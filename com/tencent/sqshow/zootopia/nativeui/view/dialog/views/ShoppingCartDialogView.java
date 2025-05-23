package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartStatus;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.ShoppingCartControl;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.cp;
import uv4.az;
import uv4.bc;
import uv4.bd;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 _2\u00020\u0001:\u0001\tB/\b\u0007\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X\u0012\b\b\u0002\u0010Z\u001a\u00020\r\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0012\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0004J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u0019H\u0014J\b\u0010 \u001a\u00020\u001bH\u0014J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020\u0019H\u0014J\b\u0010%\u001a\u00020$H\u0014J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020\u0019H\u0014J\b\u0010*\u001a\u00020)H\u0014J\b\u0010,\u001a\u00020+H\u0014J\b\u0010.\u001a\u00020-H\u0014J\n\u0010/\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u00100\u001a\u00020!H\u0014J\n\u00102\u001a\u0004\u0018\u000101H\u0014J\n\u00103\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u00104\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0006H\u0002J\b\u00108\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020\u0006H\u0002J\u0016\u0010<\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020;0\u000fH\u0002J\b\u0010>\u001a\u00020=H\u0002J\u0014\u0010A\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020@0?H\u0002J\b\u0010B\u001a\u00020\u0006H\u0002R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010L\u001a\u00020G8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\u0015R\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010T\u00a8\u0006`"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ShoppingCartDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView;", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "L", "", "onDismiss", DomainData.DOMAIN_NAME, "a", "Luv4/az;", "storeItem", "M0", "", "gender", "", "Luv4/bd;", "list", "L0", "source", "F0", "I", "N0", "isVisible", "setTitleVisible", "Landroid/widget/TextView;", "A0", "Landroid/widget/ImageView;", "z0", "r0", "s0", "q0", "j0", "Landroid/widget/LinearLayout;", "D0", "C0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "v0", "Landroidx/recyclerview/widget/RecyclerView;", "t0", "B0", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "w0", "Landroid/widget/FrameLayout;", "x0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "y0", "l0", "o0", "Lcom/tencent/sqshow/zootopia/card/view/widget/CurrencyView;", "m0", "p0", "e0", "G0", "Q0", "E0", "U0", "R0", "T0", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "i0", "", "k0", "", "", "u0", "O0", "Ln74/cp;", "D", "Ln74/cp;", "binding", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/ShoppingCartControl;", "E", "Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/ShoppingCartControl;", "n0", "()Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/ShoppingCartControl;", "control", UserInfo.SEX_FEMALE, "grayColor", "G", "H", "Ljava/util/List;", "queryList", "Ld94/h;", "Ld94/h;", "mListAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "J", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ShoppingCartDialogView extends BasePanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private cp binding;

    /* renamed from: E, reason: from kotlin metadata */
    private final ShoppingCartControl control;

    /* renamed from: F, reason: from kotlin metadata */
    private final int grayColor;

    /* renamed from: G, reason: from kotlin metadata */
    private int gender;

    /* renamed from: H, reason: from kotlin metadata */
    private List<bd> queryList;

    /* renamed from: I, reason: from kotlin metadata */
    private d94.h mListAdapter;

    public /* synthetic */ ShoppingCartDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0() {
        if (this.control.getIsInMod()) {
            C0().setEnabled(true);
            y0().e();
        } else {
            b94.e O = getMChannel().O();
            if (O != null) {
                O.S2();
            }
        }
    }

    private final void G0() {
        LifecycleOwner lifecycleOwner = getMChannel().getLifecycleOwner();
        if (lifecycleOwner != null) {
            MutableLiveData<com.tencent.sqshow.zootopia.data.f> b16 = gb4.a.f401894a.b();
            final Function1<com.tencent.sqshow.zootopia.data.f, Unit> function1 = new Function1<com.tencent.sqshow.zootopia.data.f, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView$observeData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.sqshow.zootopia.data.f fVar) {
                    invoke2(fVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.sqshow.zootopia.data.f fVar) {
                    List<CartGoodsData> value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
                    if (value != null) {
                        ShoppingCartDialogView.this.i0(value);
                    }
                }
            };
            b16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ShoppingCartDialogView.H0(Function1.this, obj);
                }
            });
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            LiveData<PriceType> a16 = cVar.o().a();
            final Function1<PriceType, Unit> function12 = new Function1<PriceType, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView$observeData$1$2

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes34.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f371818a;

                    static {
                        int[] iArr = new int[PriceType.values().length];
                        try {
                            iArr[PriceType.GOAL_FIRST.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f371818a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PriceType priceType) {
                    invoke2(priceType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PriceType priceType) {
                    int i3;
                    int collectionSizeOrDefault;
                    if ((priceType == null ? -1 : a.f371818a[priceType.ordinal()]) == 1) {
                        i3 = FontSettingManager.isFontSizeLarge() ? R.string.xnb : R.string.xna;
                    } else {
                        i3 = FontSettingManager.isFontSizeLarge() ? R.string.xne : R.string.xnd;
                    }
                    ShoppingCartDialogView.this.q0().setText(i3);
                    List<CartGoodsData> value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
                    if (value != null) {
                        List<CartGoodsData> list = value;
                        boolean z16 = false;
                        for (CartGoodsData cartGoodsData : list) {
                            PriceType priceType2 = cartGoodsData.getPriceType();
                            cartGoodsData.h(CartGoodsData.INSTANCE.a(cartGoodsData.getItemData()));
                            if (priceType2 != cartGoodsData.getPriceType()) {
                                z16 = true;
                            }
                        }
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (CartGoodsData cartGoodsData2 : list) {
                            arrayList.add(cartGoodsData2.getItemData().f440275b + " == > [ " + cartGoodsData2.getItemData().f440277d + " ], isSelected: " + cartGoodsData2.getIsSelected() + " ,priceType: " + cartGoodsData2.getPriceType());
                        }
                        QLog.d("ShoppingCart_", 1, "goodsData : " + arrayList);
                        if (z16) {
                            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(value);
                        }
                    }
                    List<CartGoodsData> value2 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.h().getValue();
                    if (value2 != null) {
                        ShoppingCartDialogView.this.i0(value2);
                    }
                }
            };
            a16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ShoppingCartDialogView.I0(Function1.this, obj);
                }
            });
            LiveData<List<CartGoodsData>> h16 = cVar.h();
            final Function1<List<? extends CartGoodsData>, Unit> function13 = new Function1<List<? extends CartGoodsData>, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView$observeData$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends CartGoodsData> list) {
                    invoke2((List<CartGoodsData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<CartGoodsData> it) {
                    d94.h hVar;
                    int i3;
                    hVar = ShoppingCartDialogView.this.mListAdapter;
                    if (hVar != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        i3 = ShoppingCartDialogView.this.gender;
                        hVar.p0(it, i3);
                    }
                    ShoppingCartDialogView shoppingCartDialogView = ShoppingCartDialogView.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    shoppingCartDialogView.i0(it);
                }
            };
            h16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ShoppingCartDialogView.J0(Function1.this, obj);
                }
            });
            LiveData<CartStatus> a17 = cVar.i().a();
            final Function1<CartStatus, Unit> function14 = new Function1<CartStatus, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView$observeData$1$4

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes34.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f371819a;

                    static {
                        int[] iArr = new int[CartStatus.values().length];
                        try {
                            iArr[CartStatus.NORMAL.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[CartStatus.SHOW_SKELETON_LOADING.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[CartStatus.SHOW_LOADING.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[CartStatus.HIDE_LOADING.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[CartStatus.LOADING_FAIL.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[CartStatus.SHOW_LOADING_AND_DISMISS.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[CartStatus.HIDE_LOADING_AND_DISMISS.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        try {
                            iArr[CartStatus.DISMISS.ordinal()] = 8;
                        } catch (NoSuchFieldError unused8) {
                        }
                        f371819a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CartStatus cartStatus) {
                    invoke2(cartStatus);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CartStatus cartStatus) {
                    QLog.d("ShoppingCart_", 1, " update status : " + cartStatus);
                    switch (cartStatus == null ? -1 : a.f371819a[cartStatus.ordinal()]) {
                        case 1:
                            ShoppingCartDialogView.this.T0();
                            return;
                        case 2:
                            ShoppingCartDialogView.this.U0();
                            return;
                        case 3:
                            ShoppingCartDialogView.this.Q0();
                            return;
                        case 4:
                            ShoppingCartDialogView.this.E0();
                            return;
                        case 5:
                            ShoppingCartDialogView.this.R0();
                            return;
                        case 6:
                            ShoppingCartDialogView.this.Q0();
                            ShoppingCartDialogView.this.o();
                            return;
                        case 7:
                            ShoppingCartDialogView.this.E0();
                            ShoppingCartDialogView.this.o();
                            return;
                        case 8:
                            ShoppingCartDialogView.this.o();
                            return;
                        default:
                            return;
                    }
                }
            };
            a17.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ShoppingCartDialogView.K0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O0() {
        final CurrencyView m06 = m0();
        if (m06 != null) {
            getMChannel().getReporter().getMReporter().g(m06, "em_zplan_recharge", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            m06.setCoinListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShoppingCartDialogView.P0(ShoppingCartDialogView.this, m06, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(ShoppingCartDialogView this$0, CurrencyView coinView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coinView, "$coinView");
        ZplanViewReportHelper.f(this$0.getMChannel().getReporter().getMReporter(), coinView, "em_zplan_recharge", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        if (this.control.getIsInMod()) {
            y0().h(500L);
            C0().setEnabled(false);
        } else {
            b94.e O = getMChannel().O();
            if (O != null) {
                O.P1(500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0() {
        E0();
        w0().d();
        w0().setVisibility(8);
        AvatarPanelErrorView v06 = v0();
        String string = getContext().getString(R.string.xrf);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ui_shop_empty_fail_title)");
        v06.f(string);
        AvatarPanelErrorView v07 = v0();
        String string2 = getContext().getString(R.string.xre);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026eui_shop_empty_fail_desc)");
        v07.b(string2);
        AvatarPanelErrorView v08 = v0();
        String string3 = getContext().getString(R.string.xrd);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026i_shop_empty_fail_button)");
        v08.setRetryButton(string3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShoppingCartDialogView.S0(ShoppingCartDialogView.this, view);
            }
        });
        v0().setVisibility(0);
        D0().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(ShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.control.C(this$0.gender, this$0.queryList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0() {
        E0();
        w0().d();
        x0().setVisibility(8);
        t0().setVisibility(0);
        C0().setVisibility(0);
        o0().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0() {
        E0();
        x0().setVisibility(0);
        w0().c();
        w0().setVisibility(0);
        v0().setVisibility(8);
        C0().setVisibility(8);
        D0().setVisibility(8);
        t0().setVisibility(4);
        o0().setVisibility(4);
    }

    private final void e0() {
        ImageView l06 = l0();
        if (l06 != null) {
            aa.d(l06, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShoppingCartDialogView.f0(ShoppingCartDialogView.this, view);
                }
            });
        }
        D0().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShoppingCartDialogView.g0(ShoppingCartDialogView.this, view);
            }
        });
        aa.d(C0(), new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShoppingCartDialogView.h0(ShoppingCartDialogView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        ImageView l06 = this$0.l0();
        if (l06 != null) {
            ZplanViewReportHelper.f(this$0.getMChannel().getReporter().getMReporter(), l06, "em_zplan_shopping_bag_close", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.control.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        if (Intrinsics.areEqual(((TextView) view).getText().toString(), this$0.getContext().getString(R.string.xqr))) {
            this$0.control.A(Source.BuyButton.getValue());
        } else {
            this$0.control.w();
        }
        this$0.getMChannel().getReporter().getMReporter().e(view, this$0.k0(), this$0.u0());
    }

    private final String k0() {
        String obj = C0().getText().toString();
        if (Intrinsics.areEqual(obj, getContext().getString(R.string.xm8)) ? true : Intrinsics.areEqual(obj, getContext().getString(R.string.xqr))) {
            return "em_zplan_cart_purchase";
        }
        return "em_zplan_avatar_save";
    }

    private final Map<String, Object> u0() {
        String obj = C0().getText().toString();
        if (Intrinsics.areEqual(obj, getContext().getString(R.string.xm8))) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.b(this.gender, getMChannel().getZplanFaceId()));
            linkedHashMap.put("zplan_btn_type", 1);
            return linkedHashMap;
        }
        if (Intrinsics.areEqual(obj, getContext().getString(R.string.xqr))) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.b(this.gender, getMChannel().getZplanFaceId()));
            linkedHashMap2.put("zplan_btn_type", 2);
            return linkedHashMap2;
        }
        return com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.d(getMChannel().getZplanFaceId());
    }

    protected TextView A0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        TextView textView = cpVar.f419067t;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.silverText");
        return textView;
    }

    protected TextView B0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        TextView textView = cpVar.f419068u;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.totalNumsText");
        return textView;
    }

    protected TextView C0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        TextView textView = cpVar.f419050c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.buyBtn");
        return textView;
    }

    protected LinearLayout D0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        LinearLayout linearLayout = cpVar.f419053f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.currencyStrategyContainer");
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F0(int source) {
        this.mListAdapter = new d94.h(source, getMChannel());
        RecyclerView t06 = t0();
        t06.setLayoutManager(new LinearLayoutManager(t06.getContext(), 1, false));
        t06.setAdapter(this.mListAdapter);
        TextView A0 = A0();
        t74.m mVar = t74.m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        A0.setTypeface(mVar.b(assets));
        TextView r06 = r0();
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        r06.setTypeface(mVar.b(assets2));
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.ilq, R.color.qui_common_icon_secondary, 1000);
        ImageView l06 = l0();
        if (l06 != null) {
            l06.setImageDrawable(o16);
        }
        ImageView l07 = l0();
        if (l07 != null) {
            l07.setColorFilter(this.grayColor);
        }
        Drawable o17 = ie0.a.f().o(getContext(), R.drawable.ild, R.color.qui_common_icon_secondary, 1000);
        ImageView p06 = p0();
        if (p06 != null) {
            p06.setImageDrawable(o17);
        }
        G0();
        e0();
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.o().e(PriceType.SILVER_FIRST);
        O0();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean L() {
        return true;
    }

    public final void L0(int gender, List<bd> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.gender = gender;
        this.queryList = list;
        this.control.C(gender, list);
    }

    public final void M0(az storeItem) {
        int index = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
        this.gender = index;
        this.control.i(index, storeItem);
    }

    public void N0() {
        LifecycleOwner lifecycleOwner = getMChannel().getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        cVar.o().a().removeObservers(lifecycleOwner);
        cVar.h().removeObservers(lifecycleOwner);
        cVar.i().a().removeObservers(lifecycleOwner);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public boolean a() {
        if (y0().getVisibility() != 0) {
            return false;
        }
        QLog.d("ShoppingCart_", 1, " handle Back Event ");
        return true;
    }

    protected ImageView j0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        ImageView imageView = cpVar.f419049b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.addImage");
        return imageView;
    }

    protected ImageView l0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        return cpVar.f419054g;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        cp g16 = cp.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
        F0(0);
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        ConstraintLayout mContainer = cpVar.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        return mContainer;
    }

    protected CurrencyView m0() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public void n() {
        N0();
        super.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n0, reason: from getter */
    public final ShoppingCartControl getControl() {
        return this.control;
    }

    protected LinearLayout o0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        LinearLayout linearLayout = cpVar.f419052e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.currencyContainer");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void onDismiss() {
        N0();
        this.control.D();
        ZplanViewReportHelper.j(getMChannel().getReporter().getMReporter(), C0(), k0(), u0(), false, null, 24, null);
        QLog.d("ShoppingCart_", 1, "dialog dismiss");
        super.onDismiss();
    }

    protected ImageView p0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        return cpVar.f419055h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView q0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        TextView textView = cpVar.f419056i;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.dialogCurrencyStrategy");
        return textView;
    }

    protected TextView r0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        TextView textView = cpVar.f419061n;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.goalText");
        return textView;
    }

    protected ImageView s0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        ImageView imageView = cpVar.f419060m;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.goalIcon");
        return imageView;
    }

    public final void setTitleVisible(boolean isVisible) {
        ImageView l06;
        CurrencyView m06 = m0();
        if (m06 != null) {
            m06.setVisibility(isVisible ? 0 : 8);
        }
        ImageView l07 = l0();
        if (l07 != null) {
            l07.setVisibility(isVisible ? 0 : 8);
        }
        if (!isVisible || (l06 = l0()) == null) {
            return;
        }
        getMChannel().getReporter().getMReporter().g(l06, "em_zplan_shopping_bag_close", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    protected RecyclerView t0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        RecyclerView recyclerView = cpVar.f419062o;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.goodsList");
        return recyclerView;
    }

    protected AvatarPanelErrorView v0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        AvatarPanelErrorView avatarPanelErrorView = cpVar.f419063p;
        Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "binding.loadErrorView");
        return avatarPanelErrorView;
    }

    protected ShimmerLinearLayout w0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        ShimmerLinearLayout shimmerLinearLayout = cpVar.f419064q.f419188b;
        Intrinsics.checkNotNullExpressionValue(shimmerLinearLayout, "binding.loadingShimmerView.avatarCartWaitingView");
        return shimmerLinearLayout;
    }

    protected FrameLayout x0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        FrameLayout frameLayout = cpVar.f419065r;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingStatusView");
        return frameLayout;
    }

    protected AvatarGlobalLoadingView y0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        AvatarGlobalLoadingView avatarGlobalLoadingView = cpVar.f419059l;
        Intrinsics.checkNotNullExpressionValue(avatarGlobalLoadingView, "binding.globalLoadingView");
        return avatarGlobalLoadingView;
    }

    protected ImageView z0() {
        cp cpVar = this.binding;
        if (cpVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cpVar = null;
        }
        ImageView imageView = cpVar.f419066s;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.silverIcon");
        return imageView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShoppingCartDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        List<bd> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.control = new ShoppingCartControl(channel, context);
        this.grayColor = ContextCompat.getColor(context, R.color.f8356q);
        this.gender = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.queryList = emptyList;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected void I() {
        setTitleVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0190 A[LOOP:2: B:28:0x0160->B:40:0x0190, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0194 A[EDGE_INSN: B:41:0x0194->B:42:0x0194 BREAK  A[LOOP:2: B:28:0x0160->B:40:0x0190], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(List<CartGoodsData> list) {
        int collectionSizeOrDefault;
        boolean z16;
        List<CartGoodsData> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (CartGoodsData cartGoodsData : list2) {
            arrayList.add("[" + cartGoodsData.getItemData().f440275b + "]: " + cartGoodsData.getItemData().f440277d + ", isSelected: " + cartGoodsData.getIsSelected() + " ,priceType: " + cartGoodsData.getPriceType() + " \n");
        }
        QLog.d("ShoppingCart_", 1, "bindCoinStats: " + arrayList);
        Triple<Integer, Integer, Integer> k3 = this.control.k(list);
        int intValue = k3.getFirst().intValue();
        int intValue2 = k3.getSecond().intValue();
        int intValue3 = k3.getThird().intValue();
        if (intValue > 0) {
            s0().setVisibility(0);
            r0().setVisibility(0);
            j0().setVisibility(0);
            j0().setColorFilter(this.grayColor);
            r0().setText(com.tencent.sqshow.zootopia.utils.e.f373267a.a(intValue));
        } else {
            s0().setVisibility(8);
            r0().setVisibility(8);
            j0().setVisibility(8);
        }
        if (intValue2 > 0) {
            z0().setVisibility(0);
            A0().setVisibility(0);
            A0().setText(com.tencent.sqshow.zootopia.utils.e.f373267a.a(intValue2));
        } else {
            z0().setVisibility(8);
            A0().setVisibility(8);
            j0().setVisibility(8);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list2) {
            CartGoodsData cartGoodsData2 = (CartGoodsData) obj;
            if (cartGoodsData2.getItemData().f440295v > 0 || com.tencent.sqshow.zootopia.nativeui.data.cart.b.d(cartGoodsData2.getItemData(), this.gender)) {
                arrayList2.add(obj);
            }
        }
        Iterator<CartGoodsData> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            CartGoodsData next = it.next();
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.c(next.getItemData(), this.gender)) {
                bc bcVar = next.getItemData().f440287n;
                if (bcVar != null && bcVar.f440312a == 3) {
                    z16 = true;
                    if (!z16) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        D0().setVisibility(i3 >= 0 ? 0 : 8);
        B0().setText(getContext().getString(R.string.xmb, Integer.valueOf(intValue3)));
        int i16 = R.string.xm8;
        if (intValue3 <= 0) {
            if (arrayList2.size() == list.size()) {
                C0().setText(R.string.xt8);
                C0().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ha_));
            } else {
                C0().setText(R.string.xm8);
                C0().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.hae));
            }
        } else {
            PriceType value = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.o().a().getValue();
            if (value == null) {
                value = PriceType.SILVER_FIRST;
            }
            Intrinsics.checkNotNullExpressionValue(value, "AvatarDataCenter.getCurr\u2026?: PriceType.SILVER_FIRST");
            gb4.a aVar = gb4.a.f401894a;
            com.tencent.sqshow.zootopia.data.f value2 = aVar.b().getValue();
            int silverCoin = value2 != null ? value2.getSilverCoin() : 0;
            com.tencent.sqshow.zootopia.data.f value3 = aVar.b().getValue();
            int goldCoin = value3 != null ? value3.getGoldCoin() : 0;
            if (value == PriceType.SILVER_FIRST && goldCoin >= intValue && silverCoin < intValue2) {
                i16 = R.string.xqr;
            }
            QLog.i("ShoppingCart_", 1, "priceType: " + value + ", currencySilverData: " + silverCoin + ", totalSilver: " + intValue2);
            C0().setText(i16);
            C0().setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ha_));
        }
        getMChannel().getReporter().getMReporter().g(C0(), k0(), (r16 & 4) != 0 ? null : u0(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }
}
