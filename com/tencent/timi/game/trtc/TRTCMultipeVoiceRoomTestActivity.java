package com.tencent.timi.game.trtc;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TRTCMultipeVoiceRoomTestActivity extends TimiGameBaseActivity {

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.timi.game.trtc.roomservice.multipevoiceroom.f f379977c0;

    /* renamed from: d0, reason: collision with root package name */
    private EditText f379978d0;

    /* renamed from: e0, reason: collision with root package name */
    private EditText f379979e0;

    /* renamed from: f0, reason: collision with root package name */
    private Button f379980f0;

    /* renamed from: g0, reason: collision with root package name */
    private Button f379981g0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f379982h0;

    /* renamed from: i0, reason: collision with root package name */
    private Button f379983i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f379984j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f379985k0;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TRTCMultipeVoiceRoomTestActivity.this.f379977c0.n(TRTCMultipeVoiceRoomTestActivity.this.N2());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e j3 = TRTCMultipeVoiceRoomTestActivity.this.f379977c0.j(TRTCMultipeVoiceRoomTestActivity.this.N2());
            if (j3 != null) {
                if (j3.o()) {
                    TRTCMultipeVoiceRoomTestActivity.this.f379977c0.h(TRTCMultipeVoiceRoomTestActivity.this.N2());
                } else {
                    TRTCMultipeVoiceRoomTestActivity.this.f379977c0.b(TRTCMultipeVoiceRoomTestActivity.this.N2());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e j3 = TRTCMultipeVoiceRoomTestActivity.this.f379977c0.j(TRTCMultipeVoiceRoomTestActivity.this.N2());
            if (j3 != null) {
                if (j3.p()) {
                    TRTCMultipeVoiceRoomTestActivity.this.f379977c0.c(TRTCMultipeVoiceRoomTestActivity.this.N2());
                } else {
                    TRTCMultipeVoiceRoomTestActivity.this.f379977c0.k(TRTCMultipeVoiceRoomTestActivity.this.N2());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements Observer<ConcurrentHashMap<String, com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ConcurrentHashMap<String, com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e> concurrentHashMap) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u623f\u95f4\n");
            Iterator<com.tencent.timi.game.trtc.roomservice.multipevoiceroom.e> it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString() + "\n");
            }
            TRTCMultipeVoiceRoomTestActivity.this.f379984j0.setText(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements Observer<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> concurrentHashMap) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, ConcurrentHashMap<String, Integer>> entry : concurrentHashMap.entrySet()) {
                sb5.append("\u3010\u623f\u95f4\u3011" + entry.getKey() + "\n");
                for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                    sb5.append("User:" + entry2.getKey() + " Volume:" + entry2.getValue() + "\n");
                }
            }
            TRTCMultipeVoiceRoomTestActivity.this.f379985k0.setText(sb5.toString());
        }
    }

    private void M2() {
        TimiGameQQTrtcUtil.h(new TimiGameQQTrtcUtil.b() { // from class: com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.7
            @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.b
            public void onError(final int i3, String str) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16 = i3;
                        if (i16 == -2) {
                            QQToast.makeText(TRTCMultipeVoiceRoomTestActivity.this, "\u8bf7\u9000\u51fa\u8be5\u4e1a\u52a1\u540e\u91cd\u8bd5", 1).show();
                        } else if (i16 == -1) {
                            QQToast.makeText(TRTCMultipeVoiceRoomTestActivity.this, "\u4e1a\u52a1\u6240\u9700\u7ec4\u4ef6\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 1).show();
                        } else if (i16 == -3) {
                            QQToast.makeText(TRTCMultipeVoiceRoomTestActivity.this, "\u7528\u6237\u6743\u9650\u6821\u9a8c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 1).show();
                        }
                        TRTCMultipeVoiceRoomTestActivity.this.doOnDestroy();
                    }
                });
            }

            @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.b
            public void onSuccess() {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(TRTCMultipeVoiceRoomTestActivity.this, "\u83b7\u53d6\u624bQTrtc\u4e1a\u52a1\u6210\u529f", 1).show();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N2() {
        return this.f379978d0.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P2() {
        return this.f379979e0.getText().toString();
    }

    private void Q2() {
        this.f379977c0.f380035a.observeForever(new e());
        this.f379977c0.f380036b.observeForever(new f());
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        M2();
        setContentView(R.layout.hvj);
        this.f379977c0 = com.tencent.timi.game.trtc.roomservice.multipevoiceroom.f.u();
        this.f379978d0 = (EditText) findViewById(R.id.f779945v);
        this.f379979e0 = (EditText) findViewById(R.id.f114926un);
        this.f379980f0 = (Button) findViewById(R.id.uvo);
        this.f379981g0 = (Button) findViewById(R.id.uxt);
        this.f379982h0 = (Button) findViewById(R.id.f166252z63);
        this.f379983i0 = (Button) findViewById(R.id.f87154tl);
        this.f379984j0 = (TextView) findViewById(R.id.yw5);
        this.f379985k0 = (TextView) findViewById(R.id.f780345z);
        Q2();
        this.f379980f0.setOnClickListener(new a());
        this.f379981g0.setOnClickListener(new b());
        this.f379982h0.setOnClickListener(new c());
        this.f379983i0.setOnClickListener(new d());
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        TimiGameQQTrtcUtil.c();
        super.doOnDestroy();
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TRTCMultipeVoiceRoomTestActivity.this.f379977c0.a(TRTCMultipeVoiceRoomTestActivity.this.N2(), TRTCMultipeVoiceRoomTestActivity.this.P2(), null, 3, new C9985a());
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.trtc.TRTCMultipeVoiceRoomTestActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C9985a implements com.tencent.timi.game.trtc.roomservice.multipevoiceroom.c {
            C9985a() {
            }

            @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.c
            public void a(String str, boolean z16) {
            }
        }
    }
}
