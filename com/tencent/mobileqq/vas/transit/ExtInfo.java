package com.tencent.mobileqq.vas.transit;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/transit/ExtInfo;", "Ljava/io/Serializable;", "()V", "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setSource", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "ueExtras", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getUeExtras", "()Ljava/util/HashMap;", "setUeExtras", "(Ljava/util/HashMap;)V", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ExtInfo implements Serializable {

    @Nullable
    private ZootopiaSource source;

    @Nullable
    private HashMap<String, Object> ueExtras;

    @Nullable
    public final ZootopiaSource getSource() {
        return this.source;
    }

    @Nullable
    public final HashMap<String, Object> getUeExtras() {
        return this.ueExtras;
    }

    public final void setSource(@Nullable ZootopiaSource zootopiaSource) {
        this.source = zootopiaSource;
    }

    public final void setUeExtras(@Nullable HashMap<String, Object> hashMap) {
        this.ueExtras = hashMap;
    }

    @NotNull
    public String toString() {
        return "ExtInfo(ueExtras=" + this.ueExtras + ')';
    }
}
