package com.tencent.mobileqq.wink.newalbum.processor;

import android.graphics.Bitmap;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.newalbum.forward.WinkNewAlbumForwardResult;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u0012\b\b\u0002\u0010)\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020*\u0012\b\b\u0002\u00105\u001a\u00020*\u0012\b\b\u0002\u00109\u001a\u00020*\u0012\b\b\u0002\u0010;\u001a\u00020\u0007\u0012\b\b\u0002\u0010=\u001a\u00020*\u0012\b\b\u0002\u0010?\u001a\u00020\u0007\u0012\b\b\u0002\u0010F\u001a\u00020@\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bS\u0010TJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00109\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010$\u001a\u0004\b2\u0010&\"\u0004\b:\u0010(R\"\u0010=\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010,\u001a\u0004\b6\u0010.\"\u0004\b<\u00100R\"\u0010?\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010$\u001a\u0004\b+\u0010&\"\u0004\b>\u0010(R\"\u0010F\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b\u0016\u0010C\"\u0004\bD\u0010ER$\u0010M\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010R\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bA\u0010O\"\u0004\bP\u0010Q\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lz83/a;", "a", "Lz83/a;", "e", "()Lz83/a;", V2TXLiveProperty.kV2SetMetaData, "(Lz83/a;)V", QQCustomArkDialogUtil.META_DATA, "Ljava/util/concurrent/atomic/AtomicReference;", "b", "Ljava/util/concurrent/atomic/AtomicReference;", "_sandboxPath", "Lcom/tencent/mobileqq/wink/newalbum/scale/c;", "c", "Lcom/tencent/mobileqq/wink/newalbum/scale/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/wink/newalbum/scale/c;", "y", "(Lcom/tencent/mobileqq/wink/newalbum/scale/c;)V", "scaledCallback", "Lcom/tencent/mobileqq/wink/newalbum/forward/e;", "d", "Lcom/tencent/mobileqq/wink/newalbum/forward/e;", "()Lcom/tencent/mobileqq/wink/newalbum/forward/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/wink/newalbum/forward/e;)V", "forwardResult", "Z", "o", "()Z", "setLast", "(Z)V", "isLast", "", "f", "J", "k", "()J", "w", "(J)V", "reportVideoThumbnailCost", "g", "j", "v", "reportScaleCost", h.F, "i", "u", "reportSavePhotoCost", ReportConstant.COSTREPORT_PREFIX, "needReportScale", "t", "reportForwardCost", "r", "needReportForward", "", "l", UserInfo.SEX_FEMALE, "()F", "p", "(F)V", "aestheticScore", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", DomainData.DOMAIN_NAME, "()Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/graphics/Bitmap;)V", "thumb", "value", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "sandboxPath", "<init>", "(Lz83/a;Ljava/util/concurrent/atomic/AtomicReference;Lcom/tencent/mobileqq/wink/newalbum/scale/c;Lcom/tencent/mobileqq/wink/newalbum/forward/e;ZJJJZJZFLandroid/graphics/Bitmap;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.processor.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private z83.a metaData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AtomicReference<String> _sandboxPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private com.tencent.mobileqq.wink.newalbum.scale.c scaledCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private WinkNewAlbumForwardResult forwardResult;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLast;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long reportVideoThumbnailCost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long reportScaleCost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long reportSavePhotoCost;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needReportScale;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long reportForwardCost;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needReportForward;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private float aestheticScore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bitmap thumb;

    public WinkNewAlbumContext() {
        this(null, null, null, null, false, 0L, 0L, 0L, false, 0L, false, 0.0f, null, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: c, reason: from getter */
    public final float getAestheticScore() {
        return this.aestheticScore;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final WinkNewAlbumForwardResult getForwardResult() {
        return this.forwardResult;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final z83.a getMetaData() {
        return this.metaData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumContext)) {
            return false;
        }
        WinkNewAlbumContext winkNewAlbumContext = (WinkNewAlbumContext) other;
        if (Intrinsics.areEqual(this.metaData, winkNewAlbumContext.metaData) && Intrinsics.areEqual(this._sandboxPath, winkNewAlbumContext._sandboxPath) && Intrinsics.areEqual(this.scaledCallback, winkNewAlbumContext.scaledCallback) && Intrinsics.areEqual(this.forwardResult, winkNewAlbumContext.forwardResult) && this.isLast == winkNewAlbumContext.isLast && this.reportVideoThumbnailCost == winkNewAlbumContext.reportVideoThumbnailCost && this.reportScaleCost == winkNewAlbumContext.reportScaleCost && this.reportSavePhotoCost == winkNewAlbumContext.reportSavePhotoCost && this.needReportScale == winkNewAlbumContext.needReportScale && this.reportForwardCost == winkNewAlbumContext.reportForwardCost && this.needReportForward == winkNewAlbumContext.needReportForward && Float.compare(this.aestheticScore, winkNewAlbumContext.aestheticScore) == 0 && Intrinsics.areEqual(this.thumb, winkNewAlbumContext.thumb)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getNeedReportForward() {
        return this.needReportForward;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getNeedReportScale() {
        return this.needReportScale;
    }

    /* renamed from: h, reason: from getter */
    public final long getReportForwardCost() {
        return this.reportForwardCost;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.metaData.hashCode() * 31) + this._sandboxPath.hashCode()) * 31) + this.scaledCallback.hashCode()) * 31) + this.forwardResult.hashCode()) * 31;
        boolean z16 = this.isLast;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int a16 = (((((((hashCode2 + i16) * 31) + androidx.fragment.app.a.a(this.reportVideoThumbnailCost)) * 31) + androidx.fragment.app.a.a(this.reportScaleCost)) * 31) + androidx.fragment.app.a.a(this.reportSavePhotoCost)) * 31;
        boolean z17 = this.needReportScale;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int a17 = (((a16 + i17) * 31) + androidx.fragment.app.a.a(this.reportForwardCost)) * 31;
        boolean z18 = this.needReportForward;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int floatToIntBits = (((a17 + i3) * 31) + Float.floatToIntBits(this.aestheticScore)) * 31;
        Bitmap bitmap = this.thumb;
        if (bitmap == null) {
            hashCode = 0;
        } else {
            hashCode = bitmap.hashCode();
        }
        return floatToIntBits + hashCode;
    }

    /* renamed from: i, reason: from getter */
    public final long getReportSavePhotoCost() {
        return this.reportSavePhotoCost;
    }

    /* renamed from: j, reason: from getter */
    public final long getReportScaleCost() {
        return this.reportScaleCost;
    }

    /* renamed from: k, reason: from getter */
    public final long getReportVideoThumbnailCost() {
        return this.reportVideoThumbnailCost;
    }

    @NotNull
    public final String l() {
        String str = this._sandboxPath.get();
        Intrinsics.checkNotNullExpressionValue(str, "_sandboxPath.get()");
        return str;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final com.tencent.mobileqq.wink.newalbum.scale.c getScaledCallback() {
        return this.scaledCallback;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final Bitmap getThumb() {
        return this.thumb;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsLast() {
        return this.isLast;
    }

    public final void p(float f16) {
        this.aestheticScore = f16;
    }

    public final void q(@NotNull WinkNewAlbumForwardResult winkNewAlbumForwardResult) {
        Intrinsics.checkNotNullParameter(winkNewAlbumForwardResult, "<set-?>");
        this.forwardResult = winkNewAlbumForwardResult;
    }

    public final void r(boolean z16) {
        this.needReportForward = z16;
    }

    public final void s(boolean z16) {
        this.needReportScale = z16;
    }

    public final void t(long j3) {
        this.reportForwardCost = j3;
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumContext(metaData=" + this.metaData + ", _sandboxPath=" + this._sandboxPath + ", scaledCallback=" + this.scaledCallback + ", forwardResult=" + this.forwardResult + ", isLast=" + this.isLast + ", reportVideoThumbnailCost=" + this.reportVideoThumbnailCost + ", reportScaleCost=" + this.reportScaleCost + ", reportSavePhotoCost=" + this.reportSavePhotoCost + ", needReportScale=" + this.needReportScale + ", reportForwardCost=" + this.reportForwardCost + ", needReportForward=" + this.needReportForward + ", aestheticScore=" + this.aestheticScore + ", thumb=" + this.thumb + ")";
    }

    public final void u(long j3) {
        this.reportSavePhotoCost = j3;
    }

    public final void v(long j3) {
        this.reportScaleCost = j3;
    }

    public final void w(long j3) {
        this.reportVideoThumbnailCost = j3;
    }

    public final void x(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._sandboxPath.set(value);
    }

    public final void y(@NotNull com.tencent.mobileqq.wink.newalbum.scale.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.scaledCallback = cVar;
    }

    public final void z(@Nullable Bitmap bitmap) {
        this.thumb = bitmap;
    }

    public WinkNewAlbumContext(@NotNull z83.a metaData, @NotNull AtomicReference<String> _sandboxPath, @NotNull com.tencent.mobileqq.wink.newalbum.scale.c scaledCallback, @NotNull WinkNewAlbumForwardResult forwardResult, boolean z16, long j3, long j16, long j17, boolean z17, long j18, boolean z18, float f16, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        Intrinsics.checkNotNullParameter(_sandboxPath, "_sandboxPath");
        Intrinsics.checkNotNullParameter(scaledCallback, "scaledCallback");
        Intrinsics.checkNotNullParameter(forwardResult, "forwardResult");
        this.metaData = metaData;
        this._sandboxPath = _sandboxPath;
        this.scaledCallback = scaledCallback;
        this.forwardResult = forwardResult;
        this.isLast = z16;
        this.reportVideoThumbnailCost = j3;
        this.reportScaleCost = j16;
        this.reportSavePhotoCost = j17;
        this.needReportScale = z17;
        this.reportForwardCost = j18;
        this.needReportForward = z18;
        this.aestheticScore = f16;
        this.thumb = bitmap;
    }

    public /* synthetic */ WinkNewAlbumContext(z83.a aVar, AtomicReference atomicReference, com.tencent.mobileqq.wink.newalbum.scale.c cVar, WinkNewAlbumForwardResult winkNewAlbumForwardResult, boolean z16, long j3, long j16, long j17, boolean z17, long j18, boolean z18, float f16, Bitmap bitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new z83.a() : aVar, (i3 & 2) != 0 ? new AtomicReference("") : atomicReference, (i3 & 4) != 0 ? new com.tencent.mobileqq.wink.newalbum.scale.c() { // from class: com.tencent.mobileqq.wink.newalbum.processor.c
            @Override // com.tencent.mobileqq.wink.newalbum.scale.c
            public final void a(boolean z19, String str, boolean z26) {
                WinkNewAlbumContext.b(z19, str, z26);
            }
        } : cVar, (i3 & 8) != 0 ? new WinkNewAlbumForwardResult(null, null, 3, null) : winkNewAlbumForwardResult, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? 0L : j3, (i3 & 64) != 0 ? 0L : j16, (i3 & 128) != 0 ? 0L : j17, (i3 & 256) != 0 ? false : z17, (i3 & 512) == 0 ? j18 : 0L, (i3 & 1024) == 0 ? z18 : false, (i3 & 2048) != 0 ? -100.0f : f16, (i3 & 4096) != 0 ? null : bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, String str, boolean z17) {
    }
}
