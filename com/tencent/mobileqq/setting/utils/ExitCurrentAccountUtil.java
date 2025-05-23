package com.tencent.mobileqq.setting.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.login.bq;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\n\u001a\u00020\t2#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u001b\u0010\u0018\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/ExitCurrentAccountUtil;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/data/Card;", "Lkotlin/ParameterName;", "name", IndividuationUrlHelper.UrlId.CARD_HOME, "", "callback", "", "i", "Landroid/content/Context;", "context", ReportConstant.COSTREPORT_PREFIX, "u", "p", "Landroid/content/DialogInterface$OnClickListener;", "l", "k", DomainData.DOMAIN_NAME, "b", "Lkotlin/Lazy;", "o", "()Z", "isBugfixSwitchOn", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExitCurrentAccountUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ExitCurrentAccountUtil f286732a = new ExitCurrentAccountUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy isBugfixSwitchOn;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.setting.utils.ExitCurrentAccountUtil$isBugfixSwitchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("setting_exit_current_account_set_unread", true);
                QLog.i("ExitCurrentAccountProcessor", 1, "switch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        isBugfixSwitchOn = lazy;
    }

    ExitCurrentAccountUtil() {
    }

    private final void i(final Function1<? super Card, Boolean> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                ExitCurrentAccountUtil.j(Function1.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 callback) {
        FriendsManager friendsManager;
        Card r16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            try {
                friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ExitCurrentAccountProcessor", 1, "asyncGetCard error : " + e16);
            }
            if (friendsManager != null) {
                r16 = friendsManager.r(peekAppRuntime.getCurrentAccountUin());
                callback.invoke(r16);
            }
        }
        r16 = null;
        callback.invoke(r16);
    }

    private final boolean k(Context context) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || !(context instanceof Activity) || !bq.a(appInterface, (Activity) context)) {
            return true;
        }
        QLog.i("ExitCurrentAccountProcessor", 1, "checkHasSetPwd: return false");
        return false;
    }

    private final DialogInterface.OnClickListener l(final Context context) {
        return new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.utils.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ExitCurrentAccountUtil.m(context, dialogInterface, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Context context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.flushLog();
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
        boolean checkBoxState = qQCustomDialog.getCheckBoxState();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime);
        SettingCloneUtil.writeValue(context, peekAppRuntime.getCurrentAccountUin(), context.getString(R.string.receive_msg_whenexit), AppConstants.QQSETTING_RECEIVEMSG_WHENEXIST_KEY, checkBoxState);
        com.tencent.common.a.c(context, checkBoxState);
        if (peekAppRuntime instanceof QQAppInterface) {
            if (!f286732a.o()) {
                QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
                com.tencent.qqconnect.wtlogin.c.d(context, qQAppInterface.getMessageFacade().H1() + qQAppInterface.getCallFacade().v());
            }
            ((QQAppInterface) peekAppRuntime).bReceiveMsgOnExit = checkBoxState;
            MainFragment.C0 = true;
        }
        qQCustomDialog.dismiss();
        if (QQPlayerService.s0()) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            context.sendBroadcast(intent);
        }
        PatternLockUtils.setFirstEnterAfterLoginState(context, peekAppRuntime.getCurrentAccountUin(), true);
        Intent intent2 = new Intent("QQ_ACTION_MENU_QUIT");
        intent2.setComponent(SplashActivity.getAliasComponent(context));
        intent2.addFlags(67108864);
        try {
            context.startActivity(intent2);
        } catch (Exception unused) {
        }
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X800932A", "0X800932A", 0, 0, "0", "", "", "");
    }

    private final boolean o() {
        return ((Boolean) isBugfixSwitchOn.getValue()).booleanValue();
    }

    private final void p(Context context) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.y(peekAppRuntime, "0X800B83D");
        String string = context.getString(R.string.receive_msg_whenexit);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.receive_msg_whenexit)");
        Intrinsics.checkNotNull(peekAppRuntime);
        boolean isContainValue = SettingCloneUtil.isContainValue(context, peekAppRuntime.getCurrentAccountUin(), string, AppConstants.QQSETTING_RECEIVEMSG_WHENEXIST_KEY);
        boolean readValue = SettingCloneUtil.readValue(context, peekAppRuntime.getCurrentAccountUin(), string, AppConstants.QQSETTING_RECEIVEMSG_WHENEXIST_KEY, true);
        if (QLog.isDevelopLevel()) {
            QLog.d("ExitCurrentAccountProcessor", 4, "init CheckBox:receiveMsgWhenExitPerfExist:" + isContainValue + ", bReceiveMsgOnExit:" + readValue);
        }
        if (isContainValue && readValue) {
            DialogUtil.createCustomDialog(context, 230, HardCodeUtil.qqStr(R.string.yva), "", HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.yv_), l(context), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.utils.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ExitCurrentAccountUtil.q(dialogInterface, i3);
                }
            }).show();
        } else {
            DialogUtil.createDialogWithCheckBox(context, 230, HardCodeUtil.qqStr(R.string.yva), null, HardCodeUtil.qqStr(R.string.yvb), readValue, HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.yv_), null, l(context), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.utils.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ExitCurrentAccountUtil.r(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void s(final Context context) {
        final ActionSheet create = ActionSheet.create(context);
        create.addButton(new ActionMenuItem(context.getString(R.string.yv8), 1, 0), 0);
        create.addButton(new ActionMenuItem(context.getString(R.string.yv9), 2, 0), 0);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.setting.utils.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ExitCurrentAccountUtil.t(ActionSheet.this, context, view, i3);
            }
        });
        create.addCancelButton(context.getString(R.string.cancel));
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ActionSheet actionSheet, Context context, View view, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        actionSheet.dismiss();
        ActionMenuItem actionMenuItem = actionSheet.getActionMenuItem(i3);
        if (actionMenuItem == null) {
            return;
        }
        int i16 = actionMenuItem.action;
        if (i16 == 1) {
            f286732a.i(new ExitCurrentAccountUtil$showLogoutActionSheet$1$1(context));
        } else {
            if (i16 != 2) {
                return;
            }
            f286732a.p(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final Context context, Card card) {
        String format;
        if (k(context)) {
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (card != null) {
                long j3 = card.lQQMasterLogindays;
                if (j3 > 0) {
                    QQDarenUtils.sQQDarenLoginDays = j3;
                } else {
                    QQDarenUtils.sQQDarenLoginDays = 30L;
                }
                long j16 = card.lLoginDays;
                if (j16 == 1 || (j16 > 1 && j16 < QQDarenUtils.sQQDarenLoginDays)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = context.getString(R.string.c6q);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026t_prompt_content_notxman)");
                    format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf((int) (QQDarenUtils.sQQDarenLoginDays - card.lLoginDays))}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else if (j16 >= QQDarenUtils.sQQDarenLoginDays) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string2 = context.getString(R.string.c6r);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026exit_prompt_content_xman)");
                    format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf((int) card.lLoginDays)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String string3 = context.getString(R.string.c6s);
                    Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ut_exit_prompt_exception)");
                    format = String.format(string3, Arrays.copyOf(new Object[0], 0));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
            } else {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String string4 = context.getString(R.string.c6s);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026ut_exit_prompt_exception)");
                format = String.format(string4, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
            createCustomDialog.setMessage(format);
            createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.utils.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ExitCurrentAccountUtil.v(AppRuntime.this, dialogInterface, i3);
                }
            });
            createCustomDialog.setPositiveButton(R.string.c6p, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.utils.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ExitCurrentAccountUtil.w(AppRuntime.this, context, dialogInterface, i3);
                }
            });
            createCustomDialog.show();
            ReportController.y(peekAppRuntime, "0X800B83C");
            ReportController.y(peekAppRuntime, "0X800C61F");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AppRuntime appRuntime, DialogInterface dialogInterface, int i3) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e16) {
            QLog.e("ExitCurrentAccountProcessor", 1, "showLogoutDialog error: " + e16);
        }
        ReportController.o(appRuntime, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AppRuntime appRuntime, Context context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        ReportController.o(appRuntime, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
        ReportController.y(appRuntime, "0X800C628");
        Intrinsics.checkNotNull(appRuntime);
        if (SettingCloneUtil.readValue((Context) appRuntime.getApplication(), appRuntime.getAccount(), (String) null, AppConstants.PCACTIVE_CONFIG, false)) {
            appRuntime.startPCActivePolling(appRuntime.getAccount(), "logout");
        }
        if (context instanceof Activity) {
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).logout((Activity) context, true);
        }
    }

    public final void n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
