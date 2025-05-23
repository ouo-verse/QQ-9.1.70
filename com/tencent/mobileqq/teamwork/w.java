package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.xweb.FileReaderHelper;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w {
    public static FileManagerEntity a(ForwardFileInfo forwardFileInfo) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.fileName = forwardFileInfo.f();
        fileManagerEntity.nFileType = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getFileType(fileManagerEntity.fileName);
        fileManagerEntity.nSessionId = forwardFileInfo.n();
        fileManagerEntity.cloudType = forwardFileInfo.c();
        return fileManagerEntity;
    }

    public static String b(int i3) {
        String qqStr = HardCodeUtil.qqStr(R.string.u1a);
        if (i3 == 3) {
            return "word";
        }
        if (i3 == 6) {
            return "excel";
        }
        if (i3 == 7) {
            return FileReaderHelper.PPT_EXT;
        }
        if (i3 == 9) {
            return FileReaderHelper.PDF_EXT;
        }
        return qqStr;
    }

    public static ForwardFileInfo c(String str) {
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.w(9);
        forwardFileInfo.N(10001);
        forwardFileInfo.y(str);
        forwardFileInfo.E(b.a().longValue());
        return forwardFileInfo;
    }

    public static void d(Activity activity, ForwardFileInfo forwardFileInfo, Bundle bundle) {
        Intent fileBrowserActivityClassIntent = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getFileBrowserActivityClassIntent(activity);
        if (forwardFileInfo != null) {
            fileBrowserActivityClassIntent.putExtra("fileinfo", forwardFileInfo);
        }
        if (bundle != null) {
            fileBrowserActivityClassIntent.putExtra("file_browser_extra_params", bundle);
        }
        activity.startActivityForResult(fileBrowserActivityClassIntent, 102);
    }

    public static void e(Activity activity, String str) {
        f(activity, str, false);
    }

    public static void f(Activity activity, String str, boolean z16) {
        ForwardFileInfo c16 = c(str);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, z16);
        d(activity, c16, bundle);
    }
}
