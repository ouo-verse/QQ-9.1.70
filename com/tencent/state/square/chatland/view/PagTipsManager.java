package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J0\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/chatland/view/PagTipsManager;", "", ParseCommon.CONTAINER, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/chatland/view/IViewContainer;", "(Ljava/lang/ref/WeakReference;)V", "destroy", "", "show", "context", "Landroid/content/Context;", "url", "", "location", "Landroid/graphics/Point;", "size", "Landroid/util/Size;", "repeatCount", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PagTipsManager {
    private static final int DEFAULT_REPEAT_COUNT = 1;
    private static final String TAG = "PagTipsManager";
    private final WeakReference<IViewContainer> container;

    public PagTipsManager(WeakReference<IViewContainer> container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
    }

    public final void show(Context context, final String url, final Point location, final Size size, final int repeatCount) {
        IViewContainer iViewContainer;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        ISquarePagView pagView = SquareBase.INSTANCE.getConfig().getCommonUtils().getPagView(context);
        if (pagView != null) {
            final View view = pagView.getView();
            view.setLayoutParams(new ViewGroup.LayoutParams(size.getWidth(), size.getHeight()));
            view.setX(location.x);
            view.setY(location.y);
            WeakReference<IViewContainer> weakReference = this.container;
            if (weakReference != null && (iViewContainer = weakReference.get()) != null) {
                iViewContainer.addView(view);
            }
            pagView.setPagViewListener(new SimpleSquarePagViewListener() { // from class: com.tencent.state.square.chatland.view.PagTipsManager$show$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(null, 1, null);
                }

                @Override // com.tencent.state.square.api.SimpleSquarePagViewListener, com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationEnd(ISquarePagView squarePagView) {
                    WeakReference weakReference2;
                    IViewContainer iViewContainer2;
                    weakReference2 = this.container;
                    if (weakReference2 == null || (iViewContainer2 = (IViewContainer) weakReference2.get()) == null) {
                        return;
                    }
                    iViewContainer2.removeView(view);
                }
            });
            PAGLoader.INSTANCE.playPAG(url, url.hashCode() + ".pag", pagView, new PAGLoaderOption(repeatCount));
        }
    }

    public static /* synthetic */ void show$default(PagTipsManager pagTipsManager, Context context, String str, Point point, Size size, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 1;
        }
        pagTipsManager.show(context, str, point, size, i3);
    }

    public final void destroy() {
    }
}
