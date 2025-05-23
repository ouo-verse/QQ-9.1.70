package com.tencent.kuikly.core.views.internal;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.kuikly.core.views.internal.GroupEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/views/internal/GroupView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/views/internal/GroupAttr;", "E", "Lcom/tencent/kuikly/core/views/internal/GroupEvent;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "()V", "bringToFront", "", "isRenderView", "", "viewName", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class GroupView<A extends GroupAttr, E extends GroupEvent> extends ViewContainer<A, E> {
    public void bringToFront() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.views.internal.GroupView$bringToFront$1
            final /* synthetic */ GroupView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderView renderView = this.this$0.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "bringToFront", null, null, 6, null);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public boolean isRenderView() {
        return isRenderViewForFlatLayer$core_release();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }
}
