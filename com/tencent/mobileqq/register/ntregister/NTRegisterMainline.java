package com.tencent.mobileqq.register.ntregister;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gateway.localphone.ecdh.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.loginregister.sms.RegisterVerifyResult;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.mobileqq.register.fragment.RegisterFailedFragment;
import com.tencent.mobileqq.register.fragment.RegisterNickAndPwdFragment;
import com.tencent.mobileqq.register.q;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.util.ce;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.CheckLimitHandleResultReq;
import com.tencent.qqnt.kernel.nativeinterface.FaceResult;
import com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback;
import com.tencent.qqnt.kernel.nativeinterface.Iframe;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityLimit;
import com.tencent.qqnt.kernel.nativeinterface.RegisterIdentityRsp;
import com.tencent.qqnt.kernel.nativeinterface.SubmitIdentityInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.UserInfo;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$EncryptPhoneData;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b?\u0010@J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ-\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014J-\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J-\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0014J-\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0014J-\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0014J-\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0014J\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b2\u0006\u0010$\u001a\u00020#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0002J$\u0010-\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0002J\b\u0010.\u001a\u00020\nH\u0002J\u001a\u00101\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u00102\u001a\u00020\nH\u0002J\b\u00103\u001a\u00020\nH\u0002R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/register/ntregister/NTRegisterMainline;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/register/bean/a;", "phoneNumInfo", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "Lcom/tencent/mobileqq/loginregister/callback/b;", "registerCallback", "", "G", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/SubmitIdentityInfoReq;", "registerReq", "O", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/register/bean/WechatInfo;Lcom/tencent/qqnt/kernel/nativeinterface/SubmitIdentityInfoReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;", "registerRsp", "I", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/register/bean/WechatInfo;Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", HippyTKDListViewAdapter.X, "u", "v", "y", "w", "Lcom/tencent/mobileqq/register/ntregister/a;", "", "N", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "code", "H", "K", "(Lcom/tencent/qqnt/kernel/nativeinterface/SubmitIdentityInfoReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckLimitHandleResultReq;", "req", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/qqnt/kernel/nativeinterface/CheckLimitHandleResultReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/Bundle;", "data", ReportConstant.COSTREPORT_PREFIX, "context", "", "registerContext", "E", "B", "", "errMsg", BdhLogUtil.LogTag.Tag_Conn, "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "Lcom/tencent/mobileqq/loginregister/callback/b;", "mRegisterCallback", "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "b", "Lmqq/util/WeakReference;", "mLoadingRef", "c", "Lcom/tencent/mobileqq/register/bean/a;", "mPhoneNumInfo", "<init>", "()V", "d", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class NTRegisterMainline {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.loginregister.callback.b mRegisterCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Dialog> mLoadingRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.register.bean.a mPhoneNumInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/register/ntregister/NTRegisterMainline$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.ntregister.NTRegisterMainline$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "ret", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class b implements IRegisterIdentityCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<a<RegisterIdentityRsp>> f280481a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super a<RegisterIdentityRsp>> cancellableContinuation) {
            this.f280481a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback
        public final void onResult(int i3, String str, RegisterIdentityRsp registerIdentityRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, registerIdentityRsp);
                return;
            }
            QLog.d("NTRegisterMainline", 1, "commitSafetyVerifyResult result: " + i3 + ", business code: " + registerIdentityRsp.retCode + ", errMsg: " + str);
            if (i3 == 0) {
                CancellableContinuation<a<RegisterIdentityRsp>> cancellableContinuation = this.f280481a;
                a aVar = new a(registerIdentityRsp.retCode, str, registerIdentityRsp);
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                    return;
                }
                QLog.e("NTLogin", 1, "request successsafeResume call failed ");
                return;
            }
            CancellableContinuation<a<RegisterIdentityRsp>> cancellableContinuation2 = this.f280481a;
            a aVar2 = new a(i3, str, registerIdentityRsp);
            if (cancellableContinuation2.isActive()) {
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(aVar2));
                return;
            }
            QLog.e("NTLogin", 1, "request failedsafeResume call failed ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "ret", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterIdentityRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class c implements IRegisterIdentityCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubmitIdentityInfoReq f280482a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<a<RegisterIdentityRsp>> f280483b;

        /* JADX WARN: Multi-variable type inference failed */
        c(SubmitIdentityInfoReq submitIdentityInfoReq, CancellableContinuation<? super a<RegisterIdentityRsp>> cancellableContinuation) {
            this.f280482a = submitIdentityInfoReq;
            this.f280483b = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) submitIdentityInfoReq, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IRegisterIdentityCallback
        public final void onResult(int i3, String str, RegisterIdentityRsp registerIdentityRsp) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, registerIdentityRsp);
                return;
            }
            int i16 = this.f280482a.type;
            if (registerIdentityRsp != null) {
                num = Integer.valueOf(registerIdentityRsp.retCode);
            } else {
                num = null;
            }
            QLog.d("NTRegisterMainline", 1, "requestNTRegister type: " + i16 + ", result: " + i3 + ", business code: " + num);
            if (i3 == 0 && registerIdentityRsp != null) {
                CancellableContinuation<a<RegisterIdentityRsp>> cancellableContinuation = this.f280483b;
                a aVar = new a(i3, str, registerIdentityRsp);
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                    return;
                }
                QLog.e("NTLogin", 1, "request successsafeResume call failed ");
                return;
            }
            CancellableContinuation<a<RegisterIdentityRsp>> cancellableContinuation2 = this.f280483b;
            a aVar2 = new a(i3, str, registerIdentityRsp);
            if (cancellableContinuation2.isActive()) {
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(aVar2));
                return;
            }
            QLog.e("NTLogin", 1, "request failedsafeResume call failed ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/register/ntregister/NTRegisterMainline$d", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements ne1.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<a<String>> f280485b;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super a<String>> cancellableContinuation) {
            this.f280485b = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTRegisterMainline.this, (Object) cancellableContinuation);
            }
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            NTRegisterMainline.this.z();
            GetLocalPhone$EncryptPhoneData getLocalPhone$EncryptPhoneData = data.msg_encrypt_phone_data.get();
            cb.d("0X800C1FA");
            if (getLocalPhone$EncryptPhoneData == null) {
                QLog.e("NTRegisterMainline", 1, "getPhoneNumSuccess, phoneData is null");
                CancellableContinuation<a<String>> cancellableContinuation = this.f280485b;
                a aVar = new a(-1, "phone data is null", null);
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                    return;
                }
                QLog.e("NTLogin", 1, "phone data is nullsafeResume call failed ");
                return;
            }
            QLog.i("NTRegisterMainline", 1, "getPhoneNumSuccess success");
            String str = getLocalPhone$EncryptPhoneData.str_encypt_phone.get();
            CancellableContinuation<a<String>> cancellableContinuation2 = this.f280485b;
            a aVar2 = new a(10000, "get phone token success", str);
            if (cancellableContinuation2.isActive()) {
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(aVar2));
            } else {
                QLog.e("NTLogin", 1, "safeResume call failed ");
            }
            cb.f("0X800C3AC", "0X800C3AB", 0, "");
        }

        @Override // ne1.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            QLog.e("NTRegisterMainline", 1, "getPhoneTokenWithMaskPhone onException : " + errorMsg);
            NTRegisterMainline.this.z();
            CancellableContinuation<a<String>> cancellableContinuation = this.f280485b;
            a aVar = new a(-1, "get phone token failed", null);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(aVar));
                return;
            }
            QLog.e("NTLogin", 1, "get phone token failedsafeResume call failed ");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26948);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTRegisterMainline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(NTRegisterMainline this$0) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<Dialog> weakReference = this$0.mLoadingRef;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void B() {
        QLog.d("NTRegisterMainline", 1, "onRegisterCancel");
        com.tencent.mobileqq.loginregister.callback.b bVar = this.mRegisterCallback;
        if (bVar != null) {
            bVar.a(RegisterResult.RegisterCancel);
        }
    }

    private final void C(int code, final String errMsg) {
        QLog.e("NTRegisterMainline", 1, "onRegisterFailed code: " + code + ", errMsg: " + errMsg);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.ntregister.b
            @Override // java.lang.Runnable
            public final void run() {
                NTRegisterMainline.D(errMsg);
            }
        });
        com.tencent.mobileqq.loginregister.callback.b bVar = this.mRegisterCallback;
        if (bVar != null) {
            bVar.a(RegisterResult.RegisterFailed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(String str) {
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.g0j);
        }
        ce.l(str, 1);
    }

    private final void E(final QBaseActivity context, final WechatInfo wechatInfo, final byte[] registerContext) {
        if (registerContext != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.ntregister.d
                @Override // java.lang.Runnable
                public final void run() {
                    NTRegisterMainline.F(QBaseActivity.this, wechatInfo, registerContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QBaseActivity context, WechatInfo wechatInfo, byte[] it) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(it, "$it");
        RegisterNickAndPwdFragment.INSTANCE.b(context, wechatInfo, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String code) {
        com.tencent.mobileqq.loginregister.callback.b bVar = this.mRegisterCallback;
        if (bVar != null) {
            bVar.a(RegisterResult.RegisterGatewayFailed);
        }
        ce.k(R.string.f2036350q, 1);
        cb.f("0X800C3AC", "0X800C3AB", 1, code);
    }

    private final Object I(final QBaseActivity qBaseActivity, WechatInfo wechatInfo, final RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        Object coroutine_suspended4;
        Object coroutine_suspended5;
        Object coroutine_suspended6;
        QLog.d("NTRegisterMainline", 1, "registerSafetyVerify type: " + registerIdentityRsp.limit.type);
        switch (registerIdentityRsp.limit.type) {
            case 1:
                Object t16 = t(qBaseActivity, wechatInfo, registerIdentityRsp, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (t16 == coroutine_suspended) {
                    return t16;
                }
                return Unit.INSTANCE;
            case 2:
                Object x16 = x(qBaseActivity, wechatInfo, registerIdentityRsp, continuation);
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (x16 == coroutine_suspended2) {
                    return x16;
                }
                return Unit.INSTANCE;
            case 3:
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.ntregister.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        NTRegisterMainline.J(RegisterIdentityRsp.this, this, qBaseActivity);
                    }
                });
                break;
            case 4:
                Object u16 = u(qBaseActivity, wechatInfo, registerIdentityRsp, continuation);
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (u16 == coroutine_suspended3) {
                    return u16;
                }
                return Unit.INSTANCE;
            case 5:
                Object v3 = v(qBaseActivity, wechatInfo, registerIdentityRsp, continuation);
                coroutine_suspended4 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (v3 == coroutine_suspended4) {
                    return v3;
                }
                return Unit.INSTANCE;
            case 6:
                Object y16 = y(qBaseActivity, wechatInfo, registerIdentityRsp, continuation);
                coroutine_suspended5 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (y16 == coroutine_suspended5) {
                    return y16;
                }
                return Unit.INSTANCE;
            case 7:
                Object w3 = w(qBaseActivity, wechatInfo, registerIdentityRsp, continuation);
                coroutine_suspended6 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (w3 == coroutine_suspended6) {
                    return w3;
                }
                return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(RegisterIdentityRsp registerRsp, NTRegisterMainline this$0, QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(registerRsp, "$registerRsp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Bundle bundle = new Bundle();
        bundle.putInt("key_verify_code", registerRsp.retCode);
        this$0.s(activity, bundle);
    }

    private final Object K(SubmitIdentityInfoReq submitIdentityInfoReq, Continuation<? super a<RegisterIdentityRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((ILoginService) QRoute.api(ILoginService.class)).submitIdentityInfo(submitIdentityInfoReq, new c(submitIdentityInfoReq, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.ntregister.c
            @Override // java.lang.Runnable
            public final void run() {
                NTRegisterMainline.M(NTRegisterMainline.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(NTRegisterMainline this$0) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (ce.d(qBaseActivity)) {
            return;
        }
        WeakReference<Dialog> weakReference = this$0.mLoadingRef;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog == null) {
            dialog = LoadingUtil.showLoadingDialog(qBaseActivity, HardCodeUtil.qqStr(R.string.f211365km), false);
            this$0.mLoadingRef = new WeakReference<>(dialog);
        }
        if (dialog != null) {
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(Continuation<? super a<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        L();
        g.n(3, 2, new d(cancellableContinuationImpl), null, 8, null);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object O(QBaseActivity qBaseActivity, WechatInfo wechatInfo, SubmitIdentityInfoReq submitIdentityInfoReq, Continuation<? super Unit> continuation) {
        NTRegisterMainline$startNTRegister$1 nTRegisterMainline$startNTRegister$1;
        Object coroutine_suspended;
        int i3;
        NTRegisterMainline nTRegisterMainline;
        a aVar;
        if (continuation instanceof NTRegisterMainline$startNTRegister$1) {
            nTRegisterMainline$startNTRegister$1 = (NTRegisterMainline$startNTRegister$1) continuation;
            int i16 = nTRegisterMainline$startNTRegister$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$startNTRegister$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTRegisterMainline$startNTRegister$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$startNTRegister$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wechatInfo = (WechatInfo) nTRegisterMainline$startNTRegister$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$startNTRegister$1.L$1;
                    nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$startNTRegister$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("NTRegisterMainline", 1, "startNTRegister");
                    nTRegisterMainline$startNTRegister$1.L$0 = this;
                    nTRegisterMainline$startNTRegister$1.L$1 = qBaseActivity;
                    nTRegisterMainline$startNTRegister$1.L$2 = wechatInfo;
                    nTRegisterMainline$startNTRegister$1.label = 1;
                    obj = K(submitIdentityInfoReq, nTRegisterMainline$startNTRegister$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline = this;
                }
                aVar = (a) obj;
                if (aVar.c() != 0 && aVar.b() != null) {
                    int i17 = ((RegisterIdentityRsp) aVar.b()).retCode;
                    if (i17 == 10000) {
                        nTRegisterMainline.E(qBaseActivity, wechatInfo, ((RegisterIdentityRsp) aVar.b()).context);
                        return Unit.INSTANCE;
                    }
                    if (i17 == 10001) {
                        RegisterIdentityRsp registerIdentityRsp = (RegisterIdentityRsp) aVar.b();
                        nTRegisterMainline$startNTRegister$1.L$0 = null;
                        nTRegisterMainline$startNTRegister$1.L$1 = null;
                        nTRegisterMainline$startNTRegister$1.L$2 = null;
                        nTRegisterMainline$startNTRegister$1.label = 2;
                        if (nTRegisterMainline.I(qBaseActivity, wechatInfo, registerIdentityRsp, nTRegisterMainline$startNTRegister$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    nTRegisterMainline.C(((RegisterIdentityRsp) aVar.b()).retCode, aVar.a());
                    return Unit.INSTANCE;
                }
                QLog.e("NTRegisterMainline", 1, "requestNTRegister failed");
                nTRegisterMainline.C(aVar.c(), aVar.a());
                return Unit.INSTANCE;
            }
        }
        nTRegisterMainline$startNTRegister$1 = new NTRegisterMainline$startNTRegister$1(this, continuation);
        Object obj2 = nTRegisterMainline$startNTRegister$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$startNTRegister$1.label;
        if (i3 == 0) {
        }
        aVar = (a) obj2;
        if (aVar.c() != 0) {
        }
        QLog.e("NTRegisterMainline", 1, "requestNTRegister failed");
        nTRegisterMainline.C(aVar.c(), aVar.a());
        return Unit.INSTANCE;
    }

    private final Object q(CheckLimitHandleResultReq checkLimitHandleResultReq, Continuation<? super a<RegisterIdentityRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((ILoginService) QRoute.api(ILoginService.class)).checkLimitHandleResult(checkLimitHandleResultReq, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void s(QBaseActivity activity, Bundle data) {
        QLog.i("NTRegisterMainline", 1, "gotoReject");
        if (ce.d(activity)) {
            return;
        }
        Intent intent = new Intent();
        if (data != null) {
            intent.putExtras(data);
        }
        LoginPublicFragmentActivity.INSTANCE.a(activity, intent, RegisterFailedFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(QBaseActivity qBaseActivity, WechatInfo wechatInfo, RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        NTRegisterMainline$handleDownSms$1 nTRegisterMainline$handleDownSms$1;
        Object coroutine_suspended;
        int i3;
        String str;
        String str2;
        Object obj;
        RegisterIdentityRsp registerIdentityRsp2;
        WechatInfo wechatInfo2;
        NTRegisterMainline nTRegisterMainline;
        a aVar;
        a aVar2;
        if (continuation instanceof NTRegisterMainline$handleDownSms$1) {
            nTRegisterMainline$handleDownSms$1 = (NTRegisterMainline$handleDownSms$1) continuation;
            int i16 = nTRegisterMainline$handleDownSms$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$handleDownSms$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = nTRegisterMainline$handleDownSms$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$handleDownSms$1.label;
                byte[] bArr = null;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            aVar2 = (a) nTRegisterMainline$handleDownSms$1.L$1;
                            nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$handleDownSms$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            aVar = aVar2;
                            if (aVar.c() != 10000 && aVar.b() != null) {
                                return Unit.INSTANCE;
                            }
                            nTRegisterMainline.B();
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    RegisterIdentityRsp registerIdentityRsp3 = (RegisterIdentityRsp) nTRegisterMainline$handleDownSms$1.L$3;
                    WechatInfo wechatInfo3 = (WechatInfo) nTRegisterMainline$handleDownSms$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$handleDownSms$1.L$1;
                    NTRegisterMainline nTRegisterMainline2 = (NTRegisterMainline) nTRegisterMainline$handleDownSms$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    wechatInfo2 = wechatInfo3;
                    nTRegisterMainline = nTRegisterMainline2;
                    obj = obj2;
                    registerIdentityRsp2 = registerIdentityRsp3;
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Bundle bundle = new Bundle();
                    com.tencent.mobileqq.register.bean.a aVar3 = this.mPhoneNumInfo;
                    if (aVar3 != null) {
                        str = aVar3.c();
                    } else {
                        str = null;
                    }
                    bundle.putString("key_phone_num", str);
                    com.tencent.mobileqq.register.bean.a aVar4 = this.mPhoneNumInfo;
                    if (aVar4 != null) {
                        str2 = aVar4.a();
                    } else {
                        str2 = null;
                    }
                    bundle.putString("key_country_code", str2);
                    NTRegisterSafetyCheckUtil nTRegisterSafetyCheckUtil = NTRegisterSafetyCheckUtil.f280486a;
                    nTRegisterMainline$handleDownSms$1.L$0 = this;
                    nTRegisterMainline$handleDownSms$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleDownSms$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleDownSms$1.L$3 = registerIdentityRsp;
                    nTRegisterMainline$handleDownSms$1.label = 1;
                    Object f16 = nTRegisterSafetyCheckUtil.f(registerIdentityRsp, bundle, nTRegisterMainline$handleDownSms$1);
                    if (f16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = f16;
                    registerIdentityRsp2 = registerIdentityRsp;
                    wechatInfo2 = wechatInfo;
                    nTRegisterMainline = this;
                }
                aVar = (a) obj;
                if (aVar.c() != 10000) {
                    RegisterVerifyResult registerVerifyResult = (RegisterVerifyResult) aVar.b();
                    if (registerVerifyResult != null) {
                        bArr = registerVerifyResult.f242907m;
                    }
                    nTRegisterMainline.E(qBaseActivity, wechatInfo2, bArr);
                } else if (aVar.c() == 10001 && aVar.b() != null && !TextUtils.isEmpty(((RegisterVerifyResult) aVar.b()).f242904f)) {
                    registerIdentityRsp2.limit.type = ((RegisterVerifyResult) aVar.b()).f242906i;
                    registerIdentityRsp2.retCode = 10001;
                    registerIdentityRsp2.context = ((RegisterVerifyResult) aVar.b()).f242907m;
                    registerIdentityRsp2.limit.handleUrl = ((RegisterVerifyResult) aVar.b()).f242904f;
                    nTRegisterMainline$handleDownSms$1.L$0 = nTRegisterMainline;
                    nTRegisterMainline$handleDownSms$1.L$1 = aVar;
                    nTRegisterMainline$handleDownSms$1.L$2 = null;
                    nTRegisterMainline$handleDownSms$1.L$3 = null;
                    nTRegisterMainline$handleDownSms$1.label = 2;
                    if (nTRegisterMainline.I(qBaseActivity, wechatInfo2, registerIdentityRsp2, nTRegisterMainline$handleDownSms$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar2 = aVar;
                    aVar = aVar2;
                }
                if (aVar.c() != 10000) {
                }
                nTRegisterMainline.B();
                return Unit.INSTANCE;
            }
        }
        nTRegisterMainline$handleDownSms$1 = new NTRegisterMainline$handleDownSms$1(this, continuation);
        Object obj22 = nTRegisterMainline$handleDownSms$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$handleDownSms$1.label;
        byte[] bArr2 = null;
        if (i3 == 0) {
        }
        aVar = (a) obj;
        if (aVar.c() != 10000) {
        }
        if (aVar.c() != 10000) {
        }
        nTRegisterMainline.B();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(QBaseActivity qBaseActivity, WechatInfo wechatInfo, RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        NTRegisterMainline$handleFaceVerify$1 nTRegisterMainline$handleFaceVerify$1;
        Object coroutine_suspended;
        int i3;
        NTRegisterMainline nTRegisterMainline;
        a aVar;
        NTRegisterMainline nTRegisterMainline2;
        QBaseActivity qBaseActivity2;
        WechatInfo wechatInfo2;
        a aVar2;
        RegisterIdentityRsp registerIdentityRsp2;
        if (continuation instanceof NTRegisterMainline$handleFaceVerify$1) {
            nTRegisterMainline$handleFaceVerify$1 = (NTRegisterMainline$handleFaceVerify$1) continuation;
            int i16 = nTRegisterMainline$handleFaceVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$handleFaceVerify$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTRegisterMainline$handleFaceVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$handleFaceVerify$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        wechatInfo2 = (WechatInfo) nTRegisterMainline$handleFaceVerify$1.L$2;
                        qBaseActivity2 = (QBaseActivity) nTRegisterMainline$handleFaceVerify$1.L$1;
                        nTRegisterMainline2 = (NTRegisterMainline) nTRegisterMainline$handleFaceVerify$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        aVar2 = (a) obj;
                        if (aVar2.c() != 10000 && aVar2.b() != null) {
                            nTRegisterMainline2.E(qBaseActivity2, wechatInfo2, ((RegisterIdentityRsp) aVar2.b()).context);
                            return Unit.INSTANCE;
                        }
                        if (aVar2.c() != 10001 && aVar2.b() != null) {
                            RegisterIdentityRsp registerIdentityRsp3 = (RegisterIdentityRsp) aVar2.b();
                            nTRegisterMainline$handleFaceVerify$1.L$0 = null;
                            nTRegisterMainline$handleFaceVerify$1.L$1 = null;
                            nTRegisterMainline$handleFaceVerify$1.L$2 = null;
                            nTRegisterMainline$handleFaceVerify$1.label = 3;
                            if (nTRegisterMainline2.I(qBaseActivity2, wechatInfo2, registerIdentityRsp3, nTRegisterMainline$handleFaceVerify$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        registerIdentityRsp2 = (RegisterIdentityRsp) aVar2.b();
                        if (registerIdentityRsp2 != null) {
                            nTRegisterMainline2.C(registerIdentityRsp2.retCode, aVar2.a());
                        }
                        return Unit.INSTANCE;
                    }
                    registerIdentityRsp = (RegisterIdentityRsp) nTRegisterMainline$handleFaceVerify$1.L$3;
                    wechatInfo = (WechatInfo) nTRegisterMainline$handleFaceVerify$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$handleFaceVerify$1.L$1;
                    nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$handleFaceVerify$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    NTRegisterSafetyCheckUtil nTRegisterSafetyCheckUtil = NTRegisterSafetyCheckUtil.f280486a;
                    RegisterIdentityLimit registerIdentityLimit = registerIdentityRsp.limit;
                    Intrinsics.checkNotNullExpressionValue(registerIdentityLimit, "registerRsp.limit");
                    nTRegisterMainline$handleFaceVerify$1.L$0 = this;
                    nTRegisterMainline$handleFaceVerify$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleFaceVerify$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleFaceVerify$1.L$3 = registerIdentityRsp;
                    nTRegisterMainline$handleFaceVerify$1.label = 1;
                    obj = nTRegisterSafetyCheckUtil.c(qBaseActivity, registerIdentityLimit, nTRegisterMainline$handleFaceVerify$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline = this;
                }
                aVar = (a) obj;
                if (aVar.c() != 10000 && aVar.b() != null) {
                    CheckLimitHandleResultReq checkLimitHandleResultReq = new CheckLimitHandleResultReq();
                    checkLimitHandleResultReq.context = registerIdentityRsp.context;
                    FaceResult faceResult = new FaceResult();
                    faceResult.resultKey = ((com.tencent.mobileqq.register.bean.b) aVar.b()).b();
                    faceResult.session = ((com.tencent.mobileqq.register.bean.b) aVar.b()).c();
                    checkLimitHandleResultReq.faceResult = faceResult;
                    nTRegisterMainline$handleFaceVerify$1.L$0 = nTRegisterMainline;
                    nTRegisterMainline$handleFaceVerify$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleFaceVerify$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleFaceVerify$1.L$3 = null;
                    nTRegisterMainline$handleFaceVerify$1.label = 2;
                    obj = nTRegisterMainline.q(checkLimitHandleResultReq, nTRegisterMainline$handleFaceVerify$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline2 = nTRegisterMainline;
                    WechatInfo wechatInfo3 = wechatInfo;
                    qBaseActivity2 = qBaseActivity;
                    wechatInfo2 = wechatInfo3;
                    aVar2 = (a) obj;
                    if (aVar2.c() != 10000) {
                    }
                    if (aVar2.c() != 10001) {
                    }
                    registerIdentityRsp2 = (RegisterIdentityRsp) aVar2.b();
                    if (registerIdentityRsp2 != null) {
                    }
                    return Unit.INSTANCE;
                }
                nTRegisterMainline.B();
                return Unit.INSTANCE;
            }
        }
        nTRegisterMainline$handleFaceVerify$1 = new NTRegisterMainline$handleFaceVerify$1(this, continuation);
        Object obj2 = nTRegisterMainline$handleFaceVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$handleFaceVerify$1.label;
        if (i3 == 0) {
        }
        aVar = (a) obj2;
        if (aVar.c() != 10000) {
        }
        nTRegisterMainline.B();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object v(QBaseActivity qBaseActivity, WechatInfo wechatInfo, RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        NTRegisterMainline$handleFriendGuarantee$1 nTRegisterMainline$handleFriendGuarantee$1;
        Object coroutine_suspended;
        int i3;
        NTRegisterMainline nTRegisterMainline;
        a aVar;
        NTRegisterMainline nTRegisterMainline2;
        QBaseActivity qBaseActivity2;
        WechatInfo wechatInfo2;
        a aVar2;
        if (continuation instanceof NTRegisterMainline$handleFriendGuarantee$1) {
            nTRegisterMainline$handleFriendGuarantee$1 = (NTRegisterMainline$handleFriendGuarantee$1) continuation;
            int i16 = nTRegisterMainline$handleFriendGuarantee$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$handleFriendGuarantee$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTRegisterMainline$handleFriendGuarantee$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$handleFriendGuarantee$1.label;
                byte[] bArr = null;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        wechatInfo2 = (WechatInfo) nTRegisterMainline$handleFriendGuarantee$1.L$2;
                        qBaseActivity2 = (QBaseActivity) nTRegisterMainline$handleFriendGuarantee$1.L$1;
                        nTRegisterMainline2 = (NTRegisterMainline) nTRegisterMainline$handleFriendGuarantee$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        aVar2 = (a) obj;
                        if (aVar2.c() != 10000) {
                            RegisterIdentityRsp registerIdentityRsp2 = (RegisterIdentityRsp) aVar2.b();
                            if (registerIdentityRsp2 != null) {
                                bArr = registerIdentityRsp2.context;
                            }
                            nTRegisterMainline2.E(qBaseActivity2, wechatInfo2, bArr);
                            return Unit.INSTANCE;
                        }
                        if (aVar2.c() == 10001 && aVar2.b() != null) {
                            RegisterIdentityRsp registerIdentityRsp3 = (RegisterIdentityRsp) aVar2.b();
                            nTRegisterMainline$handleFriendGuarantee$1.L$0 = null;
                            nTRegisterMainline$handleFriendGuarantee$1.L$1 = null;
                            nTRegisterMainline$handleFriendGuarantee$1.L$2 = null;
                            nTRegisterMainline$handleFriendGuarantee$1.label = 3;
                            if (nTRegisterMainline2.I(qBaseActivity2, wechatInfo2, registerIdentityRsp3, nTRegisterMainline$handleFriendGuarantee$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        RegisterIdentityRsp registerIdentityRsp4 = (RegisterIdentityRsp) aVar2.b();
                        if (registerIdentityRsp4 != null) {
                            nTRegisterMainline2.C(registerIdentityRsp4.retCode, aVar2.a());
                        }
                        return Unit.INSTANCE;
                    }
                    registerIdentityRsp = (RegisterIdentityRsp) nTRegisterMainline$handleFriendGuarantee$1.L$3;
                    wechatInfo = (WechatInfo) nTRegisterMainline$handleFriendGuarantee$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$handleFriendGuarantee$1.L$1;
                    nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$handleFriendGuarantee$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    NTRegisterSafetyCheckUtil nTRegisterSafetyCheckUtil = NTRegisterSafetyCheckUtil.f280486a;
                    RegisterIdentityLimit registerIdentityLimit = registerIdentityRsp.limit;
                    Intrinsics.checkNotNullExpressionValue(registerIdentityLimit, "registerRsp.limit");
                    nTRegisterMainline$handleFriendGuarantee$1.L$0 = this;
                    nTRegisterMainline$handleFriendGuarantee$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleFriendGuarantee$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleFriendGuarantee$1.L$3 = registerIdentityRsp;
                    nTRegisterMainline$handleFriendGuarantee$1.label = 1;
                    obj = nTRegisterSafetyCheckUtil.d(qBaseActivity, registerIdentityLimit, nTRegisterMainline$handleFriendGuarantee$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline = this;
                }
                aVar = (a) obj;
                if (aVar.c() != 10000 && aVar.b() != null) {
                    CheckLimitHandleResultReq checkLimitHandleResultReq = new CheckLimitHandleResultReq();
                    checkLimitHandleResultReq.context = registerIdentityRsp.context;
                    nTRegisterMainline$handleFriendGuarantee$1.L$0 = nTRegisterMainline;
                    nTRegisterMainline$handleFriendGuarantee$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleFriendGuarantee$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleFriendGuarantee$1.L$3 = null;
                    nTRegisterMainline$handleFriendGuarantee$1.label = 2;
                    obj = nTRegisterMainline.q(checkLimitHandleResultReq, nTRegisterMainline$handleFriendGuarantee$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline2 = nTRegisterMainline;
                    WechatInfo wechatInfo3 = wechatInfo;
                    qBaseActivity2 = qBaseActivity;
                    wechatInfo2 = wechatInfo3;
                    aVar2 = (a) obj;
                    if (aVar2.c() != 10000) {
                    }
                } else {
                    nTRegisterMainline.B();
                    return Unit.INSTANCE;
                }
            }
        }
        nTRegisterMainline$handleFriendGuarantee$1 = new NTRegisterMainline$handleFriendGuarantee$1(this, continuation);
        Object obj2 = nTRegisterMainline$handleFriendGuarantee$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$handleFriendGuarantee$1.label;
        byte[] bArr2 = null;
        if (i3 == 0) {
        }
        aVar = (a) obj2;
        if (aVar.c() != 10000) {
        }
        nTRegisterMainline.B();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w(QBaseActivity qBaseActivity, WechatInfo wechatInfo, RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        NTRegisterMainline$handlePuzzleVerify$1 nTRegisterMainline$handlePuzzleVerify$1;
        Object coroutine_suspended;
        int i3;
        NTRegisterMainline nTRegisterMainline;
        a aVar;
        NTRegisterMainline nTRegisterMainline2;
        QBaseActivity qBaseActivity2;
        WechatInfo wechatInfo2;
        a aVar2;
        if (continuation instanceof NTRegisterMainline$handlePuzzleVerify$1) {
            nTRegisterMainline$handlePuzzleVerify$1 = (NTRegisterMainline$handlePuzzleVerify$1) continuation;
            int i16 = nTRegisterMainline$handlePuzzleVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$handlePuzzleVerify$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTRegisterMainline$handlePuzzleVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$handlePuzzleVerify$1.label;
                byte[] bArr = null;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        wechatInfo2 = (WechatInfo) nTRegisterMainline$handlePuzzleVerify$1.L$2;
                        qBaseActivity2 = (QBaseActivity) nTRegisterMainline$handlePuzzleVerify$1.L$1;
                        nTRegisterMainline2 = (NTRegisterMainline) nTRegisterMainline$handlePuzzleVerify$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        aVar2 = (a) obj;
                        if (aVar2.c() != 10000) {
                            RegisterIdentityRsp registerIdentityRsp2 = (RegisterIdentityRsp) aVar2.b();
                            if (registerIdentityRsp2 != null) {
                                bArr = registerIdentityRsp2.context;
                            }
                            nTRegisterMainline2.E(qBaseActivity2, wechatInfo2, bArr);
                            return Unit.INSTANCE;
                        }
                        if (aVar2.c() == 10001 && aVar2.b() != null) {
                            RegisterIdentityRsp registerIdentityRsp3 = (RegisterIdentityRsp) aVar2.b();
                            nTRegisterMainline$handlePuzzleVerify$1.L$0 = null;
                            nTRegisterMainline$handlePuzzleVerify$1.L$1 = null;
                            nTRegisterMainline$handlePuzzleVerify$1.L$2 = null;
                            nTRegisterMainline$handlePuzzleVerify$1.label = 3;
                            if (nTRegisterMainline2.I(qBaseActivity2, wechatInfo2, registerIdentityRsp3, nTRegisterMainline$handlePuzzleVerify$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        RegisterIdentityRsp registerIdentityRsp4 = (RegisterIdentityRsp) aVar2.b();
                        if (registerIdentityRsp4 != null) {
                            nTRegisterMainline2.C(registerIdentityRsp4.retCode, aVar2.a());
                        }
                        return Unit.INSTANCE;
                    }
                    registerIdentityRsp = (RegisterIdentityRsp) nTRegisterMainline$handlePuzzleVerify$1.L$3;
                    wechatInfo = (WechatInfo) nTRegisterMainline$handlePuzzleVerify$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$handlePuzzleVerify$1.L$1;
                    nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$handlePuzzleVerify$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    NTRegisterSafetyCheckUtil nTRegisterSafetyCheckUtil = NTRegisterSafetyCheckUtil.f280486a;
                    String str = registerIdentityRsp.limit.handleUrl;
                    Intrinsics.checkNotNullExpressionValue(str, "registerRsp.limit.handleUrl");
                    nTRegisterMainline$handlePuzzleVerify$1.L$0 = this;
                    nTRegisterMainline$handlePuzzleVerify$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handlePuzzleVerify$1.L$2 = wechatInfo;
                    nTRegisterMainline$handlePuzzleVerify$1.L$3 = registerIdentityRsp;
                    nTRegisterMainline$handlePuzzleVerify$1.label = 1;
                    obj = nTRegisterSafetyCheckUtil.e(str, nTRegisterMainline$handlePuzzleVerify$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline = this;
                }
                aVar = (a) obj;
                if (aVar.c() != 10000 && aVar.b() != null) {
                    CheckLimitHandleResultReq checkLimitHandleResultReq = new CheckLimitHandleResultReq();
                    checkLimitHandleResultReq.context = registerIdentityRsp.context;
                    Iframe iframe = new Iframe();
                    iframe.iframeSid = ((Iframe) aVar.b()).iframeSid;
                    iframe.iframeSig = ((Iframe) aVar.b()).iframeSig;
                    iframe.iframeRandstr = ((Iframe) aVar.b()).iframeRandstr;
                    checkLimitHandleResultReq.iframe = iframe;
                    nTRegisterMainline$handlePuzzleVerify$1.L$0 = nTRegisterMainline;
                    nTRegisterMainline$handlePuzzleVerify$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handlePuzzleVerify$1.L$2 = wechatInfo;
                    nTRegisterMainline$handlePuzzleVerify$1.L$3 = null;
                    nTRegisterMainline$handlePuzzleVerify$1.label = 2;
                    obj = nTRegisterMainline.q(checkLimitHandleResultReq, nTRegisterMainline$handlePuzzleVerify$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline2 = nTRegisterMainline;
                    WechatInfo wechatInfo3 = wechatInfo;
                    qBaseActivity2 = qBaseActivity;
                    wechatInfo2 = wechatInfo3;
                    aVar2 = (a) obj;
                    if (aVar2.c() != 10000) {
                    }
                } else {
                    nTRegisterMainline.B();
                    return Unit.INSTANCE;
                }
            }
        }
        nTRegisterMainline$handlePuzzleVerify$1 = new NTRegisterMainline$handlePuzzleVerify$1(this, continuation);
        Object obj2 = nTRegisterMainline$handlePuzzleVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$handlePuzzleVerify$1.label;
        byte[] bArr2 = null;
        if (i3 == 0) {
        }
        aVar = (a) obj2;
        if (aVar.c() != 10000) {
        }
        nTRegisterMainline.B();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object x(QBaseActivity qBaseActivity, WechatInfo wechatInfo, RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        NTRegisterMainline$handleUnbindUin$1 nTRegisterMainline$handleUnbindUin$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        NTRegisterMainline nTRegisterMainline;
        NTRegisterMainline nTRegisterMainline2;
        QBaseActivity qBaseActivity2;
        WechatInfo wechatInfo2;
        a aVar;
        if (continuation instanceof NTRegisterMainline$handleUnbindUin$1) {
            nTRegisterMainline$handleUnbindUin$1 = (NTRegisterMainline$handleUnbindUin$1) continuation;
            int i16 = nTRegisterMainline$handleUnbindUin$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$handleUnbindUin$1.label = i16 - Integer.MIN_VALUE;
                obj = nTRegisterMainline$handleUnbindUin$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$handleUnbindUin$1.label;
                byte[] bArr = null;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            wechatInfo2 = (WechatInfo) nTRegisterMainline$handleUnbindUin$1.L$2;
                            qBaseActivity2 = (QBaseActivity) nTRegisterMainline$handleUnbindUin$1.L$1;
                            nTRegisterMainline2 = (NTRegisterMainline) nTRegisterMainline$handleUnbindUin$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            aVar = (a) obj;
                            if (aVar.c() != 10000) {
                                RegisterIdentityRsp registerIdentityRsp2 = (RegisterIdentityRsp) aVar.b();
                                if (registerIdentityRsp2 != null) {
                                    bArr = registerIdentityRsp2.context;
                                }
                                nTRegisterMainline2.E(qBaseActivity2, wechatInfo2, bArr);
                                return Unit.INSTANCE;
                            }
                            RegisterIdentityRsp registerIdentityRsp3 = (RegisterIdentityRsp) aVar.b();
                            if (registerIdentityRsp3 != null) {
                                nTRegisterMainline2.C(registerIdentityRsp3.retCode, aVar.a());
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    registerIdentityRsp = (RegisterIdentityRsp) nTRegisterMainline$handleUnbindUin$1.L$3;
                    wechatInfo = (WechatInfo) nTRegisterMainline$handleUnbindUin$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$handleUnbindUin$1.L$1;
                    nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$handleUnbindUin$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    NTRegisterSafetyCheckUtil nTRegisterSafetyCheckUtil = NTRegisterSafetyCheckUtil.f280486a;
                    String str = registerIdentityRsp.limit.handleUrl;
                    Intrinsics.checkNotNullExpressionValue(str, "registerRsp.limit.handleUrl");
                    nTRegisterMainline$handleUnbindUin$1.L$0 = this;
                    nTRegisterMainline$handleUnbindUin$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleUnbindUin$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleUnbindUin$1.L$3 = registerIdentityRsp;
                    nTRegisterMainline$handleUnbindUin$1.label = 1;
                    obj = nTRegisterSafetyCheckUtil.g(qBaseActivity, str, nTRegisterMainline$handleUnbindUin$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline = this;
                }
                if (((a) obj).c() == 10000) {
                    nTRegisterMainline.B();
                    return Unit.INSTANCE;
                }
                CheckLimitHandleResultReq checkLimitHandleResultReq = new CheckLimitHandleResultReq();
                checkLimitHandleResultReq.context = registerIdentityRsp.context;
                nTRegisterMainline$handleUnbindUin$1.L$0 = nTRegisterMainline;
                nTRegisterMainline$handleUnbindUin$1.L$1 = qBaseActivity;
                nTRegisterMainline$handleUnbindUin$1.L$2 = wechatInfo;
                nTRegisterMainline$handleUnbindUin$1.L$3 = null;
                nTRegisterMainline$handleUnbindUin$1.label = 2;
                obj = nTRegisterMainline.q(checkLimitHandleResultReq, nTRegisterMainline$handleUnbindUin$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nTRegisterMainline2 = nTRegisterMainline;
                WechatInfo wechatInfo3 = wechatInfo;
                qBaseActivity2 = qBaseActivity;
                wechatInfo2 = wechatInfo3;
                aVar = (a) obj;
                if (aVar.c() != 10000) {
                }
            }
        }
        nTRegisterMainline$handleUnbindUin$1 = new NTRegisterMainline$handleUnbindUin$1(this, continuation);
        obj = nTRegisterMainline$handleUnbindUin$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$handleUnbindUin$1.label;
        byte[] bArr2 = null;
        if (i3 == 0) {
        }
        if (((a) obj).c() == 10000) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y(QBaseActivity qBaseActivity, WechatInfo wechatInfo, RegisterIdentityRsp registerIdentityRsp, Continuation<? super Unit> continuation) {
        NTRegisterMainline$handleUpSms$1 nTRegisterMainline$handleUpSms$1;
        Object coroutine_suspended;
        int i3;
        NTRegisterMainline nTRegisterMainline;
        a aVar;
        if (continuation instanceof NTRegisterMainline$handleUpSms$1) {
            nTRegisterMainline$handleUpSms$1 = (NTRegisterMainline$handleUpSms$1) continuation;
            int i16 = nTRegisterMainline$handleUpSms$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nTRegisterMainline$handleUpSms$1.label = i16 - Integer.MIN_VALUE;
                Object obj = nTRegisterMainline$handleUpSms$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nTRegisterMainline$handleUpSms$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    registerIdentityRsp = (RegisterIdentityRsp) nTRegisterMainline$handleUpSms$1.L$3;
                    wechatInfo = (WechatInfo) nTRegisterMainline$handleUpSms$1.L$2;
                    qBaseActivity = (QBaseActivity) nTRegisterMainline$handleUpSms$1.L$1;
                    nTRegisterMainline = (NTRegisterMainline) nTRegisterMainline$handleUpSms$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    NTRegisterSafetyCheckUtil nTRegisterSafetyCheckUtil = NTRegisterSafetyCheckUtil.f280486a;
                    nTRegisterMainline$handleUpSms$1.L$0 = this;
                    nTRegisterMainline$handleUpSms$1.L$1 = qBaseActivity;
                    nTRegisterMainline$handleUpSms$1.L$2 = wechatInfo;
                    nTRegisterMainline$handleUpSms$1.L$3 = registerIdentityRsp;
                    nTRegisterMainline$handleUpSms$1.label = 1;
                    obj = nTRegisterSafetyCheckUtil.h(registerIdentityRsp, nTRegisterMainline$handleUpSms$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nTRegisterMainline = this;
                }
                aVar = (a) obj;
                byte[] bArr = null;
                if (aVar.c() != 10000) {
                    RegisterVerifyResult registerVerifyResult = (RegisterVerifyResult) aVar.b();
                    if (registerVerifyResult != null) {
                        bArr = registerVerifyResult.f242907m;
                    }
                    nTRegisterMainline.E(qBaseActivity, wechatInfo, bArr);
                    return Unit.INSTANCE;
                }
                if (aVar.c() == 10001 && aVar.b() != null && !TextUtils.isEmpty(((RegisterVerifyResult) aVar.b()).f242904f)) {
                    registerIdentityRsp.limit.type = ((RegisterVerifyResult) aVar.b()).f242906i;
                    registerIdentityRsp.limit.handleUrl = ((RegisterVerifyResult) aVar.b()).f242904f;
                    registerIdentityRsp.retCode = 10001;
                    registerIdentityRsp.context = ((RegisterVerifyResult) aVar.b()).f242907m;
                    nTRegisterMainline$handleUpSms$1.L$0 = null;
                    nTRegisterMainline$handleUpSms$1.L$1 = null;
                    nTRegisterMainline$handleUpSms$1.L$2 = null;
                    nTRegisterMainline$handleUpSms$1.L$3 = null;
                    nTRegisterMainline$handleUpSms$1.label = 2;
                    if (nTRegisterMainline.I(qBaseActivity, wechatInfo, registerIdentityRsp, nTRegisterMainline$handleUpSms$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                nTRegisterMainline.B();
                return Unit.INSTANCE;
            }
        }
        nTRegisterMainline$handleUpSms$1 = new NTRegisterMainline$handleUpSms$1(this, continuation);
        Object obj2 = nTRegisterMainline$handleUpSms$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nTRegisterMainline$handleUpSms$1.label;
        if (i3 == 0) {
        }
        aVar = (a) obj2;
        byte[] bArr2 = null;
        if (aVar.c() != 10000) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.register.ntregister.f
            @Override // java.lang.Runnable
            public final void run() {
                NTRegisterMainline.A(NTRegisterMainline.this);
            }
        });
    }

    public final void G(@NotNull QBaseActivity activity, @NotNull com.tencent.mobileqq.register.bean.a phoneNumInfo, @Nullable WechatInfo wechatInfo, @Nullable com.tencent.mobileqq.loginregister.callback.b registerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, phoneNumInfo, wechatInfo, registerCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(phoneNumInfo, "phoneNumInfo");
        QLog.d("NTRegisterMainline", 1, "phoneRegister phone num: " + phoneNumInfo.c());
        q.c().k(registerCallback);
        this.mRegisterCallback = registerCallback;
        this.mPhoneNumInfo = phoneNumInfo;
        SubmitIdentityInfoReq submitIdentityInfoReq = new SubmitIdentityInfoReq();
        submitIdentityInfoReq.type = 2;
        UserInfo userInfo = new UserInfo();
        userInfo.account = phoneNumInfo.c();
        userInfo.countryCode = Integer.parseInt(phoneNumInfo.a());
        submitIdentityInfoReq.phoneInfo = userInfo;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "NTRegisterMainline", null, null, null, new NTRegisterMainline$phoneRegister$1(this, activity, wechatInfo, submitIdentityInfoReq, null), 14, null);
        }
    }

    public final void r(@NotNull QBaseActivity activity, @Nullable WechatInfo wechatInfo, @NotNull com.tencent.mobileqq.loginregister.callback.b registerCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, wechatInfo, registerCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(registerCallback, "registerCallback");
        QLog.d("NTRegisterMainline", 1, "Start gatewayRegister");
        q.c().k(registerCallback);
        this.mRegisterCallback = registerCallback;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "NTRegisterMainline", null, null, null, new NTRegisterMainline$gatewayRegister$1(this, activity, wechatInfo, null), 14, null);
        }
    }
}
