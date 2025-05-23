package com.tenpay.sdk.view;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.proxy.QUIProxy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SMSAlertButton extends Button {
    private OnConfirmListener mOnConfirmListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnConfirmListener {
        void OnConfirm();
    }

    public SMSAlertButton(Context context) {
        super(context);
        init(context);
    }

    private void init(final Context context) {
        setText(R.string.f171349ea2);
        setBackgroundColor(0);
        setTextColor(context.getResources().getColor(R.color.c_t));
        setTextSize(14.0f);
        setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.view.SMSAlertButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (SMSAlertButton.this.mOnConfirmListener != null) {
                    SMSAlertButton.this.mOnConfirmListener.OnConfirm();
                }
                Context context2 = context;
                QUIProxy.createCustomDialog(context2, 230, null, context2.getString(R.string.f171348ea1), context.getString(R.string.e3_), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.view.SMSAlertButton.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                    }
                });
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    public void setOnConfirm(OnConfirmListener onConfirmListener) {
        this.mOnConfirmListener = onConfirmListener;
    }

    public SMSAlertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SMSAlertButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
