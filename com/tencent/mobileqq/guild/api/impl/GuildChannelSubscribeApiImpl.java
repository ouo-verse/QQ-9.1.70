package com.tencent.mobileqq.guild.api.impl;

import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.guild.api.IGuildChannelSubscribeApi;
import com.tencent.mobileqq.guild.setting.subscribe.recommend.GuildSubscribeSuccessDialogFragment;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.IconType;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildChannelSubscribeApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildChannelSubscribeApi;", "Lcom/tencent/mobileqq/guild/config/s;", "getGuildSubscribeChannelConfig", "", "hasShowInCycle", "", "setUinSubscribeShowTime", "", "guildId", "channelId", "", "getChannelOpenTimesInCycle", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "showSubscribeSuccessFeedBackDialog", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelSubscribeApiImpl implements IGuildChannelSubscribeApi {

    @NotNull
    public static final String TAG = "GuildChannelSubscribeApiImpl";

    @NotNull
    private static final ArrayList<IconType> rightPriorityIcons;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/api/impl/GuildChannelSubscribeApiImpl$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/LinkedList;", "", "", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends TypeToken<LinkedList<Map<String, ? extends Integer>>> {
        b() {
        }
    }

    static {
        ArrayList<IconType> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(IconType.THREE_LINES_SETTING, IconType.THREE_LINES_SETTING_RED_DOT, IconType.THREE_DOTS_SETTING);
        rightPriorityIcons = arrayListOf;
    }

    private final com.tencent.mobileqq.guild.config.s getGuildSubscribeChannelConfig() {
        com.tencent.mobileqq.guild.config.s sVar = ch.E().f216252h0;
        Intrinsics.checkNotNullExpressionValue(sVar, "getConfig().mGuildSubscribeChannelGrayConfig");
        return sVar;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelSubscribeApi
    public int getChannelOpenTimesInCycle(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Gson gson = new Gson();
        LinkedList linkedList = (LinkedList) gson.fromJson(bw.m(guildId, channelId), new b().getType());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = guildId + channelId + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(currentTimeMillis));
        if (linkedList.size() > 0 && ((Map) linkedList.getLast()).containsKey(str)) {
            Object last = linkedList.getLast();
            Intrinsics.checkNotNullExpressionValue(last, "mOpensRecordList.last");
            Object obj = ((Map) linkedList.getLast()).get(str);
            Intrinsics.checkNotNull(obj);
            ((Map) last).put(str, Integer.valueOf(((Number) obj).intValue() + 1));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(str, 1);
            linkedList.addLast(hashMap);
        }
        int c16 = getGuildSubscribeChannelConfig().c();
        LinkedList linkedList2 = new LinkedList();
        int size = linkedList.size() - 1;
        int i3 = 0;
        if (size >= 0) {
            while (true) {
                int i16 = size - 1;
                Object obj2 = linkedList.get(size);
                Intrinsics.checkNotNullExpressionValue(obj2, "mOpensRecordList[i]");
                Map map = (Map) obj2;
                while (true) {
                    if (c16 <= 0) {
                        break;
                    }
                    if (map.containsKey(str)) {
                        linkedList2.addFirst(map);
                        Iterator it = map.values().iterator();
                        while (it.hasNext()) {
                            i3 += ((Number) it.next()).intValue();
                        }
                    } else {
                        c16--;
                        currentTimeMillis -= 86400000;
                        str = guildId + channelId + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(currentTimeMillis));
                    }
                }
                if (i16 < 0) {
                    break;
                }
                size = i16;
            }
        }
        String strSetJson = gson.toJson(linkedList2);
        Intrinsics.checkNotNullExpressionValue(strSetJson, "strSetJson");
        bw.N0(guildId, channelId, strSetJson);
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelSubscribeApi
    public boolean hasShowInCycle() {
        long b16 = getGuildSubscribeChannelConfig().b() * 24 * 3600 * 1000;
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        long p16 = bw.p(g16);
        long currentTimeMillis = System.currentTimeMillis();
        if (p16 != 0 && currentTimeMillis - p16 <= b16) {
            return true;
        }
        QLog.d(TAG, 1, "hasShowInCycle | false | uin\uff1a" + g16 + ", nowTime: " + currentTimeMillis + ", lastTime: " + p16);
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelSubscribeApi
    public void setUinSubscribeShowTime() {
        long currentTimeMillis = System.currentTimeMillis();
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        QLog.d(TAG, 1, "setUinSubscribeShowTime | uin= " + g16 + ", nowTime = " + currentTimeMillis);
        bw.T0(g16, currentTimeMillis);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelSubscribeApi
    public void showSubscribeSuccessFeedBackDialog(@NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        GuildSubscribeSuccessDialogFragment.Oh(fragmentManager);
    }
}
