package com.tencent.mobileqq.matchfriend.api.impl;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigHelper;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.matchfriend.reborn.mark.helper.QQStrangerInteractiveMarkHelper;
import com.tencent.mobileqq.matchfriend.utils.StrangerEntryUnreadCountMgr;
import com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendChatApiImpl implements IMatchFriendChatApi {
    private static final String TAG = "MatchFriendChatApiImpl";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements IOperateCallback {
        a() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            QLog.i(MatchFriendChatApiImpl.TAG, 1, "deleteAllRecentContact nt success.");
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void deleteAllRecentContact() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "deleteAllRecentContact error! app is null!");
            return;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e(TAG, 1, "deleteAllRecentContact is error! recentContactService is null!");
            return;
        }
        List<RecentContactInfo> f16 = QQStrangerRecentContactHelper.f244865a.f();
        ArrayList<Contact> arrayList = new ArrayList<>();
        for (RecentContactInfo recentContactInfo : f16) {
            arrayList.add(new Contact(recentContactInfo.chatType, recentContactInfo.peerUid, ""));
        }
        recentContactService.a0(arrayList, new a());
        ((IQQStrangerUserInfoMgr) peekAppRuntime.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).deleteAll();
        QQStrangerRecentContactHelper.f244865a.d(true);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void doWhenQQLogout() {
        VoiceChatController.I().D();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public com.tencent.aio.main.businesshelper.h getAIOSigHelper() {
        return new QQStrangerAIOSigHelper();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public int getEntryVisibleUnreadCount() {
        return StrangerEntryUnreadCountMgr.f245590a.e();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public String getFriendOpenId() {
        return com.tencent.mobileqq.matchfriend.utils.b.d().b();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public com.tencent.aio.main.businesshelper.h getLittleAssistantHelper() {
        return new h72.a();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public String getMatchFriendOfficialMessageSourceType(MessageRecord messageRecord) {
        return com.tencent.mobileqq.matchfriend.utils.c.a(messageRecord);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public String getNotificationContent() {
        return BaseApplication.getContext().getString(R.string.x0h);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public Intent getNotificationIntent(Context context, String str) {
        return n72.a.a(context, str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public String getNotificationTitle() {
        return BaseApplication.getContext().getString(R.string.x0i);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public com.tencent.aio.main.businesshelper.h getQQStrangerInteractiveMarkHelper() {
        return new QQStrangerInteractiveMarkHelper();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public String getSelfOpenId() {
        return com.tencent.mobileqq.matchfriend.utils.b.d().j();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public int getUnreadNum() {
        return (int) QQStrangerRecentContactHelper.f244865a.h();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public boolean isFirstEnterSession(String str) {
        return com.tencent.mobileqq.matchfriend.utils.b.d().l(str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public boolean isNeedForbidNotification() {
        boolean z16 = !com.tencent.mobileqq.matchfriend.utils.b.d().i();
        QLog.i(TAG, 1, "isNeedForbidNotification is " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void matchFriendOfficialMessageReport(Context context, String str, String str2) {
        com.tencent.mobileqq.matchfriend.utils.c.b(context, str, str2);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public List<Pair<String, String>> parseMatchFriendQQText(String str) {
        return com.tencent.mobileqq.matchfriend.utils.c.d(str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public String parseMatchFriendUrl(String str) {
        return com.tencent.mobileqq.matchfriend.utils.c.e(str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void reportQuoteExpExposure(int i3) {
        com.tencent.mobileqq.matchfriend.aio.quote.b.d(i3);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void setFlagFirstEnterSession(String str, boolean z16) {
        com.tencent.mobileqq.matchfriend.utils.b.d().m(str, z16);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void setFriendOpenId(String str) {
        com.tencent.mobileqq.matchfriend.utils.b.d().n(str);
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi
    public void deleteUnusedMatchFriendChatDB() {
    }
}
