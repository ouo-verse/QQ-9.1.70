package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f302155a;

    /* renamed from: b, reason: collision with root package name */
    public static final Integer f302156b;

    /* renamed from: c, reason: collision with root package name */
    public static final Integer f302157c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f302155a = 1;
        f302156b = 4;
        f302157c = 2;
    }

    public static String a(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return "";
            }
            return str.substring(lastIndexOf, str.length());
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return "";
            }
            QLog.e("hw_troop", 2, "getFileSuffix:", e16);
            return "";
        }
    }

    public static boolean b(Context context, String str, String str2) {
        File file;
        try {
            file = new File(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("hw_troop", 2, "openLocalFilePreview:", e16);
            }
        }
        if (file.exists() && !file.isDirectory()) {
            FileInfo fileInfo = new FileInfo();
            fileInfo.y(str2);
            fileInfo.t(false);
            fileInfo.z(file.getPath());
            fileInfo.A(file.length());
            fileInfo.r(file.lastModified());
            FileManagerEntity newEntityByLocalFileInfo = FileManagerUtil.newEntityByLocalFileInfo(fileInfo);
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.E(newEntityByLocalFileInfo.nSessionId);
            forwardFileInfo.w(3);
            forwardFileInfo.N(10000);
            forwardFileInfo.C(fileInfo.k());
            forwardFileInfo.y(fileInfo.j());
            forwardFileInfo.z(fileInfo.l());
            Intent intent = new Intent(context, (Class<?>) FileBrowserActivity.class);
            intent.putExtra("fileinfo", forwardFileInfo);
            int i3 = newEntityByLocalFileInfo.nFileType;
            if (i3 == 0 || i3 == 1) {
                ArrayList<FileInfo> arrayList = new ArrayList<>();
                arrayList.add(fileInfo);
                ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).addFileViewerLocalFiles(arrayList);
                intent.putExtra("clicked_file_hashcode", fileInfo.hashCode());
            }
            intent.putExtra("selectMode", false);
            intent.putExtra("enableDelete", false);
            intent.putExtra("peerType", 0);
            intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 0);
            intent.putExtra("enterfrom", 0);
            intent.putExtra("sendprepare", -100);
            intent.putExtra("apautocreate", false);
            intent.putExtra("qlinkselect", false);
            intent.putExtra("max_select_size", 0);
            intent.putExtra(PictureConst.KEY_MAX_SELECT_COUNT, 20);
            intent.putExtra("rootEntrace", false);
            intent.setFlags(268435456);
            context.startActivity(intent);
            if (QLog.isColorLevel()) {
                QLog.d("hw_troop", 2, "openLocalFilePreview:" + str + "," + str2);
            }
            return true;
        }
        return false;
    }

    public static final void c(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev3/joingroup.html?_bid=206&_wv=2098179&groupCode=%1$s&source=%2$s&uin=%3$s", str2, str3, str));
        context.startActivity(intent);
    }
}
