package com.tencent.mobileqq.guild.media.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003()*B;\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\"\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e`\u001f\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u0012\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR3\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e`\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/guild/media/widget/be;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "waitingList", "allowedList", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;", "fragment", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "getMPageParam", "()Ljava/util/HashMap;", "mPageParam", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;Ljava/util/HashMap;)V", "E", "a", "GuildRaiseHandViewHolder", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRaiseHandAdapter extends ListAdapter<RaiseHandData, RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildRaiseHandDialogFragment fragment;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mPageParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0004\b5\u00106J<\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R3\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\n !*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u001c\u0010-\u001a\n !*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010/\u001a\n !*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u001c\u00103\u001a\n !*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandAdapter$GuildRaiseHandViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "reportView", "", "elementId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/media/widget/be;", "data", "guildId", "o", "Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;", "E", "Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;", "p", "()Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;", "fragment", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "getMPageParam", "()Ljava/util/HashMap;", "mPageParam", "G", "Ljava/lang/String;", "mTinyId", "H", "mNickName", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "I", "Landroid/view/ViewGroup;", "rightWaitingBtn", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mUserNameTv", "K", "rightApprovedBtn", "L", "Landroid/view/View;", "accept", "M", "reject", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "N", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "headView", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;Ljava/util/HashMap;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class GuildRaiseHandViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final GuildRaiseHandDialogFragment fragment;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final HashMap<String, Object> mPageParam;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private String mTinyId;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private String mNickName;

        /* renamed from: I, reason: from kotlin metadata */
        private final ViewGroup rightWaitingBtn;

        /* renamed from: J, reason: from kotlin metadata */
        private final TextView mUserNameTv;

        /* renamed from: K, reason: from kotlin metadata */
        private final ViewGroup rightApprovedBtn;

        /* renamed from: L, reason: from kotlin metadata */
        private final View accept;

        /* renamed from: M, reason: from kotlin metadata */
        private final View reject;

        /* renamed from: N, reason: from kotlin metadata */
        private final GuildUserAvatarView headView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildRaiseHandViewHolder(@NotNull View itemView, @NotNull GuildRaiseHandDialogFragment fragment, @NotNull HashMap<String, Object> mPageParam) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(mPageParam, "mPageParam");
            this.fragment = fragment;
            this.mPageParam = mPageParam;
            this.mTinyId = "";
            this.mNickName = "";
            this.rightWaitingBtn = (ViewGroup) itemView.findViewById(R.id.f74893xh);
            this.mUserNameTv = (TextView) itemView.findViewById(R.id.f114996uu);
            ViewGroup rightApprovedBtn$lambda$0 = (ViewGroup) itemView.findViewById(R.id.f74493we);
            Intrinsics.checkNotNullExpressionValue(rightApprovedBtn$lambda$0, "rightApprovedBtn$lambda$0");
            jt1.b.b(rightApprovedBtn$lambda$0, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter$GuildRaiseHandViewHolder$rightApprovedBtn$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    String str;
                    String str2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    str = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mTinyId;
                    str2 = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mNickName;
                    MediaChannelRevokeRaiseHandDialog mediaChannelRevokeRaiseHandDialog = new MediaChannelRevokeRaiseHandDialog(str, str2);
                    FragmentManager childFragmentManager = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.getFragment().getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    com.tencent.mobileqq.guild.base.extension.d.a(mediaChannelRevokeRaiseHandDialog, childFragmentManager, "MediaChannelRevokeRaiseHandDialog");
                }
            });
            this.rightApprovedBtn = rightApprovedBtn$lambda$0;
            final View accept$lambda$1 = itemView.findViewById(R.id.f163839w);
            Intrinsics.checkNotNullExpressionValue(accept$lambda$1, "accept$lambda$1");
            jt1.b.b(accept$lambda$1, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter$GuildRaiseHandViewHolder$accept$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str;
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildRaiseHandAdapter.GuildRaiseHandViewHolder guildRaiseHandViewHolder = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this;
                    View view = accept$lambda$1;
                    Intrinsics.checkNotNullExpressionValue(view, "this");
                    guildRaiseHandViewHolder.q(view, "em_sgrp_avchannel_handup_allow", new HashMap());
                    MediaChannelRaiseHandHelper T = com.tencent.mobileqq.guild.media.core.j.a().T();
                    str = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mTinyId;
                    final GuildRaiseHandAdapter.GuildRaiseHandViewHolder guildRaiseHandViewHolder2 = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this;
                    T.l1(str, true, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter$GuildRaiseHandViewHolder$accept$1$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                            invoke(num.intValue(), str2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3, @NotNull String msg2) {
                            String str2;
                            Intrinsics.checkNotNullParameter(msg2, "msg");
                            com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
                            str2 = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mTinyId;
                            aaVar.k(true, str2, i3, msg2);
                        }
                    });
                }
            });
            this.accept = accept$lambda$1;
            final View reject$lambda$2 = itemView.findViewById(R.id.i6k);
            Intrinsics.checkNotNullExpressionValue(reject$lambda$2, "reject$lambda$2");
            jt1.b.b(reject$lambda$2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter$GuildRaiseHandViewHolder$reject$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str;
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildRaiseHandAdapter.GuildRaiseHandViewHolder guildRaiseHandViewHolder = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this;
                    View view = reject$lambda$2;
                    Intrinsics.checkNotNullExpressionValue(view, "this");
                    guildRaiseHandViewHolder.q(view, "em_sgrp_avchannel_handup_reject", new HashMap());
                    MediaChannelRaiseHandHelper T = com.tencent.mobileqq.guild.media.core.j.a().T();
                    str = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mTinyId;
                    final GuildRaiseHandAdapter.GuildRaiseHandViewHolder guildRaiseHandViewHolder2 = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this;
                    T.l1(str, false, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter$GuildRaiseHandViewHolder$reject$1$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                            invoke(num.intValue(), str2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3, @NotNull String msg2) {
                            String str2;
                            Intrinsics.checkNotNullParameter(msg2, "msg");
                            com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
                            str2 = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mTinyId;
                            aaVar.k(false, str2, i3, msg2);
                        }
                    });
                }
            });
            this.reject = reject$lambda$2;
            GuildUserAvatarView headView$lambda$3 = (GuildUserAvatarView) itemView.findViewById(R.id.x87);
            Intrinsics.checkNotNullExpressionValue(headView$lambda$3, "headView$lambda$3");
            jt1.b.b(headView$lambda$3, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter$GuildRaiseHandViewHolder$headView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    String str;
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildRaiseHandDialogFragment fragment2 = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.getFragment();
                    str = GuildRaiseHandAdapter.GuildRaiseHandViewHolder.this.mTinyId;
                    fragment2.xh(str);
                }
            });
            this.headView = headView$lambda$3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q(View reportView, String elementId, HashMap<String, Object> param) {
            Map plus;
            VideoReport.setElementId(reportView, elementId);
            VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
            plus = MapsKt__MapsKt.plus(param, this.mPageParam);
            VideoReport.reportEvent("clck", reportView, plus);
        }

        public final void o(@NotNull RaiseHandData data, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.mUserNameTv.setText(data.getNickName());
            this.mTinyId = data.getTinyId();
            this.mNickName = data.getNickName();
            this.headView.setAvatarMeta(guildId, data.getTinyId(), data.getAvatarMeta());
            if (MediaChannelRaiseHandHelper.INSTANCE.a(data.getState())) {
                this.rightWaitingBtn.setVisibility(0);
                this.rightApprovedBtn.setVisibility(8);
            } else {
                this.rightWaitingBtn.setVisibility(8);
                this.rightApprovedBtn.setVisibility(0);
            }
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final GuildRaiseHandDialogFragment getFragment() {
            return this.fragment;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/be;", "data", "", "l", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "tv", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class b extends RecyclerView.ViewHolder {

        @NotNull
        private static final Map<String, String> G;

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView tv;

        static {
            Map<String, String> mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("-1", "\u4e3e\u624b\u53d1\u8a00"), TuplesKt.to("-2", "\u5df2\u5141\u8bb8\u53d1\u8a00"));
            G = mapOf;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.tv = (TextView) itemView.findViewById(R.id.k4a);
        }

        public final void l(@NotNull RaiseHandData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            TextView textView = this.tv;
            String str = G.get(data.getTinyId());
            textView.setText(((Object) str) + "\uff08" + data.getNickName() + "\uff09");
            if (Intrinsics.areEqual("\u5df2\u5141\u8bb8\u53d1\u8a00", this.tv.getText())) {
                this.itemView.setPadding(0, (int) cw.b(24), 0, 0);
            } else {
                this.itemView.setPadding(0, 0, 0, 0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRaiseHandAdapter(@NotNull String guildId, @NotNull GuildRaiseHandDialogFragment fragment, @NotNull HashMap<String, Object> mPageParam) {
        super(new an());
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mPageParam, "mPageParam");
        this.guildId = guildId;
        this.fragment = fragment;
        this.mPageParam = mPageParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        boolean z16;
        String tinyId = getItem(position).getTinyId();
        if (Intrinsics.areEqual(tinyId, "-1")) {
            z16 = 1;
        } else {
            z16 = Intrinsics.areEqual(tinyId, "-2");
        }
        return !z16;
    }

    public final void i0(@Nullable List<? extends IGProUserInfo> waitingList, @Nullable List<? extends IGProUserInfo> allowedList) {
        List emptyList;
        List plus;
        int collectionSizeOrDefault;
        List plus2;
        int collectionSizeOrDefault2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        String str = "0";
        if (waitingList != null && (!waitingList.isEmpty())) {
            List list = emptyList;
            String valueOf = String.valueOf(waitingList.size());
            if (valueOf == null) {
                valueOf = "0";
            }
            plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends RaiseHandData>) ((Collection<? extends Object>) list), new RaiseHandData("-1", valueOf, -1, ""));
            List list2 = plus2;
            List<? extends IGProUserInfo> list3 = waitingList;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            for (IGProUserInfo iGProUserInfo : list3) {
                String tinyId = iGProUserInfo.getTinyId();
                Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
                String name = iGProUserInfo.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.displayName");
                int userAVState = iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserAVState();
                String avatarMeta = iGProUserInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                arrayList.add(new RaiseHandData(tinyId, name, userAVState, avatarMeta));
            }
            emptyList = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) arrayList);
        }
        if (allowedList != null && (!allowedList.isEmpty())) {
            List list4 = emptyList;
            String valueOf2 = String.valueOf(allowedList.size());
            if (valueOf2 != null) {
                str = valueOf2;
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends RaiseHandData>) ((Collection<? extends Object>) list4), new RaiseHandData("-2", str, -1, ""));
            List list5 = plus;
            List<? extends IGProUserInfo> list6 = allowedList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (IGProUserInfo iGProUserInfo2 : list6) {
                String tinyId2 = iGProUserInfo2.getTinyId();
                Intrinsics.checkNotNullExpressionValue(tinyId2, "it.tinyId");
                String name2 = iGProUserInfo2.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "it.displayName");
                int userAVState2 = iGProUserInfo2.getBusinessInfo().getUserAVInfo().getUserAVState();
                String avatarMeta2 = iGProUserInfo2.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta2, "it.avatarMeta");
                arrayList2.add(new RaiseHandData(tinyId2, name2, userAVState2, avatarMeta2));
            }
            emptyList = CollectionsKt___CollectionsKt.plus((Collection) list5, (Iterable) arrayList2);
        }
        submitList(emptyList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof GuildRaiseHandViewHolder) {
            RaiseHandData item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            ((GuildRaiseHandViewHolder) holder).o(item, this.guildId);
        } else if (holder instanceof b) {
            RaiseHandData item2 = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item2, "getItem(position)");
            ((b) holder).l(item2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType == 1) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f3o, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026hand_item, parent, false)");
                return new GuildRaiseHandViewHolder(inflate, this.fragment, this.mPageParam);
            }
            throw new Exception(" unknown type " + viewType);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f3p, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   \u2026itle_item, parent, false)");
        return new b(inflate2);
    }
}
