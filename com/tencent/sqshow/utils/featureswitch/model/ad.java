package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.zplan.common.utils.GsonUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ad;", "", "", "toString", "", "enable", "Z", "b", "()Z", "", "memory", UserInfo.SEX_FEMALE, "c", "()F", "", "apiLevel", "I", "a", "()I", "", "modelBlackList", "Ljava/util/List;", "d", "()Ljava/util/List;", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ad {

    @SerializedName("enable")
    private final boolean enable = true;

    @SerializedName("memory")
    private final float memory = 1.0f;

    @SerializedName("apiLevel")
    private final int apiLevel = 16;

    @SerializedName("modelBlackList")
    private final List<String> modelBlackList = new ArrayList();

    /* renamed from: a, reason: from getter */
    public final int getApiLevel() {
        return this.apiLevel;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: c, reason: from getter */
    public final float getMemory() {
        return this.memory;
    }

    public final List<String> d() {
        return this.modelBlackList;
    }

    public String toString() {
        try {
            String json = GsonUtil.f385283b.a().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "{\n            GsonUtil.gson.toJson(this)\n        }");
            return json;
        } catch (Throwable unused) {
            return "";
        }
    }
}
