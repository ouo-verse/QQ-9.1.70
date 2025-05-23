package com.tencent.kuikly.core.android;

import a01.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationPage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailComposeActivity;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage;
import com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPage;
import com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.LiveRoomPage;
import com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage;
import com.tencent.hippykotlin.demo.pages.jubao.JubaoPage;
import com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2;
import com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.NBPCityWalkPreviewPager;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonSharePage;
import com.tencent.hippykotlin.demo.pages.nearby.debug.NBPDebugSettingsPage;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPage;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage;
import com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage;
import com.tencent.hippykotlin.demo.pages.nearby.follower_page.NBPFollowerActivity;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage;
import com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageActivity;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupActivity;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceHomePage;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPNewHomepage;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPNewProfileEditPage;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPSetProfileTagEditPage;
import com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.NBPPrayCalendarActivity;
import com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage;
import com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.QQStrangerPublicAccountActivity;
import com.tencent.hippykotlin.demo.pages.nearby.public_account_follow.NBPPublicAccountFollowActivity;
import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage;
import com.tencent.hippykotlin.demo.pages.nearby.qq_stranger_nearby_entry_guide.QQStrangerNearbyEntryGuidePage;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.BlindBoxProductDetailPage;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage;
import com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailPage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverPage;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select.QPVideoSelectPage;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage;
import com.tencent.hippykotlin.demo.pages.qqfile.views.QQFileExpiringListActivity;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDebugActivity;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQTransferDownloadActivity;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity;
import com.tencent.hippykotlin.demo.pages.qqkmp.core.QQKMPCore;
import com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.HbDetailPager;
import com.tencent.hippykotlin.demo.pages.qzone.pages.QZMoodTimeActivity;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowPage;
import com.tencent.hippykotlin.demo.pages.router_page.RouterPage;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage;
import com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponPage;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage;
import com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage;
import com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage;
import com.tencent.kuikly.core.IKuiklyCoreEntry;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.demo.pages.shop_biz.ticket_detail_page.TicketDetailPage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019JL\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/android/KuiklyCoreEntry;", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "", "callKotlinMethod", "triggerRegisterPages", "", "hadRegisterNativeBridge", "Z", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "delegate", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "getDelegate", "()Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "setDelegate", "(Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;)V", "<init>", "()V", "Companion", "a", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class KuiklyCoreEntry implements IKuiklyCoreEntry {
    public static final int $stable = 8;
    private IKuiklyCoreEntry.Delegate delegate;
    private boolean hadRegisterNativeBridge;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class b implements c.a {
        public b() {
        }

        @Override // a01.c.a
        public final Object callNative(int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            IKuiklyCoreEntry.Delegate delegate = KuiklyCoreEntry.this.getDelegate();
            if (delegate != null) {
                return delegate.callNative(i3, obj, obj2, obj3, obj4, obj5, obj6);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class c implements a01.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKuiklyCoreEntry.Delegate f117069a;

        public c(IKuiklyCoreEntry.Delegate delegate) {
            this.f117069a = delegate;
        }

        @Override // a01.b
        public final Object callNative(int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            IKuiklyCoreEntry.Delegate delegate = this.f117069a;
            if (delegate != null) {
                return delegate.callNative(i3, obj, obj2, obj3, obj4, obj5, obj6);
            }
            return null;
        }
    }

    @Override // com.tencent.kuikly.core.IKuiklyCoreEntry
    public void callKotlinMethod(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        BridgeManager bridgeManager = BridgeManager.f117344a;
        if (!bridgeManager.A()) {
            bridgeManager.x(new c(getDelegate()));
            triggerRegisterPages();
        }
        if (!this.hadRegisterNativeBridge) {
            this.hadRegisterNativeBridge = true;
            a01.c cVar = new a01.c();
            cVar.b(new b());
            Intrinsics.checkNotNull(arg0, "null cannot be cast to non-null type kotlin.String");
            bridgeManager.C((String) arg0, cVar);
        }
        bridgeManager.j(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Override // com.tencent.kuikly.core.IKuiklyCoreEntry
    public IKuiklyCoreEntry.Delegate getDelegate() {
        return this.delegate;
    }

    @Override // com.tencent.kuikly.core.IKuiklyCoreEntry
    public void setDelegate(IKuiklyCoreEntry.Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // com.tencent.kuikly.core.IKuiklyCoreEntry
    public void triggerRegisterPages() {
        BridgeManager bridgeManager = BridgeManager.f117344a;
        bridgeManager.D("adelie_agreement_consent_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$1
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdelieAgreementConsentPage();
            }
        });
        bridgeManager.D("adelie_category_home", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$2
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdelieCategoryHomePage();
            }
        });
        bridgeManager.D("adelie_creative_center", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$3
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdelieCreativeCenterPage();
            }
        });
        bridgeManager.D("adelie_manager_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$4
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdelieManagerCenterPage();
            }
        });
        bridgeManager.D("adelie_manager_permissions_setting_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$5
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new PermissionsSettingPage();
            }
        });
        bridgeManager.D("adelie_prompt_conversation", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$6
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdeliePromptConversationPage();
            }
        });
        bridgeManager.D("adelie_setting_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$7
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdelieSettingComposePage();
            }
        });
        bridgeManager.D("adelie_tts_setting_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$8
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AdelieTtsSettingPage();
            }
        });
        bridgeManager.D("dataline_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$9
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new DatalineDetailComposeActivity();
            }
        });
        bridgeManager.D("game_content_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$10
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new GameContentPage();
            }
        });
        bridgeManager.D("goods_center", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$11
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new GoodsCenterPage();
            }
        });
        bridgeManager.D("live_room_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$12
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new LiveRoomPage();
            }
        });
        bridgeManager.D("Jubao_inner", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$13
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new JubaoInnerPage();
            }
        });
        bridgeManager.D("Jubao", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$14
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new JubaoPage();
            }
        });
        bridgeManager.D("nearby_aio_setting", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$15
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPAIOSettingPage();
            }
        });
        bridgeManager.D("nearby_article_feed_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$16
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPArticleFeedDetailPageV2();
            }
        });
        bridgeManager.D("nearbypro_choose_theme", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$17
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPChooseThemePage();
            }
        });
        bridgeManager.D("nearby_city_walk_preview", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$18
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPCityWalkPreviewPager();
            }
        });
        bridgeManager.D("nearby_common_share", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$19
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NearbyCommonSharePage();
            }
        });
        bridgeManager.D("nbp_debug_settings", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$20
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPDebugSettingsPage();
            }
        });
        bridgeManager.D("nearby_feed_comment", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$21
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NearbyFeedCommentPage();
            }
        });
        bridgeManager.D("nearby_feed_comment_input", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$22
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NearbyFeedCommentInputPage();
            }
        });
        bridgeManager.D("nearby_feed_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$23
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NearbyFeedDetailPage();
            }
        });
        bridgeManager.D("nearbypro_feed_like", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$24
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPFeedLikePage();
            }
        });
        bridgeManager.D("nbp_follower_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$25
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPFollowerActivity();
            }
        });
        bridgeManager.D("nearbypro_interactive_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$26
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPInteractivePage();
            }
        });
        bridgeManager.D("nearbypro_interactive_users_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$27
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPInteractiveUsersPage();
            }
        });
        bridgeManager.D("nearbypro_main", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$28
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPMainPager();
            }
        });
        bridgeManager.D("nearby_middle_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$29
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPMiddlePageActivity();
            }
        });
        bridgeManager.D("nbp_mood_group", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$30
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPMoodGroupActivity();
            }
        });
        bridgeManager.D("nearbypro_guide_novice_home", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$31
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPGuideNoviceHomePage();
            }
        });
        bridgeManager.D("nearbypro_guide_tag_pick", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$32
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPGuideTagPickPage();
            }
        });
        bridgeManager.D("nearbypro_guide_tag_publish", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$33
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPGuideTagPublishPage();
            }
        });
        bridgeManager.D("nearby_modal_homepage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$34
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPModalHomePage();
            }
        });
        bridgeManager.D("nearby_new_homepage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$35
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPNewHomepage();
            }
        });
        bridgeManager.D("nearby_manifesto_edit", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$36
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPManifestoEditPage();
            }
        });
        bridgeManager.D("nearby_new_profile_edit", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$37
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPNewProfileEditPage();
            }
        });
        bridgeManager.D("nearby_profile_tag_edit", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$38
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPSetProfileTagEditPage();
            }
        });
        bridgeManager.D("nbp_pray_calendar", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$39
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPPrayCalendarActivity();
            }
        });
        bridgeManager.D("nearby_profile_avatar_edit", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$40
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NearbyProfileAvatarEditPage();
            }
        });
        bridgeManager.D("nearby_profile_name_edit", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$41
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPProfileNameEditPage();
            }
        });
        bridgeManager.D("stranger_public_account", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$42
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQStrangerPublicAccountActivity();
            }
        });
        bridgeManager.D("nbp_public_account_follow", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$43
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPPublicAccountFollowActivity();
            }
        });
        bridgeManager.D("nearby_publish", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$44
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new NBPPublishPage();
            }
        });
        bridgeManager.D("qq_stranger_nearby_entry_guide", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$45
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQStrangerNearbyEntryGuidePage();
            }
        });
        bridgeManager.D("float_product_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$46
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new BlindBoxProductDetailPage();
            }
        });
        bridgeManager.D("product_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$47
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new ProductDetailPage();
            }
        });
        bridgeManager.D("LiveCouponReceivePage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$48
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new LiveCouponReceivePage();
            }
        });
        bridgeManager.D("qlive_common_pendant", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$49
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new LuckyBagPendantPage();
            }
        });
        bridgeManager.D("qplus_traffic_home", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$50
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPlusTrafficHomePage();
            }
        });
        bridgeManager.D("qplus_order_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$51
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPOrderDetailPage();
            }
        });
        bridgeManager.D("qplus_promote_creator_portrait", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$52
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPPromoteReceiverCreatorPortraitPage();
            }
        });
        bridgeManager.D("qplus_traffic_promote_group", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$53
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPPromoteReceiverGroupPortraitPage();
            }
        });
        bridgeManager.D("qplus_receiver_interest_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$54
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPPromoteReceiverInterestTagsPage();
            }
        });
        bridgeManager.D("qplus_promote_receiver", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$55
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPPromoteReceiverPage();
            }
        });
        bridgeManager.D("promotion_video_select", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$56
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QPVideoSelectPage();
            }
        });
        bridgeManager.D("love_wall_homepage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$57
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new LoveWallHomepage();
            }
        });
        bridgeManager.D("QQFileExpiringListPage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$58
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQFileExpiringListActivity();
            }
        });
        bridgeManager.D("QQTransferDebugActivity", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$59
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQTransferDebugActivity();
            }
        });
        bridgeManager.D("QQTransferDownloadActivity", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$60
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQTransferDownloadActivity();
            }
        });
        bridgeManager.D("QQTransferCenterActivity", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$61
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQTransferCenterActivity();
            }
        });
        bridgeManager.D("QQKMPCore", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$62
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QQKMPCore();
            }
        });
        bridgeManager.D("anchor_resolution_setting", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$63
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AnchorResolutionSettingPage();
            }
        });
        bridgeManager.D("live_explain_view", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$64
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new LiveExplainPage();
            }
        });
        bridgeManager.D("qsearch_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$65
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QSearchDetailPage();
            }
        });
        bridgeManager.D("qwallet_hb_detail", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$66
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new HbDetailPager();
            }
        });
        bridgeManager.D("qzone_mood_time", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$67
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new QZMoodTimeActivity();
            }
        });
        bridgeManager.D("retain_pop_window", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$68
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new RetainPopWindowPage();
            }
        });
        bridgeManager.D("router", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$69
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new RouterPage();
            }
        });
        bridgeManager.D("38", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$70
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new AfterSalesDetailPage();
            }
        });
        bridgeManager.D("EntrancePage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$71
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new EntrancePage();
            }
        });
        bridgeManager.D("my_coupon_list", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$72
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new MyCouponListPage();
            }
        });
        bridgeManager.D("obtain_coupon_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$73
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new ObtainCouponPage();
            }
        });
        bridgeManager.D("select_coupon_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$74
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new SelectCouponPage();
            }
        });
        bridgeManager.D("ticket_detail_page", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$75
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new TicketDetailPage();
            }
        });
        bridgeManager.D("VasBackgroundShop", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$76
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new BackgroundShopPage();
            }
        });
        bridgeManager.D("UploadBackgroundPage", new Function0<com.tencent.kuikly.core.pager.b>() { // from class: com.tencent.kuikly.core.android.KuiklyCoreEntry$triggerRegisterPages$77
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new UpLoadBackgroundPage();
            }
        });
    }
}
