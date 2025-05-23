package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.zplan.record.model.CloudSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ae;", "", "Lcom/tencent/zplan/record/a;", "scene", "", "enableFilament", "a", "b", "d", "Lcom/tencent/zplan/record/model/b;", "c", "Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "enableCloudCacheSceneList", "Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "getEnableCloudCacheSceneList", "()Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "setEnableCloudCacheSceneList", "(Lcom/tencent/sqshow/utils/featureswitch/model/ag;)V", "enableUploadSceneList", "getEnableUploadSceneList", "setEnableUploadSceneList", "uploadToIDCSceneList", "getUploadToIDCSceneList", "setUploadToIDCSceneList", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ae {

    @SerializedName("enable_cloud_cache_scene")
    private ag enableCloudCacheSceneList = new ag();

    @SerializedName("enable_upload_scene")
    private ag enableUploadSceneList = new ag();

    @SerializedName("upload_to_idc")
    private ag uploadToIDCSceneList = new ag();

    private final boolean a(com.tencent.zplan.record.a scene, boolean enableFilament) {
        return this.enableCloudCacheSceneList.a(scene, enableFilament);
    }

    private final boolean b(com.tencent.zplan.record.a scene, boolean enableFilament) {
        return this.enableUploadSceneList.a(scene, enableFilament);
    }

    private final boolean d(com.tencent.zplan.record.a scene, boolean enableFilament) {
        return this.uploadToIDCSceneList.a(scene, enableFilament);
    }

    public final CloudSwitches c(com.tencent.zplan.record.a scene, boolean enableFilament) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return new CloudSwitches(a(scene, enableFilament), b(scene, enableFilament), d(scene, enableFilament));
    }
}
