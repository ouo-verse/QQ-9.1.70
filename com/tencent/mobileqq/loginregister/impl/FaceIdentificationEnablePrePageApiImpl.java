package com.tencent.mobileqq.loginregister.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.FaceIdentificationEnablePreFragment;
import com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0012j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/loginregister/impl/FaceIdentificationEnablePrePageApiImpl;", "Lcom/tencent/mobileqq/loginregister/IFaceIdentificationEnablePrePageApi;", "Landroid/app/Activity;", "context", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/loginregister/IFaceIdentificationEnablePrePageApi$a;", "callback", "", "openEnablePrePage", "", "result", "", "openId", "tmpKey", "onVerifyFinish", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onCancelVerify", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "callbackMap", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FaceIdentificationEnablePrePageApiImpl implements IFaceIdentificationEnablePrePageApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CALLBACK_KEY = "callback_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "FaceIdentificationEnablePrePageApiImpl";

    @NotNull
    private final HashMap<String, IFaceIdentificationEnablePrePageApi.a> callbackMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/loginregister/impl/FaceIdentificationEnablePrePageApiImpl$a;", "", "", "CALLBACK_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.loginregister.impl.FaceIdentificationEnablePrePageApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24284);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FaceIdentificationEnablePrePageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.callbackMap = new HashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi
    public void onCancelVerify(@Nullable Activity activity) {
        Intent intent;
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null || (stringExtra = intent.getStringExtra(CALLBACK_KEY)) == null) {
            return;
        }
        this.callbackMap.remove(stringExtra);
    }

    @Override // com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi
    public void onVerifyFinish(@Nullable Activity context, boolean result, @Nullable String openId, @Nullable String tmpKey) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(result), openId, tmpKey);
            return;
        }
        if (context != null) {
            intent = context.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            QLog.e(TAG, 1, "onVerifyFinish intent is null");
            return;
        }
        String stringExtra = intent.getStringExtra(CALLBACK_KEY);
        if (stringExtra == null) {
            QLog.e(TAG, 1, "onVerifyFinish callbackKey is null");
            return;
        }
        IFaceIdentificationEnablePrePageApi.a remove = this.callbackMap.remove(stringExtra);
        if (remove == null) {
            QLog.e(TAG, 1, "onVerifyFinish callback is null. callbackKey: " + stringExtra + " mapSize: " + this.callbackMap.size());
            return;
        }
        if (result) {
            remove.b(context, openId, tmpKey);
        } else {
            remove.a(context);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi
    public void openEnablePrePage(@Nullable Activity context, @Nullable Intent intent, @Nullable IFaceIdentificationEnablePrePageApi.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, intent, callback);
            return;
        }
        if (context != null && intent != null && callback != null) {
            String str = Reflection.getOrCreateKotlinClass(context.getClass()).getSimpleName() + "_" + context.hashCode();
            this.callbackMap.put(str, callback);
            intent.putExtra(CALLBACK_KEY, str);
            QLog.i(TAG, 2, "openEnablePrePage putCallback " + str + " -> " + callback);
            QPublicFragmentActivity.start(context, intent, FaceIdentificationEnablePreFragment.class);
        }
    }
}
