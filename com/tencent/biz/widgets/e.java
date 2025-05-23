package com.tencent.biz.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends ReportDialog {
    private TextView C;
    private TextView D;
    private TextView E;
    private ImageView F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f97773d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f97773d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f97773d;
            if (onClickListener != null) {
                onClickListener.onClick(e.this, 0);
            }
            e.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f97775d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f97775d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f97775d;
            if (onClickListener != null) {
                onClickListener.onClick(e.this, 1);
            }
            e.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(Context context) {
        super(context, R.style.qZoneInputDialog);
        super.setContentView(R.layout.f168572ad0);
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        N();
    }

    public void N() {
        this.C = (TextView) super.findViewById(R.id.dialogLeftBtn);
        this.D = (TextView) super.findViewById(R.id.dialogRightBtn);
        this.E = (TextView) super.findViewById(R.id.f166983jo1);
        ImageView imageView = (ImageView) super.findViewById(R.id.f166984jo2);
        this.F = imageView;
        imageView.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
    }

    public void O(String str, DialogInterface.OnClickListener onClickListener) {
        this.C.setText(str);
        if (AppSetting.f99565y) {
            Resources resources = getContext().getResources();
            TextView textView = this.C;
            Object[] objArr = new Object[1];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            textView.setContentDescription(resources.getString(R.string.f170646xb, objArr));
        }
        this.C.setOnClickListener(new a(onClickListener));
    }

    public void P(DialogInterface.OnClickListener onClickListener) {
        if (AppSetting.f99565y) {
            Resources resources = getContext().getResources();
            this.D.setContentDescription(resources.getString(R.string.f170646xb, resources.getString(R.string.hii)));
        }
        this.D.setOnClickListener(new b(onClickListener));
    }

    public void Q(String str) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }
}
