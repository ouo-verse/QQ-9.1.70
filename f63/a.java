package f63;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.j;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import f63.b;
import g63.CommonConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\f\b\u0000\u0010\u0003*\u00020\u0001*\u00020\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007\u00a2\u0006\u0004\b/\u00100J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010&\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010*\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010.\u001a\u00020+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lf63/a;", "Landroid/view/View;", "Lf63/b;", "V", "Li63/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/j;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/a;", "v", "", "g", "(Landroid/view/View;)V", "o", "a", "Landroid/view/View;", DomainData.DOMAIN_NAME, "()Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "view", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "l", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "p", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;)V", "panelViewController", "Li63/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Li63/b;", "scaleCalculator", "Lg63/a;", h.F, "()Lg63/a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "k", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "panelEventHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "i", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "flingHelper", "", "j", "()I", NodeProps.MIN_WIDTH, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a<V extends View & b> implements i63.a, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.a, j, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private V view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TimelinePanelViewController panelViewController = new TimelinePanelViewController();

    public void g(@NotNull V v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        this.view = v3;
        v3.s(this);
        this.panelViewController.i(this);
    }

    @NotNull
    public final CommonConfig h() {
        return this.panelViewController.getConfig();
    }

    @NotNull
    public final FlingHelper i() {
        return this.panelViewController.getFlingHelper();
    }

    public final int j() {
        return this.panelViewController.m();
    }

    @NotNull
    public final PanelEventHandler k() {
        return this.panelViewController.getPanelEventHandler();
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final TimelinePanelViewController getPanelViewController() {
        return this.panelViewController;
    }

    @NotNull
    public final i63.b m() {
        return this.panelViewController.getScaleCalculator();
    }

    @Nullable
    public final V n() {
        return this.view;
    }

    public void o() {
        V v3 = this.view;
        if (v3 != null) {
            v3.invalidate();
        }
    }

    public final void p(@NotNull TimelinePanelViewController timelinePanelViewController) {
        Intrinsics.checkNotNullParameter(timelinePanelViewController, "<set-?>");
        this.panelViewController = timelinePanelViewController;
    }

    public final void q(@Nullable V v3) {
        this.view = v3;
    }
}
