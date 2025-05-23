package com.tencent.mobileqq.icgame.api.impl.room;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomEndPage;
import com.tencent.mobileqq.icgame.sso.h;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zy0.f;
import zy0.g;

/* loaded from: classes15.dex */
public class LiveRoomEndPageImpl implements ILiveRoomEndPage {
    private static final String IC_LIVE_END_PAGE_SERVICE = "trpc.icggame.end_page_svr.EndPageSvr";
    private static final String IC_LIVE_GET_END_PAGE_CMD = "GetEndPageData";
    private static final String TAG = "ICGameILiveRoomEndPage";
    private IQQLiveSDK sdk;

    /* JADX INFO: Access modifiers changed from: private */
    public EndPageRealTimeInfo convertToEndPageInfo(zy0.b bVar) {
        zy0.c cVar;
        EndPageRealTimeInfo endPageRealTimeInfo = new EndPageRealTimeInfo();
        ArrayList arrayList = new ArrayList();
        g gVar = bVar.f453700b;
        if (gVar != null && (cVar = bVar.f453699a) != null && cVar.f453703c != null && cVar.f453704d != null) {
            endPageRealTimeInfo.roomID = cVar.f453701a;
            endPageRealTimeInfo.programID = cVar.f453702b;
            endPageRealTimeInfo.logoURL = gVar.f453713a;
            endPageRealTimeInfo.nickName = gVar.f453714b;
            RealTimeData realTimeData = new RealTimeData();
            realTimeData.type = MetricsType.TOTAL_LIVE_TIME;
            realTimeData.value = bVar.f453699a.f453704d.f453708c;
            realTimeData.name = bVar.f453700b.f453714b;
            arrayList.add(realTimeData);
            for (f fVar : bVar.f453699a.f453703c.f453705a) {
                RealTimeData realTimeData2 = new RealTimeData();
                switch (fVar.f453710a) {
                    case 1:
                        realTimeData2.type = MetricsType.GIFT_AMOUNT;
                        realTimeData2.value = fVar.f453712c;
                        realTimeData2.name = fVar.f453711b;
                        arrayList.add(realTimeData2);
                        break;
                    case 2:
                        realTimeData2.type = MetricsType.NEW_FANS_NUM;
                        realTimeData2.value = fVar.f453712c;
                        realTimeData2.name = fVar.f453711b;
                        arrayList.add(realTimeData2);
                        break;
                    case 3:
                        realTimeData2.type = MetricsType.CUMULATIVE_UV;
                        realTimeData2.value = fVar.f453712c;
                        realTimeData2.name = fVar.f453711b;
                        arrayList.add(realTimeData2);
                        break;
                    case 4:
                        realTimeData2.type = MetricsType.COMMENT_NUM;
                        realTimeData2.value = fVar.f453712c;
                        realTimeData2.name = fVar.f453711b;
                        arrayList.add(realTimeData2);
                        break;
                    case 5:
                        realTimeData2.type = MetricsType.GIFT_GIVER_NUM;
                        realTimeData2.value = fVar.f453712c;
                        realTimeData2.name = fVar.f453711b;
                        arrayList.add(realTimeData2);
                        break;
                    case 6:
                        realTimeData2.type = MetricsType.NUM_OF_LIKE;
                        realTimeData2.value = fVar.f453712c;
                        realTimeData2.name = fVar.f453711b;
                        arrayList.add(realTimeData2);
                        break;
                }
            }
            endPageRealTimeInfo.items = arrayList;
        }
        return endPageRealTimeInfo;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        QLog.d(TAG, 4, "ILiveRoomEndPage reset");
    }

    @Override // com.tencent.mobileqq.icgame.api.room.ILiveRoomEndPage
    public void getLiveEndPageInfo(long j3, String str, final b32.d dVar) {
        if (this.sdk == null) {
            QLog.e(TAG, 1, "getLiveEndPageInfo, sdk has destroyed");
            return;
        }
        zy0.a aVar = new zy0.a();
        aVar.f453697a = j3;
        aVar.f453698b = str;
        com.tencent.mobileqq.icgame.sso.c cVar = (com.tencent.mobileqq.icgame.sso.c) this.sdk.getExtModule("sso_module");
        if (cVar == null) {
            QLog.e(TAG, 4, "getLiveEndPageInfo get sso module null");
        } else {
            cVar.f(IC_LIVE_END_PAGE_SERVICE, IC_LIVE_GET_END_PAGE_CMD, MessageNano.toByteArray(aVar), new h(new com.tencent.mobileqq.icgame.sso.a() { // from class: com.tencent.mobileqq.icgame.api.impl.room.LiveRoomEndPageImpl.1
                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onBusinessFailed(int i3, String str2) {
                    super.onBusinessFailed(i3, str2);
                    if (dVar != null) {
                        QLog.e(LiveRoomEndPageImpl.TAG, 1, "ILiveRoomEndPage onBusinessFailed fail  errorCode = " + i3 + " errorMsg = " + str2);
                        dVar.onFailed(i3, str2);
                    }
                }

                @Override // com.tencent.mobileqq.icgame.sso.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
                public void onFailed(int i3, String str2) {
                    super.onFailed(i3, str2);
                    if (dVar != null) {
                        QLog.e(LiveRoomEndPageImpl.TAG, 1, "ILiveRoomEndPage callback fail errorCode = " + i3 + " errorMsg = " + str2);
                        dVar.onFailed(i3, str2);
                    }
                }

                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onProxyRequestSuccess(int i3, i iVar) {
                    try {
                        dVar.onSuccess(LiveRoomEndPageImpl.this.convertToEndPageInfo(zy0.b.c(iVar.e())));
                    } catch (InvalidProtocolBufferNanoException e16) {
                        QLog.e(LiveRoomEndPageImpl.TAG, 4, "ILiveRoomEndPage parse pb fail");
                        e16.printStackTrace();
                    }
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdk = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        QLog.d(TAG, 4, "ILiveRoomEndPage reset");
    }
}
