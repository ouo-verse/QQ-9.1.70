package com.qzone.reborn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.ui.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneBaseAbsFeedView extends AbsFeedView {
    private Rect C;
    protected int D;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f59582d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f59583e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f59584f;

    /* renamed from: h, reason: collision with root package name */
    protected g f59585h;

    /* renamed from: i, reason: collision with root package name */
    protected int f59586i;

    /* renamed from: m, reason: collision with root package name */
    private Rect f59587m;

    public QZoneBaseAbsFeedView(Context context) {
        super(context);
        this.f59582d = new ColorDrawable(j.s());
        this.f59583e = new ColorDrawable(j.m());
        this.f59587m = new Rect();
        this.C = new Rect();
        this.D = 255;
        this.f59584f = context;
        setWillNotDraw(false);
    }

    protected boolean c() {
        return false;
    }

    public void drawBackground(Canvas canvas) {
        a(canvas);
        b(canvas);
    }

    public int getFeedBackgroundPart1Height() {
        if (c()) {
            return 0;
        }
        return AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        setBackgroundDrawablePosition(0, 0, getMeasuredWidth(), getMeasuredHeight());
        drawBackground(canvas);
        super.onDraw(canvas);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        this.D = i3;
        this.f59582d.setAlpha(i3);
        this.f59583e.setAlpha(this.D);
    }

    public void setBackgroundDrawablePosition(int i3, int i16, int i17, int i18) {
        Rect rect = this.f59587m;
        if (rect == null || this.C == null) {
            return;
        }
        rect.left = i3;
        rect.top = i16;
        rect.right = i17;
        rect.bottom = getFeedBackgroundPart1Height() + i16;
        Rect rect2 = this.C;
        rect2.left = i3;
        rect2.top = i16 + getFeedBackgroundPart1Height();
        Rect rect3 = this.C;
        rect3.right = i17;
        rect3.bottom = i18;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.f59586i = i3;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(g gVar) {
        this.f59585h = gVar;
    }

    private void b(Canvas canvas) {
        Drawable drawable;
        Rect rect;
        if (canvas == null || (drawable = this.f59583e) == null || (rect = this.C) == null) {
            return;
        }
        drawable.setBounds(rect);
        this.f59583e.draw(canvas);
    }

    public void a(Canvas canvas) {
        Drawable drawable;
        Rect rect;
        if (canvas == null || (drawable = this.f59582d) == null || (rect = this.f59587m) == null) {
            return;
        }
        drawable.setBounds(rect);
        this.f59582d.draw(canvas);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
