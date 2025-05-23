package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J5\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasWebUrlImpl;", "Lcom/tencent/mobileqq/vas/api/IVasWebUrl;", "()V", CoverDBCacheData.URLS, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getUrls", "()Ljava/util/HashMap;", "getUrl", "key", "gotoLevelPage", "", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "originUrl", "replaceCommonParams", "urlId", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasWebUrlImpl implements IVasWebUrl {

    @NotNull
    private final HashMap<String, String> urls;

    public VasWebUrlImpl() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.urls = hashMap;
        hashMap.put(IndividuationUrlHelper.UrlId.RING_HOME, "https://zb.vip.qq.com/v2/pages/funcallMall?&asyncMode=3");
        hashMap.put(IndividuationUrlHelper.UrlId.BUBBLE_DETAIL_DLG, "https://zb.vip.qq.com/sonic/bubble?_wv=16778243&asyncMode=3&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff&uin=462938286&client=androidQQ&version=6.6.8.3050&platformId=2&device=[device]&system=[system]&adtag=index.h5&id=[id]&show_type=dialog");
        hashMap.put(IndividuationUrlHelper.UrlId.CALL_DETAIL, "https://zb.vip.qq.com/v2/pages/funcallMall?&asyncMode=3&id=[id]");
        hashMap.put(IndividuationUrlHelper.UrlId.STICKER_DETAIL, "https://gxh.vip.qq.com/club/themes/mobile/emoji/html/sticker.html?_wv=3&_nav_txtclr=000000&_nav_titleclr=000000&_nav_statusclr=000000");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_GAMECENTER_PERSONAL_CARD, "https://imgcache.qq.com/gc/gamecenterV2/dist/index/recentplay/recent_play.html?tt=2");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_CHAT_ROAM_CELL, "https://m.vip.qq.com/msgRoam/rel/html/index_v2.html?_wv=5123&_wvx=10&_wvxBclr=0xf8f9fa");
        hashMap.put(IndividuationUrlHelper.UrlId.INDIVIDUATION_MAIN_PAGE, "https://zb.vip.qq.com/v2/pages/home?_wv=5123&_wwv=128&ADTAG=mobileqq.drawer");
        hashMap.put(IndividuationUrlHelper.UrlId.EMOTICON_KEYWORD, "https://imgcache.qq.com/club/item/parcel/json/keywordList.json");
        hashMap.put("hongbao", "https://zb.vip.qq.com/sonic/redpack/index?_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff&from=[from]&asyncMode=3");
        hashMap.put(IndividuationUrlHelper.UrlId.PENDANT_DETAIL, "http://zb.vip.qq.com/collection/aio?_wv=16778243&id=[id]&adtag=mvip.gexinghua.mobile.faceaddon.collection_aio&_preload=1&type=widget&_wvx=3");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_EXTEND_ICON, "https://tianquan.gtimg.cn/nameplatependant/preview/");
        hashMap.put(IndividuationUrlHelper.UrlId.COLORRING_AUDIO, "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/[id]_2.mp3");
        hashMap.put(IndividuationUrlHelper.UrlId.VASCLASS_PROFILESTORY_URL, "https://zb.vip.qq.com/face/category?_wv=16778243&_wvx=3&id=13");
        hashMap.put(IndividuationUrlHelper.UrlId.MAGIC_PLUS, "https://zb.vip.qq.com/emoji/category?key=011");
        hashMap.put(IndividuationUrlHelper.UrlId.SUIT_HOME, "https://gxh.vip.qq.com/club/themes/mobile/suit/index.html?client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&uin=[uin]&density=[density]&_wv=1031&_bid=239");
        hashMap.put(IndividuationUrlHelper.UrlId.CARD_HOME, "https://zb.vip.qq.com/v2/pages/cardMall?");
        hashMap.put(IndividuationUrlHelper.UrlId.TROOP_ENTER_EFFECT, "https://zb.vip.qq.com/group/single?_wv=16777219");
        hashMap.put(IndividuationUrlHelper.UrlId.FUNNY_PIC, "https://zb.vip.qq.com/emoji/category?key=014");
        hashMap.put(IndividuationUrlHelper.UrlId.PENDANT_DETAIL_DLG, "https://zb.vip.qq.com/widget/home?uin=[uin]&client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&adtag=[adtag]&id=[id]&_wv=16778243");
        hashMap.put(IndividuationUrlHelper.UrlId.FONT_DETAIL, "https://zb.vip.qq.com/v2/pages/fontMall?_wv=5123&client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&uin=[uin]&adtag=[adtag]");
        hashMap.put("bubble", "https://zb.vip.qq.com/v2/pages/bubbleMall");
        hashMap.put(IndividuationUrlHelper.UrlId.RING_DETAIL, "https://zb.vip.qq.com/v2/pages/funcallMall?&asyncMode=3&id=[id]");
        hashMap.put("theme", "https://zb.vip.qq.com/v2/pages/themeMall?asyncMode=3");
        hashMap.put(IndividuationUrlHelper.UrlId.NAMEPLATE_CLICK_SVIP, "https://h5.vip.qq.com/p/mc/cardv2/other?_wv=1031");
        hashMap.put(IndividuationUrlHelper.UrlId.BUBBLE_PREVIEW, "https://gxh.vip.qq.com/xydata/bubble/item/[id]/250x300_0.png");
        hashMap.put(IndividuationUrlHelper.UrlId.RARE_CARD, "https://zb.vip.qq.com/newCard/act?id=%d");
        hashMap.put(IndividuationUrlHelper.UrlId.LINK_PENDANT_SET, "https://gxh.vip.qq.com/club/themes/mobile/act/diy_tpl/widgetLink[id]/html/index.html?_wv=1025");
        hashMap.put(IndividuationUrlHelper.UrlId.KUOLIE_PERSONAL_CARD_MASTER, "https://club.vip.qq.com/card?_wvx=3&_nav_anim=true&_nav_alpha=0&source=kl");
        hashMap.put(IndividuationUrlHelper.UrlId.CHAT_BG_DETAIL, "https://zb.vip.qq.com/v2/pages/itemDetail?appid=8&itemid=[id]&_nav_titleclr=000000&_nav_txtclr=000000");
        hashMap.put(IndividuationUrlHelper.UrlId.SIGNATURE_TEMPLATE, "https://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.v2.json");
        hashMap.put("font", "https://zb.vip.qq.com/v2/pages/fontMall?_wv=5123&client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&uin=[uin]&adtag=[adtag]");
        hashMap.put(IndividuationUrlHelper.UrlId.SUIT_DETAIL, "https://gxh.vip.qq.com/club/themes/mobile/suit/detail.html?&_wv=5123&_bid=239&suitid=[id]&suittitle=[title]");
        hashMap.put(IndividuationUrlHelper.UrlId.THEME_DETAIL, "http://zb.vip.qq.com/theme/detail?client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&uin=[uin]&density=[density]&_wv=16782337&id=[id]&_bid=2034&via=index");
        hashMap.put("emoji", "https://zb.vip.qq.com/hybrid/emoticonmall/home?_wv=553648128&_cwv=8&_wwv=129");
        hashMap.put(IndividuationUrlHelper.UrlId.GROUP_KEYWORD, "https://club.vip.qq.com/groupkeywords/group?_wv=7&_wwv=4&_wvx=10&_proxy=1&groupid=[groupid]");
        hashMap.put(IndividuationUrlHelper.UrlId.BUBBLE_DETAIL, "http://zb.vip.qq.com/collection/aio?_wv=16778243&id=[id]&adtag=mvip.gongneng.android.bubble.collection_aio&_preload=1&type=bubble&_wvx=3");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_GAMECENTER_LEBA, "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.mobileqq&cmp=com.tencent.gamecenter.activities.GameCenterActivity&url=https%3A%2F%2Fspeed.gamecenter.qq.com%2Fpushgame%2Fv1%2Fhome%2Findex%3Fplat%3Dqq%26gamecenter%3D1%26_wv%3D18950115%26_wwv%3D265%26ADTAG%3D10001%26gc_mini_floating%3D1%26preMask%3Dgc.home.index%26crashFrom%3D40501%26maxv%3D99");
        hashMap.put(IndividuationUrlHelper.UrlId.EMOJI_OPEN_AUTHOR_DETAIL, "https://gxh.vip.qq.com/club/themes/mobile/bq/html/open_author.html?_wv=1027&authorId=[id]");
        hashMap.put(IndividuationUrlHelper.UrlId.EMOJI_DETAIL, "https://zb.vip.qq.com/hybrid/emoticonmall/detail?id=[id]");
        hashMap.put(IndividuationUrlHelper.UrlId.FRIEND_TO_DIY_PENDANT_HOME, "https://zb.vip.qq.com/v2/pages/widgetMall");
        hashMap.put(IndividuationUrlHelper.UrlId.SIGNATURE_EDIT, "https://zb.vip.qq.com/v2/signList?_wvx=2&_wvxBclr=0xffffff&_wwv=4");
        hashMap.put(IndividuationUrlHelper.UrlId.SMALL_EMOJI_LIST, "https://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?adtag=vip.gongneng.mobile.biaoqing.index&_bid=102&_lv=0&key=012&name=%E5%B0%8F%E8%A1%A8%E6%83%85&src=category_list&_wv=1027");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_UP_GROUP_LIMIT, "https://gxh.vip.qq.com/club/client/group/release/index.html?_bid=199");
        hashMap.put(IndividuationUrlHelper.UrlId.EMOJI_AUTHOR_DETAIL, "https://gxh.vip.qq.com/club/themes/mobile/bq/html/author.html?id=[id]");
        hashMap.put(IndividuationUrlHelper.UrlId.FRIEND_TO_PENDANT_HOME, "https://zb.vip.qq.com/v2/pages/widgetMall");
        hashMap.put(IndividuationUrlHelper.UrlId.COLORRING_COVER, "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/preview.jpg");
        hashMap.put(IndividuationUrlHelper.UrlId.NAMEPLATE_CLICK_DEFAULT, "https://m.vip.qq.com/freedom/freedom_svipicon.html?_nav_alpha=0");
        hashMap.put(IndividuationUrlHelper.UrlId.RARE_PENDANT_ACTIVITY, "https://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=gjjbzh&type=1&_wv=1025");
        hashMap.put(IndividuationUrlHelper.UrlId.FONT_EFFECT_NONE, "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3");
        hashMap.put("background", "https://zb.vip.qq.com/v2/pages/chatbgMall?client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&uin=[uin]&adtag=[adtag]");
        hashMap.put(IndividuationUrlHelper.UrlId.CARD_WORD, "https://imgcache.qq.com/club/mobile/profile/template/summary_card_word.json");
        hashMap.put(IndividuationUrlHelper.UrlId.CARD_WZRY_MADE, "https://zb.vip.qq.com/card/setting?_wv=1027&_wvx=3");
        hashMap.put(IndividuationUrlHelper.UrlId.THEME_PATCH, "https://gxh.material.qq.com/patch/little_world/android/[id].zip");
        hashMap.put(IndividuationUrlHelper.UrlId.FONT_AIO_IMG, "https://imgcache.qq.com/qqshow/admindata/comdata/vipfont_[id]/aio.png");
        hashMap.put(IndividuationUrlHelper.UrlId.COLORRING_CONFIG, "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/config.json");
        hashMap.put(IndividuationUrlHelper.UrlId.PENDANT_HOME, "https://zb.vip.qq.com/sonic/widget/home?uin=[uin]&client=[client]&version=[version]&platformId=[platformId]&device=[device]&system=[system]&adtag=[adtag]&_wv=16778243&asyncMode=3");
        hashMap.put(IndividuationUrlHelper.UrlId.SIGNATURE_DIY_EDIT, "https://zb.vip.qq.com/sign_v2/diy?_wvx=2&_wvxBclr=0xffffff&_wwv=4");
        hashMap.put(IndividuationUrlHelper.UrlId.FONT_PREVIEW, "https://gxh.vip.qq.com/xydata/font/item/[id]/180x150.png");
        hashMap.put(IndividuationUrlHelper.UrlId.MY_FONT, "https://zb.vip.qq.com/font/myFont?_wv=16777219&_wwv=321&_wvx=3");
        hashMap.put(IndividuationUrlHelper.UrlId.FUNCALL_MINE, "https://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123&_bid=2382");
        hashMap.put(IndividuationUrlHelper.UrlId.MY_PENDANT, "https://zb.vip.qq.com/v2/pages/newMinePage?appid=4&_wv=2&_nav_titleclr=000000&_nav_txtclr=000000");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_PERSONAL_CARD_CUSTOM, "https://club.vip.qq.com/card/friend?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&_proxyByURL=1");
        hashMap.put(IndividuationUrlHelper.UrlId.CARD_DETAIL, "https://gxh.vip.qq.com/club/themes/mobile/card/html/detail.html?&cardItemId=[id]&_wv=16782337");
        hashMap.put(IndividuationUrlHelper.UrlId.PLATEOFKINGDAN, "https://mq.vip.qq.com/m/sgame/duanwei?_wvx=2");
        hashMap.put(IndividuationUrlHelper.UrlId.FONT_DETAIL_DLG, "https://imgcache.qq.com/club/themes/mobile/font/index.html?&_bid=182&_wv=1027&asyncMode=1&show_type=dialog&id=[id]");
        hashMap.put(IndividuationUrlHelper.UrlId.FONT_EFFECT, "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3");
        hashMap.put("praise", "https://zb.vip.qq.com/like?_wv=3");
        hashMap.put(IndividuationUrlHelper.UrlId.VIP_PERSONAL_CARD_MASTER, "https://club.vip.qq.com/card?_wvx=10&_nav_anim=true&_nav_alpha=0&_proxy=1");
        hashMap.put(IndividuationUrlHelper.UrlId.DIY_PIC, "https://zb.vip.qq.com/emoji/category?key=014");
        hashMap.put(IndividuationUrlHelper.UrlId.FACE_HOME, "https://zb.vip.qq.com/v2/pages/faceMall");
        hashMap.put("custom_online_status", "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1");
        hashMap.put("vip_icon_setting", "https://zb.vip.qq.com/v2/pages/qqIconMall?_wv=16777216&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoidGJzejAxIiwiaXRlbV9pZCI6IiIsIml0ZW1fdHlwZSI6IiJ9");
        hashMap.put(IndividuationUrlHelper.UrlId.SPECIALCARE_MALL_URL, "https://zb.vip.qq.com/v2/subMall/qqRing?_wv=16778243&locationtype=[lType]&uid=[uid]");
        hashMap.put("call", "https://zb.vip.qq.com/v2/pages/funcallMall");
        hashMap.put("myfuncall", "https://gxh.vip.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=16782339&_bid=2382");
        hashMap.put("myIndividuation", "https://gxh.vip.qq.com/club/themes/mobile/my_dress/index.html");
        hashMap.put("comicCdn", "https://cdn.vip.qq.com/club/mobile/profile/comic_center/");
        hashMap.put("qqreaderWoman", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?_bid=2036&isV2=1");
        hashMap.put("qqreaderAccount", "https://cdn.vip.qq.com/club/client/read/6/rel/mine_index.html?_bid=2036");
        hashMap.put("comicPayRead", "https://qc.vip.qq.com/gc/pages/pay.html");
        hashMap.put("comicReaderContent", "https://cdn.vip.qq.com/club/client/comic/release/html/readerIndex.html");
        hashMap.put("comicRedirect", "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html");
        hashMap.put("comicFav", "https://cdn.vip.qq.com/club/client/comic/release/html/favorite.html?_bid=354&_sw=1");
        hashMap.put("comicReadShare", "https://cdn.vip.qq.com/club/client/comic/release/html/read_share.html?_bid=354&ADTAG=comic.plugin.read&_wv=5123");
        hashMap.put("appStoreVipSubscrptionService", "https://h5.vip.qq.com/p/mc/iospay/index?aid=mios.p.a.APPST_kt&product_id=[productID]");
        hashMap.put("qqreaderMan", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?_bid=2036&isV2=1");
        hashMap.put("qqreaderTribe", "https://cdn.vip.qq.com/club/client/read/6/rel/tribe.html?_bid=2036");
        hashMap.put("qqreaderOffShelf", "https://cdn.vip.qq.com/club/client/read/6/rel/book_offShelf.html?_bid=2036");
        hashMap.put("vipPrivilegeOther", "http://mc.vip.qq.com/privilegelist/other?asyncMode=3&phpsonic=1");
        hashMap.put("comicFavorite", "https://cdn.vip.qq.com/club/client/comic/release/html/favorite.html?_wv=1359554471&_wvx=3");
        hashMap.put("comicDetailComic", "https://qc.vip.qq.com/gc/pages/detail/comicDetail.html");
        hashMap.put("qqreaderBookDetails", "https://cdn.vip.qq.com/club/client/read/6/rel/bookDetails.html?_bid=2036");
        hashMap.put("mycallUrl", "http://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123");
        hashMap.put("signatureH5Url", "https://zb.vip.qq.com/sign?_wv=16778243&_wvx=3");
        hashMap.put("qqreaderSearchIndex", "https://cdn.vip.qq.com/club/client/read/ios/rel/search.html?_bid=2036");
        hashMap.put("comicDetailVideo", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
        hashMap.put("qqreaderPublish", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?_bid=2036&isV2=1");
        hashMap.put("qqreaderComment", "https://cdn.vip.qq.com/club/client/read/6/rel/comment.html?_bid=2036");
        hashMap.put("vipRoamChatBanner", "https://m.vip.qq.com/msgRoam/rel/html/index_v2.html?_wv=5123&_wvx=10&_wvxBclr=0xf8f9fa&ADTAG=xiaolantiao");
        hashMap.put("qqreaderAppdown", "https://cdn.vip.qq.com/club/client/read/6/rel/appdown.html?_bid=2036");
        hashMap.put("comicMyPic", "https://cdn.vip.qq.com/club/client/comic/release/html/my_pic.html");
        hashMap.put("extendnameplatejumpurl_1", "https://act.qzone.qq.com/vip/meteor/blockly/p/6118x3f403?enteranceId=hztzy&adtag=hztzy");
        hashMap.put("qqreaderBookShelfBuy", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_buy.html?_bid=2036");
        hashMap.put("qqreaderHome", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?_bid=2036&isV2=1");
        hashMap.put("qqreaderBookShelfIndex", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_index.html?_bid=2036");
        hashMap.put("comicCategoryTitle", "http://dm.vip.qq.com?a=%E5%88%86%E7%B1%BB");
        hashMap.put("comicGroup", "https://cdn.vip.qq.com/club/client/comic/release/html/group.html?_bid=354&_wv=1091118887");
        hashMap.put("qqreaderSearchResult", "https://cdn.vip.qq.com/club/client/read/6/rel/searchResult.html?_bid=2036");
        hashMap.put("qqreaderPay", "https://cdn.vip.qq.com/club/client/read/6/rel/user_pay_v2.html?_bid=2036");
        hashMap.put("qqreaderReadover", "https://cdn.vip.qq.com/club/client/read/6/rel/readover.html?_bid=2036");
        hashMap.put("qqreaderInteract", "https://cdn.vip.qq.com/club/client/read/6/rel/interact.html?_bid=2036");
        hashMap.put("comicDetailNovel", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
        hashMap.put("comicMore", "https://qc.vip.qq.com/pages/community/index.html?_wv=3&_cwv=4&origin=1");
        hashMap.put("comicIndexTitle", "http://dm.vip.qq.com?a=%E9%A6%96%E9%A1%B5");
        hashMap.put("comicIndex", "https://qc.vip.qq.com/pages/index.html?asyncMode=3&_wv=3&_cwv=4&sonic_remain_params=type&type=multipleTab");
        hashMap.put("qqreaderBookFont", "https://cdn.vip.qq.com/club/client/read/6/rel/bookFont.html?_bid=2036");
        hashMap.put("qqreaderBookShelfFollow", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_follow.html?_bid=2036");
        hashMap.put("qqreaderBookOutDetail", "https://cdn.vip.qq.com/club/client/read/6/rel/book_outDetail.html?_bid=2036");
        hashMap.put("vipPrivilegeMy", "http://mc.vip.qq.com/privilegelist/index?asyncMode=3&phpsonic=1");
        hashMap.put("comicSearch", "https://qc.vip.qq.com/gc/pages/search.html?_wv=1027&type=1&_wwv=4&_wvx=2");
        hashMap.put("comicPicShare", "https://cdn.vip.qq.com/club/client/comic/release/html/pic_share.html");
        hashMap.put("qqreaderBookShelfDelete", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_delete.html?_bid=2036");
        hashMap.put("callDownloadUrl", "http://laidian.qq.com");
        hashMap.put("comicBarrageList", "https://cdn.vip.qq.com/club/client/comic/release/html/bulletScreen.html");
        hashMap.put("comicPayDownload", "https://cdn.vip.qq.com/club/client/comic/release/html/payDownload.html");
        hashMap.put("comicCategory", "https://qc.vip.qq.com/pages/category.html?from=1006002&filter=0&categoryType=1&sort=4&_bid=354&_wv=1027&_cwv=4&_webviewtype=4&asyncMode=3&_wvx=3");
        try {
            JSONObject json = VasLongToggle.INDIVIDUATION_URL.getJson();
            Iterator keys = json.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = json.optString(key);
                HashMap<String, String> hashMap2 = this.urls;
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                hashMap2.put(key, value);
                if (QLog.isColorLevel()) {
                    QLog.i("IVasWebUrl", 1, "add key=" + key + " value=" + value);
                }
            }
        } catch (Exception unused) {
        }
    }

    private final String replaceCommonParams(String originUrl, String urlId) {
        String str;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        String replace$default6;
        if (!TextUtils.isEmpty(originUrl)) {
            try {
                replace$default = StringsKt__StringsJVMKt.replace$default(originUrl, "[client]", "androidQQ", false, 4, (Object) null);
                String reportVersionName = AppSetting.f99554n;
                Intrinsics.checkNotNullExpressionValue(reportVersionName, "reportVersionName");
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[version]", reportVersionName, false, 4, (Object) null);
                replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "[platformId]", "2", false, 4, (Object) null);
                String encode = URLEncoder.encode(Build.DEVICE, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(encode, "encode(Build.DEVICE, \"UTF-8\")");
                replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "[device]", encode, false, 4, (Object) null);
                String encode2 = URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(encode2, "encode(Build.VERSION.RELEASE, \"UTF-8\")");
                str = StringsKt__StringsJVMKt.replace$default(replace$default4, "[system]", encode2, false, 4, (Object) null);
                try {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        String account = peekAppRuntime.getAccount();
                        Intrinsics.checkNotNullExpressionValue(account, "app.account");
                        replace$default5 = StringsKt__StringsJVMKt.replace$default(str, "[uin]", account, false, 4, (Object) null);
                        String themeDensity = ThemeUtil.getThemeDensity(peekAppRuntime.getApplication());
                        Intrinsics.checkNotNullExpressionValue(themeDensity, "getThemeDensity(app.application)");
                        replace$default6 = StringsKt__StringsJVMKt.replace$default(replace$default5, "[density]", themeDensity, false, 4, (Object) null);
                        return replace$default6;
                    }
                    return str;
                } catch (Exception e16) {
                    e = e16;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("replaceCommonParams, url=%s, urlId=%s, exception=%s", Arrays.copyOf(new Object[]{str, urlId, MsfSdkUtils.getStackTraceString(e)}, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QLog.e("IVasWebUrl", 1, format);
                    return str;
                }
            } catch (Exception e17) {
                e = e17;
                str = originUrl;
            }
        } else {
            return originUrl;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasWebUrl
    @Nullable
    public String getUrl(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = this.urls.get(key);
        if (str == null) {
            return null;
        }
        return replaceCommonParams(str, key);
    }

    @NotNull
    public final HashMap<String, String> getUrls() {
        return this.urls;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasWebUrl
    public boolean gotoLevelPage(@NotNull Context context, @Nullable Function1<? super String, String> block) {
        boolean z16;
        String invoke;
        Intrinsics.checkNotNullParameter(context, "context");
        String stringDataSet = com.tencent.mobileqq.vas.ar.INSTANCE.a("kenaiyu", "2024-05-10", "vas_level_icon_click_tab").getStringDataSet("url", "");
        if (QLog.isColorLevel()) {
            QLog.i("IVasWebUrl", 1, "gotoLevelPage tab url=" + stringDataSet);
        }
        if (stringDataSet != null && stringDataSet.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || Intrinsics.areEqual(stringDataSet, "none")) {
            return false;
        }
        IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
        if (block != null && (invoke = block.invoke(stringDataSet)) != null) {
            stringDataSet = invoke;
        }
        iVasHybridRoute.openSchema(context, stringDataSet);
        return true;
    }
}
