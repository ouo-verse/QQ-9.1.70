package com.tencent.mobileqq.flock.base;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.mqq.api.impl.AccountRuntimeImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/flock/base/FlockBaseRequest;", "T", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "", "host", "Lmqq/app/AppRuntime;", "runtime", "a", "(Ljava/lang/String;Lmqq/app/AppRuntime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "getRequestByteData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "requestBizData", "getRequestWrapper", "getPsKey", "<init>", "()V", "Companion", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class FlockBaseRequest<T> extends VSBaseRequest {
    static IPatchRedirector $redirector_ = null;
    public static final int APPID_FLOCK = 99;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String QUN_DOMAIN = "qun.qq.com";
    public static final int QUN_DOMAIN_ID = 73;

    @NotNull
    public static final String TAG = "FlockBaseRequest querySPKey";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/base/FlockBaseRequest$a;", "", "", "APPID_FLOCK", "I", "", "QUN_DOMAIN", "Ljava/lang/String;", "QUN_DOMAIN_ID", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.base.FlockBaseRequest$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockBaseRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(final String str, AppRuntime appRuntime, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{str}, new sd2.a(str, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.flock.base.FlockBaseRequest$querySPKeySuspend$2$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f210000a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<String> f210001b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.f210000a = str;
                this.f210001b = cancellableContinuationImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) cancellableContinuationImpl);
                }
            }

            @Override // sd2.a
            public void onFail(@NotNull String errMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.e(FlockBaseRequest.TAG, 1, "getPSKey onFail errMsg=" + errMsg);
                this.f210001b.resume("", FlockBaseRequest$querySPKeySuspend$2$1$onFail$1.INSTANCE);
            }

            @Override // sd2.a
            public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) domainToKeyMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                String str2 = domainToKeyMap.get(this.f210000a);
                if (str2 == null) {
                    str2 = "";
                }
                QLog.i(FlockBaseRequest.TAG, 1, "getPSKey onSuccess, spKey: " + str2);
                this.f210001b.resume(str2, FlockBaseRequest$querySPKeySuspend$2$1$onSuccess$1.INSTANCE);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public abstract MessageNano getMessageNano();

    @Nullable
    public final String getPsKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !TextUtils.isEmpty(peekAppRuntime.getAccount())) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            BuildersKt__BuildersKt.runBlocking$default(null, new FlockBaseRequest$getPsKey$1(objectRef, this, peekAppRuntime, null), 1, null);
            return (String) objectRef.element;
        }
        QLog.d(AccountRuntimeImpl.TAG, 1, "appruntime or account is null");
        return "";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        byte[] byteArray = MessageNano.toByteArray(getMessageNano());
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(getMessageNano())");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @Nullable
    public byte[] getRequestWrapper(@Nullable ByteStringMicro requestBizData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) requestBizData);
        }
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(super.getRequestWrapper(requestBizData));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        COMM.Entry entry = new COMM.Entry();
        entry.key.set(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY);
        entry.value.set(ThemeBackground.DIY_UPLOAD_BG_ID);
        stQWebReq.Extinfo.add(entry);
        return stQWebReq.toByteArray();
    }
}
