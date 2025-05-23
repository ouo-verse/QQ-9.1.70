package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.s;
import com.tencent.avcore.jni.data.DavPBCommonParam;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import tencent.im.s2c.msgtype0x210.submsgtype0x158.SubMsgType0x158$SharpVideoMsg;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VChatActivity extends BaseActivity {

    /* renamed from: d, reason: collision with root package name */
    public VideoAppInterface f75173d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f75174e;

    private void i0(FromServiceMsg fromServiceMsg, String str, byte[] bArr, long j3, String str2) {
        boolean z16;
        s.a f16 = com.tencent.av.s.f(bArr);
        if (f16.a()) {
            String valueOf = String.valueOf(f16.f74247h);
            String b16 = com.tencent.av.n.b(3, valueOf, new int[0]);
            SessionInfo i3 = com.tencent.av.n.e().i(b16);
            if (QLog.isColorLevel()) {
                QLog.i("VChatActivity", 2, "onCreate--onRequestVideo,  VideoPacket[" + f16 + "], session[" + i3 + "]");
            }
            if (i3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("tagSharpSvr", 2, "<-- VChatActivity cmd = " + str + " , msg_type = " + j3 + ", bodyType = " + f16.f74243d);
                }
                com.tencent.av.utils.ag.h("VChatActivity", b16, this.f75173d, f16, str2);
                Object attribute = fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF);
                if (attribute != null) {
                    com.tencent.av.r.h0().Z2(valueOf, ((Long) attribute).longValue());
                }
                int i16 = f16.f74251l;
                String c16 = com.tencent.av.utils.ag.c(f16);
                if (f16.f74248i == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                RtcNodeReportReceiverHelper.y(str2, this.f75173d.getCurrentAccountUin(), valueOf, z16, 0L);
                RtcNodeReportReceiverHelper.w(str2, 3);
                DavPBCommonParam.CommonParam commonParam = new DavPBCommonParam.CommonParam();
                commonParam.invite_scene.set(f16.f74250k);
                commonParam.invite_trace_id.set(str2);
                com.tencent.av.r.h0().M1(i16, valueOf, c16, null, z16, null, 0, f16.f74245f, commonParam);
                SessionInfo i17 = com.tencent.av.n.e().i(b16);
                if (i17 != null) {
                    i17.d(f16.f74242c);
                }
            }
        }
    }

    private void j0(FromServiceMsg fromServiceMsg, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("VChatActivity", 2, "handleC2CInviteV2 cmd: " + str);
        }
        if (fromServiceMsg != null && fromServiceMsg.getWupBuffer() != null && "SharpSvr.s2c".equalsIgnoreCase(str)) {
            try {
                SubMsgType0x158$SharpVideoMsg b16 = com.tencent.av.t.b(fromServiceMsg);
                if (b16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("VChatActivity", 2, "handleC2CInviteV2 sharpVideoMsg != null");
                    }
                    byte[] byteArray = b16.video_buff.get().toByteArray();
                    long j3 = b16.msg_type.get();
                    String str2 = b16.trace_info.trace_id.get();
                    if (TextUtils.isEmpty(str2)) {
                        QLog.e("VChatActivity", 1, "handleC2CInviteV2 empty traceId");
                    }
                    i0(fromServiceMsg, str, byteArray, j3, str2);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void k0(String str) {
        try {
            MobileQQ.sMobileQQ.getAppRuntime(str);
        } catch (AccountNotMatchException unused) {
            QLog.d("VChatActivity", 1, "AV_UIN_NOT_MATCH, MSFUIN: " + str + " AVUIN:" + LogUtil.getSafePrintUin(this.f75173d.getCurrentAccountUin()));
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("avuin", this.f75173d.getCurrentAccountUin());
            hashMap.put("msfuin", String.valueOf(str));
            StatisticCollector.getInstance(super.getApplicationContext()).collectPerformance(this.f75173d.getCurrentAccountUin(), "AV_UIN_NOT_MATCH", false, 0L, 0L, hashMap, "", true);
            if (!str.equals("0")) {
                this.f75173d.D0(str);
            }
        }
    }

    private void l0(FromServiceMsg fromServiceMsg, String str) {
        j0(fromServiceMsg, str);
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void g0(long j3, int i3) {
        QLog.w("VChatActivity", 1, "exitVideoProcess, reason[" + i3 + "], seq[" + j3 + "]");
        super.finish();
        if (com.tencent.av.r.h0() != null) {
            this.f75173d.u(j3, i3);
        }
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (super.getAppRuntime() instanceof VideoAppInterface) {
            this.f75173d = (VideoAppInterface) super.getAppRuntime();
        }
        VideoAppInterface videoAppInterface = this.f75173d;
        if (videoAppInterface == null) {
            QLog.d("VChatActivity", 1, "onCreate mApp is null! ");
            super.finish();
            return;
        }
        videoAppInterface.r0(false);
        this.f75174e = false;
        Intent intent = super.getIntent();
        String stringExtra = intent.getStringExtra("uin");
        FromServiceMsg fromServiceMsg = (FromServiceMsg) intent.getParcelableExtra("fromServiceMsg");
        if (fromServiceMsg != null) {
            str = fromServiceMsg.getServiceCmd();
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VChatActivity", 1, "onCreate fromServiceMsg =  " + fromServiceMsg + ",cmd = " + str);
        }
        if (stringExtra != null) {
            k0(stringExtra);
            l0(fromServiceMsg, str);
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QLog.d("VChatActivity", 1, "onDestroy()");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return super.onKeyDown(i3, keyEvent);
        }
        super.finish();
        long d16 = com.tencent.av.utils.e.d();
        QLog.w("VChatActivity", 1, "exit when KEYCODE_BACK, seq[" + d16 + "]");
        g0(d16, 1009);
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        QLog.d("VChatActivity", 1, "onNewIntent()");
        com.tencent.av.business.manager.report.a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        QLog.d("VChatActivity", 1, "onPause()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        QLog.d("VChatActivity", 1, "onResume()  mIsEffectiveRequest = " + this.f75174e);
        if (!this.f75174e) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        QLog.d("VChatActivity", 1, "onStop()");
        super.onStop();
    }
}
