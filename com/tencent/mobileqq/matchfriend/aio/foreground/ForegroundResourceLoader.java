package com.tencent.mobileqq.matchfriend.aio.foreground;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/ForegroundResourceLoader;", "Lm72/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/a;", "", "d", "p", "e", "Lm72/b;", "a", "Lkotlin/Lazy;", "c", "()Lm72/b;", "netResourceLoader", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ForegroundResourceLoader implements m72.a<QQStrangerInteractiveMarkModel, a> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy netResourceLoader;

    public ForegroundResourceLoader() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<m72.b>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.ForegroundResourceLoader$netResourceLoader$2
            @Override // kotlin.jvm.functions.Function0
            public final m72.b invoke() {
                return new m72.b();
            }
        });
        this.netResourceLoader = lazy;
    }

    private final m72.b c() {
        return (m72.b) this.netResourceLoader.getValue();
    }

    private final void d() {
        URLDrawable drawable = URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/stranger_mark_obtain_aperture.png", (URLDrawable.URLDrawableOptions) null);
        if (drawable.getStatus() == 1 || drawable.getStatus() == 4) {
            return;
        }
        drawable.startDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ForegroundResourceLoader this$0, m72.c it, m72.c lottieResLoadParam, a this_apply, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(lottieResLoadParam, "$lottieResLoadParam");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        m72.d a16 = this$0.c().a(it);
        if (Intrinsics.areEqual(it, lottieResLoadParam)) {
            this_apply.a(a16);
        } else {
            this_apply.b(a16);
        }
        countDownLatch.countDown();
    }

    @Override // m72.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a a(QQStrangerInteractiveMarkModel p16) {
        Intrinsics.checkNotNullParameter(p16, "p");
        final a aVar = new a(p16);
        d();
        ArrayList<m72.c> arrayList = new ArrayList();
        final m72.c cVar = new m72.c(com.tencent.mobileqq.matchfriend.aio.utils.b.b(p16), com.tencent.mobileqq.matchfriend.aio.utils.b.c());
        if (!c().b(cVar)) {
            arrayList.add(cVar);
        }
        m72.c cVar2 = new m72.c(com.tencent.mobileqq.matchfriend.reborn.mark.c.a(p16), com.tencent.mobileqq.matchfriend.aio.utils.b.d(p16));
        if (!c().b(cVar2)) {
            arrayList.add(cVar2);
        }
        if (!arrayList.isEmpty()) {
            final CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
            for (final m72.c cVar3 : arrayList) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ForegroundResourceLoader.f(ForegroundResourceLoader.this, cVar3, cVar, aVar, countDownLatch);
                    }
                }, 128, null, true);
            }
            countDownLatch.await();
        }
        return aVar;
    }
}
