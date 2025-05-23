package com.tencent.mobileqq.qqlive.api.reminder.impl;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.data.stage.nano.CommonStage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi;
import com.tencent.mobileqq.qqlive.api.reminder.QQLiveNoticeInfo;
import com.tencent.mobileqq.qqlive.api.reminder.ReminderInfo;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveCancelAnchorNoticeRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import com.tencent.util.QQToastUtil;
import et3.c;
import java.util.HashMap;
import java.util.Map;
import jq4.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/reminder/impl/QQLiveReminderApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/reminder/IQQLiveReminderApi;", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "createReportParams", "", "", "noticeInfo", "Lcom/tencent/mobileqq/qqlive/api/reminder/QQLiveNoticeInfo;", "destroy", "", "isQQLiveReminder", "", "busId", "msgId", "parseQQLiveNoticeInfo", "extendField", "showError", "showSuccess", "unsubscribeReminder", "reminderInfo", "Lcom/tencent/mobileqq/qqlive/api/reminder/ReminderInfo;", "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveReminderApiImpl implements IQQLiveReminderApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    @NotNull
    private static final String TAG = "QQLiveReminderApiImpl";
    private final Gson gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/reminder/impl/QQLiveReminderApiImpl$Companion;", "", "()V", "TAG", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    private static final class Companion {
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(CommonStage.CMD_COMMON_STAGE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            Companion = new Companion(null);
        }
    }

    public QQLiveReminderApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.gson = new GsonBuilder().create();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showError() {
        QQToastUtil.showQQToast(R.string.f210915je);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSuccess() {
        QQToastUtil.showQQToast(R.string.f210925jf);
    }

    @Override // com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi
    @NotNull
    public Map<String, String> createReportParams(@NotNull QQLiveNoticeInfo noticeInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this, (Object) noticeInfo);
        }
        Intrinsics.checkNotNullParameter(noticeInfo, "noticeInfo");
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_anchor_id", String.valueOf(noticeInfo.getUid()));
        hashMap.put("qqlive_room_id", String.valueOf(noticeInfo.getRoomID()));
        String type = noticeInfo.getType();
        if (type == null) {
            type = "";
        }
        hashMap.put("qqlive_mindpush_reason", type);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "0";
        }
        hashMap.put(DTPublicParamKey.DT_QQ, str);
        return hashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            c.a().i(TAG, 1, "destroy");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi
    public boolean isQQLiveReminder(@Nullable String busId, @Nullable String msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) busId, (Object) msgId)).booleanValue();
        }
        if (!Intrinsics.areEqual("eead935d504f825c750d8de4571e4d57", msgId) && !Intrinsics.areEqual("26058236d7cf114e4dee3e5356e28799", msgId)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi
    @NotNull
    public QQLiveNoticeInfo parseQQLiveNoticeInfo(@Nullable String extendField) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQLiveNoticeInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) extendField);
        }
        if (!TextUtils.isEmpty(extendField)) {
            try {
                Object fromJson = this.gson.fromJson(extendField, (Class<Object>) QQLiveNoticeInfo.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(extendFiel\u2026veNoticeInfo::class.java)");
                return (QQLiveNoticeInfo) fromJson;
            } catch (JsonSyntaxException e16) {
                c.a().e(TAG, 1, QLog.getStackTraceString(e16));
            }
        }
        return new QQLiveNoticeInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi
    public void unsubscribeReminder(@NotNull ReminderInfo reminderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) reminderInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(reminderInfo, "reminderInfo");
        c.a().i(TAG, 1, "unsubscribeReminder," + reminderInfo.getAnchorId());
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveCancelAnchorNoticeRequest(reminderInfo.getAnchorId()), new Function1<QQLiveResponse<b>, Unit>() { // from class: com.tencent.mobileqq.qqlive.api.reminder.impl.QQLiveReminderApiImpl$unsubscribeReminder$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveReminderApiImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<b> response) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                b rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    if (rsp.f410860a != 0) {
                        c.a().e("QQLiveReminderApiImpl", "failed, result=" + rsp.f410860a);
                        QQLiveReminderApiImpl.this.showError();
                        return;
                    }
                    c.a().i("QQLiveReminderApiImpl", "success");
                    QQLiveReminderApiImpl.this.showSuccess();
                    return;
                }
                c.a().e("QQLiveReminderApiImpl", "failed, response=" + response);
                QQLiveReminderApiImpl.this.showError();
            }
        });
    }
}
