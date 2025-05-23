package com.tencent.mobileqq.wink.picker;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001c\u0018\u0000 32\u00020\u0001:\u000245B\u0097\u0001\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\u0006\u0010)\u001a\u00020\u0013\u0012\u0006\u0010+\u001a\u00020\u001a\u0012\u0006\u0010-\u001a\u00020\u001a\u0012\u0006\u0010/\u001a\u00020\u001a\u00a2\u0006\u0004\b1\u00102R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\fR\u0017\u0010!\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b&\u0010\fR\u0017\u0010'\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u0017\u0010)\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u0017\u0010+\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001eR\u0017\u0010-\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001eR\u0017\u0010/\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010\u001e\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "Ljava/io/Serializable;", "", "Lcom/tencent/mobileqq/wink/picker/MediaMimeType;", "supportImageType", "Ljava/util/List;", "getSupportImageType", "()Ljava/util/List;", "", "imageMinWidth", "I", "getImageMinWidth", "()I", "imageMinHeight", "getImageMinHeight", "imageMaxWidth", "getImageMaxWidth", "imageMaxHeight", "getImageMaxHeight", "", "imageMinRatio", UserInfo.SEX_FEMALE, "getImageMinRatio", "()F", "imageMaxRatio", "getImageMaxRatio", "", "imageSizeBytesLimit", "J", "getImageSizeBytesLimit", "()J", "videoMinWidth", "getVideoMinWidth", "videoMinHeight", "getVideoMinHeight", "videoMaxWidth", "getVideoMaxWidth", "videoMaxHeight", "getVideoMaxHeight", "videoMinRatio", "getVideoMinRatio", "videoMaxRatio", "getVideoMaxRatio", "videoSizeBytesLimit", "getVideoSizeBytesLimit", "videoMinDurationMs", "getVideoMinDurationMs", "videoMaxDurationMs", "getVideoMaxDurationMs", "<init>", "(Ljava/util/List;IIIIFFJIIIIFFJJJ)V", "Companion", "a", "b", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MediaFilter implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int imageMaxHeight;
    private final float imageMaxRatio;
    private final int imageMaxWidth;
    private final int imageMinHeight;
    private final float imageMinRatio;
    private final int imageMinWidth;
    private final long imageSizeBytesLimit;

    @NotNull
    private final List<MediaMimeType> supportImageType;
    private final long videoMaxDurationMs;
    private final int videoMaxHeight;
    private final float videoMaxRatio;
    private final int videoMaxWidth;
    private final long videoMinDurationMs;
    private final int videoMinHeight;
    private final float videoMinRatio;
    private final int videoMinWidth;
    private final long videoSizeBytesLimit;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b)\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0015\u0010\u0017R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\r\u0010\u0017R\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u0019\u0010 R\"\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b\u0012\u0010 R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0017R\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0017R\"\u00107\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010\u0010\"\u0004\b-\u0010\u0017R\"\u0010:\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u000e\u001a\u0004\b9\u0010\u0010\"\u0004\b&\u0010\u0017R\"\u0010>\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u001d\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010 R\"\u0010B\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u001d\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010 R\"\u0010E\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010'\u001a\u0004\bD\u0010)\"\u0004\b5\u0010+R\"\u0010H\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010'\u001a\u0004\bG\u0010)\"\u0004\b1\u0010+R\"\u0010K\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010'\u001a\u0004\bJ\u0010)\"\u0004\b\"\u0010+\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/MediaFilter$a;", "", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "a", "", "Lcom/tencent/mobileqq/wink/picker/MediaMimeType;", "Ljava/util/List;", "getSupportImageType", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "supportImageType", "", "b", "I", "getImageMinWidth", "()I", "imageMinWidth", "c", "getImageMinHeight", "imageMinHeight", "d", "getImageMaxWidth", "(I)V", "imageMaxWidth", "e", "getImageMaxHeight", "imageMaxHeight", "", UserInfo.SEX_FEMALE, "getImageMinRatio", "()F", "(F)V", "imageMinRatio", "g", "getImageMaxRatio", "imageMaxRatio", "", tl.h.F, "J", "getImageSizeBytesLimit", "()J", "setImageSizeBytesLimit", "(J)V", "imageSizeBytesLimit", "i", "getVideoMinWidth", "setVideoMinWidth", "videoMinWidth", "j", "getVideoMinHeight", "setVideoMinHeight", "videoMinHeight", "k", "getVideoMaxWidth", "videoMaxWidth", "l", "getVideoMaxHeight", "videoMaxHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getVideoMinRatio", "setVideoMinRatio", "videoMinRatio", DomainData.DOMAIN_NAME, "getVideoMaxRatio", "setVideoMaxRatio", "videoMaxRatio", "o", "getVideoSizeBytesLimit", "videoSizeBytesLimit", "p", "getVideoMinDurationMs", "videoMinDurationMs", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getVideoMaxDurationMs", "videoMaxDurationMs", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends MediaMimeType> supportImageType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int imageMinWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int imageMinHeight;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int imageMaxWidth;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int imageMaxHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float imageMinRatio;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float imageMaxRatio;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long imageSizeBytesLimit;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int videoMinWidth;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int videoMinHeight;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int videoMaxWidth;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int videoMaxHeight;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private float videoMinRatio;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private float videoMaxRatio;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private long videoSizeBytesLimit;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private long videoMinDurationMs;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private long videoMaxDurationMs;

        public a() {
            List<? extends MediaMimeType> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MediaMimeType[]{MediaMimeType.IMAGE_JPEG, MediaMimeType.IMAGE_PNG, MediaMimeType.IMAGE_HEIF});
            this.supportImageType = listOf;
            this.imageMinWidth = -1;
            this.imageMinHeight = -1;
            this.imageMaxWidth = Integer.MAX_VALUE;
            this.imageMaxHeight = Integer.MAX_VALUE;
            this.imageMinRatio = -1.0f;
            this.imageMaxRatio = Float.MAX_VALUE;
            this.imageSizeBytesLimit = Long.MAX_VALUE;
            this.videoMinWidth = -1;
            this.videoMinHeight = -1;
            this.videoMaxWidth = Integer.MAX_VALUE;
            this.videoMaxHeight = Integer.MAX_VALUE;
            this.videoMinRatio = -1.0f;
            this.videoMaxRatio = Float.MAX_VALUE;
            this.videoSizeBytesLimit = Long.MAX_VALUE;
            this.videoMinDurationMs = -1L;
            this.videoMaxDurationMs = Long.MAX_VALUE;
        }

        @NotNull
        public final MediaFilter a() {
            return new MediaFilter(this.supportImageType, this.imageMinWidth, this.imageMinHeight, this.imageMaxWidth, this.imageMaxHeight, this.imageMinRatio, this.imageMaxRatio, this.imageSizeBytesLimit, this.videoMinWidth, this.videoMinHeight, this.videoMaxWidth, this.videoMaxHeight, this.videoMinRatio, this.videoMaxRatio, this.videoSizeBytesLimit, this.videoMinDurationMs, this.videoMaxDurationMs, null);
        }

        public final void b(int i3) {
            this.imageMaxHeight = i3;
        }

        public final void c(float f16) {
            this.imageMaxRatio = f16;
        }

        public final void d(int i3) {
            this.imageMaxWidth = i3;
        }

        public final void e(float f16) {
            this.imageMinRatio = f16;
        }

        public final void f(@NotNull List<? extends MediaMimeType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supportImageType = list;
        }

        public final void g(long j3) {
            this.videoMaxDurationMs = j3;
        }

        public final void h(int i3) {
            this.videoMaxHeight = i3;
        }

        public final void i(int i3) {
            this.videoMaxWidth = i3;
        }

        public final void j(long j3) {
            this.videoMinDurationMs = j3;
        }

        public final void k(long j3) {
            this.videoSizeBytesLimit = j3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/MediaFilter$b;", "", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.MediaFilter$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public /* synthetic */ MediaFilter(List list, int i3, int i16, int i17, int i18, float f16, float f17, long j3, int i19, int i26, int i27, int i28, float f18, float f19, long j16, long j17, long j18, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i3, i16, i17, i18, f16, f17, j3, i19, i26, i27, i28, f18, f19, j16, j17, j18);
    }

    public final int getImageMaxHeight() {
        return this.imageMaxHeight;
    }

    public final float getImageMaxRatio() {
        return this.imageMaxRatio;
    }

    public final int getImageMaxWidth() {
        return this.imageMaxWidth;
    }

    public final int getImageMinHeight() {
        return this.imageMinHeight;
    }

    public final float getImageMinRatio() {
        return this.imageMinRatio;
    }

    public final int getImageMinWidth() {
        return this.imageMinWidth;
    }

    public final long getImageSizeBytesLimit() {
        return this.imageSizeBytesLimit;
    }

    @NotNull
    public final List<MediaMimeType> getSupportImageType() {
        return this.supportImageType;
    }

    public final long getVideoMaxDurationMs() {
        return this.videoMaxDurationMs;
    }

    public final int getVideoMaxHeight() {
        return this.videoMaxHeight;
    }

    public final float getVideoMaxRatio() {
        return this.videoMaxRatio;
    }

    public final int getVideoMaxWidth() {
        return this.videoMaxWidth;
    }

    public final long getVideoMinDurationMs() {
        return this.videoMinDurationMs;
    }

    public final int getVideoMinHeight() {
        return this.videoMinHeight;
    }

    public final float getVideoMinRatio() {
        return this.videoMinRatio;
    }

    public final int getVideoMinWidth() {
        return this.videoMinWidth;
    }

    public final long getVideoSizeBytesLimit() {
        return this.videoSizeBytesLimit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    MediaFilter(List<? extends MediaMimeType> list, int i3, int i16, int i17, int i18, float f16, float f17, long j3, int i19, int i26, int i27, int i28, float f18, float f19, long j16, long j17, long j18) {
        this.supportImageType = list;
        this.imageMinWidth = i3;
        this.imageMinHeight = i16;
        this.imageMaxWidth = i17;
        this.imageMaxHeight = i18;
        this.imageMinRatio = f16;
        this.imageMaxRatio = f17;
        this.imageSizeBytesLimit = j3;
        this.videoMinWidth = i19;
        this.videoMinHeight = i26;
        this.videoMaxWidth = i27;
        this.videoMaxHeight = i28;
        this.videoMinRatio = f18;
        this.videoMaxRatio = f19;
        this.videoSizeBytesLimit = j16;
        this.videoMinDurationMs = j17;
        this.videoMaxDurationMs = j18;
    }
}
