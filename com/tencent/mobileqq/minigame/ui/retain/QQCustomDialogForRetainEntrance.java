package com.tencent.mobileqq.minigame.ui.retain;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.utils.PublicAccountUtil;
import com.tencent.mobileqq.minigame.report.MiniGameNewRetainDialogReport;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQCustomDialogForRetainEntrance extends Dialog implements ViewPager.OnPageChangeListener, Handler.Callback, CompoundButton.OnCheckedChangeListener {
    private static final int MSG_CODE_NEXT_GUIDE_PAGE = 255;
    private static final String TAG = "QQCustomDialogForRetainEntrance";
    private View bottomPaddingView;
    private View closeBtn;
    private int currentPage;
    private View dialogRoot;
    private TextView dialogTitleTextView;
    private TextView exitButton;
    private MiniAppConfig fromAppConfig;
    private LinearLayout indicatorLayout;
    private boolean isAutoShowBanner;
    private boolean isLandScape;
    private TextView moreButton;
    private CheckBox subscribeCheckBox;
    private View subscribeLayout;
    private WeakReferenceHandler uiHanlder;
    private UsageGuideStyle usageGuideStyle;
    private ViewPager viewPager;

    public QQCustomDialogForRetainEntrance(Context context, int i3, MiniAppConfig miniAppConfig) {
        super(context, i3);
        this.uiHanlder = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.currentPage = 0;
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
        this.fromAppConfig = miniAppConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSubscribeAndShow$0(EIPCResult eIPCResult) {
        boolean z16 = eIPCResult.code == 0 ? eIPCResult.data.getBoolean(PublicAccountUtil.KEY_IS_FOLLOW) : false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[isFollow] onCallback=" + eIPCResult.code + " isFollow:" + z16);
        }
        if (z16) {
            this.subscribeLayout.setVisibility(8);
        } else {
            this.subscribeLayout.setVisibility(0);
            this.subscribeCheckBox.setChecked(true);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.retain.QQCustomDialogForRetainEntrance.1
            @Override // java.lang.Runnable
            public void run() {
                QQCustomDialogForRetainEntrance.this.show();
                MiniGameNewRetainDialogReport.reportFunctionRetainDialogShow(QQCustomDialogForRetainEntrance.this.fromAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$subScribePubAccount$1(EIPCResult eIPCResult) {
        String str;
        if (eIPCResult.code == 0) {
            boolean z16 = eIPCResult.data.getBoolean(PublicAccountUtil.KEY_RESULT_CODE);
            QLog.d(TAG, 1, "[subScribePubAccount] followPA isSuccess:" + z16);
            MiniAppConfig miniAppConfig = this.fromAppConfig;
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            MiniGameNewRetainDialogReport.reportFunctionRetainSubscribeResult(miniAppConfig, IMiniGamePublicAccountApi.UIN_MINI_GAME_PA, str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[subScribePubAccount] onCallback errCode:" + eIPCResult.code);
        }
    }

    public void checkSubscribeAndShow() {
        Bundle bundle = new Bundle();
        bundle.putLong(PublicAccountUtil.KEY_PA_UIN, Long.parseLong(IMiniGamePublicAccountApi.UIN_MINI_GAME_PA));
        QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_PA_IS_FOLLOW, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.ui.retain.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQCustomDialogForRetainEntrance.this.lambda$checkSubscribeAndShow$0(eIPCResult);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 255) {
            int i3 = this.currentPage + 1;
            this.currentPage = i3;
            if (i3 >= this.viewPager.getChildCount()) {
                this.currentPage = 0;
            }
            this.isAutoShowBanner = true;
            this.viewPager.setCurrentItem(this.currentPage, true);
            this.uiHanlder.removeMessages(255);
            if (this.usageGuideStyle != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleMessage post next msg:" + message.what + " usageGuideStyle.autoSlideInterval:" + this.usageGuideStyle.autoSlideInterval);
                }
                this.uiHanlder.sendEmptyMessageDelayed(255, this.usageGuideStyle.autoSlideInterval * 1000);
            }
        }
        return false;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        String str;
        MiniAppConfig miniAppConfig = this.fromAppConfig;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        MiniGameNewRetainDialogReport.reportFunctionRetainSubscribeClick(miniAppConfig, str);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.uiHanlder.removeCallbacksAndMessages(null);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        String str;
        if (this.indicatorLayout.getChildCount() > i3) {
            for (int i16 = 0; i16 < this.indicatorLayout.getChildCount(); i16++) {
                setIndicatorBackground(i16, i3);
            }
            UsageGuideStyle usageGuideStyle = this.usageGuideStyle;
            if (usageGuideStyle != null) {
                MiniAppConfig miniAppConfig = this.fromAppConfig;
                if (this.isAutoShowBanner) {
                    str = "1";
                } else {
                    str = "2";
                }
                MiniGameNewRetainDialogReport.reportFunctionRetainGuideBannerShow(miniAppConfig, str, usageGuideStyle.guideMediasList.get(i3));
            }
            this.isAutoShowBanner = false;
        }
        if (this.usageGuideStyle != null) {
            this.uiHanlder.removeMessages(255);
            this.uiHanlder.sendEmptyMessageDelayed(255, this.usageGuideStyle.autoSlideInterval * 1000);
        }
    }

    public void reportCloseBtnClick() {
        String str;
        if (this.subscribeLayout.isShown()) {
            if (this.subscribeCheckBox.isChecked()) {
                str = "1";
            } else {
                str = "2";
            }
        } else {
            str = "3";
        }
        MiniGameNewRetainDialogReport.reportFunctionRetainCloseClick(this.fromAppConfig, str);
    }

    public void reportExitBtnClick() {
        String str;
        if (this.subscribeLayout.isShown()) {
            if (this.subscribeCheckBox.isChecked()) {
                str = "1";
            } else {
                str = "2";
            }
        } else {
            str = "3";
        }
        MiniGameNewRetainDialogReport.reportFunctionRetainExitClick(this.fromAppConfig, str);
    }

    public void setClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.exitButton.setOnClickListener(onClickListener);
        this.moreButton.setOnClickListener(onClickListener2);
        this.closeBtn.setOnClickListener(onClickListener3);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        View findViewById = findViewById(R.id.rd9);
        this.dialogRoot = findViewById;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        if (!this.isLandScape) {
            layoutParams.width = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.dialogRoot.setLayoutParams(layoutParams);
        this.exitButton = (TextView) findViewById(R.id.rd7);
        this.moreButton = (TextView) findViewById(R.id.rd8);
        this.dialogTitleTextView = (TextView) findViewById(R.id.rd_);
        if (QQTheme.isNowThemeIsNight()) {
            this.dialogRoot.setBackgroundResource(this.isLandScape ? R.drawable.ipb : R.drawable.ipa);
            this.moreButton.setTextColor(-1);
            this.exitButton.setTextColor(-1);
            this.dialogTitleTextView.setTextColor(Color.parseColor("#FFF0F0F4"));
            if (this.isLandScape) {
                ((TextView) findViewById(R.id.rda)).setTextColor(Color.parseColor("#FFF0F0F4"));
            }
        }
        this.viewPager = (ViewPager) findViewById(R.id.rdb);
        this.indicatorLayout = (LinearLayout) findViewById(R.id.re6);
        this.subscribeLayout = findViewById(R.id.rl_);
        CheckBox checkBox = (CheckBox) findViewById(R.id.rl9);
        this.subscribeCheckBox = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        View findViewById2 = findViewById(R.id.rcc);
        this.bottomPaddingView = findViewById2;
        if (this.isLandScape) {
            findViewById2.getLayoutParams().height = 1;
        }
        this.closeBtn = findViewById(R.id.rcm);
    }

    public void setDialogGravity() {
        getWindow().setGravity(this.isLandScape ? 17 : 80);
    }

    public void setLandscape(boolean z16) {
        this.isLandScape = z16;
    }

    public void setUsageGuideStyle(UsageGuideStyle usageGuideStyle) {
        this.usageGuideStyle = usageGuideStyle;
        float f16 = getContext().getResources().getDisplayMetrics().density;
        this.viewPager.setAdapter(new GuidePagerAdapter(usageGuideStyle));
        this.viewPager.setOffscreenPageLimit(usageGuideStyle.guideMediasList.size());
        this.viewPager.addOnPageChangeListener(this);
        for (int i3 = 0; i3 < usageGuideStyle.guideMediasList.size(); i3++) {
            View view = new View(getContext());
            int i16 = (int) (8.0f * f16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i16, i16);
            if (i3 != 0) {
                layoutParams.leftMargin = i16;
            }
            this.indicatorLayout.addView(view, layoutParams);
        }
        if (this.indicatorLayout.getChildCount() > 0) {
            setIndicatorBackground(0, 0);
            MiniGameNewRetainDialogReport.reportFunctionRetainGuideBannerShow(this.fromAppConfig, "3", usageGuideStyle.guideMediasList.get(0));
            this.uiHanlder.sendEmptyMessageDelayed(255, usageGuideStyle.autoSlideInterval * 1000);
        }
    }

    public void subScribePubAccount() {
        if (this.subscribeCheckBox.isChecked() && this.subscribeLayout.isShown()) {
            Bundle bundle = new Bundle();
            bundle.putLong(PublicAccountUtil.KEY_PA_UIN, Long.parseLong(IMiniGamePublicAccountApi.UIN_MINI_GAME_PA));
            bundle.putBoolean(PublicAccountUtil.KEY_IS_FOLLOW, this.subscribeCheckBox.isChecked());
            QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_PA_FOLLOW, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.ui.retain.a
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    QQCustomDialogForRetainEntrance.this.lambda$subScribePubAccount$1(eIPCResult);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[subScribePubAccount] checked is false");
        }
    }

    private void setIndicatorBackground(int i3, int i16) {
        if (i16 == i3) {
            this.indicatorLayout.getChildAt(i3).setBackgroundResource(R.drawable.iq5);
        } else {
            this.indicatorLayout.getChildAt(i3).setBackgroundResource(QQTheme.isNowThemeIsNight() ? R.drawable.iq7 : R.drawable.iq6);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
