package com.tencent.mobileqq.guild.api.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildSubscribeChannelGrayCreateApiImpl implements IGuildSubscribeChannelGrayCreateApi {
    private static final String TAG = "GuildSubscribeChannelGrayCreateApiImpl";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends TypeToken<LinkedList<Map<String, Integer>>> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends TypeToken<LinkedList<Map<String, Integer>>> {
        b() {
        }
    }

    private com.tencent.mobileqq.guild.config.s getGuildSubscribeChannelGrayConfig() {
        return ch.E().f216252h0;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi
    public boolean isOverAlreadyAddedThreshold(AppRuntime appRuntime) {
        if (((uh2.e) appRuntime.getRuntimeService(IGPSService.class, "")).getQQMsgListChannels().size() > getGuildSubscribeChannelGrayConfig().a()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi
    public boolean isOverGrayShowCycle(String str) {
        long d16 = getGuildSubscribeChannelGrayConfig().d() * 24 * 3600;
        long o16 = bw.o(str);
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (o16 != 0 && K0 - o16 <= d16) {
            return false;
        }
        QLog.e(TAG, 1, "guildId\uff1a" + str + ", nowTime: " + K0 + ", lastTime: " + o16);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi
    public boolean isOverOpensThreshold(String str, String str2) {
        Gson gson = new Gson();
        LinkedList linkedList = (LinkedList) gson.fromJson(bw.m(str, str2), new a().getType());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0() * 1000;
        String str3 = str + str2 + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(K0));
        if (linkedList.size() > 0 && ((Map) linkedList.getLast()).containsKey(str3)) {
            ((Map) linkedList.getLast()).put(str3, Integer.valueOf(((Integer) ((Map) linkedList.getLast()).get(str3)).intValue() + 1));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(str3, 1);
            linkedList.addLast(hashMap);
        }
        int e16 = getGuildSubscribeChannelGrayConfig().e();
        LinkedList linkedList2 = new LinkedList();
        int i3 = 0;
        for (int size = linkedList.size() - 1; size >= 0; size--) {
            Map map = (Map) linkedList.get(size);
            if (e16 > 0) {
                if (map.containsKey(str3)) {
                    linkedList2.addFirst(map);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        i3 += ((Integer) it.next()).intValue();
                    }
                }
                e16--;
                K0 -= 86400000;
                str3 = str + str2 + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(K0));
            }
        }
        bw.N0(str, str2, gson.toJson(linkedList2));
        if (i3 < getGuildSubscribeChannelGrayConfig().f()) {
            return false;
        }
        QLog.e(TAG, 1, "channelId\uff1a" + str2 + ", totalOpens: " + i3);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi
    public boolean isOverSpeakingThreshold(String str, String str2) {
        Gson gson = new Gson();
        LinkedList linkedList = (LinkedList) gson.fromJson(bw.n(str, str2), new b().getType());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0() * 1000;
        String str3 = str + str2 + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(K0));
        if (linkedList.size() > 0 && ((Map) linkedList.getLast()).containsKey(str3)) {
            ((Map) linkedList.getLast()).put(str3, Integer.valueOf(((Integer) ((Map) linkedList.getLast()).get(str3)).intValue() + 1));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(str3, 1);
            linkedList.addLast(hashMap);
        }
        int e16 = getGuildSubscribeChannelGrayConfig().e();
        LinkedList linkedList2 = new LinkedList();
        int i3 = 0;
        for (int size = linkedList.size() - 1; size >= 0; size--) {
            Map map = (Map) linkedList.get(size);
            if (e16 > 0) {
                if (map.containsKey(str3)) {
                    linkedList2.addFirst(map);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        i3 += ((Integer) it.next()).intValue();
                    }
                }
                e16--;
                K0 -= 86400000;
                str3 = str + str2 + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(K0));
            }
        }
        bw.P0(str, str2, gson.toJson(linkedList2));
        if (i3 < getGuildSubscribeChannelGrayConfig().g()) {
            return false;
        }
        QLog.e(TAG, 1, "channelId\uff1a" + str2 + ", totalSpeak: " + i3);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSubscribeChannelGrayCreateApi
    public void setChannelSubscribeGrayShowTime(String str) {
        bw.Q0(str, com.tencent.mobileqq.service.message.e.K0());
    }
}
