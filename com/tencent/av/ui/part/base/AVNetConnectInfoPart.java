package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.ui.m;
import com.tencent.av.utils.ae;
import com.tencent.av.utils.ba;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes32.dex */
public class AVNetConnectInfoPart extends nw.a implements mw.f {
    private WeakReference<Context> F;
    private WeakReference<VideoAppInterface> G;

    /* renamed from: e, reason: collision with root package name */
    String f76214e = null;

    /* renamed from: f, reason: collision with root package name */
    Map<String, String> f76215f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    boolean f76216h = false;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f76217i = null;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f76218m = null;
    protected RelativeLayout C = null;
    protected RelativeLayout D = null;
    protected View E = null;
    protected VideoNetStateBar H = null;
    private TextView I = null;
    private TextView J = null;
    Runnable K = new Runnable() { // from class: com.tencent.av.ui.part.base.AVNetConnectInfoPart.1
        @Override // java.lang.Runnable
        public void run() {
            AVNetConnectInfoPart aVNetConnectInfoPart = AVNetConnectInfoPart.this;
            if (aVNetConnectInfoPart.f76217i != null && aVNetConnectInfoPart.F != null) {
                AVNetConnectInfoPart.this.f76217i.setMaxWidth(((Context) AVNetConnectInfoPart.this.F.get()).getResources().getDimensionPixelSize(R.dimen.b2b));
            } else if (QLog.isColorLevel()) {
                QLog.e(((nw.a) AVNetConnectInfoPart.this).f421444d, 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
            }
        }
    };

    private void P9(int i3) {
        if (this.f76218m != null) {
            if (QLog.isDevelopLevel() || this.f76218m.getVisibility() != i3) {
                QLog.w(this.f421444d, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.f76218m.getVisibility() + "->" + i3 + "]");
            }
            this.f76218m.setVisibility(i3);
        }
    }

    public VideoNetStateBar G9() {
        return this.H;
    }

    public void H9() {
        this.f76217i.post(this.K);
        P9(8);
    }

    public void I9(long j3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("AVNetConnectInfoPart", 1, "setConnectInfo str=" + str, new Throwable());
        }
        TextView textView = this.f76217i;
        if (textView != null) {
            textView.setText(str);
            ba.setAccText(this.f76217i, str);
        }
        TextView textView2 = this.f76218m;
        if (textView2 != null) {
            textView2.setText(str);
        }
        VideoNetStateBar videoNetStateBar = this.H;
        if (videoNetStateBar != null) {
            videoNetStateBar.j(str);
        }
    }

    public void J9(boolean z16, int i3, long j3) {
        String format;
        Resources resources = getContext().getResources();
        SessionInfo f16 = n.e().f();
        String nameMaxMaseaured = ba.getNameMaxMaseaured(getContext(), r.h0().U(String.valueOf(j3), String.valueOf(f16.P0), f16.S0), this.f76217i, resources.getDimensionPixelSize(R.dimen.f158932sr));
        if (i3 == 1) {
            format = resources.getString(R.string.dbg);
        } else {
            format = String.format(resources.getString(R.string.dbf), Integer.valueOf(i3));
        }
        M9(z16, 1, 0, null, resources.getString(R.string.dbe) + nameMaxMaseaured + format);
    }

    public void K9(int i3) {
        if (r.h0() == null) {
            return;
        }
        if ((n.e().f().f73067q != 1011 || i3 == R.string.d_a || i3 == R.string.icq) && i3 > 0) {
            c2(-1016L, i3);
        }
    }

    public void L9(boolean z16, int i3, int i16, String str) {
        M9(z16, i3, i16, str, this.f76214e);
    }

