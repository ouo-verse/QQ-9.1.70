package com.tencent.superplayer.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerAudioInfo;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerMsg;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.ListenerCombine;
import com.tencent.superplayer.report.ISPReportProvider;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.f;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPMediaCodecReadyInfo;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import com.tencent.thumbplayer.api.player.TPPlayerFactory;
import com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.v1.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.v1.TPVodReportInfo;
import com.tencent.thumbplayer.api.snapshot.ITPSnapshotor;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.common.TPMD5Util;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Marker;

/* loaded from: classes26.dex */
public class SuperPlayerWrapper implements ISuperPlayer, ISuperPlayerState {
    private static final String API_CALL_LOG_PREFIX = "api call : ";
    private static final String AUDIO_CODEC_ID_NONE = "TP_CODEC_ID_NONE";
    private static final String FILENAME = "SuperPlayerWrapper.java";
    private static final String LISTENER_CALL_LOG_PREFIX = "inner listener called : ";
    private Context mContext;
    private String mFlowId;
    private boolean mIsBuffering;
    private boolean mIsLoopback;
    private boolean mIsOutputMute;
    private boolean mIsSwitchingTVideoDefn;
    private SuperPlayerListenerCallBack mListenerCallback;
    private SuperPlayerListenerMgr mListenerMgr;
    private Looper mLooper;
    private MediaInfo mMediaInfo;
    private SuperPlayerState mPlayState;
    private Handler mPlayerHandler;
    private String mPlayerTag;
    private TPDefaultReportInfo mReportInfo;
    private int mSceneId;
    private long mSkipEndMilSec;
    private long mStartPositionMilSec;
    private Surface mSurface;
    private String mTAG;
    private List<TPOptionalParam> mTPOptionalParamList;
    private ITPPlayer mTPPlayer;
    private TPPlayerListenerAdapter mTPPlayerListenerAdapter;
    private int mTVdieoSwitchDefnMode;
    private long mTotalFileSizeBytes;
    private VInfoGetter mVInfoGetter;
    private SuperPlayerVideoInfo mVideoInfo;
    private AtomicInteger mCaptureId = new AtomicInteger();
    private int mServiceType = -1;
    private SuperPlayerOption mPlayerOption = SuperPlayerOption.obtain();
    private final AtomicInteger mSwitchDefnId = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class TPPlayerListenerAdapter implements ListenerCombine.ITPPlayerCombine {
        private WrapperIdCaptureListener mCaptureListener;
        private SuperPlayerListenerCallBack mWrapperCallback;

        TPPlayerListenerAdapter(SuperPlayerListenerCallBack superPlayerListenerCallBack) {
            this.mWrapperCallback = superPlayerListenerCallBack;
        }

        private Object convertMsgObject(TPOnInfoParam tPOnInfoParam, Object obj, int i3) {
            if (tPOnInfoParam != null && (tPOnInfoParam.getObjParam() instanceof TPDataTransportMessageInfo)) {
                TPDataTransportMessageInfo tPDataTransportMessageInfo = (TPDataTransportMessageInfo) tPOnInfoParam.getObjParam();
                switch (i3) {
                    case 203:
                    case 206:
                        return tPDataTransportMessageInfo.obj1;
                    case 204:
                        TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
                        tPCDNURLInfo.url = (String) tPDataTransportMessageInfo.obj1;
                        Object obj2 = tPDataTransportMessageInfo.obj2;
                        tPCDNURLInfo.cdnIp = (String) obj2;
                        tPCDNURLInfo.uIp = (String) obj2;
                        return tPCDNURLInfo;
                    case 205:
                        TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
                        tPProtocolInfo.protocolName = (String) tPDataTransportMessageInfo.obj1;
                        tPProtocolInfo.protocolVersion = (String) tPDataTransportMessageInfo.obj2;
                        return tPProtocolInfo;
                    default:
                        return obj;
                }
            }
            return obj;
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioFrameOutListener
        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            this.mWrapperCallback.onAudioFrameOutput(tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onCompletion");
            SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(7);
            this.mWrapperCallback.onCompletion(SuperPlayerWrapper.this);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            int errorType = tPError.getErrorType();
            int errorCode = tPError.getErrorCode();
            String obj = tPError.getAllExtraParams().toString();
            LogUtil.e(SuperPlayerWrapper.this.mTAG, "inner listener called : onError, errorType:" + errorType + ", errorCode:" + errorCode + " , extraInfo:" + obj);
            if (SuperPlayerWrapper.this.mVideoInfo != null) {
                LogUtil.e(SuperPlayerWrapper.this.mTAG, "inner listener called : onError, source=" + SuperPlayerWrapper.this.mVideoInfo.getVideoSource() + ", url=" + SuperPlayerWrapper.this.mVideoInfo.getPlayUrl());
            }
            SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(9);
            this.mWrapperCallback.onError(SuperPlayerWrapper.this, 1, errorType, errorCode, obj);
        }

        @Override // com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener
        public void onGetVInfoFailed(SuperPlayerVideoInfo superPlayerVideoInfo, int i3, int i16, String str) {
            LogUtil.e(SuperPlayerWrapper.this.mTAG, "inner listener called : onGetVInfoFailed:" + i16 + Marker.ANY_NON_NULL_MARKER + str);
            if (SuperPlayerWrapper.this.mIsSwitchingTVideoDefn) {
                SuperPlayerWrapper.this.mIsSwitchingTVideoDefn = false;
                return;
            }
            SuperPlayerListenerCallBack superPlayerListenerCallBack = this.mWrapperCallback;
            if (superPlayerListenerCallBack != null) {
                superPlayerListenerCallBack.onError(SuperPlayerWrapper.this, 2, i3, i16, str);
            }
            SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(9);
        }

        @Override // com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener
        public void onGetVInfoSuccess(SuperPlayerVideoInfo superPlayerVideoInfo) {
            LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onGetVInfoSuccess:" + superPlayerVideoInfo);
            SuperPlayerVideoInfo superPlayerVideoInfo2 = SuperPlayerWrapper.this.mVideoInfo;
            if (superPlayerVideoInfo2 != null && superPlayerVideoInfo != null && SuperPlayerWrapper.this.mPlayState.getCurState() != 0 && SuperPlayerWrapper.this.mPlayState.getCurState() != 10 && SuperPlayerWrapper.this.mPlayState.getCurState() != 9) {
                if (SuperPlayerWrapper.this.mIsSwitchingTVideoDefn) {
                    try {
                        if (superPlayerVideoInfo.getFormat() == 303) {
                            ITPMediaAsset a16 = f.a(superPlayerVideoInfo, SuperPlayerWrapper.this.mPlayerOption.httpHeader);
                            if (a16 != null) {
                                SuperPlayerWrapper.this.mTPPlayer.switchDataSourceAsync(a16, SuperPlayerWrapper.this.mTVdieoSwitchDefnMode, SuperPlayerWrapper.this.mSwitchDefnId.getAndIncrement());
                            }
                        } else {
                            SuperPlayerWrapper superPlayerWrapper = SuperPlayerWrapper.this;
                            superPlayerVideoInfo.setMediaAssert(superPlayerWrapper.createMediaAsset(superPlayerVideoInfo, superPlayerWrapper.mPlayerOption));
                            SuperPlayerWrapper superPlayerWrapper2 = SuperPlayerWrapper.this;
                            SuperPlayerWrapper.this.mTPPlayer.switchDataSourceAsync(superPlayerWrapper2.getITPMediaAsset(superPlayerVideoInfo, superPlayerWrapper2.mPlayerOption), SuperPlayerWrapper.this.mTVdieoSwitchDefnMode, SuperPlayerWrapper.this.mSwitchDefnId.getAndIncrement());
                        }
                    } catch (IllegalStateException e16) {
                        LogUtil.e(SuperPlayerWrapper.this.mTAG, "onGetVInfoSuccess switchDefinition error ", e16);
                    }
                    SuperPlayerWrapper.this.mIsSwitchingTVideoDefn = false;
                    return;
                }
                if (TextUtils.equals(superPlayerVideoInfo.getVid(), superPlayerVideoInfo2.getVid()) && TextUtils.equals(superPlayerVideoInfo.getRequestDefinition(), superPlayerVideoInfo2.getRequestDefinition())) {
                    if (TextUtils.isEmpty(superPlayerVideoInfo.getPlayUrl()) && superPlayerVideoInfo.getTVideoSectionList() == null) {
                        SuperPlayerListenerCallBack superPlayerListenerCallBack = this.mWrapperCallback;
                        if (superPlayerListenerCallBack != null) {
                            superPlayerListenerCallBack.onError(SuperPlayerWrapper.this, 2, 5000, ErrorCode.ERROR_CODE_TVIDEO_URL_EMPTY, null);
                        }
                        SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(9);
                    } else {
                        SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(2);
                        SuperPlayerWrapper superPlayerWrapper3 = SuperPlayerWrapper.this;
                        superPlayerWrapper3.innerDoOpenMediaPlayer(superPlayerVideoInfo, superPlayerWrapper3.mPlayerOption);
                    }
                }
                if (this.mWrapperCallback != null && superPlayerVideoInfo.getTVideoNetInfo() != null) {
                    this.mWrapperCallback.onDefinitionInfoUpdate(SuperPlayerWrapper.this, superPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinitionStr(), superPlayerVideoInfo.getTVideoNetInfo().getDefinitionStrList());
                    this.mWrapperCallback.onTVideoNetInfoUpdate(SuperPlayerWrapper.this, superPlayerVideoInfo.getTVideoNetInfo());
                }
            }
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
            long j3;
            Object obj;
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            if (SuperPlayerWrapper.this.innerHandleInfo(i3, tPOnInfoParam)) {
                return;
            }
            long j16 = 0;
            if (tPOnInfoParam != null) {
                j3 = tPOnInfoParam.getLongParam1();
            } else {
                j3 = 0;
            }
            if (tPOnInfoParam != null) {
                j16 = tPOnInfoParam.getLongParam2();
            }
            long j17 = j16;
            if (tPOnInfoParam != null) {
                obj = tPOnInfoParam.getObjParam();
            } else {
                obj = "NULL";
            }
            int convert = SuperPlayerMsg.convert(i3, tPOnInfoParam);
            if (convert != 126 && convert != 205 && convert != 251 && convert != 203) {
                LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onInfo, what:" + convert + ", arg1:" + j3 + ", arg2:" + j17 + ", extraObject:" + obj);
            }
            this.mWrapperCallback.onInfo(SuperPlayerWrapper.this, convert, j3, j17, convertMsgObject(tPOnInfoParam, obj, convert));
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            MediaInfo mediaInfo;
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onPrepared");
            SuperPlayerWrapper.this.getMediaInfo();
            SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(4);
            if (SuperPlayerWrapper.this.mTPPlayer.getPlayerCoreType() != 1 && SuperPlayerWrapper.this.mPlayerOption.forceSystemPlayerForNoAudio && (mediaInfo = SuperPlayerWrapper.this.getMediaInfo()) != null && SuperPlayerWrapper.AUDIO_CODEC_ID_NONE.equals(mediaInfo.getAudioCodec())) {
                LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onPrepared, but check video no audio track, force reopen by system player");
                SuperPlayerWrapper.this.mPlayState.changeStateAndNotify(3);
                SuperPlayerWrapper.this.mTPPlayer.reopenPlayer(1, false);
                return;
            }
            this.mWrapperCallback.onVideoPrepared(SuperPlayerWrapper.this);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onSeekComplete");
            this.mWrapperCallback.onSeekComplete(SuperPlayerWrapper.this);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
            WrapperIdCaptureListener wrapperIdCaptureListener = this.mCaptureListener;
            if (wrapperIdCaptureListener != null) {
                wrapperIdCaptureListener.onError((int) j3, 0L, tPError);
            }
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            WrapperIdCaptureListener wrapperIdCaptureListener = this.mCaptureListener;
            if (wrapperIdCaptureListener != null) {
                wrapperIdCaptureListener.onSuccess((int) j3, j16, j16, tPVideoFrameBuffer);
            }
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSubtitleDataOutListener
        public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            this.mWrapperCallback.onSubtitleData(SuperPlayerWrapper.this, tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoFrameOutListener
        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            this.mWrapperCallback.onVideoFrameOutput(tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onVideoSizeChanged, width:" + i3 + ", height:" + i16);
            this.mWrapperCallback.onVideoSizeChanged(SuperPlayerWrapper.this, i3, i16);
        }

        void setCaptureListener(WrapperIdCaptureListener wrapperIdCaptureListener) {
            this.mCaptureListener = wrapperIdCaptureListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class WrapperIdCaptureListener implements ITPSnapshotor.ITPSnapshotorListener {
        private int mId;

        public WrapperIdCaptureListener(int i3) {
            this.mId = i3;
        }

        @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
        public void onError(int i3, long j3, @NonNull TPError tPError) {
            SuperPlayerWrapper.this.mListenerMgr.onCaptureImageFailed(SuperPlayerWrapper.this, this.mId, tPError.getErrorCode());
        }

        @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
        public void onSuccess(int i3, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            if (tPVideoFrameBuffer == null) {
                return;
            }
            Bitmap bitmap = tPVideoFrameBuffer.toBitmap();
            LogUtil.i(SuperPlayerWrapper.this.mTAG, "inner listener called : onCaptureVideoSuccess id:" + this.mId);
            SuperPlayerWrapper.this.mListenerMgr.onCaptureImageSucceed(SuperPlayerWrapper.this, this.mId, bitmap.getWidth(), bitmap.getHeight(), bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a extends TPMediaAsset {
        a() {
        }

        @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
        public int getAssetType() {
            return 0;
        }

        @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
        public boolean isValid() {
            return false;
        }
    }

    public SuperPlayerWrapper(Context context, int i3, String str, Looper looper, List<TPOptionalParam> list) throws TPLoadLibraryException {
        this.mSceneId = -1;
        this.mPlayerTag = str;
        this.mTAG = str + "-" + FILENAME;
        this.mContext = context.getApplicationContext();
        this.mSceneId = i3;
        this.mLooper = looper;
        this.mTPOptionalParamList = list;
        this.mMediaInfo = new MediaInfo(this.mTAG);
        this.mPlayerHandler = new Handler(looper);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void asyncInitMediaInfo() {
        ITPPlayer iTPPlayer;
        if (this.mPlayState.getCurState() != 4 && this.mPlayState.getCurState() != 5 && this.mPlayState.getCurState() != 6) {
            return;
        }
        MediaInfo mediaInfo = this.mMediaInfo;
        if ((mediaInfo == null || !mediaInfo.isInit()) && (iTPPlayer = this.mTPPlayer) != null) {
            MediaInfo obtainMediaInfoFromPlayer = MediaInfo.obtainMediaInfoFromPlayer(this.mPlayerTag, iTPPlayer);
            obtainMediaInfoFromPlayer.setDurationMs(this.mTPPlayer.getDurationMs());
            this.mMediaInfo = obtainMediaInfoFromPlayer;
            SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgr;
            if (superPlayerListenerMgr != null) {
                superPlayerListenerMgr.onInfo(this, 127, 0L, 0L, obtainMediaInfoFromPlayer);
            }
            LogUtil.e(getPlayerTag(), obtainMediaInfoFromPlayer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITPMediaAsset createMediaAsset(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        ITPMediaAsset iTPMediaAsset;
        ITPUrlMediaAsset iTPUrlMediaAsset = null;
        try {
        } catch (Exception e16) {
            LogUtil.e(this.mTAG, "createMediaAsset:" + e16.getMessage());
        }
        if (superPlayerVideoInfo.getFormat() == 303) {
            iTPMediaAsset = f.a(superPlayerVideoInfo, superPlayerOption.httpHeader);
        } else if (superPlayerVideoInfo.getFileDescriptor() != null) {
            iTPMediaAsset = TPMediaAssetFactory.createPfdMediaAsset(superPlayerVideoInfo.getFileDescriptor());
        } else if (superPlayerVideoInfo.getUri() != null) {
            iTPMediaAsset = TPMediaAssetFactory.createPfdMediaAsset(this.mContext.getContentResolver().openFileDescriptor(superPlayerVideoInfo.getUri(), "r"));
        } else {
            iTPUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(superPlayerVideoInfo.getPlayUrl());
            Map<String, String> map = superPlayerOption.httpHeader;
            if (map != null) {
                ((TPUrlMediaAsset) iTPUrlMediaAsset).setHttpHeader(map);
            }
            ArrayList<Map<String, String>> d16 = CommonUtil.d(superPlayerVideoInfo, superPlayerOption.httpHeader);
            if (superPlayerVideoInfo.getPlayUrls() != null && d16 != null) {
                String[] playUrls = superPlayerVideoInfo.getPlayUrls();
                for (int i3 = 0; i3 < playUrls.length && i3 < d16.size(); i3++) {
                    ((TPUrlMediaAsset) iTPUrlMediaAsset).addBackUrl(playUrls[i3], d16.get(i3));
                }
            }
            iTPMediaAsset = iTPUrlMediaAsset;
        }
        if (iTPMediaAsset == null) {
            iTPMediaAsset = new a();
            LogUtil.e(this.mTAG, "createMediaAsset error null,please check params");
        }
        superPlayerVideoInfo.setMediaAssert(iTPMediaAsset);
        return iTPMediaAsset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ITPMediaAsset getITPMediaAsset(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        ITPMediaAsset mediaAssert = superPlayerVideoInfo.getMediaAssert();
        if (mediaAssert == null) {
            mediaAssert = createMediaAsset(superPlayerVideoInfo, superPlayerOption);
        }
        mediaAssert.setParam("task_biz_id", String.valueOf(this.mServiceType));
        mediaAssert.setParam("dl_param_play_keyid", superPlayerVideoInfo.getFileId());
        innerInitDownloadParamData(superPlayerVideoInfo, superPlayerOption);
        innerConfigPlayerOption(superPlayerVideoInfo, superPlayerOption);
        return mediaAssert;
    }

    private void init() throws TPLoadLibraryException {
        TPPlayerConstructParams tPPlayerConstructParams = new TPPlayerConstructParams();
        List<TPOptionalParam> list = this.mTPOptionalParamList;
        if (list != null) {
            Iterator<TPOptionalParam> it = list.iterator();
            while (it.hasNext()) {
                tPPlayerConstructParams.addOptionalParam(it.next());
            }
        }
        Context context = this.mContext;
        Looper looper = this.mLooper;
        this.mTPPlayer = TPPlayerFactory.createTPPlayer(context, looper, looper, tPPlayerConstructParams);
        LogUtil.i(getPlayerTag(), "createTPPlayer target:" + this.mTPPlayer.getTPConext().getLogTag());
        this.mPlayState = new SuperPlayerState(this.mPlayerTag);
        SuperPlayerListenerMgr superPlayerListenerMgr = new SuperPlayerListenerMgr(this.mPlayerTag);
        this.mListenerMgr = superPlayerListenerMgr;
        SuperPlayerListenerCallBack superPlayerListenerCallBack = new SuperPlayerListenerCallBack(this, superPlayerListenerMgr, this.mLooper);
        this.mListenerCallback = superPlayerListenerCallBack;
        superPlayerListenerCallBack.setNotifyPreparedPlayMsgAhead(this.mPlayerOption.notifyPreparedPlayMsgAhead);
        this.mTPPlayerListenerAdapter = new TPPlayerListenerAdapter(this.mListenerCallback);
        int i3 = CommonUtil.i(this.mSceneId);
        this.mServiceType = i3;
        CommonUtil.j(i3);
        this.mTPPlayer.setOnPreparedListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnCompletionListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnInfoListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnErrorListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnSeekCompleteListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnVideoFrameOutListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnAudioFrameOutListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnSubtitleDataOutListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.setOnSnapshotListener(this.mTPPlayerListenerAdapter);
        this.mTPPlayer.addPlugin(new ITPPluginBase() { // from class: com.tencent.superplayer.player.SuperPlayerWrapper.1
            @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
            public void onEvent(int i16, int i17, int i18, String str, Object obj) {
                if (i16 == 102) {
                    if (obj instanceof Map) {
                        SuperPlayerWrapper.this.mFlowId = (String) ((Map) obj).get("flowid");
                        return;
                    }
                    return;
                }
                if (i16 == 101) {
                    LogUtil.d(SuperPlayerWrapper.this.mTAG, "\u65e5\u5fd7\u8fc7\u6ee4(Player): \u3010SuperPlayer-" + SuperPlayerWrapper.this.mPlayerTag + "|playId:" + i17 + "|player" + i17 + "\u3011 , " + SuperPlayerWrapper.this.mVideoInfo);
                }
            }

            @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
            public void onAttach() {
            }

            @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
            public void onDetach() {
            }
        });
        VInfoGetter vInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
        this.mVInfoGetter = vInfoGetter;
        vInfoGetter.setListener(this.mTPPlayerListenerAdapter);
    }

    private void innerConfigPlayerOption(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        if (!CommonUtil.k(superPlayerVideoInfo, superPlayerOption)) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_USE_DOWNLOAD_PROXY, false));
        }
        this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS, this.mStartPositionMilSec));
        if (this.mStartPositionMilSec > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_START_PLAYING_TIME_ACCURATE_SEEK, this.mPlayerOption.accurateSeekOnOpen));
        }
        this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_SKIP_END_TIME_MS, this.mSkipEndMilSec));
        if (this.mPlayerOption.enableVideoFrameOutput) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_VIDEO_FRAME_CALLBACK, true));
        }
        if (this.mPlayerOption.enableAudioFrameOutput) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_AUDIO_FRAME_CALLBACK, true));
            setAudioOutputParmasInternal(this.mPlayerOption.audioFrameOutputOption);
        }
        long j3 = superPlayerOption.bufferPacketMinTotalDurationMs;
        if (j3 > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFER_PACKET_TOTAL_DURATION_MS, j3));
        }
        long j16 = superPlayerOption.preloadPacketDurationMs;
        if (j16 > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_PREPARE_PACKET_TOTAL_DURATION_MS, j16));
        }
        long j17 = superPlayerOption.minBufferingPacketDurationMs;
        if (j17 > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_FOR_PLAYBACK_MS, j17));
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_RELEASE_MEDIACODEC_WHEN_SET_SURFACE, true));
        }
        long j18 = superPlayerOption.prepareTimeoutMs;
        if (j18 > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_PREPARE_TIMEOUT_MS, j18));
        }
        long j19 = superPlayerOption.bufferTimeoutMs;
        if (j19 > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_TIMEOUT_MS, j19));
        }
        if (superPlayerOption.enableDropFrameDetect) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_VIDEO_RENDER_MONITOR_PERIOD_MS, superPlayerOption.dropFrameDetectTimeMs));
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_VIDEO_HIGH_FRAME_DROP_RATE_THRESHOLD, superPlayerOption.minDropFrameRate));
        }
        if (superPlayerOption.enabledBluetoothLatencyOptimize) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_AUDIOTRACK_GET_LATENCY_STRATEGY, 3));
        }
        if (SuperPlayerSDKMgr.getSdkOption() != null && SuperPlayerSDKMgr.getSdkOption().enableErrorWhenThreadCreateFailed) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_ERROR_WHEN_THREAD_CREATE_FAILED, true));
        }
        this.mTPPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_VIDEO_ADAPTIVE_FRAMERATE, false));
        List<TPOptionalParam> list = this.mTPOptionalParamList;
        if (list != null) {
            Iterator<TPOptionalParam> it = list.iterator();
            while (it.hasNext()) {
                this.mTPPlayer.addOptionalParam(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerDoOpenMediaPlayer(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        boolean z16;
        String str = this.mTAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("api call : innerDoOpenMediaPlayer mSurface == null is ");
        if (this.mSurface == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        LogUtil.i(str, sb5.toString());
        try {
            superPlayerVideoInfo.setFileId(CommonUtil.a(superPlayerVideoInfo));
            ITPMediaAsset iTPMediaAsset = getITPMediaAsset(superPlayerVideoInfo, superPlayerOption);
            if (superPlayerOption.isPrePlay) {
                this.mTPPlayer.setIsActive(false);
            }
            this.mTPPlayer.setDataSource(iTPMediaAsset);
            LogUtil.e(this.mTAG, "innerDoOpenMediaPlayer:" + this.mTPPlayer.getTPConext().getLogTag());
            if (iTPMediaAsset instanceof TPUrlMediaAsset) {
                LogUtil.e(this.mTAG, this.mTPPlayer.getTPConext().getLogTag() + ",innerDoOpenMediaPlayer, nativeUrl:" + ((TPUrlMediaAsset) iTPMediaAsset).getSelfDevPlayerUrl());
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                this.mTPPlayer.setSurface(surface);
            }
            this.mTPPlayer.prepareAsync();
        } catch (Exception e16) {
            LogUtil.e(this.mTAG, "handleOpenMediaPlayerByUrl:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean innerHandleInfo(int i3, TPOnInfoParam tPOnInfoParam) {
        TPMediaCodecReadyInfo tPMediaCodecReadyInfo;
        if (i3 != 3) {
            if (i3 != 600) {
                if (i3 != 80001) {
                    if (i3 != 200) {
                        if (i3 == 201) {
                            this.mIsBuffering = false;
                        }
                    } else {
                        this.mIsBuffering = true;
                    }
                } else if (tPOnInfoParam.getObjParam() instanceof TPDownloadProgressInfo) {
                    this.mTotalFileSizeBytes = ((TPDownloadProgressInfo) tPOnInfoParam.getObjParam()).getFileTotalBytes();
                }
            } else {
                if (tPOnInfoParam.getObjParam() instanceof TPMediaCodecReadyInfo) {
                    tPMediaCodecReadyInfo = (TPMediaCodecReadyInfo) tPOnInfoParam.getObjParam();
                } else {
                    tPMediaCodecReadyInfo = null;
                }
                if (tPMediaCodecReadyInfo != null) {
                    LogUtil.i(this.mTAG, "innerHandleInfo mediaCodecInfo mediaType:" + tPMediaCodecReadyInfo.getMediaType() + " ,msg:" + tPMediaCodecReadyInfo.getMsg());
                }
            }
        } else if (tPOnInfoParam != null) {
            LogUtil.i(this.mTAG, "innerHandleInfo switchUrlSuccess:" + tPOnInfoParam.getLongParam1());
        }
        return false;
    }

    private void innerInitDownloadParamData(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        boolean z16;
        ITPMediaAsset mediaAssert = superPlayerVideoInfo.getMediaAssert();
        mediaAssert.setParam("task_file_type", String.valueOf(parseDownloadType(superPlayerVideoInfo, superPlayerOption)));
        mediaAssert.setParam("dl_param_save_path", superPlayerVideoInfo.getLocalSavePath());
        mediaAssert.setParam("dl_param_file_duration", String.valueOf(superPlayerVideoInfo.getVideoDurationMs()));
        if (SuperPlayerSDKMgr.hasDeviceId()) {
            mediaAssert.setParam("dl_param_vinfo_fp2p", String.valueOf(superPlayerOption.superPlayerDownOption.enableP2P ? 1 : 0));
        }
        mediaAssert.setParam("dl_param_play_flowid", UUID.randomUUID().toString() + System.nanoTime() + "_" + this.mServiceType);
        mediaAssert.setParam("dl_param_need_cache", "true");
        HashMap<String, String> extraDownloadParams = superPlayerVideoInfo.getExtraDownloadParams();
        if (extraDownloadParams != null) {
            for (Map.Entry<String, String> entry : extraDownloadParams.entrySet()) {
                mediaAssert.setParam(entry.getKey(), entry.getValue());
            }
        }
        mediaAssert.setParam("dl_param_quic_enable_mode", String.valueOf(superPlayerOption.superPlayerDownOption.quicEnableMode));
        mediaAssert.setParam("dl_param_is_enable_quic_plaintext", String.valueOf(superPlayerOption.superPlayerDownOption.enableQuicPlaintext));
        mediaAssert.setParam("dl_param_is_enable_quic_connection_migration", String.valueOf(superPlayerOption.superPlayerDownOption.enableQuicConnectionMigration));
        mediaAssert.setParam("dl_param_quic_congestion_type", String.valueOf(superPlayerOption.superPlayerDownOption.quicCongestionType));
        mediaAssert.setParam("dl_param_enable_teg_pcdn", String.valueOf(superPlayerOption.superPlayerDownOption.enablePcdn));
        mediaAssert.setParam(TPDownloadProxyEnum.DL_PARAM_ENABLE_PRELOAD_LIMIT, String.valueOf(superPlayerOption.superPlayerDownOption.enablePreloadLimitSpeed));
        long j3 = superPlayerOption.bufferPacketMinTotalDurationMs;
        if (j3 > 0 && superPlayerOption.enableListenerPlayerBuffer) {
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PLAYER_BUFFER_MINI_DURATION, String.valueOf(j3 / 1000));
        }
        if (!TextUtils.isEmpty(superPlayerOption.invalidContentType)) {
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PLAYER_INVALID_CONTENT_TYPE, superPlayerOption.invalidContentType);
        }
        if (!superPlayerOption.superPlayerDownOption.enableBandwidthStats && !com.tencent.superplayer.bandwidth.a.a(this.mSceneId)) {
            z16 = false;
        } else {
            z16 = true;
        }
        mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_BANDWIDTH_STATS_ENABLE, String.valueOf(z16));
        mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_BANDWIDTH_STATS_HOST, superPlayerOption.superPlayerDownOption.bandwidthReportHost);
        mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PCDN_FILE_MIN_BUFF_TIME, String.valueOf(superPlayerOption.superPlayerDownOption.pcdnMinBuffTime));
        mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PCDN_FILE_PROTECT_BUFF_TIME, String.valueOf(superPlayerOption.superPlayerDownOption.pcdnProtectBuffTime));
        mediaAssert.setParam("dl_param_pcdn_charge_id", superPlayerOption.superPlayerDownOption.pcdnChargeId);
        if (superPlayerOption.superPlayerDownOption.enableDownStrategyOnlyEffectSelf) {
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PLAYER_EMERGENCY_SAFE_TIME_EFFECT_SELF, String.valueOf(true));
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PLAYER_SELF_EMERGENCY_TIME, String.valueOf(superPlayerOption.superPlayerDownOption.emergencyTimeS));
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PLAYER_SELF_SAFE_TIME, String.valueOf(superPlayerOption.superPlayerDownOption.safeTimeS));
            mediaAssert.setParam(TPDownloadProxyEnum.DLPPARAM_PLAYER_SELF_EMERGENCY_TIME_FOR_PRE_PLAYER, String.valueOf(superPlayerOption.superPlayerDownOption.emergencyTimSForPrePlayer));
            mediaAssert.setParam(TPDownloadProxyEnum.DLPPARAM_PLAYER_SELF_SAFE_TIME_FOR_PRE_PLAYER, String.valueOf(superPlayerOption.superPlayerDownOption.safeTimeSForPrePlayer));
        }
        SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
        if (superPlayerDownOption.enablePreLoadPlayLimitData) {
            mediaAssert.setParam("dl_param_preload_duration", String.valueOf(superPlayerDownOption.emergencyTimSForPrePlayer));
        }
    }

    private void internalInitMediaInfo() {
        this.mPlayerHandler.post(new Runnable() { // from class: com.tencent.superplayer.player.SuperPlayerWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                SuperPlayerWrapper.this.asyncInitMediaInfo();
            }
        });
    }

    private void internalReset() {
        this.mMediaInfo = null;
        this.mIsLoopback = false;
        this.mIsOutputMute = false;
        this.mIsBuffering = false;
        this.mSkipEndMilSec = 0L;
        this.mStartPositionMilSec = 0L;
        this.mVideoInfo = null;
        this.mTPOptionalParamList = null;
        this.mPlayerOption = SuperPlayerOption.obtain();
    }

    private int parseDownloadType(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        if (superPlayerVideoInfo == null) {
            return 0;
        }
        int format = superPlayerVideoInfo.getFormat();
        if (format != 101) {
            if (format != 102) {
                if (format != 104 && format != 107) {
                    if (format != 201) {
                        if (format != 202) {
                            if (format != 401) {
                                if (format != 402) {
                                    switch (format) {
                                        case 301:
                                            break;
                                        case 302:
                                            break;
                                        case 303:
                                            return 2;
                                        default:
                                            return 0;
                                    }
                                }
                            }
                        }
                        SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
                        if (superPlayerDownOption.enableFlvPreloadMode) {
                            return 17;
                        }
                        if (superPlayerDownOption.enableXP2P) {
                            return 12;
                        }
                        return 16;
                    }
                    return 5;
                }
                return 10;
            }
            return 3;
        }
        return 1;
    }

    private void setAudioOutputParmasInternal(SuperPlayerAudioInfo superPlayerAudioInfo) {
        if (superPlayerAudioInfo == null) {
            return;
        }
        int audioSampleRateHZ = superPlayerAudioInfo.getAudioSampleRateHZ();
        if (audioSampleRateHZ > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_SAMPLE_RATE_HZ, audioSampleRateHZ));
        }
        int auidoOutPutFormat = superPlayerAudioInfo.getAuidoOutPutFormat();
        if (auidoOutPutFormat >= 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_SAMPLE_FORMAT, auidoOutPutFormat));
        }
        long audioChannelLayout = superPlayerAudioInfo.getAudioChannelLayout();
        if (audioChannelLayout > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_OUT_AUDIO_CHANNEL_LAYOUT, audioChannelLayout));
        }
        int audioSampleFrameSize = superPlayerAudioInfo.getAudioSampleFrameSize();
        if (audioSampleFrameSize > 0) {
            this.mTPPlayer.addOptionalParam(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_FRAME_SIZE_BYTE, audioSampleFrameSize));
        }
    }

    private void setReportInfo(int i3) {
        if (CommonUtil.l(i3)) {
            this.mReportInfo = new TPLiveReportInfo();
        } else {
            this.mReportInfo = new TPVodReportInfo();
        }
        this.mReportInfo.scenesId = this.mSceneId;
        this.mTPPlayer.getReportManager().setReportInfoGetter(this.mReportInfo);
        this.mTPPlayer.getReportManager().setReportSamplingRate(this.mPlayerOption.tpCoreSampleRate);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(String str, String str2) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addSubtitleSource(String str, String str2) {
        this.mTPPlayer.addSubtitleTrackSource(TPMediaAssetFactory.createUrlMediaAsset(str), str2);
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        if (this.mTPPlayer != null) {
            LogUtil.i(this.mTAG, "bindVideoPlayerInfo  " + obj);
            this.mTPPlayer.bindVideoPlayerInfo(obj);
            return;
        }
        LogUtil.i(this.mTAG, "bindVideoPlayerInfo  tpplayer is null");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16) {
        try {
            TPSnapshotParams tPSnapshotParams = new TPSnapshotParams();
            tPSnapshotParams.setWidth(i3);
            tPSnapshotParams.setHeight(i16);
            tPSnapshotParams.setRequestedPositionMsToleranceBefore(0L);
            tPSnapshotParams.setRequestedPositionMsToleranceAfter(0L);
            tPSnapshotParams.setPixelFormat(37);
            int incrementAndGet = this.mCaptureId.incrementAndGet();
            this.mTPPlayerListenerAdapter.setCaptureListener(new WrapperIdCaptureListener(incrementAndGet));
            this.mTPPlayer.snapshotAsync(tPSnapshotParams, incrementAndGet);
            return -1;
        } catch (Exception unused) {
            LogUtil.i(this.mTAG, "not support capture");
            return -1;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void deselectTrack(int i3, long j3) {
        this.mTPPlayer.deselectTrackAsync(i3, j3);
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public TVKNetVideoInfo getCurTVKNetVideoInfo() {
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getCurrentPlayerState() {
        return this.mPlayState.getCurState();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getCurrentPositionMs() {
        return this.mTPPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getDurationMs() {
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null && mediaInfo.getDurationMs() > 0) {
            return mediaInfo.getDurationMs();
        }
        return this.mTPPlayer.getDurationMs();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getFileSizeBytes() {
        return this.mTotalFileSizeBytes;
    }

    public String getFlowId() {
        return this.mFlowId;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public float getMaxVolumeGain() {
        return AudioTrack.getMaxVolume();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public MediaInfo getMediaInfo() {
        internalInitMediaInfo();
        return this.mMediaInfo;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public long getPlayableDurationMs() {
        return this.mTPPlayer.getAvailablePositionMs();
    }

    public String getPlayerTag() {
        return this.mPlayerTag;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.mTPPlayer.getProgramInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getProperty(String str) {
        return this.mTPPlayer.getProperty(str);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public ISPReportProvider getReportProvider() {
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getSceneId() {
        return this.mSceneId;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getStreamDumpInfo() {
        internalInitMediaInfo();
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null) {
            return mediaInfo.getMediaInfoStr();
        }
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public SuperPlayerVideoInfo getSuperVideoInfo() {
        return this.mVideoInfo;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public String getToken() {
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public TPTrackInfo[] getTrackInfo() {
        return this.mTPPlayer.getTrackInfo();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoHeight() {
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null && mediaInfo.getVideoHeight() > 0) {
            return mediaInfo.getVideoHeight();
        }
        return this.mTPPlayer.getHeight();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoRotation() {
        internalInitMediaInfo();
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null) {
            return mediaInfo.getVideoRotation();
        }
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    @Deprecated
    public ISPlayerVideoView getVideoView() {
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int getVideoWidth() {
        MediaInfo mediaInfo = this.mMediaInfo;
        if (mediaInfo != null && mediaInfo.getVideoWidth() > 0) {
            return mediaInfo.getVideoWidth();
        }
        return this.mTPPlayer.getWidth();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isBuffering() {
        return this.mIsBuffering;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isLoopBack() {
        return this.mIsLoopback;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isOutputMute() {
        return this.mIsOutputMute;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPausing() {
        if (this.mPlayState.getCurState() == 6) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public boolean isPlaying() {
        if (this.mPlayState.getCurState() == 5) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3) {
        openMediaPlayer(context, superPlayerVideoInfo, j3, SuperPlayerOption.obtain());
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pause() throws IllegalStateException {
        LogUtil.i(this.mTAG, "api call : pause");
        this.mTPPlayer.pause();
        this.mPlayState.changeStateAndNotify(6);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void pauseDownload() {
        this.mTPPlayer.pauseDownload();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void release() {
        LogUtil.i(this.mTAG, "api call : release");
        internalReset();
        this.mContext = null;
        this.mSurface = null;
        this.mLooper = null;
        this.mTPPlayer.release();
        this.mListenerMgr.release();
        this.mVInfoGetter.setListener(null);
        this.mPlayState.changeStateAndNotify(10);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void reset() throws IllegalStateException {
        LogUtil.i(this.mTAG, "api call : reset");
        internalReset();
        this.mTPPlayer.reset();
        this.mPlayState.changeStateAndNotify(0);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void resumeDownload() {
        this.mTPPlayer.resumeDownload();
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3) throws IllegalStateException {
        LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + i3);
        try {
            this.mTPPlayer.seekToAsync(i3);
        } catch (Exception e16) {
            LogUtil.e(this.mTAG, "api call : seekTo, positionMs:" + i3 + ", error = " + e16.toString());
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectProgram(int i3, long j3) {
        this.mTPPlayer.selectProgramAsync(i3, j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void selectTrack(int i3, long j3) {
        this.mTPPlayer.selectTrackAsync(i3, j3);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) {
        LogUtil.d(this.mTAG, "setBusinessDownloadStrategy: {" + i3 + ", " + i16 + ", " + i17 + ", " + i18 + "}");
        this.mTPPlayer.setBusinessDownloadStrategy(CommonUtil.i(this.mSceneId), i3, i16, i17, i18);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16) {
        LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + z16);
        this.mIsLoopback = z16;
        this.mTPPlayer.setLoopback(z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener onAudioFrameOutputListener) {
        LogUtil.i(this.mTAG, "api call : setOnAudioPcmOutputListener");
        this.mListenerMgr.setOnAudioFrameOutputListener(onAudioFrameOutputListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.mListenerMgr.setOnCaptureImageListener(onCaptureImageListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnCompletionListener(ISuperPlayer.OnCompletionListener onCompletionListener) {
        LogUtil.i(this.mTAG, "api call : setOnCompletionListener");
        this.mListenerMgr.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener onDefinitionInfoListener) {
        this.mListenerMgr.setOnDefinitionInfoListener(onDefinitionInfoListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnErrorListener(ISuperPlayer.OnErrorListener onErrorListener) {
        LogUtil.i(this.mTAG, "api call : setOnErrorListener");
        this.mListenerMgr.setOnErrorListener(onErrorListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnInfoListener(ISuperPlayer.OnInfoListener onInfoListener) {
        LogUtil.i(this.mTAG, "api call : setOnInfoListener");
        this.mListenerMgr.setOnInfoListener(onInfoListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        LogUtil.i(this.mTAG, "api call : setOnSeekCompleteListener");
        this.mListenerMgr.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        this.mListenerMgr.setOnSubtitleDataListener(onSubtitleDataListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnTVideoNetInfoUpdateListener(ISuperPlayer.OnTVideoNetInfoListener onTVideoNetInfoListener) {
        this.mListenerMgr.setOnTVideoNetVideoInfoListener(onTVideoNetInfoListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoFrameOutputListener(ISuperPlayer.OnVideoFrameOutputListener onVideoFrameOutputListener) {
        LogUtil.i(this.mTAG, "api call : setOnVideoFrameOutListener");
        this.mListenerMgr.setOnVideoOutputFrameListener(onVideoFrameOutputListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        LogUtil.i(this.mTAG, "api call : setOnPreparedListener");
        this.mListenerMgr.setOnVideoPreparedListener(onVideoPreparedListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        LogUtil.i(this.mTAG, "api call : setOnVideoSizeChangedListener");
        this.mListenerMgr.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setOutputMute(boolean z16) {
        LogUtil.i(this.mTAG, "api call : setOutputMute, isOutputMute:" + z16);
        this.mIsOutputMute = z16;
        this.mTPPlayer.setAudioMute(z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlaySpeedRatio(float f16) {
        LogUtil.i(this.mTAG, "api call : setPlaySpeedRatio, speedRatio:" + f16);
        this.mTPPlayer.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerActive() {
        SuperPlayerOption superPlayerOption = this.mPlayerOption;
        if (superPlayerOption != null && superPlayerOption.isPrePlay) {
            this.mTPPlayer.setIsActive(true);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        this.mTPOptionalParamList = list;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setReportContentId(String str) {
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfo;
        if (tPDefaultReportInfo != null) {
            tPDefaultReportInfo.vid = str;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setSurface(Surface surface) {
        boolean z16;
        String str = this.mTAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("api call : setSurface, surface = ");
        sb5.append(surface);
        sb5.append(", mSurface == surface is ");
        if (this.mSurface == surface) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        LogUtil.i(str, sb5.toString());
        this.mSurface = surface;
        ITPPlayer iTPPlayer = this.mTPPlayer;
        if (iTPPlayer != null) {
            iTPPlayer.setSurface(surface);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setVolumeGain(float f16) {
        this.mTPPlayer.setAudioVolume(f16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void start() throws IllegalStateException {
        LogUtil.i(this.mTAG, "api call : start");
        SuperPlayerOption superPlayerOption = this.mPlayerOption;
        if (superPlayerOption != null && superPlayerOption.isPrePlay) {
            this.mTPPlayer.setIsActive(true);
        }
        this.mTPPlayer.start();
        this.mPlayState.changeStateAndNotify(5);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void stop() throws IllegalStateException {
        LogUtil.i(this.mTAG, "api call : stop");
        if (this.mPlayState.getCurState() == 8) {
            LogUtil.e(this.mTAG, "api call : stop, failed, mPlayState.getCurState() == ISuperPlayerState.STOPPED");
        } else {
            this.mTPPlayer.stop();
            this.mPlayState.changeStateAndNotify(8);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinition(String str, int i3) {
        SuperPlayerVideoInfo superPlayerVideoInfo = this.mVideoInfo;
        if (superPlayerVideoInfo != null && superPlayerVideoInfo.getVideoSource() == 1) {
            if (this.mIsSwitchingTVideoDefn) {
                LogUtil.e(this.mTAG, "api call : switchDefinition error, is switching defn");
                return;
            }
            this.mIsSwitchingTVideoDefn = true;
            this.mTVdieoSwitchDefnMode = i3;
            this.mVideoInfo.setRequestDefinition(str);
            this.mVInfoGetter.doGetVInfo(this.mVideoInfo);
            return;
        }
        LogUtil.e(this.mTAG, "api call : switchDefinition error, videoInfo invalid");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void switchDefinitionForUrl(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoInfo.setPlayUrl(str);
            this.mVideoInfo.setMediaAssert(createMediaAsset(this.mVideoInfo, this.mPlayerOption));
            this.mVideoInfo.setFileId(TPMD5Util.getMd5(str));
            long andIncrement = this.mSwitchDefnId.getAndIncrement();
            this.mTPPlayer.switchDataSourceAsync(getITPMediaAsset(this.mVideoInfo, this.mPlayerOption), i3, andIncrement);
            LogUtil.d(this.mTAG, "switchDefinitionForUrl:" + str + "|" + i3 + "|" + andIncrement);
        }
    }

    public void updateIsPreloadingStatus(boolean z16) {
        if (z16) {
            this.mListenerCallback.setIsBlockCallback(true);
        } else {
            this.mListenerCallback.setIsBlockCallback(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePlayerTag(String str) {
        LogUtil.i(this.mTAG, "\u3010Important\u3011 updatePlayerTag from \u3010" + this.mPlayerTag + "\u3011 to \u3010" + str + "\u3011");
        this.mPlayerTag = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("-");
        sb5.append(FILENAME);
        this.mTAG = sb5.toString();
        this.mPlayState.updatePlayerTag(this.mPlayerTag);
        this.mListenerMgr.updatePlayerTag(this.mPlayerTag);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void addExtReportData(Map<String, String> map) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        this.mStartPositionMilSec = j3;
        this.mVideoInfo = superPlayerVideoInfo;
        this.mPlayerOption = superPlayerOption;
        setReportInfo(superPlayerVideoInfo.getFormat());
        int videoSource = superPlayerVideoInfo.getVideoSource();
        if (videoSource == 1) {
            this.mPlayState.changeStateAndNotify(1);
            this.mVInfoGetter.doGetVInfo(superPlayerVideoInfo);
        } else if (videoSource == 2) {
            this.mPlayState.changeStateAndNotify(2);
            innerDoOpenMediaPlayer(superPlayerVideoInfo, this.mPlayerOption);
        }
        if (superPlayerOption.superPlayerDownOption.enableP2P) {
            SuperPlayerSDKMgr.notifyEnterP2PScene(this.mSceneId);
        } else {
            if (SuperPlayerSDKMgr.isP2PActive()) {
                return;
            }
            SuperPlayerSDKMgr.notifyExitP2PScene(this.mSceneId);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void seekTo(int i3, int i16) {
        LogUtil.i(this.mTAG, "api call : seekTo, positionMs:" + i3 + ", mode:" + i16);
        try {
            this.mTPPlayer.seekToAsync(i3, i16);
        } catch (Exception e16) {
            LogUtil.e(this.mTAG, "api call : seekTo, positionMs:" + i3 + ", mode:" + i16 + ", error = " + e16.toString());
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        LogUtil.i(this.mTAG, "api call : setLoopback, isLoopback:" + z16 + ", loopStartPositionMs:" + j3 + ", loopEndPositionMs:" + j16);
        this.mIsLoopback = z16;
        this.mTPPlayer.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public int captureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) {
        try {
            TPSnapshotParams tPSnapshotParams = new TPSnapshotParams();
            tPSnapshotParams.setWidth(i3);
            tPSnapshotParams.setHeight(i16);
            tPSnapshotParams.setRequestedPositionMsToleranceBefore(i17);
            tPSnapshotParams.setRequestedPositionMsToleranceAfter(i18);
            tPSnapshotParams.setPixelFormat(37);
            int incrementAndGet = this.mCaptureId.incrementAndGet();
            this.mTPPlayerListenerAdapter.setCaptureListener(new WrapperIdCaptureListener(incrementAndGet));
            this.mTPPlayer.snapshotAsync(tPSnapshotParams, incrementAndGet);
            return incrementAndGet;
        } catch (Exception unused) {
            LogUtil.i(this.mTAG, "not support capture");
            return -1;
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    @Deprecated
    public void onPrePlayViewShow() {
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnPermissionTimeoutListener(ITVKOnPermissionTimeoutListener iTVKOnPermissionTimeoutListener) {
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void setOnTVKNetVideoInfoListener(ITVKOnNetVideoInfoListener iTVKOnNetVideoInfoListener) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    @Deprecated
    public void setXYaxis(int i3) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    public void updatePlayerSceneId(int i3) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer
    @Deprecated
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3, long j16) {
    }

    @Override // com.tencent.superplayer.tvkplayer.ITVKAbility
    public void openTVKPlayerByUrl(Context context, String str, String str2, long j3, long j16) {
    }
}
