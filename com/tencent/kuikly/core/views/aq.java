package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b%\u0010\rJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00160\u0015J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/views/aq;", "Lcom/tencent/kuikly/core/views/ao;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/views/ap;", "E", "Lcom/tencent/kuikly/core/views/ScrollerView;", "", "updateContentRenderViewsOnVisibleRectIfNeed", "Lcom/tencent/kuikly/core/views/ScrollerContentView;", "createContentView", "createRenderView", "removeRenderView", "preloadViewDistanceDidUpdate$core_release", "()V", "preloadViewDistanceDidUpdate", "createAttr", "()Lcom/tencent/kuikly/core/views/ao;", "createEvent", "()Lcom/tencent/kuikly/core/views/ap;", "", "viewName", "", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "listItems", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "", "prepareForReuse", "Z", "Lcom/tencent/kuikly/core/base/w;", "lastFrameSize", "Lcom/tencent/kuikly/core/base/w;", "getLastFrameSize", "()Lcom/tencent/kuikly/core/base/w;", "setLastFrameSize", "(Lcom/tencent/kuikly/core/base/w;)V", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class aq<A extends ao, E extends ap> extends ScrollerView<A, E> {
    private com.tencent.kuikly.core.base.w lastFrameSize;
    private boolean prepareForReuse;

    private final void updateContentRenderViewsOnVisibleRectIfNeed() {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        ScrollerContentView contentView = getContentView();
        boolean z16 = false;
        if (contentView != null && (flexNode = contentView.getFlexNode()) != null && (layoutFrame = flexNode.getLayoutFrame()) != null && !layoutFrame.f()) {
            z16 = true;
        }
        if (z16) {
            ScrollerContentView contentView2 = getContentView();
            ListContentView listContentView = contentView2 instanceof ListContentView ? (ListContentView) contentView2 : null;
            if (listContentView != null) {
                listContentView.t();
            }
        }
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView
    public ScrollerContentView createContentView() {
        return new ListContentView();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        if (this.prepareForReuse) {
            ScrollerView.setContentOffset$default(this, getCurOffsetX(), getCurOffsetY(), false, null, 8, null);
        }
        super.createRenderView();
        this.prepareForReuse = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.tencent.kuikly.core.base.w getLastFrameSize() {
        return this.lastFrameSize;
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.layoutFrameDidChanged(frame);
        com.tencent.kuikly.core.base.w wVar = this.lastFrameSize;
        if (wVar == null) {
            this.lastFrameSize = new com.tencent.kuikly.core.base.w(frame.getWidth(), frame.getHeight());
            updateContentRenderViewsOnVisibleRectIfNeed();
            return;
        }
        Intrinsics.checkNotNull(wVar);
        if (wVar.getWidth() == frame.getWidth()) {
            com.tencent.kuikly.core.base.w wVar2 = this.lastFrameSize;
            Intrinsics.checkNotNull(wVar2);
            if (wVar2.getHeight() == frame.getHeight()) {
                if (com.tencent.kuikly.core.pager.h.b()) {
                    updateContentRenderViewsOnVisibleRectIfNeed();
                    return;
                }
                return;
            }
        }
        this.lastFrameSize = new com.tencent.kuikly.core.base.w(frame.getWidth(), frame.getHeight());
        ScrollerContentView contentView = getContentView();
        ListContentView listContentView = contentView instanceof ListContentView ? (ListContentView) contentView : null;
        if (listContentView != null) {
            listContentView.A();
        }
    }

    public final List<DeclarativeBaseView<?, ?>> listItems() {
        List<DeclarativeBaseView<?, ?>> emptyList;
        ScrollerContentView contentView = getContentView();
        if ((contentView instanceof ListContentView ? (ListContentView) contentView : null) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ScrollerContentView contentView2 = getContentView();
        Intrinsics.checkNotNull(contentView2, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ListContentView");
        return ((ListContentView) contentView2).w();
    }

    public final void preloadViewDistanceDidUpdate$core_release() {
        updateContentRenderViewsOnVisibleRectIfNeed();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void removeRenderView() {
        super.removeRenderView();
        this.prepareForReuse = true;
        this.lastFrameSize = null;
    }

    protected final void setLastFrameSize(com.tencent.kuikly.core.base.w wVar) {
        this.lastFrameSize = wVar;
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRListView";
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public A createAttr() {
        return (A) new ao();
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public E createEvent() {
        return (E) new ap();
    }
}
