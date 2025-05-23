package com.tencent.mobileqq.zplan.aio.panel.item;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import ku4.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020)\u0012\b\b\u0002\u0010.\u001a\u00020)\u00a2\u0006\u0004\bT\u0010UJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010 \u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\"\u0010%\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\u0010\u0010\"\"\u0004\b#\u0010$R\u001a\u0010(\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010\"R\u001a\u0010,\u001a\u00020)8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b\u001e\u0010+R\u001a\u0010.\u001a\u00020)8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b\u0016\u0010+R\u001a\u00100\u001a\u00020\u00038\u0016X\u0096D\u00a2\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b/\u0010\"R\"\u00102\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b&\u0010\"\"\u0004\b1\u0010$R \u00106\u001a\b\u0012\u0004\u0012\u0002030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b-\u00105R\u001c\u0010;\u001a\u0004\u0018\u0001078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b\u001b\u0010:R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\b\n\u00105R<\u0010E\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020>\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0017\u0010Q\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010N\u001a\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/NormalItem;", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "Lkotlinx/coroutines/Deferred;", "", "t", "", DomainData.DOMAIN_NAME, "needLoad", "o", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "i", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "", "e", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "text", "Lku4/n;", "f", "Lku4/n;", "w", "()Lku4/n;", "resourceConfig", "g", HippyTKDListViewAdapter.X, "thumbnailUrl", h.F, "u", "identifyingUrl", "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "has", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNeedPay", "", "I", "()I", "price", "l", "id", "b", "canSelected", ReportConstant.COSTREPORT_PREFIX, "selected", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/Deferred;", "()Lkotlinx/coroutines/Deferred;", "thumbnailJob", "Lcom/tencent/mobileqq/zplan/aio/panel/item/a;", "p", "Lcom/tencent/mobileqq/zplan/aio/panel/item/a;", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/a;", "identifying", "contentLoadingJob", "Lkotlin/Function2;", "Lle3/b;", "r", "Lkotlin/jvm/functions/Function2;", "getOnSelectListener", "()Lkotlin/jvm/functions/Function2;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lkotlin/jvm/functions/Function2;)V", "onSelectListener", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnExposeListener", "()Lkotlin/jvm/functions/Function0;", "y", "(Lkotlin/jvm/functions/Function0;)V", "onExposeListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "v", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "needLoadOnClick", "Landroid/content/Context;", "context", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Lku4/n;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class NormalItem extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final n resourceConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String thumbnailUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String identifyingUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean has;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean isNeedPay;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int price;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean canSelected;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Deferred<Drawable> thumbnailJob;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Identifying identifying;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Deferred<Boolean> contentLoadingJob;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private Function2<? super CoroutineScope, ? super le3.b, ? extends Deferred<Boolean>> onSelectListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onExposeListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean needLoadOnClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$1", f = "Item.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {
        final /* synthetic */ Drawable $loadingDrawable;
        final /* synthetic */ WeakReference<NormalItem> $thisRef;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WeakReference<NormalItem> weakReference, Drawable drawable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$thisRef = weakReference;
            this.$loadingDrawable = drawable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$thisRef, this.$loadingDrawable, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NormalItem normalItem = this.$thisRef.get();
                if (normalItem == null) {
                    return new ColorDrawable(0);
                }
                if (TextUtils.isEmpty(normalItem.getThumbnailUrl())) {
                    return this.$loadingDrawable;
                }
                String thumbnailUrl = normalItem.getThumbnailUrl();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = this.$loadingDrawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                return URLDrawable.getDrawable(thumbnailUrl, obtain);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Drawable> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/image/URLDrawable;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$2", f = "Item.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URLDrawable>, Object> {
        final /* synthetic */ Drawable $loadingDrawable;
        final /* synthetic */ WeakReference<NormalItem> $thisRef;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WeakReference<NormalItem> weakReference, Drawable drawable, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$thisRef = weakReference;
            this.$loadingDrawable = drawable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$thisRef, this.$loadingDrawable, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NormalItem normalItem = this.$thisRef.get();
                if (normalItem == null) {
                    return null;
                }
                String identifyingUrl = normalItem.getIdentifyingUrl();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = this.$loadingDrawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                return URLDrawable.getDrawable(identifyingUrl, obtain);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URLDrawable> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$3", f = "Item.kt", i = {0}, l = {113, 114}, m = "invokeSuspend", n = {"self"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$3, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ WeakReference<NormalItem> $thisRef;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(WeakReference<NormalItem> weakReference, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$thisRef = weakReference;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$thisRef, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            NormalItem normalItem;
            Deferred<Drawable> a16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                normalItem = this.$thisRef.get();
                if (normalItem == null) {
                    return Boxing.boxBoolean(false);
                }
                Deferred<Drawable> l3 = normalItem.l();
                this.L$0 = normalItem;
                this.label = 1;
                if (l3.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Boxing.boxBoolean(true);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                normalItem = (NormalItem) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Identifying identifying = normalItem.getIdentifying();
            if (identifying != null && (a16 = identifying.a()) != null) {
                this.L$0 = null;
                this.label = 2;
                obj = a16.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(true);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\bR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 \u00a8\u0006$"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/item/NormalItem$a", "Lle3/b;", "", "getId", "()I", "id", "", "getName", "()Ljava/lang/String;", "name", "c", "mainIconUrl", "d", "cornerIconUrl", h.F, "aioBackgroundUrl", "k", "friendTimeBackgroundUrl", "getActionType", "actionType", "b", "friendViewId", "i", "aioBgBottomColor", "f", "friendTimeBgBottomColor", "g", "aioBgTopColor", "j", "friendTimeBgTopColor", "", "e", "()Z", "has", "a", "isNeedPay", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements le3.b {
        a() {
        }

        @Override // le3.b
        public boolean a() {
            return NormalItem.this.getResourceConfig().f413133n;
        }

        @Override // le3.b
        public int b() {
            return NormalItem.this.getResourceConfig().f413127h;
        }

        @Override // le3.b
        public String c() {
            String str = NormalItem.this.getResourceConfig().f413122c;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.mainIconUrl");
            return str;
        }

        @Override // le3.b
        public String d() {
            String str = NormalItem.this.getResourceConfig().f413123d;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.cornerIconUrl");
            return str;
        }

        @Override // le3.b
        public boolean e() {
            return NormalItem.this.getHas();
        }

        @Override // le3.b
        public String f() {
            String str = NormalItem.this.getResourceConfig().f413129j;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.friendTimeBgBottomColor");
            return str;
        }

        @Override // le3.b
        public String g() {
            String str = NormalItem.this.getResourceConfig().f413130k;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.aioBgTopColor");
            return str;
        }

        @Override // le3.b
        public int getActionType() {
            return NormalItem.this.getResourceConfig().f413126g;
        }

        @Override // le3.b
        public int getId() {
            return NormalItem.this.getResourceConfig().f413120a;
        }

        @Override // le3.b
        public String getName() {
            String str = NormalItem.this.getResourceConfig().f413121b;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.name");
            return str;
        }

        @Override // le3.b
        public String h() {
            String str = NormalItem.this.getResourceConfig().f413124e;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.aioBackgroundUrl");
            return str;
        }

        @Override // le3.b
        public String i() {
            String str = NormalItem.this.getResourceConfig().f413128i;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.aioBgBottomColor");
            return str;
        }

        @Override // le3.b
        public String j() {
            String str = NormalItem.this.getResourceConfig().f413131l;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.friendTimeBgTopColor");
            return str;
        }

        @Override // le3.b
        public String k() {
            String str = NormalItem.this.getResourceConfig().f413125f;
            Intrinsics.checkNotNullExpressionValue(str, "resourceConfig.friendTimeBackgroundUrl");
            return str;
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: b, reason: from getter */
    public boolean getCanSelected() {
        return this.canSelected;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public Deferred<Boolean> d() {
        return this.contentLoadingJob;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: e, reason: from getter */
    public boolean getHas() {
        return this.has;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: f, reason: from getter */
    public int getId() {
        return this.id;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: g, reason: from getter */
    public Identifying getIdentifying() {
        return this.identifying;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: h, reason: from getter */
    public int getPrice() {
        return this.price;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: i, reason: from getter */
    public CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: j, reason: from getter */
    public boolean getSelected() {
        return this.selected;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: k, reason: from getter */
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public Deferred<Drawable> l() {
        return this.thumbnailJob;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: m, reason: from getter */
    public boolean getIsNeedPay() {
        return this.isNeedPay;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void n() {
        this.onExposeListener.invoke();
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void o(boolean needLoad) {
        this.needLoadOnClick.getAndSet(needLoad);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void q(boolean z16) {
        this.has = z16;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void s(boolean z16) {
        this.selected = z16;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public Deferred<Boolean> t() {
        Deferred<Boolean> invoke;
        Function2<? super CoroutineScope, ? super le3.b, ? extends Deferred<Boolean>> function2 = this.onSelectListener;
        return (function2 == null || (invoke = function2.invoke(getScope(), new a())) == null) ? CompletableDeferredKt.CompletableDeferred(Boolean.FALSE) : invoke;
    }

    /* renamed from: u, reason: from getter */
    public final String getIdentifyingUrl() {
        return this.identifyingUrl;
    }

    /* renamed from: v, reason: from getter */
    public final AtomicBoolean getNeedLoadOnClick() {
        return this.needLoadOnClick;
    }

    /* renamed from: w, reason: from getter */
    public final n getResourceConfig() {
        return this.resourceConfig;
    }

    /* renamed from: x, reason: from getter */
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final void y(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onExposeListener = function0;
    }

    public final void z(Function2<? super CoroutineScope, ? super le3.b, ? extends Deferred<Boolean>> function2) {
        this.onSelectListener = function2;
    }

    public NormalItem(CoroutineScope scope, String text, n resourceConfig, Context context, String thumbnailUrl, String identifyingUrl, boolean z16, boolean z17, int i3, int i16) {
        Drawable b16;
        Identifying identifying;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(resourceConfig, "resourceConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
        Intrinsics.checkNotNullParameter(identifyingUrl, "identifyingUrl");
        this.scope = scope;
        this.text = text;
        this.resourceConfig = resourceConfig;
        this.thumbnailUrl = thumbnailUrl;
        this.identifyingUrl = identifyingUrl;
        this.has = z16;
        this.isNeedPay = z17;
        this.price = i3;
        this.id = i16;
        this.canSelected = true;
        WeakReference weakReference = new WeakReference(this);
        b16 = c.b(context);
        CoroutineScope scope2 = getScope();
        CoroutineStart coroutineStart = CoroutineStart.LAZY;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16 = CorountineFunKt.c(scope2, "zplan_Normal2Item_\u62c9\u53d6\u7f29\u7565\u56fe", null, coroutineStart, new AnonymousClass1(weakReference, b16, null), 2, null);
        Intrinsics.checkNotNull(c16);
        Deferred<Drawable> o16 = c16.o();
        Intrinsics.checkNotNull(o16);
        this.thumbnailJob = o16;
        if (TextUtils.isEmpty(identifyingUrl)) {
            identifying = null;
        } else {
            com.tencent.mobileqq.qcoroutine.api.coroutine.a c17 = CorountineFunKt.c(getScope(), "zplan_Normal2Item_\u62c9\u53d6\u89d2\u6807", null, coroutineStart, new AnonymousClass2(weakReference, b16, null), 2, null);
            Intrinsics.checkNotNull(c17);
            Deferred o17 = c17.o();
            Intrinsics.checkNotNull(o17);
            identifying = new Identifying(o17, 0.0f, 0.0f, 6, null);
        }
        this.identifying = identifying;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c18 = CorountineFunKt.c(getScope(), "zplan_Normal2Item_\u62c9\u53d6\u8d44\u6e90", null, coroutineStart, new AnonymousClass3(weakReference, null), 2, null);
        Intrinsics.checkNotNull(c18);
        Deferred<Boolean> o18 = c18.o();
        Intrinsics.checkNotNull(o18);
        this.contentLoadingJob = o18;
        this.onExposeListener = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.item.NormalItem$onExposeListener$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.needLoadOnClick = new AtomicBoolean(false);
    }
}
