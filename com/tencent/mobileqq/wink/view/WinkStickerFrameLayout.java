package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 j2\u00020\u0001:\u0003klmB'\b\u0007\u0012\u0006\u0010d\u001a\u00020c\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010e\u0012\b\b\u0002\u0010g\u001a\u00020A\u00a2\u0006\u0004\bh\u0010iJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0014\u0010\u0018\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0006J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u0018\u0010-\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020+J\u0006\u0010.\u001a\u00020&J\u0006\u0010/\u001a\u00020&J\u0006\u00100\u001a\u00020&R\u0014\u00103\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010=R\u0014\u0010@\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010BR\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010BR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010FR\u0016\u0010I\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0014\u0010J\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010BR\u0014\u0010L\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010BR\u0014\u0010N\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010BR\u0014\u0010O\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010BR\u0014\u0010Q\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010BR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010SR\"\u0010b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010S\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", BdhLogUtil.LogTag.Tag_Conn, "", "bool", "setUseSkin", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameView;", "t", "isCover", "setIsCover", "(Ljava/lang/Boolean;)V", "enableDeleteBtn", "setEnableDeleteBtn", "showCreatorInfoBtn", "setEnableCreatorInfoBtn", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$c;", "popupMenuClickListener", "setPopupMenuClickListener", "", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$b;", "menuItems", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "D", UserInfo.SEX_FEMALE, "secondStickerModel", "showMenu", tl.h.F, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Landroid/graphics/PointF;", "point", "B", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "scale", "setPicScale", "Landroid/view/ViewGroup;", TtmlNode.TAG_LAYOUT, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", ReportConstant.COSTREPORT_PREFIX, "r", "d", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameView;", "frameView", "Landroid/view/View;", "e", "Landroid/view/View;", "menuLayout", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "menuItemContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "arrowUp", "i", "arrowDown", "", "I", "menuItemWidth", "menuItemHeight", "Lcom/tencent/mobileqq/activity/richmedia/i;", "Lcom/tencent/mobileqq/activity/richmedia/i;", AdParam.SCREENSIZE, "E", "menuLayoutHalfWidth", "menuLayoutHeight", "G", "musicViewBottomY", "H", "dashboardMenuHeight", "arrowHeight", "J", "arrowMargin", "K", "Z", "useSkin", "L", "Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$c;", "menuClickListener", "M", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "N", "mPicScale", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "u", "()Z", "setManualHide", "(Z)V", "manualHide", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkStickerFrameLayout extends FrameLayout {

    /* renamed from: S */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    private final int menuItemHeight;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.richmedia.i com.tencent.ads.data.AdParam.SCREENSIZE java.lang.String;

    /* renamed from: E, reason: from kotlin metadata */
    private int menuLayoutHalfWidth;

    /* renamed from: F */
    private final int menuLayoutHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private final int musicViewBottomY;

    /* renamed from: H, reason: from kotlin metadata */
    private final int dashboardMenuHeight;

    /* renamed from: I, reason: from kotlin metadata */
    private final int arrowHeight;

    /* renamed from: J, reason: from kotlin metadata */
    private final int arrowMargin;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean useSkin;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private c menuClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private WinkStickerModel stickerModel;

    /* renamed from: N */
    private float mPicScale;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isCover;

    /* renamed from: Q */
    private boolean manualHide;

    @NotNull
    public Map<Integer, View> R;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private final WinkStickerFrameView frameView;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final View menuLayout;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout menuItemContainer;

    /* renamed from: h */
    @NotNull
    private final ImageView arrowUp;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final ImageView arrowDown;

    /* renamed from: m */
    private final int menuItemWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$a;", "", "", "MUSIC_VIEW_BOTTOM_Y", UserInfo.SEX_FEMALE, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.view.WinkStickerFrameLayout$a */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "id", "c", "nameResId", "iconResId", "<init>", "(III)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.view.WinkStickerFrameLayout$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class MenuItem {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final int nameResId;

        /* renamed from: c, reason: from kotlin metadata and from toString */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/view/WinkStickerFrameLayout$c;", "", "", "id", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void a(int id5, @Nullable WinkStickerModel stickerModel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkStickerFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C(WinkStickerModel winkStickerModel) {
        ArrayList arrayListOf;
        Comparator compareBy;
        List sortedWith;
        float f16;
        float f17;
        float f18;
        if (winkStickerModel == null) {
            this.menuLayout.setVisibility(8);
            return;
        }
        this.stickerModel = winkStickerModel;
        Matrix matrix = new Matrix();
        matrix.setRotate(-winkStickerModel.rotate, this.frameView.k(), this.frameView.m());
        com.tencent.mobileqq.wink.utils.u uVar = com.tencent.mobileqq.wink.utils.u.f326728a;
        int i3 = 1;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uVar.j(matrix, this.frameView.i().left, this.frameView.i().top), uVar.j(matrix, this.frameView.i().right, this.frameView.i().top), uVar.j(matrix, this.frameView.i().left, this.frameView.i().bottom), uVar.j(matrix, this.frameView.i().right, this.frameView.i().bottom));
        compareBy = ComparisonsKt__ComparisonsKt.compareBy(new MutablePropertyReference1Impl() { // from class: com.tencent.mobileqq.wink.view.WinkStickerFrameLayout$updateMenuPosition$pointListSorted$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Float.valueOf(((PointF) obj).x);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(@Nullable Object obj, @Nullable Object obj2) {
                ((PointF) obj).x = ((Number) obj2).floatValue();
            }
        }, new MutablePropertyReference1Impl() { // from class: com.tencent.mobileqq.wink.view.WinkStickerFrameLayout$updateMenuPosition$pointListSorted$2
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
            i3 = 0;
        }
        int i16 = 1 - i3;
        int i17 = i3 + 2;
        float f19 = 2;
        float f26 = (((PointF) sortedWith.get(i3)).x + ((PointF) sortedWith.get(i17)).x) / f19;
        float f27 = (((PointF) sortedWith.get(i3)).y + ((PointF) sortedWith.get(i17)).y) / f19;
        float f28 = ((PointF) sortedWith.get(i16)).x;
        int i18 = i16 + 2;
        float f29 = ((PointF) sortedWith.get(i18)).x;
        float f36 = (((PointF) sortedWith.get(i16)).y + ((PointF) sortedWith.get(i18)).y) / f19;
        int i19 = this.menuLayoutHalfWidth;
        if (f26 >= i19 && i19 + f26 <= this.com.tencent.ads.data.AdParam.SCREENSIZE java.lang.String.f185860a) {
            f17 = i19;
        } else {
            float f37 = f26 + i19;
            int i26 = this.com.tencent.ads.data.AdParam.SCREENSIZE java.lang.String.f185860a;
            if (f37 > i26) {
                f26 = i26;
                f17 = i19 * f19;
            } else {
                f16 = 0.0f;
                if (f27 < this.menuLayoutHeight + this.musicViewBottomY) {
                    this.arrowUp.setVisibility(4);
                    this.arrowDown.setVisibility(0);
                    f18 = (f27 - this.menuLayoutHeight) - this.arrowMargin;
                } else {
                    this.arrowUp.setVisibility(0);
                    this.arrowDown.setVisibility(4);
                    if (this.arrowMargin + f36 + this.menuLayoutHeight > getBottom() - this.dashboardMenuHeight) {
                        f18 = ((getBottom() - this.dashboardMenuHeight) - this.arrowMargin) - this.menuLayoutHeight;
                    } else {
                        f18 = f36 + this.arrowMargin;
                    }
                }
                this.menuLayout.setX(f16);
                this.menuLayout.setY(f18);
            }
        }
        f16 = f26 - f17;
        if (f27 < this.menuLayoutHeight + this.musicViewBottomY) {
        }
        this.menuLayout.setX(f16);
        this.menuLayout.setY(f18);
    }

    public static final void E(WinkStickerFrameLayout this$0, WinkStickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        this$0.frameView.a(stickerModel, null, Float.valueOf(this$0.mPicScale));
        this$0.menuLayout.setVisibility(4);
    }

    public static final void G(WinkStickerFrameLayout this$0, WinkStickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        this$0.frameView.a(stickerModel, null, Float.valueOf(this$0.mPicScale));
        this$0.menuLayout.setVisibility(4);
        this$0.w();
    }

    public static /* synthetic */ void i(WinkStickerFrameLayout winkStickerFrameLayout, WinkStickerModel winkStickerModel, WinkStickerModel winkStickerModel2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        winkStickerFrameLayout.h(winkStickerModel, winkStickerModel2, z16);
    }

    public static final void j(WinkStickerFrameLayout this$0, WinkStickerModel stickerModel, WinkStickerModel winkStickerModel, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        this$0.frameView.a(stickerModel, winkStickerModel, Float.valueOf(this$0.mPicScale));
        this$0.C(stickerModel);
        View view = this$0.menuLayout;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view.setVisibility(i3);
        this$0.A();
    }

    public static final void l(WinkStickerFrameLayout this$0, WinkStickerModel stickerModel, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        this$0.frameView.a(stickerModel, winkStickerModel, Float.valueOf(this$0.mPicScale));
        this$0.menuLayout.setVisibility(8);
        this$0.A();
    }

    public static final void n(WinkStickerFrameLayout this$0, WinkStickerModel stickerModel, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        this$0.frameView.a(stickerModel, winkStickerModel, Float.valueOf(this$0.mPicScale));
        this$0.menuLayout.setVisibility(8);
    }

    public static final void p(WinkStickerFrameLayout this$0, WinkStickerModel stickerModel, WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(stickerModel, "$stickerModel");
        this$0.frameView.a(stickerModel, winkStickerModel, Float.valueOf(this$0.mPicScale));
        this$0.menuLayout.setVisibility(8);
        this$0.w();
    }

    public static final void y(WinkStickerFrameLayout this$0, MenuItem menuItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        c cVar = this$0.menuClickListener;
        if (cVar != null) {
            cVar.a(menuItem.getId(), this$0.stickerModel);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void A() {
        this.manualHide = false;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    @NotNull
    public final PointF B(@NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        getLocationOnScreen(new int[2]);
        return new PointF(point.x - r0[0], point.y - r0[1]);
    }

    public final void D(@NotNull final WinkStickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.as
            @Override // java.lang.Runnable
            public final void run() {
                WinkStickerFrameLayout.E(WinkStickerFrameLayout.this, stickerModel);
            }
        });
    }

    public final void F(@NotNull final WinkStickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.ax
            @Override // java.lang.Runnable
            public final void run() {
                WinkStickerFrameLayout.G(WinkStickerFrameLayout.this, stickerModel);
            }
        });
    }

    public final void h(@NotNull final WinkStickerModel stickerModel, @Nullable final WinkStickerModel winkStickerModel, final boolean z16) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.av
            @Override // java.lang.Runnable
            public final void run() {
                WinkStickerFrameLayout.j(WinkStickerFrameLayout.this, stickerModel, winkStickerModel, z16);
            }
        });
    }

    public final void k(@NotNull final WinkStickerModel stickerModel, @Nullable final WinkStickerModel secondStickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.ay
            @Override // java.lang.Runnable
            public final void run() {
                WinkStickerFrameLayout.l(WinkStickerFrameLayout.this, stickerModel, secondStickerModel);
            }
        });
    }

    public final void m(@NotNull final WinkStickerModel stickerModel, @Nullable final WinkStickerModel winkStickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.aw
            @Override // java.lang.Runnable
            public final void run() {
                WinkStickerFrameLayout.n(WinkStickerFrameLayout.this, stickerModel, winkStickerModel);
            }
        });
    }

    public final void o(@NotNull final WinkStickerModel stickerModel, @Nullable final WinkStickerModel secondStickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.at
            @Override // java.lang.Runnable
            public final void run() {
                WinkStickerFrameLayout.p(WinkStickerFrameLayout.this, stickerModel, secondStickerModel);
            }
        });
    }

    @NotNull
    public final RectF q(@NotNull WinkStickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "stickerModel");
        RectF rectF = new RectF();
        WinkStickerFrameView.b(this.frameView, stickerModel, rectF, null, null, Float.valueOf(this.mPicScale), Boolean.valueOf(this.isCover));
        return rectF;
    }

    @NotNull
    public final RectF r() {
        RectF g16 = this.frameView.g();
        Intrinsics.checkNotNullExpressionValue(g16, "frameView.creatorInfoRect");
        return g16;
    }

    @NotNull
    public final RectF s() {
        RectF h16 = this.frameView.h();
        Intrinsics.checkNotNullExpressionValue(h16, "frameView.deleteRect");
        return h16;
    }

    public final void setEnableCreatorInfoBtn(boolean showCreatorInfoBtn) {
        this.frameView.setEnableCreatorBtn(Boolean.valueOf(showCreatorInfoBtn));
    }

    public final void setEnableDeleteBtn(boolean enableDeleteBtn) {
        this.frameView.setEnableDeleteBtn(Boolean.valueOf(enableDeleteBtn));
    }

    public final void setIsCover(@Nullable Boolean isCover) {
        Intrinsics.checkNotNull(isCover);
        this.isCover = isCover.booleanValue();
        this.frameView.setIsCover(isCover);
    }

    public final void setManualHide(boolean z16) {
        this.manualHide = z16;
    }

    public final void setPicScale(float scale) {
        this.mPicScale = scale;
    }

    public final void setPopupMenuClickListener(@NotNull c popupMenuClickListener) {
        Intrinsics.checkNotNullParameter(popupMenuClickListener, "popupMenuClickListener");
        this.menuClickListener = popupMenuClickListener;
    }

    public final void setUseSkin(boolean bool) {
        this.useSkin = bool;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final WinkStickerFrameView getFrameView() {
        return this.frameView;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getManualHide() {
        return this.manualHide;
    }

    @NotNull
    public final RectF v() {
        RectF o16 = this.frameView.o();
        Intrinsics.checkNotNullExpressionValue(o16, "frameView.zoomRect");
        return o16;
    }

    public final void w() {
        if (getVisibility() != 4) {
            setVisibility(4);
        }
    }

    public final void x(@NotNull List<MenuItem> menuItems) {
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        this.menuItemContainer.removeAllViews();
        for (final MenuItem menuItem : menuItems) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hew, (ViewGroup) this.menuItemContainer, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.xd6);
            TextView textView = (TextView) inflate.findViewById(R.id.zly);
            textView.setText(menuItem.getNameResId());
            if (this.useSkin) {
                ColorStateList colorStateList = textView.getContext().getColorStateList(R.color.qui_common_text_primary);
                Intrinsics.checkNotNullExpressionValue(colorStateList, "nameText.context.getColo\u2026.qui_common_text_primary)");
                textView.setTextColor(colorStateList);
                imageView.setImageResource(menuItem.getIconResId());
            } else {
                imageView.setImageResource(menuItem.getIconResId());
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.au
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkStickerFrameLayout.y(WinkStickerFrameLayout.this, menuItem, view);
                }
            });
            this.menuItemContainer.addView(inflate, this.menuItemWidth, this.menuItemHeight);
        }
        this.menuLayoutHalfWidth = (menuItems.size() * this.menuItemWidth) / 2;
        C(this.stickerModel);
    }

    public final boolean z(@Nullable WinkStickerModel winkStickerModel, @NotNull ViewGroup layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (winkStickerModel == null) {
            return false;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(-winkStickerModel.rotate, this.frameView.k(), this.frameView.m());
        com.tencent.mobileqq.wink.utils.u uVar = com.tencent.mobileqq.wink.utils.u.f326728a;
        PointF j3 = uVar.j(matrix, this.frameView.i().left, this.frameView.i().top);
        PointF j16 = uVar.j(matrix, this.frameView.i().right, this.frameView.i().top);
        PointF j17 = uVar.j(matrix, this.frameView.i().left, this.frameView.i().bottom);
        PointF j18 = uVar.j(matrix, this.frameView.i().right, this.frameView.i().bottom);
        boolean m3 = uVar.m(j3.x, j3.y, j16.x, j16.y, layout.getLeft(), layout.getTop(), layout.getRight(), layout.getBottom());
        boolean m16 = uVar.m(j3.x, j3.y, j17.x, j17.y, layout.getLeft(), layout.getTop(), layout.getRight(), layout.getBottom());
        boolean m17 = uVar.m(j17.x, j17.y, j18.x, j18.y, layout.getLeft(), layout.getTop(), layout.getRight(), layout.getBottom());
        boolean m18 = uVar.m(j16.x, j16.y, j18.x, j18.y, layout.getLeft(), layout.getTop(), layout.getRight(), layout.getBottom());
        if (!m3 && !m16 && !m17 && !m18) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkStickerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkStickerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.R = new LinkedHashMap();
        this.musicViewBottomY = ViewUtils.dip2px(89.0f);
        this.mPicScale = 1.0f;
        setVisibility(4);
        com.tencent.mobileqq.activity.richmedia.i f16 = com.tencent.mobileqq.util.x.f(context);
        Intrinsics.checkNotNullExpressionValue(f16, "getScreenSize(context)");
        this.com.tencent.ads.data.AdParam.SCREENSIZE java.lang.String = f16;
        WinkStickerFrameView winkStickerFrameView = new WinkStickerFrameView(context);
        this.frameView = winkStickerFrameView;
        addView(winkStickerFrameView, new FrameLayout.LayoutParams(-1, -1));
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

    public /* synthetic */ WinkStickerFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
