package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$MessageNodeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "b", "", "contactList", "Lcom/tencent/trpcprotocol/qqstranger/relation/relation/Relation$MessageNodeInfo;", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {
    private final int b(RecentContactInfo recentContactInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        String currentUid = peekAppRuntime != null ? peekAppRuntime.getCurrentUid() : null;
        if (currentUid == null) {
            currentUid = "";
        }
        long j3 = recentContactInfo.senderUin;
        String str = recentContactInfo.senderUid;
        String str2 = str != null ? str : "";
        if (Intrinsics.areEqual(String.valueOf(j3), currentUin) || Intrinsics.areEqual(str2, currentUid)) {
            return 1;
        }
        if (j3 == 0) {
            if (str2.length() == 0) {
                return 0;
            }
        }
        return 2;
    }

    public final List<Relation$MessageNodeInfo> a(List<RecentContactInfo> contactList) {
        List take;
        int collectionSizeOrDefault;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        take = CollectionsKt___CollectionsKt.take(contactList, 50);
        List<RecentContactInfo> list = take;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (RecentContactInfo recentContactInfo : list) {
            Relation$MessageNodeInfo relation$MessageNodeInfo = new Relation$MessageNodeInfo();
            relation$MessageNodeInfo.appid.set(com.tencent.mobileqq.matchfriend.reborn.utils.c.f245468a.b(recentContactInfo.chatType));
            PBUInt64Field pBUInt64Field = relation$MessageNodeInfo.to_tinyid;
            String str = recentContactInfo.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contactInfo.peerUid");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            pBUInt64Field.set(longOrNull != null ? longOrNull.longValue() : 0L);
            relation$MessageNodeInfo.type.set(b(recentContactInfo));
            relation$MessageNodeInfo.last_send_time.set(recentContactInfo.msgTime);
            arrayList.add(relation$MessageNodeInfo);
        }
        return arrayList;
    }
}
