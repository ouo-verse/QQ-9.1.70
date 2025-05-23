package com.tencent.thumbplayer.core.downloadproxy.api;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPDownloadParam {
    private static final String FILE_NAME = "TPDownloadParam";
    private int dlType;
    private ArrayList<String> urlList = new ArrayList<>();
    private Map<String, Object> extInfoMap = new HashMap();

    public TPDownloadParam(ArrayList<String> arrayList, int i3, Map<String, Object> map) {
        this.dlType = i3;
        setUrlList(arrayList);
        setExtInfoMap(map);
    }

    private String getExtraFormatNodesJsonInfo(ArrayList<Map<String, Object>> arrayList) {
        if (arrayList == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Map<String, Object> map = arrayList.get(i3);
                if (i3 == arrayList.size() - 1) {
                    stringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", map.get(TPDataTransportTaskParam.TASK_PARAM_FORMAT_NODES_KEY_NAME), map.get(TPDataTransportTaskParam.TASK_PARAM_FORMAT_NODES_KEY_BITRATE_PBS)));
                } else {
                    stringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", map.get(TPDataTransportTaskParam.TASK_PARAM_FORMAT_NODES_KEY_NAME), map.get(TPDataTransportTaskParam.TASK_PARAM_FORMAT_NODES_KEY_BITRATE_PBS)));
                }
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getExtraJsonInfo failed, error:" + th5);
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    private String getUrlHostNodesJsonInfo(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = arrayList.get(i3);
                if (i3 == arrayList.size() - 1) {
                    stringBuffer.append(String.format("\"%s\"", str));
                } else {
                    stringBuffer.append(String.format("\"%s\", ", str));
                }
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getArrayListStr failed, error:" + th5);
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public String buildFileId(String str, long j3) {
        StringBuilder sb5 = new StringBuilder(str);
        if (!isDownloadDataReusable()) {
            sb5.append(".");
            sb5.append(j3);
        }
        return sb5.toString();
    }

    public String buildKeyId(String str, long j3) {
        StringBuilder sb5 = new StringBuilder(getKeyid());
        if (sb5.length() == 0) {
            sb5.append(str);
        }
        if (!isDownloadDataReusable()) {
            sb5.append(".");
            sb5.append(j3);
        }
        return sb5.toString();
    }

    public int getBizId(int i3) {
        return TPDLProxyUtils.getMapIntValue(this.extInfoMap, "task_biz_id", i3);
    }

    public String getCdnUrls() {
        boolean z16;
        if (this.urlList == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Map<String, Object> map = this.extInfoMap;
        if (map != null && map.containsKey("dl_param_enable_expand_download_url")) {
            z16 = ((Boolean) this.extInfoMap.get("dl_param_enable_expand_download_url")).booleanValue();
        } else {
            z16 = false;
        }
        for (int i3 = 0; i3 < this.urlList.size(); i3++) {
            sb5.append(this.urlList.get(i3));
            if (z16) {
                if (this.urlList.get(i3).indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
                    sb5.append("&cost=low");
                } else {
                    sb5.append("?cost=low");
                }
            }
            sb5.append(";");
        }
        if (sb5.length() > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    public int getClipCount() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_play_clip_count")) {
            return 1;
        }
        return ((Integer) this.extInfoMap.get("dl_param_play_clip_count")).intValue();
    }

    public String getClipFileId() {
        return TPDLProxyUtils.getMapStringValue(this.extInfoMap, "dl_param_play_clip_keyid", "");
    }

    public int getClipNo() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_play_clip_no")) {
            return 1;
        }
        return ((Integer) this.extInfoMap.get("dl_param_play_clip_no")).intValue();
    }

    public int getDlType() {
        return this.dlType;
    }

    public Object getExtInfo(String str) {
        Map<String, Object> map = this.extInfoMap;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, Object> getExtInfoMap() {
        return this.extInfoMap;
    }

    public String getExtraJsonInfo() {
        Map<String, Object> map = this.extInfoMap;
        if (map != null && !map.isEmpty()) {
            try {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, Object> entry : this.extInfoMap.entrySet()) {
                    if (!entry.getKey().equalsIgnoreCase("dl_param_is_offline") && !entry.getKey().equalsIgnoreCase("dl_param_play_extra_info") && !entry.getKey().equalsIgnoreCase("dl_param_enable_expand_download_url")) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return new JSONObject(hashMap).toString();
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getExtraJsonInfo failed, error:" + th5);
            }
        }
        return "";
    }

    public String getFormat() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_current_format")) {
            return "";
        }
        return (String) this.extInfoMap.get("dl_param_current_format");
    }

    public String getKeyid() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_play_keyid")) {
            return "";
        }
        return (String) this.extInfoMap.get("dl_param_play_keyid");
    }

    public Map<String, String> getOfflinePlayExtraInfo() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_play_extra_info")) {
            return null;
        }
        return (Map) this.extInfoMap.get("dl_param_play_extra_info");
    }

    public String getPlayDefinition() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_play_definition")) {
            return "";
        }
        return (String) this.extInfoMap.get("dl_param_play_definition");
    }

    public String getSavaPath() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_save_path")) {
            return "";
        }
        return (String) this.extInfoMap.get("dl_param_save_path");
    }

    public long getTotalDurationMS() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_file_duration")) {
            return 0L;
        }
        return ((Long) this.extInfoMap.get("dl_param_file_duration")).longValue();
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public String getVid() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_vid")) {
            return "";
        }
        return (String) this.extInfoMap.get("dl_param_vid");
    }

    public boolean isAdaptive() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_adaptive_type") || ((Integer) this.extInfoMap.get("dl_param_adaptive_type")).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public boolean isDownloadDataReusable() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_download_data_reusable")) {
            return true;
        }
        return ((Boolean) this.extInfoMap.get("dl_param_download_data_reusable")).booleanValue();
    }

    public boolean isOffline() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || !this.extInfoMap.containsKey("dl_param_is_offline")) {
            return false;
        }
        return ((Boolean) this.extInfoMap.get("dl_param_is_offline")).booleanValue();
    }

    public boolean isTencentCloudOrigin() {
        if (TPDLProxyUtils.getMapIntValue(this.extInfoMap, "dl_param_vinfo_cdn_origin", 0) != 1) {
            return false;
        }
        return true;
    }

    public boolean isUseP2p() {
        Map<String, Object> map = this.extInfoMap;
        if (map == null || map.isEmpty() || 1 != TPDLProxyUtils.getMapIntValue(this.extInfoMap, "dl_param_vinfo_fp2p", 1)) {
            return false;
        }
        return true;
    }

    public void setDlType(int i3) {
        this.dlType = i3;
    }

    public void setExtInfoMap(Map<String, Object> map) {
        if (map != null) {
            this.extInfoMap = map;
        } else {
            this.extInfoMap.clear();
        }
    }

    public void setUrlList(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.urlList = arrayList;
        } else {
            this.urlList.clear();
        }
    }
}
