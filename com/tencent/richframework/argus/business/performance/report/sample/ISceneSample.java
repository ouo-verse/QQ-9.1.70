package com.tencent.richframework.argus.business.performance.report.sample;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0006H&J\u0018\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0007J0\u0010\u0011\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005`\bH\u0002RC\u0010\u0003\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005`\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/sample/ISceneSample;", "", "()V", "sceneList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "", "Lkotlin/collections/ArrayList;", "getSceneList", "()Ljava/util/ArrayList;", "sceneList$delegate", "Lkotlin/Lazy;", "getCanLanKey", "getSampleSize", "key", "default", "initSceneList", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class ISceneSample {

    /* renamed from: sceneList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sceneList;

    public ISceneSample() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<Pair<? extends String, ? extends Float>>>() { // from class: com.tencent.richframework.argus.business.performance.report.sample.ISceneSample$sceneList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Pair<? extends String, ? extends Float>> invoke() {
                ArrayList<Pair<? extends String, ? extends Float>> initSceneList;
                initSceneList = ISceneSample.this.initSceneList();
                return initSceneList;
            }
        });
        this.sceneList = lazy;
    }

    private final ArrayList<Pair<String, Float>> getSceneList() {
        return (ArrayList) this.sceneList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Pair<String, Float>> initSceneList() {
        ArrayList<Pair<String, Float>> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(getCanLanKey(), ""));
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str == null) {
                    str = "";
                }
                arrayList.add(TuplesKt.to(str, Float.valueOf((float) jSONObject.optDouble(str))));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @NotNull
    public abstract String getCanLanKey();

    public final float getSampleSize(@Nullable String key, float r85) {
        boolean z16;
        Object obj;
        boolean contains$default;
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return r85;
        }
        Iterator<T> it = getSceneList().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) key, (CharSequence) ((Pair) next).getFirst(), false, 2, (Object) null);
            if (contains$default) {
                obj = next;
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            return ((Number) pair.getSecond()).floatValue();
        }
        return r85;
    }
}
