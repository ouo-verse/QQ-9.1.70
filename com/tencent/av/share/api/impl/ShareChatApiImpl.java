package com.tencent.av.share.api.impl;

import android.content.Intent;
import android.view.View;
import com.tencent.av.share.ShareChat;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShareChatApiImpl implements IShareChatApi {
    @Override // com.tencent.av.share.api.IShareChatApi
    public int getLinkTypeNeedVerify() {
        return 0;
    }

    @Override // com.tencent.av.share.api.IShareChatApi
    public int getLinkTypeNoVerify() {
        return 1;
    }

    @Override // com.tencent.av.share.api.IShareChatApi
    public boolean jump(ax axVar) {
        return ShareChat.r(axVar);
    }

    @Override // com.tencent.av.share.api.IShareChatApi
    public void share(BaseQQAppInterface baseQQAppInterface, QBaseActivity qBaseActivity, View view, Intent intent) {
        ShareChat.v(baseQQAppInterface, qBaseActivity, view, intent);
    }

    @Override // com.tencent.av.share.api.IShareChatApi
    public boolean shareGAVArkMsg(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, String str3) {
        return ShareChat.w(baseQQAppInterface, str, str2, i3, str3);
    }
}
