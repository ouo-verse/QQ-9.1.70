package com.tencent.qqmini.sdk.widget.media.danmu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BarrageView extends RelativeLayout implements Comparator<Barrage> {
    private static final boolean DEFAULT_ALLOWREPEAT = true;
    private static final int DEFAULT_BARRAGESIZE = 10;
    private static final int DEFAULT_BORDERCOLOR = -16777216;
    private static final int DEFAULT_LINEHEIGHT = 24;
    private static final int DEFAULT_MAXTEXTSIZE = 18;
    private static final int DEFAULT_MINTEXTSIZE = 14;
    private static final int DEFAULT_PADDING = 15;
    private static final boolean DEFAULT_RANDOMCOLOR = false;
    private static final String TAG = "BarrageView";
    private final SparseArray<Animation> animCache;
    private final List<Barrage> barrages;
    private int borderColor;
    private int lastShowBarrageIndex;
    private long lastUpdateTime;
    private int lineHeight;
    private int maxBarrageSize;
    private int maxTextSize;
    private int minTextSize;
    private boolean noRepeat;
    private boolean randomColor;
    private int textBottomPadding;
    private int textLeftPadding;
    private int textRightPadding;
    private int textTopPadding;
    private final Set<Animation> transientAnimCache;
    private final List<Barrage> transientBarrages;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class RemoveViewOnEndAnimListenerAdapter implements Animation.AnimationListener {
        private final View view;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BarrageView.this.removeView(this.view);
        }

        RemoveViewOnEndAnimListenerAdapter(View view) {
            this.view = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public BarrageView(Context context) {
        this(context, null);
    }

    private Animation createBarrageAnim(int i3, Animation.AnimationListener animationListener) {
        Animation createTranslateAnim = AnimationHelper.createTranslateAnim(getContext(), i3, -DisplayUtil.getScreenWidth(getContext()));
        createTranslateAnim.setAnimationListener(animationListener);
        createTranslateAnim.setDuration(3000L);
        return createTranslateAnim;
    }

    private TextView createTextByBarrage(Barrage barrage, int i3, int i16) {
        TextView textView = new TextView(getContext());
        textView.setPadding(this.textLeftPadding, this.textTopPadding, this.textRightPadding, this.textBottomPadding);
        textView.setTextSize(i3);
        textView.setText(barrage.text);
        textView.setTextColor(barrage.color);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.topMargin = i16;
        Log.i(TAG, "createTextByBarrage: " + i16);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private int px2sp(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void showBarrage(List<Integer> list) {
        Log.i(TAG, "showBarrage: " + Arrays.toString(list.toArray()));
        int right = (getRight() - getLeft()) - getPaddingLeft();
        int i3 = this.minTextSize;
        Iterator<Integer> it = list.iterator();
        int i16 = 10;
        while (it.hasNext()) {
            final int intValue = it.next().intValue();
            if (this.animCache.get(intValue) == null) {
                TextView createTextByBarrage = createTextByBarrage(this.barrages.get(intValue), i3, i16);
                i16 += i3 * 3;
                Animation createBarrageAnim = createBarrageAnim(right, new RemoveViewOnEndAnimListenerAdapter(createTextByBarrage) { // from class: com.tencent.qqmini.sdk.widget.media.danmu.BarrageView.1
                    @Override // com.tencent.qqmini.sdk.widget.media.danmu.BarrageView.RemoveViewOnEndAnimListenerAdapter, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        super.onAnimationEnd(animation);
                        BarrageView.this.animCache.remove(intValue);
                    }
                });
                startBarrageAnim(createTextByBarrage, createBarrageAnim);
                this.animCache.put(intValue, createBarrageAnim);
            }
        }
        Iterator<Barrage> it5 = this.transientBarrages.iterator();
        while (it5.hasNext()) {
            TextView createTextByBarrage2 = createTextByBarrage(it5.next(), i3, i16);
            i16 += i3 * 3;
            Animation createBarrageAnim2 = createBarrageAnim(right, new RemoveViewOnEndAnimListenerAdapter(createTextByBarrage2) { // from class: com.tencent.qqmini.sdk.widget.media.danmu.BarrageView.2
                @Override // com.tencent.qqmini.sdk.widget.media.danmu.BarrageView.RemoveViewOnEndAnimListenerAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    BarrageView.this.transientAnimCache.remove(animation);
                }
            });
            startBarrageAnim(createTextByBarrage2, createBarrageAnim2);
            this.transientAnimCache.add(createBarrageAnim2);
        }
        this.transientBarrages.clear();
    }

    private void startBarrageAnim(TextView textView, Animation animation) {
        textView.startAnimation(animation);
        addView(textView);
    }

    public void destroy() {
        this.barrages.clear();
        for (int i3 = 0; i3 < this.animCache.size(); i3++) {
            this.animCache.valueAt(i3).cancel();
        }
        Iterator<Animation> it = this.transientAnimCache.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.animCache.clear();
        this.transientAnimCache.clear();
        this.lastUpdateTime = Long.MAX_VALUE;
        this.lastShowBarrageIndex = -1;
    }

    public void setBarrages(List<Barrage> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, this);
            if (this.barrages.equals(list)) {
                return;
            }
            destroy();
            this.barrages.addAll(list);
        }
    }

    public void showBarrageNextTime(Barrage barrage) {
        this.transientBarrages.add(barrage);
    }

    public void updateTime(long j3) {
        if (j3 >= 0) {
            long j16 = this.lastUpdateTime;
            if (j3 != j16) {
                if (j3 < j16) {
                    this.lastShowBarrageIndex = -1;
                }
                LinkedList linkedList = new LinkedList();
                int i3 = this.lastShowBarrageIndex;
                while (true) {
                    i3++;
                    if (i3 >= this.barrages.size()) {
                        break;
                    }
                    long j17 = this.barrages.get(i3).time * 1000;
                    if (j17 > j3) {
                        break;
                    }
                    this.lastShowBarrageIndex++;
                    if (j3 - j17 < 400) {
                        linkedList.add(Integer.valueOf(i3));
                    }
                }
                this.lastUpdateTime = j3;
                if (linkedList.size() > 0 || this.transientBarrages.size() > 0) {
                    showBarrage(linkedList);
                }
            }
        }
    }

    public BarrageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // java.util.Comparator
    public int compare(Barrage barrage, Barrage barrage2) {
        long j3 = barrage.time;
        long j16 = barrage2.time;
        if (j3 < j16) {
            return -1;
        }
        return j3 == j16 ? 0 : 1;
    }

    public BarrageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.barrages = new LinkedList();
        this.animCache = new SparseArray<>();
        this.transientBarrages = new LinkedList();
        this.transientAnimCache = new HashSet();
        this.lastUpdateTime = Long.MAX_VALUE;
        this.lastShowBarrageIndex = -1;
        this.textLeftPadding = 15;
        this.textRightPadding = 15;
        this.textTopPadding = 15;
        this.textBottomPadding = 15;
        this.maxBarrageSize = 10;
        this.maxTextSize = 18;
        this.minTextSize = 18;
        this.lineHeight = 24;
        this.borderColor = -16777216;
        this.randomColor = false;
        this.noRepeat = true;
        if (px2sp(context, 24) < this.maxTextSize) {
            this.maxTextSize = px2sp(context, this.lineHeight);
        }
    }
}
