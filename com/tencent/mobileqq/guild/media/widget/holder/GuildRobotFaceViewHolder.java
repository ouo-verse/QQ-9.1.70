package com.tencent.mobileqq.guild.media.widget.holder;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.RefreshType;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVoiceMicView;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.LivingAnimationView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRobotStateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGProAudioLiveRobotStatusCallback;
import cx1.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import mqq.util.WeakReference;
import zw1.e;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRobotFaceViewHolder extends BaseMediaItemDelegate.BaseMediaViewHolder implements View.OnClickListener {
    private static final int ROBOT_DEFAULT_VOLUME = 58;
    private static final String TAG = "QGMC.RobotFaceViewHolder";
    GuildWavAvatarImageView avatarIv;
    LinearLayout bodyRootContainer;
    private int columnsFlag;
    ImageView detailIv;
    public View itemView;
    f localUser;
    LinearLayout mAudioItemBodyLayout;
    private IGProChannelInfo mChannelInfo;
    private IGProGuildInfo mGuildInfo;
    GProAudioLiveRobotStatusRspInfo mStatus;
    GuildMediaVoiceMicView micIv;
    ImageView muteTv;
    TextView nickNameTv;
    private final Random random;
    LivingAnimationView statusAnimation;
    LinearLayout statusLayout;
    TextView statusTv;
    TextView tagTv;
    private Observer<Map<String, p>> trtcVolumeInfoObserve;
    String userId;
    p userInfo;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b implements MiniAppLaunchListener {

        /* renamed from: a, reason: collision with root package name */
        private String f229917a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<View> f229918b;

        public b(View view, String str) {
            this.f229917a = str;
            this.f229918b = new WeakReference<>(view);
        }

        @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            if (bundle != null && this.f229918b.get() != null) {
                w.x0(this.f229917a, bundle.getInt("retCode"), bundle.getString("errMsg"), this.f229918b.get());
            }
        }
    }

    public GuildRobotFaceViewHolder(View view) {
        super(view);
        this.userId = "";
        this.random = new Random();
        this.columnsFlag = -1;
        this.trtcVolumeInfoObserve = new Observer() { // from class: com.tencent.mobileqq.guild.media.widget.holder.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRobotFaceViewHolder.this.lambda$new$0((Map) obj);
            }
        };
        this.itemView = view;
        this.avatarIv = (GuildWavAvatarImageView) view.findViewById(R.id.f165434vz4);
        this.micIv = (GuildMediaVoiceMicView) view.findViewById(R.id.vz5);
        this.muteTv = (ImageView) view.findViewById(R.id.vz6);
        this.micIv.setVisibility(8);
        this.muteTv.setVisibility(8);
        this.nickNameTv = (TextView) view.findViewById(R.id.vz7);
        this.bodyRootContainer = (LinearLayout) view.findViewById(R.id.wwo);
        this.statusLayout = (LinearLayout) view.findViewById(R.id.wx5);
        this.statusTv = (TextView) view.findViewById(R.id.wx6);
        this.statusAnimation = (LivingAnimationView) view.findViewById(R.id.vzt);
        this.tagTv = (TextView) view.findViewById(R.id.wx7);
        this.detailIv = (ImageView) view.findViewById(R.id.vzs);
        this.mAudioItemBodyLayout = (LinearLayout) view.findViewById(R.id.vza);
        this.avatarIv.setOnClickListener(this);
        this.avatarIv.setColor(Color.parseColor("#00B3FF"));
        this.mAudioItemBodyLayout.setOnClickListener(this);
        this.statusTv.setOnClickListener(this);
        this.detailIv.setOnClickListener(this);
        int random = (int) ((Math.random() * 2.0d) + 1.0d);
        QLog.i(TAG, 1, "MemberRvBaseItemViewHolder init randNum " + random);
        if (GuildMediaUtils.f227771a.n()) {
            view.setBackgroundResource(R.drawable.guild_media_channel_user_item_bg);
        } else if (random == 1) {
            view.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg1);
        } else {
            view.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dealResponse, reason: merged with bridge method [inline-methods] */
    public void lambda$handleServiceItemClick$1(GProAudioLiveRobotStatusRsp gProAudioLiveRobotStatusRsp, View view) {
        GProAudioLiveRobotStatusRspInfo gProAudioLiveRobotStatusRspInfo;
        ArrayList<GProAudioLiveRobotStatusRspInfo> rspInfos = gProAudioLiveRobotStatusRsp.getRspInfos();
        long d16 = az.d(this.userId, 0L);
        Iterator<GProAudioLiveRobotStatusRspInfo> it = rspInfos.iterator();
        while (true) {
            if (it.hasNext()) {
                gProAudioLiveRobotStatusRspInfo = it.next();
                if (d16 == gProAudioLiveRobotStatusRspInfo.getBotId()) {
                    break;
                }
            } else {
                gProAudioLiveRobotStatusRspInfo = null;
                break;
            }
        }
        if (gProAudioLiveRobotStatusRspInfo == null) {
            return;
        }
        int detailType = gProAudioLiveRobotStatusRspInfo.getDetailType();
        String detailUrl = gProAudioLiveRobotStatusRspInfo.getDetailUrl();
        if (detailType == 0) {
            cx.a(view.getContext(), detailUrl);
            return;
        }
        if (detailType == 1) {
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            if (!iMiniAppService.isMiniAppUrl(detailUrl)) {
                QLog.d(TAG, 1, "open robot mini app, url error : ", detailUrl);
                return;
            }
            EntryModel entryModel = new EntryModel();
            entryModel.type = -1;
            iMiniAppService.startMiniApp(view.getContext(), detailUrl, 5003, entryModel, new b(view, detailUrl));
        }
    }

    private void handleInfoItemClick(View view, p pVar) {
        FragmentActivity fragmentActivity;
        if (o.c("click_avatar")) {
            return;
        }
        VideoReport.reportEvent("clck", view, null);
        if (this.mChannelInfo != null && this.mGuildInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_jump_information_result", 0);
            VideoReport.reportEvent("ev_qqrobot_jump_information", view, hashMap);
            if (view.getContext() instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) view.getContext();
            } else {
                fragmentActivity = QBaseActivity.sTopActivity;
            }
            RobotInfoFragment.xh(fragmentActivity, String.valueOf(this.mChannelInfo.getChannelUin()), String.valueOf(this.mGuildInfo.getGuildID()), pVar.f228093a, pVar.f228115w, "4", false, new a(), 0);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("qq_robot_jump_information_result", 1);
        VideoReport.reportEvent("ev_qqrobot_jump_information", view, hashMap2);
    }

    private void handleServiceItemClick(final View view) {
        if (o.c("click_detail") || view == null) {
            return;
        }
        VideoReport.reportEvent("clck", view, null);
        GuildChannel guildChannel = new GuildChannel();
        guildChannel.e(Long.parseLong(this.mChannelInfo.getGuildId()));
        guildChannel.c(Long.parseLong(this.mChannelInfo.getChannelUin()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(Long.parseLong(this.userId)));
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.getAudioLiveRobotStatus(new GProAudioLiveRobotStatusReq(az.d(this.mChannelInfo.getGuildId(), 0L), az.d(this.mChannelInfo.getChannelUin(), 0L), arrayList), new IGProAudioLiveRobotStatusCallback() { // from class: com.tencent.mobileqq.guild.media.widget.holder.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProAudioLiveRobotStatusCallback
            public final void onResult(int i3, String str, GProAudioLiveRobotStatusRsp gProAudioLiveRobotStatusRsp) {
                GuildRobotFaceViewHolder.this.lambda$handleServiceItemClick$2(view, i3, str, gProAudioLiveRobotStatusRsp);
            }
        });
    }

    private boolean isServiceEnabled() {
        return this.localUser.R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleServiceItemClick$2(final View view, int i3, String str, final GProAudioLiveRobotStatusRsp gProAudioLiveRobotStatusRsp) {
        if (i3 == 0 && gProAudioLiveRobotStatusRsp != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.holder.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRobotFaceViewHolder.this.lambda$handleServiceItemClick$1(gProAudioLiveRobotStatusRsp, view);
                }
            });
            return;
        }
        QLog.e(TAG, 1, "getAudioLiveRobotStatus|result=" + i3, " errMsg=" + str);
    }

    private void resetViewBackground(int i3) {
        if (i3 <= 1) {
            this.itemView.setBackgroundResource(0);
            return;
        }
        if (GuildMediaUtils.f227771a.n()) {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_item_bg);
        } else if (this.random.nextBoolean()) {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg1);
        } else {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg2);
        }
    }

    private int select(int i3, int i16, int i17, int i18) {
        if (i3 != 1) {
            if (i3 != 2) {
                return i18;
            }
            return i17;
        }
        return i16;
    }

    private int selectDp(int i3, int i16, int i17, int i18) {
        if (i3 != 1) {
            if (i3 != 2) {
                return ViewUtils.dpToPx(i18);
            }
            return ViewUtils.dpToPx(i17);
        }
        return ViewUtils.dpToPx(i16);
    }

    private void setAvatar(p pVar) {
        this.avatarIv.setAvatarTinyId(this.mGuildInfo.getGuildID(), this.userId, pVar.f228096d, pVar.J);
        this.avatarIv.setIdentityView(R.drawable.guild_audio_avatar_identity);
        this.avatarIv.setIdentityViewBorderWidth(5);
        this.avatarIv.setAvatarSize(0);
        QLog.i(TAG, 1, "getAvatarUrl tinyId:" + this.userId);
    }

    private void setDtElement() {
        if (this.userInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_robot_id", this.userInfo.f228093a);
            hashMap.put("qq_robot_role_type", Integer.valueOf(this.localUser.f228098f));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.itemView, "em_qqrobot_member_list", hashMap);
            VideoReport.setElementEndExposePolicy(this.itemView, EndExposurePolicy.REPORT_ALL);
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.avatarIv, "em_qqrobot_robot_image", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mAudioItemBodyLayout, "em_qqrobot_robot_image", null);
        GuildWavAvatarImageView guildWavAvatarImageView = this.avatarIv;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(guildWavAvatarImageView, endExposurePolicy);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.detailIv, "em_qqrobot_edit_button", null);
        VideoReport.setElementEndExposePolicy(this.detailIv, endExposurePolicy);
        if (this.mStatus != null) {
            VideoReport.setElementId(this.statusTv, "em_qqrobot_play_type");
            TextView textView = this.statusTv;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_FIRST;
            VideoReport.setElementExposePolicy(textView, exposurePolicy);
            VideoReport.setElementEndExposePolicy(this.statusTv, endExposurePolicy);
            VideoReport.setElementExposePolicy(this.statusTv, exposurePolicy);
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("qq_robot_play_type", Integer.valueOf(this.mStatus.getStatusType()));
            VideoReport.setElementParams(this.statusTv, hashMap2);
        }
    }

    private void updateStatus(p pVar, GProAudioLiveRobotStatusRspInfo gProAudioLiveRobotStatusRspInfo, f fVar) {
        int i3;
        String str;
        if (pVar.f228093a == null) {
            QLog.e(TAG, 1, "Error: info.id is null");
            return;
        }
        this.mStatus = gProAudioLiveRobotStatusRspInfo;
        this.statusLayout.setVisibility(0);
        this.tagTv.setVisibility(8);
        if (!isServiceEnabled()) {
            this.detailIv.setVisibility(8);
        } else {
            this.detailIv.setVisibility(0);
        }
        IGProRobotStateInfo iGProRobotStateInfo = this.userInfo.K;
        if (iGProRobotStateInfo != null) {
            str = iGProRobotStateInfo.getPlayText();
            i3 = iGProRobotStateInfo.getPlayState();
        } else if (gProAudioLiveRobotStatusRspInfo != null) {
            String statusText = gProAudioLiveRobotStatusRspInfo.getStatusText();
            int statusType = gProAudioLiveRobotStatusRspInfo.getStatusType();
            str = statusText;
            i3 = statusType;
        } else {
            i3 = -1;
            str = "";
        }
        if (StringUtil.isEmpty(str)) {
            str = this.itemView.getContext().getString(R.string.f1492711u);
        }
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.statusAnimation.setVisibility(8);
                        this.statusTv.setText(str);
                        this.avatarIv.z();
                    }
                } else {
                    if (this.statusAnimation.getVisibility() != 0) {
                        this.statusAnimation.setVisibility(0);
                    }
                    this.statusTv.setText(str);
                    this.avatarIv.setVolume(58.0f);
                    this.avatarIv.y();
                }
            } else {
                this.statusAnimation.setVisibility(8);
                if (this.localUser.R) {
                    this.statusTv.setText(str);
                } else {
                    this.statusTv.setText("");
                }
                this.avatarIv.z();
            }
        } else {
            this.statusAnimation.setVisibility(8);
            this.statusTv.setText(R.string.f14864105);
        }
        setDtElement();
        VideoReport.traversePage(this.itemView);
    }

    public void bindColumn(int i3) {
        if (this.columnsFlag == i3) {
            return;
        }
        QLog.i(TAG, 1, "[bindColumn] " + i3);
        this.columnsFlag = i3;
        resetViewBackground(i3);
        int dpToPx = ViewUtils.dpToPx(30.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.rightMargin = selectDp(i3, 12, 12, 4);
        layoutParams.topMargin = selectDp(i3, 12, 12, 4);
        layoutParams.addRule(21);
        layoutParams.addRule(10);
        this.detailIv.setLayoutParams(layoutParams);
        this.avatarIv.setImageWidth(select(i3, 65, 65, 44));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = selectDp(i3, 16, 16, 12);
        this.bodyRootContainer.setLayoutParams(layoutParams2);
        this.nickNameTv.setMaxEms(select(i3, 7, 7, 5));
        this.nickNameTv.setTextSize(select(i3, 16, 16, 12));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = selectDp(i3, 4, 4, 2);
        this.tagTv.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(selectDp(i3, 20, 20, 16), selectDp(i3, 20, 20, 16));
        this.micIv.setLayoutParams(layoutParams4);
        this.muteTv.setLayoutParams(layoutParams4);
        this.statusTv.setTextSize(select(i3, 14, 14, 10));
    }

    public void bindData(p pVar, GProAudioLiveRobotStatusRspInfo gProAudioLiveRobotStatusRspInfo, IGProChannelInfo iGProChannelInfo, IGProGuildInfo iGProGuildInfo, f fVar) {
        this.userInfo = pVar;
        this.userId = pVar.f228093a;
        this.localUser = fVar;
        this.nickNameTv.setText(pVar.f228094b);
        this.mChannelInfo = iGProChannelInfo;
        this.mGuildInfo = iGProGuildInfo;
        setAvatar(pVar);
        updateStatus(pVar, gProAudioLiveRobotStatusRspInfo, fVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f165434vz4 && view.getId() != R.id.vza) {
            if (view.getId() == R.id.vzs || (view.getId() == R.id.wx6 && isServiceEnabled())) {
                handleServiceItemClick(view);
            }
        } else {
            handleInfoItemClick(view, this.userInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onViewAttachedToWindow() {
        j.c().a0().observeForever(this.trtcVolumeInfoObserve);
    }

    public void onViewDetachedFromWindow() {
        j.c().a0().removeObserver(this.trtcVolumeInfoObserve);
    }

    public void resetStatusAndAnim() {
        GuildWavAvatarImageView guildWavAvatarImageView = this.avatarIv;
        if (guildWavAvatarImageView != null) {
            guildWavAvatarImageView.A();
        }
    }

    /* renamed from: setVolume, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0(Map<String, p> map) {
        int i3;
        p pVar = map.get(this.userId);
        if (pVar != null && pVar.f228101i && (i3 = pVar.f228109q) > 5) {
            this.avatarIv.setVolume(i3);
        } else {
            this.avatarIv.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements RobotInfoFragment.a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void b(boolean z16) {
            j.a().G(GuildRobotFaceViewHolder.this.mChannelInfo.getChannelUin(), RefreshType.BY_AUDIO_ROBOT);
            e.r();
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void a() {
        }
    }
}
