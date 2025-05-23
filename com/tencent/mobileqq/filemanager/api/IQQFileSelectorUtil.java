package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.s;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;
import qb1.f;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IQQFileSelectorUtil extends QRouteApi {
    List<PackageInfo> getAllApps(Context context);

    Drawable getApkIcon(Context context, String str);

    boolean getApkPackageInfo(String str, s sVar);

    @Nullable
    PackageInfo getPackageInfo(Context context, String str);

    long getPicCount(Context context);

    boolean isImportLocaFilesForH5(Context context);

    boolean isNeedFinish(Activity activity);

    void openFileAssistant(Context context, boolean z16);

    List<FileInfo> qureyApks(Context context, f fVar);

    void scanFileList(boolean z16, String str, String str2, String str3, HashMap<String, List<FileInfo>> hashMap, f fVar);

    void upDataApkPathForPackageName(FileManagerEntity fileManagerEntity);
}
