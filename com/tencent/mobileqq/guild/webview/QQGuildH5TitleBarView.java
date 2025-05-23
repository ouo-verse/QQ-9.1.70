package com.tencent.mobileqq.guild.webview;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/QQGuildH5TitleBarView;", "Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;", "", "i0", "g0", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/content/Intent;", "i", "", "url", DomainData.DOMAIN_NAME, "", "isHidden", "H", "", "color", "W", ExifInterface.LATITUDE_SOUTH, com.tencent.luggage.wxa.c8.c.f123400v, BdhLogUtil.LogTag.Tag_Req, NodeProps.VISIBLE, "X", "Lcom/tencent/mobileqq/webview/swift/component/v;", "uiStyleHandler", "<init>", "(Lcom/tencent/mobileqq/webview/swift/component/v;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildH5TitleBarView extends SwiftIphoneTitleBarUI {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildH5TitleBarView(@NotNull v uiStyleHandler) {
        super(uiStyleHandler);
        Intrinsics.checkNotNullParameter(uiStyleHandler, "uiStyleHandler");
    }

    private final void g0() {
        TextView textView = this.f314054i;
        if (textView != null) {
            textView.setMaxWidth(Integer.MAX_VALUE);
        }
        ImageView imageView = this.E;
        if (imageView != null && imageView.getVisibility() == 0) {
            int dpToPx = ViewUtils.dpToPx(350.0f);
            int[] iArr = new int[2];
            this.E.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            TextView textView2 = this.f314054i;
            if (textView2 != null) {
                textView2.getLocationOnScreen(iArr2);
                int width = ((iArr[0] - iArr2[0]) - textView2.getWidth()) - ViewUtils.dpToPx(7.0f);
                if (width >= dpToPx) {
                    dpToPx = width;
                }
                textView2.setMaxWidth(dpToPx);
            }
        }
    }

    private final void i0() {
        Intent intent = this.f314045d.E.getIntent();
        String stringExtra = intent.getStringExtra("guild_channel_name");
        String stringExtra2 = intent.getStringExtra("guild_channel_avatar_url");
        boolean booleanExtra = intent.getBooleanExtra("hide_title_left_arrow", false);
        int dpToPx = ViewUtils.dpToPx(26.0f);
        Drawable J = ch.J(stringExtra2, dpToPx, new BitmapDrawable(QQGuildUIUtil.j(false)), false);
        if (J == null) {
            J = new BitmapDrawable(QQGuildUIUtil.j(false));
        }
        J.setBounds(0, 0, dpToPx, dpToPx);
        if (booleanExtra) {
            this.f314054i.setCompoundDrawables(null, null, null, null);
        } else {
            TextView textView = this.f314054i;
            if (textView != null) {
                textView.setCompoundDrawables(J, null, null, null);
            }
            TextView textView2 = this.f314054i;
            if (textView2 != null) {
                textView2.setCompoundDrawablePadding(ViewUtils.dpToPx(7.0f));
            }
        }
        TextView textView3 = this.f314054i;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.f314054i;
        if (textView4 != null) {
            textView4.setText(stringExtra);
        }
    }

    private final void j0() {
        int parseColor = Color.parseColor("#EEF0F4");
        if (!this.f314047e.f314641x) {
            ViewGroup viewGroup = this.M;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(parseColor);
            }
            WebViewProvider webViewProvider = this.f314045d.P;
            if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
                this.f314045d.P.getWebTitleBarInterface().a3().setBackgroundColor(parseColor);
                ImmersiveUtils.clearCoverForStatus(this.f314045d.E.getWindow(), true);
                this.f314045d.E.getWindow().setStatusBarColor(parseColor);
                ImmersiveUtils.setStatusTextColor(true, this.f314045d.E.getWindow());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void H(boolean isHidden) {
        super.H(true);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void R(int alpha) {
        super.R(255);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void S(int color) {
        super.S(-16777216);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void W(int color) {
        TextView textView = this.f314054i;
        if (textView != null) {
            textView.setTextColor(-16777216);
            super.W(-16777216);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public boolean X(boolean visible) {
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
        i0();
        g0();
        TextView textView = this.f314059m;
        if (textView != null) {
            textView.setVisibility(8);
        }
        j0();
        H(true);
        W(-16777216);
        S(-16777216);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
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
    public void n(@Nullable Intent i3, @Nullable String url) {
        super.n(i3, url);
        H(true);
    }
}
