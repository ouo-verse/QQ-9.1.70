package nh3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.model.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020$\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020$\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\u0006\u00a2\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010#\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0017\u0010*\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010,\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b\u000f\u0010'R\u0017\u0010-\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010 \u001a\u0004\b\u001c\u0010\"R\u0017\u0010/\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b.\u0010\r\u00a8\u00062"}, d2 = {"Lnh3/b;", "", "", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "g", "()I", "errCode", "b", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "recorderType", "c", "J", "k", "()J", "recordStartEngineTime", "d", "j", "recordQueueTime", "e", "l", "recordTime", "f", "Z", h.F, "()Z", "recordCache", "Lcom/tencent/zplan/meme/action/MODE;", "Lcom/tencent/zplan/meme/action/MODE;", "i", "()Lcom/tencent/zplan/meme/action/MODE;", "recordMode", "encode2DQueueTime", "encode2DTime", "encodeDownloadTime", "encode2DMode", "encodeCache", "getResID", "resID", "<init>", "(ILjava/lang/String;JJJZLcom/tencent/zplan/meme/action/MODE;JJJLcom/tencent/zplan/meme/action/MODE;ZI)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: nh3.b, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZPlanEmoticonReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String recorderType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long recordStartEngineTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long recordQueueTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long recordTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean recordCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final MODE recordMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final long encode2DQueueTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long encode2DTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final long encodeDownloadTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final MODE encode2DMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean encodeCache;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resID;

    public ZPlanEmoticonReportData() {
        this(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, null, false, 0, InitSkin.DRAWABLE_COUNT, null);
    }

    public final long a() {
        return this.recordStartEngineTime + this.recordQueueTime + this.recordTime + this.encode2DQueueTime + this.encode2DTime + this.encodeDownloadTime;
    }

    /* renamed from: b, reason: from getter */
    public final MODE getEncode2DMode() {
        return this.encode2DMode;
    }

    /* renamed from: c, reason: from getter */
    public final long getEncode2DQueueTime() {
        return this.encode2DQueueTime;
    }

    /* renamed from: d, reason: from getter */
    public final long getEncode2DTime() {
        return this.encode2DTime;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getEncodeCache() {
        return this.encodeCache;
    }

    /* renamed from: f, reason: from getter */
    public final long getEncodeDownloadTime() {
        return this.encodeDownloadTime;
    }

    /* renamed from: g, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getRecordCache() {
        return this.recordCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.errCode * 31) + this.recorderType.hashCode()) * 31) + c.a(this.recordStartEngineTime)) * 31) + c.a(this.recordQueueTime)) * 31) + c.a(this.recordTime)) * 31;
        boolean z16 = this.recordCache;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((((hashCode + i3) * 31) + this.recordMode.hashCode()) * 31) + c.a(this.encode2DQueueTime)) * 31) + c.a(this.encode2DTime)) * 31) + c.a(this.encodeDownloadTime)) * 31) + this.encode2DMode.hashCode()) * 31;
        boolean z17 = this.encodeCache;
        return ((hashCode2 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.resID;
    }

    /* renamed from: i, reason: from getter */
    public final MODE getRecordMode() {
        return this.recordMode;
    }

    /* renamed from: j, reason: from getter */
    public final long getRecordQueueTime() {
        return this.recordQueueTime;
    }

    /* renamed from: k, reason: from getter */
    public final long getRecordStartEngineTime() {
        return this.recordStartEngineTime;
    }

    /* renamed from: l, reason: from getter */
    public final long getRecordTime() {
        return this.recordTime;
    }

    /* renamed from: m, reason: from getter */
    public final String getRecorderType() {
        return this.recorderType;
    }

    public ZPlanEmoticonReportData(int i3, String recorderType, long j3, long j16, long j17, boolean z16, MODE recordMode, long j18, long j19, long j26, MODE encode2DMode, boolean z17, int i16) {
        Intrinsics.checkNotNullParameter(recorderType, "recorderType");
        Intrinsics.checkNotNullParameter(recordMode, "recordMode");
        Intrinsics.checkNotNullParameter(encode2DMode, "encode2DMode");
        this.errCode = i3;
        this.recorderType = recorderType;
        this.recordStartEngineTime = j3;
        this.recordQueueTime = j16;
        this.recordTime = j17;
        this.recordCache = z16;
        this.recordMode = recordMode;
        this.encode2DQueueTime = j18;
        this.encode2DTime = j19;
        this.encodeDownloadTime = j26;
        this.encode2DMode = encode2DMode;
        this.encodeCache = z17;
        this.resID = i16;
    }

    public String toString() {
        return "ZPlanEmoticonReportData(errCode=" + this.errCode + ", recorderType=" + this.recorderType + ", recordStartEngineTime=" + this.recordStartEngineTime + ", recordQueueTime=" + this.recordQueueTime + ", recordTime=" + this.recordTime + ", recordCache=" + this.recordCache + ", recordMode=" + this.recordMode + ", encode2DQueueTime=" + this.encode2DQueueTime + ", encode2DTime=" + this.encode2DTime + ", encodeDownloadTime=" + this.encodeDownloadTime + ", encode2DMode=" + this.encode2DMode + ", encodeCache=" + this.encodeCache + ", resID=" + this.resID + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEmoticonReportData)) {
            return false;
        }
        ZPlanEmoticonReportData zPlanEmoticonReportData = (ZPlanEmoticonReportData) other;
        return this.errCode == zPlanEmoticonReportData.errCode && Intrinsics.areEqual(this.recorderType, zPlanEmoticonReportData.recorderType) && this.recordStartEngineTime == zPlanEmoticonReportData.recordStartEngineTime && this.recordQueueTime == zPlanEmoticonReportData.recordQueueTime && this.recordTime == zPlanEmoticonReportData.recordTime && this.recordCache == zPlanEmoticonReportData.recordCache && this.recordMode == zPlanEmoticonReportData.recordMode && this.encode2DQueueTime == zPlanEmoticonReportData.encode2DQueueTime && this.encode2DTime == zPlanEmoticonReportData.encode2DTime && this.encodeDownloadTime == zPlanEmoticonReportData.encodeDownloadTime && this.encode2DMode == zPlanEmoticonReportData.encode2DMode && this.encodeCache == zPlanEmoticonReportData.encodeCache && this.resID == zPlanEmoticonReportData.resID;
    }

    public /* synthetic */ ZPlanEmoticonReportData(int i3, String str, long j3, long j16, long j17, boolean z16, MODE mode, long j18, long j19, long j26, MODE mode2, boolean z17, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? Source.LOCAL_CACHE.name() : str, (i17 & 4) != 0 ? 0L : j3, (i17 & 8) != 0 ? 0L : j16, (i17 & 16) != 0 ? 0L : j17, (i17 & 32) != 0 ? false : z16, (i17 & 64) != 0 ? MODE.FRAME : mode, (i17 & 128) != 0 ? 0L : j18, (i17 & 256) != 0 ? 0L : j19, (i17 & 512) == 0 ? j26 : 0L, (i17 & 1024) != 0 ? MODE.FRAME : mode2, (i17 & 2048) != 0 ? false : z17, (i17 & 4096) != 0 ? 0 : i16);
    }
}
