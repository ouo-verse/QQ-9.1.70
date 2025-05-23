package com.tencent.ntcompose.foundation.lazy;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerContentView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ad;
import com.tencent.kuikly.core.views.bs;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.ntcompose.foundation.scheduler.Choreographer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import to3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u001e\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005H\u0016J.\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0006\u0010\u0018\u001a\u00020\rJ\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\"\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016RD\u0010+\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\u00052\u0016\u0010'\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\"\u0010(\u001a\u0004\b)\u0010*R\"\u00101\u001a\u00020\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\n028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\n028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\r028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00104R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010B\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b;\u0010AR\u0011\u0010D\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b6\u0010CR\u0011\u0010E\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010CR\u0011\u0010H\u001a\u00020F8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010GR\u0011\u0010I\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b9\u0010C\u00a8\u0006L"}, d2 = {"Lcom/tencent/ntcompose/foundation/lazy/f;", "", "Lcom/tencent/kuikly/core/views/ad;", "Lto3/b;", "Lcom/tencent/ntcompose/foundation/scheduler/Choreographer$b;", "Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/views/ScrollerView;", "ref", "", "i", "", "offsetX", "offsetY", "", "animated", "Lcom/tencent/kuikly/core/views/bs;", "springAnimation", "k", "contentOffsetX", "contentOffsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "onContentOffsetDidChanged", "subViewsDidLayout", "j", "width", "height", "contentSizeDidChanged", "scrollerDragBegin", "scrollerScrollDidEnd", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "scrollFrameDidChanged", "offsetDp", "a", "b", "", "frameTimeNanos", "doFrame", "<set-?>", "Lcom/tencent/kuikly/core/base/aa;", "getScrollRef", "()Lcom/tencent/kuikly/core/base/aa;", "scrollRef", "Z", "e", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "didCallSetContentOffset", "Landroidx/compose/runtime/MutableState;", "c", "Landroidx/compose/runtime/MutableState;", "contentSizeState", "d", "contentOffsetState", "scrollingState", "f", "scrollerFrameState", "g", UserInfo.SEX_FEMALE, "scrollOffsetPerFrame", h.F, "J", "lastScrollCallbackTimestamp", "()Lcom/tencent/kuikly/core/views/ScrollerView;", "scrollView", "()F", "contentSize", "contentOffset", "Lcom/tencent/kuikly/core/base/w;", "()Lcom/tencent/kuikly/core/base/w;", "scrollViewSize", "maxOffset", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class f implements ad, to3.b, Choreographer.b {

    /* renamed from: a, reason: from kotlin metadata */
    private aa<ScrollerView<?, ?>> scrollRef;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean didCallSetContentOffset;

    /* renamed from: c, reason: from kotlin metadata */
    private final MutableState<Float> contentSizeState;

    /* renamed from: d, reason: from kotlin metadata */
    private final MutableState<Float> contentOffsetState;

    /* renamed from: e, reason: from kotlin metadata */
    private final MutableState<Boolean> scrollingState;

    /* renamed from: f, reason: from kotlin metadata */
    private final MutableState<com.tencent.kuikly.core.layout.d> scrollerFrameState;

    /* renamed from: g */
    private float scrollOffsetPerFrame;

    /* renamed from: h */
    private long lastScrollCallbackTimestamp;

    public f() {
        MutableState<Float> mutableStateOf$default;
        MutableState<Float> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        MutableState<com.tencent.kuikly.core.layout.d> mutableStateOf$default4;
        Float valueOf = Float.valueOf(0.0f);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.contentSizeState = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.contentOffsetState = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.scrollingState = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.tencent.kuikly.core.layout.d.INSTANCE.a(), null, 2, null);
        this.scrollerFrameState = mutableStateOf$default4;
    }

    @Override // to3.b
    public float a(float offsetDp, boolean animated, bs springAnimation) {
        ScrollerContentView contentView;
        float offsetY;
        float max;
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        ScrollerContentView contentView2;
        FlexNode flexNode2;
        com.tencent.kuikly.core.layout.d layoutFrame2;
        FlexNode flexNode3;
        com.tencent.kuikly.core.layout.d layoutFrame3;
        ScrollerContentView contentView3;
        FlexNode flexNode4;
        com.tencent.kuikly.core.layout.d layoutFrame4;
        ScrollerContentView contentView4;
        if (j()) {
            ScrollerView<?, ?> g16 = g();
            if (g16 != null && (contentView4 = g16.getContentView()) != null) {
                offsetY = contentView4.getOffsetX();
            }
            offsetY = 0.0f;
        } else {
            ScrollerView<?, ?> g17 = g();
            if (g17 != null && (contentView = g17.getContentView()) != null) {
                offsetY = contentView.getOffsetY();
            }
            offsetY = 0.0f;
        }
        float f16 = offsetY + offsetDp;
        if (j()) {
            ScrollerView<?, ?> g18 = g();
            float width = (g18 == null || (contentView3 = g18.getContentView()) == null || (flexNode4 = contentView3.getFlexNode()) == null || (layoutFrame4 = flexNode4.getLayoutFrame()) == null) ? 0.0f : layoutFrame4.getWidth();
            ScrollerView<?, ?> g19 = g();
            max = Math.max(width - ((g19 == null || (flexNode3 = g19.getFlexNode()) == null || (layoutFrame3 = flexNode3.getLayoutFrame()) == null) ? 0.0f : layoutFrame3.getWidth()), 0.0f);
        } else {
            ScrollerView<?, ?> g26 = g();
            float height = (g26 == null || (contentView2 = g26.getContentView()) == null || (flexNode2 = contentView2.getFlexNode()) == null || (layoutFrame2 = flexNode2.getLayoutFrame()) == null) ? 0.0f : layoutFrame2.getHeight();
            ScrollerView<?, ?> g27 = g();
            max = Math.max(height - ((g27 == null || (flexNode = g27.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getHeight()), 0.0f);
        }
        if (f16 > max) {
            offsetDp = max - offsetY;
        } else if (f16 < 0.0f) {
            offsetDp = 0.0f - offsetY;
        }
        b(offsetY + offsetDp, animated, springAnimation);
        return offsetDp;
    }

    @Override // to3.b
    public void b(float offsetDp, boolean animated, bs springAnimation) {
        if (j()) {
            k(offsetDp, 0.0f, animated, springAnimation);
        } else {
            k(0.0f, offsetDp, animated, springAnimation);
        }
    }

    public final float c() {
        return this.contentOffsetState.getValue().floatValue();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentSizeDidChanged(float width, float height) {
        ad.a.a(this, width, height);
        if (j()) {
            this.contentSizeState.setValue(Float.valueOf(width));
        } else {
            this.contentSizeState.setValue(Float.valueOf(height));
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentViewDidSetFrameToRenderView() {
        ad.a.b(this);
    }

    public final float d() {
        return this.contentSizeState.getValue().floatValue();
    }

    @Override // com.tencent.ntcompose.foundation.scheduler.Choreographer.b
    public void doFrame(long frameTimeNanos) {
        if ((this.scrollOffsetPerFrame == 0.0f) || g() == null) {
            return;
        }
        long j3 = this.lastScrollCallbackTimestamp;
        if (j3 == 0) {
            b.a.a(this, this.scrollOffsetPerFrame, false, null, 6, null);
        } else {
            b.a.a(this, this.scrollOffsetPerFrame * ((((float) ((frameTimeNanos - j3) / 1000)) * 1.0f) / 16.0f), false, null, 6, null);
        }
        this.lastScrollCallbackTimestamp = frameTimeNanos;
        Choreographer.INSTANCE.a().d(this);
    }

    /* renamed from: e, reason: from getter */
    public final boolean getDidCallSetContentOffset() {
        return this.didCallSetContentOffset;
    }

    public final float f() {
        if (j()) {
            return Math.max(d() - h().getWidth(), 0.0f);
        }
        return Math.max(d() - h().getHeight(), 0.0f);
    }

    public final ScrollerView<?, ?> g() {
        aa<ScrollerView<?, ?>> aaVar = this.scrollRef;
        if (aaVar != null) {
            return aaVar.b();
        }
        return null;
    }

    public final w h() {
        return new w(this.scrollerFrameState.getValue().getWidth(), this.scrollerFrameState.getValue().getHeight());
    }

    public void i(aa<ScrollerView<?, ?>> ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        ScrollerView<?, ?> b16 = ref.b();
        aa<ScrollerView<?, ?>> aaVar = this.scrollRef;
        if (Intrinsics.areEqual(b16, aaVar != null ? aaVar.b() : null)) {
            return;
        }
        this.scrollRef = ref;
        ScrollerView<?, ?> b17 = ref.b();
        if (b17 != null) {
            b17.addScrollerViewEventObserver(this);
        }
    }

    public final boolean j() {
        ScrollerView<?, ?> g16 = g();
        return g16 != null && g16.isRowFlexDirection();
    }

    public final void m(boolean z16) {
        this.didCallSetContentOffset = z16;
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (j()) {
            this.contentOffsetState.setValue(Float.valueOf(contentOffsetX));
        } else {
            this.contentOffsetState.setValue(Float.valueOf(contentOffsetY));
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollFrameDidChanged(com.tencent.kuikly.core.layout.d r26) {
        Intrinsics.checkNotNullParameter(r26, "frame");
        ad.a.d(this, r26);
        if (this.scrollerFrameState.getValue().equals(r26)) {
            return;
        }
        this.scrollerFrameState.setValue(r26);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollerDragBegin(ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ad.a.e(this, params);
        if (this.scrollingState.getValue().booleanValue()) {
            return;
        }
        this.scrollingState.setValue(Boolean.TRUE);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollerScrollDidEnd(ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ad.a.f(this, params);
        if (this.scrollingState.getValue().booleanValue()) {
            this.scrollingState.setValue(Boolean.FALSE);
        }
    }

    public void k(float offsetX, float offsetY, boolean animated, bs springAnimation) {
        this.didCallSetContentOffset = true;
        float f16 = f();
        if (j()) {
            if (offsetX >= f16 - 0.1d) {
                offsetX = com.tencent.kuikly.core.utils.b.a(f16);
            }
        } else if (offsetY >= f16 - 0.1d) {
            offsetY = com.tencent.kuikly.core.utils.b.a(f16);
        }
        ScrollerView<?, ?> g16 = g();
        if (g16 != null) {
            g16.setContentOffset(offsetX, offsetY, animated, springAnimation);
        }
    }

    public static /* synthetic */ void l(f fVar, float f16, float f17, boolean z16, bs bsVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            if ((i3 & 8) != 0) {
                bsVar = null;
            }
            fVar.k(f16, f17, z16, bsVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentOffset");
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void subViewsDidLayout() {
    }
}
