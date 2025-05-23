package d94;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.adv.web.RewardType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartGoodsData;
import com.tencent.sqshow.zootopia.nativeui.data.cart.CartStatus;
import com.tencent.sqshow.zootopia.nativeui.data.cart.PriceType;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.util.QQToastUtil;
import d94.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import m94.DressErrorMsg;
import n74.ct;
import n74.cu;
import n74.cv;
import n74.cw;
import n74.cx;
import org.json.JSONObject;
import t74.o;
import uv4.az;
import uv4.ba;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004/012B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u0016\u00a8\u00063"}, d2 = {"Ld94/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ld94/h$a;", "", "l0", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "list", "", "gender", "", "p0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "holder", "position", "n0", "getItemCount", "getItemViewType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getSource", "()I", "source", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "m0", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", "D", "Ljava/util/List;", "mData", "Ljava/util/concurrent/locks/ReentrantLock;", "E", "Ljava/util/concurrent/locks/ReentrantLock;", "dataLock", UserInfo.SEX_FEMALE, "firstNoSellGoodsIndex", "G", "mGender", "<init>", "(ILcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "H", "a", "b", "c", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: D, reason: from kotlin metadata */
    private List<CartGoodsData> mData;

    /* renamed from: E, reason: from kotlin metadata */
    private final ReentrantLock dataLock;

    /* renamed from: F, reason: from kotlin metadata */
    private int firstNoSellGoodsIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private int mGender;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001c\u0010\u001b\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n \u0012*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u001c\u0010\u001f\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u001c\u0010!\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0014R\u001c\u0010#\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0014R\u001c\u0010%\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0014R\u001c\u0010'\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001aR\u001c\u0010+\u001a\n \u0012*\u0004\u0018\u00010(0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010-\u001a\n \u0012*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\rR\u001c\u00101\u001a\n \u0012*\u0004\u0018\u00010.0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\n \u0012*\u0004\u0018\u00010.0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u001c\u00105\u001a\n \u0012*\u0004\u0018\u00010.0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Ld94/h$d;", "Ld94/h$a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "v", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "G", "Landroid/widget/TextView;", "currencyText", "H", "originalPrice", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "isSelected", "J", "goodsCurrencyContainer", "K", "currencyIcon", "L", "experienceTips", "M", "goodsName", "N", "originalPriceType", "P", "currenctExchage", "Landroid/view/ViewGroup;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/ViewGroup;", "originalPriceContainer", BdhLogUtil.LogTag.Tag_Req, "goodsContainer", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "goodsImageView", "T", "goodsLeftTag", "U", "goodsRightTag", "Landroid/os/CountDownTimer;", "V", "Landroid/os/CountDownTimer;", "campaignBeginTimer", "<init>", "(Ld94/h;Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public final class d extends a {

        /* renamed from: F, reason: from kotlin metadata */
        private final View rootView;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView currencyText;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView originalPrice;

        /* renamed from: I, reason: from kotlin metadata */
        private final ImageView isSelected;

        /* renamed from: J, reason: from kotlin metadata */
        private final View goodsCurrencyContainer;

        /* renamed from: K, reason: from kotlin metadata */
        private final ImageView currencyIcon;

        /* renamed from: L, reason: from kotlin metadata */
        private final TextView experienceTips;

        /* renamed from: M, reason: from kotlin metadata */
        private final TextView goodsName;

        /* renamed from: N, reason: from kotlin metadata */
        private final TextView originalPriceType;

        /* renamed from: P, reason: from kotlin metadata */
        private final ImageView currenctExchage;

        /* renamed from: Q, reason: from kotlin metadata */
        private final ViewGroup originalPriceContainer;

        /* renamed from: R, reason: from kotlin metadata */
        private final View goodsContainer;

        /* renamed from: S, reason: from kotlin metadata */
        private final RoundCornerImageView goodsImageView;

        /* renamed from: T, reason: from kotlin metadata */
        private final RoundCornerImageView goodsLeftTag;

        /* renamed from: U, reason: from kotlin metadata */
        private final RoundCornerImageView goodsRightTag;

        /* renamed from: V, reason: from kotlin metadata */
        private CountDownTimer campaignBeginTimer;
        final /* synthetic */ h W;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"d94/h$d$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements View.OnAttachStateChangeListener {
            a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v3) {
                QLog.d("ShoppingCartListAdapter", 1, " View detached~");
                CountDownTimer countDownTimer = d.this.campaignBeginTimer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                d.this.getRootView().removeOnAttachStateChangeListener(this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v3) {
            }
        }

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes38.dex */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f393262a;

            static {
                int[] iArr = new int[PriceType.values().length];
                try {
                    iArr[PriceType.GOAL_FIRST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PriceType.SILVER_FIRST.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PriceType.GOAL_AND_SILVER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f393262a = iArr;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"d94/h$d$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class c extends CountDownTimer {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f393263a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CartGoodsData f393264b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(long j3, d dVar, CartGoodsData cartGoodsData) {
                super(j3, 1000L);
                this.f393263a = dVar;
                this.f393264b = cartGoodsData;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.f393263a.w();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                this.f393263a.A(this.f393264b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h hVar, View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.W = hVar;
            this.rootView = rootView;
            TextView textView = (TextView) rootView.findViewById(R.id.pnj);
            this.currencyText = textView;
            TextView textView2 = (TextView) rootView.findViewById(R.id.qap);
            this.originalPrice = textView2;
            this.isSelected = (ImageView) rootView.findViewById(R.id.q2q);
            this.goodsCurrencyContainer = rootView.findViewById(R.id.pxj);
            this.currencyIcon = (ImageView) rootView.findViewById(R.id.pnh);
            this.experienceTips = (TextView) rootView.findViewById(R.id.pt_);
            this.goodsName = (TextView) rootView.findViewById(R.id.pxo);
            this.originalPriceType = (TextView) rootView.findViewById(R.id.qar);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.pnf);
            this.currenctExchage = imageView;
            this.originalPriceContainer = (ViewGroup) rootView.findViewById(R.id.qaq);
            View findViewById = rootView.findViewById(R.id.pxe);
            this.goodsContainer = findViewById;
            this.goodsImageView = (RoundCornerImageView) findViewById.findViewById(R.id.pxl);
            this.goodsLeftTag = (RoundCornerImageView) findViewById.findViewById(R.id.pxm);
            this.goodsRightTag = (RoundCornerImageView) findViewById.findViewById(R.id.pxp);
            t74.m mVar = t74.m.f435564a;
            AssetManager assets = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            textView.setTypeface(mVar.b(assets));
            AssetManager assets2 = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
            textView2.setTypeface(mVar.b(assets2));
            rootView.addOnAttachStateChangeListener(new a());
            imageView.setImageDrawable(ie0.a.f().o(rootView.getContext(), R.drawable.ild, R.color.qui_common_icon_tertiary, 1000));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void A(CartGoodsData data) {
            int i3;
            this.experienceTips.setVisibility(0);
            this.goodsRightTag.setVisibility(0);
            this.originalPriceContainer.setVisibility(0);
            long serverTime = NetConnInfoCenter.getServerTime();
            int i16 = b.f393262a[data.getPriceType().ordinal()];
            if (i16 == 1) {
                i3 = data.getItemData().f440287n.f440313b;
            } else if (i16 != 2) {
                i3 = data.getItemData().f440287n.f440313b;
            } else {
                i3 = data.getItemData().f440287n.f440314c;
            }
            this.originalPrice.setText(com.tencent.sqshow.zootopia.utils.e.f373267a.a(i3));
            this.originalPriceType.setText(data.getPriceType().getType());
            this.experienceTips.setText(this.rootView.getContext().getResources().getString(R.string.xnh, t.f373300a.c(data.getItemData().f440287n.f440317f - serverTime)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(CartGoodsData data, h this$0, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.d("ShoppingCartListAdapter", 1, "data is Select " + data.getItemData().f440277d + " => data isSelected: " + data.getIsSelected());
            data.i(data.getIsSelected() ^ true);
            com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(this$0.mData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(CartGoodsData data, h this$0, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.d("ShoppingCartListAdapter", 1, "click currencyContainer");
            if (data.f()) {
                PriceType priceType = data.getPriceType();
                PriceType priceType2 = PriceType.GOAL_FIRST;
                if (priceType == priceType2) {
                    priceType2 = PriceType.SILVER_FIRST;
                }
                data.h(priceType2);
                com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.I(this$0.mData);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void w() {
            this.experienceTips.setVisibility(8);
            this.goodsRightTag.setVisibility(8);
            this.originalPriceContainer.setVisibility(8);
            CountDownTimer countDownTimer = this.campaignBeginTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.campaignBeginTimer = null;
        }

        private final void y(CartGoodsData data) {
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(data.getItemData())) {
                this.experienceTips.setText(R.string.xpw);
                this.experienceTips.setTextColor(ContextCompat.getColor(this.rootView.getContext(), R.color.b9l));
                this.experienceTips.setVisibility(0);
                this.originalPriceContainer.setVisibility(8);
                return;
            }
            if (data.d()) {
                this.experienceTips.setTextColor(ContextCompat.getColor(this.rootView.getContext(), R.color.f8577b));
                TextView textView = this.originalPrice;
                textView.setPaintFlags(textView.getPaintFlags() | 16);
                x(data);
                return;
            }
            w();
        }

        private final void z(CartGoodsData data) {
            this.goodsName.setText(data.getItemData().f440277d);
            this.currenctExchage.setVisibility(data.f() ? 0 : 8);
            int i3 = b.f393262a[data.getPriceType().ordinal()];
            if (i3 == 1) {
                this.currencyIcon.setImageResource(R.drawable.ilx);
                TextView textView = this.currencyText;
                com.tencent.sqshow.zootopia.utils.e eVar = com.tencent.sqshow.zootopia.utils.e.f373267a;
                bc bcVar = data.getItemData().f440287n;
                textView.setText(eVar.a(bcVar != null ? bcVar.f440315d : 0));
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                QLog.e("ShoppingCartListAdapter", 1, "wrong type");
            } else {
                this.currencyIcon.setImageResource(R.drawable.f159901im2);
                TextView textView2 = this.currencyText;
                com.tencent.sqshow.zootopia.utils.e eVar2 = com.tencent.sqshow.zootopia.utils.e.f373267a;
                bc bcVar2 = data.getItemData().f440287n;
                textView2.setText(eVar2.a(bcVar2 != null ? bcVar2.f440316e : 0));
            }
        }

        public final void s(final CartGoodsData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("ShoppingCartListAdapter", 1, "bindData => " + data.getItemData().f440275b + " ==> [ " + data.getItemData().f440277d + " ], " + data.getIsSelected() + " ," + data.getPriceType() + " \n");
            String str = data.getItemData().f440279f;
            if (str != null) {
                RoundCornerImageView goodsImageView = this.goodsImageView;
                Intrinsics.checkNotNullExpressionValue(goodsImageView, "goodsImageView");
                CommonExKt.w(goodsImageView, str, q.b(R.drawable.h4b), null, 4, null);
            }
            z(data);
            if (data.getIsSelected()) {
                this.isSelected.setImageResource(R.drawable.ilb);
            } else {
                this.isSelected.setImageResource(R.drawable.ilc);
            }
            View view = this.rootView;
            final h hVar = this.W;
            view.setOnClickListener(new View.OnClickListener() { // from class: d94.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.d.t(CartGoodsData.this, hVar, view2);
                }
            });
            View view2 = this.goodsCurrencyContainer;
            final h hVar2 = this.W;
            view2.setOnClickListener(new View.OnClickListener() { // from class: d94.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    h.d.u(CartGoodsData.this, hVar2, view3);
                }
            });
            RoundCornerImageView goodsLeftTag = this.goodsLeftTag;
            Intrinsics.checkNotNullExpressionValue(goodsLeftTag, "goodsLeftTag");
            l(goodsLeftTag, data.getItemData().f440282i, data.getItemData().f440276c > 0);
            RoundCornerImageView goodsRightTag = this.goodsRightTag;
            Intrinsics.checkNotNullExpressionValue(goodsRightTag, "goodsRightTag");
            a.m(this, goodsRightTag, data.getItemData().f440283j, false, 4, null);
            y(data);
        }

        /* renamed from: v, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }

        private final void x(CartGoodsData data) {
            QLog.d("ShoppingCartListAdapter", 1, "renderDiscountEndTime");
            CountDownTimer countDownTimer = this.campaignBeginTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            long serverTime = (data.getItemData().f440287n.f440317f - NetConnInfoCenter.getServerTime()) * 1000;
            A(data);
            c cVar = new c(serverTime, this, data);
            this.campaignBeginTimer = cVar;
            cVar.start();
        }
    }

    public h(int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.source = i3;
        this.channel = channel;
        this.mData = new ArrayList();
        this.dataLock = new ReentrantLock();
        this.firstNoSellGoodsIndex = -1;
    }

    private final boolean l0() {
        int i3 = this.source;
        if (i3 != 0) {
            return i3 == 1 || i3 == 2;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        ReentrantLock reentrantLock = this.dataLock;
        reentrantLock.lock();
        try {
            return this.mData.size();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ReentrantLock reentrantLock = this.dataLock;
        reentrantLock.lock();
        try {
            CartGoodsData cartGoodsData = this.mData.get(position);
            reentrantLock.unlock();
            return com.tencent.sqshow.zootopia.nativeui.data.cart.b.c(cartGoodsData.getItemData(), this.mGender) ? 1 : 2;
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    /* renamed from: m0, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getChannel() {
        return this.channel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof d) {
            ((d) holder).s(this.mData.get(position));
        } else if (holder instanceof c) {
            ((c) holder).q(this.mData.get(position), this.firstNoSellGoodsIndex == position);
        } else if (holder instanceof z74.c) {
            ((z74.c) holder).q(this.mData.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewBinding g16;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType == 2) {
                if (l0()) {
                    g16 = cx.g(LayoutInflater.from(parent.getContext()), parent, false);
                    Intrinsics.checkNotNullExpressionValue(g16, "{\n                    Zp\u2026      )\n                }");
                } else {
                    g16 = cw.g(LayoutInflater.from(parent.getContext()), parent, false);
                    Intrinsics.checkNotNullExpressionValue(g16, "{\n                    Zp\u2026      )\n                }");
                }
                View mRv = g16.getMRv();
                Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
                return new c(this, mRv);
            }
            throw new IllegalArgumentException("viewType = " + viewType + " is not support. ");
        }
        int i3 = this.source;
        if (i3 == 1) {
            cu g17 = cu.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            ConstraintLayout root = g17.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return new d(this, root);
        }
        if (i3 == 2) {
            cu g18 = cu.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g18, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            ConstraintLayout root2 = g18.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            return new d(this, root2);
        }
        if (i3 != 3) {
            ct g19 = ct.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g19, "inflate(LayoutInflater.f\u2026.context), parent, false)");
            ConstraintLayout root3 = g19.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            return new d(this, root3);
        }
        cv g26 = cv.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g26, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        ConstraintLayout root4 = g26.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
        return new z74.c(root4, this.mData);
    }

    public final void p0(List<CartGoodsData> list, int gender) {
        List list2;
        Intrinsics.checkNotNullParameter(list, "list");
        list2 = CollectionsKt___CollectionsKt.toList(list);
        ReentrantLock reentrantLock = this.dataLock;
        reentrantLock.lock();
        try {
            this.mData.clear();
            this.mData.addAll(list2);
            reentrantLock.unlock();
            this.mGender = gender;
            Iterator<CartGoodsData> it = list.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (!com.tencent.sqshow.zootopia.nativeui.data.cart.b.c(it.next().getItemData(), gender)) {
                    break;
                } else {
                    i3++;
                }
            }
            this.firstNoSellGoodsIndex = i3;
            notifyDataSetChanged();
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u0003\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Ld94/h$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/image/URLImageView;", "view", "", "url", "", "isUgcItem", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final void l(URLImageView view, String url, boolean isUgcItem) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!isUgcItem && !TextUtils.isEmpty(url)) {
                if (url != null) {
                    CommonExKt.w(view, url, null, null, 6, null);
                }
                view.setVisibility(0);
                return;
            }
            view.setVisibility(8);
        }

        public static /* synthetic */ void m(a aVar, URLImageView uRLImageView, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                aVar.l(uRLImageView, str, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTagView");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J4\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH\u0003J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007R\u0017\u0010\u0019\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001c\u0010!\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001dR\u001c\u0010#\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001dR\u001c\u0010%\u001a\n \u001b*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u001c\u0010)\u001a\n \u001b*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n \u001b*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u001c\u0010-\u001a\n \u001b*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R&\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000602018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Ld94/h$c;", "Ld94/h$a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "data", "", "r", "Luv4/az;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "w", "Landroid/view/View;", "goodsName", "t", "v", "cartGoodsData", "u", "", "shouldShowTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, UserInfo.SEX_FEMALE, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "G", "Landroid/widget/TextView;", "titleTextView", "H", "I", "goodsDesc", "J", "watchAdCount", "K", "goodsContainer", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "L", "Lcom/tencent/sqshow/zootopia/utils/ui/RoundCornerImageView;", "goodsImageView", "M", "goodsLeftTag", "N", "goodsRightTag", "P", "Lcom/tencent/sqshow/zootopia/nativeui/data/cart/a;", "curCardGoodsData", "Landroidx/lifecycle/Observer;", "", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/lifecycle/Observer;", "watchAdStoreItemObserver", "<init>", "(Ld94/h;Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public final class c extends a {

        /* renamed from: F, reason: from kotlin metadata */
        private final View rootView;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView titleTextView;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView goodsName;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView goodsDesc;

        /* renamed from: J, reason: from kotlin metadata */
        private final TextView watchAdCount;

        /* renamed from: K, reason: from kotlin metadata */
        private final View goodsContainer;

        /* renamed from: L, reason: from kotlin metadata */
        private final RoundCornerImageView goodsImageView;

        /* renamed from: M, reason: from kotlin metadata */
        private final RoundCornerImageView goodsLeftTag;

        /* renamed from: N, reason: from kotlin metadata */
        private final RoundCornerImageView goodsRightTag;

        /* renamed from: P, reason: from kotlin metadata */
        private CartGoodsData curCardGoodsData;

        /* renamed from: Q, reason: from kotlin metadata */
        private final Observer<Map<Long, az>> watchAdStoreItemObserver;
        final /* synthetic */ h R;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"d94/h$c$a", "Lt74/o$b;", "", "success", "", "b", "profitable", "c", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements o.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f393258a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CartGoodsData f393259b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ h f393260c;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"d94/h$c$a$a", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: d94.h$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes38.dex */
            public static final class C10167a implements m94.h {
                C10167a() {
                }

                @Override // m94.h
                public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    QLog.i("ShoppingCartListAdapter", 1, "onError");
                }

                @Override // m94.h
                public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    QLog.i("ShoppingCartListAdapter", 1, "onSuccess");
                }
            }

            a(View view, CartGoodsData cartGoodsData, h hVar) {
                this.f393258a = view;
                this.f393259b = cartGoodsData;
                this.f393260c = hVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void g(h this$0, CartGoodsData cartGoodsData) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(cartGoodsData, "$cartGoodsData");
                if (this$0.mData.size() > 1) {
                    ReentrantLock reentrantLock = this$0.dataLock;
                    reentrantLock.lock();
                    try {
                        this$0.mData.remove(cartGoodsData);
                        reentrantLock.unlock();
                        this$0.notifyDataSetChanged();
                    } catch (Throwable th5) {
                        reentrantLock.unlock();
                        throw th5;
                    }
                } else {
                    com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.i().e(CartStatus.HIDE_LOADING_AND_DISMISS);
                }
                b94.d avatarDressController = this$0.getChannel().getAvatarDressController();
                if (avatarDressController != null) {
                    avatarDressController.Lf(cartGoodsData.getItemData(), new C10167a(), NormalDressStrategy.ONLY_OFF);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void h(View goodsName) {
                Intrinsics.checkNotNullParameter(goodsName, "$goodsName");
                QQToastUtil.showQQToast(0, R.string.xs_);
                goodsName.setEnabled(true);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(View goodsName) {
                Intrinsics.checkNotNullParameter(goodsName, "$goodsName");
                goodsName.setEnabled(true);
            }

            @Override // t74.o.b
            public void a(boolean success) {
                QLog.i("ShoppingCartListAdapter", 1, "ZPlanAdHelper onReportResult " + success);
                if (success) {
                    this.f393259b.getItemData().f440288o.f440307h++;
                    this.f393260c.getChannel().K().put(Long.valueOf(this.f393259b.getItemData().f440274a), this.f393259b.getItemData());
                    this.f393260c.getChannel().L().postValue(this.f393260c.getChannel().K());
                    if (this.f393259b.getItemData().f440288o.f440308i == this.f393259b.getItemData().f440288o.f440307h) {
                        QLog.e("ShoppingCartListAdapter", 1, "ZPlanAvatarChangeManager.refreshPannel");
                        this.f393260c.getChannel().K().remove(Long.valueOf(this.f393259b.getItemData().f440274a));
                        this.f393260c.getChannel().L().postValue(this.f393260c.getChannel().K());
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final h hVar = this.f393260c;
                        final CartGoodsData cartGoodsData = this.f393259b;
                        uIHandlerV2.post(new Runnable() { // from class: d94.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                h.c.a.g(h.this, cartGoodsData);
                            }
                        });
                        f94.c.f398021a.c(false);
                        QQToastUtil.showQQToastInUiThread(2, BaseApplication.getContext().getString(R.string.xsa));
                        return;
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = BaseApplication.getContext().getString(R.string.xs9);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026_activity_ad_count_toast)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f393259b.getItemData().f440288o.f440308i - this.f393259b.getItemData().f440288o.f440307h)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QQToastUtil.showQQToastInUiThread(0, format);
                }
            }

            @Override // t74.o.b
            public void b(boolean success) {
                QLog.i("ShoppingCartListAdapter", 1, "ZPlanAdHelper onRequestResult " + success);
                if (success) {
                    return;
                }
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final View view = this.f393258a;
                uIHandlerV2.post(new Runnable() { // from class: d94.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.c.a.h(view);
                    }
                });
            }

            @Override // t74.o.b
            public void c(boolean profitable) {
                QLog.i("ShoppingCartListAdapter", 1, "ZPlanAdHelper onShowResult " + profitable);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final View view = this.f393258a;
                uIHandlerV2.post(new Runnable() { // from class: d94.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.c.a.i(view);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h hVar, View rootView) {
            super(rootView);
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.R = hVar;
            this.rootView = rootView;
            this.titleTextView = (TextView) rootView.findViewById(R.id.qrh);
            this.goodsName = (TextView) rootView.findViewById(R.id.pxo);
            this.goodsDesc = (TextView) rootView.findViewById(R.id.pxk);
            this.watchAdCount = (TextView) rootView.findViewById(R.id.qys);
            View findViewById = rootView.findViewById(R.id.pxe);
            this.goodsContainer = findViewById;
            this.goodsImageView = (RoundCornerImageView) findViewById.findViewById(R.id.pxl);
            this.goodsLeftTag = (RoundCornerImageView) findViewById.findViewById(R.id.pxm);
            this.goodsRightTag = (RoundCornerImageView) findViewById.findViewById(R.id.pxp);
            this.watchAdStoreItemObserver = new Observer() { // from class: d94.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    h.c.y(h.c.this, (Map) obj);
                }
            };
        }

        private final void r(final CartGoodsData data) {
            Unit unit;
            final HashMap<String, String> hashMapOf;
            if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.d(data.getItemData(), this.R.mGender)) {
                this.goodsDesc.setTextColor(ContextCompat.getColor(this.rootView.getContext(), R.color.qui_common_text_secondary));
                this.goodsDesc.setText(R.string.xrm);
                this.goodsDesc.setTextSize(1, 15.0f);
                return;
            }
            if (data.getItemData().f440295v > 0) {
                this.goodsDesc.setTextColor(ContextCompat.getColor(this.rootView.getContext(), R.color.qui_common_text_secondary));
                this.goodsDesc.setText(R.string.xrn);
                this.goodsDesc.setTextSize(1, 15.0f);
                return;
            }
            ba baVar = data.getItemData().f440288o;
            if (baVar != null) {
                final h hVar = this.R;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_item_id", r94.b.K(data.getItemData())), TuplesKt.to("zplan_act_id", baVar.f440301b));
                ZplanViewReportHelper mReporter = hVar.getChannel().getReporter().getMReporter();
                TextView goodsName = this.goodsName;
                Intrinsics.checkNotNullExpressionValue(goodsName, "goodsName");
                mReporter.g(goodsName, "em_zplan_cart_activity_entrance", (r16 & 4) != 0 ? null : hashMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
                TextView goodsName2 = this.goodsName;
                Intrinsics.checkNotNullExpressionValue(goodsName2, "goodsName");
                aa.d(goodsName2, new View.OnClickListener() { // from class: d94.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        h.c.s(h.c.this, data, hVar, hashMapOf, view);
                    }
                });
                w(data.getItemData(), hashMapOf);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.goodsDesc.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(c this$0, CartGoodsData data, h this$1, HashMap reportParams, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
            TextView goodsName = this$0.goodsName;
            Intrinsics.checkNotNullExpressionValue(goodsName, "goodsName");
            this$0.t(goodsName, data);
            ZplanViewReportHelper mReporter = this$1.getChannel().getReporter().getMReporter();
            TextView goodsName2 = this$0.goodsName;
            Intrinsics.checkNotNullExpressionValue(goodsName2, "goodsName");
            mReporter.e(goodsName2, "em_zplan_cart_activity_entrance", reportParams);
        }

        private final void t(View goodsName, CartGoodsData data) {
            ba baVar = data.getItemData().f440288o;
            if (baVar != null) {
                String scheme = baVar.f440302c;
                boolean y16 = r94.b.y(data.getItemData());
                boolean z16 = baVar.f440308i > baVar.f440307h;
                QLog.d("ShoppingCartListAdapter", 1, "open scheme: " + scheme + ", needJumpAd: " + z16);
                if (y16) {
                    if (z16) {
                        u(goodsName, data);
                        return;
                    }
                    return;
                } else {
                    Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
                    if (scheme.length() > 0) {
                        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                        Context context = this.rootView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                        iSchemeApi.launchScheme(context, scheme);
                        return;
                    }
                }
            }
            v();
        }

        private final void u(View goodsName, CartGoodsData cartGoodsData) {
            Activity attachedActivity;
            t74.o oVar = new t74.o();
            oVar.o(new a(goodsName, cartGoodsData, this.R));
            if (cartGoodsData.getItemData().f440288o.f440308i <= cartGoodsData.getItemData().f440288o.f440307h || (attachedActivity = this.R.getChannel().getAttachedActivity()) == null) {
                return;
            }
            goodsName.setEnabled(false);
            int value = RewardType.SUPER_SHOW_FREE_ITEM.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("item_id", cartGoodsData.getItemData().f440275b);
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
            t74.o.m(oVar, attachedActivity, value, jSONObject2, 0, 8, null);
        }

        private final void w(final az data, final HashMap<String, String> reportParams) {
            String str;
            String str2;
            this.goodsDesc.setTextColor(ContextCompat.getColor(this.rootView.getContext(), R.color.qui_common_text_link));
            this.goodsDesc.setTextSize(1, 16.0f);
            if (r94.b.y(data)) {
                str = "\u770b\u5e7f\u544a\u83b7\u53d6";
            } else {
                str = data.f440288o.f440303d;
                if (str.length() == 0) {
                    str = "\u6d3b\u52a8\u83b7\u53d6";
                }
            }
            this.goodsDesc.setText(str + " >");
            ba baVar = data.f440288o;
            int i3 = baVar.f440308i;
            int i16 = i3 - baVar.f440307h;
            if (i16 > 0 && i3 > 1) {
                TextView textView = this.watchAdCount;
                Activity attachedActivity = this.R.getChannel().getAttachedActivity();
                if (attachedActivity != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = attachedActivity.getResources().getString(R.string.xs8);
                    Intrinsics.checkNotNullExpressionValue(string, "it.resources.getString(R\u2026portal_activity_ad_count)");
                    str2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                } else {
                    str2 = null;
                }
                textView.setText(str2);
                this.watchAdCount.setVisibility(0);
            }
            TextView goodsDesc = this.goodsDesc;
            Intrinsics.checkNotNullExpressionValue(goodsDesc, "goodsDesc");
            final h hVar = this.R;
            aa.d(goodsDesc, new View.OnClickListener() { // from class: d94.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.c.x(h.this, this, reportParams, data, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(h this$0, c this$1, HashMap reportParams, az data, View view) {
            Object obj;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
            Intrinsics.checkNotNullParameter(data, "$data");
            ReentrantLock reentrantLock = this$0.dataLock;
            reentrantLock.lock();
            try {
                Iterator it = this$0.mData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((CartGoodsData) obj).getItemData().f440274a == data.f440274a) {
                            break;
                        }
                    }
                }
                CartGoodsData cartGoodsData = (CartGoodsData) obj;
                if (cartGoodsData != null) {
                    TextView goodsDesc = this$1.goodsDesc;
                    Intrinsics.checkNotNullExpressionValue(goodsDesc, "goodsDesc");
                    this$1.t(goodsDesc, cartGoodsData);
                }
                ZplanViewReportHelper mReporter = this$0.getChannel().getReporter().getMReporter();
                TextView goodsName = this$1.goodsName;
                Intrinsics.checkNotNullExpressionValue(goodsName, "goodsName");
                mReporter.e(goodsName, "em_zplan_cart_activity_entrance", reportParams);
            } finally {
                reentrantLock.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(c this$0, Map map) {
            HashMap<String, String> hashMapOf;
            az itemData;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (az azVar : map.values()) {
                CartGoodsData cartGoodsData = this$0.curCardGoodsData;
                if ((cartGoodsData == null || (itemData = cartGoodsData.getItemData()) == null || azVar.f440274a != itemData.f440274a) ? false : true) {
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_item_id", r94.b.K(azVar)), TuplesKt.to("zplan_act_id", azVar.f440288o.f440301b));
                    this$0.w(azVar, hashMapOf);
                }
            }
        }

        public final void q(CartGoodsData data, boolean shouldShowTitle) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.curCardGoodsData = data;
            LifecycleOwner lifecycleOwner = this.R.getChannel().getLifecycleOwner();
            if (lifecycleOwner != null) {
                this.R.getChannel().L().observe(lifecycleOwner, this.watchAdStoreItemObserver);
            }
            String str = data.getItemData().f440279f;
            if (str != null) {
                RoundCornerImageView goodsImageView = this.goodsImageView;
                Intrinsics.checkNotNullExpressionValue(goodsImageView, "goodsImageView");
                CommonExKt.w(goodsImageView, str, q.b(R.drawable.h4b), null, 4, null);
            }
            this.titleTextView.setVisibility(shouldShowTitle ? 0 : 8);
            this.goodsName.setText(data.getItemData().f440277d);
            r(data);
            RoundCornerImageView goodsLeftTag = this.goodsLeftTag;
            Intrinsics.checkNotNullExpressionValue(goodsLeftTag, "goodsLeftTag");
            l(goodsLeftTag, data.getItemData().f440282i, data.getItemData().f440276c > 0);
            RoundCornerImageView goodsRightTag = this.goodsRightTag;
            Intrinsics.checkNotNullExpressionValue(goodsRightTag, "goodsRightTag");
            a.m(this, goodsRightTag, data.getItemData().f440283j, false, 4, null);
        }

        private final void v() {
        }
    }
}
