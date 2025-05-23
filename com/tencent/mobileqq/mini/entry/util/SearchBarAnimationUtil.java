package com.tencent.mobileqq.mini.entry.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchBarAnimationUtil {
    private static final int ANIM_TIME = 250;
    public static final String TAG = "SearchBarAnimationUtil";
    private static float mAnimViewMovingYDistance;
    private static float mSearchBarKeywordMovingXDistance;

    private static void addAnimViewToWindow(Activity activity, View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.getStatusBarHeight(activity);
        activity.addContentView(view, layoutParams);
    }

    public static void runEnterAnim(Activity activity, final View view, final TextView textView) {
        addAnimViewToWindow(activity, view);
        setSearchBarKeyword(activity, textView);
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mobileqq.mini.entry.util.SearchBarAnimationUtil.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                SearchBarAnimationUtil.mSearchBarKeywordMovingXDistance = SearchBarAnimationUtil.getSearchBarKeywordMovingXDistance(view, textView);
                SearchBarAnimationUtil.mAnimViewMovingYDistance = SearchBarAnimationUtil.getAnimViewMovingYDistance(view);
                textView.animate().translationXBy(-SearchBarAnimationUtil.mSearchBarKeywordMovingXDistance).setDuration(250L).start();
                view.animate().translationYBy(-SearchBarAnimationUtil.mAnimViewMovingYDistance).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.mini.entry.util.SearchBarAnimationUtil.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(8);
                    }
                }).setDuration(250L).start();
                return false;
            }
        });
    }

    public static void runExitAnim(View view, TextView textView, final Animator.AnimatorListener animatorListener) {
        view.setVisibility(0);
        textView.animate().translationXBy(mSearchBarKeywordMovingXDistance).setDuration(250L).start();
        view.animate().translationYBy(mAnimViewMovingYDistance).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.mini.entry.util.SearchBarAnimationUtil.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener2 = animatorListener;
                if (animatorListener2 != null) {
                    animatorListener2.onAnimationStart(animator);
                }
            }
        }).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getAnimViewMovingYDistance(View view) {
        return view.findViewById(R.id.rlo).getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float getSearchBarKeywordMovingXDistance(View view, TextView textView) {
        return ((((LinearLayout) view.findViewById(R.id.rhi)).getMeasuredWidth() - textView.getMeasuredWidth()) - ViewUtils.dpToPx(18.0f)) / 2.0f;
    }

    private static void setSearchBarKeyword(Activity activity, TextView textView) {
        String qqStr = HardCodeUtil.qqStr(R.string.f172191o72);
        if (activity.getIntent().hasExtra(MiniAppSearchFragment.KEY_RECOMMEND_WORD)) {
            qqStr = activity.getIntent().getStringExtra(MiniAppSearchFragment.KEY_RECOMMEND_WORD);
        }
        textView.setText(qqStr);
    }
}
