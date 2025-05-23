package com.tencent.mobileqq.unusedcodecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.unusedcodecheck.CheckCore;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\u0006\u0010\u0010\u001a\u00020\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/a;", "", "", "partName", "version", "Lcom/tencent/mobileqq/unusedcodecheck/LoadedClassInfoObject;", "c", "", "Ljava/io/File;", "e", "", "forceCombine", "Lcom/tencent/mobileqq/unusedcodecheck/LoadResult;", "a", "b", "", "d", "", "Ljava/util/Set;", "processNames", "Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "checkState", "<init>", "(Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;)V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<String> processNames;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CheckStateData checkState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/a$a;", "", "", "version", "", "a", "Ljava/io/File;", "loadedClassInfoFile", "Lcom/tencent/mobileqq/unusedcodecheck/LoadedClassInfoObject;", "b", "infoFile", "loadInfo", "", "c", "TAG", "Ljava/lang/String;", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final List<String> a(@NotNull String version) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (List) iPatchRedirector.redirect((short) 1, (Object) this, (Object) version);
            }
            Intrinsics.checkNotNullParameter(version, "version");
            ArrayList arrayList = new ArrayList();
            File c16 = CheckCore.INSTANCE.c(com.tencent.mobileqq.unusedcodecheck.b.f306127n.l(), version);
            if (!c16.exists()) {
                return arrayList;
            }
            File[] listFiles = c16.listFiles();
            if (listFiles != null) {
                for (File it : listFiles) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String partName = it.getName();
                    try {
                        Integer.valueOf(partName);
                        Intrinsics.checkNotNullExpressionValue(partName, "partName");
                        arrayList.add(partName);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return arrayList;
        }

        @Nullable
        public final LoadedClassInfoObject b(@NotNull File loadedClassInfoFile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LoadedClassInfoObject) iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadedClassInfoFile);
            }
            Intrinsics.checkNotNullParameter(loadedClassInfoFile, "loadedClassInfoFile");
            try {
                FileInputStream fileInputStream = new FileInputStream(loadedClassInfoFile);
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        Object readObject = objectInputStream.readObject();
                        if (readObject != null) {
                            LoadedClassInfoObject loadedClassInfoObject = (LoadedClassInfoObject) readObject;
                            CloseableKt.closeFinally(objectInputStream, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            return loadedClassInfoObject;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.unusedcodecheck.LoadedClassInfoObject");
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.unusedcodecheck.b.f306127n.n().h("UnusedCodeCheck.Analysis", "loadCheckInfo infoFile:" + loadedClassInfoFile + " file error", e16);
                if ((e16 instanceof ClassNotFoundException) || (e16 instanceof InvalidClassException) || (e16 instanceof OptionalDataException)) {
                    loadedClassInfoFile.delete();
                }
                return null;
            }
        }

        public final boolean c(@NotNull File infoFile, @NotNull LoadedClassInfoObject loadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) infoFile, (Object) loadInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(infoFile, "infoFile");
            Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
            try {
                infoFile.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(infoFile);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream.writeObject(loadInfo);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(objectOutputStream, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        return true;
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.unusedcodecheck.b.f306127n.n().h("UnusedCodeCheck.Analysis", "saveCheckInfo infoFile:" + infoFile + " loadInfo:" + loadInfo + " failed", e16);
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", QzoneZipCacheHelper.DIR, "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    static final class b implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final b f306093d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7190);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f306093d = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String name) {
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) name)).booleanValue();
            }
            Intrinsics.checkNotNullExpressionValue(name, "name");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) com.tencent.mobileqq.unusedcodecheck.b.f306127n.l(), false, 2, (Object) null);
            return contains$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", QzoneZipCacheHelper.DIR, "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static final class c implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public static final c f306094d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7246);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f306094d = new c();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String name) {
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) name)).booleanValue();
            }
            Intrinsics.checkNotNullExpressionValue(name, "name");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) com.tencent.mobileqq.unusedcodecheck.b.f306127n.l(), false, 2, (Object) null);
            return contains$default;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7278);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull CheckStateData checkState) {
        Intrinsics.checkNotNullParameter(checkState, "checkState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) checkState);
        } else {
            this.checkState = checkState;
            this.processNames = new LinkedHashSet();
        }
    }

    private final LoadedClassInfoObject c(String partName, String version) {
        LoadedClassInfoObject loadedClassInfoObject;
        com.tencent.mobileqq.unusedcodecheck.b bVar;
        String str;
        loop0: while (true) {
            loadedClassInfoObject = null;
            for (File file : e(partName, version)) {
                LoadedClassInfoObject b16 = INSTANCE.b(file);
                bVar = com.tencent.mobileqq.unusedcodecheck.b.f306127n;
                g n3 = bVar.n();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("combineProcessResult part process file:");
                sb5.append(file.getAbsolutePath());
                sb5.append(" info:");
                if (b16 != null) {
                    str = b16.getInfo();
                } else {
                    str = null;
                }
                sb5.append(str);
                n3.c("UnusedCodeCheck.Analysis", sb5.toString());
                if (b16 != null && loadedClassInfoObject != null) {
                    Intrinsics.checkNotNull(loadedClassInfoObject);
                    if (!loadedClassInfoObject.checkConsistency(b16)) {
                        break;
                    }
                    Intrinsics.checkNotNull(loadedClassInfoObject);
                    loadedClassInfoObject.getMarker().or(b16.getMarker());
                    Intrinsics.checkNotNull(loadedClassInfoObject);
                    loadedClassInfoObject.setCheckCount(loadedClassInfoObject.getCheckCount() + b16.getCheckCount());
                } else {
                    loadedClassInfoObject = b16;
                }
            }
            bVar.n().e("UnusedCodeCheck.Analysis", "combineProcessResult checkConsistency error file:" + file.getAbsolutePath());
        }
        if (loadedClassInfoObject != null) {
            g n16 = com.tencent.mobileqq.unusedcodecheck.b.f306127n.n();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("combineProcessResult part all process info:");
            Intrinsics.checkNotNull(loadedClassInfoObject);
            sb6.append(loadedClassInfoObject.getInfo());
            n16.e("UnusedCodeCheck.Analysis", sb6.toString());
        }
        return loadedClassInfoObject;
    }

    private final List<File> e(String partName, String version) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        File d16 = CheckCore.INSTANCE.d(version);
        if (d16.exists() && (listFiles = d16.listFiles(c.f306094d)) != null) {
            for (File it : listFiles) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String processName = it.getName();
                Set<String> set = this.processNames;
                Intrinsics.checkNotNullExpressionValue(processName, "processName");
                set.add(processName);
                File b16 = CheckCore.INSTANCE.b(processName, partName, version, false);
                if (b16.exists()) {
                    arrayList.add(b16);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final LoadResult a(boolean forceCombine) {
        LoadedClassInfoObject b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LoadResult) iPatchRedirector.redirect((short) 1, (Object) this, forceCombine);
        }
        String f16 = this.checkState.f();
        List<String> a16 = INSTANCE.a(this.checkState.f());
        if (!forceCombine) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                File b17 = CheckCore.INSTANCE.b("combine", (String) it.next(), f16, false);
                if (b17.exists() && (b16 = INSTANCE.b(b17)) != null) {
                    arrayList.add(b16);
                }
            }
            return new LoadResult(this.processNames, arrayList);
        }
        Set<String> set = this.processNames;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it5 = a16.iterator();
        while (it5.hasNext()) {
            LoadedClassInfoObject c16 = c((String) it5.next(), f16);
            if (c16 != null) {
                arrayList2.add(c16);
            }
        }
        return new LoadResult(set, arrayList2);
    }

    @NotNull
    public final List<LoadResult> b() {
        File[] listFiles;
        Set of5;
        LoadedClassInfoObject b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String f16 = this.checkState.f();
        List<String> a16 = INSTANCE.a(this.checkState.f());
        File d16 = CheckCore.INSTANCE.d(f16);
        ArrayList arrayList = new ArrayList();
        if (d16.exists() && (listFiles = d16.listFiles(b.f306093d)) != null) {
            ArrayList arrayList2 = new ArrayList(listFiles.length);
            for (File it : listFiles) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String processName = it.getName();
                ArrayList arrayList3 = new ArrayList();
                for (String str : a16) {
                    CheckCore.Companion companion = CheckCore.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(processName, "processName");
                    File b17 = companion.b(processName, str, f16, false);
                    if (b17.exists() && (b16 = INSTANCE.b(b17)) != null) {
                        arrayList3.add(b16);
                    }
                }
                if (arrayList3.size() == a16.size()) {
                    of5 = SetsKt__SetsJVMKt.setOf(processName);
                    arrayList.add(new LoadResult(of5, arrayList3));
                }
                arrayList2.add(Unit.INSTANCE);
            }
        }
        return arrayList;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int c16 = this.checkState.c();
        if (c16 != 0 && c16 % com.tencent.mobileqq.unusedcodecheck.b.f306127n.i() == 0) {
            String f16 = this.checkState.f();
            for (String str : INSTANCE.a(this.checkState.f())) {
                LoadedClassInfoObject c17 = c(str, f16);
                if (c17 != null) {
                    File b16 = CheckCore.INSTANCE.b("combine", str, f16, true);
                    b16.delete();
                    INSTANCE.c(b16, c17);
                    com.tencent.mobileqq.unusedcodecheck.b.f306127n.n().e("UnusedCodeCheck.Analysis", "generateLoadResultCache loadInfo:" + c17.getInfo() + " combineInfoFile:" + b16);
                }
            }
        }
    }
}
