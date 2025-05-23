package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IpLearningImpl implements IpLearning {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_SUCC_FAIL_COUNT = -1;
    public static final boolean IS_DEBUG = true;
    public static int sEnableIpLearning;
    public static int sMaxFailCount;
    public static long sTimeToLiveMills;
    private ConcurrentHashMap<String, IpConnInfo> mIpConnInfos;
    private String mSuccIpInfo_Key;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class IpListCompartor implements Comparator<EndPoint> {
        static IPatchRedirector $redirector_;

        IpListCompartor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(EndPoint endPoint, EndPoint endPoint2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) endPoint, (Object) endPoint2)).intValue();
            }
            boolean z16 = endPoint.isSameIsp;
            if (z16 && !endPoint2.isSameIsp) {
                return -1;
            }
            if (z16 || !endPoint2.isSameIsp) {
                return endPoint.failCount - endPoint2.failCount;
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        sEnableIpLearning = 0;
        sMaxFailCount = 3;
        sTimeToLiveMills = 600000L;
    }

    public IpLearningImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSuccIpInfo_Key = null;
            this.mIpConnInfos = new ConcurrentHashMap<>();
        }
    }

    private String dumpIpLearningInfos() {
        String str;
        StringBuilder sb5 = new StringBuilder("_IpLearning_\n");
        sb5.append("mSuccIpInfo_Key");
        sb5.append(this.mSuccIpInfo_Key);
        sb5.append("\n");
        for (String str2 : this.mIpConnInfos.keySet()) {
            IpConnInfo ipConnInfo = this.mIpConnInfos.get(str2);
            sb5.append("Host:");
            sb5.append(str2);
            sb5.append(" Info:");
            if (ipConnInfo != null) {
                str = ipConnInfo.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, sb5.toString());
        return sb5.toString();
    }

    private static String dumpIpList(ArrayList<EndPoint> arrayList, String str) {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, str + Arrays.toString(arrayList.toArray()));
        return "IS NOT DEBUG";
    }

    @Override // com.tencent.mobileqq.highway.iplearning.IpLearning
    public ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
        }
        ArrayList<EndPoint> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null && !arrayList.isEmpty()) {
            dumpIpLearningInfos();
            String str = this.mSuccIpInfo_Key;
            Iterator<EndPoint> it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                EndPoint next = it.next();
                IpConnInfo ipConnInfo = this.mIpConnInfos.get(next.host);
                if (ipConnInfo == null) {
                    next.failCount = 0;
                } else if (ipConnInfo.isConnSucc) {
                    if (str != null && next.host.equalsIgnoreCase(str)) {
                        if (SystemClock.uptimeMillis() - ipConnInfo.lLastSuccTimeMills > sTimeToLiveMills) {
                            this.mIpConnInfos.remove(str);
                            this.mSuccIpInfo_Key = null;
                        } else {
                            next.failCount = -1;
                        }
                        z16 = true;
                    } else {
                        this.mIpConnInfos.remove(ipConnInfo.mHost);
                        this.mSuccIpInfo_Key = null;
                    }
                } else {
                    int i3 = ipConnInfo.iFailCount;
                    if (i3 > sMaxFailCount) {
                        arrayList3.add(next);
                    } else {
                        next.failCount = i3;
                    }
                }
            }
            if (str != null && !z16) {
                IpConnInfo ipConnInfo2 = this.mIpConnInfos.get(str);
                if (ipConnInfo2 != null) {
                    EndPoint endPoint = new EndPoint(ipConnInfo2.mHost, ipConnInfo2.mPort, ipConnInfo2.isSameIsp);
                    endPoint.failCount = -1;
                    endPoint.timestamp = System.currentTimeMillis();
                    arrayList2.add(endPoint);
                } else {
                    this.mSuccIpInfo_Key = null;
                }
            }
            dumpIpList(arrayList, " DUMP_IPLIST_IN ");
            arrayList2.addAll(arrayList);
            if (this.mIpConnInfos.isEmpty()) {
                dumpIpList(arrayList2, " DUMP_IPLIST_OUT ");
                return arrayList2;
            }
            arrayList2.removeAll(arrayList3);
            Collections.sort(arrayList2, new IpListCompartor());
            dumpIpList(arrayList2, " DUMP_IPLIST_OUT ");
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.highway.iplearning.IpLearning
    public void onIpConnFail(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
            return;
        }
        if (str == null) {
            return;
        }
        String str2 = this.mSuccIpInfo_Key;
        if (str2 != null && str2.equalsIgnoreCase(str)) {
            this.mSuccIpInfo_Key = null;
        }
        IpConnInfo ipConnInfo = new IpConnInfo(str, i3, false, false, SystemClock.uptimeMillis());
        IpConnInfo putIfAbsent = this.mIpConnInfos.putIfAbsent(str, ipConnInfo);
        if (putIfAbsent != null) {
            putIfAbsent.markAsFailOnceMore();
        } else {
            ipConnInfo.markAsFailOnceMore();
        }
        dumpIpLearningInfos();
    }

    @Override // com.tencent.mobileqq.highway.iplearning.IpLearning
    public void onIpConnSucc(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (str == null) {
            return;
        }
        IpConnInfo putIfAbsent = this.mIpConnInfos.putIfAbsent(str, new IpConnInfo(str, i3, true, z16, SystemClock.uptimeMillis()));
        if (putIfAbsent != null) {
            putIfAbsent.markAsSucc();
        }
        this.mSuccIpInfo_Key = str;
        dumpIpLearningInfos();
    }

    @Override // com.tencent.mobileqq.highway.iplearning.IpLearning
    public void onRecvClearCMD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mSuccIpInfo_Key = null;
            this.mIpConnInfos.clear();
        }
    }
}
