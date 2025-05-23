package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedpro.widget.MenuItem;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProHeaderNaviBarElement;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "", "Lcom/qzone/reborn/feedpro/widget/header/NavigatorItem;", "o", "Lcom/qzone/reborn/feedpro/widget/MenuItem;", DomainData.DOMAIN_NAME, "", "p", "onInit", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "k", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProNavigatorBar;", "f", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProNavigatorBar;", "getNavigatorBar", "()Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProNavigatorBar;", "setNavigatorBar", "(Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProNavigatorBar;)V", "navigatorBar", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "getNavBarMenuIcon", "()Landroid/widget/ImageView;", "setNavBarMenuIcon", "(Landroid/widget/ImageView;)V", "navBarMenuIcon", "Lcom/qzone/reborn/feedpro/widget/b;", "i", "Lcom/qzone/reborn/feedpro/widget/b;", "getMenuPopupWindow", "()Lcom/qzone/reborn/feedpro/widget/b;", "setMenuPopupWindow", "(Lcom/qzone/reborn/feedpro/widget/b;)V", "menuPopupWindow", "Landroid/view/View;", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProHeaderNaviBarElement extends d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProNavigatorBar navigatorBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView navBarMenuIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.widget.b menuPopupWindow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProHeaderNaviBarElement(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.navigatorBar = (QzoneFeedProNavigatorBar) containerView.findViewById(R.id.mzz);
        this.navBarMenuIcon = (ImageView) containerView.findViewById(R.id.mwe);
    }

    private final List<MenuItem> n() {
        ArrayList arrayList = new ArrayList();
        if (QZoneIntimateEntranceManager.v()) {
            MenuItem menuItem = new MenuItem(0, 0, null, null, 15, null);
            menuItem.e(72);
            menuItem.f(R.drawable.qui_intimates_space_qzone);
            menuItem.h(QzoneConfig.DEFAULT_VALUE_INTIMATE_SPACE_NAME);
            menuItem.g(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProHeaderNaviBarElement$buildMenuItems$list$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String p06 = QZoneConfigHelper.p0();
                    if (p06 == null || p06.length() == 0) {
                        return;
                    }
                    ho.i.p(QzoneFeedProHeaderNaviBarElement.this.h().getContext(), p06);
                }
            });
            arrayList.add(menuItem);
        }
        return arrayList;
    }

    private final void p() {
        com.qzone.reborn.feedpro.widget.b bVar;
        ImageView imageView = this.navBarMenuIcon;
        if (imageView == null || (bVar = this.menuPopupWindow) == null) {
            return;
        }
        bVar.i(imageView, 2, 4, 0, com.qzone.reborn.util.r.f59560a.e(12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(QzoneFeedProHeaderNaviBarElement this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.header.d
    public String k() {
        return "QzoneFeedProHeaderNaviBarElement";
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QzoneFeedProNavigatorBar qzoneFeedProNavigatorBar = this.navigatorBar;
        if (qzoneFeedProNavigatorBar != null) {
            qzoneFeedProNavigatorBar.i();
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        ImageView imageView = this.navBarMenuIcon;
        boolean z16 = true;
        if (imageView != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView, 0.0f, 1, null);
        }
        QzoneFeedProNavigatorBar qzoneFeedProNavigatorBar = this.navigatorBar;
        if (qzoneFeedProNavigatorBar != null) {
            qzoneFeedProNavigatorBar.setNavigatorItems(o());
        }
        ImageView imageView2 = this.navBarMenuIcon;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProHeaderNaviBarElement.q(QzoneFeedProHeaderNaviBarElement.this, view);
                }
            });
        }
        Context context = h().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        View rootView = h().getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "containerView.rootView");
        com.qzone.reborn.feedpro.widget.b bVar = new com.qzone.reborn.feedpro.widget.b(context, rootView);
        bVar.t(n());
        this.menuPopupWindow = bVar;
        List<MenuItem> r16 = bVar.r();
        if (r16 != null && !r16.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            ImageView imageView3 = this.navBarMenuIcon;
            if (imageView3 == null) {
                return;
            }
            imageView3.setVisibility(8);
            return;
        }
        ImageView imageView4 = this.navBarMenuIcon;
        if (imageView4 == null) {
            return;
        }
        imageView4.setVisibility(0);
    }

    private final List<NavigatorItem> o() {
        ArrayList arrayList = new ArrayList();
        NavigatorItem navigatorItem = new NavigatorItem(0, 0, null, null, 15, null);
        navigatorItem.e(20);
        navigatorItem.f(R.drawable.qui_shuoshuo_qzone);
        navigatorItem.h("\u8bf4\u8bf4");
        navigatorItem.g(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProHeaderNaviBarElement$buildNaviItems$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                long uin = LoginData.getInstance().getUin();
                String nickName = LoginData.getInstance().getNickName("");
                Intrinsics.checkNotNullExpressionValue(nickName, "getInstance().getNickName(\"\")");
                ho.i.h().c(QzoneFeedProHeaderNaviBarElement.this.i(), new QZoneMoodListInitBean(uin, nickName, "getActiveFeeds"));
            }
        });
        arrayList.add(navigatorItem);
        NavigatorItem navigatorItem2 = new NavigatorItem(0, 0, null, null, 15, null);
        navigatorItem2.e(100);
        navigatorItem2.f(R.drawable.qui_rizhi_qzone);
        navigatorItem2.h("\u65e5\u5fd7");
        navigatorItem2.g(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProHeaderNaviBarElement$buildNaviItems$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                vo.b.g(QzoneFeedProHeaderNaviBarElement.this.i(), LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""), "getActiveFeeds");
            }
        });
        arrayList.add(navigatorItem2);
        NavigatorItem navigatorItem3 = new NavigatorItem(0, 0, null, null, 15, null);
        navigatorItem3.e(19);
        navigatorItem3.f(R.drawable.qui_image_qzone);
        navigatorItem3.h(QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE);
        navigatorItem3.g(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProHeaderNaviBarElement$buildNaviItems$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                vo.b.f(QzoneFeedProHeaderNaviBarElement.this.i(), LoginData.getInstance().getUin(), "getActiveFeeds");
            }
        });
        arrayList.add(navigatorItem3);
        NavigatorItem navigatorItem4 = new NavigatorItem(0, 0, null, null, 15, null);
        navigatorItem4.e(101);
        navigatorItem4.f(R.drawable.qui_comment_bank_qzone);
        navigatorItem4.h("\u7559\u8a00");
        navigatorItem4.g(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProHeaderNaviBarElement$buildNaviItems$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ho.i.z().l(QzoneFeedProHeaderNaviBarElement.this.i(), LoginData.getInstance().getUin());
            }
        });
        arrayList.add(navigatorItem4);
        return arrayList;
    }
}
