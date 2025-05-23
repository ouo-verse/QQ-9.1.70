package gd1;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: gd1.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C10369b {

        /* renamed from: a, reason: collision with root package name */
        public static b f401959a = new b();
    }

    private ConversationInfo a(AppInterface appInterface, ConversationInfo conversationInfo) {
        IMessageFacade iMessageFacade;
        if (appInterface == null || conversationInfo == null || (iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")) == null) {
            return null;
        }
        Message lastMessage = iMessageFacade.getLastMessage(conversationInfo.uin, conversationInfo.type);
        if (lastMessage != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList item = " + lastMessage.getBaseInfoString());
            }
            String extInfoFromExtStr = lastMessage.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO);
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                conversationInfo.extString = extInfoFromExtStr;
                conversationInfo.tinyInfo = new TinyInfo(extInfoFromExtStr, lastMessage.isSend());
            }
        } else if (!TextUtils.isEmpty(conversationInfo.extString)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList info = " + conversationInfo);
            }
            conversationInfo.tinyInfo = new TinyInfo(conversationInfo.extString);
        }
        return conversationInfo;
    }

    public static b b() {
        return C10369b.f401959a;
    }

    private boolean d(ConversationInfo conversationInfo) {
        if (TextUtils.isEmpty(conversationInfo.extString)) {
            QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "isValid() called, info is invalid!" + conversationInfo);
            return false;
        }
        TinyInfo tinyInfo = conversationInfo.tinyInfo;
        if (tinyInfo != null && !TextUtils.isEmpty(tinyInfo.fromRoleId) && !TextUtils.isEmpty(conversationInfo.tinyInfo.toRoleId)) {
            return true;
        }
        QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "isValid() called, info is invalid!" + conversationInfo);
        return false;
    }

    public List<ConversationInfo> c(AppInterface appInterface) {
        ConversationInfo a16;
        Set<ConversationInfo> conversationInfoSet = ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getConversationInfoSet();
        ArrayList arrayList = new ArrayList();
        for (ConversationInfo conversationInfo : conversationInfoSet) {
            if (conversationInfo.type == 10007 && (a16 = a(appInterface, conversationInfo)) != null && d(a16)) {
                arrayList.add(a16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList mock before = " + arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.unread.TinyConvProxy", 2, "getTinyConvInfoList size = " + arrayList.size());
        }
        return arrayList;
    }

    b() {
    }
}
