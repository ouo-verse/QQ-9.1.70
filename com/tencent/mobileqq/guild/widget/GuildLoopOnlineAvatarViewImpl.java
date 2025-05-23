package com.tencent.mobileqq.guild.widget;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.GuildLoopOnlineAvatarView;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.setting.member.view.GuildOnlineMemberDialogFragment;
import com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberLoopView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001?B%\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010!R\u001e\u0010%\u001a\n #*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u001c\u0010)\u001a\n #*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\n #*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00101\u001a\n #*\u0004\u0018\u00010.0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildLoopOnlineAvatarViewImpl;", "Lcom/tencent/mobileqq/guild/api/GuildLoopOnlineAvatarView;", "Ld02/b;", "Lcom/tencent/mobileqq/guild/api/h;", "callback", "", "setOnJumpChannelCallback", "", "jumpChannelId", "", "channelType", "z0", "Ldg1/b;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "feedSummary", "q1", "Landroidx/fragment/app/FragmentActivity;", "e", "Landroidx/fragment/app/FragmentActivity;", "i", "()Landroidx/fragment/app/FragmentActivity;", "context", "Landroid/os/Bundle;", "f", "Landroid/os/Bundle;", "getParams", "()Landroid/os/Bundle;", "params", tl.h.F, "Ljava/lang/String;", "mGuildId", "", "J", "mChannelId", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "elementID", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;", "D", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;", "mAvatarList", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mText", "", UserInfo.SEX_FEMALE, "Z", "isStartShow", "Ljava/lang/Runnable;", "G", "Ljava/lang/Runnable;", "delayHideFunc", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLoopOnlineAvatarViewImpl extends GuildLoopOnlineAvatarView implements d02.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private final GuildMemberLoopView mAvatarList;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView mText;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isStartShow;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Runnable delayHideFunc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle params;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mChannelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String elementID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLoopOnlineAvatarViewImpl(@NotNull FragmentActivity context, @Nullable AttributeSet attributeSet, @NotNull Bundle params) {
        super(context, attributeSet);
        ExposurePolicy exposurePolicy;
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        this.context = context;
        this.params = params;
        this.mGuildId = "";
        this.elementID = params.getString("dt_element_id", "");
        View inflate = View.inflate(context, R.layout.f1n, this);
        this.mRootView = inflate;
        GuildMemberLoopView guildMemberLoopView = (GuildMemberLoopView) inflate.findViewById(R.id.t1l);
        this.mAvatarList = guildMemberLoopView;
        TextView textView = (TextView) inflate.findViewById(R.id.jfb);
        textView.setText(params.getString("text_content", ""));
        textView.setTextColor(params.getInt("text_color", textView.getResources().getColor(R.color.f158017al3)));
        this.mText = textView;
        this.delayHideFunc = new Runnable() { // from class: com.tencent.mobileqq.guild.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                GuildLoopOnlineAvatarViewImpl.f(GuildLoopOnlineAvatarViewImpl.this);
            }
        };
        guildMemberLoopView.setAvatarSize(params.getInt("avatar_size", ViewUtils.dpToPx(18.0f)));
        guildMemberLoopView.setAvatarBorderDark(params.getBoolean("avatar_border_dark", false));
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        String str = this.elementID;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        if (params.getBoolean("auto_report", false)) {
            exposurePolicy = ExposurePolicy.REPORT_FIRST;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        }
        iGuildDTReportApi.setElementReport(this, str, clickPolicy, exposurePolicy);
        IGuildDTReportApi iGuildDTReportApi2 = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        emptyMap = MapsKt__MapsKt.emptyMap();
        iGuildDTReportApi2.setElementParams(this, emptyMap);
        jt1.b.b(this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.widget.GuildLoopOnlineAvatarViewImpl.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map emptyMap2;
                Intrinsics.checkNotNullParameter(it, "it");
                emptyMap2 = MapsKt__MapsKt.emptyMap();
                VideoReport.reportEvent("clck", it, emptyMap2);
                GuildOnlineMemberDialogFragment.Companion companion = GuildOnlineMemberDialogFragment.INSTANCE;
                FragmentManager supportFragmentManager = GuildLoopOnlineAvatarViewImpl.this.getContext().getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.supportFragmentManager");
                companion.a(supportFragmentManager, GuildLoopOnlineAvatarViewImpl.this.mGuildId, GuildLoopOnlineAvatarViewImpl.this.mChannelId, GuildLoopOnlineAvatarViewImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final GuildLoopOnlineAvatarViewImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isStartShow = false;
        if (this$0.getParent() != null && (this$0.getParent() instanceof ViewGroup)) {
            ViewParent parent = this$0.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            final ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.animate().alpha(0.0f).setDuration(400L).withStartAction(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.o
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLoopOnlineAvatarViewImpl.g(GuildLoopOnlineAvatarViewImpl.this);
                }
            }).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLoopOnlineAvatarViewImpl.h(viewGroup);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildLoopOnlineAvatarViewImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mRootView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        parentView.setAlpha(1.0f);
        parentView.setVisibility(8);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final FragmentActivity getContext() {
        return this.context;
    }

    @Override // d02.b
    public void q1(@NotNull dg1.b channelInfo, @NotNull IGProFeedSummary feedSummary) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(feedSummary, "feedSummary");
        long channelId = channelInfo.getChannelId();
        long guildId = channelInfo.getGuildId();
        if (ch.C(ch.l(), String.valueOf(guildId), String.valueOf(channelId)) == null) {
            QLog.i("GuildLoopOnlineAvatarViewImpl", 1, "onItemClicked: error, channel info is null.");
            return;
        }
        boolean j06 = ch.j0(this.mGuildId);
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) this.params.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        if (j06 && joinInfoParam == null) {
            QQToast.makeText(this.context, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("joinGuildParams is null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildLoopOnlineAvatarViewImpl", 1, (String) it.next(), null);
            }
            return;
        }
        QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) api;
        BaseApplication baseApplication = BaseApplication.context;
        Bundle bundle = new Bundle();
        bundle.putString("guildId", String.valueOf(guildId));
        bundle.putString("channelId", String.valueOf(channelId));
        bundle.putString("feedId", feedSummary.getFeedId());
        bundle.putString("visitorTinyId", ch.g());
        bundle.putParcelable("joinInfoParam", joinInfoParam);
        Unit unit = Unit.INSTANCE;
        IGuildFeedLauncherApi.a.a(iGuildFeedLauncherApi, baseApplication, bundle, false, 4, null);
    }

    @Override // com.tencent.mobileqq.guild.api.GuildLoopOnlineAvatarView
    public void setOnJumpChannelCallback(@NotNull com.tencent.mobileqq.guild.api.h callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // d02.b
    public void z0(@NotNull String jumpChannelId, int channelType) {
        Intrinsics.checkNotNullParameter(jumpChannelId, "jumpChannelId");
        boolean j06 = ch.j0(this.mGuildId);
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) this.params.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) this.params.getParcelable("GuildAppReportSourceInfo");
        if (j06 && (joinInfoParam == null || guildAppReportSourceInfo == null)) {
            QQToast.makeText(this.context, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("joinGuildParams or appReportParas is null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildLoopOnlineAvatarViewImpl", 1, (String) it.next(), null);
            }
            return;
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openChannelInChannel(this.context, String.valueOf(this.mChannelId), this.mGuildId, jumpChannelId, channelType, joinInfoParam, guildAppReportSourceInfo, 11);
    }
}
