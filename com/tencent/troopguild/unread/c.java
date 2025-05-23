package com.tencent.troopguild.unread;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupOptType;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/troopguild/unread/c;", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/a;", "Landroid/content/Context;", "context", "", "optType", "", "c", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/String;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/b;", "a", "<init>", "()V", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class c extends com.tencent.qqnt.chats.biz.summary.highlight.core.a {
    private final String c(Context context, Integer optType) {
        int ordinal = GuildGroupOptType.KFEEDCOMMENT.ordinal();
        if (optType != null && optType.intValue() == ordinal) {
            String string = context.getString(R.string.f2336677v);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026guild_high_light_comment)");
            return string;
        }
        int ordinal2 = GuildGroupOptType.KFEEDATME.ordinal();
        if (optType != null && optType.intValue() == ordinal2) {
            String string2 = context.getString(R.string.f2336577u);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026p_guild_high_light_at_me)");
            return string2;
        }
        int ordinal3 = GuildGroupOptType.KFEEDLIKE.ordinal();
        if (optType != null && optType.intValue() == ordinal3) {
            String string3 = context.getString(R.string.f2336777w);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026op_guild_high_light_link)");
            return string3;
        }
        return "";
    }

    @Override // com.tencent.qqnt.chats.biz.summary.highlight.core.a
    @Nullable
    public com.tencent.qqnt.chats.biz.summary.highlight.core.b a(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        Integer num;
        Object last;
        Object last2;
        UnreadCntInfo unreadCntInfo;
        Contact contact;
        UnreadCntInfo unreadCntInfo2;
        GuildGroupOptType guildGroupOptType;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        GuildContactInfo guildContactInfo = item.s().guildContactInfo;
        if (guildContactInfo != null && (unreadCntInfo2 = guildContactInfo.unreadCntInfo) != null && (guildGroupOptType = unreadCntInfo2.lastRelatedToFeedType) != null) {
            num = Integer.valueOf(guildGroupOptType.ordinal());
        } else {
            num = null;
        }
        String c16 = c(context, num);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        if (item.n() == 2) {
            GuildContactInfo guildContactInfo2 = item.s().guildContactInfo;
            boolean z16 = false;
            if (guildContactInfo2 != null && (unreadCntInfo = guildContactInfo2.unreadCntInfo) != null && (contact = unreadCntInfo.peer) != null && contact.chatType == 9) {
                z16 = true;
            }
            if (z16) {
                com.tencent.qqnt.chats.biz.summary.highlight.core.b bVar = new com.tencent.qqnt.chats.biz.summary.highlight.core.b();
                bVar.f(6);
                bVar.e(c16);
                if (item.s().listOfSpecificEventTypeInfosInMsgBox != null) {
                    Iterator<SpecificEventTypeInfoInMsgBox> it = item.s().listOfSpecificEventTypeInfosInMsgBox.iterator();
                    long j3 = -1;
                    while (it.hasNext()) {
                        SpecificEventTypeInfoInMsgBox next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next.msgInfos, "msgBox.msgInfos");
                        if (!r13.isEmpty()) {
                            ArrayList<MsgBoxNecessaryMsgInfo> arrayList = next.msgInfos;
                            Intrinsics.checkNotNullExpressionValue(arrayList, "msgBox.msgInfos");
                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                            if (((MsgBoxNecessaryMsgInfo) last).msgTime > j3) {
                                ArrayList<MsgBoxNecessaryMsgInfo> arrayList2 = next.msgInfos;
                                Intrinsics.checkNotNullExpressionValue(arrayList2, "msgBox.msgInfos");
                                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                                j3 = ((MsgBoxNecessaryMsgInfo) last2).msgTime;
                            }
                        }
                    }
                    if (item.s().guildContactInfo.unreadCntInfo.relatedToMeStringTime / 1000 >= j3) {
                        QLog.i("TroopGuildHighLightSupplier", 1, "createSummaryHighLight: chatUid: " + item.k() + ", extraInfo: " + bVar.b() + ", extraType: " + bVar.c());
                    } else {
                        QLog.i("TroopGuildHighLightSupplier", 1, "createSummaryHighLight: chatUid: " + item.k() + ", return null! latestAtTime\uff1a" + j3);
                        return null;
                    }
                } else {
                    QLog.i("TroopGuildHighLightSupplier", 1, "createSummaryHighLight: chatUid: " + item.k() + ", extraInfo: " + bVar.b() + ", extraType: " + bVar.c());
                }
                return bVar;
            }
        }
        QLog.i("TroopGuildHighLightSupplier", 1, "createSummaryHighLight: chatUid: " + item.k() + ", contact type is NOT TROOP GUILD!");
        return null;
    }
}
