package com.tencent.mobileqq.guild.media.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.fn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.el;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J&\u0010\u001f\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010 \u001a\u00020\rH\u0014J\u001a\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0003H\u0016R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010%R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00103R\"\u0010?\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010W\u001a\u00020P8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010Y0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildRoleModifyTalkModeFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initView", "Ph", "Rh", "", "modifyTime", "bi", "Sh", "", "mode", "", "confirmExt", "Wh", "di", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "Oh", "Qh", "reportView", "elementId", "Nh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "getContentLayoutId", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "T", "Landroid/view/View;", "mTalkModeFreeSpeechContainer", "U", "mTalkModeFreeSpeechCheck", "V", "mTalkModeMicSequenceContainer", "W", "mTalkModeHandupSpeechContainer", "X", "mTalkModeMicSequenceCheck", "Y", "mTalkModeHandupSpeechCheck", "Landroid/widget/TextView;", "Z", "Landroid/widget/TextView;", "mMicSequenceTimeTv", "a0", "mMicSequenceTimeContainer", "b0", "mMicSequenceRelatedSettingTv", "c0", "I", "Lh", "()I", "Vh", "(I)V", "mSecond", "Lcom/tencent/mobileqq/guild/rolegroup/view/b;", "d0", "Lcom/tencent/mobileqq/guild/rolegroup/view/b;", "Mh", "()Lcom/tencent/mobileqq/guild/rolegroup/view/b;", "ci", "(Lcom/tencent/mobileqq/guild/rolegroup/view/b;)V", "micSequenceTimeView", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "e0", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Jh", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Th", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "f0", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Kh", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Uh", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "mGuildInfo", "", "", "g0", "Ljava/util/Map;", "mDtPageParam", "<init>", "()V", "h0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRoleModifyTalkModeFragment extends QQGuildTitleBarFragment implements View.OnClickListener {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private View mTalkModeFreeSpeechContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private View mTalkModeFreeSpeechCheck;

    /* renamed from: V, reason: from kotlin metadata */
    private View mTalkModeMicSequenceContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private View mTalkModeHandupSpeechContainer;

    /* renamed from: X, reason: from kotlin metadata */
    private View mTalkModeMicSequenceCheck;

    /* renamed from: Y, reason: from kotlin metadata */
    private View mTalkModeHandupSpeechCheck;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView mMicSequenceTimeTv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private View mMicSequenceTimeContainer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TextView mMicSequenceRelatedSettingTv;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int mSecond;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mobileqq.guild.rolegroup.view.b micSequenceTimeView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    public IGProChannelInfo mChannelInfo;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    public IGProGuildInfo mGuildInfo;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> mDtPageParam = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildRoleModifyTalkModeFragment$a;", "", "Landroid/app/Activity;", "context", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Landroid/content/Intent;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.GuildRoleModifyTalkModeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@Nullable IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo) {
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_guild_guild_info", guildInfo);
            bundle.putSerializable("extra_guild_channel_info", channelInfo);
            intent.putExtras(bundle);
            return intent;
        }

        public final void b(@NotNull Activity context, @NotNull IGProChannelInfo channelInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            String guildId = channelInfo.getGuildId();
            if (TextUtils.isEmpty(guildId)) {
                QLog.e("GuildRoleModifyTalkModeFragment", 1, "guild is null");
                QQToast.makeText(context, 1, context.getResources().getString(R.string.f143560me), 1).show();
                return;
            }
            Logger.f235387a.d().i("GuildRoleModifyTalkModeFragment", 1, "openFragment guildId:" + guildId + ", channelId = " + channelInfo.getChannelUin() + " channelInfo:" + channelInfo);
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            QPublicFragmentActivity.b.e(context, a(((IGPSService) S0).getGuildInfo(guildId), channelInfo), QPublicFragmentActivity.class, GuildRoleModifyTalkModeFragment.class, 0);
        }

        Companion() {
        }
    }

    private final void Nh(View reportView, String elementId) {
        if (reportView == null) {
            return;
        }
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap(this.mDtPageParam);
        hashMap.put("sgrp_speakmode_time", Integer.valueOf(this.mSecond));
        VideoReport.reportEvent("clck", reportView, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Oh(int second) {
        if (second < 60) {
            return second + "\u79d2";
        }
        int i3 = second / 60;
        int i16 = second % 60;
        if (i16 == 0) {
            return i3 + "\u5206\u949f";
        }
        return i3 + "\u5206\u949f" + i16 + "\u79d2";
    }

    private final void Ph() {
        int g16;
        this.E.setText(getResources().getString(R.string.f141930i0));
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg = Jh().getVoiceSpeakModeCfg();
        int n3 = MediaChannelUtils.f228046a.n(Jh().getChannelUin());
        di(n3);
        if (voiceSpeakModeCfg.getSpeakSecond() != 0) {
            g16 = voiceSpeakModeCfg.getSpeakSecond();
        } else {
            g16 = bs.g();
        }
        this.mSecond = g16;
        IGProVoiceQueueCfg voiceQueueCfg = Jh().getVoiceQueueCfg();
        Logger logger = Logger.f235387a;
        logger.d().i("GuildRoleModifyTalkModeFragment", 1, "setCurrentStatus\uff0c get config, speakMode = " + n3 + ", speakSecond = " + voiceSpeakModeCfg.getSpeakSecond() + ", voiceQueueState = " + voiceQueueCfg.getVoiceQueueState() + ", mSecond = " + getMSecond());
        TextView textView = this.mMicSequenceTimeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeTv");
            textView = null;
        }
        textView.setText(Oh(this.mSecond));
        logger.d().i("GuildRoleModifyTalkModeFragment", 1, "setCurrentStatus mSecond:" + getMSecond() + " text:" + Oh(getMSecond()));
    }

    private final void Qh() {
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_speakmode_set");
        this.mDtPageParam.put("sgrp_sub_channel_id", Jh().getChannelUin());
        this.mDtPageParam.put("sgrp_sub_channel_name", Jh().getChannelName());
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.P, com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), this.mDtPageParam);
    }

    private final void Rh() {
        Xh(this, 1, false, null, 6, null);
    }

    private final void Sh() {
        Xh(this, 4, false, null, 6, null);
    }

    private final void Wh(final int mode, final boolean modifyTime, String confirmExt) {
        fn fnVar = new fn();
        fnVar.c(mode);
        fnVar.d(this.mSecond);
        Logger.f235387a.d().i("GuildRoleModifyTalkModeFragment", 1, "speakMode = " + fnVar.a() + ", speakSecond = " + fnVar.b());
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String guildID = Kh().getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
        long parseLong = Long.parseLong(guildID);
        String channelUin = Jh().getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo.channelUin");
        iGPSService.setAVChannelSpeakMode(parseLong, Long.parseLong(channelUin), confirmExt, fnVar, new el() { // from class: com.tencent.mobileqq.guild.media.widget.aq
            @Override // wh2.el
            public final void a(int i3, String str, IGProVoiceSpeakModeRsp iGProVoiceSpeakModeRsp) {
                GuildRoleModifyTalkModeFragment.Yh(modifyTime, this, mode, i3, str, iGProVoiceSpeakModeRsp);
            }
        });
    }

    static /* synthetic */ void Xh(GuildRoleModifyTalkModeFragment guildRoleModifyTalkModeFragment, int i3, boolean z16, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            str = "";
        }
        guildRoleModifyTalkModeFragment.Wh(i3, z16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(final boolean z16, final GuildRoleModifyTalkModeFragment this$0, final int i3, int i16, String errMsg, final IGProVoiceSpeakModeRsp voiceSpeakModeRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(voiceSpeakModeRsp, "voiceSpeakModeRsp");
        Logger.f235387a.d().i("GuildRoleModifyTalkModeFragment", 1, "setMicSequenceMode result:" + i16 + " errMsg:" + errMsg);
        if (i16 == 0) {
            if (voiceSpeakModeRsp.getModCode() == 1) {
                if (z16) {
                    com.tencent.mobileqq.guild.util.qqui.g.c(2, R.string.f141470gr);
                } else {
                    com.tencent.mobileqq.guild.util.qqui.g.c(2, R.string.f156431k7);
                }
                this$0.di(i3);
                return;
            }
            if (!Intrinsics.areEqual(voiceSpeakModeRsp.getConfirmMsg(), "")) {
                com.tencent.mobileqq.guild.util.qqui.c.d(this$0.getActivity(), 230, null, voiceSpeakModeRsp.getConfirmMsg(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ar
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i17) {
                        GuildRoleModifyTalkModeFragment.Zh(GuildRoleModifyTalkModeFragment.this, i3, z16, voiceSpeakModeRsp, dialogInterface, i17);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.as
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i17) {
                        GuildRoleModifyTalkModeFragment.ai(dialogInterface, i17);
                    }
                }).show();
                return;
            } else {
                com.tencent.mobileqq.guild.util.qqui.g.c(1, R.string.f156051j6);
                return;
            }
        }
        QQToast.makeText(BaseApplication.context, errMsg, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildRoleModifyTalkModeFragment this$0, int i3, boolean z16, IGProVoiceSpeakModeRsp voiceSpeakModeRsp, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(voiceSpeakModeRsp, "$voiceSpeakModeRsp");
        String confirmExt = voiceSpeakModeRsp.getConfirmExt();
        Intrinsics.checkNotNullExpressionValue(confirmExt, "voiceSpeakModeRsp.confirmExt");
        this$0.Wh(i3, z16, confirmExt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(boolean modifyTime) {
        Xh(this, 2, modifyTime, null, 4, null);
    }

    private final void di(int mode) {
        TextView textView = null;
        if (mode != 2) {
            if (mode != 4) {
                View view = this.mTalkModeFreeSpeechCheck;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTalkModeFreeSpeechCheck");
                    view = null;
                }
                view.setVisibility(0);
                View view2 = this.mTalkModeHandupSpeechCheck;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTalkModeHandupSpeechCheck");
                    view2 = null;
                }
                view2.setVisibility(8);
                View view3 = this.mTalkModeMicSequenceCheck;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTalkModeMicSequenceCheck");
                    view3 = null;
                }
                view3.setVisibility(8);
                View view4 = this.mMicSequenceTimeContainer;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeContainer");
                    view4 = null;
                }
                view4.setVisibility(8);
                TextView textView2 = this.mMicSequenceRelatedSettingTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceRelatedSettingTv");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(8);
                return;
            }
            View view5 = this.mTalkModeHandupSpeechCheck;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTalkModeHandupSpeechCheck");
                view5 = null;
            }
            view5.setVisibility(0);
            View view6 = this.mTalkModeMicSequenceCheck;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTalkModeMicSequenceCheck");
                view6 = null;
            }
            view6.setVisibility(8);
            View view7 = this.mTalkModeFreeSpeechCheck;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTalkModeFreeSpeechCheck");
                view7 = null;
            }
            view7.setVisibility(8);
            View view8 = this.mMicSequenceTimeContainer;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeContainer");
                view8 = null;
            }
            view8.setVisibility(8);
            TextView textView3 = this.mMicSequenceRelatedSettingTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceRelatedSettingTv");
            } else {
                textView = textView3;
            }
            textView.setVisibility(8);
            return;
        }
        View view9 = this.mTalkModeFreeSpeechCheck;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTalkModeFreeSpeechCheck");
            view9 = null;
        }
        view9.setVisibility(8);
        View view10 = this.mTalkModeHandupSpeechCheck;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTalkModeHandupSpeechCheck");
            view10 = null;
        }
        view10.setVisibility(8);
        View view11 = this.mTalkModeMicSequenceCheck;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTalkModeMicSequenceCheck");
            view11 = null;
        }
        view11.setVisibility(0);
        View view12 = this.mMicSequenceTimeContainer;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeContainer");
            view12 = null;
        }
        view12.setVisibility(0);
        TextView textView4 = this.mMicSequenceRelatedSettingTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceRelatedSettingTv");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.wr7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.g\u2026talk_mode_free_speech_rl)");
        this.mTalkModeFreeSpeechContainer = findViewById;
        View findViewById2 = view.findViewById(R.id.wre);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.g\u2026alk_mode_mic_sequence_rl)");
        this.mTalkModeMicSequenceContainer = findViewById2;
        View findViewById3 = view.findViewById(R.id.wra);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.g\u2026lk_mode_handup_speech_rl)");
        this.mTalkModeHandupSpeechContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.wr6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.g\u2026talk_mode_free_speech_iv)");
        this.mTalkModeFreeSpeechCheck = findViewById4;
        View findViewById5 = view.findViewById(R.id.wrd);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.g\u2026alk_mode_mic_sequence_iv)");
        this.mTalkModeMicSequenceCheck = findViewById5;
        View findViewById6 = view.findViewById(R.id.wr_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.g\u2026lk_mode_handup_speech_iv)");
        this.mTalkModeHandupSpeechCheck = findViewById6;
        View findViewById7 = view.findViewById(R.id.f165579wr4);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.g\u2026ify_mic_sequence_time_tv)");
        this.mMicSequenceTimeTv = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f165578wr3);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.g\u2026ify_mic_sequence_time_rl)");
        this.mMicSequenceTimeContainer = findViewById8;
        View findViewById9 = view.findViewById(R.id.f165576wr1);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.g\u2026uence_related_setting_tv)");
        this.mMicSequenceRelatedSettingTv = (TextView) findViewById9;
        View view2 = this.mTalkModeFreeSpeechContainer;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTalkModeFreeSpeechContainer");
            view2 = null;
        }
        view2.setOnClickListener(this);
        View view4 = this.mTalkModeMicSequenceContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTalkModeMicSequenceContainer");
            view4 = null;
        }
        view4.setOnClickListener(this);
        View view5 = this.mTalkModeHandupSpeechContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTalkModeHandupSpeechContainer");
            view5 = null;
        }
        view5.setOnClickListener(this);
        View view6 = this.mMicSequenceTimeContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeContainer");
        } else {
            view3 = view6;
        }
        view3.setOnClickListener(this);
    }

    @NotNull
    public final IGProChannelInfo Jh() {
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo != null) {
            return iGProChannelInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
        return null;
    }

    @NotNull
    public final IGProGuildInfo Kh() {
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
        return null;
    }

    /* renamed from: Lh, reason: from getter */
    public final int getMSecond() {
        return this.mSecond;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.rolegroup.view.b Mh() {
        com.tencent.mobileqq.guild.rolegroup.view.b bVar = this.micSequenceTimeView;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("micSequenceTimeView");
        return null;
    }

    public final void Th(@NotNull IGProChannelInfo iGProChannelInfo) {
        Intrinsics.checkNotNullParameter(iGProChannelInfo, "<set-?>");
        this.mChannelInfo = iGProChannelInfo;
    }

    public final void Uh(@NotNull IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(iGProGuildInfo, "<set-?>");
        this.mGuildInfo = iGProGuildInfo;
    }

    public final void Vh(int i3) {
        this.mSecond = i3;
    }

    public final void ci(@NotNull com.tencent.mobileqq.guild.rolegroup.view.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.micSequenceTimeView = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("extra_guild_channel_info");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo");
            Th((IGProChannelInfo) serializable);
            Serializable serializable2 = arguments.getSerializable("extra_guild_guild_info");
            Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo");
            Uh((IGProGuildInfo) serializable2);
        }
        Logger.f235387a.d().i("GuildRoleModifyTalkModeFragment", 1, "doOnCreateView mChannelInfo:" + Jh() + ", channelId = " + Jh().getChannelUin() + " mGuildInfo:" + Kh());
        Qh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f6t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!FastClickUtils.isFastDoubleClick("GuildRoleModifyTalkModeFragmentguild_modify_talk_mode")) {
            View view = this.mTalkModeFreeSpeechContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTalkModeFreeSpeechContainer");
                view = null;
            }
            if (Intrinsics.areEqual(v3, view)) {
                Rh();
                Nh(v3, "em_pg_sgrp_speakmode_free");
            } else {
                View view2 = this.mTalkModeMicSequenceContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTalkModeMicSequenceContainer");
                    view2 = null;
                }
                if (Intrinsics.areEqual(v3, view2)) {
                    Logger.f235387a.d().i("GuildRoleModifyTalkModeFragment", 1, "onClick mic sequence:");
                    bi(false);
                    Nh(v3, "em_pg_sgrp_speakmode_queue");
                } else {
                    View view3 = this.mTalkModeHandupSpeechContainer;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTalkModeHandupSpeechContainer");
                        view3 = null;
                    }
                    if (Intrinsics.areEqual(v3, view3)) {
                        Sh();
                        Nh(v3, "em_pg_sgrp_speakmode_raise_hand");
                    } else {
                        View view4 = this.mMicSequenceTimeContainer;
                        if (view4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeContainer");
                            view4 = null;
                        }
                        if (Intrinsics.areEqual(v3, view4)) {
                            Logger.f235387a.d().i("GuildRoleModifyTalkModeFragment", 1, "onClick mMicSequenceTimeTv:");
                            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(getAppInterface(), false, null);
                            FragmentActivity activity = getActivity();
                            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
                            ci(new com.tencent.mobileqq.guild.rolegroup.view.b(activity, isNowThemeIsNight));
                            Mh().h(this.mSecond);
                            if (Mh().a() == null) {
                                Mh().b(new b());
                            }
                            Mh().d();
                            Nh(v3, "em_pg_sgrp_speakmode_time_set");
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Ph();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildRoleModifyTalkModeFragment$b", "Lcom/tencent/mobileqq/guild/widget/selector/GuildActionSheetProfileEdit$d;", "", "onDismiss", "onConfirm", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildActionSheetProfileEdit.d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
        public void onConfirm() {
            GuildRoleModifyTalkModeFragment guildRoleModifyTalkModeFragment = GuildRoleModifyTalkModeFragment.this;
            guildRoleModifyTalkModeFragment.Vh(guildRoleModifyTalkModeFragment.Mh().g());
            TextView textView = GuildRoleModifyTalkModeFragment.this.mMicSequenceTimeTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMicSequenceTimeTv");
                textView = null;
            }
            GuildRoleModifyTalkModeFragment guildRoleModifyTalkModeFragment2 = GuildRoleModifyTalkModeFragment.this;
            textView.setText(guildRoleModifyTalkModeFragment2.Oh(guildRoleModifyTalkModeFragment2.getMSecond()));
            Logger logger = Logger.f235387a;
            GuildRoleModifyTalkModeFragment guildRoleModifyTalkModeFragment3 = GuildRoleModifyTalkModeFragment.this;
            logger.d().i("GuildRoleModifyTalkModeFragment", 1, "micSequenceTimeView onConfirm second = " + guildRoleModifyTalkModeFragment3.getMSecond() + " ");
            GuildRoleModifyTalkModeFragment.this.bi(true);
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildActionSheetProfileEdit.d
        public void onDismiss() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(DialogInterface dialogInterface, int i3) {
    }
}
