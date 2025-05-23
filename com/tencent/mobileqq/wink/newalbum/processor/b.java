package com.tencent.mobileqq.wink.newalbum.processor;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \n2\u00020\u0001:\u0001\tB\u001d\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u0011\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\u0004\u0018\u00010!8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "", "start", "g", "stop", DKHippyEvent.EVENT_STOP, "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "a", "i", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "data", h.F, "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "result", "f", "d", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "c", "()Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "next", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "traceId", "", "J", "()J", "setStartTime", "(J)V", "startTime", "Lz93/c;", "Lz93/c;", "getQualityReportApi", "()Lz93/c;", "qualityReportApi", "b", "logTag", "<init>", "(Lcom/tencent/mobileqq/wink/newalbum/processor/a;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a next;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String traceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final z93.c qualityReportApi;

    public b(@Nullable a aVar, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.next = aVar;
        this.traceId = traceId;
        this.qualityReportApi = Wink.INSTANCE.f();
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public String b() {
        return "WinkNewAlbum_BaseProcessor-";
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final a getNext() {
        return this.next;
    }

    /* renamed from: d, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public void f(@NotNull WinkNewMemoryAlbumResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (QLog.isColorLevel()) {
            QLog.d(b(), 1, "onCollectResult, albumID:" + result.getAlbumID() + ", albumName:" + result.getAlbumName());
        }
    }

    public abstract void g();

    public void h(@NotNull WinkPublishQualityReportData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        z93.c cVar = this.qualityReportApi;
        if (cVar != null) {
            cVar.a(data, 1);
        }
    }

    public void i(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = this.next;
        if (aVar != null) {
            aVar.a(context);
        }
    }

    public abstract void onStop();

    @Override // com.tencent.mobileqq.wink.newalbum.processor.a
    public void start() {
        QLog.d(b(), 1, "start ");
        this.startTime = System.currentTimeMillis();
        g();
        a aVar = this.next;
        if (aVar != null) {
            aVar.start();
        }
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.a
    public void stop() {
        QLog.d(b(), 1, "stop ");
        onStop();
        a aVar = this.next;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public /* synthetic */ b(a aVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar, (i3 & 2) != 0 ? "" : str);
    }
}
