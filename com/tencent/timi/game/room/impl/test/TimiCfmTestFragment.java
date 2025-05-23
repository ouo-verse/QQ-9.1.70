package com.tencent.timi.game.room.impl.test;

import ag4.g;
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
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import pl4.d;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupRoomRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiCfmTestFragment extends QPublicBaseFragment {
    private View C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f379212d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f379213e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f379214f;

        a(EditText editText, EditText editText2, TextView textView) {
            this.f379212d = editText;
            this.f379213e = editText2;
            this.f379214f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TextUtils.isEmpty(this.f379212d.getText())) {
                f.c("\u8bf7\u8f93\u5165gamedata!");
            } else if (TextUtils.isEmpty(this.f379213e.getText())) {
                f.c("\u8bf7\u8f93\u5165openid!");
            } else {
                TimiCfmTestFragment.rh(this.f379213e, "TimiCfmTestFragmentopenid");
                TimiCfmTestFragment.rh(this.f379212d, "TimiCfmTestFragmentgamedata");
                String obj = this.f379213e.getText().toString();
                String str = ("cfm://?gamedata=" + this.f379212d.getText().toString() + "&OpenId=" + obj + "&openid=" + obj + "&user_openid=" + obj + "&current_uin=" + obj + "&platform=qq_m") + "&launchtype=cymini";
                this.f379214f.setText(str);
                nm4.a.a(str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ EditText C;
        final /* synthetic */ View D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f379216d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f379217e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f379218f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ EditText f379219h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ EditText f379220i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ TextView f379221m;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements d<MessageMicro> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f379222a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f379223b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f379224c;

            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.room.impl.test.TimiCfmTestFragment$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            class ViewOnClickListenerC9965a implements View.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f379226d;

                ViewOnClickListenerC9965a(String str) {
                    this.f379226d = str;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    f.c("\u5df2\u62f7\u8d1d\u81f3\u526a\u8d34\u677f\u548c\u4e0b\u9762\u8f93\u5165\u6846");
                    com.tencent.timi.game.utils.a.a(TimiCfmTestFragment.this.getActivity(), this.f379226d);
                    b.this.C.setText(this.f379226d);
                    l.e("TimiCfmTestFragment", "print CFM rsp: " + this.f379226d);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            a(boolean z16, int i3, long j3) {
                this.f379222a = z16;
                this.f379223b = i3;
                this.f379224c = j3;
            }

            @Override // pl4.d
            public void a(MessageMicro messageMicro, FromServiceMsg fromServiceMsg) {
                String str;
                String str2;
                if (messageMicro != null) {
                    int i3 = !this.f379222a ? 1 : 0;
                    if (messageMicro instanceof GameDataServerOuterClass$CreateCFMGroupRoomRsp) {
                        GameDataServerOuterClass$CreateCFMGroupRoomRsp gameDataServerOuterClass$CreateCFMGroupRoomRsp = (GameDataServerOuterClass$CreateCFMGroupRoomRsp) messageMicro;
                        str = gameDataServerOuterClass$CreateCFMGroupRoomRsp.cfm_room_id.get();
                        str2 = gameDataServerOuterClass$CreateCFMGroupRoomRsp.cfm_trans_svr_id.get();
                    } else {
                        str = "0";
                        str2 = "0";
                    }
                    String str3 = "yes_" + i3 + "_" + str + "_" + this.f379223b + "_" + this.f379224c + "_" + str2;
                    b.this.f379221m.setText("CFM rsp:\n" + str3);
                    b.this.C.setText(str3);
                    ViewOnClickListenerC9965a viewOnClickListenerC9965a = new ViewOnClickListenerC9965a(str3);
                    b.this.f379221m.setOnClickListener(viewOnClickListenerC9965a);
                    b.this.D.setOnClickListener(viewOnClickListenerC9965a);
                    l.e("TimiCfmTestFragment", "CFM rsp: " + str3);
                    return;
                }
                b.this.f379221m.setText("CFM rsp: \u521b\u5efa\u6210\u529f, NULL");
            }

            @Override // pl4.d
            public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable MessageMicro messageMicro, @Nullable FromServiceMsg fromServiceMsg) {
                b.this.f379221m.setText("CFM rsp: \u521b\u5efa\u5931\u8d25, " + str2);
            }
        }

        b(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, TextView textView, EditText editText6, View view) {
            this.f379216d = editText;
            this.f379217e = editText2;
            this.f379218f = editText3;
            this.f379219h = editText4;
            this.f379220i = editText5;
            this.f379221m = textView;
            this.C = editText6;
            this.D = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TimiCfmTestFragment.rh(this.f379216d, "TimiCfmTestFragmentyesroomid");
            TimiCfmTestFragment.rh(this.f379217e, "TimiCfmTestFragmenthostuid");
            try {
                int parseInt = Integer.parseInt(this.f379218f.getText().toString());
                int parseInt2 = Integer.parseInt(this.f379219h.getText().toString());
                int parseInt3 = Integer.parseInt(this.f379216d.getText().toString());
                boolean equals = "1".equals(this.f379220i.getText().toString());
                ((g) mm4.b.b(g.class)).C0(equals, parseInt3, parseInt2, parseInt, "testName", new a(equals, parseInt2, Long.parseLong(this.f379217e.getText().toString())));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initView(View view) {
        EditText editText = (EditText) view.findViewById(R.id.f781546a);
        EditText editText2 = (EditText) view.findViewById(R.id.f781846d);
        TextView textView = (TextView) view.findViewById(R.id.f94475cd);
        qh(editText2, "TimiCfmTestFragmentopenid");
        qh(editText, "TimiCfmTestFragmentgamedata");
        view.findViewById(R.id.f94425c9).setOnClickListener(new a(editText, editText2, textView));
        View findViewById = view.findViewById(R.id.thf);
        TextView textView2 = (TextView) view.findViewById(R.id.f95755fu);
        EditText editText3 = (EditText) view.findViewById(R.id.uam);
        EditText editText4 = (EditText) view.findViewById(R.id.uan);
        EditText editText5 = (EditText) view.findViewById(R.id.ual);
        EditText editText6 = (EditText) view.findViewById(R.id.uao);
        EditText editText7 = (EditText) view.findViewById(R.id.uak);
        qh(editText6, "TimiCfmTestFragmentyesroomid");
        qh(editText7, "TimiCfmTestFragmenthostuid");
        view.findViewById(R.id.thg).setOnClickListener(new b(editText6, editText7, editText4, editText5, editText3, textView2, editText, findViewById));
    }

    public static void ph(Context context) {
        QPublicFragmentActivity.b.c(context, QPublicFragmentActivity.class, TimiCfmTestFragment.class);
    }

    public static void qh(EditText editText, String str) {
        String f16 = rm4.a.f(str, "");
        if (!TextUtils.isEmpty(f16)) {
            editText.setText(f16);
        }
    }

    public static void rh(EditText editText, String str) {
        String obj;
        if (TextUtils.isEmpty(editText.getText())) {
            obj = "";
        } else {
            obj = editText.getText().toString();
        }
        rm4.a.k(str, obj);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hw5, viewGroup, false);
        this.C = inflate;
        initView(inflate);
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
