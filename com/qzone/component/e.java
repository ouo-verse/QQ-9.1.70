package com.qzone.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f46683a;

    /* renamed from: b, reason: collision with root package name */
    String f46684b = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleCancelConcern", "\u786e\u8ba4\u4e0d\u518d\u5173\u6ce8\uff1f");

    /* renamed from: c, reason: collision with root package name */
    String f46685c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancelConcern", "\u4e0d\u518d\u5173\u6ce8");

    /* renamed from: d, reason: collision with root package name */
    String f46686d = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleSpecialCancelConcern", "\u786e\u8ba4\u4e0d\u518d\u7279\u522b\u5173\u6ce8\uff1f");

    /* renamed from: e, reason: collision with root package name */
    String f46687e = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancelSpecialConcern", "\u4e0d\u518d\u7279\u522b\u5173\u6ce8");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46688d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f46688d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (e.this.f46683a) {
                return;
            }
            e.this.f46683a = true;
            DialogInterface.OnClickListener onClickListener = this.f46688d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46690d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f46690d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener = this.f46690d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46692d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f46692d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (e.this.f46683a) {
                return;
            }
            e.this.f46683a = true;
            DialogInterface.OnClickListener onClickListener = this.f46692d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46694d;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f46694d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener = this.f46694d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.component.e$e, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class DialogInterfaceOnClickListenerC0379e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46696d;

        DialogInterfaceOnClickListenerC0379e(DialogInterface.OnClickListener onClickListener) {
            this.f46696d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (e.this.f46683a) {
                return;
            }
            e.this.f46683a = true;
            DialogInterface.OnClickListener onClickListener = this.f46696d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46698d;

        f(DialogInterface.OnClickListener onClickListener) {
            this.f46698d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener = this.f46698d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f46700d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f46701e;

        g(DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog) {
            this.f46700d = onClickListener;
            this.f46701e = qQCustomDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f46700d;
            if (onClickListener != null) {
                onClickListener.onClick(this.f46701e, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e() {
        this.f46683a = false;
        this.f46683a = false;
    }

    public static QQCustomDialog i(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        TextView titleTextView = createCustomDialog.getTitleTextView();
        if (titleTextView != null) {
            titleTextView.setVisibility(8);
        }
        createCustomDialog.setMessage(l.a(R.string.f2200167z));
        createCustomDialog.setMessageTextSize(17.0f);
        createCustomDialog.setPositiveButton(l.a(R.string.f22003681), onClickListener);
        if (QQTheme.isNowThemeIsNightForQzone()) {
            c(createCustomDialog);
        }
        TextView btnLeft = createCustomDialog.getBtnLeft();
        if (btnLeft == null) {
            return createCustomDialog;
        }
        String a16 = l.a(R.string.f22002680);
        btnLeft.setText(a16);
        btnLeft.setContentDescription(a16 + l.a(R.string.a_n));
        btnLeft.setVisibility(0);
        btnLeft.setOnClickListener(new g(onClickListener2, createCustomDialog));
        return createCustomDialog;
    }

    public void g(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        f(context, 230, str, str2, context.getResources().getString(R.string.a8j), context.getResources().getString(R.string.f170647xd), onClickListener, onClickListener2);
    }

    public void j(Context context, DialogInterface.OnClickListener onClickListener) {
        f(context, 230, this.f46684b, "", this.f46685c, l.a(R.string.j6l), onClickListener, null);
    }

    public void k(Context context, DialogInterface.OnClickListener onClickListener) {
        f(context, 230, this.f46686d, "", this.f46687e, l.a(R.string.j6l), onClickListener, null);
    }

    public QQCustomDialog d(Context context, int i3, int i16, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        DialogInterfaceOnClickListenerC0379e dialogInterfaceOnClickListenerC0379e;
        f fVar;
        DialogInterfaceOnClickListenerC0379e dialogInterfaceOnClickListenerC0379e2 = new DialogInterfaceOnClickListenerC0379e(onClickListener);
        f fVar2 = new f(onClickListener2);
        if (i3 == 232) {
            dialogInterfaceOnClickListenerC0379e = dialogInterfaceOnClickListenerC0379e2;
            fVar = null;
        } else if (i3 != 233) {
            dialogInterfaceOnClickListenerC0379e = dialogInterfaceOnClickListenerC0379e2;
            fVar = fVar2;
        } else {
            fVar = fVar2;
            dialogInterfaceOnClickListenerC0379e = null;
        }
        try {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, i16, str, str2, str4, str3, dialogInterfaceOnClickListenerC0379e, fVar);
            createCustomDialog.show();
            this.f46683a = false;
            return createCustomDialog;
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    public QQCustomDialog e(Context context, int i3, String str, String str2, String str3, int i16, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        c cVar;
        d dVar;
        c cVar2 = new c(onClickListener);
        d dVar2 = new d(onClickListener2);
        if (i3 == 232) {
            cVar = cVar2;
            dVar = null;
        } else if (i3 != 233) {
            cVar = cVar2;
            dVar = dVar2;
        } else {
            dVar = dVar2;
            cVar = null;
        }
        try {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, str, str2, str4, str3, i16, cVar, dVar);
            createCustomDialog.show();
            this.f46683a = false;
            return createCustomDialog;
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    public QQCustomDialog f(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        a aVar;
        b bVar;
        a aVar2 = new a(onClickListener);
        b bVar2 = new b(onClickListener2);
        if (i3 == 232) {
            aVar = aVar2;
            bVar = null;
        } else if (i3 != 233) {
            aVar = aVar2;
            bVar = bVar2;
        } else {
            bVar = bVar2;
            aVar = null;
        }
        try {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, str, str2, str4, str3, aVar, bVar);
            createCustomDialog.show();
            this.f46683a = false;
            return createCustomDialog;
        } catch (Exception e16) {
            QZLog.w(e16);
            return null;
        }
    }

    private static void c(QQCustomDialog qQCustomDialog) {
        if (qQCustomDialog == null) {
            return;
        }
        qQCustomDialog.setBackground(R.drawable.lcz);
        qQCustomDialog.setMessageTextColor(R.color.a_x);
        ColorStateList colorStateList = BaseApplication.getContext().getResources().getColorStateList(R.color.a_x);
        if (qQCustomDialog.getBtnLeft() != null) {
            qQCustomDialog.getBtnLeft().setTextColor(colorStateList);
        }
        if (qQCustomDialog.getBtnight() != null) {
            qQCustomDialog.getBtnight().setTextColor(colorStateList);
        }
        if (qQCustomDialog.getDialogDivider() != null) {
            qQCustomDialog.getDialogDivider().setBackgroundColor(Color.parseColor("#999999"));
        }
    }

    public void h(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog f16 = f(context, 230, str, str2, str3, str4, onClickListener, onClickListener2);
        TextView titleTextView = f16.getTitleTextView();
        if (titleTextView != null) {
            titleTextView.setSingleLine(false);
        }
        TextView messageTextView = f16.getMessageTextView();
        if (messageTextView != null) {
            messageTextView.setSingleLine(false);
        }
    }
}
