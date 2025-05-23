package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelChildIpcModule;
import com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements IEmojiListenerManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static b f204726d;

    /* renamed from: a, reason: collision with root package name */
    CopyOnWriteArrayList<WeakReference<EmoticonPackageChangedListener>> f204727a;

    /* renamed from: b, reason: collision with root package name */
    CopyOnWriteArrayList<WeakReference<EmoticonPackageDownloadListener>> f204728b;

    /* renamed from: c, reason: collision with root package name */
    CopyOnWriteArrayList<WeakReference<EmotionJsonDownloadListener>> f204729c;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f204727a = new CopyOnWriteArrayList<>();
        this.f204728b = new CopyOnWriteArrayList<>();
        this.f204729c = new CopyOnWriteArrayList<>();
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (f204726d == null) {
                f204726d = new b();
            }
            bVar = f204726d;
        }
        return bVar;
    }

    public void a(EmoticonPackageChangedListener emoticonPackageChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonPackageChangedListener);
            return;
        }
        if (emoticonPackageChangedListener == null) {
            return;
        }
        synchronized (this.f204727a) {
            Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
            while (it.hasNext()) {
                if (it.next().get() == emoticonPackageChangedListener) {
                    return;
                }
            }
            this.f204727a.add(new WeakReference<>(emoticonPackageChangedListener));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener emoticonPackageDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackageDownloadListener);
            return;
        }
        if (emoticonPackageDownloadListener == null) {
            return;
        }
        synchronized (this.f204728b) {
            Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
            while (it.hasNext()) {
                if (it.next().get() == emoticonPackageDownloadListener) {
                    return;
                }
            }
            this.f204728b.add(new WeakReference<>(emoticonPackageDownloadListener));
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void addEmotionJsonDownloadListener(EmotionJsonDownloadListener emotionJsonDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emotionJsonDownloadListener);
            return;
        }
        if (emotionJsonDownloadListener == null) {
            return;
        }
        synchronized (this.f204729c) {
            Iterator<WeakReference<EmotionJsonDownloadListener>> it = this.f204729c.iterator();
            while (it.hasNext()) {
                if (it.next().get() == emotionJsonDownloadListener) {
                    return;
                }
            }
            this.f204729c.add(new WeakReference<>(emotionJsonDownloadListener));
        }
    }

    public void c(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) emoticonPackage, i3);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        CopyOnWriteArrayList<WeakReference<EmoticonPackageDownloadListener>> copyOnWriteArrayList = this.f204728b;
        if (copyOnWriteArrayList != null) {
            Iterator<WeakReference<EmoticonPackageDownloadListener>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                EmoticonPackageDownloadListener emoticonPackageDownloadListener = it.next().get();
                if (emoticonPackageDownloadListener != null) {
                    emoticonPackageDownloadListener.onJsonComplete(emoticonPackage, i3);
                }
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_emoticonjson");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_TWO, i3);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    public void d(EmoticonPackage emoticonPackage) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        if (EmotionUtils.b()) {
            if (emoticonPackage.type == 1) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", i3);
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packageadded_one");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
        Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
        while (it.hasNext()) {
            EmoticonPackageChangedListener emoticonPackageChangedListener = it.next().get();
            if (emoticonPackageChangedListener != null) {
                emoticonPackageChangedListener.onPackageAdded(emoticonPackage);
            }
        }
    }

    public void e(EmoticonPackage emoticonPackage, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) emoticonPackage, (Object) appInterface);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        d(emoticonPackage);
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
        sharedPreferences.edit().putString("LAST_ADD_EMO_PACKAGE", sharedPreferences.getString("LAST_ADD_EMO_PACKAGE", "") + "|" + emoticonPackage.epId).commit();
        if (3 == emoticonPackage.jobType) {
            sharedPreferences.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packageadded");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
        while (it.hasNext()) {
            EmoticonPackageChangedListener emoticonPackageChangedListener = it.next().get();
            if (emoticonPackageChangedListener != null) {
                emoticonPackageChangedListener.onPackageDataListUpdate();
            }
        }
    }

    public void g(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
        while (it.hasNext()) {
            EmoticonPackageChangedListener emoticonPackageChangedListener = it.next().get();
            if (emoticonPackageChangedListener != null) {
                emoticonPackageChangedListener.onPackageDeleted(emoticonPackage);
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packagedeleted");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    public void h(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
        while (it.hasNext()) {
            EmoticonPackageChangedListener emoticonPackageChangedListener = it.next().get();
            if (emoticonPackageChangedListener != null) {
                emoticonPackageChangedListener.onPackageMoved(i3, i16);
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packagemoved");
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, i3);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_TWO, i16);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
        while (it.hasNext()) {
            EmoticonPackageChangedListener emoticonPackageChangedListener = it.next().get();
            if (emoticonPackageChangedListener != null) {
                emoticonPackageChangedListener.onPackageSetBottom();
            }
        }
    }

    public void j(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, emoticonPackage, Integer.valueOf(i3), bundle);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        CopyOnWriteArrayList<WeakReference<EmotionJsonDownloadListener>> copyOnWriteArrayList = this.f204729c;
        if (copyOnWriteArrayList != null) {
            Iterator<WeakReference<EmotionJsonDownloadListener>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                EmotionJsonDownloadListener emotionJsonDownloadListener = it.next().get();
                if (emotionJsonDownloadListener != null) {
                    emotionJsonDownloadListener.onJsonComplete(emoticonPackage, i3, bundle);
                }
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_loadend");
            bundle2.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            bundle2.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_TWO, i3);
            bundle2.putBundle(EmoticonMainPanelChildIpcModule.PARAMTER_THREE, bundle);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle2);
        }
    }

    public void k(EmoticonPackage emoticonPackage, int i3, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, emoticonPackage, Integer.valueOf(i3), appInterface);
        } else {
            notifyPackageFail(emoticonPackage, -1, i3, appInterface);
        }
    }

    public void l(EmoticonPackage emoticonPackage) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (EmotionUtils.b()) {
            if (emoticonPackage.type == 1) {
                i3 = 5;
            } else {
                i3 = 4;
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("0", i3);
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packagesucc");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
        synchronized (this.f204728b) {
            Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
            while (it.hasNext()) {
                EmoticonPackageDownloadListener emoticonPackageDownloadListener = it.next().get();
                if (emoticonPackageDownloadListener != null) {
                    emoticonPackageDownloadListener.onPackageEnd(emoticonPackage, 0);
                }
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        synchronized (this.f204727a) {
            this.f204727a.clear();
        }
        synchronized (this.f204728b) {
            this.f204728b.clear();
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_destory");
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    public void n(EmoticonPackageChangedListener emoticonPackageChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticonPackageChangedListener);
            return;
        }
        if (emoticonPackageChangedListener == null) {
            return;
        }
        Iterator<WeakReference<EmoticonPackageChangedListener>> it = this.f204727a.iterator();
        while (it.hasNext()) {
            WeakReference<EmoticonPackageChangedListener> next = it.next();
            if (next.get() == emoticonPackageChangedListener) {
                this.f204727a.remove(next);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void notifyEmoticonCoverListener(EmoticonPackage emoticonPackage, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        CopyOnWriteArrayList<WeakReference<EmoticonPackageDownloadListener>> copyOnWriteArrayList = this.f204728b;
        if (copyOnWriteArrayList != null) {
            if (i16 != 0) {
                i18 = i17;
            }
            synchronized (copyOnWriteArrayList) {
                Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
                while (it.hasNext()) {
                    EmoticonPackageDownloadListener emoticonPackageDownloadListener = it.next().get();
                    if (emoticonPackageDownloadListener != null) {
                        emoticonPackageDownloadListener.onCoverComplete(emoticonPackage, i3, i18);
                    }
                }
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_emoticoncover");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_TWO, i3);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_THREE, i16);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_FOUR, i17);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void notifyPackageFail(EmoticonPackage emoticonPackage, int i3, int i16, AppInterface appInterface) {
        String str;
        int i17;
        AppInterface appInterface2;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16), appInterface);
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        if (EmotionUtils.b()) {
            if (appInterface == null) {
                return;
            }
            if (emoticonPackage.status != 2 || !com.tencent.mobileqq.core.util.a.h(emoticonPackage.updateFlag)) {
                str = "";
                i17 = 5;
                appInterface2 = appInterface;
                emoticonPackage.status = 0;
            } else {
                str = "";
                i17 = 5;
                appInterface2 = appInterface;
                ReportController.o(appInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, emoticonPackage.epId, "" + emoticonPackage.localVersion, "" + emoticonPackage.latestVersion, "");
            }
            if (i3 != 19 && i3 != 20) {
                hd0.c.g("EmojiListenerManager", "notifyPackageFail ep.id=" + emoticonPackage.epId + " error: " + i3);
                ((IEmoticonManagerService) appInterface2.getRuntimeService(IEmoticonManagerService.class, str)).saveEmoticonPackage(emoticonPackage);
            }
            if (emoticonPackage.type == 1) {
                i18 = i17;
            } else {
                i18 = 4;
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(i16), i18);
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packagefail");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_TWO, i3);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_THREE, i16);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
        Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
        while (it.hasNext()) {
            EmoticonPackageDownloadListener emoticonPackageDownloadListener = it.next().get();
            if (emoticonPackageDownloadListener != null) {
                emoticonPackageDownloadListener.onPackageEnd(emoticonPackage, i16);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void notifyPackageProgress(EmoticonPackage emoticonPackage, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (emoticonPackage == null) {
            return;
        }
        synchronized (this.f204728b) {
            Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
            while (it.hasNext()) {
                EmoticonPackageDownloadListener emoticonPackageDownloadListener = it.next().get();
                if (emoticonPackageDownloadListener != null) {
                    emoticonPackageDownloadListener.onPackageProgress(emoticonPackage, i3, i16);
                }
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_package_progress");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_TWO, i3);
            bundle.putInt(EmoticonMainPanelChildIpcModule.PARAMTER_THREE, i16);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void notifyPackageStart(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) emoticonPackage);
            return;
        }
        Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
        while (it.hasNext()) {
            EmoticonPackageDownloadListener emoticonPackageDownloadListener = it.next().get();
            if (emoticonPackageDownloadListener != null) {
                emoticonPackageDownloadListener.onPackageStart(emoticonPackage);
            }
        }
        if (EmotionUtils.b()) {
            Bundle bundle = new Bundle();
            bundle.putString(EmoticonMainPanelChildIpcModule.NAME, "emojilistener_packagestart");
            bundle.putSerializable(EmoticonMainPanelChildIpcModule.PARAMTER_ONE, emoticonPackage);
            EmoticonMainPanelIpcModule.getInstance().postChildIPCBundle(bundle);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener emoticonPackageDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonPackageDownloadListener);
            return;
        }
        if (emoticonPackageDownloadListener == null) {
            return;
        }
        Iterator<WeakReference<EmoticonPackageDownloadListener>> it = this.f204728b.iterator();
        while (it.hasNext()) {
            WeakReference<EmoticonPackageDownloadListener> next = it.next();
            if (next.get() == emoticonPackageDownloadListener) {
                this.f204728b.remove(next);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmojiListenerManager
    public void removeEmotionJsonDownloadListener(EmotionJsonDownloadListener emotionJsonDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emotionJsonDownloadListener);
            return;
        }
        if (emotionJsonDownloadListener == null) {
            return;
        }
        Iterator<WeakReference<EmotionJsonDownloadListener>> it = this.f204729c.iterator();
        while (it.hasNext()) {
            WeakReference<EmotionJsonDownloadListener> next = it.next();
            if (next.get() == emotionJsonDownloadListener) {
                this.f204729c.remove(next);
            }
        }
    }
}
