package com.tencent.biz.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends QQCustomDialog {
    protected EditText C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.widgets.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnClickListenerC0996a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f97756d;

        ViewOnClickListenerC0996a(DialogInterface.OnClickListener onClickListener) {
            this.f97756d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f97756d;
            if (onClickListener != null) {
                onClickListener.onClick(a.this, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f97758d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f97758d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f97758d;
            if (onClickListener != null) {
                onClickListener.onClick(a.this, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    protected a(Context context, int i3) {
        super(context, i3);
    }

    public static a N(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        a aVar = new a(context, R.style.qZoneInputDialog);
        aVar.setContentView(R.layout.f167856jn);
        aVar.setTitle(str);
        aVar.setMessage(str2);
        aVar.setNegativeButton(i3, onClickListener2);
        aVar.setPositiveButton(i16, onClickListener);
        aVar.setCanceledOnTouchOutside(false);
        EditText editText = new EditText(context);
        editText.setSingleLine();
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(120)});
        editText.setBackgroundResource(R.drawable.kyk);
        editText.setTextColor(context.getColor(R.color.qui_common_text_primary));
        editText.setPadding(20, 0, 20, 0);
        editText.setHeight(BaseAIOUtils.f(37.0f, context.getResources()));
        editText.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(37.0f, context.getResources()));
        layoutParams.topMargin = BaseAIOUtils.f(11.0f, context.getResources());
        editText.setLayoutParams(layoutParams);
        aVar.O(editText);
        return aVar;
    }

    protected void O(EditText editText) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bodyLayout.getLayoutParams();
        layoutParams.bottomMargin = BaseAIOUtils.f(16.0f, getContext().getResources());
        layoutParams.topMargin = BaseAIOUtils.f(8.0f, getContext().getResources());
        ((RelativeLayout.LayoutParams) this.title.getLayoutParams()).bottomMargin = BaseAIOUtils.f(5.0f, getContext().getResources());
        addView(editText);
        this.C = editText;
    }

    public void P(String str, int i3) {
        if (str != null) {
            this.text.setText(str);
            this.text.setTextSize(1, 16.0f);
            this.text.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = BaseAIOUtils.f(9.0f, getContext().getResources());
            this.text.setLayoutParams(layoutParams);
            this.text.setContentDescription(str);
            this.text.setVisibility(0);
            this.text.setTextColor(i3);
            ((RelativeLayout.LayoutParams) this.bodyLayout.getLayoutParams()).topMargin = 0;
            return;
        }
        this.text.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public a setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(i3);
        this.lBtn.setContentDescription(getContext().getString(i3));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new ViewOnClickListenerC0996a(onClickListener));
        setSeperatorState();
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public a setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        this.rBtn.setContentDescription(getContext().getString(i3));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new b(onClickListener));
        setSeperatorState();
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public EditText getEditText() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getInputValue() {
        return this.C.getText().toString();
    }
}
