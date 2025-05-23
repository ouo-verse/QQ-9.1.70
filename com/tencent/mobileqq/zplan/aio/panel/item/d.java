package com.tencent.mobileqq.zplan.aio.panel.item;

import android.graphics.drawable.ColorDrawable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u00038\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR \u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b\"\u0010#R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b%\u0010#R\"\u0010)\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b\u0006\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010+\u001a\u00020\u00038\u0016X\u0096D\u00a2\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b*\u0010\u001aR\u001a\u00100\u001a\u00020,8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u0017\u0010/R\u001a\u00102\u001a\u00020,8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b\f\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/d;", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "Lkotlinx/coroutines/CompletableDeferred;", "", HippyTKDListViewAdapter.X, "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "i", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "", "f", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "text", "", "g", "Ljava/lang/Void;", "v", "()Ljava/lang/Void;", "identifying", h.F, "Z", "j", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "selected", "b", "canSelected", "Landroid/graphics/drawable/ColorDrawable;", "Lkotlinx/coroutines/CompletableDeferred;", "w", "()Lkotlinx/coroutines/CompletableDeferred;", "thumbnailJob", "u", "contentLoadingJob", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "has", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNeedPay", "", DomainData.DOMAIN_NAME, "I", "()I", "price", "o", "id", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final d f331180d = new d();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope scope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final String text;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Void identifying = null;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean selected;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final boolean canSelected = false;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final CompletableDeferred<ColorDrawable> thumbnailJob;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final CompletableDeferred<Boolean> contentLoadingJob;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static boolean has;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final boolean isNeedPay = false;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final int price = 0;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final int id = 0;

    static {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        Intrinsics.checkNotNull(f16);
        scope = f16;
        text = "\u52a0\u8f7d\u4e2d";
        thumbnailJob = CompletableDeferredKt.CompletableDeferred(new ColorDrawable(0));
        CompletableDeferred<Boolean> CompletableDeferred = CompletableDeferredKt.CompletableDeferred((Job) null);
        Job.DefaultImpls.cancel$default((Job) CompletableDeferred, (CancellationException) null, 1, (Object) null);
        contentLoadingJob = CompletableDeferred;
    }

    d() {
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: b */
    public boolean getCanSelected() {
        return canSelected;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: e */
    public boolean getHas() {
        return has;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: f */
    public int getId() {
        return id;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: g */
    public /* bridge */ /* synthetic */ Identifying getIdentifying() {
        return (Identifying) v();
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: h */
    public int getPrice() {
        return price;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: i */
    public CoroutineScope getScope() {
        return scope;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: j */
    public boolean getSelected() {
        return selected;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: k */
    public String getText() {
        return text;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: m */
    public boolean getIsNeedPay() {
        return isNeedPay;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void q(boolean z16) {
        has = z16;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    public void s(boolean z16) {
        selected = z16;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public CompletableDeferred<Boolean> d() {
        return contentLoadingJob;
    }

    public Void v() {
        return identifying;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public CompletableDeferred<ColorDrawable> l() {
        return thumbnailJob;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.item.b
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public CompletableDeferred<Boolean> t() {
        return CompletableDeferredKt.CompletableDeferred(Boolean.TRUE);
    }
}
