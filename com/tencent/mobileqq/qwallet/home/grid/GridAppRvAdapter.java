package com.tencent.mobileqq.qwallet.home.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.grid.GridAppRvAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/GridAppRvAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "", "layoutId", "Landroid/view/View;", "i0", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "onViewAttachedToWindow", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "twoLineTitleMode", BdhLogUtil.LogTag.Tag_Conn, "isV2", "<init>", "(ZZ)V", "D", "b", "NormalAppViewHolder", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class GridAppRvAdapter extends ListAdapter<QWalletHomePage$AppInfo, RecyclerView.ViewHolder> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final a E = new a();

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isV2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean twoLineTitleMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001b\u0010!\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/GridAppRvAdapter$NormalAppViewHolder;", "Lcom/tencent/mobileqq/qwallet/home/grid/GridAppViewHolder;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "appInfo", "", "p", "", "n0", "Landroid/widget/ImageView;", "l0", "G", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "g0", UserInfo.SEX_FEMALE, "", "I", "Z", "twoLineTitleMode", "J", "isV2", "K", "Landroid/widget/ImageView;", "redPoint", "L", "Landroid/widget/TextView;", "textMarket", "M", "market", "N", "Lkotlin/Lazy;", "v", "()I", "itemHolderSize", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;ZZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    @SuppressLint({"SetTextI18n"})
    /* loaded from: classes16.dex */
    public static final class NormalAppViewHolder extends GridAppViewHolder {

        /* renamed from: I, reason: from kotlin metadata */
        private final boolean twoLineTitleMode;

        /* renamed from: J, reason: from kotlin metadata */
        private final boolean isV2;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final ImageView redPoint;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final TextView textMarket;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final ImageView market;

        /* renamed from: N, reason: from kotlin metadata */
        @NotNull
        private final Lazy itemHolderSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalAppViewHolder(@NotNull final View view, boolean z16, boolean z17) {
            super(view);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(view, "view");
            this.twoLineTitleMode = z16;
            this.isV2 = z17;
            View findViewById = view.findViewById(R.id.f164395su4);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.app_red_point)");
            this.redPoint = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.su7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.app_text_tag)");
            this.textMarket = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.su6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.app_tag)");
            this.market = (ImageView) findViewById3;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.qwallet.home.grid.GridAppRvAdapter$NormalAppViewHolder$itemHolderSize$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    boolean z18;
                    boolean z19;
                    GridAppRvAdapter.Companion companion = GridAppRvAdapter.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "view.context");
                    z18 = this.twoLineTitleMode;
                    z19 = this.isV2;
                    return Integer.valueOf(companion.a(context, z18, z19));
                }
            });
            this.itemHolderSize = lazy;
            view.getLayoutParams().height = v();
            ol2.b.f(view, 0, false, 6, null);
            View findViewById4 = view.findViewById(R.id.f164379vi);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.app_icon)");
            r((ImageView) findViewById4);
            ol2.b.f(m(), 0, false, 6, null);
            View findViewById5 = view.findViewById(R.id.su8);
            TextView textView = (TextView) findViewById5;
            ol2.b.f(textView, 0, false, 6, null);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById<TextVi\u2026tMode(this)\n            }");
            s(textView);
        }

        private final int v() {
            return ((Number) this.itemHolderSize.getValue()).intValue();
        }

        @Override // com.tencent.mobileqq.qwallet.home.am.b
        @NotNull
        /* renamed from: F, reason: from getter */
        public ImageView getMarket() {
            return this.market;
        }

        @Override // com.tencent.mobileqq.qwallet.home.am.b
        @NotNull
        /* renamed from: G, reason: from getter */
        public ImageView getRedPoint() {
            return this.redPoint;
        }

        @Override // com.tencent.mobileqq.qwallet.home.am.b
        @NotNull
        public ImageView S() {
            return this.redPoint;
        }

        @Override // com.tencent.mobileqq.qwallet.home.am.b
        @NotNull
        /* renamed from: g0, reason: from getter */
        public TextView getTextMarket() {
            return this.textMarket;
        }

        @Override // com.tencent.mobileqq.qwallet.home.am.b
        @NotNull
        /* renamed from: l0 */
        public ImageView getImgRes() {
            return m();
        }

        @Override // com.tencent.mobileqq.qwallet.home.am.b
        public int n0() {
            return 2;
        }

        @Override // com.tencent.mobileqq.qwallet.home.grid.GridAppViewHolder
        public void p(@NotNull QWalletHomePage$AppInfo appInfo) {
            Intrinsics.checkNotNullParameter(appInfo, "appInfo");
            super.p(appInfo);
            TextView titleView = getTitleView();
            String obj = titleView.getText().toString();
            if (this.twoLineTitleMode && obj.length() > 4) {
                titleView.setMaxLines(2);
                String substring = obj.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring2 = obj.substring(3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                titleView.setText(substring + "\n" + substring2);
                return;
            }
            titleView.setMaxLines(1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/home/grid/GridAppRvAdapter$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "oldItem", "newItem", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends DiffUtil.ItemCallback<QWalletHomePage$AppInfo> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull QWalletHomePage$AppInfo oldItem, @NotNull QWalletHomePage$AppInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return c4.a.j(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull QWalletHomePage$AppInfo oldItem, @NotNull QWalletHomePage$AppInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return c4.a.n(oldItem, newItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/GridAppRvAdapter$b;", "", "Landroid/content/Context;", "context", "", "supportTwoLineTitle", "isV2", "", "a", "", "APP_VIEW_TAG_VALUE", "Ljava/lang/String;", "com/tencent/mobileqq/qwallet/home/grid/GridAppRvAdapter$a", "ITEM_CALLBACK", "Lcom/tencent/mobileqq/qwallet/home/grid/GridAppRvAdapter$a;", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.grid.GridAppRvAdapter$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ int b(Companion companion, Context context, boolean z16, boolean z17, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            if ((i3 & 4) != 0) {
                z17 = false;
            }
            return companion.a(context, z16, z17);
        }

        public final int a(@NotNull Context context, boolean supportTwoLineTitle, boolean isV2) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!isV2) {
                if (supportTwoLineTitle) {
                    return context.getResources().getDimensionPixelSize(R.dimen.cbn);
                }
                return context.getResources().getDimensionPixelSize(R.dimen.cbm);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.cbp);
        }

        Companion() {
        }
    }

    public GridAppRvAdapter(boolean z16, boolean z17) {
        super(E);
        this.twoLineTitleMode = z16;
        this.isV2 = z17;
    }

    private final View i0(ViewGroup viewGroup, @LayoutRes int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        inflate.setTag("app_view_tag_value");
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(la\u2026_VIEW_TAG_VALUE\n        }");
        return inflate;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof GridAppViewHolder) {
            QWalletHomePage$AppInfo item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            ((GridAppViewHolder) holder).p(item);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        int i3;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.isV2) {
            i3 = R.layout.hjb;
        } else {
            i3 = R.layout.hja;
        }
        return new NormalAppViewHolder(i0(parent, i3), this.twoLineTitleMode, this.isV2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        GridAppViewHolder gridAppViewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof GridAppViewHolder) {
            gridAppViewHolder = (GridAppViewHolder) holder;
        } else {
            gridAppViewHolder = null;
        }
        if (gridAppViewHolder != null) {
            gridAppViewHolder.onViewAttachedToWindow();
        }
    }

    public /* synthetic */ GridAppRvAdapter(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? false : z17);
    }
}
