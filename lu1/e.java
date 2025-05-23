package lu1;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Llu1/e;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "a", "b", "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", "", "copyMRBaseFields", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class a {
        public static ChatMessage a(e eVar, AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            ChatMessage b16 = eVar.b(app, msgRecord, msgElement);
            if (b16 == null) {
                return null;
            }
            b(eVar, app, msgRecord, b16, msgElement);
            return b16;
        }

        private static void b(e eVar, AppRuntime appRuntime, MsgRecord msgRecord, MessageRecord messageRecord, MsgElement msgElement) {
            messageRecord.uniseq = msgRecord.msgId;
            messageRecord.msgUid = msgRecord.msgRandom;
            messageRecord.shmsgseq = msgRecord.msgSeq;
            messageRecord.frienduin = msgRecord.channelId;
            messageRecord.extObj = msgElement;
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecord, msgRecord.guildId);
            messageRecord.time = msgRecord.msgTime;
            messageRecord.senderuin = msgRecord.senderUid;
            messageRecord.selfuin = appRuntime.getCurrentUin();
            int i3 = msgRecord.sendType;
            if (i3 == 1) {
                messageRecord.issend = 1;
            } else if (i3 == 2) {
                messageRecord.issend = 2;
            }
            int i16 = msgRecord.sendStatus;
            if (i16 == 0) {
                messageRecord.extraflag = 32768;
            } else if (i16 != 1) {
                messageRecord.extraflag = 0;
            } else {
                messageRecord.extraflag = 32772;
            }
            messageRecord.istroop = 10014;
        }
    }

    ChatMessage a(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement);

    ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement);
}
