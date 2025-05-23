package com.tencent.mobileqq.guild.homev2.misc;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.UiThread;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.t;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout;
import com.tencent.mobileqq.guild.homev2.views.GuildHomeV2ContentLayout;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp1.ScrollStateData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00031noB!\u0012\u0006\u0010i\u001a\u00020h\u0012\b\u0010k\u001a\u0004\u0018\u00010j\u0012\u0006\u00108\u001a\u000203\u00a2\u0006\u0004\bl\u0010mJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J8\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J8\u0010 \u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J@\u0010$\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016JP\u0010)\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J(\u0010*\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020+H\u0007J\u0010\u0010.\u001a\u00020\f2\u0006\u0010,\u001a\u00020+H\u0007J \u00101\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020/2\u0006\u00100\u001a\u00020\bH\u0016J\u0006\u00102\u001a\u00020\fR\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\"\u0010?\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010DR\u0016\u0010G\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010DR\u0016\u0010J\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010IR\u0016\u0010L\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010DR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020+0M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010XR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010ZR\u0016\u0010\\\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010:R\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010ZR\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010ZR\u0016\u0010a\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010`R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010`R\u0014\u0010e\u001a\u00020c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010dR\u0014\u0010g\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010f\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "Landroid/view/View;", "target", "", "dy", "", "l", "", "from", "", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "child", "dependency", "p", "layoutDirection", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/MotionEvent;", "ev", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", "coordinatorLayout", "targetChild", "axes", "type", "v", HippyTKDListViewAdapter.X, "dx", "", "consumed", "t", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "u", "y", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "listener", "k", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/ViewGroup;", "handled", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "g", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "getFacadeType", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", h.F, "Z", "getScrollToContentFlag", "()Z", "B", "(Z)V", "scrollToContentFlag", "i", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "contentLayout", "j", "Landroid/view/ViewGroup;", "homeHeaderLayout", "coverBelowLayout", "titleLayout", "Landroid/widget/Space;", "Landroid/widget/Space;", "windowAnchor", DomainData.DOMAIN_NAME, "pullRefreshLoadingLayout", "", "o", "Ljava/util/Set;", "stateUpdateListeners", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$b;", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$b;", "heightInfo", "Lqp1/a;", "Lqp1/a;", "scrollStateCalculator", "Lcom/tencent/mobileqq/guild/homev2/misc/e;", "Lcom/tencent/mobileqq/guild/homev2/misc/e;", "slideRightExitBehaviorHelper", "I", "startNestedScrollOffset", "firstNavigatorUpdate", "nestScrollState", "nestScrollOffsetCount", "Landroid/graphics/Point;", "Landroid/graphics/Point;", "startPoint", "currentPoint", "Lqp1/b;", "()Lqp1/b;", HippyTKDListViewAdapter.SCROLL_STATE, "()I", "anchorTop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2FragmentBehavior extends CoordinatorLayout.Behavior<GuildHomeV2ContentLayout> implements BetterCoordinatorLayout.b {

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private static final GuildDebugUtils.b<Integer> f225852z = GuildDebugUtils.f235333a.g("GuildHomeV2FragmentBehavior", "navigatorBarHeight");

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFacadeType facadeType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean scrollToContentFlag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildHomeV2ContentLayout contentLayout;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ViewGroup homeHeaderLayout;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ViewGroup coverBelowLayout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ViewGroup titleLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Space windowAnchor;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private ViewGroup pullRefreshLoadingLayout;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<c> stateUpdateListeners;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HeightInfo heightInfo;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private qp1.a scrollStateCalculator;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e slideRightExitBehaviorHelper;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int startNestedScrollOffset;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean firstNavigatorUpdate;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int nestScrollState;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int nestScrollOffsetCount;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Point startPoint;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Point currentPoint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Rect;", "a", "Landroid/graphics/Rect;", "getTitleRect", "()Landroid/graphics/Rect;", "titleRect", "b", "getNavigatorRect", "navigatorRect", "c", "I", "getNavigatorVisibleHeight", "()I", "navigatorVisibleHeight", "d", "getContentHeight", "contentHeight", "e", "getSystemAnchorTop", "systemAnchorTop", "<init>", "(Landroid/graphics/Rect;Landroid/graphics/Rect;III)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class HeightInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Rect titleRect;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Rect navigatorRect;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int navigatorVisibleHeight;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int contentHeight;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int systemAnchorTop;

        public HeightInfo() {
            this(null, null, 0, 0, 0, 31, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeightInfo)) {
                return false;
            }
            HeightInfo heightInfo = (HeightInfo) other;
            if (Intrinsics.areEqual(this.titleRect, heightInfo.titleRect) && Intrinsics.areEqual(this.navigatorRect, heightInfo.navigatorRect) && this.navigatorVisibleHeight == heightInfo.navigatorVisibleHeight && this.contentHeight == heightInfo.contentHeight && this.systemAnchorTop == heightInfo.systemAnchorTop) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.titleRect.hashCode() * 31) + this.navigatorRect.hashCode()) * 31) + this.navigatorVisibleHeight) * 31) + this.contentHeight) * 31) + this.systemAnchorTop;
        }

        @NotNull
        public String toString() {
            return "HeightInfo(titleRect=" + this.titleRect + ", navigatorRect=" + this.navigatorRect + ", navigatorVisibleHeight=" + this.navigatorVisibleHeight + ", contentHeight=" + this.contentHeight + ", systemAnchorTop=" + this.systemAnchorTop + ")";
        }

        public HeightInfo(@NotNull Rect titleRect, @NotNull Rect navigatorRect, int i3, int i16, int i17) {
            Intrinsics.checkNotNullParameter(titleRect, "titleRect");
            Intrinsics.checkNotNullParameter(navigatorRect, "navigatorRect");
            this.titleRect = titleRect;
            this.navigatorRect = navigatorRect;
            this.navigatorVisibleHeight = i3;
            this.contentHeight = i16;
            this.systemAnchorTop = i17;
        }

        public /* synthetic */ HeightInfo(Rect rect, Rect rect2, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? new Rect() : rect, (i18 & 2) != 0 ? new Rect() : rect2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) == 0 ? i17 : 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c;", "", "Lqp1/b;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f225877a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior$c$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior$c$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f225877a = new Companion();

            Companion() {
            }
        }

        void a(@NotNull ScrollStateData state);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeV2FragmentBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull GuildFacadeType facadeType) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        this.facadeType = facadeType;
        this.stateUpdateListeners = new LinkedHashSet();
        this.heightInfo = new HeightInfo(null, null, 0, 0, 0, 31, null);
        this.scrollStateCalculator = new qp1.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior$scrollStateCalculator$1
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
                GuildHomeV2FragmentBehavior.this.C("ScrollStateCalculator");
            }
        });
        e eVar = new e(context);
        eVar.h(new GuildHomeV2FragmentBehavior$slideRightExitBehaviorHelper$1$1(this));
        this.slideRightExitBehaviorHelper = eVar;
        this.firstNavigatorUpdate = true;
        this.startPoint = new Point();
        this.currentPoint = new Point();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String from) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2FragmentBehavior", "[" + from + "]updateOffsetToUi offset:" + o().getOffset());
        }
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        ViewGroup viewGroup = null;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        guildHomeV2ContentLayout.setTranslationY(o().getOffset());
        ViewGroup viewGroup2 = this.homeHeaderLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup2 = null;
        }
        viewGroup2.setTranslationY(o().getOffset());
        int max = Math.max(-o().getOffset(), 0);
        ViewGroup viewGroup3 = this.homeHeaderLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup3 = null;
        }
        ViewGroup viewGroup4 = this.homeHeaderLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup4 = null;
        }
        int width = viewGroup4.getWidth();
        ViewGroup viewGroup5 = this.homeHeaderLayout;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup5 = null;
        }
        viewGroup3.setClipBounds(new Rect(0, max, width, viewGroup5.getHeight()));
        ViewGroup viewGroup6 = this.pullRefreshLoadingLayout;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pullRefreshLoadingLayout");
            viewGroup6 = null;
        }
        ViewGroup viewGroup7 = this.pullRefreshLoadingLayout;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pullRefreshLoadingLayout");
            viewGroup7 = null;
        }
        int width2 = viewGroup7.getWidth();
        ViewGroup viewGroup8 = this.pullRefreshLoadingLayout;
        if (viewGroup8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pullRefreshLoadingLayout");
        } else {
            viewGroup = viewGroup8;
        }
        viewGroup6.setClipBounds(new Rect(0, 0, width2, viewGroup.getHeight()));
        q();
    }

    private final boolean l(View target, int dy5) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        RecyclerView.ViewHolder findViewHolderForLayoutPosition;
        int i3;
        if ((target instanceof RecyclerView) && dy5 < 0) {
            if (!target.canScrollVertically(dy5)) {
                return false;
            }
            RecyclerView recyclerView = (RecyclerView) target;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            ViewGroup.LayoutParams layoutParams = null;
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) == 0 || (findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition)) == null) {
                return true;
            }
            int top = findViewHolderForLayoutPosition.itemView.getTop();
            View view = findViewHolderForLayoutPosition.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = layoutParams2;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.topMargin;
            } else {
                i3 = 0;
            }
            if (top - i3 != 0) {
                return true;
            }
            int i16 = 0;
            for (int i17 = findFirstVisibleItemPosition - 1; i17 >= 0; i17--) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition2 = recyclerView.findViewHolderForLayoutPosition(i17);
                if (findViewHolderForLayoutPosition2 == null || (i16 = i16 + findViewHolderForLayoutPosition2.itemView.getHeight()) > 0) {
                    return true;
                }
            }
            return false;
        }
        return target.canScrollVertically(dy5);
    }

    private final int n() {
        if (this.facadeType != GuildFacadeType.GameCenter) {
            Space space = this.windowAnchor;
            if (space == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space = null;
            }
            return space.getTop();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScrollStateData o() {
        return this.scrollStateCalculator.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String();
    }

    private final void q() {
        Iterator<T> it = this.stateUpdateListeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(o());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2FragmentBehavior", "onSlideRight()");
        }
    }

    @UiThread
    public final void A(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateUpdateListeners.remove(listener)) {
            Logger logger = Logger.f235387a;
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            Logger.b bVar = new Logger.b();
            bVar.a().add("removeStateUpdateListener() can't not find callback!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildHomeV2FragmentBehavior", 1, (String) it.next(), fileNotFoundException);
            }
        }
    }

    public final void B(boolean z16) {
        this.scrollToContentFlag = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0053, code lost:
    
        if (r0 != 3) goto L17;
     */
    @Override // com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NotNull MotionEvent ev5, @NotNull ViewGroup parent, boolean handled) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2FragmentBehavior", "onDispatchTouchEvent: handled=" + handled + " isTouch=" + o().getIsTouching() + " ev=" + ev5);
        }
        int actionMasked = ev5.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    this.currentPoint.set((int) ev5.getX(), (int) ev5.getY());
                    if (QLog.isDevelopLevel()) {
                        Log.d("GuildHomeV2FragmentBehavior", "onDispatchTouchEvent DiffOffset: " + (this.currentPoint.x - this.startPoint.x) + " " + (this.currentPoint.y - this.startPoint.y));
                    }
                }
            }
            this.startPoint.set(0, 0);
            this.currentPoint.set(0, 0);
        } else {
            this.startPoint.set((int) ev5.getX(), (int) ev5.getY());
        }
        this.slideRightExitBehaviorHelper.f(ev5, parent, handled);
        if (actionMasked == 1 || actionMasked == 3) {
            this.scrollStateCalculator.h();
        }
    }

    @UiThread
    public final void k(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateUpdateListeners.add(listener);
    }

    public final void m() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2FragmentBehavior", "finishRefresh: " + o());
        }
        this.scrollStateCalculator.p();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean layoutDependsOn(@NotNull CoordinatorLayout parent, @NotNull GuildHomeV2ContentLayout child, @NotNull View dependency) {
        Object m476constructorimpl;
        List listOf;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        this.contentLayout = child;
        int id5 = dependency.getId();
        if (id5 == R.id.f915155d) {
            this.windowAnchor = (Space) dependency;
        } else if (id5 == R.id.ws8) {
            this.homeHeaderLayout = (ViewGroup) dependency;
        } else if (id5 == R.id.u_r) {
            this.coverBelowLayout = (ViewGroup) dependency;
        } else if (id5 == R.id.jp7) {
            this.titleLayout = (ViewGroup) dependency;
        } else if (id5 == R.id.loading_layout) {
            this.pullRefreshLoadingLayout = (ViewGroup) dependency;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(dependency.getResources().getResourceEntryName(dependency.getId()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "unknown(" + dependency.getId() + ')';
            }
            Log.d("GuildHomeV2FragmentBehavior", "layoutDependsOn dependency:" + ((String) m476constructorimpl));
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.ws8), Integer.valueOf(R.id.f915155d), Integer.valueOf(R.id.jp7)});
        return listOf.contains(Integer.valueOf(dependency.getId()));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean onInterceptTouchEvent(@NotNull CoordinatorLayout parent, @NotNull GuildHomeV2ContentLayout child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2FragmentBehavior", "onInterceptTouchEvent " + ev5.getAction());
        }
        return super.onInterceptTouchEvent(parent, child, ev5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull GuildHomeV2ContentLayout child, int layoutDirection) {
        int i3;
        ViewGroup viewGroup;
        boolean z16;
        boolean z17;
        boolean z18;
        List listOf;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            View[] viewArr = new View[3];
            ViewGroup viewGroup2 = this.titleLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                viewGroup2 = null;
            }
            viewArr[0] = viewGroup2;
            ViewGroup viewGroup3 = this.homeHeaderLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup3 = null;
            }
            viewArr[1] = viewGroup3;
            Space space = this.windowAnchor;
            if (space == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space = null;
            }
            viewArr[2] = space;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, null, null, null, 0, null, new Function1<View, CharSequence>() { // from class: com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior$onLayoutChild$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull View it) {
                    Object m476constructorimpl;
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(it.getResources().getResourceEntryName(it.getId()));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                        m476constructorimpl = "unknown(" + it.getId() + ')';
                    }
                    return ((String) m476constructorimpl) + "(v=" + (it.getVisibility() == 0) + ")/" + t.a(it);
                }
            }, 31, null);
            Log.d("GuildHomeV2FragmentBehavior", "onLayoutChild " + joinToString$default);
        }
        ViewGroup viewGroup4 = this.homeHeaderLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup4 = null;
        }
        int c16 = t.c(viewGroup4);
        f225852z.e(Integer.valueOf(c16), "onLayoutChild");
        ViewGroup viewGroup5 = this.titleLayout;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            viewGroup5 = null;
        }
        int measuredHeight = viewGroup5.getMeasuredHeight();
        int measuredHeight2 = parent.getMeasuredHeight() - measuredHeight;
        ViewGroup viewGroup6 = this.titleLayout;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            viewGroup6 = null;
        }
        int left = viewGroup6.getLeft();
        ViewGroup viewGroup7 = this.titleLayout;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            viewGroup7 = null;
        }
        int top = viewGroup7.getTop();
        ViewGroup viewGroup8 = this.titleLayout;
        if (viewGroup8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            viewGroup8 = null;
        }
        int right = viewGroup8.getRight();
        ViewGroup viewGroup9 = this.titleLayout;
        if (viewGroup9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            viewGroup9 = null;
        }
        Rect rect = new Rect(left, top, right, viewGroup9.getBottom());
        ViewGroup viewGroup10 = this.homeHeaderLayout;
        if (viewGroup10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup10 = null;
        }
        int left2 = viewGroup10.getLeft();
        ViewGroup viewGroup11 = this.homeHeaderLayout;
        if (viewGroup11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup11 = null;
        }
        int top2 = viewGroup11.getTop();
        ViewGroup viewGroup12 = this.homeHeaderLayout;
        if (viewGroup12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup12 = null;
        }
        int right2 = viewGroup12.getRight();
        ViewGroup viewGroup13 = this.homeHeaderLayout;
        if (viewGroup13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup13 = null;
        }
        HeightInfo heightInfo = new HeightInfo(rect, new Rect(left2, top2, right2, viewGroup13.getBottom()), c16, measuredHeight2, n());
        boolean n3 = o().n(c16);
        int state = o().getState();
        int offset = o().getOffset();
        if (QLog.isDevelopLevel()) {
            boolean z19 = this.firstNavigatorUpdate;
            ViewGroup viewGroup14 = this.homeHeaderLayout;
            if (viewGroup14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup14 = null;
            }
            if (viewGroup14.getVisibility() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            StringBuilder sb5 = new StringBuilder();
            i3 = state;
            sb5.append("onLayoutChild[scrollTop] ");
            sb5.append(z19);
            sb5.append(" ");
            sb5.append(z18);
            sb5.append(" ");
            sb5.append(measuredHeight);
            sb5.append("/(");
            sb5.append(c16);
            sb5.append(")");
            sb5.append(n3);
            Log.d("GuildHomeV2FragmentBehavior", sb5.toString());
        } else {
            i3 = state;
        }
        if (this.firstNavigatorUpdate) {
            ViewGroup viewGroup15 = this.homeHeaderLayout;
            if (viewGroup15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup15 = null;
            }
            if (viewGroup15.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && n3) {
                if (this.scrollToContentFlag) {
                    offset = -c16;
                    z17 = false;
                    i3 = 0;
                } else {
                    z17 = false;
                }
                this.firstNavigatorUpdate = z17;
            }
        }
        int i16 = i3;
        if (!Intrinsics.areEqual(heightInfo, this.heightInfo)) {
            this.heightInfo = heightInfo;
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildHomeV2FragmentBehavior", 1, "onLayoutChild " + heightInfo);
            }
            ViewGroup viewGroup16 = this.homeHeaderLayout;
            if (viewGroup16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup16 = null;
            }
            ViewGroup.LayoutParams layoutParams = viewGroup16.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
            ViewGroup viewGroup17 = this.titleLayout;
            if (viewGroup17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                viewGroup17 = null;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = viewGroup17.getMeasuredHeight();
            ViewGroup viewGroup18 = this.homeHeaderLayout;
            if (viewGroup18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup18 = null;
            }
            viewGroup18.setLayoutParams(layoutParams2);
            int max = Math.max(-o().getOffset(), 0);
            ViewGroup viewGroup19 = this.homeHeaderLayout;
            if (viewGroup19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup19 = null;
            }
            ViewGroup viewGroup20 = this.homeHeaderLayout;
            if (viewGroup20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup20 = null;
            }
            int width = viewGroup20.getWidth();
            ViewGroup viewGroup21 = this.homeHeaderLayout;
            if (viewGroup21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup21 = null;
            }
            viewGroup19.setClipBounds(new Rect(0, max, width, viewGroup21.getHeight()));
            ViewGroup viewGroup22 = this.homeHeaderLayout;
            if (viewGroup22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
                viewGroup22 = null;
            }
            viewGroup22.requestLayout();
            ViewGroup.LayoutParams layoutParams3 = child.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.LayoutParams layoutParams4 = (CoordinatorLayout.LayoutParams) layoutParams3;
            ViewGroup viewGroup23 = this.titleLayout;
            if (viewGroup23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                viewGroup = null;
            } else {
                viewGroup = viewGroup23;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = viewGroup.getMeasuredHeight() + c16;
            ((ViewGroup.MarginLayoutParams) layoutParams4).height = measuredHeight2;
            child.setLayoutParams(layoutParams4);
            child.requestLayout();
        }
        if (n3 && o().q(offset, "onLayoutChild", i16)) {
            C("onLayoutChild");
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onNestedPreScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeV2ContentLayout child, @NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        boolean z16;
        RecyclerView recyclerView;
        int sign;
        Object m476constructorimpl;
        boolean z17;
        Object m476constructorimpl2;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        boolean z18 = false;
        if (this.nestScrollOffsetCount == 0 && Math.abs(this.currentPoint.x - this.startPoint.x) > Math.abs(this.currentPoint.y - this.startPoint.y) * 1.1f) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildHomeV2FragmentBehavior", "onNestedPreScroll will stop scroll!");
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            qp1.a aVar = this.scrollStateCalculator;
            if (type == 0) {
                z18 = true;
            }
            sign = MathKt__MathJVMKt.getSign(dy5);
            boolean l3 = aVar.l(dy5, z18, l(target, sign));
            boolean shouldMarkStopScroll = this.scrollStateCalculator.getShouldMarkStopScroll();
            consumed[1] = consumed[1] + this.scrollStateCalculator.getConsumedY();
            super.onNestedPreScroll(coordinatorLayout, child, target, dx5, dy5, consumed, type);
            if (l3) {
                Logger logger2 = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        m476constructorimpl2 = Result.m476constructorimpl(target.getResources().getResourceEntryName(target.getId()));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m479exceptionOrNullimpl(m476constructorimpl2) != null) {
                        m476constructorimpl2 = "unknown(" + target.getId() + ')';
                    }
                    Log.d("GuildHomeV2FragmentBehavior", "caused by onNestedPreScroll dxy=[" + dx5 + "," + dy5 + "] type[" + type + "] id[" + ((String) m476constructorimpl2) + "] " + t.b(target));
                }
                C("onNestedPreScroll");
            } else if (!o().getIsTouching()) {
                Logger logger3 = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(target.getResources().getResourceEntryName(target.getId()));
                    } catch (Throwable th6) {
                        Result.Companion companion4 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                        m476constructorimpl = "unknown(" + target.getId() + ')';
                    }
                    String b16 = t.b(target);
                    int offset = o().getOffset();
                    String j3 = o().j();
                    StringBuilder sb5 = new StringBuilder();
                    z17 = shouldMarkStopScroll;
                    sb5.append("not update offset onNestedPreScroll dxy=[");
                    sb5.append(dx5);
                    sb5.append(",");
                    sb5.append(dy5);
                    sb5.append("] type[");
                    sb5.append(type);
                    sb5.append("] id[");
                    sb5.append((String) m476constructorimpl);
                    sb5.append("] ");
                    sb5.append(b16);
                    sb5.append(" offset=");
                    sb5.append(offset);
                    sb5.append(" state=");
                    sb5.append(j3);
                    Log.d("GuildHomeV2FragmentBehavior", sb5.toString());
                    z16 = z17;
                }
            }
            z17 = shouldMarkStopScroll;
            z16 = z17;
        }
        this.nestScrollOffsetCount++;
        if (z16) {
            target.stopNestedScroll();
            if (target instanceof RecyclerView) {
                recyclerView = (RecyclerView) target;
            } else {
                recyclerView = null;
            }
            if (recyclerView != null) {
                recyclerView.stopScroll();
            }
            Logger logger4 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildHomeV2FragmentBehavior", "[onNestedPreScroll] stopNestedScroll");
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeV2ContentLayout child, @NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NotNull int[] consumed) {
        boolean z16;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
        qp1.a aVar = this.scrollStateCalculator;
        if (type == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.i(dyUnconsumed, dyConsumed, z16);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(target.getResources().getResourceEntryName(target.getId()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "unknown(" + target.getId() + ')';
            }
            Log.d("GuildHomeV2FragmentBehavior", "onNestedScroll dxy=[" + dxConsumed + "/" + dxUnconsumed + "," + dyConsumed + "/" + dyUnconsumed + "] type[" + type + "] id[" + ((String) m476constructorimpl) + "] " + t.b(target));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onNestedScrollAccepted(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeV2ContentLayout child, @NotNull View targetChild, @NotNull View target, int axes, int type) {
        String str;
        Object m476constructorimpl;
        Object m476constructorimpl2;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(targetChild, "targetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onNestedScrollAccepted(coordinatorLayout, child, targetChild, target, axes, type);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            if (axes != 0) {
                if (axes != 1) {
                    if (axes != 2) {
                        str = "\u2725";
                    } else {
                        str = "\u2195";
                    }
                } else {
                    str = "\u2194";
                }
            } else {
                str = "\u25a1";
            }
            String str2 = "axis(" + str + ')';
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(targetChild.getResources().getResourceEntryName(targetChild.getId()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "unknown(" + targetChild.getId() + ')';
            }
            String str3 = (String) m476constructorimpl;
            try {
                m476constructorimpl2 = Result.m476constructorimpl(target.getResources().getResourceEntryName(target.getId()));
            } catch (Throwable th6) {
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl2) != null) {
                m476constructorimpl2 = "unknown(" + target.getId() + ')';
            }
            Log.d("GuildHomeV2FragmentBehavior", "onNestedScrollAccepted " + str2 + " type[" + type + "] targetChild[" + str3 + "] target[" + ((String) m476constructorimpl2) + "] " + t.b(target));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout parent, @NotNull GuildHomeV2ContentLayout child, @NotNull View targetChild, @NotNull View target, int axes, int type) {
        String str;
        Object m476constructorimpl;
        Object m476constructorimpl2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(targetChild, "targetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        if ((axes & 2) != 2) {
            if (type == 0) {
                this.scrollStateCalculator.b();
            }
            return super.onStartNestedScroll(parent, child, targetChild, target, axes, type);
        }
        this.slideRightExitBehaviorHelper.g(target, axes, type);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            if (axes != 0) {
                if (axes != 1) {
                    if (axes != 2) {
                        str = "\u2725";
                    } else {
                        str = "\u2195";
                    }
                } else {
                    str = "\u2194";
                }
            } else {
                str = "\u25a1";
            }
            String str2 = "axis(" + str + ')';
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(targetChild.getResources().getResourceEntryName(targetChild.getId()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "unknown(" + targetChild.getId() + ')';
            }
            String str3 = (String) m476constructorimpl;
            try {
                m476constructorimpl2 = Result.m476constructorimpl(target.getResources().getResourceEntryName(target.getId()));
            } catch (Throwable th6) {
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl2) != null) {
                m476constructorimpl2 = "unknown(" + target.getId() + ')';
            }
            Log.d("GuildHomeV2FragmentBehavior", "onStartNestedScroll " + str2 + " type[" + type + "] targetChild[" + str3 + "] target[" + ((String) m476constructorimpl2) + "]" + t.b(target));
        }
        this.startNestedScrollOffset = o().getOffset();
        if (type == 0) {
            this.scrollStateCalculator.b();
            this.nestScrollState = 1;
            this.nestScrollOffsetCount = 0;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onStopNestedScroll(@NotNull CoordinatorLayout parent, @NotNull GuildHomeV2ContentLayout child, @NotNull View target, int type) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onStopNestedScroll(parent, child, target, type);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(target.getResources().getResourceEntryName(target.getId()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "unknown(" + target.getId() + ')';
            }
            Log.d("GuildHomeV2FragmentBehavior", "onStopNestedScroll type[" + type + "] id[" + ((String) m476constructorimpl) + "] " + t.b(target));
        }
        if (type == 0) {
            this.nestScrollState = 0;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public boolean onTouchEvent(@NotNull CoordinatorLayout parent, @NotNull GuildHomeV2ContentLayout child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildHomeV2FragmentBehavior", "onTouchEvent " + ev5.getAction());
        }
        return super.onTouchEvent(parent, child, ev5);
    }
}
