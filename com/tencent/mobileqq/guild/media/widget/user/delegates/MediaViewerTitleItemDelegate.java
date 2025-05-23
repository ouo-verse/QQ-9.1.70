package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.bd;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.widget.GuildMicSequenceDialogFragment;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaViewerTitleItemDelegate;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import rt1.MediaViewerTitleItem;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B\u000f\u0012\u0006\u0010 \u001a\u00020\u0018\u00a2\u0006\u0004\b!\u0010\"J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/k;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder;", "Lrt1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "u", "holder", "", "payloads", "", "t", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", h.F, "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "e", "Ljava/lang/ref/WeakReference;", "fragmentRef", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "f", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "dialogFragment", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "a", "ViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaViewerTitleItemDelegate extends BaseMediaItemDelegate<MediaViewerTitleItem, ViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Fragment> fragmentRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMicSequenceDialogFragment dialogFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002$'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002JF\u0010\u0015\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dRF\u0010 \u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "", "onAudioQueueLayoutClicked", "reportClickAudioQueueProgressTip", "", "viewerCount", "updateViewerCountView", "", "getViewCountText", "updateAudioQueueProgressTips", "Lrt1/k;", "data", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lkotlin/ParameterName;", "name", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "clickFunc", "bindData", "init", "unInit", "Landroid/widget/LinearLayout;", "viewerCountLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "viewerCountTextView", "Landroid/widget/TextView;", "audioQueueLayout", "audioQueueCountTextView", "mClickFunc", "Lkotlin/jvm/functions/Function2;", "lastViewerCount", "I", "com/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder$b", "micSequenceListObserver", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder$b;", "com/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder$a", "mMediaRoomObserver", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder$a;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class ViewHolder extends BaseMediaItemDelegate.BaseMediaViewHolder {

        @NotNull
        private final TextView audioQueueCountTextView;

        @NotNull
        private final LinearLayout audioQueueLayout;
        private int lastViewerCount;
        private Function2<? super IGProGuildInfo, ? super IGProChannelInfo, Unit> mClickFunc;

        @NotNull
        private final a mMediaRoomObserver;

        @NotNull
        private final b micSequenceListObserver;

        @NotNull
        private final LinearLayout viewerCountLayout;

        @NotNull
        private final TextView viewerCountTextView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder$a", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "from", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", "", "j", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class a extends y {
            a() {
            }

            @Override // com.tencent.mobileqq.guild.media.core.notify.q
            public void e(@Nullable IGProChannelInfo channelInfo) {
                Integer num;
                IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
                if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null) {
                    num = Integer.valueOf(voiceSpeakModeCfg.getSpeakMode());
                } else {
                    num = null;
                }
                QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onSpeakModeChanged] speakMode: " + num);
                ViewHolder.this.updateAudioQueueProgressTips();
            }

            @Override // com.tencent.mobileqq.guild.media.core.notify.q
            public void j(@Nullable String from, @Nullable IGProChannelUserNum channelNumber) {
                Integer num;
                Integer num2 = null;
                if (channelNumber != null) {
                    num = Integer.valueOf(channelNumber.getViewersNum());
                } else {
                    num = null;
                }
                QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onUserNumberOfChannelChanged] onlookerNum: " + num);
                if (channelNumber != null) {
                    num2 = Integer.valueOf(channelNumber.getViewersNum());
                }
                if (num2 != null) {
                    ViewHolder.this.updateViewerCountView(channelNumber.getViewersNum());
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/user/delegates/MediaViewerTitleItemDelegate$ViewHolder$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bd;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class b implements o<bd> {
            b() {
            }

            @Override // com.tencent.mobileqq.guild.media.core.notify.o
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void D0(@NotNull bd event) {
                Intrinsics.checkNotNullParameter(event, "event");
                ViewHolder.this.updateAudioQueueProgressTips();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.zyh);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.onlooker_title)");
            this.viewerCountLayout = (LinearLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.zyg);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.onlooker_count_view)");
            this.viewerCountTextView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.vzj);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.g\u2026e_progress_tip_container)");
            this.audioQueueLayout = (LinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.vzl);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.g\u2026io_queue_progress_tip_tv)");
            this.audioQueueCountTextView = (TextView) findViewById4;
            this.lastViewerCount = -1;
            this.micSequenceListObserver = new b();
            this.mMediaRoomObserver = new a();
        }

        private final String getViewCountText(int viewerCount) {
            int X = j.c().X();
            if (viewerCount <= X) {
                return String.valueOf(viewerCount);
            }
            return X + Marker.ANY_NON_NULL_MARKER;
        }

        private final void onAudioQueueLayoutClicked() {
            QLog.i("QGMC.GuildMediaChatNormalView", 1, "[onAudioQueueLayoutClicked] start");
            reportClickAudioQueueProgressTip();
            IGProGuildInfo guildInfo = j.a().getGuildInfo();
            IGProChannelInfo channelInfo = j.a().getChannelInfo();
            if (guildInfo != null && channelInfo != null) {
                Function2<? super IGProGuildInfo, ? super IGProChannelInfo, Unit> function2 = this.mClickFunc;
                if (function2 == null) {
                    QLog.e("QGMC.GuildMediaChatNormalView", 1, "[onAudioQueueLayoutClicked] click handler is not init");
                    return;
                }
                if (function2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mClickFunc");
                    function2 = null;
                }
                function2.invoke(guildInfo, channelInfo);
                return;
            }
            QLog.e("QGMC.GuildMediaChatNormalView", 1, "[onAudioQueueLayoutClicked] failed. " + guildInfo + ", " + channelInfo);
        }

        private final void reportClickAudioQueueProgressTip() {
            IGProGuildInfo guildInfo = j.a().getGuildInfo();
            IGProChannelInfo channelInfo = j.a().getChannelInfo();
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_queuemanage_entrance_type", 1);
            if (guildInfo != null) {
                String guildID = guildInfo.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
                hashMap.put("sgrp_channel_id", guildID);
                hashMap.put("sgrp_user_type", Integer.valueOf(guildInfo.getUserType()));
            }
            if (channelInfo != null) {
                String channelUin = channelInfo.getChannelUin();
                Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
                hashMap.put("sgrp_sub_channel_id", channelUin);
                hashMap.put("sgrp_sub_channel_type", Integer.valueOf(channelInfo.getType()));
            }
            VideoReport.reportEvent("clck", "em_sgrp_avchannel_manege_queue", hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateAudioQueueProgressTips() {
            Object obj;
            if (!MediaChannelUtils.f228046a.u(j.a().E())) {
                this.audioQueueLayout.setVisibility(8);
                return;
            }
            List<IGProUserInfo> d16 = j.a().N().d1();
            Iterator<T> it = d16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), j.c().getSelfUserInfo().f228093a)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u6392\u9ea6\u4e2d" + d16.size());
            boolean z16 = true;
            if (iGProUserInfo != null) {
                sb5.append(" | \u6211\u6392" + (d16.indexOf(iGProUserInfo) + 1));
            }
            if (sb5.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                this.audioQueueLayout.setVisibility(0);
                this.audioQueueCountTextView.setText(sb5);
                this.audioQueueLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MediaViewerTitleItemDelegate.ViewHolder.updateAudioQueueProgressTips$lambda$1(MediaViewerTitleItemDelegate.ViewHolder.this, view);
                    }
                });
                return;
            }
            this.audioQueueLayout.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void updateAudioQueueProgressTips$lambda$1(ViewHolder this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onAudioQueueLayoutClicked();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateViewerCountView(int viewerCount) {
            if (this.lastViewerCount == viewerCount) {
                return;
            }
            this.lastViewerCount = viewerCount;
            QLog.i("QGMC.GuildMediaChatNormalView", 1, "[updateViewerCountView] " + viewerCount);
            if (viewerCount <= 0) {
                this.viewerCountLayout.setVisibility(8);
            } else {
                this.viewerCountLayout.setVisibility(0);
                this.viewerCountTextView.setText(getViewCountText(viewerCount));
            }
        }

        public final void bindData(@NotNull MediaViewerTitleItem data, @NotNull Function2<? super IGProGuildInfo, ? super IGProChannelInfo, Unit> clickFunc) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(clickFunc, "clickFunc");
            updateViewerCountView(j.c().c0());
            updateAudioQueueProgressTips();
            this.mClickFunc = clickFunc;
        }

        public final void init() {
            j.a().l0().b(this.mMediaRoomObserver);
            j.d().V(bd.class, this.micSequenceListObserver);
        }

        public final void unInit() {
            j.d().j(bd.class, this.micSequenceListObserver);
            j.a().l0().B(this.mMediaRoomObserver);
        }
    }

    public MediaViewerTitleItemDelegate(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentRef = new WeakReference<>(fragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof ViewHolder) {
            viewHolder = (ViewHolder) holder;
        } else {
            viewHolder = null;
        }
        if (viewHolder != null) {
            viewHolder.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ViewHolder) {
            viewHolder = (ViewHolder) holder;
        } else {
            viewHolder = null;
        }
        if (viewHolder != null) {
            viewHolder.unInit();
        }
        super.h(holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull rt1.a item, @NotNull List<rt1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MediaViewerTitleItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MediaViewerTitleItem item, @NotNull ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.o(item, holder, payloads);
        holder.bindData(item, new Function2<IGProGuildInfo, IGProChannelInfo, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.user.delegates.MediaViewerTitleItemDelegate$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
                invoke2(iGProGuildInfo, iGProChannelInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo) {
                WeakReference weakReference;
                GuildMicSequenceDialogFragment guildMicSequenceDialogFragment;
                GuildMicSequenceDialogFragment guildMicSequenceDialogFragment2;
                GuildMicSequenceDialogFragment guildMicSequenceDialogFragment3;
                Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
                Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
                weakReference = MediaViewerTitleItemDelegate.this.fragmentRef;
                Fragment fragment = (Fragment) weakReference.get();
                if (fragment != null) {
                    guildMicSequenceDialogFragment = MediaViewerTitleItemDelegate.this.dialogFragment;
                    if (guildMicSequenceDialogFragment != null) {
                        guildMicSequenceDialogFragment3 = MediaViewerTitleItemDelegate.this.dialogFragment;
                        if (guildMicSequenceDialogFragment3 != null) {
                            guildMicSequenceDialogFragment3.dismiss();
                        }
                        MediaViewerTitleItemDelegate.this.dialogFragment = null;
                    }
                    MediaViewerTitleItemDelegate.this.dialogFragment = new GuildMicSequenceDialogFragment(guildInfo, channelInfo);
                    guildMicSequenceDialogFragment2 = MediaViewerTitleItemDelegate.this.dialogFragment;
                    if (guildMicSequenceDialogFragment2 != null) {
                        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                        com.tencent.mobileqq.guild.base.extension.d.a(guildMicSequenceDialogFragment2, childFragmentManager, "GuildMicSequenceDialogFragment");
                        return;
                    }
                    return;
                }
                QLog.w("QGMC.GuildMediaChatNormalView", 1, "[onBindViewHolder] invalid fragment");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.eye, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026le_layout, parent, false)");
        return new ViewHolder(inflate);
    }
}
