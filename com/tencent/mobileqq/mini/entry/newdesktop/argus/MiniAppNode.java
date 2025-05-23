package com.tencent.mobileqq.mini.entry.newdesktop.argus;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/argus/MiniAppNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "partHost", "(Landroid/view/View;Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopPartHost;)V", "isSelfVisible", "", "()Z", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppNode extends ArgusNode<MiniAppDesktopPartHost> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppNode(View rootView, MiniAppDesktopPartHost partHost) {
        super(rootView, partHost);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partHost, "partHost");
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        MiniAppDesktopPartHost miniAppDesktopPartHost = getContainerWrf().get();
        View view = getNodeViewWrf().get();
        if (miniAppDesktopPartHost == null || view == null) {
            return false;
        }
        return miniAppDesktopPartHost.getMIsDesktopOpened();
    }
}
