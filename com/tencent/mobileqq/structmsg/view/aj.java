package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aj {
    static IPatchRedirector $redirector_;

    public static View a(Context context, View view, com.tencent.mobileqq.activity.aio.an anVar, Bundle bundle) {
        boolean z16;
        Resources resources = context.getResources();
        if (bundle.getInt("longMsgHolderType", -1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (view != null && (view instanceof RelativeLayout)) {
            ((RelativeLayout) view).removeAllViews();
        } else {
            view = new RelativeLayout(context);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(75.0f, resources)));
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams);
        ImageView imageView = new ImageView(context);
        TextView textView = new TextView(context);
        if (z16) {
            imageView.setImageResource(R.drawable.f161228sm);
            textView.setText(resources.getString(R.string.dyq));
        } else {
            imageView.setImageResource(R.drawable.f161227sl);
            textView.setText(resources.getString(R.string.dyp));
        }
        imageView.setId(R.id.f166924j51);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(BaseAIOUtils.f(23.5f, resources), BaseAIOUtils.f(22.5f, resources)));
        relativeLayout2.addView(imageView);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#777777"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, R.id.f166924j51);
        layoutParams2.leftMargin = BaseAIOUtils.f(7.5f, resources);
        relativeLayout2.addView(textView, layoutParams2);
        return relativeLayout;
    }
}
