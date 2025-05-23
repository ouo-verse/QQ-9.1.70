package com.tencent.mobileqq.guildhelper;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.f;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.itemdata.h;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.i;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guildhelper/c;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "b", "c", "Landroid/content/Context;", "context", "a", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "update", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c extends g {
    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        boolean z16;
        item.v().k("");
        item.v().j(null);
        if (item.s().guildContactInfo != null) {
            String str = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                g.e v3 = item.v();
                String str2 = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
                Intrinsics.checkNotNullExpressionValue(str2, "item.originData.guildCon\u2026CntInfo.relatedToMeString");
                v3.k(str2);
                item.v().j(Integer.valueOf(context.getResources().getColor(R.color.qui_common_feedback_error)));
            }
        }
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        if (h.a(item)) {
            item.v().n(4);
        }
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        String selfTid = "";
        try {
            selfTid = ((IGPSService) params.a().getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        } catch (Exception e16) {
            QLog.i("GuildHelperSummaryConvertProcessor", 1, "buildSummary getSelfTid exception: " + e16.getMessage());
        }
        f fVar = f.f217908a;
        RecentContactInfo s16 = item.s();
        Intrinsics.checkNotNullExpressionValue(selfTid, "selfTid");
        QQText qQText = new QQText(fVar.a(s16, selfTid).getMsgContent(), 7, 15);
        g.e v3 = item.v();
        g.c cVar = new g.c(0L, null, 3, null);
        cVar.e(qQText);
        v3.i(cVar);
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull com.tencent.qqnt.chats.data.converter.f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof i;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        b(item, params);
        c(item, params);
        a(item, params.b());
    }
}
