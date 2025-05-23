package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes23.dex */
public class TVKVodInfoPlayUrlBuilder {
    private static final int BUILD_BACK_PLAY_URL_MIN_SIZE = 2;
    private static final String TAG = "TVKPlayer[TVKVodInfoPlayUrlBuilder]";

    private static void buildBakPlayUrl(@NonNull TVKVodVideoInfo tVKVodVideoInfo) {
        int size = tVKVodVideoInfo.getCdnUrlList().size();
        if (size < 2) {
            tVKVodVideoInfo.setBakPlayUrl(new String[0]);
            return;
        }
        String[] strArr = new String[size - 1];
        for (int i3 = 1; i3 < size; i3++) {
            strArr[i3 - 1] = tVKVodVideoInfo.getCdnUrlList().get(i3);
        }
        tVKVodVideoInfo.setBakPlayUrl(strArr);
    }

    public static void buildCdnUrl(TVKVodVideoInfo tVKVodVideoInfo, String str) {
        if (tVKVodVideoInfo != null && tVKVodVideoInfo.getUrlList().size() != 0) {
            if (tVKVodVideoInfo.getDownloadType() == 1) {
                buildMp4CdnUrl(tVKVodVideoInfo, str);
                return;
            } else if (tVKVodVideoInfo.getDownloadType() == 4) {
                buildClipMp4CdnUrl(tVKVodVideoInfo, str);
                return;
            } else {
                buildHlsCdnUrl(tVKVodVideoInfo, str);
                return;
            }
        }
        TVKLogUtil.e(TAG, "buildCdnUrl, videoInfo is null or url size is 0");
    }

    private static void buildClipMp4CdnUrl(@NonNull TVKVodVideoInfo tVKVodVideoInfo, String str) {
        boolean z16;
        if (tVKVodVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_DL_PROXY) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (TVKVodVideoInfo.Section section : tVKVodVideoInfo.getSectionList()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < tVKVodVideoInfo.getUrlList().size(); i3++) {
                String url = tVKVodVideoInfo.getUrlList().get(i3).getUrl();
                if (!z16) {
                    String url2 = section.getUrl();
                    if (!tVKVodVideoInfo.isFreeNetFlowUrl()) {
                        url = generateMp4url(tVKVodVideoInfo, url + generateClipMp4Filename(tVKVodVideoInfo.getFileName(), section.getIdx()), section.getVbkey(), str).replaceAll(ContainerUtils.FIELD_DELIMITER, "&amp;");
                    } else {
                        url = url2;
                    }
                }
                if (i3 == 0) {
                    section.setUrl(url);
                }
                arrayList.add(url);
            }
            section.setUrlList(arrayList);
        }
        if (tVKVodVideoInfo.getSectionList().size() > 0) {
            tVKVodVideoInfo.setPlayUrl(tVKVodVideoInfo.getSectionList().get(0).getUrl());
        } else {
            tVKVodVideoInfo.setPlayUrl("");
        }
    }

    private static void buildHlsCdnUrl(@NonNull TVKVodVideoInfo tVKVodVideoInfo, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str2 = "";
        if (tVKVodVideoInfo.getMasterM3u8Info() != null) {
            if (!TextUtils.isEmpty(tVKVodVideoInfo.getMasterM3u8Info().getM3u8Url())) {
                str2 = tVKVodVideoInfo.getMasterM3u8Info().getM3u8Url();
            } else if (!tVKVodVideoInfo.getUrlList().isEmpty()) {
                str2 = generateHlsCdnUrl(tVKVodVideoInfo, tVKVodVideoInfo.getUrlList().get(0), str);
            }
            arrayList.add(str2);
        } else {
            Iterator<TVKVodVideoInfo.ReferUrl> it = tVKVodVideoInfo.getUrlList().iterator();
            while (it.hasNext()) {
                arrayList.add(generateHlsCdnUrl(tVKVodVideoInfo, it.next(), str));
            }
            if (!arrayList.isEmpty()) {
                str2 = arrayList.get(0);
            }
        }
        tVKVodVideoInfo.setPlayUrl(str2);
        tVKVodVideoInfo.setCdnUrlList(arrayList);
        buildBakPlayUrl(tVKVodVideoInfo);
    }

    private static void buildMp4CdnUrl(@NonNull TVKVodVideoInfo tVKVodVideoInfo, String str) {
        String str2;
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<TVKVodVideoInfo.ReferUrl> it = tVKVodVideoInfo.getUrlList().iterator();
        while (it.hasNext()) {
            TVKVodVideoInfo.ReferUrl next = it.next();
            if (next != null) {
                str2 = next.getUrl();
                if (!tVKVodVideoInfo.isFreeNetFlowUrl()) {
                    str2 = generateMp4url(tVKVodVideoInfo, next.getUrl() + tVKVodVideoInfo.getFileName(), tVKVodVideoInfo.getVKey(), str);
                }
            } else {
                str2 = "";
            }
            arrayList.add(str2);
        }
        tVKVodVideoInfo.setPlayUrl(arrayList.get(0));
        tVKVodVideoInfo.setCdnUrlList(arrayList);
        buildBakPlayUrl(tVKVodVideoInfo);
    }

    private static String generateClipMp4Filename(String str, int i3) {
        int lastIndexOf = str.lastIndexOf(".");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, lastIndexOf + 1));
        stringBuffer.append(i3);
        stringBuffer.append(str.substring(lastIndexOf));
        return stringBuffer.toString();
    }

    private static String generateHlsCdnUrl(@NonNull TVKVodVideoInfo tVKVodVideoInfo, TVKVodVideoInfo.ReferUrl referUrl, String str) {
        if (referUrl == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(referUrl.getUrl());
        if (!tVKVodVideoInfo.isFreeNetFlowUrl() && 8 != tVKVodVideoInfo.getDownloadType()) {
            stringBuffer.append(referUrl.getPt());
            stringBuffer.append("&sdtfrom=");
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        return stringBuffer.toString();
    }

    private static String generateMp4url(@NonNull TVKVodVideoInfo tVKVodVideoInfo, String str, String str2, String str3) {
        String defn;
        if (tVKVodVideoInfo.getCurDefinition() == null) {
            defn = "";
        } else {
            defn = tVKVodVideoInfo.getCurDefinition().getDefn();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?vkey=");
        stringBuffer.append(str2);
        stringBuffer.append("&br=");
        stringBuffer.append(tVKVodVideoInfo.getBitrate());
        stringBuffer.append("&fmt=");
        stringBuffer.append(defn);
        stringBuffer.append("&sdtfrom=");
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }
}
