package com.tencent.mobileqq.nt.msgpush;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nt.msgpush.factory.e;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$BusinessData;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$BusinessDataList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/b;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$BusinessData;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "", "e", "", "a", "", "cmd", "", "pbBuffer", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b implements com.tencent.qqnt.kernel.frequencycontrol.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f254421a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f254421a = new a(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(FrequencyControlField$BusinessData businessData) {
        boolean z16;
        FrequencyControlField$BusinessData frequencyControlField$BusinessData;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        byte[] byteArray;
        e b16;
        if (businessData != null) {
            if (businessData.has() && businessData.type.has() && businessData.data.has()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                frequencyControlField$BusinessData = businessData;
            } else {
                frequencyControlField$BusinessData = null;
            }
            if (frequencyControlField$BusinessData != null && (pBBytesField = frequencyControlField$BusinessData.data) != null && (byteStringMicro = pBBytesField.get()) != null && (byteArray = byteStringMicro.toByteArray()) != null && (b16 = com.tencent.mobileqq.nt.msgpush.factory.b.f254424a.b(businessData.type.get())) != null) {
                b16.b(byteArray);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(List it, b this$0) {
        FrequencyControlField$BusinessData frequencyControlField$BusinessData;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            FrequencyControlField$BusinessData frequencyControlField$BusinessData2 = (FrequencyControlField$BusinessData) it5.next();
            if (frequencyControlField$BusinessData2 != null) {
                frequencyControlField$BusinessData = frequencyControlField$BusinessData2.get();
            } else {
                frequencyControlField$BusinessData = null;
            }
            this$0.e(frequencyControlField$BusinessData);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{221011};
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        final List<FrequencyControlField$BusinessData> list;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, cmd, (Object) pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (cmd != 221011) {
            return;
        }
        FrequencyControlField$BusinessDataList frequencyControlField$BusinessDataList = new FrequencyControlField$BusinessDataList();
        try {
            frequencyControlField$BusinessDataList.mergeFrom(pbBuffer);
        } catch (Exception e16) {
            QLog.e("MsgPushBusinessDataDispatcherCallback", 1, "onDispatchCall error! exception = " + e16.getMessage());
        }
        PBRepeatMessageField<FrequencyControlField$BusinessData> pBRepeatMessageField = frequencyControlField$BusinessDataList.businessDataList;
        if (pBRepeatMessageField != null) {
            boolean z17 = false;
            if (pBRepeatMessageField.has()) {
                List<FrequencyControlField$BusinessData> list2 = pBRepeatMessageField.get();
                if (list2 != null) {
                    Intrinsics.checkNotNullExpressionValue(list2, "get()");
                    if (!list2.isEmpty()) {
                        z16 = true;
                        if (z16) {
                            z17 = true;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            if (!z17) {
                pBRepeatMessageField = null;
            }
            if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nt.msgpush.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.f(list, this);
                    }
                }, 16, null, true);
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
        } else {
            Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        }
    }
}
