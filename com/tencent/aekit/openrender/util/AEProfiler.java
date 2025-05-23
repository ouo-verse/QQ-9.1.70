package com.tencent.aekit.openrender.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AEProfiler extends AEProfilerBase {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AEProfilerInstance";
    public static final int TYPE_DETECT = 1;
    public static final int TYPE_FILTER = 2;
    public static final int TYPE_PROCESS = 0;
    private static final AEProfiler ourInstance;
    private HashMap<String, Long> detectTimeCostMap;
    private HashMap<String, Long> filterTimeCostMap;
    private boolean isEnable;
    private HashMap<String, Long> processTimeCostMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            ourInstance = new AEProfiler();
        }
    }

    public AEProfiler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isEnable = false;
        this.processTimeCostMap = new HashMap<>();
        this.filterTimeCostMap = new HashMap<>();
        this.detectTimeCostMap = new HashMap<>();
    }

    public static AEProfiler getInstance() {
        return ourInstance;
    }

    public void add(int i3, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, Long.valueOf(j3));
            return;
        }
        if (!this.isEnable) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.filterTimeCostMap.put(str, Long.valueOf(j3));
                    return;
                }
                return;
            }
            this.detectTimeCostMap.put(str, Long.valueOf(j3));
            return;
        }
        this.processTimeCostMap.put(str, Long.valueOf(j3));
    }

    public long end(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? end(str, false) : ((Long) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).longValue();
    }

    @Override // com.tencent.aekit.openrender.util.AEProfilerBase, com.tencent.aekit.openrender.util.IAEProfiler
    public long endByTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).longValue();
        }
        super.endByTag(str);
        long end = end(str);
        add(0, str, end);
        return end;
    }

    @Override // com.tencent.aekit.openrender.util.AEProfilerBase, com.tencent.aekit.openrender.util.IAEProfiler
    public String print() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (!this.isEnable) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        if (this.mOneFrameCost != 0) {
            sb5.append("\"OneFrameCost\": " + this.mOneFrameCost + ", ");
        }
        if (this.processTimeCostMap.get(IAEProfiler.TAG_DRAW_FRAME) != null) {
            sb5.append("\"DrawFrame\": " + this.processTimeCostMap.get(IAEProfiler.TAG_DRAW_FRAME) + ", ");
        }
        if (this.processTimeCostMap.get(IAEProfiler.TAG_INIT_FILTERS) != null) {
            sb5.append("\"initFilters\": " + this.processTimeCostMap.get(IAEProfiler.TAG_INIT_FILTERS) + ", ");
        }
        if (this.processTimeCostMap.get(IAEProfiler.TAG_CONFIG_FILTERS) != null) {
            sb5.append("\"configFilters\": " + this.processTimeCostMap.get(IAEProfiler.TAG_CONFIG_FILTERS) + ", ");
        }
        if (this.processTimeCostMap.get(IAEProfiler.TAG_CHAIN_FILTERS) != null) {
            sb5.append("\"chainFilters\": " + this.processTimeCostMap.get(IAEProfiler.TAG_CHAIN_FILTERS) + ", ");
        }
        if (this.processTimeCostMap.get(IAEProfiler.TAG_DETECT_FRAME) != null) {
            sb5.append("\"detectFrame\": " + this.processTimeCostMap.get(IAEProfiler.TAG_DETECT_FRAME) + ", ");
        }
        for (Map.Entry<String, Long> entry : this.filterTimeCostMap.entrySet()) {
            sb5.append("\"" + entry.getKey() + "\": " + entry.getValue() + ", ");
        }
        for (Map.Entry<String, Long> entry2 : this.detectTimeCostMap.entrySet()) {
            sb5.append("\"" + entry2.getKey() + "\": " + entry2.getValue() + ", ");
        }
        sb5.delete(sb5.length() - 2, sb5.length());
        sb5.append("}");
        LogUtils.d(TAG, sb5.toString());
        return sb5.toString();
    }

    @Override // com.tencent.aekit.openrender.util.AEProfilerBase, com.tencent.aekit.openrender.util.IAEProfiler
    public void reset() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.reset();
        if (this.processTimeCostMap.get(IAEProfiler.TAG_INIT_FILTERS) != null) {
            j3 = this.processTimeCostMap.get(IAEProfiler.TAG_INIT_FILTERS).longValue();
        } else {
            j3 = 0;
        }
        this.filterTimeCostMap.clear();
        this.detectTimeCostMap.clear();
        this.processTimeCostMap.clear();
        this.processTimeCostMap.put(IAEProfiler.TAG_INIT_FILTERS, Long.valueOf(j3));
    }

    public void setEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.isEnable = z16;
        BenchUtil.ENABLE_LOG = z16;
        this.mEnableBase = z16;
    }

    public void setEnableGLFinish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            BenchUtil.ENABLE_PERFORMANCE_RECORD = z16;
        }
    }

    public void start(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            start(str, false);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.aekit.openrender.util.AEProfilerBase, com.tencent.aekit.openrender.util.IAEProfiler
    public void startByTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            super.startByTag(str);
            start(str);
        }
    }

    public long end(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16))).longValue();
        }
        if (z16) {
            return BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + " " + str);
        }
        return BenchUtil.benchEnd(str);
    }

    public void start(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + " " + str);
            return;
        }
        BenchUtil.benchStart(str);
    }
}
