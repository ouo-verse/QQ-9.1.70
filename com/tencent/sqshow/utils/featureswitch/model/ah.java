package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ah;", "", "", "toString", "", "gpuBlackList", "Ljava/util/List;", "a", "()Ljava/util/List;", "modelBlackList", "b", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ah {

    @SerializedName("GPUBlackList")
    private final List<String> gpuBlackList = new ArrayList();

    @SerializedName("model_black_list")
    private final List<String> modelBlackList = new ArrayList();

    public final List<String> a() {
        return this.gpuBlackList;
    }

    public final List<String> b() {
        return this.modelBlackList;
    }

    public String toString() {
        return "gpuBlackList=" + this.gpuBlackList + ", modelBlackList=" + this.modelBlackList;
    }
}
