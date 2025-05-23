package hr2;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.studymode.urlfilter.StudyModeUrlFilterCachesInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PrivacySetting;
import com.tencent.qqnt.kernel.nativeinterface.SettingKeyForBuffer;
import com.tencent.qqnt.kernel.nativeinterface.bp;
import hr2.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J0\u0010\u000b\u001a\u00020\u00022&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0014\u001a\u00020\u0002J\u0016\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u001b\u001a\u00020\u00108\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(\u00a8\u0006,"}, d2 = {"Lhr2/d;", "", "", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForBuffer;", "", "Lkotlin/collections/HashMap;", "buffer", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "i", "j", "g", "", "url", "", "r", "k", "result", "p", "b", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "TAG", "c", "Z", "accountChangedCallbackFlag", "hr2/d$a", "d", "Lhr2/d$a;", "accountChangedCallback", "", "e", "J", "kernelSettingListenerId", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "kernelSettingListener", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean accountChangedCallbackFlag;

    /* renamed from: a, reason: collision with root package name */
    public static final d f406079a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "StudyModUrlFilterManager";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final a accountChangedCallback = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long kernelSettingListenerId = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final IKernelSettingListener kernelSettingListener = new b();

    d() {
    }

    private final void f() {
        AppRuntime peekAppRuntime;
        if (accountChangedCallbackFlag || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e(TAG, 1, "[RunTime] failed");
        } else {
            MobileQQ.sMobileQQ.registerAccountCallback(accountChangedCallback);
            accountChangedCallbackFlag = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        IKernelSettingService i3 = i();
        if (i3 == null) {
            QLog.d(TAG, 1, "kernelSettingService unregister, settingService is null");
            return;
        }
        i3.removeKernelSettingListener(kernelSettingListenerId);
        kernelSettingListenerId = 0L;
        QLog.d(TAG, 1, "kernelSettingService unregister sucess");
    }

    private final IKernelSettingService i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IKernelService iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "");
        IKernelSettingService settingService = iKernelService != null ? iKernelService.getSettingService() : null;
        if (settingService != null) {
            return settingService;
        }
        QLog.d(TAG, 1, "kernelSettingService register, settingService is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        IKernelSettingService i3 = i();
        if (i3 == null) {
            QLog.d(TAG, 1, "kernelSettingService register, settingService is null");
        } else {
            kernelSettingListenerId = i3.addKernelSettingListener(kernelSettingListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        IKernelSettingService i3 = i();
        if (i3 == null) {
            QLog.d(TAG, 1, " settingService is null");
            return;
        }
        ArrayList<SettingKeyForBuffer> arrayList = new ArrayList<>();
        arrayList.add(SettingKeyForBuffer.KTEENAGELINKBLOCKING);
        i3.getSettingForBuffer(arrayList, new IOperateCallback() { // from class: hr2.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                d.m(i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i3, String str) {
        QLog.d(TAG, 1, " urlfilter settingService request ", "result=" + i3, "errMsg=" + str);
    }

    private final void n(HashMap<SettingKeyForBuffer, byte[]> buffer) {
        IKernelSettingService i3 = i();
        if (i3 == null) {
            QLog.d(TAG, 1, " settingService is null");
        } else {
            i3.setSettingForBuffer(buffer, new IOperateCallback() { // from class: hr2.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    d.o(i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(int i3, String str) {
        QLog.d(TAG, 1, " urlfilter settingService save ", "result=" + i3, "errMsg=" + str);
    }

    private final void q() {
        g gVar = g.f406087a;
        if (gVar.b()) {
            ByteBuffer f16 = gVar.f();
            if (f16 != null) {
                HashMap<SettingKeyForBuffer, byte[]> hashMap = new HashMap<>();
                SettingKeyForBuffer settingKeyForBuffer = SettingKeyForBuffer.KTEENAGELINKBLOCKING;
                byte[] array = f16.array();
                Intrinsics.checkNotNullExpressionValue(array, "data.array()");
                hashMap.put(settingKeyForBuffer, array);
                n(hashMap);
            }
            gVar.e(false);
        }
    }

    public final String h() {
        return TAG;
    }

    public final void k() {
        if (StudyModeManager.S().booleanValue()) {
            j();
            if (!accountChangedCallbackFlag) {
                g.f406087a.a();
                l();
            }
            f();
        }
    }

    public final void p(String result, String url) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH);
        intent.putExtra(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT, result);
        intent.putExtra(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH_URL, url);
        if (result.equals(IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_SUC)) {
            g gVar = g.f406087a;
            gVar.h(url);
            q();
            StudyModeUrlFilterCachesInfo i3 = gVar.i(url);
            if (i3 != null) {
                intent.putExtra(IStudyModeManager.STUDY_MODE_ULR_FILTER_RESULT_TIME, i3.getInvalidTime());
            }
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"hr2/d$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingListener;", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/SettingKeyForBuffer;", "", "setting", "", "onBufferSettingChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IKernelSettingListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(byte[] bArr) {
            final Map<String, StudyModeUrlFilterCachesInfo> g16 = g.f406087a.g(bArr);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: hr2.f
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.d(g16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Map keyValueMap) {
            Intrinsics.checkNotNullParameter(keyValueMap, "$keyValueMap");
            for (Map.Entry entry : keyValueMap.entrySet()) {
                StudyModeUrlFilterCachesInfo studyModeUrlFilterCachesInfo = (StudyModeUrlFilterCachesInfo) entry.getValue();
                if (studyModeUrlFilterCachesInfo.f()) {
                    g.f406087a.d(studyModeUrlFilterCachesInfo);
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onCleanCacheProgressChanged(int i3, int i16) {
            bp.b(this, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onNumSettingChanged(HashMap hashMap) {
            bp.c(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onPrivacySettingChanged(PrivacySetting privacySetting) {
            bp.d(this, privacySetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onStrSettingChanged(HashMap hashMap) {
            bp.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public /* synthetic */ void onVerifyInfoChange(int i3) {
            bp.f(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSettingListener
        public void onBufferSettingChanged(HashMap<SettingKeyForBuffer, byte[]> setting) {
            if (setting != null && setting.containsKey(SettingKeyForBuffer.KTEENAGELINKBLOCKING)) {
                final byte[] bArr = setting != null ? setting.get(SettingKeyForBuffer.KTEENAGELINKBLOCKING) : null;
                String h16 = d.f406079a.h();
                Object[] objArr = new Object[2];
                objArr[0] = " urlfilter bufferChanger is ";
                objArr[1] = "count=" + (bArr != null ? Integer.valueOf(bArr.length) : null);
                QLog.d(h16, 1, objArr);
                if (bArr != null) {
                    if (!(bArr.length == 0)) {
                        ThreadManagerV2.excute(new Runnable() { // from class: hr2.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.b.c(bArr);
                            }
                        }, 128, null, true);
                    }
                }
            }
        }
    }

    public final boolean r(String url) {
        StudyModeUrlFilterCachesInfo i3;
        if (url == null || (i3 = g.f406087a.i(url)) == null) {
            return false;
        }
        return i3.f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"hr2/d$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            Boolean S = StudyModeManager.S();
            Intrinsics.checkNotNullExpressionValue(S, "studyMode9165Switch()");
            if (S.booleanValue()) {
                g.f406087a.a();
                d dVar = d.f406079a;
                dVar.g();
                dVar.j();
                dVar.l();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
            Boolean S = StudyModeManager.S();
            Intrinsics.checkNotNullExpressionValue(S, "studyMode9165Switch()");
            if (S.booleanValue()) {
                g.f406087a.a();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }
    }
}
