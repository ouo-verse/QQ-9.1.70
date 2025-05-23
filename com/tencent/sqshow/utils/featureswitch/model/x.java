package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/x;", "", "", "", "enableScene", "Ljava/util/List;", "b", "()Ljava/util/List;", "enableUploadScene", "c", "enableCloudCacheScene", "a", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class x {

    @SerializedName("scene")
    private final List<Integer> enableScene = new ArrayList();

    @SerializedName("enable_upload_scene")
    private final List<Integer> enableUploadScene = new ArrayList();

    @SerializedName("enable_cloud_cache_scene")
    private final List<Integer> enableCloudCacheScene = new ArrayList();

    public final List<Integer> a() {
        return this.enableCloudCacheScene;
    }

    public final List<Integer> b() {
        return this.enableScene;
    }

    public final List<Integer> c() {
        return this.enableUploadScene;
    }
}
