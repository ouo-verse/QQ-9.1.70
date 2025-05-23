package com.tencent.mobileqq.leba.feed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.entity.p;
import com.tencent.mobileqq.leba.feed.LebaPluginFeedAdapter;
import com.tencent.mobileqq.leba.feed.impl.a;
import com.tencent.mobileqq.leba.l;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouch;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.view.LebaFeedItemPreLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0001%\u0018\u0000 +2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003,-.B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b)\u0010*J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0012\u001a\u00020\nR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$LebaPluginsFeedViewHolder;", "Landroid/view/ViewGroup;", "viewGroup", "", "position", "y", "getItemCount", "holder", "", "w", "", "Lcom/tencent/mobileqq/leba/entity/n;", "data", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "pluginViewItem", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "d", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "u", "()Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "lebaPluginProxy", "", "e", "Ljava/util/List;", "pluginDataList", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouchBase;", "f", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouchBase;", "lebaRedTouchBase", "Landroid/os/Handler;", tl.h.F, "Landroid/os/Handler;", "uiHandler", "com/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$c", "i", "Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$c;", "pluginClickListener", "<init>", "(Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "LebaPluginsFeedViewHolder", "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginFeedAdapter extends RecyclerView.Adapter<LebaPluginsFeedViewHolder> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final Lazy<Boolean> C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginProxy lebaPluginProxy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<n> pluginDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaRedTouchBase lebaRedTouchBase;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c pluginClickListener;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020\b\u00a2\u0006\u0004\b/\u00100J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010#\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$LebaPluginsFeedViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "l", "Landroid/view/View;", "view", "k", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouchBase;", "lebaRedTouchBase", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "d", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouch;", "e", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouch;", "unityRedTouch", "f", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "tvName", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "ivIcon", "pluginLayout", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "customRedViewContainer", "D", "I", "curPosition", "E", "Lcom/tencent/mobileqq/leba/entity/n;", "lebaItem", "itemView", "<init>", "(Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter;Landroid/view/View;)V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class LebaPluginsFeedViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final FrameLayout customRedViewContainer;

        /* renamed from: D, reason: from kotlin metadata */
        private int curPosition;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private n lebaItem;
        final /* synthetic */ LebaPluginFeedAdapter F;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RedTouch redTouch;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LebaRedTouch unityRedTouch;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View rootView;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView tvName;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView ivIcon;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View pluginLayout;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "path", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.leba.feed.LebaPluginFeedAdapter$LebaPluginsFeedViewHolder$1, reason: invalid class name */
        /* loaded from: classes15.dex */
        static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<WeakReference<LebaPluginsFeedViewHolder>> $weakReference;
            final /* synthetic */ LebaPluginsFeedViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Ref.ObjectRef<WeakReference<LebaPluginsFeedViewHolder>> objectRef, LebaPluginsFeedViewHolder lebaPluginsFeedViewHolder) {
                super(1);
                this.$weakReference = objectRef;
                this.this$0 = lebaPluginsFeedViewHolder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef, (Object) lebaPluginsFeedViewHolder);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public static final void b(Ref.ObjectRef weakReference, LebaPluginsFeedViewHolder this$0) {
                Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                LebaPluginsFeedViewHolder lebaPluginsFeedViewHolder = (LebaPluginsFeedViewHolder) ((WeakReference) weakReference.element).get();
                if (lebaPluginsFeedViewHolder != null) {
                    this$0.l(this$0.lebaItem, lebaPluginsFeedViewHolder.curPosition);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String path) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
                    return;
                }
                Intrinsics.checkNotNullParameter(path, "path");
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Ref.ObjectRef<WeakReference<LebaPluginsFeedViewHolder>> objectRef = this.$weakReference;
                final LebaPluginsFeedViewHolder lebaPluginsFeedViewHolder = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.AnonymousClass1.b(Ref.ObjectRef.this, lebaPluginsFeedViewHolder);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Type inference failed for: r3v3, types: [mqq.util.WeakReference, T] */
        public LebaPluginsFeedViewHolder(@NotNull final LebaPluginFeedAdapter lebaPluginFeedAdapter, final View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = lebaPluginFeedAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginFeedAdapter, (Object) itemView);
                return;
            }
            this.rootView = itemView;
            View findViewById = itemView.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_name)");
            this.tvName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.dvu);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_icon)");
            this.ivIcon = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.ypr);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.ll_plugin_container)");
            this.pluginLayout = findViewById3;
            View findViewById4 = itemView.findViewById(R.id.yps);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026_plugin_custom_container)");
            FrameLayout frameLayout = (FrameLayout) findViewById4;
            this.customRedViewContainer = frameLayout;
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            TianshuRedTouch h06 = new LebaRedTouch(context, frameLayout).j0(12.0f).g0(22.0f).h0(17);
            Intrinsics.checkNotNull(h06, "null cannot be cast to non-null type com.tencent.mobileqq.leba.redtouch.LebaRedTouch");
            LebaRedTouch lebaRedTouch = (LebaRedTouch) h06;
            this.unityRedTouch = lebaRedTouch;
            if (TianshuRedTouch.INSTANCE.j()) {
                lebaRedTouch.t();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new WeakReference(this);
                if (lebaRedTouch != null) {
                    lebaRedTouch.setNotifyRedBadgeShow(new AnonymousClass1(objectRef, this));
                }
            }
            RedTouch applyTo = new RedTouch(itemView.getContext(), itemView.findViewById(R.id.u6u)).setGravity(17).setLeftMargin(12).setButtomMargin(12).applyTo();
            Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(itemView.contex\u2026uttomMargin(12).applyTo()");
            this.redTouch = applyTo;
            itemView.setOnClickListener(com.tencent.mobileqq.leba.view.d.INSTANCE.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.feed.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.d(LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.this, lebaPluginFeedAdapter, itemView, view);
                }
            }));
            itemView.setOnTouchListener(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final LebaPluginsFeedViewHolder this$0, LebaPluginFeedAdapter this$1, View itemView, final View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            final n nVar = this$0.lebaItem;
            if (nVar != null) {
                if (nVar.f240507d != 2) {
                    c cVar = this$1.pluginClickListener;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    cVar.c(it, nVar, this$0.getAdapterPosition());
                } else {
                    this$1.pluginClickListener.b(itemView, nVar);
                }
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    this$0.k(it, nVar);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(it, nVar) { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedAdapter$LebaPluginsFeedViewHolder$lambda$2$lambda$1$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ View f240538d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ n f240539e;

                        {
                            this.f240538d = it;
                            this.f240539e = nVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.this, it, nVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.this.k(this.f240538d, this.f240539e);
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
            EventCollector.getInstance().onViewClicked(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(LebaPluginsFeedViewHolder this$0, n item, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.l(item, i3 + 1);
            if (item.f240507d == 2) {
                com.tencent.mobileqq.leba.utils.a.c(this$0.ivIcon, HardCodeUtil.qqStr(R.string.f162061ze), 30);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(View view, n item) {
            this.unityRedTouch.x();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(n item, int position) {
            if (item == null) {
                return;
            }
            VideoReport.setElementReuseIdentifier(this.rootView, String.valueOf(item.f240504a));
            com.tencent.mobileqq.leba.report.d.j(this.rootView, item, position);
            this.F.u().g(item);
            TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
            if (companion.j()) {
                com.tencent.mobileqq.leba.report.d.u(this.rootView, String.valueOf(companion.g(String.valueOf(item.f240504a))), companion.f(String.valueOf(item.f240504a)).toString());
            } else {
                com.tencent.mobileqq.leba.report.d.t(this.rootView, 0);
            }
        }

        private final void m(n item, Context context, LebaRedTouchBase lebaRedTouchBase, int position) {
            if (item.f240505b != null && item.f240507d != 2) {
                p pVar = new p();
                pVar.f240520a = context;
                pVar.f240521b = this.redTouch;
                pVar.f240522c = this.unityRedTouch;
                pVar.f240523d = item.f240504a;
                pVar.f240524e = item.f240505b.strPkgName;
                pVar.f240526g = true;
                pVar.f240525f = position;
                if (TianshuRedTouch.INSTANCE.j()) {
                    this.unityRedTouch.p0(TianshuRedTouch.RedTouchAssembleType.ONLY_REDDOT);
                    if (!this.F.u().j(item.f240504a)) {
                        this.unityRedTouch.n0(String.valueOf(item.f240504a));
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime == null) {
                            return;
                        }
                        BusinessInfoCheckUpdate.AppInfo c16 = lebaRedTouchBase.c(peekAppRuntime, String.valueOf(item.f240504a));
                        BusinessInfoCheckUpdate.AppInfo c17 = lebaRedTouchBase.c(peekAppRuntime, item.f240504a + ".0");
                        if ((c16 != null && com.tencent.mobileqq.tianshu.ui.a.d(c16)) || (c17 != null && com.tencent.mobileqq.tianshu.ui.a.a(c17))) {
                            lebaRedTouchBase.a(pVar);
                        }
                    }
                    lebaRedTouchBase.j(pVar, this.F.u());
                    return;
                }
                lebaRedTouchBase.l(pVar, this.F.u());
                return;
            }
            if (TianshuRedTouch.INSTANCE.j()) {
                this.unityRedTouch.w();
            } else {
                this.redTouch.clearRedTouch();
            }
        }

        public final void i(@NotNull final n item, final int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, position);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            n nVar = this.lebaItem;
            if (nVar != null) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter = this.F;
                if (!Intrinsics.areEqual(nVar, item)) {
                    if (TianshuRedTouch.INSTANCE.j()) {
                        this.unityRedTouch.w();
                    } else {
                        this.redTouch.clearRedTouch();
                    }
                    lebaPluginFeedAdapter.u().w(nVar);
                    this.pluginLayout.setVisibility(0);
                    this.customRedViewContainer.setVisibility(8);
                }
            }
            this.curPosition = position;
            this.lebaItem = item;
            this.F.u().d(item, this.rootView);
            com.tencent.mobileqq.leba.utils.e.b(this.ivIcon, this.tvName, this.rootView, item, false);
            this.customRedViewContainer.setVisibility(0);
            this.customRedViewContainer.setTag(R.id.ygd, Long.valueOf(item.f240504a));
            Context context = this.rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            m(item, context, this.F.lebaRedTouchBase, position);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.g
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.j(LebaPluginFeedAdapter.LebaPluginsFeedViewHolder.this, item, position);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$a;", "", "", "postBindSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "postBindSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.feed.LebaPluginFeedAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) LebaPluginFeedAdapter.C.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$b;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    v3.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            v3.setAlpha(0.5f);
            return false;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter$c", "Lcom/tencent/mobileqq/leba/entity/h;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "c", "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements com.tencent.mobileqq.leba.entity.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginFeedAdapter.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.entity.h
        public void b(@NotNull View v3, @Nullable n item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            QLog.i("LebaPluginFeedAdapter", 1, "onMoreClick from feeds");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ReportController.o(peekAppRuntime, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IR\u2026nstant.MAIN\n            )");
            ((IRedTouchManager) runtimeService).onRedTouchItemClick("150000");
            com.tencent.mobileqq.leba.core.e.a().f240377c = true;
            Context context = v3.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            com.tencent.mobileqq.leba.core.f.q((Activity) context, peekAppRuntime, false, 2);
        }

        @Override // com.tencent.mobileqq.leba.entity.h
        public void c(@NotNull View v3, @Nullable n item, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, v3, item, Integer.valueOf(position));
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            com.tencent.mobileqq.leba.entity.f fVar = new com.tencent.mobileqq.leba.entity.f();
            fVar.f240480d = true;
            Intrinsics.checkNotNull(item);
            fVar.f240477a = item.f240504a;
            fVar.f240478b = position + 1;
            if (v3 instanceof RedTouch) {
                fVar.f240479c = l.b((RedTouch) v3);
            }
            TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
            if (companion.j()) {
                fVar.f240479c = companion.e(String.valueOf(item.f240504a));
                com.tencent.mobileqq.leba.report.d.g(v3, item, position, String.valueOf(Long.valueOf(item.f240504a)));
            }
            LebaPluginFeedAdapter.this.u().q(v3, item, fVar);
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17903);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LebaPluginFeedAdapter$Companion$postBindSwitch$2.INSTANCE);
        C = lazy;
    }

    public LebaPluginFeedAdapter(@NotNull LebaPluginProxy lebaPluginProxy) {
        Intrinsics.checkNotNullParameter(lebaPluginProxy, "lebaPluginProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginProxy);
            return;
        }
        this.lebaPluginProxy = lebaPluginProxy;
        this.pluginDataList = new ArrayList();
        this.lebaRedTouchBase = new a.b();
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.pluginClickListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, LebaPluginFeedAdapter this$0, LebaPluginsFeedViewHolder lebaPluginsFeedViewHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 < this$0.pluginDataList.size() && lebaPluginsFeedViewHolder != null) {
            lebaPluginsFeedViewHolder.i(this$0.pluginDataList.get(i3), i3);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    @UiThread
    public final void A(@NotNull List<? extends n> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (INSTANCE.b()) {
            this.uiHandler.removeCallbacksAndMessages(null);
        }
        this.pluginDataList.clear();
        this.pluginDataList.addAll(data);
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.pluginDataList.size(), 10);
            return coerceAtMost;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    @NotNull
    public final LebaPluginProxy u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LebaPluginProxy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.lebaPluginProxy;
    }

    public final void v(@Nullable final n pluginViewItem) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pluginViewItem);
            return;
        }
        if (pluginViewItem != null) {
            if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                int indexOf = this.pluginDataList.indexOf(pluginViewItem);
                if (indexOf >= 0 && indexOf < this.pluginDataList.size()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    notifyItemChanged(indexOf, 0);
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(pluginViewItem) { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedAdapter$notifyPluginChanged$$inlined$runOnMainThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ n f240540d;

                {
                    this.f240540d = pluginViewItem;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginFeedAdapter.this, (Object) pluginViewItem);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    boolean z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int indexOf2 = LebaPluginFeedAdapter.this.pluginDataList.indexOf(this.f240540d);
                    if (indexOf2 >= 0 && indexOf2 < LebaPluginFeedAdapter.this.pluginDataList.size()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        LebaPluginFeedAdapter.this.notifyItemChanged(indexOf2, 0);
                    }
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@Nullable final LebaPluginsFeedViewHolder holder, final int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
        } else if (INSTANCE.b()) {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.e
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginFeedAdapter.x(position, this, holder);
                }
            });
        } else if (holder != null) {
            holder.i(this.pluginDataList.get(position), position);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(holder, position, getItemId(position));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public LebaPluginsFeedViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LebaPluginsFeedViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, position);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new LebaPluginsFeedViewHolder(this, LebaFeedItemPreLoader.f240776a.c(viewGroup, R.layout.gxf));
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.lebaRedTouchBase.h(MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }
}
