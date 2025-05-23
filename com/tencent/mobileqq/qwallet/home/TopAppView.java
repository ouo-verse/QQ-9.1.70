package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Declaim;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Market;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedPoint;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.home.am;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001]B1\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020\u0011\u0012\b\b\u0002\u0010Y\u001a\u00020\u0011\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J,\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\t\u001a\u00020\bJ\u001e\u0010$\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!J\b\u0010&\u001a\u00020\u0003H\u0014R\u0014\u0010)\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00100\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00102\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0014\u00104\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010(R\u0014\u00106\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010+R\u0014\u00108\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010(R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010;\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010?R#\u0010F\u001a\n A*\u0004\u0018\u00010@0@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/TopAppView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/qwallet/home/am$b;", "", "O0", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "appInfo", "J0", "", "shrinkMode", "M0", "F0", "L0", "K0", "info", ViewStickEventHelper.IS_SHOW, "N0", "", "n0", "Landroid/widget/ImageView;", "l0", "G", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "g0", UserInfo.SEX_FEMALE, "event", "u0", "type", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", "declaim", "setTypeAndAppInfo", "isRealName", "", "majorPart", "minorPart", "P0", "Q0", NodeProps.ON_ATTACHED_TO_WINDOW, "d", "Landroid/widget/ImageView;", "imgRes", "e", "Landroid/widget/TextView;", "bigMoneyView", "f", "smallMoneyView", tl.h.F, "unverifiedArrow", "i", "titleView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "redPointView", BdhLogUtil.LogTag.Tag_Conn, "textMarket", "D", "marketTag", "E", "Ljava/lang/Integer;", "<set-?>", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "H0", "()Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "H", "Lkotlin/Lazy;", "G0", "()Landroid/graphics/Typeface;", "amountTypeFace", "Lcom/tencent/mobileqq/qwallet/home/am;", "I", "I0", "()Lcom/tencent/mobileqq/qwallet/home/am;", "redPointMarket", "J", "Z", "K", "reportOpType", "Lkotlin/Function0;", "L", "Lkotlin/jvm/functions/Function0;", AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "M", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TopAppView extends ConstraintLayout implements am.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TextView textMarket;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ImageView marketTag;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer type;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QWalletHomePage$AppInfo appInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QWalletHomePage$Declaim declaim;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy amountTypeFace;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy redPointMarket;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isRealName;

    /* renamed from: K, reason: from kotlin metadata */
    private int reportOpType;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> clickAction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView imgRes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView bigMoneyView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView smallMoneyView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView unverifiedArrow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView redPointView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void F0() {
        if (QWalletUtils.i(getContext()).getBoolean("account_num_protect_switch" + QWalletUtils.h(), false)) {
            this.bigMoneyView.setTypeface(Typeface.DEFAULT_BOLD);
            this.bigMoneyView.setText("*****");
            this.smallMoneyView.setText("");
        }
    }

    private final Typeface G0() {
        return (Typeface) this.amountTypeFace.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final am I0() {
        return (am) this.redPointMarket.getValue();
    }

    private final void J0(QWalletHomePage$AppInfo appInfo) {
        String str;
        PBStringField pBStringField;
        this.imgRes.setVisibility(4);
        boolean z16 = false;
        this.bigMoneyView.setVisibility(0);
        this.smallMoneyView.setVisibility(0);
        if (appInfo != null && (pBStringField = appInfo.name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        TextView textView = this.titleView;
        if (str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            str = "\u4f59\u989d";
        }
        textView.setText(str);
        com.tencent.mobileqq.qwallet.k.d(this, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$renderBalanceInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                function0 = TopAppView.this.clickAction;
                function0.invoke();
            }
        }, 1, null);
    }

    private final void K0(QWalletHomePage$AppInfo appInfo) {
        if (appInfo == null) {
            setVisibility(8);
            QLog.d("TopAppView", 2, "renderOperationInfo: appInfo is null, hide top app view");
            return;
        }
        setVisibility(0);
        this.imgRes.setVisibility(0);
        this.imgRes.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(appInfo.icon.get()));
        ViewGroup.LayoutParams layoutParams = this.imgRes.getLayoutParams();
        int c16 = com.tencent.mobileqq.util.x.c(getContext(), 35.0f);
        layoutParams.height = c16;
        layoutParams.width = c16;
        ol2.b.i(this.imgRes, false, 2, null);
        this.bigMoneyView.setVisibility(8);
        this.smallMoneyView.setVisibility(8);
        this.titleView.setText(appInfo.name.get());
        com.tencent.mobileqq.qwallet.k.d(this, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$renderOperationInfo$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                function0 = TopAppView.this.clickAction;
                function0.invoke();
            }
        }, 1, null);
    }

    private final void L0(QWalletHomePage$AppInfo appInfo) {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        boolean z16 = false;
        this.imgRes.setVisibility(0);
        this.bigMoneyView.setVisibility(8);
        this.smallMoneyView.setVisibility(8);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.frm);
        String str2 = null;
        if (appInfo != null && (pBStringField2 = appInfo.icon) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        this.imgRes.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str, drawable, drawable));
        if (appInfo != null && (pBStringField = appInfo.name) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null) {
            str3 = str2;
        }
        TextView textView = this.titleView;
        if (str3.length() == 0) {
            z16 = true;
        }
        if (z16) {
            str3 = "\u6536\u4ed8\u6b3e";
        }
        textView.setText(str3);
        com.tencent.mobileqq.qwallet.k.d(this, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$renderPaymentCodeInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                function0 = TopAppView.this.clickAction;
                function0.invoke();
            }
        }, 1, null);
    }

    private final void M0(QWalletHomePage$AppInfo appInfo, boolean shrinkMode) {
        String str;
        if (appInfo == null) {
            setVisibility(8);
            QLog.d("TopAppView", 2, "renderQBInfo: appInfo is null, hide top app view");
            return;
        }
        boolean z16 = false;
        setVisibility(0);
        if (shrinkMode) {
            this.imgRes.setVisibility(0);
            this.imgRes.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(appInfo.icon.get(), ContextCompat.getDrawable(getContext(), R.drawable.nwg)));
            this.bigMoneyView.setVisibility(8);
            this.smallMoneyView.setVisibility(8);
        } else {
            this.imgRes.setVisibility(4);
            this.bigMoneyView.setVisibility(0);
            this.smallMoneyView.setVisibility(0);
        }
        PBStringField pBStringField = appInfo.name;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        TextView textView = this.titleView;
        if (str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            str = "Q\u5e01";
        }
        textView.setText(str);
        com.tencent.mobileqq.qwallet.k.d(this, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$renderQBInfo$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0 function0;
                function0 = TopAppView.this.clickAction;
                function0.invoke();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(QWalletHomePage$AppInfo info, boolean isShow) {
        String str;
        int i3;
        if ((info.type.get() != 0 && info.f41686id.get() != 4) || this.reportOpType == 0) {
            return;
        }
        if (isShow) {
            str = "qianbao_lingfuli_show";
        } else {
            str = "qianbao_lingfuli_click";
        }
        int i16 = this.reportOpType;
        if (i16 == 4) {
            i3 = info.market.f41694id.get();
        } else {
            i3 = 0;
        }
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report(str, new WelfareReportBean(i16, i3, info.red_point.f41696id.get(), true, info.market.type.get(), "").a(str));
    }

    private final void O0() {
        String str;
        String str2;
        String str3 = "";
        if (this.titleView.getVisibility() != 0) {
            str = "";
        } else {
            str = this.titleView.getText().toString();
        }
        if (this.bigMoneyView.getVisibility() != 0 || this.smallMoneyView.getVisibility() != 0) {
            str2 = "";
        } else {
            CharSequence text = this.bigMoneyView.getText();
            CharSequence text2 = this.smallMoneyView.getText();
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) text);
            sb5.append((Object) text2);
            str2 = sb5.toString();
        }
        String r16 = I0().r();
        if (r16 != null) {
            str3 = r16;
        }
        setContentDescription(str + str2 + str3);
    }

    public static /* synthetic */ void setTypeAndAppInfo$default(TopAppView topAppView, int i3, QWalletHomePage$AppInfo qWalletHomePage$AppInfo, QWalletHomePage$Declaim qWalletHomePage$Declaim, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        topAppView.setTypeAndAppInfo(i3, qWalletHomePage$AppInfo, qWalletHomePage$Declaim, z16);
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    @NotNull
    /* renamed from: F, reason: from getter */
    public ImageView getMarket() {
        return this.marketTag;
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    @NotNull
    /* renamed from: G, reason: from getter */
    public ImageView getRedPoint() {
        return this.redPointView;
    }

    @Nullable
    /* renamed from: H0, reason: from getter */
    public final QWalletHomePage$AppInfo getAppInfo() {
        return this.appInfo;
    }

    public final void P0(boolean isRealName, @NotNull String majorPart, @NotNull String minorPart) {
        List listOf;
        Intrinsics.checkNotNullParameter(majorPart, "majorPart");
        Intrinsics.checkNotNullParameter(minorPart, "minorPart");
        this.isRealName = isRealName;
        if (isRealName) {
            this.bigMoneyView.setTypeface(G0());
            this.bigMoneyView.setText(majorPart);
            this.bigMoneyView.setTextSize(31.0f);
            this.smallMoneyView.setTypeface(G0());
            this.smallMoneyView.setTextSize(14.0f);
            this.smallMoneyView.setText(minorPart);
            this.unverifiedArrow.setVisibility(8);
            F0();
        } else {
            this.bigMoneyView.setTypeface(Typeface.DEFAULT_BOLD);
            this.bigMoneyView.setText("\u5f85\u8ba4\u8bc1");
            this.bigMoneyView.setTextSize(16.0f);
            this.smallMoneyView.setText("");
            this.unverifiedArrow.setVisibility(0);
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.bigMoneyView, this.smallMoneyView, this.unverifiedArrow});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ol2.b.i((View) it.next(), false, 2, null);
        }
        O0();
        ol2.b.f(this.bigMoneyView, 0, false, 6, null);
        ol2.b.f(this.smallMoneyView, 0, false, 6, null);
    }

    public final void Q0(@NotNull String majorPart, @NotNull String minorPart) {
        List listOf;
        Intrinsics.checkNotNullParameter(majorPart, "majorPart");
        Intrinsics.checkNotNullParameter(minorPart, "minorPart");
        this.bigMoneyView.setTypeface(G0());
        this.bigMoneyView.setText(majorPart);
        this.bigMoneyView.setTextSize(31.0f);
        this.smallMoneyView.setTypeface(G0());
        this.smallMoneyView.setTextSize(14.0f);
        this.smallMoneyView.setText(minorPart);
        F0();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TextView[]{this.bigMoneyView, this.smallMoneyView});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ol2.b.i((TextView) it.next(), false, 2, null);
        }
        O0();
        ol2.b.f(this.bigMoneyView, 0, false, 6, null);
        ol2.b.f(this.smallMoneyView, 0, false, 6, null);
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    @NotNull
    public ImageView S() {
        return this.redPointView;
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    @NotNull
    /* renamed from: g0, reason: from getter */
    public TextView getTextMarket() {
        return this.textMarket;
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    @NotNull
    /* renamed from: l0, reason: from getter */
    public ImageView getImgRes() {
        return this.imgRes;
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    public int n0() {
        return 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        I0().t(this);
    }

    public final void setTypeAndAppInfo(int type, @Nullable QWalletHomePage$AppInfo appInfo, @Nullable QWalletHomePage$Declaim declaim, boolean shrinkMode) {
        this.type = Integer.valueOf(type);
        this.appInfo = appInfo;
        this.declaim = declaim;
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        M0(appInfo, shrinkMode);
                    }
                } else {
                    L0(appInfo);
                }
            } else {
                J0(appInfo);
            }
        } else {
            K0(appInfo);
        }
        if (shrinkMode) {
            this.titleView.setVisibility(8);
            this.redPointView.setVisibility(8);
            this.marketTag.setVisibility(8);
            setScaleX(0.6f);
            setScaleY(0.6f);
        } else if (appInfo != null) {
            c4.a.y(appInfo, "index.topbutton.show", null, 0, 6, null);
            I0().x(appInfo);
            N0(appInfo, true);
        }
        O0();
    }

    @Override // com.tencent.mobileqq.qwallet.home.am.b
    public void u0(int event, @NotNull QWalletHomePage$AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        if (event != -1) {
            if (event != 0) {
                if (event != 4) {
                    if (event != 5) {
                        if (event != 6) {
                            if (event == 7) {
                                QWalletHomePage$Market qWalletHomePage$Market = appInfo.market;
                                String D = c4.a.D(appInfo);
                                String str = appInfo.name.get();
                                Intrinsics.checkNotNullExpressionValue(str, "appInfo.name.get()");
                                c4.a.w(qWalletHomePage$Market, "topbutton.market.click", D, str);
                                return;
                            }
                            return;
                        }
                        this.reportOpType = 4;
                        QWalletHomePage$Market qWalletHomePage$Market2 = appInfo.market;
                        String D2 = c4.a.D(appInfo);
                        String str2 = appInfo.name.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "appInfo.name.get()");
                        c4.a.w(qWalletHomePage$Market2, "topbutton.market.show", D2, str2);
                        return;
                    }
                    QWalletHomePage$RedPoint qWalletHomePage$RedPoint = appInfo.red_point;
                    String D3 = c4.a.D(appInfo);
                    String str3 = appInfo.name.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "appInfo.name.get()");
                    c4.a.x(qWalletHomePage$RedPoint, "topbutton.redpoint.click", D3, str3);
                    return;
                }
                this.reportOpType = 3;
                QWalletHomePage$RedPoint qWalletHomePage$RedPoint2 = appInfo.red_point;
                String D4 = c4.a.D(appInfo);
                String str4 = appInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str4, "appInfo.name.get()");
                c4.a.x(qWalletHomePage$RedPoint2, "topbutton.redpoint.show", D4, str4);
                return;
            }
            this.reportOpType = 2;
            return;
        }
        this.reportOpType = 1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopAppView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopAppView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Typeface>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$amountTypeFace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Typeface invoke() {
                return Typeface.createFromAsset(context.getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
            }
        });
        this.amountTypeFace = lazy;
        View.inflate(context, R.layout.hin, this);
        View findViewById = findViewById(R.id.tpw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.cell_image_res)");
        this.imgRes = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tpv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cell_big_money_res)");
        this.bigMoneyView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f164755tq0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.cell_small_money_res)");
        this.smallMoneyView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f114376t6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.unverified_arrow)");
        this.unverifiedArrow = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f164756tq1);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.cell_text)");
        TextView textView = (TextView) findViewById5;
        this.titleView = textView;
        View findViewById6 = findViewById(R.id.f164758tq3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.cell_true_red_dot)");
        this.redPointView = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f164757tq2);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.cell_text_tag)");
        this.textMarket = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.tpy);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.cell_market_tag)");
        this.marketTag = (ImageView) findViewById8;
        ol2.b.f(textView, 20, false, 4, null);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<am>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$redPointMarket$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final am invoke() {
                return new am(TopAppView.this);
            }
        });
        this.redPointMarket = lazy2;
        this.isRealName = true;
        this.clickAction = new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.home.TopAppView$clickAction$1
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
                Integer num;
                QWalletHomePage$Declaim qWalletHomePage$Declaim;
                QWalletHomePage$Declaim qWalletHomePage$Declaim2;
                am I0;
                boolean z16;
                num = TopAppView.this.type;
                if (num != null && num.intValue() == 1) {
                    u uVar = u.f278200a;
                    Context context2 = context;
                    QWalletHomePage$AppInfo appInfo = TopAppView.this.getAppInfo();
                    z16 = TopAppView.this.isRealName;
                    uVar.b(context2, appInfo, z16);
                } else if (num != null && num.intValue() == 3) {
                    Context context3 = context;
                    QWalletHomePage$AppInfo appInfo2 = TopAppView.this.getAppInfo();
                    qWalletHomePage$Declaim2 = TopAppView.this.declaim;
                    u.c(context3, appInfo2, qWalletHomePage$Declaim2);
                } else if (num != null && num.intValue() == 2) {
                    u.f278200a.e(context, TopAppView.this.getAppInfo());
                } else if (num != null && num.intValue() == 0) {
                    Context context4 = context;
                    QWalletHomePage$AppInfo appInfo3 = TopAppView.this.getAppInfo();
                    qWalletHomePage$Declaim = TopAppView.this.declaim;
                    u.c(context4, appInfo3, qWalletHomePage$Declaim);
                    QWalletHomePage$AppInfo appInfo4 = TopAppView.this.getAppInfo();
                    if (appInfo4 != null) {
                        TopAppView.this.N0(appInfo4, false);
                    }
                }
                QWalletHomePage$AppInfo appInfo5 = TopAppView.this.getAppInfo();
                if (appInfo5 != null) {
                    c4.a.y(appInfo5, "index.topbutton.click", null, 0, 6, null);
                }
                I0 = TopAppView.this.I0();
                I0.u();
            }
        };
    }
}
