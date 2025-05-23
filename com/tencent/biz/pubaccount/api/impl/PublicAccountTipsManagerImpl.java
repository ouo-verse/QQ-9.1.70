package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountTipsManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes32.dex */
public class PublicAccountTipsManagerImpl implements View.OnClickListener, IPublicAccountTipsManager {
    public static final String TAG = "PubAccountTipsManager";
    long lastClkTime;
    private Context mContext;
    private View mTipsView;
    private View mPendantView;
    private View[] mBars = {this.mTipsView, this.mPendantView};

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountTipsManager
    public View createEcshopDistanceTipsBar(String str, View.OnClickListener onClickListener) {
        if (this.mContext == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mTipsView == null) {
            TextView textView = new TextView(this.mContext);
            this.mTipsView = textView;
            textView.setTextColor(this.mContext.getResources().getColor(R.color.f158017al3));
            this.mTipsView.setBackgroundResource(R.drawable.btw);
            ((TextView) this.mTipsView).setGravity(16);
            this.mTipsView.setTag(IPublicAccountTipsManager.TAG_ON_NEARBY_TIPS_CLICK);
            ((TextView) this.mTipsView).setTextSize(this.mContext.getResources().getInteger(R.integer.f167157j));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = x.c(this.mContext, 18.0f);
        layoutParams.addRule(3, R.id.gp5);
        layoutParams.addRule(11);
        layoutParams.rightMargin = x.h(this.mContext, 20.0f);
        ((TextView) this.mTipsView).setText(str);
        this.mTipsView.setLayoutParams(layoutParams);
        this.mTipsView.setOnClickListener(onClickListener);
        return this.mTipsView;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountTipsManager
    public void hidePendant() {
        ViewGroup viewGroup;
        View view = this.mPendantView;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(this.mPendantView);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountTipsManager
    public void init(Context context) {
        this.mContext = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (System.currentTimeMillis() - this.lastClkTime < 1000) {
            return;
        }
        this.lastClkTime = System.currentTimeMillis();
        if (view.getId() != R.id.f164250og || this.mContext == null) {
            return;
        }
        String str = (String) view.getTag(R.id.f164253oj);
        String str2 = (String) view.getTag(R.id.f164251oh);
        String str3 = (String) view.getTag(R.id.f164252oi);
        if (((Integer) view.getTag(R.id.f164254ol)).intValue() == 1) {
            Intent intent = new Intent(this.mContext, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromAio", true);
            this.mContext.startActivity(intent);
        } else {
            Intent intent2 = new Intent(this.mContext, (Class<?>) JumpActivity.class);
            intent2.setData(Uri.parse(str));
            this.mContext.startActivity(intent2);
        }
        ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "1", "0X80075A1", "0X80075A1", 0, 0, "", "", str2, str3);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountTipsManager
    public void showPendant(String str, String str2, int i3, int i16, int i17) {
        ViewGroup viewGroup;
        if (this.mContext == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            viewGroup = (ViewGroup) ((BaseActivity) this.mContext).getChatFragment().qh().f25594s.findViewById(R.id.aua);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        if (this.mPendantView == null) {
            URLImageView uRLImageView = new URLImageView(this.mContext);
            this.mPendantView = uRLImageView;
            uRLImageView.setId(R.id.f164250og);
            int c16 = x.c(this.mContext, 62.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c16, c16);
            layoutParams.topMargin = x.c(this.mContext, 15.0f);
            layoutParams.rightMargin = x.c(this.mContext, 15.0f);
            layoutParams.addRule(3, R.id.gp5);
            layoutParams.addRule(11);
            this.mPendantView.setLayoutParams(layoutParams);
        }
        this.mPendantView.setTag(R.id.f164253oj, str2);
        this.mPendantView.setTag(R.id.f164251oh, String.valueOf(i3));
        this.mPendantView.setTag(R.id.f164252oi, String.valueOf(i16));
        this.mPendantView.setTag(R.id.f164254ol, Integer.valueOf(i17));
        this.mPendantView.setOnClickListener(this);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        try {
            URLDrawable drawable = URLDrawable.getDrawable(new URL(str), obtain);
            ((URLImageView) this.mPendantView).setImageDrawable(drawable);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
                this.mPendantView.setVisibility(8);
            }
            ((URLImageView) this.mPendantView).setURLDrawableDownListener(new a());
        } catch (MalformedURLException unused2) {
        }
        showTipsBar(viewGroup, this.mPendantView);
        ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "1", "0X80075A0", "0X80075A0", 0, 0, "", "", String.valueOf(i3), String.valueOf(i16));
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountTipsManager
    public void showTipsBar(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            View[] viewArr = this.mBars;
            if (i3 >= viewArr.length) {
                break;
            }
            View view2 = viewArr[i3];
            if (view2 != null && view2 != view && viewGroup.indexOfChild(view2) != -1) {
                viewGroup.removeView(this.mBars[i3]);
            }
            i3++;
        }
        if (viewGroup.indexOfChild(view) == -1) {
            viewGroup.addView(view);
        }
    }

    /* loaded from: classes32.dex */
    class a implements URLDrawableDownListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i(PublicAccountTipsManagerImpl.TAG, 2, "img Load Failed.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            if (QLog.isColorLevel()) {
                QLog.i(PublicAccountTipsManagerImpl.TAG, 2, "img Load Interrupted.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            if (PublicAccountTipsManagerImpl.this.mPendantView != null) {
                PublicAccountTipsManagerImpl.this.mPendantView.setVisibility(0);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }
}
