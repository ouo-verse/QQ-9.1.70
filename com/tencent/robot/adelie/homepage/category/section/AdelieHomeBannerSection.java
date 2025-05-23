package com.tencent.robot.adelie.homepage.category.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.adelie.homepage.category.section.AdelieHomeBannerSection;
import com.tencent.robot.adelie.homepage.category.view.AdelieGuideContainer;
import com.tencent.robot.adelie.homepage.category.viewmodel.BannerDelegateData;
import com.tencent.robot.adelie.homepage.eventbus.AdelieRobotGuideAnimationEvent;
import com.tencent.robot.adelie.homepage.eventbus.AdelieRobotGuideCompleteEvent;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.adelie.homepage.utils.AdelieGuideUtil;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.adelie.homepage.utils.i;
import com.tencent.robot.adelie.homepage.utils.n;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0004RST4B\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0003J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0003J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u001aH\u0002J\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0018H\u0014J\u0012\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&`'H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016J(\u00101\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020,2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0015J\b\u00102\u001a\u00020\u0005H\u0016R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\"\u0010>\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00180;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR#\u0010I\u001a\n D*\u0004\u0018\u00010@0@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010M\u00a8\u0006U"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/robot/adelie/homepage/eventbus/AdelieRobotGuideAnimationEvent;", "", "H", "Lt14/f;", "data", "J", "Landroid/widget/ImageView;", "imageView", "", "url", "O", "Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", "robotGuideView", "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "path", "M", "Landroid/view/View;", "view", "Lt14/a;", "L", "", "G", "", "getViewStubLayoutId", "containerView", "onInitView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", NodeProps.VISIBLE, "onVisibleChanged", "", "position", "", "", "payload", "N", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", "Ljava/util/List;", "bannerList", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "e", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "bannerLayout", "", "f", "Ljava/util/Map;", "reportPositionToViewMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "urlToDrawableCache", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", UserInfo.SEX_FEMALE, "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "lastPagePosition", "Z", "dispatched", "<init>", "()V", "D", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeBannerSection extends Section<BannerDelegateData> implements SimpleEventReceiver<AdelieRobotGuideAnimationEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean dispatched;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BannerLayout bannerLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastPagePosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<t14.a> bannerList = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, View> reportPositionToViewMap = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Drawable> urlToDrawableCache = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$a;", "Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$c;", "Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", "E", "Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", "l", "()Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", "adelieGuideContainer", "<init>", "(Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends c {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final AdelieGuideContainer adelieGuideContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AdelieGuideContainer adelieGuideContainer) {
            super(adelieGuideContainer);
            Intrinsics.checkNotNullParameter(adelieGuideContainer, "adelieGuideContainer");
            this.adelieGuideContainer = adelieGuideContainer;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final AdelieGuideContainer getAdelieGuideContainer() {
            return this.adelieGuideContainer;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$b;", "Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$c;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "imageView", "<init>", "(Landroid/widget/ImageView;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends c {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ImageView imageView) {
            super(imageView);
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.imageView = imageView;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static class c extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366002a;

        static {
            int[] iArr = new int[LoadState.values().length];
            try {
                iArr[LoadState.STATE_DOWNLOAD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadState.STATE_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f366002a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$f", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f extends ViewPager2.OnPageChangeCallback {
        f() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            int c16;
            Object orNull;
            super.onPageSelected(position);
            BannerLayout bannerLayout = AdelieHomeBannerSection.this.bannerLayout;
            if (bannerLayout == null || (c16 = bannerLayout.c(position)) < 0 || AdelieHomeBannerSection.this.lastPagePosition == c16) {
                return;
            }
            View view = (View) AdelieHomeBannerSection.this.reportPositionToViewMap.get(Integer.valueOf(c16));
            if (view != null) {
                AdelieHomeBannerSection adelieHomeBannerSection = AdelieHomeBannerSection.this;
                orNull = CollectionsKt___CollectionsKt.getOrNull(adelieHomeBannerSection.bannerList, c16);
                t14.a aVar = (t14.a) orNull;
                if (aVar == null) {
                    return;
                } else {
                    VideoReport.reportEvent("imp", view, adelieHomeBannerSection.G(aVar));
                }
            }
            AdelieHomeBannerSection.this.lastPagePosition = c16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$g", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/robot/adelie/homepage/category/section/AdelieHomeBannerSection$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "position", "getItemViewType", "holder", "", "j0", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class g extends RecyclerView.Adapter<c> {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(t14.a data, g this$0, AdelieHomeBannerSection this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            QLog.i("AdelieHomeBannerSection", 1, "banner click data=" + data);
            if (!u64.g.f438512a.g()) {
                n nVar = n.f366680a;
                Context context = this$1.getRootView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                nVar.f(context, ((t14.e) data).getScheme());
                VideoReport.reportEvent("clck", view, this$1.G(data));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AdelieHomeBannerSection.this.bannerList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return ((t14.a) AdelieHomeBannerSection.this.bannerList.get(position)).b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull c holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final t14.a aVar = (t14.a) AdelieHomeBannerSection.this.bannerList.get(position);
            if (aVar instanceof t14.e) {
                b bVar = (b) holder;
                ImageView imageView = bVar.getImageView();
                AdelieHomeBannerSection.this.O(imageView, ((t14.e) aVar).j());
                ImageView imageView2 = bVar.getImageView();
                final AdelieHomeBannerSection adelieHomeBannerSection = AdelieHomeBannerSection.this;
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.category.section.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AdelieHomeBannerSection.g.k0(t14.a.this, this, adelieHomeBannerSection, view);
                    }
                });
                AdelieHomeBannerSection.this.L(imageView, aVar);
                AdelieHomeBannerSection.this.reportPositionToViewMap.put(Integer.valueOf(position), imageView);
                return;
            }
            if (aVar instanceof t14.f) {
                AdelieGuideContainer adelieGuideContainer = ((a) holder).getAdelieGuideContainer();
                AdelieHomeBannerSection adelieHomeBannerSection2 = AdelieHomeBannerSection.this;
                t14.f fVar = (t14.f) aVar;
                adelieGuideContainer.f(fVar.getAdelieGuideInfo());
                adelieHomeBannerSection2.J(fVar);
                adelieHomeBannerSection2.L(adelieGuideContainer, aVar);
                adelieHomeBannerSection2.reportPositionToViewMap.put(Integer.valueOf(position), adelieGuideContainer);
                Context context = adelieGuideContainer.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                adelieHomeBannerSection2.C(fVar, adelieGuideContainer, context);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType != 1) {
                if (viewType != 2) {
                    ImageView imageView = new ImageView(AdelieHomeBannerSection.this.getRootView().getContext());
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return new b(imageView);
                }
                Context context = AdelieHomeBannerSection.this.getRootView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                AdelieGuideContainer adelieGuideContainer = new AdelieGuideContainer(context, null, 0, 6, null);
                adelieGuideContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new a(adelieGuideContainer);
            }
            ImageView imageView2 = new ImageView(AdelieHomeBannerSection.this.getRootView().getContext());
            imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new b(imageView2);
        }
    }

    public AdelieHomeBannerSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.robot.adelie.homepage.category.section.AdelieHomeBannerSection$loadingDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return AdelieHomeBannerSection.this.getRootView().getResources().getDrawable(R.drawable.qui_common_bg_middle_light_bg);
            }
        });
        this.loadingDrawable = lazy;
        this.lastPagePosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final t14.f data, final AdelieGuideContainer robotGuideView, final Context context) {
        robotGuideView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.category.section.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdelieHomeBannerSection.D(AdelieHomeBannerSection.this, data, context, robotGuideView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AdelieHomeBannerSection this$0, final t14.f data, final Context context, AdelieGuideContainer robotGuideView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(robotGuideView, "$robotGuideView");
        if (!u64.g.f438512a.g()) {
            final RobotCoreInfo robotInfo = data.getAdelieGuideInfo().robotInfo;
            i iVar = i.f366662a;
            if (iVar.a()) {
                AIOUtil aIOUtil = AIOUtil.f366629a;
                Intrinsics.checkNotNullExpressionValue(robotInfo, "robotInfo");
                AIOUtil.e(aIOUtil, context, robotInfo, "27", null, 8, null);
            } else {
                iVar.d();
                AdelieGuideUtil adelieGuideUtil = AdelieGuideUtil.f366639a;
                String str = data.getAdelieGuideInfo().fullscreenBg;
                Intrinsics.checkNotNullExpressionValue(str, "data.adelieGuideInfo.fullscreenBg");
                String str2 = data.getAdelieGuideInfo().bannerBg;
                Intrinsics.checkNotNullExpressionValue(str2, "data.adelieGuideInfo.bannerBg");
                String str3 = data.getAdelieGuideInfo().robotUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "data.adelieGuideInfo.robotUrl");
                adelieGuideUtil.d(str, str2, str3, new Function3<Bitmap, Bitmap, Bitmap, Unit>() { // from class: com.tencent.robot.adelie.homepage.category.section.AdelieHomeBannerSection$bannerRobotGuideToAio$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
                        invoke2(bitmap, bitmap2, bitmap3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2, @Nullable Bitmap bitmap3) {
                        String str4;
                        String str5;
                        AIOUtil aIOUtil2 = AIOUtil.f366629a;
                        aIOUtil2.g(bitmap);
                        if (je0.a.a(BaseApplication.getContext())) {
                            str4 = RobotCoreInfo.this.bgNight;
                            str5 = "robotInfo.bgNight";
                        } else {
                            str4 = RobotCoreInfo.this.bgDay;
                            str5 = "robotInfo.bgDay";
                        }
                        Intrinsics.checkNotNullExpressionValue(str4, str5);
                        ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackgroundUrl(str4, true);
                        RobotCoreInfo robotInfo2 = RobotCoreInfo.this;
                        Intrinsics.checkNotNullExpressionValue(robotInfo2, "robotInfo");
                        com.tencent.robot.profile.utils.a.v(robotInfo2);
                        Context context2 = context;
                        RobotCoreInfo robotInfo3 = RobotCoreInfo.this;
                        Intrinsics.checkNotNullExpressionValue(robotInfo3, "robotInfo");
                        aIOUtil2.d(context2, robotInfo3, "27", data.getAdelieGuideInfo());
                        VideoReport.reportEvent("ev_bas_agent_novice_boot", null, null);
                    }
                });
            }
            VideoReport.reportEvent("clck", robotGuideView, this$0.G(data));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable F() {
        return (Drawable) this.loadingDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> G(t14.a data) {
        Map<String, String> mapOf;
        Map<String, String> mapOf2;
        if (data instanceof t14.e) {
            t14.e eVar = (t14.e) data;
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_agent_home_page_new"), TuplesKt.to("banner_id", data.getId()), TuplesKt.to("banner_name", eVar.getName()), TuplesKt.to("pic_url", eVar.j()), TuplesKt.to("jump_address", eVar.getScheme()));
            return mapOf2;
        }
        if (data instanceof t14.f) {
            t14.f fVar = (t14.f) data;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_pgid", "pg_bas_agent_home_page_new"), TuplesKt.to("banner_name", fVar.getAdelieGuideInfo().title), TuplesKt.to("pic_url", fVar.getAdelieGuideInfo().robotUrl), TuplesKt.to("jump_address", fVar.getAdelieGuideInfo().videoUrl), TuplesKt.to("banner_id", data.getId()));
            return mapOf;
        }
        return null;
    }

    private final void H() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        g gVar = new g();
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAdapter(gVar);
        }
        BannerLayout bannerLayout2 = this.bannerLayout;
        if (bannerLayout2 != null) {
            viewPager2 = bannerLayout2.getViewPager2();
        } else {
            viewPager2 = null;
        }
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(1);
        }
        BannerLayout bannerLayout3 = this.bannerLayout;
        if (bannerLayout3 != null && (viewPager22 = bannerLayout3.getViewPager2()) != null) {
            viewPager22.registerOnPageChangeCallback(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(final t14.f data) {
        ViewTreeObserver viewTreeObserver;
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null && (viewTreeObserver = bannerLayout.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.robot.adelie.homepage.category.section.e
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    AdelieHomeBannerSection.K(AdelieHomeBannerSection.this, data);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AdelieHomeBannerSection this$0, t14.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Rect rect = new Rect();
        BannerLayout bannerLayout = this$0.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.getGlobalVisibleRect(rect);
        }
        AdelieRobotGuideCompleteEvent adelieRobotGuideCompleteEvent = new AdelieRobotGuideCompleteEvent(rect, data);
        BannerLayout bannerLayout2 = this$0.bannerLayout;
        if (bannerLayout2 != null) {
            bannerLayout2.setAutoScroll(false);
        }
        if (rect.left > 0 && !this$0.dispatched) {
            SimpleEventBus.getInstance().dispatchEvent(adelieRobotGuideCompleteEvent, false);
            this$0.dispatched = true;
            QLog.i("AdelieHomeBannerSection", 1, "section dispatchEvent " + adelieRobotGuideCompleteEvent.getRect());
        }
        BannerLayout bannerLayout3 = this$0.bannerLayout;
        if (bannerLayout3 != null) {
            bannerLayout3.setAutoScroll(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(View view, t14.a data) {
        Map<String, String> G = G(data);
        if (data instanceof t14.e) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, view, EmotionDaTongReportUtil.EM_BAS_BANNER, G, ((t14.e) data).j(), null, null, null, 112, null);
        } else if (data instanceof t14.f) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, view, EmotionDaTongReportUtil.EM_BAS_BANNER, G, ((t14.f) data).getAdelieGuideInfo().robotUrl, null, null, null, 112, null);
        }
    }

    @RequiresApi(api = 28)
    private final void M(ImageView imageView, String url, String path) {
        ImageDecoder.Source createSource;
        Drawable decodeDrawable;
        AnimatedImageDrawable animatedImageDrawable;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            createSource = ImageDecoder.createSource(new File(path));
            Intrinsics.checkNotNullExpressionValue(createSource, "createSource(File(path))");
            decodeDrawable = ImageDecoder.decodeDrawable(createSource);
            if (decodeDrawable instanceof AnimatedImageDrawable) {
                animatedImageDrawable = (AnimatedImageDrawable) decodeDrawable;
            } else {
                animatedImageDrawable = null;
            }
            imageView.setImageDrawable(animatedImageDrawable);
            if (animatedImageDrawable != null) {
                animatedImageDrawable.start();
            }
            this.urlToDrawableCache.put(url, animatedImageDrawable);
            QLog.i("AdelieHomeBannerSection", 1, "loadAnimatedWebP success, decode cost=" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (IOException e16) {
            QLog.e("AdelieHomeBannerSection", 1, "loadAnimatedWebP failed", e16);
            P(imageView, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(ImageView imageView, String url) {
        boolean endsWith;
        if (Build.VERSION.SDK_INT >= 28) {
            endsWith = StringsKt__StringsJVMKt.endsWith(url, ".webp", true);
            if (endsWith) {
                Q(imageView, url);
                return;
            }
        }
        P(imageView, url);
    }

    private final void P(ImageView imageView, String url) {
        QLog.i("AdelieHomeBannerSection", 1, "showNormalPic, url=" + url);
        CommonExKt.h(imageView, url, F(), F(), null, 8, null);
    }

    @RequiresApi(28)
    private final void Q(final ImageView imageView, final String url) {
        QLog.i("AdelieHomeBannerSection", 1, "showWebpPic, url=" + url);
        Drawable drawable = this.urlToDrawableCache.get(url);
        if (drawable != null) {
            QLog.i("AdelieHomeBannerSection", 1, "showWebpPic, hit cache");
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(F());
            final long currentTimeMillis = System.currentTimeMillis();
            QQPicLoader.f201806a.d().download(Option.obtain().setUrl(url).setLoadingDrawable(F()).setFailDrawable(F()).setPredecode(false), new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.category.section.d
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    AdelieHomeBannerSection.R(AdelieHomeBannerSection.this, imageView, url, currentTimeMillis, loadState, option);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AdelieHomeBannerSection this$0, ImageView imageView, String url, long j3, LoadState loadState, Option option) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(url, "$url");
        QLog.i("AdelieHomeBannerSection", 1, "showWebpPic QQPicLoader download, state=" + loadState + ", option=" + option);
        if (loadState == null) {
            i3 = -1;
        } else {
            i3 = e.f366002a[loadState.ordinal()];
        }
        if (i3 == 1 || i3 == 2) {
            String localPath = option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
            this$0.M(imageView, url, localPath);
            QLog.i("AdelieHomeBannerSection", 1, "showWebpPic after loadAnimatedWebP, cost=" + (System.currentTimeMillis() - j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable BannerDelegateData data, int position, @NotNull List<? extends Object> payload) {
        t14.b bVar;
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> b16;
        BannerLayout bannerLayout;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (data != null) {
            bVar = data.getBannerConfig();
        } else {
            bVar = null;
        }
        QLog.i("AdelieHomeBannerSection", 1, "onBindData config=" + bVar);
        ArrayList arrayList = new ArrayList();
        if (data != null) {
            if (data.getBannerConfig().getLoopInterval() > 0 && (bannerLayout = this.bannerLayout) != null) {
                bannerLayout.setAutoLoopInterval(data.getBannerConfig().getLoopInterval());
            }
            t14.f robotGuideInfo = data.getRobotGuideInfo();
            if (robotGuideInfo != null) {
                arrayList.add(robotGuideInfo);
            }
            arrayList.addAll(data.getBannerConfig().a());
        }
        this.bannerList = arrayList;
        BannerLayout bannerLayout2 = this.bannerLayout;
        if (bannerLayout2 != null && (b16 = bannerLayout2.b()) != null) {
            b16.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<AdelieRobotGuideAnimationEvent>> getEventClass() {
        ArrayList<Class<AdelieRobotGuideAnimationEvent>> arrayList = new ArrayList<>();
        arrayList.add(AdelieRobotGuideAnimationEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        AnimatedImageDrawable animatedImageDrawable;
        super.onDestroy();
        for (Drawable drawable : this.urlToDrawableCache.values()) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (drawable instanceof AnimatedImageDrawable) {
                    animatedImageDrawable = (AnimatedImageDrawable) drawable;
                } else {
                    animatedImageDrawable = null;
                }
                if (animatedImageDrawable != null) {
                    animatedImageDrawable.stop();
                }
            }
        }
        this.urlToDrawableCache.clear();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        BannerLayout bannerLayout;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        FontSettingManager.resetViewSize2Normal(containerView.getContext(), containerView);
        View rootView = getRootView();
        if (rootView != null) {
            bannerLayout = (BannerLayout) rootView.findViewById(R.id.f164746tp0);
        } else {
            bannerLayout = null;
        }
        this.bannerLayout = bannerLayout;
        H();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        BannerLayout bannerLayout;
        if ((event instanceof AdelieRobotGuideAnimationEvent) && (bannerLayout = this.bannerLayout) != null) {
            bannerLayout.setAutoScroll(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        QLog.i("AdelieHomeBannerSection", 1, "onVisibleChanged, visible=" + visible);
        super.onVisibleChanged(visible);
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAutoScroll(visible);
        }
    }
}
