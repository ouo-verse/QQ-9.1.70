package com.tencent.mobileqq.qqlive.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveEcomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveGameRecommendInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomConfigInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveStreamIdInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveTrtcInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomTag;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceAddressInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceFrameInfo;
import com.tencent.mobileqq.qqlive.data.room.stream.ServiceStreamInfo;
import com.tencent.qphone.base.util.QLog;
import rt3.ab;
import rt3.ac;
import rt3.ad;
import rt3.ae;
import rt3.af;
import rt3.ag;
import rt3.ah;
import rt3.v;
import rt3.y;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    @NonNull
    private static LiveRoomConfigInfo a(rt3.d dVar) {
        LiveRoomConfigInfo liveRoomConfigInfo = new LiveRoomConfigInfo();
        if (dVar != null) {
            liveRoomConfigInfo.commonConfig = dVar.f432275b;
            liveRoomConfigInfo.currentRoomConfig = dVar.f432274a;
            liveRoomConfigInfo.gameRoomConfig = dVar.f432276c;
            liveRoomConfigInfo.normalRoomConfig = dVar.f432277d;
        }
        return liveRoomConfigInfo;
    }

    public static LiveInfo b(rt3.h hVar) {
        y[] yVarArr;
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.userFlag = hVar.f432292f;
        liveInfo.anchorType = hVar.f432300n;
        liveInfo.roomEnterSetting = hVar.f432302p;
        LiveRoomInfo liveRoomInfo = new LiveRoomInfo();
        ac acVar = hVar.f432290d;
        if (acVar != null) {
            liveRoomInfo.roomId = acVar.f432229a;
            liveRoomInfo.ownerId = acVar.f432230b;
            liveRoomInfo.roomName = acVar.f432232d;
            liveRoomInfo.roomLogo = acVar.f432231c;
            liveRoomInfo.programId = acVar.f432237i;
            liveRoomInfo.giftFlag = acVar.f432235g;
            liveRoomInfo.goodsFlag = acVar.f432236h;
            liveRoomInfo.roomType = acVar.f432233e;
            liveRoomInfo.enterRoomSystemNotice = acVar.f432238j;
            ad adVar = acVar.f432234f;
            if (adVar != null && (yVarArr = adVar.f432239a) != null) {
                for (y yVar : yVarArr) {
                    RoomTag roomTag = new RoomTag();
                    roomTag.type = yVar.f432383a;
                    roomTag.text = yVar.f432384b;
                    roomTag.url = yVar.f432385c;
                    liveRoomInfo.tags.add(roomTag);
                }
            }
        } else {
            QLog.e("LiveInfoProvider", 1, "parseLiveAudienceLiveInfo roomInfo is null");
        }
        liveInfo.setRoomInfo(liveRoomInfo);
        LiveAnchorInfo liveAnchorInfo = new LiveAnchorInfo();
        ah ahVar = hVar.f432291e;
        if (ahVar != null) {
            liveAnchorInfo.uid = ahVar.f432253a;
            liveAnchorInfo.nickName = ahVar.f432255c;
            liveAnchorInfo.explicitId = ahVar.f432256d;
            liveAnchorInfo.headUrl = ahVar.f432257e;
            liveAnchorInfo.businessUid = ahVar.f432260h;
            liveAnchorInfo.initialClientType = ahVar.f432259g;
            liveAnchorInfo.imsdkTinyId = ahVar.f432258f;
            liveAnchorInfo.wechatPub = ahVar.f432261i;
            liveAnchorInfo.sex = ahVar.f432254b;
        }
        liveInfo.setAnchorInfo(liveAnchorInfo);
        LiveWatchMediaInfo liveWatchMediaInfo = new LiveWatchMediaInfo();
        if (hVar.f432293g != null) {
            LiveVideoStatus[] values = LiveVideoStatus.values();
            rt3.a aVar = hVar.f432293g;
            liveWatchMediaInfo.mVideoStatus = values[aVar.f432207a];
            liveWatchMediaInfo.mRtmpUrl = "";
            liveWatchMediaInfo.mRtmpUrlHigh = "";
            liveWatchMediaInfo.mRtmpUrlLow = "";
            liveWatchMediaInfo.mRtmpUrlLowest = "";
            v vVar = aVar.f432212f;
            if (vVar != null) {
                liveWatchMediaInfo.mRtmpUrl = vVar.f432361a;
                liveWatchMediaInfo.mRtmpUrlHigh = vVar.f432362b;
                liveWatchMediaInfo.mRtmpUrlLow = vVar.f432363c;
                liveWatchMediaInfo.mRtmpUrlLowest = vVar.f432364d;
            }
            v vVar2 = aVar.f432213g;
            if (vVar2 != null) {
                liveWatchMediaInfo.mHLSUrl = vVar2.f432361a;
            }
            v vVar3 = aVar.f432214h;
            if (vVar3 != null) {
                liveWatchMediaInfo.mFlvUrl = vVar3.f432361a;
                liveWatchMediaInfo.mFlvUrlHigh = vVar3.f432362b;
                liveWatchMediaInfo.mFlvUrlLow = vVar3.f432363c;
                liveWatchMediaInfo.mFlvUrlLowest = vVar3.f432364d;
            }
            liveWatchMediaInfo.sig = aVar.f432209c;
            liveWatchMediaInfo.sigTimeOut = aVar.f432210d;
            liveWatchMediaInfo.mSdkType = aVar.f432208b;
            rt3.e eVar = aVar.f432215i;
            if (eVar != null) {
                d(eVar, liveWatchMediaInfo);
                if (hVar.f432293g.f432215i.f432279b == 1) {
                    liveWatchMediaInfo.forceSwitch = true;
                }
            }
        }
        liveInfo.watchMediaInfo = liveWatchMediaInfo;
        liveInfo.configInfo = a(hVar.f432296j);
        ab abVar = hVar.f432301o;
        if (abVar != null) {
            liveInfo.gameRecommendInfo = new LiveGameRecommendInfo(abVar.f432226a);
        }
        LiveGameRecommendInfo liveGameRecommendInfo = liveInfo.gameRecommendInfo;
        if ((liveGameRecommendInfo == null || !liveGameRecommendInfo.getHasTask()) && hVar.f432297k != null) {
            LiveEcomInfo liveEcomInfo = new LiveEcomInfo();
            liveInfo.ecomInfo = liveEcomInfo;
            liveEcomInfo.hasGoods = hVar.f432297k.f432386a;
        }
        if (hVar.f432298l != null) {
            LiveTrtcInfo liveTrtcInfo = new LiveTrtcInfo();
            liveInfo.trtcInfo = liveTrtcInfo;
            ag agVar = hVar.f432298l;
            liveTrtcInfo.sig = agVar.f432251a;
            liveTrtcInfo.time = agVar.f432252b;
        }
        if (hVar.f432299m != null) {
            LiveStreamIdInfo liveStreamIdInfo = new LiveStreamIdInfo();
            liveInfo.streamIdInfo = liveStreamIdInfo;
            af afVar = hVar.f432299m;
            liveStreamIdInfo.uid = afVar.f432244a;
            liveStreamIdInfo.roomId = afVar.f432245b;
            liveStreamIdInfo.mainStreamId = afVar.f432246c;
            liveStreamIdInfo.auxStreamId = afVar.f432247d;
            liveStreamIdInfo.isSelfInfo = afVar.f432248e;
            liveStreamIdInfo.originUid = afVar.f432249f;
            liveStreamIdInfo.originRoomId = afVar.f432250g;
        }
        return liveInfo;
    }

    public static LiveRealTimeInfo c(br3.c cVar) {
        LiveRealTimeInfo liveRealTimeInfo = new LiveRealTimeInfo();
        br3.d dVar = cVar.f29013a;
        if (dVar == null) {
            return liveRealTimeInfo;
        }
        liveRealTimeInfo.roomId = dVar.f29016c;
        liveRealTimeInfo.programId = dVar.f29014a;
        liveRealTimeInfo.anchorId = dVar.f29015b;
        br3.a[] aVarArr = dVar.f29017d;
        if (aVarArr != null && aVarArr.length != 0) {
            for (br3.a aVar : aVarArr) {
                RealTimeData realTimeData = new RealTimeData();
                realTimeData.isShow = aVar.f29010d;
                int i3 = aVar.f29007a;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                realTimeData.type = MetricsType.DEFAULT;
                            } else {
                                realTimeData.type = MetricsType.NUM_OF_LIKE;
                            }
                        } else {
                            realTimeData.type = MetricsType.CUR_UV;
                        }
                    } else {
                        realTimeData.type = MetricsType.CUMULATIVE_UV;
                    }
                } else {
                    realTimeData.type = MetricsType.TOTAL_LIVE_TIME;
                }
                realTimeData.name = aVar.f29008b;
                realTimeData.value = aVar.f29009c;
                liveRealTimeInfo.items.add(realTimeData);
            }
        }
        return liveRealTimeInfo;
    }

    private static void d(rt3.e eVar, LiveWatchMediaInfo liveWatchMediaInfo) {
        ae aeVar;
        liveWatchMediaInfo.sugLevel = eVar.f432281d;
        ae[] aeVarArr = eVar.f432278a;
        if (aeVarArr != null && aeVarArr.length > 0 && (aeVar = aeVarArr[0]) != null) {
            ServiceStreamInfo serviceStreamInfo = new ServiceStreamInfo();
            serviceStreamInfo.name = aeVar.f432242b;
            int i3 = aeVar.f432243c;
            serviceStreamInfo.rawLevel = i3;
            liveWatchMediaInfo.mLevel = i3;
            rt3.k[] kVarArr = aeVar.f432241a;
            if (kVarArr != null) {
                for (rt3.k kVar : kVarArr) {
                    ServiceFrameInfo serviceFrameInfo = new ServiceFrameInfo();
                    serviceFrameInfo.level = kVar.f432317a;
                    serviceFrameInfo.definition = kVar.f432319c;
                    rt3.b[] bVarArr = kVar.f432318b;
                    if (bVarArr != null) {
                        for (rt3.b bVar : bVarArr) {
                            ServiceAddressInfo serviceAddressInfo = new ServiceAddressInfo();
                            serviceAddressInfo.bitrate = bVar.f432264b;
                            serviceAddressInfo.url = bVar.f432263a;
                            serviceFrameInfo.addresses.add(serviceAddressInfo);
                        }
                    }
                    if (serviceFrameInfo.level == liveWatchMediaInfo.sugLevel) {
                        liveWatchMediaInfo.sugServiceFrameInfo = serviceFrameInfo;
                    }
                    serviceStreamInfo.frames.add(serviceFrameInfo);
                }
            }
            liveWatchMediaInfo.serviceStreamInfo = serviceStreamInfo;
        }
        ServiceFrameInfo serviceFrameInfo2 = liveWatchMediaInfo.sugServiceFrameInfo;
        if (serviceFrameInfo2 != null && serviceFrameInfo2.addresses.size() > 0) {
            liveWatchMediaInfo.mUrl = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
            liveWatchMediaInfo.mUrlHigh = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
            liveWatchMediaInfo.mUrlLow = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
            liveWatchMediaInfo.mUrlLowest = liveWatchMediaInfo.sugServiceFrameInfo.addresses.get(0).url;
        }
    }
}
