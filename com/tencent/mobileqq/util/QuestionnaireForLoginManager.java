package com.tencent.mobileqq.util;

import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.servlet.QuestionnaireForLoginHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/util/QuestionnaireForLoginManager;", "", "", "eventType", "", tl.h.F, "d", "", TangramHippyConstants.LOGIN_TYPE, "i", "deviceType", "g", "e", "", "time", "f", "b", "I", "mEvent", "Lorg/json/JSONObject;", "c", "Lorg/json/JSONObject;", "mMsg", "<init>", "()V", "DeviceType", "EventType", "LoginType", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QuestionnaireForLoginManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QuestionnaireForLoginManager f306468a = new QuestionnaireForLoginManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mEvent = 1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static JSONObject mMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/util/QuestionnaireForLoginManager$DeviceType;", "", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes20.dex */
    public @interface DeviceType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/util/QuestionnaireForLoginManager$EventType;", "", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes20.dex */
    public @interface EventType {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/util/QuestionnaireForLoginManager$LoginType;", "", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes20.dex */
    public @interface LoginType {
    }

    static {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TangramHippyConstants.LOGIN_TYPE, "other_login");
        jSONObject.put("deviceType", "old_device");
        mMsg = jSONObject;
    }

    QuestionnaireForLoginManager() {
    }

    @JvmStatic
    public static final void b() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.bv
            @Override // java.lang.Runnable
            public final void run() {
                QuestionnaireForLoginManager.c();
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(QuestionnaireForLoginHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.QuestionnaireForLoginHandler");
        int i3 = mEvent;
        String jSONObject = mMsg.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "mMsg.toString()");
        ((QuestionnaireForLoginHandler) businessHandler).D2(i3, jSONObject);
        QLog.i("QuestionnaireForLoginManager", 1, "mEvent = " + mEvent + ", mMsg: loginType = " + mMsg.optString(TangramHippyConstants.LOGIN_TYPE) + ", deviceType = " + mMsg.optString("deviceType"));
        mEvent = 1;
        e();
    }

    @JvmStatic
    public static final void d(int eventType) {
        mEvent = eventType ^ (mEvent | eventType);
    }

    @JvmStatic
    public static final void e() {
        JSONObject jSONObject = mMsg;
        jSONObject.put(TangramHippyConstants.LOGIN_TYPE, "other_login");
        jSONObject.put("deviceType", "old_device");
    }

    @JvmStatic
    public static final void f(long time) {
        com.tencent.mobileqq.config.at atVar = com.tencent.mobileqq.config.at.f202335a;
        String optString = mMsg.optString("deviceType");
        Intrinsics.checkNotNullExpressionValue(optString, "mMsg.optString(KEY_DEVICE_TYPE)");
        String optString2 = mMsg.optString(TangramHippyConstants.LOGIN_TYPE);
        Intrinsics.checkNotNullExpressionValue(optString2, "mMsg.optString(KEY_LOGIN_TYPE)");
        long a16 = atVar.a(optString, optString2);
        QLog.d("QuestionnaireForLoginManager", 2, "time : " + time + ", costTimeConfig : " + a16);
        if (time > a16) {
            h(4);
        } else {
            d(4);
        }
    }

    @JvmStatic
    public static final void g(@NotNull String deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        mMsg.put("deviceType", deviceType);
    }

    @JvmStatic
    public static final void h(int eventType) {
        mEvent = eventType | mEvent;
    }

    @JvmStatic
    public static final void i(@NotNull String loginType) {
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        mMsg.put(TangramHippyConstants.LOGIN_TYPE, loginType);
    }
}
