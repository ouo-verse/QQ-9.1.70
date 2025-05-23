package com.tencent.mobileqq.guild.widget.operationbanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.j;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.guild.component.banner.viewpager2.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.guild.widget.GuildDotIndicator;
import com.tencent.mobileqq.guild.widget.operationbanner.GuildOperationBanner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelActivity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.util.WeakReference;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q12.g;
import q12.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0003hijB\u001b\u0012\u0006\u0010b\u001a\u00020a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\be\u0010fJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0002J\u001e\u0010(\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010)\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020\tJ\u0010\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010,J\u0010\u00100\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010/J\u0018\u00104\u001a\u00020\t2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u0005H\u0014J\u0012\u00105\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u000101H\u0016J\u0010\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00122\u0006\u00107\u001a\u000206H\u0016R\u0016\u0010<\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0010R\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010MR\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010OR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010MR\u0016\u0010T\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010XR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010ZR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010\\R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010MR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "guildId", "", "channelType", "channelId", "groupId", "", ReportConstant.COSTREPORT_PREFIX, "(JILjava/lang/Long;Ljava/lang/Long;)V", "v", "o", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "bannerData", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", NodeProps.VISIBLE, BdhLogUtil.LogTag.Tag_Conn, "colorMode", "D", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "w", "selectIndex", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "y", HippyTKDListViewAdapter.X, "", "p", "eventId", "activityId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "t", "setAttachedPageVisibility", DomainData.DOMAIN_NAME, "Lq12/h;", "listener", "setBannerVisibleListener", "Lq12/d;", "setBannerClickListener", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "d", "Landroid/view/View;", "bannerRootView", "Lcom/tencent/mobileqq/guild/widget/GuildDotIndicator;", "e", "Lcom/tencent/mobileqq/guild/widget/GuildDotIndicator;", "indicatorView", "f", "closeButton", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", h.F, "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "bannerLayout", "Lq12/c;", "i", "Lq12/c;", "adapter", "", "initialX", "I", "touchSlop", "Lq12/d;", "bannerClickListener", "currentSelectedIndex", "G", "Z", "isAttachedPageVisible", "H", "isMoving", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner$b;", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner$b;", "holdBannerData", "J", "K", "Ljava/lang/Long;", "L", "M", "N", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "P", "a", "b", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOperationBanner extends FrameLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: D, reason: from kotlin metadata */
    private int colorMode;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private q12.d bannerClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentSelectedIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isAttachedPageVisible;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isMoving;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private HoldBannerData holdBannerData;

    /* renamed from: J, reason: from kotlin metadata */
    private long guildId;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Long channelId;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Long groupId;

    /* renamed from: M, reason: from kotlin metadata */
    private int channelType;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private IGProGetChannelActivityRsp bannerData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View bannerRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildDotIndicator indicatorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View closeButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BannerLayout bannerLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private q12.c adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float initialX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner$c;", "Lq12/i;", "", "requestTag", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "bannerData", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "Lmqq/util/WeakReference;", "bannerWeakReference", "banner", "<init>", "(Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<GuildOperationBanner> bannerWeakReference;

        public c(@NotNull GuildOperationBanner banner) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            this.bannerWeakReference = new WeakReference<>(banner);
        }

        @Override // q12.i
        public void a(@NotNull String requestTag, @Nullable IGProGetChannelActivityRsp bannerData) {
            boolean z16;
            String str;
            Intrinsics.checkNotNullParameter(requestTag, "requestTag");
            if (bannerData != null && bannerData.getIsShow()) {
                ArrayList<IGProChannelActivity> channelActivities = bannerData.getChannelActivities();
                boolean z17 = false;
                if (channelActivities != null && !channelActivities.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    GuildOperationBanner guildOperationBanner = this.bannerWeakReference.get();
                    if (guildOperationBanner != null && Intrinsics.areEqual(requestTag, guildOperationBanner.p())) {
                        guildOperationBanner.q(bannerData);
                        return;
                    }
                    Logger.a d16 = Logger.f235387a.d();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("fetchBannerData no need update: ");
                    if (guildOperationBanner == null) {
                        z17 = true;
                    }
                    sb5.append(z17);
                    sb5.append(" - ");
                    sb5.append(requestTag);
                    sb5.append(" - ");
                    if (guildOperationBanner != null) {
                        str = guildOperationBanner.p();
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    sb5.append(", ");
                    d16.w("Guild.comm.GuildOperationBanner", 1, sb5.toString());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner$d", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends pg1.d {
        d() {
        }

        @Override // pg1.d
        public void a(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            b.d(viewPager2, 0.5f);
            b.b(viewPager2, 3.2f);
            viewPager2.setOffscreenPageLimit(1);
            recyclerView.setOverScrollMode(2);
            GuildOperationBanner.this.w(viewPager2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner$e", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f236441c;

        e(ViewPager2 viewPager2) {
            this.f236441c = viewPager2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int roundToInt;
            int roundToInt2;
            Logger logger = Logger.f235387a;
            ViewPager2 viewPager2 = this.f236441c;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.comm.GuildOperationBanner", "onPageScrolled:\uff08" + position + ", " + positionOffset + "\uff09- " + viewPager2.getCurrentItem());
            }
            BannerLayout bannerLayout = GuildOperationBanner.this.bannerLayout;
            BannerLayout bannerLayout2 = null;
            if (bannerLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                bannerLayout = null;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(positionOffset);
            int c16 = bannerLayout.c(roundToInt + position);
            if (GuildOperationBanner.this.currentSelectedIndex != c16) {
                GuildOperationBanner guildOperationBanner = GuildOperationBanner.this;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.comm.GuildOperationBanner", "onPageScrolled:" + guildOperationBanner.currentSelectedIndex + " -> " + c16);
                }
                GuildOperationBanner.this.E(c16);
            }
            if (this.f236441c.isUserInputEnabled() && GuildOperationBanner.this.isMoving) {
                int currentItem = this.f236441c.getCurrentItem();
                if (Math.abs((position + positionOffset) - currentItem) >= 0.8d) {
                    BannerLayout bannerLayout3 = GuildOperationBanner.this.bannerLayout;
                    if (bannerLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                    } else {
                        bannerLayout2 = bannerLayout3;
                    }
                    bannerLayout2.a(false);
                    int i3 = currentItem - 1;
                    if (position < i3) {
                        this.f236441c.setCurrentItem(i3, false);
                    } else {
                        if (position > currentItem) {
                            this.f236441c.setCurrentItem(currentItem + 1, false);
                            return;
                        }
                        ViewPager2 viewPager22 = this.f236441c;
                        roundToInt2 = MathKt__MathJVMKt.roundToInt(positionOffset);
                        viewPager22.setCurrentItem(position + roundToInt2, true);
                    }
                }
            }
        }
    }

    public /* synthetic */ GuildOperationBanner(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final void A() {
        q12.c cVar = new q12.c();
        cVar.o0(new q12.d() { // from class: q12.a
            @Override // q12.d
            public final void a(int i3, IGProChannelActivity iGProChannelActivity) {
                GuildOperationBanner.B(GuildOperationBanner.this, i3, iGProChannelActivity);
            }
        });
        this.adapter = cVar;
        BannerLayout bannerLayout = this.bannerLayout;
        q12.c cVar2 = null;
        if (bannerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout = null;
        }
        q12.c cVar3 = this.adapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            cVar2 = cVar3;
        }
        bannerLayout.setAdapter(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildOperationBanner this$0, int i3, IGProChannelActivity iGProChannelActivity) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(i3);
        if (iGProChannelActivity != null) {
            str = iGProChannelActivity.getJumpUrl();
        } else {
            str = null;
        }
        boolean z16 = true;
        Logger.f235387a.d().d("Guild.comm.GuildOperationBanner", 1, "onclick: " + i3 + TokenParser.SP + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            if (!URLUtil.isValidUrl(str)) {
                str = "https://" + str;
            }
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(QBaseActivity.sTopActivity, str, "");
        }
        q12.d dVar = this$0.bannerClickListener;
        if (dVar != null) {
            dVar.a(i3, iGProChannelActivity);
        }
    }

    private final void C(boolean visible) {
        boolean z16;
        View view = this.bannerRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerRootView");
            view = null;
        }
        int i3 = 0;
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != visible) {
            View view3 = this.bannerRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerRootView");
            } else {
                view2 = view3;
            }
            if (!visible) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    private final void D(int colorMode) {
        GuildDotIndicator guildDotIndicator = null;
        if (colorMode != 0) {
            if (colorMode != 1) {
                s.f("Guild.comm.GuildOperationBanner", "setColorMode invalid " + colorMode, new IllegalStateException());
                return;
            }
            View view = this.closeButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeButton");
                view = null;
            }
            view.setBackgroundResource(R.drawable.guild_operation_banner_close_dark_bg);
            GuildDotIndicator guildDotIndicator2 = this.indicatorView;
            if (guildDotIndicator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorView");
            } else {
                guildDotIndicator = guildDotIndicator2;
            }
            guildDotIndicator.setDotRes(R.drawable.guild_operation_banner_dark_indicator);
            return;
        }
        View view2 = this.closeButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            view2 = null;
        }
        view2.setBackgroundResource(R.drawable.guild_skin_operation_banner_close_bg);
        GuildDotIndicator guildDotIndicator3 = this.indicatorView;
        if (guildDotIndicator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorView");
        } else {
            guildDotIndicator = guildDotIndicator3;
        }
        guildDotIndicator.setDotRes(R.drawable.guild_skin_operation_banner_indicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int selectIndex) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.comm.GuildOperationBanner", "updateAndReportSelect:" + selectIndex);
        }
        if (selectIndex < 0) {
            return;
        }
        this.currentSelectedIndex = selectIndex;
        GuildDotIndicator guildDotIndicator = this.indicatorView;
        if (guildDotIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorView");
            guildDotIndicator = null;
        }
        guildDotIndicator.b(this.currentSelectedIndex);
        y(this.currentSelectedIndex);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetChannelActivityRsp] */
    /* JADX WARN: Type inference failed for: r3v1 */
    private final void F(IGProGetChannelActivityRsp bannerData) {
        ArrayList arrayList;
        byte b16;
        List<? extends IGProChannelActivity> emptyList;
        ArrayList<IGProChannelActivity> channelActivities;
        byte b17;
        this.bannerData = bannerData;
        GuildDotIndicator guildDotIndicator = 0;
        GuildDotIndicator guildDotIndicator2 = null;
        this.holdBannerData = new HoldBannerData(false, guildDotIndicator, 2, guildDotIndicator);
        if (bannerData != null && (channelActivities = bannerData.getChannelActivities()) != null) {
            arrayList = new ArrayList();
            for (Object obj : channelActivities) {
                IGProChannelActivity iGProChannelActivity = (IGProChannelActivity) obj;
                if (URLUtil.isValidUrl(iGProChannelActivity.getImageUrl()) && URLUtil.isValidUrl(iGProChannelActivity.getJumpUrl())) {
                    b17 = true;
                } else {
                    b17 = false;
                }
                if (b17 != false) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            b16 = false;
        } else {
            b16 = true;
        }
        if (b16 != false) {
            C(false);
            q12.c cVar = this.adapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                cVar = null;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cVar.setData(emptyList);
            this.currentSelectedIndex = -1;
            GuildDotIndicator guildDotIndicator3 = this.indicatorView;
            if (guildDotIndicator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorView");
            } else {
                guildDotIndicator2 = guildDotIndicator3;
            }
            guildDotIndicator2.a(0);
            return;
        }
        C(true);
        q12.c cVar2 = this.adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar2 = null;
        }
        cVar2.setData(arrayList);
        GuildDotIndicator guildDotIndicator4 = this.indicatorView;
        if (guildDotIndicator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorView");
        } else {
            guildDotIndicator = guildDotIndicator4;
        }
        guildDotIndicator.a(arrayList.size());
        E(0);
    }

    private final void l() {
        BannerLayout bannerLayout = this.bannerLayout;
        BannerLayout bannerLayout2 = null;
        if (bannerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout = null;
        }
        bannerLayout.setAutoLoop(true);
        BannerLayout bannerLayout3 = this.bannerLayout;
        if (bannerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            bannerLayout3 = null;
        }
        bannerLayout3.setAutoLoopInterval(2000L);
        BannerLayout bannerLayout4 = this.bannerLayout;
        if (bannerLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
        } else {
            bannerLayout2 = bannerLayout4;
        }
        bannerLayout2.getStyleManager().a(new d());
    }

    private final boolean m() {
        boolean z16;
        IGProGetChannelActivityRsp iGProGetChannelActivityRsp = this.bannerData;
        if (iGProGetChannelActivityRsp == null) {
            return false;
        }
        Intrinsics.checkNotNull(iGProGetChannelActivityRsp);
        if (!iGProGetChannelActivityRsp.getIsShow()) {
            return false;
        }
        IGProGetChannelActivityRsp iGProGetChannelActivityRsp2 = this.bannerData;
        Intrinsics.checkNotNull(iGProGetChannelActivityRsp2);
        ArrayList<IGProChannelActivity> channelActivities = iGProGetChannelActivityRsp2.getChannelActivities();
        if (channelActivities != null && !channelActivities.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return true;
    }

    private final void o() {
        g.f428207a.f(this.guildId, p(), this.channelType, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.channelId);
        sb5.append('-');
        sb5.append(this.groupId);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(IGProGetChannelActivityRsp bannerData) {
        if (this.isAttachedPageVisible) {
            F(bannerData);
        } else {
            this.holdBannerData = new HoldBannerData(true, bannerData);
        }
    }

    private final void r() {
        A();
        l();
    }

    private final void s(long guildId, int channelType, Long channelId, Long groupId) {
        Logger.f235387a.d().i("Guild.comm.GuildOperationBanner", 1, "initData: " + guildId + " - " + channelId + " - " + channelType + " - " + this.channelId);
        if (!Intrinsics.areEqual(this.channelId, channelId) || !Intrinsics.areEqual(this.groupId, groupId)) {
            F(null);
        }
        this.guildId = guildId;
        this.channelId = channelId;
        this.channelType = channelType;
        this.groupId = groupId;
        o();
    }

    private final void v() {
        LayoutInflater.from(getContext()).inflate(R.layout.eih, this);
        View findViewById = findViewById(R.id.t49);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.banner_root)");
        this.bannerRootView = findViewById;
        View findViewById2 = findViewById(R.id.tzi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.close_bg)");
        this.closeButton = findViewById2;
        View findViewById3 = findViewById(R.id.f164574t41);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.banner_layout)");
        this.bannerLayout = (BannerLayout) findViewById3;
        View findViewById4 = findViewById(R.id.djp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.indicator)");
        this.indicatorView = (GuildDotIndicator) findViewById4;
        D(this.colorMode);
        r();
        View view = this.closeButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            view = null;
        }
        view.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(ViewPager2 viewPager2) {
        viewPager2.registerOnPageChangeCallback(new e(viewPager2));
    }

    private final void x(int position) {
        String str;
        boolean z16;
        q12.c cVar = this.adapter;
        q12.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar = null;
        }
        IGProChannelActivity k06 = cVar.k0(position);
        if (k06 != null) {
            str = k06.getActivityId();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.a d16 = Logger.f235387a.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reportClick error: ");
            sb5.append(position);
            sb5.append(" - ");
            q12.c cVar3 = this.adapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                cVar2 = cVar3;
            }
            sb5.append(cVar2.k0(position));
            d16.i("Guild.comm.GuildOperationBanner", 1, sb5.toString());
            return;
        }
        z("ev_sgrp_subchannel_banner_clk", str);
    }

    private final void y(int position) {
        String str;
        boolean z16;
        q12.c cVar = this.adapter;
        q12.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cVar = null;
        }
        IGProChannelActivity k06 = cVar.k0(position);
        if (k06 != null) {
            str = k06.getActivityId();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.a d16 = Logger.f235387a.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reportExpose error: ");
            sb5.append(position);
            sb5.append(" - ");
            q12.c cVar3 = this.adapter;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                cVar2 = cVar3;
            }
            sb5.append(cVar2.k0(position));
            d16.i("Guild.comm.GuildOperationBanner", 1, sb5.toString());
            return;
        }
        z("ev_sgrp_subchannel_banner_imp", str);
    }

    private final void z(String eventId, String activityId) {
        Logger.f235387a.d().i("Guild.comm.GuildOperationBanner", 1, "reportExpose: " + eventId + " - " + this.channelId + " - " + activityId + '}');
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", String.valueOf(this.guildId));
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(this.channelType));
        hashMap.put("sgrp_banner_id", activityId);
        Long l3 = this.groupId;
        if (l3 != null) {
            Intrinsics.checkNotNull(l3);
            hashMap.put("group_id", l3);
        }
        Long l16 = this.channelId;
        if (l16 != null) {
            hashMap.put("sgrp_sub_channel_id", String.valueOf(l16));
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent(eventId, hashMap);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isMoving = z16;
        if (ev5.getActionMasked() == 0 || ev5.getActionMasked() == 5) {
            BannerLayout bannerLayout = this.bannerLayout;
            if (bannerLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
                bannerLayout = null;
            }
            bannerLayout.a(true);
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final void n() {
        F(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        View view = this.closeButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            IGProGetChannelActivityRsp iGProGetChannelActivityRsp = this.bannerData;
            F(null);
            boolean z16 = false;
            if (iGProGetChannelActivityRsp != null && iGProGetChannelActivityRsp.getCloseOption() == 1) {
                z16 = true;
            }
            if (z16) {
                g.f428207a.d(this.guildId);
            } else {
                this.holdBannerData = new HoldBannerData(true, iGProGetChannelActivityRsp);
            }
            Logger.f235387a.d().i("Guild.comm.GuildOperationBanner", 1, "close banner, isReallyClose:" + z16);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r0 != 3) goto L15;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (Math.abs(ev5.getX() - this.initialX) > this.touchSlop) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.initialX = ev5.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        Logger.f235387a.d().i("Guild.comm.GuildOperationBanner", 1, "onVisibilityChanged: " + visibility);
        BannerLayout bannerLayout = null;
        if (visibility == 0) {
            BannerLayout bannerLayout2 = this.bannerLayout;
            if (bannerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            } else {
                bannerLayout = bannerLayout2;
            }
            bannerLayout.setAutoLoop(true);
        } else {
            BannerLayout bannerLayout3 = this.bannerLayout;
            if (bannerLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            } else {
                bannerLayout = bannerLayout3;
            }
            bannerLayout.setAutoLoop(false);
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final void setAttachedPageVisibility(boolean visible) {
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.comm.GuildOperationBanner", 1, "setAttachedPageVisibility: " + visible + "\uff0c origin\uff1a" + this.isAttachedPageVisible);
        if (this.isAttachedPageVisible == visible) {
            return;
        }
        this.isAttachedPageVisible = visible;
        BannerLayout bannerLayout = null;
        if (visible) {
            if (this.holdBannerData.getShouldUpdateAfterVisible()) {
                F(this.holdBannerData.getCacheBannerData());
            } else if (m()) {
                E(this.currentSelectedIndex);
            } else {
                logger.d().i("Guild.comm.GuildOperationBanner", 1, "do nothing while no data to show");
            }
            BannerLayout bannerLayout2 = this.bannerLayout;
            if (bannerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
            } else {
                bannerLayout = bannerLayout2;
            }
            bannerLayout.setAutoLoop(true);
            return;
        }
        BannerLayout bannerLayout3 = this.bannerLayout;
        if (bannerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerLayout");
        } else {
            bannerLayout = bannerLayout3;
        }
        bannerLayout.setAutoLoop(false);
    }

    public final void setBannerClickListener(@Nullable q12.d listener) {
        this.bannerClickListener = listener;
    }

    public final void t(long guildId, long groupId) {
        s(guildId, 9, null, Long.valueOf(groupId));
    }

    public final void u(long guildId, long channelId, int channelType) {
        s(guildId, channelType, Long.valueOf(channelId), null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildOperationBanner(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentSelectedIndex = -1;
        this.holdBannerData = new HoldBannerData(false, null, 2, 0 == true ? 1 : 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.A1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ble.GuildOperationBanner)");
        this.colorMode = obtainStyledAttributes.getInteger(j.B1, 0);
        obtainStyledAttributes.recycle();
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        v();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "shouldUpdateAfterVisible", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;", "cacheBannerData", "<init>", "(ZLcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetChannelActivityRsp;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.operationbanner.GuildOperationBanner$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class HoldBannerData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean shouldUpdateAfterVisible;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final IGProGetChannelActivityRsp cacheBannerData;

        public HoldBannerData(boolean z16, @Nullable IGProGetChannelActivityRsp iGProGetChannelActivityRsp) {
            this.shouldUpdateAfterVisible = z16;
            this.cacheBannerData = iGProGetChannelActivityRsp;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final IGProGetChannelActivityRsp getCacheBannerData() {
            return this.cacheBannerData;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShouldUpdateAfterVisible() {
            return this.shouldUpdateAfterVisible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HoldBannerData)) {
                return false;
            }
            HoldBannerData holdBannerData = (HoldBannerData) other;
            if (this.shouldUpdateAfterVisible == holdBannerData.shouldUpdateAfterVisible && Intrinsics.areEqual(this.cacheBannerData, holdBannerData.cacheBannerData)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.shouldUpdateAfterVisible;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            IGProGetChannelActivityRsp iGProGetChannelActivityRsp = this.cacheBannerData;
            if (iGProGetChannelActivityRsp == null) {
                hashCode = 0;
            } else {
                hashCode = iGProGetChannelActivityRsp.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "HoldBannerData(shouldUpdateAfterVisible=" + this.shouldUpdateAfterVisible + ", cacheBannerData=" + this.cacheBannerData + ')';
        }

        public /* synthetic */ HoldBannerData(boolean z16, IGProGetChannelActivityRsp iGProGetChannelActivityRsp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? null : iGProGetChannelActivityRsp);
        }
    }

    public final void setBannerVisibleListener(@Nullable q12.h listener) {
    }
}
