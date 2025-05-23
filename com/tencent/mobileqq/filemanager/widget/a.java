package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.widget.tip.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/filemanager/widget/a;", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "d", "a", "", "c", "onShow", "onDismiss", "", WidgetCacheConstellationData.INTERVAL, "b", "Lcom/tencent/mobileqq/widget/tip/a;", "Lcom/tencent/mobileqq/widget/tip/a;", "mBubbleTip", "Z", "mIsShowing", "J", "mDismissTimestamp", "<init>", "(Lcom/tencent/mobileqq/widget/tip/a;)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements a.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.tip.a mBubbleTip;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mDismissTimestamp;

    public a(@NotNull com.tencent.mobileqq.widget.tip.a mBubbleTip) {
        Intrinsics.checkNotNullParameter(mBubbleTip, "mBubbleTip");
        this.mBubbleTip = mBubbleTip;
        mBubbleTip.f(this);
    }

    public final void a() {
        this.mBubbleTip.o();
    }

    public final boolean b(long interval) {
        if (System.currentTimeMillis() - this.mDismissTimestamp <= interval) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMIsShowing() {
        return this.mIsShowing;
    }

    public final void d() {
        this.mIsShowing = true;
        this.mBubbleTip.s0();
        this.mDismissTimestamp = 0L;
    }

    @Override // com.tencent.mobileqq.widget.tip.a.b
    public /* bridge */ /* synthetic */ void onClick(View view) {
        l53.d.a(this, view);
    }

    @Override // com.tencent.mobileqq.widget.tip.a.b
    public void onDismiss() {
        this.mIsShowing = false;
        this.mDismissTimestamp = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.widget.tip.a.b
    public void onShow() {
    }
}
