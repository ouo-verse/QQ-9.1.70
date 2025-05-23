package com.tencent.localedit.fakenative.packages;

import com.tencent.localedit.LocalEditSDK;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import x11.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J=\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/localedit/fakenative/packages/ResourcePackage;", "", "", "docsType", h.F, "l", "", "e", "Lkotlin/Function1;", "", "callback", "checkInnerZip", DomainData.DOMAIN_NAME, "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/Boolean;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "j", "f", "path", "Lorg/json/JSONObject;", "i", "g", "", "a", "Ljava/util/Set;", "currentUpdatingList", "<init>", "()V", "b", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public class ResourcePackage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> currentUpdatingList = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[LOOP:0: B:8:0x0020->B:18:0x004c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(String docsType) {
        File[] listFiles;
        File file;
        boolean z16;
        boolean endsWith$default;
        File file2 = new File(h(docsType));
        if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
            int length = listFiles.length;
            int i3 = 0;
            while (true) {
                file = null;
                if (i3 >= length) {
                    break;
                }
                File file3 = listFiles[i3];
                if (file3.exists() && !file3.isDirectory()) {
                    String path = file3.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "it.path");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, ".zip", false, 2, null);
                    if (endsWith$default) {
                        z16 = true;
                        if (!z16) {
                            file = file3;
                            break;
                        }
                        i3++;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            if (file != null) {
                b bVar = b.f446855a;
                bVar.d("ResourcePackage", Intrinsics.stringPlus("inner unzipFile package zipFile ", file.getAbsolutePath()));
                w11.a aVar = w11.a.f444159a;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "this.absolutePath");
                if (aVar.t(absolutePath, h(docsType))) {
                    bVar.d("ResourcePackage", Intrinsics.stringPlus("inner unzipFile unzipSuccess ", file.getAbsolutePath()));
                    file.delete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(String docsType) {
        return Intrinsics.stringPlus(k(docsType), "_new");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        String stringPlus = Intrinsics.stringPlus(LocalEditSDK.INSTANCE.getApplicationContext().getFilesDir().getAbsolutePath(), "/localEdit/offline/update");
        File file = new File(stringPlus);
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringPlus;
    }

    public final boolean f(@Nullable String docsType) {
        boolean z16;
        boolean z17;
        String k3 = k(docsType);
        b.f446855a.d("ResourcePackage", "checkLoadSuccess docsType:" + ((Object) docsType) + ", path:" + k3);
        File file = new File(k3);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            z17 = false;
        } else {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            z17 = !z16;
        }
        if (!z17) {
            return false;
        }
        return true;
    }

    public final void g(@Nullable String docsType) {
        File file = new File(k(docsType));
        if (file.exists()) {
            FilesKt__UtilsKt.deleteRecursively(file);
        }
    }

    @Nullable
    public final JSONObject i(@Nullable String path) {
        boolean z16;
        Object m476constructorimpl;
        BufferedReader bufferedReader;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj = null;
        if (z16) {
            b.f446855a.b("ResourcePackage", "path is empty");
            return null;
        }
        File file = new File(path, "config.json");
        if (!file.exists()) {
            b.f446855a.b("ResourcePackage", Intrinsics.stringPlus("config file not exists for ", path));
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            }
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                m476constructorimpl = Result.m476constructorimpl(new JSONObject(readText));
            } finally {
            }
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            b.f446855a.c("ResourcePackage", Intrinsics.stringPlus("read config.json failed for ", path), m479exceptionOrNullimpl);
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (JSONObject) obj;
    }

    @Nullable
    public String j(@Nullable String docsType) {
        throw null;
    }

    @NotNull
    public String k(@Nullable String docsType) {
        String stringPlus = Intrinsics.stringPlus(LocalEditSDK.INSTANCE.getApplicationContext().getFilesDir().getAbsolutePath(), "/localEdit/offline/resources");
        File file = new File(stringPlus);
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringPlus + '/' + ((Object) docsType);
    }

    public final boolean m(@Nullable String docsType) {
        int i3;
        int i16;
        File file = new File(h(docsType));
        if (!file.exists()) {
            b.f446855a.b("ResourcePackage", Intrinsics.stringPlus("new resource not exists for ", docsType));
            return false;
        }
        JSONObject i17 = i(k(docsType));
        if (i17 == null) {
            i3 = 0;
        } else {
            i3 = i17.getInt("version");
        }
        JSONObject i18 = i(h(docsType));
        if (i18 == null) {
            i16 = 0;
        } else {
            i16 = i18.getInt("version");
        }
        if (i3 < i16) {
            g(docsType);
            file.renameTo(new File(k(docsType)));
            b.f446855a.d("ResourcePackage", "update for " + ((Object) docsType) + ", existing:" + i3 + ", new:" + i16);
            return true;
        }
        b.f446855a.d("ResourcePackage", "no update for " + ((Object) docsType) + ", existing:" + i3 + ", new:" + i16);
        FilesKt__UtilsKt.deleteRecursively(file);
        return false;
    }

    public void n(@Nullable String docsType, @Nullable Function1<? super Boolean, Unit> callback, @Nullable Boolean checkInnerZip) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ResourcePackage$updateResource$1(this, docsType, callback, checkInnerZip, null), 3, null);
    }
}
