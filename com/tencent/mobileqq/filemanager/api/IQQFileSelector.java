package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQFileSelector extends QRouteApi {
    void enterCloudFileBrowser(Activity activity);

    void enterLocalFileBrowserByDevice(Activity activity, String str, int i3);

    void enterQlinkFromQfav(Activity activity, String str, int i3, boolean z16, int i16);

    void enterQlinkLocalFileBrowser(Activity activity, String str, int i3, boolean z16, int i16);

    void enterQlinkRecentFileBrowser(Activity activity, boolean z16);

    void fileChooseLaunchForResult(Activity activity, int i3, int i16, ArrayList<String> arrayList);

    void free();

    void jumpToMyFile(Activity activity, long j3);

    void jumpToMyFile(Activity activity, long[] jArr);

    void openExpiredFilePageBySchema(Context context);

    void openFileClear(Activity activity, int i3);

    void openFileSelectorByAIO(Activity activity, int i3, String str, @Nullable String str2, String str3, int i16);

    void openFileSelectorByColorNoteHistory(Context context);

    void openFileSelectorByDeviceMsg(Activity activity, int i3, String str, int i16, long j3);

    void openFileSelectorByDocApiPlugin(Activity activity, String str);

    void openFileSelectorByLiteActivity(Activity activity, int i3, String str);

    void openFileSelectorByLiteAdvance(Activity activity);

    void openFileSelectorByMyComputer(Activity activity, int i3, String str, @Nullable String str2, String str3);

    void openFileSelectorByPrinter(Activity activity, String[] strArr, int i3);

    void openFileSelectorByPulsPanel(Activity activity, String str, int i3, int i16, int i17, long j3);

    void openFileSelectorByQRLogin(Activity activity, String str, long j3, int i3);

    void openFileSelectorByQRLoginMyComputer(Activity activity, String str, long j3, int i3, int i16, String str2, String str3);

    void openFileSelectorByWeiyunBoroadcast(Context context, Bundle bundle);

    void openFileSelectorForTroopFileBrowser(Activity activity, String str, boolean z16, boolean z17);

    void openLocalFileBrowserActivity(Context context, String str);

    void openMyFile(Activity activity);

    void openMyFileBySchema(Activity activity, String str);

    void startFM(Context context);
}
