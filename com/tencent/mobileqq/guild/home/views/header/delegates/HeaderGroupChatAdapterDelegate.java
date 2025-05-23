package com.tencent.mobileqq.guild.home.views.header.delegates;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ar1.h;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.channellist.MsgData;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildCapsuleInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.e;
import com.tencent.mobileqq.guild.home.views.header.delegates.BaseHeaderBarsAbsDelegate;
import com.tencent.mobileqq.guild.home.views.header.delegates.HeaderGroupChatAdapterDelegate;
import com.tencent.mobileqq.guild.home.views.widget.GuildHomeHeaderGroupChatLayout;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import com.tencent.mobileqq.guild.summary.c;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.RadiusConstraintLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.bi;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B@\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018\u0012!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120\u001c\u00a2\u0006\u0004\b$\u0010%J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR/\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGroupChatAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/BaseHeaderBarsAbsDelegate;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/e;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGroupChatAdapterDelegate$GroupChatViewHolder;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lar1/h;", "d", "Lar1/h;", "redPointDragHandler", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "openChannelList", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "channelId", "f", "Lkotlin/jvm/functions/Function1;", "openChannel", "<init>", "(Lar1/h;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "GroupChatViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class HeaderGroupChatAdapterDelegate extends BaseHeaderBarsAbsDelegate<e, GroupChatViewHolder> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h redPointDragHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> openChannelList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> openChannel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0019\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000eJG\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0014R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/delegates/HeaderGroupChatAdapterDelegate$GroupChatViewHolder;", "Lcom/tencent/mobileqq/guild/home/views/header/delegates/BaseHeaderBarsAbsDelegate$a;", "Lcom/tencent/mobileqq/guild/summary/b;", "summaryUIData", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/e;", "data", HippyTKDListViewAdapter.X, "t", "r", "", "msgShowType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Integer;)I", "p", "Lar1/h;", "redPointDragHandler", "Lkotlin/Function0;", "openChannelList", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "channelId", "openChannel", "u", "Lvp1/bi;", UserInfo.SEX_FEMALE, "Lvp1/bi;", "o", "()Lvp1/bi;", "binding", "G", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/e;", "mData", "<init>", "(Lvp1/bi;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class GroupChatViewHolder extends BaseHeaderBarsAbsDelegate.a {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final bi binding;

        /* renamed from: G, reason: from kotlin metadata */
        private e mData;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public GroupChatViewHolder(@NotNull bi binding) {
            super(r0);
            Intrinsics.checkNotNullParameter(binding, "binding");
            GuildHomeHeaderGroupChatLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
            GuildHomeHeaderGroupChatLayout root2 = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.views.header.delegates.HeaderGroupChatAdapterDelegate$GroupChatViewHolder$special$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar;
                    e eVar2;
                    HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.getBinding().f442485h.setBackgroundResource(R.drawable.guild_token_overlay_item_bg_select);
                    HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.getBinding().f442486i.setImageResource(R.drawable.qui_chevron_right_icon_white);
                    HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.getBinding().f442483f.setBackgroundResource(R.drawable.guild_token_overlay_item_bg_select);
                    HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.getBinding().f442487j.setText(R.string.f146550uh);
                    eVar = HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.mData;
                    if (eVar != null) {
                        ImageView imageView = HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.getBinding().f442486i;
                        eVar2 = HeaderGroupChatAdapterDelegate.GroupChatViewHolder.this.mData;
                        if (eVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mData");
                            eVar2 = null;
                        }
                        imageView.setColorFilter(eVar2.getTintColors().getGroupChatTipsColor());
                    }
                }
            }, 50L);
        }

        private final int p(Integer msgShowType) {
            boolean z16;
            if ((msgShowType != null && msgShowType.intValue() == 1) || (msgShowType != null && msgShowType.intValue() == 2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return 2;
            }
            return 1;
        }

        private final int q(Integer msgShowType) {
            if (msgShowType != null && msgShowType.intValue() == 1) {
                return 2;
            }
            if (msgShowType != null && msgShowType.intValue() == 2) {
                return 3;
            }
            return 0;
        }

        private final void r(e data) {
            Integer num;
            Map mutableMapOf;
            String str;
            Map mutableMapOf2;
            MsgData msgData;
            VideoReport.setElementId(this.binding.f442485h, "em_sgrp_aio_entry");
            RadiusConstraintLayout radiusConstraintLayout = this.binding.f442485h;
            Pair[] pairArr = new Pair[1];
            UnreadInfo.a unreadInfo = data.getUnreadInfo();
            Integer num2 = null;
            if (unreadInfo != null) {
                num = Integer.valueOf(unreadInfo.getUnreadType());
            } else {
                num = null;
            }
            int i3 = 0;
            pairArr[0] = TuplesKt.to("sgrp_red_tips_type", Integer.valueOf(q(num)));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            VideoReport.setElementParams(radiusConstraintLayout, mutableMapOf);
            VideoReport.setElementId(this.binding.f442483f, "em_sgrp_exposed_aio");
            FrameLayout frameLayout = this.binding.f442483f;
            Pair[] pairArr2 = new Pair[3];
            GuildCapsuleInfo capsuleInfo = data.getCapsuleInfo();
            if (capsuleInfo == null || (str = capsuleInfo.getChannelId()) == null) {
                str = "";
            }
            pairArr2[0] = TuplesKt.to("sgrp_sub_channel_id", str);
            GuildCapsuleInfo capsuleInfo2 = data.getCapsuleInfo();
            if (capsuleInfo2 != null) {
                i3 = capsuleInfo2.getChannelType();
            }
            pairArr2[1] = TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(i3));
            GuildCapsuleInfo capsuleInfo3 = data.getCapsuleInfo();
            if (capsuleInfo3 != null && (msgData = capsuleInfo3.getMsgData()) != null) {
                num2 = Integer.valueOf(msgData.getMsgShowType());
            }
            pairArr2[2] = TuplesKt.to("sgrp_msg_state", Integer.valueOf(p(num2)));
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr2);
            VideoReport.setElementParams(frameLayout, mutableMapOf2);
        }

        private final void s(GuildSummaryUIData summaryUIData) {
            Object obj;
            if (summaryUIData != null) {
                if (summaryUIData.getLastTime() > 0) {
                    this.binding.f442490m.setVisibility(0);
                    this.binding.f442490m.setText(gr1.b.f403085a.a(summaryUIData.getLastTime()));
                    obj = Unit.INSTANCE;
                } else {
                    TextView textView = this.binding.f442490m;
                    textView.setVisibility(8);
                    Intrinsics.checkNotNullExpressionValue(textView, "{\n                    bi\u2026.gone()\n                }");
                    obj = textView;
                }
                if (obj != null) {
                    return;
                }
            }
            TextView textView2 = this.binding.f442490m;
            textView2.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(textView2, "run {\n                bi\u2026Time.gone()\n            }");
        }

        private final void t(e data) {
            MsgData msgData;
            GuildCapsuleInfo capsuleInfo = data.getCapsuleInfo();
            if (capsuleInfo != null) {
                msgData = capsuleInfo.getMsgData();
            } else {
                msgData = null;
            }
            if (msgData == null) {
                this.binding.f442492o.setVisibility(8);
                return;
            }
            int msgShowType = msgData.getMsgShowType();
            if (msgShowType != 0 && msgShowType != 4) {
                GuildDragTextView guildDragTextView = this.binding.f442492o;
                Intrinsics.checkNotNullExpressionValue(guildDragTextView, "binding.unreadMsg");
                er1.a.i(guildDragTextView, msgData.getMsgCnt(), data.getTintColors().getGroupChatUnreadTextColor(), data.getTintColors().getGroupChatUnreadBg(), 16.0f);
                return;
            }
            this.binding.f442492o.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(Function0 openChannelList, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(openChannelList, "$openChannelList");
            openChannelList.invoke();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(e data, GroupChatViewHolder this$0, Function1 openChannel, Function0 openChannelList, View view) {
            Unit unit;
            String channelId;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(openChannel, "$openChannel");
            Intrinsics.checkNotNullParameter(openChannelList, "$openChannelList");
            GuildCapsuleInfo capsuleInfo = data.getCapsuleInfo();
            if (capsuleInfo != null && (channelId = capsuleInfo.getChannelId()) != null) {
                openChannel.invoke(channelId);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                openChannelList.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void x(e data) {
            int i3;
            int parseColor;
            UnreadInfo.a unreadInfo = data.getUnreadInfo();
            if (unreadInfo == null) {
                if (data.getShowTips()) {
                    this.binding.f442487j.setVisibility(0);
                } else {
                    this.binding.f442487j.setVisibility(8);
                }
                this.binding.f442489l.setVisibility(8);
                return;
            }
            int unreadType = unreadInfo.getUnreadType();
            if (unreadType != 0 && unreadType != 4) {
                this.binding.f442487j.setVisibility(8);
                if (unreadInfo.getUnreadType() == 2) {
                    i3 = GuildUIUtils.f235378a.v(Color.parseColor("#1A1C1E"), 0.8f, false);
                } else {
                    i3 = -1;
                }
                if (unreadInfo.getUnreadType() == 2) {
                    parseColor = GuildUIUtils.f235378a.v(-1, 0.9f, false);
                } else {
                    parseColor = Color.parseColor("#F74C30");
                }
                GuildDragTextView guildDragTextView = this.binding.f442489l;
                Intrinsics.checkNotNullExpressionValue(guildDragTextView, "binding.headerGroupChatTopUnreadTv");
                er1.a.i(guildDragTextView, unreadInfo.getCount(), i3, parseColor, 16.0f);
                return;
            }
            if (data.getShowTips()) {
                this.binding.f442487j.setVisibility(0);
            } else {
                this.binding.f442487j.setVisibility(8);
            }
            this.binding.f442489l.setVisibility(8);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final bi getBinding() {
            return this.binding;
        }

        public final void u(@NotNull final e data, @NotNull h redPointDragHandler, @NotNull final Function0<Unit> openChannelList, @NotNull final Function1<? super String, Unit> openChannel) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(redPointDragHandler, "redPointDragHandler");
            Intrinsics.checkNotNullParameter(openChannelList, "openChannelList");
            Intrinsics.checkNotNullParameter(openChannel, "openChannel");
            this.mData = data;
            this.binding.f442482e.c(data.getTintColors().getType());
            this.binding.f442488k.setTextColor(data.getTintColors().getGroupChatMainColor());
            this.binding.f442487j.setTextColor(data.getTintColors().getGroupChatTipsColor());
            this.binding.f442486i.setColorFilter(data.getTintColors().getGroupChatTipsColor());
            this.binding.f442489l.setOnModeChangeListener(redPointDragHandler.c());
            this.binding.f442489l.setDragViewType(10, this.itemView);
            this.binding.f442489l.setTag(data);
            this.binding.f442484g.setBackgroundColor(data.getTintColors().getGroupChatLineColor());
            this.binding.f442481d.setTextColor(data.getTintColors().getGroupChatMainColor());
            this.binding.f442490m.setTextColor(data.getTintColors().getGroupChatTimeColor());
            TextView textView = this.binding.f442490m;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.lastTime");
            s.a(textView, 300, 0);
            this.binding.f442491n.setTextColor(data.getTintColors().getGroupChatSummaryHighlightColor(), data.getTintColors().getGroupChatSummaryColor());
            this.binding.f442492o.setOnModeChangeListener(redPointDragHandler.c());
            this.binding.f442492o.setDragViewType(10, this.itemView);
            this.binding.f442492o.setTag(data.getCapsuleInfo());
            GuildCapsuleInfo capsuleInfo = data.getCapsuleInfo();
            if (capsuleInfo != null) {
                this.binding.f442483f.setVisibility(0);
                this.binding.f442481d.setText(capsuleInfo.getChannelName());
                if (capsuleInfo.getChannelType() == 6) {
                    this.binding.f442480c.setBackground(null);
                    String appChannelIconUrl = capsuleInfo.getAppChannelIconUrl();
                    if (!TextUtils.isEmpty(appChannelIconUrl)) {
                        ImageView imageView = this.binding.f442480c;
                        Context context = this.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                        u.r(appChannelIconUrl, imageView, false, GuildUIUtils.y(context, R.drawable.guild_channel_app_p, data.getTintColors().getGroupChatMainColor()));
                    } else {
                        ImageView imageView2 = this.binding.f442480c;
                        Context context2 = this.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                        imageView2.setImageDrawable(GuildUIUtils.y(context2, R.drawable.guild_channel_app_p, data.getTintColors().getGroupChatMainColor()));
                    }
                    GuildSummaryUIData summaryUIData = capsuleInfo.getMsgData().getSummaryUIData();
                    if (summaryUIData != null && !summaryUIData.h()) {
                        this.binding.f442479b.setVisibility(0);
                        this.binding.f442491n.setSummaryData(summaryUIData);
                    } else {
                        this.binding.f442479b.setVisibility(8);
                    }
                } else {
                    ImageView imageView3 = this.binding.f442480c;
                    Context context3 = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "itemView.context");
                    imageView3.setBackground(GuildUIUtils.y(context3, R.drawable.guild_channel_text_icon_bg, data.getTintColors().getGroupChatMainColor()));
                    ImageView imageView4 = this.binding.f442480c;
                    Context context4 = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "itemView.context");
                    imageView4.setImageDrawable(GuildUIUtils.y(context4, R.drawable.guild_channel_text_icon_src, data.getTintColors().getGroupChatMainColor()));
                    GuildSummaryUIData summaryUIData2 = capsuleInfo.getMsgData().getSummaryUIData();
                    if (summaryUIData2 == null || summaryUIData2.h()) {
                        String welcomeTips = QQGuildUIUtil.s(R.string.f142290iz, capsuleInfo.getChannelName());
                        Intrinsics.checkNotNullExpressionValue(welcomeTips, "welcomeTips");
                        summaryUIData2 = c.b(welcomeTips);
                    }
                    this.binding.f442479b.setVisibility(0);
                    this.binding.f442491n.setSummaryData(summaryUIData2);
                }
                s(capsuleInfo.getMsgData().getSummaryUIData());
                t(data);
                Unit unit = Unit.INSTANCE;
            } else {
                FrameLayout frameLayout = this.binding.f442483f;
                frameLayout.setVisibility(8);
                Intrinsics.checkNotNullExpressionValue(frameLayout, "run {\n                bi\u2026Area.gone()\n            }");
            }
            x(data);
            this.binding.f442485h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.header.delegates.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderGroupChatAdapterDelegate.GroupChatViewHolder.v(Function0.this, view);
                }
            });
            this.binding.f442483f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.header.delegates.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderGroupChatAdapterDelegate.GroupChatViewHolder.w(e.this, this, openChannel, openChannelList, view);
                }
            });
            r(data);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeaderGroupChatAdapterDelegate(@NotNull h redPointDragHandler, @NotNull Function0<Unit> openChannelList, @NotNull Function1<? super String, Unit> openChannel) {
        Intrinsics.checkNotNullParameter(redPointDragHandler, "redPointDragHandler");
        Intrinsics.checkNotNullParameter(openChannelList, "openChannelList");
        Intrinsics.checkNotNullParameter(openChannel, "openChannel");
        this.redPointDragHandler = redPointDragHandler;
        this.openChannelList = openChannelList;
        this.openChannel = openChannel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b item, @NotNull List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull e item, @NotNull GroupChatViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.u(item, this.redPointDragHandler, this.openChannelList, this.openChannel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public GroupChatViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bi g16 = bi.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new GroupChatViewHolder(g16);
    }
}
