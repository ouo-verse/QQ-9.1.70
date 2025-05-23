package cooperation.plugin.patch;

import android.content.Context;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.d;
import cooperation.plugin.patch.PatchDownloadManager;
import cooperation.plugin.patch.PatchReporter;
import java.io.File;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f implements d.c {
    private final b C;
    private final PatchDownloadManager.PatchInfo D;
    private long E = 0;
    private long F = -1;
    private long G = 0;
    private long H = -1;

    /* renamed from: d, reason: collision with root package name */
    private final Context f390355d;

    /* renamed from: e, reason: collision with root package name */
    private final PluginInfo f390356e;

    /* renamed from: f, reason: collision with root package name */
    private final String f390357f;

    /* renamed from: h, reason: collision with root package name */
    private final String f390358h;

    /* renamed from: i, reason: collision with root package name */
    private String f390359i;

    /* renamed from: m, reason: collision with root package name */
    private d.c f390360m;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f390361a;

        a(String str) {
            this.f390361a = str;
        }

        @Override // cooperation.plugin.patch.c
        public void a(File file) {
            f.this.H = System.currentTimeMillis() - f.this.G;
            f.this.m(this.f390361a, file);
        }

        @Override // cooperation.plugin.patch.c
        public void onFail(String str) {
            f.this.H = System.currentTimeMillis() - f.this.G;
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, String.format("patch file failed. [pluginId]=%s, [err]=%s, [patchTime]=%d", this.f390361a, str, Long.valueOf(f.this.H)));
            }
            PatchReporter.b(PatchReporter.ERROR.PATCH_FAILED.ordinal(), f.this.D, f.this.F, f.this.H, f.this.f390359i);
            f.this.k();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void a();
    }

    public f(Context context, PluginInfo pluginInfo, String str, String str2, d.c cVar, b bVar) {
        this.f390355d = context;
        this.f390356e = pluginInfo;
        this.f390357f = str;
        this.f390358h = str2;
        this.f390360m = cVar;
        this.C = bVar;
        this.D = g.e(context, pluginInfo);
        PluginInfo d16 = g.d(context, pluginInfo.mID);
        if (d16 != null) {
            this.f390359i = d16.mVersion;
        } else {
            this.f390359i = "";
        }
    }

    private boolean i(String str) {
        File file = new File(this.f390357f);
        if (file.exists() && file.isFile()) {
            if (file.length() != bv.a(this.D.length)) {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.i("plugin_tag", 1, String.format("download %s's patch check failed. bad patch file: length not equal.", str));
                return false;
            }
            if (Objects.equals(FileUtils.calcMd5(this.f390357f), this.D.md5)) {
                return true;
            }
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.i("plugin_tag", 1, String.format("download %s's patch check failed. bad patch file: md5 not match.", str));
            return false;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.i("plugin_tag", 1, String.format("download %s's patch check failed.", str));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f390356e.mPatchDescription = null;
        b bVar = this.C;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, File file) {
        String str2;
        if (file != null && file.exists() && Objects.equals(FileUtils.calcMd5(file.getAbsolutePath()), this.f390356e.mMD5)) {
            File file2 = new File(this.f390358h);
            if (file2.exists()) {
                file2.delete();
            }
            FileUtils.moveFile(file.getAbsolutePath(), this.f390358h);
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, String.format("patch file succeed. [pluginId]=%s, [patchedFileMd5]=%s, [patchTime]=%d", str, FileUtils.calcMd5(this.f390358h), Long.valueOf(this.H)));
            }
            this.f390360m.v(true, str);
            PatchReporter.b(PatchReporter.ERROR.PATCH_SUCCEED.ordinal(), this.D, this.F, this.H, this.f390359i);
            return;
        }
        if (QLog.isColorLevel()) {
            if (file != null) {
                str2 = FileUtils.calcMd5(file.getAbsolutePath());
            } else {
                str2 = "";
            }
            QLog.i("plugin_tag", 2, String.format("patch file verify failed. [pluginId]=%s, [patchedFileMD5]=%s, [originMD5]=%s, [patchTime]=%d", str, str2, this.f390356e.mMD5, Long.valueOf(this.H)));
        }
        PatchReporter.b(PatchReporter.ERROR.PATCH_FILE_VERIFY_FAILED.ordinal(), this.D, this.F, this.H, this.f390359i);
        k();
    }

    @Override // cooperation.plugin.d.c
    public void E3(int i3, int i16, String str) {
        d.c cVar = this.f390360m;
        if (cVar != null) {
            cVar.E3(i3, i16, str);
        }
    }

    @Override // cooperation.plugin.d.c
    public void Z2(String str) {
        d.c cVar = this.f390360m;
        if (cVar != null) {
            cVar.Z2(str);
        }
    }

    @Override // cooperation.plugin.d.c
    public void j(String str) {
        d.c cVar = this.f390360m;
        if (cVar != null) {
            cVar.j(str);
        }
        this.E = System.currentTimeMillis();
    }

    public void l(d.c cVar) {
        this.f390360m = cVar;
    }

    @Override // cooperation.plugin.d.c
    public void v(boolean z16, String str) {
        this.F = System.currentTimeMillis() - this.E;
        if (this.D != null) {
            if (z16) {
                if (!i(str)) {
                    PatchReporter.b(PatchReporter.ERROR.PATCH_MD5_MISMATCH.ordinal(), this.D, this.F, -1L, this.f390359i);
                    k();
                    return;
                }
                String b16 = g.b(this.f390355d, str);
                File file = new File(this.f390358h + ".pt");
                if (file.exists()) {
                    file.delete();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 1, String.format("start patch. [pluginId]=%s, [originPath]=%s, [patchPath]=%s", str, b16, this.f390357f));
                }
                this.G = System.currentTimeMillis();
                new h().c(b16, this.f390357f, file.getAbsolutePath(), new a(str));
                return;
            }
            d.c cVar = this.f390360m;
            if (cVar != null) {
                cVar.v(false, str);
            }
            PatchReporter.b(PatchReporter.ERROR.PATCH_DOWNLOAD_FAILED.ordinal(), this.D, this.F, -1L, this.f390359i);
            return;
        }
        d.c cVar2 = this.f390360m;
        if (cVar2 != null) {
            cVar2.v(z16, str);
        }
    }

    @Override // cooperation.plugin.d.c
    public void x(String str) {
        d.c cVar = this.f390360m;
        if (cVar != null) {
            cVar.x(str);
        }
    }
}
