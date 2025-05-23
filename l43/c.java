package l43;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Ll43/c;", "Lcom/tencent/qqnt/msg/api/b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onRecvMsg", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements com.tencent.qqnt.msg.api.b {
    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        b.a.h(this, hVar);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] bArr) {
        b.a.g(this, bArr);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> arrayList) {
        b.a.a(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo groupGuildNotifyInfo) {
        b.a.b(this, groupGuildNotifyInfo);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        b.a.c(this, guildMsgAbFlag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int i3) {
        b.a.d(this, i3);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        for (MsgRecord msgRecord : msgList) {
            if (msgRecord.chatType == 103 && Intrinsics.areEqual(msgRecord.senderUid, "u_m9X3fOJ4pgkey0OEgpnXHQ")) {
                e.f413840a.h(msgRecord);
                return;
            }
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int i3) {
        b.a.f(this, i3);
    }
}
