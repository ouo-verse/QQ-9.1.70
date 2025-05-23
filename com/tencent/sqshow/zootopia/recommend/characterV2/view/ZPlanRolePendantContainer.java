package com.tencent.sqshow.zootopia.recommend.characterV2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.c;
import com.tencent.sqshow.zootopia.nativeui.data.o;
import com.tencent.sqshow.zootopia.recommend.characterV2.controller.a;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRolePendantContainer;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.cl;
import pv4.s;
import tl.h;
import uv4.u;
import uv4.w;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\u0006\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0014\u0010\u0011\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0010J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\b0.j\b\u0012\u0004\u0012\u00020\b`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00100R0\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n02j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`38\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00107R\u0014\u0010:\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010<\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006U"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "", "p", "", "index", "Lpv4/s;", "data", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/view/ZPlanRolePendantItemView;", "e", "g", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "bubbleOwner", "setRoleBubbleOwner", "", "o", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "avatarInterface", "setAvatarComponentInterface", "k", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "success", "engineInitFinish", "Luv4/w;", "rsp", "hasCacheData", "B", "errorCode", "", "errorMsg", "onFailed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "j", h.F, "Ln74/cl;", "d", "Ln74/cl;", "mBinding", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "mItemViewPool", "I", "mItemWidth", "i", "mItemHeight", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "mFirstFrameResult", "Luv4/u;", BdhLogUtil.LogTag.Tag_Conn, "Luv4/u;", "mNativeUIRsp", "D", "Luv4/w;", "mNativeUIV1Rsp", "E", "Z", "mNativeUIHasCacheData", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "mBubbleOwner", "G", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRolePendantContainer extends FrameLayout implements c, o {

    /* renamed from: C, reason: from kotlin metadata */
    private u mNativeUIRsp;

    /* renamed from: D, reason: from kotlin metadata */
    private w mNativeUIV1Rsp;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mNativeUIHasCacheData;

    /* renamed from: F, reason: from kotlin metadata */
    private a mBubbleOwner;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.recommend.characterV2.component.a avatarInterface;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final cl mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<s> mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, ZPlanRolePendantItemView> mItemViewPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mItemWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mItemHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FirstFrameResult mFirstFrameResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRolePendantContainer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ZPlanRolePendantItemView e(int index, s data) {
        ZPlanRolePendantItemView g16 = g(index);
        g16.q(data, index);
        FirstFrameResult firstFrameResult = this.mFirstFrameResult;
        if (firstFrameResult != null) {
            g16.onFirstFrame(firstFrameResult);
        }
        u uVar = this.mNativeUIRsp;
        if (uVar != null) {
            g16.p(uVar, this.mNativeUIHasCacheData);
        }
        w wVar = this.mNativeUIV1Rsp;
        if (wVar != null) {
            g16.B(wVar, this.mNativeUIHasCacheData);
        }
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanRolePendantContainer this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this$0.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().engineInitFinish(z16);
        }
    }

    private final ZPlanRolePendantItemView g(int index) {
        ZPlanRolePendantItemView zPlanRolePendantItemView = this.mItemViewPool.get(Integer.valueOf(index));
        if (zPlanRolePendantItemView != null) {
            return zPlanRolePendantItemView;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new ZPlanRolePendantItemView(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZPlanRolePendantContainer this$0, FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.mFirstFrameResult = result;
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this$0.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onFirstFrame(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ZPlanRolePendantContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this$0.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().o();
        }
    }

    private final void p() {
        boolean contains;
        ArrayList arrayList = new ArrayList();
        Iterator<s> it = this.mData.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            ZPlanRolePendantItemView e16 = e(i3, it.next());
            e16.setAvatarComponentInterface(this.avatarInterface);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
            layoutParams.topMargin = i.b(4);
            if (!Intrinsics.areEqual(e16.getParent(), this.mBinding.f419033b)) {
                ViewParent parent = e16.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(e16);
                }
                this.mBinding.f419033b.addView(e16, layoutParams);
            } else {
                e16.setLayoutParams(layoutParams);
            }
            arrayList.add(e16);
            e16.z(this.mBubbleOwner);
            this.mItemViewPool.put(Integer.valueOf(i3), e16);
            i3 = i16;
        }
        int childCount = this.mBinding.f419033b.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = this.mBinding.f419033b.getChildAt(i17);
            contains = CollectionsKt___CollectionsKt.contains(arrayList, childAt);
            if (!contains) {
                this.mBinding.f419033b.removeView(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(boolean z16, ZPlanRolePendantContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.mFirstFrameResult = null;
        }
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this$0.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().serviceConnected(z16);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.o
    public void B(w rsp, boolean hasCacheData) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mNativeUIV1Rsp = rsp;
        this.mNativeUIHasCacheData = hasCacheData;
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().B(rsp, hasCacheData);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(final boolean success) {
        post(new Runnable() { // from class: bb4.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRolePendantContainer.f(ZPlanRolePendantContainer.this, success);
            }
        });
    }

    public final void h() {
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onDestroy();
        }
    }

    public final void j() {
        this.mBinding.f419033b.removeAllViews();
    }

    public void k() {
        post(new Runnable() { // from class: bb4.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRolePendantContainer.l(ZPlanRolePendantContainer.this);
            }
        });
    }

    public final void m() {
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onResume();
        }
    }

    public final void n() {
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onStop();
        }
    }

    public final void o(List<s> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData.clear();
        if (ZPlanQQMC.INSTANCE.disableZPlanAIGCEntrance()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                if (((s) obj).f427688i != 15) {
                    arrayList.add(obj);
                }
            }
            data = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : data) {
            if (((s) obj2).f427690k == 48 ? ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).isDeviceSupported() : true) {
                arrayList2.add(obj2);
            }
        }
        this.mData.addAll(arrayList2);
        p();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(final FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        post(new Runnable() { // from class: bb4.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRolePendantContainer.i(ZPlanRolePendantContainer.this, result);
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(final boolean connect) {
        post(new Runnable() { // from class: bb4.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRolePendantContainer.q(connect, this);
            }
        });
    }

    public final void setAvatarComponentInterface(com.tencent.sqshow.zootopia.recommend.characterV2.component.a avatarInterface) {
        this.avatarInterface = avatarInterface;
    }

    public final void setRoleBubbleOwner(a bubbleOwner) {
        this.mBubbleOwner = bubbleOwner;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanRolePendantContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.o
    public void onFailed(int errorCode, String errorMsg) {
        this.mNativeUIRsp = null;
        Iterator<Map.Entry<Integer, ZPlanRolePendantItemView>> it = this.mItemViewPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onFailed(errorCode, errorMsg);
        }
    }

    public /* synthetic */ ZPlanRolePendantContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanRolePendantContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        cl f16 = cl.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mData = new ArrayList<>();
        this.mItemViewPool = new HashMap<>();
        this.mItemWidth = (int) context.getResources().getDimension(R.dimen.f12547r);
        this.mItemHeight = (int) context.getResources().getDimension(R.dimen.f12537q);
    }
}
