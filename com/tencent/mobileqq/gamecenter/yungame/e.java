package com.tencent.mobileqq.gamecenter.yungame;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends ReportDialog {
    private TextView C;
    private TextView D;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f213570d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f213570d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f213570d;
            if (onClickListener != null) {
                onClickListener.onClick(e.this, -1);
            }
            try {
                if (e.this.isShowing()) {
                    e.this.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("YunGameErrorDialog", 1, e16, new Object[0]);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(@NonNull Context context, int i3) {
        super(context, i3);
    }

    public e N(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.C.setText(charSequence);
            this.C.setContentDescription(charSequence);
            this.C.setVisibility(0);
            this.C.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else {
            this.C.setVisibility(8);
        }
        return this;
    }

    public e O(String str, DialogInterface.OnClickListener onClickListener) {
        this.D.setText(str);
        this.D.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        this.D = (TextView) findViewById(R.id.dialogRightBtn);
    }
}
