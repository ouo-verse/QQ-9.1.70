package com.tencent.qqlive.tvkplayer.qqliveasset.common;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKAudioTrackExternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKSubtitleTrackExternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKTrackUtils {
    public static final int INVALID_TRACK_ID = -1;

    private static int convertToTPMediaTrack(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    return -1;
                }
            }
            return i16;
        }
        return 0;
    }

    public static void deselectTrackByName(String str, int i3, List<TVKTrackInfo> list) {
        for (TVKTrackInfo tVKTrackInfo : list) {
            if (tVKTrackInfo.getTrackType() == i3 && TextUtils.equals(tVKTrackInfo.getTrackName(), str)) {
                tVKTrackInfo.setSelected(false);
            }
        }
    }

    @Nullable
    public static TVKNetVideoInfo.AudioTrackInfo getAudioTrackFromTrackInfo(String str, @Nullable TVKTrackInfo[] tVKTrackInfoArr) {
        if (tVKTrackInfoArr != null && !TextUtils.isEmpty(str)) {
            for (TVKTrackInfo tVKTrackInfo : tVKTrackInfoArr) {
                if (tVKTrackInfo.getTrackType() == 2 && TextUtils.equals(str, tVKTrackInfo.getTrackName())) {
                    if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
                        return ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo();
                    }
                    if (tVKTrackInfo instanceof TVKAudioTrackExternal) {
                        TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = new TVKNetVideoInfo.AudioTrackInfo();
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(((TVKAudioTrackExternal) tVKTrackInfo).getAudioTrackUrl());
                        audioTrackInfo.setAudioTrack(str);
                        audioTrackInfo.setAudioUrlList(arrayList);
                        return audioTrackInfo;
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public static TVKNetVideoInfo.SubTitle getSubtitleFromTrackInfos(String str, @Nullable TVKTrackInfo[] tVKTrackInfoArr) {
        if (tVKTrackInfoArr != null && !TextUtils.isEmpty(str)) {
            for (TVKTrackInfo tVKTrackInfo : tVKTrackInfoArr) {
                if (tVKTrackInfo.getTrackType() == 3 && TextUtils.equals(str, tVKTrackInfo.getTrackName())) {
                    if (tVKTrackInfo instanceof TVKSubtitleTrackVinfo) {
                        return ((TVKSubtitleTrackVinfo) tVKTrackInfo).getSubTitle();
                    }
                    if (tVKTrackInfo instanceof TVKSubtitleTrackExternal) {
                        TVKNetVideoInfo.SubTitle subTitle = new TVKNetVideoInfo.SubTitle();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(((TVKSubtitleTrackExternal) tVKTrackInfo).getSubTitleUrl());
                        subTitle.setName(str);
                        subTitle.setUrlList(arrayList);
                        return subTitle;
                    }
                }
            }
        }
        return null;
    }

    public static int getTrackIdByName(@NonNull TVKTrackInfo tVKTrackInfo, TPTrackInfo[] tPTrackInfoArr) {
        if (tPTrackInfoArr != null && tPTrackInfoArr.length != 0) {
            for (int i3 = 0; i3 < tPTrackInfoArr.length; i3++) {
                TPTrackInfo tPTrackInfo = tPTrackInfoArr[i3];
                if (!isIllegalTrack(convertToTPMediaTrack(tVKTrackInfo.getTrackType()), tPTrackInfo)) {
                    if (TextUtils.equals(tPTrackInfo.getName(), tVKTrackInfo.getTrackUniqueId())) {
                        return i3;
                    }
                    if (isInternalAudioTrack(tVKTrackInfo) && tPTrackInfo.getMediaType() == 1 && tPTrackInfo.isInternal()) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isAudioTrackWithUrl(TVKNetVideoInfo.AudioTrackInfo audioTrackInfo) {
        if (audioTrackInfo != null && !TextUtils.isEmpty(audioTrackInfo.getAudioPlayUrl())) {
            return true;
        }
        return false;
    }

    public static boolean isAvsSeparateTrack(TVKTrackInfo tVKTrackInfo) {
        TVKNetVideoInfo.SubTitle subTitle;
        if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
            TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo();
            if (audioTrackInfo == null) {
                return false;
            }
            return audioTrackInfo.isAvsSeparate();
        }
        if (!(tVKTrackInfo instanceof TVKSubtitleTrackVinfo) || (subTitle = ((TVKSubtitleTrackVinfo) tVKTrackInfo).getSubTitle()) == null) {
            return false;
        }
        return subTitle.isAvsSeparate();
    }

    private static boolean isIllegalTrack(int i3, TPTrackInfo tPTrackInfo) {
        if (tPTrackInfo == null || tPTrackInfo.getName() == null || tPTrackInfo.getMediaType() != i3) {
            return true;
        }
        return false;
    }

    public static boolean isInternalAudioTrack(TVKTrackInfo tVKTrackInfo) {
        if ((tVKTrackInfo instanceof TVKAudioTrackVinfo) && 1 == ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo().getTrackType()) {
            return true;
        }
        return false;
    }

    public static void selectTrackByName(String str, int i3, List<TVKTrackInfo> list) {
        for (TVKTrackInfo tVKTrackInfo : list) {
            if (tVKTrackInfo.getTrackType() == i3 && TextUtils.equals(tVKTrackInfo.getTrackName(), str)) {
                tVKTrackInfo.setSelected(true);
            }
        }
    }
}
