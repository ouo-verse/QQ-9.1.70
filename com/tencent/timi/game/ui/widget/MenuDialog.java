package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MenuDialog extends ReportDialog {
    private DialogInterface.OnClickListener C;
    private View D;
    private LinearLayout E;
    private View.OnClickListener F;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int intValue = ((Integer) view.getTag()).intValue();
            if (MenuDialog.this.C != null) {
                MenuDialog.this.C.onClick(MenuDialog.this, intValue);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MenuDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private Context f380096a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence[] f380097b;

        /* renamed from: c, reason: collision with root package name */
        private DialogInterface.OnClickListener f380098c;

        public c(Context context) {
            this.f380096a = context;
        }

        public MenuDialog a() {
            MenuDialog menuDialog = new MenuDialog(this.f380096a);
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f380096a).inflate(R.layout.htt, (ViewGroup) null);
            menuDialog.E = (LinearLayout) viewGroup.findViewById(R.id.epy);
            float f16 = this.f380096a.getResources().getDisplayMetrics().density;
            for (int i3 = 0; i3 < this.f380097b.length; i3++) {
                TextView textView = new TextView(this.f380096a);
                textView.setTextColor(-16777216);
                textView.setTextSize(1, 14.0f);
                int i16 = (int) (20.0f * f16);
                textView.setPadding(i16, 0, i16, 0);
                textView.setBackgroundResource(R.drawable.f162546lr1);
                textView.setGravity(17);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) (45.0f * f16));
                layoutParams.gravity = 17;
                menuDialog.E.addView(textView, layoutParams);
                textView.setTag(Integer.valueOf(i3));
                textView.setText(this.f380097b[i3]);
                textView.setOnClickListener(menuDialog.F);
            }
            menuDialog.C = this.f380098c;
            menuDialog.setContentView(viewGroup);
            return menuDialog;
        }

        public c b(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.f380097b = charSequenceArr;
            this.f380098c = onClickListener;
            return this;
        }
    }

    MenuDialog(@NonNull Context context) {
        super(context, R.style.au6);
        this.F = new a();
    }

    public void S(final float f16, final float f17) {
        show();
        this.E.setVisibility(4);
        com.tencent.timi.game.utils.w.c(new Runnable() { // from class: com.tencent.timi.game.ui.widget.MenuDialog.3
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = MenuDialog.this.E.getMeasuredWidth();
                int measuredHeight = MenuDialog.this.E.getMeasuredHeight();
                int screenWidth = ScreenUtils.getScreenWidth(MenuDialog.this.getContext());
                int screenHeight = ScreenUtils.getScreenHeight(MenuDialog.this.getContext());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MenuDialog.this.E.getLayoutParams();
                float f18 = measuredWidth;
                float f19 = 32;
                if ((f16 + f18) - f19 < screenWidth - 60) {
                    layoutParams.addRule(9, 1);
                    layoutParams.leftMargin = (int) Math.max(f16 - f19, 0.0f);
                    MenuDialog.this.E.setPivotX(0.0f);
                } else {
                    layoutParams.addRule(11, 1);
                    layoutParams.rightMargin = (int) Math.max((screenWidth - f16) - f19, 0.0f);
                    MenuDialog.this.E.setPivotX(f18);
                }
                float f26 = measuredHeight;
                float f27 = 25;
                if ((f17 + f26) - f27 < screenHeight - 100) {
                    layoutParams.addRule(10, 1);
                    layoutParams.topMargin = (int) Math.max(f17 - f27, 0.0f);
                    MenuDialog.this.E.setPivotY(0.0f);
                } else {
                    layoutParams.addRule(12, 1);
                    layoutParams.bottomMargin = (int) Math.max((screenHeight - f17) - 45, 0.0f);
                    MenuDialog.this.E.setPivotY(f26);
                }
                MenuDialog.this.E.setLayoutParams(layoutParams);
                MenuDialog.this.E.setVisibility(0);
                yn4.b.f(MenuDialog.this.E, 0.0f, 1.0f, 120L, null, false);
            }
        });
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog
    public void setContentView(@NonNull View view) {
        super.setContentView(view);
        this.D = view;
        view.setOnClickListener(new b());
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
    }
}
