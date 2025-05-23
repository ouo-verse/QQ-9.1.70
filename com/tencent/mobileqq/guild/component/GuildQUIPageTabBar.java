package com.tencent.mobileqq.guild.component;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewGroupKt;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C11733a;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0004qr\u0006sB\u0013\b\u0016\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u00a2\u0006\u0004\bh\u0010iB\u001d\b\u0016\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\b\u0010k\u001a\u0004\u0018\u00010j\u00a2\u0006\u0004\bh\u0010lB%\b\u0016\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\b\u0010k\u001a\u0004\u0018\u00010j\u0012\u0006\u0010m\u001a\u00020\n\u00a2\u0006\u0004\bh\u0010nB-\b\u0016\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\b\u0010k\u001a\u0004\u0018\u00010j\u0012\u0006\u0010m\u001a\u00020\n\u0012\u0006\u0010o\u001a\u00020\n\u00a2\u0006\u0004\bh\u0010pJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001aJ\b\u0010\u001c\u001a\u00020\nH\u0014J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\nH\u0014J(\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\u0014\u0010)\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&J \u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0014J\u001f\u0010)\u001a\u00020\u00052\u000e\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0-H\u0016\u00a2\u0006\u0004\b)\u0010/J\u0018\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020\nH\u0016J\u0010\u00104\u001a\u00020\u00032\u0006\u00101\u001a\u00020\nH\u0016JB\u0010;\u001a\u00020\u00052\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u001d2\u0006\u00101\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u001dH\u0016J:\u0010;\u001a\u00020\u00032\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u001d2\u0006\u00101\u001a\u00020\nH\u0016J4\u0010>\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010\u001d2\b\u00109\u001a\u0004\u0018\u00010\u001d2\u0006\u00101\u001a\u00020\nH\u0016J(\u0010C\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0014J\u0012\u0010F\u001a\u00020\u00032\b\u0010E\u001a\u0004\u0018\u00010DH\u0016R \u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010G\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010HR\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010OR\u0016\u0010Q\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010JR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00000R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R*\u0010e\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u00128\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u00a8\u0006t"}, d2 = {"Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "Landroidx/core/view/NestedScrollingChild3;", "", "enable", "", "c", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar$h;", "onCurrentTabClickListener", "setOnCurrentTabClickListener", "", "position", "Landroid/view/View;", "tab", "setTabClickListener", "", "title", "addTab", "", "textSize", "setTabTextSize", "notifyDataSetChanged", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$c;", "listener", "setDataSetChangeListener", "e", "Lkotlin/sequences/Sequence;", "d", "getTabMargin", "", "getUnderLineRect", "currentPos", "updateTextColor", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$b;", "tabDataList", "setTabData", "animUnderline", "fromUserClick", "setCurrentPosition", "", "tabTitles", "([Ljava/lang/String;)V", "axes", "type", "startNestedScroll", "stopNestedScroll", "hasNestedScrollingParent", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "offsetInWindow", "consumed", "dispatchNestedScroll", "dx", "dy", "dispatchNestedPreScroll", "l", "t", "oldl", "oldt", "onScrollChanged", "Landroid/view/MotionEvent;", "ev", "onTouchEvent", "Landroid/graphics/drawable/Drawable;", "Ljava/util/List;", "tabDataDrawables", "Z", "isFromClick", "f", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$c;", "dataSetChangeListener", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar$h;", "i", "isEnableSmoothScroll", "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$RetryInvalidateRunnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$RetryInvalidateRunnable;", "retryInvalidateRunnable", "Landroidx/collection/LruCache;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/collection/LruCache;", "rectCache", "Landroidx/core/view/NestedScrollingChildHelper;", "D", "Landroidx/core/view/NestedScrollingChildHelper;", "scrollingChildHelper", "value", "E", UserInfo.SEX_FEMALE, "getFontSize", "()F", CanvasView.ACTION_SET_FONT_SIZE, "(F)V", "fontSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "b", "RetryInvalidateRunnable", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildQUIPageTabBar extends QUIPageTabBar implements NestedScrollingChild3 {

    @NotNull
    private static final C11733a.C11227a<Float> G;

    @NotNull
    private static final C11733a.C11227a<Float> H;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LruCache<Integer, int[]> rectCache;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final NestedScrollingChildHelper scrollingChildHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private float fontSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends Drawable> tabDataDrawables;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFromClick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c dataSetChangeListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPageTabBar.h onCurrentTabClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableSmoothScroll;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RetryInvalidateRunnable<GuildQUIPageTabBar> retryInvalidateRunnable;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B,\u0012\u0006\u0010\u0011\u001a\u00028\u0000\u0012\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\b\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016R*\u0010\f\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\b\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$RetryInvalidateRunnable;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "T", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "d", "Lkotlin/jvm/functions/Function1;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "block", "Ljava/lang/ref/WeakReference;", "e", "Ljava/lang/ref/WeakReference;", "mRef", "tabBar", "<init>", "(Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;Lkotlin/jvm/functions/Function1;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class RetryInvalidateRunnable<T extends QUIPageTabBar> implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function1<T, Unit> block;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<T> mRef;

        /* JADX WARN: Multi-variable type inference failed */
        public RetryInvalidateRunnable(@NotNull T tabBar, @Nullable Function1<? super T, Unit> function1) {
            Intrinsics.checkNotNullParameter(tabBar, "tabBar");
            this.block = function1;
            this.mRef = new WeakReference<>(tabBar);
        }

        @Override // java.lang.Runnable
        public void run() {
            T t16 = this.mRef.get();
            if (t16 != null) {
                Function1<T, Unit> function1 = this.block;
                if (function1 != null) {
                    function1.invoke(t16);
                }
                t16.invalidate();
            } else {
                t16 = null;
            }
            if (t16 == null) {
                QLog.i("GuildQUIPagerTabBar", 1, "GuildQUIPageTabBar is null");
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.GuildQUIPageTabBar$b, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class GuildQUIPagerTabData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Drawable drawable;

        public GuildQUIPagerTabData(@NotNull String title, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.title = title;
            this.drawable = drawable;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildQUIPagerTabData)) {
                return false;
            }
            GuildQUIPagerTabData guildQUIPagerTabData = (GuildQUIPagerTabData) other;
            if (Intrinsics.areEqual(this.title, guildQUIPagerTabData.title) && Intrinsics.areEqual(this.drawable, guildQUIPagerTabData.drawable)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.title.hashCode() * 31;
            Drawable drawable = this.drawable;
            if (drawable == null) {
                hashCode = 0;
            } else {
                hashCode = drawable.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "GuildQUIPagerTabData(title=" + this.title + ", drawable=" + this.drawable + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/component/GuildQUIPageTabBar$c;", "", "", "onChanged", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface c {
        void onChanged();
    }

    static {
        C11733a c11733a = C11733a.f433775a;
        G = c11733a.a("GuildQUIPagerTabBar", "fontSize");
        H = c11733a.a("GuildQUIPagerTabBar", "paintTextSize");
    }

    public GuildQUIPageTabBar(@Nullable Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GuildQUIPageTabBar this$0, int i3, View view) {
        QUIPageTabBar.h hVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getCurrentPosition() == i3 && this$0.getCurrentPosition() >= 0 && (hVar = this$0.onCurrentTabClickListener) != null) {
            hVar.k1(i3);
        }
        this$0.isFromClick = true;
        ViewPager viewPager = this$0.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3, this$0.isEnableSmoothScroll);
        } else {
            ViewPager2 viewPager2 = this$0.mViewPager2;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i3, this$0.isEnableSmoothScroll);
            } else {
                this$0.setCurrentPosition(i3, true, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        TextView textView;
        boolean z16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Drawable drawable;
        int dip2px;
        int dip2px2;
        super.addTab(position, title);
        View childAt = this.mTabContainer.getChildAt(position);
        if (childAt instanceof TextView) {
            textView = (TextView) childAt;
        } else {
            textView = null;
        }
        if (textView != null) {
            if (position == getCurrentPosition()) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setSelected(z16);
            textView.setTextSize(1, this.fontSize);
            G.b(Float.valueOf(textView.getTextSize()), "addTab() fontSize=" + this.fontSize + "dp");
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                if (position == 0) {
                    dip2px = ViewUtils.dip2px(16.0f);
                } else {
                    dip2px = ViewUtils.dip2px(13.0f);
                }
                marginLayoutParams.leftMargin = dip2px;
                if (position == this.mTabTexts.length - 1) {
                    dip2px2 = ViewUtils.dip2px(36.0f);
                } else {
                    dip2px2 = ViewUtils.dip2px(13.0f);
                }
                marginLayoutParams.rightMargin = dip2px2;
            }
            if (textView.isSelected()) {
                textView.setTypeface(null, 0);
            } else {
                kotlin.h.d(textView, 300, 0);
            }
            textView.getPaint().setFakeBoldText(textView.isSelected());
            List<? extends Drawable> list = this.tabDataDrawables;
            if (list != null && position < list.size() && (drawable = list.get(position)) != null) {
                int dip2px3 = ViewUtils.dip2px(16.0f);
                drawable.setBounds(0, 0, dip2px3, dip2px3);
                Unit unit = Unit.INSTANCE;
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                textView.setCompoundDrawablePadding(ViewUtils.dip2px(3.0f));
            }
        }
    }

    public final void c(boolean enable) {
        this.isEnableSmoothScroll = enable;
    }

    @NotNull
    public final Sequence<View> d() {
        LinearLayout mTabContainer = this.mTabContainer;
        Intrinsics.checkNotNullExpressionValue(mTabContainer, "mTabContainer");
        return ViewGroupKt.getChildren(mTabContainer);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int dx5, int dy5, @Nullable int[] consumed, @Nullable int[] offsetInWindow, int type) {
        return this.scrollingChildHelper.dispatchNestedPreScroll(dx5, dy5, consumed, offsetInWindow, type);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow, int type, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        this.scrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    @Nullable
    public final View e(int position) {
        return this.mTabContainer.getChildAt(position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public int getTabMargin() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    @NotNull
    public int[] getUnderLineRect(int position) {
        View childAt = this.mTabContainer.getChildAt(position);
        if (childAt == null) {
            if (position <= 0) {
                QLog.e("GuildQUIPagerTabBar", 1, "getUnderLineRect, currentTab is null!");
                return new int[]{0, 0, 0, 0};
            }
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isDebugVersion()) {
                QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "getUnderLineRect, currentTab(" + position + ") is null, try prev tab", (Throwable) null);
            }
            return getUnderLineRect(position - 1);
        }
        int height = getHeight() - ViewUtils.dip2px(3.0f);
        int height2 = getHeight();
        int measureText = (int) this.mPaint.measureText(this.mTabTexts[position]);
        int dip2px = ViewUtils.dip2px(8.0f);
        if (measureText - (dip2px * 2) <= ViewUtils.dip2px(this.fontSize)) {
            dip2px = (int) Math.max(0.0f, (measureText - ViewUtils.dip2px(16.0f)) / 2.0f);
        }
        int left = childAt.getLeft() + dip2px;
        int left2 = (childAt.getLeft() + measureText) - dip2px;
        if (childAt.getRight() - childAt.getLeft() == 0) {
            removeCallbacks(this.retryInvalidateRunnable);
            postDelayed(this.retryInvalidateRunnable, 200L);
            int[] iArr = this.rectCache.get(Integer.valueOf(position));
            if (iArr == null) {
                return new int[]{0, height, left2, height2};
            }
            return iArr;
        }
        int[] iArr2 = {left, height, left2, height2};
        this.rectCache.put(Integer.valueOf(position), iArr2);
        return iArr2;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int type) {
        return this.scrollingChildHelper.hasNestedScrollingParent(type);
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        c cVar = this.dataSetChangeListener;
        if (cVar != null) {
            cVar.onChanged();
        }
        if (this.mTabContainer.getChildAt(getCurrentPosition()) == null) {
            int i3 = getUnderLineRect(getCurrentPosition())[0];
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isDebugVersion()) {
                QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "notifyDataSetChanged currentPosition:" + getCurrentPosition() + ", mTabContainer.getChildAt(currentPosition) is null, startX = " + this.mAnimationStartX + " -> " + i3, (Throwable) null);
            }
            this.mAnimationStartX = i3;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        super.onScrollChanged(l3, t16, oldl, oldt);
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "onScrollChanged l:" + l3 + ", t:" + t16 + ", oldl:" + oldl + ", oldt:" + oldt, (Throwable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        View childAt;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (w3 < oldw && (childAt = this.mTabContainer.getChildAt(getCurrentPosition())) != null) {
            int right = childAt.getRight();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.rightMargin;
            } else {
                i3 = 0;
            }
            int i16 = right + i3;
            if (i16 - getScrollX() > w3) {
                smoothScrollTo(i16 - w3, 0);
            }
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar, android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent ev5) {
        boolean onTouchEvent = super.onTouchEvent(ev5);
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "onTouchEvent ret:" + onTouchEvent, (Throwable) null);
        }
        return onTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setCurrentPosition(int position, boolean animUnderline, boolean fromUserClick) {
        boolean z16;
        if (!this.isFromClick && !fromUserClick) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isFromClick = false;
        if (animUnderline && this.mTabContainer.getChildAt(getCurrentPosition()) == null) {
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isDebugVersion()) {
                QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "setCurrentPosition position:" + position + ", animUnderline:true -> false, fromUserClick:" + z16, (Throwable) null);
            }
            animUnderline = false;
        } else {
            C11734b c11734b2 = C11734b.f433780a;
            if (QLog.isDebugVersion()) {
                QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "setCurrentPosition position:" + position + ", animUnderline:" + animUnderline + ", fromUserClick:" + z16, (Throwable) null);
            }
        }
        super.setCurrentPosition(position, animUnderline, z16);
    }

    public final void setDataSetChangeListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dataSetChangeListener = listener;
    }

    public final void setFontSize(float f16) {
        boolean z16;
        if (this.fontSize == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.fontSize = f16;
            setTabTextSize(f16);
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setOnCurrentTabClickListener(@Nullable QUIPageTabBar.h onCurrentTabClickListener) {
        super.setOnCurrentTabClickListener(onCurrentTabClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setTabClickListener(final int position, @Nullable View tab) {
        if (tab != null) {
            tab.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.component.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildQUIPageTabBar.f(GuildQUIPageTabBar.this, position, view);
                }
            });
        }
    }

    public final void setTabData(@NotNull List<GuildQUIPagerTabData> tabDataList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<? extends Drawable> list;
        int collectionSizeOrDefault3;
        Intrinsics.checkNotNullParameter(tabDataList, "tabDataList");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.GuildQUIPagerTabBar", 2, "setTabData tabDataList:" + tabDataList, (Throwable) null);
        }
        List<GuildQUIPagerTabData> list2 = tabDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuildQUIPagerTabData) it.next()).getDrawable());
        }
        CollectionsKt___CollectionsKt.toList(arrayList);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((GuildQUIPagerTabData) it5.next()).getDrawable());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList2);
        this.tabDataDrawables = list;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        Iterator<T> it6 = list2.iterator();
        while (it6.hasNext()) {
            arrayList3.add(((GuildQUIPagerTabData) it6.next()).getTitle());
        }
        Object[] array = arrayList3.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        super.setTabData((String[]) array);
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setTabTextSize(float textSize) {
        super.setTabTextSize(textSize);
        H.b(Float.valueOf(this.mPaint.getTextSize()), "setTabTextSize(" + textSize + "dp)");
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int axes, int type) {
        return this.scrollingChildHelper.startNestedScroll(axes, type);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int type) {
        this.scrollingChildHelper.stopNestedScroll(type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        TextView textView;
        ColorStateList colorStateList;
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                textView = null;
            }
            boolean z16 = true;
            if (textView != null) {
                if (i3 == currentPos) {
                    colorStateList = this.mCheckedTextColor;
                } else {
                    colorStateList = this.mUncheckedTextColor;
                }
                textView.setTextColor(colorStateList);
                if (i3 != currentPos) {
                    z16 = false;
                }
                textView.setSelected(z16);
                if (textView.isSelected()) {
                    textView.setTypeface(null, 0);
                } else {
                    kotlin.h.d(textView, 300, 0);
                }
                textView.getPaint().setFakeBoldText(textView.isSelected());
            } else {
                QLog.e("GuildQUIPagerTabBar", 1, "updateTextColor, but textview is null.");
            }
        }
    }

    public GuildQUIPageTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow, int type) {
        return this.scrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public GuildQUIPageTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public GuildQUIPageTabBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.isEnableSmoothScroll = true;
        this.retryInvalidateRunnable = new RetryInvalidateRunnable<>(this, new Function1<GuildQUIPageTabBar, Unit>() { // from class: com.tencent.mobileqq.guild.component.GuildQUIPageTabBar$retryInvalidateRunnable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildQUIPageTabBar guildQUIPageTabBar) {
                invoke2(guildQUIPageTabBar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildQUIPageTabBar $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                ((QUIPageTabBar) $receiver).mAnimationStartX = 0;
            }
        });
        this.rectCache = new LruCache<>(10);
        this.scrollingChildHelper = new NestedScrollingChildHelper(this);
        this.fontSize = 16.0f;
        setTabTextSize(16.0f);
        setUnderlineColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_feedback_normal));
        this.mNeedUpdateUIWhenWidthChange = false;
        this.mTabContainer.getLayoutParams().width = -2;
        this.mCheckedTextColor = ie0.a.f().h(getContext(), R.color.qui_common_text_primary, 1000);
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setTabData(@NotNull String[] tabTitles) {
        List<? extends Drawable> emptyList;
        Intrinsics.checkNotNullParameter(tabTitles, "tabTitles");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.tabDataDrawables = emptyList;
        super.setTabData(tabTitles);
    }
}
