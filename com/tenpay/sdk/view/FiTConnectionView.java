package com.tenpay.sdk.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FiTConnectionView extends LinearLayout implements View.OnClickListener {
    String url;

    public FiTConnectionView(Context context) {
        super(context);
        this.url = null;
        initView(context, null, 0);
    }

    private void initView(Context context, AttributeSet attributeSet, int i3) {
        LayoutInflater.from(context).inflate(R.layout.adx, (ViewGroup) this, true);
        setGravity(17);
        setOrientation(1);
        TextView textView = (TextView) findViewById(R.id.asx);
        if (textView != null) {
            textView.setClickable(true);
            textView.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.url != null) {
            Intent intent = new Intent();
            intent.putExtra("url", this.url);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("hide_more_button", true);
            RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public FiTConnectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.url = null;
        initView(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    public FiTConnectionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.url = null;
        initView(context, attributeSet, i3);
    }
}
