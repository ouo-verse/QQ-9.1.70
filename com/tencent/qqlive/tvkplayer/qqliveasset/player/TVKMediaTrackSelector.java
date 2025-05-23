package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKTrackUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKAudioTrackExternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKSubtitleTrackExternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKMediaTrackSelector {
    private static final String MODULE_NAME = "TVKQQLiveAssetPlayer";

    @NonNull
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;
    private final ITVKLogger mLogger;

    public TVKMediaTrackSelector(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
    }

    private void addExternalMediaTrack() {
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo instanceof TVKSubtitleTrackExternal) {
                addSubtitleTrackToPlayerCore((TVKSubtitleTrackExternal) tVKTrackInfo);
            } else if (tVKTrackInfo instanceof TVKAudioTrackExternal) {
                addAudioTrackToPlayerCore((TVKAudioTrackExternal) tVKTrackInfo);
            }
        }
    }

    private void addSubtitleTrackToPlayerCore(TVKSubtitleTrackVinfo tVKSubtitleTrackVinfo) {
        List<String> urlList;
        TVKNetVideoInfo.SubTitle subTitle = tVKSubtitleTrackVinfo.getSubTitle();
        if (subTitle.isAvsSeparate() || (urlList = subTitle.getUrlList()) == null || urlList.isEmpty() || TextUtils.isEmpty(urlList.get(0))) {
            return;
        }
        ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(urlList.get(0));
        for (int i3 = 1; i3 < urlList.size(); i3++) {
            createUrlMediaAsset.addBackUrl(urlList.get(i3));
        }
        createUrlMediaAsset.setParam("dl_param_play_keyid", subTitle.getKeyId());
        createUrlMediaAsset.setParam("dl_param_is_offline", String.valueOf(tVKSubtitleTrackVinfo.isOffline()));
        int subtitleType = tVKSubtitleTrackVinfo.getSubTitle().getSubtitleType();
        if (subtitleType == 1) {
            createUrlMediaAsset.setParam("task_file_type", String.valueOf(14));
        } else if (subtitleType == 3) {
            createUrlMediaAsset.setParam("task_file_type", String.valueOf(15));
        }
        String m3u8 = subTitle.getM3u8();
        if (!TextUtils.isEmpty(m3u8)) {
            createUrlMediaAsset.setParam("dl_param_vinfo_m3u8", m3u8);
        }
        try {
            this.mAssetPlayerContext.getPlayer().addSubtitleTrackSource(createUrlMediaAsset, tVKSubtitleTrackVinfo.getTrackUniqueId());
        } catch (IllegalArgumentException | UnsupportedOperationException e16) {
            this.mLogger.printException(e16);
        }
    }

    private void selectAudioTrackAsync(@NonNull TVKTrackInfo tVKTrackInfo) {
        this.mLogger.info("selectAudioTrack start, trackName: " + tVKTrackInfo.getTrackName(), new Object[0]);
        if ((tVKTrackInfo instanceof TVKAudioTrackExternal) && TextUtils.isEmpty(((TVKAudioTrackExternal) tVKTrackInfo).getAudioTrackUrl())) {
            this.mLogger.warn("select audio track, but externally added audioTrackInfo url is null", new Object[0]);
            return;
        }
        if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
            TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo();
            if (audioTrackInfo == null) {
                this.mLogger.warn("select audio track, but vinfo return audioTrackInfo is null", new Object[0]);
                return;
            }
            if (TextUtils.isEmpty(audioTrackInfo.getAudioPlayUrl())) {
                this.mLogger.warn("select audio track, but vinfo return trackurl is null", new Object[0]);
                return;
            }
            int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, this.mAssetPlayerContext.getPlayer().getTrackInfo());
            if (trackIdByName == -1) {
                this.mLogger.warn("select audio track, but player track id -1, failed", new Object[0]);
                return;
            } else {
                this.mAssetPlayerContext.getPlayer().selectTrackAsync(trackIdByName, trackIdByName);
                return;
            }
        }
        this.mLogger.warn("select audio track, audio track type is unknown", new Object[0]);
    }

    private void selectSubtitleAsync(@NonNull TVKTrackInfo tVKTrackInfo) {
        this.mLogger.info("selectSubtitle start, trackName: " + tVKTrackInfo.getTrackName(), new Object[0]);
        int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, this.mAssetPlayerContext.getPlayer().getTrackInfo());
        if (trackIdByName == -1) {
            this.mLogger.warn("switch subtitle, but player track id -1, failed", new Object[0]);
        } else {
            this.mAssetPlayerContext.getPlayer().selectTrackAsync(trackIdByName, trackIdByName);
        }
    }

    public void addAudioTrackToPlayerCore(TVKTrackInfo tVKTrackInfo) {
        if (tVKTrackInfo instanceof TVKAudioTrackExternal) {
            addAudioTrackToPlayerCore((TVKAudioTrackExternal) tVKTrackInfo);
        } else if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
            addAudioTrackToPlayerCore((TVKAudioTrackVinfo) tVKTrackInfo);
        }
    }

    public void addMediaTrackFromVinfo() {
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo instanceof TVKSubtitleTrackVinfo) {
                addSubtitleTrackToPlayerCore((TVKSubtitleTrackVinfo) tVKTrackInfo);
            } else if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
                addAudioTrackToPlayerCore((TVKAudioTrackVinfo) tVKTrackInfo);
            }
        }
    }

    public void deselectSubtitleAsync(@NonNull TVKTrackInfo tVKTrackInfo) {
        TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
        int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, trackInfo);
        if (trackIdByName != -1 && trackInfo[trackIdByName].isSelected()) {
            this.mAssetPlayerContext.getPlayer().deselectTrackAsync(trackIdByName, trackIdByName);
        } else {
            this.mLogger.warn("deselectSubtitle, but no selected track in player", new Object[0]);
        }
    }

    public void processSelectStateOfAudioTrack(@NonNull TVKTrackInfo tVKTrackInfo) {
        if (tVKTrackInfo.isSelected() && (tVKTrackInfo instanceof TVKAudioTrackVinfo)) {
            TVKAudioTrackVinfo tVKAudioTrackVinfo = (TVKAudioTrackVinfo) tVKTrackInfo;
            if (tVKAudioTrackVinfo.getAudioTrackInfo().isAvsSeparate() || tVKAudioTrackVinfo.getAudioTrackInfo().getTrackType() == 1) {
                return;
            }
            selectAudioTrackAsync(tVKTrackInfo);
        }
    }

    public void processSelectStateOfMediaTrack() {
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo.getTrackType() == 3) {
                processSelectStateOfSubtitleTrack(tVKTrackInfo);
            } else if (tVKTrackInfo.getTrackType() == 2) {
                processSelectStateOfAudioTrack(tVKTrackInfo);
            }
        }
    }

    public void processSelectStateOfSubtitleTrack(@NonNull TVKTrackInfo tVKTrackInfo) {
        if (!tVKTrackInfo.isSelected()) {
            deselectSubtitleAsync(tVKTrackInfo);
        } else {
            if ((tVKTrackInfo instanceof TVKSubtitleTrackVinfo) && ((TVKSubtitleTrackVinfo) tVKTrackInfo).getSubTitle().isAvsSeparate()) {
                return;
            }
            selectSubtitleAsync(tVKTrackInfo);
        }
    }

    public void setupAllMediaTracks() {
        this.mLogger.info("setupAllMediaTracks start, trackInfoList size:" + this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList().size(), new Object[0]);
        addMediaTrackFromVinfo();
        addExternalMediaTrack();
        processSelectStateOfMediaTrack();
    }

    public void setupMediaTrackFromVinfo() {
        this.mLogger.info("setupMediaTrackFromVinfo start, trackInfoList size:" + this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList().size(), new Object[0]);
        addMediaTrackFromVinfo();
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo.isSelected()) {
                if (tVKTrackInfo.getTrackType() == 3) {
                    if (!(tVKTrackInfo instanceof TVKSubtitleTrackVinfo) || !((TVKSubtitleTrackVinfo) tVKTrackInfo).getSubTitle().isAvsSeparate()) {
                        selectSubtitleAsync(tVKTrackInfo);
                    }
                } else if (tVKTrackInfo.getTrackType() == 2) {
                    if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
                        TVKAudioTrackVinfo tVKAudioTrackVinfo = (TVKAudioTrackVinfo) tVKTrackInfo;
                        if (!tVKAudioTrackVinfo.getAudioTrackInfo().isAvsSeparate() && tVKAudioTrackVinfo.getAudioTrackInfo().getTrackType() != 1) {
                        }
                    }
                    selectAudioTrackAsync(tVKTrackInfo);
                }
            }
        }
    }

    private void addAudioTrackToPlayerCore(TVKAudioTrackVinfo tVKAudioTrackVinfo) {
        if (tVKAudioTrackVinfo.getAudioTrackInfo().isAvsSeparate() || 1 == tVKAudioTrackVinfo.getAudioTrackInfo().getTrackType() || TextUtils.isEmpty(tVKAudioTrackVinfo.getAudioTrackInfo().getAudioPlayUrl())) {
            return;
        }
        ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(tVKAudioTrackVinfo.getAudioTrackInfo().getAudioPlayUrl());
        createUrlMediaAsset.setParam("dl_param_play_keyid", tVKAudioTrackVinfo.getAudioTrackInfo().getKeyId());
        createUrlMediaAsset.setParam("task_file_type", String.valueOf(3));
        createUrlMediaAsset.setParam("dl_param_is_offline", String.valueOf(tVKAudioTrackVinfo.isOffline()));
        String m3u8 = tVKAudioTrackVinfo.getAudioTrackInfo().getM3u8();
        if (!TextUtils.isEmpty(m3u8)) {
            createUrlMediaAsset.setParam("dl_param_vinfo_m3u8", m3u8);
        }
        try {
            this.mAssetPlayerContext.getPlayer().addAudioTrackSource(createUrlMediaAsset, tVKAudioTrackVinfo.getTrackUniqueId());
        } catch (IllegalArgumentException | UnsupportedOperationException e16) {
            this.mLogger.printException(e16);
        }
    }

    private void addAudioTrackToPlayerCore(TVKAudioTrackExternal tVKAudioTrackExternal) {
        if (TextUtils.isEmpty(tVKAudioTrackExternal.getAudioTrackUrl())) {
            return;
        }
        ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(tVKAudioTrackExternal.getAudioTrackUrl());
        createUrlMediaAsset.setParam("dl_param_play_keyid", tVKAudioTrackExternal.getTrackUniqueId());
        this.mAssetPlayerContext.getPlayer().addAudioTrackSource(createUrlMediaAsset, tVKAudioTrackExternal.getTrackUniqueId());
    }

    private void addSubtitleTrackToPlayerCore(TVKSubtitleTrackExternal tVKSubtitleTrackExternal) {
        if (TextUtils.isEmpty(tVKSubtitleTrackExternal.getSubTitleUrl())) {
            return;
        }
        ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(tVKSubtitleTrackExternal.getSubTitleUrl());
        createUrlMediaAsset.setParam("dl_param_play_keyid", tVKSubtitleTrackExternal.getTrackUniqueId());
        try {
            this.mAssetPlayerContext.getPlayer().addSubtitleTrackSource(createUrlMediaAsset, tVKSubtitleTrackExternal.getTrackUniqueId());
        } catch (IllegalArgumentException | UnsupportedOperationException e16) {
            this.mLogger.printException(e16);
        }
    }
}
