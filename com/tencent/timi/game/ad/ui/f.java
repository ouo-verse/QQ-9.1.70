package com.tencent.timi.game.ad.ui;

import af4.OperationData;
import af4.OperationItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ad.ui.OperationItemView;
import com.tencent.timi.game.ad.ui.view.BaseOperationSingleItemView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u0001:\u0001<B#\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020\u0019\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&R\"\u0010-\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010.R<\u00105\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020201`38\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/timi/game/ad/ui/f;", "Landroidx/viewpager/widget/PagerAdapter;", "", "g", "", com.tencent.luggage.wxa.c8.c.G, "k", "position", "Laf4/d;", "itemData", "Landroid/view/View;", "view", "e", "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "jumpInterceptor", "i", "Laf4/c;", "data", h.F, "getCount", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "instantiateItem", "object", "", "isViewFromObject", "destroyItem", "j", "destroy", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "I", "getPos", "()I", "f", "Z", "getMIsLandscape", "()Z", "setMIsLandscape", "(Z)V", "mIsLandscape", "Laf4/c;", "mData", "Ljava/util/HashMap;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/ad/ui/view/BaseOperationSingleItemView;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mPageViews", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/ad/ui/OperationItemView$b;", "mJumpInterceptor", "<init>", "(Landroid/content/Context;IZ)V", BdhLogUtil.LogTag.Tag_Conn, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int pos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private OperationData mData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, WeakReference<BaseOperationSingleItemView>> mPageViews;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OperationItemView.b mJumpInterceptor;

    public f(@NotNull Context context, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.pos = i3;
        this.mIsLandscape = z16;
        this.mData = new OperationData(0, null, 3, null);
        this.mPageViews = new HashMap<>();
    }

    private final void e(int position, OperationItem itemData, View view) {
        Object obj;
        gh4.e I0;
        gh4.d m06;
        int sceneId = itemData.getSceneId();
        if (sceneId != 1) {
            if (sceneId == 2 && (I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0()) != null && (m06 = I0.m0()) != null) {
                m06.a(view, "em_yes_treasure_floating");
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_guajian_location_hori", String.valueOf(position));
        hashMap.put("qqlive_guajian_location_ver", String.valueOf(this.pos));
        hashMap.put("qqlive_resource_id", String.valueOf(itemData.getIAdId()));
        boolean isRedPacket = itemData.getIsRedPacket();
        String str = "0";
        if (isRedPacket) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("qqlive_guajian_type", obj);
        if (this.mIsLandscape) {
            str = "1";
        }
        hashMap.put("qqlive_screen_orientation", str);
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, view, false, null, "em_qqlive_guajian", hashMap, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (r0 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void f(int i3, f this$0, OperationItem itemData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        if (!o.c("OperationItemPageAdapter_" + i3)) {
            OperationItemView.b bVar = this$0.mJumpInterceptor;
            if (bVar != null) {
                bVar.a(itemData);
            }
            OperationItemView.b bVar2 = this$0.mJumpInterceptor;
            if (bVar2 != null) {
                boolean z16 = false;
                if (bVar2 != null && !bVar2.b(itemData)) {
                    z16 = true;
                }
            }
            d.f376246a.b(itemData);
            OperationItemView.b bVar3 = this$0.mJumpInterceptor;
            if (bVar3 != null) {
                bVar3.c(itemData);
            }
            af4.g.f26031a.g(String.valueOf(itemData.getIAdId()), itemData.getTraceInfo(), 102);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g() {
        Collection<WeakReference<BaseOperationSingleItemView>> values = this.mPageViews.values();
        Intrinsics.checkNotNullExpressionValue(values, "mPageViews.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            BaseOperationSingleItemView baseOperationSingleItemView = (BaseOperationSingleItemView) ((WeakReference) it.next()).get();
            if (baseOperationSingleItemView != null) {
                baseOperationSingleItemView.b();
            }
        }
        this.mPageViews.clear();
    }

    private final void k(int pos) {
        BaseOperationSingleItemView baseOperationSingleItemView;
        WeakReference<BaseOperationSingleItemView> weakReference = this.mPageViews.get(Integer.valueOf(pos));
        if (weakReference != null && (baseOperationSingleItemView = weakReference.get()) != null) {
            baseOperationSingleItemView.l();
        }
    }

    public final void destroy() {
        g();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.mData.i().size();
    }

    public final void h(@NotNull OperationData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        g();
        this.mData = data;
        notifyDataSetChanged();
    }

    public final void i(@Nullable OperationItemView.b jumpInterceptor) {
        this.mJumpInterceptor = jumpInterceptor;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, final int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        final OperationItem operationItem = this.mData.i().get(position);
        BaseOperationSingleItemView a16 = cf4.b.f30784a.a(this.context, operationItem, this.mIsLandscape);
        l.a("OperationItemPageAdapter_", 1, "loading :{" + operationItem + "}");
        a16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ad.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.f(position, this, operationItem, view);
            }
        });
        container.addView(a16);
        e(position, operationItem, a16);
        this.mPageViews.put(Integer.valueOf(position), new WeakReference<>(a16));
        k(position);
        return a16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        if (view == object) {
            return true;
        }
        return false;
    }

    public final void j() {
        for (Map.Entry<Integer, WeakReference<BaseOperationSingleItemView>> entry : this.mPageViews.entrySet()) {
            int intValue = entry.getKey().intValue();
            entry.getValue();
            k(intValue);
        }
    }
}
