package pj2;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.l;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pj2.b;
import qj2.CommonConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\f\b\u0000\u0010\u0003*\u00020\u0001*\u00020\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007\u00a2\u0006\u0004\b/\u00100J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010&\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010*\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010.\u001a\u00020+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lpj2/a;", "Landroid/view/View;", "Lpj2/b;", "V", "", "Ltj2/b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/l;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/a;", "v", "", "f", "(Landroid/view/View;)V", DomainData.DOMAIN_NAME, "a", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "setView", "view", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "k", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "o", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;)V", "panelViewController", "Lrj2/a;", "l", "()Lrj2/a;", "scaleCalculator", "Lqj2/a;", "g", "()Lqj2/a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "j", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "panelEventHandler", "Ltj2/a;", h.F, "()Ltj2/a;", "flingHelper", "", "i", "()I", NodeProps.MIN_WIDTH, "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class a<V extends View & b> implements tj2.b, l, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private V view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TimelinePanelViewController panelViewController = new TimelinePanelViewController();

    public void f(@NotNull V v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        this.view = v3;
        v3.o(this);
        this.panelViewController.d(this);
    }

    @NotNull
    public final CommonConfig g() {
        return this.panelViewController.getConfig();
    }

    @NotNull
    public final tj2.a h() {
        return this.panelViewController.getFlingHelper();
    }

    public final int i() {
        return this.panelViewController.h();
    }

    @NotNull
    public final PanelEventHandler j() {
        return this.panelViewController.getPanelEventHandler();
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final TimelinePanelViewController getPanelViewController() {
        return this.panelViewController;
    }

    @NotNull
    public final rj2.a l() {
        return this.panelViewController.getScaleCalculator();
    }

    @Nullable
    public final V m() {
        return this.view;
    }

    public void n() {
        V v3 = this.view;
        if (v3 != null) {
            v3.invalidate();
        }
    }

    public final void o(@NotNull TimelinePanelViewController timelinePanelViewController) {
        Intrinsics.checkNotNullParameter(timelinePanelViewController, "<set-?>");
        this.panelViewController = timelinePanelViewController;
    }
}
