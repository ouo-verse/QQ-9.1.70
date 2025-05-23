package com.tencent.richframework.gallery.datacenter;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/gallery/datacenter/ExtraDataWrapper;", "", "", "toString", "", "hashCode", "other", "", "equals", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", WadlProxyConsts.EXTRA_DATA, "Ljava/lang/Object;", "getExtraData", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class ExtraDataWrapper {

    @NotNull
    private final Object extraData;

    @NotNull
    private final String key;

    public ExtraDataWrapper(@NotNull String key, @NotNull Object extraData) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.key = key;
        this.extraData = extraData;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ExtraDataWrapper) {
                ExtraDataWrapper extraDataWrapper = (ExtraDataWrapper) other;
                if (!Intrinsics.areEqual(this.key, extraDataWrapper.key) || !Intrinsics.areEqual(this.extraData, extraDataWrapper.extraData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        int i3;
        String str = this.key;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Object obj = this.extraData;
        if (obj != null) {
            i16 = obj.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ExtraDataWrapper(key=" + this.key + ", extraData=" + this.extraData + ")";
    }
}
