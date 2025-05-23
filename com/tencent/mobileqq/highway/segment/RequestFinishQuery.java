package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestFinishQuery extends RequestInfoQuery {
    static IPatchRedirector $redirector_ = null;
    public static final int COMMON_QUERY = -1;
    public static int QUERY_HOLE_INTERVAL = 0;
    public static final int QUERY_HOLE_INTERVAL_DEFAULT = 5000;
    public static int QUERY_HOLE_MAX_COUNT = 0;
    public static final int QUERY_HOLE_MAX_COUNT_DEFAULT = 3;
    public int mQueryHoleFinishIndex;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            QUERY_HOLE_MAX_COUNT = 3;
            QUERY_HOLE_INTERVAL = 5000;
        }
    }

    public RequestFinishQuery(String str, String str2, int i3, byte[] bArr, Transaction transaction, long j3, byte[] bArr2) {
        super(str, str2, i3, bArr, transaction, j3, bArr2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), bArr, transaction, Long.valueOf(j3), bArr2);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.RequestInfoQuery, com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.SegHead getSegmentHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CSDataHighwayHead.SegHead) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        CSDataHighwayHead.SegHead segmentHead = super.getSegmentHead();
        int i3 = this.mQueryHoleFinishIndex;
        if (i3 != -1) {
            segmentHead.uint32_query_times.set(i3 + 1);
        }
        return segmentHead;
    }
}
