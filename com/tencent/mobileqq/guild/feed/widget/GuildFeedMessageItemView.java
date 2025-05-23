package com.tencent.mobileqq.guild.feed.widget;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import com.airbnb.lottie.LottieAnimationView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.util.au;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.menu.BaseMenuEntry;
import com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCustomManageTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import zm1.a;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedMessageItemView extends GuildBaseWidgetView<ij1.a> implements View.OnClickListener {
    public TextView C;
    public TextView D;
    public TextView E;
    public FrameLayout F;
    public RoundRectImageView G;
    public ImageView H;
    public ImageView I;
    public ImageView J;
    public LinearLayout K;
    public LinearLayout L;
    public ConstraintLayout M;
    public LottieAnimationView N;
    public RFWRoundImageView P;
    public TextView Q;
    private boolean R;
    private int S;
    private com.tencent.mobileqq.guild.feed.part.notice.f T;
    private GProStNotice U;
    private GuildFeedBaseInitBean V;
    private SwipeMenuLayout W;

    /* renamed from: a0, reason: collision with root package name */
    private GuildSwipeMenuItemHelper f224155a0;

    /* renamed from: d, reason: collision with root package name */
    public View f224156d;

    /* renamed from: e, reason: collision with root package name */
    public GuildUserAvatarView f224157e;

    /* renamed from: f, reason: collision with root package name */
    public QQProAvatarView f224158f;

    /* renamed from: h, reason: collision with root package name */
    public View f224159h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f224160i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f224161m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements Function1<IGProGuildInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProStNotice f224170d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f224171e;

        a(GProStNotice gProStNotice, String str) {
            this.f224170d = gProStNotice;
            this.f224171e = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            GuildFeedMessageItemView.this.h1(iGProGuildInfo, this.f224170d, this.f224171e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements Function1<IGProGuildInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f224173d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f224174e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f224175f;

        b(String str, String str2, View view) {
            this.f224173d = str;
            this.f224174e = str2;
            this.f224175f = view;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            if (!this.f224173d.isEmpty() && !this.f224174e.isEmpty() && iGProGuildInfo != null) {
                GuildFeedMessageItemView.this.L0(iGProGuildInfo, this.f224173d, this.f224174e, this.f224175f);
                return null;
            }
            QLog.e("GuildFeedMessageItemView", 1, "fetchGuildInfoAnyway guildInfo is null.");
            yl1.n.A(0, "\u64cd\u4f5c\u5931\u8d25");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements Function1<IGProGuildInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f224177d;

        c(String str) {
            this.f224177d = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            if (!this.f224177d.isEmpty() && iGProGuildInfo != null) {
                GuildFeedMessageItemView.this.i1(iGProGuildInfo);
                return null;
            }
            QLog.e("GuildFeedMessageItemView", 1, "fetchGuildInfoAnyway guildInfo is null.");
            GuildFeedMessageItemView.this.M.setVisibility(0);
            GuildFeedMessageItemView.this.P.setImageResource(R.drawable.guild_icon_default);
            GuildFeedMessageItemView.this.Q.setText("\u9891\u9053\u5df2\u89e3\u6563");
            return null;
        }
    }

    public GuildFeedMessageItemView(@NonNull Context context, Integer num, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        super(context, num);
        this.R = false;
        this.S = 0;
        V0(this);
        this.V = guildFeedBaseInitBean;
    }

    private void C0(GProStNotice gProStNotice, int i3) {
        Map a16;
        List<? extends BaseMenuEntry> a17;
        boolean z16 = !gProStNotice.isCloseInteract;
        a16 = e.a(new Map.Entry[]{new AbstractMap.SimpleEntry("sgrp_feed_id", gProStNotice.origineFeed.idd)});
        GuildSwipeMenuItemHelper guildSwipeMenuItemHelper = this.f224155a0;
        a17 = com.tencent.mobileqq.guild.feed.widget.d.a(new Object[]{new BaseMenuEntry.c(!z16, a16), new BaseMenuEntry.b(a16)});
        guildSwipeMenuItemHelper.n(a17);
        this.f224155a0.r(this, i3);
    }

    private void D0(GProStNotice gProStNotice) {
        ArrayList<GProStRichTextContent> arrayList;
        ArrayList<GProStRichTextContent> arrayList2;
        if (ui1.g.e(gProStNotice)) {
            G0(gProStNotice);
        } else {
            E0(gProStNotice);
        }
        this.C.setText(P0(gProStNotice.psvFeed.createTime * 1000));
        F0(gProStNotice);
        GProStRichText gProStRichText = gProStNotice.pattonInfo.plainTxt.txtInfo.content;
        if (gProStRichText != null && (arrayList2 = gProStRichText.contents) != null && arrayList2.size() > 0) {
            g1(gProStNotice.pattonInfo.plainTxt.txtInfo.content.contents);
        } else {
            g1(null);
        }
        GProStRichText gProStRichText2 = gProStNotice.pattonInfo.plainTxt.txtInfo.contentOfReference;
        if (gProStRichText2 != null && (arrayList = gProStRichText2.contents) != null && arrayList.size() > 0) {
            k1(gProStNotice.pattonInfo.plainTxt.txtInfo.contentOfReference.contents);
        } else {
            k1(null);
        }
        l1(gProStNotice);
        z0();
        if (TextUtils.isEmpty(this.V.getGuildId()) || "0".equals(this.V.getGuildId())) {
            S0();
        }
        int i3 = gProStNotice.type;
        if (i3 > 3 && i3 < 7 && !Y0().booleanValue() && gProStNotice.status != 1) {
            this.K.setVisibility(0);
            this.L.setVisibility(0);
        } else {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
        }
        boolean z16 = gProStNotice.psvFeed.totalLike.isClicked;
        this.S = z16 ? 1 : 0;
        m1(z16 ? 1 : 0);
        ImageView imageView = this.J;
        imageView.setImageDrawable(GuildUIUtils.w(imageView.getContext(), R.drawable.guild_feed_item_comment_icon_token_selector, Integer.valueOf(R.color.qui_common_icon_primary)));
    }

    private void E0(GProStNotice gProStNotice) {
        GProStUser gProStUser = gProStNotice.psvFeed.poster;
        String str = gProStUser.idd;
        String b16 = ui1.g.b(gProStNotice);
        this.f224157e.setTag(str);
        this.f224157e.setAvatarTinyId(b16, str);
        I0(gProStUser.nick);
        J0(gProStUser.userTagList);
    }

    private void F0(GProStNotice gProStNotice) {
        this.F.setVisibility(8);
        this.H.setVisibility(8);
        ArrayList<GProStVideo> arrayList = gProStNotice.origineFeed.videos;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.F.setVisibility(0);
            e1(this.G, arrayList.get(0).cover.picUrl);
            this.H.setVisibility(0);
        } else {
            ArrayList<GProStImage> arrayList2 = gProStNotice.origineFeed.images;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                this.F.setVisibility(0);
                e1(this.G, arrayList2.get(0).picUrl);
            }
        }
    }

    private void G0(final GProStNotice gProStNotice) {
        I0(getContext().getResources().getString(R.string.f154371em));
        J0(null);
        final String b16 = ui1.g.b(gProStNotice);
        String d16 = ui1.g.d(gProStNotice);
        if (!TextUtils.isEmpty(d16)) {
            this.f224157e.setVisibility(8);
            this.f224158f.setVisibility(0);
            this.f224158f.x(4, d16, null);
            return;
        }
        this.f224157e.setVisibility(0);
        this.f224158f.setVisibility(8);
        if (!TextUtils.isEmpty(b16) && !b16.equals("0")) {
            this.f224157e.setTag(b16);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedMessageItemView.this.a1(b16, gProStNotice);
                }
            }, 128, null, true);
            return;
        }
        QLog.d("GuildFeedMessageItemView", 1, "bindReportForExceptionData: guildId = " + b16);
        H0(gProStNotice);
    }

    private void H0(GProStNotice gProStNotice) {
        String c16 = ui1.g.c(gProStNotice);
        if (TextUtils.isEmpty(c16)) {
            QLog.e("GuildFeedMessageItemView", 1, "bindRobotFace robotIconUrl is null!");
            return;
        }
        this.f224157e.setTag(c16);
        j1(c16, c16, this.f224157e);
        QLog.d("GuildFeedMessageItemView", 1, "bindRobotFace: " + c16);
    }

    private void I0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f224160i.setVisibility(8);
        } else {
            this.f224160i.setVisibility(0);
            this.f224160i.setText(str);
        }
    }

    private void J0(List<GProCustomManageTag> list) {
        this.f224161m.setVisibility(8);
        if (list != null && list.size() != 0) {
            GProCustomManageTag gProCustomManageTag = list.get(0);
            if (TextUtils.isEmpty(gProCustomManageTag.tagName)) {
                return;
            }
            this.f224161m.setVisibility(0);
            this.f224161m.setText(gProCustomManageTag.tagName);
            TextView textView = this.f224161m;
            textView.setBackground(ol1.b.f423088a.c(textView.getContext()));
        }
    }

    private void K0(View view) {
        if (!Y0().booleanValue() && !this.R && !QQGuildUIUtil.v()) {
            String b16 = ui1.g.b(this.U);
            String a16 = ui1.g.a(this.U);
            if (!TextUtils.isEmpty(b16) && !TextUtils.isEmpty(a16)) {
                this.S = this.U.psvFeed.totalLike.isClicked ? 1 : 0;
                IGProGuildInfo L = ch.L(b16);
                if (L == null) {
                    GuildMainFrameUtils.l(b16, false, new b(b16, a16, view));
                    return;
                } else {
                    L0(L, b16, a16, view);
                    return;
                }
            }
            QLog.e("GuildFeedMessageItemView", 1, "doReply |channelId and guildId must not be empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(IGProGuildInfo iGProGuildInfo, final String str, String str2, View view) {
        GProStReply gProStReply;
        int i3 = 0;
        if (!iGProGuildInfo.isMember() && !((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getVisibleForVisitor(iGProGuildInfo)) {
            yl1.n.z(0, R.string.f158261p5);
            return;
        }
        if (this.S == 0) {
            this.R = true;
            this.S = 1;
            this.I.setVisibility(4);
            this.N.setVisibility(0);
            this.N.playAnimation();
        } else {
            this.S = 0;
        }
        m1(this.S);
        Uri parse = Uri.parse(this.U.pattonInfo.plainTxt.operation.schema);
        String queryParameter = parse.getQueryParameter("comment_id");
        String queryParameter2 = parse.getQueryParameter("reply_id");
        GProStComment gProStComment = new GProStComment();
        gProStComment.idd = queryParameter;
        if (!TextUtils.isEmpty(queryParameter2)) {
            GProStReply gProStReply2 = new GProStReply();
            gProStReply2.idd = queryParameter2;
            gProStReply = gProStReply2;
        } else {
            gProStReply = null;
        }
        this.T.l8(this.U, gProStComment, gProStReply, this.S, new IGProDoLikeCallback() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageItemView.4
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback
            public void onResult(final int i16, final String str3, boolean z16, GProStDoLikeRsp gProStDoLikeRsp) {
                ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageItemView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z17 = false;
                        if (i16 != 0) {
                            QLog.d("GuildFeedMessageItemView", 1, "result = " + i16 + ", msg =" + str3);
                            if (GuildFeedMessageItemView.this.S == 1) {
                                GuildFeedMessageItemView.this.S = 0;
                            } else {
                                GuildFeedMessageItemView.this.S = 1;
                            }
                            GuildFeedMessageItemView guildFeedMessageItemView = GuildFeedMessageItemView.this;
                            guildFeedMessageItemView.m1(guildFeedMessageItemView.S);
                            yl1.n.A(1, str3);
                            return;
                        }
                        GProTotalLike gProTotalLike = GuildFeedMessageItemView.this.U.psvFeed.totalLike;
                        if (GuildFeedMessageItemView.this.S == 1) {
                            z17 = true;
                        }
                        gProTotalLike.isClicked = z17;
                        if (GuildFeedMessageItemView.this.S == 1) {
                            yl1.n.A(2, "\u70b9\u8d5e\u6210\u529f");
                        }
                        if (GuildFeedMessageItemView.this.W0()) {
                            com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), str, "guild_notice_list_like");
                        }
                    }
                });
            }
        });
        HashMap hashMap = new HashMap();
        if (this.S != 1) {
            i3 = 1;
        }
        hashMap.put("sgrp_action_result", Integer.valueOf(i3));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_forum_up", "clck", hashMap);
    }

    private void M0(View view) {
        GProStReply gProStReply;
        if (!Y0().booleanValue() && !QQGuildUIUtil.v()) {
            Uri parse = Uri.parse(this.U.pattonInfo.plainTxt.operation.schema);
            String queryParameter = parse.getQueryParameter("comment_id");
            String queryParameter2 = parse.getQueryParameter("reply_id");
            GProStComment gProStComment = new GProStComment();
            gProStComment.idd = queryParameter;
            GProStFeed gProStFeed = this.U.psvFeed;
            gProStComment.postUser = gProStFeed.poster;
            gProStComment.createTime = gProStFeed.createTime;
            if (!TextUtils.isEmpty(queryParameter2)) {
                gProStReply = new GProStReply();
                gProStReply.postUser = this.U.psvFeed.poster;
                gProStReply.idd = queryParameter2;
            } else {
                gProStReply = null;
            }
            this.T.e6(this.U, gProStComment, gProStReply, W0());
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_forum_comment", "clck", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(String str, GuildUserAvatarView guildUserAvatarView, String str2) {
        boolean z16;
        Drawable avatarDrawable = ((IQQGuildAvatarApi) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IQQGuildAvatarApi.class)).getAvatarDrawable(str, 2, true, "");
        Object tag = guildUserAvatarView.getTag();
        if (avatarDrawable != null && str2.equals(tag)) {
            this.f224157e.setTag(R.id.f165440w05, null);
            guildUserAvatarView.setImageDrawable(avatarDrawable);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tag: ");
        sb5.append(tag);
        sb5.append(", originalViewTag: ");
        sb5.append(str2);
        sb5.append(", drawable: ");
        if (avatarDrawable != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.e("GuildFeedMessageItemView", 1, sb5.toString());
    }

    private void O0() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_msg_type", Integer.valueOf(this.U.datongType));
        if (this.V.getBusinessType() != 7) {
            String b16 = ui1.g.b(this.U);
            String a16 = ui1.g.a(this.U);
            String valueOf = String.valueOf(this.U.origineFeed.idd);
            hashMap.put("sgrp_channel_id", b16);
            hashMap.put("sgrp_sub_channel_id", a16);
            hashMap.put("sgrp_feed_id", valueOf);
        }
        VideoReport.setElementId(this.f224156d, "em_sgrp_forum_related_feed");
        VideoReport.setElementParams(this.f224156d, hashMap);
        VideoReport.setElementExposePolicy(this.f224156d, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.f224156d, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f224156d, ClickPolicy.REPORT_NONE);
    }

    private String P0(long j3) {
        Date date;
        Object valueOf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        if (j3 == 0) {
            date = new Date();
        } else {
            date = new Date(j3);
        }
        String format = simpleDateFormat.format(date);
        Time time = new Time();
        time.set(j3);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        int i3 = time2.yearDay - 1;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" ");
        sb5.append(time.hour);
        sb5.append(":");
        int i16 = time.minute;
        if (i16 < 10) {
            valueOf = "0" + time.minute;
        } else {
            valueOf = Integer.valueOf(i16);
        }
        sb5.append(valueOf);
        String sb6 = sb5.toString();
        if (time.year == time2.year) {
            int i17 = time2.yearDay;
            int i18 = time.yearDay;
            if (i17 < i18) {
                return format;
            }
            if (i17 == i18) {
                return HardCodeUtil.qqStr(R.string.f146670ut) + sb6;
            }
            if (i18 == i3) {
                return HardCodeUtil.qqStr(R.string.f146680uu) + sb6;
            }
            return (time.month + 1) + "-" + time.monthDay + sb6;
        }
        return format;
    }

    private int Q0() {
        return R.layout.ept;
    }

    private void T0() {
        this.N.setVisibility(4);
        this.N.setAnimation("feed/feed_item/list_prefer_clicked_anim.json");
        this.N.setImageAssetsFolder("feed/feed_item/prefer_images/");
        au.f223851a.i(this.N, this.f224156d.getContext().getResources().getColor(R.color.qui_common_text_secondary_light));
        this.N.addAnimatorListener(new d());
    }

    private void U0() {
        this.f224155a0 = new GuildSwipeMenuItemHelper(this.W, new com.tencent.mobileqq.guild.widget.menu.b());
    }

    private void V0(View view) {
        LayoutInflater.from(getContext()).inflate(Q0(), (ViewGroup) this, true);
        f1(view);
    }

    private boolean X0(TextView textView) {
        int lineCount;
        if (textView.getLayout() == null || (lineCount = textView.getLayout().getLineCount()) <= 0 || textView.getLayout().getEllipsisCount(lineCount - 1) <= 0) {
            return false;
        }
        return true;
    }

    private Boolean Y0() {
        boolean z16;
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.V;
        if (guildFeedBaseInitBean != null && guildFeedBaseInitBean.getBusinessType() == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        int measuredWidth = this.C.getMeasuredWidth() + com.tencent.biz.qui.quicommon.e.a(8.0f);
        if (this.f224161m.getVisibility() == 0) {
            measuredWidth += this.f224161m.getMeasuredWidth() + com.tencent.biz.qui.quicommon.e.a(5.0f);
        }
        this.f224160i.setMaxWidth(this.f224159h.getMeasuredWidth() - measuredWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(String str, GProStNotice gProStNotice) {
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class, "")).getGuildInfo(str);
        if (guildInfo == null) {
            GuildMainFrameUtils.l(str, true, new a(gProStNotice, str));
        } else {
            h1(guildInfo, gProStNotice, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b1(GuildFeedDetailInitBean guildFeedDetailInitBean, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        guildFeedDetailInitBean.setBusinessType(guildFeedBaseInitBean.getBusinessType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(GProStNotice gProStNotice) {
        int i3;
        if (gProStNotice.isCloseInteract) {
            Drawable drawable = getResources().getDrawable(R.drawable.guild_remind_off_icon);
            int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
            if (!X0(this.E)) {
                i3 = (int) TypedValue.applyDimension(1, 8.0f, getResources().getDisplayMetrics());
            } else {
                i3 = 0;
            }
            drawable.setBounds(i3, 0, applyDimension + i3, applyDimension);
            this.E.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        this.E.setCompoundDrawables(null, null, null, null);
    }

    private void d1(String str) {
        int i3;
        String str2;
        if (TextUtils.isEmpty(str)) {
            final GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(this.U.origineFeed);
            initFeedDetailInitBeanFromFeed.setPosition(2);
            initFeedDetailInitBeanFromFeed.setFromPage(4);
            GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
            guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", "pg_sgrp_new_notification");
            initFeedDetailInitBeanFromFeed.setFeedReportSourceInfo(guildFeedReportSourceInfo);
            ax.J(this.V, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.widget.g
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    GuildFeedMessageItemView.b1(GuildFeedDetailInitBean.this, (GuildFeedBaseInitBean) obj);
                }
            });
            GuildFeedLauncher.w(getContext(), initFeedDetailInitBeanFromFeed);
            return;
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.V;
        if (guildFeedBaseInitBean != null) {
            i3 = guildFeedBaseInitBean.getBusinessType();
        } else {
            i3 = 0;
        }
        if (i3 == 7) {
            str2 = n1(str);
        } else {
            str2 = (str + ContainerUtils.FIELD_DELIMITER + "businessType" + ContainerUtils.KEY_VALUE_DELIMITER + i3) + ContainerUtils.FIELD_DELIMITER + com.tencent.mobileqq.guild.feed.b.f218140z + ContainerUtils.KEY_VALUE_DELIMITER + "pg_sgrp_new_notification";
            GuildFeedBaseInitBean guildFeedBaseInitBean2 = this.V;
            if (guildFeedBaseInitBean2 != null && guildFeedBaseInitBean2.getIsVisitor().booleanValue()) {
                str2 = str2 + "&joinGuildSig=" + Uri.encode(this.U.origineFeed.share.channelShareInfo.channelSign.joinGuildSig) + "&sourceId=message&subSourceId=visitor_interaction";
            }
        }
        GuildFeedLauncher.t(str2);
    }

    private void e1(ImageView imageView, String str) {
        String d16 = com.tencent.mobileqq.guild.picload.e.d(str);
        String str2 = (String) imageView.getTag(R.id.w9r);
        if (str != null && !TextUtils.isEmpty(d16) && !d16.equals(str2)) {
            imageView.setTag(R.id.w9r, d16);
            com.tencent.mobileqq.guild.picload.e.a().f(new Option().setTargetView(imageView).setRequestWidth(imageView.getWidth()).setRequestHeight(imageView.getHeight()).setUrl(str).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565), null);
        }
    }

    private void f1(View view) {
        this.W = (SwipeMenuLayout) view.findViewById(R.id.wcc);
        this.f224156d = view.findViewById(R.id.wbz);
        this.f224157e = (GuildUserAvatarView) view.findViewById(R.id.wby);
        this.f224158f = (QQProAvatarView) view.findViewById(R.id.wce);
        this.f224159h = view.findViewById(R.id.wc8);
        this.f224160i = (TextView) view.findViewById(R.id.wc9);
        this.f224161m = (TextView) view.findViewById(R.id.wcb);
        this.C = (TextView) view.findViewById(R.id.wcd);
        this.D = (TextView) view.findViewById(R.id.wc6);
        this.E = (TextView) view.findViewById(R.id.wc7);
        this.F = (FrameLayout) view.findViewById(R.id.f165502wc2);
        this.G = (RoundRectImageView) view.findViewById(R.id.w9r);
        this.H = (ImageView) view.findViewById(R.id.w9s);
        this.I = (ImageView) view.findViewById(R.id.f165503wc3);
        this.J = (ImageView) view.findViewById(R.id.wca);
        this.K = (LinearLayout) view.findViewById(R.id.f165504wc4);
        this.L = (LinearLayout) view.findViewById(R.id.wc_);
        this.N = (LottieAnimationView) view.findViewById(R.id.wcf);
        this.M = (ConstraintLayout) view.findViewById(R.id.f165500wc0);
        this.P = (RFWRoundImageView) view.findViewById(R.id.wic);
        this.Q = (TextView) view.findViewById(R.id.wrw);
        this.G.setCornerRadiusAndMode(getResources().getDimensionPixelSize(R.dimen.f158723nd), 1);
        this.f224156d.setOnClickListener(this);
        this.f224157e.setOnClickListener(this);
        this.f224158f.setOnClickListener(this);
        this.f224160i.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        T0();
        this.L.setBackgroundResource(R.drawable.guild_feed_notice_operation_bg);
        this.K.setBackgroundResource(R.drawable.guild_feed_notice_operation_bg);
        U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(IGProGuildInfo iGProGuildInfo, GProStNotice gProStNotice, String str) {
        if (iGProGuildInfo != null) {
            String avatarUrl = iGProGuildInfo.getAvatarUrl(140);
            QLog.d("GuildFeedMessageItemView", 1, "bindReportForExceptionData: " + avatarUrl);
            if (!TextUtils.isEmpty(avatarUrl)) {
                j1(str, avatarUrl, this.f224157e);
                return;
            }
        }
        QLog.e("GuildFeedMessageItemView", 1, "bindReportForExceptionData use robot face!");
        H0(gProStNotice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(IGProGuildInfo iGProGuildInfo) {
        this.M.setVisibility(0);
        this.P.setImageDrawable(ch.J(iGProGuildInfo.getAvatarUrl(40), com.tencent.biz.qui.quicommon.e.c(12.0f), BaseImageUtil.getDefaultFaceDrawable(false), false));
        this.Q.setText(iGProGuildInfo.getGuildName());
    }

    private void j1(final String str, final String str2, final GuildUserAvatarView guildUserAvatarView) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            N0(str2, guildUserAvatarView, str);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageItemView.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedMessageItemView.this.N0(str2, guildUserAvatarView, str);
                }
            });
        }
    }

    private void l1(final GProStNotice gProStNotice) {
        this.E.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedMessageItemView.this.c1(gProStNotice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i3) {
        if (i3 == 1) {
            ImageView imageView = this.I;
            imageView.setImageDrawable(GuildUIUtils.w(imageView.getContext(), R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
        } else if (i3 == 0) {
            ImageView imageView2 = this.I;
            imageView2.setImageDrawable(GuildUIUtils.w(imageView2.getContext(), R.drawable.guild_feed_item_up_vote_icon_token_selector, Integer.valueOf(R.color.qui_common_icon_primary)));
        }
    }

    private String n1(String str) {
        return str + ContainerUtils.FIELD_DELIMITER + "businessType" + ContainerUtils.KEY_VALUE_DELIMITER + this.V.getBusinessType() + ContainerUtils.FIELD_DELIMITER + "troopUin" + ContainerUtils.KEY_VALUE_DELIMITER + this.V.getTroopUin() + ContainerUtils.FIELD_DELIMITER + "troopRole" + ContainerUtils.KEY_VALUE_DELIMITER + this.V.getTroopRole();
    }

    private void z0() {
        this.f224159h.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedMessageItemView.this.Z0();
            }
        });
    }

    public void A0(com.tencent.mobileqq.guild.feed.part.notice.f fVar) {
        QLog.d("GuildFeedMessageItemView", 1, "vashzhong attachIoc! " + fVar);
        this.T = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void bindData(ij1.a aVar, int i3) {
        GProStNotice b16 = aVar.b();
        this.U = b16;
        if (b16 == null) {
            return;
        }
        D0(b16);
        C0(this.U, i3);
        O0();
    }

    void S0() {
        if (Y0().booleanValue()) {
            this.M.setVisibility(8);
            return;
        }
        String b16 = ui1.g.b(this.U);
        IGProGuildInfo L = ch.L(b16);
        if (L == null) {
            GuildMainFrameUtils.l(b16, false, new c(b16));
        } else {
            i1(L);
        }
    }

    public boolean W0() {
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.V;
        if (guildFeedBaseInitBean != null && guildFeedBaseInitBean.getBusinessType() == 19) {
            return true;
        }
        return false;
    }

    @SuppressLint({"SetTextI18n"})
    protected void g1(List<GProStRichTextContent> list) {
        if (list != null && !list.isEmpty()) {
            SpannableStringBuilder first = FeedRichTextContentParser.f221393a.q(list, null, IParseRichTextConfig.INSTANCE.b()).getFirst();
            this.D.setVisibility(0);
            this.D.setText(first);
            return;
        }
        this.D.setVisibility(8);
    }

    protected void k1(List<GProStRichTextContent> list) {
        if (list != null && !list.isEmpty()) {
            SpannableStringBuilder first = FeedRichTextContentParser.f221393a.q(list, null, IParseRichTextConfig.INSTANCE.c()).getFirst();
            this.E.setVisibility(0);
            this.E.setText(first, TextView.BufferType.SPANNABLE);
            return;
        }
        this.E.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IGProGuildInfo L;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && this.U != null && !((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view)) {
            int id5 = view.getId();
            if (id5 != R.id.wby && id5 != R.id.wce && id5 != R.id.wc9) {
                if (id5 == R.id.wbz) {
                    VideoReport.reportEvent("clck", view, null);
                    if (this.V.getIsVisitor().booleanValue()) {
                        this.V.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(ui1.g.a(this.U), this.U.origineFeed.share.channelShareInfo.channelSign.joinGuildSig, "message", "visitor_interaction"));
                        IGProGuildInfo L2 = ch.L(ui1.g.b(this.U));
                        if (L2 != null && !L2.isMember() && !((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getVisibleForVisitor(L2)) {
                            yl1.n.A(0, "\u52a0\u5165\u9891\u9053\u540e\u53ef\u67e5\u770b");
                        }
                    }
                    GProStNotice gProStNotice = this.U;
                    String str = gProStNotice.pattonInfo.plainTxt.operation.schema;
                    GProStFeed gProStFeed = gProStNotice.origineFeed;
                    IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class);
                    if (iGuildFeedNativeDetailApi.needOpenNativeDetailPage(gProStFeed)) {
                        Uri parse = Uri.parse(str);
                        Intent intent = new Intent();
                        String queryParameter = parse.getQueryParameter("comment_id");
                        String queryParameter2 = parse.getQueryParameter("reply_id");
                        if (!TextUtils.isEmpty(queryParameter) || !TextUtils.isEmpty(queryParameter2)) {
                            intent.putExtra("comment_id", parse.getQueryParameter("comment_id"));
                            intent.putExtra("reply_id", parse.getQueryParameter("reply_id"));
                            intent.putExtra("start_intent_interact_action", 2);
                        }
                        iGuildFeedNativeDetailApi.openFeedNativeDetailPage(getContext(), gProStFeed, this.V, intent);
                    } else {
                        d1(str);
                    }
                } else if (id5 == R.id.f165504wc4) {
                    K0(view);
                } else if (id5 == R.id.wc_) {
                    M0(view);
                }
            } else {
                GProStNotice gProStNotice2 = this.U;
                GProStUser gProStUser = gProStNotice2.psvFeed.poster;
                if (gProStUser != null && !ui1.g.e(gProStNotice2)) {
                    if (this.V.getBusinessType() == 7) {
                        long j3 = this.U.psvFeed.groupCode;
                        long j16 = gProStUser.uin;
                        QLog.d("GuildFeedMessageItemView", 1, "\u8c03\u8d77\u7fa4\u5e16\u5b50\u6210\u5458\u8d44\u6599\u5361 groupId = " + j3 + ", uin = " + j16);
                        ax.M(String.valueOf(j3), String.valueOf(j16));
                    } else if (this.V.getIsVisitor().booleanValue() && (L = ch.L(ui1.g.b(this.U))) != null && !L.isMember() && !((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getVisibleForVisitor(L)) {
                        yl1.n.A(0, "\u52a0\u5165\u9891\u9053\u540e\u53ef\u67e5\u770b");
                    } else {
                        String b16 = ui1.g.b(this.U);
                        String a16 = ui1.g.a(this.U);
                        QLog.d("GuildFeedMessageItemView", 1, "\u8c03\u8d77\u9891\u9053\u5e16\u5b50\u8d44\u6599\u5361 guildId:" + b16 + ", feedId:" + String.valueOf(this.U.psvFeed.idd) + ", channelId:" + a16);
                        GuildProfileData guildProfileData = new GuildProfileData(b16, "", gProStUser.idd, 0, 7);
                        guildProfileData.getGuildBaseProfileData().r(a16);
                        guildProfileData.setFeedImpeachData(new FeedImpeachData(3, "", "", ""));
                        GuildProfileCard.Lh((Activity) getContext(), guildProfileData);
                        HashMap hashMap = new HashMap();
                        hashMap.put("sgrp_touin", gProStUser.idd);
                        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_forum_avatar", "clck", hashMap);
                    }
                } else {
                    com.tencent.mobileqq.guild.util.qqui.g.f(-1, "\u6682\u4e0d\u652f\u6301\u67e5\u770b");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setDataWithPayload(ij1.a aVar, int i3, zm1.a aVar2) {
        setDataPosInList(i3);
        GProStNotice b16 = aVar.b();
        this.U = b16;
        if (aVar2 instanceof a.C11698a) {
            C0(b16, i3);
            l1(this.U);
        }
    }

    public void y0(GuildSwipeMenuItemHelper.b bVar) {
        this.f224155a0.g(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GuildFeedMessageItemView.this.N.setVisibility(4);
            GuildFeedMessageItemView.this.I.setVisibility(0);
            GuildFeedMessageItemView.this.R = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
