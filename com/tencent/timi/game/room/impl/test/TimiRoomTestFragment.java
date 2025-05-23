package com.tencent.timi.game.room.impl.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.scheme.tools.SchemeUtil;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;
import trpc.yes.common.UserProxyCmdOuterClass$TgpaNewVersionInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiRoomTestFragment extends QPublicBaseFragment {
    private View C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SchemeUtil.f((Activity) TimiRoomTestFragment.this.getContext(), om4.a.a(false, "owanlsgUUoQZDDk5WtingHGvE2d8", "tencentmsdk1104466820://", om4.a.b("1001", "1", "0", "0", "0", "20040", "1", 5, String.valueOf(System.currentTimeMillis()))), "", false);
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
            l.i("TimiRoomTestFragment", "debug TGPA start, XID = \u4e00\u671f\u6682\u65e0");
            ((ag4.i) mm4.b.b(ag4.i.class)).Q2(101);
            ((fm4.g) mm4.b.b(fm4.g.class)).j2(1L, "");
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
            l.i("TimiRoomTestFragment", "debug TGPA stop ");
            TGPAUtil.f(TimiRoomTestFragment.this.getActivity());
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
            TimiCodmTestFragment.ph(TimiRoomTestFragment.this.getActivity());
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
            TimiCfmTestFragment.ph(TimiRoomTestFragment.this.getActivity());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f379250d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f379251e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f379252f;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements pl4.d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f379254a;

            a(String str) {
                this.f379254a = str;
            }

            @Override // pl4.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable UserProxyCmdOuterClass$GetTgpaVersionInfoRsp userProxyCmdOuterClass$GetTgpaVersionInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
                i.this.f379252f.setText("TGPA rsp: \u5931\u8d25, " + str2);
            }

            @Override // pl4.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(UserProxyCmdOuterClass$GetTgpaVersionInfoRsp userProxyCmdOuterClass$GetTgpaVersionInfoRsp, FromServiceMsg fromServiceMsg) {
                UserProxyCmdOuterClass$TgpaNewVersionInfo userProxyCmdOuterClass$TgpaNewVersionInfo;
                if (userProxyCmdOuterClass$GetTgpaVersionInfoRsp != null && (userProxyCmdOuterClass$TgpaNewVersionInfo = userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info) != null && userProxyCmdOuterClass$TgpaNewVersionInfo.has()) {
                    i.this.f379252f.setText("TGPA rsp:\n cur_apk: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.cur_version_id.get() + ", new_apk: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.new_version_id.get() + "\n cur_res: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.cur_source_id.get() + ", new_res: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.new_source_id.get());
                    l.e("TimiRoomTestFragment", "getTgpaGameVersion xid: " + this.f379254a + "\ncur_apk: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.cur_version_id.get() + ", new_apk: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.new_version_id.get() + ", cur_res: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.cur_source_id.get() + ", new_res: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.new_source_id.get());
                    return;
                }
                i.this.f379252f.setText("TGPA rsp: \u6210\u529f, NULL");
            }
        }

        i(EditText editText, EditText editText2, TextView textView) {
            this.f379250d = editText;
            this.f379251e = editText2;
            this.f379252f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = this.f379250d.getText().toString();
            String obj2 = this.f379251e.getText().toString();
            if (!TextUtils.isEmpty(obj2) && !TextUtils.isEmpty(obj)) {
                ((ag4.g) mm4.b.b(ag4.g.class)).u2(obj, Integer.parseInt(obj2), true, new a(obj));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initView(View view) {
        view.findViewById(R.id.f7813469).setOnClickListener(new a());
        view.findViewById(R.id.f781646b).setOnClickListener(new b((EditText) view.findViewById(R.id.f781746c)));
        view.findViewById(R.id.f781446_).setOnClickListener(new c());
        view.findViewById(R.id.f781946e).setOnClickListener(new d());
        view.findViewById(R.id.f782046f).setOnClickListener(new e());
        view.findViewById(R.id.f7812468).setOnClickListener(new f());
        view.findViewById(R.id.yaw).setOnClickListener(new g());
        view.findViewById(R.id.yav).setOnClickListener(new h());
        EditText editText = (EditText) view.findViewById(R.id.f782446j);
        editText.setText(TGPAUtil.b());
        view.findViewById(R.id.f782246h).setOnClickListener(new i(editText, (EditText) view.findViewById(R.id.f782146g), (TextView) view.findViewById(R.id.f782346i)));
    }

    public static void ph(Context context) {
        QPublicFragmentActivity.b.c(context, QPublicFragmentActivity.class, TimiRoomTestFragment.class);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hw9, viewGroup, false);
        this.C = inflate;
        initView(inflate);
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
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
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f379240d;

        b(EditText editText) {
            this.f379240d = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long parseLong;
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = this.f379240d.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                parseLong = -1;
            } else {
                parseLong = Long.parseLong(obj);
            }
            if (parseLong <= 0) {
                com.tencent.timi.game.ui.widget.f.c("roomId\u65e0\u6548\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");
            } else {
                com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
                dVar.f379324a = parseLong;
                dVar.f379325b = 1;
                dVar.f379326c = 1;
                dVar.f379328e = 1;
                dVar.f379327d = ((fm4.g) mm4.b.b(fm4.g.class)).h2(1);
                dVar.f379329f = null;
                dVar.f379330g = 0L;
                dVar.f379331h = 0L;
                com.tencent.timi.game.room.impl.util.c cVar = new com.tencent.timi.game.room.impl.util.c();
                cVar.f379322a = 0;
                cVar.f379323b = null;
                ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, TimiRoomTestFragment.this.getActivity(), dVar, cVar, new a());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
                com.tencent.timi.game.ui.widget.f.c("DebugToast\n\u52a0\u5165\u623f\u95f4\u6210\u529f\uff0c\u8df3\u8f6c\u623f\u95f4\u9875");
                l.i("TimiRoomTestFragment", "testRoom JOIN SUCCESS - " + yoloRoomOuterClass$YoloRoomInfo);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
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
            YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
            if (z16 == null) {
                com.tencent.timi.game.ui.widget.f.c("\u672a\u5728\u5f00\u9ed1\u8f66\u961f\u5185");
            } else {
                ((fm4.g) mm4.b.b(fm4.g.class)).T2(z16.room_id.get(), true, 0, new a(), true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
                com.tencent.timi.game.ui.widget.f.c("\u9000\u623f\u6210\u529f");
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
        }
    }
}
