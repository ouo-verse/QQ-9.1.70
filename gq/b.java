package gq;

import android.os.Bundle;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLaunchServer;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends QIPCModule {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static b f403052a = new b();
    }

    b() {
        super(IAECameraLaunchServer.NAME);
    }

    public static b b() {
        return a.f403052a;
    }

    private void c(Bundle bundle) {
        js.a aVar = js.a.f410904d;
        int i3 = bundle.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        if (i3 == aVar.b()) {
            bundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
        }
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, i3);
        bundle.putInt("ability_flag", 2);
        bundle.putInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, 3);
        bundle.putBoolean(AECameraConstants.KEY_DISABLE_FACE_DETECT, true);
        c.q(MobileQQ.sMobileQQ, bundle);
    }

    private void d(Bundle bundle) {
        js.a aVar = js.a.f410904d;
        int i3 = bundle.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        if (i3 == aVar.b()) {
            bundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
        }
        bundle.putInt(AECameraConstants.AECAMERA_MODE, 200);
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, i3);
        bundle.putString(IAECameraUnit.KEY_CURRENT_SELECT_ID, bundle.getString(IAECameraUnit.WIDGET_NAME));
        bundle.putInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, -2);
        bundle.putInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, -2);
        c.q(MobileQQ.sMobileQQ, bundle);
    }

    private void e(Bundle bundle) {
        js.a aVar = js.a.f410904d;
        int i3 = bundle.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        if (i3 == aVar.b()) {
            bundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
        }
        bundle.putInt(AECameraConstants.AECAMERA_MODE, 200);
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, i3);
        bundle.putString(IAECameraUnit.KEY_CURRENT_SELECT_ID, bundle.getString(IAECameraUnit.WIDGET_NAME));
        c.q(MobileQQ.sMobileQQ, bundle);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        QLog.i(IAECameraLaunchServer.NAME, 1, "onCall. action=" + str);
        if (MobileQQ.sMobileQQ != null) {
            if (IAECameraLaunchServer.ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN.equals(str)) {
                e(bundle);
                return null;
            }
            if (IAECameraLaunchServer.ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY.equals(str)) {
                d(bundle);
                return null;
            }
            if (!IAECameraLaunchServer.ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP.equals(str)) {
                return null;
            }
            c(bundle);
            return null;
        }
        QLog.e(IAECameraLaunchServer.NAME, 1, "no mobile qq.");
        return null;
    }
}
