package com.tencent.zplan.record.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/record/model/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/zplan/record/model/d;", "a", "Lcom/tencent/zplan/record/model/d;", "b", "()Lcom/tencent/zplan/record/model/d;", "setRenderSwitches", "(Lcom/tencent/zplan/record/model/d;)V", "renderSwitches", "Lcom/tencent/zplan/record/model/b;", "Lcom/tencent/zplan/record/model/b;", "()Lcom/tencent/zplan/record/model/b;", "setCloudSwitches", "(Lcom/tencent/zplan/record/model/b;)V", "cloudSwitches", "<init>", "(Lcom/tencent/zplan/record/model/d;Lcom/tencent/zplan/record/model/b;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.record.model.c, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class GeneralRecordSwitches {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private RenderSwitches renderSwitches;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private CloudSwitches cloudSwitches;

    public GeneralRecordSwitches() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CloudSwitches getCloudSwitches() {
        return this.cloudSwitches;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RenderSwitches getRenderSwitches() {
        return this.renderSwitches;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GeneralRecordSwitches) {
                GeneralRecordSwitches generalRecordSwitches = (GeneralRecordSwitches) other;
                if (!Intrinsics.areEqual(this.renderSwitches, generalRecordSwitches.renderSwitches) || !Intrinsics.areEqual(this.cloudSwitches, generalRecordSwitches.cloudSwitches)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        RenderSwitches renderSwitches = this.renderSwitches;
        int i16 = 0;
        if (renderSwitches != null) {
            i3 = renderSwitches.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        CloudSwitches cloudSwitches = this.cloudSwitches;
        if (cloudSwitches != null) {
            i16 = cloudSwitches.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "GeneralRecordSwitches(renderSwitches=" + this.renderSwitches + ", cloudSwitches=" + this.cloudSwitches + ")";
    }

    public GeneralRecordSwitches(@NotNull RenderSwitches renderSwitches, @NotNull CloudSwitches cloudSwitches) {
        Intrinsics.checkNotNullParameter(renderSwitches, "renderSwitches");
        Intrinsics.checkNotNullParameter(cloudSwitches, "cloudSwitches");
        this.renderSwitches = renderSwitches;
        this.cloudSwitches = cloudSwitches;
    }

    public /* synthetic */ GeneralRecordSwitches(RenderSwitches renderSwitches, CloudSwitches cloudSwitches, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new RenderSwitches(false, false, false, 7, null) : renderSwitches, (i3 & 2) != 0 ? new CloudSwitches(false, false, false, 7, null) : cloudSwitches);
    }
}
