package com.tencent.mobileqq.wink.picker.interceptor;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.VideoTemplateData;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/FetchVideoTemplateInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverBitmaps", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "", "f", "e", "", "name", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "Ljava/util/concurrent/CountDownLatch;", "d", "Ljava/util/concurrent/CountDownLatch;", "syncLatch", "", "Z", "isVideoTemplatePreLoad", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FetchVideoTemplateInterceptor implements com.tencent.mobileqq.wink.picker.interceptor.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch syncLatch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoTemplatePreLoad;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/interceptor/FetchVideoTemplateInterceptor$b", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f324881a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c.a f324882b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FetchVideoTemplateInterceptor f324883c;

        b(MetaMaterial metaMaterial, c.a aVar, FetchVideoTemplateInterceptor fetchVideoTemplateInterceptor) {
            this.f324881a = metaMaterial;
            this.f324882b = aVar;
            this.f324883c = fetchVideoTemplateInterceptor;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            w53.b.f("FetchVideoTemplateInterceptor", "Download recommend finish. Material id " + this.f324881a.f30533id + ", isSuccess: " + isSuccess);
            if (isSuccess) {
                this.f324882b.b().W0(1.0f);
            }
            CountDownLatch countDownLatch = this.f324883c.syncLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
            this.f324882b.b().W0((progress * 1.0f) / 100);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/interceptor/FetchVideoTemplateInterceptor$c", "Lcom/tencent/mobileqq/wink/edit/manager/h$c;", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", "recommendList", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements h.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.a f324884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FetchVideoTemplateInterceptor f324885b;

        c(c.a aVar, FetchVideoTemplateInterceptor fetchVideoTemplateInterceptor) {
            this.f324884a = aVar;
            this.f324885b = fetchVideoTemplateInterceptor;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void a() {
            CountDownLatch countDownLatch = this.f324885b.syncLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            this.f324884a.b().g0(PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_TEMPLATE, true);
            w53.b.c("FetchVideoTemplateInterceptor", "requestRecommendAutoTemplate error: ");
            com.tencent.mobileqq.wink.edit.manager.h.d().n(this);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void b(@NotNull ArrayList<MetaMaterial> recommendList) {
            Intrinsics.checkNotNullParameter(recommendList, "recommendList");
            w53.b.f("FetchVideoTemplateInterceptor", "requestRecommendAutoTemplate finish.");
            this.f324884a.b().g0(PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_TEMPLATE, true);
            this.f324885b.isVideoTemplatePreLoad = true;
            this.f324885b.e(this.f324884a);
            com.tencent.mobileqq.wink.edit.manager.h.d().n(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(c.a chain) {
        MetaCategory e16 = com.tencent.mobileqq.wink.edit.manager.h.d().e();
        if (e16 != null) {
            if (e16.materials.isEmpty()) {
                w53.b.f("FetchVideoTemplateInterceptor", "recommendList == null || recommendList.materials.size() == 0");
                CountDownLatch countDownLatch = this.syncLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                    return;
                }
                return;
            }
            MetaMaterial metaMaterial = e16.materials.get(0);
            WinkEditorResourceManager.a1().f(metaMaterial, new b(metaMaterial, chain, this));
        }
    }

    private final void f(ArrayList<byte[]> coverBitmaps, c.a chain) {
        com.tencent.mobileqq.wink.edit.manager.h.d().a(new c(chain, this));
        WinkDataServiceHandler a16 = com.tencent.mobileqq.wink.edit.manager.e.a();
        if (a16 != null) {
            a16.o3(chain.e(), coverBitmaps, 2);
            a16.p3(coverBitmaps, 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.util.ArrayList] */
    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @Nullable
    public MediaPickerOutput a(@NotNull c.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (chain.c() && chain.a() == MediaPickerScene.STANDARD) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_ONE_CLICK_TEMPLATE);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (chain.getMediaPickerInput().c() == null) {
                this.syncLatch = new CountDownLatch(1);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new FetchVideoTemplateInterceptor$intercept$1(objectRef, chain, this, null), 3, null);
                CountDownLatch countDownLatch = this.syncLatch;
                if (countDownLatch != null) {
                    countDownLatch.await();
                }
            } else {
                objectRef.element = chain.getMediaPickerInput().c();
            }
            this.syncLatch = new CountDownLatch(1);
            T t16 = objectRef.element;
            Intrinsics.checkNotNull(t16);
            f((ArrayList) t16, chain);
            CountDownLatch countDownLatch2 = this.syncLatch;
            if (countDownLatch2 != null) {
                countDownLatch2.await();
            }
            return chain.f(MediaPickerInput.b(chain.getMediaPickerInput(), null, null, null, null, VideoTemplateData.b(chain.getMediaPickerInput().getVideoTemplateData(), false, this.isVideoTemplatePreLoad, null, 5, null), null, null, (ArrayList) objectRef.element, null, null, 879, null));
        }
        return chain.f(chain.getMediaPickerInput());
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "FetchVideoTemplateInterceptor";
    }
}
