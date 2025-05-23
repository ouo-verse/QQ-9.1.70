package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.s;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileSelectorUtilImpl implements IQQFileSelectorUtil {
    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public List<PackageInfo> getAllApps(Context context) {
        return FileCategoryUtil.a(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public Drawable getApkIcon(Context context, String str) {
        return FileCategoryUtil.b(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public boolean getApkPackageInfo(String str, s sVar) {
        return FileCategoryUtil.c(str, sVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public PackageInfo getPackageInfo(Context context, String str) {
        return FileCategoryUtil.d(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public long getPicCount(Context context) {
        return FileCategoryUtil.g(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public boolean isImportLocaFilesForH5(Context context) {
        if (context != null && (context instanceof BaseFileAssistantActivity) && ((BaseFileAssistantActivity) context).O0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public boolean isNeedFinish(Activity activity) {
        if (activity != null && (activity instanceof FMActivity)) {
            FMActivity fMActivity = (FMActivity) activity;
            if (fMActivity.getTabType() == 0 || 7 == fMActivity.getTabType()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public void openFileAssistant(Context context, boolean z16) {
        Intent intent = new Intent();
        intent.setClass(context, FileAssistantActivity.class);
        intent.putExtra("from", "FileAssistant");
        if (z16) {
            intent.setFlags(276824064);
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public List<FileInfo> qureyApks(Context context, qb1.f fVar) {
        return FileCategoryUtil.t(context, fVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public void scanFileList(boolean z16, String str, String str2, String str3, HashMap<String, List<FileInfo>> hashMap, qb1.f fVar) {
        FileCategoryUtil.u(z16, str, str2, str3, hashMap, fVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
    public void upDataApkPathForPackageName(FileManagerEntity fileManagerEntity) {
        FileCategoryUtil.x(fileManagerEntity);
    }
}
