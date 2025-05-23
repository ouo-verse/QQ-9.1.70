package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.api.IGuildRecentUseEmojiHandler;
import com.tencent.mobileqq.guild.message.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EmojiUseInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRecentUseEmojiHandler extends BusinessHandler implements IGuildRecentUseEmojiHandler, IGetRecentUseEmojiListCallback {
    private static final String TAG = "GuildRecentUseEmojiHandler";

    protected GuildRecentUseEmojiHandler(AppInterface appInterface) {
        super(appInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendPbReq, reason: merged with bridge method [inline-methods] */
    public void lambda$reqRecentUseEmojiList$0() {
        QLog.d(TAG, 1, "sendPbReq");
        ((IMsgService) QRoute.api(IMsgService.class)).getRecentUseEmojiList(this);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return v.class;
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRecentUseEmojiListCallback
    public void onGetRecentUseEmojiListCallback(int i3, String str, ArrayList<EmojiUseInfo> arrayList) {
        QLog.d(TAG, 1, "onGetRecentUseEmojiListCallback result=" + i3 + " errMsg=" + str + " size=" + arrayList.size());
        com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new oi1.d());
        if (i3 == 0) {
            oi1.g.e().j(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildRecentUseEmojiHandler
    public void reqRecentUseEmojiList() {
        if (oi1.g.e().c()) {
            QLog.d(TAG, 1, "reqRecentUseEmojiList cache valid");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRecentUseEmojiHandler.this.lambda$reqRecentUseEmojiList$0();
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
