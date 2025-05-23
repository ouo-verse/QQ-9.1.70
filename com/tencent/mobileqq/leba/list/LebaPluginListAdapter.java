package com.tencent.mobileqq.leba.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.controller.list.a;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.entity.p;
import com.tencent.mobileqq.leba.list.LebaPluginListAdapter;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouch;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.view.LebaListItemPreLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u00019\u0018\u0000 22\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003?@AB\u000f\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b=\u0010>J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J2\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u001e\u0010\u0017\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u001b\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007J\u0010\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001e\u001a\u00020\rR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$PluginItemHolder;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "resID", "", "resPkgName", "", "position", "", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouch;", "redBadge", "E", "Landroid/view/ViewGroup;", "viewGroup", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getItemCount", "holder", "y", "", "Lcom/tencent/mobileqq/leba/entity/n;", "data", "D", "pluginViewItem", HippyTKDListViewAdapter.X, "B", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "d", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "v", "()Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "lebaPluginProxy", "", "e", "Ljava/util/List;", "pluginDataList", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouchBase;", "f", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouchBase;", "lebaRedTouch", "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$b;", h.F, "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$b;", "w", "()Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$b;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$b;)V", "pluginItemController", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "uiHandler", "com/tencent/mobileqq/leba/list/LebaPluginListAdapter$pluginClickListener$1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$pluginClickListener$1;", "pluginClickListener", "<init>", "(Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;)V", "a", "b", "PluginItemHolder", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginListAdapter extends RecyclerView.Adapter<PluginItemHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
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
    private final LebaRedTouchBase lebaRedTouch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b pluginItemController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginListAdapter$pluginClickListener$1 pluginClickListener;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u00108J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$PluginItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "o", "", "position", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, h.F, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "letsTextView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "letsIcon", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "itemLayout", "arrowIcon", "i", "Landroid/view/View;", "divider", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouch;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/leba/redtouch/LebaRedTouch;", "unityRedBadge", "D", "customRedViewContainer", "E", "Lcom/tencent/mobileqq/leba/entity/n;", "dataItem", UserInfo.SEX_FEMALE, "I", "k", "()I", "setCurPosition", "(I)V", "curPosition", "", "G", "Z", "isVasTheme", "itemView", "<init>", "(Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter;Landroid/view/View;)V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class PluginItemHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private LebaRedTouch unityRedBadge;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final RelativeLayout customRedViewContainer;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private n dataItem;

        /* renamed from: F, reason: from kotlin metadata */
        private int curPosition;

        /* renamed from: G, reason: from kotlin metadata */
        private boolean isVasTheme;
        final /* synthetic */ LebaPluginListAdapter H;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView letsTextView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView letsIcon;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RelativeLayout itemLayout;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView arrowIcon;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View divider;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RedTouch redTouch;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "path", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.leba.list.LebaPluginListAdapter$PluginItemHolder$1, reason: invalid class name */
        /* loaded from: classes15.dex */
        static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<WeakReference<PluginItemHolder>> $weakReference;
            final /* synthetic */ PluginItemHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Ref.ObjectRef<WeakReference<PluginItemHolder>> objectRef, PluginItemHolder pluginItemHolder) {
                super(1);
                this.$weakReference = objectRef;
                this.this$0 = pluginItemHolder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef, (Object) pluginItemHolder);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public static final void b(Ref.ObjectRef weakReference, PluginItemHolder this$0) {
                Intrinsics.checkNotNullParameter(weakReference, "$weakReference");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                PluginItemHolder pluginItemHolder = (PluginItemHolder) ((WeakReference) weakReference.element).get();
                if (pluginItemHolder != null) {
                    this$0.n(pluginItemHolder.k());
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
                final Ref.ObjectRef<WeakReference<PluginItemHolder>> objectRef = this.$weakReference;
                final PluginItemHolder pluginItemHolder = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        LebaPluginListAdapter.PluginItemHolder.AnonymousClass1.b(Ref.ObjectRef.this, pluginItemHolder);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Type inference failed for: r1v4, types: [mqq.util.WeakReference, T] */
        public PluginItemHolder(@NotNull final LebaPluginListAdapter lebaPluginListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = lebaPluginListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginListAdapter, (Object) itemView);
                return;
            }
            this.curPosition = -1;
            View findViewById = itemView.findViewById(R.id.e6w);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.leba_item_layout)");
            RelativeLayout relativeLayout = (RelativeLayout) findViewById;
            this.itemLayout = relativeLayout;
            View findViewById2 = itemView.findViewById(R.id.letsTextView);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.letsTextView)");
            this.letsTextView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.letsIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.letsIcon)");
            this.letsIcon = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f164473yx);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(co\u2026.leba.api.R.id.arrowIcon)");
            this.arrowIcon = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.ygg);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.leba_item_divider)");
            this.divider = findViewById5;
            View findViewById6 = itemView.findViewById(R.id.yhr);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.letsBizContainer)");
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById6;
            this.customRedViewContainer = relativeLayout2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 19;
            layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 10.0f, relativeLayout2.getResources().getDisplayMetrics());
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            TianshuRedTouch k06 = new LebaRedTouch(context, relativeLayout2).h0(8388629).k0(layoutParams);
            Intrinsics.checkNotNull(k06, "null cannot be cast to non-null type com.tencent.mobileqq.leba.redtouch.LebaRedTouch");
            this.unityRedBadge = (LebaRedTouch) k06;
            RedTouch applyTo = new RedTouch(itemView.getContext(), relativeLayout).setRightMargin(36.0f).setImageGravity(21).setImageRedTouchMargin(0.0f, 32.0f, 0.0f, 0.0f).setUseNewStyle(true).setUseTextColorFromRedTouchConfig(false).applyTo();
            Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(itemView.contex\u2026               .applyTo()");
            this.redTouch = applyTo;
            if (TianshuRedTouch.INSTANCE.j()) {
                ViewGroup.LayoutParams layoutParams2 = relativeLayout2.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams2, "customRedViewContainer.layoutParams");
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).leftMargin = 10;
                }
                LebaRedTouch lebaRedTouch = this.unityRedBadge;
                if (lebaRedTouch != null) {
                    lebaRedTouch.p0(TianshuRedTouch.RedTouchAssembleType.ALL_REDTOUCH);
                }
                LebaRedTouch lebaRedTouch2 = this.unityRedBadge;
                if (lebaRedTouch2 != null) {
                    lebaRedTouch2.t();
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new WeakReference(this);
                LebaRedTouch lebaRedTouch3 = this.unityRedBadge;
                if (lebaRedTouch3 != null) {
                    lebaRedTouch3.setNotifyRedBadgeShow(new AnonymousClass1(objectRef, this));
                }
            }
            applyTo.setOnClickListener(com.tencent.mobileqq.leba.view.d.INSTANCE.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.list.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LebaPluginListAdapter.PluginItemHolder.d(LebaPluginListAdapter.PluginItemHolder.this, lebaPluginListAdapter, view);
                }
            }));
            this.isVasTheme = QQTheme.isVasTheme();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final PluginItemHolder this$0, final LebaPluginListAdapter this$1, final View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            com.tencent.mobileqq.leba.util.a aVar = com.tencent.mobileqq.leba.util.a.f240763a;
            if (!aVar.a()) {
                n nVar = this$0.dataItem;
                if (nVar != null) {
                    LebaPluginListAdapter$pluginClickListener$1 lebaPluginListAdapter$pluginClickListener$1 = this$1.pluginClickListener;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    lebaPluginListAdapter$pluginClickListener$1.a(it, nVar, this$0.k());
                    if (nVar.f240507d == 2) {
                        this$1.pluginClickListener.b(it, nVar);
                    } else {
                        this$1.pluginClickListener.c(it, nVar, this$0.k());
                    }
                    if (aVar.a()) {
                        this$0.l(it, nVar);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new LebaPluginListAdapter$PluginItemHolder$lambda$3$lambda$2$lambda$1$$inlined$runOnMainThread$1(this$0, it, nVar));
                    }
                }
            } else {
                com.tencent.mobileqq.leba.util.a.c(new Runnable(this$1, it) { // from class: com.tencent.mobileqq.leba.list.LebaPluginListAdapter$PluginItemHolder$_init_$lambda$3$$inlined$runOnWorkThread$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ LebaPluginListAdapter f240613d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ View f240614e;

                    {
                        this.f240613d = this$1;
                        this.f240614e = it;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, LebaPluginListAdapter.PluginItemHolder.this, this$1, it);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            n nVar2 = LebaPluginListAdapter.PluginItemHolder.this.dataItem;
                            if (nVar2 != null) {
                                LebaPluginListAdapter$pluginClickListener$1 lebaPluginListAdapter$pluginClickListener$12 = this.f240613d.pluginClickListener;
                                View it5 = this.f240614e;
                                Intrinsics.checkNotNullExpressionValue(it5, "it");
                                lebaPluginListAdapter$pluginClickListener$12.a(this.f240614e, nVar2, LebaPluginListAdapter.PluginItemHolder.this.k());
                                if (nVar2.f240507d == 2) {
                                    LebaPluginListAdapter$pluginClickListener$1 lebaPluginListAdapter$pluginClickListener$13 = this.f240613d.pluginClickListener;
                                    View it6 = this.f240614e;
                                    Intrinsics.checkNotNullExpressionValue(it6, "it");
                                    lebaPluginListAdapter$pluginClickListener$13.b(this.f240614e, nVar2);
                                } else {
                                    LebaPluginListAdapter$pluginClickListener$1 lebaPluginListAdapter$pluginClickListener$14 = this.f240613d.pluginClickListener;
                                    View it7 = this.f240614e;
                                    Intrinsics.checkNotNullExpressionValue(it7, "it");
                                    lebaPluginListAdapter$pluginClickListener$14.c(this.f240614e, nVar2, LebaPluginListAdapter.PluginItemHolder.this.k());
                                }
                                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                                    LebaPluginListAdapter.PluginItemHolder.this.l(this.f240614e, nVar2);
                                    return;
                                } else {
                                    ThreadManagerV2.getUIHandlerV2().post(new LebaPluginListAdapter$PluginItemHolder$lambda$3$lambda$2$lambda$1$$inlined$runOnMainThread$1(LebaPluginListAdapter.PluginItemHolder.this, this.f240614e, nVar2));
                                    return;
                                }
                            }
                            return;
                        }
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(PluginItemHolder this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.n(i3);
        }

        private final void j(n item, int position) {
            String str;
            String str2;
            String str3 = null;
            if (TianshuRedTouch.INSTANCE.j()) {
                this.customRedViewContainer.setVisibility(0);
                LebaPluginListAdapter lebaPluginListAdapter = this.H;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                LebaRedTouch lebaRedTouch = this.unityRedBadge;
                long j3 = item.f240504a;
                LebaPluginInfo lebaPluginInfo = item.f240505b;
                if (lebaPluginInfo != null) {
                    str3 = lebaPluginInfo.strPkgName;
                }
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3;
                }
                lebaPluginListAdapter.E(context, lebaRedTouch, j3, str2, position);
                return;
            }
            if (item.f240507d == 1) {
                if (!this.H.v().y(item, this.redTouch, this.H.lebaRedTouch.c(MobileQQ.sMobileQQ.peekAppRuntime(), String.valueOf(item.f240504a)), 1)) {
                    LebaPluginListAdapter lebaPluginListAdapter2 = this.H;
                    Context context2 = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                    RedTouch redTouch = this.redTouch;
                    long j16 = item.f240504a;
                    LebaPluginInfo lebaPluginInfo2 = item.f240505b;
                    if (lebaPluginInfo2 != null) {
                        str3 = lebaPluginInfo2.strPkgName;
                    }
                    if (str3 == null) {
                        str = "";
                    } else {
                        str = str3;
                    }
                    lebaPluginListAdapter2.F(context2, redTouch, j16, str, position);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(View view, n item) {
            LebaRedTouch lebaRedTouch = this.unityRedBadge;
            if (lebaRedTouch != null) {
                lebaRedTouch.x();
            }
        }

        private final View m() {
            return this.redTouch;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n(int position) {
            n nVar = this.dataItem;
            if (nVar != null) {
                LebaPluginListAdapter lebaPluginListAdapter = this.H;
                VideoReport.setElementReuseIdentifier(m(), String.valueOf(nVar.f240504a));
                com.tencent.mobileqq.leba.report.d.j(m(), nVar, position + 1);
                String g16 = lebaPluginListAdapter.v().g(nVar);
                TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                if (companion.j()) {
                    com.tencent.mobileqq.leba.report.d.u(m(), String.valueOf(companion.g(String.valueOf(nVar.f240504a))), companion.f(String.valueOf(nVar.f240504a)));
                } else {
                    com.tencent.mobileqq.leba.report.d.u(m(), g16, "0");
                }
            }
        }

        private final void o() {
            if (TianshuRedTouch.INSTANCE.j()) {
                LebaRedTouch lebaRedTouch = this.unityRedBadge;
                if (lebaRedTouch != null) {
                    lebaRedTouch.w();
                    return;
                }
                return;
            }
            this.customRedViewContainer.removeAllViews();
            this.redTouch.clearRedTouch();
        }

        public final void h(@NotNull n item, final int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, position);
                return;
            }
            Intrinsics.checkNotNullParameter(item, "item");
            n nVar = this.dataItem;
            int i3 = 8;
            if (nVar != null) {
                LebaPluginListAdapter lebaPluginListAdapter = this.H;
                if (!Intrinsics.areEqual(nVar, item)) {
                    this.customRedViewContainer.setVisibility(8);
                    o();
                    lebaPluginListAdapter.v().w(nVar);
                }
            }
            this.dataItem = item;
            this.curPosition = position;
            this.customRedViewContainer.setVisibility(0);
            this.customRedViewContainer.setTag(R.id.ygd, Long.valueOf(item.f240504a));
            LebaPluginProxy v3 = this.H.v();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            v3.d(item, itemView);
            com.tencent.mobileqq.leba.utils.e.b(this.letsIcon, this.letsTextView, this.itemLayout, item, true);
            View view = this.divider;
            if (item.f240508e) {
                if (this.isVasTheme != QQTheme.isVasTheme()) {
                    this.isVasTheme = !this.isVasTheme;
                }
                i3 = 0;
            }
            view.setVisibility(i3);
            this.itemLayout.setBackground(null);
            this.itemLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            j(item, position);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.d
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginListAdapter.PluginItemHolder.i(LebaPluginListAdapter.PluginItemHolder.this, position);
                }
            });
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.curPosition;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.list.LebaPluginListAdapter$a, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$b;", "", "", "position", "", "P0", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void P0(int position);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginListAdapter(@NotNull LebaPluginProxy lebaPluginProxy) {
        Intrinsics.checkNotNullParameter(lebaPluginProxy, "lebaPluginProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaPluginProxy);
            return;
        }
        this.lebaPluginProxy = lebaPluginProxy;
        this.pluginDataList = new ArrayList();
        this.lebaRedTouch = new a.C7962a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.pluginClickListener = new LebaPluginListAdapter$pluginClickListener$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Context context, LebaRedTouch redBadge, long resID, String resPkgName, int position) {
        String valueOf;
        p pVar = new p();
        pVar.f240520a = context;
        pVar.f240522c = redBadge;
        pVar.f240523d = resID;
        pVar.f240524e = resPkgName;
        pVar.f240526g = false;
        pVar.f240525f = position;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (valueOf = String.valueOf(resID)) == null || this.lebaRedTouch.c(peekAppRuntime, valueOf) == null) {
            return;
        }
        if (redBadge != null) {
            redBadge.o0(valueOf, false);
        }
        this.lebaRedTouch.a(pVar);
        this.lebaRedTouch.j(pVar, this.lebaPluginProxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(Context context, RedTouch redTouch, long resID, String resPkgName, int position) {
        p pVar = new p();
        pVar.f240520a = context;
        pVar.f240521b = redTouch;
        pVar.f240523d = resID;
        pVar.f240524e = resPkgName;
        pVar.f240526g = false;
        pVar.f240525f = position;
        this.lebaRedTouch.l(pVar, this.lebaPluginProxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int i3, LebaPluginListAdapter this$0, PluginItemHolder pluginItemHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 < this$0.pluginDataList.size() && pluginItemHolder != null) {
            pluginItemHolder.h(this$0.pluginDataList.get(i3), i3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public PluginItemHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (PluginItemHolder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, position);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return new PluginItemHolder(this, LebaListItemPreLoader.f240780a.c(viewGroup, R.layout.f167912m2));
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.lebaRedTouch.h(MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    public final void C(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.pluginItemController = bVar;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    @UiThread
    public final void D(@NotNull List<? extends n> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.uiHandler.removeCallbacksAndMessages(null);
        this.pluginDataList.clear();
        this.pluginDataList.addAll(data);
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.pluginDataList.size();
    }

    @NotNull
    public final LebaPluginProxy v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LebaPluginProxy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.lebaPluginProxy;
    }

    @Nullable
    public final b w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pluginItemController;
    }

    public final void x(@Nullable final n pluginViewItem) {
        b w3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) pluginViewItem);
            return;
        }
        if (pluginViewItem != null) {
            if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                int indexOf = this.pluginDataList.indexOf(pluginViewItem);
                boolean z16 = false;
                if (indexOf >= 0 && indexOf < this.pluginDataList.size()) {
                    z16 = true;
                }
                if (z16 && (w3 = w()) != null) {
                    w3.P0(indexOf);
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(pluginViewItem) { // from class: com.tencent.mobileqq.leba.list.LebaPluginListAdapter$notifyPluginChanged$$inlined$runOnMainThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ n f240617d;

                {
                    this.f240617d = pluginViewItem;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListAdapter.this, (Object) pluginViewItem);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginListAdapter.b w16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int indexOf2 = LebaPluginListAdapter.this.pluginDataList.indexOf(this.f240617d);
                    boolean z17 = false;
                    if (indexOf2 >= 0 && indexOf2 < LebaPluginListAdapter.this.pluginDataList.size()) {
                        z17 = true;
                    }
                    if (z17 && (w16 = LebaPluginListAdapter.this.w()) != null) {
                        w16.P0(indexOf2);
                    }
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@Nullable final PluginItemHolder holder, final int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder, position);
        } else {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.b
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginListAdapter.z(position, this, holder);
                }
            });
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(holder, position, getItemId(position));
    }
}
