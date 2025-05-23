package com.tencent.mobileqq.guild.gift.view.banner;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.util.bd;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020$j\b\u0012\u0004\u0012\u00020\u0002`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue;", "", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "g", "j", "k", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "i", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "Lkotlin/Function1;", "output", DomainData.DOMAIN_NAME, "o", "", "a", "J", "duration", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "b", "Ljava/util/concurrent/ConcurrentLinkedDeque;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lcom/tencent/mobileqq/guild/util/bd;", "c", "Lcom/tencent/mobileqq/guild/util/bd;", "handler", "d", "Z", "isFirstElement", "e", "isRunning", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "giftAnimDatas", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "getGiftData", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "setGiftData", "(Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;)V", "giftData", "<init>", "(J)V", "MyRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MediaGiftQueue {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long duration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentLinkedDeque<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> queue = new ConcurrentLinkedDeque<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bd handler = new bd();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstElement = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> giftAnimDatas = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue$MyRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "d", "Lkotlin/jvm/functions/Function1;", "getOutput", "()Lkotlin/jvm/functions/Function1;", "output", "<init>", "(Lcom/tencent/mobileqq/guild/gift/view/banner/MediaGiftQueue;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private final class MyRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.qqgift.mvvm.business.anim.a, Unit> output;
        final /* synthetic */ MediaGiftQueue this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public MyRunnable(@NotNull MediaGiftQueue mediaGiftQueue, Function1<? super com.tencent.mobileqq.qqgift.mvvm.business.anim.a, Unit> output) {
            Intrinsics.checkNotNullParameter(output, "output");
            this.this$0 = mediaGiftQueue;
            this.output = output;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a m3 = this.this$0.m();
            if (this.this$0.isFirstElement) {
                if (m3 != null) {
                    this.output.invoke(m3);
                }
                this.this$0.isFirstElement = false;
            } else if (m3 != null) {
                this.output.invoke(m3);
            }
            if (this.this$0.queue.isEmpty() || m3 == null) {
                this.this$0.isRunning = false;
                this.this$0.isFirstElement = true;
            } else {
                if (((com.tencent.mobileqq.qqgift.mvvm.business.anim.a) this.this$0.queue.getFirst()).f264925p != m3.f264925p) {
                    j3 = this.this$0.duration;
                } else {
                    j3 = 400;
                }
                this.this$0.handler.c(this, j3);
            }
        }
    }

    public MediaGiftQueue(long j3) {
        this.duration = j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[LOOP:0: B:13:0x0042->B:15:0x0051, LOOP_START, PHI: r1 r2
  0x0042: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:12:0x0040, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]
  0x0042: PHI (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:12:0x0040, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        this.giftAnimDatas.clear();
        int i16 = data.f264926q;
        int i17 = 1;
        if (i16 == 0) {
            data.f264928s = 1;
            this.giftAnimDatas.add(data);
            j(data);
            return;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.giftData;
        if (aVar != null && i16 > 1) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.f264925p == data.f264925p) {
                int i18 = data.f264926q;
                com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = this.giftData;
                Intrinsics.checkNotNull(aVar2);
                i16 = i18 - aVar2.f264926q;
                com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar3 = this.giftData;
                Intrinsics.checkNotNull(aVar3);
                i3 = aVar3.f264926q + 1;
                if (1 <= i16) {
                    while (true) {
                        com.tencent.mobileqq.qqgift.mvvm.business.anim.a k3 = k(data);
                        int i19 = i3 + 1;
                        k3.f264928s = i3;
                        this.giftAnimDatas.add(k3);
                        if (i17 == i16) {
                            break;
                        }
                        i17++;
                        i3 = i19;
                    }
                }
                j(data);
            }
        }
        i3 = 1;
        if (1 <= i16) {
        }
        j(data);
    }

    public final void h(@NotNull List<? extends com.tencent.mobileqq.qqgift.mvvm.business.anim.a> elements) {
        List reversed;
        Intrinsics.checkNotNullParameter(elements, "elements");
        reversed = CollectionsKt___CollectionsKt.reversed(elements);
        Iterator it = reversed.iterator();
        while (it.hasNext()) {
            this.queue.addFirst((com.tencent.mobileqq.qqgift.mvvm.business.anim.a) it.next());
        }
    }

    public final void i(@NotNull List<? extends com.tencent.mobileqq.qqgift.mvvm.business.anim.a> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends com.tencent.mobileqq.qqgift.mvvm.business.anim.a> it = elements.iterator();
        while (it.hasNext()) {
            this.queue.addLast(it.next());
        }
    }

    public final void j(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        List reversed;
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(String.valueOf(data.f264918i), MediaChannelCore.INSTANCE.a().o0().getSelfUserInfo().f228093a)) {
            if (data.f264926q > 1 && this.queue.size() >= 1 && this.queue.getFirst().f264925p == data.f264925p) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> it = this.queue.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.qqgift.mvvm.business.anim.a next = it.next();
                    if (next.f264925p != data.f264925p) {
                        break;
                    } else {
                        linkedHashSet.add(next);
                    }
                }
                this.queue.removeAll(linkedHashSet);
                Iterator<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> it5 = this.giftAnimDatas.iterator();
                while (it5.hasNext()) {
                    linkedHashSet.add(it5.next());
                }
                reversed = CollectionsKt___CollectionsKt.reversed(linkedHashSet);
                Iterator it6 = reversed.iterator();
                while (it6.hasNext()) {
                    this.queue.addFirst((com.tencent.mobileqq.qqgift.mvvm.business.anim.a) it6.next());
                }
            } else {
                h(this.giftAnimDatas);
            }
        } else {
            i(this.giftAnimDatas);
        }
        this.giftData = data;
    }

    @NotNull
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.a k(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        aVar.f264910a = data.f264910a;
        aVar.f264913d = data.f264913d;
        aVar.f264914e = data.f264914e;
        aVar.f264924o = data.f264924o;
        aVar.f264912c = data.f264912c;
        aVar.f264915f = data.f264915f;
        aVar.f264911b = data.f264911b;
        aVar.f264925p = data.f264925p;
        aVar.f264926q = data.f264926q;
        aVar.f264918i = data.f264918i;
        aVar.f264919j = data.f264919j;
        aVar.f264922m = data.f264922m;
        aVar.f264920k = data.f264920k;
        aVar.f264921l = data.f264921l;
        aVar.f264923n = data.f264923n;
        return aVar;
    }

    public final boolean l() {
        if (this.isRunning && this.queue.size() > 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.a m() {
        return this.queue.pollFirst();
    }

    public final void n(@NotNull Function1<? super com.tencent.mobileqq.qqgift.mvvm.business.anim.a, Unit> output) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.isRunning = true;
        this.handler.b(new MyRunnable(this, output));
    }

    public final void o() {
        this.isRunning = false;
        this.queue.clear();
        this.handler.d();
    }
}
