package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u0016\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0017\u0010\u0016\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0016R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\"\u0010\u0006\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"\u00a8\u00062"}, d2 = {"Lcom/tencent/kuikly/core/views/ScrollerAttr;", "Lcom/tencent/kuikly/core/base/m;", "", "value", "", "scrollEnable", ScrollerAttr.BOUNCES_ENABLE, ScrollerAttr.LIMIT_BOUNCES_ENABLE, ScrollerAttr.SHOW_SCROLLER_INDICATOR, "enable", "pagingEnable", "", "margin", "visibleAreaIgnoreTopMargin", "visibleAreaIgnoreBottomMargin", ScrollerAttr.FLING_ENABLE, "syncEnable", "syncScroll", "maxOffset", ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET, "Lcom/tencent/kuikly/core/layout/FlexDirection;", NodeProps.FLEX_DIRECTION, ScrollerAttr.SCROLL_WITH_PARENT, "(Ljava/lang/Boolean;)V", "wrapContentSize", "", "direction", "panDirection", "touches", "minimumPanTouches", "Z", "getSyncScroll", "()Z", "setSyncScroll", "(Z)V", UserInfo.SEX_FEMALE, "getVisibleAreaIgnoreTopMargin", "()F", "setVisibleAreaIgnoreTopMargin", "(F)V", "getVisibleAreaIgnoreBottomMargin", "setVisibleAreaIgnoreBottomMargin", "getBouncesEnable$core_release", "setBouncesEnable$core_release", "getWrapContentSize$core_release", "setWrapContentSize$core_release", "<init>", "()V", "Companion", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ScrollerAttr extends com.tencent.kuikly.core.base.m {
    public static final String BOUNCES_ENABLE = "bouncesEnable";
    public static final String DIRECTION_ROW = "directionRow";
    public static final String FLING_ENABLE = "flingEnable";
    public static final String LIMIT_BOUNCES_ENABLE = "limitHeaderBounces";
    public static final String PAGING_ENABLED = "pagingEnabled";
    public static final String SCROLL_ENABLED = "scrollEnabled";
    public static final String SCROLL_WITH_PARENT = "scrollWithParent";
    public static final String SHOW_SCROLLER_INDICATOR = "showScrollerIndicator";
    public static final String SYNC_SCROLL_IN_MAX_OFFSET = "syncScrollInMaxOffset";
    private boolean bouncesEnable = true;
    private boolean syncScroll;
    private float visibleAreaIgnoreBottomMargin;
    private float visibleAreaIgnoreTopMargin;
    private boolean wrapContentSize;

    public final void bouncesEnable(boolean bouncesEnable, boolean limitHeaderBounces) {
        this.bouncesEnable = bouncesEnable;
        with(BOUNCES_ENABLE, Integer.valueOf(com.tencent.kuikly.core.base.d.b(bouncesEnable)));
        with(LIMIT_BOUNCES_ENABLE, Integer.valueOf(com.tencent.kuikly.core.base.d.b(limitHeaderBounces)));
    }

    public final void flingEnable(boolean enable) {
        with(FLING_ENABLE, Integer.valueOf(com.tencent.kuikly.core.base.d.b(enable)));
    }

    /* renamed from: getBouncesEnable$core_release, reason: from getter */
    public final boolean getBouncesEnable() {
        return this.bouncesEnable;
    }

    public final boolean getSyncScroll() {
        return this.syncScroll;
    }

    public final float getVisibleAreaIgnoreBottomMargin() {
        return this.visibleAreaIgnoreBottomMargin;
    }

    public final float getVisibleAreaIgnoreTopMargin() {
        return this.visibleAreaIgnoreTopMargin;
    }

    /* renamed from: getWrapContentSize$core_release, reason: from getter */
    public final boolean getWrapContentSize() {
        return this.wrapContentSize;
    }

    @Override // com.tencent.kuikly.core.base.Attr
    public void minimumPanTouches(final int touches) {
        super.minimumPanTouches(touches);
        AbstractBaseView<?, ?> view = view();
        ScrollerView scrollerView = view instanceof ScrollerView ? (ScrollerView) view : null;
        if (scrollerView != null) {
            scrollerView.performTaskWhenContentViewDidCreated(new Function1<ScrollerContentView, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerAttr$minimumPanTouches$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ScrollerContentView scrollerContentView) {
                    invoke2(scrollerContentView);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ScrollerContentView it) {
                    ScrollerContentView contentView;
                    Intrinsics.checkNotNullParameter(it, "it");
                    AbstractBaseView<?, ?> view2 = ScrollerAttr.this.view();
                    ScrollerView scrollerView2 = view2 instanceof ScrollerView ? (ScrollerView) view2 : null;
                    if (scrollerView2 == null || (contentView = scrollerView2.getContentView()) == null) {
                        return;
                    }
                    ((com.tencent.kuikly.core.base.m) contentView.getViewAttr()).minimumPanTouches(touches);
                }
            });
        }
    }

    public final void pagingEnable(boolean enable) {
        with(PAGING_ENABLED, Integer.valueOf(com.tencent.kuikly.core.base.d.b(enable)));
    }

    @Override // com.tencent.kuikly.core.base.Attr
    public void panDirection(final int direction) {
        super.panDirection(direction);
        if (direction != 0) {
            AbstractBaseView<?, ?> view = view();
            ScrollerView scrollerView = view instanceof ScrollerView ? (ScrollerView) view : null;
            if (scrollerView != null) {
                scrollerView.performTaskWhenContentViewDidCreated(new Function1<ScrollerContentView, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerAttr$panDirection$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ScrollerContentView scrollerContentView) {
                        invoke2(scrollerContentView);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ScrollerContentView it) {
                        ScrollerContentView contentView;
                        Intrinsics.checkNotNullParameter(it, "it");
                        AbstractBaseView<?, ?> view2 = ScrollerAttr.this.view();
                        ScrollerView scrollerView2 = view2 instanceof ScrollerView ? (ScrollerView) view2 : null;
                        if (scrollerView2 == null || (contentView = scrollerView2.getContentView()) == null) {
                            return;
                        }
                        ((com.tencent.kuikly.core.base.m) contentView.getViewAttr()).panDirection(direction);
                    }
                });
            }
        }
    }

    public final void scrollEnable(boolean value) {
        with(SCROLL_ENABLED, Integer.valueOf(com.tencent.kuikly.core.base.d.b(value)));
    }

    public final void setBouncesEnable$core_release(boolean z16) {
        this.bouncesEnable = z16;
    }

    public final void setSyncScroll(boolean z16) {
        this.syncScroll = z16;
    }

    public final void setVisibleAreaIgnoreBottomMargin(float f16) {
        this.visibleAreaIgnoreBottomMargin = f16;
    }

    public final void setVisibleAreaIgnoreTopMargin(float f16) {
        this.visibleAreaIgnoreTopMargin = f16;
    }

    public final void setWrapContentSize$core_release(boolean z16) {
        this.wrapContentSize = z16;
    }

    public final void showScrollerIndicator(boolean value) {
        with(SHOW_SCROLLER_INDICATOR, Integer.valueOf(com.tencent.kuikly.core.base.d.b(value)));
    }

    public final void syncScroll(boolean syncEnable) {
        this.syncScroll = syncEnable;
    }

    public final void syncScrollInMaxOffset(float maxOffset) {
        with(SYNC_SCROLL_IN_MAX_OFFSET, Float.valueOf(maxOffset));
    }

    public final void visibleAreaIgnoreBottomMargin(float margin) {
        this.visibleAreaIgnoreBottomMargin = margin;
    }

    public final void visibleAreaIgnoreTopMargin(float margin) {
        this.visibleAreaIgnoreTopMargin = margin;
    }

    @Override // com.tencent.kuikly.core.base.m
    public com.tencent.kuikly.core.base.m flexDirection(FlexDirection flexDirection) {
        Intrinsics.checkNotNullParameter(flexDirection, "flexDirection");
        with(DIRECTION_ROW, Integer.valueOf(com.tencent.kuikly.core.base.d.b(flexDirection == FlexDirection.ROW || flexDirection == FlexDirection.ROW_REVERSE)));
        return super.flexDirection(flexDirection);
    }

    public final void wrapContentSize() {
        this.wrapContentSize = true;
    }

    public final void scrollWithParent(Boolean enable) {
        with(SCROLL_WITH_PARENT, Integer.valueOf(enable != null ? com.tencent.kuikly.core.base.d.b(enable.booleanValue()) : -1));
    }

    public static /* synthetic */ void bouncesEnable$default(ScrollerAttr scrollerAttr, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = false;
            }
            scrollerAttr.bouncesEnable(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bouncesEnable");
    }
}
