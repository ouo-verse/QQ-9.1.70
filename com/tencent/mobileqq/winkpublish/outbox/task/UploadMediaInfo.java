package com.tencent.mobileqq.winkpublish.outbox.task;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.slot.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.AbstractUploadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\fB\u00a9\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u00108\u001a\u000201\u0012\b\b\u0002\u0010;\u001a\u000201\u0012\b\b\u0002\u0010>\u001a\u000201\u0012\b\b\u0002\u0010A\u001a\u000201\u0012\b\b\u0002\u0010D\u001a\u000201\u0012\b\b\u0002\u0010J\u001a\u00020\u0004\u0012\b\b\u0002\u0010O\u001a\u00020\t\u0012\b\b\u0002\u0010U\u001a\u00020P\u0012\b\b\u0002\u0010X\u001a\u00020\t\u00a2\u0006\u0004\bf\u0010gJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b,\u0010!R$\u00100\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010%\u001a\u0004\b\u0018\u0010'\"\u0004\b/\u0010)R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\"\u0010>\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00103\u001a\u0004\b\u0013\u00105\"\u0004\b=\u00107R\"\u0010A\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00103\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\"\u0010D\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00103\u001a\u0004\b+\u00105\"\u0004\bC\u00107R\"\u0010J\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\b<\u0010G\"\u0004\bH\u0010IR\"\u0010O\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010K\u001a\u0004\b.\u0010L\"\u0004\bM\u0010NR\"\u0010U\u001a\u00020P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010(\u001a\u0004\b$\u0010R\"\u0004\bS\u0010TR\"\u0010X\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010K\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR\u0013\u0010\\\u001a\u0004\u0018\u00010Y8F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R\u0013\u0010_\u001a\u0004\u0018\u00010]8F\u00a2\u0006\u0006\u001a\u0004\bE\u0010^R\u0013\u0010b\u001a\u0004\u0018\u00010`8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010aR\u0011\u0010c\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bB\u0010GR\u0011\u0010d\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010GR\u0011\u0010e\u001a\u00020P8F\u00a2\u0006\u0006\u001a\u0004\bQ\u0010R\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "", "", "t", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "a", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "k", "()Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;)V", "mediaParams", "b", "I", "i", "()I", "indexInMediaList", "c", "getIndexInTypeList", "indexInTypeList", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "d", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/upload/uinterface/AbstractUploadTask;", "G", "(Lcom/tencent/upload/uinterface/AbstractUploadTask;)V", "uploadTask", "Lcom/tencent/upload/uinterface/AbstractUploadResult;", "e", "Lcom/tencent/upload/uinterface/AbstractUploadResult;", "p", "()Lcom/tencent/upload/uinterface/AbstractUploadResult;", UserInfo.SEX_FEMALE, "(Lcom/tencent/upload/uinterface/AbstractUploadResult;)V", "uploadResponse", "f", HippyTKDListViewAdapter.X, "coverUploadTask", "g", "w", "coverUploadResponse", "", h.F, "J", DomainData.DOMAIN_NAME, "()J", "E", "(J)V", "totalSize", "getSentSize", "D", "sentSize", "j", "v", "coverTotalSize", "getCoverSentSize", "u", "coverSentSize", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "fakeTotalSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "()Ljava/lang/String;", "B", "(Ljava/lang/String;)V", "md5", "Z", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "hasChangedCover", "", "o", "()F", "y", "(F)V", "exportProgress", ReportConstant.COSTREPORT_PREFIX, "H", "isVideoExported", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "r", "()Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "videoParams", "Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams;", "()Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams;", "netVideoParams", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "()Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "imageParams", "mediaPath", QQWinkConstants.COVER_PATH, "uploadProgress", "<init>", "(Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;IILcom/tencent/upload/uinterface/AbstractUploadTask;Lcom/tencent/upload/uinterface/AbstractUploadResult;Lcom/tencent/upload/uinterface/AbstractUploadTask;Lcom/tencent/upload/uinterface/AbstractUploadResult;JJJJJLjava/lang/String;ZFZ)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class UploadMediaInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private MediaParams mediaParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int indexInMediaList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int indexInTypeList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private AbstractUploadTask uploadTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private AbstractUploadResult uploadResponse;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private AbstractUploadTask coverUploadTask;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private AbstractUploadResult coverUploadResponse;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long sentSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long coverTotalSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long coverSentSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private long fakeTotalSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String md5;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasChangedCover;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private float exportProgress;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVideoExported;

    public UploadMediaInfo(MediaParams mediaParams, int i3, int i16, AbstractUploadTask abstractUploadTask, AbstractUploadResult abstractUploadResult, AbstractUploadTask abstractUploadTask2, AbstractUploadResult abstractUploadResult2, long j3, long j16, long j17, long j18, long j19, String md5, boolean z16, float f16, boolean z17) {
        Intrinsics.checkNotNullParameter(mediaParams, "mediaParams");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.mediaParams = mediaParams;
        this.indexInMediaList = i3;
        this.indexInTypeList = i16;
        this.uploadTask = abstractUploadTask;
        this.uploadResponse = abstractUploadResult;
        this.coverUploadTask = abstractUploadTask2;
        this.coverUploadResponse = abstractUploadResult2;
        this.totalSize = j3;
        this.sentSize = j16;
        this.coverTotalSize = j17;
        this.coverSentSize = j18;
        this.fakeTotalSize = j19;
        this.md5 = md5;
        this.hasChangedCover = z16;
        this.exportProgress = f16;
        this.isVideoExported = z17;
    }

    public final void A(boolean z16) {
        this.hasChangedCover = z16;
    }

    public final void B(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void C(MediaParams mediaParams) {
        Intrinsics.checkNotNullParameter(mediaParams, "<set-?>");
        this.mediaParams = mediaParams;
    }

    public final void D(long j3) {
        this.sentSize = j3;
    }

    public final void E(long j3) {
        this.totalSize = j3;
    }

    public final void F(AbstractUploadResult abstractUploadResult) {
        this.uploadResponse = abstractUploadResult;
    }

    public final void G(AbstractUploadTask abstractUploadTask) {
        this.uploadTask = abstractUploadTask;
    }

    public final void H(boolean z16) {
        this.isVideoExported = z16;
    }

    public final String a() {
        MediaParams mediaParams = this.mediaParams;
        if (mediaParams instanceof VideoParams) {
            Intrinsics.checkNotNull(mediaParams, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.model.params.VideoParams");
            return ((VideoParams) mediaParams).getCoverPath();
        }
        if (mediaParams instanceof NetVideoParams) {
            Intrinsics.checkNotNull(mediaParams, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.model.params.NetVideoParams");
            return ((NetVideoParams) mediaParams).getCoverUrl();
        }
        if (mediaParams instanceof ImageParams) {
            Intrinsics.checkNotNull(mediaParams, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.model.params.ImageParams");
            return ((ImageParams) mediaParams).getLocalPath();
        }
        return "error";
    }

    /* renamed from: b, reason: from getter */
    public final long getCoverTotalSize() {
        return this.coverTotalSize;
    }

    /* renamed from: c, reason: from getter */
    public final AbstractUploadResult getCoverUploadResponse() {
        return this.coverUploadResponse;
    }

    /* renamed from: d, reason: from getter */
    public final AbstractUploadTask getCoverUploadTask() {
        return this.coverUploadTask;
    }

    /* renamed from: e, reason: from getter */
    public final float getExportProgress() {
        return this.exportProgress;
    }

    /* renamed from: f, reason: from getter */
    public final long getFakeTotalSize() {
        return this.fakeTotalSize;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getHasChangedCover() {
        return this.hasChangedCover;
    }

    public final ImageParams h() {
        MediaParams mediaParams = this.mediaParams;
        if (mediaParams instanceof ImageParams) {
            return (ImageParams) mediaParams;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.mediaParams.hashCode() * 31) + this.indexInMediaList) * 31) + this.indexInTypeList) * 31;
        AbstractUploadTask abstractUploadTask = this.uploadTask;
        int hashCode2 = (hashCode + (abstractUploadTask == null ? 0 : abstractUploadTask.hashCode())) * 31;
        AbstractUploadResult abstractUploadResult = this.uploadResponse;
        int hashCode3 = (hashCode2 + (abstractUploadResult == null ? 0 : abstractUploadResult.hashCode())) * 31;
        AbstractUploadTask abstractUploadTask2 = this.coverUploadTask;
        int hashCode4 = (hashCode3 + (abstractUploadTask2 == null ? 0 : abstractUploadTask2.hashCode())) * 31;
        AbstractUploadResult abstractUploadResult2 = this.coverUploadResponse;
        int hashCode5 = (((((((((((((hashCode4 + (abstractUploadResult2 != null ? abstractUploadResult2.hashCode() : 0)) * 31) + d.a(this.totalSize)) * 31) + d.a(this.sentSize)) * 31) + d.a(this.coverTotalSize)) * 31) + d.a(this.coverSentSize)) * 31) + d.a(this.fakeTotalSize)) * 31) + this.md5.hashCode()) * 31;
        boolean z16 = this.hasChangedCover;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int floatToIntBits = (((hashCode5 + i3) * 31) + Float.floatToIntBits(this.exportProgress)) * 31;
        boolean z17 = this.isVideoExported;
        return floatToIntBits + (z17 ? 1 : z17 ? 1 : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getIndexInMediaList() {
        return this.indexInMediaList;
    }

    /* renamed from: j, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* renamed from: k, reason: from getter */
    public final MediaParams getMediaParams() {
        return this.mediaParams;
    }

    public final String l() {
        MediaParams mediaParams = this.mediaParams;
        if (mediaParams instanceof VideoParams) {
            Intrinsics.checkNotNull(mediaParams, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.model.params.VideoParams");
            return ((VideoParams) mediaParams).getLocalPath();
        }
        if (mediaParams instanceof ImageParams) {
            Intrinsics.checkNotNull(mediaParams, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.model.params.ImageParams");
            return ((ImageParams) mediaParams).getLocalPath();
        }
        return "";
    }

    public final NetVideoParams m() {
        MediaParams mediaParams = this.mediaParams;
        if (mediaParams instanceof NetVideoParams) {
            return (NetVideoParams) mediaParams;
        }
        return null;
    }

    /* renamed from: n, reason: from getter */
    public final long getTotalSize() {
        return this.totalSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float o() {
        float f16;
        long j3;
        if (r() != null) {
            long j16 = this.totalSize;
            if (j16 != 0) {
                j3 = this.sentSize;
            } else {
                j16 = this.fakeTotalSize;
                if (j16 != 0) {
                    j3 = this.sentSize;
                } else {
                    f16 = 0.0f;
                    long j17 = this.coverTotalSize;
                    float f17 = j17 != 0 ? ((float) this.coverSentSize) / ((float) j17) : 0.0f;
                    if (QLog.isColorLevel()) {
                        QLog.d("UploadMediaInfo", 2, "videoProgress=" + f16 + ", coverProgress=" + f17);
                    }
                    return (f16 * 0.9f) + (f17 * 0.1f);
                }
            }
            f16 = ((float) j3) / ((float) j16);
            long j172 = this.coverTotalSize;
            if (j172 != 0) {
            }
            if (QLog.isColorLevel()) {
            }
            return (f16 * 0.9f) + (f17 * 0.1f);
        }
        if (h() == null) {
            return m() != null ? 100.0f : 0.0f;
        }
        long j18 = this.totalSize;
        if (j18 != 0) {
            return ((float) this.sentSize) / ((float) j18);
        }
        return 0.0f;
    }

    /* renamed from: p, reason: from getter */
    public final AbstractUploadResult getUploadResponse() {
        return this.uploadResponse;
    }

    /* renamed from: q, reason: from getter */
    public final AbstractUploadTask getUploadTask() {
        return this.uploadTask;
    }

    public final VideoParams r() {
        MediaParams mediaParams = this.mediaParams;
        if (mediaParams instanceof VideoParams) {
            return (VideoParams) mediaParams;
        }
        return null;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsVideoExported() {
        return this.isVideoExported;
    }

    public final void u(long j3) {
        this.coverSentSize = j3;
    }

    public final void v(long j3) {
        this.coverTotalSize = j3;
    }

    public final void w(AbstractUploadResult abstractUploadResult) {
        this.coverUploadResponse = abstractUploadResult;
    }

    public final void x(AbstractUploadTask abstractUploadTask) {
        this.coverUploadTask = abstractUploadTask;
    }

    public final void y(float f16) {
        this.exportProgress = f16;
    }

    public final void z(long j3) {
        this.fakeTotalSize = j3;
    }

    public final void t() {
        this.uploadTask = null;
        this.uploadResponse = null;
        this.coverUploadTask = null;
        this.coverUploadResponse = null;
        this.totalSize = 0L;
        this.coverTotalSize = 0L;
        this.sentSize = 0L;
        this.coverSentSize = 0L;
        this.fakeTotalSize = 0L;
        this.md5 = "";
        this.isVideoExported = false;
    }

    public String toString() {
        return "UploadMediaInfo(mediaParams=" + this.mediaParams + ", indexInMediaList=" + this.indexInMediaList + ", indexInTypeList=" + this.indexInTypeList + ", uploadTask=" + this.uploadTask + ", uploadResponse=" + this.uploadResponse + ", coverUploadTask=" + this.coverUploadTask + ", coverUploadResponse=" + this.coverUploadResponse + ", totalSize=" + this.totalSize + ", sentSize=" + this.sentSize + ", coverTotalSize=" + this.coverTotalSize + ", coverSentSize=" + this.coverSentSize + ", fakeTotalSize=" + this.fakeTotalSize + ", md5=" + this.md5 + ", hasChangedCover=" + this.hasChangedCover + ", exportProgress=" + this.exportProgress + ", isVideoExported=" + this.isVideoExported + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadMediaInfo)) {
            return false;
        }
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) other;
        return Intrinsics.areEqual(this.mediaParams, uploadMediaInfo.mediaParams) && this.indexInMediaList == uploadMediaInfo.indexInMediaList && this.indexInTypeList == uploadMediaInfo.indexInTypeList && Intrinsics.areEqual(this.uploadTask, uploadMediaInfo.uploadTask) && Intrinsics.areEqual(this.uploadResponse, uploadMediaInfo.uploadResponse) && Intrinsics.areEqual(this.coverUploadTask, uploadMediaInfo.coverUploadTask) && Intrinsics.areEqual(this.coverUploadResponse, uploadMediaInfo.coverUploadResponse) && this.totalSize == uploadMediaInfo.totalSize && this.sentSize == uploadMediaInfo.sentSize && this.coverTotalSize == uploadMediaInfo.coverTotalSize && this.coverSentSize == uploadMediaInfo.coverSentSize && this.fakeTotalSize == uploadMediaInfo.fakeTotalSize && Intrinsics.areEqual(this.md5, uploadMediaInfo.md5) && this.hasChangedCover == uploadMediaInfo.hasChangedCover && Float.compare(this.exportProgress, uploadMediaInfo.exportProgress) == 0 && this.isVideoExported == uploadMediaInfo.isVideoExported;
    }

    public /* synthetic */ UploadMediaInfo(MediaParams mediaParams, int i3, int i16, AbstractUploadTask abstractUploadTask, AbstractUploadResult abstractUploadResult, AbstractUploadTask abstractUploadTask2, AbstractUploadResult abstractUploadResult2, long j3, long j16, long j17, long j18, long j19, String str, boolean z16, float f16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaParams, i3, i16, (i17 & 8) != 0 ? null : abstractUploadTask, (i17 & 16) != 0 ? null : abstractUploadResult, (i17 & 32) != 0 ? null : abstractUploadTask2, (i17 & 64) != 0 ? null : abstractUploadResult2, (i17 & 128) != 0 ? 0L : j3, (i17 & 256) != 0 ? 0L : j16, (i17 & 512) != 0 ? 0L : j17, (i17 & 1024) != 0 ? 0L : j18, (i17 & 2048) != 0 ? 0L : j19, (i17 & 4096) != 0 ? "" : str, (i17 & 8192) != 0 ? false : z16, (i17 & 16384) != 0 ? 0.0f : f16, (i17 & 32768) != 0 ? false : z17);
    }
}
