package com.tencent.qqlive.tvkplayer.qqliveasset.common;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDrmTypeUtil;

/* loaded from: classes23.dex */
public class TVKBasicPlayInfoCollector {
    private static final String PLAY_INFO_KEY_DRM_TYPE = "\"DRM type\"";
    private static final String PLAY_INFO_KEY_ERROR_CODE = "\"error code\"";
    private static final String PLAY_INFO_KEY_FLOW_ID = "\"flow ID\"";
    private static final String PLAY_INFO_KEY_FMT = "\"format\"";
    private static final String PLAY_INFO_KEY_GUID = "\"GUID\"";
    private static final String PLAY_INFO_KEY_QIMEI36 = "\"QiMei36\"";
    private static final char PLAY_INFO_KEY_TO_VALUE_DELIMITER = '=';
    private static final String PLAY_INFO_KEY_VID = "\"VID\"";
    private static final String PLAY_INFO_KEY_VUID = "\"VUID\"";
    private static final String PLAY_INFO_KV_QUOTATION_MARK = "\"";
    private static final char PLAY_INFO_KV_TO_KV_DELIMITER = '&';
    private static final String TAG_BASIC_INFORMATION = "[TVKBasicInfo]";

    @Nullable
    private TVKError mError;

    @Nullable
    private String mFlowID;

    @Nullable
    private TVKNetVideoInfo mNetVideoInfo;

    @Nullable
    private TVKUserInfo mUserInfo;

    private void appendCommonInfoToKeyContent(@NonNull StringBuilder sb5) {
        appendKvToKeyContent(sb5, PLAY_INFO_KEY_FLOW_ID, this.mFlowID);
    }

    private void appendErrorInfoToKeyContent(@NonNull StringBuilder sb5) {
        TVKError tVKError = this.mError;
        if (tVKError == null) {
            return;
        }
        appendKvToKeyContent(sb5, PLAY_INFO_KEY_ERROR_CODE, tVKError.getFullErrorCode());
    }

    private void appendKvToKeyContent(@NonNull StringBuilder sb5, @NonNull String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb5.append(str);
        sb5.append(PLAY_INFO_KEY_TO_VALUE_DELIMITER);
        sb5.append(PLAY_INFO_KV_QUOTATION_MARK);
        sb5.append(str2);
        sb5.append(PLAY_INFO_KV_QUOTATION_MARK);
        sb5.append('&');
    }

    private void appendNetVideoInfoToKeyContent(@NonNull StringBuilder sb5) {
        TVKNetVideoInfo tVKNetVideoInfo = this.mNetVideoInfo;
        if (tVKNetVideoInfo == null) {
            return;
        }
        appendKvToKeyContent(sb5, PLAY_INFO_KEY_VID, tVKNetVideoInfo.getVid());
        TVKNetVideoInfo.DefnInfo curDefinition = tVKNetVideoInfo.getCurDefinition();
        if (curDefinition != null) {
            appendKvToKeyContent(sb5, PLAY_INFO_KEY_FMT, String.valueOf(curDefinition.getDefnId()));
            appendKvToKeyContent(sb5, PLAY_INFO_KEY_DRM_TYPE, TVKDrmTypeUtil.drmTypeToName(curDefinition.getDrm()));
        }
    }

    private void appendUserInfoToKeyContent(@NonNull StringBuilder sb5) {
        appendKvToKeyContent(sb5, PLAY_INFO_KEY_QIMEI36, TVKCommParams.getQimei36());
        appendKvToKeyContent(sb5, PLAY_INFO_KEY_GUID, TVKCommParams.getStaGuid());
        TVKUserInfo tVKUserInfo = this.mUserInfo;
        if (tVKUserInfo == null) {
            return;
        }
        appendKvToKeyContent(sb5, PLAY_INFO_KEY_VUID, tVKUserInfo.getVUserId());
    }

    public void reset() {
        this.mFlowID = null;
        this.mError = null;
        this.mNetVideoInfo = null;
        this.mUserInfo = null;
    }

    public void setError(@NonNull TVKError tVKError) {
        this.mError = tVKError;
    }

    public void setFlowID(@NonNull String str) {
        this.mFlowID = str;
    }

    public void setNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        this.mNetVideoInfo = tVKNetVideoInfo;
    }

    public void setUserInfo(@NonNull TVKUserInfo tVKUserInfo) {
        this.mUserInfo = tVKUserInfo;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        appendNetVideoInfoToKeyContent(sb5);
        appendUserInfoToKeyContent(sb5);
        appendErrorInfoToKeyContent(sb5);
        appendCommonInfoToKeyContent(sb5);
        return TAG_BASIC_INFORMATION + sb5.toString();
    }
}
