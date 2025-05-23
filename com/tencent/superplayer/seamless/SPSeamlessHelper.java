package com.tencent.superplayer.seamless;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes26.dex */
public class SPSeamlessHelper {
    public static ViewGroup.LayoutParams DEFAULT_LAYOUT_PARAM = null;
    public static final long DURATION = 250;
    public static final String TAG = "SPSeamlessHelper";
    public static ViewGroup.LayoutParams WRAP_LAYOUT_PARAM;
    private WeakReference<Activity> mAnimActivity;
    private Map<String, Set<SeamlessCallback>> mCallbackMap = new HashMap();
    private String mEnterToken;
    private ViewGroup mJumpParentViewGroup;
    private static SPSeamlessHelper mInstance = new SPSeamlessHelper();
    public static ViewGroup.LayoutParams MATCH_LAYOUT_PARAM = new ViewGroup.LayoutParams(-2, -2);

    /* loaded from: classes26.dex */
    public enum SceneTransformType {
        EnterIn,
        Exit
    }

    /* loaded from: classes26.dex */
    public interface SeamlessCallback {
        void onSeamlessExitEnd(String str, String str2, Map<String, Object> map);

        void onSeamlessJump(String str);
    }

    static {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        WRAP_LAYOUT_PARAM = layoutParams;
        DEFAULT_LAYOUT_PARAM = layoutParams;
    }

