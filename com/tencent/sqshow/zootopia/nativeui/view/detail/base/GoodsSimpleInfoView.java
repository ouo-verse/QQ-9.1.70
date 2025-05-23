package com.tencent.sqshow.zootopia.nativeui.view.detail.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsSimpleInfoView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import g94.b;
import i94.CollectInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.w;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/base/GoodsSimpleInfoView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "", "f", "Luv4/az;", "itemData", "", "showCollect", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "b", "Ln74/w;", "d", "Ln74/w;", "e", "()Ln74/w;", "setBinding", "(Ln74/w;)V", "binding", "Landroidx/lifecycle/Observer;", "Li94/a;", "Landroidx/lifecycle/Observer;", "observer", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GoodsSimpleInfoView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Observer<CollectInfo> observer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsSimpleInfoView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        f(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(w this_apply, az itemData, CollectInfo collectInfo) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        this_apply.f419458b.setVisibility(b.f401562a.i(itemData) ? 0 : 8);
    }

    private final void f(Context context) {
        this.binding = w.f(LayoutInflater.from(context), this);
    }

    public final void b(final az itemData, boolean showCollect, j channel) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        final w wVar = this.binding;
        if (wVar != null) {
            wVar.f419459c.setRadius(i.e(4), i.e(4), i.e(4), i.e(4));
            RoundCornerImageView itemIcon = wVar.f419459c;
            Intrinsics.checkNotNullExpressionValue(itemIcon, "itemIcon");
            String str = itemData.f440279f;
            Intrinsics.checkNotNullExpressionValue(str, "itemData.icon");
            CommonExKt.w(itemIcon, str, q.b(R.drawable.h4b), null, 4, null);
            if (!TextUtils.isEmpty(itemData.f440282i)) {
                wVar.f419460d.setVisibility(0);
                URLImageView leftTopLabel = wVar.f419460d;
                Intrinsics.checkNotNullExpressionValue(leftTopLabel, "leftTopLabel");
                String str2 = itemData.f440282i;
                Intrinsics.checkNotNullExpressionValue(str2, "itemData.brandLabel");
                CommonExKt.w(leftTopLabel, str2, q.b(R.drawable.h4a), null, 4, null);
            }
            if (!TextUtils.isEmpty(itemData.f440283j)) {
                wVar.f419461e.setVisibility(0);
                URLImageView rightTopLabel = wVar.f419461e;
                Intrinsics.checkNotNullExpressionValue(rightTopLabel, "rightTopLabel");
                String str3 = itemData.f440283j;
                Intrinsics.checkNotNullExpressionValue(str3, "itemData.saleLabel");
                CommonExKt.w(rightTopLabel, str3, q.b(R.drawable.h4a), null, 4, null);
            }
            if (showCollect) {
                FrameLayout frameLayout = wVar.f419458b;
                b bVar = b.f401562a;
                frameLayout.setVisibility(bVar.i(itemData) ? 0 : 8);
                if (channel == null || (lifecycleOwner = channel.getLifecycleOwner()) == null) {
                    return;
                }
                this.observer = new Observer() { // from class: fa4.m
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GoodsSimpleInfoView.d(w.this, itemData, (CollectInfo) obj);
                    }
                };
                MutableLiveData<CollectInfo> g16 = bVar.g();
                Observer<CollectInfo> observer = this.observer;
                Intrinsics.checkNotNull(observer);
                g16.observe(lifecycleOwner, observer);
            }
        }
    }

    /* renamed from: e, reason: from getter */
    public final w getBinding() {
        return this.binding;
    }

    public final void setBinding(w wVar) {
        this.binding = wVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsSimpleInfoView(Context context, AttributeSet attr) {
        super(context, attr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        f(context);
    }

    public static /* synthetic */ void c(GoodsSimpleInfoView goodsSimpleInfoView, az azVar, boolean z16, j jVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            jVar = null;
        }
        goodsSimpleInfoView.b(azVar, z16, jVar);
    }
}
