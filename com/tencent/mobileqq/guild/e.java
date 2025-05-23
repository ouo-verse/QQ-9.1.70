package com.tencent.mobileqq.guild;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.ChannStateItemInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u0006\u0010\r\u001a\u00020\u0006J\"\u0010\u000f\u001a\u00020\u00022\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bJ\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006Rp\u0010\u0015\u001a^\u0012\u0004\u0012\u00020\u0006\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00130\u0012j.\u0012\u0004\u0012\u00020\u0006\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0013`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014Rp\u0010\u0016\u001a^\u0012\u0004\u0012\u00020\u0006\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00130\u0012j.\u0012\u0004\u0012\u00020\u0006\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0013`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0090\u0001\u0010\u0018\u001a~\u0012\u0004\u0012\u00020\u0006\u00124\u00122\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0018\u00010\u0012j\u0018\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0018\u0001`\u00130\u0012j>\u0012\u0004\u0012\u00020\u0006\u00124\u00122\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0018\u00010\u0012j\u0018\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0018\u0001`\u0013`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/e;", "", "", "state", "", "a", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/ChannStateItemInfo;", "Lkotlin/collections/ArrayList;", "channelStateList", "channelStateReq", "b", "c", "", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "curShowStateMap", "readStateSeqMap", "", "curShowStateListMap", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f217857a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, HashMap<Long, Integer>> curShowStateMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, HashMap<Long, Long>> readStateSeqMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, HashMap<Long, List<Integer>>> curShowStateListMap = new HashMap<>();

    e() {
    }

    private final String a(int state) {
        if (state != 1) {
            if (state != 6) {
                if (state != 8 && state != 9) {
                    if (state != 17) {
                        if (state != 18) {
                            return "";
                        }
                        return "[\u6709\u4e00\u8d77\u73a9]";
                    }
                    return "[\u6709\u4e00\u8d77\u542c]";
                }
                return "[\u6709\u4e00\u8d77\u5f00\u9ed1]";
            }
            return "[\u6709\u5c4f\u5e55\u5171\u4eab]";
        }
        return "[\u4e3b\u64ad\u5f00\u64ad\u4e86]";
    }

    @NotNull
    public final String b(long guildId, long channelId, @Nullable ArrayList<ChannStateItemInfo> channelStateList, long channelStateReq) {
        Integer num;
        ArrayList arrayList;
        boolean z16;
        Long l3;
        List<Integer> arrayList2;
        int collectionSizeOrDefault;
        HashMap<Long, Integer> hashMap = curShowStateMap.get(Long.valueOf(guildId));
        int i3 = 0;
        if (hashMap == null || (num = hashMap.get(Long.valueOf(channelId))) == null) {
            num = 0;
        }
        int intValue = num.intValue();
        if (channelStateList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(channelStateList, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = channelStateList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((ChannStateItemInfo) it.next()).channelState));
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList3 = arrayList;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            HashMap<Long, Long> hashMap2 = readStateSeqMap.get(Long.valueOf(guildId));
            if (hashMap2 == null || (l3 = hashMap2.get(Long.valueOf(channelId))) == null) {
                l3 = 0L;
            }
            if (l3.longValue() == channelStateReq) {
                return "";
            }
            if (arrayList.contains(Integer.valueOf(intValue))) {
                i3 = intValue;
            }
            HashMap<Long, List<Integer>> hashMap3 = curShowStateListMap.get(Long.valueOf(guildId));
            if (hashMap3 == null || (arrayList2 = hashMap3.get(Long.valueOf(channelId))) == null) {
                arrayList2 = new ArrayList<>();
            }
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                int intValue2 = ((Number) it5.next()).intValue();
                if (!arrayList2.contains(Integer.valueOf(intValue2))) {
                    i3 = intValue2;
                    break;
                }
            }
        }
        HashMap<Long, HashMap<Long, Integer>> hashMap4 = curShowStateMap;
        if (hashMap4.get(Long.valueOf(guildId)) == null) {
            hashMap4.put(Long.valueOf(guildId), new HashMap<>());
        }
        HashMap<Long, Integer> hashMap5 = hashMap4.get(Long.valueOf(guildId));
        if (hashMap5 != null) {
            hashMap5.put(Long.valueOf(channelId), Integer.valueOf(i3));
        }
        HashMap<Long, HashMap<Long, List<Integer>>> hashMap6 = curShowStateListMap;
        if (hashMap6.get(Long.valueOf(guildId)) == null) {
            hashMap6.put(Long.valueOf(guildId), new HashMap<>());
        }
        HashMap<Long, List<Integer>> hashMap7 = hashMap6.get(Long.valueOf(guildId));
        if (hashMap7 != null) {
            hashMap7.put(Long.valueOf(channelId), arrayList);
        }
        return a(i3);
    }

    public final int c(@Nullable ArrayList<ChannStateItemInfo> channelStateList) {
        boolean z16;
        int i3 = 0;
        if (channelStateList != null && !channelStateList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 0;
        }
        Iterator<ChannStateItemInfo> it = channelStateList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            ChannStateItemInfo next = it.next();
            long j16 = next.updateTs;
            if (j3 < j16) {
                i3 = next.channelState;
                j3 = j16;
            }
        }
        return i3;
    }

    public final void d(long guildId, long channelId, long channelStateReq) {
        QLog.i("GuildChannelStateDataHub", 1, "[setChannelHighlightInfoRead] guildId:" + guildId + ", channelId:" + channelId + ", channelStateReq:" + channelStateReq);
        HashMap<Long, Integer> hashMap = curShowStateMap.get(Long.valueOf(guildId));
        if (hashMap != null) {
            hashMap.put(Long.valueOf(channelId), 0);
        }
        HashMap<Long, HashMap<Long, Long>> hashMap2 = readStateSeqMap;
        if (hashMap2.get(Long.valueOf(guildId)) == null) {
            hashMap2.put(Long.valueOf(guildId), new HashMap<>());
        }
        HashMap<Long, Long> hashMap3 = hashMap2.get(Long.valueOf(guildId));
        if (hashMap3 != null) {
            hashMap3.put(Long.valueOf(channelId), Long.valueOf(channelStateReq));
        }
    }
}
