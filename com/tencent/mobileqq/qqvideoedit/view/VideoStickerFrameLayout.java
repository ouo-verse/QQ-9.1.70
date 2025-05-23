package com.tencent.mobileqq.qqvideoedit.view;

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
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00029\rB'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u001f\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0014\u0010,\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "stickerModel", "", "e", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$b;", "popupMenuClickListener", "setPopupMenuClickListener", "", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$a;", "menuItems", "c", "b", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameView;", "d", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameView;", "frameView", "Landroid/view/View;", "Landroid/view/View;", "menuLayout", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "menuItemContainer", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "arrowUp", "i", "arrowDown", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "menuItemWidth", BdhLogUtil.LogTag.Tag_Conn, "menuItemHeight", "Lcom/tencent/mobileqq/activity/richmedia/i;", "D", "Lcom/tencent/mobileqq/activity/richmedia/i;", AdParam.SCREENSIZE, "E", "menuLayoutHalfWidth", UserInfo.SEX_FEMALE, "menuLayoutHeight", "G", "Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$b;", "menuClickListener", "H", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoStickerFrameLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int menuItemHeight;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final i screenSize;

    /* renamed from: E, reason: from kotlin metadata */
    private int menuLayoutHalfWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private final int menuLayoutHeight;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private b menuClickListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private VideoStickerModel stickerModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoStickerFrameView frameView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View menuLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout menuItemContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView arrowUp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView arrowDown;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int menuItemWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "id", "c", "nameResId", "iconResId", "<init>", "(III)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.view.VideoStickerFrameLayout$a, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class MenuItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int nameResId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int iconResId;

        public MenuItem(int i3, int i16, int i17) {
            this.id = i3;
            this.nameResId = i16;
            this.iconResId = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
        }

        /* renamed from: b, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: c, reason: from getter */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/view/VideoStickerFrameLayout$b;", "", "", "id", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "stickerModel", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(int id5, @Nullable VideoStickerModel stickerModel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoStickerFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(VideoStickerFrameLayout this$0, MenuItem menuItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        b bVar = this$0.menuClickListener;
        if (bVar != null) {
            bVar.a(menuItem.getId(), this$0.stickerModel);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e(VideoStickerModel stickerModel) {
        float f16;
        if (stickerModel == null) {
            return;
        }
        this.stickerModel = stickerModel;
        Matrix matrix = new Matrix();
        matrix.setRotate(-stickerModel.rotate, stickerModel.getCenterInView().f275793x, stickerModel.getCenterInView().f275794y);
        com.tencent.mobileqq.qqvideoedit.utils.i iVar = com.tencent.mobileqq.qqvideoedit.utils.i.f276251a;
        PointF h16 = iVar.h(matrix, stickerModel.getLeftTopInView().f275793x, stickerModel.getLeftTopInView().f275794y);
        PointF h17 = iVar.h(matrix, stickerModel.getRightBottomInView().f275793x, stickerModel.getLeftTopInView().f275794y);
        PointF h18 = iVar.h(matrix, stickerModel.getLeftTopInView().f275793x, stickerModel.getRightBottomInView().f275794y);
        PointF h19 = iVar.h(matrix, stickerModel.getRightBottomInView().f275793x, stickerModel.getRightBottomInView().f275794y);
        float f17 = 2;
        float f18 = (h16.x + h17.x) / f17;
        float f19 = (h16.y + h17.y) / f17;
        float f26 = h18.x;
        float f27 = h19.x;
        float f28 = (h18.y + h19.y) / f17;
        int i3 = this.menuLayoutHalfWidth;
        if (f18 >= i3) {
            f16 = f18 - i3;
            float f29 = i3 + f16;
            int i16 = this.screenSize.f185860a;
            if (f29 > i16) {
                f16 = i16 - i3;
            }
        } else {
            f16 = i3;
        }
        int i17 = this.menuLayoutHeight;
        if (f19 >= i17) {
            f28 = f19 - i17;
            this.arrowUp.setVisibility(4);
            this.arrowDown.setVisibility(0);
        } else {
            this.arrowUp.setVisibility(0);
            this.arrowDown.setVisibility(4);
        }
        this.menuLayout.setX(f16);
        this.menuLayout.setY(f28);
    }

    public final void b() {
        if (getVisibility() != 4) {
            setVisibility(4);
        }
    }

    public final void c(@NotNull List<MenuItem> menuItems) {
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        this.menuItemContainer.removeAllViews();
        for (final MenuItem menuItem : menuItems) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h1u, (ViewGroup) this.menuItemContainer, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.xd6);
            ((TextView) inflate.findViewById(R.id.zly)).setText(menuItem.getNameResId());
            imageView.setImageResource(menuItem.getIconResId());
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoStickerFrameLayout.d(VideoStickerFrameLayout.this, menuItem, view);
                }
            });
            this.menuItemContainer.addView(inflate, this.menuItemWidth, this.menuItemHeight);
        }
        this.menuLayoutHalfWidth = (menuItems.size() * this.menuItemWidth) / 2;
        e(this.stickerModel);
    }

    public final void setPopupMenuClickListener(@NotNull b popupMenuClickListener) {
        Intrinsics.checkNotNullParameter(popupMenuClickListener, "popupMenuClickListener");
        this.menuClickListener = popupMenuClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoStickerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoStickerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(4);
        i f16 = x.f(context);
        Intrinsics.checkNotNullExpressionValue(f16, "getScreenSize(context)");
        this.screenSize = f16;
        VideoStickerFrameView videoStickerFrameView = new VideoStickerFrameView(context);
        this.frameView = videoStickerFrameView;
        addView(videoStickerFrameView, new FrameLayout.LayoutParams(-1, -1));
        View inflate = LayoutInflater.from(context).inflate(R.layout.h1t, (ViewGroup) this, false);
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
        this.menuItemWidth = getResources().getDimensionPixelSize(R.dimen.dit);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dis);
        this.menuItemHeight = dimensionPixelSize;
        this.menuLayoutHeight = dimensionPixelSize + ((getResources().getDimensionPixelSize(R.dimen.dip) + getResources().getDimensionPixelSize(R.dimen.diq)) * 2);
    }

    public /* synthetic */ VideoStickerFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
