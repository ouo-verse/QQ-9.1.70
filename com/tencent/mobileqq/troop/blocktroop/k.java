package com.tencent.mobileqq.troop.blocktroop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.blocktroop.k;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.widget.ActionSheet;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void onCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(QQCustomDialog qQCustomDialog, String str, DialogInterface dialogInterface, int i3) {
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).goToAppealForTempBlock(qQCustomDialog.getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(ActionSheet.OnButtonClickListener onButtonClickListener, ActionSheet actionSheet, View view, int i3) {
        onButtonClickListener.onClick(view, i3);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(a aVar, DialogInterface dialogInterface) {
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(AppInterface appInterface, String str) {
        if (NetworkUtil.isNetSupport(appInterface.getApp().getApplicationContext())) {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).quitGroup(str, false, null, "TroopBlockUtils", null);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.b1a), 0).show();
        }
    }

    private static void E(Context context, int i3, int i16, final ActionSheet.OnButtonClickListener onButtonClickListener, @Nullable final a aVar) {
        final ActionSheet create = ActionSheet.create(context);
        create.setMainTitle(context.getString(i3));
        create.addButton(context.getString(i16), 3);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.i
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i17) {
                k.B(ActionSheet.OnButtonClickListener.this, create, view, i17);
            }
        });
        create.addCancelButton(context.getString(R.string.cancel));
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.troop.blocktroop.j
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                k.C(k.a.this, dialogInterface);
            }
        });
        create.show();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(10:5|(1:7)|8|9|(1:31)(1:12)|(1:(1:15)(1:27))(1:(1:29)(1:30))|16|17|(1:19)|21)(1:32))(1:34)|33|9|(0)|31|(0)(0)|16|17|(0)|21) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0119, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x011e, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0120, code lost:
    
        com.tencent.qphone.base.util.QLog.e("TroopBlockUtils", 2, "showConstantBlockDialog exception: " + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0115 A[Catch: Exception -> 0x0119, TRY_LEAVE, TryCatch #0 {Exception -> 0x0119, blocks: (B:17:0x010f, B:19:0x0115), top: B:16:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QQCustomDialog F(Activity activity, AppInterface appInterface, String str, @Nullable a aVar) {
        boolean z16;
        boolean z17;
        TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        boolean z18 = true;
        if (troopManager != null) {
            TroopInfo k3 = troopManager.k(str);
            if (k3 != null) {
                z16 = k3.isOwner();
                z17 = k3.isAdmin();
                if (System.currentTimeMillis() >= k3.getBlockExpireTime() * 1000) {
                    z18 = false;
                }
                QLog.d("TroopBlockUtils", 2, "[showConstantBlockDialog] isOwner = " + z16 + ", isAdmin = " + z17 + " troopUin: " + str + ", isTempBlock = " + z18);
                QQCustomDialog title = DialogUtil.createCustomDialog(activity, 230).setTitle(activity.getString(R.string.f180013_x));
                title.setCancelable(false);
                k(title, aVar);
                if (z16 && !z17) {
                    ReportController.o(null, "dc00898", "", "", "0X800B225", "0X800B225", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X800B222", "0X800B222", 0, 0, "", "", "", "");
                }
                if (!z18) {
                    if (z16) {
                        q(title, str);
                    } else {
                        p(title, activity, appInterface, str, aVar);
                    }
                } else if (z16) {
                    o(title, activity, appInterface, str, aVar);
                } else {
                    n(title, activity, appInterface, str, aVar);
                }
                if (!activity.isFinishing()) {
                    title.show();
                }
                return title;
            }
            QLog.i("TroopBlockUtils", 1, "[showConstantBlockDialog] troopInfo is NULL! troopUin: " + str);
        } else {
            QLog.i("TroopBlockUtils", 1, "[showConstantBlockDialog] troopManager is NULL! troopUin: " + str);
        }
        z18 = false;
        z16 = false;
        z17 = false;
        QQCustomDialog title2 = DialogUtil.createCustomDialog(activity, 230).setTitle(activity.getString(R.string.f180013_x));
        title2.setCancelable(false);
        k(title2, aVar);
        if (z16) {
        }
        ReportController.o(null, "dc00898", "", "", "0X800B222", "0X800B222", 0, 0, "", "", "", "");
        if (!z18) {
        }
        if (!activity.isFinishing()) {
        }
        return title2;
    }

    public static void G(View view, int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.j1v);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.dwd);
        if (imageView != null) {
            if (i3 == 1) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
                    if (r(qQAppInterface, str)) {
                        imageView.setImageResource(R.drawable.ob8);
                        imageView.setVisibility(0);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            if (i16 == 2) {
                                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = -ViewUtils.dpToPx(6.0f);
                            } else {
                                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = -ViewUtils.dpToPx(3.0f);
                            }
                            ((RelativeLayout.LayoutParams) layoutParams).rightMargin = -ViewUtils.dpToPx(3.0f);
                        }
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                            if (SimpleUIUtil.getSimpleUISwitch()) {
                                imageView2.setBackgroundResource(R.drawable.k_o);
                                return;
                            } else {
                                imageView2.setBackgroundResource(R.drawable.f161422x6);
                                return;
                            }
                        }
                        return;
                    }
                    imageView.setVisibility(8);
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                        return;
                    }
                    return;
                }
                imageView.setVisibility(8);
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    return;
                }
                return;
            }
            imageView.setVisibility(8);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
    }

    private static void k(QQCustomDialog qQCustomDialog, @Nullable final a aVar) {
        String string = qQCustomDialog.getContext().getString(R.string.f179973_t);
        qQCustomDialog.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.t(k.a.this, dialogInterface, i3);
            }
        });
        qQCustomDialog.setPositiveButtonContentDescription(string);
    }

    public static boolean l(Activity activity, AppInterface appInterface, Intent intent) {
        String stringExtra = intent.getStringExtra("uin");
        if (intent.getIntExtra("uintype", -1) == 1 && stringExtra != null) {
            QLog.i("TroopBlockUtils", 1, "[checkBlockTroopBeforeEnterAio] troopUin: " + stringExtra);
            if (r(appInterface, stringExtra)) {
                if (activity instanceof ChatActivity) {
                    Activity topActivity = Foreground.getTopActivity();
                    if (topActivity != null && topActivity != activity) {
                        activity.finish();
                        F(topActivity, appInterface, stringExtra, null);
                    } else {
                        F(activity, appInterface, stringExtra, null);
                    }
                } else {
                    F(activity, appInterface, stringExtra, null);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(AppInterface appInterface, String str) {
        if (NetworkUtil.isNetSupport(appInterface.getApp().getApplicationContext())) {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).destroyGroup(str, false, null, "TroopBlockUtils", null);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.b1a), 0).show();
        }
    }

    private static void n(final QQCustomDialog qQCustomDialog, final Activity activity, final AppInterface appInterface, final String str, @Nullable final a aVar) {
        String string = qQCustomDialog.getContext().getString(R.string.f179943_q);
        qQCustomDialog.setMessage(qQCustomDialog.getContext().getString(R.string.f179983_u));
        qQCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.v(QQCustomDialog.this, activity, appInterface, str, aVar, dialogInterface, i3);
            }
        });
        qQCustomDialog.setNegativeButtonContentDescription(string);
    }

    private static void o(final QQCustomDialog qQCustomDialog, final Activity activity, final AppInterface appInterface, final String str, @Nullable final a aVar) {
        String string = qQCustomDialog.getContext().getString(R.string.f179953_r);
        qQCustomDialog.setMessage(qQCustomDialog.getContext().getString(R.string.f179983_u));
        qQCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.x(QQCustomDialog.this, activity, appInterface, str, aVar, dialogInterface, i3);
            }
        });
        qQCustomDialog.setNegativeButtonContentDescription(string);
    }

    private static void p(final QQCustomDialog qQCustomDialog, final Activity activity, final AppInterface appInterface, final String str, @Nullable final a aVar) {
        String string = qQCustomDialog.getContext().getString(R.string.f179943_q);
        qQCustomDialog.setMessage(qQCustomDialog.getContext().getString(R.string.f179993_v));
        qQCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.z(QQCustomDialog.this, activity, appInterface, str, aVar, dialogInterface, i3);
            }
        });
        qQCustomDialog.setNegativeButtonContentDescription(string);
    }

    private static void q(final QQCustomDialog qQCustomDialog, final String str) {
        String string = qQCustomDialog.getContext().getString(R.string.f179963_s);
        qQCustomDialog.setMessage(qQCustomDialog.getContext().getString(R.string.f180003_w));
        qQCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.A(QQCustomDialog.this, str, dialogInterface, i3);
            }
        });
        qQCustomDialog.setNegativeButtonContentDescription(string);
    }

    public static boolean r(AppInterface appInterface, String str) {
        TroopInfo k3;
        TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(str)) != null) {
            return k3.isUnreadableBlock();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUtils", 2, "isConstantBlockTroop. TroopManager is null. isConstantBlockTroop = false");
            return false;
        }
        return false;
    }

    public static boolean s(QQAppInterface qQAppInterface, String str) {
        TroopInfo m3;
        TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager == null || (m3 = troopManager.m(str, false, false)) == null) {
            return false;
        }
        return m3.isTroopBlocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(a aVar, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(QQCustomDialog qQCustomDialog, Activity activity, final AppInterface appInterface, final String str, a aVar, DialogInterface dialogInterface, int i3) {
        qQCustomDialog.dismiss();
        E(activity, R.string.f179923_o, R.string.f181063cr, new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                k.D(AppInterface.this, str);
            }
        }, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(QQCustomDialog qQCustomDialog, Activity activity, final AppInterface appInterface, final String str, a aVar, DialogInterface dialogInterface, int i3) {
        qQCustomDialog.dismiss();
        E(activity, R.string.f179913_n, R.string.f180043a0, new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                k.m(AppInterface.this, str);
            }
        }, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(QQCustomDialog qQCustomDialog, Activity activity, final AppInterface appInterface, final String str, a aVar, DialogInterface dialogInterface, int i3) {
        qQCustomDialog.dismiss();
        E(activity, R.string.f179933_p, R.string.f181063cr, new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.blocktroop.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                k.D(AppInterface.this, str);
            }
        }, aVar);
    }
}
