package com.tencent.biz.qqcircle.wink;

import android.graphics.Bitmap;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 42\u00020\u0001:\u0001\u0003B\u0081\u0001\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u0012\b\b\u0002\u00105\u001a\u00020\u0007\u0012\b\b\u0002\u00107\u001a\u00020\u0007\u0012\b\b\u0002\u0010=\u001a\u000208\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\bD\u0010EJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R$\u0010-\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010)\u001a\u0004\b\u0011\u0010*\"\u0004\b+\u0010,R\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u00101R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u00101R\"\u00107\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b.\u0010\u001c\"\u0004\b6\u00101R\"\u0010=\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00109\u001a\u0004\b\u001e\u0010:\"\u0004\b;\u0010<R$\u0010C\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b\u0016\u0010A\"\u0004\b?\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/c;", "", "", "a", "k", "", "toString", "", "hashCode", "other", "", "equals", "", "J", tl.h.F, "()J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "traceId", "c", "f", "missionId", "d", "I", "getInitUploadProgress", "()I", "initUploadProgress", "e", "getInitExportProgress", "initExportProgress", "coverUrl", "g", "Z", "()Z", "setShowNotification", "(Z)V", "showNotification", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "()Lkotlinx/coroutines/Job;", "l", "(Lkotlinx/coroutines/Job;)V", "computeJob", "i", "getCurrUploadProgress", "p", "(I)V", "currUploadProgress", "getCurrExportProgress", DomainData.DOMAIN_NAME, "currExportProgress", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "tick", "", "D", "()D", "o", "(D)V", "currProgress", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "coverBitmap", "<init>", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLkotlinx/coroutines/Job;IIIDLandroid/graphics/Bitmap;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.wink.c, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ProgressInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String missionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int initUploadProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int initExportProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean showNotification;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Job computeJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int currUploadProgress;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int currExportProgress;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int tick;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private double currProgress;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bitmap coverBitmap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/wink/c$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.wink.c$b */
    /* loaded from: classes5.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS) {
                if (QLog.isColorLevel()) {
                    QLog.i("QCirclePublishProgress", 2, "[loadCoverBitmap] large icon loaded");
                }
                ProgressInfo.this.m(option.getResultBitMap());
            } else if (state == LoadState.STATE_DOWNLOAD_FAILED || state == LoadState.STATE_DECODE_FAILED) {
                QLog.w("QCirclePublishProgress", 1, "[loadCoverBitmap] load failed, path=" + ProgressInfo.this.getCoverUrl());
            }
        }
    }

    public ProgressInfo(long j3, @NotNull String traceId, @NotNull String missionId, int i3, int i16, @NotNull String coverUrl, boolean z16, @Nullable Job job, int i17, int i18, int i19, double d16, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.taskId = j3;
        this.traceId = traceId;
        this.missionId = missionId;
        this.initUploadProgress = i3;
        this.initExportProgress = i16;
        this.coverUrl = coverUrl;
        this.showNotification = z16;
        this.computeJob = job;
        this.currUploadProgress = i17;
        this.currExportProgress = i18;
        this.tick = i19;
        this.currProgress = d16;
        this.coverBitmap = bitmap;
    }

    public final void a() {
        double coerceIn;
        double coerceAtMost;
        try {
            int i3 = this.currUploadProgress;
            int i16 = this.initUploadProgress;
            double d16 = (i3 - i16) * 0.5d;
            int i17 = this.currExportProgress;
            coerceIn = RangesKt___RangesKt.coerceIn(((d16 + ((i17 - r8) * 0.5d)) * 100.0d) / (100.0d - ((i16 * 0.5d) + (this.initExportProgress * 0.5d))), 1.0d, 100.0d);
            double d17 = this.currProgress;
            if (((int) d17) == 0) {
                this.currProgress = coerceIn;
            } else {
                double d18 = ((100.0d - coerceIn) / coerceIn) * this.tick;
                if (((int) d18) != 0) {
                    this.currProgress = d17 + ((100.0d - d17) / d18);
                } else {
                    this.currProgress = 100.0d;
                }
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.currProgress, 100.0d);
            this.currProgress = coerceAtMost;
            if (QLog.isColorLevel()) {
                QLog.i("QCirclePublishProgress", 2, "[computeProgress] computed, " + this);
            }
        } catch (Exception e16) {
            QLog.e("QCirclePublishProgress", 1, "compute error", e16);
            this.currProgress = 0.0d;
        }
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Job getComputeJob() {
        return this.computeJob;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Bitmap getCoverBitmap() {
        return this.coverBitmap;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: e, reason: from getter */
    public final double getCurrProgress() {
        return this.currProgress;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgressInfo)) {
            return false;
        }
        ProgressInfo progressInfo = (ProgressInfo) other;
        if (this.taskId == progressInfo.taskId && Intrinsics.areEqual(this.traceId, progressInfo.traceId) && Intrinsics.areEqual(this.missionId, progressInfo.missionId) && this.initUploadProgress == progressInfo.initUploadProgress && this.initExportProgress == progressInfo.initExportProgress && Intrinsics.areEqual(this.coverUrl, progressInfo.coverUrl) && this.showNotification == progressInfo.showNotification && Intrinsics.areEqual(this.computeJob, progressInfo.computeJob) && this.currUploadProgress == progressInfo.currUploadProgress && this.currExportProgress == progressInfo.currExportProgress && this.tick == progressInfo.tick && Double.compare(this.currProgress, progressInfo.currProgress) == 0 && Intrinsics.areEqual(this.coverBitmap, progressInfo.coverBitmap)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getShowNotification() {
        return this.showNotification;
    }

    /* renamed from: h, reason: from getter */
    public final long getTaskId() {
        return this.taskId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = ((((((((((androidx.fragment.app.a.a(this.taskId) * 31) + this.traceId.hashCode()) * 31) + this.missionId.hashCode()) * 31) + this.initUploadProgress) * 31) + this.initExportProgress) * 31) + this.coverUrl.hashCode()) * 31;
        boolean z16 = this.showNotification;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (a16 + i3) * 31;
        Job job = this.computeJob;
        int i17 = 0;
        if (job == null) {
            hashCode = 0;
        } else {
            hashCode = job.hashCode();
        }
        int a17 = (((((((((i16 + hashCode) * 31) + this.currUploadProgress) * 31) + this.currExportProgress) * 31) + this.tick) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.currProgress)) * 31;
        Bitmap bitmap = this.coverBitmap;
        if (bitmap != null) {
            i17 = bitmap.hashCode();
        }
        return a17 + i17;
    }

    /* renamed from: i, reason: from getter */
    public final int getTick() {
        return this.tick;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final void k() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.coverUrl);
        if (isBlank) {
            QLog.w("QCirclePublishProgress", 1, "[loadCoverBitmap] invalid cover url");
            return;
        }
        if (this.coverBitmap != null) {
            QLog.i("QCirclePublishProgress", 1, "[loadCoverBitmap] already loaded");
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(this.coverUrl);
        obtain.setRequestWidth(cx.a(48.0f));
        obtain.setRequestHeight(cx.a(48.0f));
        QCircleFeedPicLoader.g().loadImage(obtain, new b());
    }

    public final void l(@Nullable Job job) {
        this.computeJob = job;
    }

    public final void m(@Nullable Bitmap bitmap) {
        this.coverBitmap = bitmap;
    }

    public final void n(int i3) {
        this.currExportProgress = i3;
    }

    public final void o(double d16) {
        this.currProgress = d16;
    }

    public final void p(int i3) {
        this.currUploadProgress = i3;
    }

    public final void q(int i3) {
        this.tick = i3;
    }

    @NotNull
    public String toString() {
        return "ProgressInfo(taskId=" + this.taskId + ", traceId=" + this.traceId + ", missionId=" + this.missionId + ", initUploadProgress=" + this.initUploadProgress + ", initExportProgress=" + this.initExportProgress + ", coverUrl=" + this.coverUrl + ", showNotification=" + this.showNotification + ", computeJob=" + this.computeJob + ", currUploadProgress=" + this.currUploadProgress + ", currExportProgress=" + this.currExportProgress + ", tick=" + this.tick + ", currProgress=" + this.currProgress + ", coverBitmap=" + this.coverBitmap + ")";
    }

    public /* synthetic */ ProgressInfo(long j3, String str, String str2, int i3, int i16, String str3, boolean z16, Job job, int i17, int i18, int i19, double d16, Bitmap bitmap, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, str2, i3, i16, str3, (i26 & 64) != 0 ? false : z16, (i26 & 128) != 0 ? null : job, (i26 & 256) != 0 ? 0 : i17, (i26 & 512) != 0 ? 0 : i18, (i26 & 1024) != 0 ? 0 : i19, (i26 & 2048) != 0 ? 0.0d : d16, (i26 & 4096) != 0 ? null : bitmap);
    }
}
