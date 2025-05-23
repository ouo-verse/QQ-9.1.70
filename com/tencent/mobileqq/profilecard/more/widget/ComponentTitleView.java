package com.tencent.mobileqq.profilecard.more.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ComponentTitleView extends LinearLayout {
    private static String TAG = "ComponentTitleView";
    private ViewGroup mComponentContent;
    private LinearLayout mRightContainer;
    private TextView mRightTxt;
    private TextView mTitle;

    public ComponentTitleView(Context context) {
        this(context, null);
    }

    public ViewGroup getComponentContent() {
        return this.mComponentContent;
    }

    public ViewGroup getRightContainer() {
        return this.mRightContainer;
    }

    void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.cyw, (ViewGroup) this, true);
        this.mTitle = (TextView) findViewById(R.id.oxc);
        this.mRightTxt = (TextView) findViewById(R.id.owv);
        this.mComponentContent = (ViewGroup) findViewById(R.id.oto);
        this.mRightContainer = (LinearLayout) findViewById(R.id.owu);
    }

    public void setRightTxt(CharSequence charSequence) {
        this.mRightTxt.setText(charSequence);
    }

    public void setTitle(int i3) {
        this.mTitle.setText(i3);
    }

    public void updateNightModeUI() {
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setTextColor(-1);
        }
        TextView textView2 = this.mRightTxt;
        if (textView2 != null) {
            textView2.setTextColor(-1712591883);
        }
        ((ImageView) findViewById(R.id.oup)).setImageResource(R.drawable.g7n);
        ((ViewGroup) findViewById(R.id.oxd)).setBackgroundColor(-16777216);
        ViewGroup viewGroup = this.mComponentContent;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-16777216);
        }
    }

    public ComponentTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComponentTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTitle = null;
        this.mRightTxt = null;
        this.mComponentContent = null;
        this.mRightContainer = null;
        initView();
    }

    public void addComponentContent(View view) {
        if (view == null) {
            QLog.w(TAG, 1, "componentContentView is null");
            return;
        }
        this.mComponentContent.removeAllViews();
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.mComponentContent.addView(view);
    }

    public void hideTitleArea() {
        ((ViewGroup) findViewById(R.id.oxd)).setVisibility(8);
    }

    public void setRightContainerState(int i3) {
        if (i3 != 0 && i3 != 4 && i3 != 8) {
            QLog.e(TAG, 1, "setRightContainerState type illegal");
        } else {
            this.mRightContainer.setVisibility(i3);
        }
    }
}
