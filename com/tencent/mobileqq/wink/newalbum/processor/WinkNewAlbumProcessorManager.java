package com.tencent.mobileqq.wink.newalbum.processor;

import android.os.Build;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorProcessor;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.forward.WinkNewAlbumForwardProcessor;
import com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor;
import com.tencent.mobileqq.wink.newalbum.processor.poi.WinkNewAlbumPoiCollectorProcessor;
import com.tencent.mobileqq.wink.newalbum.scale.WinkNewAlbumPhotoScaleProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0013\u0010\b\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/WinkNewAlbumProcessorManager;", "Lx83/a;", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "o", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "result", "", ReportConstant.COSTREPORT_PREFIX, "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "albumInfo", "p", "Lcom/tencent/mobileqq/wink/newalbum/director/datasource/a;", "dataConsumer", "t", "", "d", "g", h.F, "f", "b", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "headerProcessor", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "e", "Lcom/tencent/mobileqq/wink/newalbum/director/datasource/a;", "", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumProcessorManager extends x83.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile com.tencent.mobileqq.wink.newalbum.processor.a headerProcessor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile com.tencent.mobileqq.wink.newalbum.director.datasource.a<WinkNewMemoryAlbumResult> dataConsumer;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkNewAlbumProcessorManager f324234a = new WinkNewAlbumProcessorManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope mainScope = CoroutineScopeKt.MainScope();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final WinkNewAlbumDatabaseImp db = new WinkNewAlbumDatabaseImp();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/newalbum/processor/WinkNewAlbumProcessorManager$a", "La93/b;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "result", "", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends a93.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.newalbum.processor.b
        public void f(@NotNull WinkNewMemoryAlbumResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.f(result);
            WinkNewAlbumProcessorManager winkNewAlbumProcessorManager = WinkNewAlbumProcessorManager.f324234a;
            winkNewAlbumProcessorManager.s(result);
            if (!result.getIsLast() && w83.b.f445025a.M()) {
                winkNewAlbumProcessorManager.p(result);
            }
        }
    }

    WinkNewAlbumProcessorManager() {
    }

    private final com.tencent.mobileqq.wink.newalbum.processor.a o() {
        String str = "WinkNewAlbum_" + System.nanoTime();
        a aVar = new a();
        com.tencent.mobileqq.wink.newalbum.processor.a winkNewAlbumForwardProcessor = new WinkNewAlbumForwardProcessor(new WinkNewAlbumCollectorProcessor(new com.tencent.mobileqq.wink.newalbum.processor.holiday.b(aVar, str, aVar), str, aVar), str);
        if (!w83.b.f445025a.G()) {
            winkNewAlbumForwardProcessor = new WinkNewAlbumPhotoScaleProcessor(winkNewAlbumForwardProcessor, str);
        }
        return new WinkNewAlbumMediaScanProcessor(new WinkNewAlbumPoiCollectorProcessor(winkNewAlbumForwardProcessor, str, aVar), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final WinkNewMemoryAlbumResult albumInfo) {
        db.H(Collections.singletonList(albumInfo), new t83.b() { // from class: com.tencent.mobileqq.wink.newalbum.processor.e
            @Override // t83.b
            public final void a(boolean z16) {
                WinkNewAlbumProcessorManager.q(WinkNewMemoryAlbumResult.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WinkNewMemoryAlbumResult albumInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(albumInfo, "$albumInfo");
        QLog.i("WinkNewAlbum_WinkNewAlbumProcessorManager", 1, "insertAlbumInfoToDb result:" + z16 + ", id:" + albumInfo.getAlbumID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new WinkNewAlbumProcessorManager$notifyProducedEnd$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(WinkNewMemoryAlbumResult result) {
        BuildersKt__Builders_commonKt.launch$default(mainScope, null, null, new WinkNewAlbumProcessorManager$onCollectResult$1(result, null), 3, null);
    }

    @Override // x83.a
    @NotNull
    public String c() {
        return "WinkNewAlbum_WinkNewAlbumProcessorManager";
    }

    @Override // x83.a
    public boolean d() {
        w83.b bVar = w83.b.f445025a;
        if (!bVar.P()) {
            QLog.d(c(), 1, "isExtraSwitchOpen, isNewAlbumOpen is false ");
            return false;
        }
        if (!bVar.L()) {
            QLog.d(c(), 1, "isExtraSwitchOpen, isHitExpNewAlbum is false ");
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < bVar.s()) {
            QLog.d(c(), 1, "isExtraSwitchOpen, sdk version smaller:" + i3);
            return false;
        }
        if (ah.n() <= bVar.r()) {
            QLog.d(c(), 1, "isExtraSwitchOpen, cpu core smaller:" + ah.n());
            return false;
        }
        if (!bVar.l().contains(ah.s())) {
            return true;
        }
        QLog.d(c(), 1, "isExtraSwitchOpen, black model:" + ah.s());
        return false;
    }

    @Override // x83.a
    public void f() {
        QLog.d(c(), 1, "onDestroyProcess ");
        com.tencent.mobileqq.wink.newalbum.processor.a aVar = headerProcessor;
        if (aVar != null) {
            aVar.stop();
        }
        dataConsumer = null;
        headerProcessor = null;
    }

    @Override // x83.a
    public boolean g() {
        if (headerProcessor != null) {
            QLog.d(c(), 1, "onStartProcess, already started ");
            return false;
        }
        QLog.d(c(), 1, "onStartProcess ");
        com.tencent.mobileqq.wink.newalbum.processor.a o16 = o();
        headerProcessor = o16;
        o16.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x83.a
    public void h() {
        super.h();
        BuildersKt__Builders_commonKt.launch$default(mainScope, null, null, new WinkNewAlbumProcessorManager$onStartSwitchClose$1(null), 3, null);
    }

    public final void t(@Nullable com.tencent.mobileqq.wink.newalbum.director.datasource.a<WinkNewMemoryAlbumResult> dataConsumer2) {
        dataConsumer = dataConsumer2;
    }
}