    public void M9(boolean z16, int i3, int i16, String str, String str2) {
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d("AVNetConnectInfoPart", 2, "setMembersInOrOutWording --> Type = " + i3 + " , Id = " + i16 + " , Uin = " + str + " , value = " + str2);
        }
        Resources resources = getContext().getResources();
        VideoAppInterface b16 = nw.b.b();
        if (i3 == 0) {
            if (str == null) {
                str2 = resources.getString(i16);
            } else {
                if (z16) {
                    SessionInfo f16 = n.e().f();
                    if (QAVHrMeeting.k(b16.F(String.valueOf(f16.P0)))) {
                        Q9(i3, i16, str, str2);
                        return;
                    }
                    str3 = r.h0().U(str, String.valueOf(f16.P0), f16.S0);
                } else {
                    AVPhoneUserInfo k3 = n.e().f().k(Long.valueOf(str).longValue());
                    if (k3 == null) {
                        str3 = resources.getString(R.string.box);
                    } else {
                        String str4 = k3.telInfo.mobile;
                        if (str4 == null) {
                            str3 = resources.getString(R.string.box);
                        } else {
                            String P = VideoAppInterface.N().P(str4);
                            if (P == null) {
                                str3 = ae.g(str4, 4);
                                if (str3 == null) {
                                    str3 = resources.getString(R.string.box);
                                }
                            } else {
                                str3 = P;
                            }
                        }
                    }
                }
                str2 = ba.getNameMaxMaseaured(getContext(), str3, this.f76217i, resources.getDimensionPixelSize(R.dimen.f158932sr)) + resources.getString(i16);
            }
        } else if (i3 != 1) {
            str2 = null;
        }
        cw.e.p(b16, 3011, str2);
    }

    public void N9(int i3) {
        if (r.h0() == null) {
            return;
        }
        K9(F9(n.e().f(), i3));
    }

    public void O9(int i3) {
        if (this.f76217i != null) {
            if (QLog.isDevelopLevel() || this.f76217i.getVisibility() != i3) {
                QLog.w(this.f421444d, 1, "setVisibility_ConnectInfoView_MiddleCenter, visibility[" + this.f76217i.getVisibility() + "->" + i3 + "]");
            }
            this.f76217i.setVisibility(i3);
        }
    }

    void Q9(int i3, final int i16, final String str, String str2) {
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.AVNetConnectInfoPart.2
            @Override // java.lang.Runnable
            public void run() {
                String U;
                if (AVNetConnectInfoPart.this.f76216h) {
                    return;
                }
                SessionInfo f16 = n.e().f();
                if (i16 == R.string.dc6) {
                    U = AVNetConnectInfoPart.this.f76215f.containsKey(str) ? AVNetConnectInfoPart.this.f76215f.get(str) : null;
                    if (TextUtils.isEmpty(U) || TextUtils.equals(U, "QQ")) {
                        U = r.h0().U(str, String.valueOf(f16.P0), f16.S0);
                    }
                } else {
                    U = r.h0().U(str, String.valueOf(f16.P0), f16.S0);
                    if ((TextUtils.isEmpty(U) || TextUtils.equals(U, "QQ")) && AVNetConnectInfoPart.this.f76215f.containsKey(str)) {
                        U = AVNetConnectInfoPart.this.f76215f.get(str);
                    }
                }
                Resources resources = AVNetConnectInfoPart.this.getContext().getResources();
                String str3 = ba.getNameMaxMaseaured(AVNetConnectInfoPart.this.getContext(), U, AVNetConnectInfoPart.this.f76217i, resources.getDimensionPixelSize(R.dimen.f158932sr)) + resources.getString(i16);
                cw.e.p(nw.b.b(), 3011, str3);
                QLog.e("AVNetConnectInfoPart", 1, "showHrMeetingInOrOutWordingWithDelay str=" + str3);
            }
        }, 1000L);
    }

    public void R9(String str, String[] strArr) {
        String format;
        String nameMaxMaseaured;
        int length = strArr.length;
        if (length < 1) {
            return;
        }
        String str2 = strArr[0];
        SessionInfo f16 = n.e().f();
        String U = r.h0().U(str2, String.valueOf(f16.P0), f16.S0);
        Resources resources = getContext().getResources();
        float dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158932sr);
        if (length == 1) {
            format = resources.getString(R.string.dbg);
        } else {
            format = String.format(resources.getString(R.string.dbf), Integer.valueOf(length));
        }
        if (!str.equals(nw.b.b().getCurrentAccountUin())) {
            String U2 = r.h0().U(str, String.valueOf(f16.P0), f16.S0);
            float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.f158934st);
            nameMaxMaseaured = ba.getNameMaxMaseaured(getContext(), U, this.f76217i, dimensionPixelSize2);
            this.f76214e = ba.getNameMaxMaseaured(getContext(), U2, this.f76217i, dimensionPixelSize2) + resources.getString(R.string.dbd) + nameMaxMaseaured + format;
        } else {
            nameMaxMaseaured = ba.getNameMaxMaseaured(getContext(), U, this.f76217i, dimensionPixelSize);
            this.f76214e = resources.getString(R.string.dbe) + nameMaxMaseaured + format;
        }
        QLog.w("AVNetConnectInfoPart", 1, "onOtherMemberInvited, inviterUin[" + str + "], invitedName[" + nameMaxMaseaured + "]");
    }

    public void S9(final String str, final String[] strArr) {
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.AVNetConnectInfoPart.3
            @Override // java.lang.Runnable
            public void run() {
                AVNetConnectInfoPart.this.R9(str, strArr);
            }
        }, 1000L);
    }

    public void T9(boolean z16) {
        E9(z16);
        O9(z16 ? 8 : 0);
    }

    public void U9(boolean z16) {
        int f16;
        if (this.E == null) {
            return;
        }
        boolean z17 = n.e().f().f73045k1.size() <= 1;
        boolean z18 = n.e().f().O1 == 4;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        if (z16 && (z17 || z18)) {
            f16 = BaseAIOUtils.f(43.0f, this.E.getResources());
        } else {
            f16 = BaseAIOUtils.f(20.0f, this.E.getResources());
        }
        if (f16 != layoutParams.topMargin) {
            layoutParams.topMargin = f16;
            this.E.setLayoutParams(layoutParams);
        }
    }

    @Override // mw.f
    public void c2(long j3, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("AVNetConnectInfoPart", 1, "setConnectInfo id=" + i3, new Throwable());
        }
        if (i3 > 0 && x9(this.F) != null) {
            I9(j3, x9(this.F).getResources().getString(i3));
        } else {
            I9(j3, null);
        }
    }

    @Override // mw.f
    public TextPaint j() {
        return this.f76217i.getPaint();
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        this.D = null;
        this.E = null;
        this.f76217i = null;
        this.f76218m = null;
        this.C = null;
        VideoNetStateBar videoNetStateBar = this.H;
        if (videoNetStateBar != null) {
            videoNetStateBar.f();
            this.H = null;
        }
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        VideoNetStateBar videoNetStateBar;
        super.onInitView(view);
        z9(getContext(), nw.b.b());
        this.f76217i = (TextView) view.findViewById(m.n.f76085c);
        this.f76218m = (TextView) view.findViewById(m.p.f76091c);
        this.C = (RelativeLayout) view.findViewById(m.p.f76089a);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(m.InterfaceC0763m.f76081a);
        this.D = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        this.E = view.findViewById(m.d.f76012j);
        this.I = (TextView) view.findViewById(R.id.g87);
        this.J = (TextView) view.findViewById(R.id.g86);
        if (view.findViewById(m.p.f76090b) != null && view.findViewById(m.n.f76084b) != null) {
            VideoNetStateBar videoNetStateBar2 = new VideoNetStateBar(this.G.get(), x9(this.F), (ViewGroup) view);
            this.H = videoNetStateBar2;
            videoNetStateBar2.e();
        }
        if (r.h0().W0() && (videoNetStateBar = this.H) != null && !videoNetStateBar.b()) {
            this.H.h();
        }
        this.f76216h = false;
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.f.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
        this.f76216h = true;
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.f.class);
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.F = new WeakReference<>(context);
        this.G = new WeakReference<>((VideoAppInterface) appInterface);
    }

    public void C9(int i3) {
        if (i3 == 3) {
            this.C.setVisibility(8);
            View view = this.E;
            if (view != null) {
                view.setVisibility(8);
            }
            VideoNetStateBar videoNetStateBar = this.H;
            if (videoNetStateBar != null) {
                videoNetStateBar.l();
                return;
            }
            return;
        }
        if (i3 == 4) {
            this.C.setVisibility(0);
            View view2 = this.E;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            VideoNetStateBar videoNetStateBar2 = this.H;
            if (videoNetStateBar2 != null) {
                videoNetStateBar2.l();
            }
        }
    }

    protected void E9(boolean z16) {
        if (z16) {
            this.C.setVisibility(0);
            RelativeLayout relativeLayout = this.D;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            TextView textView = this.I;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.J.setVisibility(8);
            VideoNetStateBar videoNetStateBar = this.H;
            if (videoNetStateBar != null) {
                videoNetStateBar.l();
                return;
            }
            return;
        }
        this.C.setVisibility(8);
        RelativeLayout relativeLayout2 = this.D;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        this.J.setVisibility(0);
        TextView textView2 = this.I;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        VideoNetStateBar videoNetStateBar2 = this.H;
        if (videoNetStateBar2 != null) {
            videoNetStateBar2.l();
        }
    }

    public void D9(int i3) {
        if (i3 == 2) {
            VideoNetStateBar videoNetStateBar = this.H;
            if (videoNetStateBar != null) {
                videoNetStateBar.l();
            }
            O9(8);
            RelativeLayout relativeLayout = this.C;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            P9(0);
            View view = this.E;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        if (i3 == 1) {
            VideoNetStateBar videoNetStateBar2 = this.H;
            if (videoNetStateBar2 != null) {
                videoNetStateBar2.l();
            }
            O9(0);
            P9(8);
            View view2 = this.E;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.C;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
        }
    }

    public static int F9(SessionInfo sessionInfo, int i3) {
        int i16;
        if (i3 != 3) {
            i16 = R.string.djb;
            if (i3 != 12) {
                if (i3 == 25) {
                    i16 = R.string.dg5;
                } else if (i3 == 42) {
                    i16 = R.string.dj9;
                } else if (i3 != 43) {
                    i16 = R.string.dj8;
                    if (i3 != 64) {
                        if (i3 != 65) {
                            switch (i3) {
                                default:
                                    switch (i3) {
                                        case 54:
                                            i16 = R.string.dj7;
                                            break;
                                    }
                                case 50:
                                case 51:
                                case 52:
                                    i16 = R.string.dja;
                                    break;
                            }
                        } else {
                            i16 = R.string.dh6;
                        }
                    }
                }
            } else if (!sessionInfo.W) {
                i16 = R.string.dj_;
            }
        } else {
            i16 = R.string.id8;
        }
        return sessionInfo.f73067q == 1011 ? i3 == 9 ? R.string.icq : R.string.d_a : i16;
    }
}
