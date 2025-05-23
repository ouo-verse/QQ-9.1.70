package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.struct.editor.PublishParam;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends AEPituCameraUnit {
    public h(or.e eVar, or.d dVar) {
        super(eVar, dVar);
        this.P = new or.a(10012, 105, 11);
        this.V = 9;
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        Activity activity = this.f61817h.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (i3 == com.tencent.mobileqq.tribe.util.a.f293489a) {
            if (i16 == -1) {
                if (intent == null) {
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("result", intent.getStringExtra("result"));
                activity.setResult(-1, intent2);
            }
            activity.finish();
            return;
        }
        if (i3 == 10012 && i16 == -1) {
            PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
            Intent intent3 = new Intent();
            intent3.putExtra("thumbPath", publishParam.f69067e);
            intent3.putExtra("videoPath", publishParam.P);
            intent3.putExtra("fakeVid", publishParam.f69066d);
            intent3.putExtra("videoDoodleDescription", publishParam.f69070i);
            int intExtra = intent.getIntExtra("theme_id", -1);
            String stringExtra = intent.getStringExtra("theme_name");
            intent3.putExtra("theme_id", intExtra);
            intent3.putExtra("theme_name", stringExtra);
            com.tencent.aelight.camera.aioeditor.capture.music.g gVar = (com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8);
            if (gVar != null) {
                gVar.i();
                return;
            }
            return;
        }
        hd0.c.v("QIMTribeEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", Integer.valueOf(i3), Integer.valueOf(i16), intent);
    }
}
