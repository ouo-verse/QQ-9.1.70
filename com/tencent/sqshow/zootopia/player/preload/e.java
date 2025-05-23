package com.tencent.sqshow.zootopia.player.preload;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.f;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u0000 \u00142\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010$\u001a\u00020\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010'R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010*R\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010*R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0016\u0010-\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010,R\u0016\u0010.\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010,R\u0016\u00100\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010/R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010*\u00a8\u00064"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/e;", "", "", "vid", ReportConstant.COSTREPORT_PREFIX, "g", "", "seqId", "r", "f", "preloadSelectedUrl", DomainData.DOMAIN_NAME, "d", "Lcom/tencent/sqshow/zootopia/player/f;", "options", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "videoDuration", "t", h.F, "duration", "l", "c", "status", "o", "preloadTaskId", "p", "e", "", "continueDownload", "j", "b", "", "preloadTime", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isMultiLevel", "k", "i", "a", "Ljava/lang/String;", "Ljava/lang/Integer;", "Lcom/tencent/sqshow/zootopia/player/f;", "preloadOptions", "I", "preloadDuration", "Z", "preContinue", "mIsMultiLevel", "J", "mPreloadTime", "preloadStatus", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static AtomicInteger f372292m = new AtomicInteger(30000);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String vid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Integer seqId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String preloadSelectedUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private f preloadOptions;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int preloadDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int videoDuration;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int preloadTaskId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean preContinue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMultiLevel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long mPreloadTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int preloadStatus = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/e$a;", "", "Lcom/tencent/sqshow/zootopia/player/preload/e;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "sAtomicInteger", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setSAtomicInteger", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "", "STATUS_DEFAULT", "I", "STATUS_PRELOADING", "STATUS_PRELOAD_FAILED", "STATUS_PRELOAD_START", "STATUS_PRELOAD_SUCCESS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.player.preload.e$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return new e().r(b().getAndIncrement());
        }

        public final AtomicInteger b() {
            return e.f372292m;
        }

        Companion() {
        }
    }

    /* renamed from: b, reason: from getter */
    public final boolean getPreContinue() {
        return this.preContinue;
    }

    /* renamed from: c, reason: from getter */
    public final int getPreloadDuration() {
        return this.preloadDuration;
    }

    public final String d() {
        String str = this.preloadSelectedUrl;
        return str == null ? "" : str;
    }

    /* renamed from: e, reason: from getter */
    public final int getPreloadTaskId() {
        return this.preloadTaskId;
    }

    public final int f() {
        Integer num = this.seqId;
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }

    public final String g() {
        String str = this.vid;
        return str == null ? "" : str;
    }

    /* renamed from: h, reason: from getter */
    public final int getVideoDuration() {
        return this.videoDuration;
    }

    public final boolean i() {
        int i3 = this.preloadStatus;
        boolean z16 = i3 == 2 || i3 == 1;
        QLog.d("VideoPreDownloadRecord", 1, "isPreloadDataValid() hasPreloadData:" + z16);
        return z16;
    }

    public final e j(boolean continueDownload) {
        this.preContinue = continueDownload;
        return this;
    }

    public final e k(boolean isMultiLevel) {
        this.mIsMultiLevel = isMultiLevel;
        return this;
    }

    public final e l(int duration) {
        this.preloadDuration = duration;
        return this;
    }

    public final e m(f options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.preloadOptions = options;
        return this;
    }

    public final e n(String preloadSelectedUrl) {
        this.preloadSelectedUrl = preloadSelectedUrl;
        return this;
    }

    public final e o(int status) {
        this.preloadStatus = status;
        return this;
    }

    public final e p(int preloadTaskId) {
        this.preloadTaskId = preloadTaskId;
        return this;
    }

    public final e q(long preloadTime) {
        this.mPreloadTime = preloadTime;
        return this;
    }

    public final e r(int seqId) {
        this.seqId = Integer.valueOf(seqId);
        return this;
    }

    public final e s(String vid) {
        this.vid = vid;
        return this;
    }

    public final e t(int videoDuration) {
        this.videoDuration = videoDuration;
        return this;
    }
}
