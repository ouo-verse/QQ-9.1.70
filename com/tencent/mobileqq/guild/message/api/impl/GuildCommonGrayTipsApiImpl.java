package com.tencent.mobileqq.guild.message.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.guild.data.GuildCommonGrayTipsParseParams;
import com.tencent.mobileqq.guild.message.api.IGuildCommonGrayTipsApi;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.guild.message.base.p;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCommonGrayTipsApiImpl implements IGuildCommonGrayTipsApi {
    private static final String ICON_TAG = "icon";
    private static final int NICK_LENGTH_LIMIT_1 = 6;
    private static final int NICK_LENGTH_LIMIT_2 = 12;
    private static final String TAG = "GuildCommonGrayTipsApiImpl";
    private static p grayTipUtilCallback;
    private final ConcurrentHashMap<Long, b> grayTipsParseResultHashMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements Comparator<GrayTipsMessageConstants$HighlightItem> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem2) {
            return grayTipsMessageConstants$HighlightItem.start - grayTipsMessageConstants$HighlightItem2.start;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f230125a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f230126b;

        /* renamed from: c, reason: collision with root package name */
        com.tencent.mobileqq.graytip.g f230127c;

        /* renamed from: d, reason: collision with root package name */
        UniteEntity f230128d;

        public b(String str, CharSequence charSequence, com.tencent.mobileqq.graytip.g gVar, UniteEntity uniteEntity) {
            this.f230125a = str;
            this.f230126b = charSequence;
            this.f230127c = gVar;
            this.f230128d = uniteEntity;
        }
    }

    static {
        try {
            ArrayList<Class<? extends p>> arrayList = vt1.a.f443342d;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Class<? extends p>> it = vt1.a.f443342d.iterator();
                while (it.hasNext()) {
                    grayTipUtilCallback = it.next().newInstance();
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[static] ", e16);
        }
    }

    private boolean checkNickNeedFrontSpace(StringBuilder sb5) {
        String sb6 = sb5.toString();
        boolean find = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~\uff01@#\uffe5\u2026\u2026&*\uff08\uff09\u2014\u2014|{}\u3010\u3011\u2018\uff1b\uff1a\u201d\u201c'\u3002\uff0c\u3001\uff1f]$").matcher(sb6).find();
        if (!TextUtils.isEmpty(sb6) && !sb6.equals("icon") && !find) {
            return true;
        }
        return false;
    }

    private boolean checkParseParams(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams) {
        if (guildCommonGrayTipsParseParams != null && !TextUtils.isEmpty(guildCommonGrayTipsParseParams.getGuildId()) && guildCommonGrayTipsParseParams.getMsgId() != null && guildCommonGrayTipsParseParams.getXmlElement() != null) {
            return true;
        }
        return false;
    }

    private void decodeImageSpan(com.tencent.mobileqq.guild.data.a aVar, SpannableStringBuilder spannableStringBuilder, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem) {
        int defaultIconSize = aVar.getDefaultIconSize();
        int iconPaddingLeft = aVar.getIconPaddingLeft();
        int iconPaddingRight = aVar.getIconPaddingRight();
        if (grayTipsMessageConstants$HighlightItem.start == 0 && !TextUtils.isEmpty(grayTipsMessageConstants$HighlightItem.icon)) {
            iconPaddingRight = aVar.getIconFirstPaddingRight();
        }
        int i3 = iconPaddingRight;
        String str = grayTipsMessageConstants$HighlightItem.icon;
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            Context a16 = aVar.a();
            spannableStringBuilder.setSpan(new wt1.a(a16, a16.getResources().getIdentifier(str, "drawable", a16.getPackageName()), defaultIconSize, iconPaddingLeft, i3), grayTipsMessageConstants$HighlightItem.start, grayTipsMessageConstants$HighlightItem.end, 33);
            return;
        }
        wt1.f fVar = new wt1.f(aVar.context, str, defaultIconSize, iconPaddingLeft, i3);
        Drawable.Callback callback = aVar.drawableCallback;
        if (callback != null) {
            fVar.c(callback);
        }
        spannableStringBuilder.setSpan(fVar, grayTipsMessageConstants$HighlightItem.start, grayTipsMessageConstants$HighlightItem.end, 33);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getDisplayName(AppRuntime appRuntime, String str, String str2, String str3, String str4, StringBuilder sb5, boolean z16) {
        String str5;
        boolean checkNickNeedFrontSpace = checkNickNeedFrontSpace(sb5);
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        boolean z17 = false;
        if (!TextUtils.isEmpty(str2) && (str2.equals(appRuntime.getCurrentAccountUin()) || str2.equals(selfTinyId))) {
            String qqStr = HardCodeUtil.qqStr(R.string.f158081on);
            if (TextUtils.equals("1", str3)) {
                qqStr = HardCodeUtil.qqStr(R.string.f158091oo);
            }
            str4 = qqStr;
            checkNickNeedFrontSpace = false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                IGuildNicknameApi iGuildNicknameApi = (IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class);
                if (TextUtils.isEmpty(str4)) {
                    str4 = "\u9891\u9053\u7528\u6237";
                }
                if (z16) {
                    str5 = iGuildNicknameApi.removeIncompleteEmoji(str4, getLimitLength(str4.length(), false));
                    if (str5.length() < str4.length()) {
                        str5 = str5 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    } else {
                        z17 = true;
                    }
                } else {
                    z17 = true;
                    str5 = str4;
                }
                try {
                    QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str5 + ", nickName: " + str4);
                    str4 = str5;
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", exception: " + e.toString());
                    str4 = str2;
                    if (checkNickNeedFrontSpace) {
                    }
                    if (z17) {
                    }
                    QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str4 + ", needFrontSpace: " + checkNickNeedFrontSpace + ", needBackSpace: " + z17 + ", content: " + sb5.toString());
                    return str4;
                }
            } catch (Exception e17) {
                e = e17;
                z17 = true;
            }
        } else {
            z17 = true;
        }
        if (checkNickNeedFrontSpace) {
            str4 = " " + str4;
        }
        if (z17) {
            str4 = str4 + " ";
        }
        QLog.d(TAG, 2, "parseUniteGrayTipsContent, getDisplayName, uin: " + str2 + ", result: " + str4 + ", needFrontSpace: " + checkNickNeedFrontSpace + ", needBackSpace: " + z17 + ", content: " + sb5.toString());
        return str4;
    }

    private int getGrayTextOtherLinesIndentation(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams) {
        int dpToPx = ViewUtils.dpToPx(37.0f);
        Bundle extraParams = guildCommonGrayTipsParseParams.getExtraParams();
        if (extraParams.containsKey("extra_key_gray_tip_other_line_indentation")) {
            return extraParams.getInt("extra_key_gray_tip_other_line_indentation");
        }
        return dpToPx;
    }

    private SpannableStringBuilder getHighlightMsgText(AppRuntime appRuntime, CharSequence charSequence, com.tencent.mobileqq.graytip.g gVar, GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams, Drawable.Callback callback) {
        if (gVar.f() == null) {
            return new SpannableStringBuilder(charSequence);
        }
        ArrayList<GrayTipsMessageConstants$HighlightItem> sortHighlightItems = sortHighlightItems(gVar);
        gVar.k(sortHighlightItems);
        p pVar = grayTipUtilCallback;
        if (pVar == null) {
            return new SpannableStringBuilder(charSequence);
        }
        SpannableStringBuilder a16 = pVar.a(charSequence.toString());
        if (a16 == null) {
            return new SpannableStringBuilder(charSequence);
        }
        com.tencent.mobileqq.guild.data.a aVar = new com.tencent.mobileqq.guild.data.a();
        aVar.app = appRuntime;
        aVar.context = appRuntime.getApplicationContext();
        aVar.drawableCallback = callback;
        updateHighLightParams(guildCommonGrayTipsParseParams, aVar);
        Iterator<GrayTipsMessageConstants$HighlightItem> it = sortHighlightItems.iterator();
        while (it.hasNext()) {
            GrayTipsMessageConstants$HighlightItem next = it.next();
            if (next != null) {
                int i3 = next.start;
                int i16 = next.end;
                Bundle bundle = new Bundle();
                bundle.putString("guild_id", guildCommonGrayTipsParseParams.getGuildId());
                bundle.putString("channelId", guildCommonGrayTipsParseParams.getChannelId());
                bundle.putString("sender_uin", guildCommonGrayTipsParseParams.getSenderId());
                if (!TextUtils.isEmpty(next.icon)) {
                    decodeImageSpan(aVar, a16, next);
                    if (next.actionType == 1) {
                        a16.setSpan(new wt1.c(aVar.app, next.textColor, aVar.context, next, bundle), i3, i16, 33);
                    }
                } else {
                    a16.setSpan(new wt1.c(aVar.app, next.textColor, aVar.context, next, bundle), i3, i16, 33);
                }
            }
        }
        a16.setSpan(new LeadingMarginSpan.Standard(0, getGrayTextOtherLinesIndentation(guildCommonGrayTipsParseParams)), 0, a16.length(), 18);
        return a16;
    }

    private int getLimitLength(int i3, boolean z16) {
        if (z16) {
            if (FontSettingManager.getFontLevel() <= 16.0f) {
                return Math.min(i3, 12);
            }
            return Math.min(i3, 6);
        }
        return Math.min(i3, 12);
    }

    @NonNull
    private static String getTextLinkColor() {
        return String.format("#%06X", Integer.valueOf(QQGuildUIUtil.h(R.color.qui_common_text_link) & 16777215));
    }

    private XmlElement getXmlElement(MsgRecord msgRecord) {
        if (msgRecord != null && msgRecord.getMsgType() == 5 && msgRecord.getElements() != null) {
            Iterator<MsgElement> it = msgRecord.getElements().iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next != null && next.getGrayTipElement() != null) {
                    return next.getGrayTipElement().getXmlElement();
                }
            }
        }
        return null;
    }

    private CharSequence parseUniteEntity(AppRuntime appRuntime, UniteEntity uniteEntity, GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams, com.tencent.mobileqq.graytip.g gVar, boolean z16) {
        com.tencent.mobileqq.graytip.g gVar2;
        Iterator<UniteEntity.Note> it;
        String str;
        com.tencent.mobileqq.graytip.g gVar3;
        HashMap<Integer, Object> hashMap;
        int length;
        com.tencent.mobileqq.graytip.g gVar4 = gVar;
        if (TextUtils.isEmpty(guildCommonGrayTipsParseParams.getGuildId())) {
            return null;
        }
        UniteEntity.Note rootNote = uniteEntity.getRootNote();
        StringBuilder sb5 = new StringBuilder();
        Iterator<UniteEntity.Note> it5 = rootNote.getSubNotes().iterator();
        while (it5.hasNext()) {
            UniteEntity.Note next = it5.next();
            int noteType = next.getNoteType();
            if (noteType != 2) {
                String str2 = "#FFFF596A";
                String str3 = "key_action_DATA";
                if (noteType != 3) {
                    String str4 = "";
                    if (noteType == 4) {
                        it = it5;
                        HashMap<Integer, Object> fields = next.getFields();
                        Set<Integer> keySet = fields.keySet();
                        int length2 = sb5.length();
                        sb5.length();
                        Bundle bundle = new Bundle();
                        Iterator<Integer> it6 = keySet.iterator();
                        boolean z17 = false;
                        String str5 = "";
                        String str6 = str5;
                        while (it6.hasNext()) {
                            Iterator<Integer> it7 = it6;
                            Integer next2 = it6.next();
                            int i3 = length2;
                            if (next2.intValue() == 6) {
                                str4 = (String) fields.get(next2);
                            } else if (next2.intValue() == 7) {
                                str6 = (String) fields.get(next2);
                            } else if (next2.intValue() == 9) {
                                str5 = (String) fields.get(next2);
                            } else if (next2.intValue() == 5) {
                                String str7 = (String) fields.get(next2);
                                if (str7.equals("2")) {
                                    bundle.putString("textColor", "#FFFF596A");
                                } else if (str7.equals("3")) {
                                    bundle.putString("textColor", getTextLinkColor());
                                }
                            } else if (next2.intValue() == 4) {
                                String str8 = (String) fields.get(next2);
                                if (!str8.startsWith("http://") && !str8.startsWith("https://")) {
                                    if (str8.startsWith("mqq") || str8.startsWith(TenpayJumpActivity.TENPAY_SCHEME)) {
                                        bundle.putInt("key_action", 3);
                                        bundle.putString("key_action_DATA", str8);
                                    }
                                } else {
                                    bundle.putInt("key_action", 1);
                                    bundle.putString("key_action_DATA", str8);
                                }
                                z17 = true;
                            }
                            length2 = i3;
                            it6 = it7;
                        }
                        int i16 = length2;
                        String displayName = getDisplayName(appRuntime, guildCommonGrayTipsParseParams.getGuildId(), str4, str5, str6, sb5, z16);
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "parseUniteGrayTipsContent name : " + displayName);
                        }
                        sb5.append(displayName);
                        int length3 = i16 + displayName.length();
                        if (z17) {
                            gVar.b(i16, length3, bundle);
                            gVar2 = gVar;
                        } else {
                            gVar2 = gVar;
                        }
                    } else if (noteType != 5) {
                        gVar2 = gVar4;
                        it = it5;
                    } else {
                        HashMap<Integer, Object> fields2 = next.getFields();
                        Set<Integer> keySet2 = fields2.keySet();
                        int length4 = sb5.length();
                        int length5 = sb5.length();
                        Bundle bundle2 = new Bundle();
                        Iterator<Integer> it8 = keySet2.iterator();
                        String str9 = "";
                        String str10 = str9;
                        while (it8.hasNext()) {
                            Iterator<UniteEntity.Note> it9 = it5;
                            Integer next3 = it8.next();
                            Iterator<Integer> it10 = it8;
                            if (next3.intValue() == 8) {
                                String str11 = (String) fields2.get(next3);
                                length = length4 + 4;
                                bundle2.putString("image_resource", str11);
                                str10 = "icon";
                            } else {
                                if (next3.intValue() == 4) {
                                    String str12 = (String) fields2.get(next3);
                                    if (!str12.startsWith("http://") && !str12.startsWith("https://")) {
                                        if (str12.startsWith("mqq") || str12.startsWith(TenpayJumpActivity.TENPAY_SCHEME)) {
                                            bundle2.putInt("key_action", 3);
                                            bundle2.putString("key_action_DATA", str12);
                                        }
                                    } else {
                                        bundle2.putInt("key_action", 1);
                                        bundle2.putString("key_action_DATA", str12);
                                    }
                                } else if (next3.intValue() == 10) {
                                    String str13 = (String) fields2.get(next3);
                                    if (TextUtils.isEmpty(str13)) {
                                        str9 = str13;
                                    } else {
                                        length = str13.length() + length4;
                                        bundle2.putString("image_alt", str13);
                                        str9 = str13;
                                    }
                                }
                                it8 = it10;
                                it5 = it9;
                            }
                            length5 = length;
                            it8 = it10;
                            it5 = it9;
                        }
                        it = it5;
                        if (TextUtils.isEmpty(str9)) {
                            sb5.append(str10);
                        } else {
                            sb5.append(str9);
                        }
                        gVar.b(length4, length5, bundle2);
                        gVar2 = gVar;
                    }
                } else {
                    it = it5;
                    com.tencent.mobileqq.graytip.g gVar5 = gVar4;
                    HashMap<Integer, Object> fields3 = next.getFields();
                    Set<Integer> keySet3 = fields3.keySet();
                    int length6 = sb5.length();
                    int length7 = sb5.length();
                    Bundle bundle3 = new Bundle();
                    Iterator<Integer> it11 = keySet3.iterator();
                    int i17 = length7;
                    while (it11.hasNext()) {
                        Iterator<Integer> it12 = it11;
                        Integer next4 = it11.next();
                        String str14 = str3;
                        if (next4.intValue() == 2) {
                            String str15 = (String) fields3.get(next4);
                            sb5.append(str15);
                            hashMap = fields3;
                            i17 = str15.length() + length6;
                        } else if (next4.intValue() == 5) {
                            String str16 = (String) fields3.get(next4);
                            if (str16.equals("2")) {
                                bundle3.putString("textColor", str2);
                            } else if (str16.equals("3")) {
                                bundle3.putString("textColor", getTextLinkColor());
                            }
                            hashMap = fields3;
                        } else {
                            if (next4.intValue() == 4) {
                                String str17 = (String) fields3.get(next4);
                                if (!str17.startsWith("http://") && !str17.startsWith("https://")) {
                                    if (str17.startsWith("mqq") || str17.startsWith(TenpayJumpActivity.TENPAY_SCHEME) || str17.startsWith(WadlProxyConsts.CHANNEL)) {
                                        bundle3.putInt("key_action", 3);
                                        str3 = str14;
                                        bundle3.putString(str3, str17);
                                    } else {
                                        str3 = str14;
                                    }
                                    str = str2;
                                } else {
                                    str3 = str14;
                                    str = str2;
                                    bundle3.putInt("key_action", 1);
                                    bundle3.putString(str3, str17);
                                }
                            } else {
                                str3 = str14;
                                str = str2;
                                if (next4.intValue() == 14) {
                                    String str18 = (String) fields3.get(next4);
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(str18);
                                    sb6.append(ContainerUtils.FIELD_DELIMITER);
                                    gVar3 = gVar;
                                    hashMap = fields3;
                                    sb6.append(gVar3.f213681d);
                                    sb6.append(ContainerUtils.FIELD_DELIMITER);
                                    sb6.append(guildCommonGrayTipsParseParams.getGuildId());
                                    bundle3.putString("key_a_action_DATA", sb6.toString());
                                    gVar5 = gVar3;
                                    str2 = str;
                                    it11 = it12;
                                    fields3 = hashMap;
                                }
                            }
                            gVar3 = gVar;
                            hashMap = fields3;
                            gVar5 = gVar3;
                            str2 = str;
                            it11 = it12;
                            fields3 = hashMap;
                        }
                        str3 = str14;
                        str = str2;
                        gVar3 = gVar;
                        gVar5 = gVar3;
                        str2 = str;
                        it11 = it12;
                        fields3 = hashMap;
                    }
                    gVar2 = gVar5;
                    gVar2.b(length6, i17, bundle3);
                }
            } else {
                gVar2 = gVar4;
                it = it5;
                HashMap<Integer, Object> fields4 = next.getFields();
                for (Integer num : fields4.keySet()) {
                    Object obj = fields4.get(num);
                    if (num.intValue() == 2) {
                        sb5.append(obj);
                    }
                }
            }
            gVar4 = gVar2;
            it5 = it;
        }
        return sb5;
    }

    private ArrayList<GrayTipsMessageConstants$HighlightItem> sortHighlightItems(com.tencent.mobileqq.graytip.g gVar) {
        ArrayList<GrayTipsMessageConstants$HighlightItem> f16 = gVar.f();
        Collections.sort(f16, new a());
        return f16;
    }

    private void updateHighLightParams(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams, com.tencent.mobileqq.guild.data.a aVar) {
        Bundle extraParams = guildCommonGrayTipsParseParams.getExtraParams();
        if (extraParams.containsKey("extra_key_gray_tip_icon_right_padding")) {
            aVar.g(extraParams.getInt("extra_key_gray_tip_icon_right_padding"));
        }
        if (extraParams.containsKey("extra_key_gray_tip_icon_size")) {
            aVar.f(extraParams.getInt("extra_key_gray_tip_icon_size"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    @Override // com.tencent.mobileqq.guild.message.api.IGuildCommonGrayTipsApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence getGuildCommonGrayTipsContent(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams, Drawable.Callback callback, boolean z16) {
        AppRuntime peekAppRuntime;
        UniteEntity uniteEntity;
        UniteEntity uniteEntity2;
        if (!checkParseParams(guildCommonGrayTipsParseParams) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return null;
        }
        b bVar = this.grayTipsParseResultHashMap.get(guildCommonGrayTipsParseParams.getMsgId());
        if (!z16) {
            if (bVar != null) {
                SpannableStringBuilder highlightMsgText = getHighlightMsgText(peekAppRuntime, bVar.f230126b, bVar.f230127c, guildCommonGrayTipsParseParams, callback);
                bVar.f230125a = highlightMsgText.toString();
                return highlightMsgText;
            }
            uniteEntity2 = ((IGuildUniteGrayTipUtilApi) QRoute.api(IGuildUniteGrayTipUtilApi.class)).parseXML(guildCommonGrayTipsParseParams.getXmlElement().getContent());
        } else if (bVar != null) {
            uniteEntity2 = bVar.f230128d;
        } else {
            uniteEntity = null;
            if (uniteEntity != null) {
                return null;
            }
            com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(guildCommonGrayTipsParseParams.getChannelId(), peekAppRuntime.getCurrentAccountUin(), "", 10014, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 655397, 0L);
            CharSequence parseUniteEntity = parseUniteEntity(peekAppRuntime, uniteEntity, guildCommonGrayTipsParseParams, gVar, z16);
            if (TextUtils.isEmpty(parseUniteEntity)) {
                return null;
            }
            SpannableStringBuilder highlightMsgText2 = getHighlightMsgText(peekAppRuntime, parseUniteEntity, gVar, guildCommonGrayTipsParseParams, callback);
            this.grayTipsParseResultHashMap.put(guildCommonGrayTipsParseParams.getMsgId(), new b(highlightMsgText2.toString(), parseUniteEntity, gVar, uniteEntity));
            return highlightMsgText2;
        }
        uniteEntity = uniteEntity2;
        if (uniteEntity != null) {
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildCommonGrayTipsApi
    public String getGuildCommonGrayTipsSummary(GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams) {
        if (!checkParseParams(guildCommonGrayTipsParseParams)) {
            return "";
        }
        b bVar = this.grayTipsParseResultHashMap.get(guildCommonGrayTipsParseParams.getMsgId());
        if (bVar != null) {
            return bVar.f230125a;
        }
        CharSequence guildCommonGrayTipsContent = getGuildCommonGrayTipsContent(guildCommonGrayTipsParseParams, null, false);
        if (guildCommonGrayTipsContent == null) {
            return "";
        }
        return guildCommonGrayTipsContent.toString();
    }
}
