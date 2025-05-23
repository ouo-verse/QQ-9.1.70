package lu1;

import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lu1.e;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Llu1/l;", "Llu1/e;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l implements e {
    @Override // lu1.e
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return e.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // lu1.e
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MessageRecord d16 = q.d(-2000);
        MessageForPic messageForPic = d16 instanceof MessageForPic ? (MessageForPic) d16 : null;
        if (messageForPic == null) {
            return null;
        }
        if (msgElement == null && (msgElement = k.f415564a.e(msgRecord)) == null) {
            return null;
        }
        PicElement picElement = msgElement.picElement;
        messageForPic.subTypeId = msgElement.elementId;
        messageForPic.uuid = picElement.fileName;
        messageForPic.path = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(msgElement);
        messageForPic.size = picElement.fileSize;
        messageForPic.width = picElement.picWidth;
        messageForPic.height = picElement.picHeight;
        messageForPic.md5 = picElement.md5HexStr;
        Integer num = picElement.picType;
        Intrinsics.checkNotNullExpressionValue(num, "picElement.picType");
        messageForPic.imageType = num.intValue();
        try {
            String str = picElement.fileUuid;
            Intrinsics.checkNotNullExpressionValue(str, "picElement.fileUuid");
            messageForPic.groupFileID = Long.parseLong(str);
        } catch (Exception unused) {
            QLog.e("PicMsgRecordConverter", 1, "createMessageRecord: convert fileUUid failed: " + picElement.fileUuid);
        }
        messageForPic.type = 1;
        return messageForPic;
    }
}
