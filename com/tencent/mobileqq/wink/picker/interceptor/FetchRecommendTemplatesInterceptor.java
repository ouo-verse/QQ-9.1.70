package com.tencent.mobileqq.wink.picker.interceptor;

import android.content.Intent;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.core.viewmodel.b;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/FetchRecommendTemplatesInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Ljava/util/ArrayList;", "", "coverBitmaps", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "", "c", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "medias", "", "d", "", "e", "", "name", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "Landroid/content/Intent;", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "syncLatch", "<init>", "(Landroid/content/Intent;)V", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FetchRecommendTemplatesInterceptor implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Intent intent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch syncLatch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/picker/interceptor/FetchRecommendTemplatesInterceptor$b", "Lcom/tencent/mobileqq/wink/edit/manager/h$c;", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "recommendList", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements h.c {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void a() {
            CountDownLatch countDownLatch = FetchRecommendTemplatesInterceptor.this.syncLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            w53.b.c("FetchRecommendTemplatesInterceptor", "request error: ");
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void b(@NotNull ArrayList<MetaMaterial> recommendList) {
            Intrinsics.checkNotNullParameter(recommendList, "recommendList");
            com.tencent.mobileqq.wink.edit.manager.h.d().f318436e = recommendList;
            CountDownLatch countDownLatch = FetchRecommendTemplatesInterceptor.this.syncLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    public FetchRecommendTemplatesInterceptor(@Nullable Intent intent) {
        this.intent = intent;
    }

    private final void c(ArrayList<byte[]> coverBitmaps, c.a chain) {
        com.tencent.mobileqq.wink.edit.manager.h.d().a(new b());
        WinkDataServiceHandler a16 = com.tencent.mobileqq.wink.edit.manager.e.a();
        if (a16 != null) {
            a16.o3(chain.e(), coverBitmaps, d(chain.e()));
        }
    }

    private final int d(List<? extends LocalMediaInfo> medias) {
        Iterator<T> it = medias.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            if (e93.i.I((LocalMediaInfo) it.next())) {
                i3++;
            } else {
                i16++;
            }
        }
        if (i3 == 1 && i16 == 0) {
            return 2;
        }
        if (i3 == 0 && i16 == 1) {
            return 1;
        }
        if (i3 == 0 && i16 > 1) {
            return 3;
        }
        if (i3 > 1 && i16 == 0) {
            return 4;
        }
        if (i3 <= 1 || i16 <= 1) {
            return 0;
        }
        return 5;
    }

    private final boolean e() {
        boolean z16;
        Intent intent = this.intent;
        if (intent != null && intent.getBooleanExtra(QQWinkConstants.EDITOR_TEMPLATE_RECOMMEND_MENU, false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.intent.getBooleanExtra(QQWinkConstants.EDITOR_RECOMMEND_TEMPLATE_SHOW, false)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.util.ArrayList] */
    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @Nullable
    public MediaPickerOutput a(@NotNull c.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        com.tencent.mobileqq.wink.edit.manager.h.d().f318436e = null;
        if (!e()) {
            return chain.f(chain.getMediaPickerInput());
        }
        chain.b().y0(chain.e().size());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (chain.getMediaPickerInput().c() == null) {
            this.syncLatch = new CountDownLatch(1);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new FetchRecommendTemplatesInterceptor$intercept$1(objectRef, chain, this, null), 3, null);
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
        c((ArrayList) t16, chain);
        CountDownLatch countDownLatch2 = this.syncLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.await();
        }
        b.a.c(chain.b(), PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_RECOMMEND_TEMPLATES, false, 2, null);
        return chain.f(chain.getMediaPickerInput());
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "FetchRecommendTemplatesInterceptor";
    }
}
