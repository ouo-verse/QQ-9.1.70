package cooperation.plugin.patch;

import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0003&*-B9\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020)\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00105\u001a\u00020\u0013\u00a2\u0006\u0004\b7\u00108B;\b\u0016\u0012\u0006\u00109\u001a\u00020\u0006\u0012\u0006\u0010:\u001a\u00020\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00105\u001a\u00020\u0013\u00a2\u0006\u0004\b7\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000f\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J0\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J.\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001d0\fH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010!\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001c\u0010#\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0006R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00104R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u00106\u00a8\u0006<"}, d2 = {"Lcooperation/plugin/patch/ZipPatcher;", "", "Lcooperation/plugin/patch/b;", "e", "Lcom/tencent/commonsdk/zip/QZipInputStream;", "inputStream", "", "confName", "", "Lcooperation/plugin/patch/PatchConfigBean;", "j", "operations", "", "filesInPatchStream", "", DomainData.DOMAIN_NAME, "Ljava/util/zip/ZipEntry;", "zipEntry", "normalOps", "", "p", "toPath", "fromPath", "md5", "buffer", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "operationName", tl.h.F, "", "map", "o", "f", "patchStream", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "patchZipPath", "l", "a", "Lcom/tencent/commonsdk/zip/QZipInputStream;", "oldStream", "Ljava/util/zip/ZipOutputStream;", "b", "Ljava/util/zip/ZipOutputStream;", "newStream", "c", "Ljava/lang/String;", "tempDirectory", "Lcooperation/plugin/patch/ZipPatcher$c;", "d", "Lcooperation/plugin/patch/ZipPatcher$c;", "postProcessor", "Z", "keepExtraInNestedZip", "Ljava/util/Map;", "<init>", "(Lcom/tencent/commonsdk/zip/QZipInputStream;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;Lcooperation/plugin/patch/ZipPatcher$c;Z)V", "oldZipPath", "newZipPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcooperation/plugin/patch/ZipPatcher$c;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class ZipPatcher {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, b> f390344h = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QZipInputStream oldStream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ZipOutputStream newStream;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String tempDirectory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c postProcessor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean keepExtraInNestedZip;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Map<String, ? extends cooperation.plugin.patch.b> filesInPatchStream;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J>\u0010\t\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007`\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J2\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcooperation/plugin/patch/ZipPatcher$a;", "", "", "Lcooperation/plugin/patch/PatchConfigBean;", "nestingOps", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "e", "operations", "normalOps", "", "c", "operationName", "Lcooperation/plugin/patch/ZipPatcher$b;", "method", "d", "PATCH_CONFIG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "installedMethods", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cooperation.plugin.patch.ZipPatcher$a, reason: from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(List<? extends PatchConfigBean> operations, List<PatchConfigBean> normalOps, List<PatchConfigBean> nestingOps) {
            for (PatchConfigBean patchConfigBean : operations) {
                String str = patchConfigBean.f390333to;
                boolean z16 = false;
                if (str != null && i.f390366a.f(str)) {
                    z16 = true;
                }
                if (z16) {
                    normalOps.add(patchConfigBean);
                } else {
                    nestingOps.add(patchConfigBean);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HashMap<String, List<PatchConfigBean>> e(List<? extends PatchConfigBean> nestingOps) {
            HashMap<String, List<PatchConfigBean>> hashMap = new HashMap<>();
            for (PatchConfigBean patchConfigBean : nestingOps) {
                String to5 = patchConfigBean.f390333to;
                if (to5 != null) {
                    Intrinsics.checkNotNullExpressionValue(to5, "to");
                    int h16 = i.f390366a.h(to5);
                    String substring = to5.substring(0, h16);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    List<PatchConfigBean> list = hashMap.get(substring);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    PatchConfigBean patchConfigBean2 = new PatchConfigBean(patchConfigBean);
                    String substring2 = to5.substring(h16 + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    patchConfigBean2.f390333to = substring2;
                    list.add(patchConfigBean2);
                    hashMap.put(substring, list);
                }
            }
            return hashMap;
        }

        @JvmStatic
        public final void d(@NotNull String operationName, @NotNull b method) {
            Intrinsics.checkNotNullParameter(operationName, "operationName");
            Intrinsics.checkNotNullParameter(method, "method");
            ZipPatcher.f390344h.put(operationName, method);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J$\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\b"}, d2 = {"Lcooperation/plugin/patch/ZipPatcher$b;", "", "", "a", "toFile", "fromFile", "newFile", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public interface b {
        boolean a();

        @Nullable
        Object b(@NotNull Object toFile, @NotNull Object fromFile, @Nullable Object newFile);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u0007"}, d2 = {"Lcooperation/plugin/patch/ZipPatcher$c;", "", "", "a", "fromFile", "toFile", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes28.dex */
    public interface c {
        boolean a();

        @Nullable
        Object b(@NotNull Object fromFile, @Nullable Object toFile);
    }

    public ZipPatcher(@NotNull QZipInputStream oldStream, @NotNull ZipOutputStream newStream, @Nullable String str, @Nullable c cVar, boolean z16) {
        Intrinsics.checkNotNullParameter(oldStream, "oldStream");
        Intrinsics.checkNotNullParameter(newStream, "newStream");
        this.oldStream = oldStream;
        this.newStream = newStream;
        this.tempDirectory = str;
        this.postProcessor = cVar;
        this.keepExtraInNestedZip = z16;
    }

    private final cooperation.plugin.patch.b e() {
        cooperation.plugin.patch.b a16;
        String str = this.tempDirectory;
        if (str == null || (a16 = j.a(str)) == null) {
            return j.c(null, 1, null);
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(ZipEntry zipEntry) throws IOException {
        this.newStream.putNextEntry(j.d(new ZipEntry(zipEntry.getName()), Boolean.valueOf(!this.keepExtraInNestedZip)));
        i.d(i.f390366a, this.oldStream, this.newStream, false, false, 8, null);
        this.oldStream.closeEntry();
        this.newStream.closeEntry();
    }

    private final void h(String operationName, String toPath, String fromPath, String md5) throws IOException {
        b bVar = f390344h.get(operationName);
        if (bVar == null) {
            return;
        }
        Map<String, ? extends cooperation.plugin.patch.b> map = this.filesInPatchStream;
        byte[] bArr = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filesInPatchStream");
            map = null;
        }
        cooperation.plugin.patch.b bVar2 = map.get(fromPath);
        if (bVar2 == null) {
            return;
        }
        cooperation.plugin.patch.b e16 = e();
        i.f390366a.b(this.oldStream, e16);
        if (bVar.a()) {
            Object b16 = bVar.b(e16.b(), bVar2.b(), null);
            if (b16 instanceof byte[]) {
                bArr = (byte[]) b16;
            }
            if (bArr != null) {
                e16 = j.b(bArr);
            }
        } else {
            String str = this.tempDirectory;
            if (str == null) {
                str = ".";
            }
            cooperation.plugin.patch.b a16 = j.a(str);
            if (bVar.b(e16.a(), bVar2.a(), a16.a()) != null) {
                e16 = a16;
            }
        }
        q(toPath, fromPath, md5, e16);
    }

    private final Map<String, cooperation.plugin.patch.b> i(QZipInputStream patchStream, List<? extends PatchConfigBean> operations) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends PatchConfigBean> it = operations.iterator();
        while (it.hasNext()) {
            String str = it.next().from;
            if (str != null && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return new ZipExtractor(patchStream, this.tempDirectory).e(arrayList);
    }

    private final List<PatchConfigBean> j(QZipInputStream inputStream, String confName) throws IOException {
        List<PatchConfigBean> a16 = d.a(new String(new ZipExtractor(inputStream, this.tempDirectory).g(confName), Charsets.UTF_8), PatchConfigBean.class);
        Intrinsics.checkNotNullExpressionValue(a16, "ZipExtractor(inputStream\u2026an::class.java)\n        }");
        return a16;
    }

    static /* synthetic */ List k(ZipPatcher zipPatcher, QZipInputStream qZipInputStream, String str, int i3, Object obj) throws IOException {
        if ((i3 & 2) != 0) {
            str = "patch.conf";
        }
        return zipPatcher.j(qZipInputStream, str);
    }

    private final void n(List<? extends PatchConfigBean> operations, Map<String, ? extends cooperation.plugin.patch.b> filesInPatchStream) throws IOException {
        this.filesInPatchStream = filesInPatchStream;
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Companion companion = INSTANCE;
        companion.c(operations, arrayList, arrayList2);
        final HashMap e16 = companion.e(arrayList2);
        i.f390366a.e(this.oldStream, new Function1<ZipEntry, Boolean>() { // from class: cooperation.plugin.patch.ZipPatcher$patch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ZipEntry zipEntry) {
                boolean p16;
                boolean o16;
                Intrinsics.checkNotNullParameter(zipEntry, "zipEntry");
                p16 = ZipPatcher.this.p(zipEntry, arrayList);
                if (!p16) {
                    o16 = ZipPatcher.this.o(zipEntry, e16);
                    if (!o16) {
                        ZipPatcher.this.f(zipEntry);
                    }
                }
                return Boolean.TRUE;
            }
        });
        this.newStream.finish();
        this.oldStream.closeEntry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(ZipEntry zipEntry, Map<String, ? extends List<PatchConfigBean>> map) throws IOException {
        String name = zipEntry.getName();
        List<PatchConfigBean> list = map.get(name);
        if (list != null) {
            cooperation.plugin.patch.b e16 = e();
            i iVar = i.f390366a;
            iVar.b(this.oldStream, e16);
            this.oldStream.closeEntry();
            QZipInputStream qZipInputStream = new QZipInputStream(e16.d());
            cooperation.plugin.patch.b e17 = e();
            ZipPatcher zipPatcher = new ZipPatcher(qZipInputStream, new ZipOutputStream(e17.c()), this.tempDirectory, this.postProcessor, this.keepExtraInNestedZip);
            Map<String, ? extends cooperation.plugin.patch.b> map2 = this.filesInPatchStream;
            byte[] bArr = null;
            if (map2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filesInPatchStream");
                map2 = null;
            }
            zipPatcher.n(list, map2);
            c cVar = this.postProcessor;
            if (cVar != null) {
                if (cVar.a()) {
                    Object b16 = this.postProcessor.b(e17.b(), null);
                    if (b16 instanceof byte[]) {
                        bArr = (byte[]) b16;
                    }
                    e17 = j.b(bArr);
                } else {
                    String str = this.tempDirectory;
                    if (str == null) {
                        str = ".";
                    }
                    cooperation.plugin.patch.b a16 = j.a(str);
                    if (this.postProcessor.b(e17.a(), a16.a()) != null) {
                        e17 = a16;
                    }
                }
            }
            this.newStream.putNextEntry(j.d(new ZipEntry(name), Boolean.valueOf(!this.keepExtraInNestedZip)));
            iVar.a(e17, this.newStream);
            this.newStream.closeEntry();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(ZipEntry zipEntry, List<? extends PatchConfigBean> normalOps) throws IOException {
        for (PatchConfigBean patchConfigBean : normalOps) {
            if (Intrinsics.areEqual(zipEntry.getName(), patchConfigBean.f390333to)) {
                String str = patchConfigBean.f390332op;
                if (Intrinsics.areEqual(str, "u")) {
                    String str2 = patchConfigBean.f390333to;
                    String str3 = patchConfigBean.from;
                    String str4 = patchConfigBean.md5;
                    Map<String, ? extends cooperation.plugin.patch.b> map = this.filesInPatchStream;
                    if (map == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filesInPatchStream");
                        map = null;
                    }
                    q(str2, str3, str4, map.get(patchConfigBean.from));
                    return true;
                }
                if (Intrinsics.areEqual(str, "d")) {
                    g(patchConfigBean.f390333to);
                    return true;
                }
                String str5 = patchConfigBean.f390332op;
                Intrinsics.checkNotNullExpressionValue(str5, "op.op");
                h(str5, patchConfigBean.f390333to, patchConfigBean.from, patchConfigBean.md5);
                return true;
            }
        }
        return false;
    }

    private final void q(String toPath, String fromPath, String md5, cooperation.plugin.patch.b buffer) throws IOException {
        boolean equals;
        if (buffer != null) {
            if (md5 != null) {
                String g16 = i.f390366a.g(buffer);
                boolean z16 = false;
                if (g16 != null) {
                    equals = StringsKt__StringsJVMKt.equals(g16, md5, true);
                    if (equals) {
                        z16 = true;
                    }
                }
                if (!z16) {
                    this.newStream.closeEntry();
                    throw new IOException("md5 check error!");
                }
            }
            this.newStream.putNextEntry(j.d(new ZipEntry(toPath), Boolean.valueOf(!this.keepExtraInNestedZip)));
            i.f390366a.a(buffer, this.newStream);
            this.newStream.closeEntry();
        }
    }

    public final void l(@NotNull String patchZipPath) throws IOException {
        Intrinsics.checkNotNullParameter(patchZipPath, "patchZipPath");
        m(k(this, new QZipInputStream(new FileInputStream(patchZipPath)), null, 2, null), new QZipInputStream(new FileInputStream(patchZipPath)));
    }

    public final void m(@NotNull List<? extends PatchConfigBean> operations, @NotNull QZipInputStream patchStream) throws IOException {
        Intrinsics.checkNotNullParameter(operations, "operations");
        Intrinsics.checkNotNullParameter(patchStream, "patchStream");
        n(operations, i(patchStream, operations));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZipPatcher(@NotNull String oldZipPath, @NotNull String newZipPath, @Nullable String str, @Nullable c cVar, boolean z16) {
        this(new QZipInputStream(new FileInputStream(oldZipPath)), new ZipOutputStream(new FileOutputStream(newZipPath)), str, cVar, z16);
        Intrinsics.checkNotNullParameter(oldZipPath, "oldZipPath");
        Intrinsics.checkNotNullParameter(newZipPath, "newZipPath");
    }

    private final void g(String toPath) throws IOException {
    }
}
