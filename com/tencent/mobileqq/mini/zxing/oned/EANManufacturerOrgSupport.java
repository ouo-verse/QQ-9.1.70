package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.luggage.wxa.gf.b0;
import com.tencent.luggage.wxa.gf.i0;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.luggage.wxa.ig.s;
import com.tencent.luggage.wxa.ih.e;
import com.tencent.luggage.wxa.j2.c;
import com.tencent.luggage.wxa.q2.d;
import com.tencent.luggage.wxa.uf.m;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.luggage.wxa.xd.w0;
import com.tencent.luggage.wxa.yf.o;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.tlv_type.tlv_t183;

/* compiled from: P */
/* loaded from: classes33.dex */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, 379}, "FR");
            add(new int[]{LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT}, "BG");
            add(new int[]{383}, "SI");
            add(new int[]{385}, "HR");
            add(new int[]{tlv_t183.CMD_183}, "BA");
            add(new int[]{400, 440}, "DE");
            add(new int[]{450, 459}, "JP");
            add(new int[]{LocaleManager.MOBILE_COUNTRY_CODE_CN_INT, e.CTRL_INDEX}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{474}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{c.CTRL_INDEX}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG}, "LK");
            add(new int[]{480}, "PH");
            add(new int[]{481}, "BY");
            add(new int[]{482}, "UA");
            add(new int[]{484}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{487}, "KZ");
            add(new int[]{489}, "HK");
            add(new int[]{P2VGlobalConfig.WATER_MARKER_WIDTH, s.CTRL_INDEX}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST}, "GR");
            add(new int[]{528}, "LB");
            add(new int[]{529}, "CY");
            add(new int[]{TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED}, "MK");
            add(new int[]{535}, "MT");
            add(new int[]{TVKQQLiveAssetPlayerMsg.PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE}, "IE");
            add(new int[]{540, 549}, "BE/LU");
            add(new int[]{PlayerResources.ViewId.GET_MORE_TOGGLE_AREA}, "PT");
            add(new int[]{PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON}, "IS");
            add(new int[]{PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 579}, "DK");
            add(new int[]{c0.CTRL_INDEX}, "PL");
            add(new int[]{594}, "RO");
            add(new int[]{599}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{608}, "BH");
            add(new int[]{609}, "MU");
            add(new int[]{611}, "MA");
            add(new int[]{613}, "DZ");
            add(new int[]{616}, "KE");
            add(new int[]{618}, "CI");
            add(new int[]{619}, "TN");
            add(new int[]{621}, "SY");
            add(new int[]{622}, "EG");
            add(new int[]{624}, "LY");
            add(new int[]{625}, "JO");
            add(new int[]{626}, "IR");
            add(new int[]{627}, "KW");
            add(new int[]{628}, "SA");
            add(new int[]{629}, "AE");
            add(new int[]{640, 649}, "FI");
            add(new int[]{690, 695}, LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
            add(new int[]{700, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES}, "NO");
            add(new int[]{729}, "IL");
            add(new int[]{TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH, 739}, "SE");
            add(new int[]{740}, "GT");
            add(new int[]{741}, "SV");
            add(new int[]{ExpMgrListProcessor.CONFIG_ID}, "HN");
            add(new int[]{743}, "NI");
            add(new int[]{744}, "CR");
            add(new int[]{745}, "PA");
            add(new int[]{746}, "DO");
            add(new int[]{750}, "MX");
            add(new int[]{754, w0.CTRL_INDEX}, "CA");
            add(new int[]{759}, "VE");
            add(new int[]{760, 769}, "CH");
            add(new int[]{MiniReportManager.EventId.SDK_EMBEDDED_VIDEO}, "CO");
            add(new int[]{773}, "UY");
            add(new int[]{775}, "PE");
            add(new int[]{com.tencent.luggage.wxa.he.e.CTRL_INDEX}, "BO");
            add(new int[]{com.tencent.luggage.wxa.gg.e.CTRL_INDEX}, "AR");
            add(new int[]{MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{com.tencent.luggage.wxa.gf.e.CTRL_INDEX}, "PE");
            add(new int[]{b0.CTRL_INDEX}, KeyPropertiesCompact.KEY_ALGORITHM_EC);
            add(new int[]{m.CTRL_INDEX, com.tencent.luggage.wxa.uf.c.CTRL_INDEX}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{850}, "CU");
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{i0.CTRL_INDEX}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{d.CTRL_INDEX}, "KP");
            add(new int[]{868, 869}, "TR");
            add(new int[]{870, 879}, "NL");
            add(new int[]{x.CTRL_INDEX}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{888}, "SG");
            add(new int[]{y.CTRL_INDEX}, "IN");
            add(new int[]{com.tencent.luggage.wxa.gf.m.CTRL_INDEX}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{899}, "ID");
            add(new int[]{900, 919}, "AT");
            add(new int[]{930, 939}, "AU");
            add(new int[]{940, 949}, "AZ");
            add(new int[]{o.CTRL_INDEX}, "MY");
            add(new int[]{958}, "MO");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lookupCountryIdentifier(String str) {
        int[] iArr;
        int i3;
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i16 = 0; i16 < size && parseInt >= (i3 = (iArr = this.ranges.get(i16))[0]); i16++) {
            if (iArr.length != 1) {
                i3 = iArr[1];
            }
            if (parseInt <= i3) {
                return this.countryIdentifiers.get(i16);
            }
        }
        return null;
    }
}
