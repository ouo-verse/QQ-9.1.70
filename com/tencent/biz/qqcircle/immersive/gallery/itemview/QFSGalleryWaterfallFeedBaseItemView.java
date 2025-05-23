package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.content.Context;
import android.util.Size;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import e30.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0004J\b\u0010\t\u001a\u00020\u0005H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/gallery/itemview/QFSGalleryWaterfallFeedBaseItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Landroid/widget/ImageView;", "l0", "", "k0", "Landroid/util/Size;", "m0", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSGalleryWaterfallFeedBaseItemView extends QCircleBaseWidgetView<b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSGalleryWaterfallFeedBaseItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void k0() {
        bz.d(l0(), m0());
    }

    @NotNull
    public abstract ImageView l0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Size m0() {
        int screenWidth = (DisplayUtil.getScreenWidth() / 2) - DisplayUtil.dip2px(getContext(), 4.0f);
        return new Size(screenWidth, (screenWidth * 4) / 3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k0();
    }
}
