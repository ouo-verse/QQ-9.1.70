package com.tencent.mobileqq.qwallet.preload;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kl2.PreloadConfBean;
import org.json.JSONArray;

@Service(process = {""})
/* loaded from: classes16.dex */
public interface IPreloadService extends IPreloadServiceAbs {
    public static final String CONIFG_FILE_NAME = "preload.config";
    public static final String KEY_CONFIG_FROM_QQ = "config_from_qq";
    public static final int MSG_FLOW_CONTROL_ADD_RES = 1;
    public static final int MSG_FLOW_CONTROL_CHECK_NEXT_RES = 2;
    public static final String PREF_NAME_QWALLET_PRELOAD_CONFIG = "qwallet_preload_config";
    public static final String TAG = "PreloadService";

    /* loaded from: classes16.dex */
    public static class PathResult implements Serializable {
        public String filePath;
        public String folderPath;
        public boolean isAlreadyExist;
        public int subErrCode;
        public String url;

        public PathResult() {
        }

        public static PathResult getFailRes(String str) {
            return getFailRes(str, 0);
        }

        public String toString() {
            return "PathResult{file='" + this.filePath + "', folder='" + this.folderPath + "', url='" + this.url + "'}";
        }

        public PathResult(String str, String str2, String str3, int i3) {
            this.filePath = str;
            this.folderPath = str2;
            this.url = str3;
            this.subErrCode = i3;
        }

        public static PathResult getFailRes(String str, int i3) {
            return new PathResult(null, null, str, i3);
        }
    }

    /* loaded from: classes16.dex */
    public interface a {
        void onDownloadResFinished(String str, int i3, String str2, ResourceInfo resourceInfo);
    }

    /* loaded from: classes16.dex */
    public static abstract class b {
        public abstract void a(IPreloadService iPreloadService);
    }

    /* loaded from: classes16.dex */
    public interface c {
        void onResult(int i3, PathResult pathResult);
    }

    /* loaded from: classes16.dex */
    public interface d {
        void onResult(int i3, HashMap<String, PathResult> hashMap);
    }

    void addResToFlowControlCheck(b bVar);

    void downloadModule(String str);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    void downloadModule(String str, String str2, a aVar);

    void downloadModule(String str, boolean z16);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    void downloadRes(String str, String str2, a aVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void downloadUrls(List<String> list, c cVar);

    void getFilePath(String str, c cVar);

    void getFilePath(String str, String str2, c cVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void getFilePathByResID(String str, ResultReceiver resultReceiver);

    kl2.a getModuleByMID(String str);

    kl2.a getModuleByName(String str);

    String getResIdByUrl(String str);

    ResourceInfo getResInfoByResId(String str);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void getResPath(DownloadParam downloadParam, c cVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void getResPath(LinkedList<DownloadParam> linkedList, d dVar);

    void getUnzipFolderPath(String str, c cVar);

    void getUnzipFolderPath(String str, String str2, c cVar);

    String getUnzipFolderPathByResId(String str);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    String getVideoResPathByID(String str);

    void mergeConfig(String str);

    void notifyResFlowCheckNext();

    @Override // mqq.app.api.IRuntimeService
    void onDestroy();

    void preCheck();

    void realTimeDownload(DownloadParam downloadParam, c cVar);

    void replaceConfig(PreloadConfBean preloadConfBean);

    void replaceConfig(JSONArray jSONArray, int i3);

    void savePreloadConfig();

    void setPreloadHelpConfig(int i3, int i16);

    void startCheckConfig(boolean z16);
}
