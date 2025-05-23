package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.TextViewKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.live.LivePicInfo;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.LiveShowItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 h2\u00020\u0001:\u0001iB?\u0012\u0006\u0010e\u001a\u00020d\u0012\u0016\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040]j\u0002`^\u0012\u0016\u0010c\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040]j\u0002`^\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0004R\u001a\u0010\u001a\u001a\u00020\u00158\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\u00020\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001a\u0010)\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010.\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u001dR\u0014\u00102\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u001dR\u0014\u00104\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010+R\u001a\u00106\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b%\u0010-R\u001a\u00108\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b7\u0010+\u001a\u0004\b/\u0010-R\u001a\u0010;\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u0010-R\u0014\u0010=\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010+R\u001a\u0010@\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b>\u0010+\u001a\u0004\b?\u0010-R\u001a\u0010C\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bA\u0010+\u001a\u0004\bB\u0010-R\u001a\u0010E\u001a\u00020*8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bD\u0010+\u001a\u0004\b\u0016\u0010-R\u0014\u0010G\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010+R\u001a\u0010M\u001a\u00020H8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010&R\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010+R$\u0010\\\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040]j\u0002`^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R$\u0010c\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040]j\u0002`^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010`\u00a8\u0006j"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECBaseLiveItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/repo/live/r;", "showItem", "", ReportConstant.COSTREPORT_PREFIX, "v", "", "position", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "isEditable", "", "", "payloads", "t", "Lcom/tencent/ecommerce/repo/live/q$b;", "leftPrice", "rightPrice", "u", "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "I", "()Landroid/widget/ImageView;", "selectCheckBox", "G", "D", "reorderButton", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/FrameLayout;", "itemRoot", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "y", "()Landroid/widget/TextView;", "indexTextView", "J", "coverImageView", "K", "coverForegroundImageView", "L", "titleTextView", "M", "secondTitleTextView", "N", "thirdTitleTextView", "P", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "prePriceTextView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "rmbTextView", BdhLogUtil.LogTag.Tag_Req, BdhLogUtil.LogTag.Tag_Conn, "priceTextView", ExifInterface.LATITUDE_SOUTH, "B", "priceSuffixTextView", "T", "secondPriceTextView", "U", "stateTextView", "Landroid/widget/Button;", "V", "Landroid/widget/Button;", "w", "()Landroid/widget/Button;", "actionButton", "W", "coverBottomLayout", "Lorg/libpag/PAGView;", "X", "Lorg/libpag/PAGView;", "explainingAnim", "Y", "coverBottomTextView", "Z", "Lcom/tencent/ecommerce/repo/live/q;", HippyTKDListViewAdapter.X, "()Lcom/tencent/ecommerce/repo/live/q;", "setCurrentLiveProduct", "(Lcom/tencent/ecommerce/repo/live/q;)V", "currentLiveProduct", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "a0", "Lkotlin/jvm/functions/Function1;", "onItemClick", "b0", "onActionClick", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "f0", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECBaseLiveItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: c0, reason: collision with root package name */
    private static final Lazy f102790c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final Lazy f102791d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final Lazy f102792e0;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView selectCheckBox;

    /* renamed from: G, reason: from kotlin metadata */
    private final ImageView reorderButton;

    /* renamed from: H, reason: from kotlin metadata */
    private final FrameLayout itemRoot;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView indexTextView;

    /* renamed from: J, reason: from kotlin metadata */
    private final ImageView coverImageView;

    /* renamed from: K, reason: from kotlin metadata */
    private final ImageView coverForegroundImageView;

    /* renamed from: L, reason: from kotlin metadata */
    private final TextView titleTextView;

    /* renamed from: M, reason: from kotlin metadata */
    private final TextView secondTitleTextView;

    /* renamed from: N, reason: from kotlin metadata */
    private final TextView thirdTitleTextView;

    /* renamed from: P, reason: from kotlin metadata */
    private final TextView prePriceTextView;

    /* renamed from: Q, reason: from kotlin metadata */
    private final TextView rmbTextView;

    /* renamed from: R, reason: from kotlin metadata */
    private final TextView priceTextView;

    /* renamed from: S, reason: from kotlin metadata */
    private final TextView priceSuffixTextView;

    /* renamed from: T, reason: from kotlin metadata */
    private final TextView secondPriceTextView;

    /* renamed from: U, reason: from kotlin metadata */
    private final TextView stateTextView;

    /* renamed from: V, reason: from kotlin metadata */
    private final Button actionButton;

    /* renamed from: W, reason: from kotlin metadata */
    private final FrameLayout coverBottomLayout;

    /* renamed from: X, reason: from kotlin metadata */
    private final PAGView explainingAnim;

    /* renamed from: Y, reason: from kotlin metadata */
    private final TextView coverBottomTextView;

    /* renamed from: Z, reason: from kotlin metadata */
    private LiveProduct currentLiveProduct;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Function1<LiveProduct, Unit> onItemClick;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Function1<LiveProduct, Unit> onActionClick;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECLiveItemBaseViewHolder", "item self onClickListener: " + ECBaseLiveItemViewHolder.this.getCurrentLiveProduct());
            LiveProduct currentLiveProduct = ECBaseLiveItemViewHolder.this.getCurrentLiveProduct();
            if (currentLiveProduct != null) {
                ECBaseLiveItemViewHolder.this.onItemClick.invoke(currentLiveProduct);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECLiveItemBaseViewHolder", "actionButton onClickListener: " + ECBaseLiveItemViewHolder.this.getCurrentLiveProduct());
            LiveProduct currentLiveProduct = ECBaseLiveItemViewHolder.this.getCurrentLiveProduct();
            if (currentLiveProduct != null) {
                ECBaseLiveItemViewHolder.this.onActionClick.invoke(currentLiveProduct);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECBaseLiveItemViewHolder$c;", "", "", "COVER_IMAGE_SIZE$delegate", "Lkotlin/Lazy;", "a", "()I", "COVER_IMAGE_SIZE", "TITLE_ICON_HEIGHT$delegate", "b", "TITLE_ICON_HEIGHT", "TITLE_ICON_PADDING$delegate", "c", "TITLE_ICON_PADDING", "", "ANIM_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$c, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ((Number) ECBaseLiveItemViewHolder.f102790c0.getValue()).intValue();
        }

        public final int b() {
            return ((Number) ECBaseLiveItemViewHolder.f102791d0.getValue()).intValue();
        }

        public final int c() {
            return ((Number) ECBaseLiveItemViewHolder.f102792e0.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$Companion$COVER_IMAGE_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(96.0f);
            }
        });
        f102790c0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$Companion$TITLE_ICON_HEIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(15.0f);
            }
        });
        f102791d0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$Companion$TITLE_ICON_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(6.0f);
            }
        });
        f102792e0 = lazy3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECBaseLiveItemViewHolder(View view, Function1<? super LiveProduct, Unit> function1, Function1<? super LiveProduct, Unit> function12) {
        super(view);
        this.onItemClick = function1;
        this.onActionClick = function12;
        Application a16 = wg0.a.a();
        this.context = a16;
        this.selectCheckBox = (ImageView) view.findViewById(R.id.o6y);
        this.reorderButton = (ImageView) view.findViewById(R.id.o7f);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.o78);
        this.itemRoot = frameLayout;
        this.indexTextView = (TextView) view.findViewById(R.id.o77);
        this.coverImageView = (ImageView) view.findViewById(R.id.f163082o71);
        this.coverForegroundImageView = (ImageView) view.findViewById(R.id.f163081o70);
        this.titleTextView = (TextView) view.findViewById(R.id.o7m);
        this.secondTitleTextView = (TextView) view.findViewById(R.id.o7i);
        this.thirdTitleTextView = (TextView) view.findViewById(R.id.o7k);
        this.prePriceTextView = (TextView) view.findViewById(R.id.o7b);
        this.rmbTextView = (TextView) view.findViewById(R.id.o7c);
        this.priceTextView = (TextView) view.findViewById(R.id.o7e);
        this.priceSuffixTextView = (TextView) view.findViewById(R.id.o7d);
        this.secondPriceTextView = (TextView) view.findViewById(R.id.o7h);
        this.stateTextView = (TextView) view.findViewById(R.id.o7j);
        Button button = (Button) view.findViewById(R.id.o6x);
        this.actionButton = button;
        this.coverBottomLayout = (FrameLayout) view.findViewById(R.id.o6z);
        this.explainingAnim = (PAGView) view.findViewById(R.id.f163085o74);
        this.coverBottomTextView = (TextView) view.findViewById(R.id.nuv);
        com.tencent.ecommerce.base.device.a.f100685b.f(a16, view);
        frameLayout.setOnClickListener(new a());
        button.setOnClickListener(new b());
    }

    private final void s(LiveShowItem showItem) {
        LivePicInfo mainCover = showItem.getMainCover();
        if (mainCover != null && mainCover.d()) {
            this.coverForegroundImageView.setVisibility(0);
            Companion companion = INSTANCE;
            IECImageLoader.ImageLoaderOption imageLoaderOption = new IECImageLoader.ImageLoaderOption(companion.a(), companion.a(), 0, null, null, null, false, false, null, w.CTRL_INDEX, null);
            IECImageLoader imageLoader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader();
            Context context = this.context;
            LivePicInfo mainCover2 = showItem.getMainCover();
            String url = mainCover2 != null ? mainCover2.getUrl() : null;
            Intrinsics.checkNotNull(url);
            imageLoader.load(context, url, this.coverForegroundImageView, imageLoaderOption);
            return;
        }
        this.coverForegroundImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A, reason: from getter */
    public final TextView getPrePriceTextView() {
        return this.prePriceTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B, reason: from getter */
    public final TextView getPriceSuffixTextView() {
        return this.priceSuffixTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C, reason: from getter */
    public final TextView getPriceTextView() {
        return this.priceTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D, reason: from getter */
    public final ImageView getReorderButton() {
        return this.reorderButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E, reason: from getter */
    public final TextView getSecondPriceTextView() {
        return this.secondPriceTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H, reason: from getter */
    public final TextView getSecondTitleTextView() {
        return this.secondTitleTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I, reason: from getter */
    public final ImageView getSelectCheckBox() {
        return this.selectCheckBox;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J, reason: from getter */
    public final TextView getThirdTitleTextView() {
        return this.thirdTitleTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0232 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        byte b16;
        String cover;
        int i3;
        int i16;
        LiveProduct.UIStyle uiStyle;
        boolean isBlank;
        LiveShowItem normalShowItem;
        String statusTxt;
        int i17;
        boolean isBlank2;
        this.currentLiveProduct = liveProduct;
        cg0.a.b("ECLiveItemBaseViewHolder", "configItemUI position:" + position + ", payloads:" + payloads + " liveProduct : " + String.valueOf(this.currentLiveProduct));
        TextViewKt.b(this.indexTextView, "fonts/DINNextLTPro-Regular.ttf");
        TextViewKt.b(this.rmbTextView, "fonts/qvideo-digit-Bold.ttf");
        TextViewKt.b(this.priceTextView, "fonts/qvideo-digit-Bold.ttf");
        TextViewKt.b(this.secondPriceTextView, "fonts/qvideo-digit-Bold.ttf");
        Drawable drawable = AppCompatResources.getDrawable(this.context, R.drawable.f159674bj4);
        String cover2 = liveProduct != null ? liveProduct.getCover() : null;
        if (cover2 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(cover2);
            if (!isBlank2) {
                b16 = false;
                if (b16 != true) {
                    this.coverImageView.setImageDrawable(drawable);
                } else if (liveProduct != null && (cover = liveProduct.getCover()) != null) {
                    Companion companion = INSTANCE;
                    QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(this.context, cover, this.coverImageView, new IECImageLoader.ImageLoaderOption(companion.a(), companion.a(), 0, null, drawable, drawable, false, false, null, TroopInfo.PAY_PRIVILEGE_ALL, null));
                }
                if (liveProduct != null || (statusTxt = liveProduct.getStatusTxt()) == null) {
                    i3 = 1;
                } else {
                    if (statusTxt.length() > 0) {
                        i3 = 1;
                        i17 = 1;
                    } else {
                        i3 = 1;
                        i17 = 0;
                    }
                    if (i17 == i3) {
                        i16 = 0;
                        this.stateTextView.setVisibility(0);
                        this.stateTextView.setText(liveProduct.getStatusTxt());
                        this.titleTextView.setText(liveProduct != null ? liveProduct.getTitle() : null);
                        if (liveProduct == null && liveProduct.getIsExplaining() == i3) {
                            this.coverBottomLayout.setVisibility(i16);
                            FrameLayout frameLayout = this.coverBottomLayout;
                            ECSkin eCSkin = ECSkin.INSTANCE;
                            frameLayout.setBackground(eCSkin.getDrawable("qecommerce_qqlive_bg_color"));
                            this.explainingAnim.setVisibility(i16);
                            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSoAsync(new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$configItemUI$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z16) {
                                    if (z16) {
                                        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$configItemUI$2.1
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
                                                PAGView pAGView;
                                                pAGView = ECBaseLiveItemViewHolder.this.explainingAnim;
                                                pAGView.setPath("assets://pag/ecommerce_live_explaining.pag");
                                                pAGView.setRepeatCount(-1);
                                                pAGView.play();
                                            }
                                        });
                                    } else {
                                        cg0.a.a("ECLiveItemBaseViewHolder", "configItemUI", "pag so load failure.");
                                    }
                                }
                            });
                            this.coverBottomTextView.setText(this.context.getResources().getString(R.string.wlv));
                            this.itemRoot.setBackground(new ColorDrawable(eCSkin.getColor(R.color.f6812k)));
                        } else {
                            this.coverBottomLayout.setVisibility(8);
                            this.itemRoot.setBackground(new ColorDrawable(i16));
                            if (liveProduct != null || (uiStyle = liveProduct.getTempUIStyle()) == null) {
                                uiStyle = liveProduct != null ? liveProduct.getUiStyle() : null;
                            }
                            if (uiStyle != null && uiStyle.type == 2) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(uiStyle.uiTitle);
                                if (((isBlank ? 1 : 0) ^ i3) != 0) {
                                    this.coverBottomTextView.setText(uiStyle.uiTitle);
                                    this.coverBottomLayout.setVisibility(i16);
                                    this.coverBottomLayout.setBackground(new ColorDrawable(this.context.getResources().getColor(R.color.f156588od)));
                                    this.explainingAnim.setVisibility(8);
                                    if (position == 0 && liveProduct != null && liveProduct.getIsTop() == i3) {
                                        this.itemRoot.setBackground(new ColorDrawable(this.context.getResources().getColor(R.color.f156584mm)));
                                    }
                                }
                            }
                        }
                        if (liveProduct != null) {
                            u(liveProduct.getPrice(), liveProduct.getOriPrice());
                        }
                        if (liveProduct == null && liveProduct.F() == i3) {
                            LiveShowItem activityShowItem = liveProduct.getActivityShowItem();
                            if (activityShowItem != null) {
                                s(activityShowItem);
                                v(activityShowItem);
                                return;
                            }
                            return;
                        }
                        if (liveProduct == null && liveProduct.E() == i3) {
                            LiveShowItem couponShowItem = liveProduct.getCouponShowItem();
                            if (couponShowItem != null) {
                                s(couponShowItem);
                                v(couponShowItem);
                                return;
                            }
                            return;
                        }
                        if ((liveProduct != null ? liveProduct.getNormalShowItem() : null) == null || liveProduct == null || (normalShowItem = liveProduct.getNormalShowItem()) == null) {
                            return;
                        }
                        s(normalShowItem);
                        v(normalShowItem);
                        return;
                    }
                }
                i16 = 0;
                if (liveProduct == null && liveProduct.getStatus() == i3) {
                    if (liveProduct.I()) {
                        this.stateTextView.setVisibility(0);
                        this.stateTextView.setText("\u5df2\u552e\u7f44");
                    } else {
                        this.stateTextView.setVisibility(8);
                    }
                } else {
                    this.stateTextView.setVisibility(0);
                    this.stateTextView.setText("\u5df2\u5931\u6548");
                }
                this.titleTextView.setText(liveProduct != null ? liveProduct.getTitle() : null);
                if (liveProduct == null) {
                }
                this.coverBottomLayout.setVisibility(8);
                this.itemRoot.setBackground(new ColorDrawable(i16));
                if (liveProduct != null) {
                }
                if (liveProduct != null) {
                }
                if (uiStyle != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(uiStyle.uiTitle);
                    if (((isBlank ? 1 : 0) ^ i3) != 0) {
                    }
                }
                if (liveProduct != null) {
                }
                if (liveProduct == null) {
                }
                if (liveProduct == null) {
                }
                if ((liveProduct != null ? liveProduct.getNormalShowItem() : null) == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        b16 = true;
        if (b16 != true) {
        }
        if (liveProduct != null) {
        }
        i3 = 1;
        i16 = 0;
        if (liveProduct == null) {
        }
        this.stateTextView.setVisibility(0);
        this.stateTextView.setText("\u5df2\u5931\u6548");
        this.titleTextView.setText(liveProduct != null ? liveProduct.getTitle() : null);
        if (liveProduct == null) {
        }
        this.coverBottomLayout.setVisibility(8);
        this.itemRoot.setBackground(new ColorDrawable(i16));
        if (liveProduct != null) {
        }
        if (liveProduct != null) {
        }
        if (uiStyle != null) {
        }
        if (liveProduct != null) {
        }
        if (liveProduct == null) {
        }
        if (liveProduct == null) {
        }
        if ((liveProduct != null ? liveProduct.getNormalShowItem() : null) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(LiveProduct.Price leftPrice, LiveProduct.Price rightPrice) {
        boolean isBlank;
        String str;
        StringBuilder sb5;
        boolean z16;
        String str2;
        boolean z17;
        boolean isBlank2;
        boolean isBlank3;
        List split$default;
        boolean isBlank4;
        isBlank = StringsKt__StringsJVMKt.isBlank(leftPrice.pricesTxt);
        if (!isBlank) {
            String pricesPre = leftPrice.getPricesPre();
            if (pricesPre != null) {
                isBlank4 = StringsKt__StringsJVMKt.isBlank(pricesPre);
                if (!isBlank4) {
                    this.prePriceTextView.setText(leftPrice.getPricesPre());
                    this.prePriceTextView.setVisibility(0);
                    this.priceTextView.setText(leftPrice.pricesTxt);
                    TextView textView = this.priceTextView;
                    textView.setTypeface(textView.getTypeface(), 1);
                    str = leftPrice.pricesTxt;
                    if (str == null && split$default != null && split$default.size() == 2) {
                        this.priceTextView.setText((CharSequence) split$default.get(0));
                        String str3 = (String) split$default.get(1);
                        sb5 = new StringBuilder(".");
                        sb5.append(str3);
                        z16 = true;
                    } else {
                        sb5 = null;
                        z16 = false;
                    }
                    str2 = leftPrice.pricesSuffix;
                    if (str2 != null) {
                        isBlank3 = StringsKt__StringsJVMKt.isBlank(str2);
                        if (!isBlank3) {
                            z17 = false;
                            if (!z17) {
                                if (sb5 == null) {
                                    sb5 = new StringBuilder(" ");
                                    sb5.append(leftPrice.pricesSuffix);
                                } else {
                                    Intrinsics.checkNotNull(sb5);
                                    sb5.append(" ");
                                    sb5.append(leftPrice.pricesSuffix);
                                }
                                z16 = true;
                            }
                            if (z16) {
                                this.priceSuffixTextView.setText(sb5 != null ? sb5.toString() : null);
                                this.priceSuffixTextView.setVisibility(0);
                            } else {
                                this.priceSuffixTextView.setVisibility(8);
                            }
                            if (leftPrice.priceNum < rightPrice.priceNum) {
                                isBlank2 = StringsKt__StringsJVMKt.isBlank(rightPrice.pricesTxt);
                                if (!isBlank2) {
                                    this.secondPriceTextView.setVisibility(0);
                                    this.secondPriceTextView.setText('\u00a5' + rightPrice.pricesTxt);
                                    TextView textView2 = this.secondPriceTextView;
                                    textView2.setPaintFlags(textView2.getPaintFlags() | 16);
                                    this.secondPriceTextView.setVisibility(0);
                                    return;
                                }
                            }
                            this.secondPriceTextView.setVisibility(8);
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                    if (z16) {
                    }
                    if (leftPrice.priceNum < rightPrice.priceNum) {
                    }
                    this.secondPriceTextView.setVisibility(8);
                }
            }
            this.prePriceTextView.setVisibility(8);
            this.priceTextView.setText(leftPrice.pricesTxt);
            TextView textView3 = this.priceTextView;
            textView3.setTypeface(textView3.getTypeface(), 1);
            str = leftPrice.pricesTxt;
            if (str == null) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            }
            sb5 = null;
            z16 = false;
            str2 = leftPrice.pricesSuffix;
            if (str2 != null) {
            }
            z17 = true;
            if (!z17) {
            }
            if (z16) {
            }
            if (leftPrice.priceNum < rightPrice.priceNum) {
            }
            this.secondPriceTextView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w, reason: from getter */
    public final Button getActionButton() {
        return this.actionButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x, reason: from getter */
    public final LiveProduct getCurrentLiveProduct() {
        return this.currentLiveProduct;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: y, reason: from getter */
    public final TextView getIndexTextView() {
        return this.indexTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z, reason: from getter */
    public final FrameLayout getItemRoot() {
        return this.itemRoot;
    }

    private final void v(LiveShowItem showItem) {
        LivePicInfo titleIcon = showItem.getTitleIcon();
        if (titleIcon != null && titleIcon.d()) {
            LivePicInfo titleIcon2 = showItem.getTitleIcon();
            if (titleIcon2 != null) {
                final int b16 = INSTANCE.b();
                final int width = (int) ((titleIcon2.getWidth() / titleIcon2.getHeight()) * r2.b());
                QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().fetchDrawable(this.context, titleIcon2.getUrl(), new IECImageLoader.ImageLoaderOption(width, b16, 0, null, null, null, false, false, null, w.CTRL_INDEX, null), new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder$configTitleLeftIcon$$inlined$run$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                        invoke2(drawable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Drawable drawable) {
                        TextView textView;
                        TextView textView2;
                        if (drawable != null) {
                            drawable.setBounds(0, 0, width, b16);
                            textView = this.titleTextView;
                            textView.setCompoundDrawablePadding(ECBaseLiveItemViewHolder.INSTANCE.c());
                            textView2 = this.titleTextView;
                            textView2.setCompoundDrawables(drawable, null, null, null);
                        }
                    }
                });
                return;
            }
            return;
        }
        this.titleTextView.setCompoundDrawables(null, null, null, null);
    }
}
