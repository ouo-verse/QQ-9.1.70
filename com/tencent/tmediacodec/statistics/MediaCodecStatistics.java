package com.tencent.tmediacodec.statistics;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaCodecStatistics {
    static IPatchRedirector $redirector_;
    private long lastTimeInMs;
    private String mCacheResultData;
    private boolean mIsReuse;
    private boolean mIsReuseHasSet;
    private boolean mIsVideo;
    private boolean mReuseEnable;
    private final Map<String, Long> mStatisticsMap;

    public MediaCodecStatistics(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.mStatisticsMap = new HashMap();
        this.mCacheResultData = "";
        this.mIsVideo = z16;
    }

    private final void setIsReuse(boolean z16) {
        this.mIsReuse = z16;
        this.mIsReuseHasSet = true;
    }

    private final void setReuseEnable(boolean z16) {
        this.mReuseEnable = z16;
    }

    public final void configCodecEnd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            setIsReuse(z16);
            this.mStatisticsMap.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.lastTimeInMs));
        }
    }

    public final void configCodecStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            setReuseEnable(z16);
            this.lastTimeInMs = System.currentTimeMillis();
        }
    }

    public final void createByCodecEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mStatisticsMap.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.lastTimeInMs));
        }
    }

    public final void createByCodecStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mCacheResultData = "";
        this.mStatisticsMap.clear();
        this.lastTimeInMs = System.currentTimeMillis();
    }

    @NonNull
    public final String getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (TextUtils.isEmpty(this.mCacheResultData)) {
            StringBuilder sb5 = new StringBuilder("{");
            sb5.append("\"isVideo\":");
            sb5.append(this.mIsVideo + " ,");
            if (this.mIsReuseHasSet) {
                sb5.append("\"isReuse\":");
                sb5.append(this.mIsReuse + " ,");
            }
            sb5.append("\"reuseEnable\":");
            sb5.append(this.mReuseEnable + " ,");
            long j3 = 0;
            for (Map.Entry<String, Long> entry : this.mStatisticsMap.entrySet()) {
                if (entry != null) {
                    j3 += entry.getValue().longValue();
                }
                sb5.append("\"" + ((Object) entry.getKey()) + "\":");
                StringBuilder sb6 = new StringBuilder();
                sb6.append(entry.getValue().longValue());
                sb6.append(" ,");
                sb5.append(sb6.toString());
            }
            sb5.append("\"totalCodec\":");
            sb5.append(j3);
            sb5.append("}");
            this.mCacheResultData = sb5.toString();
        }
        return this.mCacheResultData;
    }

    public final void startCodecEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mStatisticsMap.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.lastTimeInMs));
        }
    }

    public final void startCodecStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.lastTimeInMs = System.currentTimeMillis();
        }
    }
}
