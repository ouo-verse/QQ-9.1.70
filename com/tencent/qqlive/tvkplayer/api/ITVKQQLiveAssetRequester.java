package com.tencent.qqlive.tvkplayer.api;

import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKQQLiveAssetRequester {
    public static final int LIVE_MEDIA_PLAY_ERROR_AUTH_FAILED_INPAY = 23;
    public static final int LIVE_MEDIA_PLAY_ERROR_CKEY = 32;
    public static final int LIVE_MEDIA_PLAY_ERROR_LOGIN_INFO_VERIFY_FAILED = 28;
    public static final int LIVE_MEDIA_PLAY_ERROR_LOST_LOGIN_INFO = 25;
    public static final int LIVE_MEDIA_PLAY_ERROR_NO_LOGIN = 31;
    public static final int LIVE_MEDIA_PLAY_ERROR_NO_PAY = 30;
    public static final int LIVE_MEDIA_PLAY_ERROR_TRY_LOOK_CALCULATE_FAILED = 47;
    public static final int LIVE_MEDIA_PLAY_ERROR_TRY_WATCH_CHANCE_USED = 45;
    public static final int LIVE_MEDIA_PLAY_ERROR_WEIXIN_VERIFY_FAILED = 48;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ExtraVideoInfo {
        public String[] mBackPlayUrlList;
        public ArrayList<String> mReferUrlList;
        public ArrayList<Integer> mVtList;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKQQLiveAssetListener {
        void onFailure(int i3, TVKError tVKError);

        void onSuccess(int i3, String str, ExtraVideoInfo extraVideoInfo, TVKNetVideoInfo tVKNetVideoInfo);
    }

    int inquireLiveInfo(TVKUserInfo tVKUserInfo, String str, String str2, Map<String, String> map) throws IllegalArgumentException, IllegalAccessException;

    int request(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, int i3) throws IllegalArgumentException, IllegalAccessException;

    int requestForDlna(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, int i3) throws IllegalArgumentException, IllegalAccessException;

    void setQQLiveAssetListener(ITVKQQLiveAssetListener iTVKQQLiveAssetListener);
}
