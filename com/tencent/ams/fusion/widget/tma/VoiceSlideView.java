package com.tencent.ams.fusion.widget.tma;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.slopecard.SlopeCardView;
import com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceSlideView extends SlopeCardView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VoiceSlideView";
    private static final String TITLE_DEFAULT = "\u5439\u5c4f\u5e55\u6216\u524d\u503e\u624b\u673a";
    private static final String TITLE_DEFAULT_NO_VOICE = "\u524d\u503e\u624b\u673a";
    private final Context mContext;
    private int mCount;
    private boolean mHasBlowStart;
    private boolean mHasCallbackRecordError;
    private final boolean mHasPermission;
    private final AtomicBoolean mIsRelease;
    private OnVoiceRecordListener mOnVoiceRecordListener;
    private int mSampleRate;
    private int mT1;
    private VoiceBlowLayer mVoiceBlowLayer;
    private VoiceRecorder mVoiceRecorder;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnVoiceRecordListener {
        void onAudioRecordError();
    }

    public VoiceSlideView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSampleRate = 44100;
        this.mCount = 10;
        this.mT1 = 10;
        this.mIsRelease = new AtomicBoolean(false);
        this.mHasBlowStart = false;
        this.mHasCallbackRecordError = false;
        this.mContext = context;
        this.mHasPermission = TMAUtils.checkPermission(context);
    }

    private void clearBlowAnim() {
        VoiceBlowLayer voiceBlowLayer = this.mVoiceBlowLayer;
        if (voiceBlowLayer != null && voiceBlowLayer.getAnimator() != null) {
            this.mVoiceBlowLayer.getAnimator().cancelAnimation();
            this.mVoiceBlowLayer.clear();
        }
    }

    private AnimatorLayer createVoiceBlowLayer() {
        VoiceBlowLayer voiceBlowLayer = new VoiceBlowLayer(getContext());
        this.mVoiceBlowLayer = voiceBlowLayer;
        voiceBlowLayer.setY(((int) this.mPhoneLayer.getY()) + this.mPhoneLayer.getHeight() + Utils.getRelativeSize375(getContext(), 38));
        this.mVoiceBlowLayer.setWidth(getWidth());
        this.mVoiceBlowLayer.init();
        return this.mVoiceBlowLayer;
    }

    private void initBlowingDetector() {
        if (!this.mHasPermission) {
            OnVoiceRecordListener onVoiceRecordListener = this.mOnVoiceRecordListener;
            if (onVoiceRecordListener != null && !this.mHasCallbackRecordError) {
                this.mHasCallbackRecordError = true;
                onVoiceRecordListener.onAudioRecordError();
                return;
            }
            return;
        }
        if (this.mVoiceRecorder != null) {
            return;
        }
        this.mVoiceRecorder = new VoiceRecorder(this.mContext, this.mSampleRate, this.mT1, this.mCount, new BlowingDetector.c() { // from class: com.tencent.ams.fusion.widget.tma.VoiceSlideView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VoiceSlideView.this);
                }
            }

            @Override // com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector.c
            public void onDetectError(int i3, int i16, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                    return;
                }
                Logger.d(VoiceSlideView.TAG, "onDetectError " + i3 + "_" + i16 + "_" + str);
                if (((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener != null) {
                    ((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener.onInteractFinish(3, false, null);
                }
            }

            @Override // com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector.c
            public void onDetectResult(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, z16);
                    return;
                }
                Logger.d(VoiceSlideView.TAG, "onDetectResult:" + z16);
                if (z16) {
                    if (((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener != null) {
                        VoiceSlideView.this.onInteractSuccess(3, null);
                        ((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener.onInteractFinish(3, true, null);
                    }
                    VoiceSlideView.this.releaseBlowingDetector();
                }
            }

            @Override // com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector.c
            public void onDetectStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                Logger.d(VoiceSlideView.TAG, "onDetectStart");
                if (((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener != null) {
                    VoiceSlideView.this.mHasBlowStart = true;
                    ((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener.onInteractStart(3, null);
                }
            }

            @Override // com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector.c
            public void onDetectStop() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else {
                    Logger.d(VoiceSlideView.TAG, "onDetectStop");
                }
            }

            @Override // com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector.c
            public void onSoInit() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Logger.d(VoiceSlideView.TAG, "onSoInit");
                if (!VoiceSlideView.this.mIsRelease.get()) {
                    VoiceSlideView.this.startRecord();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseBlowingDetector() {
        this.mIsRelease.set(true);
        VoiceRecorder voiceRecorder = this.mVoiceRecorder;
        if (voiceRecorder != null) {
            voiceRecorder.stopDetect();
            this.mVoiceRecorder.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        VoiceRecorder voiceRecorder;
        if (this.mHasPermission && (voiceRecorder = this.mVoiceRecorder) != null) {
            voiceRecorder.startDetect();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.slopecard.SlopeCardView, com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public GroupLayer createGroupLayer(@NonNull List<AnimatorLayer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (GroupLayer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
        }
        list.add(createVoiceBlowLayer());
        list.add(0, createUpBgShadowLayer());
        list.add(0, createBgShadowLayer());
        list.add(list.size() - 1, createCenterIconLayer());
        return new GroupLayer((AnimatorLayer[]) list.toArray(new AnimatorLayer[0]));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.slopecard.SlopeCardView
    public int getCenterIconLayerHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return super.getCenterIconLayerHeight() + Utils.getRelativeSize375(getContext(), 100);
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public float getPhoneBottom(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this, (Object) animatorLayer)).floatValue();
        }
        return super.getPhoneBottom(animatorLayer) - Utils.getRelativeSize(getContext(), 80);
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (getWidth() > 0 && getHeight() > 0) {
            this.mSubTitleLayer = createTextLayer(this.mSubTitle, SlopeSlideView.SUBTITLE_TEXT_COLOR, Utils.dp2px(14.0f), getSubtitleTextY());
            this.mTitleLayer = createTextLayer(this.mTitle, -1, Utils.dp2px(18.0f), getTitleTextY());
            createPhoneLayer();
            createBgShaderLayer();
            createIconLayer();
            createIconShakeAnimator();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mBgShaderLayer);
            arrayList.add(this.mPhoneLayer);
            arrayList.add(this.mSubTitleLayer);
            arrayList.add(this.mTitleLayer);
            arrayList.add(this.mIconLayer);
            addLayer(createGroupLayer(arrayList));
        }
    }

    public void onApngAnimComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        SlopeSlideView.OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
        if (onSlopSlideInteractListener != null) {
            onSlopSlideInteractListener.onAnimatorStart();
        }
        startEndAnimation(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.tma.VoiceSlideView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VoiceSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ((SlopeSlideView) VoiceSlideView.this).mAnimatorFinished = true;
                    if (((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener != null) {
                        ((SlopeSlideView) VoiceSlideView.this).mOnSlopeSlideInteractListener.onAnimatorFinish();
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        clearBlowAnim();
        releaseBlowingDetector();
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    protected void onInteractCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        synchronized (this) {
            SlopeSlideView.OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
            if (onSlopSlideInteractListener != null) {
                if (!this.mIsInteractSuccess) {
                    int i3 = 6;
                    if (this.mMaxAngle >= 5.0f) {
                        if (!this.mHasBlowStart) {
                            i3 = 4;
                        }
                        onSlopSlideInteractListener.onInteractFinish(3, false, null);
                    } else if (this.mHasBlowStart) {
                        i3 = 5;
                    }
                    this.mOnSlopeSlideInteractListener.onInteractResult(3, false, i3, null, this.mMaxAngle);
                } else if (!this.mAnimatorFinished) {
                    this.mAnimatorFinished = true;
                    onSlopSlideInteractListener.onAnimatorFinish();
                }
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    protected synchronized void onInteractSuccess(int i3, Point point) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) point);
            return;
        }
        if (!this.mIsInteractSuccess) {
            this.mIsInteractSuccess = true;
            SlopeSlideView.OnSlopSlideInteractListener onSlopSlideInteractListener = this.mOnSlopeSlideInteractListener;
            if (onSlopSlideInteractListener != null) {
                onSlopSlideInteractListener.onInteractResult(i3, true, 0, point, this.mMaxAngle);
            }
        }
        clearBlowAnim();
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.pauseAnimation();
        VoiceRecorder voiceRecorder = this.mVoiceRecorder;
        if (voiceRecorder != null) {
            voiceRecorder.stopDetect();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.resumeAnimation();
        VoiceRecorder voiceRecorder = this.mVoiceRecorder;
        if (voiceRecorder != null) {
            voiceRecorder.startDetect();
        }
    }

    public void setCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mCount = i3;
        }
    }

    public void setOnVoiceRecordListener(OnVoiceRecordListener onVoiceRecordListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onVoiceRecordListener);
        } else {
            this.mOnVoiceRecordListener = onVoiceRecordListener;
        }
    }

    public void setSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mSampleRate = i3;
        }
    }

    public void setT1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mT1 = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (!TMAUtils.checkPermission(this.mContext)) {
            str = TITLE_DEFAULT_NO_VOICE;
        }
        super.setTitle(str);
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.start();
        if (TextUtils.isEmpty(this.mTitle)) {
            setTitle(TITLE_DEFAULT);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.startAnimation();
            initBlowingDetector();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView, com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.stopAnimation();
            releaseBlowingDetector();
        }
    }

    public VoiceSlideView(Context context, int i3, int i16, int i17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mSampleRate = 44100;
        this.mCount = 10;
        this.mT1 = 10;
        this.mIsRelease = new AtomicBoolean(false);
        this.mHasBlowStart = false;
        this.mHasCallbackRecordError = false;
        this.mContext = context;
        this.mSampleRate = i3;
        this.mT1 = i16;
        this.mCount = i17;
        this.mHasPermission = TMAUtils.checkPermission(context);
    }
}
