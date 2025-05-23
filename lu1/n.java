package lu1;

import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lu1.e;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Llu1/n;", "Llu1/e;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class n implements e {
    @Override // lu1.e
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return e.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // lu1.e
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        boolean z16 = true;
        if (msgElement == null || msgElement.faceElement == null) {
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            if (arrayList == null) {
                return null;
            }
            if (com.tencent.guild.aio.util.ex.e.e(arrayList) && ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).isSupportLottie(com.tencent.guild.aio.util.ex.e.b(arrayList))) {
                msgElement = arrayList.get(0);
            } else {
                msgElement = null;
                z16 = false;
            }
        }
        if (z16) {
            return new g().a(app, msgRecord, msgElement);
        }
        MessageRecord d16 = q.d(-1000);
        MessageForText messageForText = d16 instanceof MessageForText ? (MessageForText) d16 : null;
        if (messageForText == null) {
            return null;
        }
        return messageForText;
    }
}
