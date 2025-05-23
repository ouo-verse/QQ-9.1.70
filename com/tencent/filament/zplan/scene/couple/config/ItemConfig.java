package com.tencent.filament.zplan.scene.couple.config;

import com.tencent.ark.ark;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0012B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0003\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/ItemConfig;", "", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "a", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "c", "()Lcom/tencent/filament/zplan/scene/couple/config/d;", "d", "(Lcom/tencent/filament/zplan/scene/couple/config/d;)V", "transform", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "mesh", "anim", "<init>", "(Lcom/tencent/filament/zplan/scene/couple/config/d;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ItemConfig {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d transform;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String mesh;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String anim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/ItemConfig$Companion;", "", "", "directory", "Lcom/tencent/filament/zplan/scene/couple/config/ItemConfig;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(@NotNull String str, @NotNull Continuation<? super ItemConfig> continuation) {
            ItemConfig$Companion$from$1 itemConfig$Companion$from$1;
            Object coroutine_suspended;
            int i3;
            JSONObject jSONObject;
            d b16;
            String str2;
            if (continuation instanceof ItemConfig$Companion$from$1) {
                itemConfig$Companion$from$1 = (ItemConfig$Companion$from$1) continuation;
                int i16 = itemConfig$Companion$from$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    itemConfig$Companion$from$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = itemConfig$Companion$from$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = itemConfig$Companion$from$1.label;
                    String str3 = null;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            str = (String) itemConfig$Companion$from$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                        String filePathInDir = filamentFileUtil.filePathInDir(str, "item_config", ark.ARKMETADATA_JSON);
                        if (filePathInDir != null) {
                            itemConfig$Companion$from$1.L$0 = str;
                            itemConfig$Companion$from$1.label = 1;
                            obj = filamentFileUtil.readJsonFile(filePathInDir, itemConfig$Companion$from$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return null;
                    }
                    jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
                        if (optJSONObject == null || (b16 = d.INSTANCE.b(optJSONObject)) == null) {
                            b16 = d.INSTANCE.b(jSONObject);
                        }
                        String optString = jSONObject.optString("mesh");
                        String optString2 = jSONObject.optString("anim");
                        if (optString != null) {
                            str2 = str + '/' + optString;
                        } else {
                            str2 = null;
                        }
                        if (optString2 != null) {
                            str3 = str + '/' + optString2;
                        }
                        return new ItemConfig(b16, str2, str3);
                    }
                    return null;
                }
            }
            itemConfig$Companion$from$1 = new ItemConfig$Companion$from$1(this, continuation);
            Object obj2 = itemConfig$Companion$from$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = itemConfig$Companion$from$1.label;
            String str32 = null;
            if (i3 == 0) {
            }
            jSONObject = (JSONObject) obj2;
            if (jSONObject != null) {
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ItemConfig(@Nullable d dVar, @Nullable String str, @Nullable String str2) {
        this.transform = dVar;
        this.mesh = str;
        this.anim = str2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAnim() {
        return this.anim;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMesh() {
        return this.mesh;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final d getTransform() {
        return this.transform;
    }

    public final void d(@Nullable d dVar) {
        this.transform = dVar;
    }
}
