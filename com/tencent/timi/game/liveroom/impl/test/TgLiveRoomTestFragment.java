package com.tencent.timi.game.liveroom.impl.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.liveroom.impl.room.more.AnchorMoreDialog;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TgLiveRoomTestFragment extends QPublicBaseFragment {
    private EditText C;
    private TextView D;
    private TextView E;
    private CommonButton F;
    private TextView G;
    private View H;
    private long I = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long c16 = ((ni4.a) mm4.b.b(ni4.a.class)).b0().c();
            if (c16 != 0) {
                ((ni4.a) mm4.b.b(ni4.a.class)).X2(TgLiveRoomTestFragment.this.getActivity(), c16, "share_qq");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements jg4.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQLiveAnchorStreamRecordType f378950a;

        b(QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType) {
            this.f378950a = qQLiveAnchorStreamRecordType;
        }

        @Override // jg4.g
        public void a() {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onPrepareStart");
        }

        @Override // jg4.g
        public void b() {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onCreateRoomStart");
        }

        @Override // jg4.g
        public void c(int i3, int i16, String str) {
            l.e("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onFinalError, step = " + i3 + ", errorCode= " + i16 + ", errorDisplayMsg= " + str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5f00\u64ad\u5931\u8d25! ");
            sb5.append(str);
            sb5.append("(");
            sb5.append(i16);
            sb5.append(")");
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
        }

        @Override // jg4.g
        public void d(boolean z16, QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo, String str, String str2) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "onGetThirdPushInfo" + this.f378950a + " ### onGetThirdPushInfo - " + z16);
            if (!z16) {
                com.tencent.timi.game.ui.widget.f.c("\u83b7\u53d6\u7b2c\u4e09\u65b9\u63a8\u6d41\u5730\u5740\u5931\u8d25, " + qQLiveAnchorDataPushInfo.errorMsg);
                return;
            }
            TgLiveRoomTestFragment.this.F.setEnabled(true);
            TgLiveRoomTestFragment.this.G.setEnabled(true);
            TgLiveRoomTestFragment.this.D.setText(str);
            TgLiveRoomTestFragment.this.E.setText(str2);
            String str3 = "\u63a8\u6d41\u5730\u5740:\nrtmpServer = " + str + "\nrtmpKey = " + str2;
            com.tencent.timi.game.utils.a.a(eh4.a.b(), str3);
            com.tencent.timi.game.ui.widget.f.c("\u5df2\u62f7\u8d1d\u81f3\u526a\u8d34\u677f\n\n" + str3);
        }

        @Override // jg4.g
        public void e(boolean z16, QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onEnterRoomResult");
        }

        @Override // jg4.g
        public void f() {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onPublishStreamStart");
        }

        @Override // jg4.g
        public void g(boolean z16, QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onPrepareResult");
        }

        @Override // jg4.g
        public void h() {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onEnterRoomStart");
        }

        @Override // jg4.g
        public void i(boolean z16, QQLiveAnchorDataBase qQLiveAnchorDataBase, View view) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onPublishStreamResult");
            if (z16) {
                ((ni4.a) mm4.b.b(ni4.a.class)).openAnchorRoomPage(TgLiveRoomTestFragment.this.getContext(), 2, null);
            }
        }

        @Override // jg4.g
        public void j(boolean z16, QQLiveAnchorDataInit qQLiveAnchorDataInit) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onCreateRoomInitResult");
        }

        @Override // jg4.g
        public void k(boolean z16) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onLiveSdkInitResult");
        }

        @Override // jg4.g
        public void l(int i3, String str) {
            com.tencent.timi.game.ui.widget.f.c(str + str);
        }

        @Override // jg4.g
        public void onGetPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onGetPullInfo");
        }

        @Override // jg4.g
        public void onThirdPushChecked(QQLiveAnchorDataThirdPushCheck qQLiveAnchorDataThirdPushCheck) {
            l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + this.f378950a + " ### onThirdPushChecked");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.ui.widget.f.c("\u5df2\u9000\u51fa\u623f\u95f4\u5e76\u91ca\u653e\u5168\u90e8\u8d44\u6e90");
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
            TgLiveRoomTestFragment.this.xh(QQLiveAnchorStreamRecordType.SCREEN);
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
            TgLiveRoomTestFragment.this.xh(QQLiveAnchorStreamRecordType.THIRD_PUSH);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a extends jg4.e {
            a() {
            }

            @Override // jg4.g
            public void c(int i3, int i16, String str) {
                com.tencent.timi.game.ui.widget.f.c(str);
            }

            @Override // jg4.g
            public void i(boolean z16, QQLiveAnchorDataBase qQLiveAnchorDataBase, View view) {
                if (z16) {
                    ((ni4.a) mm4.b.b(ni4.a.class)).openAnchorRoomPage(TgLiveRoomTestFragment.this.getActivity(), 2, null);
                }
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((jg4.b) mm4.b.b(jg4.b.class)).H0(0L, "", new a());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<EndPageRealTimeInfo> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
                l.i("TgLiveRoomTestFragment", "anchorStopLive LiveRealTimeInfo - " + endPageRealTimeInfo);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                l.e("TgLiveRoomTestFragment", "anchorStopLive LiveRealTimeInfo onError - " + i3 + " " + str);
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((jg4.b) mm4.b.b(jg4.b.class)).x3(TgLiveRoomTestFragment.this.I, new a());
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
            long parseLong;
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = TgLiveRoomTestFragment.this.C.getText().toString();
            TgLiveRoomTestFragment tgLiveRoomTestFragment = TgLiveRoomTestFragment.this;
            if (TextUtils.isEmpty(obj)) {
                parseLong = -1;
            } else {
                parseLong = Long.parseLong(obj);
            }
            tgLiveRoomTestFragment.I = parseLong;
            if (TgLiveRoomTestFragment.this.I <= 0) {
                com.tencent.timi.game.ui.widget.f.c("roomId\u65e0\u6548\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165!");
            }
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
            if (TgLiveRoomTestFragment.this.D.getText() != null) {
                String charSequence = TgLiveRoomTestFragment.this.D.getText().toString();
                com.tencent.timi.game.utils.a.a(eh4.a.b(), charSequence);
                com.tencent.timi.game.ui.widget.f.c("\u5df2\u62f7\u8d1d\u81f3\u526a\u8d34\u677f\n\n" + charSequence);
            }
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
            if (TgLiveRoomTestFragment.this.E.getText() != null) {
                String charSequence = TgLiveRoomTestFragment.this.E.getText().toString();
                com.tencent.timi.game.utils.a.a(eh4.a.b(), charSequence);
                com.tencent.timi.game.ui.widget.f.c("\u5df2\u62f7\u8d1d\u81f3\u526a\u8d34\u677f\n\n" + charSequence);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long j3 = 0;
            BaseRoomInfo q16 = ((jg4.b) mm4.b.b(jg4.b.class)).q(0L);
            FragmentActivity activity = TgLiveRoomTestFragment.this.getActivity();
            if (q16 != null) {
                j3 = q16.getRoomId();
            }
            AnchorMoreDialog.A0(activity, j3, 0, null, true, null, null, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initView(View view) {
        view.findViewById(R.id.f96235h5).setOnClickListener(new c());
        view.findViewById(R.id.f96145gw).setOnClickListener(new d());
        view.findViewById(R.id.f96165gy).setOnClickListener(new e());
        view.findViewById(R.id.f96135gv).setOnClickListener(new f());
        view.findViewById(R.id.f96155gx).setOnClickListener(new g());
        this.C = (EditText) view.findViewById(R.id.f96285h_);
        view.findViewById(R.id.f96275h9).setOnClickListener(new h());
        this.D = (TextView) view.findViewById(R.id.f96205h2);
        this.E = (TextView) view.findViewById(R.id.f96185h0);
        this.F = (CommonButton) view.findViewById(R.id.f96195h1);
        this.G = (TextView) view.findViewById(R.id.f96175gz);
        this.F.setOnClickListener(new i());
        this.G.setOnClickListener(new j());
        this.F.setEnabled(false);
        this.G.setEnabled(false);
        view.findViewById(R.id.f96345hf).setOnClickListener(new k());
        view.findViewById(R.id.f96335he).setOnClickListener(new a());
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.headUrl = "https://thirdqq.qlogo.cn/g?b=oidb&k=8GHTq0bzoYEklP24NyBYPg&s=140&t=1555927329";
        liveUserInfo.nick = "haha";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType) {
        l.i("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", "anchorStartLive_" + qQLiveAnchorStreamRecordType);
        ((jg4.b) mm4.b.b(jg4.b.class)).p3(qQLiveAnchorStreamRecordType, false, new b(qQLiveAnchorStreamRecordType));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hxd, viewGroup, false);
        this.H = inflate;
        initView(inflate);
        View view = this.H;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
