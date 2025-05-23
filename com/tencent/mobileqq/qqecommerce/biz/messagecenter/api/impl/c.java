package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u0006H\u0002\u001a\u000e\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u0000H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "g", "", PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "f", "e", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {
    private static final MessageItem d(String str) {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject = jSONObject.optJSONObject("src_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        } else {
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"src_info\") ?: JSONObject()");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cover");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        } else {
            Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(\"cover\") ?: JSONObject()");
        }
        String optString = jSONObject.optString("id");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"id\")");
        long optLong = jSONObject.optLong("uin");
        int optInt = optJSONObject.optInt("type");
        String optString2 = optJSONObject.optString("type_name");
        Intrinsics.checkNotNullExpressionValue(optString2, "srcInfo.optString(\"type_name\")");
        MessageType messageType = new MessageType(optInt, optString2);
        String optString3 = optJSONObject.optString("icon");
        Intrinsics.checkNotNullExpressionValue(optString3, "srcInfo.optString(\"icon\")");
        String optString4 = optJSONObject.optString("src_name");
        Intrinsics.checkNotNullExpressionValue(optString4, "srcInfo.optString(\"src_name\")");
        String optString5 = jSONObject.optString("title");
        Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"title\")");
        String optString6 = jSONObject.optString("brief");
        Intrinsics.checkNotNullExpressionValue(optString6, "optString(\"brief\")");
        String optString7 = jSONObject.optString("content");
        Intrinsics.checkNotNullExpressionValue(optString7, "optString(\"content\")");
        String optString8 = jSONObject.optString("jump_url");
        Intrinsics.checkNotNullExpressionValue(optString8, "optString(\"jump_url\")");
        long optLong2 = jSONObject.optLong(AlbumCacheData.CREATE_TIME) * 1000;
        String optString9 = optJSONObject2.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString9, "coverInfo.optString(\"url\")");
        return new MessageItem(optString, optLong, messageType, optString3, optString4, optString5, optString6, optString7, optString8, optLong2, optString9, com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.b.a(jSONObject.optInt("style")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageItem g(MsgRecord msgRecord) {
        QRouteApi api = QRoute.api(IPublicAccountMsgExtMrg.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountMsgExtMrg::class.java)");
        IPublicAccountMsgExtMrg iPublicAccountMsgExtMrg = (IPublicAccountMsgExtMrg) api;
        String originalParam = iPublicAccountMsgExtMrg.getOriginalParam(iPublicAccountMsgExtMrg.getBusiIdExtra(msgRecord));
        if (originalParam.length() == 0) {
            QLog.i(EcommerceMsgCenterServiceImpl.TAG, 1, "onReceiveMessage: get message without extra info");
            return null;
        }
        return d(originalParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(MsgRecord msgRecord) {
        if (msgRecord == null) {
            return "MsgRecord=null";
        }
        return "MsgRecord(id=" + msgRecord.msgId + " msgTime=" + msgRecord.msgTime + " chatType=" + msgRecord.chatType + " peerUin=" + msgRecord.peerUin + " peerName=" + msgRecord.peerName + " )";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(RecentContactInfo recentContactInfo) {
        if (recentContactInfo == null) {
            return "RecentContactInfo=null";
        }
        return "RecentContactInfo(id=" + recentContactInfo.f359204id + " msgId=" + recentContactInfo.msgId + " msgTime=" + recentContactInfo.msgTime + "chatType=" + recentContactInfo.chatType + " peerUin=" + recentContactInfo.peerUin + " peerName=" + recentContactInfo.peerName + " unReadCont=" + recentContactInfo.unreadCnt + " unreadFlag=" + recentContactInfo.unreadFlag + " )";
    }
}
