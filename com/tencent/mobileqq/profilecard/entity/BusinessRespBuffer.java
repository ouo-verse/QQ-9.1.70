package com.tencent.mobileqq.profilecard.entity;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$comm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BusinessRespBuffer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BusinessRespBuffer";
    public byte[] buffer;
    public SummaryCardBusiEntry$comm comm;

    public BusinessRespBuffer(SummaryCardBusiEntry$comm summaryCardBusiEntry$comm, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) summaryCardBusiEntry$comm, (Object) bArr);
        } else {
            this.comm = summaryCardBusiEntry$comm;
            this.buffer = bArr;
        }
    }

    public static SparseArray<BusinessRespBuffer> parseBusinessRespBuffer(ArrayList<byte[]> arrayList) {
        int length;
        int i3;
        SparseArray<BusinessRespBuffer> sparseArray = new SparseArray<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            byte[] bArr = null;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                byte[] bArr2 = arrayList.get(i16);
                if (bArr2 == null) {
                    length = 0;
                } else {
                    length = bArr2.length;
                }
                if (length > 10) {
                    int longData = (int) PkgTools.getLongData(bArr2, 1);
                    int longData2 = (int) PkgTools.getLongData(bArr2, 5);
                    if (longData > 0 && (i3 = 9 + longData) < length) {
                        byte[] bArr3 = new byte[longData];
                        PkgTools.copyData(bArr3, 0, bArr2, 9, longData);
                        if (longData2 > 0) {
                            bArr = new byte[longData2];
                            PkgTools.copyData(bArr, 0, bArr2, i3, longData2);
                        }
                        try {
                            SummaryCardBusiEntry$comm summaryCardBusiEntry$comm = new SummaryCardBusiEntry$comm();
                            summaryCardBusiEntry$comm.mergeFrom(bArr3);
                            if (summaryCardBusiEntry$comm.result.get() == 0) {
                                sparseArray.put(summaryCardBusiEntry$comm.service.get(), new BusinessRespBuffer(summaryCardBusiEntry$comm, bArr));
                            }
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "", e16);
                        }
                    }
                }
            }
        }
        return sparseArray;
    }
}
