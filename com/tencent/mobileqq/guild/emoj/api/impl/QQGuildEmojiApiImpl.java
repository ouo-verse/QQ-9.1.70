package com.tencent.mobileqq.guild.emoj.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.emoj.f;
import com.tencent.mobileqq.guild.message.api.IGuildRecentUseEmojiHandler;
import com.tencent.mobileqq.guild.util.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import oi1.b;
import oi1.g;

/* compiled from: P */
/* loaded from: classes13.dex */
public class QQGuildEmojiApiImpl implements IQQGuildEmojiApi {
    private static final String TAG = "QQGuildEmojiApiImpl";
    private static ArrayList<Integer> FILTER_SYS_DATA = new ArrayList<>();
    private static ArrayList<Integer> FILTER_EMOJI_DATA = new ArrayList<>();

    static {
        FILTER_SYS_DATA.add(40);
        FILTER_SYS_DATA.add(19);
        FILTER_SYS_DATA.add(43);
        FILTER_SYS_DATA.add(20);
        FILTER_SYS_DATA.add(106);
        FILTER_SYS_DATA.add(24);
        FILTER_SYS_DATA.add(0);
        FILTER_SYS_DATA.add(33);
        FILTER_SYS_DATA.add(32);
        FILTER_SYS_DATA.add(13);
        FILTER_SYS_DATA.add(22);
        FILTER_SYS_DATA.add(3);
        FILTER_SYS_DATA.add(30);
        FILTER_SYS_DATA.add(83);
        FILTER_SYS_DATA.add(84);
        FILTER_SYS_DATA.add(39);
        FILTER_SYS_DATA.add(78);
        FILTER_SYS_DATA.add(48);
        FILTER_SYS_DATA.add(90);
        FILTER_SYS_DATA.add(41);
        FILTER_SYS_DATA.add(91);
        FILTER_SYS_DATA.add(164);
        FILTER_SYS_DATA.add(170);
        FILTER_SYS_DATA.add(169);
        FILTER_SYS_DATA.add(263);
        FILTER_SYS_DATA.add(283);
        FILTER_SYS_DATA.add(286);
        FILTER_SYS_DATA.add(288);
        FILTER_SYS_DATA.add(300);
        FILTER_SYS_DATA.add(301);
        FILTER_SYS_DATA.add(323);
        FILTER_SYS_DATA.add(311);
        FILTER_SYS_DATA.add(312);
        FILTER_SYS_DATA.add(317);
        FILTER_SYS_DATA.add(325);
        FILTER_SYS_DATA.add(92);
        FILTER_SYS_DATA.add(57);
        FILTER_SYS_DATA.add(179);
        FILTER_SYS_DATA.add(118);
        FILTER_SYS_DATA.add(74);
        FILTER_SYS_DATA.add(177);
        FILTER_SYS_DATA.add(109);
        FILTER_SYS_DATA.add(63);
        FILTER_SYS_DATA.add(72);
        FILTER_SYS_DATA.add(53);
        FILTER_SYS_DATA.add(153);
        FILTER_SYS_DATA.add(151);
        FILTER_SYS_DATA.add(149);
        FILTER_SYS_DATA.add(143);
        FILTER_SYS_DATA.add(185);
        FILTER_SYS_DATA.add(160);
        FILTER_SYS_DATA.add(159);
        FILTER_SYS_DATA.add(147);
        FILTER_SYS_DATA.add(155);
        FILTER_SYS_DATA.add(292);
        FILTER_SYS_DATA.add(198);
        FILTER_SYS_DATA.add(187);
        FILTER_SYS_DATA.add(209);
        FILTER_SYS_DATA.add(207);
        FILTER_SYS_DATA.add(189);
        FILTER_SYS_DATA.add(193);
        FILTER_SYS_DATA.add(197);
        FILTER_SYS_DATA.add(213);
        FILTER_SYS_DATA.add(210);
        FILTER_SYS_DATA.add(201);
        FILTER_SYS_DATA.add(188);
        FILTER_SYS_DATA.add(190);
        FILTER_SYS_DATA.add(205);
        FILTER_SYS_DATA.add(216);
        FILTER_SYS_DATA.add(195);
        FILTER_SYS_DATA.add(203);
        FILTER_SYS_DATA.add(196);
        FILTER_SYS_DATA.add(211);
        FILTER_SYS_DATA.add(202);
        FILTER_SYS_DATA.add(7);
        FILTER_SYS_DATA.add(17);
        FILTER_SYS_DATA.add(70);
        FILTER_SYS_DATA.add(141);
        FILTER_SYS_DATA.add(15);
        FILTER_SYS_DATA.add(96);
        FILTER_SYS_DATA.add(Integer.valueOf(AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE));
        FILTER_SYS_DATA.add(329);
        FILTER_EMOJI_DATA.add(10);
        FILTER_EMOJI_DATA.add(18);
        FILTER_EMOJI_DATA.add(26);
        FILTER_EMOJI_DATA.add(27);
        FILTER_EMOJI_DATA.add(31);
        FILTER_EMOJI_DATA.add(33);
        FILTER_EMOJI_DATA.add(57);
        FILTER_EMOJI_DATA.add(67);
        FILTER_EMOJI_DATA.add(80);
        FILTER_EMOJI_DATA.add(81);
        FILTER_EMOJI_DATA.add(91);
        FILTER_EMOJI_DATA.add(101);
        FILTER_EMOJI_DATA.add(106);
        FILTER_EMOJI_DATA.add(107);
        FILTER_EMOJI_DATA.add(108);
        FILTER_EMOJI_DATA.add(111);
        FILTER_EMOJI_DATA.add(121);
        FILTER_EMOJI_DATA.add(143);
        FILTER_EMOJI_DATA.add(162);
    }

