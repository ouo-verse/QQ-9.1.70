package ij1;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\bH\b\u0086\b\u0018\u0000 [2\u00020\u0001:\u0001+B\u00e3\u0001\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u00eb\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u00c6\u0001J\t\u0010&\u001a\u00020\u0002H\u00d6\u0001J\t\u0010'\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00100R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b8\u0010,\u001a\u0004\b9\u0010.R\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\"\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010,\u001a\u0004\b>\u0010.\"\u0004\b?\u0010@R\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\bA\u00100\u001a\u0004\bB\u00102R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\bC\u0010,\u001a\u0004\bD\u0010.R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010\u0018\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bN\u00100\u001a\u0004\bO\u00102\"\u0004\bP\u00104R\"\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010,\u001a\u0004\bQ\u0010.\"\u0004\bR\u0010@R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\"\u0010\u001c\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010F\u001a\u0004\b6\u0010H\"\u0004\bW\u0010XR\"\u0010\u001d\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010F\u001a\u0004\bC\u0010H\"\u0004\bY\u0010XR\u0017\u0010\u001e\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b;\u0010F\u001a\u0004\bS\u0010HR\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010F\u001a\u0004\b5\u0010H\"\u0004\bZ\u0010XR\"\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010,\u001a\u0004\b+\u0010.\"\u0004\b[\u0010@R\"\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\\\u001a\u0004\b!\u0010]\"\u0004\b^\u0010_R\"\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\\\u001a\u0004\b/\u0010]\"\u0004\b`\u0010_R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bA\u0010c\"\u0004\ba\u0010dR\u0014\u0010e\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010.R\u0014\u0010g\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010.R\u0014\u0010h\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010]R\u0014\u0010i\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010]R\u0014\u0010j\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010]R\u0014\u0010k\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010]R\u0014\u0010l\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bl\u0010]R\u0014\u0010m\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bm\u0010]\u00a8\u0006p"}, d2 = {"Lij1/m;", "Lcom/tencent/mobileqq/guild/data/o;", "", "H", UserInfo.SEX_FEMALE, "", "G", "mainTaskId", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "E", "fileId", "", "state", "type", "clientKey", "traceId", "uploadProgress", "coverUrl", "businessType", "feedId", "", "feedTime", "Lij1/k;", "mediaInfo", "errCode", "errMsg", "Landroid/os/Bundle;", "transParams", "totalFileSize", "totalUploadFileSize", "internalId", "originSize", "md5", "isRaw", NodeProps.CUSTOM_PROP_ISGIF, "Lcom/tencent/mobileqq/guild/data/g;", "localMediaInfo", "k", "toString", "hashCode", "", "other", "equals", "a", "Ljava/lang/String;", "getFileId", "()Ljava/lang/String;", "b", "I", "getState", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "c", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "getTraceId", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "g", "getCoverUrl", "r", "(Ljava/lang/String;)V", tl.h.F, "getBusinessType", "i", "getFeedId", "j", "J", "getFeedTime", "()J", "Lij1/k;", "o", "()Lij1/k;", HippyTKDListViewAdapter.X, "(Lij1/k;)V", "l", "getErrCode", ReportConstant.COSTREPORT_PREFIX, "getErrMsg", "t", DomainData.DOMAIN_NAME, "Landroid/os/Bundle;", "p", "()Landroid/os/Bundle;", "B", "(J)V", BdhLogUtil.LogTag.Tag_Conn, "y", "w", "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Z)V", "u", "v", "Lcom/tencent/mobileqq/guild/data/g;", "()Lcom/tencent/mobileqq/guild/data/g;", "(Lcom/tencent/mobileqq/guild/data/g;)V", "videoId", "getUrl", "url", "isVideoTask", "isImageTask", "isFinishSuccess", "isFinishError", "isActive", "isCancelled", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JLij1/k;ILjava/lang/String;Landroid/os/Bundle;JJJJLjava/lang/String;ZZLcom/tencent/mobileqq/guild/data/g;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij1.m, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildMediaUploadTaskInfo implements com.tencent.mobileqq.guild.data.o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String clientKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int uploadProgress;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String coverUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final long feedTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GuildMediaInfo mediaInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int errCode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String errMsg;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle transParams;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long totalFileSize;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private long totalUploadFileSize;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private final long internalId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long originSize;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String md5;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isRaw;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean isGif;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.data.g localMediaInfo;

    public GuildMediaUploadTaskInfo(@NotNull String fileId, int i3, int i16, @NotNull String clientKey, @NotNull String traceId, int i17, @NotNull String coverUrl, int i18, @NotNull String feedId, long j3, @Nullable GuildMediaInfo guildMediaInfo, int i19, @NotNull String errMsg, @Nullable Bundle bundle, long j16, long j17, long j18, long j19, @NotNull String md5, boolean z16, boolean z17, @Nullable com.tencent.mobileqq.guild.data.g gVar) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.fileId = fileId;
        this.state = i3;
        this.type = i16;
        this.clientKey = clientKey;
        this.traceId = traceId;
        this.uploadProgress = i17;
        this.coverUrl = coverUrl;
        this.businessType = i18;
        this.feedId = feedId;
        this.feedTime = j3;
        this.mediaInfo = guildMediaInfo;
        this.errCode = i19;
        this.errMsg = errMsg;
        this.transParams = bundle;
        this.totalFileSize = j16;
        this.totalUploadFileSize = j17;
        this.internalId = j18;
        this.originSize = j19;
        this.md5 = md5;
        this.isRaw = z16;
        this.isGif = z17;
        this.localMediaInfo = gVar;
    }

    private final String F() {
        l lVar;
        GuildMediaInfo guildMediaInfo = this.mediaInfo;
        l lVar2 = null;
        if (guildMediaInfo != null) {
            lVar = guildMediaInfo.getUploadResult();
        } else {
            lVar = null;
        }
        if (lVar instanceof GuildImageResult) {
            GuildMediaInfo guildMediaInfo2 = this.mediaInfo;
            if (guildMediaInfo2 != null) {
                lVar2 = guildMediaInfo2.getUploadResult();
            }
            Intrinsics.checkNotNull(lVar2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.data.GuildImageResult");
            return ((GuildImageResult) lVar2).getOriginUrl();
        }
        return "";
    }

    private final String H() {
        l lVar;
        GuildMediaInfo guildMediaInfo = this.mediaInfo;
        l lVar2 = null;
        if (guildMediaInfo != null) {
            lVar = guildMediaInfo.getUploadResult();
        } else {
            lVar = null;
        }
        if (lVar instanceof GuildVideoResult) {
            GuildMediaInfo guildMediaInfo2 = this.mediaInfo;
            if (guildMediaInfo2 != null) {
                lVar2 = guildMediaInfo2.getUploadResult();
            }
            Intrinsics.checkNotNull(lVar2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.data.GuildVideoResult");
            return ((GuildVideoResult) lVar2).getVideoId();
        }
        return "";
    }

    public void A(int i3) {
        this.state = i3;
    }

    public void B(long j3) {
        this.totalFileSize = j3;
    }

    public void C(long j3) {
        this.totalUploadFileSize = j3;
    }

    public final void D(int i3) {
        this.uploadProgress = i3;
    }

    @NotNull
    public final GuildMediaProgressState E(@NotNull String mainTaskId) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        return mn1.b.c(mainTaskId, this);
    }

    public final boolean G() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (g()) {
            if (getUrl().length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 && yl1.i.f450608a.i(getUrl())) {
                return true;
            }
        } else if (isVideoTask()) {
            if (f().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (getCoverUrl().length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && yl1.i.f450608a.i(getCoverUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getMd5() {
        return this.md5;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    /* renamed from: b, reason: from getter */
    public boolean getIsGif() {
        return this.isGif;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    /* renamed from: c, reason: from getter */
    public long getOriginSize() {
        return this.originSize;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    /* renamed from: d, reason: from getter */
    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (r0 != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (getUrl().length() > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        r0 = true;
     */
    @Override // com.tencent.mobileqq.guild.data.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (getState() != 3 || getErrCode() != 0) {
            return false;
        }
        if (!g()) {
            if (isVideoTask()) {
                if (f().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (getCoverUrl().length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
            }
            z18 = false;
        }
        if (!z18) {
            return false;
        }
        return true;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMediaUploadTaskInfo)) {
            return false;
        }
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo = (GuildMediaUploadTaskInfo) other;
        if (Intrinsics.areEqual(getFileId(), guildMediaUploadTaskInfo.getFileId()) && getState() == guildMediaUploadTaskInfo.getState() && this.type == guildMediaUploadTaskInfo.type && Intrinsics.areEqual(this.clientKey, guildMediaUploadTaskInfo.clientKey) && Intrinsics.areEqual(this.traceId, guildMediaUploadTaskInfo.traceId) && this.uploadProgress == guildMediaUploadTaskInfo.uploadProgress && Intrinsics.areEqual(getCoverUrl(), guildMediaUploadTaskInfo.getCoverUrl()) && this.businessType == guildMediaUploadTaskInfo.businessType && Intrinsics.areEqual(this.feedId, guildMediaUploadTaskInfo.feedId) && this.feedTime == guildMediaUploadTaskInfo.feedTime && Intrinsics.areEqual(this.mediaInfo, guildMediaUploadTaskInfo.mediaInfo) && getErrCode() == guildMediaUploadTaskInfo.getErrCode() && Intrinsics.areEqual(getErrMsg(), guildMediaUploadTaskInfo.getErrMsg()) && Intrinsics.areEqual(this.transParams, guildMediaUploadTaskInfo.transParams) && getTotalFileSize() == guildMediaUploadTaskInfo.getTotalFileSize() && getTotalUploadFileSize() == guildMediaUploadTaskInfo.getTotalUploadFileSize() && this.internalId == guildMediaUploadTaskInfo.internalId && getOriginSize() == guildMediaUploadTaskInfo.getOriginSize() && Intrinsics.areEqual(getMd5(), guildMediaUploadTaskInfo.getMd5()) && getIsRaw() == guildMediaUploadTaskInfo.getIsRaw() && getIsGif() == guildMediaUploadTaskInfo.getIsGif() && Intrinsics.areEqual(getLocalMediaInfo(), guildMediaUploadTaskInfo.getLocalMediaInfo())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    @NotNull
    public String f() {
        return H();
    }

    @Override // com.tencent.mobileqq.guild.data.o
    public boolean g() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    @NotNull
    public String getCoverUrl() {
        return this.coverUrl;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    public int getErrCode() {
        return this.errCode;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    @NotNull
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    @NotNull
    public String getFileId() {
        return this.fileId;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    public int getState() {
        return this.state;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    @NotNull
    public String getUrl() {
        return F();
    }

    @Override // com.tencent.mobileqq.guild.data.o
    @Nullable
    /* renamed from: h, reason: from getter */
    public com.tencent.mobileqq.guild.data.g getLocalMediaInfo() {
        return this.localMediaInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((((((((((((((getFileId().hashCode() * 31) + getState()) * 31) + this.type) * 31) + this.clientKey.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.uploadProgress) * 31) + getCoverUrl().hashCode()) * 31) + this.businessType) * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.feedTime)) * 31;
        GuildMediaInfo guildMediaInfo = this.mediaInfo;
        int i3 = 0;
        if (guildMediaInfo == null) {
            hashCode = 0;
        } else {
            hashCode = guildMediaInfo.hashCode();
        }
        int errCode = (((((hashCode3 + hashCode) * 31) + getErrCode()) * 31) + getErrMsg().hashCode()) * 31;
        Bundle bundle = this.transParams;
        if (bundle == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bundle.hashCode();
        }
        int a16 = (((((((((((errCode + hashCode2) * 31) + androidx.fragment.app.a.a(getTotalFileSize())) * 31) + androidx.fragment.app.a.a(getTotalUploadFileSize())) * 31) + androidx.fragment.app.a.a(this.internalId)) * 31) + androidx.fragment.app.a.a(getOriginSize())) * 31) + getMd5().hashCode()) * 31;
        boolean isRaw = getIsRaw();
        int i16 = 1;
        int i17 = isRaw;
        if (isRaw) {
            i17 = 1;
        }
        int i18 = (a16 + i17) * 31;
        boolean isGif = getIsGif();
        if (!isGif) {
            i16 = isGif;
        }
        int i19 = (i18 + i16) * 31;
        if (getLocalMediaInfo() != null) {
            i3 = getLocalMediaInfo().hashCode();
        }
        return i19 + i3;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    /* renamed from: i, reason: from getter */
    public long getTotalUploadFileSize() {
        return this.totalUploadFileSize;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    public boolean isActive() {
        if (getState() == 0 || getState() == 1 || getState() == 6) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    public boolean isCancelled() {
        if (getState() == 5) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    public boolean isCompleted() {
        return o.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.data.o
    /* renamed from: isRaw, reason: from getter */
    public boolean getIsRaw() {
        return this.isRaw;
    }

    @Override // com.tencent.mobileqq.guild.data.o
    public boolean isVideoTask() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.data.t
    public boolean j() {
        if (getState() != 2 && (getState() != 3 || e())) {
            return false;
        }
        return true;
    }

    @NotNull
    public final GuildMediaUploadTaskInfo k(@NotNull String fileId, int state, int type, @NotNull String clientKey, @NotNull String traceId, int uploadProgress, @NotNull String coverUrl, int businessType, @NotNull String feedId, long feedTime, @Nullable GuildMediaInfo mediaInfo, int errCode, @NotNull String errMsg, @Nullable Bundle transParams, long totalFileSize, long totalUploadFileSize, long internalId, long originSize, @NotNull String md5, boolean isRaw, boolean isGif, @Nullable com.tencent.mobileqq.guild.data.g localMediaInfo) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new GuildMediaUploadTaskInfo(fileId, state, type, clientKey, traceId, uploadProgress, coverUrl, businessType, feedId, feedTime, mediaInfo, errCode, errMsg, transParams, totalFileSize, totalUploadFileSize, internalId, originSize, md5, isRaw, isGif, localMediaInfo);
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getClientKey() {
        return this.clientKey;
    }

    /* renamed from: n, reason: from getter */
    public final long getInternalId() {
        return this.internalId;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final GuildMediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final Bundle getTransParams() {
        return this.transParams;
    }

    /* renamed from: q, reason: from getter */
    public final int getUploadProgress() {
        return this.uploadProgress;
    }

    public void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrl = str;
    }

    public void s(int i3) {
        this.errCode = i3;
    }

    public void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    @NotNull
    public String toString() {
        return "GuildMediaUploadTaskInfo(fileId=" + getFileId() + ", state=" + getState() + ", type=" + this.type + ", clientKey=" + this.clientKey + ", traceId=" + this.traceId + ", uploadProgress=" + this.uploadProgress + ", coverUrl=" + getCoverUrl() + ", businessType=" + this.businessType + ", feedId=" + this.feedId + ", feedTime=" + this.feedTime + ", mediaInfo=" + this.mediaInfo + ", errCode=" + getErrCode() + ", errMsg=" + getErrMsg() + ", transParams=" + this.transParams + ", totalFileSize=" + getTotalFileSize() + ", totalUploadFileSize=" + getTotalUploadFileSize() + ", internalId=" + this.internalId + ", originSize=" + getOriginSize() + ", md5=" + getMd5() + ", isRaw=" + getIsRaw() + ", isGif=" + getIsGif() + ", localMediaInfo=" + getLocalMediaInfo() + ")";
    }

    public void u(boolean z16) {
        this.isGif = z16;
    }

    public void v(@Nullable com.tencent.mobileqq.guild.data.g gVar) {
        this.localMediaInfo = gVar;
    }

    public void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void x(@Nullable GuildMediaInfo guildMediaInfo) {
        this.mediaInfo = guildMediaInfo;
    }

    public void y(long j3) {
        this.originSize = j3;
    }

    public void z(boolean z16) {
        this.isRaw = z16;
    }

    public /* synthetic */ GuildMediaUploadTaskInfo(String str, int i3, int i16, String str2, String str3, int i17, String str4, int i18, String str5, long j3, GuildMediaInfo guildMediaInfo, int i19, String str6, Bundle bundle, long j16, long j17, long j18, long j19, String str7, boolean z16, boolean z17, com.tencent.mobileqq.guild.data.g gVar, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, (i26 & 8) != 0 ? "" : str2, (i26 & 16) != 0 ? "" : str3, (i26 & 32) != 0 ? 0 : i17, (i26 & 64) != 0 ? "" : str4, (i26 & 128) != 0 ? 0 : i18, (i26 & 256) != 0 ? "" : str5, (i26 & 512) != 0 ? 0L : j3, (i26 & 1024) != 0 ? null : guildMediaInfo, (i26 & 2048) != 0 ? 0 : i19, (i26 & 4096) != 0 ? "" : str6, (i26 & 8192) != 0 ? null : bundle, (i26 & 16384) != 0 ? 0L : j16, (32768 & i26) != 0 ? 0L : j17, (65536 & i26) != 0 ? 0L : j18, (131072 & i26) != 0 ? 0L : j19, (262144 & i26) != 0 ? "" : str7, (524288 & i26) != 0 ? true : z16, (1048576 & i26) != 0 ? false : z17, (i26 & 2097152) != 0 ? null : gVar);
    }
}
