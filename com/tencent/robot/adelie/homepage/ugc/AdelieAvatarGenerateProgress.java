package com.tencent.robot.adelie.homepage.ugc;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel;
import d24.GenerateImageItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J \u0010\u000e\u001a\u00020\u00042\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0014\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\nR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarGenerateProgress;", "", "", "progress", "", "i", "j", "progressType", "e", "d", "Lmqq/util/WeakReference;", "", "Ld24/g;", "currentFetchingImageItems", tl.h.F, "f", "Lcom/tencent/robot/adelie/homepage/ugc/viewmodel/AdelieUgcImageViewModel$c;", "listener", "g", "a", "I", "mProgressType", "", "b", "Ljava/lang/String;", "mProgressTip", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUpdatingProgress", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "mProgress", "", "Ljava/util/List;", "mLoadingTips", "Lmqq/util/WeakReference;", "mUgcImageStateListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarGenerateProgress {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mProgressType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mProgressTip = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isUpdatingProgress = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger mProgress = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> mLoadingTips;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<AdelieUgcImageViewModel.c> mUgcImageStateListener;

    public AdelieAvatarGenerateProgress() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mLoadingTips = emptyList;
        this.mUgcImageStateListener = new WeakReference<>(null);
    }

    private final void e(int progressType) {
        Object random;
        Object random2;
        List<String> listOf;
        Object random3;
        Object random4;
        Object random5;
        Object random6;
        this.mProgressType = progressType;
        if (progressType != 0) {
            if (progressType != 1) {
                if (progressType != 2) {
                    listOf = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    random6 = CollectionsKt___CollectionsKt.random(d24.h.f392706a.a(), Random.INSTANCE);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(random6);
                }
            } else {
                d24.h hVar = d24.h.f392706a;
                List<String> b16 = hVar.b();
                Random.Companion companion = Random.INSTANCE;
                random3 = CollectionsKt___CollectionsKt.random(b16, companion);
                random4 = CollectionsKt___CollectionsKt.random(hVar.c(), companion);
                random5 = CollectionsKt___CollectionsKt.random(hVar.a(), companion);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{(String) random3, (String) random4, (String) random5});
            }
        } else {
            d24.h hVar2 = d24.h.f392706a;
            List<String> c16 = hVar2.c();
            Random.Companion companion2 = Random.INSTANCE;
            random = CollectionsKt___CollectionsKt.random(c16, companion2);
            random2 = CollectionsKt___CollectionsKt.random(hVar2.a(), companion2);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{(String) random, (String) random2});
        }
        this.mLoadingTips = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int progress) {
        this.mProgress.set(progress);
        j();
        AdelieUgcImageViewModel.c cVar = this.mUgcImageStateListener.get();
        if (cVar != null) {
            cVar.b(progress, this.mProgressTip);
        }
    }

    private final void j() {
        boolean z16;
        boolean z17;
        if (this.mLoadingTips.isEmpty()) {
            return;
        }
        int i3 = this.mProgress.get();
        int i16 = this.mProgressType;
        boolean z18 = false;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    this.mProgressTip = ((Object) this.mLoadingTips.get(0)) + " " + i3 + "%";
                    return;
                }
                return;
            }
            if (i3 >= 0 && i3 < 31) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.mProgressTip = ((Object) this.mLoadingTips.get(0)) + " " + i3 + "%";
            }
            if (31 <= i3 && i3 < 61) {
                z18 = true;
            }
            if (z18) {
                this.mProgressTip = ((Object) this.mLoadingTips.get(1)) + " " + i3 + "%";
            }
            if (i3 > 60) {
                this.mProgressTip = ((Object) this.mLoadingTips.get(2)) + " " + i3 + "%";
                return;
            }
            return;
        }
        if (i3 >= 0 && i3 < 51) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mProgressTip = ((Object) this.mLoadingTips.get(0)) + " " + i3 + "%";
        }
        if (i3 > 50) {
            this.mProgressTip = ((Object) this.mLoadingTips.get(1)) + " " + i3 + "%";
        }
    }

    public final void d(int progressType) {
        if (this.isUpdatingProgress.get()) {
            return;
        }
        this.isUpdatingProgress.set(true);
        e(progressType);
        i(0);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AdelieUgcImageViewModel_updateProgress", null, null, null, new AdelieAvatarGenerateProgress$dispatchUpdateProgress$1(this, null), 14, null);
        }
    }

    public final void f() {
        this.isUpdatingProgress.set(false);
    }

    public final void g(@NotNull WeakReference<AdelieUgcImageViewModel.c> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mUgcImageStateListener = listener;
    }

    public final void h(@NotNull WeakReference<Map<Integer, GenerateImageItem>> currentFetchingImageItems) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(currentFetchingImageItems, "currentFetchingImageItems");
        Map<Integer, GenerateImageItem> map = currentFetchingImageItems.get();
        if (map != null) {
            int i16 = 1;
            if (map.isEmpty()) {
                i3 = 0;
            } else {
                Iterator<Map.Entry<Integer, GenerateImageItem>> it = map.entrySet().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (it.next().getValue().getState() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        i3++;
                    }
                }
            }
            Map<Integer, GenerateImageItem> map2 = currentFetchingImageItems.get();
            if (map2 != null) {
                i16 = map2.size();
            }
            int i17 = (int) ((i3 / i16) * 100.0f);
            if (this.mProgress.get() > 99) {
                this.isUpdatingProgress.set(false);
            }
            if (i17 > this.mProgress.get()) {
                i(i17);
            }
        }
    }
}
