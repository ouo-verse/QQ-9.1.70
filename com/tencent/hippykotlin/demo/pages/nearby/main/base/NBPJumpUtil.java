package com.tencent.hippykotlin.demo.pages.nearby.main.base;

import c45.i;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.k;
import java.util.Iterator;
import java.util.List;
import k25.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.l;
import p35.n;
import v25.a;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPJumpUtil {
    public static final NBPJumpUtil INSTANCE = new NBPJumpUtil();
    public static final FastClickUtils fastClickUtils = new FastClickUtils(500);

    public static /* synthetic */ void jumpPersonaPage$default(int i3, String str, boolean z16, boolean z17, HomepageSource homepageSource, String str2, int i16) {
        NBPJumpUtil nBPJumpUtil = INSTANCE;
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        boolean z19 = z17;
        if ((i16 & 16) != 0) {
            homepageSource = HomepageSource.DEFAULT;
        }
        HomepageSource homepageSource2 = homepageSource;
        if ((i16 & 32) != 0) {
            str2 = null;
        }
        nBPJumpUtil.jumpPersonaPage(i3, str, z18, z19, homepageSource2, str2);
    }

    public static void jumpPrayCalendarPage$default() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_pray_calendar&custom_back_pressed=1&local_bundle_name=nearbypro&mid=");
        sb5.append(2);
        if (k.a(c.f117352a)) {
            str = "&modal_mode=1";
        } else {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(sb6, false, 4);
    }

    public static void jumpPraySharePage$default(d dVar, long j3) {
        KLog.INSTANCE.i("NBPJumpUtil", "jumpMoodMapSharePage: mid=2, " + dVar);
        byte[][] bArr = new byte[1];
        if (dVar == null) {
            dVar = new d(null, null, null, 0, null, null, null, 127, null);
        }
        bArr[0] = i.d(dVar);
        QQNearbyModule.Companion.getInstance().setSharePenetratePageData(bArr);
        String str = "mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_common_share&app_id=2&share_type=1&custom_back_pressed=1&timestamp=" + j3 + "&modal_mode=1&nbp_source=0";
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(str, false, 4);
    }

    public final void jumpArticleFeedDetailPage(l lVar, int i3, e eVar) {
        String str;
        byte[] encodeToByteArray;
        e eVar2 = new e();
        eVar2.v("feed_id", lVar.f418092d);
        r25.e eVar3 = lVar.f418093e;
        if (eVar3 == null || (str = Long.valueOf(eVar3.f430610d).toString()) == null) {
            str = "-1";
        }
        eVar2.v("poster_user_id", str);
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        eVar2.u("user_id", userDataManager.getUserSelfInfo().tid);
        eVar2.v("user_nickname", userDataManager.getUserSelfInfo().nickName);
        eVar2.v("user_avatar", userDataManager.getUserSelfInfo().avatarUrl);
        eVar2.t("app_id", 2);
        eVar2.v("comment_id", eVar.p("comment_id"));
        eVar2.v("comment_reply_id", eVar.p("reply_id"));
        eVar2.v("show_reply_input", eVar.q("show_reply_input", ""));
        eVar2.v("feed_image_url", eVar.p("feedImageUrl"));
        eVar2.w("has_followed", eVar.g("hasFollowed", false));
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(eVar2.toString());
        companion.setSharePenetratePageData(new byte[][]{encodeToByteArray, i.d(NearbyProUtilsKt.toStrangerFeed(lVar))});
        String str2 = "mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_article_feed_detail&custom_back_pressed=1&nbp_source=" + i3;
        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(str2, false, 6);
    }

    public final void jumpPersonaPage(int i3, String str, boolean z16, boolean z17, HomepageSource homepageSource, String str2) {
        String str3;
        if (fastClickUtils.isFastDoubleClick()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&bu_type=" + i3 + "&self=" + (z16 ? 1 : 0) + "&tinyid=" + str);
        if (i3 == 2) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("&source_id=");
            m3.append(homepageSource.nbpValue);
            sb5.append(m3.toString());
            if (z16) {
                str3 = "&page_name=nearby_new_homepage";
            } else {
                str3 = "&page_name=nearby_modal_homepage&modal_mode=1";
            }
            sb5.append(str3);
        } else {
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("&page_name=nearby_modal_homepage&modal_mode=1&source_id=");
            m16.append(homepageSource.jbValue);
            m16.append("&from_id=");
            m16.append(homepageSource.jbFromId);
            sb5.append(m16.toString());
            if (str2 != null) {
                sb5.append("&feed_id=" + str2);
            }
        }
        String sb6 = sb5.toString();
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpPersonaFeedPage schema:", sb6, KLog.INSTANCE, "NBPJumpUtil");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(sb6, z17, 4);
    }

    public final void jumpPublishPage(String str, NBPLatLng nBPLatLng, String str2) {
        KLog kLog = KLog.INSTANCE;
        kLog.i("NBPMainControlViewModel", QUISkinImage$$ExternalSyntheticOutline0.m("jumpPublishPage source:", str, " themeId:", str2));
        if (!QQNearbyModule.Companion.getInstance().hadLocationPermission()) {
            kLog.e("NBPJumpUtil", "jumpPublishPage, not loc permission");
            Utils.INSTANCE.currentBridgeModule().qToast("\u6ca1\u6709\u4f4d\u7f6e\u6743\u9650\uff0c\u8bf7\u5148\u6388\u6743", QToastMode.Warning);
            return;
        }
        e eVar = new e();
        if (nBPLatLng != null) {
            eVar.s(QCircleSchemeAttr.Polymerize.LAT, nBPLatLng.latitude);
            eVar.s("lon", nBPLatLng.longitude);
        }
        String m3 = QUISkinImage$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_publish&modal_mode=1&custom_back_pressed=1&source=", str, "&cameraPosTarget=", eVar.toString());
        if (str2 != null) {
            m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m(m3, "&theme_id=", str2);
        }
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(m3, false, 6);
    }

    public static void jumpArticleFeedDetailPage$default(String str, String str2, UserSelfBaseInfo userSelfBaseInfo, int i3, n nVar, String str3, Boolean bool, int i16) {
        byte[] encodeToByteArray;
        byte[][] bArr;
        if ((i16 & 32) != 0) {
            str3 = "";
        }
        if ((i16 & 64) != 0) {
            bool = null;
        }
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("feed_id", str2, "poster_user_id", str);
        m3.v("user_id", userSelfBaseInfo.accountId);
        m3.v("user_nickname", userSelfBaseInfo.nick);
        m3.v("user_avatar", userSelfBaseInfo.avatarUrl);
        m3.t("app_id", userSelfBaseInfo.appId);
        if (str3.length() > 0) {
            m3.v("feed_image_url", str3);
        }
        if (bool != null) {
            m3.w("has_followed", bool.booleanValue());
        }
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(m3.toString());
        if (nVar != null) {
            bArr = new byte[][]{encodeToByteArray, i.d(nVar)};
        } else {
            bArr = new byte[][]{encodeToByteArray};
        }
        QQNearbyModule.Companion.getInstance().setSharePenetratePageData(bArr);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_article_feed_detail&nbp_source=" + i3, false, 6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
    
        r4 = kotlin.text.StringsKt__StringsJVMKt.encodeToByteArray(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void jumpMoodGroupPage$default(int i3, int i16, int i17, String str, boolean z16, int i18) {
        byte[] bArr;
        if ((i18 & 8) != 0) {
            str = null;
        }
        if ((i18 & 16) != 0) {
            z16 = false;
        }
        byte[][] bArr2 = new byte[1];
        if (str == null || bArr == null) {
            bArr = new byte[0];
        }
        bArr2[0] = bArr;
        QQNearbyModule.Companion.getInstance().setSharePenetratePageData(bArr2);
        String str2 = "mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_mood_group&nbp_source=" + i3 + "&mid=" + i16 + "&auto_join=" + i17 + "&kr_turbo_display=" + i16 + "&local_bundle_name=nearbypro";
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpMoodGroupPage scheme=", str2, KLog.INSTANCE, "NBPJumpUtil");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(str2, z16, 4);
    }

    public static void jumpNickEditPage$default(int i3, String str, int i16) {
        if ((i16 & 1) != 0) {
            i3 = 2;
        }
        if ((i16 & 2) != 0) {
            str = null;
        }
        boolean z16 = (i16 & 4) != 0;
        if (str == null) {
            str = "";
        }
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_profile_name_edit&modal_mode=1&appid=", i3, "&nickname=", ((com.tencent.kuikly.core.module.d) c.f117352a.g().acquireModule("KRCodecModule")).b(str), "&commit=");
        m3.append(z16);
        String sb5 = m3.toString();
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
    }

    public static void jumpSquareFeedList$default(p pVar, l lVar, a aVar, String str, boolean z16, String str2, n25.k kVar, List list, int i3) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        List mutableListOf;
        if ((i3 & 1) != 0) {
            pVar = null;
        }
        if ((i3 & 2) != 0) {
            lVar = null;
        }
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        if ((i3 & 32) != 0) {
            str2 = "";
        }
        if ((i3 & 64) != 0) {
            kVar = null;
        }
        if ((i3 & 128) != 0) {
            list = null;
        }
        byte[][] bArr5 = new byte[4];
        if (pVar == null || (bArr = i.d(pVar)) == null) {
            bArr = new byte[0];
        }
        bArr5[0] = bArr;
        if (lVar == null || (bArr2 = i.d(lVar)) == null) {
            bArr2 = new byte[0];
        }
        bArr5[1] = bArr2;
        if (aVar == null || (bArr3 = i.d(aVar)) == null) {
            bArr3 = new byte[0];
        }
        bArr5[2] = bArr3;
        if (kVar == null || (bArr4 = i.d(kVar)) == null) {
            bArr4 = new byte[0];
        }
        bArr5[3] = bArr4;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(bArr5);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                mutableListOf.add(i.d((a) it.next()));
            }
        }
        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
        Object[] array = mutableListOf.toArray(new byte[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        companion.setSharePenetratePageData((byte[][]) array);
        String str3 = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_feed_detail&modal_mode=1&open_type=" + str + "&custom_back_pressed=1&theme_id=" + str2;
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpNewFeedDetail schema:", str3, KLog.INSTANCE, "NBPFeedMarkerViewModel");
        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.openPage$default(str3, z16, 4);
    }
}
