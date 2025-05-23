package com.tencent.mobileqq.app.message.filescan;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001c\u0010\u001aR'\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b\r\u0010!R'\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\b\u0010!R'\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001f8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b$\u0010!R'\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b\u0013\u0010!R'\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001f8\u0006\u00a2\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b\u0015\u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/d;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "dataPath", "c", "d", "externalPath", "k", "storagePath", "e", "getDirSDCardMain", "dirSDCardMain", "f", "j", "spRoot", "g", "mmkvRoot", h.F, "databasesRoot", "", "i", "[Ljava/lang/String;", "()[Ljava/lang/String;", "sdPaths", "l", "storageScanSDPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "innerPaths", "excludeInnerPaths", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "systemCachePathList", DomainData.DOMAIN_NAME, "publicDir", "o", "restartCleanPathList", "<init>", "()V", "storage-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f195978a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String dataPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String externalPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String storagePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String dirSDCardMain;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String spRoot;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String mmkvRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String databasesRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] sdPaths;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] storageScanSDPath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> innerPaths;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> excludeInnerPaths;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> systemCachePathList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> publicDir;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> restartCleanPathList;

    static {
        Object[] plus;
        ArrayList<String> arrayListOf;
        ArrayList<String> arrayListOf2;
        ArrayList<String> arrayListOf3;
        ArrayList<String> arrayListOf4;
        ArrayList<String> arrayListOf5;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        f195978a = new d();
        String d16 = com.tencent.mobileqq.vfs.b.i().d();
        if (d16 == null) {
            d16 = "/data/data/com.tencent.mobileqq";
        }
        dataPath = d16;
        String e16 = com.tencent.mobileqq.vfs.b.i().e();
        if (e16 == null) {
            e16 = "/sdcard/Android/data/com.tencent.mobileqq";
        }
        externalPath = e16;
        String f16 = com.tencent.mobileqq.vfs.b.i().f();
        if (f16 == null) {
            f16 = PreDownloadConstants.SDCRAD_DEFAULT;
        }
        storagePath = f16;
        String str = f16 + "/Tencent/MobileQQ";
        dirSDCardMain = str;
        spRoot = d16 + "/shared_prefs";
        mmkvRoot = BaseApplication.getContext().getFilesDir() + "/mmkv";
        databasesRoot = d16 + "/databases";
        String[] strArr = {f16 + "/Tencent/QQ_Images", f16 + "/Tencent/QQfile_recv", f16 + "/Tencent/QQ_Collection", f16 + "/Tencent/QQ_Favorite", f16 + "/Tencent/QQ_Video", f16 + "/Tencent/QQfile_share", f16 + "/Tencent/QQHomework_recv", f16 + "/Tencent/QQHomework_attach", f16 + "/Tencent/AIO_FORWARD", f16 + "/Tencent/QQ_business", f16 + "/Tencent/msflogs"};
        sdPaths = strArr;
        plus = ArraysKt___ArraysJvmKt.plus(strArr, str);
        storageScanSDPath = (String[]) plus;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d16);
        sb5.append("/files");
        StringBuilder sb6 = new StringBuilder();
        sb6.append(d16);
        sb6.append("/files/files");
        StringBuilder sb7 = new StringBuilder();
        sb7.append(d16);
        sb7.append("/cache");
        StringBuilder sb8 = new StringBuilder();
        sb8.append(d16);
        sb8.append("/app_lib");
        StringBuilder sb9 = new StringBuilder();
        sb9.append(d16);
        sb9.append("/databases");
        StringBuilder sb10 = new StringBuilder();
        sb10.append(d16);
        sb10.append("/databases/nt_db");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(d16, sb5.toString(), sb6.toString(), sb7.toString(), sb8.toString(), sb9.toString(), sb10.toString());
        innerPaths = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(d16 + "/files", d16 + "/files/files", d16 + "/cache", d16 + "/app_lib", d16 + "/databases", d16 + "/databases/nt_db");
        excludeInnerPaths = arrayListOf2;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(d16);
        sb11.append("/cache");
        StringBuilder sb12 = new StringBuilder();
        sb12.append(d16);
        sb12.append("/code_cache");
        StringBuilder sb13 = new StringBuilder();
        sb13.append(e16);
        sb13.append("/cache");
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(sb11.toString(), sb12.toString(), sb13.toString());
        systemCachePathList = arrayListOf3;
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(d16, d16 + "/files", d16 + "/files/mmkv", d16 + "/databases", d16 + "/shared_prefs", e16, e16 + "/Tencent", e16 + "/Tencent/MobileQQ", e16 + "/files", e16 + "/files/tencent", e16 + "/files/tencent/MobileQQ", f16 + "/Tencent/MobileQQ");
        publicDir = arrayListOf4;
        StringBuilder sb14 = new StringBuilder();
        sb14.append(d16);
        sb14.append("/files/qqso");
        StringBuilder sb15 = new StringBuilder();
        sb15.append(d16);
        sb15.append("/app_libs");
        arrayListOf5 = CollectionsKt__CollectionsKt.arrayListOf(sb14.toString(), sb15.toString());
        restartCleanPathList = arrayListOf5;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return dataPath;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return databasesRoot;
    }

    @NotNull
    public final ArrayList<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return excludeInnerPaths;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return externalPath;
    }

    @NotNull
    public final ArrayList<String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return innerPaths;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return mmkvRoot;
    }

    @NotNull
    public final ArrayList<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return publicDir;
    }

    @NotNull
    public final ArrayList<String> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ArrayList) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return restartCleanPathList;
    }

    @NotNull
    public final String[] i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return sdPaths;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return spRoot;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return storagePath;
    }

    @NotNull
    public final String[] l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return storageScanSDPath;
    }

    @NotNull
    public final ArrayList<String> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return systemCachePathList;
    }
}
