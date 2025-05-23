package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCntInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012<\u0010\u0011\u001a8\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tj \u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\r\u0018\u0001`\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003RM\u0010\u0011\u001a8\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tj \u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\r\u0018\u0001`\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/cd;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUnreadCntInfo;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "newUnreadCntInfo", "<init>", "(Ljava/util/HashMap;)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqguildsdk.data.cd, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class GProUnreadCntUpData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<Integer, ArrayList<GProUnreadCntInfo>> newUnreadCntInfo;

    public GProUnreadCntUpData(@Nullable HashMap<Integer, ArrayList<GProUnreadCntInfo>> hashMap) {
        this.newUnreadCntInfo = hashMap;
    }

    @Nullable
    public final HashMap<Integer, ArrayList<GProUnreadCntInfo>> a() {
        return this.newUnreadCntInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GProUnreadCntUpData) && Intrinsics.areEqual(this.newUnreadCntInfo, ((GProUnreadCntUpData) other).newUnreadCntInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        HashMap<Integer, ArrayList<GProUnreadCntInfo>> hashMap = this.newUnreadCntInfo;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "GProUnreadCntUpData(newUnreadCntInfo=" + this.newUnreadCntInfo + ')';
    }
}
