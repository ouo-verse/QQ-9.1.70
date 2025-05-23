package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.module.QQSearchModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.ITabPager;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.GuildItemInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchGuildJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.g;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchUtilKt {
    public static long lastClickTime;

    /* JADX WARN: Removed duplicated region for block: B:124:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0313 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void allInOneJump(QSearchJump qSearchJump, b bVar, String str, String str2, long j3, Map<String, String> map) {
        boolean isBlank;
        boolean isBlank2;
        String str3;
        String str4;
        ArrayList arrayList;
        String str5;
        long parseLong;
        Map mutableMapOf;
        String str6;
        g pageData;
        e n3;
        boolean isBlank3;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("allInOneJump:    moreJumpInfo == null:");
        m3.append(qSearchJump == null);
        m3.append("       moreJumpInfo.type:");
        m3.append(qSearchJump != null ? Integer.valueOf(qSearchJump.type) : null);
        m3.append("  tabMask:");
        m3.append(j3);
        m3.append("  extensionMap:");
        m3.append(map);
        kLog.e("QSearchUtil", m3.toString());
        if (qSearchJump == null) {
            return;
        }
        String str12 = "1020";
        long j16 = 0;
        String str13 = "";
        switch (qSearchJump.type) {
            case 0:
            case 12:
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default(qSearchJump.jumpLink, false, 6);
                return;
            case 1:
                ITabPager iTabPager = bVar instanceof ITabPager ? (ITabPager) bVar : null;
                if (iTabPager != null) {
                    iTabPager.jumpToTab(qSearchJump.tabMask);
                    return;
                }
                return;
            case 2:
                boolean z16 = true;
                String str14 = map != null ? map.get("guild_sub_source") : null;
                if (str14 != null && str14.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    str14 = "qq_network_search_post";
                }
                String str15 = str14;
                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                QSearchGuildJump qSearchGuildJump = qSearchJump.guildJump;
                BridgeModule.openGuildChannel$default(currentBridgeModule, qSearchGuildJump != null ? qSearchGuildJump.guildId : 0L, (qSearchGuildJump == null || (str3 = qSearchGuildJump.joinGuildSig) == null) ? "" : str3, str, qSearchGuildJump != null ? qSearchGuildJump.joinStatus : 0, str2, str15, null, TroopInfo.PAY_PRIVILEGE_ALL);
                return;
            case 3:
                BridgeModule currentBridgeModule2 = Utils.INSTANCE.currentBridgeModule();
                String str16 = qSearchJump.jumpLink;
                currentBridgeModule2.getClass();
                e eVar = new e();
                eVar.v("url", str16);
                currentBridgeModule2.callNativeMethod("openGuildArticlePage", eVar, null);
                return;
            case 4:
                BridgeModule currentBridgeModule3 = Utils.INSTANCE.currentBridgeModule();
                String str17 = qSearchJump.jumpLink;
                int i3 = BridgeModule.$r8$clinit;
                currentBridgeModule3.getClass();
                e eVar2 = new e();
                eVar2.v("feed", str17);
                eVar2.v("sourceId", "1009");
                currentBridgeModule3.callNativeMethod("joinDaZi", eVar2, null);
                return;
            case 5:
                Utils.INSTANCE.currentBridgeModule().callNativeMethod("addFriendWithParams", QSearchReport.INSTANCE.packContactParams(map, bVar, true, j3, str), null);
                return;
            case 6:
                Utils.INSTANCE.currentBridgeModule().callNativeMethod("openProfileCard", QSearchReport.INSTANCE.packContactParams(map, bVar, false, j3, str), null);
                return;
            case 7:
                if (bVar == null || (pageData = bVar.getPageData()) == null || (n3 = pageData.n()) == null || (str4 = n3.p("page_name")) == null) {
                    str4 = "";
                }
                try {
                    arrayList = new ArrayList();
                    if (map != null && (str6 = map.get("feedPbTokens")) != null) {
                        com.tencent.kuikly.core.nvi.serialization.json.b bVar2 = new com.tencent.kuikly.core.nvi.serialization.json.b(str6);
                        int c16 = bVar2.c();
                        for (int i16 = 0; i16 < c16; i16++) {
                            e l3 = bVar2.l(i16);
                            String p16 = l3 != null ? l3.p("feedPb") : null;
                            if (p16 != null) {
                                if (p16.length() > 0) {
                                    arrayList.add(p16);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                    arrayList = new ArrayList();
                }
                if (map != null) {
                    try {
                        str5 = map.get("playPosition");
                    } catch (Exception unused2) {
                    }
                    if (str5 != null) {
                        parseLong = Long.parseLong(str5);
                        if (map != null) {
                            try {
                                String str18 = map.get("tab_mask");
                                if (str18 != null) {
                                    j16 = Long.parseLong(str18);
                                }
                            } catch (Exception unused3) {
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return;
                        }
                        BridgeModule currentBridgeModule4 = Utils.INSTANCE.currentBridgeModule();
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("tab_mask", Long.valueOf(j16)));
                        currentBridgeModule4.openQQCirLayerPage(arrayList, parseLong, "", str4, mutableMapOf);
                        return;
                    }
                }
                parseLong = 0;
                if (map != null) {
                }
                if (!arrayList.isEmpty()) {
                }
                break;
            case 8:
                String str19 = map != null ? map.get("feedPb") : null;
                AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("openPersonalDetailPage:    feedPbTokens==null:"), str19 == null, kLog, "QSearchUtil");
                if (str19 != null) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(str19);
                    if (!(!isBlank3) || bVar == null) {
                        return;
                    }
                    if (bVar.getPageData().getIsAndroid()) {
                        QQSearchModule qqSearchModule = Utils.INSTANCE.qqSearchModule();
                        qqSearchModule.getClass();
                        e eVar3 = new e();
                        eVar3.v("feedPbToken", str19);
                        Unit unit = Unit.INSTANCE;
                        qqSearchModule.callNativeMethod("qCircleOpenPersonalDetailPage", eVar3, null);
                        return;
                    }
                    Utils.INSTANCE.currentBridgeModule().qCircleOpenPersonalDetailPage(str19);
                    return;
                }
                return;
            case 9:
                try {
                    e eVar4 = new e(qSearchJump.extension);
                    String q16 = eVar4.q("tag_name", "");
                    String q17 = eVar4.q("tag_id", "");
                    kLog.i("QSearchUtil", "openQFSHotTagPage:  extension:" + qSearchJump.extension + "  hotTagName:" + q16 + "    hotTagId:" + q17);
                    isBlank = StringsKt__StringsJVMKt.isBlank(q16);
                    if (!isBlank) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(q17);
                        if (!isBlank2) {
                            QQSearchModule qqSearchModule2 = Utils.INSTANCE.qqSearchModule();
                            qqSearchModule2.getClass();
                            e eVar5 = new e();
                            eVar5.v("hotTagName", q16);
                            eVar5.v("hotTagId", q17);
                            qqSearchModule2.callNativeMethod("openHotTagPage", eVar5, null);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    KLog.INSTANCE.i("QSearchUtil", "openQFSHotTagPage:    exception:" + e16);
                    return;
                }
            case 10:
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("joinGroup:    extension:");
                m16.append(qSearchJump.extension);
                kLog.i("QSearchUtil", m16.toString());
                try {
                    e eVar6 = new e(qSearchJump.extension);
                    String p17 = eVar6.p("group_name");
                    boolean z17 = eVar6.j("exact_search") == 1;
                    String p18 = eVar6.p("join_group_auth");
                    final String p19 = eVar6.p("group_code");
                    if (map != null && (str7 = map.get("subSourceId")) != null) {
                        str12 = str7;
                    }
                    Utils.INSTANCE.currentBridgeModule().joinTroopV2(p19, p17, z17, p18, str12, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt$joinGroup$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num) {
                            int intValue = num.intValue();
                            String str20 = p19;
                            c.f117352a.k(BridgeManager.f117344a.u()).setMemoryCache(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("QSearchTroopStatus_", str20), Integer.valueOf(intValue));
                            k notifyModule = Utils.INSTANCE.notifyModule("");
                            e m17 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("troop_uin", str20, "status", intValue);
                            Unit unit2 = Unit.INSTANCE;
                            k.d(notifyModule, "update_troop_join_status", m17, false, 4, null);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                } catch (Exception e17) {
                    KLog.INSTANCE.i("QSearchUtil", "joinGroup:    exception:" + e17);
                    return;
                }
            case 11:
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("openGroupDetailPage:    extension:");
                m17.append(qSearchJump.extension);
                m17.append("    extensionMap:");
                m17.append(map);
                kLog.i("QSearchUtil", m17.toString());
                try {
                    e eVar7 = new e(qSearchJump.extension);
                    String p26 = eVar7.p("group_name");
                    boolean z18 = eVar7.j("exact_search") == 1;
                    String p27 = eVar7.p("join_group_auth");
                    String p28 = eVar7.p("group_code");
                    if (map != null && (str10 = map.get("open_group_detail_transInfo")) != null) {
                        str13 = str10;
                    }
                    e eVar8 = new e(str13);
                    eVar8.v("group_name", p26);
                    String p29 = eVar8.p("search_query_text");
                    if (map != null && (str9 = map.get("subSourceId")) != null) {
                        str8 = str9;
                        Utils.INSTANCE.currentBridgeModule().openTroopPageV2(p28, p26, z18, p27, eVar8.toString(), p29, str8);
                        return;
                    }
                    str8 = "1020";
                    Utils.INSTANCE.currentBridgeModule().openTroopPageV2(p28, p26, z18, p27, eVar8.toString(), p29, str8);
                    return;
                } catch (Exception e18) {
                    KLog.INSTANCE.i("QSearchUtil", "openGroupDetailPage:    exception:" + e18);
                    return;
                }
            case 13:
                QSearchGuildJump qSearchGuildJump2 = qSearchJump.guildJump;
                if (qSearchGuildJump2 != null) {
                    if (map != null && (str11 = map.get("subSource")) != null) {
                        str13 = str11;
                    }
                    final String valueOf = String.valueOf(qSearchGuildJump2.guildId);
                    e m18 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("guildId", valueOf);
                    m18.v("joinGuildSig", qSearchGuildJump2.joinGuildSig);
                    m18.v("mainSource", "search");
                    m18.v("subSource", str13);
                    Utils.INSTANCE.currentBridgeModule().callNativeMethod("joinGuildChannel", m18, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt$joinGuild$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar9) {
                            e eVar10 = eVar9;
                            int j17 = eVar10 != null ? eVar10.j("code") : -1;
                            if (j17 == 0) {
                                k notifyModule = Utils.INSTANCE.notifyModule("");
                                e eVar11 = new e();
                                eVar11.v("guildId", valueOf);
                                eVar11.t("status", 1);
                                Unit unit2 = Unit.INSTANCE;
                                k.d(notifyModule, "update_guild_join_status", eVar11, false, 4, null);
                            } else {
                                NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("joinGuildChannel failed, code=", j17, KLog.INSTANCE, "QSearchUtil");
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static final void fastLog(String str, boolean z16) {
        if (c.f117352a.k(BridgeManager.f117344a.u()).getPageData().getIsAndroid()) {
            Utils.INSTANCE.logToNative(str);
        } else {
            if (z16) {
                return;
            }
            Utils.INSTANCE.logToNative(str);
        }
    }

    public static final long getTimeStamp() {
        return Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
    }

    public static final void openGuildSubChannel(SearchGuildBaseItemModel searchGuildBaseItemModel, String str) {
        e eVar = new e();
        GuildItemInfo guildItemInfo = searchGuildBaseItemModel.originData;
        eVar.v("guildId", String.valueOf(guildItemInfo != null ? guildItemInfo.guildId : 0L));
        GuildItemInfo guildItemInfo2 = searchGuildBaseItemModel.originData;
        eVar.v("channelId", String.valueOf(guildItemInfo2 != null ? guildItemInfo2.channelId : 0L));
        GuildItemInfo guildItemInfo3 = searchGuildBaseItemModel.originData;
        eVar.u("guildOwnerUin", guildItemInfo3 != null ? guildItemInfo3.guildOwner : 0L);
        GuildItemInfo guildItemInfo4 = searchGuildBaseItemModel.originData;
        eVar.u("roomId", guildItemInfo4 != null ? guildItemInfo4.roomId : 0L);
        eVar.t("type", searchGuildBaseItemModel.getType());
        eVar.v("channelName", searchGuildBaseItemModel.getChannelName());
        eVar.v("subChannelName", searchGuildBaseItemModel.getSubChannelName());
        eVar.v("traceId", str);
        eVar.v("mainSource", "search");
        eVar.v("subSource", "qq_network_search_sub_channel");
        Utils.INSTANCE.currentBridgeModule().callNativeMethod("openGuildSubChannelPage", eVar, null);
    }

    public static /* synthetic */ void allInOneJump$default(QSearchJump qSearchJump, b bVar, long j3, int i3) {
        String str = (i3 & 4) != 0 ? "" : null;
        String str2 = (i3 & 8) != 0 ? "" : null;
        if ((i3 & 16) != 0) {
            j3 = 0;
        }
        allInOneJump(qSearchJump, bVar, str, str2, j3, null);
    }

    public static final String formatBigNum(int i3) {
        int indexOf$default;
        if (i3 < 10000) {
            return String.valueOf(i3);
        }
        if (i3 < 1000000) {
            String valueOf = String.valueOf(i3 / 10000.0f);
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) valueOf, '.', 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                valueOf = StringsKt___StringsKt.take(valueOf, indexOf$default + 1 + 1);
            }
            return valueOf + 'w';
        }
        if (i3 < 100000000) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3 / 10000);
            sb5.append('w');
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(i3 / 100000000);
        sb6.append('\u4ebf');
        return sb6.toString();
    }
}
