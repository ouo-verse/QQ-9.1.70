package com.tencent.mobileqq.guild.home.parts;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.home.parts.GuildHomeLoadingPart;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeLoadingPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "", "T9", "R9", "", "from", "X9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "e", "Z", "hasShowContent", "f", "hasTintColor", tl.h.F, "hasHeaderList", "i", "hasPrint", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeLoadingPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasTintColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasHeaderList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasPrint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IPerformanceReportTask reportTask;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeLoadingPart$b", "Landroid/view/ViewTreeObserver$OnDrawListener;", "", "onDraw", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewTreeObserver.OnDrawListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f224955e;

        b(View view) {
            this.f224955e = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view, b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnDrawListener(this$0);
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (!GuildHomeLoadingPart.this.hasPrint) {
                Logger.f235387a.d().d("Guild.NewHome.GuildHomeLoadingPart", 1, "Guild Performance guild independent page pre draw");
            }
            GuildHomeLoadingPart.this.hasPrint = true;
            final View view = this.f224955e;
            view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.ba
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeLoadingPart.b.b(view, this);
                }
            });
        }
    }

    private final void R9() {
        Context context = getPartRootView().getContext();
        ((ImageView) getPartRootView().findViewById(R.id.ysa)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.az
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeLoadingPart.S9(GuildHomeLoadingPart.this, view);
            }
        });
        int color = ResourcesCompat.getColor(context.getResources(), R.color.qui_common_icon_allwhite_primary, null);
        ImageView imageView = (ImageView) getPartRootView().findViewById(R.id.ysa);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(GuildUIUtils.y(context, R.drawable.qui_chevron_left_icon_white, color));
        ((ImageView) getPartRootView().findViewById(R.id.ysz)).setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_title_notice_btn_icon_white, color));
        ((ImageView) getPartRootView().findViewById(R.id.f166137yt4)).setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_title_more_btn_icon_white, color));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(GuildHomeLoadingPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9() {
        this.hasShowContent = false;
        this.hasTintColor = false;
        this.hasHeaderList = false;
        this.hasPrint = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(GuildHomeLoadingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9("\u515c\u5e951s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(String from) {
        if (this.hasShowContent) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildHomeLoadingPart", "showContent from:" + from);
        }
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            iPerformanceReportTask = null;
        }
        iPerformanceReportTask.setExtra("from", from).report();
        dp1.a aVar = dp1.a.f394517a;
        String str = z9().f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        aVar.g(str, System.currentTimeMillis());
        this.hasShowContent = true;
        getPartRootView().findViewById(R.id.f79694_g).setVisibility(8);
        getPartRootView().findViewById(R.id.f79684_f).setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        ViewTreeObserver viewTreeObserver;
        ScanningLightView scanningLightView;
        super.onInitView(rootView);
        this.reportTask = C9().b().duplicate("guild_id").setStageCode("loading_dismiss");
        T9();
        R9();
        if (rootView != null && (scanningLightView = (ScanningLightView) rootView.findViewById(R.id.f79684_f)) != null) {
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
        }
        if (rootView != null) {
            view = rootView.findViewById(R.id.f79694_g);
        } else {
            view = null;
        }
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnDrawListener(new b(view));
        }
        LiveData<List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b>> b26 = E9().getGuildHomeHeaderBarsViewModel().b2();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final GuildHomeLoadingPart$onInitView$2 guildHomeLoadingPart$onInitView$2 = new GuildHomeLoadingPart$onInitView$2(this);
        b26.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeLoadingPart.U9(Function1.this, obj);
            }
        });
        LiveData<GuildHomeCoverColors> T1 = E9().getHeaderColorsViewModel().T1();
        LifecycleOwner hostLifecycleOwner2 = getPartHost().getHostLifecycleOwner();
        final GuildHomeLoadingPart$onInitView$3 guildHomeLoadingPart$onInitView$3 = new GuildHomeLoadingPart$onInitView$3(this);
        T1.observe(hostLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ax
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeLoadingPart.V9(Function1.this, obj);
            }
        });
        if (rootView != null) {
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.ay
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeLoadingPart.W9(GuildHomeLoadingPart.this);
                }
            }, 1000L);
        }
    }
}
