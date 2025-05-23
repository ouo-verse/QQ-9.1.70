package com.tencent.mobileqq.zplan.aigc.helper;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0011\u0010\u001d\"\u0004\b\u001b\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/CouponShoppingBagHelper;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "c", "Landroid/content/Context;", "context", "", "source", "", "e", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "b", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "getLoadingView", "()Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "loadingView", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;Landroidx/lifecycle/LifecycleOwner;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CouponShoppingBagHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AvatarGlobalLoadingView loadingView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    public CouponShoppingBagHelper(ViewGroup container, AvatarGlobalLoadingView loadingView, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.container = container;
        this.loadingView = loadingView;
        this.lifecycleOwner = lifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.nativeui.data.j c() {
        ga4.i iVar = new ga4.i(this.container);
        com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar2 = new com.tencent.sqshow.zootopia.nativeui.data.repo.i();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar);
        jVar.Z(this.lifecycleOwner);
        jVar.X(this.loadingView);
        jVar.T(iVar2);
        return jVar;
    }

    /* renamed from: b, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    public final void d(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        this.mChannel = jVar;
    }

    public final void e(Context context, String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CouponShoppingBagHelper$showShoppingBag$1(this, context, source, null), 3, null);
    }
}