    private CharSequence createMarketSmallFaceSpan(int i3) {
        a aVar = a.f359552a;
        int b16 = aVar.b(i3);
        return ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseSmallEmo(aVar.c(i3), b16, 0), 16);
    }

    private BaseQQAppInterface getAppRuntime() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            return (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public CharSequence createEmojiFaceSpan(int i3, int i16) {
        try {
            return ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).convertEmoServerIdToEmoCode(i16, i3), 16);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public CharSequence fetchEmoSpan(int i3, int i16) {
        if (i16 < 0) {
            QLog.i(TAG, 1, "fetchEmoSpan error: value invalid");
            return "";
        }
        if (i3 == 4) {
            return createMarketSmallFaceSpan(i16);
        }
        return createEmojiFaceSpan(1, i16);
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public List<b> fetchRecentEmojiData() {
        ArrayList arrayList = new ArrayList();
        for (EmotionPanelData emotionPanelData : g.e().f()) {
            if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                b bVar = new b();
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                bVar.f422703a = String.valueOf(systemAndEmojiEmoticonInfo.code);
                bVar.f422704b = systemAndEmojiEmoticonInfo.emotionType;
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public Drawable getDynamicDrawable(int i3, int i16) {
        return n.b(i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public String getEmoDsc(int i3) {
        return QQSysFaceUtil.getFaceDescription(serverToLocal(String.valueOf(i3), n.f235571a));
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public List<Integer> getFilterEmojiData() {
        return FILTER_EMOJI_DATA;
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public List<Integer> getFilterSysData() {
        return FILTER_SYS_DATA;
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public Drawable getStaticDrawable(int i3, int i16) {
        return n.d(i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public boolean isGuildEmojiReactionEnable() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public boolean isInFilterList(long j3, String str) {
        List<Integer> list;
        if (j3 == 1) {
            list = getFilterSysData();
        } else if (j3 == 2) {
            list = getFilterEmojiData();
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().toString())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public int localToServer(String str, int i3) {
        return n.f(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public void requestRecentUseEmo() {
        try {
            if (getAppRuntime() != null) {
                ((IGuildRecentUseEmojiHandler) getAppRuntime().getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRecentUseEmojiHandlerName())).reqRecentUseEmojiList();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public int serverToLocal(String str, int i3) {
        return n.g(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public void showWithAnim(com.tencent.mobileqq.guild.emoj.b bVar, int i3, f fVar) {
        com.tencent.mobileqq.guild.message.chatpie.a.C(bVar, i3, fVar);
    }

    @Override // com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi
    public void updateRecentEmojiData(int i3, int i16) {
        g.e().i(new SystemAndEmojiEmoticonInfo(7, i3, i16, "", false));
    }
}
