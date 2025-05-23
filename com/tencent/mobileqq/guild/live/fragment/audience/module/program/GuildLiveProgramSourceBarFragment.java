package com.tencent.mobileqq.guild.live.fragment.audience.module.program;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.qzone.widget.u;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildLivePlayListDialogFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.program.GuildLiveProgramSourceBarFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.widget.GuildLiveProgramSourceBarLayout;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IContainerViewCallback;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nq1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/program/GuildLiveProgramSourceBarFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/base/QQGuildLiveModuleBaseFragment;", "Landroid/view/View$OnClickListener;", "", "wh", "", "hasPermission", "uh", "th", "", "height", "Bh", OcrConfig.CHINESE, "", "jsonStr", "vh", "getLayoutId", "Landroid/view/View;", "view", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDetach", "v", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveProgramSourceBarLayout;", "D", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveProgramSourceBarLayout;", "mVideoSourceBar", "<init>", "()V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveProgramSourceBarFragment extends QQGuildLiveModuleBaseFragment implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildLiveProgramSourceBarLayout mVideoSourceBar;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/program/GuildLiveProgramSourceBarFragment$a;", "", "Lcom/tencent/mobileqq/guild/live/fragment/audience/module/program/GuildLiveProgramSourceBarFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.fragment.audience.module.program.GuildLiveProgramSourceBarFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildLiveProgramSourceBarFragment a() {
            return new GuildLiveProgramSourceBarFragment();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(GuildLiveProgramSourceBarFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vh(str);
    }

    private final void Bh(final int height) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: lq1.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveProgramSourceBarFragment.Ch(GuildLiveProgramSourceBarFragment.this, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(GuildLiveProgramSourceBarFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c a16 = this$0.mLiveModuleControl.a();
        if (a16 != null) {
            a16.onLiveBusinessBarHeightChanged(i3);
        }
    }

    private final void th() {
        QQGuildChannelLive.LiveProgramInfo liveProgramInfo;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProGuildInfo value = gLiveChannelCore.t().k().getValue();
        IGProChannelInfo value2 = gLiveChannelCore.t().e().getValue();
        if (value != null && value2 != null) {
            GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout = null;
            if (gLiveChannelCore.t().p().getValue() != null) {
                LiveChannelRoomInfo value3 = gLiveChannelCore.t().p().getValue();
                if (value3 != null) {
                    liveProgramInfo = value3.getProgramInfo();
                } else {
                    liveProgramInfo = null;
                }
                if (liveProgramInfo != null && value3.getProgramInfo().isValid()) {
                    if (gLiveChannelCore.r().a()) {
                        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout2 = this.mVideoSourceBar;
                        if (guildLiveProgramSourceBarLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                            guildLiveProgramSourceBarLayout2 = null;
                        }
                        guildLiveProgramSourceBarLayout2.setVisibility(0);
                    }
                    Boolean value4 = gLiveChannelCore.t().C().getValue();
                    if (value4 == null) {
                        value4 = Boolean.FALSE;
                    }
                    if (value4.booleanValue()) {
                        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout3 = this.mVideoSourceBar;
                        if (guildLiveProgramSourceBarLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                            guildLiveProgramSourceBarLayout3 = null;
                        }
                        guildLiveProgramSourceBarLayout3.c(true);
                        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout4 = this.mVideoSourceBar;
                        if (guildLiveProgramSourceBarLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                            guildLiveProgramSourceBarLayout4 = null;
                        }
                        guildLiveProgramSourceBarLayout4.setVideoSelectClickedListener(this);
                    } else {
                        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout5 = this.mVideoSourceBar;
                        if (guildLiveProgramSourceBarLayout5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                            guildLiveProgramSourceBarLayout5 = null;
                        }
                        guildLiveProgramSourceBarLayout5.c(false);
                    }
                    GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout6 = this.mVideoSourceBar;
                    if (guildLiveProgramSourceBarLayout6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                        guildLiveProgramSourceBarLayout6 = null;
                    }
                    String anchorName = value3.getProgramInfo().getAnchorName();
                    Intrinsics.checkNotNullExpressionValue(anchorName, "roomInfo.programInfo.anchorName");
                    String liveTitle = value3.getProgramInfo().getLiveTitle();
                    Intrinsics.checkNotNullExpressionValue(liveTitle, "roomInfo.programInfo.liveTitle");
                    guildLiveProgramSourceBarLayout6.setVideoSourceInfo(anchorName, liveTitle);
                    GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout7 = this.mVideoSourceBar;
                    if (guildLiveProgramSourceBarLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                    } else {
                        guildLiveProgramSourceBarLayout = guildLiveProgramSourceBarLayout7;
                    }
                    String thirdPartyLogo = value3.getProgramInfo().getThirdPartyLogo();
                    Intrinsics.checkNotNullExpressionValue(thirdPartyLogo, "roomInfo.programInfo.thirdPartyLogo");
                    guildLiveProgramSourceBarLayout.setVideoSourceIconUrl(thirdPartyLogo);
                    Bh(x.c(getContext(), 43.0f));
                    return;
                }
            }
            GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout8 = this.mVideoSourceBar;
            if (guildLiveProgramSourceBarLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
            } else {
                guildLiveProgramSourceBarLayout = guildLiveProgramSourceBarLayout8;
            }
            guildLiveProgramSourceBarLayout.setVisibility(8);
            Bh(0);
        }
    }

    private final void uh(boolean hasPermission) {
        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout = this.mVideoSourceBar;
        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout2 = null;
        if (guildLiveProgramSourceBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
            guildLiveProgramSourceBarLayout = null;
        }
        if (guildLiveProgramSourceBarLayout.getVisibility() == 0) {
            if (hasPermission) {
                GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout3 = this.mVideoSourceBar;
                if (guildLiveProgramSourceBarLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                    guildLiveProgramSourceBarLayout3 = null;
                }
                guildLiveProgramSourceBarLayout3.c(true);
                GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout4 = this.mVideoSourceBar;
                if (guildLiveProgramSourceBarLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
                } else {
                    guildLiveProgramSourceBarLayout2 = guildLiveProgramSourceBarLayout4;
                }
                guildLiveProgramSourceBarLayout2.setVideoSelectClickedListener(this);
                return;
            }
            GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout5 = this.mVideoSourceBar;
            if (guildLiveProgramSourceBarLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
            } else {
                guildLiveProgramSourceBarLayout2 = guildLiveProgramSourceBarLayout5;
            }
            guildLiveProgramSourceBarLayout2.c(false);
        }
    }

    private final void vh(String jsonStr) {
        GuildLiveProgramSourceBarLayout guildLiveProgramSourceBarLayout = this.mVideoSourceBar;
        if (guildLiveProgramSourceBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoSourceBar");
            guildLiveProgramSourceBarLayout = null;
        }
        if (jsonStr == null) {
            jsonStr = "";
        }
        guildLiveProgramSourceBarLayout.setVideoSourceData(jsonStr);
    }

    private final void wh() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        gLiveChannelCore.t().p().observe(getViewLifecycleOwner(), new Observer() { // from class: lq1.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildLiveProgramSourceBarFragment.xh(GuildLiveProgramSourceBarFragment.this, (LiveChannelRoomInfo) obj);
            }
        });
        gLiveChannelCore.t().C().observe(getViewLifecycleOwner(), new Observer() { // from class: lq1.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildLiveProgramSourceBarFragment.yh(GuildLiveProgramSourceBarFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(GuildLiveProgramSourceBarFragment this$0, LiveChannelRoomInfo liveChannelRoomInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildLiveProgramSourceBarFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.uh(it.booleanValue());
    }

    private final void zh() {
        LiveChannelRoomInfo value;
        QQGuildChannelLive.LiveProgramInfo programInfo;
        FragmentManager childFragmentManager;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProChannelInfo value2 = gLiveChannelCore.t().e().getValue();
        if (value2 == null || (value = gLiveChannelCore.t().p().getValue()) == null || (programInfo = value.getProgramInfo()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String guildId = value2.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        linkedHashMap.put("guild_id", guildId);
        String channelUin = value2.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        linkedHashMap.put("channel_id", channelUin);
        linkedHashMap.put(u.COLUMN_TAB_ID, Long.valueOf(programInfo.getTabId()));
        String programId = programInfo.getProgramId();
        Intrinsics.checkNotNullExpressionValue(programId, "programInfo.programId");
        linkedHashMap.put("program_id", programId);
        QQGuildLivePlayListDialogFragment yh5 = QQGuildLivePlayListDialogFragment.yh(linkedHashMap, new IContainerViewCallback() { // from class: lq1.c
            @Override // com.tencent.mobileqq.mini.api.IContainerViewCallback
            public final void onMiniViewResult(String str) {
                GuildLiveProgramSourceBarFragment.Ah(GuildLiveProgramSourceBarFragment.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(yh5, "newInstance(paramsMap) {\u2026Result(jsonStr)\n        }");
        FragmentActivity activity = getActivity();
        if (activity == null || (childFragmentManager = activity.getSupportFragmentManager()) == null) {
            childFragmentManager = getChildFragmentManager();
        }
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "activity?.supportFragmen\u2026r ?: childFragmentManager");
        d.a(yh5, childFragmentManager, QQGuildLivePlayListDialogFragment.class.getSimpleName());
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.f168122ex4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        this.mRootView = view;
        View findViewById = view.findViewById(R.id.f1179972y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<GuildL\u2026id.video_source_info_bar)");
        this.mVideoSourceBar = (GuildLiveProgramSourceBarLayout) findViewById;
        th();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        zh();
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (QLog.isColorLevel()) {
            QLog.i("QGL.GuildLiveProgramSourceBarFragment", 1, "onDetach ");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        wh();
    }
}
