package com.tencent.mobileqq.guild.feed.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditDraftInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRetryTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils;
import com.tencent.mobileqq.guild.feed.util.al;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkpublish.config.GuildUploadLocalConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class GuildFeedProgressItemView extends GuildBaseWidgetView<ij1.g> implements View.OnClickListener, SimpleEventReceiver {
    private TextView C;
    private TextView D;
    private GuildTaskProgressState E;
    private ImageView F;
    private View G;
    private TextView H;
    private RoundCornerLayout I;
    private TextView J;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f224188d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f224189e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f224190f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f224191h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f224192i;

    /* renamed from: m, reason: collision with root package name */
    private ProgressBar f224193m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            GuildFeedProgressItemView.this.C0("CH_E_SENDBOX_CANCEL_SEL_CANCEL_NO");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GuildFeedProgressItemView.this.r0();
            GuildFeedProgressItemView.this.C0("CH_E_SENDBOX_CANCEL_SEL_CANCEL_YES");
        }
    }

    public GuildFeedProgressItemView(@NonNull Context context) {
        super(context);
    }

    private boolean A0(GuildTaskProgressState guildTaskProgressState) {
        if ((guildTaskProgressState.getMainState() != 1 && guildTaskProgressState.getMainState() != 2) || guildTaskProgressState.getProgress() % 10 == 0) {
            return true;
        }
        return false;
    }

    private void B0() {
        int i3;
        if (this.E != null && (getContext() instanceof Activity)) {
            if (wj1.c.b(this.E.getJson())) {
                try {
                    JSONObject jSONObject = new JSONObject(new JSONObject(this.E.getJson()).optString("jsonFeed"));
                    String str = "";
                    if (jSONObject.has("id")) {
                        str = jSONObject.getString("id");
                    }
                    String str2 = str;
                    if (jSONObject.has("publishExtra")) {
                        jSONObject.remove("publishExtra");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        i3 = 4;
                    } else {
                        i3 = 3;
                    }
                    em1.a.e(getContext(), this.E.getGuildId(), this.E.getChannelId(), str2, i3, jSONObject.toString(), this.E.getMainTaskId(), this.E.getBusinessType());
                    return;
                } catch (Exception e16) {
                    QLog.d("GUP-T-GuildFeedProgressItemView", 1, "onClickEntryEditor error! " + e16.getMessage());
                    return;
                }
            }
            GuildFeedPublishInitBean guildFeedPublishInitBean = new GuildFeedPublishInitBean();
            GuildFeedPublishEditDraftInitBean guildFeedPublishEditDraftInitBean = new GuildFeedPublishEditDraftInitBean();
            guildFeedPublishInitBean.setDraftBean(guildFeedPublishEditDraftInitBean);
            guildFeedPublishEditDraftInitBean.setTaskId(this.E.getMainTaskId());
            guildFeedPublishEditDraftInitBean.setFeedJson(this.E.getJson());
            guildFeedPublishInitBean.setGuildId(this.E.getGuildId());
            guildFeedPublishInitBean.setChannelId(this.E.getChannelId());
            GuildFeedBaseInitBean q16 = ax.q(getContext());
            if (q16 != null) {
                guildFeedPublishInitBean.setBusinessType(q16.getBusinessType());
                guildFeedPublishInitBean.setTroopUin(q16.getTroopUin());
                guildFeedPublishInitBean.setTroopRole(q16.getTroopRole());
            }
            String u16 = ax.u();
            guildFeedPublishInitBean.setTinyId(u16);
            guildFeedPublishInitBean.setNickName(((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayName(this.E.getGuildId(), u16));
            GuildFeedLauncher.B(getContext(), guildFeedPublishInitBean);
            QLog.i("GUP-T-GuildFeedProgressItemView", 1, "[onClickEntryEditor]  | taskData = " + this.E.toString() + " | json = " + this.E.getJson());
            C0("CH_E_SENDBOX_EDIT");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String str) {
        String str2;
        int size = ((GuildFeedWorker) jj1.b.c().getDataWorker(GuildFeedWorker.class)).v(this.E.getGuildId(), this.E.getChannelId()).size();
        GuildUploadLocalConfig n3 = GuildTaskQueueManager.m().n();
        QCirclePublishQualityDataBuilder ext4 = new QCirclePublishQualityDataBuilder().setKeyEventId(str).setTraceId(this.E.getMainTaskId()).setExt1(al.c(this.E.getMediaProgressStates())).setExt2(String.valueOf(this.E.getMediaProgressStates().size())).setExt3(al.a(this.E.getMediaProgressStates())).setExt4(al.b(this.E.getMediaProgressStates()));
        if (this.E.isEdit()) {
            str2 = "isModify";
        } else {
            str2 = "isNotModify";
        }
        n3.uploadQualityReport(ext4.setExt5(str2).setExt6(String.valueOf(size)));
    }

    private void D0(View view) {
        QLog.d("GUP-T-GuildFeedProgressItemView", 1, "retryPublish  mTaskData = " + this.E);
        if (this.E != null && !((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view)) {
            this.f224192i.setVisibility(8);
            this.f224191h.setVisibility(0);
            SimpleEventBus.getInstance().dispatchEvent(new GuildRetryTaskOperationEvent(2, this.E.getMainTaskId()));
            C0("CH_E_SENDBOX_RETRY");
        }
    }

    private void E0() {
        this.f224192i.setVisibility(8);
        this.f224191h.setVisibility(0);
        this.f224190f.setText(HardCodeUtil.qqStr(R.string.f145020qc));
    }

    @SuppressLint({"SetTextI18n"})
    private void F0(int i3) {
        this.f224192i.setVisibility(8);
        this.f224191h.setVisibility(0);
        this.f224190f.setText(String.format(HardCodeUtil.qqStr(R.string.f145090qj), Integer.valueOf(i3)) + HardCodeUtil.qqStr(R.string.f145100qk));
        this.f224193m.setProgress(i3);
    }

    private void G0() {
        this.f224189e.setVisibility(8);
        GuildTaskProgressState guildTaskProgressState = this.E;
        if (guildTaskProgressState == null) {
            QLog.e("GUP-T-GuildFeedProgressItemView", 1, "setAvatarPic  mTaskData == null");
            return;
        }
        List<GuildMediaProgressState> mediaProgressStates = guildTaskProgressState.getMediaProgressStates();
        Iterator<GuildMediaProgressState> it = mediaProgressStates.iterator();
        GuildMediaProgressState guildMediaProgressState = null;
        String str = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GuildMediaProgressState next = it.next();
            if (TextUtils.equals(next.getType(), "pic")) {
                if (!TextUtils.isEmpty(next.getPath())) {
                    str = next.getPath();
                } else {
                    str = next.getCoverUrl();
                }
                if (!TextUtils.isEmpty(str)) {
                    QLog.i("GUP-T-GuildFeedProgressItemView", 1, "setAvatarPic url from image, url = " + str);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<GuildMediaProgressState> it5 = mediaProgressStates.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                GuildMediaProgressState next2 = it5.next();
                if (TextUtils.equals(next2.getType(), "video")) {
                    if (guildMediaProgressState == null) {
                        guildMediaProgressState = next2;
                    }
                    if (next2.getCoverUrl() != null) {
                        String coverUrl = next2.getCoverUrl();
                        QLog.i("GUP-T-GuildFeedProgressItemView", 1, "setAvatarPic url from video cover, url = " + coverUrl);
                        str = coverUrl;
                        break;
                    }
                }
            }
            if (str == null && guildMediaProgressState != null && !TextUtils.isEmpty(guildMediaProgressState.getPath())) {
                final String b16 = GuildFeedMediaUtils.b(guildMediaProgressState.getPath());
                QLog.i("GUP-T-GuildFeedProgressItemView", 1, "setAvatarPic url from video transform cover, thumbnailPath = " + b16);
                GuildFeedMediaUtils.g(guildMediaProgressState.getPath(), b16, new GuildFeedMediaUtils.a() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildFeedProgressItemView.1
                    @Override // com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils.a
                    public void onComplete() {
                        if (b16 != null) {
                            QLog.i("GUP-T-GuildFeedProgressItemView", 1, "setAvatarPic url from video transform cover, transform success,  thumbnailPath = " + b16);
                            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildFeedProgressItemView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    GuildFeedProgressItemView.this.z0(b16);
                                }
                            });
                        }
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(str)) {
            z0(str);
        }
    }

    private void H0() {
        if (QQTheme.isNowThemeIsNight()) {
            this.f224193m.setProgressDrawable(getContext().getResources().getDrawable(R.drawable.guild_feed_publish_night_mode_progress));
            this.f224188d.setBackgroundResource(R.drawable.guild_feed_publish_progress_item_night_back);
        } else {
            this.f224193m.setProgressDrawable(getContext().getResources().getDrawable(R.drawable.guild_feed_publish_progress));
            this.f224188d.setBackgroundResource(R.drawable.guild_feed_publish_progress_item_back);
        }
    }

    private void I0(GuildTaskProgressState guildTaskProgressState) {
        this.f224192i.setVisibility(0);
        this.f224191h.setVisibility(8);
        long j3 = guildTaskProgressState.mPublishErrCode;
        if (j3 == 10023) {
            this.H.setText(R.string.f144950q6);
            this.H.setOnClickListener(null);
        } else if (j3 == 10015) {
            this.H.setText(R.string.f144910q2);
            this.H.setOnClickListener(this);
        } else {
            this.H.setText(R.string.f145170qr);
            this.H.setOnClickListener(this);
        }
    }

    private void J0(GuildTaskProgressState guildTaskProgressState) {
        if (guildTaskProgressState == null) {
            QLog.e("GUP-T-GuildFeedProgressItemView", 1, "updateProgressOrState  progressState == null");
            return;
        }
        if (guildTaskProgressState.getMainState() == 3) {
            E0();
        } else if (guildTaskProgressState.getMainState() != 4 && guildTaskProgressState.getMainState() != 5) {
            F0(guildTaskProgressState.getProgress());
        } else {
            I0(guildTaskProgressState);
        }
        if (A0(guildTaskProgressState)) {
            QLog.i("GUP-T-GuildFeedProgressItemView", 1, "updateProgressOrState  | mainTaskId = " + guildTaskProgressState.getMainTaskId() + " | mainState = " + guildTaskProgressState.getMainState() + " | progress = " + guildTaskProgressState.getProgress());
        }
    }

    private void p0() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setListItemElementExposureAndClickParams(this.D, "em_sgrp_forum_fail_cancel", String.valueOf(this.E.hashCode()), new HashMap());
    }

    private void q0() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setListItemElementExposureAndClickParams(this.J, "em_sgrp_forum_fail_reedit", String.valueOf(this.E.hashCode()), new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        GuildTaskProgressState guildTaskProgressState = this.E;
        if (guildTaskProgressState != null && !TextUtils.isEmpty(guildTaskProgressState.getMainTaskId())) {
            QLog.i("GUP-T-GuildFeedProgressItemView", 1, "cancelOperation  mTaskData = " + this.E.toString());
            GuildTaskQueueManager.m().M(this.E.getMainTaskId(), this.E.getJson(), this.E.mJson, 0);
            GuildCancelTaskOperationEvent guildCancelTaskOperationEvent = new GuildCancelTaskOperationEvent(2, this.E.getMainTaskId(), false);
            guildCancelTaskOperationEvent.setActionType(GuildCancelTaskOperationEvent.ACTION_TYPE_USER_OPERATION);
            bl.c().b(guildCancelTaskOperationEvent, true);
            return;
        }
        QLog.e("GUP-T-GuildFeedProgressItemView", 1, "cancelOperation  data == null || taskId == null");
    }

    private void s0() {
        DialogUtil.createCustomDialog(Foreground.getTopActivity(), 0, (String) null, HardCodeUtil.qqStr(R.string.f145670s4), HardCodeUtil.qqStr(R.string.ihc), HardCodeUtil.qqStr(R.string.hl7), new a(), new b()).show();
        C0("CH_E_SENDBOX_CANCEL_SHOW");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void y0(GuildTaskProgressStateEvent guildTaskProgressStateEvent) {
        if (guildTaskProgressStateEvent.getTaskProgressState() != null && getData().p() != null && TextUtils.equals(guildTaskProgressStateEvent.getTaskProgressState().getMainTaskId(), getData().p().getMainTaskId())) {
            QLog.e("GUP-T-GuildFeedProgressItemView", 1, "handleTaskProgressStateEvent:  progressState[" + guildTaskProgressStateEvent.getTaskProgressState().toString() + "]");
            GuildTaskProgressState taskProgressState = guildTaskProgressStateEvent.getTaskProgressState();
            getData().z(taskProgressState);
            this.E = taskProgressState;
            J0(taskProgressState);
        }
    }

    private void v0() {
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.J.setOnClickListener(this);
    }

    private void w0() {
        LinearLayout linearLayout = this.f224188d;
        if (linearLayout != null) {
            this.F.setImageDrawable(GuildUIUtils.w(linearLayout.getContext(), R.drawable.qui_refresh, Integer.valueOf(R.color.qui_common_icon_white)));
        }
    }

    private void x0(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.wd9);
        if (viewStub != null) {
            this.f224188d = (LinearLayout) viewStub.inflate();
        }
        this.f224189e = (ImageView) view.findViewById(R.id.y2x);
        this.I = (RoundCornerLayout) view.findViewById(R.id.ifh);
        this.f224191h = (RelativeLayout) view.findViewById(R.id.yfa);
        this.f224192i = (RelativeLayout) view.findViewById(R.id.yf_);
        this.f224190f = (TextView) view.findViewById(R.id.f110196hv);
        this.f224193m = (ProgressBar) view.findViewById(R.id.f110186hu);
        this.C = (TextView) view.findViewById(R.id.f167033k60);
        this.D = (TextView) view.findViewById(R.id.f1064568r);
        this.F = (ImageView) view.findViewById(R.id.y89);
        this.G = view.findViewById(R.id.yfg);
        this.H = (TextView) view.findViewById(R.id.f110746jc);
        this.J = (TextView) view.findViewById(R.id.f107626ax);
        w0();
        v0();
        float dip2px = ScreenUtil.dip2px(4.0f);
        this.I.setRadius(dip2px, dip2px, dip2px, dip2px);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        this.f224189e.setVisibility(0);
        String d16 = com.tencent.mobileqq.guild.picload.e.d(str);
        String str2 = (String) this.f224189e.getTag(R.id.y2x);
        if (str != null && !TextUtils.isEmpty(d16) && !d16.equals(str2)) {
            this.f224189e.setTag(R.id.y2x, d16);
            com.tencent.mobileqq.guild.u.p(str, this.f224189e);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildTaskProgressStateEvent.class);
        arrayList.add(GuildFeedThemeChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.eqa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(ij1.g gVar, int i3) {
        if (gVar != null && gVar.p() != null) {
            if (this.E != null && TextUtils.equals(gVar.p().getMainTaskId(), this.E.getMainTaskId())) {
                return;
            }
            GuildTaskProgressState p16 = gVar.p();
            this.E = p16;
            J0(p16);
            G0();
            p0();
            q0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f107626ax) {
            B0();
        } else if (id5 != R.id.y89 && id5 != R.id.f110746jc) {
            if (id5 == R.id.f167033k60 || id5 == R.id.f1064568r) {
                s0();
            }
        } else {
            D0(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildTaskProgressStateEvent) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedProgressItemView.this.y0(simpleBaseEvent);
                }
            });
        } else if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            H0();
            QLog.d("GUP-T-GuildFeedProgressItemView", 1, "theme change");
        }
    }

    public GuildFeedProgressItemView(@NonNull Context context, Integer num) {
        super(context, num);
        x0(this);
    }
}
