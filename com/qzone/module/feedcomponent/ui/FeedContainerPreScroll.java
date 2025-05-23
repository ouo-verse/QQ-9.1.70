package com.qzone.module.feedcomponent.ui;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.qzone.module.feedcomponent.ui.common.CenterViewPager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.component.animation.rebound.SimpleSpringListener;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.component.animation.rebound.SpringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes39.dex */
public class FeedContainerPreScroll {
    static final String KEY_PRE_SCROLL = "qzone_feed_container_pre_scroll";
    public static int scrolledCount;
    SharedPreferences mPrescrollPreference;
    float mScrollTo;
    CenterViewPager mViewPager;
    Spring popAnimationSpring;
    Spring pushAnimationSpring;
    public String TAG = getClass().getName();
    final int MAX_PRE_SCROLL_NUM = 3;

    void animateScroll() {
        final float f16 = this.mScrollTo;
        SpringSystem create = SpringSystem.create();
        this.popAnimationSpring = create.createSpring().setSpringConfig(SpringConfig.fromBouncinessAndSpeed(14.0d, 13.0d)).addListener(new SimpleSpringListener() { // from class: com.qzone.module.feedcomponent.ui.FeedContainerPreScroll.1
            @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
                FeedContainerPreScroll.this.pushAnimationSpring.setEndValue(1.0d);
            }

            @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                FeedContainerPreScroll.this.setPopAnimationProgress((float) spring.getCurrentValue(), true, FeedContainerPreScroll.this.mViewPager, f16);
            }
        });
        this.pushAnimationSpring = create.createSpring().setSpringConfig(SpringConfig.fromBouncinessAndSpeed(14.0d, 13.0d)).addListener(new SimpleSpringListener() { // from class: com.qzone.module.feedcomponent.ui.FeedContainerPreScroll.2
            @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
            }

            @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                FeedContainerPreScroll.this.setPopAnimationProgress((float) spring.getCurrentValue(), false, FeedContainerPreScroll.this.mViewPager, f16);
            }
        });
        this.popAnimationSpring.setEndValue(1.0d);
    }

    public void clearPreScroll() {
        savePreScroll(new ArrayList());
    }

    boolean feedAllow(BusinessFeedData businessFeedData) {
        return businessFeedData.isAdFeeds() && !businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds();
    }

    public void feedScrolledByUser(BusinessFeedData businessFeedData) {
        if (scrolledCount < 3) {
            setPreScrollFull();
        }
    }

    public List<String> getPreScroll() {
        String string = getPreScrollPreferences().getString(KEY_PRE_SCROLL, "");
        return !TextUtils.isEmpty(string) ? new ArrayList(Arrays.asList(string.split(","))) : new ArrayList();
    }

    public SharedPreferences getPreScrollPreferences() {
        if (this.mPrescrollPreference == null) {
            FeedGlobalEnv g16 = FeedGlobalEnv.g();
            FeedGlobalEnv.g();
            this.mPrescrollPreference = g16.getCachePreference(FeedGlobalEnv.getContext(), com.qzone.adapter.feedcomponent.i.H().j0());
        }
        return this.mPrescrollPreference;
    }

    public void saveCount(BusinessFeedData businessFeedData) {
        String feedsKey = getFeedsKey(businessFeedData);
        List<String> preScroll = getPreScroll();
        preScroll.add(feedsKey);
        savePreScroll(preScroll);
    }

    public void savePreScroll(List<String> list) {
        getPreScrollPreferences().edit().putString(KEY_PRE_SCROLL, TextUtils.join(",", list)).commit();
        scrolledCount = list.size();
        com.qzone.proxy.feedcomponent.b.a(this.TAG, "the scrollcount : " + scrolledCount + ", keys is: " + TextUtils.join(",", list));
    }

    public void setPreScrollFull() {
        List<String> preScroll = getPreScroll();
        int size = preScroll.size();
        if (size < 3) {
            while (size < 3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fake_");
                size++;
                sb5.append(size);
                sb5.append("");
                preScroll.add(sb5.toString());
            }
            savePreScroll(preScroll);
            return;
        }
        scrolledCount = preScroll.size();
        com.qzone.proxy.feedcomponent.b.a(this.TAG, "the scrollcount : " + scrolledCount + ", keys is: " + TextUtils.join(",", preScroll));
    }

    boolean versionAllow() {
        return true;
    }

    public boolean isViewVisable() {
        int[] iArr = new int[2];
        this.mViewPager.getLocationOnScreen(iArr);
        int height = this.mViewPager.getHeight();
        int i3 = iArr[1];
        boolean z16 = i3 > com.qzone.proxy.feedcomponent.util.g.a(75.0f) + AreaConst.dp5;
        boolean z17 = i3 < (FeedGlobalEnv.g().getScreenHeight() - height) - AreaConst.dp10;
        com.qzone.proxy.feedcomponent.b.a(this.TAG, "location: " + i3 + ";viewpage height: " + height + "; notoverTop : " + z16 + "; notbeblowBottom : " + z17);
        return z16 && z17;
    }

    public String getFeedsKey(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            return businessFeedData.getFeedCommInfoV2().feedskey;
        }
        return "";
    }

    public void preScrollContent(BusinessFeedData businessFeedData, CenterViewPager centerViewPager, float f16, ListAdapter listAdapter, int i3) {
        if (listAdapter == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.a(this.TAG, "adapter: " + listAdapter.getCount() + "; feedpos" + i3);
        if (businessFeedData == null || centerViewPager == null || !feedAllow(businessFeedData) || !versionAllow() || i3 >= listAdapter.getCount()) {
            return;
        }
        this.mViewPager = centerViewPager;
        this.mScrollTo = f16;
        List<String> preScroll = getPreScroll();
        com.qzone.proxy.feedcomponent.b.a(this.TAG, "try scroll, userScrolled size: " + preScroll.size());
        if (preScroll.size() >= 3 || preScroll.contains(getFeedsKey(businessFeedData)) || !isViewVisable()) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.a(this.TAG, "can scroll , userScrolled size: " + preScroll.size());
        animateScroll();
        saveCount(businessFeedData);
    }

    public void setPopAnimationProgress(float f16, boolean z16, CenterViewPager centerViewPager, float f17) {
        float f18 = 0.0f;
        if (z16) {
            f18 = f17;
            f17 = 0.0f;
        }
        int transition = (int) transition(f16, f17, f18);
        com.qzone.proxy.feedcomponent.b.a("satan-xx", "tran2:  " + transition);
        centerViewPager.scrollTo(transition, 0);
    }

    public float transition(float f16, float f17, float f18) {
        return (float) SpringUtil.mapValueFromRangeToRange(f16, 0.0d, 1.0d, f17, f18);
    }
}
