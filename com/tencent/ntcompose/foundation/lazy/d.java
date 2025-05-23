package com.tencent.ntcompose.foundation.lazy;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.bs;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import to3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010.\u001a\u00020\r\u0012\b\b\u0002\u00103\u001a\u00020\u0006\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J0\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J \u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\rJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0%J\u0019\u0010(\u001a\u00020\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b(\u0010)R\u0017\u0010.\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00103\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\r048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00105R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0006048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00105R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u000209048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00105R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010<R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010?R\u001e\u0010D\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010A8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/ntcompose/foundation/lazy/d;", "Lcom/tencent/ntcompose/foundation/lazy/f;", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "", "isRow", "", DomainData.DOMAIN_NAME, "o", "offset", "scrollViewSize", "", "v", "", "targetIndex", "t", "y", "index", "scrollOffset", "animated", "Lcom/tencent/kuikly/core/views/bs;", "springAnimation", "w", "offsetX", "offsetY", "k", "width", "height", "contentSizeDidChanged", "contentOffsetX", "contentOffsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "onContentOffsetDidChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)Ljava/lang/Float;", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "minOffset", "u", "(Ljava/lang/Float;)V", "i", "I", "r", "()I", "initialFirstVisibleItemIndex", "j", UserInfo.SEX_FEMALE, "getInitialFirstVisibleItemScrollOffset", "()F", "initialFirstVisibleItemScrollOffset", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "firstVisibleItemIndexState", "l", "firstVisibleItemScrollOffsetState", "Lcom/tencent/ntcompose/foundation/lazy/LazyListLayoutInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "layoutInfoState", "Z", "didInitFirstVisibleItemIndex", "needListenOffsetChanged", "Ljava/lang/Float;", "limitMinOffset", "Lcom/tencent/kuikly/core/views/aq;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/kuikly/core/views/aq;", "listView", "<init>", "(IF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class d extends f {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int initialFirstVisibleItemIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float initialFirstVisibleItemScrollOffset;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final MutableState<Integer> firstVisibleItemIndexState;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final MutableState<Float> firstVisibleItemScrollOffsetState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableState<LazyListLayoutInfo> layoutInfoState;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean didInitFirstVisibleItemIndex;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean needListenOffsetChanged;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Float limitMinOffset;

    public d() {
        this(0, 0.0f, 3, null);
    }

    private final aq<?, ?> s() {
        ScrollerView<?, ?> g16 = g();
        if (g16 instanceof aq) {
            return (aq) g16;
        }
        return null;
    }

    private final void t(int targetIndex) {
        ScrollerView<?, ?> g16 = g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
        int currentPageIndex = targetIndex - ((PageListView) g16).getCurrentPageIndex();
        if (Math.abs(currentPageIndex) > 1) {
            float f16 = 0.0f;
            if (currentPageIndex > 0) {
                Float q16 = q(targetIndex - 1);
                if (q16 != null) {
                    f16 = q16.floatValue();
                }
            } else {
                Float q17 = q(targetIndex + 1);
                if (q17 != null) {
                    f16 = q17.floatValue();
                }
            }
            b.a.b(this, f16 + (currentPageIndex <= 0 ? -1 : 1), false, null, 4, null);
        }
    }

    private final void v(float offset, boolean isRow, float scrollViewSize) {
        List<DeclarativeBaseView<?, ?>> emptyList;
        float j3;
        float h16;
        ArrayList arrayList = new ArrayList();
        aq<?, ?> s16 = s();
        if (s16 == null || (emptyList = s16.listItems()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator<DeclarativeBaseView<?, ?>> it = emptyList.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (it.hasNext()) {
            com.tencent.kuikly.core.layout.d layoutFrame = it.next().getFlexNode().getLayoutFrame();
            if (!layoutFrame.f()) {
                if (!z16 && n(layoutFrame, isRow) >= offset) {
                    if (this.firstVisibleItemIndexState.getValue().intValue() != i3) {
                        this.firstVisibleItemIndexState.setValue(Integer.valueOf(i3));
                    }
                    float o16 = offset - o(layoutFrame, isRow);
                    if (!(this.firstVisibleItemScrollOffsetState.getValue().floatValue() == o16)) {
                        this.firstVisibleItemScrollOffsetState.setValue(Float.valueOf(o16));
                    }
                    z16 = true;
                }
                if (isRow) {
                    j3 = layoutFrame.i();
                } else {
                    j3 = layoutFrame.j();
                }
                if (isRow) {
                    h16 = layoutFrame.g();
                } else {
                    h16 = layoutFrame.h();
                }
                if (h16 > offset && j3 < offset + scrollViewSize) {
                    arrayList.add(new c(i3, j3, h16 - j3));
                }
            }
            i3++;
        }
        this.layoutInfoState.setValue(new LazyListLayoutInfo(arrayList, offset, offset + scrollViewSize, emptyList.size(), d()));
    }

    private final void y() {
        Float f16 = this.limitMinOffset;
        if (f16 != null) {
            float floatValue = f16.floatValue();
            if (c() < floatValue) {
                b.a.b(this, floatValue, false, null, 4, null);
            }
        }
    }

    @Override // com.tencent.ntcompose.foundation.lazy.f, com.tencent.kuikly.core.views.ad
    public void contentSizeDidChanged(float width, float height) {
        float curOffsetY;
        super.contentSizeDidChanged(width, height);
        aq<?, ?> s16 = s();
        if (s16 != null && this.needListenOffsetChanged) {
            boolean j3 = j();
            if (j3) {
                curOffsetY = s16.getCurOffsetX();
            } else {
                curOffsetY = s16.getCurOffsetY();
            }
            w h16 = h();
            if (j3) {
                h16.getWidth();
            } else {
                h16.getHeight();
            }
            v(curOffsetY, j3, h().getWidth());
        }
        if (width <= 0.0f || height <= 0.0f || this.didInitFirstVisibleItemIndex) {
            return;
        }
        this.didInitFirstVisibleItemIndex = true;
        int i3 = this.initialFirstVisibleItemIndex;
        if (i3 == 0) {
            if (this.initialFirstVisibleItemScrollOffset == 0.0f) {
                return;
            }
        }
        x(this, i3, this.initialFirstVisibleItemScrollOffset, false, null, 12, null);
    }

    @Override // com.tencent.ntcompose.foundation.lazy.f
    public void k(float offsetX, float offsetY, boolean animated, bs springAnimation) {
        super.k(offsetX, offsetY, animated, springAnimation);
    }

    @Override // com.tencent.ntcompose.foundation.lazy.f, com.tencent.kuikly.core.views.ad
    public void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        float viewHeight;
        Intrinsics.checkNotNullParameter(params, "params");
        super.onContentOffsetDidChanged(contentOffsetX, contentOffsetY, params);
        if (this.needListenOffsetChanged) {
            boolean j3 = j();
            if (!j3) {
                contentOffsetX = contentOffsetY;
            }
            if (j3) {
                viewHeight = params.getViewWidth();
            } else {
                viewHeight = params.getViewHeight();
            }
            v(contentOffsetX, j3, viewHeight);
        }
        y();
    }

    public final com.tencent.kuikly.core.layout.d p(int index) {
        DeclarativeBaseView declarativeBaseView;
        List<DeclarativeBaseView<?, ?>> listItems;
        Object orNull;
        aq<?, ?> s16 = s();
        if (s16 == null || (listItems = s16.listItems()) == null) {
            declarativeBaseView = null;
        } else {
            orNull = CollectionsKt___CollectionsKt.getOrNull(listItems, index);
            declarativeBaseView = (DeclarativeBaseView) orNull;
        }
        if (declarativeBaseView == null || declarativeBaseView.getFlexNode().getLayoutFrame().f()) {
            return null;
        }
        return declarativeBaseView.getFlexNode().getLayoutFrame();
    }

    public final Float q(int index) {
        DeclarativeBaseView declarativeBaseView;
        List<DeclarativeBaseView<?, ?>> listItems;
        Object orNull;
        aq<?, ?> s16 = s();
        if (s16 == null || (listItems = s16.listItems()) == null) {
            declarativeBaseView = null;
        } else {
            orNull = CollectionsKt___CollectionsKt.getOrNull(listItems, index);
            declarativeBaseView = (DeclarativeBaseView) orNull;
        }
        if (declarativeBaseView == null || declarativeBaseView.getFlexNode().getLayoutFrame().f()) {
            return null;
        }
        aq<?, ?> s17 = s();
        if (s17 != null ? s17.isRowFlexDirection() : false) {
            return Float.valueOf(declarativeBaseView.getFlexNode().getLayoutFrame().getX());
        }
        return Float.valueOf(declarativeBaseView.getFlexNode().getLayoutFrame().getY());
    }

    /* renamed from: r, reason: from getter */
    public final int getInitialFirstVisibleItemIndex() {
        return this.initialFirstVisibleItemIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(Float minOffset) {
        ScrollerAttr scrollerAttr;
        ScrollerAttr scrollerAttr2;
        this.limitMinOffset = minOffset;
        if (minOffset == null) {
            ScrollerView<?, ?> g16 = g();
            if (g16 == null || (scrollerAttr2 = (ScrollerAttr) g16.getViewAttr()) == null) {
                return;
            }
            scrollerAttr2.syncScrollInMaxOffset(-100000.0f);
            return;
        }
        ScrollerView<?, ?> g17 = g();
        if (g17 != null && (scrollerAttr = (ScrollerAttr) g17.getViewAttr()) != null) {
            scrollerAttr.syncScrollInMaxOffset(minOffset.floatValue());
        }
        y();
    }

    public final List<Integer> z() {
        List<DeclarativeBaseView<?, ?>> listItems;
        ArrayList arrayList = new ArrayList();
        float c16 = c();
        aq<?, ?> s16 = s();
        if (s16 != null && (listItems = s16.listItems()) != null) {
            int i3 = 0;
            for (Object obj : listItems) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.kuikly.core.layout.d layoutFrame = ((DeclarativeBaseView) obj).getFlexNode().getLayoutFrame();
                if (!layoutFrame.f()) {
                    if (j()) {
                        if (layoutFrame.i() < h().getWidth() + c16 && layoutFrame.g() > c16) {
                            arrayList.add(Integer.valueOf(i3));
                        }
                    } else if (layoutFrame.j() < h().getHeight() + c16 && layoutFrame.h() > c16) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                i3 = i16;
            }
        }
        return arrayList;
    }

    public /* synthetic */ d(int i3, float f16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0.0f : f16);
    }

    public d(int i3, float f16) {
        this.initialFirstVisibleItemIndex = i3;
        this.initialFirstVisibleItemScrollOffset = f16;
        this.firstVisibleItemIndexState = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i3), null, 2, null);
        this.firstVisibleItemScrollOffsetState = SnapshotStateKt.mutableStateOf$default(Float.valueOf(f16), null, 2, null);
        this.layoutInfoState = SnapshotStateKt.mutableStateOf$default(LazyListLayoutInfo.INSTANCE.a(), null, 2, null);
    }

    private final float n(com.tencent.kuikly.core.layout.d frame, boolean isRow) {
        if (isRow) {
            return frame.g();
        }
        return frame.h();
    }

    private final float o(com.tencent.kuikly.core.layout.d frame, boolean isRow) {
        if (isRow) {
            return frame.getX();
        }
        return frame.getY();
    }

    public boolean w(int index, float scrollOffset, boolean animated, bs springAnimation) {
        if ((animated || springAnimation != null) && (g() instanceof PageListView)) {
            t(index);
        }
        Float q16 = q(index);
        if (q16 == null) {
            return false;
        }
        b(q16.floatValue() + scrollOffset, animated, springAnimation);
        return true;
    }

    public static /* synthetic */ boolean x(d dVar, int i3, float f16, boolean z16, bs bsVar, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                f16 = 0.0f;
            }
            if ((i16 & 4) != 0) {
                z16 = false;
            }
            if ((i16 & 8) != 0) {
                bsVar = null;
            }
            return dVar.w(i3, f16, z16, bsVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToIndex");
    }
}
