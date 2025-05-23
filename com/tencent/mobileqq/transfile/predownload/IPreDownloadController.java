package com.tencent.mobileqq.transfile.predownload;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes19.dex */
public interface IPreDownloadController extends IRuntimeService {
    public static final int BUSINESS_CHIRP = 10040;
    public static final int BUSINESS_DEFINE_STAT = 10000;
    public static final int BUSINESS_MINI_SCAN_DECODE = 10083;
    public static final int BUSINESS_MINI_SCAN_DETECT = 10084;
    public static final int BUSINESS_MINI_SCAN_DETECT_MODEL = 10085;
    public static final int BUSINESS_ONLINE_STATUS_ANIMATION = 10096;
    public static final int BUSINESS_QBAR_AI_RES = 10090;
    public static final int BUSINESS_QWALLET_RES = 10069;

    AbsPreDownloadTask cancelPreDownload(String str);

    boolean couldDownload();

    String getPreDownloadPath(int i3, String str, boolean z16);

    boolean isEnable();

    void onAppBackground();

    void onAppForeground();

    void onAppLiteStart(boolean z16);

    void onTaskEnd(AbsPreDownloadTask absPreDownloadTask);

    @Deprecated
    void preDownloadSuccess(String str, long j3);

    void preDownloadSuccess(String str, String str2, long j3);

    void preDownloadSuccess(String str, ArrayList<String> arrayList, long j3);

    boolean requestPreDownload(int i3, String str, String str2, int i16, String str3, String str4, int i17, int i18, boolean z16, AbsPreDownloadTask absPreDownloadTask);

    void startPreDownload();
}
