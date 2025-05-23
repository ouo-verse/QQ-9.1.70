package com.tencent.sqshow.zootopia.nativeui.view.detail.recommend;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/d;", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/b;", "Luv4/bk;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", tl.h.F, "", NodeProps.VISIBLE, "i", "e", "d", "f", "", "withAnim", "a", "b", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "J", "ANIM_DURATION", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarDetailFloatView;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarDetailFloatView;", "mDetailFloatView", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "clickedItemChangeObserver", "Landroid/view/ViewStub;", "viewStub", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;Landroid/view/ViewStub;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long ANIM_DURATION;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final PortalStoreAvatarDetailFloatView mDetailFloatView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Observer<bk> clickedItemChangeObserver;

    public d(com.tencent.sqshow.zootopia.nativeui.data.j channel, ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        this.channel = channel;
        this.ANIM_DURATION = 100L;
        this.clickedItemChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.g(d.this, (bk) obj);
            }
        };
        View findViewById = viewStub.inflate().findViewById(R.id.ppc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewStub.inflate().findViewById(R.id.detail_view)");
        PortalStoreAvatarDetailFloatView portalStoreAvatarDetailFloatView = (PortalStoreAvatarDetailFloatView) findViewById;
        this.mDetailFloatView = portalStoreAvatarDetailFloatView;
        portalStoreAvatarDetailFloatView.b(channel);
        f();
    }

    private final void d() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.mDetailFloatView, "translationX", 0.0f, r1.getWidth()));
        animatorSet.setDuration(this.ANIM_DURATION);
        animatorSet.start();
    }

    private final void e() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mDetailFloatView, "translationX", r1.getWidth(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mDetailFloatView, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mDetailFloatView, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mDetailFloatView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animatorSet.play(ofFloat4);
        animatorSet.setDuration(this.ANIM_DURATION);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0, bk bkVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(bkVar);
    }

    private final void i(int visible) {
        if (visible == this.mDetailFloatView.getVisibility()) {
            return;
        }
        this.mDetailFloatView.setVisibility(visible);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b
    public void a(boolean withAnim) {
        e();
        this.mDetailFloatView.f();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b
    public void b(boolean withAnim) {
        d();
        this.mDetailFloatView.e();
    }

    public final void f() {
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.channel.k().observe(lifecycleOwner, this.clickedItemChangeObserver);
    }

    private final void h(bk item) {
        az azVar;
        az azVar2;
        Unit unit = null;
        QLog.i("PortalStoreAvatarDetailController", 1, "onItemClicked, itemId=" + ((item == null || (azVar2 = item.f440366b) == null) ? null : Integer.valueOf(azVar2.f440275b)) + ", itemName==" + ((item == null || (azVar = item.f440366b) == null) ? null : azVar.f440277d));
        this.mDetailFloatView.setCurrentClickStoreItem(item != null ? item.f440366b : null);
        if (item != null && item.f440366b != null) {
            i(0);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            i(8);
        }
    }
}
