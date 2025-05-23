package com.tencent.mobileqq.activity.activateFriend.qqlive;

import Wallet.AcsMsg;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage;
import com.tencent.mobileqq.activity.activateFriend.ai;
import com.tencent.mobileqq.activity.activateFriend.y;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.reminder.IQQLiveReminderApi;
import com.tencent.mobileqq.qqlive.api.reminder.QQLiveNoticeInfo;
import com.tencent.mobileqq.qqlive.api.reminder.ReminderInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/activity/activateFriend/qqlive/QQLiveReminderCardItemPage;", "Lcom/tencent/mobileqq/activity/activateFriend/ReminderCardItemPage;", "", HippyTKDListViewAdapter.X, "", "rejectType", "w", "", "anchorId", "y", "p", "destroy", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Req, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QQAppInterface;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;)V", "T", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class QQLiveReminderCardItemPage extends ReminderCardItemPage {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a T;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final QQAppInterface app;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/activateFriend/qqlive/QQLiveReminderCardItemPage$a;", "", "", "COLOR_BLACK", "Ljava/lang/String;", "REJECT_TYPE_ANCHOR", "REJECT_TYPE_BIZ", "REJECT_TYPE_CANCEL", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            T = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveReminderCardItemPage(@NotNull Context context, @NotNull QQAppInterface app) {
        super(context, app);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) app);
        } else {
            this.activity = (Activity) context;
            this.app = app;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ActionSheet unsubscribeOptionsSheet, QQLiveReminderCardItemPage this$0, QQLiveNoticeInfo qQLiveNoticeInfo, View view, int i3) {
        Intrinsics.checkNotNullParameter(unsubscribeOptionsSheet, "$unsubscribeOptionsSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 != 1) {
                unsubscribeOptionsSheet.dismiss();
                return;
            }
            unsubscribeOptionsSheet.dismiss();
            super.p();
            this$0.w("1");
            return;
        }
        unsubscribeOptionsSheet.dismiss();
        this$0.y(qQLiveNoticeInfo.getUid());
        this$0.w("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ActionSheet unsubscribeOptionsSheet, QQLiveReminderCardItemPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(unsubscribeOptionsSheet, "$unsubscribeOptionsSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        unsubscribeOptionsSheet.dismiss();
        this$0.w("2");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(String rejectType) {
        Map mutableMap;
        QQAppInterface qQAppInterface = this.app;
        AcsMsg acsMsg = this.P;
        String str = acsMsg.busi_id;
        String str2 = acsMsg.msg_id;
        String str3 = acsMsg.mn_reserved;
        mutableMap = MapsKt__MapsKt.toMutableMap(ai.a(acsMsg));
        mutableMap.put("qqlive_mindpush_reject_type", rejectType);
        Unit unit = Unit.INSTANCE;
        y.c(qQAppInterface, "remind_qqlive_rejectbutton_click", str, str2, null, str3, mutableMap);
    }

    private final void x() {
        QQAppInterface qQAppInterface = this.app;
        AcsMsg acsMsg = this.P;
        y.c(qQAppInterface, "remind_qqlive_rejectpage_exp", acsMsg.busi_id, acsMsg.msg_id, null, acsMsg.mn_reserved, ai.a(acsMsg));
    }

    private final void y(long anchorId) {
        ((IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class)).unsubscribeReminder(new ReminderInfo(anchorId));
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.destroy();
            ((IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class)).destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    @Override // com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        final QQLiveNoticeInfo qQLiveNoticeInfo = new QQLiveNoticeInfo();
        if (!TextUtils.isEmpty(this.P.extend_field)) {
            QLog.i("QQLiveReminderCardItemPage", 1, "has extend field");
            qQLiveNoticeInfo = ((IQQLiveReminderApi) QRoute.api(IQQLiveReminderApi.class)).parseQQLiveNoticeInfo(this.P.extend_field);
            if (qQLiveNoticeInfo != null && qQLiveNoticeInfo.getUid() > 0) {
                z16 = true;
                if (z16) {
                    super.p();
                    return;
                }
                Dialog createDialog = ActionSheetHelper.createDialog(this.activity, null);
                Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
                final ActionSheet actionSheet = (ActionSheet) createDialog;
                actionSheet.setMainTitle(R.string.f2038651c);
                Activity activity = this.activity;
                Intrinsics.checkNotNull(qQLiveNoticeInfo);
                actionSheet.addRadioButton((CharSequence) activity.getString(R.string.f2038451a, qQLiveNoticeInfo.getNick()), false);
                actionSheet.addRadioButton(R.string.f2038551b, false);
                actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.activateFriend.qqlive.a
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        QQLiveReminderCardItemPage.u(ActionSheet.this, this, qQLiveNoticeInfo, view, i3);
                    }
                });
                actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.activateFriend.qqlive.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QQLiveReminderCardItemPage.v(ActionSheet.this, this, view);
                    }
                });
                actionSheet.addCancelButton(R.string.f2038351_);
                actionSheet.preInitView();
                actionSheet.setTitleWithColor(this.activity.getString(R.string.f2038651c), "#000000");
                actionSheet.show();
                x();
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
