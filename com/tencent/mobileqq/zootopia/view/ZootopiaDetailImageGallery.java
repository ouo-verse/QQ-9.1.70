package com.tencent.mobileqq.zootopia.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailImageGallery;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cooperation.qzone.QZoneTopGestureLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0004CDEFB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u001b\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010\rR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00101R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00103R.\u0010;\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery;", "Landroidx/recyclerview/widget/RecyclerView;", "", "style", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$d;", UserInfo.SEX_FEMALE, "Landroid/view/MotionEvent;", "ev", "", "G", "", "dx", "dy", "I", "", "isIntercept", "D", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "H", "mapId", "", "mapName", BdhLogUtil.LogTag.Tag_Conn, "L", "", "imageList", "K", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "E", "f", "Ljava/util/List;", tl.h.F, "scaledTouchSlop", "", "i", "B", "slideDir", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "downX", "downY", "Lcom/tencent/mobileqq/zootopia/view/ab;", "Lcom/tencent/mobileqq/zootopia/view/ab;", "itemDecoration", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Landroid/view/View$OnClickListener;", "value", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "clickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailImageGallery extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    private int downX;

    /* renamed from: D, reason: from kotlin metadata */
    private int downY;

    /* renamed from: E, reason: from kotlin metadata */
    private ab itemDecoration;

    /* renamed from: F, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.portal.detail.ah reportHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: H, reason: from kotlin metadata */
    private View.OnClickListener clickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<String> imageList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int scaledTouchSlop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private byte slideDir;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "imageView", "<init>", "(Landroid/widget/FrameLayout;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final FrameLayout container;

        /* renamed from: F, reason: from kotlin metadata */
        private ImageView imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrameLayout container) {
            super(container);
            Intrinsics.checkNotNullParameter(container, "container");
            this.container = container;
            View findViewById = container.findViewById(R.id.r0t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "container.findViewById(R\u2026topia_gallery_image_view)");
            this.imageView = (ImageView) findViewById;
        }

        public final FrameLayout getContainer() {
            return this.container;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", tl.h.F, "()I", "width", "b", "c", "height", "e", "radius", "d", "margin", "decorationGap", "", "f", UserInfo.SEX_FEMALE, "()F", BasicAnimation.KeyPath.ROTATION, "g", "style", "bigGalleryStyle", "<init>", "(IIIIIFII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.view.ZootopiaDetailImageGallery$d, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class GalleryItemSize {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int radius;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int margin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int decorationGap;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final float rotation;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int style;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bigGalleryStyle;

        public GalleryItemSize() {
            this(0, 0, 0, 0, 0, 0.0f, 0, 0, 255, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getBigGalleryStyle() {
            return this.bigGalleryStyle;
        }

        /* renamed from: b, reason: from getter */
        public final int getDecorationGap() {
            return this.decorationGap;
        }

        /* renamed from: c, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: d, reason: from getter */
        public final int getMargin() {
            return this.margin;
        }

        /* renamed from: e, reason: from getter */
        public final int getRadius() {
            return this.radius;
        }

        /* renamed from: f, reason: from getter */
        public final float getRotation() {
            return this.rotation;
        }

        /* renamed from: g, reason: from getter */
        public final int getStyle() {
            return this.style;
        }

        /* renamed from: h, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((((((((((((this.width * 31) + this.height) * 31) + this.radius) * 31) + this.margin) * 31) + this.decorationGap) * 31) + Float.floatToIntBits(this.rotation)) * 31) + this.style) * 31) + this.bigGalleryStyle;
        }

        public String toString() {
            return "GalleryItemSize(width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", margin=" + this.margin + ", decorationGap=" + this.decorationGap + ", rotation=" + this.rotation + ", style=" + this.style + ", bigGalleryStyle=" + this.bigGalleryStyle + ")";
        }

        public GalleryItemSize(int i3, int i16, int i17, int i18, int i19, float f16, int i26, int i27) {
            this.width = i3;
            this.height = i16;
            this.radius = i17;
            this.margin = i18;
            this.decorationGap = i19;
            this.rotation = f16;
            this.style = i26;
            this.bigGalleryStyle = i27;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GalleryItemSize)) {
                return false;
            }
            GalleryItemSize galleryItemSize = (GalleryItemSize) other;
            return this.width == galleryItemSize.width && this.height == galleryItemSize.height && this.radius == galleryItemSize.radius && this.margin == galleryItemSize.margin && this.decorationGap == galleryItemSize.decorationGap && Float.compare(this.rotation, galleryItemSize.rotation) == 0 && this.style == galleryItemSize.style && this.bigGalleryStyle == galleryItemSize.bigGalleryStyle;
        }

        public /* synthetic */ GalleryItemSize(int i3, int i16, int i17, int i18, int i19, float f16, int i26, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
            this((i28 & 1) != 0 ? 0 : i3, (i28 & 2) != 0 ? 0 : i16, (i28 & 4) != 0 ? 0 : i17, (i28 & 8) != 0 ? 0 : i18, (i28 & 16) != 0 ? 0 : i19, (i28 & 32) != 0 ? 0.0f : f16, (i28 & 64) != 0 ? 0 : i26, (i28 & 128) == 0 ? i27 : 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailImageGallery(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void D(boolean isIntercept) {
        TopGestureLayout E = E();
        if (E != null) {
            E.requestDisallowInterceptTouchEvent(isIntercept);
        }
    }

    private final void G(MotionEvent ev5) {
        int rawX = (int) ev5.getRawX();
        int rawY = (int) ev5.getRawY();
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.slideDir == 0) {
                        I(Math.abs(rawX - this.downX), Math.abs(rawY - this.downY));
                    }
                    if (this.slideDir == 1) {
                        D(true);
                        return;
                    }
                    return;
                }
                if (action != 3) {
                    return;
                }
            }
            this.slideDir = (byte) 0;
            D(false);
            TopGestureLayout E = E();
            if (E != null) {
                E.setIsInterceptChildEventWhenScroll(true);
            }
            QZoneTopGestureLayout.shouldInterceptEvent(true);
            return;
        }
        this.downX = rawX;
        this.downY = rawY;
        TopGestureLayout E2 = E();
        if (E2 != null) {
            E2.setIsInterceptChildEventWhenScroll(false);
        }
        QZoneTopGestureLayout.shouldInterceptEvent(false);
    }

    private final void I(float dx5, float dy5) {
        int i3 = this.scaledTouchSlop;
        if (dx5 > i3 || dy5 > i3) {
            this.slideDir = (dx5 <= ((float) i3) || dy5 / dx5 >= 0.6f) ? (byte) 2 : (byte) 1;
        }
    }

    public final void C(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        com.tencent.mobileqq.zootopia.portal.detail.ah.f(this.reportHelper, this, mapId, mapName, this.source, null, 16, null);
    }

    public final TopGestureLayout E() {
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        KeyEvent.Callback callback = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            callback = viewGroup.getChildAt(i3);
            boolean z16 = callback instanceof DragFrameLayout;
            if (z16) {
                DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) callback : null;
                callback = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
            }
            if (callback instanceof TopGestureLayout) {
                break;
            }
        }
        TopGestureLayout topGestureLayout2 = callback instanceof TopGestureLayout ? (TopGestureLayout) callback : null;
        this.topGestureLayout = topGestureLayout2;
        return topGestureLayout2;
    }

    public final void H(ZootopiaSource source) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setAdapter(new c(context));
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.source = source;
    }

    public final void K(List<String> imageList) {
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        this.imageList = imageList;
        RecyclerView.Adapter adapter = getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar != null) {
            cVar.t0(imageList);
        }
    }

    public final void L(int style) {
        GalleryItemSize F = F(style);
        RecyclerView.Adapter adapter = getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar != null) {
            cVar.s0(F);
        }
        RecyclerView.ItemDecoration itemDecoration = this.itemDecoration;
        if (itemDecoration != null) {
            removeItemDecoration(itemDecoration);
        }
        ab abVar = new ab(F.getDecorationGap(), F.getMargin());
        this.itemDecoration = abVar;
        addItemDecoration(abVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        G(ev5);
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        G(ev5);
        return super.onTouchEvent(ev5);
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
        RecyclerView.Adapter adapter = getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar == null) {
            return;
        }
        cVar.r0(this.clickListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailImageGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$b;", "Landroid/view/View$OnClickListener;", "", "style", "l0", "", "", "imageList", "", "t0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "holder", "position", "m0", "getItemCount", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$d;", "E", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$d;", "getGalleryItemSize", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$d;", "s0", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDetailImageGallery$d;)V", "galleryItemSize", UserInfo.SEX_FEMALE, "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "r0", "(Landroid/view/View$OnClickListener;)V", "clickListener", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "G", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.Adapter<b> implements View.OnClickListener {

        /* renamed from: C, reason: from kotlin metadata */
        private List<String> imageList;

        /* renamed from: D, reason: from kotlin metadata */
        private RecyclerView recyclerView;

        /* renamed from: E, reason: from kotlin metadata */
        private GalleryItemSize galleryItemSize;

        /* renamed from: F, reason: from kotlin metadata */
        private View.OnClickListener clickListener;

        /* renamed from: G, reason: from kotlin metadata */
        private final com.tencent.mobileqq.zootopia.portal.detail.ah reportHelper;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final Context context;

        public c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.galleryItemSize = new GalleryItemSize(0, 0, 0, 0, 0, 0.0f, 0, 0, 255, null);
            this.reportHelper = new com.tencent.mobileqq.zootopia.portal.detail.ah(context);
        }

        private final int l0(int style) {
            if (style != 1) {
                if (style != 2) {
                    return R.drawable.ik8;
                }
                return R.drawable.ikb;
            }
            return R.drawable.ika;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n0(ImageView this_apply, b holder) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            this_apply.setLayoutParams(new FrameLayout.LayoutParams(holder.getContainer().getMeasuredWidth(), holder.getContainer().getMeasuredHeight()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o0(b holder, ImageView this_apply, c this$0) {
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int measuredWidth = holder.getContainer().getMeasuredWidth();
            this_apply.setLayoutParams(new FrameLayout.LayoutParams(holder.getContainer().getMeasuredHeight(), measuredWidth));
            float f16 = measuredWidth / 2.0f;
            this_apply.setPivotX(f16);
            this_apply.setPivotY(f16);
            this_apply.setRotation(this$0.galleryItemSize.getRotation());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p0(c this$0, b holder, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            this$0.reportHelper.j("imp", holder.getContainer(), i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.imageList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(final b holder, final int position) {
            Object orNull;
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<String> list = this.imageList;
            if (list != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, position);
                String str = (String) orNull;
                if (str == null) {
                    return;
                }
                final ImageView imageView = holder.getImageView();
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(l0(this.galleryItemSize.getStyle()));
                    imageView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZootopiaDetailImageGallery.c.n0(imageView, holder);
                        }
                    });
                } else {
                    com.tencent.sqshow.zootopia.utils.ae.INSTANCE.a(imageView, str, com.tencent.sqshow.zootopia.utils.q.b(l0(this.galleryItemSize.getStyle())), 0);
                    if (!(this.galleryItemSize.getRotation() == 0.0f)) {
                        if (!(imageView.getRotation() == this.galleryItemSize.getRotation())) {
                            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ZootopiaDetailImageGallery.c.o0(ZootopiaDetailImageGallery.b.this, imageView, this);
                                }
                            });
                        }
                    }
                }
                holder.getContainer().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaDetailImageGallery.c.p0(ZootopiaDetailImageGallery.c.this, holder, position);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onAttachedToRecyclerView(recyclerView);
            this.recyclerView = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int viewType) {
            FrameLayout.LayoutParams layoutParams;
            Intrinsics.checkNotNullParameter(parent, "parent");
            RoundImageView roundImageView = new RoundImageView(this.context);
            roundImageView.setId(R.id.r0t);
            roundImageView.setmRadius(this.galleryItemSize.getRadius(), false);
            if (this.galleryItemSize.getRotation() == 0.0f) {
                layoutParams = new FrameLayout.LayoutParams(this.galleryItemSize.getWidth(), this.galleryItemSize.getHeight());
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.galleryItemSize.getWidth(), this.galleryItemSize.getWidth());
            }
            roundImageView.setLayoutParams(layoutParams);
            roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout frameLayout = new FrameLayout(this.context);
            frameLayout.addView(roundImageView);
            frameLayout.setId(R.id.r0u);
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(this.galleryItemSize.getWidth(), this.galleryItemSize.getHeight()));
            if (this.galleryItemSize.getBigGalleryStyle() != 0) {
                frameLayout.setOnClickListener(this);
            } else {
                View.OnClickListener onClickListener = this.clickListener;
                if (onClickListener != null) {
                    frameLayout.setOnClickListener(onClickListener);
                }
            }
            com.tencent.mobileqq.zootopia.portal.detail.ah.c(this.reportHelper, frameLayout, false, false, 6, null);
            return new b(frameLayout);
        }

        public final void r0(View.OnClickListener onClickListener) {
            this.clickListener = onClickListener;
        }

        public final void s0(GalleryItemSize galleryItemSize) {
            Intrinsics.checkNotNullParameter(galleryItemSize, "<set-?>");
            this.galleryItemSize = galleryItemSize;
        }

        public final void t0(List<String> imageList) {
            Intrinsics.checkNotNullParameter(imageList, "imageList");
            this.imageList = imageList;
            notifyDataSetChanged();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            RecyclerView recyclerView = this.recyclerView;
            int childAdapterPosition = recyclerView != null ? recyclerView.getChildAdapterPosition(view) : -1;
            if (childAdapterPosition != -1) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", childAdapterPosition);
                List<String> list = this.imageList;
                ArrayList<String> arrayList = list instanceof ArrayList ? (ArrayList) list : null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                ZootopiaGalleryFragment.INSTANCE.a(this.context, bundle);
                this.reportHelper.j("clck", view, childAdapterPosition);
            }
        }
    }

    public /* synthetic */ ZootopiaDetailImageGallery(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDetailImageGallery(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportHelper = new com.tencent.mobileqq.zootopia.portal.detail.ah(context);
    }

    private final GalleryItemSize F(int style) {
        if (style == 1) {
            return new GalleryItemSize(com.tencent.sqshow.zootopia.utils.i.a(312.0f), com.tencent.sqshow.zootopia.utils.i.a(144.0f), com.tencent.sqshow.zootopia.utils.i.a(13.0f), com.tencent.sqshow.zootopia.utils.i.a(16.0f), com.tencent.sqshow.zootopia.utils.i.a(10.0f), 0.0f, 1, 3, 32, null);
        }
        if (style == 2) {
            return new GalleryItemSize(com.tencent.sqshow.zootopia.utils.i.a(137.0f), com.tencent.sqshow.zootopia.utils.i.a(297.0f), com.tencent.sqshow.zootopia.utils.i.a(13.0f), com.tencent.sqshow.zootopia.utils.i.a(16.0f), com.tencent.sqshow.zootopia.utils.i.a(10.0f), 0.0f, 1, 4, 32, null);
        }
        if (style == 3) {
            return new GalleryItemSize(com.tencent.sqshow.zootopia.utils.i.a(304.5f), -1, com.tencent.sqshow.zootopia.utils.i.a(18.0f), com.tencent.sqshow.zootopia.utils.i.a(35.0f), com.tencent.sqshow.zootopia.utils.i.a(20.0f), 90.0f, 3, 0, 128, null);
        }
        if (style != 4) {
            return new GalleryItemSize(0, 0, 0, 0, 0, 0.0f, 0, 0, 255, null);
        }
        return new GalleryItemSize(com.tencent.sqshow.zootopia.utils.i.a(304.5f), -1, com.tencent.sqshow.zootopia.utils.i.a(18.0f), com.tencent.sqshow.zootopia.utils.i.a(35.0f), com.tencent.sqshow.zootopia.utils.i.a(20.0f), 0.0f, 4, 0, 160, null);
    }
}
