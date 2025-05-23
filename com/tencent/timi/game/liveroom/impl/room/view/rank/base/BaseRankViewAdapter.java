package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.view.rank.OnlineRankView;
import com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView;
import d55.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0001CB\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!J\u0018\u0010'\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0004R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00103R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00104R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/BaseRankViewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/View;", "view", "", "g", "Ld55/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "i", "j", "Landroid/view/ViewGroup;", tl.h.F, DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/c;", "baseRankViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getCount", "", "object", "", "isViewFromObject", ParseCommon.CONTAINER, "position", "instantiateItem", "destroyItem", "onPageSelected", "o", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "openGiftPanelListener", "p", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$c;", "selfRankViewClickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ld55/j;", "data", "anchor", "r", "k", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;", "rankWebView", "f", "Landroid/app/Activity;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/c;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$c;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/OnlineRankView;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "l", "()Lcom/tencent/timi/game/liveroom/impl/room/view/rank/OnlineRankView;", "onlineRankView", "", "D", "Ljava/util/Map;", "dataViewMap", "<init>", "(Landroid/content/Context;Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;)V", "E", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class BaseRankViewAdapter extends PagerAdapter {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineRankView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Map<d55.h, View> dataViewMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RankWebView rankWebView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c baseRankViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelfRankInfoView.b openGiftPanelListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelfRankInfoView.c selfRankViewClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/BaseRankViewAdapter$a;", "", "", "a", "DEF_ONLINE_RANK_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.rank.base.BaseRankViewAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String a() {
            return ht3.a.d("native_rank_list_header_text_title", "\u89c2\u4f17");
        }

        Companion() {
        }
    }

    public BaseRankViewAdapter(@NotNull Context context, @NotNull RankWebView rankWebView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rankWebView, "rankWebView");
        this.context = context;
        this.rankWebView = rankWebView;
        lazy = LazyKt__LazyJVMKt.lazy(new BaseRankViewAdapter$onlineRankView$2(this));
        this.onlineRankView = lazy;
        this.dataViewMap = new LinkedHashMap();
    }

    private final void g(View view) {
        j jVar;
        boolean z16;
        if (view instanceof OnlineRankView) {
            SelfRankInfoView.b bVar = this.openGiftPanelListener;
            if (bVar != null) {
                p(bVar);
            }
            c cVar = this.baseRankViewModel;
            if (cVar != null) {
                jVar = cVar.e();
            } else {
                jVar = null;
            }
            c cVar2 = this.baseRankViewModel;
            if (cVar2 != null) {
                z16 = cVar2.getIsAnchor();
            } else {
                z16 = false;
            }
            r(jVar, z16);
        }
    }

    private final void h(ViewGroup view, d55.h item) {
        QLog.i("BaseRankViewAdapter", 1, "changeTab: item.name:" + item.f393081b + " item.type" + item.f393080a);
        ViewParent parent = this.rankWebView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.rankWebView);
        }
        view.addView(this.rankWebView);
        c cVar = this.baseRankViewModel;
        if (cVar != null) {
            RankWebView rankWebView = this.rankWebView;
            String str = item.f393081b;
            Intrinsics.checkNotNullExpressionValue(str, "item.rankName");
            cVar.r(rankWebView, str);
        }
    }

    private final View i(d55.h item) {
        if (Intrinsics.areEqual(item.f393081b, INSTANCE.a())) {
            return l();
        }
        return j();
    }

    private final View j() {
        return new FrameLayout(this.context);
    }

    private final OnlineRankView l() {
        return (OnlineRankView) this.onlineRankView.getValue();
    }

    private final void n() {
        j jVar;
        boolean z16;
        c cVar = this.baseRankViewModel;
        if (cVar != null) {
            jVar = cVar.e();
        } else {
            jVar = null;
        }
        c cVar2 = this.baseRankViewModel;
        if (cVar2 != null) {
            z16 = cVar2.getIsAnchor();
        } else {
            z16 = false;
        }
        r(jVar, z16);
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
        d55.h[] k3;
        c cVar = this.baseRankViewModel;
        if (cVar != null && (k3 = cVar.k()) != null) {
            return k3.length;
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        d55.h[] k3;
        Intrinsics.checkNotNullParameter(container, "container");
        c cVar = this.baseRankViewModel;
        if (cVar != null && (k3 = cVar.k()) != null) {
            d55.h hVar = k3[position];
            View view = this.dataViewMap.get(hVar);
            if (view == null) {
                view = i(hVar);
                this.dataViewMap.put(hVar, view);
            }
            g(view);
            container.addView(view);
            return view;
        }
        return new View(this.context);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }

    public final void k() {
        for (Map.Entry<d55.h, View> entry : this.dataViewMap.entrySet()) {
            if (entry.getValue() instanceof d) {
                KeyEvent.Callback value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.view.rank.base.IRankItemView");
                ((d) value).onDismiss();
            }
        }
    }

    public final void m(@NotNull Activity activity, @NotNull c baseRankViewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(baseRankViewModel, "baseRankViewModel");
        this.activity = activity;
        this.baseRankViewModel = baseRankViewModel;
        notifyDataSetChanged();
    }

    public final void o() {
        n();
        notifyDataSetChanged();
    }

    public final void onPageSelected(int position) {
        d55.h[] k3;
        boolean z16;
        d55.h hVar;
        c cVar = this.baseRankViewModel;
        if (cVar != null && (k3 = cVar.k()) != null) {
            if (k3.length > position) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                k3 = null;
            }
            if (k3 != null && (hVar = k3[position]) != null) {
                View view = this.dataViewMap.get(hVar);
                if (!(view instanceof OnlineRankView) && (view instanceof ViewGroup)) {
                    h((ViewGroup) view, hVar);
                }
            }
        }
    }

    public final void p(@Nullable SelfRankInfoView.b openGiftPanelListener) {
        this.openGiftPanelListener = openGiftPanelListener;
        l().setOpenGiftPanelListener(openGiftPanelListener);
    }

    public final void q(@Nullable SelfRankInfoView.c selfRankViewClickListener) {
        this.selfRankViewClickListener = selfRankViewClickListener;
        l().setSelfRankViewClickListener(selfRankViewClickListener);
    }

    public final void r(@Nullable j data, boolean anchor) {
        if (data == null) {
            return;
        }
        l().d(data, anchor);
    }
}
