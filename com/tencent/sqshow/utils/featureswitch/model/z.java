package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.zplan.common.utils.GsonUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/z;", "", "", "toString", "", "enableFilament", "Z", "a", "()Z", "", "", "enableScenesOnPublic", "Ljava/util/List;", "d", "()Ljava/util/List;", "enableScenesOnDebug", "getEnableScenesOnDebug", "enableJSApp", "b", "enableNativeApp", "c", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class z {

    @SerializedName("enableFilament")
    private final boolean enableFilament = true;

    @SerializedName("enableJSApp")
    private final boolean enableJSApp;

    @SerializedName("enableNativeApp")
    private final boolean enableNativeApp;

    @SerializedName("enableScenesOnDebug")
    private final List<Integer> enableScenesOnDebug;

    @SerializedName("enableScenesOnPublic")
    private final List<Integer> enableScenesOnPublic;

    public z() {
        List<Integer> mutableListOf;
        List<Integer> mutableListOf2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0, 1, 2, 3);
        this.enableScenesOnPublic = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(0, 1, 2, 3);
        this.enableScenesOnDebug = mutableListOf2;
        this.enableNativeApp = true;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableFilament() {
        return this.enableFilament;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableJSApp() {
        return this.enableJSApp;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableNativeApp() {
        return this.enableNativeApp;
    }

    public final List<Integer> d() {
        return this.enableScenesOnPublic;
    }

    public String toString() {
        String json = GsonUtil.f385283b.a().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "GsonUtil.gson.toJson(this)");
        return json;
    }
}
