package com.tencent.mobileqq.qwallet.home.grid;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Market;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedPoint;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mobileqq.qwallet.home.am;
import com.tencent.mobileqq.qwallet.home.u;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u0013\u001a\u00020\f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/GridAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/qwallet/home/am$b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "appInfo", "p", "onViewAttachedToWindow", "", "event", "u0", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "r", "(Landroid/widget/ImageView;)V", "iconView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/widget/TextView;)V", "titleView", "<set-?>", "G", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "getAppInfo", "()Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "Lcom/tencent/mobileqq/qwallet/home/am;", "H", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/qwallet/home/am;", "redPointMarket", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class GridAppViewHolder extends RecyclerView.ViewHolder implements am.b {

    /* renamed from: E, reason: from kotlin metadata */
    protected ImageView iconView;

    /* renamed from: F, reason: from kotlin metadata */
    protected TextView titleView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QWalletHomePage$AppInfo appInfo;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy redPointMarket;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridAppViewHolder(@NotNull View view) {
        super(view);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(view, "view");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<am>() { // from class: com.tencent.mobileqq.qwallet.home.grid.GridAppViewHolder$redPointMarket$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final am invoke() {
                return new am(GridAppViewHolder.this);
            }
        });
        this.redPointMarket = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final am o() {
        return (am) this.redPointMarket.getValue();
    }

    private final void q() {
        String str;
        String str2 = "";
        if (getTitleView().getVisibility() != 0) {
            str = "";
        } else {
            str = getTitleView().getText().toString();
        }
        String r16 = o().r();
        if (r16 != null) {
            str2 = r16;
        }
        this.itemView.setContentDescription(str + str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView getTitleView() {
        TextView textView = this.titleView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ImageView m() {
        ImageView imageView = this.iconView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    }

    public final void onViewAttachedToWindow() {
        am o16 = o();
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        o16.t(itemView);
    }

    public void p(@NotNull final QWalletHomePage$AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        this.appInfo = appInfo;
        if (!c4.a.u(appInfo)) {
            return;
        }
        m().setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(appInfo.icon.get()));
        getTitleView().setText(appInfo.name.get());
        o().x(appInfo);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        k.d(itemView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.grid.GridAppViewHolder$renderAppInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                am o16;
                c4.a.y(QWalletHomePage$AppInfo.this, "index.tuijian.click", null, 0, 6, null);
                o16 = this.o();
                o16.u();
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                u.c(context, QWalletHomePage$AppInfo.this, HomeLegacyBizManager.f277929d.g());
            }
        }, 1, null);
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.iconView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleView = textView;
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    public void u0(int event, @NotNull QWalletHomePage$AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        switch (event) {
            case 2:
                QWalletHomePage$RedPoint qWalletHomePage$RedPoint = appInfo.red_point;
                String D = c4.a.D(appInfo);
                String str = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str, "appInfo.name.get()");
                c4.a.x(qWalletHomePage$RedPoint, "tuijian.redpoint.show", D, str);
                return;
            case 3:
                QWalletHomePage$RedPoint qWalletHomePage$RedPoint2 = appInfo.red_point;
                String D2 = c4.a.D(appInfo);
                String str2 = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str2, "appInfo.name.get()");
                c4.a.x(qWalletHomePage$RedPoint2, "tuijian.redpoint.click", D2, str2);
                return;
            case 4:
                QWalletHomePage$RedPoint qWalletHomePage$RedPoint3 = appInfo.red_point;
                String D3 = c4.a.D(appInfo);
                String str3 = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str3, "appInfo.name.get()");
                c4.a.x(qWalletHomePage$RedPoint3, "tuijian.redpoint.show", D3, str3);
                return;
            case 5:
                QWalletHomePage$RedPoint qWalletHomePage$RedPoint4 = appInfo.red_point;
                String D4 = c4.a.D(appInfo);
                String str4 = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str4, "appInfo.name.get()");
                c4.a.x(qWalletHomePage$RedPoint4, "tuijian.redpoint.click", D4, str4);
                return;
            case 6:
                QWalletHomePage$Market qWalletHomePage$Market = appInfo.market;
                String D5 = c4.a.D(appInfo);
                String str5 = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str5, "appInfo.name.get()");
                c4.a.w(qWalletHomePage$Market, "tuijian.market.show", D5, str5);
                return;
            case 7:
                QWalletHomePage$Market qWalletHomePage$Market2 = appInfo.market;
                String D6 = c4.a.D(appInfo);
                String str6 = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str6, "appInfo.name.get()");
                c4.a.w(qWalletHomePage$Market2, "tuijian.market.click", D6, str6);
                return;
            default:
                return;
        }
    }
}
