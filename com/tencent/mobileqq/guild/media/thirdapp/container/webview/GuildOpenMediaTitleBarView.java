package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildOpenMediaTitleBarView;", "Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;", "", "g0", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/mobileqq/webview/swift/component/v;", "uIStyleHandler", "<init>", "(Lcom/tencent/mobileqq/webview/swift/component/v;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenMediaTitleBarView extends SwiftIphoneTitleBarUI {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildOpenMediaTitleBarView(@NotNull v uIStyleHandler) {
        super(uIStyleHandler);
        Intrinsics.checkNotNullParameter(uIStyleHandler, "uIStyleHandler");
    }

    private final void g0() {
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        g0();
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void o() {
        super.o();
        g0();
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
    }
}
