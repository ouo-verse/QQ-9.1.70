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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import pl4.d;
import trpc.yes.common.GameDataServerOuterClass$CreateCODMGroupRoomRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiCodmTestFragment extends QPublicBaseFragment {
    private View C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f379228d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f379229e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f379230f;

        a(EditText editText, EditText editText2, TextView textView) {
            this.f379228d = editText;
            this.f379229e = editText2;
            this.f379230f = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TextUtils.isEmpty(this.f379228d.getText())) {
                f.c("\u8bf7\u8f93\u5165gamedata!");
            } else if (TextUtils.isEmpty(this.f379229e.getText())) {
                f.c("\u8bf7\u8f93\u5165openid!");
            } else {
                TimiCfmTestFragment.rh(this.f379229e, "TimiCodmTestFragmentopenid");
                TimiCfmTestFragment.rh(this.f379228d, "TimiCodmTestFragmentgamedata");
                String obj = this.f379229e.getText().toString();
                String obj2 = this.f379228d.getText().toString();
                try {
                    obj2 = "EnterTeam_" + obj2;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                String str = (("tencentmsdk16283://?gamedata=" + obj2 + "&OpenId=" + obj + "&openid=" + obj + "&user_openid=" + obj + "&current_uin=" + obj + "&platform=qq_m") + "&launchtype=cymini") + "&launchfrom=sq_gamecenter";
                this.f379230f.setText(str);
                nm4.a.a(str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f379232d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f379233e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f379234f;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements d<GameDataServerOuterClass$CreateCODMGroupRoomRsp> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.room.impl.test.TimiCodmTestFragment$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public class ViewOnClickListenerC9966a implements View.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f379237d;

                ViewOnClickListenerC9966a(String str) {
                    this.f379237d = str;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    f.c("\u5df2\u62f7\u8d1d\u81f3\u526a\u8d34\u677f\u548c\u4e0b\u9762\u8f93\u5165\u6846");
                    com.tencent.timi.game.utils.a.a(TimiCodmTestFragment.this.getActivity(), this.f379237d);
                    b.this.f379233e.setText(this.f379237d);
                    l.e("TimiCodmTestFragment", "print CODM rsp: " + this.f379237d);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            a() {
            }

            @Override // pl4.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameDataServerOuterClass$CreateCODMGroupRoomRsp gameDataServerOuterClass$CreateCODMGroupRoomRsp, @Nullable FromServiceMsg fromServiceMsg) {
                b.this.f379232d.setText("CODM rsp: \u521b\u5efa\u5931\u8d25, " + str2);
            }

            @Override // pl4.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(GameDataServerOuterClass$CreateCODMGroupRoomRsp gameDataServerOuterClass$CreateCODMGroupRoomRsp, FromServiceMsg fromServiceMsg) {
                if (gameDataServerOuterClass$CreateCODMGroupRoomRsp != null) {
                    String str = "{\"roomid\":\"" + gameDataServerOuterClass$CreateCODMGroupRoomRsp.group_room_id.get() + "\",\"roomguid\":\"" + gameDataServerOuterClass$CreateCODMGroupRoomRsp.group_room_guid.get() + "\",\"roomaddress\":\"" + gameDataServerOuterClass$CreateCODMGroupRoomRsp.room_svr_addr.get() + "\",\"entersource\":8}";
                    try {
                        str = URLEncoder.encode(str, "utf-8");
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                    b.this.f379232d.setText("CODM rsp:\n" + str);
                    b.this.f379233e.setText(str);
                    ViewOnClickListenerC9966a viewOnClickListenerC9966a = new ViewOnClickListenerC9966a(str);
                    b.this.f379232d.setOnClickListener(viewOnClickListenerC9966a);
                    b.this.f379234f.setOnClickListener(viewOnClickListenerC9966a);
                    l.e("TimiCodmTestFragment", "CODM rsp: " + str);
                    return;
                }
                b.this.f379232d.setText("CODM rsp: \u521b\u5efa\u6210\u529f, NULL");
            }
        }

        b(TextView textView, EditText editText, View view) {
            this.f379232d = textView;
            this.f379233e = editText;
            this.f379234f = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((g) mm4.b.b(g.class)).R1(0, new a());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initView(View view) {
        EditText editText = (EditText) view.findViewById(R.id.f781546a);
        EditText editText2 = (EditText) view.findViewById(R.id.f781846d);
        TextView textView = (TextView) view.findViewById(R.id.f94475cd);
        TimiCfmTestFragment.qh(editText2, "TimiCodmTestFragmentopenid");
        TimiCfmTestFragment.qh(editText, "TimiCodmTestFragmentgamedata");
        view.findViewById(R.id.f94425c9).setOnClickListener(new a(editText, editText2, textView));
        View findViewById = view.findViewById(R.id.thf);
        view.findViewById(R.id.thg).setOnClickListener(new b((TextView) view.findViewById(R.id.f95755fu), editText, findViewById));
    }

    public static void ph(Context context) {
        QPublicFragmentActivity.b.c(context, QPublicFragmentActivity.class, TimiCodmTestFragment.class);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hw6, viewGroup, false);
        this.C = inflate;
        initView(inflate);
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
