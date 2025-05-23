package com.tencent.mobileqq.highway.transaction;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CacheIpInfo {
    static IPatchRedirector $redirector_;
    private int cache_addr_port;
    private int cache_addr_res;

    /* renamed from: ip, reason: collision with root package name */
    private String f236839ip;

    public CacheIpInfo(HwResponse hwResponse, HwRequest hwRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hwResponse, (Object) hwRequest);
            return;
        }
        if (hwResponse.segmentResp.uint32_cache_addr.has()) {
            int i3 = hwResponse.segmentResp.uint32_cache_addr.get();
            int i16 = hwResponse.segmentResp.uint32_cache_port.get();
            String str = HwRequest.intToIP(i3) + ":" + i16;
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "RequestUpload HandleResp : cache_addr res from server is : ( " + str + " ) Seq:" + hwRequest.getHwSeq());
            this.cache_addr_res = i3;
            this.cache_addr_port = i16;
            this.f236839ip = str;
        }
    }

    public void checkCacheIp(HwResponse hwResponse, HwRequest hwRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hwResponse, (Object) hwRequest);
            return;
        }
        if (hwResponse.segmentResp.uint32_update_cacheip.has() && hwResponse.segmentResp.uint32_update_cacheip.get() == 1) {
            synchronized (this) {
                int i3 = hwResponse.segmentResp.uint32_cache_addr.get();
                int i16 = hwResponse.segmentResp.uint32_cache_port.get();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, hwRequest.getClass().getSimpleName() + " HandleResp : cache ip Diff !" + i3 + " ( " + HwRequest.intToIP(i3) + ":" + i16 + " ) Seq:" + hwRequest.getHwSeq());
                this.cache_addr_res = i3;
                this.cache_addr_port = i16;
            }
        }
    }

    public void writeHeadCacheIp(CSDataHighwayHead.SegHead segHead, HwRequest hwRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) segHead, (Object) hwRequest);
            return;
        }
        int i3 = this.cache_addr_res;
        if (i3 != 0 && this.cache_addr_port != 0) {
            segHead.uint32_cache_addr.set(i3);
            segHead.uint32_cache_port.set(this.cache_addr_port);
        }
    }
}
