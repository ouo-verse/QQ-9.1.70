package com.tencent.rdelivery.reshub.asset;

import android.content.res.AssetManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.rdelivery.reshub.api.e;
import com.tencent.rdelivery.reshub.core.ResLoadRequestPriority;
import com.tencent.rdelivery.reshub.core.g;
import com.tencent.rdelivery.reshub.local.LocalResConfigManager;
import com.tencent.rdelivery.reshub.report.ReportHelper;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import com.tencent.rdelivery.reshub.util.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jz3.b;
import jz3.c;
import jz3.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J:\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u001c\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dJ\"\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u001e\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0006R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/rdelivery/reshub/asset/PresetResLoader;", "", "Ljz3/e;", "resConfig", "", "i", "", "assetResDir", "fileResDir", "resId", "", "version", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "assetResPath", "fileResPath", "Lcom/tencent/rdelivery/reshub/api/e;", "pathParam", h.F, DomainData.DOMAIN_NAME, "", "c", "presetResPath", "targetResPath", "f", "d", "filePath", "e", DownloadInfo.spKey_Config, "g", "Lkotlin/Function0;", "thenDo", "l", "", Constants.Configs.CONFIGS, "k", "j", "", "failedType", "appId", "o", "Lcom/tencent/rdelivery/reshub/core/a;", "a", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "b", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "localConfigMgr", "<init>", "(Lcom/tencent/rdelivery/reshub/core/a;Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class PresetResLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.core.a appInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LocalResConfigManager localConfigMgr;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/reshub/asset/PresetResLoader$a", "Lcom/tencent/rdelivery/reshub/api/e;", "", "e", "f", "d", "c", "b", "g", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f364404b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ jz3.e f364405c;

        a(String str, jz3.e eVar) {
            this.f364404b = str;
            this.f364405c = eVar;
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @Nullable
        public String a() {
            return PresetResLoader.this.appInfo.getConfigStoreSuffix();
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @NotNull
        public String b() {
            return String.valueOf(this.f364405c.f411261b);
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @NotNull
        /* renamed from: c */
        public String getResId() {
            String resId = this.f364404b;
            Intrinsics.checkExpressionValueIsNotNull(resId, "resId");
            return resId;
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @NotNull
        public String d() {
            return PresetResLoader.this.appInfo.i();
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @NotNull
        public String e() {
            return PresetResLoader.this.appInfo.c();
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @NotNull
        public String f() {
            return m.e(PresetResLoader.this.appInfo.getTarget());
        }

        @Override // com.tencent.rdelivery.reshub.api.e
        @NotNull
        public String g() {
            String str = this.f364405c.f411266g;
            Intrinsics.checkExpressionValueIsNotNull(str, "resConfig.downloadUrl");
            return str;
        }
    }

    public PresetResLoader(@NotNull com.tencent.rdelivery.reshub.core.a appInfo, @NotNull LocalResConfigManager localConfigMgr) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(localConfigMgr, "localConfigMgr");
        this.appInfo = appInfo;
        this.localConfigMgr = localConfigMgr;
    }

    private final boolean c(jz3.e resConfig) {
        boolean z16;
        Long l3;
        LocalResConfigManager localResConfigManager = this.localConfigMgr;
        String str = resConfig.f411260a;
        Intrinsics.checkExpressionValueIsNotNull(str, "resConfig.id");
        jz3.e m3 = localResConfigManager.m(str);
        if (m3 != null && m3.f411261b >= resConfig.f411261b) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PresetRes No Need to Load/Update. ResId: ");
            sb5.append(resConfig.f411260a);
            sb5.append(" Preset Ver: ");
            sb5.append(resConfig.f411261b);
            sb5.append(" Local Ver: ");
            if (m3 != null) {
                l3 = Long.valueOf(m3.f411261b);
            } else {
                l3 = null;
            }
            sb5.append(l3);
            d.i("PresetResLoader", sb5.toString());
        }
        return z16;
    }

    private final boolean d(String presetResPath, String targetResPath) {
        boolean startsWith$default;
        String removePrefix;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(presetResPath, "file://", false, 2, null);
        if (startsWith$default) {
            removePrefix = StringsKt__StringsKt.removePrefix(presetResPath, (CharSequence) "file://");
            FilesKt__UtilsKt.copyTo$default(new File(removePrefix), new File(targetResPath), true, 0, 4, null);
            return true;
        }
        return false;
    }

    private final void e(String filePath) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            c.f(new File(filePath), true);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            d.d("PresetResLoader", "Clean File Exception: " + m479exceptionOrNullimpl.getMessage(), m479exceptionOrNullimpl);
        }
    }

    private final void f(String presetResPath, String targetResPath) {
        try {
            c.n(targetResPath);
            e(targetResPath);
            if (d(presetResPath, targetResPath)) {
                return;
            }
            com.tencent.rdelivery.reshub.asset.a.c(g.d(), presetResPath, new File(targetResPath));
        } catch (Exception e16) {
            d.d("PresetResLoader", "Copy Preset Res File(" + presetResPath + " -> " + targetResPath + ") Exception: " + e16.getMessage(), e16);
        }
    }

    private final String g(jz3.e config) {
        String substringAfterLast$default;
        String str = config.f411266g;
        Intrinsics.checkExpressionValueIsNotNull(str, "config.downloadUrl");
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, "/", (String) null, 2, (Object) null);
        return com.tencent.rdelivery.reshub.asset.a.d(this.appInfo) + config.f411260a + File.separator + substringAfterLast$default;
    }

    private final void h(String assetResPath, String fileResPath, jz3.e resConfig, e pathParam, String resId, long version) {
        boolean z16;
        f(assetResPath, fileResPath);
        boolean z17 = true;
        if (c.b(fileResPath, resConfig.f411265f, resConfig.f411264e)) {
            if (g.i(this.appInfo, resConfig)) {
                String l3 = b.l(pathParam);
                if (g.b(fileResPath, l3, false, null, 12, null) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean e16 = b.e(resConfig.f411271l, resConfig.f411270k, l3, false, 8, null);
                if (z16 && e16) {
                    resConfig.G = l3;
                    resConfig.H = fileResPath;
                } else {
                    d.c("PresetResLoader", "Invalid Unzipped PresetRes File (Unzip: " + z16 + " MD5Check: " + e16 + "), Delete.  ResId: " + resId + " Ver: " + version + " FileResPath: " + fileResPath + " AssetResPath: " + assetResPath + " UnzippedPath: " + l3);
                    e(l3);
                    o(resConfig, 2, this.appInfo.c());
                }
            } else {
                resConfig.G = fileResPath;
                resConfig.H = fileResPath;
            }
            String str = resConfig.G;
            if (str != null && str.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                n(resConfig);
                return;
            }
            return;
        }
        d.c("PresetResLoader", "Invalid PresetRes File (MD5 Check Fail), Delete. ResId: " + resId + " FileResPath: " + fileResPath + " AssetResPath: " + assetResPath);
        e(fileResPath);
        o(resConfig, 1, this.appInfo.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void i(jz3.e resConfig) {
        boolean endsWith$default;
        if (!c(resConfig)) {
            return;
        }
        String str = resConfig.f411260a;
        long j3 = resConfig.f411261b;
        a aVar = new a(str, resConfig);
        String k3 = b.k(aVar);
        String str2 = resConfig.M;
        if (str2 == null) {
            str2 = g(resConfig);
        }
        String str3 = str2;
        d.e("PresetResLoader", "Loading PresetRes... ResId: " + str + " Ver:" + j3 + " FileResPath: " + k3 + " AssetResPath: " + str3);
        if (resConfig.B == 1) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str3, ".zip", false, 2, null);
            if (endsWith$default) {
                str3 = str3.subSequence(0, str3.length() - 4).toString();
            }
            String l3 = b.l(aVar);
            d.e("PresetResLoader", "Loading UnzippedBuiltIn PresetRes... ResId: " + str + " Ver:" + j3 + " fileResDir: " + l3 + " assetResDir: " + str3);
            m(str3, l3, resConfig, str, j3);
        } else {
            h(str3, k3, resConfig, aVar, str, j3);
        }
    }

    private final void m(String assetResDir, String fileResDir, jz3.e resConfig, String resId, long version) {
        boolean z16;
        AssetManager assets = g.d().getAssets();
        Intrinsics.checkExpressionValueIsNotNull(assets, "getContext().assets");
        com.tencent.rdelivery.reshub.asset.a.b(assets, assetResDir, fileResDir);
        boolean e16 = b.e(resConfig.f411271l, resConfig.f411270k, fileResDir, false, 8, null);
        d.e("PresetResLoader", "Loading UnzippedBuiltIn PresetRes... copyAssetFolder finish. ResId: " + resId + " Ver:" + version + " fileResDir: " + fileResDir + " assetResDir: " + assetResDir + " fileValid:" + e16);
        if (e16) {
            resConfig.G = fileResDir;
            resConfig.H = fileResDir;
            if (fileResDir != null && fileResDir.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                n(resConfig);
                return;
            }
            return;
        }
        d.c("PresetResLoader", "Invalid BuiltIn Unzipped PresetRes File (MD5Check: " + e16 + "), Delete.  ResId: " + resId + " Ver: " + version + " fileResDir: " + fileResDir + " AssetResPath: " + assetResDir);
        e(fileResDir);
        o(resConfig, 3, this.appInfo.c());
    }

    private final void n(jz3.e resConfig) {
        Long longOrNull;
        boolean z16 = true;
        resConfig.N = true;
        this.localConfigMgr.z(resConfig);
        String str = resConfig.f411279t;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            String str2 = resConfig.f411279t;
            Intrinsics.checkExpressionValueIsNotNull(str2, "resConfig.task_id");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
            if (longOrNull != null) {
                this.localConfigMgr.A(longOrNull.longValue(), resConfig);
            }
        }
        d.e("PresetResLoader", "PresetRes Loaded, ResId: " + resConfig.f411260a + " Ver: " + resConfig.f411261b + " LocalPath: " + resConfig.G + " OriginFilePath: " + resConfig.H);
    }

    public final void j(@NotNull jz3.e config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        i(config);
        d.e("PresetResLoader", "PresetRes Load Sync Finish: " + config.f411260a);
    }

    public final void k(@NotNull final List<? extends jz3.e> configs, @NotNull final Function0<Unit> thenDo) {
        int collectionSizeOrDefault;
        Intrinsics.checkParameterIsNotNull(configs, "configs");
        Intrinsics.checkParameterIsNotNull(thenDo, "thenDo");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Start Loading PresetRes Async: ");
        List<? extends jz3.e> list = configs;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((jz3.e) it.next()).f411260a);
        }
        sb5.append(arrayList);
        sb5.append('.');
        d.e("PresetResLoader", sb5.toString());
        ThreadUtil.f364593c.b("PresetResLoad", ResLoadRequestPriority.High, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.asset.PresetResLoader$loadResAsync$2
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
                Iterator it5 = configs.iterator();
                while (it5.hasNext()) {
                    PresetResLoader.this.i((jz3.e) it5.next());
                }
                ThreadUtil.f364593c.e(new Runnable() { // from class: com.tencent.rdelivery.reshub.asset.PresetResLoader$loadResAsync$2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.e("PresetResLoader", "PresetRes Load Finish.");
                        thenDo.invoke();
                    }
                });
            }
        });
    }

    public final void l(@NotNull jz3.e config, @NotNull Function0<Unit> thenDo) {
        List<? extends jz3.e> listOf;
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(thenDo, "thenDo");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(config);
        k(listOf, thenDo);
    }

    public final void o(@NotNull jz3.e resConfig, int failedType, @NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        new ReportHelper().g(resConfig, failedType, appId);
    }
}
