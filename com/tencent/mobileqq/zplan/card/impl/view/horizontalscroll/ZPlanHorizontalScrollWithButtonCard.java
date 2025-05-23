package com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m84.ViewAdjustObject;
import oa4.a;
import pu4.g;
import pv4.p;
import pv4.s;
import t74.m;
import t74.u;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0002<=B/\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00108\u001a\u00020\u0002\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\rR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\rR\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\rR\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\rR\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\rR\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010\rR\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\rR\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\r\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithButtonCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard;", "", "L", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "", "J", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "I", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "W", "itemWidth", "a0", "itemHeight", "b0", "mediaHeight", "c0", "bottomRightSize", "d0", "bottomRightMarginRight", "e0", "bottomRightMarginBottom", "f0", "titleTxtSizeDp", "g0", "titleTxtMarginBottom", "h0", "descContainerMarginBottom", "i0", "descContainerMarginLeft", "j0", "descIconWidth", "k0", "descIconHeight", "l0", "descIconMarginRight", "m0", "descTxtSizeDp", "n0", "itemMargin", "o0", NodeProps.MARGIN_LEFT, "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "p0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHorizontalScrollWithButtonCard extends ZPlanBaseHorizontalScrollCard {

    /* renamed from: W, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int mediaHeight;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final int bottomRightSize;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final int bottomRightMarginRight;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final int bottomRightMarginBottom;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final int titleTxtSizeDp;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final int titleTxtMarginBottom;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final int descContainerMarginBottom;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final int descContainerMarginLeft;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final int descIconWidth;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final int descIconHeight;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final int descIconMarginRight;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final int descTxtSizeDp;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final int itemMargin;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final int marginLeft;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010=\u001a\u00020\u0004\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00101\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R$\u00105\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u0017\u00109\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b7\u00108R\u001a\u0010<\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b:\u0010'\u001a\u0004\b;\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithButtonCard$b;", "Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanBaseHorizontalScrollCard$a;", "", "t", "Landroid/view/View;", "itemRootView", "p", "", "itemPos", "Lpv4/s;", "itemData", "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "l", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "getContentContainer", "()Landroid/view/ViewGroup;", "setContentContainer", "(Landroid/view/ViewGroup;)V", "contentContainer", UserInfo.SEX_FEMALE, "getDescContainer", "setDescContainer", "descContainer", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getTitleTxt", "()Landroid/widget/TextView;", "setTitleTxt", "(Landroid/widget/TextView;)V", "titleTxt", "H", "getDescTxt", "setDescTxt", "descTxt", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "I", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "getDescIconImg", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setDescIconImg", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "descIconImg", "J", "getMediaView", "setMediaView", "mediaView", "K", "getBottomRightTagImg", "setBottomRightTagImg", "bottomRightTagImg", "L", "getDefaultTitleTxtColor", "()I", "defaultTitleTxtColor", "M", "getDefaultDescTxtColor", "defaultDescTxtColor", "view", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithButtonCard;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b extends ZPlanBaseHorizontalScrollCard.a {

        /* renamed from: E, reason: from kotlin metadata */
        private ViewGroup contentContainer;

        /* renamed from: F, reason: from kotlin metadata */
        private ViewGroup descContainer;

        /* renamed from: G, reason: from kotlin metadata */
        private TextView titleTxt;

        /* renamed from: H, reason: from kotlin metadata */
        private TextView descTxt;

        /* renamed from: I, reason: from kotlin metadata */
        private ZPlanMediaView descIconImg;

        /* renamed from: J, reason: from kotlin metadata */
        private ZPlanMediaView mediaView;

        /* renamed from: K, reason: from kotlin metadata */
        private ZPlanMediaView bottomRightTagImg;

        /* renamed from: L, reason: from kotlin metadata */
        private final int defaultTitleTxtColor;

        /* renamed from: M, reason: from kotlin metadata */
        private final int defaultDescTxtColor;
        final /* synthetic */ ZPlanHorizontalScrollWithButtonCard N;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ZPlanHorizontalScrollWithButtonCard zPlanHorizontalScrollWithButtonCard, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.N = zPlanHorizontalScrollWithButtonCard;
            this.defaultTitleTxtColor = Color.parseColor("#868686");
            this.defaultDescTxtColor = -1;
        }

        private final void t() {
            u.Companion companion = u.INSTANCE;
            Context context = this.N.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            float c16 = u.Companion.e(companion, context, false, 2, null) ? ((int) (((companion.c(this.N.getContext()) - this.N.marginLeft) - (this.N.itemMargin * 3)) / (3 + 0.4f))) / this.N.itemWidth : 1.0f;
            ViewGroup viewGroup = this.contentContainer;
            if (viewGroup != null) {
                m84.b.a(viewGroup, new ViewAdjustObject(viewGroup, c16, this.N.itemWidth, this.N.itemHeight, null, false, 48, null));
            }
            ZPlanMediaView zPlanMediaView = this.mediaView;
            if (zPlanMediaView != null) {
                m84.b.a(zPlanMediaView, new ViewAdjustObject(zPlanMediaView, c16, -1, this.N.mediaHeight, null, false, 48, null));
            }
            ZPlanMediaView zPlanMediaView2 = this.bottomRightTagImg;
            if (zPlanMediaView2 != null) {
                m84.b.a(zPlanMediaView2, new ViewAdjustObject(zPlanMediaView2, c16, this.N.bottomRightSize, this.N.bottomRightSize, new Rect(0, 0, this.N.bottomRightMarginRight, this.N.bottomRightMarginBottom), true));
            }
            TextView textView = this.titleTxt;
            if (textView != null) {
                m84.b.e(textView, c16, this.N.titleTxtSizeDp, new Rect(0, 0, 0, this.N.titleTxtMarginBottom), false, 8, null);
            }
            ViewGroup viewGroup2 = this.descContainer;
            if (viewGroup2 != null) {
                m84.b.a(viewGroup2, new ViewAdjustObject(viewGroup2, c16, -1, -2, new Rect(this.N.descContainerMarginLeft, 0, 0, this.N.descContainerMarginBottom), false, 32, null));
            }
            ZPlanMediaView zPlanMediaView3 = this.descIconImg;
            if (zPlanMediaView3 != null) {
                m84.b.a(zPlanMediaView3, new ViewAdjustObject(zPlanMediaView3, c16, this.N.descIconWidth, this.N.descIconHeight, new Rect(0, 0, this.N.descIconMarginRight, 0), false, 32, null));
            }
            TextView textView2 = this.descTxt;
            if (textView2 != null) {
                m84.b.e(textView2, c16, this.N.descTxtSizeDp, null, false, 12, null);
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void l(int itemPos, s itemData, ZootopiaCardData parentCardData) {
            g gVar;
            t();
            if (itemData != null) {
                ZPlanMediaView zPlanMediaView = this.mediaView;
                if (zPlanMediaView != null) {
                    g gVar2 = itemData.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar2, "itemData.material");
                    zPlanMediaView.e(gVar2);
                }
                TextView textView = this.titleTxt;
                if (textView != null) {
                    l84.b.a(textView, itemData.f427683d, this.defaultTitleTxtColor);
                }
                TextView textView2 = this.descTxt;
                if (textView2 != null) {
                    l84.b.a(textView2, itemData.f427680a, this.defaultDescTxtColor);
                }
                pv4.u uVar = itemData.f427680a;
                if (TextUtils.isEmpty((uVar == null || (gVar = uVar.f427705d) == null) ? null : gVar.f427434a)) {
                    ZPlanMediaView zPlanMediaView2 = this.descIconImg;
                    if (zPlanMediaView2 != null) {
                        zPlanMediaView2.setVisibility(8);
                    }
                } else {
                    ZPlanMediaView zPlanMediaView3 = this.descIconImg;
                    if (zPlanMediaView3 != null) {
                        zPlanMediaView3.setVisibility(0);
                    }
                    ZPlanMediaView zPlanMediaView4 = this.descIconImg;
                    if (zPlanMediaView4 != null) {
                        g gVar3 = itemData.f427680a.f427705d;
                        Intrinsics.checkNotNullExpressionValue(gVar3, "itemData.desc.material");
                        zPlanMediaView4.e(gVar3);
                    }
                }
                ZPlanMediaView zPlanMediaView5 = this.bottomRightTagImg;
                if (zPlanMediaView5 != null) {
                    zPlanMediaView5.setVisibility(8);
                }
                p[] pVarArr = itemData.f427685f;
                if (pVarArr != null) {
                    for (p pVar : pVarArr) {
                        if (pVar.f427651a != null && pVar.f427652b == 3) {
                            ZPlanMediaView zPlanMediaView6 = this.bottomRightTagImg;
                            if (zPlanMediaView6 != null) {
                                zPlanMediaView6.setVisibility(0);
                            }
                            ZPlanMediaView zPlanMediaView7 = this.bottomRightTagImg;
                            if (zPlanMediaView7 != null) {
                                g gVar4 = pVar.f427651a;
                                Intrinsics.checkNotNullExpressionValue(gVar4, "label.material");
                                zPlanMediaView7.e(gVar4);
                            }
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard.a
        public void p(View itemRootView) {
            Intrinsics.checkNotNullParameter(itemRootView, "itemRootView");
            this.contentContainer = (ViewGroup) this.itemView.findViewById(R.id.pm8);
            this.descContainer = (ViewGroup) this.itemView.findViewById(R.id.f163416q05);
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) this.itemView.findViewById(R.id.q8i);
            this.mediaView = zPlanMediaView;
            if (zPlanMediaView != null) {
                zPlanMediaView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            ZPlanMediaView zPlanMediaView2 = this.mediaView;
            if (zPlanMediaView2 != null) {
                zPlanMediaView2.setRadius(4);
            }
            ZPlanMediaView zPlanMediaView3 = (ZPlanMediaView) this.itemView.findViewById(R.id.q3j);
            this.bottomRightTagImg = zPlanMediaView3;
            if (zPlanMediaView3 != null) {
                zPlanMediaView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.titleTxt = (TextView) this.itemView.findViewById(R.id.q07);
            this.descTxt = (TextView) this.itemView.findViewById(R.id.f163415q04);
            this.descIconImg = (ZPlanMediaView) this.itemView.findViewById(R.id.q06);
            m mVar = m.f435564a;
            AssetManager assets = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            Typeface f16 = mVar.f(assets);
            TextView textView = this.titleTxt;
            if (textView != null) {
                textView.setTypeface(f16);
            }
            TextView textView2 = this.descTxt;
            if (textView2 == null) {
                return;
            }
            textView2.setTypeface(f16);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/horizontalscroll/ZPlanHorizontalScrollWithButtonCard$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = ZPlanHorizontalScrollWithButtonCard.this.itemMargin;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanHorizontalScrollWithButtonCard(Context context, LifecycleOwner owner, a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.itemWidth = i.b(97);
        this.itemHeight = i.b(146);
        this.mediaHeight = i.b(130);
        this.bottomRightSize = i.b(16);
        this.bottomRightMarginRight = i.b(4);
        this.bottomRightMarginBottom = i.b(19);
        this.titleTxtSizeDp = 11;
        this.descContainerMarginBottom = i.b(20);
        this.descContainerMarginLeft = i.b(3);
        this.descIconWidth = i.b(10);
        this.descIconHeight = i.b(12);
        this.descIconMarginRight = i.b(3);
        this.descTxtSizeDp = 11;
        this.itemMargin = i.b(10);
        this.marginLeft = getResources().getDimensionPixelSize(R.dimen.f12046e);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public ZPlanBaseHorizontalScrollCard.a I(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new b(this, view);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public void J(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        recyclerView.addItemDecoration(new c());
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanBaseHorizontalScrollCard
    public int L() {
        return R.layout.f167448dd2;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanHorizontalScrollWithButtonCard";
    }
}
