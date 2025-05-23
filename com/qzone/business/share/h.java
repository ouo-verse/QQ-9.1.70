package com.qzone.business.share;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends ReportDialog {
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44801d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f44801d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44801d;
            if (onClickListener != null) {
                onClickListener.onClick(h.this, -2);
            }
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44803d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f44803d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44803d;
            if (onClickListener != null) {
                onClickListener.onClick(h.this, -1);
            }
            h.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public void N(String str, DialogInterface.OnClickListener onClickListener) {
        this.C.setText(str);
        Resources resources = getContext().getResources();
        TextView textView = this.C;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        textView.setContentDescription(resources.getString(R.string.f170646xb, objArr));
        this.C.setOnClickListener(new a(onClickListener));
    }

    public void O(String str, DialogInterface.OnClickListener onClickListener) {
        this.D.setText(str);
        Resources resources = getContext().getResources();
        TextView textView = this.D;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        textView.setContentDescription(resources.getString(R.string.f170646xb, objArr));
        this.D.setOnClickListener(new b(onClickListener));
    }

    public void P(String str) {
        if (TextUtils.isEmpty(str)) {
            this.F.setVisibility(8);
            return;
        }
        this.F.setText(str);
        this.F.setContentDescription(str);
        this.F.setVisibility(0);
    }

    public void Q(Context context, int i3, int i16) {
        try {
            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(i3);
            if (drawable != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ard);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.E.setCompoundDrawables(drawable, null, null, null);
            }
        } catch (Resources.NotFoundException e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "ShareQzoneFeedResultDialog setResultTitle NotFoundException: " + e16.getMessage());
        }
        String string = context.getString(i16);
        this.E.setText(string);
        this.E.setContentDescription(string);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public h(Context context) {
        super(context, R.style.qZoneInputDialog);
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        setContentView(R.layout.br8);
        this.E = (TextView) findViewById(R.id.i8r);
        this.F = (TextView) findViewById(R.id.i8q);
        this.C = (TextView) findViewById(R.id.big);
        this.D = (TextView) findViewById(R.id.bih);
    }
}
