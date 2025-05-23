package com.tencent.qqnt.qbasealbum.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.qbasealbum.model.MediaMimeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b!\u0018\u0000 E2\u00020\u0001:\u0002\u001b#B\u0097\u0001\b\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020\u001d\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u0010-\u001a\u00020\u0004\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\u0004\u0012\u0006\u00106\u001a\u00020\u001d\u0012\u0006\u00108\u001a\u00020\u001d\u0012\u0006\u0010;\u001a\u00020%\u0012\u0006\u0010>\u001a\u00020%\u0012\u0006\u0010A\u001a\u00020%\u00a2\u0006\u0004\bB\u0010CB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0015\u0010 R\u0017\u0010$\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010 R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010-\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013R\u0017\u0010/\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b.\u0010\u0013R\u0017\u00102\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u0017\u00104\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u00106\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b5\u0010 R\u0017\u00108\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b7\u0010 R\u0017\u0010;\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b9\u0010'\u001a\u0004\b:\u0010)R\u0017\u0010>\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b<\u0010'\u001a\u0004\b=\u0010)R\u0017\u0010A\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b?\u0010'\u001a\u0004\b@\u0010)\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "Lcom/tencent/qqnt/qbasealbum/model/MediaMimeType;", "d", "Ljava/util/List;", "k", "()Ljava/util/List;", "supportImageType", "e", "I", "g", "()I", "imageMinWidth", "f", "imageMinHeight", h.F, "c", "imageMaxWidth", "i", "a", "imageMaxHeight", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "()F", "imageMinRatio", BdhLogUtil.LogTag.Tag_Conn, "b", "imageMaxRatio", "", "D", "J", "j", "()J", "imageSizeBytesLimit", "E", ReportConstant.COSTREPORT_PREFIX, "videoMinWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "videoMinHeight", "G", "o", "videoMaxWidth", "H", "videoMaxHeight", "r", "videoMinRatio", DomainData.DOMAIN_NAME, "videoMaxRatio", "K", "t", "videoSizeBytesLimit", "L", "p", "videoMinDurationMs", "M", "l", "videoMaxDurationMs", "<init>", "(Ljava/util/List;IIIIFFJIIIIFFJJJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MediaFilter implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final float imageMaxRatio;

    /* renamed from: D, reason: from kotlin metadata */
    private final long imageSizeBytesLimit;

    /* renamed from: E, reason: from kotlin metadata */
    private final int videoMinWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private final int videoMinHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private final int videoMaxWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private final int videoMaxHeight;

    /* renamed from: I, reason: from kotlin metadata */
    private final float videoMinRatio;

    /* renamed from: J, reason: from kotlin metadata */
    private final float videoMaxRatio;

    /* renamed from: K, reason: from kotlin metadata */
    private final long videoSizeBytesLimit;

    /* renamed from: L, reason: from kotlin metadata */
    private final long videoMinDurationMs;

    /* renamed from: M, reason: from kotlin metadata */
    private final long videoMaxDurationMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MediaMimeType> supportImageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int imageMinWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int imageMinHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int imageMaxWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int imageMaxHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float imageMinRatio;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b*\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0012\u0010\u0017R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\r\u0010\u0017R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b\u0015\u0010,R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0017R\"\u00105\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0017R\"\u00109\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0017R\"\u0010<\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010\u0010\"\u0004\b#\u0010\u0017R\"\u0010@\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\"\u0010D\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\"\u0010G\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010)\u001a\u0004\bF\u0010+\"\u0004\b(\u0010,R\"\u0010K\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010)\u001a\u0004\bI\u0010+\"\u0004\bJ\u0010,R\"\u0010N\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010)\u001a\u0004\bM\u0010+\"\u0004\b\u001c\u0010,\u00a8\u0006Q"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter$a;", "", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "a", "", "Lcom/tencent/qqnt/qbasealbum/model/MediaMimeType;", "Ljava/util/List;", "getSupportImageType", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "supportImageType", "", "b", "I", "getImageMinWidth", "()I", "imageMinWidth", "c", "getImageMinHeight", "imageMinHeight", "d", "getImageMaxWidth", "(I)V", "imageMaxWidth", "getImageMaxHeight", "imageMaxHeight", "", "f", UserInfo.SEX_FEMALE, "getImageMinRatio", "()F", "setImageMinRatio", "(F)V", "imageMinRatio", "g", "getImageMaxRatio", "setImageMaxRatio", "imageMaxRatio", "", h.F, "J", "getImageSizeBytesLimit", "()J", "(J)V", "imageSizeBytesLimit", "i", "getVideoMinWidth", "setVideoMinWidth", "videoMinWidth", "j", "getVideoMinHeight", "setVideoMinHeight", "videoMinHeight", "k", "getVideoMaxWidth", "setVideoMaxWidth", "videoMaxWidth", "l", "getVideoMaxHeight", "videoMaxHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getVideoMinRatio", "setVideoMinRatio", "videoMinRatio", DomainData.DOMAIN_NAME, "getVideoMaxRatio", "setVideoMaxRatio", "videoMaxRatio", "o", "getVideoSizeBytesLimit", "videoSizeBytesLimit", "p", "getVideoMinDurationMs", "setVideoMinDurationMs", "videoMinDurationMs", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getVideoMaxDurationMs", "videoMaxDurationMs", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MediaMimeType[]{MediaMimeType.IMAGE_JPEG, MediaMimeType.IMAGE_PNG, MediaMimeType.IMAGE_HEIF, MediaMimeType.IMAGE_GIF, MediaMimeType.IMAGE_WEBP});
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
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final MediaFilter a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return (MediaFilter) iPatchRedirector.redirect((short) 34, (Object) this);
            }
            return new MediaFilter(this.supportImageType, this.imageMinWidth, this.imageMinHeight, this.imageMaxWidth, this.imageMaxHeight, this.imageMinRatio, this.imageMaxRatio, this.imageSizeBytesLimit, this.videoMinWidth, this.videoMinHeight, this.videoMaxWidth, this.videoMaxHeight, this.videoMinRatio, this.videoMaxRatio, this.videoSizeBytesLimit, this.videoMinDurationMs, this.videoMaxDurationMs, null);
        }

        public final void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.imageMaxHeight = i3;
            }
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.imageMaxWidth = i3;
            }
        }

        public final void d(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, j3);
            } else {
                this.imageSizeBytesLimit = j3;
            }
        }

        public final void e(@NotNull List<? extends MediaMimeType> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.supportImageType = list;
            }
        }

        public final void f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                iPatchRedirector.redirect((short) 33, (Object) this, j3);
            } else {
                this.videoMaxDurationMs = j3;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, i3);
            } else {
                this.videoMaxHeight = i3;
            }
        }

        public final void h(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, j3);
            } else {
                this.videoSizeBytesLimit = j3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter$b;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.filter.MediaFilter$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<MediaFilter> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaFilter createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MediaFilter) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaFilter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaFilter[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MediaFilter[]) iPatchRedirector.redirect((short) 4, (Object) this, size);
            }
            return new MediaFilter[size];
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ MediaFilter(List list, int i3, int i16, int i17, int i18, float f16, float f17, long j3, int i19, int i26, int i27, int i28, float f18, float f19, long j16, long j17, long j18, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i3, i16, i17, i18, f16, f17, j3, i19, i26, i27, i28, f18, f19, j16, j17, j18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, this, list, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Float.valueOf(f18), Float.valueOf(f19), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), defaultConstructorMarker);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.imageMaxHeight;
    }

    public final float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.imageMaxRatio;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.imageMaxWidth;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return 0;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.imageMinHeight;
    }

    public final float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.imageMinRatio;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.imageMinWidth;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.imageSizeBytesLimit;
    }

    @NotNull
    public final List<MediaMimeType> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.supportImageType;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        return this.videoMaxDurationMs;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.videoMaxHeight;
    }

    public final float n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return this.videoMaxRatio;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.videoMaxWidth;
    }

    public final long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.videoMinDurationMs;
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.videoMinHeight;
    }

    public final float r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        return this.videoMinRatio;
    }

    public final int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.videoMinWidth;
    }

    public final long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.videoSizeBytesLimit;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<MediaMimeType> list = this.supportImageType;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaMimeType) it.next()).name());
        }
        parcel.writeStringList(arrayList);
        parcel.writeInt(this.imageMinWidth);
        parcel.writeInt(this.imageMinHeight);
        parcel.writeInt(this.imageMaxWidth);
        parcel.writeInt(this.imageMaxHeight);
        parcel.writeFloat(this.imageMinRatio);
        parcel.writeFloat(this.imageMaxRatio);
        parcel.writeLong(this.imageSizeBytesLimit);
        parcel.writeInt(this.videoMinWidth);
        parcel.writeInt(this.videoMinHeight);
        parcel.writeInt(this.videoMaxWidth);
        parcel.writeInt(this.videoMaxHeight);
        parcel.writeFloat(this.videoMinRatio);
        parcel.writeFloat(this.videoMaxRatio);
        parcel.writeLong(this.videoSizeBytesLimit);
        parcel.writeLong(this.videoMinDurationMs);
        parcel.writeLong(this.videoMaxDurationMs);
    }

    MediaFilter(List<? extends MediaMimeType> list, int i3, int i16, int i17, int i18, float f16, float f17, long j3, int i19, int i26, int i27, int i28, float f18, float f19, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Float.valueOf(f18), Float.valueOf(f19), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaFilter(@NotNull Parcel parcel) {
        this(r2, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readLong(), parcel.readLong(), parcel.readLong());
        List emptyList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        if (createStringArrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(createStringArrayList, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            for (String it : createStringArrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                emptyList.add(MediaMimeType.valueOf(it));
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
    }
}
