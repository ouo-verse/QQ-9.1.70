package com.tencent.mobileqq.zplan.aio.panel.item;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0096\u0001\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012'\u0010\u001c\u001a#\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\"\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050(\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\b\b\u0002\u00104\u001a\u00020\"\u0012\b\b\u0002\u00105\u001a\u00020\"\u00a2\u0006\u0004\bK\u0010LJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R5\u0010\u001c\u001a#\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u000e\u0010 \"\u0004\b,\u0010-R\u001a\u00101\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b/\u0010\u001e\u001a\u0004\b0\u0010 R\u001a\u00104\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b0\u00102\u001a\u0004\b\u001d\u00103R\u001a\u00105\u001a\u00020\"8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b\u0012\u00103R\u001a\u0010\u0019\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b#\u00108R\u001c\u0010>\u001a\u0004\u0018\u0001098\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010@\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b?\u0010-R\u001a\u0010C\u001a\u00020\u00038\u0016X\u0096D\u00a2\u0006\f\n\u0004\bA\u0010\u001e\u001a\u0004\bB\u0010 R \u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110D8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b?\u0010E\u001a\u0004\bF\u0010GR \u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030D8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010E\u001a\u0004\bI\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/ButtonItem;", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "Lkotlinx/coroutines/Deferred;", "", "t", "", DomainData.DOMAIN_NAME, "", "d", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "text", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "icon", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "scope", "g", "Lkotlin/jvm/functions/Function1;", "performClickAsync", h.F, "Z", "c", "()Z", "clipToOutline", "", "i", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "backgroundColor", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "performExpose", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "has", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNeedPay", "I", "()I", "price", "id", "o", "Lkotlinx/coroutines/CoroutineScope;", "()Lkotlinx/coroutines/CoroutineScope;", "", "p", "Ljava/lang/Void;", "v", "()Ljava/lang/Void;", "identifying", ReportConstant.COSTREPORT_PREFIX, "selected", "r", "b", "canSelected", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableDeferred;", "w", "()Lkotlinx/coroutines/CompletableDeferred;", "thumbnailJob", "u", "contentLoadingJob", "<init>", "(Ljava/lang/String;Landroid/content/Context;Landroid/graphics/drawable/Drawable;Lkotlin/jvm/functions/Function1;ZLjava/lang/Integer;Lkotlin/jvm/functions/Function0;ZZII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ButtonItem extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Drawable icon;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Function1<CoroutineScope, Deferred<Boolean>> performClickAsync;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean clipToOutline;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Integer backgroundColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> performExpose;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean has;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean isNeedPay;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int price;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Void identifying;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final boolean canSelected;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final CompletableDeferred<Drawable> thumbnailJob;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final CompletableDeferred<Boolean> contentLoadingJob;

    public /* synthetic */ ButtonItem(String str, Context context, Drawable drawable, Function1 function1, boolean z16, Integer num, Function0 function0, boolean z17, boolean z18, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, drawable, function1, (i17 & 16) != 0 ? true : z16, (i17 & 32) != 0 ? Integer.valueOf(Color.rgb(245, 245, 245)) : num, (i17 & 64) != 0 ? new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.item.ButtonItem.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0, (i17 & 128) != 0 ? false : z17, (i17 & 256) != 0 ? false : z18, (i17 & 512) != 0 ? 0 : i3, (i17 & 1024) != 0 ? 0 : i16);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: a, reason: from getter */
    public Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: b, reason: from getter */
    public boolean getCanSelected() {
        return this.canSelected;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: c, reason: from getter */
    public boolean getClipToOutline() {
        return this.clipToOutline;
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
    /* renamed from: g */
    public /* bridge */ /* synthetic */ Identifying getIdentifying() {
        return (Identifying) getIdentifying();
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
    /* renamed from: m, reason: from getter */
    public boolean getIsNeedPay() {
        return this.isNeedPay;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void n() {
        this.performExpose.invoke();
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
        return this.performClickAsync.invoke(getScope());
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public CompletableDeferred<Boolean> d() {
        return this.contentLoadingJob;
    }

    /* renamed from: v, reason: from getter */
    public Void getIdentifying() {
        return this.identifying;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public CompletableDeferred<Drawable> l() {
        return this.thumbnailJob;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ButtonItem(String text, Context context, Drawable icon, Function1<? super CoroutineScope, ? extends Deferred<Boolean>> performClickAsync, boolean z16, Integer num, Function0<Unit> performExpose, boolean z17, boolean z18, int i3, int i16) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(performClickAsync, "performClickAsync");
        Intrinsics.checkNotNullParameter(performExpose, "performExpose");
        this.text = text;
        this.context = context;
        this.icon = icon;
        this.performClickAsync = performClickAsync;
        this.clipToOutline = z16;
        this.backgroundColor = num;
        this.performExpose = performExpose;
        this.has = z17;
        this.isNeedPay = z18;
        this.price = i3;
        this.id = i16;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        Intrinsics.checkNotNull(f16);
        this.scope = f16;
        this.thumbnailJob = CompletableDeferredKt.CompletableDeferred(icon);
        this.contentLoadingJob = CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
    }
}
