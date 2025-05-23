package com.tencent.mobileqq.wink.newalbum.processor.mediascan;

import android.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.picker.core.repository.h;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import e93.i;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u0019\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010.\u001a\u00020(\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u0014\u001a\u00020\t*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\rH\u0003J\b\u0010\u0016\u001a\u00020\u0004H\u0017J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/mediascan/WinkNewAlbumMediaScanProcessor;", "Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "Lcom/tencent/mobileqq/wink/newalbum/processor/mediascan/a;", "data", "", "v", "", "Lz83/a;", "photoList", "", "u", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/flow/Flow;", "", "size", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", HippyTKDListViewAdapter.X, "t", "w", "g", DKHippyEvent.EVENT_STOP, "Lcom/tencent/mobileqq/wink/picker/core/repository/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/picker/core/repository/h;", "localMediaRepository", "Lkotlinx/coroutines/CoroutineScope;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/CoroutineScope;", "fileScope", "Lkotlinx/coroutines/Job;", "D", "Lkotlinx/coroutines/Job;", "scanJob", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "E", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "b", "()Ljava/lang/String;", "logTag", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "next", "traceId", "<init>", "(Lcom/tencent/mobileqq/wink/newalbum/processor/a;Ljava/lang/String;)V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumMediaScanProcessor extends com.tencent.mobileqq.wink.newalbum.processor.b {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope fileScope;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Job scanJob;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final WinkNewAlbumDatabaseImp db;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h localMediaRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/mediascan/WinkNewAlbumMediaScanProcessor$a;", "", "", "d", "()I", "QUERY_COUNT", "c", "INSERT_DB_COUNT", "", QAlbumConstants.ALBUM_ID, "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c() {
            return w83.b.f445025a.z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d() {
            return w83.b.f445025a.x();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements t83.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f324279a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f324279a = cancellableContinuation;
        }

        @Override // t83.b
        public final void a(boolean z16) {
            CancellableContinuation<Boolean> cancellableContinuation = this.f324279a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkNewAlbumMediaScanProcessor f324280d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CoroutineExceptionHandler.Companion companion, WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor) {
            super(companion);
            this.f324280d = winkNewAlbumMediaScanProcessor;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            QLog.d(this.f324280d.b(), 1, "onStart, error ", exception);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumMediaScanProcessor(@Nullable com.tencent.mobileqq.wink.newalbum.processor.a aVar, @NotNull String traceId) {
        super(aVar, traceId);
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.fileScope = CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b());
        this.db = new WinkNewAlbumDatabaseImp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Flow<List<T>> s(Flow<? extends T> flow, int i3) {
        return FlowKt.flow(new WinkNewAlbumMediaScanProcessor$chunked$1(flow, i3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
    
        if (r0 != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean t(LocalMediaInfo localMediaInfo, WinkAlbumScanReportData winkAlbumScanReportData) {
        float f16;
        boolean z16;
        int min = Math.min(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
        int max = Math.max(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
        boolean z17 = true;
        try {
            f16 = localMediaInfo.mediaWidth / localMediaInfo.mediaHeight;
        } catch (Exception e16) {
            QLog.e(b(), 1, "filter, error", e16);
            f16 = 0.0f;
        }
        double d16 = min;
        w83.b bVar = w83.b.f445025a;
        if (d16 >= bVar.q() && max <= bVar.n()) {
            double p16 = bVar.p();
            double m3 = bVar.m();
            double d17 = f16;
            if (p16 <= d17 && d17 <= m3) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        if (z17) {
            winkAlbumScanReportData.c(localMediaInfo.modifiedDate * 1000);
        } else {
            winkAlbumScanReportData.b(i.I(localMediaInfo));
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(List<z83.a> list, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.db.I(list, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(WinkAlbumScanReportData data) {
        data.h(getTraceId());
        WinkAlbumScanReportData a16 = data.a();
        if (a16 != null) {
            h(a16.k());
            h(a16.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalCoroutinesApi
    public final Flow<List<LocalMediaInfo>> w() {
        return FlowKt.callbackFlow(new WinkNewAlbumMediaScanProcessor$scanFlow$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final z83.a x(LocalMediaInfo localMediaInfo) {
        int i3;
        boolean contains;
        boolean contains2;
        boolean contains3;
        int i16;
        boolean contains4;
        boolean contains5;
        z83.a aVar = new z83.a();
        String str = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
        aVar.P(str);
        aVar.S(localMediaInfo.modifiedDate * 1000);
        int i17 = 2;
        int i18 = 0;
        if (i.I(localMediaInfo)) {
            i3 = 2;
        } else if (i.F(localMediaInfo)) {
            i3 = 4;
        } else if (i.G(localMediaInfo)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        aVar.N(i3);
        contains = StringsKt__StringsKt.contains((CharSequence) aVar.getPath(), (CharSequence) "camera", true);
        if (!contains) {
            contains2 = StringsKt__StringsKt.contains((CharSequence) aVar.getPath(), (CharSequence) "screenshots", true);
            if (!contains2) {
                contains3 = StringsKt__StringsKt.contains((CharSequence) aVar.getPath(), (CharSequence) QQPermissionConstants.Permission.AUIDO_GROUP, true);
                if (!contains3) {
                    i16 = 0;
                }
            }
            i16 = 2;
        } else {
            i16 = 1;
        }
        aVar.Q(i16);
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_NEWALBUM_CAMERA, 1) && w83.b.f445025a.M()) {
            aVar.F(0);
        } else {
            try {
                String attribute = new ExifInterface(aVar.getPath()).getAttribute("Model");
                if (attribute == null) {
                    attribute = "";
                }
                Intrinsics.checkNotNullExpressionValue(attribute, "ExifInterface(path).getA\u2026nterface.TAG_MODEL) ?: \"\"");
                contains4 = StringsKt__StringsKt.contains((CharSequence) attribute, (CharSequence) "front", true);
                if (!contains4) {
                    contains5 = StringsKt__StringsKt.contains((CharSequence) attribute, (CharSequence) "back", true);
                    if (contains5) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                }
                i18 = i17;
            } catch (Exception e16) {
                QLog.e(b(), 1, "toMetaData, error ", e16);
            }
            aVar.F(i18);
        }
        aVar.T((int) localMediaInfo.mDuration);
        aVar.U(localMediaInfo.mediaWidth);
        aVar.K(localMediaInfo.mediaHeight);
        aVar.O(localMediaInfo);
        return aVar;
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    @NotNull
    public String b() {
        return super.b() + "WinkNewAlbumMediaScanProcessor";
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    @ExperimentalCoroutinesApi
    public void g() {
        Job launch$default;
        Job job = this.scanJob;
        boolean z16 = false;
        if (job != null && job.isActive()) {
            z16 = true;
        }
        if (z16) {
            QLog.d(b(), 1, "onStart, already start ");
            return;
        }
        QLog.d(b(), 1, "onStart ");
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        Ref.IntRef intRef3 = new Ref.IntRef();
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.fileScope, new c(CoroutineExceptionHandler.INSTANCE, this), null, new WinkNewAlbumMediaScanProcessor$onStart$2(this, new WinkAlbumScanReportData(0L, 0, 0, 0, 0, 0, 0, 0, null, 511, null), new Ref.IntRef(), intRef, intRef2, intRef3, null), 2, null);
        this.scanJob = launch$default;
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        QLog.d(b(), 1, "onStop ");
        Job job = this.scanJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
