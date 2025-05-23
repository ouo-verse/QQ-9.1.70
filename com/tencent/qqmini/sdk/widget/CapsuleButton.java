package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.utils.CustomWidgetUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CapsuleButton extends RelativeLayout implements ICapsuleButton, View.OnClickListener, Handler.Callback {
    public static final String TAG = "CapsuleButton";
    private Drawable mCloseBtnBgDrawable;
    private Drawable mCloseBtnWhiteBgDrawable;
    private ImageView mCloseView;
    private CapsuleBtnClickListener mListener;
    private Drawable mMoreBtnBgDrawable;
    private Drawable mMoreBtnWhiteBgDrawable;
    private ImageView mMoreView;
    private TextView mRedDot;
    private View mSplider;
    private static final String CAPSULE_CLOSE_URL = WnsConfig.getConfig("qqminiapp", "closebutton", (String) null);
    private static final String CAPSULE_CLOSE_DARK_URL = WnsConfig.getConfig("qqminiapp", "closebuttondark", (String) null);
    private static int unReadCount = 0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface CapsuleBtnClickListener {
        void onCloseClick();

        void onMoreClick();
    }

    public CapsuleButton(Context context) {
        super(context);
        initUI();
    }

    private ImageView createMoreView() {
        ImageView capsuleButtonMoreView = ((KingCardProxy) AppLoaderFactory.g().getProxyManager().get(KingCardProxy.class)).getCapsuleButtonMoreView(getContext());
        if (capsuleButtonMoreView == null) {
            ImageView imageView = new ImageView(getContext());
            int i3 = R.id.mini_sdk_capsule_btn_more_menu;
            imageView.setId(i3);
            imageView.setContentDescription("\u66f4\u591a");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px(40.0f), dip2px(30.0f));
            layoutParams.addRule(9, -1);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            addView(imageView, layoutParams);
            return (ImageView) findViewById(i3);
        }
        addView(capsuleButtonMoreView);
        return capsuleButtonMoreView;
    }

    private int dip2px(float f16) {
        return DisplayUtil.dip2px(getContext(), f16);
    }

    private View getContainerView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setId(R.id.mini_sdk_capsule_btn_close_menu);
        imageView.setContentDescription("\u5173\u95ed");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px(40.0f), dip2px(30.0f));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(1, R.id.mini_sdk_capsule_btn_more_menu);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(imageView, layoutParams);
        View view = new View(getContext());
        view.setId(R.id.mini_sdk_capsule_btn_line_split);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dip2px(0.5f), dip2px(18.0f));
        layoutParams2.addRule(13, -1);
        view.setBackgroundColor(436207616);
        addView(view, layoutParams2);
        View textView = new TextView(getContext());
        textView.setId(R.id.mini_sdk_capsule_btn_reddot);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = dip2px(21.5f);
        layoutParams3.topMargin = dip2px(-9.5f);
        addView(textView, layoutParams3);
        return this;
    }

    private void initUI() {
        setClipChildren(false);
        this.mMoreView = createMoreView();
        getContainerView();
        this.mCloseView = (ImageView) findViewById(R.id.mini_sdk_capsule_btn_close_menu);
        this.mRedDot = (TextView) findViewById(R.id.mini_sdk_capsule_btn_reddot);
        this.mSplider = findViewById(R.id.mini_sdk_capsule_btn_line_split);
        this.mRedDot.setTextSize(12.0f);
        this.mRedDot.setTextColor(-1);
        this.mRedDot.setGravity(17);
        this.mRedDot.setIncludeFontPadding(false);
        this.mMoreView.setOnClickListener(this);
        this.mCloseView.setOnClickListener(this);
        this.mMoreBtnWhiteBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_more_white_bg);
        this.mCloseBtnWhiteBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_close_white_bg);
        this.mMoreBtnBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_more_bg);
        this.mCloseBtnBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_close_bg);
        String str = CAPSULE_CLOSE_URL;
        if (!TextUtils.isEmpty(str)) {
            String str2 = CAPSULE_CLOSE_DARK_URL;
            if (!TextUtils.isEmpty(str2)) {
                MiniAppProxy miniAppProxy = (MiniAppProxy) AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
                this.mCloseBtnWhiteBgDrawable = miniAppProxy.getDrawable(getContext(), str2, dip2px(40.0f), dip2px(30.0f), this.mCloseBtnWhiteBgDrawable);
                this.mCloseBtnBgDrawable = miniAppProxy.getDrawable(getContext(), str, dip2px(40.0f), dip2px(30.0f), this.mCloseBtnBgDrawable);
            }
        }
    }

    public void changeNavIcon(int i3) {
        if (i3 == -1) {
            this.mMoreView.setImageDrawable(this.mMoreBtnWhiteBgDrawable);
            this.mCloseView.setImageDrawable(this.mCloseBtnWhiteBgDrawable);
            this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        } else {
            this.mMoreView.setImageDrawable(this.mMoreBtnBgDrawable);
            this.mCloseView.setImageDrawable(this.mCloseBtnBgDrawable);
            this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.ICapsuleButton
    public ImageView getMoreView() {
        return this.mMoreView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CapsuleBtnClickListener capsuleBtnClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.mMoreView) {
            CapsuleBtnClickListener capsuleBtnClickListener2 = this.mListener;
            if (capsuleBtnClickListener2 != null) {
                capsuleBtnClickListener2.onMoreClick();
            }
        } else if (view == this.mCloseView && (capsuleBtnClickListener = this.mListener) != null) {
            capsuleBtnClickListener.onCloseClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public CapsuleButton setListener(CapsuleBtnClickListener capsuleBtnClickListener) {
        this.mListener = capsuleBtnClickListener;
        return this;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.ICapsuleButton
    public void setUnReadCount(int i3, boolean z16) {
        if (z16) {
            unReadCount = i3;
            if (QMLog.isColorLevel()) {
                QMLog.d(TAG, "forceUpdate : " + z16 + "; setUnReadCount : " + i3);
            }
        }
        unReadCount = i3;
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "forceUpdate : " + z16 + "; setUnReadCount : " + i3);
        }
        updateRedDotVisible();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.ICapsuleButton
    public void updateRedDotVisible() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.CapsuleButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (CapsuleButton.unReadCount > 0 && CapsuleButton.this.mMoreView != null) {
                    CapsuleButton.this.mRedDot.setVisibility(0);
                    CustomWidgetUtil.updateCustomNoteTxt(CapsuleButton.this.mRedDot, CapsuleButton.unReadCount);
                } else {
                    CapsuleButton.this.mRedDot.setVisibility(8);
                }
            }
        });
    }

    public void updateStyle(int i3) {
        ImageView imageView = this.mMoreView;
        if (imageView != null && this.mCloseView != null && this.mSplider != null) {
            if (i3 == -1) {
                imageView.setImageResource(R.drawable.mini_sdk_top_btns_more_white_bg);
                this.mCloseView.setImageResource(R.drawable.mini_sdk_top_btns_close_white_bg);
                this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
            } else {
                imageView.setImageResource(R.drawable.mini_sdk_top_btns_more_bg);
                this.mCloseView.setImageResource(R.drawable.mini_sdk_top_btns_close_bg);
                this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
            }
        }
    }

    public void updateTopMargin(boolean z16) {
        int i3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (z16) {
            layoutParams.topMargin = DisplayUtil.dip2px(getContext(), 9.0f);
        } else {
            int dip2px = DisplayUtil.dip2px(getContext(), 9.0f);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                i3 = DisplayUtil.getStatusBarHeight(getContext());
            } else {
                i3 = 0;
            }
            layoutParams.topMargin = dip2px + i3;
        }
        setLayoutParams(layoutParams);
    }

    public CapsuleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }
}
