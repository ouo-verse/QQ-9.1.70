package com.tencent.superplayer.api;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bd4.a;
import com.tencent.superplayer.bandwidth.AbstractPredictor;
import com.tencent.superplayer.bandwidth.IBandwidthObtainer;
import com.tencent.superplayer.bandwidth.SPBandwidthMonitor;
import com.tencent.superplayer.bandwidth.SPBandwidthPredictor;
import com.tencent.superplayer.bandwidth.SPBufferRangeController;
import com.tencent.superplayer.capture.SPlayerImageGenerator;
import com.tencent.superplayer.datatransport.SPlayerDownloaderImpl;
import com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.preload.SPlayerPreLoaderImpl;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import java.util.ArrayList;
import java.util.Map;
import zc4.c;

/* loaded from: classes26.dex */
public class SuperPlayerFactory {
    private static final String TAG = "SuperPlayerFactory";

    public static ISPBandwidthMonitor createBandwidthMonitor(int i3) {
        return new SPBandwidthMonitor(i3);
    }

    public static ISPBandwidthPredictor createBandwidthPredictor(Context context) {
        return new SPBandwidthPredictor(context);
    }

    public static ISPBufferRangeController createBufferRangeController(@NonNull ISPBandwidthPredictor iSPBandwidthPredictor, @NonNull Map<String, String> map) {
        return new SPBufferRangeController(iSPBandwidthPredictor, map);
    }

    public static ISPlayerDownloader createDownloader(Context context, int i3) {
        return new SPlayerDownloaderImpl(context, i3);
    }

    public static ISPlayerImageGenerator createImageGenerator(String str) {
        return new SPlayerImageGenerator(str);
    }

