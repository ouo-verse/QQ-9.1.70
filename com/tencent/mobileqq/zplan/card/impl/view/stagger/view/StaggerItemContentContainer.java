package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import ag3.a;
import ag3.c;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import zf3.StaggerItemData;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000bB\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContentContainer;", "Landroid/widget/FrameLayout;", "Lag3/a;", "", "Lyf3/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lzf3/e;", "data", "", "selfPos", "", "a", "c", "", "d", "canPlay", "b", "e", "Lag3/c;", "Lag3/c;", "mCache", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContent;", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContent;", "mStaggerItemContent", "f", "I", "mState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lag3/c;)V", h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerItemContentContainer extends FrameLayout implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c mCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private StaggerItemContent mStaggerItemContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerItemContentContainer(Context context, c mCache) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mCache, "mCache");
        this.mCache = mCache;
        this.mState = 2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(i.a(0.5f), Color.parseColor("#21648CA6"));
        gradientDrawable.setCornerRadius(i.e(5));
        setBackground(gradientDrawable);
    }

    public boolean a(yf3.a card, StaggerItemData data, int selfPos) {
        boolean d16;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.mState == 1) {
            QLog.e("StaggerItemContentContainer_", 1, this + " already bind!");
        }
        StaggerItemContent staggerItemContent = this.mStaggerItemContent;
        if (staggerItemContent != null) {
            d16 = staggerItemContent.d(card, data, selfPos);
        } else {
            StaggerItemContent e16 = this.mCache.e();
            d16 = e16.d(card, data, selfPos);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            removeAllViews();
            addView(e16, layoutParams);
            this.mStaggerItemContent = e16;
        }
        this.mState = 1;
        return d16;
    }

    public boolean b(boolean canPlay) {
        StaggerItemContent staggerItemContent = this.mStaggerItemContent;
        if (this.mState == 2 || staggerItemContent == null) {
            return false;
        }
        return staggerItemContent.e(canPlay);
    }

    public boolean c() {
        StaggerItemContent staggerItemContent = this.mStaggerItemContent;
        if (this.mState == 2 || staggerItemContent == null) {
            return false;
        }
        return staggerItemContent.f();
    }

    public void d() {
        StaggerItemContent staggerItemContent = this.mStaggerItemContent;
        if (staggerItemContent == null) {
            return;
        }
        staggerItemContent.l();
        ViewParent parent = staggerItemContent.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(staggerItemContent);
        }
        this.mCache.d(staggerItemContent);
        this.mStaggerItemContent = null;
        this.mState = 2;
    }

    public void e() {
        StaggerItemContent staggerItemContent = this.mStaggerItemContent;
        if (staggerItemContent != null) {
            staggerItemContent.m();
        }
    }
}
