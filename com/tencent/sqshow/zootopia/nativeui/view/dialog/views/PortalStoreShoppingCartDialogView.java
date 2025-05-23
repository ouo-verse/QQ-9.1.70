package com.tencent.sqshow.zootopia.nativeui.view.dialog.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewOrientationHelper;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.cd;
import n74.cp;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010\"\u001a\u00020!H\u0014J\n\u0010#\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010$\u001a\u00020\u0015H\u0014J\n\u0010&\u001a\u0004\u0018\u00010%H\u0014J\n\u0010'\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020+H\u0002R\u0016\u0010/\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006?"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/PortalStoreShoppingCartDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/ShoppingCartDialogView;", "", "orientation", "", "e", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", UserInfo.SEX_FEMALE, "r", "t", HippyTKDListViewAdapter.X, "Landroid/widget/TextView;", "A0", "Landroid/widget/ImageView;", "z0", "r0", "s0", "q0", "j0", "Landroid/widget/LinearLayout;", "D0", "C0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "v0", "Landroidx/recyclerview/widget/RecyclerView;", "t0", "B0", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "w0", "Landroid/widget/FrameLayout;", "x0", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "y0", "l0", "o0", "Lcom/tencent/sqshow/zootopia/card/view/widget/CurrencyView;", "m0", "p0", "Z0", "Ln74/cd;", "W0", "Ln74/cp;", "Y0", "K", "Ln74/cd;", "landscapeBinding", "L", "Ln74/cp;", "portraitBinding", "M", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class PortalStoreShoppingCartDialogView extends ShoppingCartDialogView {

    /* renamed from: K, reason: from kotlin metadata */
    private cd landscapeBinding;

    /* renamed from: L, reason: from kotlin metadata */
    private cp portraitBinding;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isLandscape;

    public /* synthetic */ PortalStoreShoppingCartDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar);
    }

    private final cd W0() {
        cd g16 = cd.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.landscapeBinding = g16;
        F0(1);
        cd cdVar = this.landscapeBinding;
        if (cdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            cdVar = null;
        }
        cdVar.f418996s.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.views.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreShoppingCartDialogView.X0(PortalStoreShoppingCartDialogView.this, view);
            }
        });
        cd cdVar2 = this.landscapeBinding;
        if (cdVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            cdVar2 = null;
        }
        ViewGroup.LayoutParams layoutParams = cdVar2.f418981d.getLayoutParams();
        layoutParams.width = PortalStoreViewOrientationHelper.INSTANCE.b();
        cd cdVar3 = this.landscapeBinding;
        if (cdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            cdVar3 = null;
        }
        cdVar3.f418981d.setLayoutParams(layoutParams);
        cd cdVar4 = this.landscapeBinding;
        if (cdVar4 != null) {
            return cdVar4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(PortalStoreShoppingCartDialogView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    private final cp Y0() {
        cp g16 = cp.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.portraitBinding = g16;
        F0(0);
        cp cpVar = this.portraitBinding;
        if (cpVar != null) {
            return cpVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
        return null;
    }

    private final boolean Z0() {
        return getMChannel().getOrientationMode() == OrientationMode.PORTRAIT;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView A0() {
        TextView textView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            textView = cdVar.f418998u;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            textView = cpVar.f419067t;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "if (isLandscape) landsca\u2026traitBinding.silverText }");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView B0() {
        TextView textView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            textView = cdVar.f418999v;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            textView = cpVar.f419068u;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "if (isLandscape) landsca\u2026itBinding.totalNumsText }");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView C0() {
        TextView textView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            textView = cdVar.f418980c;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            textView = cpVar.f419050c;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "if (isLandscape) landsca\u2026 portraitBinding.buyBtn }");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected LinearLayout D0() {
        LinearLayout linearLayout;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            linearLayout = cdVar.f418983f;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            linearLayout = cpVar.f419053f;
        }
        Intrinsics.checkNotNullExpressionValue(linearLayout, "if (isLandscape) landsca\u2026rrencyStrategyContainer }");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean F() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView, ga4.g
    public void e(int orientation) {
        if (this.isLandscape == (!Z0() && orientation == 2)) {
            return;
        }
        n();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        PortalStoreShoppingCartDialogView portalStoreShoppingCartDialogView = new PortalStoreShoppingCartDialogView(context, null, 0, getMChannel(), 6, null);
        portalStoreShoppingCartDialogView.M0(null);
        portalStoreShoppingCartDialogView.show();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView j0() {
        ImageView imageView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            imageView = cdVar.f418979b;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            imageView = cpVar.f419049b;
        }
        Intrinsics.checkNotNullExpressionValue(imageView, "if (isLandscape) landsca\u2026ortraitBinding.addImage }");
        return imageView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView l0() {
        cp cpVar = null;
        if (this.isLandscape) {
            return null;
        }
        cp cpVar2 = this.portraitBinding;
        if (cpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
        } else {
            cpVar = cpVar2;
        }
        return cpVar.f419054g;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView, com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        Configuration configuration;
        boolean z16 = false;
        if (!Z0()) {
            Resources resources = getContext().getResources();
            if ((resources == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true) {
                z16 = true;
            }
        }
        this.isLandscape = z16;
        if (z16) {
            LinearLayout mContainer = W0().getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "{\n            buildLands\u2026tentView().root\n        }");
            return mContainer;
        }
        ConstraintLayout mContainer2 = Y0().getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "{\n            buildPortr\u2026tentView().root\n        }");
        return mContainer2;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected CurrencyView m0() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected LinearLayout o0() {
        LinearLayout linearLayout;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            linearLayout = cdVar.f418982e;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            linearLayout = cpVar.f419052e;
        }
        Intrinsics.checkNotNullExpressionValue(linearLayout, "if (isLandscape) landsca\u2026nding.currencyContainer }");
        return linearLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView p0() {
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            return cdVar.f418984g;
        }
        cp cpVar2 = this.portraitBinding;
        if (cpVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
        } else {
            cpVar = cpVar2;
        }
        return cpVar.f419055h;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView q0() {
        TextView textView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            textView = cdVar.f418985h;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            textView = cpVar.f419056i;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "if (isLandscape) landsca\u2026.dialogCurrencyStrategy }");
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int r() {
        if (getMChannel().getEngineApi().getType() == AvatarEngineType.UE_SMALL_HOME) {
            return Color.parseColor("#00000000");
        }
        return super.r();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected TextView r0() {
        TextView textView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            textView = cdVar.f418990m;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            textView = cpVar.f419061n;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "if (isLandscape) landsca\u2026ortraitBinding.goalText }");
        return textView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView s0() {
        ImageView imageView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            imageView = cdVar.f418989l;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            imageView = cpVar.f419060m;
        }
        Intrinsics.checkNotNullExpressionValue(imageView, "if (isLandscape) landsca\u2026ortraitBinding.goalIcon }");
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int t() {
        if (this.isLandscape) {
            return -1;
        }
        return super.t();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected RecyclerView t0() {
        RecyclerView recyclerView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            recyclerView = cdVar.f418991n;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            recyclerView = cpVar.f419062o;
        }
        Intrinsics.checkNotNullExpressionValue(recyclerView, "if (isLandscape) landsca\u2026rtraitBinding.goodsList }");
        return recyclerView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected AvatarPanelErrorView v0() {
        AvatarPanelErrorView avatarPanelErrorView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            avatarPanelErrorView = cdVar.f418993p;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            avatarPanelErrorView = cpVar.f419063p;
        }
        Intrinsics.checkNotNullExpressionValue(avatarPanelErrorView, "if (isLandscape) landsca\u2026itBinding.loadErrorView }");
        return avatarPanelErrorView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ShimmerLinearLayout w0() {
        ShimmerLinearLayout shimmerLinearLayout;
        String str;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            shimmerLinearLayout = cdVar.f418994q.f419190b;
            str = "landscapeBinding.loading\u2026iew.avatarCartWaitingView";
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            shimmerLinearLayout = cpVar.f419064q.f419188b;
            str = "{ portraitBinding.loadin\u2026w.avatarCartWaitingView }";
        }
        Intrinsics.checkNotNullExpressionValue(shimmerLinearLayout, str);
        return shimmerLinearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public int x() {
        return this.isLandscape ? 3 : 1;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected FrameLayout x0() {
        FrameLayout frameLayout;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            frameLayout = cdVar.f418995r;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            frameLayout = cpVar.f419065r;
        }
        Intrinsics.checkNotNullExpressionValue(frameLayout, "if (isLandscape) landsca\u2026nding.loadingStatusView }");
        return frameLayout;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected AvatarGlobalLoadingView y0() {
        AvatarGlobalLoadingView avatarGlobalLoadingView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            avatarGlobalLoadingView = cdVar.f418988k;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            avatarGlobalLoadingView = cpVar.f419059l;
        }
        Intrinsics.checkNotNullExpressionValue(avatarGlobalLoadingView, "if (isLandscape) landsca\u2026nding.globalLoadingView }");
        return avatarGlobalLoadingView;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.ShoppingCartDialogView
    protected ImageView z0() {
        ImageView imageView;
        cp cpVar = null;
        cd cdVar = null;
        if (this.isLandscape) {
            cd cdVar2 = this.landscapeBinding;
            if (cdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("landscapeBinding");
            } else {
                cdVar = cdVar2;
            }
            imageView = cdVar.f418997t;
        } else {
            cp cpVar2 = this.portraitBinding;
            if (cpVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("portraitBinding");
            } else {
                cpVar = cpVar2;
            }
            imageView = cpVar.f419066s;
        }
        Intrinsics.checkNotNullExpressionValue(imageView, "if (isLandscape) landsca\u2026traitBinding.silverIcon }");
        return imageView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreShoppingCartDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
    }
}
