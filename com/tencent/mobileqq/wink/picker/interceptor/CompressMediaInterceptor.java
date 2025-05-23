package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.editor.extractor.FirstFramePreLoader;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b!\u0010\"JV\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u000426\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\n\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0018\u001a\u00020\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/CompressMediaInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "progress", "", "onProgressChanged", "e", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/a;", "d", "", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "c", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "syncLatch", "Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "f", "Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "interceptException", "<init>", "()V", tl.h.F, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class CompressMediaInterceptor implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c.a chain;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch syncLatch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile InterceptException interceptException;

    private final MediaPickerInput d(c.a chain) {
        int collectionSizeOrDefault;
        List<LocalMediaInfo> i3 = chain.getMediaPickerInput().i();
        if (i3 == null) {
            List<LocalMediaInfo> e16 = chain.e();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = e16.iterator();
            while (it.hasNext()) {
                arrayList.add(e93.i.b((LocalMediaInfo) it.next()));
            }
            i3 = CollectionsKt___CollectionsKt.toList(arrayList);
        }
        List<LocalMediaInfo> list = i3;
        for (LocalMediaInfo localMediaInfo : list) {
            String str = MediaCompressUtils.f325262a.r().get(localMediaInfo.path);
            if (str != null) {
                localMediaInfo.path = str;
                localMediaInfo.orientation = 0;
            }
        }
        return MediaPickerInput.b(chain.getMediaPickerInput(), null, null, null, null, null, null, list, null, null, null, 959, null);
    }

    private final void e(AtomicBoolean isRunning, List<? extends LocalMediaInfo> media, Function2<? super Integer, ? super Float, Unit> onProgressChanged) {
        this.syncLatch = new CountDownLatch(1);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new CompressMediaInterceptor$serialCompressMedia$1(media, this, isRunning, onProgressChanged, null), 3, null);
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.await();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public MediaPickerOutput a(@NotNull final c.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        List<LocalMediaInfo> i3 = chain.getMediaPickerInput().i();
        if (i3 == null) {
            i3 = chain.getMediaPickerInput().j();
        }
        List<LocalMediaInfo> q16 = MediaCompressUtils.f325262a.q(i3);
        com.tencent.mobileqq.wink.editor.performance.a.f321445a.d(q16.size(), chain.getMediaPickerInput().j());
        this.interceptException = null;
        if (!q16.isEmpty()) {
            this.chain = chain;
            ExtractCoverHelper.f320276a.p();
            FirstFramePreLoader.f320286a.i();
            e(chain.getIsRunning(), q16, new Function2<Integer, Float, Unit>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.CompressMediaInterceptor$intercept$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Float f16) {
                    invoke(num.intValue(), f16.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16, float f16) {
                    c.a.this.b().e(i16, f16);
                }
            });
        }
        InterceptException interceptException = this.interceptException;
        if (interceptException == null) {
            return chain.f(d(chain));
        }
        InterceptException interceptException2 = this.interceptException;
        Intrinsics.checkNotNull(interceptException2);
        w53.b.c("CompressMediaInterceptor", "interceptException: exception code = " + interceptException2.getErrorCode());
        throw interceptException;
    }

    public final void c() {
        List<LocalMediaInfo> list;
        MediaPickerInput mediaPickerInput;
        MediaPickerInput mediaPickerInput2;
        if (this.syncLatch == null) {
            return;
        }
        MediaCompressUtils mediaCompressUtils = MediaCompressUtils.f325262a;
        c.a aVar = this.chain;
        if (aVar == null || (mediaPickerInput2 = aVar.getMediaPickerInput()) == null || (list = mediaPickerInput2.i()) == null) {
            c.a aVar2 = this.chain;
            if (aVar2 != null && (mediaPickerInput = aVar2.getMediaPickerInput()) != null) {
                list = mediaPickerInput.j();
            } else {
                list = null;
            }
        }
        mediaCompressUtils.h(list);
        this.interceptException = new InterceptException(name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_USER_CANCEL, null, 2, null));
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "CompressMediaInterceptor";
    }
}
