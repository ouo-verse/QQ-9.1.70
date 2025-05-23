package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R+\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/t;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "msgAbstractInfos", "<init>", "(Ljava/util/ArrayList;)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqguildsdk.data.t, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class GProAbstractUpdateData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ArrayList<MsgAbstract> msgAbstractInfos;

    public GProAbstractUpdateData(@Nullable ArrayList<MsgAbstract> arrayList) {
        this.msgAbstractInfos = arrayList;
    }

    @Nullable
    public final ArrayList<MsgAbstract> a() {
        return this.msgAbstractInfos;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GProAbstractUpdateData) && Intrinsics.areEqual(this.msgAbstractInfos, ((GProAbstractUpdateData) other).msgAbstractInfos)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        ArrayList<MsgAbstract> arrayList = this.msgAbstractInfos;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    @NotNull
    public String toString() {
        return "GProAbstractUpdateData(msgAbstractInfos=" + this.msgAbstractInfos + ')';
    }
}
