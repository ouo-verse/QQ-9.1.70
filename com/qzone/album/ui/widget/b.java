package com.qzone.album.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends ReportDialog {
    TextView C;
    TextView D;
    TextView E;
    CornerImageView F;
    TextView G;
    View H;
    ImageView I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44289d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f44289d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44289d;
            if (onClickListener != null) {
                onClickListener.onClick(b.this, 0);
            }
            try {
                if (b.this.isShowing()) {
                    b.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(Context context, int i3) {
        super(context, i3);
    }

    public void N(String str) {
        this.E.setText(str);
        this.E.setContentDescription(str);
        this.E.setVisibility(0);
    }

    public void O(int i3) {
        this.E.setMaxLines(i3);
    }

    public void Q(String str) {
        if (this.F == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.F.setAsyncImage(str);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]AlbumShowDialog", "dismiss catch an exception.", e16);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        this.E = (TextView) findViewById(R.id.dialogText);
        this.D = (TextView) findViewById(R.id.dialogLeftBtn);
        this.F = (CornerImageView) findViewById(R.id.bjh);
        this.G = (TextView) findViewById(R.id.bil);
        this.H = findViewById(R.id.biw);
        ImageView imageView = (ImageView) findViewById(R.id.bij);
        this.I = imageView;
        if (imageView != null) {
            imageView.setContentDescription("\u5173\u95ed");
        }
        this.F.setRadius(new float[]{u4.a.z().o(6.0f), u4.a.z().o(6.0f), u4.a.z().o(6.0f), u4.a.z().o(6.0f), 0.0f, 0.0f, 0.0f, 0.0f});
    }

    public void setTitle(String str) {
        this.C.setText(str);
        this.C.setContentDescription(str);
        this.C.setVisibility(0);
    }

    public b P(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.D.setVisibility(8);
            return this;
        }
        this.D.setText(str);
        this.D.setContentDescription(str + getContext().getString(R.string.a_n));
        this.D.setVisibility(0);
        this.G.setVisibility(8);
        this.I.setVisibility(8);
        this.D.setOnClickListener(new a(onClickListener));
        return this;
    }
}
