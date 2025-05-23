package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import fr.f;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends fr.e {

    /* renamed from: e, reason: collision with root package name */
    public static final File f66861e = new File(QIMFileUtils.a(), "dov_doodle_sticker");

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DoodleEmojiItem> f66862d;

    private ArrayList<DoodleEmojiItem> g(String str) {
        ArrayList<DoodleEmojiItem> arrayList = new ArrayList<>(4);
        try {
            boolean i3 = i();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("category");
            arrayList.ensureCapacity(jSONArray.length());
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                DoodleEmojiItem doodleEmojiItemFromJsonObj = DoodleEmojiItem.getDoodleEmojiItemFromJsonObj(jSONArray.getJSONObject(i16));
                if (doodleEmojiItemFromJsonObj != null && (!"1000".equals(doodleEmojiItemFromJsonObj.pack_id) || !i3)) {
                    arrayList.add(doodleEmojiItemFromJsonObj);
                }
            }
            return arrayList;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QIMPasterConfigManager", 2, QLog.getStackTraceString(e16));
            }
            return arrayList;
        }
    }

    private boolean i() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return ((IFeatureRuntimeService) runtime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("forbid_sticker_favorite_emotion_tab", false);
        }
        return false;
    }

    public static boolean j() {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        StringBuilder sb5 = new StringBuilder();
        File file = f66861e;
        sb5.append(file);
        String str = File.separator;
        sb5.append(str);
        sb5.append(String.format("doodle_sticker_config_%s.cfg", account));
        boolean exists = new File(sb5.toString()).exists();
        if (QLog.isColorLevel()) {
            QLog.i("QIMPasterConfigManager", 2, "QIMPasterConfigManager isStickerConfigFile with uin exist? " + exists);
        }
        if (!exists) {
            exists = new File(file + str + "doodle_sticker_config.cfg").exists();
        }
        if (QLog.isColorLevel()) {
            QLog.i("QIMPasterConfigManager", 2, "QIMPasterConfigManager isStickerConfigFileExist=" + exists);
        }
        return exists;
    }

    @Override // fr.e
    public void e() {
        f();
    }

    public ArrayList<DoodleEmojiItem> f() {
        if (this.f66862d == null) {
            synchronized (this) {
                if (this.f66862d == null) {
                    String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                    File file = f66861e;
                    boolean z16 = true;
                    String b16 = QIMFileUtils.b(file, String.format("doodle_sticker_config_%s.cfg", account));
                    if (TextUtils.isEmpty(b16)) {
                        b16 = QIMFileUtils.b(file, "doodle_sticker_config.cfg");
                    }
                    if (!TextUtils.isEmpty(b16)) {
                        this.f66862d = g(b16);
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("initStickerConfigFromCache result:");
                        sb5.append(this.f66862d != null);
                        QLog.i("QIMPasterConfigManager", 2, sb5.toString());
                    }
                    ArrayList<DoodleEmojiItem> arrayList = this.f66862d;
                    if (arrayList == null || arrayList.size() == 0) {
                        this.f66862d = g(QIMFileUtils.c("doodle_sticker.cfg"));
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("initStickerConfigFromAssets result:");
                            if (this.f66862d == null) {
                                z16 = false;
                            }
                            sb6.append(z16);
                            QLog.i("QIMPasterConfigManager", 2, sb6.toString());
                        }
                    }
                }
            }
        }
        return this.f66862d;
    }

    public void h(String str) {
        ArrayList<DoodleEmojiItem> g16 = g(str);
        if (g16 == null || g16.isEmpty()) {
            return;
        }
        this.f66862d = g16;
        CopyOnWriteArrayList<hr.a> copyOnWriteArrayList = ((PasterDataManager) f.d().g(4)).F;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        ((wr.a) f.c(14)).q(this.f66862d);
        c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 4, true, null);
        if (QLog.isColorLevel()) {
            QLog.i("QIMPasterConfigManager", 2, "paster config send notify");
        }
        QIMFileUtils.d(f66861e, String.format("doodle_sticker_config_%s.cfg", BaseApplicationImpl.getApplication().getRuntime().getAccount()), str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("paster config handleConfig");
        sb5.append(str);
        sb5.append(" result:");
        sb5.append(this.f66862d != null);
        QLog.i("QIMPasterConfigManager", 2, sb5.toString());
    }

    @Override // fr.e
    public void d() {
    }
}
