package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.g;
import x12.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001:\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u001dB\u000f\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/NavigatorUI;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "Lwk1/g$a;", "Landroid/view/ViewGroup;", "bottomLayoutRoot", "", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "", "contentWidth", "Lx12/s;", "guideBarBinding", "Lkotlin/Function0;", "onAdjust", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", BdhLogUtil.LogTag.Tag_Conn, "D", "B", "t", "isMember", "E", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "guildInfo", ReportConstant.COSTREPORT_PREFIX, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "init", "a", "", "action", "", "msg", "c", "", "state", "f", "Lwk1/a;", "d", "Lwk1/a;", "dependency", "e", "Lx12/s;", "binding", "Z", "isBindingSetup", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "hintTv", "i", "Landroid/view/ViewGroup;", "hostView", "Lkotlinx/coroutines/Job;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/Job;", "fetchGuildInfoJob", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/NavigatorUI$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/NavigatorUI$b;", "viewModel", "<init>", "(Lwk1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NavigatorUI implements d, g.a {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.a dependency;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isBindingSetup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView hintTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup hostView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job fetchGuildInfoJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/NavigatorUI$a;", "", "Lco1/k;", "a", "", "ALPHA_100", UserInfo.SEX_FEMALE, "ALPHA_50", "", "COLOR_INDEX_GUILD_DESC", "I", "COLOR_INDEX_GUILD_NAME", "GUILD_BTN_MARGIN_LEFT", "GUILD_BTN_SIZE", "GUILD_ICON_MARGIN_RIGHT", "GUILD_ICON_SIZE", "GUILD_NAME_WEIGHT", "", "PRESS_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/NavigatorUI$a$a", "Lco1/k;", "Landroidx/viewbinding/ViewBinding;", "servedViewBinding", "", "c", "Landroid/view/View;", "servedRootView", "b", "who", NodeProps.ON_CLICK, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7751a extends co1.k {
            C7751a() {
            }

            @Override // co1.k
            public void b(@NotNull View servedRootView) {
                Intrinsics.checkNotNullParameter(servedRootView, "servedRootView");
            }

            @Override // co1.k
            public void c(@NotNull ViewBinding servedViewBinding) {
                Intrinsics.checkNotNullParameter(servedViewBinding, "servedViewBinding");
                s sVar = (s) servedViewBinding;
                bt btVar = bt.f235484a;
                RelativeLayout root = sVar.getRoot();
                EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
                ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
                Intrinsics.checkNotNullExpressionValue(root, "root");
                bt.d(root, "em_sgrp_left_down_guide_join_channel", null, clickPolicy, null, endExposurePolicy, 20, null);
                TextView guildBtn = sVar.f447006c;
                ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
                ClickPolicy clickPolicy2 = ClickPolicy.REPORT_NONE;
                Intrinsics.checkNotNullExpressionValue(guildBtn, "guildBtn");
                bt.d(guildBtn, "em_sgrp_left_down_guide_join_channel_join", null, clickPolicy2, exposurePolicy, endExposurePolicy, 4, null);
            }

            @Override // co1.k, android.view.View.OnClickListener
            public void onClick(@NotNull View who) {
                EventCollector.getInstance().onViewClickedBefore(who);
                Intrinsics.checkNotNullParameter(who, "who");
                if (who.getId() == R.id.f165444w13) {
                    VideoReport.reportEvent("clck", who, null);
                }
                EventCollector.getInstance().onViewClicked(who);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final co1.k a() {
            return new C7751a();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/NavigatorUI$b", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "info", "", "d", "", "isMember", "e", "c", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "guildInfoMutable", "b", "isMemberMutable", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "guildInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MutableLiveData<GuideBarGuildInfo> guildInfoMutable = new MutableLiveData<>();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MutableLiveData<Boolean> isMemberMutable = new MutableLiveData<>();

        b() {
        }

        @NotNull
        public final LiveData<GuideBarGuildInfo> a() {
            return this.guildInfoMutable;
        }

        @NotNull
        public final LiveData<Boolean> b() {
            return this.isMemberMutable;
        }

        public final void c() {
            LifecycleOwner g16 = NavigatorUI.this.dependency.g();
            if (g16 != null) {
                a().removeObservers(g16);
                b().removeObservers(g16);
            }
        }

        public final void d(@Nullable GuideBarGuildInfo info) {
            if (info == null) {
                return;
            }
            Boolean isMember = info.getIsMember();
            if (isMember != null) {
                this.isMemberMutable.setValue(Boolean.valueOf(isMember.booleanValue()));
            }
            this.guildInfoMutable.setValue(info);
        }

        public final void e(boolean isMember) {
            this.isMemberMutable.setValue(Boolean.valueOf(isMember));
            GuideBarGuildInfo value = this.guildInfoMutable.getValue();
            if (value != null) {
                value.m(Boolean.valueOf(isMember));
            }
        }
    }

    public NavigatorUI(@NotNull wk1.a dependency) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        this.dependency = dependency;
        wk1.g d16 = dependency.d();
        if (d16 != null) {
            d16.c(this);
        }
        this.viewModel = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(NavigatorUI this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wk1.g d16 = this$0.dependency.d();
        if (d16 != null) {
            d16.b();
        }
        co1.k e16 = this$0.dependency.e();
        if (e16 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e16.onClick(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void B() {
        RelativeLayout relativeLayout;
        ViewGroup viewGroup = this.hostView;
        if (viewGroup != null) {
            r(viewGroup);
        }
        s sVar = this.binding;
        if (sVar != null) {
            relativeLayout = sVar.getRoot();
        } else {
            relativeLayout = null;
        }
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private final void C() {
        TextView textView = this.hintTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
            textView = null;
        }
        textView.setVisibility(8);
        B();
    }

    private final void D() {
        RelativeLayout root;
        TextView textView = this.hintTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintTv");
            textView = null;
        }
        textView.setVisibility(0);
        s sVar = this.binding;
        if (sVar != null && (root = sVar.getRoot()) != null) {
            ViewExtKt.a(root);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(boolean isMember) {
        if (!this.dependency.h()) {
            D();
            return;
        }
        if (isMember) {
            if (this.dependency.j()) {
                C();
                return;
            } else {
                D();
                return;
            }
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int contentWidth, s guideBarBinding, Function0<Unit> onAdjust) {
        int i3;
        float measuredWidth = guideBarBinding.f447009f.getMeasuredWidth();
        if (Intrinsics.areEqual(this.viewModel.b().getValue(), Boolean.TRUE)) {
            i3 = 0;
        } else {
            i3 = 44;
        }
        float d16 = measuredWidth - cw.d(((i3 + 36) + 17) + 8);
        if (contentWidth > d16) {
            int i16 = (int) d16;
            guideBarBinding.f447010g.setMaxWidth(i16);
            guideBarBinding.f447007d.setMaxWidth(i16);
            if (onAdjust != null) {
                onAdjust.invoke();
            }
        }
    }

    private final boolean r(ViewGroup bottomLayoutRoot) {
        ViewParent viewParent;
        RelativeLayout root;
        s sVar = this.binding;
        if (sVar != null && (root = sVar.getRoot()) != null) {
            viewParent = root.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) bottomLayoutRoot.findViewById(R.id.jnc);
        if (viewGroup == null) {
            return false;
        }
        s sVar2 = this.binding;
        if (sVar2 == null) {
            s g16 = s.g(LayoutInflater.from(bottomLayoutRoot.getContext()), viewGroup, true);
            int dimensionPixelSize = g16.getRoot().getResources().getDimensionPixelSize(R.dimen.f158711n0);
            g16.f447010g.setLineSpacing(dimensionPixelSize - r3.getPaint().getFontMetricsInt(null), 1.0f);
            g16.f447008e.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
            TextView guildName = g16.f447010g;
            Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
            com.tencent.mobileqq.guild.base.extension.s.a(guildName, 500, 1);
            this.binding = g16;
            w();
        } else {
            Intrinsics.checkNotNull(sVar2);
            viewGroup.addView(sVar2.getRoot());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(GuideBarGuildInfo guildInfo) {
        float f16;
        if (guildInfo == null) {
            QLog.e("NavigatorUI", 1, "updateViews|guildInfo == null");
            return;
        }
        s sVar = this.binding;
        if (sVar == null) {
            return;
        }
        String guildIcon = guildInfo.getGuildIcon();
        if (guildIcon != null) {
            u.l(sVar.f447008e, guildIcon, null);
        }
        String guildName = guildInfo.getGuildName();
        if (guildName != null) {
            sVar.f447010g.setText(guildName);
            TextView textView = sVar.f447010g;
            if (TopicHashtagTool.INSTANCE.e(guildName, 0, guildName.length()) >= 6.0f) {
                f16 = 15.0f;
            } else {
                f16 = 16.0f;
            }
            textView.setTextSize(f16);
        }
        String recommendTag = guildInfo.getRecommendTag();
        if (recommendTag != null) {
            sVar.f447007d.setText(GuildUIUtils.f235378a.s(recommendTag));
        }
        int[] b16 = this.dependency.b();
        if (b16 != null) {
            sVar.f447010g.setTextColor(b16[0]);
            sVar.f447007d.setTextColor(b16[1]);
        }
    }

    private final void t() {
        LifecycleOwner g16 = this.dependency.g();
        if (g16 == null) {
            QLog.e("NavigatorUI", 1, "Lifecycle is null, please check caller site!");
            return;
        }
        ViewGroup viewGroup = this.hostView;
        if (viewGroup != null && r(viewGroup) && !this.isBindingSetup) {
            z();
            x();
            this.viewModel.c();
            LiveData<GuideBarGuildInfo> a16 = this.viewModel.a();
            final Function1<GuideBarGuildInfo, Unit> function1 = new Function1<GuideBarGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$prepareGuideBar$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GuideBarGuildInfo guideBarGuildInfo) {
                    invoke2(guideBarGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable GuideBarGuildInfo guideBarGuildInfo) {
                    NavigatorUI.this.s(guideBarGuildInfo);
                }
            };
            a16.observe(g16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NavigatorUI.u(Function1.this, obj);
                }
            });
            LiveData<Boolean> b16 = this.viewModel.b();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$prepareGuideBar$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
                
                    r0 = r4.this$0.binding;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(Boolean isMember) {
                    s sVar;
                    s sVar2;
                    TextView textView;
                    sVar = NavigatorUI.this.binding;
                    boolean z16 = false;
                    if (sVar != null && (textView = sVar.f447006c) != null) {
                        textView.setVisibility(8);
                        ?? r26 = (View) com.tencent.guild.aio.util.ex.g.a(isMember, textView);
                        if (r26 == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView = r26;
                        }
                    }
                    if (!isMember.booleanValue() && sVar2 != null) {
                        if (sVar2.f447005b.isLaidOut() && sVar2.f447005b.getWidth() > 0) {
                            z16 = true;
                        }
                        if (!z16) {
                            sVar2 = null;
                        }
                        if (sVar2 != null) {
                            NavigatorUI.this.q(sVar2.f447005b.getWidth(), sVar2, null);
                        }
                    }
                    NavigatorUI navigatorUI = NavigatorUI.this;
                    Intrinsics.checkNotNullExpressionValue(isMember, "isMember");
                    navigatorUI.E(isMember.booleanValue());
                }
            };
            b16.observe(g16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NavigatorUI.v(Function1.this, obj);
                }
            });
            this.isBindingSetup = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void w() {
        if (this.binding == null) {
            QLog.e("NavigatorUI", 1, "setUpDtReport fail, ensure prepareNavigator called correctly");
            return;
        }
        co1.k e16 = this.dependency.e();
        if (e16 != null) {
            s sVar = this.binding;
            Intrinsics.checkNotNull(sVar);
            e16.c(sVar);
        }
    }

    private final void x() {
        final s sVar = this.binding;
        if (sVar == null) {
            return;
        }
        sVar.f447005b.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$setUpLayoutChangeListener$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                NavigatorUI navigatorUI = NavigatorUI.this;
                int i3 = right - left;
                final s sVar2 = sVar;
                navigatorUI.q(i3, sVar2, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$setUpLayoutChangeListener$1$onLayoutChange$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        s.this.f447005b.removeOnLayoutChangeListener(this);
                    }
                });
            }
        });
        sVar.f447010g.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                NavigatorUI.y(s.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(s guideBarBinding, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(guideBarBinding, "$guideBarBinding");
        TextView textView = guideBarBinding.f447007d;
        Intrinsics.checkNotNullExpressionValue(textView, "guideBarBinding.guildDesc");
        int i29 = 0;
        boolean z16 = true;
        if (guideBarBinding.f447010g.getLineCount() > 1) {
            z16 = false;
        }
        if (!z16) {
            i29 = 8;
        }
        textView.setVisibility(i29);
    }

    private final void z() {
        s sVar = this.binding;
        if (sVar == null) {
            return;
        }
        Intrinsics.checkNotNull(sVar);
        final RelativeLayout root = sVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        final long j3 = 200;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$setUpOnClickListener$lambda$5$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                root.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                wk1.g d16 = this.dependency.d();
                if (d16 != null) {
                    d16.a();
                }
                final View view = root;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$setUpOnClickListener$lambda$5$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        sVar.f447008e.setClickable(false);
        sVar.f447010g.setClickable(false);
        sVar.f447007d.setClickable(false);
        sVar.f447006c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigatorUI.A(NavigatorUI.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void a() {
        LifecycleCoroutineScope lifecycleScope;
        Job job = this.fetchGuildInfoJob;
        Job job2 = null;
        if (job != null) {
            JobKt__JobKt.cancel$default(job, "onContextInfoChanged", null, 2, null);
        }
        this.fetchGuildInfoJob = null;
        this.isBindingSetup = false;
        if (this.dependency.h() && !wk1.k.a(this.dependency)) {
            t();
            if (this.dependency.j() || !this.dependency.i()) {
                C();
            }
            LifecycleOwner g16 = this.dependency.g();
            if (g16 != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(g16)) != null) {
                job2 = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, ae.a().b(), null, new NavigatorUI$onContextInfoChange$1(this, null), 2, null);
            }
            this.fetchGuildInfoJob = job2;
            return;
        }
        D();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void b(@NotNull qj1.b bVar) {
        d.a.c(this, bVar);
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        s sVar;
        RelativeLayout root;
        boolean z16;
        co1.k e16;
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "message_on_bottom_interact_exposure") && (sVar = this.binding) != null && (root = sVar.getRoot()) != null) {
            if (root.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                root = null;
            }
            if (root != null && (e16 = this.dependency.e()) != null) {
                e16.a(root);
            }
        }
    }

    @Override // wk1.j
    @Nullable
    public Object d(@NotNull String str, @Nullable Object obj) {
        return d.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void e(@NotNull SpeakPermissionType speakPermissionType) {
        d.a.e(this, speakPermissionType);
    }

    @Override // wk1.g.a
    public void f(final short state) {
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI$onGuildStateChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                NavigatorUI.b bVar;
                NavigatorUI.b bVar2;
                short s16 = state;
                boolean z16 = true;
                if (s16 == 1) {
                    bVar2 = this.viewModel;
                    bVar2.e(true);
                    return;
                }
                if (s16 != 2 && s16 != 3) {
                    z16 = false;
                }
                if (z16) {
                    bVar = this.viewModel;
                    bVar.e(false);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void init(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.hostView = rootView;
        View findViewById = rootView.findViewById(R.id.u1l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.comment_hint_tv)");
        this.hintTv = (TextView) findViewById;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void u1(boolean z16) {
        d.a.f(this, z16);
    }
}
