package com.tencent.mobileqq.vas.gift;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.BalanceExplainDialogData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BalanceExplainDialogHelper {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements DialogUtil.IDialogView {
        a() {
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.IDialogView
        public View getView(Context context, Object obj) {
            BalanceExplainDialogView balanceExplainDialogView = new BalanceExplainDialogView(context);
            if (obj != null) {
                balanceExplainDialogView.b((BalanceExplainDialogData) obj);
            }
            return balanceExplainDialogView;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f309261d;

        b(Dialog dialog) {
            this.f309261d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f309261d.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            BalanceExplainDialogHelper.f(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, DialogInterface.OnClickListener onClickListener) {
        QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(context, 230, context.getString(R.string.f237557hd), context.getString(R.string.f237547hc), context.getString(R.string.f237537hb), false, context.getString(R.string.f170647xd), context.getString(R.string.f237567he), new c(), onClickListener, new d());
        LinearLayout linearLayout = (LinearLayout) createDialogWithCheckBox.findViewById(R.id.e2z);
        if (linearLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).gravity = 3;
        }
        TextView textView = (TextView) createDialogWithCheckBox.findViewById(R.id.dialogRightBtn);
        TextView textView2 = (TextView) createDialogWithCheckBox.findViewById(R.id.dialogLeftBtn);
        TextView textView3 = (TextView) createDialogWithCheckBox.findViewById(R.id.dialogTitle);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView3.setTypeface(Typeface.DEFAULT_BOLD);
        createDialogWithCheckBox.show();
    }

    private static void d(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        TextView textView = (TextView) dialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            textView.setTextColor(-1);
        }
        TextView textView2 = (TextView) dialog.findViewById(R.id.zta);
        if (textView2 != null) {
            textView2.setTextColor(-1);
        }
        TextView textView3 = (TextView) dialog.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setTextColor(-1);
        }
    }

    public static boolean e() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e("BalanceExplainDialogHelper", 1, "isNotEnoughHasShowedFlagInSp error, app is null");
            return false;
        }
        String account = waitAppRuntime.getAccount();
        if (TextUtils.isEmpty(account)) {
            return false;
        }
        return BaseApplication.getContext().getSharedPreferences("BalanceExplainDialog", 0).getBoolean("notEnoughExplainCheckState" + account, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.BalanceExplainDialogHelper.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                    if (waitAppRuntime == null) {
                        QLog.e("BalanceExplainDialogHelper", 1, "saveCheckStateToSp error, app is null");
                        return;
                    }
                    String account = waitAppRuntime.getAccount();
                    if (!TextUtils.isEmpty(account)) {
                        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("BalanceExplainDialog", 0).edit();
                        edit.putBoolean("notEnoughExplainCheckState" + account, z16);
                        edit.apply();
                        return;
                    }
                    QLog.e("BalanceExplainDialogHelper", 1, "saveCheckStateToSp  error, uinStr is empty");
                } catch (Exception e16) {
                    QLog.e("BalanceExplainDialogHelper", 1, "saveCheckStateToSp  error:", e16);
                }
            }
        }, 64, null, false);
    }

    public static void g(Context context, BalanceExplainDialogData balanceExplainDialogData) {
        Dialog createCustomViewDialog = DialogUtil.createCustomViewDialog(context, R.string.f237577hf, new a(), balanceExplainDialogData, R.string.f1380608j, R.string.f1380608j, null, null, false, false);
        View findViewById = createCustomViewDialog.findViewById(R.id.bjj);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = -1;
        findViewById.setLayoutParams(layoutParams);
        TextView textView = (TextView) createCustomViewDialog.findViewById(R.id.dialogRightBtn);
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) createCustomViewDialog.findViewById(R.id.dialogLeftBtn);
        if (textView2 != null) {
            textView2.setOnClickListener(new b(createCustomViewDialog));
        }
        if (QQTheme.isNowThemeIsNight()) {
            d(createCustomViewDialog);
        }
        if (context.getResources().getConfiguration().orientation == 2) {
            TextView textView3 = (TextView) createCustomViewDialog.findViewById(R.id.zta);
            textView3.setMaxHeight((x.f(context).f185861b - x.c(context, 287.0f)) - x.c(context, 58.0f));
            textView3.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        URLDrawable drawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone_vip_icon/gift_marketing_coin_notice_BG.png", (URLDrawable.URLDrawableOptions) null);
        if (drawable != null) {
            createCustomViewDialog.findViewById(R.id.ztb).setBackground(drawable);
        }
        createCustomViewDialog.show();
    }

    public static void h(final Context context, final DialogInterface.OnClickListener onClickListener, final Runnable runnable) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.BalanceExplainDialogHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BalanceExplainDialogHelper.e()) {
                    ThreadManagerV2.getUIHandlerV2().post(runnable);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.BalanceExplainDialogHelper.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            BalanceExplainDialogHelper.c(context, onClickListener);
                        }
                    });
                }
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
