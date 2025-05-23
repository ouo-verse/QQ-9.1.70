package kl2;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lkl2/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/google/gson/JsonObject;", "moduleConfigs", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: kl2.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class PreloadConfBean implements IConfigData {

    @SerializedName("module_config")
    @NotNull
    private final List<JsonObject> moduleConfigs;

    public PreloadConfBean(@NotNull List<JsonObject> moduleConfigs) {
        Intrinsics.checkNotNullParameter(moduleConfigs, "moduleConfigs");
        this.moduleConfigs = moduleConfigs;
    }

    @NotNull
    public final List<JsonObject> a() {
        return this.moduleConfigs;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof PreloadConfBean) && Intrinsics.areEqual(this.moduleConfigs, ((PreloadConfBean) other).moduleConfigs)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.moduleConfigs.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreloadConfBean(moduleConfigs=" + this.moduleConfigs + ')';
    }
}
