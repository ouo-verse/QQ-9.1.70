package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bi extends ReportDialog {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f292092d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f292092d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f292092d;
            if (onClickListener != null) {
                onClickListener.onClick(bi.this, 1);
            }
            try {
                if (bi.this.isShowing()) {
                    bi.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f292094d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f292094d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f292094d;
            if (onClickListener != null) {
                onClickListener.onClick(bi.this, 0);
            }
            try {
                if (bi.this.isShowing()) {
                    bi.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public bi(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        super(context, R.style.qZoneInputDialog);
        setContentView(R.layout.c0s);
        TextView textView = (TextView) findViewById(R.id.title);
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.content);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setVisibility(0);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setText(new n(str2, 8));
        } else {
            textView2.setVisibility(8);
        }
        ((Button) findViewById(R.id.b7p)).setOnClickListener(new a(onClickListener));
        ((ImageView) findViewById(R.id.az7)).setOnClickListener(new b(onClickListener2));
        setCanceledOnTouchOutside(false);
    }
}
