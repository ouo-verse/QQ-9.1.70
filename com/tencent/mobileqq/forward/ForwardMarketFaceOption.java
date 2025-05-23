package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardMarketFaceOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f210680d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f210681e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f210682f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMarketFaceOption.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else {
                uRLDrawable.setBounds(BaseImageUtil.calculateThumbBounds(uRLDrawable, 36, 100, ForwardMarketFaceOption.this.mDensity));
                ForwardMarketFaceOption.this.f210682f.setImageDrawable(uRLDrawable);
            }
        }
    }

    public ForwardMarketFaceOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210681e = intent.getBooleanExtra(AppConstants.Key.KEY_DIRECT_SEND_EMOJI, false);
        this.mForwardReportType = 4;
        this.f210680d = intent.getBooleanExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) bundle);
            return;
        }
        if (this.f210681e) {
            if (i3 >= 0) {
                this.mExtraData.putInt("key_forward_ability_type", i3);
            }
            if (bundle != null) {
                this.mExtraData.putAll(bundle);
            }
            forwardOnConfirm();
            return;
        }
        super.buildForwardDialog(i3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        frameLayout.setMinimumHeight(ViewUtils.dip2px(85.0f));
        int dip2px = ViewUtils.dip2px(15.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxWidth(ViewUtils.dip2px(120.0f));
        imageView.setMaxHeight(ViewUtils.dip2px(120.0f));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.f210682f = imageView;
        m();
        return frameLayout;
    }

    protected void m() {
        IPicEmoticonInfo iPicEmoticonInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "setPreviewImage");
        }
        boolean z16 = this.mExtraData.getBoolean(AppConstants.Key.FORWARD_EMOTION_FROM_PREVIEW, false);
        if (this.f210680d) {
            iPicEmoticonInfo = com.tencent.qqnt.aio.forward.l.e().c();
        } else if (z16) {
            iPicEmoticonInfo = AIOEmotionFragment.O0;
        } else {
            iPicEmoticonInfo = MarketFaceItemBuilder.f179359b;
        }
        if (iPicEmoticonInfo == null) {
            return;
        }
        URLDrawable loadingDrawable = iPicEmoticonInfo.getLoadingDrawable(EmotionConstants.FROM_AIO, false);
        loadingDrawable.setBounds(BaseImageUtil.calculateThumbBounds(loadingDrawable, 36, 100, this.mDensity));
        this.f210682f.setImageDrawable(loadingDrawable);
        loadingDrawable.setURLDrawableListener(new a());
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        aliasIntent.putExtras(this.mExtraData);
        if (this.f210680d) {
            this.mActivity.setResult(-1, aliasIntent);
            this.mActivity.finish();
            return false;
        }
        ForwardUtils.w(this.app, this.mActivity, this.mAppContext, aliasIntent, null);
        this.mActivity.setResult(-1, aliasIntent);
        this.mActivity.finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
