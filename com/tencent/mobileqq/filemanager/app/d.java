package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i3, boolean z16, Object obj) {
        if (obj != null && !(obj instanceof String)) {
            Object[] objArr = (Object[]) obj;
            if (QLog.isColorLevel()) {
                QLog.d("FileTransferObserver<FileAssistant>", 2, "onUpdate : type[" + i3 + "], isSuccess[" + z16 + "]");
            }
            switch (i3) {
                case 5004:
                    k(z16, (f) objArr[0], (StatictisInfo) objArr[1], (List) objArr[2]);
                    return;
                case 5005:
                    l(z16, (f) objArr[0], (StatictisInfo) objArr[1]);
                    return;
                case 5006:
                    j(z16, ((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2], (ByteStringMicro) objArr[3], ((Boolean) objArr[4]).booleanValue(), (String) objArr[5], ((Short) objArr[6]).shortValue(), (String) objArr[7], (List) objArr[8], ((Integer) objArr[9]).intValue(), (String) objArr[10], (String) objArr[11], (String) objArr[12], ((Long) objArr[13]).longValue(), (Bundle) objArr[14]);
                    return;
                case 5007:
                    b(z16, (f) objArr[0], (StatictisInfo) objArr[1]);
                    break;
                default:
                    switch (i3) {
                        case 5013:
                            a(z16, ((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue(), (String) objArr[5], (String) objArr[6], ((Integer) objArr[7]).intValue(), ((Long) objArr[8]).longValue(), (Bundle) objArr[9]);
                            break;
                        case 5014:
                            f(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), ((Long) objArr[3]).longValue(), ((Integer) objArr[2]).intValue(), ((Long) objArr[4]).longValue());
                            break;
                        case 5015:
                            Long l3 = (Long) objArr[0];
                            h(z16, l3.longValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], ((Integer) objArr[5]).intValue(), (String) objArr[6], (String) objArr[7], (Bundle) objArr[8]);
                            break;
                        case 5016:
                            g(z16, (Long) objArr[0]);
                            break;
                        default:
                            switch (i3) {
                                case 5020:
                                    e(z16, (f) objArr[0], (StatictisInfo) objArr[1], (List) objArr[2]);
                                    break;
                                case 5021:
                                    c(z16, ((Boolean) objArr[0]).booleanValue(), (List) objArr[1]);
                                    break;
                                case 5022:
                                    d(z16, ((Boolean) objArr[0]).booleanValue(), (List) objArr[1]);
                                    break;
                                default:
                                    QLog.e("FileTransferObserver<FileAssistant>", 1, "onUpdate : Can Not process type" + i3);
                                    break;
                            }
                    }
            }
        }
    }

    protected void g(boolean z16, Long l3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z16, f fVar, StatictisInfo statictisInfo) {
    }

    protected void c(boolean z16, boolean z17, List<OfflineFileInfo> list) {
    }

    protected void d(boolean z16, boolean z17, List<OfflineFileInfo> list) {
    }

    protected void l(boolean z16, f fVar, StatictisInfo statictisInfo) {
    }

    protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
    }

    protected void e(boolean z16, f fVar, StatictisInfo statictisInfo, List<String> list) {
    }

    protected void k(boolean z16, f fVar, StatictisInfo statictisInfo, List<String> list) {
    }

    protected void f(boolean z16, long j3, long j16, int i3, long j17) {
    }

    protected void h(boolean z16, long j3, String str, String str2, String str3, String str4, int i3, String str5, String str6, Bundle bundle) {
    }

    protected void a(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, String str5, int i16, long j16, Bundle bundle) {
    }
}
