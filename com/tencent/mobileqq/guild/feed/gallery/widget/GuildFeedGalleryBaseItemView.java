package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB#\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010M\u001a\u00020\u000f\u0012\u0006\u00106\u001a\u000201\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u0003H\u0014J\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\b\u0010$\u001a\u00020\u0003H\u0014J&\u0010%\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0013J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J,\u0010/\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030-\u0012\u0004\u0012\u00020\u00170,j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030-\u0012\u0004\u0012\u00020\u0017`.H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0014R\u001a\u00106\u001a\u0002018\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u0010=\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R8\u0010@\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030-\u0012\u0004\u0012\u00020\u00170,j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030-\u0012\u0004\u0012\u00020\u0017`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010L\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryBaseItemView;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildBaseWidgetView;", "Ljk1/a;", "", "s0", "C0", "w0", "D0", "initView", "Landroid/content/Context;", "context", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "x0", "data", "", com.tencent.luggage.wxa.c8.c.G, "u0", "", "", "payloads", "v0", "r0", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "m0", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getLayoutPreLoader", "Landroid/widget/FrameLayout$LayoutParams;", "getPreLoadLayoutParams", NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/tencent/mobileqq/guild/feed/manager/f;", "selectInfo", "A0", "B0", "z0", "y0", NodeProps.ON_DETACHED_FROM_WINDOW, "setData", "", "action", "msg", "l0", "objData", "k0", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "q0", "o0", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "d", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "n0", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "bean", "e", "I", "getMPageSource", "()I", "setMPageSource", "(I)V", "mPageSource", "f", "Ljava/util/HashMap;", "mPresenterMap", "Lkk1/d;", tl.h.F, "Lkk1/d;", "p0", "()Lkk1/d;", "E0", "(Lkk1/d;)V", "mPresenterManager", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "mDtParams", "viewType", "<init>", "(Landroid/content/Context;ILcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedGalleryBaseItemView extends GuildBaseWidgetView<jk1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedDefaultInitBean bean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mPageSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Class<?>, com.tencent.mobileqq.guild.feed.gallery.presenter.b> mPresenterMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected kk1.d mPresenterManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> mDtParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryBaseItemView(@NotNull Context context, int i3, @NotNull GuildFeedDefaultInitBean bean) {
        super(context, null, 0, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.bean = bean;
        this.mPageSource = bean.getShareSource();
        this.mPresenterMap = new HashMap<>();
        this.mDtParams = new ConcurrentHashMap<>();
        initView();
    }

    private final void C0() {
        for (com.tencent.mobileqq.guild.feed.gallery.presenter.b presenter : q0().values()) {
            kk1.d p06 = p0();
            Intrinsics.checkNotNullExpressionValue(presenter, "presenter");
            if (!p06.b(presenter)) {
                p0().d(presenter);
                presenter.s(p0());
            }
        }
    }

    private final void D0() {
        p0().c();
    }

    private final void initView() {
        r0();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        x0(context, this);
    }

    private final List<com.tencent.mobileqq.guild.feed.gallery.presenter.b> m0() {
        LinkedList linkedList = new LinkedList();
        List<com.tencent.mobileqq.guild.feed.gallery.presenter.b> o06 = o0();
        if (!o06.isEmpty()) {
            linkedList.addAll(o06);
        }
        return linkedList;
    }

    private final void r0() {
        HashMap<Class<?>, com.tencent.mobileqq.guild.feed.gallery.presenter.b> q06 = q0();
        E0(new kk1.d());
        for (com.tencent.mobileqq.guild.feed.gallery.presenter.b bVar : m0()) {
            p0().d(bVar);
            bVar.s(p0());
            q06.put(bVar.getClass(), bVar);
        }
    }

    private final void s0() {
        Iterator<com.tencent.mobileqq.guild.feed.gallery.presenter.b> it = q0().values().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    private final void u0(jk1.a data, int pos) {
        for (com.tencent.mobileqq.guild.feed.gallery.presenter.b bVar : q0().values()) {
            bVar.c(this.mDtParams);
            bVar.k(data, pos);
        }
    }

    private final void v0(jk1.a data, int pos, List<? extends Object> payloads) {
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryBaseItemView", 4, "[notifyBindData] start");
        for (com.tencent.mobileqq.guild.feed.gallery.presenter.b bVar : q0().values()) {
            bVar.c(this.mDtParams);
            bVar.l(data, pos, payloads);
        }
    }

    private final void w0() {
        Iterator<com.tencent.mobileqq.guild.feed.gallery.presenter.b> it = q0().values().iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    private final void x0(Context context, View rootView) {
        if (rootView == null) {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBaseItemView", 1, "[notifyInitView] root view should not be null.");
            return;
        }
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        for (com.tencent.mobileqq.guild.feed.gallery.presenter.b bVar : q0().values()) {
            long currentTimeMillis = System.currentTimeMillis();
            bVar.r(rootView);
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryBaseItemView", 4, "[notifyInitView] [" + bVar + "], cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void A0(@NotNull com.tencent.mobileqq.guild.feed.manager.f selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        Iterator<com.tencent.mobileqq.guild.feed.gallery.presenter.b> it = q0().values().iterator();
        while (it.hasNext()) {
            it.next().p(selectInfo);
        }
    }

    public final void B0(@NotNull com.tencent.mobileqq.guild.feed.manager.f selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        Iterator<com.tencent.mobileqq.guild.feed.gallery.presenter.b> it = q0().values().iterator();
        while (it.hasNext()) {
            it.next().q(selectInfo);
        }
    }

    protected final void E0(@NotNull kk1.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.mPresenterManager = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @Nullable
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return gj1.a.a().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NotNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull jk1.a objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        u0(objData, pos);
    }

    public final void l0(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        p0().a(action, msg2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: n0, reason: from getter */
    public final GuildFeedDefaultInitBean getBean() {
        return this.bean;
    }

    @NotNull
    protected List<com.tencent.mobileqq.guild.feed.gallery.presenter.b> o0() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0();
        C0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w0();
        D0();
    }

    @NotNull
    protected final kk1.d p0() {
        kk1.d dVar = this.mPresenterManager;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPresenterManager");
        return null;
    }

    @NotNull
    public HashMap<Class<?>, com.tencent.mobileqq.guild.feed.gallery.presenter.b> q0() {
        return this.mPresenterMap;
    }

    public final void setData(@NotNull jk1.a data, int pos, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (data.b() == null) {
            return;
        }
        v0(data, pos, payloads);
    }

    public final void y0() {
        Iterator<com.tencent.mobileqq.guild.feed.gallery.presenter.b> it = q0().values().iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    public final void z0() {
        Iterator<com.tencent.mobileqq.guild.feed.gallery.presenter.b> it = q0().values().iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }
}
