package com.tencent.mobileqq.guild.mainframe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGView;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\u0005\rB'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/view/GuildPAGFrameLayout;", "Landroid/widget/FrameLayout;", "Lorg/libpag/PAGView;", "pagView", "", "a", NodeProps.ON_DETACHED_FROM_WINDOW, "", "url", "setPagUrl", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildPAGFrameLayout$b;", "listener", "setAnimationListener", "b", "d", "Lorg/libpag/PAGView;", "e", "Ljava/lang/String;", "pagUrl", "", "f", "Z", "downloadPagFileSuccess", h.F, "loadPagSoIsSuccess", "i", "isDestroy", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildPAGFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGView pagView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean downloadPagFileSuccess;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean loadPagSoIsSuccess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/view/GuildPAGFrameLayout$b;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildPAGFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(PAGView pagView) {
        Boolean bool;
        PAGComposition pAGComposition;
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        if (pagView != null) {
            bool = Boolean.valueOf(pagView.isPlaying());
        } else {
            bool = null;
        }
        d16.d("GuildPAGFrameLayout", 1, "[clearPagView] isPlaying " + bool);
        boolean z16 = false;
        if (pagView != null && pagView.isPlaying()) {
            z16 = true;
        }
        if (!z16) {
            if (pagView != null) {
                pAGComposition = pagView.getComposition();
            } else {
                pAGComposition = null;
            }
            if (pAGComposition != null) {
                pagView.setComposition(null);
                pagView.flush();
                logger.d().d("GuildPAGFrameLayout", 1, "clearPagView and flush ");
            }
        }
    }

    public final void b() {
        if (this.isDestroy) {
            return;
        }
        Logger.f235387a.d().d("GuildPAGFrameLayout", 1, "[destroy] ");
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
        }
        a(this.pagView);
        this.downloadPagFileSuccess = false;
        this.loadPagSoIsSuccess = false;
        this.isDestroy = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public final void setPagUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Intrinsics.areEqual(url, this.pagUrl)) {
            this.pagUrl = url;
            this.downloadPagFileSuccess = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildPAGFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildPAGFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildPAGFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pagUrl = "";
    }

    public final void setAnimationListener(@Nullable b listener) {
    }
}