    private void addSeamlessCallback(String str, SeamlessCallback seamlessCallback) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "addSeamlessCallback failed for token is empty.");
            return;
        }
        Set<SeamlessCallback> set = this.mCallbackMap.get(str);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(seamlessCallback);
        this.mCallbackMap.put(str, set);
    }

    private void clearEnterTokenCallback() {
        removeSeamlessCallback(this.mEnterToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doContentViewAlphaGradientAnimation(final View view, float f16, float f17, long j3) {
        final boolean z16;
        if (view == null) {
            return;
        }
        if (f17 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f17);
        alphaAnimation.setDuration(j3);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.superplayer.seamless.SPSeamlessHelper.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z16) {
                    view.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doVideoViewAnimation(final View view, ViewGroup viewGroup, final ViewGroup viewGroup2, long j3, final SPSeamlessParam sPSeamlessParam, final Animator.AnimatorListener animatorListener) {
        ViewInfo viewInfo = getViewInfo(view);
        view.clearAnimation();
        attachVideoView(viewGroup, view);
        new VideoMoveAnimator(view, viewInfo, getViewInfo(viewGroup2), j3, new Animator.AnimatorListener() { // from class: com.tencent.superplayer.seamless.SPSeamlessHelper.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SPSeamlessHelper.this.onWindowAnimEnd(animator, view, viewGroup2, sPSeamlessParam, animatorListener);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationStart(animator);
                }
            }
        }).start();
    }

    public static SPSeamlessHelper get() {
        return mInstance;
    }

    private ViewGroup getParentView(View view) {
        if (view == null) {
            return null;
        }
        return (ViewGroup) view.getParent();
    }

    private View getVideoViewByToken(String str) {
        ISuperPlayer iSuperPlayer = SuperPlayerSDKMgr.getPlayerPool().get(str);
        if (iSuperPlayer != null && iSuperPlayer.getVideoView() != null) {
            return (View) iSuperPlayer.getVideoView();
        }
        LogUtil.e(TAG, "getVideoViewByToken failed for player/videoView or videoLayout is null.");
        return null;
    }

    private ViewInfo getViewInfo(View view) {
        ViewInfo viewInfo = new ViewInfo();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        viewInfo.f373955x = iArr[0];
        viewInfo.f373956y = iArr[1];
        viewInfo.width = view.getWidth();
        viewInfo.height = view.getHeight();
        return viewInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeamlessExitEnd() {
        Set<SeamlessCallback> set = this.mCallbackMap.get(this.mEnterToken);
        if (set != null) {
            Iterator<SeamlessCallback> it = set.iterator();
            while (it.hasNext()) {
                it.next().onSeamlessExitEnd("", "", null);
            }
        }
        clearEnterTokenCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWindowAnimEnd(final Animator animator, final View view, final ViewGroup viewGroup, final SPSeamlessParam sPSeamlessParam, final Animator.AnimatorListener animatorListener) {
        viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.superplayer.seamless.SPSeamlessHelper.5
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                view.setX(0.0f);
                view.setY(0.0f);
                SPSeamlessHelper sPSeamlessHelper = SPSeamlessHelper.this;
                ViewGroup viewGroup2 = viewGroup;
                View view2 = view;
                SPSeamlessParam sPSeamlessParam2 = sPSeamlessParam;
                sPSeamlessHelper.attachVideoView(viewGroup2, view2, sPSeamlessParam2.layoutParams, sPSeamlessParam2.viewIndex);
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationEnd(animator);
                    return true;
                }
                return true;
            }
        });
        viewGroup.invalidate();
    }

    private void removeSeamlessCallback(String str) {
        this.mCallbackMap.remove(str);
    }

    public void attachThenDoAnimation(final View view, final ViewGroup viewGroup, final SPSeamlessParam sPSeamlessParam, SceneTransformType sceneTransformType) {
        WeakReference<Activity> weakReference = this.mAnimActivity;
        if (weakReference != null && weakReference.get() != null) {
            final ViewGroup viewGroup2 = (ViewGroup) this.mAnimActivity.get().getWindow().getDecorView();
            if (sceneTransformType == SceneTransformType.Exit) {
                doVideoViewAnimation(view, viewGroup2, viewGroup, 250L, sPSeamlessParam, new Animator.AnimatorListener() { // from class: com.tencent.superplayer.seamless.SPSeamlessHelper.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SPSeamlessHelper.this.onSeamlessExitEnd();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                doContentViewAlphaGradientAnimation(viewGroup2.findViewById(R.id.content), 1.0f, 0.0f, 250L);
                return;
            } else {
                if (sceneTransformType == SceneTransformType.EnterIn) {
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.superplayer.seamless.SPSeamlessHelper.2
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                            SPSeamlessHelper.this.doVideoViewAnimation(view, viewGroup2, viewGroup, 250L, sPSeamlessParam, null);
                            SPSeamlessHelper.this.doContentViewAlphaGradientAnimation(viewGroup2.findViewById(R.id.content), 0.0f, 1.0f, 250L);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
        }
        LogUtil.e(TAG, "attachThenDoAnimation failed for mAnimActivity is null, mAnimActivityReference:" + this.mAnimActivity);
    }

    public void attachVideoView(ViewGroup viewGroup, ISPlayerVideoView iSPlayerVideoView) {
        attachVideoView(viewGroup, iSPlayerVideoView, DEFAULT_LAYOUT_PARAM);
    }

    @Deprecated
    public void enterScene(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, SeamlessCallback seamlessCallback) {
        if (seamlessCallback != null) {
            addSeamlessCallback(str, seamlessCallback);
        }
        ISuperPlayer iSuperPlayer = SuperPlayerSDKMgr.getPlayerPool().get(str);
        if (iSuperPlayer != null && iSuperPlayer.getVideoView() != null && viewGroup != null) {
            attachVideoView(viewGroup, iSuperPlayer.getVideoView(), layoutParams);
        } else {
            LogUtil.e(TAG, "attachBeforeAnimation failed for player/videoView or videoLayout is null.");
        }
    }

    public void enterSceneWithAnim(Activity activity, String str, ViewGroup viewGroup, SPSeamlessParam sPSeamlessParam, SeamlessCallback seamlessCallback) {
        if (seamlessCallback != null) {
            addSeamlessCallback(str, seamlessCallback);
        }
        ISuperPlayer iSuperPlayer = SuperPlayerSDKMgr.getPlayerPool().get(str);
        if (iSuperPlayer != null && iSuperPlayer.getVideoView() != null && viewGroup != null) {
            View view = (View) iSuperPlayer.getVideoView();
            this.mAnimActivity = new WeakReference<>(activity);
            this.mJumpParentViewGroup = getParentView(view);
            attachThenDoAnimation(view, viewGroup, sPSeamlessParam, SceneTransformType.EnterIn);
            return;
        }
        LogUtil.e(TAG, "attachBeforeAnimation failed for player/videoView or videoLayout is null.");
    }

    public void exitScene(String str, String str2, SPSeamlessParam sPSeamlessParam, SeamlessCallback seamlessCallback) {
        if (seamlessCallback != null) {
            addSeamlessCallback(str, seamlessCallback);
        }
        this.mEnterToken = str;
        View videoViewByToken = getVideoViewByToken(str2);
        if (videoViewByToken == null) {
            LogUtil.e(TAG, "exitScene failed for videoView is null.");
            return;
        }
        boolean equals = TextUtils.equals(str, str2);
        if (!sPSeamlessParam.doAnimation) {
            attachVideoView(this.mJumpParentViewGroup, videoViewByToken, sPSeamlessParam.layoutParams, sPSeamlessParam.viewIndex);
            onSeamlessExitEnd();
        } else if (equals) {
            attachThenDoAnimation(videoViewByToken, this.mJumpParentViewGroup, sPSeamlessParam, SceneTransformType.Exit);
        } else {
            LogUtil.w(TAG, "exitScene failed for token not equal, enterToken:" + str + " leftToken:" + str2);
        }
        this.mAnimActivity = null;
    }

    @Deprecated
    public void jumpScene(String str, SeamlessCallback seamlessCallback) {
        if (seamlessCallback != null) {
            addSeamlessCallback(str, seamlessCallback);
        }
        Set<SeamlessCallback> set = this.mCallbackMap.get(str);
        if (set != null) {
            Iterator<SeamlessCallback> it = set.iterator();
            while (it.hasNext()) {
                it.next().onSeamlessJump(str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachVideoView(ViewGroup viewGroup, ISPlayerVideoView iSPlayerVideoView, ViewGroup.LayoutParams layoutParams) {
        if (iSPlayerVideoView instanceof View) {
            attachVideoView(viewGroup, (View) iSPlayerVideoView, layoutParams, -1);
        }
    }

    public void attachVideoView(ViewGroup viewGroup, View view) {
        attachVideoView(viewGroup, view, DEFAULT_LAYOUT_PARAM, -1);
    }

    public void attachVideoView(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        attachVideoView(viewGroup, view, layoutParams, -1);
    }

    public void jumpScene(Activity activity, String str, SeamlessCallback seamlessCallback) {
        activity.overridePendingTransition(0, 0);
        jumpScene(str, seamlessCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachVideoView(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i3) {
        if (viewGroup != null && view != 0) {
            if (view instanceof ISPlayerVideoView) {
                ((ISPlayerVideoView) view).disableViewCallback();
            }
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            if (i3 == -1) {
                viewGroup.addView(view, layoutParams);
            } else {
                viewGroup.addView(view, i3, layoutParams);
            }
            ((ISPlayerVideoView) view).enableViewCallback();
            return;
        }
        LogUtil.e(TAG, "innerAttachVideoView failed for containerView or videoView is null");
    }
}
