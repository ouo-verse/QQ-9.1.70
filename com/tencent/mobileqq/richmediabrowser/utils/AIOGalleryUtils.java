package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOGalleryUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f281900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Boolean f281901b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f281902c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f281903d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f281904e;

        c(File file, Boolean bool, File file2, Activity activity, d dVar) {
            this.f281900a = file;
            this.f281901b = bool;
            this.f281902c = file2;
            this.f281903d = activity;
            this.f281904e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                if (this.f281900a.exists()) {
                    if (!this.f281901b.booleanValue()) {
                        QLog.w("AIOGalleryUtils", 1, "[savePhoto] file exists with replace flag false, path=" + this.f281902c + "->" + this.f281900a);
                        return Boolean.FALSE;
                    }
                    BaseImageUtil.deletePic2SystemMedia(BaseApplicationImpl.getApplication(), this.f281900a);
                    BaseImageUtil.savePhotoToSysAlbum(this.f281903d, this.f281900a.getAbsolutePath());
                }
                if (n0.a.d(this.f281902c, this.f281900a, true)) {
                    BaseImageUtil.savePic2SystemMedia(BaseApplicationImpl.getApplication(), this.f281900a);
                    BaseImageUtil.savePhotoToSysAlbum(this.f281903d, this.f281900a.getAbsolutePath());
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            } catch (OutOfMemoryError e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryUtils", 4, "savePhoto exception = " + e16.getMessage());
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            int i3;
            String string;
            Activity activity = this.f281903d;
            if (activity instanceof BaseActivity) {
                i3 = ((BaseActivity) activity).getTitleBarHeight();
            } else {
                i3 = 0;
            }
            if (bool.booleanValue()) {
                string = this.f281903d.getString(R.string.cvu);
            } else {
                string = this.f281903d.getString(R.string.cwi);
            }
            QQToast.makeText(this.f281903d, 2, string, 0).show(i3);
            d dVar = this.f281904e;
            if (dVar != null) {
                dVar.onSavePhotoResult(bool.booleanValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void onSavePhotoResult(boolean z16);
    }

    private static void d(final Context context, Boolean bool) {
        final int i3;
        final int i16;
        if (bool.booleanValue()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (bool.booleanValue()) {
            i16 = R.string.f173075h42;
        } else {
            i16 = R.string.cwi;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                AIOGalleryUtils.j(context, i3, i16);
            }
        });
    }

    public static void e(Activity activity, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, path is empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, path = " + str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(activity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), arrayList, i3);
    }

    public static void f(Activity activity, String str, ArrayList<String> arrayList, int i3) {
        if (arrayList != null && arrayList.size() != 0) {
            QZoneHelper.forwardToUploadPhoto(activity, str, 0, 0, arrayList, activity.getResources().getString(R.string.vxi), i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, picMsgList is empty");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(Activity activity, String str, String str2, int i3, Parcelable parcelable, boolean z16, String str3) {
        String str4;
        long j3;
        if (!(parcelable instanceof AIOPictureData)) {
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = str;
        AIOPictureData aIOPictureData = (AIOPictureData) parcelable;
        String maxSizeExistFile = aIOPictureData.getMaxSizeExistFile();
        if (!maxSizeExistFile.endsWith("_hd")) {
            String str5 = maxSizeExistFile + "_hd";
            if (new File(str5).exists()) {
                str4 = str5;
                String str6 = aIOPictureData.uuid;
                long j16 = aIOPictureData.timestamp;
                if (!z16) {
                    j3 = aIOPictureData.groupFileID;
                } else {
                    j3 = 0;
                }
                QZoneHelper.forwardToQzoneAlbum(activity, userInfo, z16, str3, str2, i3, str4, str6, j16, j3, -1);
            }
        }
        str4 = maxSizeExistFile;
        String str62 = aIOPictureData.uuid;
        long j162 = aIOPictureData.timestamp;
        if (!z16) {
        }
        QZoneHelper.forwardToQzoneAlbum(activity, userInfo, z16, str3, str2, i3, str4, str62, j162, j3, -1);
    }

    public static void h(Activity activity, String str, String str2, String str3, String str4, String str5, long j3, int i3) {
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = str;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryUtils", 4, "fowardToGroupAlbum(),uin:" + str + " qunId:" + str2 + " qunCode:" + str3 + " uuid:" + str5 + " time:" + j3 + " path:" + i3);
        QZoneHelper.forwardToGroupAlbum(activity, userInfo, str2, str3, str4, str5, j3, i3);
    }

    public static Boolean i() {
        return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("new_save_album_api", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Context context, int i3, int i16) {
        QQToast.makeText(context, i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(d dVar, boolean z16, Context context, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        QLog.i("AIOGalleryUtils", 1, "newSaveAlbumApi, result: " + rFWSaveMediaResultBean.isSuccess);
        if (dVar != null) {
            dVar.onSavePhotoResult(rFWSaveMediaResultBean.isSuccess);
        }
        if (z16) {
            d(context, Boolean.valueOf(rFWSaveMediaResultBean.isSuccess));
        }
    }

    public static void l(Context context, String str, d dVar) {
        m(context, str, true, dVar);
    }

    public static void m(final Context context, String str, final boolean z16, final d dVar) {
        if (!i().booleanValue()) {
            return;
        }
        RFWSaveUtil.insertMedia(context, str, new Consumer() { // from class: com.tencent.mobileqq.richmediabrowser.utils.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                AIOGalleryUtils.k(AIOGalleryUtils.d.this, z16, context, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(Activity activity, File file, File file2, Boolean bool, d dVar) {
        new c(file2, bool, file, activity, dVar).execute(new Void[0]);
    }

    @Deprecated
    public static void o(Activity activity, File file, String str) {
        p(activity, file, str, null);
    }

    @Deprecated
    public static void p(final Activity activity, final File file, String str, final d dVar) {
        if (i().booleanValue()) {
            QLog.i("AIOGalleryUtils", 1, "use new save api");
            q(activity, file.getAbsolutePath(), dVar);
            return;
        }
        QLog.i("AIOGalleryUtils", 1, "use old save api");
        if (!com.tencent.mobileqq.startup.permission.a.f(activity)) {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
            return;
        }
        String str2 = AppConstants.SDCARD_IMG_SAVE;
        new File(str2).mkdirs();
        if (str.indexOf(".") == -1) {
            str = str + "." + FileUtils.estimateFileType(file.getAbsolutePath());
        }
        final File file2 = new File(str2, str);
        QLog.i("AIOGalleryUtils", 1, "[savePic] file exists: " + file2.exists() + ", filePath: " + file2.getPath());
        if (!file2.exists()) {
            n(activity, file, file2, Boolean.FALSE, dVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.3

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils$3$a */
                /* loaded from: classes18.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        if (dVar != null) {
                            QLog.i("AIOGalleryUtils", 1, "[savePic] do not replace existing file.");
                            dVar.onSavePhotoResult(false);
                        }
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils$3$b */
                /* loaded from: classes18.dex */
                class b implements DialogInterface.OnClickListener {
                    b() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        QLog.i("AIOGalleryUtils", 1, "[savePic] replace existing file.");
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        AIOGalleryUtils.n(activity, file, file2, Boolean.TRUE, dVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    DialogUtil.createCustomDialog(activity, 230).setTitle(activity.getString(R.string.h4e)).setMessage(activity.getString(R.string.cwb)).setPositiveButton(activity.getString(R.string.h1a), new b()).setNegativeButton(activity.getString(R.string.f171142no), new a()).show();
                }
            });
        }
    }

    public static void q(Activity activity, String str, d dVar) {
        if (!i().booleanValue()) {
            return;
        }
        if (!com.tencent.mobileqq.startup.permission.a.f(activity)) {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
        } else if (!TextUtils.isEmpty(str)) {
            l(activity, str, dVar);
        } else {
            QQToast.makeText(activity, 0, R.string.cwi, 0).show();
        }
    }
}
