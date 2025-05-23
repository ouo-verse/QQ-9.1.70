package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.f;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.mobileqq.magicface.service.b;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneGiftFullScreenActionManager {
    public static final String MAGICFACE_RECEIVE_SOUND = "receiveSound";
    public static final String MAGICFACE_RECEIVE_XML = "receive.xml";
    public static final String TAG = "QzoneGiftFullScreenActionManager";
    Action currentMagicfaceAction;
    String epId;
    MagicfaceActionListener magicfaceActionListener;
    List<Action> magicfaceActions;
    MagicfaceCloseListener magicfaceCloseListener;
    b magicfacePlayManager;
    f magicfaceResLoader;
    QzoneGiftFullScreenViewController magicfaceViewController;
    volatile boolean isStart = false;
    volatile boolean isShutDown = false;
    volatile boolean isRelease = false;
    ActionGlobalData actionGlobalData = null;
    com.tencent.mobileqq.magicface.magicfaceaction.b magicfaceActionDecoder = new com.tencent.mobileqq.magicface.magicfaceaction.b();
    SoundPoolUtil soundPoolUtil = new SoundPoolUtil();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface MagicfaceActionListener {
        void magicfaceActionEnd(ActionGlobalData actionGlobalData);

        void magicfaceActionStart(ActionGlobalData actionGlobalData);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface MagicfaceCloseListener {
        void magicfaceClose();
    }

    public QzoneGiftFullScreenActionManager(QzoneGiftFullScreenViewController qzoneGiftFullScreenViewController) {
        this.magicfaceViewController = qzoneGiftFullScreenViewController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filterAction() {
        int i3;
        int i16;
        ActionGlobalData actionGlobalData = this.actionGlobalData;
        boolean z16 = false;
        if (actionGlobalData != null && !"non-ver".equals(actionGlobalData.f243353f)) {
            int[] splitVersion = splitVersion(AppSetting.f99551k);
            int[] splitVersion2 = splitVersion(this.actionGlobalData.f243353f);
            if (splitVersion != null && splitVersion2 != null && splitVersion.length == splitVersion2.length) {
                for (int i17 = 0; i17 < splitVersion2.length && (i3 = splitVersion[i17]) <= (i16 = splitVersion2[i17]); i17++) {
                    if (i3 < i16) {
                        break;
                    }
                }
            }
            z16 = true;
            this.magicfaceActions = getValidActions(!z16);
            return;
        }
        this.magicfaceActions = getValidActions(false);
    }

    public static String getGiftFullScreenFolderPath(String str) {
        String gifFullScreenDir = CacheManager.getGifFullScreenDir();
        File file = new File(gifFullScreenDir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(gifFullScreenDir);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        return sb5.toString();
    }

    public static String getPassiveFullScreenFolderPath(String str) {
        String praiseDir = CacheManager.getPraiseDir();
        File file = new File(praiseDir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(praiseDir);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        return sb5.toString();
    }

    private List<Action> getValidActions(boolean z16) {
        ArrayList arrayList = new ArrayList();
        Iterator<Action> it = this.magicfaceActions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Action next = it.next();
            if (next != null) {
                if (z16) {
                    if ("default".equals(next.f243331b)) {
                        arrayList.add(next);
                        break;
                    }
                } else if (!"default".equals(next.f243331b)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static ActionGlobalData hasAction(String str, String str2) {
        String f16 = new f(str2).f(MAGICFACE_RECEIVE_XML);
        if (f16 == null) {
            return null;
        }
        return new com.tencent.mobileqq.magicface.magicfaceaction.b().b(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEndMagicface(ActionGlobalData actionGlobalData) {
        MagicfaceCloseListener magicfaceCloseListener = this.magicfaceCloseListener;
        if (magicfaceCloseListener != null) {
            magicfaceCloseListener.magicfaceClose();
        }
        this.isStart = false;
        MagicfaceActionListener magicfaceActionListener = this.magicfaceActionListener;
        if (magicfaceActionListener != null) {
            magicfaceActionListener.magicfaceActionEnd(actionGlobalData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartMagicface(ActionGlobalData actionGlobalData) {
        MagicfaceActionListener magicfaceActionListener = this.magicfaceActionListener;
        if (magicfaceActionListener != null) {
            magicfaceActionListener.magicfaceActionStart(actionGlobalData);
        }
        if (actionGlobalData == null || actionGlobalData.f243360m == null) {
            return;
        }
        actionGlobalData.b();
    }

    private int[] splitVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int[] iArr = new int[3];
        for (int i3 = 0; i3 < 3; i3++) {
            iArr[i3] = 0;
        }
        String[] split = str.split("\\.");
        if (split != null && split.length > 1) {
            for (int i16 = 0; i16 < 3; i16++) {
                try {
                    iArr[i16] = Integer.valueOf(split[i16]).intValue();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
        return iArr;
    }

    public void doAction(String str, final String str2) {
        if (this.isStart) {
            return;
        }
        this.epId = str;
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.QzoneGiftFullScreenActionManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QzoneGiftFullScreenActionManager.TAG, 2, "doaction=Exception=" + e16.toString());
                        }
                    }
                    if (QzoneGiftFullScreenActionManager.this.isRelease) {
                        return;
                    }
                    QzoneGiftFullScreenActionManager.this.initActionData(str2);
                    String f16 = QzoneGiftFullScreenActionManager.this.magicfaceResLoader.f(QzoneGiftFullScreenActionManager.MAGICFACE_RECEIVE_XML);
                    if (f16 != null) {
                        QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager = QzoneGiftFullScreenActionManager.this;
                        qzoneGiftFullScreenActionManager.actionGlobalData = qzoneGiftFullScreenActionManager.magicfaceActionDecoder.b(f16);
                        QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager2 = QzoneGiftFullScreenActionManager.this;
                        qzoneGiftFullScreenActionManager2.onStartMagicface(qzoneGiftFullScreenActionManager2.actionGlobalData);
                        QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager3 = QzoneGiftFullScreenActionManager.this;
                        qzoneGiftFullScreenActionManager3.magicfaceActions = qzoneGiftFullScreenActionManager3.magicfaceActionDecoder.d(f16);
                        QzoneGiftFullScreenActionManager.this.filterAction();
                        for (Action action : QzoneGiftFullScreenActionManager.this.magicfaceActions) {
                            QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager4 = QzoneGiftFullScreenActionManager.this;
                            qzoneGiftFullScreenActionManager4.currentMagicfaceAction = action;
                            action.f243336g = qzoneGiftFullScreenActionManager4.magicfacePlayManager;
                            action.f243330a = qzoneGiftFullScreenActionManager4.actionGlobalData;
                            boolean b16 = action.b();
                            if (QzoneGiftFullScreenActionManager.this.isShutDown || !b16 || QzoneGiftFullScreenActionManager.this.isShutDown) {
                                break;
                            }
                        }
                    }
                } finally {
                    QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager5 = QzoneGiftFullScreenActionManager.this;
                    qzoneGiftFullScreenActionManager5.onEndMagicface(qzoneGiftFullScreenActionManager5.actionGlobalData);
                }
            }
        }, 8, null, true);
    }

    public boolean getPreferencesReceiveSound() {
        return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean(MAGICFACE_RECEIVE_SOUND, false);
    }

    public boolean isStart() {
        return this.isStart;
    }

    public void openSound(boolean z16) {
        ActionGlobalData actionGlobalData = this.actionGlobalData;
        if (actionGlobalData != null) {
            actionGlobalData.f243361n = true;
        }
    }

    public void setMagicfaceActionListener(MagicfaceActionListener magicfaceActionListener) {
        this.magicfaceActionListener = magicfaceActionListener;
    }

    public void setMagicfacePlayManager(b bVar) {
        this.magicfacePlayManager = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initActionData(String str) {
        this.isStart = true;
        this.isShutDown = false;
        this.magicfacePlayManager.b();
        f fVar = new f(str);
        this.magicfaceResLoader = fVar;
        this.magicfacePlayManager.i(fVar);
        this.magicfacePlayManager.g(this.soundPoolUtil);
    }

    public void release() {
        this.isRelease = true;
        ActionGlobalData actionGlobalData = this.actionGlobalData;
        if (actionGlobalData != null) {
            actionGlobalData.a(null);
        }
        b bVar = this.magicfacePlayManager;
        if (bVar != null) {
            bVar.g(null);
            this.magicfacePlayManager.f();
        }
        SoundPoolUtil soundPoolUtil = this.soundPoolUtil;
        if (soundPoolUtil != null) {
            soundPoolUtil.c();
            this.soundPoolUtil = null;
        }
        this.magicfaceViewController = null;
    }

    public void close(MagicfaceCloseListener magicfaceCloseListener) {
        if (magicfaceCloseListener != null) {
            this.magicfaceCloseListener = magicfaceCloseListener;
        }
        this.isShutDown = true;
        Action action = this.currentMagicfaceAction;
        if (action != null) {
            action.g();
        }
        ActionGlobalData actionGlobalData = this.actionGlobalData;
        if (actionGlobalData != null) {
            actionGlobalData.a(null);
        }
    }
}
