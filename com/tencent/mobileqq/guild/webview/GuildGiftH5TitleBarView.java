package com.tencent.mobileqq.guild.webview;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/GuildGiftH5TitleBarView;", "Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;", "", "g0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/content/Intent;", "i", "", "url", DomainData.DOMAIN_NAME, "", "isHidden", "H", "", "color", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/webview/swift/component/v;", "uiStyleHandler", "<init>", "(Lcom/tencent/mobileqq/webview/swift/component/v;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGiftH5TitleBarView extends SwiftIphoneTitleBarUI {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftH5TitleBarView(@NotNull v uiStyleHandler) {
        super(uiStyleHandler);
        Intrinsics.checkNotNullParameter(uiStyleHandler, "uiStyleHandler");
    }

    private final void g0() {
        WebViewProgressBar webViewProgressBar;
        TextView textView = this.f314054i;
        if (textView != null) {
            textView.setVisibility(8);
        }
        v vVar = this.f314045d;
        if (vVar != null) {
            vVar.f314499a0 = true;
        }
        TextView textView2 = this.f314059m;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        v vVar2 = this.f314045d;
        if (vVar2 != null) {
            webViewProgressBar = vVar2.T;
        } else {
            webViewProgressBar = null;
        }
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
        H(true);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void H(boolean isHidden) {
        super.H(true);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void S(int color) {
        super.S(-16777216);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
        g0();
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        WebViewProgressBar webViewProgressBar;
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        v vVar = this.f314045d;
        if (vVar != null) {
            vVar.f314499a0 = true;
        }
        if (vVar != null) {
            webViewProgressBar = vVar.T;
        } else {
            webViewProgressBar = null;
        }
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void n(@Nullable Intent i3, @Nullable String url) {
        super.n(i3, url);
        g0();
    }
}
