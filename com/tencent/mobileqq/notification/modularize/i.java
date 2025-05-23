package com.tencent.mobileqq.notification.modularize;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.ITianshuTempApi;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.tianshu.TianShuManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J6\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J>\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J2\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/notification/modularize/i;", "", "", "mainBusinessId", "subBusinessId", BaseConstants.EXTRA_PUSHID, "", "triggerInfo", "from", "", "f", tl.h.F, "action", "g", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/notification/modularize/f;", "pushComponent", "b", "iconUrl", "Landroid/graphics/Bitmap;", "c", "selfUin", "actionId", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f254311a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f254311a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@NotNull Intent intent, @NotNull f pushComponent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(pushComponent, "pushComponent");
        intent.putExtra("KEY_MAIN_BUSINESS_ID", pushComponent.mainBusinessId);
        intent.putExtra("KEY_SUB_BUSINESS_ID", pushComponent.subBusinessId);
        intent.putExtra("KEY_PUSH_ID", pushComponent.com.tencent.qphone.base.BaseConstants.EXTRA_PUSHID java.lang.String);
        intent.putExtra("KEY_PUSH_TRIGGER_INFO", pushComponent.triggerInfo);
        intent.putExtra("KEY_PUSH_IS_FROM", pushComponent.from);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String selfUin, int i3, String pushId, String str, String str2) {
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        Intrinsics.checkNotNullParameter(pushId, "$pushId");
        TianShuReportData tianShuReportData = new TianShuReportData();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        tianShuReportData.mTraceId = selfUin + "_" + currentTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = pushId;
        tianShuReportData.mOperTime = currentTimeMillis;
        if (str != null) {
            tianShuReportData.mTriggerInfo = str;
        }
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "vab_push";
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            if (guardManager.isApplicationForeground()) {
                str4 = "0";
            } else {
                str4 = "1";
            }
            tianShuReportData.mPositionId = str4;
        }
        tianShuReportData.mPageId = "vab_push";
        tianShuReportData.mModuleId = "";
        JSONObject jSONObject = new JSONObject();
        if (QQAppInterface.isNotificationEnabled() == 1) {
            str3 = "on";
        } else {
            str3 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        jSONObject.put("notify", str3);
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("msgFrom", str2);
        }
        tianShuReportData.mBusiInfo = jSONObject.toString();
        TianShuManager.getInstance().report(tianShuReportData);
        QLog.d("PushUtil", 1, "reportAdBoss:  ", "tianShuReportData: " + tianShuReportData);
    }

    @JvmStatic
    public static final void f(int mainBusinessId, int subBusinessId, int pushId, @Nullable String triggerInfo, @Nullable String from) {
        g(mainBusinessId, subBusinessId, String.valueOf(pushId), triggerInfo, "0X800AE74", from);
    }

    @JvmStatic
    public static final void g(int mainBusinessId, int subBusinessId, @Nullable String pushId, @Nullable String triggerInfo, @NotNull String action, @Nullable String from) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (mainBusinessId != -1) {
            ReportController.o(null, "dc00898", "", "", action, action, mainBusinessId, 0, String.valueOf(subBusinessId), pushId, "", "");
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            i iVar = f254311a;
            String account = runtime.getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "runtime.account");
            iVar.d(account, 118, String.valueOf(pushId), triggerInfo, from);
            ((ITianshuTempApi) QRoute.api(ITianshuTempApi.class)).setHalfLayerADParams("1", "PushUtil");
            QLog.d("PushUtil", 2, "setHalfLayerADParams", "PushUtil");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PushUtil", 2, "reportPushClick: called. ", "no need report mainBusinessId: " + mainBusinessId);
        }
    }

    @JvmStatic
    public static final void h(int mainBusinessId, int subBusinessId, @Nullable String pushId, @Nullable String triggerInfo, @Nullable String from) {
        g(mainBusinessId, subBusinessId, pushId, triggerInfo, "0X800BBD0", from);
    }

    @Nullable
    public final Bitmap c(@Nullable String iconUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iconUrl);
        }
        return com.tencent.mobileqq.message.newmsg.a.f(iconUrl);
    }

    public final void d(@NotNull final String selfUin, final int actionId, @NotNull final String pushId, @Nullable final String triggerInfo, @Nullable final String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, selfUin, Integer.valueOf(actionId), pushId, triggerInfo, from);
            return;
        }
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(pushId, "pushId");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.notification.modularize.h
            @Override // java.lang.Runnable
            public final void run() {
                i.e(selfUin, actionId, pushId, triggerInfo, from);
            }
        });
    }
}
