package com.tencent.gamematrix.gmcg.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class GmCgPlayPerfInfo implements Parcelable {
    public static final Parcelable.Creator<GmCgPlayPerfInfo> CREATOR = new Parcelable.Creator<GmCgPlayPerfInfo>() { // from class: com.tencent.gamematrix.gmcg.api.model.GmCgPlayPerfInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgPlayPerfInfo createFromParcel(Parcel parcel) {
            return new GmCgPlayPerfInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgPlayPerfInfo[] newArray(int i3) {
            return new GmCgPlayPerfInfo[i3];
        }
    };
    public long pAudioBitrate;
    public int pAudioPacketsLossPercentage;
    public int pAudioPacketsLost;
    public long pAudioPacketsReceived;
    public long pBitrate;
    public String pDecodeType;
    public double pFecRate;
    public String pGameCodecConfig;
    public String pLocalNetCarrier;
    public double pLostRateFinal;
    public double pLostRateNet;
    public double pNackRate;
    public double pPerfdogJankDuration;
    public double pPerfdogPotentialJankDuration;
    public double pPerfdogStutter;
    public boolean pRealNetFreeFlow;
    public double pRecoverRate;
    public String pRemoteNetCarrier;
    public long pReportTimestamp;
    public short pRoundTripLatency;
    public int pSrType;
    public boolean pSupportNetFreeFlow;
    public String pTgpaPingValue;
    public boolean pUsingVDecoder;
    public long pVideoAverageBitRate;
    public long pVideoAverageDecodeTimeMs;
    public double pVideoAverageFrameRate;
    public long pVideoAverageRtt;
    public long pVideoBitrate;
    public long pVideoBytesReceived;
    public int pVideoDecodeTimeMs;
    public long pVideoFirstFrameRenderDelay;
    public long pVideoFrameHeight;
    public long pVideoFrameWidth;
    public double pVideoFramerate;
    public long pVideoFramesDecoded;
    public long pVideoFramesDropped;
    public long pVideoFramesReceived;
    public long pVideoFreezeCount;
    public double pVideoFreezeDuringLast10s;
    public int pVideoPacketsLost;
    public long pVideoPacketsReceived;
    public long pVideoPlayTime;
    public long pVideoRtt;
    public long pVideoStutterLatency;
    public double pVideoTotalFreezesDuration;
    public int pWebrtcNetworkBandwidth;
    public double pWebrtcNetworkQuality;

    public GmCgPlayPerfInfo() {
        this.pWebrtcNetworkQuality = 5.0d;
        this.pLocalNetCarrier = "unknown";
        this.pRemoteNetCarrier = "unknown";
        this.pTgpaPingValue = "-1";
        this.pGameCodecConfig = "";
        this.pUsingVDecoder = false;
        this.pPerfdogStutter = 0.0d;
        this.pLostRateNet = 0.0d;
        this.pLostRateFinal = 0.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getShutterLatencyState() {
        long j3 = this.pVideoStutterLatency;
        if (j3 < 50) {
            return 1;
        }
        if (j3 >= 150) {
            return 3;
        }
        return 2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.pVideoFirstFrameRenderDelay);
        parcel.writeInt(this.pVideoDecodeTimeMs);
        parcel.writeDouble(this.pVideoFramerate);
        parcel.writeLong(this.pVideoBitrate);
        parcel.writeLong(this.pVideoFramesDecoded);
        parcel.writeLong(this.pVideoFramesDropped);
        parcel.writeLong(this.pVideoFramesReceived);
        parcel.writeLong(this.pVideoPacketsReceived);
        parcel.writeInt(this.pVideoPacketsLost);
        parcel.writeLong(this.pVideoFrameWidth);
        parcel.writeLong(this.pVideoFrameHeight);
        parcel.writeLong(this.pVideoRtt);
        parcel.writeString(this.pDecodeType);
        parcel.writeDouble(this.pVideoAverageFrameRate);
        parcel.writeLong(this.pVideoAverageDecodeTimeMs);
        parcel.writeLong(this.pVideoAverageBitRate);
        parcel.writeLong(this.pVideoAverageRtt);
        parcel.writeLong(this.pVideoBytesReceived);
        parcel.writeLong(this.pVideoPlayTime);
        parcel.writeLong(this.pVideoFreezeCount);
        parcel.writeDouble(this.pVideoTotalFreezesDuration);
        parcel.writeDouble(this.pVideoFreezeDuringLast10s);
        parcel.writeInt(this.pWebrtcNetworkBandwidth);
        parcel.writeDouble(this.pWebrtcNetworkQuality);
        parcel.writeLong(this.pVideoStutterLatency);
        parcel.writeInt(this.pAudioPacketsLost);
        parcel.writeLong(this.pAudioPacketsReceived);
        parcel.writeInt(this.pAudioPacketsLossPercentage);
        parcel.writeLong(this.pAudioBitrate);
        parcel.writeLong(this.pReportTimestamp);
        parcel.writeLong(this.pBitrate);
        parcel.writeString(this.pLocalNetCarrier);
        parcel.writeString(this.pRemoteNetCarrier);
        parcel.writeByte(this.pSupportNetFreeFlow ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.pRealNetFreeFlow ? (byte) 1 : (byte) 0);
        parcel.writeString(this.pTgpaPingValue);
        parcel.writeString(this.pGameCodecConfig);
        parcel.writeByte(this.pUsingVDecoder ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.pSrType);
        parcel.writeDouble(this.pPerfdogStutter);
        parcel.writeDouble(this.pPerfdogJankDuration);
        parcel.writeDouble(this.pPerfdogPotentialJankDuration);
        parcel.writeDouble(this.pLostRateNet);
        parcel.writeDouble(this.pLostRateFinal);
        parcel.writeInt(this.pRoundTripLatency);
    }

    protected GmCgPlayPerfInfo(Parcel parcel) {
        this.pWebrtcNetworkQuality = 5.0d;
        this.pLocalNetCarrier = "unknown";
        this.pRemoteNetCarrier = "unknown";
        this.pTgpaPingValue = "-1";
        this.pGameCodecConfig = "";
        this.pUsingVDecoder = false;
        this.pPerfdogStutter = 0.0d;
        this.pLostRateNet = 0.0d;
        this.pLostRateFinal = 0.0d;
        this.pVideoFirstFrameRenderDelay = parcel.readLong();
        this.pVideoDecodeTimeMs = parcel.readInt();
        this.pVideoFramerate = parcel.readDouble();
        this.pVideoBitrate = parcel.readLong();
        this.pVideoFramesDecoded = parcel.readLong();
        this.pVideoFramesDropped = parcel.readLong();
        this.pVideoFramesReceived = parcel.readLong();
        this.pVideoPacketsReceived = parcel.readLong();
        this.pVideoPacketsLost = parcel.readInt();
        this.pVideoFrameWidth = parcel.readLong();
        this.pVideoFrameHeight = parcel.readLong();
        this.pVideoRtt = parcel.readLong();
        this.pDecodeType = parcel.readString();
        this.pVideoAverageFrameRate = parcel.readDouble();
        this.pVideoAverageDecodeTimeMs = parcel.readLong();
        this.pVideoAverageBitRate = parcel.readLong();
        this.pVideoAverageRtt = parcel.readLong();
        this.pVideoBytesReceived = parcel.readLong();
        this.pVideoPlayTime = parcel.readLong();
        this.pVideoFreezeCount = parcel.readLong();
        this.pVideoTotalFreezesDuration = parcel.readDouble();
        this.pVideoFreezeDuringLast10s = parcel.readDouble();
        this.pWebrtcNetworkBandwidth = parcel.readInt();
        this.pWebrtcNetworkQuality = parcel.readDouble();
        this.pVideoStutterLatency = parcel.readLong();
        this.pAudioPacketsLost = parcel.readInt();
        this.pAudioPacketsReceived = parcel.readLong();
        this.pAudioPacketsLossPercentage = parcel.readInt();
        this.pAudioBitrate = parcel.readLong();
        this.pReportTimestamp = parcel.readLong();
        this.pBitrate = parcel.readLong();
        this.pLocalNetCarrier = parcel.readString();
        this.pRemoteNetCarrier = parcel.readString();
        this.pSupportNetFreeFlow = parcel.readByte() != 0;
        this.pRealNetFreeFlow = parcel.readByte() != 0;
        this.pTgpaPingValue = parcel.readString();
        this.pGameCodecConfig = parcel.readString();
        this.pUsingVDecoder = parcel.readByte() != 0;
        this.pSrType = parcel.readInt();
        this.pPerfdogStutter = parcel.readDouble();
        this.pPerfdogJankDuration = parcel.readDouble();
        this.pPerfdogPotentialJankDuration = parcel.readDouble();
        this.pLostRateNet = parcel.readDouble();
        this.pLostRateFinal = parcel.readDouble();
        this.pRoundTripLatency = (short) parcel.readInt();
    }
}
