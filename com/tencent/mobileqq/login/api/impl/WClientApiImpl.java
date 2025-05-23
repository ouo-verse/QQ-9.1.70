package com.tencent.mobileqq.login.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.login.api.IWClientApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/login/api/impl/WClientApiImpl;", "Lcom/tencent/mobileqq/login/api/IWClientApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "getWClientVersion", "", "serviceType", "sequence", "Le72/e;", "callback", "", "startWClientVerify", "<init>", "()V", "Companion", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class WClientApiImpl implements IWClientApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String APP_ID = "0003";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String ORGANIZATION_ID = "00001426";

    @NotNull
    public static final String TAG = "WClientApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/login/api/impl/WClientApiImpl$a;", "", "", "APP_ID", "Ljava/lang/String;", "ORGANIZATION_ID", "TAG", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.api.impl.WClientApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WClientApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWClientVerify$lambda$0(e72.e callback, l.b bVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d(TAG, 1, "startWClientVerify onResult : " + bVar.a());
        String jSONObject = new JSONObject().put(QzoneIPCModule.RESULT_CODE, bVar.a()).put("resultDesc", bVar.c()).put("idCardAuthData", bVar.b().c()).put("certPwdData", bVar.b().a()).put("extrasData", bVar.b().b()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonResult.toString()");
        callback.onResult(jSONObject);
    }

    @Override // com.tencent.mobileqq.login.api.IWClientApi
    @NotNull
    public String getWClientVersion(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        String d16 = k.c.d();
        Intrinsics.checkNotNullExpressionValue(d16, "getVersion()");
        return d16;
    }

    @Override // com.tencent.mobileqq.login.api.IWClientApi
    public void startWClientVerify(@NotNull Activity activity, int serviceType, @NotNull String sequence, @NotNull final e72.e callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, Integer.valueOf(serviceType), sequence, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 2, "startWClientVerify serviceType: " + serviceType + ", sequence: " + sequence);
        new k.c(activity, new l.c(ORGANIZATION_ID, "0003", sequence, serviceType)).a(new k.a() { // from class: com.tencent.mobileqq.login.api.impl.i
            @Override // k.a
            public final void a(l.b bVar) {
                WClientApiImpl.startWClientVerify$lambda$0(e72.e.this, bVar);
            }
        });
    }
}
