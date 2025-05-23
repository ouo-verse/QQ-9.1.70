package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedOperateData;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u0016\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareInviteSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/n;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData;", "Landroid/view/ViewGroup;", "v", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "containerView", "B", "D", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "", "getViewStubLayoutId", "onInitView", "data", "", "position", "", "", "payload", "G", "", "attached", "onAttachedChanged", "Lx12/w;", "e", "Lx12/w;", "binding", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareInviteSection extends n<GuildFeedOperateData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private x12.w binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f219112d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareInviteSection f219113e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f219114f;

        public b(View view, GuildFeedSquareInviteSection guildFeedSquareInviteSection, View view2) {
            this.f219112d = view;
            this.f219113e = guildFeedSquareInviteSection;
            this.f219114f = view2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this.f219113e.B(this.f219114f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f219115d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareInviteSection f219116e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f219117f;

        public c(View view, GuildFeedSquareInviteSection guildFeedSquareInviteSection, View view2) {
            this.f219115d = view;
            this.f219116e = guildFeedSquareInviteSection;
            this.f219117f = view2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this.f219116e.D(this.f219117f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f219118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareInviteSection f219119e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f219120f;

        public d(View view, GuildFeedSquareInviteSection guildFeedSquareInviteSection, View view2) {
            this.f219118d = view;
            this.f219119e = guildFeedSquareInviteSection;
            this.f219120f = view2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this.f219119e.C(this.f219120f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f219121d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareInviteSection f219122e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f219123f;

        public e(View view, GuildFeedSquareInviteSection guildFeedSquareInviteSection, View view2) {
            this.f219121d = view;
            this.f219122e = guildFeedSquareInviteSection;
            this.f219123f = view2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this.f219122e.F(this.f219123f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private final void A(ViewGroup v3) {
        Sequence map;
        Sequence filterNotNull;
        Object firstOrNull;
        Map mapOf;
        VideoReport.setElementId(v3, "em_sgrp_empty_share_item");
        map = SequencesKt___SequencesKt.map(ViewGroupKt.getChildren(v3), new Function1<View, TextView>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareInviteSection$dtReport$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final TextView invoke(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof TextView) {
                    return (TextView) it;
                }
                return null;
            }
        });
        filterNotNull = SequencesKt___SequencesKt.filterNotNull(map);
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(filterNotNull);
        TextView textView = (TextView) firstOrNull;
        if (textView != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_name", textView.getText().toString()));
            VideoReport.setElementParams(v3, mapOf);
        }
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(v3, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(View containerView) {
        Activity activity;
        xj1.c u16;
        Long longOrNull;
        Context context = containerView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (u16 = u()) != null && (r0 = u16.getGuildId()) != null && longOrNull != null) {
            yz1.d.INSTANCE.a(activity, longOrNull.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(View containerView) {
        String guildId;
        final Activity activity;
        if (!m02.d.i()) {
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f156731l0);
            return;
        }
        xj1.c u16 = u();
        if (u16 != null && (guildId = u16.getGuildId()) != null) {
            Context context = containerView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                return;
            }
            GuildMainFrameUtils.i(guildId, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareInviteSection$handleShare2Wechat$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                    invoke2(guildAndChannelInfoRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                    Intrinsics.checkNotNullParameter(guildAndChannelInfoRsp, "guildAndChannelInfoRsp");
                    ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).shareGuildToWechatFriend(activity, guildAndChannelInfoRsp.h(), GuildSharePageSource.FEED_SQUARE_SHARE);
                }
            }, 30, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(View containerView) {
        String guildId;
        final Activity activity;
        xj1.c u16 = u();
        if (u16 != null && (guildId = u16.getGuildId()) != null) {
            Context context = containerView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                return;
            }
            GuildMainFrameUtils.i(guildId, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareInviteSection$handleShareQQ$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                    invoke2(guildAndChannelInfoRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                    Intrinsics.checkNotNullParameter(guildAndChannelInfoRsp, "guildAndChannelInfoRsp");
                    ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).shareGuildToQQ(activity, guildAndChannelInfoRsp.h(), GuildSharePageSource.FEED_SQUARE_SHARE);
                }
            }, 30, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(View containerView) {
        Activity activity;
        xj1.c u16;
        String guildId;
        Context context = containerView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (u16 = u()) != null && (guildId = u16.getGuildId()) != null) {
            GuildSettingQRCodeFragment.INSTANCE.a(activity, guildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        x12.w e16 = x12.w.e(containerView);
        LinearLayout groupShareInvite = e16.f447040b;
        Intrinsics.checkNotNullExpressionValue(groupShareInvite, "groupShareInvite");
        groupShareInvite.setOnClickListener(new b(groupShareInvite, this, containerView));
        LinearLayout groupShareInvite2 = e16.f447040b;
        Intrinsics.checkNotNullExpressionValue(groupShareInvite2, "groupShareInvite");
        A(groupShareInvite2);
        LinearLayout groupShareQq = e16.f447041c;
        Intrinsics.checkNotNullExpressionValue(groupShareQq, "groupShareQq");
        groupShareQq.setOnClickListener(new c(groupShareQq, this, containerView));
        LinearLayout groupShareQq2 = e16.f447041c;
        Intrinsics.checkNotNullExpressionValue(groupShareQq2, "groupShareQq");
        A(groupShareQq2);
        LinearLayout groupShareWechat = e16.f447043e;
        Intrinsics.checkNotNullExpressionValue(groupShareWechat, "groupShareWechat");
        groupShareWechat.setOnClickListener(new d(groupShareWechat, this, containerView));
        LinearLayout groupShareWechat2 = e16.f447043e;
        Intrinsics.checkNotNullExpressionValue(groupShareWechat2, "groupShareWechat");
        A(groupShareWechat2);
        LinearLayout groupShareQrcode = e16.f447042d;
        Intrinsics.checkNotNullExpressionValue(groupShareQrcode, "groupShareQrcode");
        groupShareQrcode.setOnClickListener(new e(groupShareQrcode, this, containerView));
        LinearLayout groupShareQrcode2 = e16.f447042d;
        Intrinsics.checkNotNullExpressionValue(groupShareQrcode2, "groupShareQrcode");
        A(groupShareQrcode2);
        DisplayMetrics displayMetrics = e16.getRoot().getContext().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "it.root.context.resources.displayMetrics");
        float f16 = FontSettingManager.systemMetrics.density / displayMetrics.density;
        if (f16 < 1.0f) {
            ConstraintLayout constraintLayout = e16.f447044f;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "it.iconContainer");
            kotlin.h.e(constraintLayout, (int) (com.tencent.mobileqq.utils.am.a(34.0f) * f16));
        }
        this.binding = e16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable GuildFeedOperateData data, int position, @Nullable List<Object> payload) {
    }
}
