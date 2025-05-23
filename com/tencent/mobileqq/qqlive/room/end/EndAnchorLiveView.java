package com.tencent.mobileqq.qqlive.room.end;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cj4.c;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class EndAnchorLiveView implements View.OnClickListener, IQQLiveEndView {
    static IPatchRedirector $redirector_;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private View L;
    private Drawable M;
    private FrameLayout N;
    private View P;
    private TextView Q;
    private TextView R;
    private Map<String, String> S;
    private TextView T;

    /* renamed from: d, reason: collision with root package name */
    private Context f271531d;

    /* renamed from: e, reason: collision with root package name */
    private EndLiveClickCallback f271532e;

    /* renamed from: f, reason: collision with root package name */
    private View f271533f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f271534h;

    /* renamed from: i, reason: collision with root package name */
    private RoundRelativeLayout f271535i;

    /* renamed from: m, reason: collision with root package name */
    private URLImageView f271536m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class EndLiveTransactionDataCallback implements Function4<Long, Long, Long, String, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<EndAnchorLiveView> f271537d;

        public EndLiveTransactionDataCallback(EndAnchorLiveView endAnchorLiveView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) endAnchorLiveView);
            } else {
                this.f271537d = new WeakReference<>(endAnchorLiveView);
            }
        }

        @Override // kotlin.jvm.functions.Function4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Long l3, Long l16, Long l17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, this, l3, l16, l17, str);
            }
            ThreadManager.getUIHandler().post(new Runnable(l3, l16, l17, str) { // from class: com.tencent.mobileqq.qqlive.room.end.EndAnchorLiveView.EndLiveTransactionDataCallback.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Long f271538d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Long f271539e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Long f271540f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f271541h;

                {
                    this.f271538d = l3;
                    this.f271539e = l16;
                    this.f271540f = l17;
                    this.f271541h = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EndLiveTransactionDataCallback.this, l3, l16, l17, str);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    EndAnchorLiveView endAnchorLiveView = (EndAnchorLiveView) EndLiveTransactionDataCallback.this.f271537d.get();
                    if (endAnchorLiveView != null) {
                        endAnchorLiveView.S.put("qqlive_order_uv", String.valueOf(this.f271538d));
                        endAnchorLiveView.S.put("qqlive_order_money", String.valueOf(this.f271539e));
                        endAnchorLiveView.j(this.f271540f, this.f271541h);
                        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("ev_qqlive_liveend_data", endAnchorLiveView, endAnchorLiveView.S);
                    }
                }
            });
            return null;
        }
    }

    public EndAnchorLiveView(Context context, QQLiveEndPageInfo qQLiveEndPageInfo, EndLiveClickCallback endLiveClickCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQLiveEndPageInfo, endLiveClickCallback);
            return;
        }
        this.S = new HashMap();
        this.f271531d = context;
        this.f271532e = endLiveClickCallback;
        this.f271533f = LayoutInflater.from(context).inflate(R.layout.h_h, (ViewGroup) null);
        e(context);
        d(qQLiveEndPageInfo);
        i(qQLiveEndPageInfo);
        h();
    }

    private SpannableStringBuilder c() {
        Drawable drawable = this.f271531d.getResources().getDrawable(R.drawable.qvideo_skin_icon_general_warning_primary_baoxiang);
        drawable.setBounds(0, 0, ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(10.0f));
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f271531d.getString(R.string.f210515ib));
        spannableStringBuilder.setSpan(imageSpan, 0, 1, 17);
        return spannableStringBuilder;
    }

    private void d(QQLiveEndPageInfo qQLiveEndPageInfo) {
        if (qQLiveEndPageInfo != null) {
            g(qQLiveEndPageInfo);
            this.S.put("qqlive_user_id", String.valueOf(qQLiveEndPageInfo.uid));
            this.S.put("qqlive_anchor_id", String.valueOf(qQLiveEndPageInfo.anchorUid));
            this.S.put("qqlive_room_id", String.valueOf(qQLiveEndPageInfo.roomId));
            this.S.put("qqlive_program_id", String.valueOf(qQLiveEndPageInfo.programId));
            this.S.put("qqlive_zhibo_type", String.valueOf(qQLiveEndPageInfo.liveType));
            this.S.put("qqlive_zhibo_content", "2");
            this.S.put("qqlive_gift_money", String.valueOf(qQLiveEndPageInfo.giftValue));
            this.S.put("qqlive_add_fans_uv", String.valueOf(qQLiveEndPageInfo.newFans));
            this.S.put("qqlive_watch_uv", String.valueOf(qQLiveEndPageInfo.popularity));
            this.S.put("qqlive_comment_uv", String.valueOf(qQLiveEndPageInfo.commentNum));
            this.S.put("qqlive_gift_uv", String.valueOf(qQLiveEndPageInfo.sendGiftPopularity));
            this.S.put("qqlive_dianzan_uv", String.valueOf(qQLiveEndPageInfo.praiseNum));
        }
        c.f31003a.e(new EndLiveTransactionDataCallback(this));
    }

    private void e(Context context) {
        this.f271533f.findViewById(R.id.ylk).setPadding(0, ViewUtils.getStatusBarHeight(context), 0, 0);
        this.f271534h = (ImageView) this.f271533f.findViewById(R.id.f166077yl3);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f271533f.findViewById(R.id.ylc);
        this.f271535i = roundRelativeLayout;
        roundRelativeLayout.f316197h = 15;
        this.f271535i.f316195e = ViewUtils.dpToPx(ViewUtils.dip2px(96.0f) / 2);
        this.f271536m = (URLImageView) this.f271533f.findViewById(R.id.ylb);
        this.C = (TextView) this.f271533f.findViewById(R.id.yld);
        this.D = (TextView) this.f271533f.findViewById(R.id.yl6);
        this.E = (TextView) this.f271533f.findViewById(R.id.yl9);
        this.K = (TextView) this.f271533f.findViewById(R.id.yla);
        this.F = (TextView) this.f271533f.findViewById(R.id.yl7);
        this.G = (TextView) this.f271533f.findViewById(R.id.yle);
        this.H = (TextView) this.f271533f.findViewById(R.id.f166078yl4);
        this.I = (TextView) this.f271533f.findViewById(R.id.yl8);
        this.J = (TextView) this.f271533f.findViewById(R.id.ylf);
        this.L = this.f271533f.findViewById(R.id.yl5);
        this.M = context.getResources().getDrawable(R.drawable.nmi);
        this.f271534h.setOnClickListener(this);
        TextView textView = (TextView) this.f271533f.findViewById(R.id.uv_);
        this.T = textView;
        textView.setText(c());
    }

    private void f(URLImageView uRLImageView, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = this.M;
                int dip2px = ViewUtils.dip2px(i3);
                URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                drawable.setTag(new int[]{dip2px, dip2px});
                uRLImageView.setImageDrawable(drawable);
            } catch (Exception e16) {
                QLog.e("EndAnchorLiveView", 1, "loadRoundImg + " + e16);
            }
        }
    }

    private void g(QQLiveEndPageInfo qQLiveEndPageInfo) {
        setHeadIcon(qQLiveEndPageInfo.headIcon);
        setNick(qQLiveEndPageInfo.nick);
        setLiveTime(qQLiveEndPageInfo.time);
        setGiftValue(qQLiveEndPageInfo.giftValue);
        setNewFans(qQLiveEndPageInfo.newFans);
        setPopularity(qQLiveEndPageInfo.popularity);
        setCommentNum(qQLiveEndPageInfo.commentNum);
        setGiftPopularity(qQLiveEndPageInfo.sendGiftPopularity);
        setPraiseNum(qQLiveEndPageInfo.praiseNum);
    }

    private void h() {
        View findViewById = this.f271533f.findViewById(R.id.yld);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(findViewById, false, null, "em_qqlive_anchor_inf", new HashMap());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", findViewById, new HashMap());
        View findViewById2 = this.f271533f.findViewById(R.id.yl5);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(findViewById2, false, null, "em_qqlive_datamodule", new HashMap());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", findViewById2, new HashMap());
    }

    private void i(QQLiveEndPageInfo qQLiveEndPageInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_zhibo_type", String.valueOf(qQLiveEndPageInfo.liveType));
        hashMap.put("qqlive_zhibo_content", qQLiveEndPageInfo.liveContent);
        hashMap.put("qqlive_anchor_id", String.valueOf(qQLiveEndPageInfo.anchorUid));
        hashMap.put("qqlive_room_id", String.valueOf(qQLiveEndPageInfo.roomId));
        hashMap.put("qqlive_user_id", String.valueOf(qQLiveEndPageInfo.uid));
        hashMap.put("qqlive_program_id", qQLiveEndPageInfo.programId);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().b(this.f271533f, "pg_qqlive_liveend_anchor", hashMap);
        hashMap.put("pgid", "pg_qqlive_liveend_anchor");
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("pgin", this.f271533f, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Long l3, String str) {
        this.N = (FrameLayout) this.f271533f.findViewById(R.id.yll);
        this.P = this.f271533f.findViewById(R.id.f166076yl2);
        this.R = (TextView) this.f271533f.findViewById(R.id.ylg);
        this.Q = (TextView) this.f271533f.findViewById(R.id.ylh);
        FrameLayout frameLayout = this.N;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.R.setText(str);
            this.Q.setText(String.valueOf(l3));
            this.P.setOnClickListener(this);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.N, false, null, "em_qqlive_goods_data", this.S);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.P, false, null, "em_qqlive_goods_center_button", this.S);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", this.N, this.S);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", this.P, this.S);
        }
    }

    private String k(long j3) {
        long j16 = j3 / 3600;
        String str = "";
        if (j16 > 0) {
            str = "" + j16 + "\u5c0f\u65f6";
        }
        long j17 = j3 % 3600;
        long j18 = j17 % 60;
        long j19 = j17 / 60;
        if (j19 > 0) {
            str = str + j19 + "\u5206\u949f";
        } else if (j18 > 0) {
            str = str + j18 + "\u79d2";
        }
        return "\u65f6\u957f: " + str;
    }

    private String l(Long l3) {
        if (l3.longValue() >= 10000) {
            return new DecimalFormat("#.00").format(l3.longValue() / 10000.0d) + "\u4e07";
        }
        return Long.toString(l3.longValue());
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f271533f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f166077yl3) {
                EndLiveClickCallback endLiveClickCallback = this.f271532e;
                if (endLiveClickCallback != null) {
                    endLiveClickCallback.onCloseClick(this.f271533f);
                }
            } else if (id5 == R.id.f166076yl2) {
                c.f31003a.h();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) configuration);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void onPageOut(long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setCommentNum(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        TextView textView = this.H;
        if (textView != null && j3 > 0) {
            textView.setText(l(Long.valueOf(j3)));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setFollow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setFollowVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setGiftPopularity(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
            return;
        }
        TextView textView = this.I;
        if (textView != null && j3 > 0) {
            textView.setText(l(Long.valueOf(j3)));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setGiftValue(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        TextView textView = this.E;
        if (textView != null && j3 > 0) {
            textView.setText(l(Long.valueOf(j3)));
            this.K.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setHeadIcon(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("EndAnchorLiveView", 1, "iconUrl is empty");
            return;
        }
        QLog.d("EndAnchorLiveView", 1, "upload success iconUrl is " + str);
        f(this.f271536m, 96, str);
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setLeftRecommend(QQLiveEndRecommendInfo qQLiveEndRecommendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qQLiveEndRecommendInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setLiveTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        TextView textView = this.D;
        if (textView != null && j3 > 0) {
            textView.setText(k(j3));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setNewFans(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
            return;
        }
        TextView textView = this.F;
        if (textView != null && j3 > 0) {
            textView.setText(l(Long.valueOf(j3)));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setNick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (str != null && !TextUtils.isEmpty(str)) {
            this.C.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setPopularity(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (this.G != null && !TextUtils.isEmpty(str)) {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                this.G.setText(l(Long.valueOf(parseLong)));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setPraiseNum(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
            return;
        }
        TextView textView = this.J;
        if (textView != null && j3 > 0) {
            textView.setText(l(Long.valueOf(j3)));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setRecommendList(List<QQLiveEndRecommendInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView
    public void setRightRecommend(QQLiveEndRecommendInfo qQLiveEndRecommendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) qQLiveEndRecommendInfo);
        }
    }
}
