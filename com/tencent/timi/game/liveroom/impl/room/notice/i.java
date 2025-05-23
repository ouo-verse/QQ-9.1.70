package com.tencent.timi.game.liveroom.impl.room.notice;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.sso.request.QQLiveGetAnnounceRequest;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i extends BaseSlideUpDialog implements View.OnClickListener, SimpleEventReceiver {
    private ImageView T;
    private ImageView U;
    private TextView V;
    private ConstraintLayout W;
    private LinearLayout X;
    private View Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f378152a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f378153b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f378154c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f378155d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SimpleEventBus.getInstance().unRegisterReceiver(i.this);
        }
    }

    public i(Context context, long j3, long j16) {
        super(context);
        this.f378152a0 = 0;
        this.f378153b0 = j3;
        this.f378154c0 = j16;
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
        e0(this.W);
        g0(this.Y);
    }

    private void k0() {
        dismiss();
    }

    private void l0() {
        TimiNoticeEditFragment.xh(getContext(), this.f378155d0, this.f378153b0, this.f378154c0);
        dismiss();
    }

    private void m0() {
        p0();
    }

    private void n0() {
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.W.setOnClickListener(this);
        setOnDismissListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(QQLiveResponse qQLiveResponse) {
        String str;
        int i3;
        String str2;
        xq4.c cVar = (xq4.c) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && cVar != null) {
            String str3 = cVar.f448406a;
            boolean z16 = cVar.f448407b;
            l.i("Timi_Notice", "getRoomAnnounce success : announce == " + str3 + ",reviewed=" + z16);
            if (TextUtils.isEmpty(str3)) {
                this.X.setVisibility(0);
            } else {
                this.X.setVisibility(8);
                this.V.setText(str3);
                this.f378155d0 = str3;
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f378152a0 = i3;
            TextView textView = this.Z;
            if (z16) {
                str2 = "\u516c\u544a";
            } else {
                str2 = "\u516c\u544a(\u5ba1\u6838\u4e2d)";
            }
            textView.setText(str2);
            return;
        }
        String errMsg = qQLiveResponse.getErrMsg();
        long retCode = qQLiveResponse.getRetCode();
        if (TextUtils.isEmpty(errMsg)) {
            str = "\u670d\u52a1\u5668\u8d70\u8ff7\u8def\u4e86\uff0c\u518d\u8bd5\u4e00\u4e0b";
        } else {
            str = errMsg;
        }
        com.tencent.timi.game.ui.widget.f.c(str);
        l.e("Timi_Notice", "getRoomAnnounce failed :errorCode == " + retCode + ",errorMessage == " + errMsg);
        dismiss();
    }

    private void p0() {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetAnnounceRequest(this.f378153b0), new ILiveNetRequest.Callback() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.h
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                i.this.o0(qQLiveResponse);
            }
        });
    }

    public static void q0(Context context, long j3) {
        long k3 = com.tencent.mobileqq.qqlive.sail.c.f272176a.k(j3, 1);
        if (j3 > 0 && k3 > 0) {
            new i(context, j3, k3).show();
        } else {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "showDialog:\u83b7\u53d6roomId\u3001anchorId\u5931\u8d25");
        }
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
            int i3 = this.f378152a0;
            if (i3 == 0) {
                com.tencent.timi.game.ui.widget.f.c("\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            } else if (i3 == 2) {
                com.tencent.timi.game.ui.widget.f.c("\u516c\u544a\u6b63\u5728\u5ba1\u6838\uff0c\u8bf7\u7a0d\u540e\u8bbe\u7f6e");
            } else {
                l0();
            }
        } else if (view.getId() == R.id.f166427zt1) {
            k0();
        } else if (view.getId() == R.id.zt6) {
            k0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f169122hv2);
        initView();
        n0();
        m0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof UpdateNoticeEvent) {
            l.i("Timi_Notice", "onReceiveEvent : UpdateNoticeEvent");
            p0();
        }
    }
}
