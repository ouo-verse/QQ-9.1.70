package com.tencent.mobileqq.matchfriend.reborn.guide;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.guild.component.banner.indicator.SimpleBannerIndicator;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002;<B\u0017\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00105\u001a\n 2*\u0004\u0018\u000101018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog;", "Landroid/app/Dialog;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "k", "f", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "show", "dismiss", "onBackPressed", "Lcom/tencent/mobileqq/matchfriend/api/b;", "d", "Lcom/tencent/mobileqq/matchfriend/api/b;", "g", "()Lcom/tencent/mobileqq/matchfriend/api/b;", "content", "", "", "e", "Lkotlin/Lazy;", h.F, "()Ljava/util/Map;", "pageParam", "Lcom/tencent/mobileqq/matchfriend/utils/d;", "i", "()Lcom/tencent/mobileqq/matchfriend/utils/d;", "reportHelper", "", "Z", DomainData.DOMAIN_NAME, "()Z", "isPagContent", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mQusHalfScreenFloatingView", "Landroid/view/View;", "Landroid/view/View;", "mContainer", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Button;", "mButton", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mTitle", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerController;", "controller", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/matchfriend/api/b;)V", UserInfo.SEX_FEMALE, "a", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerGuideDialog extends Dialog {

    /* renamed from: C, reason: from kotlin metadata */
    private Button mButton;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private final QUIShimmerController controller;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.matchfriend.api.b content;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy pageParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy reportHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isPagContent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenFloatingView mQusHalfScreenFloatingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "E", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "l", "()Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "pagUrl", "<init>", "(Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;Ljava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RadiusFrameLayout item;

        /* renamed from: F, reason: from kotlin metadata */
        private String pagUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RadiusFrameLayout item, String pagUrl) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
            this.item = item;
            this.pagUrl = pagUrl;
        }

        /* renamed from: l, reason: from getter */
        public final RadiusFrameLayout getItem() {
            return this.item;
        }

        /* renamed from: m, reason: from getter */
        public final String getPagUrl() {
            return this.pagUrl;
        }

        public final void n(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pagUrl = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            TextView textView;
            if (QQStrangerGuideDialog.this.getContent().d().length <= position || QQStrangerGuideDialog.this.getContent().d().length != QQStrangerGuideDialog.this.getContent().e().length || (textView = QQStrangerGuideDialog.this.mTitle) == null) {
                return;
            }
            textView.setText(QQStrangerGuideDialog.this.getContent().d()[position]);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog$e", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e extends com.tencent.mobileqq.widget.qus.e {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57179d() {
            return QQStrangerGuideDialog.this.mContainer;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerGuideDialog(final Context context, com.tencent.mobileqq.matchfriend.api.b content) {
        super(context, R.style.f173448dl);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerGuideDialog$pageParam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends String> invoke() {
                Map<String, ? extends String> mapOf;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_function_name", QQStrangerGuideDialog.this.getContent().a().toString()));
                return mapOf;
            }
        });
        this.pageParam = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.matchfriend.utils.d>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerGuideDialog$reportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.matchfriend.utils.d invoke() {
                return new com.tencent.mobileqq.matchfriend.utils.d(context);
            }
        });
        this.reportHelper = lazy2;
        this.isPagContent = content instanceof b.C8005b;
        this.controller = new QUIShimmerController("Viewholder").setAnimationToken(R.anim.f154986ut, 8);
    }

    private final void f() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        Intrinsics.checkNotNull(qUSHalfScreenFloatingView);
        qUSHalfScreenFloatingView.t();
    }

    private final Map<String, String> h() {
        return (Map) this.pageParam.getValue();
    }

    private final com.tencent.mobileqq.matchfriend.utils.d i() {
        return (com.tencent.mobileqq.matchfriend.utils.d) this.reportHelper.getValue();
    }

    private final void j() {
        List<String> listOf;
        i().c("pg_kl_new_function_float", h());
        com.tencent.mobileqq.matchfriend.utils.d i3 = i();
        listOf = CollectionsKt__CollectionsJVMKt.listOf("em_kl_tochat_btn");
        i3.b(listOf);
    }

    private final void k() {
        ViewPager2 viewPager2;
        TextView textView;
        Object first;
        View inflate = getLayoutInflater().inflate(R.layout.cwe, (ViewGroup) null);
        this.mContainer = inflate;
        Button button = inflate != null ? (Button) inflate.findViewById(R.id.oj5) : null;
        this.mButton = button;
        if (button != null) {
            button.setText(this.content.b());
        }
        Button button2 = this.mButton;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQStrangerGuideDialog.l(QQStrangerGuideDialog.this, view);
                }
            });
        }
        Button button3 = this.mButton;
        if (button3 != null) {
            button3.setBackgroundResource(com.tencent.mobileqq.matchfriend.reborn.utils.b.f245467a.b());
        }
        View view = this.mContainer;
        this.mTitle = view != null ? (TextView) view.findViewById(R.id.osa) : null;
        if ((!(this.content.d().length == 0)) && (textView = this.mTitle) != null) {
            first = ArraysKt___ArraysKt.first(this.content.d());
            textView.setText((CharSequence) first);
        }
        d dVar = new d();
        View view2 = this.mContainer;
        BannerLayout bannerLayout = view2 != null ? (BannerLayout) view2.findViewById(R.id.oii) : null;
        if (bannerLayout != null) {
            bannerLayout.setAdapter(dVar);
        }
        ViewPager2 viewPager22 = bannerLayout != null ? bannerLayout.getViewPager2() : null;
        if (viewPager22 != null) {
            viewPager22.setOffscreenPageLimit(1);
        }
        if (bannerLayout != null && (viewPager2 = bannerLayout.getViewPager2()) != null) {
            viewPager2.registerOnPageChangeCallback(new c());
        }
        if (bannerLayout != null) {
            bannerLayout.setLoop(false);
        }
        View view3 = this.mContainer;
        SimpleBannerIndicator simpleBannerIndicator = view3 != null ? (SimpleBannerIndicator) view3.findViewById(R.id.oij) : null;
        if (simpleBannerIndicator == null || bannerLayout == null) {
            return;
        }
        com.tencent.mobileqq.guild.component.banner.a.f215813a.a(bannerLayout.getViewPager2(), simpleBannerIndicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QQStrangerGuideDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
        com.tencent.mobileqq.matchfriend.api.c c16 = this$0.content.c();
        if (c16 != null) {
            c16.a();
        }
        this$0.i().d("em_kl_tochat_btn");
    }

    private final void m() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QQStrangerGuideDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QQStrangerGuideDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        i().j(h());
        com.tencent.mobileqq.matchfriend.api.c c16 = this.content.c();
        if (c16 != null) {
            c16.onDismiss();
        }
        QUIImmersiveHelper.u(getWindow(), false, true);
    }

    /* renamed from: g, reason: from getter */
    public final com.tencent.mobileqq.matchfriend.api.b getContent() {
        return this.content;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsPagContent() {
        return this.isPagContent;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m();
        j();
        setContentView(R.layout.e3i);
        this.mQusHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        k();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(new e());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setIsHeightWrapContent(true);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setMaxWidthDp(500);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 != null) {
            qUSHalfScreenFloatingView4.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.b
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    QQStrangerGuideDialog.o(QQStrangerGuideDialog.this);
                }
            });
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        i().i(h());
        i().f("em_kl_tochat_btn");
        QUIImmersiveHelper.u(getWindow(), false, true);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog$d", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onDetachedFromRecyclerView", "getItemViewType", "k0", "l0", "m0", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends RecyclerView.Adapter<b> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerGuideDialog$d$a", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/a;", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes33.dex */
        public static final class a implements com.tencent.mobileqq.matchfriend.reborn.guide.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQStrangerGuideDialog f245092a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ QUIShimmerImageView f245093b;

            a(QQStrangerGuideDialog qQStrangerGuideDialog, QUIShimmerImageView qUIShimmerImageView) {
                this.f245092a = qQStrangerGuideDialog;
                this.f245093b = qUIShimmerImageView;
            }

            @Override // com.tencent.mobileqq.matchfriend.reborn.guide.a
            public void a() {
                if (this.f245092a.controller.isShimmerStarted()) {
                    this.f245093b.stopShimming(this.f245092a.controller);
                }
                this.f245093b.setVisibility(8);
            }
        }

        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return QQStrangerGuideDialog.this.getContent().e().length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            QLog.d("QQStrangerGuideDialog", 2, "onBindViewHolder position: " + position);
            if (QQStrangerGuideDialog.this.getIsPagContent()) {
                holder.n(QQStrangerGuideDialog.this.getContent().e()[position]);
                return;
            }
            Option option = Option.obtain().setTargetView((ImageView) holder.getItem().findViewById(R.id.okc)).setUrl(QQStrangerGuideDialog.this.getContent().e()[position]);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int viewType) {
            RadiusFrameLayout radiusFrameLayout;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (QQStrangerGuideDialog.this.getIsPagContent()) {
                View inflate = QQStrangerGuideDialog.this.getLayoutInflater().inflate(R.layout.cw6, parent, false);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.RadiusFrameLayout");
                radiusFrameLayout = (RadiusFrameLayout) inflate;
            } else {
                View inflate2 = QQStrangerGuideDialog.this.getLayoutInflater().inflate(R.layout.cw5, parent, false);
                Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.RadiusFrameLayout");
                radiusFrameLayout = (RadiusFrameLayout) inflate2;
            }
            return new b(radiusFrameLayout, QQStrangerGuideDialog.this.getContent().e()[viewType]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onViewAttachedToWindow(b holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            QLog.d("QQStrangerGuideDialog", 2, "onViewAttachedToWindow ");
            if (QQStrangerGuideDialog.this.getIsPagContent()) {
                float f16 = QQStrangerGuideDialog.this.getContext().getResources().getDisplayMetrics().widthPixels;
                float f17 = QQStrangerGuideDialog.this.getContext().getResources().getDisplayMetrics().heightPixels;
                QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) holder.getItem().findViewById(R.id.oih);
                QQStrangerGuideDialog.this.controller.setEndPoint(f16, f17);
                QQStrangerGuideDialog.this.controller.setStartPoint((float) (f16 / 2.0d), (float) (f17 / 2.0d));
                qUIShimmerImageView.setVisibility(0);
                QQStrangerGuideDialog.this.controller.startShimmer();
                qUIShimmerImageView.startShimming(QQStrangerGuideDialog.this.controller);
                ((QQStrangerPagView) holder.getItem().findViewById(R.id.omv)).q(holder.getPagUrl(), new a(QQStrangerGuideDialog.this, qUIShimmerImageView));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onViewDetachedFromWindow(b holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            QLog.d("QQStrangerGuideDialog", 2, "onViewDetachedFromWindow ");
            if (QQStrangerGuideDialog.this.getIsPagContent()) {
                QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) holder.getItem().findViewById(R.id.oih);
                if (QQStrangerGuideDialog.this.controller.isShimmerStarted()) {
                    qUIShimmerImageView.stopShimming(QQStrangerGuideDialog.this.controller);
                    qUIShimmerImageView.setVisibility(8);
                }
                QQStrangerPagView qQStrangerPagView = (QQStrangerPagView) holder.getItem().findViewById(R.id.omv);
                qQStrangerPagView.s();
                qQStrangerPagView.setVisibility(8);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(b holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            QLog.d("QQStrangerGuideDialog", 2, "onViewRecycled ");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QLog.d("QQStrangerGuideDialog", 2, "onDetachedFromRecyclerView ");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position;
        }
    }
}
