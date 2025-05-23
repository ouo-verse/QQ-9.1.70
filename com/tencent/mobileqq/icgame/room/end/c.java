package com.tencent.mobileqq.icgame.room.end;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.end.IQQLiveEndView;
import com.tencent.mobileqq.icgame.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.icgame.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements View.OnClickListener, IQQLiveEndView {
    private View C;
    private RoundRelativeLayout D;
    private QQLiveEndPageInfo E = new QQLiveEndPageInfo();
    private Context F;
    private IQQLiveSDK G;
    private s22.a H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private QQLiveEndPageInfo L;

    /* renamed from: d, reason: collision with root package name */
    private View f237543d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f237544e;

    /* renamed from: f, reason: collision with root package name */
    private URLImageView f237545f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f237546h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f237547i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f237548m;

    public c(Context context, IQQLiveSDK iQQLiveSDK, QQLiveEndPageInfo qQLiveEndPageInfo, au0.c cVar, s22.a aVar) {
        this.F = context;
        this.G = iQQLiveSDK;
        this.L = qQLiveEndPageInfo;
        this.H = aVar;
        this.f237543d = LayoutInflater.from(context).inflate(R.layout.fao, (ViewGroup) null);
        e(context);
        d(qQLiveEndPageInfo);
        i(qQLiveEndPageInfo);
        h(qQLiveEndPageInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean b16 = com.tencent.icgame.game.liveroom.impl.room.util.b.b(this.f237543d.getContext(), this.f237543d.getWidth(), this.f237543d.getHeight());
        int i3 = this.F.getResources().getDisplayMetrics().widthPixels;
        int dpToPx = ViewUtils.dpToPx(580.0f);
        rt0.a.e("ICGameAudience|ICGameEndAudienceLiveView", "isFolderScreenOpen: " + b16 + " windowWidth: " + i3 + " expectWidth: " + dpToPx);
        View findViewById = this.f237543d.findViewById(R.id.iew);
        if (b16 && i3 > dpToPx) {
            int i16 = (i3 - dpToPx) / 2;
            ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).setMargins(i16, 0, i16, 0);
        } else {
            ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).setMargins(0, 0, 0, 0);
            dpToPx = this.f237543d.getWidth();
        }
        findViewById.requestLayout();
        e.a(dpToPx);
    }

    private void d(QQLiveEndPageInfo qQLiveEndPageInfo) {
        if (qQLiveEndPageInfo != null) {
            QQLiveEndPageInfo qQLiveEndPageInfo2 = this.E;
            qQLiveEndPageInfo2.uid = qQLiveEndPageInfo.uid;
            qQLiveEndPageInfo2.anchorUid = qQLiveEndPageInfo.anchorUid;
            qQLiveEndPageInfo2.headIcon = qQLiveEndPageInfo.headIcon;
            qQLiveEndPageInfo2.nick = qQLiveEndPageInfo.nick;
            qQLiveEndPageInfo2.time = qQLiveEndPageInfo.time;
            qQLiveEndPageInfo2.popularity = qQLiveEndPageInfo.popularity;
            qQLiveEndPageInfo2.follow = qQLiveEndPageInfo.follow;
            qQLiveEndPageInfo2.recommendInfos = qQLiveEndPageInfo.recommendInfos;
            g(qQLiveEndPageInfo2);
        }
    }

    private void e(Context context) {
        rt0.a.e("ICGameAudience|ICGameEndAudienceLiveView", "initView");
        this.f237545f = (URLImageView) this.f237543d.findViewById(R.id.f60552vq);
        this.D = (RoundRelativeLayout) this.f237543d.findViewById(R.id.f60562vr);
        this.f237546h = (TextView) this.f237543d.findViewById(R.id.f60572vs);
        this.f237547i = (TextView) this.f237543d.findViewById(R.id.f60582vt);
        this.f237548m = (TextView) this.f237543d.findViewById(R.id.f60542vp);
        this.f237544e = (ImageView) this.f237543d.findViewById(R.id.f60522vn);
        this.C = this.f237543d.findViewById(R.id.f60712w6);
        this.f237543d.findViewById(R.id.f60622vx).setPadding(0, ViewUtils.getStatusBarHeight(context), 0, 0);
        this.D.f316197h = 15;
        this.D.f316195e = ViewUtils.dpToPx(ViewUtils.dip2px(65.0f) / 2);
        this.K = context.getResources().getDrawable(R.drawable.nmi);
        this.I = context.getResources().getDrawable(R.drawable.l2i);
        this.J = context.getResources().getDrawable(R.drawable.l2h);
        this.f237544e.setOnClickListener(this);
        this.C.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(QQLiveEndPageInfo qQLiveEndPageInfo) {
        setRecommendList(qQLiveEndPageInfo.recommendInfos);
    }

    private void g(final QQLiveEndPageInfo qQLiveEndPageInfo) {
        rt0.a.f("ICGameAudience|ICGameEndAudienceLiveView", "refresh", "refresh");
        if (qQLiveEndPageInfo.uid == qQLiveEndPageInfo.anchorUid) {
            setFollowVisible(false);
        } else {
            setFollowVisible(true);
        }
        setHeadIcon(qQLiveEndPageInfo.headIcon);
        setNick(qQLiveEndPageInfo.nick);
        setPopularity(qQLiveEndPageInfo.popularity);
        setLiveTime(qQLiveEndPageInfo.time);
        setNick(qQLiveEndPageInfo.nick);
        setFollow(qQLiveEndPageInfo.follow);
        ArrayList<QQLiveEndRecommendInfo> arrayList = qQLiveEndPageInfo.recommendInfos;
        if (arrayList != null && arrayList.size() > 0) {
            this.f237543d.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.end.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.f(qQLiveEndPageInfo);
                }
            });
        }
    }

    private void h(QQLiveEndPageInfo qQLiveEndPageInfo) {
        View findViewById = this.f237543d.findViewById(R.id.f60532vo);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(findViewById, false, null, "em_icgame_anchor_inf", new HashMap());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", findViewById, new HashMap());
        View findViewById2 = this.f237543d.findViewById(R.id.f60602vv);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(findViewById2, false, null, "em_icgame_datamodule", new HashMap());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", findViewById2, new HashMap());
        HashMap hashMap = new HashMap();
        if (qQLiveEndPageInfo.follow == 1) {
            hashMap.put("icgame_follow_status", String.valueOf(1));
        } else {
            hashMap.put("icgame_follow_status", String.valueOf(0));
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.C, false, null, "em_icgame_follow", hashMap);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", this.C, hashMap);
    }

    private void i(QQLiveEndPageInfo qQLiveEndPageInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("icgame_user_id", String.valueOf(qQLiveEndPageInfo.uid));
        hashMap.put("icgame_anchor_id", String.valueOf(qQLiveEndPageInfo.anchorUid));
        hashMap.put("icgame_room_id", String.valueOf(qQLiveEndPageInfo.roomId));
        hashMap.put("icgame_program_id", qQLiveEndPageInfo.programId);
        hashMap.put("icgame_zhibo_type", String.valueOf(qQLiveEndPageInfo.liveType));
        hashMap.put("icgame_zhibo_content", qQLiveEndPageInfo.liveContent);
        hashMap.put("icgame_start_source", qQLiveEndPageInfo.liveSource);
        hashMap.put("icgame_abtestid", "-1");
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().b(this.f237543d, "pg_icgame_liveend_audience", hashMap);
        hashMap.put("pgid", "pg_icgame_liveend_audience");
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("pgin", this.f237543d, hashMap);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public View getView() {
        return this.f237543d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s22.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f60522vn) {
            s22.a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.onCloseClick(this.f237543d);
            }
        } else if (id5 == R.id.f60712w6) {
            s22.a aVar3 = this.H;
            if (aVar3 != null) {
                aVar3.onFollowClick(this.f237543d);
            }
        } else if (id5 == R.id.f60552vq) {
            s22.a aVar4 = this.H;
            if (aVar4 != null) {
                aVar4.onHeadIconClick(this.f237543d);
            }
        } else if (id5 == R.id.f60572vs) {
            s22.a aVar5 = this.H;
            if (aVar5 != null) {
                aVar5.onNickClick(this.f237543d);
            }
        } else if (id5 == R.id.f60582vt && (aVar = this.H) != null) {
            aVar.onPopularityClick(this.f237543d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void onConfigurationChanged() {
        rt0.a.e("ICGameAudience|ICGameEndAudienceLiveView", "onConfigurationChanged");
        this.f237543d.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.end.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.c();
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void onPageOut(long j3, boolean z16, boolean z17) {
        rt0.a.e("ICGameAudience|ICGameEndAudienceLiveView", "onPageOut");
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void onResume() {
        rt0.a.e("ICGameAudience|ICGameEndAudienceLiveView", "onResume");
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void onStop() {
        rt0.a.e("ICGameAudience|ICGameEndAudienceLiveView", DKHippyEvent.EVENT_STOP);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setFollow(int i3) {
        HashMap hashMap = new HashMap();
        if (i3 == 1) {
            this.f237548m.setText("\u5df2\u6536\u85cf");
            Drawable drawable = this.I;
            if (drawable != null) {
                this.C.setBackgroundDrawable(drawable);
            }
            hashMap.put("icgame_follow_status", String.valueOf(1));
        } else if (i3 == 2) {
            this.f237548m.setText("\u6536\u85cf");
            Drawable drawable2 = this.J;
            if (drawable2 != null) {
                this.C.setBackgroundDrawable(drawable2);
            }
            hashMap.put("icgame_follow_status", String.valueOf(0));
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("clck", this.C, hashMap);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setFollowVisible(boolean z16) {
        if (z16) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setHeadIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            rt0.a.c("ICGameAudience|ICGameEndAudienceLiveView", "setHeadIcon", "iconUrl is empty");
            return;
        }
        rt0.a.b("ICGameAudience|ICGameEndAudienceLiveView", "setHeadIcon", "upload success iconUrl is " + str);
        e42.a.a(this.f237545f, this.K, 65, str);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setNick(String str) {
        this.f237546h.setText(str);
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setPopularity(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 10000 && this.F != null) {
                str = String.format(Locale.CHINA, "%.1f", Float.valueOf(((float) parseLong) / 10000.0f)) + this.F.getResources().getString(R.string.f181633ea);
            }
            this.f237547i.setText(str);
        } catch (Exception e16) {
            rt0.a.c("ICGameRoom_info", "setEndAudiencePopularity", e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setCommentNum(long j3) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setGiftPopularity(long j3) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setGiftValue(long j3) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setLeftRecommend(QQLiveEndRecommendInfo qQLiveEndRecommendInfo) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setLiveTime(long j3) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setNewFans(long j3) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setPraiseNum(long j3) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setRecommendList(List<QQLiveEndRecommendInfo> list) {
    }

    @Override // com.tencent.mobileqq.icgame.api.end.IQQLiveEndView
    public void setRightRecommend(QQLiveEndRecommendInfo qQLiveEndRecommendInfo) {
    }
}
