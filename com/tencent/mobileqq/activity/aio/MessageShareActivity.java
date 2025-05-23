package com.tencent.mobileqq.activity.aio;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageShareActivity extends BaseActivity implements Runnable, Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    protected Dialog f178164a0;

    /* renamed from: b0, reason: collision with root package name */
    protected final MqqHandler f178165b0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: c0, reason: collision with root package name */
    protected Bundle f178166c0 = null;

    private boolean G2(AbsStructMsg absStructMsg) {
        if (11 != this.f178166c0.getInt("forward_type", -1)) {
            return false;
        }
        return ForwardUtils.O(absStructMsg);
    }

    private void H2(List<ResultRecord> list, Intent intent, AbsStructMsg absStructMsg) {
        if (G2(absStructMsg)) {
            QLog.d("MessageShareActivity", 1, "onSDKShareEnd sdkLocalShare");
            ForwardUtils.k0(list, null, this, intent.getStringExtra(AppConstants.Key.SHARE_MSG_INPUT_VALUE));
            intent.putExtra("sdk_mult_share", true);
            intent.putExtra("sdk_mult_share_for_local", true);
            intent.putExtra("open_chatfragment", false);
            intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            startActivity(intent);
        }
    }

    protected void F2() {
        if (this.f178166c0 != null) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        Dialog dialog = this.f178164a0;
        if (dialog != null) {
            dialog.dismiss();
            this.f178164a0 = null;
        }
        super.doOnDestroy();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Intent m3;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    finish();
                }
            } else {
                ((TextView) this.f178164a0.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(HardCodeUtil.qqStr(R.string.o3i));
                this.f178164a0.findViewById(R.id.f166511fq3).setVisibility(4);
                this.f178165b0.sendEmptyMessageDelayed(3, 800L);
            }
        } else {
            int i16 = this.f178166c0.getInt("forward_type", -1);
            if (i16 == 2 || i16 == 11) {
                long j3 = this.f178166c0.getLong("req_share_id");
                String string = this.f178166c0.getString("pkg_name");
                String string2 = this.f178166c0.getString("detail_url");
                this.f178166c0.putBoolean("isBack2Root", false);
                this.f178166c0.putLong(AppConstants.Key.SHARE_RES_ID, j3);
                this.f178166c0.putString(AppConstants.Key.SHARE_RES_PKG_NAME, string);
                this.f178166c0.putString(AppConstants.Key.SHARE_RES_DETAIL_URL, string2);
                QLog.d("MessageShareActivity", 1, "-->handleMessage--appid = ", Long.valueOf(j3), ", pkgNmae = ", string);
                Intent aliasIntent = SplashActivity.getAliasIntent(this);
                aliasIntent.putExtra("k_from_login", true);
                final String string3 = this.f178166c0.getString("uin");
                final int i17 = this.f178166c0.getInt("uintype");
                long j16 = this.f178166c0.getLong("req_share_id");
                final ArrayList parcelableArrayList = this.f178166c0.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
                if (i16 == 11) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j16), "shareToQQ")));
                    intent.setPackage(string);
                    aliasIntent.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT, PendingIntent.getActivity(this, 0, intent, 335544320));
                    String string4 = this.f178166c0.getString("video_url");
                    String string5 = this.f178166c0.getString("detail_url");
                    if (!TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string5)) {
                        String b16 = com.tencent.mobileqq.structmsg.d.b(string5);
                        if (!TextUtils.isEmpty(b16)) {
                            ReportController.o(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, com.tencent.mobileqq.structmsg.d.d(i17) + "", "", b16, "");
                        }
                    }
                }
                final AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(this.f178166c0);
                if (e16 != null && this.app != null) {
                    if (e16 instanceof StructMsgForImageShare) {
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.MessageShareActivity.1
                            @Override // java.lang.Runnable
                            public void run() {
                                List list = parcelableArrayList;
                                if (list != null && !list.isEmpty()) {
                                    for (ResultRecord resultRecord : parcelableArrayList) {
                                        StructMsgForImageShare.sendAndUploadImageShare(MessageShareActivity.this.app, (StructMsgForImageShare) e16, resultRecord.uin, resultRecord.getUinType(), null, 0);
                                    }
                                    return;
                                }
                                StructMsgForImageShare.sendAndUploadImageShare(MessageShareActivity.this.app, (StructMsgForImageShare) e16, string3, i17, null, 0);
                            }
                        }, 8, null, false);
                    } else if (i16 == 11) {
                        this.f178166c0.putBoolean(AppConstants.Key.SHARE_SEND_MSG_BY_SERVER, true);
                    } else if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                        for (ResultRecord resultRecord : parcelableArrayList) {
                            AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg) e16, resultRecord.uin, resultRecord.getUinType(), resultRecord.groupUin);
                        }
                    } else {
                        AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg) e16, string3, i17, this.f178166c0.getString("troop_uin"));
                    }
                    aliasIntent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
                    if (!this.f178166c0.getBoolean("share_from_aio", false)) {
                        m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
                        this.f178166c0.remove("share_from_aio");
                    } else {
                        m3 = BaseAIOUtils.m(aliasIntent, null);
                        m3.putExtra("share_from_aio", true);
                    }
                    m3.putExtras(this.f178166c0);
                    if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                        H2(parcelableArrayList, m3, e16);
                    } else {
                        startActivity(m3);
                    }
                }
                finish();
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(new View(this));
        ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
        this.f178164a0 = reportDialog;
        reportDialog.setCancelable(false);
        this.f178164a0.setContentView(R.layout.f168383uh);
        ((TextView) this.f178164a0.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.cuv);
        Bundle extras = getIntent().getExtras();
        this.f178166c0 = extras;
        if (extras != null) {
            try {
                handleMessage(this.f178165b0.obtainMessage(1));
                return;
            } catch (IllegalArgumentException e16) {
                QLog.e("MessageShareActivity", 1, e16, new Object[0]);
                AppSetting.r();
                return;
            }
        }
        QLog.d("MessageShareActivity", 1, "getExtras() is null !!!!!");
        this.f178164a0.show();
        handleMessage(this.f178165b0.obtainMessage(2));
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            F2();
            this.f178165b0.sendEmptyMessageDelayed(1, 333L);
        } catch (Exception e16) {
            QLog.e("MessageShareActivity", 1, "doShare() cause exception !!!!!", e16);
            this.f178165b0.sendEmptyMessageDelayed(2, 333L);
        }
    }
}
