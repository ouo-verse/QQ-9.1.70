package com.tencent.biz.richframework.video;

import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMediaFocusManager implements IModule.FocusChangeListener {
    private String mBusinessName;
    private String mCurrentFocusBusinessNameBlackListPrint;
    private IModule mMediaFocusModule;
    private final int mMediaHashCode = hashCode();
    private static final Set<Integer> mMediaFocusRegisterSet = new CopyOnWriteArraySet();
    private static final AtomicBoolean ENABLED_MEDIA_FOCUS = new AtomicBoolean(false);

    RFWMediaFocusManager(String str) {
        this.mBusinessName = str;
        ENABLED_MEDIA_FOCUS.set(isEnabledMediaFocus());
    }

    public static RFWMediaFocusManager createMediaFocusManager(String str) {
        return new RFWMediaFocusManager(str);
    }

    private void createMediaFocusTypeModule(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFP-RFWMediaFocusManager", 1, "[createMediaFocusTypeModule] business name should not be null.");
            return;
        }
        if (!TextUtils.isEmpty(this.mBusinessName)) {
            AVBizModuleFactory.removeModuleByName(this.mBusinessName);
        }
        IModule moduleByName = AVBizModuleFactory.getModuleByName(str);
        this.mMediaFocusModule = moduleByName;
        moduleByName.setListener(this);
        QLog.d(getTag(), 1, "[updateMediaFocusModule] media focus businessName: " + str + " | preBusinessName: " + this.mBusinessName + " | manager: " + hashCode());
        this.mBusinessName = str;
    }

    private boolean isEnabledMediaFocus() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_media_focus_switch", true);
    }

    private boolean isFocusBusinessNameBlackList(String str) {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_media_conflict_black_list", "");
            if (TextUtils.isEmpty(loadAsString)) {
                return false;
            }
            if (!TextUtils.equals(this.mCurrentFocusBusinessNameBlackListPrint, loadAsString)) {
                QLog.d("QFP-RFWMediaFocusManager", 1, "[isFocusBusinessNameBlackList] mediaConflictBlackList:" + loadAsString);
                this.mCurrentFocusBusinessNameBlackListPrint = loadAsString;
            }
            for (String str2 : loadAsString.split("\\|")) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            RFWLog.d("QFP-RFWMediaFocusManager", RFWLog.CLR, "error: ", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFocusGain$3(String str, String str2) {
        QLog.d("QFP-RFWMediaFocusManager", 1, "[onFocusGain] current un focus focusBusinessName:" + str + " | conflictBusinessName: " + str2 + " | mediaHashCode: " + this.mMediaHashCode);
        SimpleEventBus.getInstance().dispatchEvent(new RFWMediaFocusChangeEvent(false, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFocusLoss$2(String str, String str2) {
        boolean z16 = true;
        QLog.d("QFP-RFWMediaFocusManager", 1, "[onFocusLoss] current un focus focusBusinessName:" + str + " | conflictBusinessName: " + str2 + " | mediaHashCode: " + this.mMediaHashCode);
        if (Constants.Business.QQCIRCLE.equals(str) && Constants.Business.QQ_CIRCLE_WINDOW.equals(str2)) {
            z16 = false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new RFWMediaFocusChangeEvent(z16, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMediaFocus$0() {
        QLog.d("QFP-RFWMediaFocusManager", 1, "[requestMediaFocus] result: " + this.mMediaFocusModule.requestAVFocus() + " | businessName: " + this.mBusinessName + " | mediaHashCode: " + this.mMediaHashCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMediaUnFocus$1() {
        if (this.mMediaFocusModule == null) {
            QLog.e(getTag(), 1, "[requestMediaUnFocus] current av module un focus fail, not request focus.");
            return;
        }
        QLog.d(getTag(), 1, "[requestMediaUnFocus] current media un focus, businessName: " + this.mBusinessName + " | mediaHashCode: " + this.mMediaHashCode);
        this.mMediaFocusModule.abandonAVFocus();
        this.mMediaFocusModule.setListener(null);
    }

    private String obtainFocusBusinessName() {
        IModule iModule = this.mMediaFocusModule;
        if (iModule == null) {
            return "none";
        }
        String checkAVFocus = iModule.checkAVFocus();
        if (TextUtils.equals(checkAVFocus, "true")) {
            return "none";
        }
        return checkAVFocus;
    }

    protected String getTag() {
        return "QFP-RFWMediaFocusManager_" + this.mBusinessName;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        final String obtainFocusBusinessName = obtainFocusBusinessName();
        final String str = this.mBusinessName;
        if (isFocusBusinessNameBlackList(str)) {
            QLog.d("QFP-RFWMediaFocusManager", 1, "[onFocusGain] current focus business name: " + obtainFocusBusinessName + " | conflictBusinessName:" + str + " has black list.");
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.c
            @Override // java.lang.Runnable
            public final void run() {
                RFWMediaFocusManager.this.lambda$onFocusGain$3(obtainFocusBusinessName, str);
            }
        });
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        final String obtainFocusBusinessName = obtainFocusBusinessName();
        final String str = this.mBusinessName;
        if (isFocusBusinessNameBlackList(obtainFocusBusinessName)) {
            QLog.d("QFP-RFWMediaFocusManager", 1, "[onFocusLoss] current business name: " + str + " has black list.");
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWMediaFocusManager.this.lambda$onFocusLoss$2(obtainFocusBusinessName, str);
            }
        });
    }

    public void requestMediaFocus() {
        if (!ENABLED_MEDIA_FOCUS.get()) {
            QLog.w("QFP-RFWMediaFocusManager", 2, "[requestMediaFocus] current switch close, media focus not request.");
            return;
        }
        Set<Integer> set = mMediaFocusRegisterSet;
        if (set.contains(Integer.valueOf(this.mMediaHashCode))) {
            QLog.w("QFP-RFWMediaFocusManager", 2, "[requestMediaFocus] current hash code: " + this.mMediaHashCode + " exists, not request focus.");
            return;
        }
        createMediaFocusTypeModule(this.mBusinessName);
        if (this.mMediaFocusModule == null) {
            QLog.e("QFP-RFWMediaFocusManager", 1, "[requestMediaFocus] create media focus module should not be null.");
            return;
        }
        set.add(Integer.valueOf(this.mMediaHashCode));
        this.mMediaFocusModule.setListener(this);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWMediaFocusManager.this.lambda$requestMediaFocus$0();
            }
        });
    }

    public void requestMediaUnFocus() {
        if (!ENABLED_MEDIA_FOCUS.get()) {
            QLog.w("QFP-RFWMediaFocusManager", 2, "[requestMediaUnFocus] current switch close, media unfocus not request.");
            return;
        }
        Set<Integer> set = mMediaFocusRegisterSet;
        if (!set.contains(Integer.valueOf(this.mMediaHashCode))) {
            QLog.w("QFP-RFWMediaFocusManager", 2, "[requestMediaUnFocus] current hash code: " + this.mMediaHashCode + " not exists, not request unfocus.");
            return;
        }
        set.remove(Integer.valueOf(this.mMediaHashCode));
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWMediaFocusManager.this.lambda$requestMediaUnFocus$1();
            }
        });
    }

    public void updateFocusBusinessName(String str) {
        this.mBusinessName = str;
    }
}
