package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.feedx.event.QZoneUserHomeUpdateBackgroundEvent;
import com.qzone.reborn.feedx.viewmodel.t;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ch extends com.qzone.reborn.base.k implements SimpleEventReceiver, t.c {
    private static final String H = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetOnlyReceiveRecommend", "\u4ec5\u63a5\u6536\u63a8\u8350\u52a8\u6001");
    private static final String I = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetSpecialFollow", "\u7279\u522b\u5173\u6ce8");
    private static final String J = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetSpecialAndPush", "\u7279\u522b\u5173\u6ce8\u5e76\u63a5\u6536\u63a8\u9001");
    private static final String K = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionSheetCancelFollow", "\u53d6\u6d88\u5173\u6ce8");

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f55099d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f55100e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.t f55101f;

    /* renamed from: h, reason: collision with root package name */
    protected x6.a f55102h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f55103i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f55104m = false;
    private View.OnClickListener C = new f();
    private View.OnClickListener D = new g();
    private View.OnClickListener E = new h();
    private View.OnClickListener F = new i();
    private View.OnClickListener G = new j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Function0<Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke() {
            ch.this.f55104m = true;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements t.d {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.t.d
        public void a() {
            if (ch.this.f55103i == null) {
                return;
            }
            ch.this.f55103i.setText("\u5df2\u5220\u8bb0\u5f55");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements t.f {
        c() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.t.f
        public void a(QZoneResult qZoneResult) {
            ch.this.Y9(qZoneResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements t.h {
        d() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.t.h
        public void a(QZoneResult qZoneResult) {
            ch.this.da(qZoneResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e implements t.e {
        e() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.t.e
        public void a(QZoneResult qZoneResult) {
            ch.this.W9(qZoneResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ch chVar = ch.this;
            if (chVar.f55102h != null && chVar.f55100e != null) {
                Activity activity = ch.this.getActivity();
                ch chVar2 = ch.this;
                x6.a aVar = chVar2.f55102h;
                y6.b.b(activity, aVar.uin, aVar, chVar2.f55100e.getMEntryType());
                ch.this.Q9(LpReportInfo_dc04586.ITEM_ID_BTN_APPLY_VISIT, 102, 0);
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT, 2, ch.this.la() ? 3 : 4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ch chVar = ch.this;
            if (chVar.f55102h != null && chVar.f55100e != null) {
                if (y6.b.e(ch.this.f55100e.getMEntryType(), ch.this.f55100e.getMHasTalk())) {
                    Activity activity = ch.this.getActivity();
                    ch chVar2 = ch.this;
                    y6.b.g(activity, chVar2.f55102h.uin, chVar2.f55100e.getMNearbyProfile(), ch.this.getContext().getResources().getString(R.string.cgk));
                } else {
                    Activity activity2 = ch.this.getActivity();
                    ch chVar3 = ch.this;
                    y6.b.a(activity2, chVar3.f55102h.uin, chVar3.getContext().getResources().getString(R.string.f241767sr), 3081, 1);
                }
                ch.this.Q9(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, 102, 0);
                LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT, 3, ch.this.la() ? 3 : 4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z5.a f16;
            EventCollector.getInstance().onViewClickedBefore(view);
            ch chVar = ch.this;
            if (chVar.f55102h != null && chVar.f55101f != null && (f16 = z5.a.f()) != null) {
                long uin = LoginData.getInstance().getUin();
                ch chVar2 = ch.this;
                f16.h(uin, chVar2.f55102h.uin, chVar2.f55101f.getMHandler());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ch.this.f55102h != null && !FastClickUtils.isFastDoubleClick("QZoneUserHomeGuestBtnGroupPartfollow", 500L)) {
                if (ch.this.f55102h.isFollowed) {
                    str = "6";
                } else {
                    str = "5";
                }
                com.qzone.misc.network.report.c.b("380", str);
                ch chVar = ch.this;
                x6.a aVar = chVar.f55102h;
                int i3 = 2;
                if (aVar.isFollowed) {
                    if (aVar.isSpecialFollowedPush) {
                        r4 = 2;
                    } else if (!aVar.isSpecialFollowed) {
                        r4 = 0;
                    }
                    chVar.oa(false, r4, chVar.f55101f.getMHandler());
                } else {
                    chVar.pa(aVar.isReverseBlack ? 4 : 1);
                }
                x6.a aVar2 = ch.this.f55102h;
                if (aVar2 != null && aVar2.isFollowed) {
                    i3 = 3;
                }
                LpReportInfo_pf00064.allReport(308, 74, i3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void N9(View view, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_blocked", Integer.valueOf(z16 ? 1 : 0));
        fo.c.o(view, "em_qz_add_friends", new fo.b().l(hashMap));
    }

    private void O9(final ActionSheet actionSheet, final int i3, final boolean z16, final int i16) {
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.feedx.part.cg
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i17) {
                ch.this.ma(i3, z16, i16, actionSheet, view, i17);
            }
        });
    }

    private int P9(int i3) {
        int o16 = pl.a.f426446a.o(getActivity());
        if (i3 == 1) {
            return o16 - com.qzone.util.ar.d(32.0f);
        }
        if (i3 == 2) {
            return ((o16 - com.qzone.util.ar.d(32.0f)) - com.qzone.util.ar.d(5.0f)) / 2;
        }
        if (i3 != 3) {
            return 0;
        }
        return ((o16 - com.qzone.util.ar.d(32.0f)) - com.qzone.util.ar.d(10.0f)) / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(String str, int i3, int i16) {
        LpReportInfo_dc04586.report(new LpReportInfo_dc04586(str, i3, i16));
    }

    private void U9() {
        String str;
        if (this.f55099d == null || this.f55102h == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.nay);
        if (this.f55102h.isFollowed) {
            str = x6.c.f447265c;
        } else {
            str = x6.c.f447264b;
        }
        textView.setText(str);
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary_default));
        textView.setBackgroundResource(R.drawable.f143523);
        textView.setOnClickListener(this.G);
        this.f55099d.removeAllViews();
        this.f55099d.addView(inflate, R9(1));
        this.f55099d.setVisibility(0);
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.TRUE);
    }

    private void V9() {
        String str;
        if (this.f55099d == null || this.f55102h == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.nay);
        if (this.f55102h.isFollowed) {
            str = x6.c.f447265c;
        } else {
            str = x6.c.f447264b;
        }
        textView.setText(str);
        textView.setOnClickListener(this.G);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.nay);
        textView2.setText("\u52a0\u597d\u53cb");
        textView2.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary_default));
        textView2.setBackgroundResource(R.drawable.f143523);
        textView2.setOnClickListener(this.E);
        this.f55099d.removeAllViews();
        this.f55099d.addView(inflate, R9(2));
        this.f55099d.addView(inflate2, R9(2));
        this.f55099d.setVisibility(0);
        Q9(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, 101, 0);
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.TRUE);
        N9(textView2, false);
    }

    private void Z9() {
        if (this.f55099d == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.nay);
        textView.setText("\u52a0\u597d\u53cb");
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary_default));
        textView.setBackgroundResource(R.drawable.f143523);
        textView.setOnClickListener(this.E);
        this.f55099d.removeAllViews();
        this.f55099d.addView(inflate, R9(1));
        this.f55099d.setVisibility(0);
        Q9(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, 101, 0);
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.TRUE);
        N9(textView, false);
    }

    private void ba() {
        if (this.f55099d == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.nay);
        textView.setText("\u9080\u8bf7\u5f00\u901a");
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary_default));
        textView.setBackgroundResource(R.drawable.f143523);
        textView.setOnClickListener(this.F);
        this.f55099d.removeAllViews();
        this.f55099d.addView(inflate, R9(1));
        this.f55099d.setVisibility(0);
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(QZoneResult qZoneResult) {
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            Bundle bundle = (Bundle) qZoneResult.getData();
            int i3 = bundle.getInt("needToSpecialFollow", 0);
            int i16 = bundle.getInt("needToPush", 0);
            x6.a aVar = this.f55102h;
            if (aVar != null) {
                if (i3 == 1) {
                    aVar.isSpecialFollowed = true;
                } else if (i3 == -1) {
                    aVar.isSpecialFollowed = false;
                    aVar.isSpecialFollowedPush = false;
                }
                if (i16 == 1) {
                    aVar.isSpecialFollowed = true;
                    aVar.isSpecialFollowedPush = true;
                } else if (i16 == -1) {
                    aVar.isSpecialFollowedPush = false;
                }
                com.qzone.reborn.feedx.viewmodel.w wVar = this.f55100e;
                if (wVar != null) {
                    wVar.C2().postValue(this.f55102h);
                }
            }
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSuccess", WinkBaseErrorCodeKt.ERROR_MSG_OK), 5);
            return;
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSettingFail", "\u8bbe\u7f6e\u5931\u8d25"), 4);
    }

    private void ga() {
        com.qzone.reborn.feedx.viewmodel.t tVar = this.f55101f;
        if (tVar == null) {
            return;
        }
        tVar.D2(new b());
    }

    private void ha() {
        com.qzone.reborn.feedx.viewmodel.t tVar = this.f55101f;
        if (tVar == null) {
            return;
        }
        tVar.E2(new e());
    }

    private void ia() {
        com.qzone.reborn.feedx.viewmodel.t tVar = this.f55101f;
        if (tVar == null) {
            return;
        }
        tVar.G2(new c());
    }

    private void ja() {
        com.qzone.reborn.feedx.viewmodel.t tVar = this.f55101f;
        if (tVar == null) {
            return;
        }
        tVar.H2(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean la() {
        x6.a aVar = this.f55102h;
        if (aVar == null) {
            return false;
        }
        int i3 = aVar.relationShip;
        return i3 == 4 || i3 == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma(int i3, boolean z16, int i16, ActionSheet actionSheet, View view, int i17) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"), 4);
        } else if (i17 != i3) {
            if (z16 && i17 > 0) {
                i17++;
            }
            na(i17, i16);
        }
        try {
            actionSheet.dismiss();
        } catch (Exception e16) {
            QLog.e("QZoneUserHomeGuestBtnGroupPart", 1, "showSpecialFollowActionSheet() catch an exception when onclick the actionsheet.", e16);
        }
    }

    private void na(int i3, int i16) {
        a8.b O = a8.b.O();
        if (O != null) {
            if (i3 == 0) {
                O.M(this.f55102h.uin, -1, 0, 1, this.f55101f.getMHandler());
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    O.M(this.f55102h.uin, 0, 1, 1, this.f55101f.getMHandler());
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    O.L(this.f55102h.uin, false, 1, this.f55101f.getMHandler(), null, 0, null, getContext());
                    return;
                }
            }
            if (i16 == 0) {
                O.M(this.f55102h.uin, 1, 0, 1, this.f55101f.getMHandler());
            } else if (i16 == 2) {
                O.M(this.f55102h.uin, 0, -1, 1, this.f55101f.getMHandler());
            }
        }
    }

    public void S9(Object obj) {
        if (!(obj instanceof x6.a)) {
            QLog.e("QZoneUserHomeGuestBtnGroupPart", 1, "not BusinessUserInfoData");
            return;
        }
        x6.a aVar = (x6.a) obj;
        this.f55102h = aVar;
        if (y6.b.f(aVar.uin)) {
            if (com.qzone.reborn.feedx.util.k.F(aVar)) {
                y6.a.E().D(aVar.uin, this.f55101f.getMHandler());
                return;
            }
            int i3 = aVar.relationShip;
            if (i3 != 0) {
                switch (i3) {
                    case 2:
                        Z9();
                        return;
                    case 3:
                    case 4:
                        X9();
                        return;
                    case 5:
                    case 6:
                        aa();
                        return;
                    case 7:
                    case 8:
                        ba();
                        return;
                    default:
                        T9();
                        return;
                }
            }
            ca();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T9() {
        if (this.f55099d == null) {
            return;
        }
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.FALSE);
        this.f55099d.removeAllViews();
        this.f55099d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X9() {
        if (this.f55099d == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cnz, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.nay);
        this.f55103i = textView;
        textView.setText("\u5220\u9664\u8bb0\u5f55");
        qa(this.f55103i);
        this.f55103i.setOnClickListener(this.D);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.nay);
        textView2.setText("\u7533\u8bf7\u8bbf\u95ee");
        textView2.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary_default));
        textView2.setBackgroundResource(R.drawable.f143523);
        textView2.setOnClickListener(this.C);
        this.f55099d.removeAllViews();
        this.f55099d.addView(inflate, R9(2));
        this.f55099d.addView(inflate2, R9(2));
        this.f55099d.setVisibility(0);
        Q9("delete", 101, 0);
        Q9(LpReportInfo_dc04586.ITEM_ID_BTN_APPLY_VISIT, 101, 0);
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.FALSE);
        if (com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-12-05", "vas_bug_132247101").isEnable(true)) {
            na.e.f419543a.e(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa() {
        if (this.f55099d == null) {
            return;
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.cnz, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(getActivity()).inflate(R.layout.cny, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.nay);
        this.f55103i = textView;
        textView.setText("\u5220\u9664\u8bb0\u5f55");
        this.f55103i.setOnClickListener(this.D);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.nay);
        textView2.setText("\u7533\u8bf7\u8bbf\u95ee");
        textView2.setOnClickListener(this.C);
        TextView textView3 = (TextView) inflate3.findViewById(R.id.nay);
        textView3.setText("\u52a0\u597d\u53cb");
        textView3.setOnClickListener(this.E);
        textView3.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary_default));
        textView3.setBackgroundResource(R.drawable.f143523);
        qa(this.f55103i);
        qa(textView2);
        this.f55099d.removeAllViews();
        this.f55099d.addView(inflate, R9(3));
        this.f55099d.addView(inflate2, R9(3));
        this.f55099d.addView(inflate3, R9(3));
        this.f55099d.setVisibility(0);
        Q9("delete", 101, 0);
        Q9(LpReportInfo_dc04586.ITEM_ID_BTN_APPLY_VISIT, 101, 0);
        Q9(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, 101, 0);
        broadcastMessage("whether_set_user_home_bottom_padding", Boolean.FALSE);
        N9(textView3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ca() {
        com.qzone.reborn.feedx.viewmodel.w wVar;
        if (this.f55102h == null || (wVar = this.f55100e) == null) {
            return;
        }
        if (wVar.M2()) {
            T9();
        } else if (this.f55102h.isFriend) {
            X9();
        } else {
            aa();
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void g0(int i3, int i16) {
        LinearLayout linearLayout = this.f55099d;
        if (linearLayout != null) {
            linearLayout.setTranslationY(-i3);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneUserHomeUpdateBackgroundEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeGuestBtnGroupPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals("user_home_business_info", str)) {
            S9(obj);
        }
    }

    public void oa(boolean z16, int i3, Handler handler) {
        if (this.f55102h == null || getContext() == null) {
            return;
        }
        boolean z17 = i3 == 0 || i3 == 2;
        int i16 = (z17 && i3 == 2) ? i3 - 1 : i3;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getContext(), null);
        actionSheet.addRadioButton((CharSequence) H, false);
        actionSheet.addRadioButton((CharSequence) I, false);
        if (!z17) {
            actionSheet.addRadioButton((CharSequence) J, false);
        }
        actionSheet.addRadioButton((CharSequence) K, false);
        actionSheet.addCancelButton(com.qzone.util.l.a(R.string.j6l));
        if (i16 == 0) {
            actionSheet.setRadioButtonChecked(0);
        } else if (i16 == 1) {
            actionSheet.setRadioButtonChecked(1);
        } else if (i16 == 2) {
            actionSheet.setRadioButtonChecked(2);
        }
        O9(actionSheet, i16, z17, i3);
        actionSheet.show();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f55099d != null) {
            for (int i3 = 0; i3 < this.f55099d.getChildCount(); i3++) {
                this.f55099d.getChildAt(i3).setLayoutParams(R9(this.f55099d.getChildCount()));
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55100e = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f55101f = (com.qzone.reborn.feedx.viewmodel.t) getViewModel(com.qzone.reborn.feedx.viewmodel.t.class);
        LinearLayout linearLayout = (LinearLayout) ((ViewStub) view.findViewById(R.id.ncn)).inflate();
        this.f55099d = linearLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
        this.f55101f.q2(this);
        ga();
        ia();
        ja();
        ha();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneUserHomeUpdateBackgroundEvent) {
            ea((QZoneUserHomeUpdateBackgroundEvent) simpleBaseEvent);
        }
    }

    protected void pa(int i3) {
        a8.b O;
        if (this.f55102h == null || (O = a8.b.O()) == null) {
            return;
        }
        x6.a aVar = this.f55102h;
        boolean z16 = aVar.isFollowed;
        O.K(aVar.uin, !z16, i3, this.f55101f.getMHandler(), null, 0, null);
        if (z16) {
            LpReportInfo_pf00064.allReport(308, 9, 13);
        } else {
            LpReportInfo_pf00064.allReport(308, 9, 14);
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void s0() {
        LinearLayout linearLayout = this.f55099d;
        if (linearLayout != null) {
            linearLayout.setTranslationY(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9(QZoneResult qZoneResult) {
        if (qZoneResult == null || this.f55102h == null) {
            return;
        }
        if (((Bundle) qZoneResult.getData()) == null) {
            com.qzone.proxy.feedcomponent.util.j.c("QZoneUserHomeGuestBtnGroupPart", "onGetBottomNaviInfo() error!bundle is null");
        } else if (com.qzone.reborn.feedx.util.k.F(this.f55102h)) {
            if (this.f55102h.isFriend) {
                U9();
            } else {
                V9();
            }
        }
    }

    private void qa(TextView textView) {
        x6.a aVar;
        x6.d dVar;
        String str;
        if (textView == null || (aVar = this.f55102h) == null || (dVar = aVar.strangerDecorate) == null) {
            return;
        }
        if (TextUtils.isEmpty(dVar.f447267b)) {
            QLog.i("QZoneUserHomeGuestBtnGroupPart", 1, "strImageUrl is empty");
            return;
        }
        if (!TextUtils.isEmpty(this.f55102h.strangerDecorate.f447268c)) {
            str = this.f55102h.strangerDecorate.f447268c;
        } else {
            str = this.f55102h.strangerDecorate.f447269d;
        }
        QLog.i("QZoneUserHomeGuestBtnGroupPart", 1, "strangerDecorate text color is " + str);
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e16) {
            QLog.e("QZoneUserHomeGuestBtnGroupPart", 1, "exception is " + e16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!NetworkState.isNetSupport()) {
                ToastUtil.s("\u65e0\u7f51\u7edc\u8fde\u63a5", 0);
            } else {
                ch chVar = ch.this;
                if (chVar.f55102h != null && chVar.f55101f != null) {
                    if (!LoginData.getInstance().isQzoneVip() && !ch.this.f55104m) {
                        String stringDataSet = com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-07-12", "qzone_kuikly_pay_url").getStringDataSet("delete_record_vip_url", "");
                        if (!stringDataSet.isEmpty()) {
                            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(ch.this.getActivity(), stringDataSet);
                        } else {
                            com.qzone.common.activities.base.ak.R(ch.this.getActivity(), com.qzone.common.activities.base.ak.q(ch.this.getActivity(), "jhan_beidangshanchu", null, null, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip() || ch.this.f55104m), -1, false);
                        }
                    } else {
                        z5.a f16 = z5.a.f();
                        long uin = LoginData.getInstance().getUin();
                        ch chVar2 = ch.this;
                        f16.d(uin, chVar2.f55102h.uin, (byte) 0, 0L, (byte) 8, chVar2.f55101f.getMHandler(), "");
                    }
                    ch.this.Q9("delete", 102, 0);
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT, 4, ch.this.la() ? 3 : 4);
                    ClickReport.q("328", "13", "", true);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (qZoneResult.getSucceed()) {
            x6.a aVar = this.f55102h;
            if (aVar != null) {
                boolean z16 = aVar.isFollowed;
                boolean z17 = !z16;
                aVar.isFollowed = z17;
                if (!z17) {
                    aVar.isSpecialFollowed = false;
                    aVar.isSpecialFollowedPush = false;
                }
                if (z16) {
                    long j3 = aVar.fansCount - 1;
                    aVar.fansCount = j3;
                    if (j3 < 0) {
                        aVar.fansCount = 0L;
                    }
                } else {
                    aVar.fansCount++;
                }
                if (aVar.isOpenFollow && aVar.isFollow48SpaceUser() && !this.f55102h.isLimitRelationship()) {
                    y6.a.E().D(this.f55102h.uin, this.f55101f.getMHandler());
                    return;
                }
                return;
            }
            return;
        }
        if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
            ToastUtil.r(qZoneResult.getMessage());
        } else if (this.f55102h != null) {
            ToastUtil.o(R.string.f173117hh4, 4);
        }
    }

    private void ea(QZoneUserHomeUpdateBackgroundEvent qZoneUserHomeUpdateBackgroundEvent) {
        LinearLayout linearLayout;
        if (qZoneUserHomeUpdateBackgroundEvent == null || (linearLayout = this.f55099d) == null) {
            return;
        }
        linearLayout.setBackgroundResource(qZoneUserHomeUpdateBackgroundEvent.hasStrangerDecorate ? R.drawable.lvj : R.drawable.qui_common_bg_bottom_light_bg);
    }

    private LinearLayout.LayoutParams R9(int i3) {
        if (i3 == 1) {
            return new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(P9(1), -2));
        }
        if (i3 != 2) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(P9(3), -2));
            layoutParams.leftMargin = com.qzone.util.ar.d(2.5f);
            layoutParams.rightMargin = com.qzone.util.ar.d(2.5f);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(P9(2), -2));
        layoutParams2.leftMargin = com.qzone.util.ar.d(2.5f);
        layoutParams2.rightMargin = com.qzone.util.ar.d(2.5f);
        return layoutParams2;
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void onEnd() {
    }

    @Override // com.qzone.reborn.feedx.viewmodel.t.c
    public void onStart(int i3) {
    }
}
