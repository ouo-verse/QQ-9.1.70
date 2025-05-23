package com.tencent.mobileqq.zplan.filament.precompiled;

import com.tencent.filament.zplan.util.JsonUtilKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.m;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import uk0.e;
import vk0.b;
import vk0.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a#\u0010\u0005\u001a\u00020\u0004\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\t\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a\u001a\u0010\r\u001a\u00020\u0004*\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\"\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\n8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\"$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lvk0/b;", "Lvk0/c;", "T", "app", "", "e", "(Lvk0/b;)V", "Ljava/io/File;", "shadersDir", "f", "", "", "paths", h.F, "Ljava/lang/Object;", "a", "Ljava/lang/Object;", "compiledShaderLocker", "value", "c", "()Ljava/lang/Iterable;", "i", "(Ljava/lang/Iterable;)V", "compiledShaders", "d", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "compiledShadersString", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PreCompiledUtilKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f333450a = new Object();

    /* JADX WARN: Incorrect field signature: TT; */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/filament/precompiled/PreCompiledUtilKt$a", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f333451d;

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        a(b bVar) {
            this.f333451d = bVar;
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            b bVar = this.f333451d;
            File absoluteFile = new File(eventData).getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "File(eventData).absoluteFile");
            PreCompiledUtilKt.f(bVar, absoluteFile);
        }
    }

    private static final Iterable<File> c() {
        List split$default;
        int collectionSizeOrDefault;
        split$default = StringsKt__StringsKt.split$default((CharSequence) d(), new char[]{QbAddrData.DATA_SPLITER}, false, 0, 6, (Object) null);
        List list = split$default;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new File((String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((File) obj).exists()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private static final String d() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("zplan_filament_onDownloadShadersFinished", "");
    }

    public static final <T extends b & c> void e(T app) {
        Intrinsics.checkNotNullParameter(app, "app");
        T t16 = app;
        t16.removeEventListener("onDownloadShadersFinished");
        t16.c("onDownloadShadersFinished", new a(app));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b bVar, File file) {
        final Set set;
        final Set mutableSet;
        set = SequencesKt___SequencesKt.toSet(JsonUtilKt.a(JsonUtilKt.b(ZPlanFeatureSwitch.f369852a.v2(), "preCompiledShader", new JSONArray())));
        synchronized (f333450a) {
            mutableSet = CollectionsKt___CollectionsKt.toMutableSet(c());
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.mobileqq.zplan.filament.precompiled.a
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    boolean g16;
                    g16 = PreCompiledUtilKt.g(set, mutableSet, file2);
                    return g16;
                }
            });
            if (listFiles != null) {
                if (!(listFiles.length == 0)) {
                    CollectionsKt__MutableCollectionsKt.addAll(mutableSet, listFiles);
                    i(mutableSet);
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (File file2 : listFiles) {
                        String file3 = file2.toString();
                        Intrinsics.checkNotNullExpressionValue(file3, "it.toString()");
                        arrayList.add(file3);
                    }
                    h(bVar, arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Set needCompile, Set compiledSet, File it) {
        String extension;
        Intrinsics.checkNotNullParameter(needCompile, "$needCompile");
        Intrinsics.checkNotNullParameter(compiledSet, "$compiledSet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (needCompile.contains(it.getName()) && !compiledSet.contains(it)) {
            extension = FilesKt__UtilsKt.getExtension(it);
            if (Intrinsics.areEqual(extension, "filamat")) {
                return true;
            }
        }
        return false;
    }

    private static final void h(b bVar, Iterable<String> iterable) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paths", m.a(iterable));
        b.a.a(bVar, "preCompileShader", jSONObject.toString(), null, 4, null);
    }

    private static final void i(Iterable<? extends File> iterable) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(iterable, "|", null, null, 0, null, new Function1<File, CharSequence>() { // from class: com.tencent.mobileqq.zplan.filament.precompiled.PreCompiledUtilKt$compiledShaders$3
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String file = it.toString();
                Intrinsics.checkNotNullExpressionValue(file, "it.toString()");
                return file;
            }
        }, 30, null);
        j(joinToString$default);
    }

    private static final void j(String str) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_filament_onDownloadShadersFinished", str);
    }
}
