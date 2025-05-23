package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicOptimizeManager;
import com.tencent.mobileqq.wink.editor.recommend.WinkMusicRecommender;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import java.util.ArrayList;
import java.util.Collection;
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
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/FetchMusicRecommendInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "", "e", "d", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "c", "", "name", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "syncLatch", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FetchMusicRecommendInterceptor implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch syncLatch;

    private final boolean c(List<? extends LocalMediaInfo> selectedMedia) {
        boolean z16;
        List<? extends LocalMediaInfo> list = selectedMedia;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!e93.i.G((LocalMediaInfo) it.next())) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        w53.b.f("FetchMusicRecommendInterceptor", "isAllImage=" + z16);
        if (!z16) {
            boolean a16 = MusicOptimizeManager.f321154a.a();
            w53.b.f("FetchMusicRecommendInterceptor", "disableAutoMusic=" + a16);
            if (a16) {
                return false;
            }
        }
        return true;
    }

    private final boolean d() {
        boolean c16 = MusicOptimizeManager.f321154a.c();
        w53.b.f("FetchMusicRecommendInterceptor", "isHitMusicApplyOptimize=" + c16);
        return c16;
    }

    private final boolean e(c.a chain) {
        if (chain.a() == MediaPickerScene.STANDARD && !chain.c() && chain.e().size() > 1 && !d() && c(chain.e())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public MediaPickerOutput a(@NotNull c.a chain) {
        ArrayList<byte[]> arrayList;
        List<QQCircleSmartMatchMusic$MusicInfo> list;
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (!e(chain)) {
            return chain.f(chain.getMediaPickerInput());
        }
        chain.b().y0(chain.e().size());
        this.syncLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list2 = null;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new FetchMusicRecommendInterceptor$intercept$1(objectRef, chain, this, null), 3, null);
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.await();
        }
        w53.b.f("FetchMusicRecommendInterceptor", "musicRecommendData=" + objectRef.element);
        MediaPickerInput mediaPickerInput = chain.getMediaPickerInput();
        WinkMusicRecommender.a aVar = (WinkMusicRecommender.a) objectRef.element;
        if (aVar != null) {
            arrayList = aVar.a();
        } else {
            arrayList = null;
        }
        WinkMusicRecommender.a aVar2 = (WinkMusicRecommender.a) objectRef.element;
        if (aVar2 != null) {
            list = aVar2.b();
        } else {
            list = null;
        }
        WinkMusicRecommender.a aVar3 = (WinkMusicRecommender.a) objectRef.element;
        if (aVar3 != null) {
            list2 = aVar3.c();
        }
        return chain.f(MediaPickerInput.b(mediaPickerInput, null, null, null, null, null, null, null, arrayList, list, list2, 127, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "FetchMusicRecommendInterceptor";
    }
}
