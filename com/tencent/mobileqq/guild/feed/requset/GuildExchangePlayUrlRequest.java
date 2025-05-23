package com.tencent.mobileqq.guild.feed.requset;

import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import guild.GuildVideoUrlExchange$GetVideoAdaptReq;
import guild.GuildVideoUrlExchange$GetVideoAdaptRsp;
import guild.GuildVideoUrlExchange$Video;

/* loaded from: classes13.dex */
public class GuildExchangePlayUrlRequest extends GuildBaseRequest {
    GuildVideoUrlExchange$GetVideoAdaptReq mReq = new GuildVideoUrlExchange$GetVideoAdaptReq();

    public GuildExchangePlayUrlRequest(GProStVideo gProStVideo) {
        GuildVideoUrlExchange$Video guildVideoUrlExchange$Video = new GuildVideoUrlExchange$Video();
        guildVideoUrlExchange$Video.fileID.set(gProStVideo.fileId);
        guildVideoUrlExchange$Video.playURL.set(gProStVideo.playUrl);
        guildVideoUrlExchange$Video.duration.set(gProStVideo.duration);
        guildVideoUrlExchange$Video.fileSize.set(gProStVideo.fileSize);
        guildVideoUrlExchange$Video.height.set(gProStVideo.height);
        guildVideoUrlExchange$Video.width.set(gProStVideo.width);
        guildVideoUrlExchange$Video.transStatus.set(gProStVideo.transStatus);
        guildVideoUrlExchange$Video.videoRate.set(gProStVideo.videoRate);
        guildVideoUrlExchange$Video.videoPrior.set(gProStVideo.videoPrior);
        this.mReq.from.set(0);
        this.mReq.bizType.set(1);
        this.mReq.userID.set(ax.v());
        this.mReq.videos.add(guildVideoUrlExchange$Video);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QChannelSvr.trpc.qchannel.videourlexchange.VideoURLExchange.GetVideoAdaptInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        GuildVideoUrlExchange$GetVideoAdaptRsp guildVideoUrlExchange$GetVideoAdaptRsp = new GuildVideoUrlExchange$GetVideoAdaptRsp();
        try {
            guildVideoUrlExchange$GetVideoAdaptRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return guildVideoUrlExchange$GetVideoAdaptRsp;
    }
}