    public static ISuperPlayer createMediaPlayer(Context context, int i3, ISPlayerVideoView iSPlayerVideoView) {
        boolean z16 = !SuperPlayerSDKMgr.hasSuperInit();
        if (!TPMgr.isInitialized()) {
            SuperPlayerSDKMgr.initTPPlayerBackUp(context);
            LogUtil.e(TAG, "back up player init ");
            z16 = true;
        }
        ISuperPlayer createMediaPlayer = createMediaPlayer(context, i3, iSPlayerVideoView, 0);
        if (z16) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TPOptionalParam.buildQueueInt(TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE, new int[]{1}));
            createMediaPlayer.setPlayerOptionalParamList(arrayList);
        }
        return createMediaPlayer;
    }

    public static ISPlayerVideoView createPlayerVideoView(Context context) {
        return createPlayerVideoView(context, true);
    }

    public static ISPlayerPreDownloader createPreDownloader(Context context, int i3) {
        return new SPlayerPreDownloaderImpl(context, i3);
    }

    public static ISPlayerPreLoader createPreLoader(int i3, int i16) {
        return new SPlayerPreLoaderImpl(i3, i16);
    }

    public static ISPlayerPreDownloader createTVKPreDownloader(Context context) {
        return new a(context);
    }

    public static SuperPlayerVideoInfo createVideoInfoForDRM(int i3, String str, int i16, String str2, String str3) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setFormat(i16);
        superPlayerVideoInfo.setPlayUrl(str);
        ITPDrmMediaAsset createDrmMediaAsset = TPMediaAssetFactory.createDrmMediaAsset(str, i3);
        createDrmMediaAsset.setCertificateUrl(str2);
        createDrmMediaAsset.setLicenseUrl(str3);
        if (i3 == 0) {
            createDrmMediaAsset.setParam(ITPDrmMediaAsset.TP_ASSET_PARAM_KEY_BOOL_LICENSE_STANDARDIZATION, String.valueOf(true));
        }
        superPlayerVideoInfo.setMediaAssert(createDrmMediaAsset);
        return superPlayerVideoInfo;
    }

    public static SuperPlayerVideoInfo createVideoInfoForFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setFormat(204);
        superPlayerVideoInfo.setParcelFileDescriptor(parcelFileDescriptor);
        return superPlayerVideoInfo;
    }

    public static SuperPlayerVideoInfo createVideoInfoForTVideo(String str) {
        return new SuperPlayerVideoInfo(1, 1, str);
    }

    public static SuperPlayerVideoInfo createVideoInfoForUri(Uri uri) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setFormat(204);
        superPlayerVideoInfo.setUri(uri);
        return superPlayerVideoInfo;
    }

    public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] strArr, int i3, String str, String str2) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setPlayUrl(strArr);
        superPlayerVideoInfo.setFormat(i3);
        superPlayerVideoInfo.setFileId(str);
        superPlayerVideoInfo.setLocalSavePath(str2);
        return superPlayerVideoInfo;
    }

    public static ISuperPlayer obtainMediaPlayer(String str) {
        return SuperPlayerSDKMgr.getPlayerPool().get(str);
    }

    public static ISPBandwidthPredictor createBandwidthPredictor(Context context, @Nullable ArrayList<AbstractPredictor> arrayList, @Nullable ArrayList<IBandwidthObtainer> arrayList2, @Nullable Map<String, String> map) {
        return new SPBandwidthPredictor(context, arrayList, arrayList2, map);
    }

    public static ISPlayerVideoView createPlayerVideoView(Context context, boolean z16) {
        return createPlayerVideoView(context, z16, 0);
    }

    public static SuperPlayerVideoInfo createVideoInfoForTVideo(int i3, String str) {
        return new SuperPlayerVideoInfo(1, 1, i3, str);
    }

    public static ISPlayerVideoView createPlayerVideoView(Context context, boolean z16, int i3) {
        if (i3 == 1) {
            return new c(context, z16);
        }
        return new SPlayerVideoView(context, z16);
    }

    public static SuperPlayerVideoInfo createVideoInfoForTVideo(String str, String str2) {
        return new SuperPlayerVideoInfo(1, 2, str, str2);
    }

    public static SuperPlayerVideoInfo createVideoInfoForTVideo(int i3, String str, String str2) {
        return new SuperPlayerVideoInfo(1, 2, i3, str, str2);
    }

    public static SuperPlayerVideoInfo createVideoInfoForUrl(String str, int i3, String str2, String str3) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setPlayUrl(str);
        superPlayerVideoInfo.setFormat(i3);
        superPlayerVideoInfo.setFileId(str2);
        superPlayerVideoInfo.setLocalSavePath(str3);
        return superPlayerVideoInfo;
    }

    public static ISuperPlayer createMediaPlayer(Context context, int i3, ISPlayerVideoView iSPlayerVideoView, int i16) {
        ISuperPlayer superPlayerMgr;
        boolean z16 = !SuperPlayerSDKMgr.hasSuperInit();
        if (!TPMgr.isInitialized()) {
            SuperPlayerSDKMgr.initTPPlayerBackUp(context);
            LogUtil.e(TAG, "back up player init ");
            z16 = true;
        }
        if (i16 == 1) {
            superPlayerMgr = new yc4.a(context, i3, iSPlayerVideoView);
        } else {
            superPlayerMgr = new SuperPlayerMgr(context, i3, iSPlayerVideoView);
        }
        if (z16) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TPOptionalParam.buildQueueInt(TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE, new int[]{1}));
            superPlayerMgr.setPlayerOptionalParamList(arrayList);
        }
        return superPlayerMgr;
    }

    public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] strArr, int i3, String str) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setPlayUrl(strArr);
        superPlayerVideoInfo.setFormat(i3);
        superPlayerVideoInfo.setFileId(str);
        return superPlayerVideoInfo;
    }

    public static SuperPlayerVideoInfo createVideoInfoForUrl(String[] strArr, int i3, long j3, String str) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setPlayUrl(strArr);
        superPlayerVideoInfo.setFormat(i3);
        superPlayerVideoInfo.setVideoDurationMs(j3);
        superPlayerVideoInfo.setFileId(str);
        return superPlayerVideoInfo;
    }

    public static SuperPlayerVideoInfo createVideoInfoForUrl(String str, int i3, String str2) {
        SuperPlayerVideoInfo superPlayerVideoInfo = new SuperPlayerVideoInfo(2);
        superPlayerVideoInfo.setPlayUrl(str);
        superPlayerVideoInfo.setFormat(i3);
        superPlayerVideoInfo.setFileId(str2);
        return superPlayerVideoInfo;
    }
}
