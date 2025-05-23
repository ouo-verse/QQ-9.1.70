package com.tencent.mobileqq.guild.home.parts;

import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeBanPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "initData", "Landroid/view/ViewStub;", "e", "Landroid/view/ViewStub;", "guildHomeBanViewStub", "Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "f", "Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "guildHomeBanLayout", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", tl.h.F, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "guildBanReportTask", "", "i", "Lkotlin/Lazy;", "N9", "()Ljava/util/List;", "shouldGoneViewsWhenBanned", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "Q9", "()Z", "setInflated", "(Z)V", "isInflated", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeBanPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewStub guildHomeBanViewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildHomeBanLayout guildHomeBanLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IPerformanceReportTask guildBanReportTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shouldGoneViewsWhenBanned;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isInflated;

    public GuildHomeBanPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends View>>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeBanPart$shouldGoneViewsWhenBanned$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends View> invoke() {
                List<? extends View> filterNotNull;
                filterNotNull = ArraysKt___ArraysKt.filterNotNull(new View[]{GuildHomeBanPart.this.getPartRootView().findViewById(R.id.x4w), GuildHomeBanPart.this.getPartRootView().findViewById(R.id.f165507wd2), GuildHomeBanPart.this.getPartRootView().findViewById(R.id.vaz), (ViewStub) GuildHomeBanPart.this.getPartRootView().findViewById(R.id.wjw), GuildHomeBanPart.this.getPartRootView().findViewById(R.id.b9w), GuildHomeBanPart.this.getPartRootView().findViewById(R.id.f98755ny), GuildHomeBanPart.this.getPartRootView().findViewById(R.id.u_r), GuildHomeBanPart.this.getPartRootView().findViewById(R.id.loading_layout)});
                return filterNotNull;
            }
        });
        this.shouldGoneViewsWhenBanned = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<View> N9() {
        return (List) this.shouldGoneViewsWhenBanned.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(GuildHomeBanPart this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* renamed from: Q9, reason: from getter */
    public final boolean getIsInflated() {
        return this.isInflated;
    }

    public final void initData() {
        ViewStub viewStub = this.guildHomeBanViewStub;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeBanViewStub");
            viewStub = null;
        }
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.guild.home.parts.g
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                GuildHomeBanPart.O9(GuildHomeBanPart.this, viewStub2, view);
            }
        });
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final GuildHomeBanPart$initData$2 guildHomeBanPart$initData$2 = new GuildHomeBanPart$initData$2(booleanRef, this, objectRef);
        e26.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeBanPart.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f165532wi2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_home_ban_layout)");
        this.guildHomeBanViewStub = (ViewStub) findViewById;
        this.guildBanReportTask = C9().b().duplicate(new String[0]).setStageCode("stage_ban_part");
        initData();
    }
}
