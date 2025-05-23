package com.tencent.mobileqq.icgame.api.message;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import t22.a;
import t22.b;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveAnnounceMsgService extends IQQLiveModule {
    public static final String QQ_LIVE_DEFAULT_ANNOUNCE = "\u5e73\u53f0\u5bf9\u76f4\u64ad\u5185\u5bb9\u548c\u8bc4\u8bba\u8fdb\u884c24\u5c0f\u65f6\u5de1\u67e5\uff0c\u4e25\u7981\u4f20\u64ad\u653f\u6cbb\u3001\u5c01\u5efa\u8ff7\u4fe1\u3001\u66b4\u529b\u8840\u8165\u3001\u4f4e\u4fd7\u8272\u60c5\u3001\u62db\u5ad6\u8bc8\u9a97\u3001\u865a\u5047\u5145\u503c\u7b49\u4e0d\u826f\u5185\u5bb9\uff0c\u82e5\u6709\u8fdd\u53cd\uff0c\u5c06\u5e73\u53f0\u89c4\u5219\u7ed9\u4e88\u7981\u64ad\u3001\u5c01\u53f7\u7b49\u5904\u7406\u3002\u8bf7\u52ff\u8f7b\u4fe1\u5404\u7c7b\u62db\u8058\u5f81\u5a5a\u3001\u4ee3\u7ec3\u4ee3\u62bd\u3001\u8d2d\u4e70\u793c\u5305\u7801\u3001\u6e38\u620f\u5e01\u7b49\u5e7f\u544a\u4fe1\u606f\uff0c\u8bf7\u8c28\u614e\u5224\u65ad\u4ee5\u514d\u4e0a\u5f53\u53d7\u9a97\u3002";

    void addAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener);

    void delAnnounceMessageListener(IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener);

    void getRoomAnnounce(long j3, a aVar);

    void setRoomAnnounce(long j3, long j16, String str, b bVar);
}
