package com.tencent.mobileqq.zplan.easteregg.repository;

import ci3.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.avatar.image.easterEgg.ZPlanAvatarEasterEggPortraitCacheManager;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.PortraitQueryType;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ResultCode;
import com.tencent.mobileqq.zplan.servlet.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import nk3.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 &2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b$\u0010%J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J<\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010#\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/RemoteRepository;", "", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "", "", "zipUrlList", "Ljava/io/File;", "currLocalDir", "Lhh3/a;", "listener", "", "retryCount", "", "g", "Lkotlin/Function0;", "downloadFailHandler", h.F, "", "e", "url", "downloadFile", "Lci3/a$a;", "downloadListener", "i", "cacheDir", "l", "appearanceKey", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "a", "Lkotlin/Lazy;", "j", "()Ljava/io/File;", "localCacheDir", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RemoteRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy localCacheDir;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333049a;

        static {
            int[] iArr = new int[PortraitQueryType.values().length];
            try {
                iArr[PortraitQueryType.BATCH_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PortraitQueryType.SINGLE_QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f333049a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/repository/RemoteRepository$c", "Lci3/a$a;", "", "isSuccess", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements a.InterfaceC0194a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333050a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f333051b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f333052c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f333053d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f333054e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f333055f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ RemoteRepository f333056g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.model.d f333057h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ hh3.a f333058i;

        c(Ref.IntRef intRef, String str, Function0<Unit> function0, File file, File file2, Ref.BooleanRef booleanRef, RemoteRepository remoteRepository, com.tencent.mobileqq.zplan.easteregg.model.d dVar, hh3.a aVar) {
            this.f333050a = intRef;
            this.f333051b = str;
            this.f333052c = function0;
            this.f333053d = file;
            this.f333054e = file2;
            this.f333055f = booleanRef;
            this.f333056g = remoteRepository;
            this.f333057h = dVar;
            this.f333058i = aVar;
        }

        @Override // ci3.a.InterfaceC0194a
        public void onResult(boolean isSuccess) {
            QLog.i("[EasterEggResource]RemoteRepository", 1, "download zip success: " + isSuccess);
            Ref.IntRef intRef = this.f333050a;
            intRef.element = intRef.element - 1;
            if (!isSuccess) {
                QLog.e("[EasterEggResource]RemoteRepository", 1, "downloadZipPackage failed, url: " + this.f333051b);
                this.f333052c.invoke();
            }
            if (isSuccess) {
                com.tencent.mobileqq.zplan.avatar.image.easterEgg.a.f331822a.c(this.f333053d, this.f333054e);
            }
            if (this.f333050a.element == 0) {
                this.f333055f.element = true;
                this.f333056g.l(this.f333057h, this.f333053d, this.f333058i);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/repository/RemoteRepository$d", "Lnk3/g;", "", "", "zipUrlList", "", "lastUploadTime", "", "a", "errMsg", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333059a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.model.d f333060b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ hh3.a f333061c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RemoteRepository f333062d;

        d(String str, com.tencent.mobileqq.zplan.easteregg.model.d dVar, hh3.a aVar, RemoteRepository remoteRepository) {
            this.f333059a = str;
            this.f333060b = dVar;
            this.f333061c = aVar;
            this.f333062d = remoteRepository;
        }

        @Override // nk3.g
        public void a(List<String> zipUrlList, long lastUploadTime) {
            Intrinsics.checkNotNullParameter(zipUrlList, "zipUrlList");
            if (ZPlanAvatarEasterEggPortraitCacheManager.f331820a.f(lastUploadTime, this.f333059a, this.f333060b.b())) {
                QLog.i("[EasterEggResource]RemoteRepository", 1, "cache out of date, already cleared local cache, key: " + this.f333059a);
                this.f333061c.b(null);
                return;
            }
            if (this.f333060b.b() == null || !this.f333062d.m(this.f333060b, this.f333061c)) {
                File file = new File(this.f333062d.j(), this.f333059a);
                if (file.exists() && file.isDirectory()) {
                    FileUtils.deleteFilesInDirectory(file.getAbsolutePath());
                } else {
                    file.mkdirs();
                }
                this.f333062d.g(this.f333060b, zipUrlList, file, this.f333061c, 3);
            }
        }

        @Override // nk3.g
        public void onError(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f333061c.a(PortraitSource.REMOTE, errMsg);
        }
    }

    public RemoteRepository() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.RemoteRepository$localCacheDir$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return di3.b.f393984a.c("zplan/easteregg/portrait/");
            }
        });
        this.localCacheDir = lazy;
    }

    private final boolean e(List<String> zipUrlList) {
        if (!zipUrlList.isEmpty()) {
            return true;
        }
        QLog.e("[EasterEggResource]RemoteRepository", 1, "check before download failed, zip url list empty.");
        return false;
    }

    private final String f(String appearanceKey, String url) {
        if (url.length() == 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(appearanceKey + "_");
        sb5.append(url);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        String c16 = com.tencent.zplan.common.utils.d.c(sb6);
        Intrinsics.checkNotNullExpressionValue(c16, "toMD5(md5Content)");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = c16.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final com.tencent.mobileqq.zplan.easteregg.model.d param, final List<String> zipUrlList, final File currLocalDir, final hh3.a listener, final int retryCount) {
        h(param, zipUrlList, currLocalDir, listener, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.RemoteRepository$downloadZip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i3 = retryCount - 1;
                QLog.i("[EasterEggResource]RemoteRepository", 1, "retry download zip, curr retry count: " + i3);
                if (i3 > 0) {
                    this.g(param, zipUrlList, currLocalDir, listener, i3);
                } else {
                    listener.b(null);
                }
            }
        });
    }

    private final void i(String url, File downloadFile, a.InterfaceC0194a downloadListener) {
        ci3.a.f30972a.a("scene_easter_egg_avatar_portrait", url, downloadFile, downloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File j() {
        return (File) this.localCacheDir.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.tencent.mobileqq.zplan.easteregg.model.d param, File cacheDir, hh3.a listener) {
        List<Integer> e16;
        int i3 = b.f333049a[param.getType().ordinal()];
        if (i3 == 1) {
            e16 = param.e();
        } else if (i3 == 2) {
            Integer[] numArr = new Integer[1];
            Integer id5 = param.getId();
            numArr[0] = Integer.valueOf(id5 != null ? id5.intValue() : -1);
            e16 = CollectionsKt__CollectionsKt.mutableListOf(numArr);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        List<Integer> list = e16;
        if (!list.isEmpty() && (list.size() != 1 || list.get(0).intValue() >= 0)) {
            if (cacheDir.exists() && cacheDir.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    File file = new File(cacheDir + "/" + intValue + ".png");
                    if (file.exists()) {
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "pngFileIfExists.absolutePath");
                        arrayList.add(absolutePath);
                        list.remove(Integer.valueOf(intValue));
                    }
                }
                if (list.isEmpty()) {
                    listener.b(new ResultData(ResultCode.SUCCESS, list, arrayList, PortraitSource.REMOTE, null, null, 48, null));
                    return;
                } else {
                    listener.b(null);
                    return;
                }
            }
            listener.b(null);
            return;
        }
        listener.b(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(com.tencent.mobileqq.zplan.easteregg.model.d param, hh3.a listener) {
        List<Integer> e16;
        String appearanceKey = param.getAppearanceKey();
        int i3 = b.f333049a[param.getType().ordinal()];
        if (i3 == 1) {
            e16 = param.e();
        } else if (i3 == 2) {
            Integer id5 = param.getId();
            e16 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(id5 != null ? id5.intValue() : -1));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        List<Integer> list = e16;
        List<String> j3 = ZPlanAvatarEasterEggPortraitCacheManager.f331820a.j(appearanceKey, list);
        List<String> list2 = j3;
        if (list2 == null || list2.isEmpty()) {
            QLog.i("[EasterEggResource]RemoteRepository", 1, "tryGetLocalCacheAgain failed, do remote query.");
            return false;
        }
        QLog.i("[EasterEggResource]RemoteRepository", 1, "tryGetLocalCacheAgain success, key: " + appearanceKey + ".");
        listener.b(new ResultData(ResultCode.SUCCESS, list, j3, PortraitSource.LOCAL, null, null, 48, null));
        return true;
    }

    public void k(com.tencent.mobileqq.zplan.easteregg.model.d param, hh3.a listener) {
        String str;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!ZPlanFeatureSwitch.f369852a.q0()) {
            listener.b(null);
            return;
        }
        String appearanceKey = param.getAppearanceKey();
        List<Integer> e16 = param.e();
        if (!(appearanceKey.length() == 0) && !e16.isEmpty()) {
            if (AppSetting.isPublicVersion()) {
                str = appearanceKey;
            } else {
                str = appearanceKey + "_TEST";
            }
            i.f335409a.e(str, new d(appearanceKey, param, listener, this));
            return;
        }
        QLog.e("[EasterEggResource]RemoteRepository", 1, "remote query failed, param invalid, requestAppearanceKey: " + appearanceKey + ", requestIdList: " + e16);
        listener.a(PortraitSource.REMOTE, "remote request, param invalid.");
    }

    private final void h(com.tencent.mobileqq.zplan.easteregg.model.d param, List<String> zipUrlList, File currLocalDir, hh3.a listener, Function0<Unit> downloadFailHandler) {
        String str;
        Ref.IntRef intRef;
        if (!e(zipUrlList)) {
            listener.b(null);
            return;
        }
        String appearanceKey = param.getAppearanceKey();
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = zipUrlList.size();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (String str2 : zipUrlList) {
            String f16 = f(appearanceKey, str2);
            if (f16 == null || f16.length() == 0) {
                QLog.e("[EasterEggResource]RemoteRepository", 1, "check before download error, url: " + str2);
                str = appearanceKey;
                intRef = intRef2;
            } else {
                File file = new File(currLocalDir, f16 + ".zip");
                str = appearanceKey;
                intRef = intRef2;
                i(str2, file, new c(intRef2, str2, downloadFailHandler, currLocalDir, file, booleanRef, this, param, listener));
            }
            appearanceKey = str;
            intRef2 = intRef;
        }
        if (booleanRef.element) {
            return;
        }
        listener.b(null);
    }
}
