package com.tencent.mobileqq.unusedcodecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/e;", "", "Ljava/io/File;", "destFile", "Lcom/tencent/mobileqq/unusedcodecheck/LoadResult;", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "", "a", "Lcom/tencent/mobileqq/unusedcodecheck/d;", "classDef", "Ljava/io/BufferedWriter;", "writer", "", "c", "destDirFile", "b", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static final class a<T> implements Comparator<T> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((LoadedClassInfoObject) t16).getAllClassCount()), Integer.valueOf(((LoadedClassInfoObject) t17).getAllClassCount()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    private final boolean a(File destFile, LoadResult loadResult) {
        BufferedWriter bufferedWriter;
        b bVar = b.f306127n;
        bVar.n().c("UnusedCodeCheck.Export", "export start destFile:" + destFile + " loadResult:" + loadResult);
        d dVar = null;
        try {
            try {
                d dVar2 = new d(InitClassInfo.INSTANCE.b(), bVar.g());
                try {
                    Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(destFile), Charsets.UTF_8);
                    int g16 = bVar.g();
                    if (outputStreamWriter instanceof BufferedWriter) {
                        bufferedWriter = (BufferedWriter) outputStreamWriter;
                    } else {
                        bufferedWriter = new BufferedWriter(outputStreamWriter, g16);
                    }
                    try {
                        c(dVar2, loadResult, bufferedWriter);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedWriter, null);
                        dVar2.release();
                        return true;
                    } finally {
                    }
                } catch (IOException e16) {
                    e = e16;
                    dVar = dVar2;
                    b.f306127n.n().h("UnusedCodeCheck.Export", "export loadClass error", e);
                    if (dVar != null) {
                        dVar.release();
                        return false;
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    dVar = dVar2;
                    if (dVar != null) {
                        dVar.release();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    private final void c(d classDef, LoadResult loadResult, BufferedWriter writer) {
        List<LoadedClassInfoObject> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(loadResult.a(), new a());
        int i3 = 0;
        int i16 = 0;
        for (LoadedClassInfoObject loadedClassInfoObject : sortedWith) {
            int partClassCount = loadedClassInfoObject.getPartClassCount();
            for (int i17 = 0; i17 < partClassCount; i17++) {
                String nextElement = classDef.nextElement();
                if (i17 == 0) {
                    if (!Intrinsics.areEqual(nextElement, loadedClassInfoObject.getFirstClassName())) {
                        throw new IOException("checkFirstClassError className:" + nextElement + " recordClassName:" + loadedClassInfoObject.getFirstClassName());
                    }
                } else if (i17 == loadedClassInfoObject.getPartClassCount() - 1 && (!Intrinsics.areEqual(nextElement, loadedClassInfoObject.getLastClassName()))) {
                    throw new IOException("checkLastClassError className:" + nextElement + " recordClassName:" + loadedClassInfoObject.getLastClassName());
                }
                if (loadedClassInfoObject.getMarker().get(i17)) {
                    writer.write(nextElement);
                    writer.newLine();
                    i3++;
                }
                i16++;
            }
        }
        b.f306127n.n().c("UnusedCodeCheck.Export", "export success,loadClassCount:" + i3 + " allClassCount:" + i16);
    }

    public final boolean b(@NotNull File destDirFile) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) destDirFile)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(destDirFile, "destDirFile");
        destDirFile.mkdirs();
        boolean z16 = false;
        for (LoadResult loadResult : new com.tencent.mobileqq.unusedcodecheck.a(CheckStateData.INSTANCE.b()).b()) {
            first = CollectionsKt___CollectionsKt.first(loadResult.d());
            File file = new File(destDirFile, (String) first);
            file.delete();
            z16 &= a(file, loadResult);
        }
        return z16;
    }
}
