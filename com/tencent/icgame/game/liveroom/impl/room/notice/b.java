package com.tencent.icgame.game.liveroom.impl.room.notice;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.ui.widget.BaseSlideUpDialog;
import com.tencent.icgame.game.ui.widget.f;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fu0.c;
import fu0.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends BaseSlideUpDialog implements View.OnClickListener, SimpleEventReceiver {
    private ImageView T;
    private ImageView U;
    private TextView V;
    private ConstraintLayout W;
    private LinearLayout X;
    private View Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f115453a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f115454b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f115455c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f115456d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SimpleEventBus.getInstance().unRegisterReceiver(b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.notice.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C5839b implements t22.a {
        C5839b() {
        }

        @Override // t22.a
        public void a(String str, boolean z16) {
            int i3;
            String str2;
            g.h("ICGame_Notice", "getRoomAnnounce success : announce == " + str + ",reviewed=" + z16);
            if (TextUtils.isEmpty(str)) {
                b.this.X.setVisibility(0);
            } else {
                b.this.X.setVisibility(8);
                b.this.V.setText(str);
                b.this.f115456d0 = str;
            }
            b bVar = b.this;
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            bVar.f115453a0 = i3;
            TextView textView = b.this.Z;
            if (z16) {
                str2 = "\u516c\u544a";
            } else {
                str2 = "\u516c\u544a(\u5ba1\u6838\u4e2d)";
            }
            textView.setText(str2);
        }

        @Override // t22.a
        public void onFail(int i3, String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "\u670d\u52a1\u5668\u8d70\u8ff7\u8def\u4e86\uff0c\u518d\u8bd5\u4e00\u4e0b";
            } else {
                str2 = str;
            }
            f.b(str2);
            g.d("ICGame_Notice", "getRoomAnnounce failed :errorCode == " + i3 + ",errorMessage == " + str);
            b.this.dismiss();
        }
    }

    public b(Context context, long j3, long j16) {
        super(context);
        this.f115453a0 = 0;
        this.f115454b0 = j3;
        this.f115455c0 = j16;
    }

    private void initView() {
        this.T = (ImageView) findViewById(R.id.f166430zt4);
        this.U = (ImageView) findViewById(R.id.f166427zt1);
        this.V = (TextView) findViewById(R.id.f166429zt3);
        this.W = (ConstraintLayout) findViewById(R.id.f166428zt2);
        this.X = (LinearLayout) findViewById(R.id.zt5);
        this.Y = findViewById(R.id.zt6);
        this.Z = (TextView) findViewById(R.id.zt7);
        this.V.setMovementMethod(LinkMovementMethod.getInstance());
        c0(this.W);
        d0(this.Y);
    }

    private void l0() {
        dismiss();
    }

    private void m0() {
        TimiNoticeEditFragment.xh(getContext(), this.f115456d0, this.f115454b0, this.f115455c0);
        dismiss();
    }

    private void n0() {
        p0();
    }

    private void o0() {
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.W.setOnClickListener(this);
        setOnDismissListener(new a());
    }

    private void p0() {
        ILiveRoomOperation A = ((c) qx0.a.b(c.class)).A(this.f115454b0);
        if (A != null) {
            A.getRoomAnnounce(this.f115454b0, new C5839b());
        }
    }

    public static void q0(Context context, long j3) {
        BaseRoomInfo q16 = ((c) qx0.a.b(c.class)).q(j3);
        e n3 = ((c) qx0.a.b(c.class)).n(j3);
        if (q16 != null && n3 != null) {
            long anchorUid = n3.getAnchorUid();
            if (j3 != 0 && anchorUid != 0) {
                new b(context, j3, anchorUid).show();
                return;
            } else {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "showDialog:\u83b7\u53d6roomId\u3001anchorId\u5931\u8d25");
                return;
            }
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "showDialog:\u8fdb\u623f\u5931\u8d25");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(UpdateNoticeEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f166430zt4) {
            int i3 = this.f115453a0;
            if (i3 == 0) {
                f.b("\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            } else if (i3 == 2) {
                f.b("\u516c\u544a\u6b63\u5728\u5ba1\u6838\uff0c\u8bf7\u7a0d\u540e\u8bbe\u7f6e");
            } else {
                m0();
            }
        } else if (view.getId() == R.id.f166427zt1) {
            l0();
        } else if (view.getId() == R.id.zt6) {
            l0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.ui.widget.BaseSlideUpDialog, com.tencent.icgame.game.ui.widget.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fbu);
        initView();
        o0();
        n0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof UpdateNoticeEvent) {
            g.h("ICGame_Notice", "onReceiveEvent : UpdateNoticeEvent");
            p0();
        }
    }
}
