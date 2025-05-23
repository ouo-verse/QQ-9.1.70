package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002:\bB\u001d\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b8\u00109J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010%\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010)\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010+\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0014\u0010-\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010$R\u0014\u0010/\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010$R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wink/view/MenuLayout;", "Landroid/widget/LinearLayout;", "Landroid/graphics/Matrix;", "matrix", "", HippyTKDListViewAdapter.X, "y", "Landroid/graphics/PointF;", "b", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/view/MenuLayout$a;", "Lkotlin/collections/ArrayList;", "menuItems", "", "setMenuItems", "Lcom/tencent/mobileqq/wink/view/MenuLayout$b;", "popupMenuClickListener", "setPopupMenuClickListener", "Landroid/view/View;", "borderView", "", "width", "height", "d", "Landroid/view/View;", "menuLayout", "e", "Landroid/widget/LinearLayout;", "menuItemContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "arrowUp", tl.h.F, "arrowDown", "i", "I", "menuItemWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "menuItemHeight", BdhLogUtil.LogTag.Tag_Conn, "menuLayoutHeight", "D", "dashboardMenuHeight", "E", "arrowHeight", UserInfo.SEX_FEMALE, "arrowMargin", "G", "menuLayoutHalfWidth", "H", "Ljava/util/ArrayList;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MenuLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int menuLayoutHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private final int dashboardMenuHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private final int arrowHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private final int arrowMargin;

    /* renamed from: G, reason: from kotlin metadata */
    private int menuLayoutHalfWidth;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<MenuItem> menuItems;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View menuLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout menuItemContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView arrowUp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView arrowDown;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int menuItemWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int menuItemHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/view/MenuLayout$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getId", "()I", "id", "b", "nameResId", "c", "iconResId", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.view.MenuLayout$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class MenuItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int nameResId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int iconResId;

        /* renamed from: a, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
        }

        /* renamed from: b, reason: from getter */
        public final int getNameResId() {
            return this.nameResId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuItem)) {
                return false;
            }
            MenuItem menuItem = (MenuItem) other;
            if (this.id == menuItem.id && this.nameResId == menuItem.nameResId && this.iconResId == menuItem.iconResId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.id * 31) + this.nameResId) * 31) + this.iconResId;
        }

        @NotNull
        public String toString() {
            return "MenuItem(id=" + this.id + ", nameResId=" + this.nameResId + ", iconResId=" + this.iconResId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/view/MenuLayout$b;", "", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MenuLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final PointF b(Matrix matrix, float x16, float y16) {
        float[] fArr = {x16, y16};
        matrix.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MenuLayout this$0, MenuItem menuItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        this$0.getClass();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(@NotNull View borderView, int width, int height) {
        ArrayList arrayListOf;
        Comparator compareBy;
        List sortedWith;
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(borderView, "borderView");
        if (this.menuItems.size() == 0) {
            return;
        }
        Matrix matrix = new Matrix();
        float rotation = borderView.getRotation();
        int i3 = borderView.getLayoutParams().width;
        int i16 = borderView.getLayoutParams().height;
        matrix.setRotate(-rotation, borderView.getX() + (i3 / 2), borderView.getY() + (i16 / 2));
        float f18 = i3;
        float f19 = i16;
        int i17 = 1;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(b(matrix, borderView.getX(), borderView.getY()), b(matrix, borderView.getX() + f18, borderView.getY()), b(matrix, borderView.getX(), borderView.getY() + f19), b(matrix, borderView.getX() + f18, borderView.getY() + f19));
        compareBy = ComparisonsKt__ComparisonsKt.compareBy(new MutablePropertyReference1Impl() { // from class: com.tencent.mobileqq.wink.view.MenuLayout$updateMenuPosition$pointListSorted$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Float.valueOf(((PointF) obj).x);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(@Nullable Object obj, @Nullable Object obj2) {
                ((PointF) obj).x = ((Number) obj2).floatValue();
            }
        }, new MutablePropertyReference1Impl() { // from class: com.tencent.mobileqq.wink.view.MenuLayout$updateMenuPosition$pointListSorted$2
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Float.valueOf(((PointF) obj).y);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(@Nullable Object obj, @Nullable Object obj2) {
                ((PointF) obj).y = ((Number) obj2).floatValue();
            }
        });
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayListOf, compareBy);
        if (((PointF) sortedWith.get(0)).y < ((PointF) sortedWith.get(1)).y) {
            i17 = 0;
        }
        int i18 = 1 - i17;
        int i19 = i17 + 2;
        float f26 = 2;
        float f27 = (((PointF) sortedWith.get(i17)).x + ((PointF) sortedWith.get(i19)).x) / f26;
        float f28 = (((PointF) sortedWith.get(i17)).y + ((PointF) sortedWith.get(i19)).y) / f26;
        float f29 = ((PointF) sortedWith.get(i18)).x;
        int i26 = i18 + 2;
        float f36 = ((PointF) sortedWith.get(i26)).x;
        float f37 = (((PointF) sortedWith.get(i18)).y + ((PointF) sortedWith.get(i26)).y) / f26;
        int i27 = this.menuLayoutHalfWidth;
        if (f27 >= i27 && i27 + f27 <= width) {
            f16 = f27 - i27;
        } else {
            float f38 = width;
            if (f27 + i27 > f38) {
                f16 = f38 - (i27 * f26);
            } else {
                f16 = 0.0f;
            }
        }
        if (f28 >= this.menuLayoutHeight) {
            this.arrowUp.setVisibility(4);
            this.arrowDown.setVisibility(0);
            f17 = (f28 - this.menuLayoutHeight) - this.arrowMargin;
        } else {
            this.arrowUp.setVisibility(0);
            this.arrowDown.setVisibility(4);
            int i28 = this.arrowMargin;
            int i29 = this.menuLayoutHeight;
            if (i28 + f37 + i29 > height) {
                f17 = (height - i28) - i29;
            } else {
                f17 = f37 + i28;
            }
        }
        setX(f16);
        setY(f17);
    }

    public final void setMenuItems(@NotNull ArrayList<MenuItem> menuItems) {
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        this.menuItemContainer.removeAllViews();
        this.menuItems = menuItems;
        for (final MenuItem menuItem : menuItems) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hew, (ViewGroup) this.menuItemContainer, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.xd6);
            ((TextView) inflate.findViewById(R.id.zly)).setText(menuItem.getNameResId());
            imageView.setImageResource(menuItem.getIconResId());
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MenuLayout.c(MenuLayout.this, menuItem, view);
                }
            });
            this.menuItemContainer.addView(inflate, this.menuItemWidth, this.menuItemHeight);
        }
        this.menuLayoutHalfWidth = (menuItems.size() * this.menuItemWidth) / 2;
    }

    public final void setPopupMenuClickListener(@NotNull b popupMenuClickListener) {
        Intrinsics.checkNotNullParameter(popupMenuClickListener, "popupMenuClickListener");
    }

    public /* synthetic */ MenuLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.menuItems = new ArrayList<>();
        View inflate = LayoutInflater.from(context).inflate(R.layout.hev, (ViewGroup) this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026_popup_menu, this, false)");
        this.menuLayout = inflate;
        addView(inflate, new FrameLayout.LayoutParams(-2, -2));
        View findViewById = inflate.findViewById(R.id.z3c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "menuLayout.findViewById(R.id.menuItemContainer)");
        this.menuItemContainer = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.svt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "menuLayout.findViewById(R.id.arrowUp)");
        this.arrowUp = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.svp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "menuLayout.findViewById(R.id.arrowDown)");
        this.arrowDown = (ImageView) findViewById3;
        this.menuItemWidth = getResources().getDimensionPixelSize(R.dimen.djp);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.djo);
        this.menuItemHeight = dimensionPixelSize;
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.djl);
        this.arrowHeight = dimensionPixelSize2;
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.djm);
        this.arrowMargin = dimensionPixelSize3;
        this.dashboardMenuHeight = getResources().getDimensionPixelSize(R.dimen.f159626dj1);
        this.menuLayoutHeight = dimensionPixelSize + dimensionPixelSize2 + dimensionPixelSize3;
    }
}
