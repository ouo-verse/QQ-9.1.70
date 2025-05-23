package com.tencent.rdelivery.reshub.asset;

import android.content.Context;
import com.tencent.rdelivery.reshub.core.g;
import com.tencent.rdelivery.reshub.core.j;
import com.tencent.rdelivery.reshub.local.LocalResConfigManager;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jz3.d;
import jz3.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import nz3.b;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u001c\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\u0006R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/rdelivery/reshub/asset/PresetRes;", "", "", "d", "Landroid/content/Context;", "context", "", "presetResAssetBasePath", "f", "resId", "Ljz3/e;", "e", "a", "Lkotlin/Function0;", "thenDo", "b", "Lcom/tencent/rdelivery/reshub/api/g;", "c", "", "Ljava/util/Map;", "presetResConfigMap", "Lcom/tencent/rdelivery/reshub/asset/PresetResLoader;", "Lcom/tencent/rdelivery/reshub/asset/PresetResLoader;", "presetResLoader", "Lcom/tencent/rdelivery/reshub/core/a;", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "localConfigMgr", "<init>", "(Lcom/tencent/rdelivery/reshub/core/a;Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class PresetRes {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, e> presetResConfigMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final PresetResLoader presetResLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.core.a appInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LocalResConfigManager localConfigMgr;

    public PresetRes(@NotNull com.tencent.rdelivery.reshub.core.a appInfo, @NotNull LocalResConfigManager localConfigMgr) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(localConfigMgr, "localConfigMgr");
        this.appInfo = appInfo;
        this.localConfigMgr = localConfigMgr;
        this.presetResConfigMap = new ConcurrentHashMap();
        this.presetResLoader = new PresetResLoader(appInfo, localConfigMgr);
        d();
    }

    private final void d() {
        boolean z16;
        Object m476constructorimpl;
        Map<String, e> e16;
        Map<String, e> e17;
        String e18 = a.e(g.d(), a.d(this.appInfo) + "config.json");
        boolean z17 = true;
        if (e18.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (e17 = b.e(e18)) != null) {
            Map<String, e> map = this.presetResConfigMap;
            for (Map.Entry<String, e> entry : e17.entrySet()) {
                if (entry.getValue().f(entry.getKey())) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }
        d.a("PresetRes", "initPresetResConfig read config.json,presetResConfigMap.size = " + this.presetResConfigMap.size() + TokenParser.SP);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a.d(this.appInfo));
        sb5.append("manualConfig.json");
        String sb6 = sb5.toString();
        String e19 = a.e(g.d(), sb6);
        d.a("PresetRes", "initPresetResConfig manualPath = " + sb6);
        if (e19.length() <= 0) {
            z17 = false;
        }
        if (z17 && (e16 = b.e(e19)) != null) {
            Map<String, e> map2 = this.presetResConfigMap;
            for (Map.Entry<String, e> entry2 : e16.entrySet()) {
                if (entry2.getValue().f(entry2.getKey())) {
                    map2.put(entry2.getKey(), entry2.getValue());
                }
            }
        }
        d.e("PresetRes", "initPresetResConfig read manualConfig.json,presetResConfigMap.size = " + this.presetResConfigMap.size() + TokenParser.SP);
        j jVar = j.L;
        if (jVar.o()) {
            f(g.d(), a.d(this.appInfo));
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            jVar.x().a(this.appInfo, this.presetResConfigMap);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            d.d("PresetRes", "Process PresetResConfigs Exception: ", m479exceptionOrNullimpl);
        }
    }

    private final e e(String resId) {
        boolean z16;
        e m3 = this.localConfigMgr.m(resId);
        e eVar = this.presetResConfigMap.get(resId);
        if (eVar == null) {
            return null;
        }
        boolean z17 = false;
        if (m3 != null && m3.f411261b >= eVar.f411261b) {
            z16 = false;
        } else {
            z16 = true;
        }
        long j3 = eVar.f411261b;
        Intrinsics.checkExpressionValueIsNotNull(eVar.f411260a, "presetConfig.id");
        if (j3 >= g.g(r6, this.appInfo)) {
            z17 = true;
        }
        if (!z16 || !z17) {
            return null;
        }
        return eVar;
    }

    private final void f(Context context, String presetResAssetBasePath) {
        Object m476constructorimpl;
        Integer num;
        int i3;
        boolean z16;
        Map<String, e> e16;
        String dropLast;
        try {
            Result.Companion companion = Result.INSTANCE;
            String[] list = context.getAssets().list(presetResAssetBasePath);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("tryReadConfigInfoInPresetResKeyDir ,files count = ");
            Integer num2 = null;
            if (list != null) {
                num = Integer.valueOf(list.length);
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(TokenParser.SP);
            d.e("PresetRes", sb5.toString());
            if (list != null) {
                i3 = list.length;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                dropLast = StringsKt___StringsKt.dropLast(presetResAssetBasePath, File.separator.length());
                String[] list2 = context.getAssets().list(dropLast);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("tryReadConfigInfoInPresetResKeyDir ,folderPath = ");
                sb6.append(dropLast);
                sb6.append(", files count = ");
                if (list2 != null) {
                    num2 = Integer.valueOf(list2.length);
                }
                sb6.append(num2);
                sb6.append(TokenParser.SP);
                d.e("PresetRes", sb6.toString());
                list = list2;
            }
            if (list != null) {
                for (String str : list) {
                    String e17 = a.e(g.d(), presetResAssetBasePath + str + File.separator + "config.json");
                    if (e17.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && (e16 = b.e(e17)) != null) {
                        Map<String, e> map = this.presetResConfigMap;
                        for (Map.Entry<String, e> entry : e16.entrySet()) {
                            if (entry.getValue().f(entry.getKey())) {
                                map.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                }
            }
            d.e("PresetRes", "tryReadConfigInfoInPresetResKeyDir ,presetResConfigMap.size = " + this.presetResConfigMap.size() + TokenParser.SP);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            d.d("PresetRes", "tryReadConfigInfoInPresetResKeyDir Exception: " + m479exceptionOrNullimpl.getMessage(), m479exceptionOrNullimpl);
        }
    }

    public final void a(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        e e16 = e(resId);
        if (e16 != null) {
            this.presetResLoader.j(e16);
        }
    }

    public final void b(@NotNull String resId, @NotNull final Function0<Unit> thenDo) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        Intrinsics.checkParameterIsNotNull(thenDo, "thenDo");
        e e16 = e(resId);
        if (e16 != null) {
            this.presetResLoader.l(e16, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.asset.PresetRes$ensurePresetResLoaded$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Function0.this.invoke();
                }
            });
        } else {
            thenDo.invoke();
        }
    }

    @Nullable
    public final com.tencent.rdelivery.reshub.api.g c(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        return this.presetResConfigMap.get(resId);
    }
}
