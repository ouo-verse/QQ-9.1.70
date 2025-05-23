package com.tencent.sqshow.zootopia.avatar;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.avatar.d;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b*\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/a;", "Lcom/tencent/sqshow/zootopia/avatar/d;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "b", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "", "viewportType", "c", "a", "", "", "d", "Ljava/util/List;", "mNeedCleanKeyList", "e", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSourceCurrent", "f", "I", "getMViewportType$annotations", "()V", "mViewportType", h.F, "mViewType", "Ljava/util/concurrent/atomic/AtomicInteger;", "i", "Ljava/util/concurrent/atomic/AtomicInteger;", "mResetAvatarCounter", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "mFirstInAutoAppendParam", BdhLogUtil.LogTag.Tag_Conn, "Z", "mFirstFrameDone", "<init>", "D", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mFirstFrameDone;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<String> mNeedCleanKeyList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource mSourceCurrent = new ZootopiaSource(Source.UnSet, "", null, 4, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mViewportType = 1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mViewType = 1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger mResetAvatarCounter = new AtomicInteger();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Integer> mFirstInAutoAppendParam;

    public a() {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("PlayMontage", 1));
        this.mFirstInAutoAppendParam = mapOf;
    }

    public void a() {
        this.mNeedCleanKeyList.clear();
    }

    public void b(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.mSourceCurrent = source;
    }

    public void c(int viewportType) {
        this.mViewportType = viewportType;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean z16) {
        d.a.a(this, z16);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.mFirstFrameDone = true;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean connect) {
        if (connect) {
            return;
        }
        this.mFirstFrameDone = false;
    }
}
