package com.tencent.mobileqq.weiyun.api;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.util.Pair;
import java.io.File;
import y43.e;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeiyunHelper extends QRouteApi {
    public static final String AID_WY_OPEN_QQ_VIP = "mvip.n.a.zcwy_xht";
    public static final String BROADCAST_ENTER_FILE_ASSIT = "enter_file_assit";
    public static final String BROADCAST_EXIT_FILE_ASSIT = "exit_file_assit";
    public static final int RESULT_CODE_OPEN_VIP = 21;
    public static final String SOURCE_ID = "biz_src_jc_xiaolv";
    public static final String TAG = "Weiyun.AlbumBackup";
    public static final String WEIYUN_PLUGIN_ID = "WeiyunPlugin.apk";

    /* renamed from: pf, reason: collision with root package name */
    public static final String f315119pf = "qq.wyhy.khd";

    boolean checkSOExists(Context context);

    void cleanPwdRecord(Context context, long j3);

    void clearDefaultUploadDirKey();

    PluginRuntime createRuntime(Context context);

    void downgradePath();

    void downloadSo(Context context, e eVar);

    Pair<Pair<String, String>, Long> genThumbInfo(String str, int i3, boolean z16);

    String getDefaultDownloadPath();

    String getDefaultThumbPath();

    String[] getDefaultUploadDirKey();

    String getOpenQQVipH5(String str, String str2);

    String getOpenWeiyunBuySpaceH5();

    String getOpenWeiyunVipH5(String str, String str2);

    File getUploadSoFile(Context context);

    void notifyEnterFileAssit(Context context);

    void notifyExitFileAssit(Context context);

    void saveDefaultUploadDirKey(String str, String str2);

    void shutdownWySystem();

    void startWySystem();

    void upgradePath();
}
