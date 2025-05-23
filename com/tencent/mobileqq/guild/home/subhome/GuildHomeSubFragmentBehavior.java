package com.tencent.mobileqq.guild.home.subhome;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager2.widget.ViewPager2;
import bp1.l;
import bp1.m;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.subhome.c;
import com.tencent.mobileqq.guild.home.viewmodels.e;
import com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout;
import com.tencent.mobileqq.guild.home.views.header.GuildHomeGuildInfoLayout;
import com.tencent.mobileqq.guild.home.views.title.GuildHomeFloatTitleLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\u0019\u0012\u0006\u0010f\u001a\u00020e\u0012\b\u0010h\u001a\u0004\u0018\u00010g\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u0004J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J8\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016J8\u0010\"\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016J@\u0010'\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0007H\u0016JP\u0010,\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0016J(\u0010-\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0007H\u0016J0\u00101\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0016J8\u00102\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u0010&\u001a\u00020\nH\u0016J \u00103\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u00104\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205J\u000e\u00108\u001a\u00020\u00042\u0006\u00106\u001a\u000205J\u000e\u0010:\u001a\u00020\u00042\u0006\u00106\u001a\u000209J\u000e\u0010;\u001a\u00020\u00042\u0006\u00106\u001a\u000209J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0007J\u0006\u0010A\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\nR\u0016\u0010E\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010DR\u0016\u0010G\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010FR\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010FR\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010JR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010LR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010NR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010QR\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010TR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010WR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u0002050Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010ZR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u0002090Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010ZR\u0016\u0010]\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010LR\"\u0010a\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020.0^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010c\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFragmentContentLayout;", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "", "w", "j", "", "i", HippyTKDListViewAdapter.X, "", "enable", "k", "D", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "child", "layoutDirection", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "G", "Landroid/view/MotionEvent;", "ev", "Landroid/view/ViewGroup;", "handled", "a", "Landroid/view/View;", "dependency", DomainData.DOMAIN_NAME, "coordinatorLayout", "directTargetChild", "target", "axes", "type", "v", "y", "dx", "dy", "", "consumed", "t", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "velocityX", "velocityY", ReportConstant.COSTREPORT_PREFIX, "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "listener", h.F, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/home/subhome/f;", "g", "B", "l", "offset", "o", "threshold", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "available", "E", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFragmentContentLayout;", "homeSubFragmentContentLayout", "Landroid/view/ViewGroup;", "homeHeaderLayout", "homeFloatLayout", "Landroid/widget/Space;", "Landroid/widget/Space;", "windowAnchor", "Z", "isFloatingTitleAvailable", "I", "previousWidth", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverView", "Lbp1/l;", "Lbp1/l;", "behaviorHelper", "Lbp1/m;", "Lbp1/m;", "slideRightExitBehaviorHelper", "", "Ljava/util/Set;", "stateUpdateListeners", "slideRightListeners", "enableAnchorTopConfig", "", "", "Ljava/util/Map;", "extraStageOffsets", "Lcom/tencent/mobileqq/guild/home/viewmodels/e$c;", "Lcom/tencent/mobileqq/guild/home/viewmodels/e$c;", "latestTabEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFragmentBehavior extends CoordinatorLayout.Behavior<GuildHomeSubFragmentContentLayout> implements BetterCoordinatorLayout.b {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private GuildHomeSubFragmentContentLayout homeSubFragmentContentLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup homeHeaderLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup homeFloatLayout;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Space windowAnchor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isFloatingTitleAvailable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int previousWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GuildHomeCoverBelowList coverView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l behaviorHelper;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private m slideRightExitBehaviorHelper;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<g> stateUpdateListeners;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<f> slideRightListeners;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean enableAnchorTopConfig;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, Float> extraStageOffsets;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e.SelectTabEvent latestTabEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeSubFragmentBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFloatingTitleAvailable = true;
        l lVar = new l(context);
        lVar.U(new GuildHomeSubFragmentBehavior$behaviorHelper$1$1(this));
        lVar.W(new Function0<Float>() { // from class: com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior$behaviorHelper$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                e.SelectTabEvent selectTabEvent;
                Map map;
                c.GuildHomeSubTabData tabData;
                selectTabEvent = GuildHomeSubFragmentBehavior.this.latestTabEvent;
                long categoryId = (selectTabEvent == null || (tabData = selectTabEvent.getTabData()) == null) ? 0L : tabData.getCategoryId();
                map = GuildHomeSubFragmentBehavior.this.extraStageOffsets;
                Float f16 = (Float) map.remove(Long.valueOf(categoryId));
                return Float.valueOf(f16 != null ? f16.floatValue() : 0.0f);
            }
        });
        this.behaviorHelper = lVar;
        m mVar = new m(context);
        mVar.h(new GuildHomeSubFragmentBehavior$slideRightExitBehaviorHelper$1$1(this));
        this.slideRightExitBehaviorHelper = mVar;
        this.stateUpdateListeners = new LinkedHashSet();
        this.slideRightListeners = new LinkedHashSet();
        this.enableAnchorTopConfig = true;
        this.extraStageOffsets = new LinkedHashMap();
    }

    private final int i() {
        int i3;
        int a16 = GuildHomeCoverBelowList.INSTANCE.a();
        if (this.enableAnchorTopConfig) {
            Space space = this.windowAnchor;
            if (space == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space = null;
            }
            i3 = space.getTop();
        } else {
            i3 = 0;
        }
        int a17 = ((a16 - i3) - GuildHomeGuildInfoLayout.INSTANCE.a()) - this.behaviorHelper.getFloatHeaderHeight();
        if (a17 < 0) {
            return ViewUtils.f352270a.a(0.5f);
        }
        return a17;
    }

    private final void j() {
        int i3 = i();
        int a16 = GuildHomeGuildInfoLayout.INSTANCE.a() + i3;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Space space = this.windowAnchor;
            if (space == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space = null;
            }
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "calcHeaderAlpha windowAnchor.top:" + space.getTop() + "  GuildHomeViewUtils.getFixedSize():" + cp1.c.f391536a.f());
        }
        float offset = this.behaviorHelper.getCurrentState().getOffset();
        float f16 = 0.0f;
        if (offset <= (-i3)) {
            float f17 = ((-offset) - i3) / (a16 - i3);
            f16 = RangesKt___RangesKt.coerceIn(f17, 0.0f, 1.0f);
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "calcHeaderAlpha  offset:" + offset + " (" + i3 + " - " + a16 + ") " + f17 + " / " + f16);
            }
        } else if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "calcHeaderAlpha offset:" + offset + " (" + i3 + " - " + a16 + ") 0");
        }
        this.behaviorHelper.getCurrentState().g(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        if (this.homeSubFragmentContentLayout == null) {
            return;
        }
        l lVar = this.behaviorHelper;
        long currentTimeMillis = System.currentTimeMillis();
        float y16 = lVar.y();
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.homeSubFragmentContentLayout;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        guildHomeSubFragmentContentLayout.setTranslationY(y16);
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.homeSubFragmentContentLayout;
        if (guildHomeSubFragmentContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
            guildHomeSubFragmentContentLayout3 = null;
        }
        View findViewById = guildHomeSubFragmentContentLayout3.findViewById(R.id.f165163c54);
        if (findViewById != null) {
            findViewById.setTranslationY(lVar.B());
        }
        ViewGroup viewGroup = this.homeHeaderLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup = null;
        }
        viewGroup.setTranslationY(y16);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onOffsetUpdate offset:" + y16 + " extraStageOffset:" + lVar.B());
        }
        j();
        bp1.a currentState = lVar.getCurrentState();
        Iterator<T> it = this.stateUpdateListeners.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(currentState);
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout4 = this.homeSubFragmentContentLayout;
        if (guildHomeSubFragmentContentLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
        } else {
            guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout4;
        }
        guildHomeSubFragmentContentLayout2.invalidate();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onOffsetUpdate() time costs: " + currentTimeMillis2 + " ms - " + lVar.getCurrentState() + " - " + lVar.getCurrentState2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        Iterator<T> it = this.slideRightListeners.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a();
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onSlideRight()");
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public boolean onTouchEvent(@NotNull CoordinatorLayout parent, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onTouchEvent ev:" + ev5);
        }
        this.behaviorHelper.R(ev5);
        return true;
    }

    public final void B(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.slideRightListeners.remove(listener)) {
            Logger logger = Logger.f235387a;
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            Logger.b bVar = new Logger.b();
            bVar.a().add("removeSlideRightListener() can't not find callback!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", 1, (String) it.next(), fileNotFoundException);
            }
        }
    }

    public final void C(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateUpdateListeners.remove(listener)) {
            Logger logger = Logger.f235387a;
            FileNotFoundException fileNotFoundException = new FileNotFoundException();
            Logger.b bVar = new Logger.b();
            bVar.a().add("removeStateUpdateListener() can't not find callback!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", 1, (String) it.next(), fileNotFoundException);
            }
        }
    }

    public final void D() {
        this.behaviorHelper.S();
        this.extraStageOffsets.clear();
    }

    public final void E(boolean available) {
        this.isFloatingTitleAvailable = available;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.homeSubFragmentContentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            return;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        ViewParent parent = guildHomeSubFragmentContentLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.homeSubFragmentContentLayout;
        if (guildHomeSubFragmentContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
        } else {
            guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout3;
        }
        onLayoutChild(coordinatorLayout, guildHomeSubFragmentContentLayout2, 0);
    }

    public final void F(int threshold) {
        this.behaviorHelper.V(threshold);
    }

    public final void G() {
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.homeSubFragmentContentLayout;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        ViewParent parent = guildHomeSubFragmentContentLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.homeSubFragmentContentLayout;
        if (guildHomeSubFragmentContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
        } else {
            guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout3;
        }
        onLayoutChild(coordinatorLayout, guildHomeSubFragmentContentLayout2, 0);
    }

    @Override // com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout.b
    public void a(@NotNull MotionEvent ev5, @NotNull ViewGroup parent, boolean handled) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onDispatchTouchEvent ev:" + ev5);
        }
        this.slideRightExitBehaviorHelper.f(ev5, parent, handled);
    }

    public final void g(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.slideRightListeners.add(listener);
    }

    public final void h(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateUpdateListeners.add(listener);
    }

    public final void k(boolean enable) {
        this.enableAnchorTopConfig = enable;
    }

    public final void l(boolean enable) {
        this.behaviorHelper.t(enable);
    }

    public final void m() {
        this.behaviorHelper.u();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean layoutDependsOn(@NotNull CoordinatorLayout parent, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View dependency) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "layoutDependsOn dependency:" + dependency);
        }
        this.homeSubFragmentContentLayout = child;
        int id5 = dependency.getId();
        if (id5 == R.id.vaz) {
            this.homeFloatLayout = (ViewGroup) dependency;
        } else if (id5 == R.id.f98755ny) {
            this.homeHeaderLayout = (ViewGroup) dependency;
        } else if (id5 == R.id.f915155d) {
            this.windowAnchor = (Space) dependency;
        } else if (id5 == R.id.u_r) {
            this.coverView = (GuildHomeCoverBelowList) dependency;
        }
        return super.layoutDependsOn(parent, child, dependency);
    }

    public final void o(int offset) {
        this.behaviorHelper.H(offset);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean onInterceptTouchEvent(@NotNull CoordinatorLayout parent, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean M = this.behaviorHelper.M(ev5);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onInterceptTouchEvent res:" + M + " ev:" + ev5);
        }
        return M;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull GuildHomeSubFragmentContentLayout child, int layoutDirection) {
        int i3;
        int i16;
        int top;
        int i17;
        int i18;
        int i19;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Logger logger = Logger.f235387a;
        Integer num = null;
        if (QLog.isDevelopLevel()) {
            int identityHashCode = System.identityHashCode(this);
            Space space = this.windowAnchor;
            if (space == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space = null;
            }
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onLayoutChild[" + identityHashCode + "] windowAnchor.top=" + space.getTop() + ", ");
        }
        ViewGroup viewGroup = this.homeHeaderLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.f165534wi4);
        ViewGroup viewGroup2 = this.homeHeaderLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeHeaderLayout");
            viewGroup2 = null;
        }
        int measuredHeight = viewGroup2.getMeasuredHeight();
        if (this.enableAnchorTopConfig) {
            i3 = GuildHomeFloatTitleLayout.INSTANCE.b();
        } else {
            Space space2 = this.windowAnchor;
            if (space2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space2 = null;
            }
            i3 = -space2.getTop();
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.homeSubFragmentContentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeSubFragmentContentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        int f16 = guildHomeSubFragmentContentLayout.f();
        int measuredHeight2 = parent.getMeasuredHeight();
        boolean z16 = false;
        if (this.enableAnchorTopConfig) {
            ViewGroup viewGroup3 = this.homeFloatLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeFloatLayout");
                viewGroup3 = null;
            }
            i16 = viewGroup3.getBottom();
        } else {
            i16 = 0;
        }
        int i26 = (measuredHeight2 - i16) + f16;
        if (this.enableAnchorTopConfig) {
            top = 0;
        } else {
            Space space3 = this.windowAnchor;
            if (space3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space3 = null;
            }
            top = space3.getTop();
        }
        int i27 = i26 + top;
        l lVar = this.behaviorHelper;
        int measuredHeight3 = parent.getMeasuredHeight();
        if (this.enableAnchorTopConfig) {
            Space space4 = this.windowAnchor;
            if (space4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space4 = null;
            }
            i17 = space4.getTop();
        } else {
            i17 = 0;
        }
        int i28 = measuredHeight3 - i17;
        if (this.enableAnchorTopConfig) {
            if (findViewById != null) {
                i18 = findViewById.getMeasuredHeight();
            } else {
                i18 = 0;
            }
        } else {
            i18 = measuredHeight;
        }
        if (this.isFloatingTitleAvailable) {
            i19 = i3;
        } else {
            i19 = measuredHeight;
        }
        boolean X = lVar.X(i28, measuredHeight, i18, i19, i27, f16);
        this.behaviorHelper.T(i());
        if (parent.getMeasuredWidth() != this.previousWidth) {
            z16 = true;
        }
        if (X) {
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = measuredHeight;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = i27;
            child.setLayoutParams(layoutParams2);
            if (QLog.isDevelopLevel()) {
                int i29 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                ViewPager2 i36 = child.i();
                if (i36 != null) {
                    num = Integer.valueOf(i36.getMeasuredHeight());
                }
                Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onLayoutChild: GuildHomeContentLayout heightChanged! topMargin=" + i29 + " contentHeight:" + i27 + " viewPagerHeight: " + num);
            }
            child.requestLayout();
        }
        if (z16 || X) {
            this.previousWidth = parent.getMeasuredWidth();
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean onNestedFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        boolean onNestedFling = super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onNestedFling: " + velocityX + " " + velocityY + " -> " + onNestedFling + ", " + target);
        }
        return onNestedFling;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean onNestedPreFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        boolean onNestedPreFling = super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onNestedPreFling: " + velocityX + " " + velocityY + " -> " + onNestedPreFling + ", " + target);
        }
        return onNestedPreFling;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onNestedPreScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        super.onNestedPreScroll(coordinatorLayout, child, target, dx5, dy5, consumed, type);
        this.behaviorHelper.N(target, dx5, dy5, consumed, type);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onNestedScroll: " + target + " " + dyConsumed + " " + dyUnconsumed + " " + consumed);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onNestedScrollAccepted(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeSubFragmentBehavior", "onNestedScrollAccepted " + axes + " " + target.canScrollVertically(-1) + " " + target.canScrollVertically(1) + " " + target.canScrollHorizontally(-1) + " " + target.canScrollHorizontally(1));
        }
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
        this.behaviorHelper.O(target, axes, type);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        this.behaviorHelper.P(target, axes, type);
        this.slideRightExitBehaviorHelper.g(target, axes, type);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull GuildHomeSubFragmentContentLayout child, @NotNull View target, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
        this.behaviorHelper.Q(target, type);
    }
}
