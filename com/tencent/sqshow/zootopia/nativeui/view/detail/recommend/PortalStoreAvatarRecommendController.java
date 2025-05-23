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
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.repo.f;
import com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.IStateChangeListener;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bk;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u001c\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010.R\"\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00060-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendController;", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/b;", "Luv4/bk;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", VideoTemplateParser.ITEM_LIST, "l", "storeItemList", "o", "", NodeProps.VISIBLE, "p", "g", "f", tl.h.F, "", "withAnim", "a", "b", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "j", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "J", "ANIM_DURATION", "c", "Ljava/util/List;", "mDefaultRecommendList", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView;", "mRecommendFloatView", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/f;", "e", "Lkotlin/Lazy;", "k", "()Lcom/tencent/sqshow/zootopia/nativeui/data/repo/f;", "mRecommendDataRepo", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/a;", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/a;", "mRecommendAntiDisturbController", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "clickedItemChangeObserver", "recommendItemListChangeObserver", "Landroid/view/ViewStub;", "viewStub", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;Landroid/view/ViewStub;)V", "i", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreAvatarRecommendController implements com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long ANIM_DURATION;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<bk> mDefaultRecommendList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final PortalStoreAvatarRecommendFloatView mRecommendFloatView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mRecommendDataRepo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final a mRecommendAntiDisturbController;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Observer<bk> clickedItemChangeObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Observer<List<bk>> recommendItemListChangeObserver;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendController$b", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/f$b;", "", "itemId", "", "Luv4/bk;", "result", "", "onSuccess", "errCode", "", "errMsg", "onError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements f.b {
        b() {
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.data.repo.f.b
        public void onError(int errCode, String errMsg) {
            QLog.e("AvatarRecommendController", 1, "request list error, errCode=" + errCode + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.sqshow.zootopia.nativeui.data.repo.f.b
        public void onSuccess(int itemId, List<bk> result) {
            int collectionSizeOrDefault;
            az azVar;
            Intrinsics.checkNotNullParameter(result, "result");
            int size = result.size();
            List<bk> list = result;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((bk) it.next()).f440366b);
            }
            QLog.i("AvatarRecommendController", 1, "request list success, itemId=" + itemId + ", size=" + size + ", list=" + r94.b.p(arrayList));
            bk value = PortalStoreAvatarRecommendController.this.getChannel().k().getValue();
            boolean z16 = false;
            if (value != null && (azVar = value.f440366b) != null && azVar.f440275b == itemId) {
                z16 = true;
            }
            if (z16) {
                PortalStoreAvatarRecommendController.this.mRecommendFloatView.setRecommendStoreItemList(result);
            } else {
                QLog.w("AvatarRecommendController", 1, "current click item changed, no need refresh data");
            }
        }
    }

    public PortalStoreAvatarRecommendController(com.tencent.sqshow.zootopia.nativeui.data.j channel, ViewStub viewStub) {
        List<bk> emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        this.channel = channel;
        this.ANIM_DURATION = 100L;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mDefaultRecommendList = emptyList;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.sqshow.zootopia.nativeui.data.repo.f>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.PortalStoreAvatarRecommendController$mRecommendDataRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.sqshow.zootopia.nativeui.data.repo.f invoke() {
                return new com.tencent.sqshow.zootopia.nativeui.data.repo.f();
            }
        });
        this.mRecommendDataRepo = lazy;
        this.clickedItemChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreAvatarRecommendController.i(PortalStoreAvatarRecommendController.this, (bk) obj);
            }
        };
        this.recommendItemListChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreAvatarRecommendController.n(PortalStoreAvatarRecommendController.this, (List) obj);
            }
        };
        View findViewById = viewStub.inflate().findViewById(R.id.qfy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewStub.inflate().findV\u2026ById(R.id.recommend_view)");
        PortalStoreAvatarRecommendFloatView portalStoreAvatarRecommendFloatView = (PortalStoreAvatarRecommendFloatView) findViewById;
        this.mRecommendFloatView = portalStoreAvatarRecommendFloatView;
        portalStoreAvatarRecommendFloatView.p(channel);
        a aVar = new a();
        this.mRecommendAntiDisturbController = aVar;
        portalStoreAvatarRecommendFloatView.j(aVar);
        h();
    }

    private final void f() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.mRecommendFloatView, "translationX", 0.0f, r1.getWidth()));
        animatorSet.setDuration(this.ANIM_DURATION);
        animatorSet.start();
    }

    private final void g() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRecommendFloatView, "translationX", r1.getWidth(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRecommendFloatView, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mRecommendFloatView, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mRecommendFloatView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animatorSet.play(ofFloat4);
        animatorSet.setDuration(this.ANIM_DURATION);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PortalStoreAvatarRecommendController this$0, bk bkVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(bkVar);
    }

    private final com.tencent.sqshow.zootopia.nativeui.data.repo.f k() {
        return (com.tencent.sqshow.zootopia.nativeui.data.repo.f) this.mRecommendDataRepo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(PortalStoreAvatarRecommendController this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(list);
    }

    private final void o(List<bk> storeItemList) {
        this.mDefaultRecommendList = storeItemList;
        this.mRecommendFloatView.setRecommendStoreItemList(storeItemList);
    }

    private final void p(int visible) {
        if (visible == this.mRecommendFloatView.getVisibility()) {
            return;
        }
        this.mRecommendFloatView.setVisibility(visible);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b
    public void a(boolean withAnim) {
        if (this.mRecommendAntiDisturbController.f()) {
            this.mRecommendFloatView.setState(IStateChangeListener.State.EXPAND);
        } else {
            this.mRecommendFloatView.setState(IStateChangeListener.State.FOLD);
        }
        g();
        this.mRecommendFloatView.z();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b
    public void b(boolean withAnim) {
        f();
        this.mRecommendFloatView.y();
    }

    public final void h() {
        LifecycleOwner lifecycleOwner = this.channel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        this.channel.k().observe(lifecycleOwner, this.clickedItemChangeObserver);
        this.channel.B().observe(lifecycleOwner, this.recommendItemListChangeObserver);
    }

    /* renamed from: j, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getChannel() {
        return this.channel;
    }

    private final void l(List<bk> itemList) {
        String str;
        int collectionSizeOrDefault;
        Integer valueOf = itemList != null ? Integer.valueOf(itemList.size()) : null;
        if (itemList != null) {
            List<bk> list = itemList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((bk) it.next()).f440366b);
            }
            str = r94.b.p(arrayList);
        } else {
            str = null;
        }
        boolean z16 = true;
        QLog.i("AvatarRecommendController", 1, "onRecommendListChange, itemList.size=" + valueOf + ", itemList=" + str);
        List<bk> list2 = itemList;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            p(8);
            return;
        }
        o(itemList);
        this.mRecommendFloatView.setCurrentClickStoreItem(null);
        p(0);
    }

    private final void m(bk item) {
        az azVar;
        az azVar2;
        az azVar3;
        Unit unit = null;
        QLog.i("AvatarRecommendController", 1, "onItemClicked, itemId=" + ((item == null || (azVar3 = item.f440366b) == null) ? null : Integer.valueOf(azVar3.f440275b)) + ", itemName==" + ((item == null || (azVar2 = item.f440366b) == null) ? null : azVar2.f440277d));
        this.mRecommendFloatView.setCurrentClickStoreItem(item != null ? item.f440366b : null);
        if (item != null && (azVar = item.f440366b) != null) {
            k().b(azVar.f440275b, new b());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.mRecommendFloatView.setRecommendStoreItemList(this.mDefaultRecommendList);
        }
    }
}
