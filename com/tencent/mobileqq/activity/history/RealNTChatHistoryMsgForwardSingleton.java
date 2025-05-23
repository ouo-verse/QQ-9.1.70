package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgForwardNtUtil;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001e\u0010\u0017\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR2\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0007j\b\u0012\u0004\u0012\u00020\u0013`\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001aR\u0018\u0010,\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001aR>\u0010.\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0-0\u0007j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0-`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001c\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/activity/history/RealNTChatHistoryMsgForwardSingleton;", "Lcom/tencent/mobileqq/activity/history/api/INTChatHistoryMsgForwardApi;", "Landroid/content/Intent;", "data", "", "parseAndHandleForwardData", "doForward", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lkotlin/collections/ArrayList;", "dstContacts", "msgForward", "exitForward", "doChatHistoryMsgForward", "Landroid/content/Context;", "context", "intent", "previewForwardMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "params", "setData", "", "TAG", "Ljava/lang/String;", "chatHistoryMsgRecords", "Ljava/util/ArrayList;", "getChatHistoryMsgRecords", "()Ljava/util/ArrayList;", "setChatHistoryMsgRecords", "(Ljava/util/ArrayList;)V", "forwardParams", "Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "getForwardParams", "()Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "setForwardParams", "(Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;)V", "", "forwardType", "I", "chatType", "peerUid", "comment", "Lkotlin/Pair;", "contactList", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RealNTChatHistoryMsgForwardSingleton implements INTChatHistoryMsgForwardApi {
    public static final String TAG = "NTChatHistoryMsgForwardSingleton";
    private static int chatType;
    private static String comment;
    private static NTChatHistoryMsgForwardSingleton.a forwardParams;
    private static int forwardType;
    public static final RealNTChatHistoryMsgForwardSingleton INSTANCE = new RealNTChatHistoryMsgForwardSingleton();
    private static ArrayList<MsgRecord> chatHistoryMsgRecords = new ArrayList<>();
    private static String peerUid = "";
    private static ArrayList<Pair<String, Integer>> contactList = new ArrayList<>();

    RealNTChatHistoryMsgForwardSingleton() {
    }

    private final void doForward() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        ArrayList<Contact> arrayList = new ArrayList<>();
        ArrayList<Pair<String, Integer>> arrayList2 = contactList;
        ArrayList<Pair> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (!com.tencent.nt.adapter.session.c.e(((Number) ((Pair) obj).getSecond()).intValue())) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (Pair pair : arrayList3) {
            arrayList4.add(new Contact(com.tencent.nt.adapter.session.c.l(((Number) pair.getSecond()).intValue()), (String) pair.getFirst(), ""));
        }
        arrayList.addAll(arrayList4);
        ArrayList<Pair<String, Integer>> arrayList5 = contactList;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList5) {
            if (com.tencent.nt.adapter.session.c.e(((Number) ((Pair) obj2).getSecond()).intValue())) {
                arrayList6.add(obj2);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10);
        ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault2);
        Iterator it = arrayList6.iterator();
        while (it.hasNext()) {
            arrayList7.add((String) ((Pair) it.next()).getFirst());
        }
        if (arrayList7.isEmpty()) {
            msgForward(arrayList);
        }
        Iterator it5 = arrayList7.iterator();
        while (it5.hasNext()) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin((String) it5.next());
            ArrayList<Pair<String, Integer>> arrayList8 = contactList;
            ArrayList arrayList9 = new ArrayList();
            for (Object obj3 : arrayList8) {
                if (com.tencent.nt.adapter.session.c.e(((Number) ((Pair) obj3).getSecond()).intValue())) {
                    arrayList9.add(obj3);
                }
            }
            Iterator it6 = arrayList9.iterator();
            while (it6.hasNext()) {
                arrayList.add(new Contact(com.tencent.nt.adapter.session.c.l(((Number) ((Pair) it6.next()).getSecond()).intValue()), uidFromUin, ""));
            }
            INSTANCE.msgForward(arrayList);
        }
    }

    private final void exitForward() {
        chatHistoryMsgRecords.clear();
        contactList.clear();
        forwardType = 0;
        chatType = 0;
        peerUid = "";
        comment = null;
    }

    private final void msgForward(ArrayList<Contact> dstContacts) {
        ArrayList<MsgElement> forwardCommentElement;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        QLog.d(TAG, 1, "forward dstContacts = " + dstContacts + ", comment=" + comment);
        if (dstContacts.isEmpty()) {
            return;
        }
        String str = comment;
        if (str == null || str.length() == 0) {
            forwardCommentElement = null;
        } else {
            IAIOMsgItemApi iAIOMsgItemApi = (IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class);
            String str2 = comment;
            Intrinsics.checkNotNull(str2);
            forwardCommentElement = iAIOMsgItemApi.getForwardCommentElement(str2);
        }
        if (forwardType == 0) {
            String str3 = comment;
            ArrayList<MsgElement> arrayList = str3 == null || str3.length() == 0 ? null : forwardCommentElement;
            for (Contact contact : dstContacts) {
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    ArrayList<MsgRecord> arrayList2 = chatHistoryMsgRecords;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                    for (MsgRecord msgRecord : arrayList2) {
                        arrayList3.add(new MultiMsgInfo(msgRecord.msgId, msgRecord.sendNickName));
                    }
                    e16.t0(new ArrayList<>(arrayList3), new Contact(chatType, peerUid, ""), contact, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.activity.history.e
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str4) {
                            RealNTChatHistoryMsgForwardSingleton.msgForward$lambda$10$lambda$9(i3, str4);
                        }
                    });
                }
            }
        } else {
            String str4 = comment;
            ArrayList<MsgElement> arrayList4 = str4 == null || str4.length() == 0 ? null : forwardCommentElement;
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                ArrayList<MsgRecord> arrayList5 = chatHistoryMsgRecords;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
                ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = arrayList5.iterator();
                while (it.hasNext()) {
                    arrayList6.add(Long.valueOf(((MsgRecord) it.next()).msgId));
                }
                e17.forwardMsg(new ArrayList<>(arrayList6), new Contact(chatType, peerUid, ""), dstContacts, arrayList4, new IForwardOperateCallback() { // from class: com.tencent.mobileqq.activity.history.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
                    public final void onResult(int i3, String str5, HashMap hashMap) {
                        RealNTChatHistoryMsgForwardSingleton.msgForward$lambda$12(i3, str5, hashMap);
                    }
                });
            }
        }
        if ((!chatHistoryMsgRecords.isEmpty()) || (!contactList.isEmpty())) {
            exitForward();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void msgForward$lambda$10$lambda$9(int i3, String str) {
        INSTANCE.exitForward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void msgForward$lambda$12(int i3, String str, HashMap hashMap) {
        INSTANCE.exitForward();
    }

    private final void parseAndHandleForwardData(Intent data) {
        int intExtra = data.getIntExtra("forward_type", Integer.MAX_VALUE);
        ArrayList<ResultRecord> parcelableArrayListExtra = data.getParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayListExtra != null) {
            for (ResultRecord resultRecord : parcelableArrayListExtra) {
                if (resultRecord.getUinType() == 10014) {
                    Intent intent = new Intent(data);
                    intent.putExtra("uin", resultRecord.uin);
                    intent.putExtra("uintype", resultRecord.getUinType());
                    intent.putExtra("troop_uin", resultRecord.groupUin);
                    intent.putExtra("uinname", resultRecord.name);
                    SessionInfo n06 = ForwardUtils.n0(intent);
                    Intrinsics.checkNotNullExpressionValue(n06, "sessionFromIntent(newIntent)");
                    ForwardUtils.K(n06, intExtra, data);
                } else {
                    contactList.add(new Pair<>(resultRecord.uin, Integer.valueOf(resultRecord.uinType)));
                }
            }
            return;
        }
        SessionInfo n07 = ForwardUtils.n0(data);
        Intrinsics.checkNotNullExpressionValue(n07, "sessionFromIntent(data)");
        int i3 = n07.f179555d;
        if (i3 == 10014) {
            ForwardUtils.K(n07, intExtra, data);
        } else {
            contactList.add(new Pair<>(n07.f179557e, Integer.valueOf(i3)));
        }
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void doChatHistoryMsgForward(Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        NTChatHistoryMsgForwardSingleton.a aVar = forwardParams;
        if (aVar == null) {
            QLog.e(TAG, 1, "forward msg error: parameter empty");
            return;
        }
        Intrinsics.checkNotNull(aVar);
        forwardType = aVar.b();
        NTChatHistoryMsgForwardSingleton.a aVar2 = forwardParams;
        Intrinsics.checkNotNull(aVar2);
        chatType = aVar2.a();
        NTChatHistoryMsgForwardSingleton.a aVar3 = forwardParams;
        Intrinsics.checkNotNull(aVar3);
        peerUid = aVar3.c();
        comment = data.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        parseAndHandleForwardData(data);
        doForward();
    }

    public final ArrayList<MsgRecord> getChatHistoryMsgRecords() {
        return chatHistoryMsgRecords;
    }

    public final NTChatHistoryMsgForwardSingleton.a getForwardParams() {
        return forwardParams;
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void previewForwardMsg(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_NT_CHAT_HISTORY, false)) {
            NTChatHistoryMsgForwardSingleton.a aVar = forwardParams;
            if (aVar == null) {
                QLog.e(TAG, 1, "forward msg error: parameter empty");
                return;
            }
            Intrinsics.checkNotNull(aVar);
            chatType = aVar.a();
            NTChatHistoryMsgForwardSingleton.a aVar2 = forwardParams;
            Intrinsics.checkNotNull(aVar2);
            String c16 = aVar2.c();
            peerUid = c16;
            if (chatType != -1) {
                if (!(c16.length() == 0)) {
                    String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE);
                    if (stringExtra == null || stringExtra.length() == 0) {
                        stringExtra = context.getString(R.string.mpg);
                    }
                    String str = stringExtra;
                    if (chatHistoryMsgRecords.isEmpty()) {
                        QLog.e(TAG, 1, "previewMsg invalid");
                        return;
                    }
                    boolean booleanExtra = intent.getBooleanExtra(AppConstants.Key.FORWARD_ACTIVITY_BG, false);
                    IMsgForwardNtUtil iMsgForwardNtUtil = (IMsgForwardNtUtil) QRoute.api(IMsgForwardNtUtil.class);
                    int i3 = chatType;
                    String str2 = peerUid;
                    ArrayList<MsgRecord> arrayList = chatHistoryMsgRecords;
                    NTChatHistoryMsgForwardSingleton.a aVar3 = forwardParams;
                    Intrinsics.checkNotNull(aVar3);
                    iMsgForwardNtUtil.previewMsgWithMsgRecord(context, i3, str2, str, arrayList, false, aVar3.b(), booleanExtra);
                    return;
                }
            }
            QLog.e(TAG, 1, "source data invalid");
        }
    }

    public final void setChatHistoryMsgRecords(ArrayList<MsgRecord> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        chatHistoryMsgRecords = arrayList;
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void setData(List<MsgRecord> msgRecordList, NTChatHistoryMsgForwardSingleton.a params) {
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        Intrinsics.checkNotNullParameter(params, "params");
        chatHistoryMsgRecords.clear();
        chatHistoryMsgRecords.addAll(msgRecordList);
        forwardParams = params;
    }

    public final void setForwardParams(NTChatHistoryMsgForwardSingleton.a aVar) {
        forwardParams = aVar;
    }
}
