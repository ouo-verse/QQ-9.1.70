package jy3;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.pb.performance.ClientPerformance$SsoMonitorCollectorReportRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\b\u00a8\u0006\u0016"}, d2 = {"Ljy3/b;", "Ljy3/e;", "Lcom/tencent/pb/performance/ClientPerformance$SsoMonitorCollectorReportRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "toString", "Ljava/lang/String;", "type", "b", "image_layout_relation", "c", "stage", "d", "page", "e", "img_size", "f", "view_size", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jy3.b, reason: from toString */
/* loaded from: classes25.dex */
public final class LargeImageProblem extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String image_layout_relation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String stage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String page;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String img_size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String view_size;

    public LargeImageProblem(@NotNull String type, @NotNull String image_layout_relation, @NotNull String stage, @NotNull String page, @NotNull String img_size, @NotNull String view_size) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(image_layout_relation, "image_layout_relation");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(img_size, "img_size");
        Intrinsics.checkNotNullParameter(view_size, "view_size");
        this.type = type;
        this.image_layout_relation = image_layout_relation;
        this.stage = stage;
        this.page = page;
        this.img_size = img_size;
        this.view_size = view_size;
    }

    @Override // jy3.e
    public void a(@NotNull ClientPerformance$SsoMonitorCollectorReportRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.data.setHasFlag(true);
        request.data.large_image_monitor.setHasFlag(true);
        request.data.large_image_monitor.type.set(this.type);
        request.data.large_image_monitor.image_layout_relation.set(this.image_layout_relation);
        request.data.large_image_monitor.stage.set(this.stage);
        request.data.large_image_monitor.page.set(this.page);
        request.data.large_image_monitor.img_size.set(this.img_size);
        request.data.large_image_monitor.view_size.set(this.view_size);
        request.data.large_image_monitor.info.set(ky3.a.b(ky3.a.f413435a, null, 1, null));
    }

    @NotNull
    public String toString() {
        return "LargeImageProblem(type='" + this.type + "', image_layout_relation='" + this.image_layout_relation + "', stage='" + this.stage + "', page='" + this.page + "', img_size='" + this.img_size + "', view_size='" + this.view_size + "')";
    }
}
