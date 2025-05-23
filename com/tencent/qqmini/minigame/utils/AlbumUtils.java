package com.tencent.qqmini.minigame.utils;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileProvider7Helper;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AlbumUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f346808a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera/";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f346814a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f346815b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ File f346816c;

        b(File file, Activity activity, File file2, c cVar) {
            this.f346814a = file;
            this.f346815b = activity;
            this.f346816c = file2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                if (this.f346814a.exists()) {
                    ImageUtil.deletePic2SystemMedia(this.f346815b, this.f346814a);
                }
                if (FileUtils.copyFile(this.f346816c, this.f346814a)) {
                    ImageUtil.savePic2SystemMedia(this.f346815b, this.f346814a);
                    FileProvider7Helper.savePhotoToSysAlbum(this.f346815b, new File(this.f346814a.getAbsolutePath()));
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            } catch (OutOfMemoryError e16) {
                QMLog.e("AlbumUtils", "[savePhoto], e:", e16);
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            String string;
            if (bool.booleanValue()) {
                string = this.f346815b.getString(R.string.pic_edit_save);
            } else {
                string = this.f346815b.getString(R.string.picture_save_failed);
            }
            MiniToast.makeText(this.f346815b, string, 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface d {
        void allow();

        void reject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Activity activity, d dVar) {
        if (!c(activity)) {
            d(activity, dVar);
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        int checkSelfPermission = context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        QMLog.i("AlbumUtils", "checkPermission,   permit: " + checkSelfPermission);
        if (checkSelfPermission != 0) {
            return false;
        }
        return true;
    }

    public static boolean d(Activity activity, d dVar) {
        IPermissionManagerProxy iPermissionManagerProxy = (IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class);
        if (Build.VERSION.SDK_INT < 29) {
            Permissions permissions = Permissions.WRITE_EXTERNAL_STORAGE;
            if (!iPermissionManagerProxy.isPermissionGranted(activity, permissions)) {
                iPermissionManagerProxy.requestForPermission(activity, permissions, new a(dVar));
                return false;
            }
            return false;
        }
        return false;
    }

    private static void e(Activity activity, File file, File file2, c cVar) {
        new b(file2, activity, file, cVar).execute(new Void[0]);
    }

    public static void f(Activity activity, File file, String str, c cVar) {
        String str2 = f346808a;
        new File(str2).mkdirs();
        File file2 = new File(str2, str);
        if (!file2.exists()) {
            e(activity, file, file2, cVar);
        }
    }

    public static void g(final String str, final Activity activity) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.utils.AlbumUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (AlbumUtils.b(activity, new a(file))) {
                    AlbumUtils.f(activity, file, file.getName(), null);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.qqmini.minigame.utils.AlbumUtils$1$a */
            /* loaded from: classes23.dex */
            class a implements d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ File f346811a;

                a(File file) {
                    this.f346811a = file;
                }

                @Override // com.tencent.qqmini.minigame.utils.AlbumUtils.d
                public void allow() {
                    Activity activity = activity;
                    File file = this.f346811a;
                    AlbumUtils.f(activity, file, file.getName(), null);
                }

                @Override // com.tencent.qqmini.minigame.utils.AlbumUtils.d
                public void reject() {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f346813a;

        a(d dVar) {
            this.f346813a = dVar;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            QMLog.e("AlbumUtils", "savaPicToAlbum failed.");
            this.f346813a.reject();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            d dVar = this.f346813a;
            if (dVar != null) {
                dVar.allow();
            }
            QMLog.i("AlbumUtils", "audio permission:true");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }
}
