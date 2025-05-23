package cooperation.photoplus;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.sticker.Sticker;
import eipc.EIPCResult;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;

/* loaded from: classes28.dex */
public class PhotoPlusModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static PhotoPlusModule f390162d;

    PhotoPlusModule() {
        super("PhotoPlusModule");
    }

    public static PhotoPlusModule b() {
        if (f390162d == null) {
            synchronized (PhotoPlusModule.class) {
                if (f390162d == null) {
                    f390162d = new PhotoPlusModule();
                }
            }
        }
        return f390162d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PhotoPlusModule", 2, "[onCall] action = " + str + ", params = " + bundle + ", callbackId=" + i3);
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!QQAppInterface.class.isInstance(runtime)) {
            if (QLog.isColorLevel()) {
                QLog.e("PhotoPlusModule", 2, "[onCall] get app failed.");
            }
            return null;
        }
        final PhotoPlusManager photoPlusManager = (PhotoPlusManager) runtime.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER);
        if ("action_get_sticker_templates".equals(str)) {
            photoPlusManager.h(true);
            ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.photoplus.PhotoPlusModule.1
                @Override // java.lang.Runnable
                public void run() {
                    List<Sticker> d16 = photoPlusManager.d();
                    JSONArray jSONArray = new JSONArray();
                    if (d16 != null) {
                        for (Sticker sticker : d16) {
                            if (sticker.toJsonObject() != null) {
                                jSONArray.mo162put(sticker.toJsonObject());
                            }
                        }
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("param_sticker_templates", jSONArray.toString());
                    PhotoPlusModule.this.callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
                }
            }, null, true);
        } else if ("action_exit_sticker".equals(str)) {
            photoPlusManager.h(false);
        } else if ("action_jump_to_shortvideo".equals(str)) {
            photoPlusManager.i(true);
        }
        return null;
    }
}
