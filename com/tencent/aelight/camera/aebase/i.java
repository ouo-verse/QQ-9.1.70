package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import or.b;
import or.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends AEPituCameraUnit {

    /* renamed from: v1, reason: collision with root package name */
    private BroadcastReceiver f66037v1;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Activity activity;
            if ("tencent.video.q2v.startUploadPTV".equals(intent.getAction())) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIMWebEffectCameraCaptureUnit", 2, "receive ACTION_BLESS_UPLOAD_PTV.");
                }
                if (intent.getIntExtra("broadcastType", 1) != 1 || (activity = ((AEBaseCameraUnit) i.this).f61817h.getActivity()) == null || activity.isFinishing()) {
                    return;
                }
                activity.finish();
            }
        }
    }

    public i(or.e eVar, or.d dVar) {
        super(eVar, dVar);
        this.f66037v1 = new a();
        this.P = new or.a(10007, this.W.j(), 6);
        this.V = 5;
    }

    public static Bundle v3(boolean z16, boolean z17, int i3, boolean z18, boolean z19, boolean z26, String str, boolean z27, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt("ability_flag", (!z17 || z16) ? (z17 || !z16) ? 1 : 3 : 2);
        bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, i3);
        bundle.putBoolean(PeakConstants.ARG_BEAUTY, z18);
        bundle.putBoolean(PeakConstants.ARG_SHARP_FACE, z18);
        bundle.putBoolean(PeakConstants.ARG_SUPPORT_DD, z19);
        if (z19 && z26) {
            bundle.putString(IAECameraUnit.KEY_CURRENT_TAB, AECaptureMode.NORMAL.name);
            bundle.putString(IAECameraUnit.KEY_CURRENT_SELECT_ID, str);
        }
        bundle.putBoolean(PeakConstants.ARG_SUPPORT_FILTER, z27);
        bundle.putInt("edit_video_type", 10007);
        bundle.putInt("entrance_type", i16);
        bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
        int b16 = js.a.I.b();
        if (i16 == 107) {
            b16 = js.a.J.b();
        } else if (i16 == 108) {
            b16 = js.a.G.b();
        }
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
        return bundle;
    }

    private Bundle w3(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("dynamic_text", intent.getStringExtra("dynamic_text"));
        return bundle;
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 10007 && i16 == -1 && intent != null) {
            PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
            if (publishParam.N == 1) {
                Activity activity = this.f61817h.getActivity();
                activity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
                String str = publishParam.f69067e;
                if (QLog.isColorLevel()) {
                    QLog.d("QIMWebEffectCameraCaptureUnit", 2, "hwEncodeVideo videoMergeThumbPath =" + str);
                    QLog.d("QIMWebEffectCameraCaptureUnit", 2, "publishParam =" + publishParam.toString());
                }
                PtvFilterUtils.a(new File(publishParam.P).getParent(), publishParam.f69066d);
                activity.getIntent().putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, this.P.b() == 107 ? 15 : 32);
                activity.getIntent().putExtra(ISelectMemberActivityConstants.FAKE_ID, publishParam.f69066d);
                Bundle w3 = w3(intent);
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179557e = "0";
                j.c(activity, sessionInfo, publishParam, w3);
            }
            this.f61868u0.m();
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.video.q2v.startUploadPTV");
        this.f61817h.getActivity().registerReceiver(this.f66037v1, intentFilter);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        super.onDestroy();
        this.f61817h.getActivity().unregisterReceiver(this.f66037v1);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit
    public void n3(boolean z16) {
        if (!z16) {
            this.P.f(new c.a().k(3).f());
        } else {
            this.P.e(new b.a(this.f61819m.getSelectedCamera()).l(3).j());
        }
    }
}
