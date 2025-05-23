package com.tencent.mobileqq.wink.newalbum.processor.mediascan;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import com.tencent.mobileqq.wink.picker.core.repository.b;
import com.tencent.mobileqq.wink.picker.core.repository.h;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qcircle.cooperation.config.debug.c;
import com.tencent.qphone.base.util.QLog;
import e93.QZoneAlbumInfo;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$scanFlow$1", f = "WinkNewAlbumMediaScanProcessor.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkNewAlbumMediaScanProcessor$scanFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends LocalMediaInfo>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WinkNewAlbumMediaScanProcessor this$0;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/newalbum/processor/mediascan/WinkNewAlbumMediaScanProcessor$scanFlow$1$a", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "Le93/j;", "qZoneAlbumInfo", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkNewAlbumMediaScanProcessor f324285a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProducerScope<List<? extends LocalMediaInfo>> f324286b;

        /* JADX WARN: Multi-variable type inference failed */
        a(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, ProducerScope<? super List<? extends LocalMediaInfo>> producerScope) {
            this.f324285a = winkNewAlbumMediaScanProcessor;
            this.f324286b = producerScope;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void a(@NotNull QZoneAlbumInfo qZoneAlbumInfo) {
            Intrinsics.checkNotNullParameter(qZoneAlbumInfo, "qZoneAlbumInfo");
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void b(@NotNull b mediaRepoData) {
            List<? extends LocalMediaInfo> list;
            h hVar;
            int d16;
            Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
            QLog.d(this.f324285a.b(), 1, "scanFlow, onQueryNextFinish, isActive:" + CoroutineScopeKt.isActive(this.f324286b) + ", isSuccess:" + mediaRepoData.getIsSuccess() + ", size:" + mediaRepoData.e().size());
            if (!CoroutineScopeKt.isActive(this.f324286b)) {
                return;
            }
            if (mediaRepoData.getIsSuccess()) {
                ProducerScope<List<? extends LocalMediaInfo>> producerScope = this.f324286b;
                list = CollectionsKt___CollectionsKt.toList(mediaRepoData.e());
                producerScope.mo2003trySendJP2dKIU(list);
                if (mediaRepoData.getHasMore()) {
                    hVar = this.f324285a.localMediaRepository;
                    if (hVar != null) {
                        d16 = WinkNewAlbumMediaScanProcessor.INSTANCE.d();
                        com.tencent.mobileqq.wink.picker.core.repository.a.b(hVar, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID, d16, null, 4, null);
                        return;
                    }
                    return;
                }
                SendChannel.DefaultImpls.close$default(this.f324286b, null, 1, null);
                return;
            }
            throw new CancellationException("query media failed ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumMediaScanProcessor$scanFlow$1(WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor, Continuation<? super WinkNewAlbumMediaScanProcessor$scanFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = winkNewAlbumMediaScanProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkNewAlbumMediaScanProcessor$scanFlow$1 winkNewAlbumMediaScanProcessor$scanFlow$1 = new WinkNewAlbumMediaScanProcessor$scanFlow$1(this.this$0, continuation);
        winkNewAlbumMediaScanProcessor$scanFlow$1.L$0 = obj;
        return winkNewAlbumMediaScanProcessor$scanFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MediaType mediaType;
        int d16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            this.this$0.h(new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_SCAN_START").traceId(this.this$0.getTraceId()).getReportData());
            if (c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_WINK_NEWALBUM_VIDEO, 1) && w83.b.f445025a.y()) {
                mediaType = MediaType.LOCAL_IMAGE;
            } else {
                mediaType = MediaType.LOCAL_ALL;
            }
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            h hVar = new h(mediaType, new MediaFilter.a().a());
            hVar.mediaQueryListener = new a(this.this$0, producerScope);
            this.this$0.localMediaRepository = hVar;
            d16 = WinkNewAlbumMediaScanProcessor.INSTANCE.d();
            com.tencent.mobileqq.wink.picker.core.repository.a.b(hVar, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID, d16, null, 4, null);
            final WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$scanFlow$1.4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    h hVar2;
                    QLog.d(WinkNewAlbumMediaScanProcessor.this.b(), 1, "scanFlow, closed ");
                    hVar2 = WinkNewAlbumMediaScanProcessor.this.localMediaRepository;
                    if (hVar2 != null) {
                        hVar2.j();
                    }
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super List<? extends LocalMediaInfo>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumMediaScanProcessor$scanFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
