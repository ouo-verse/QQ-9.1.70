package com.tencent.mobileqq.wink.h5native;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishDataReport", "", "", "component1", "component2", "scene", "activity_id", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PublishDataReport;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "getActivity_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PublishDataReport, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PublishDataReport {

    @NotNull
    private final String activity_id;

    @NotNull
    private final String scene;

    public PublishDataReport(@NotNull String scene, @NotNull String activity_id) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(activity_id, "activity_id");
        this.scene = scene;
        this.activity_id = activity_id;
    }

    public static /* synthetic */ PublishDataReport copy$default(PublishDataReport publishDataReport, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = publishDataReport.scene;
        }
        if ((i3 & 2) != 0) {
            str2 = publishDataReport.activity_id;
        }
        return publishDataReport.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getActivity_id() {
        return this.activity_id;
    }

    @NotNull
    public final PublishDataReport copy(@NotNull String scene, @NotNull String activity_id) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(activity_id, "activity_id");
        return new PublishDataReport(scene, activity_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishDataReport)) {
            return false;
        }
        PublishDataReport publishDataReport = (PublishDataReport) other;
        if (Intrinsics.areEqual(this.scene, publishDataReport.scene) && Intrinsics.areEqual(this.activity_id, publishDataReport.activity_id)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getActivity_id() {
        return this.activity_id;
    }

    @NotNull
    public final String getScene() {
        return this.scene;
    }

    public int hashCode() {
        return (this.scene.hashCode() * 31) + this.activity_id.hashCode();
    }

    @NotNull
    public String toString() {
        return "PublishDataReport(scene=" + this.scene + ", activity_id=" + this.activity_id + ")";
    }
}
