package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintForQQLiteApi;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static long f208332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208333d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208334e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ qb1.a f208335f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f208336h;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class ViewOnClickListenerC7566a implements View.OnClickListener {
            ViewOnClickListenerC7566a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                a aVar = a.this;
                m.j(aVar.f208333d, aVar.f208334e, aVar.f208335f);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a(Activity activity, FileManagerEntity fileManagerEntity, qb1.a aVar, boolean z16) {
            this.f208333d = activity;
            this.f208334e = fileManagerEntity;
            this.f208335f = aVar;
            this.f208336h = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IPrintForQQLiteApi) QRoute.api(IPrintForQQLiteApi.class)).showPrintDialog(this.f208333d, this.f208334e, m.e(), new ViewOnClickListenerC7566a(), this.f208336h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static boolean a(String str) {
        int fileType;
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.endsWith(".zip") || lowerCase.endsWith(".rar") || lowerCase.endsWith(".7z") || (fileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(str)) == 3 || fileType == 0 || fileType == 7 || fileType == 6 || fileType == 9 || fileType == 10) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean b(String str) {
        if (str != null && ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(str) == 9) {
            return true;
        }
        return false;
    }

    public static View.OnClickListener c(Activity activity, FileManagerEntity fileManagerEntity, qb1.a aVar, boolean z16) {
        return new a(activity, fileManagerEntity, aVar, z16);
    }

    public static View.OnClickListener d(Activity activity, FileManagerEntity fileManagerEntity, boolean z16) {
        return c(activity, fileManagerEntity, null, z16);
    }

    public static com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g e() {
        return (com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("online_file_print");
    }

    public static long f() {
        return f208332a;
    }

    public static boolean g(String str, boolean z16) {
        if (z16 || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("online_file_print", false) || e() == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return a(str);
    }

    public static boolean h(String str, boolean z16, boolean z17) {
        if (!i(str, z17) && !g(str, z16)) {
            return false;
        }
        return true;
    }

    public static boolean i(String str, boolean z16) {
        if (!z16 || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("sys_print", false) || TextUtils.isEmpty(str) || !b(str)) {
            return false;
        }
        return true;
    }

    public static void j(Activity activity, FileManagerEntity fileManagerEntity, qb1.a aVar) {
        if (q.f(fileManagerEntity.strFilePath)) {
            k(activity, fileManagerEntity.strFilePath);
        } else if (aVar != null) {
            l(fileManagerEntity.nSessionId);
            aVar.a();
        }
    }

    public static void k(Activity activity, String str) {
        if (!q.f(str) || activity == null) {
            return;
        }
        ((PrintManager) activity.getSystemService("print")).print(str.substring(str.lastIndexOf("/") + 1), new l(str), new PrintAttributes.Builder().build());
    }

    public static void l(long j3) {
        f208332a = j3;
    }
}
