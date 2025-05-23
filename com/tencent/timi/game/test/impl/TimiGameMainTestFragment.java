package com.tencent.timi.game.test.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.gift.impl.timi.TestGiftFragment;
import com.tencent.timi.game.liveroom.impl.room.notice.TimiNoticeEditFragment;
import com.tencent.timi.game.team.impl.floating.FloatingTestFragment;
import com.tencent.timi.game.test.impl.emo.EmoticonDataTestFragment;
import com.tencent.timi.game.test.impl.emo.EmoticonTestFragment;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.api.ProcessConstant;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiGameMainTestFragment extends QPublicBaseFragment implements IWXAPIEventHandler {
    private IWXAPI D;
    private String C = "https://test-live.yes.qq.com/Home?gameId=1&anchorId=E10CA96B796C0CA835EEDB8D416B24F8";
    private BroadcastReceiver E = new ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.ui.widget.f.c("bannerContainerClick");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ad extends BroadcastReceiver {
        ad() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TimiGameMainTestFragment.this.D != null) {
                TimiGameMainTestFragment.this.D.handleIntent(intent, TimiGameMainTestFragment.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ae implements View.OnClickListener {
        ae() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((ni4.a) mm4.b.b(ni4.a.class)).V2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class af implements View.OnClickListener {
        af() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.ui.widget.f.c("\u8f6c\u6587\u5b57\u914d\u7f6e" + ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanGifText());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ag implements View.OnClickListener {
        ag() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.ui.widget.f.c("\u8868\u60c5\u914d\u7f6e\u5165\u53e3" + ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanAIOMakeGifEntrance());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ah implements View.OnClickListener {
        ah() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QPublicFragmentActivity.start(TimiGameMainTestFragment.this.getActivity(), EmoticonTestFragment.class);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ai implements View.OnClickListener {
        ai() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QPublicFragmentActivity.start(TimiGameMainTestFragment.this.getActivity(), EmoticonDataTestFragment.class);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class aj implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map.Entry f379920d;

            a(Map.Entry entry) {
                this.f379920d = entry;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                bi.c((BaseQQAppInterface) TimiGameMainTestFragment.this.getQBaseActivity().getAppRuntime(), TimiGameMainTestFragment.this.getContext(), (String) this.f379920d.getValue()).b();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        aj() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = TimiGameMainTestFragment.this.getActivity();
            LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
            HashMap hashMap = new HashMap();
            hashMap.put("\u738b\u8005\u9644\u8fd1\u5927\u5385", "mqqapi://esports/open?roomtype=1&entryscene=3&roomid=7012550747825942529&yesgameid=101");
            hashMap.put("\u98de\u8f66\u9644\u8fd1\u5927\u5385", "mqqapi://esports/open?roomtype=1&entryscene=3&roomid=7012551164437770243&yesgameid=104");
            hashMap.put("\u521b\u5efa\u738b\u8005\u8f66\u961f", "mqqapi://esports/team/create?entryscene=3&yesgameid=101");
            hashMap.put("\u52a0\u5165\u738b\u8005\u8f66\u961f", "mqqapi://esports/team/join?entryscene=3&teamid=7015106081501261833&yesgameid=101");
            hashMap.put("\u521b\u5efaQ\u98de\u8f66\u961f", "mqqapi://esports/team/create?entryscene=3&yesgameid=104");
            hashMap.put("\u52a0\u5165Q\u98de\u8f66\u961f", "mqqapi://esports/team/join?entryscene=3&teamid=7015106081501261833&yesgameid=104");
            for (Map.Entry entry : hashMap.entrySet()) {
                CommonButton commonButton = new CommonButton(activity);
                commonButton.setText((CharSequence) entry.getKey());
                commonButton.setGravity(17);
                commonButton.setBackgroundResource(R.drawable.f162549lr4);
                commonButton.setOnClickListener(new a(entry));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Utils.n(240.0f, TimiGameMainTestFragment.this.getResources()), Utils.n(35.0f, TimiGameMainTestFragment.this.getResources()));
                layoutParams.gravity = 1;
                layoutParams.topMargin = Utils.n(10.0f, TimiGameMainTestFragment.this.getResources());
                layoutParams.bottomMargin = Utils.n(5.0f, TimiGameMainTestFragment.this.getResources());
                commonButton.setLayoutParams(layoutParams);
                linearLayout.addView(commonButton);
            }
            e.a aVar = new e.a(activity);
            aVar.q("").j("").g(linearLayout, 0, 0, 0, 0).n("").p("\u786e\u5b9a");
            aVar.c().show();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ak implements View.OnClickListener {
        ak() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.ui.widget.f.c("bannerClick");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            in4.e.N3(TimiGameMainTestFragment.this.getActivity(), 104);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f379925d;

            a(int i3) {
                this.f379925d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                in4.e.N3(TimiGameMainTestFragment.this.getActivity(), this.f379925d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = TimiGameMainTestFragment.this.getActivity();
            LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
            for (Map.Entry<Integer, Integer> entry : ((ag4.h) mm4.b.b(ag4.h.class)).h1().entrySet()) {
                int intValue = entry.getKey().intValue();
                int intValue2 = entry.getValue().intValue();
                CommonButton commonButton = new CommonButton(activity);
                String a16 = com.tencent.timi.game.room.impl.util.f.a(intValue2);
                YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(intValue);
                if (!TextUtils.isEmpty(l16.game_name.get())) {
                    a16 = l16.game_name.get();
                }
                commonButton.setText(a16);
                commonButton.setGravity(17);
                commonButton.setBackgroundResource(R.drawable.f162549lr4);
                commonButton.setOnClickListener(new a(intValue));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Utils.n(240.0f, TimiGameMainTestFragment.this.getResources()), Utils.n(35.0f, TimiGameMainTestFragment.this.getResources()));
                layoutParams.gravity = 1;
                layoutParams.topMargin = Utils.n(10.0f, TimiGameMainTestFragment.this.getResources());
                layoutParams.bottomMargin = Utils.n(5.0f, TimiGameMainTestFragment.this.getResources());
                commonButton.setLayoutParams(layoutParams);
                linearLayout.addView(commonButton);
            }
            e.a aVar = new e.a(activity);
            aVar.q("").j("").g(linearLayout, 0, 0, 0, 0).n("").p("\u786e\u5b9a");
            aVar.c().show();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((fm4.g) mm4.b.b(fm4.g.class)).L();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((ni4.a) mm4.b.b(ni4.a.class)).L();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TimiNoticeEditFragment.xh(TimiGameMainTestFragment.this.getContext(), "\u53cd\u5012\u662f\u6cd5\u5f8b\u6846\u67b6\u5927\u715e\u98ce\u666f\u7684\u5feb\u4e50\u6c34\u714e\u670d\u7684\u9644\u8fd1\u7684\u5feb\u4e50\u6c34\u623f\u95f4\u770b\u4e86\u7535\u89c6\u5267\u53d1\u770b\u4e86\u7535\u89c6\u5267\u53d1\u90fd\u6b7b\u4e86", 4536L, 8798L);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ArrayList arrayList = new ArrayList();
            arrayList.add(904357639L);
            arrayList.add(904357639L);
            new an4.c(TimiGameMainTestFragment.this.getActivity(), arrayList, "0", 101).show();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            an4.f.f26362a.d(TimiGameMainTestFragment.this.getActivity(), "259217951");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((lo4.a) mm4.b.b(lo4.a.class)).Y(TimiGameMainTestFragment.this.getActivity(), "https://cdn.yes.qq.com/h5/h5-jsbridge/index.html?ver=73");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class k implements CompoundButton.OnCheckedChangeListener {
        k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                str = "Yes_Http";
            } else {
                str = ProcessConstant.MSF;
            }
            compoundButton.setText("\u7f51\u7edc\u5e95\u5c42\u5207\u6362(\u5f53\u524d\uff1a" + str + ")   ");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TODO \u7f51\u7edc\u5e95\u5c42\u5df2\u5207\u6362\u81f3 ");
            sb5.append(str);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QPublicFragmentActivity.start(TimiGameMainTestFragment.this.getActivity(), TestGiftFragment.class);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                QPublicFragmentActivity.start(TimiGameMainTestFragment.this.getActivity(), Class.forName("hexin.ui.QImageCheckerFragment"));
            } catch (Exception unused) {
                com.tencent.timi.game.ui.widget.f.c("\u542f\u52a8\u5931\u8d25");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = String.valueOf(System.currentTimeMillis());
            req.transaction = String.valueOf(System.currentTimeMillis());
            TimiGameMainTestFragment.this.D.sendReq(req);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QPublicFragmentActivity.start(TimiGameMainTestFragment.this.getActivity(), FloatingTestFragment.class);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = new YoloRoomOuterClass$YoloGiftConfig();
            yoloRoomOuterClass$YoloGiftConfig.gift_num.set(4);
            yoloRoomOuterClass$YoloGiftConfig.gift_id.set(56);
            yoloRoomOuterClass$YoloGiftConfig.gift_material_id.set(32);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.utils.l.i("QQDtReporter", "ranlili BtnClick");
            VideoReport.traverseExposure();
            VideoReport.reportEvent("clck", view, new HashMap());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QPublicFragmentActivity.start(TimiGameMainTestFragment.this.getActivity(), ArkViewTestFragment.class);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bi.c((BaseQQAppInterface) TimiGameMainTestFragment.this.getQBaseActivity().getAppRuntime(), TimiGameMainTestFragment.this.getContext(), "mqqapi://vaslive/portal?from=14").b();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (rm4.a.b("webview_test", false)) {
                com.tencent.timi.game.ui.widget.f.c("\u5173\u95ed\u6302\u4ef6\u5165\u53e3");
                rm4.a.h("webview_test", false);
            } else {
                com.tencent.timi.game.ui.widget.f.c("\u6253\u5f00\u6302\u4ef6\u5165\u53e3");
                rm4.a.h("webview_test", true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (rm4.a.b("is_one_capture_key", true)) {
                com.tencent.timi.game.ui.widget.f.c("\u5f55\u5c4f\u5f00\u64ad\u6253\u5f00");
                rm4.a.h("is_one_capture_key", false);
            } else {
                com.tencent.timi.game.ui.widget.f.c("\u4e00\u952e\u5f00\u64ad\u6253\u5f00");
                rm4.a.h("is_one_capture_key", true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((lo4.a) mm4.b.b(lo4.a.class)).y1(TimiGameMainTestFragment.this.getContext(), "https://static.qlive.qq.com/qlive/h5/jump-qq/index.html?_bid=4849&to=mqqapi%3A%2F%2Fvaslive%2Fwatch%3Froomid%3D1365672049%26from%3D12%26video_source%3D0%26room_type%3D1%26qq_live_product_type%3D1%26auto_open_url%3Dhttps%25253A%25252F%25252Fcdn.yes.qq.com%25252Fh5%25252Fhonor-anniversary-release%25252Findex.html%25253Ftimestamp%25253D1634007999%252526source%25253D12");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initView(View view) {
        ((ag4.i) mm4.b.b(ag4.i.class)).I1(101, null);
        Switch r06 = (Switch) view.findViewById(R.id.tc8);
        r06.setChecked(false);
        r06.setText("\u7f51\u7edc\u5e95\u5c42\u5207\u6362(\u5f53\u524d\uff1a" + ProcessConstant.MSF + ")   ");
        r06.setOnCheckedChangeListener(new k());
        view.findViewById(R.id.yaz).setOnClickListener(new v());
        view.findViewById(R.id.zwt).setOnClickListener(new ae());
        view.findViewById(R.id.f99345pj).setOnClickListener(new af());
        view.findViewById(R.id.f99335pi).setOnClickListener(new ag());
        view.findViewById(R.id.us7).setOnClickListener(new ah());
        view.findViewById(R.id.us6).setOnClickListener(new ai());
        view.findViewById(R.id.zoe).setOnClickListener(new aj());
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.ykc);
        View view2 = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getTimiLiveApi().e(null, (Activity) getContext()).getView();
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(view2);
        viewGroup.setOnClickListener(new ak());
        view2.setOnClickListener(new a());
        view.findViewById(R.id.f164646tc2).setOnClickListener(new b());
        view.findViewById(R.id.f164647tc3).setOnClickListener(new c());
        view.findViewById(R.id.tca).setOnClickListener(new d());
        view.findViewById(R.id.tc6).setOnClickListener(new e());
        ((lo4.a) mm4.b.b(lo4.a.class)).K1();
        view.findViewById(R.id.xp6).setOnClickListener(new f());
        view.findViewById(R.id.zsq).setOnClickListener(new g());
        view.findViewById(R.id.f84174lj).setOnClickListener(new h());
        view.findViewById(R.id.f84124le).setOnClickListener(new i());
        view.findViewById(R.id.f122067cy).setOnClickListener(new j());
        view.findViewById(R.id.udb).setOnClickListener(new l());
        view.findViewById(R.id.vov).setOnClickListener(new m());
        view.findViewById(R.id.xhn).setOnClickListener(new n());
        this.D = WXAPIFactory.createWXAPI(getActivity(), qh());
        BaseApplication.getContext().registerReceiver(this.E, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"));
        view.findViewById(R.id.f125567me).setOnClickListener(new o());
        view.findViewById(R.id.f73463tm).setOnClickListener(new p());
        view.findViewById(R.id.vb5).setOnClickListener(new q());
        view.findViewById(R.id.y_y).setOnClickListener(new r());
        view.findViewById(R.id.voq).setOnClickListener(new s());
        View findViewById = view.findViewById(R.id.iet);
        HashMap hashMap = new HashMap();
        hashMap.put("url", "https://puui.qpic.cn/vupload/0/20190307_1551949943235_fyzjsfvz9xk.png/0");
        hashMap.put("ranlili", "https://puui.qpic.cn/vupload/0/20190307_1551949943235_fyzjsfvz9xk.png/0");
        ((ug4.a) mm4.b.b(ug4.a.class)).u().i(this, findViewById, "page_yolo_test", hashMap);
        View findViewById2 = view.findViewById(R.id.f73403tg);
        VideoReport.setElementId(findViewById2, "ranliliReportTestContainer");
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("buttonType", "submit");
        hashMap2.put("ranliliContainer", "ranliliContainerValue");
        VideoReport.setElementParams(findViewById2, hashMap2);
        View findViewById3 = view.findViewById(R.id.f73393tf);
        VideoReport.setElementId(findViewById3, "ranliliReportTestBtn");
        HashMap hashMap3 = new HashMap(1);
        hashMap3.put("ranliliBtnButtonType", "submitButtonTyp");
        hashMap3.put("ranliliBtn", "ranliliContainerBtn");
        VideoReport.setElementParams(findViewById3, hashMap3);
        findViewById3.setOnClickListener(new t());
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(findViewById2, clickPolicy);
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(findViewById2, exposurePolicy);
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(findViewById2, endExposurePolicy);
        VideoReport.setElementClickPolicy(findViewById3, clickPolicy);
        VideoReport.setElementExposePolicy(findViewById3, exposurePolicy);
        VideoReport.setElementEndExposePolicy(findViewById3, endExposurePolicy);
        view.findViewById(R.id.sv_).setOnClickListener(new u());
        view.findViewById(R.id.f122347dp).setOnClickListener(new w());
        view.findViewById(R.id.f25630bc).setOnClickListener(new x());
        view.findViewById(R.id.f122337do).setOnClickListener(new y());
        view.findViewById(R.id.f84934nl).setOnClickListener(new z());
        view.findViewById(R.id.f84924nk).setOnClickListener(new aa());
        view.findViewById(R.id.tuj).setOnClickListener(new ab());
        view.findViewById(R.id.ycz).setOnClickListener(new ac());
    }

    private String qh() {
        return "wxb27274b726480a1b";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hx9, viewGroup, false);
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.getContext().unregisterReceiver(this.E);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        com.tencent.timi.game.utils.l.i("TimiGameMainTestFragment", "onReq: " + baseReq.openId);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        com.tencent.timi.game.utils.l.i("TimiGameMainTestFragment", "onResp: " + baseResp.errCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class aa implements View.OnClickListener {
        aa() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ab implements View.OnClickListener {
        ab() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ac implements View.OnClickListener {
        ac() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class z implements View.OnClickListener {
        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
