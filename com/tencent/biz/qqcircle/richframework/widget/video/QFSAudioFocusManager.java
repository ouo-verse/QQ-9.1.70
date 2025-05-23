package com.tencent.biz.qqcircle.richframework.widget.video;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSAudioFocusManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile QFSAudioFocusManager f92254d;

    /* renamed from: a, reason: collision with root package name */
    private AudioManager f92255a;

    /* renamed from: b, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f92256b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i3) {
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    int i16 = i3;
                    if (i16 == -3 || i16 == -2 || i16 == -1) {
                        QFSAudioFocusManager.this.f92257c = false;
                        QLog.d("QFSAudioFocusManager", 1, "onAudioFocusChange, loss focus:" + i3);
                        return;
                    }
                    if (i16 == 1 || i16 == 2 || i16 == 3) {
                        QFSAudioFocusManager.this.f92257c = true;
                        QLog.d("QFSAudioFocusManager", 1, "onAudioFocusChange, gain focus:" + i3);
                        return;
                    }
                    QLog.d("QFSAudioFocusManager", 1, "onAudioFocusChange:" + i3);
                }
            });
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private boolean f92257c;

    QFSAudioFocusManager() {
    }

    public static QFSAudioFocusManager f() {
        if (f92254d == null) {
            synchronized (QFSAudioFocusManager.class) {
                if (f92254d == null) {
                    f92254d = new QFSAudioFocusManager();
                }
            }
        }
        return f92254d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        this.f92255a = (AudioManager) QCircleApplication.getAPP().getSystemService("audio");
    }

    public void h() {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (QFSAudioFocusManager.this.f92255a == null) {
                    QLog.d("QFSAudioFocusManager", 1, "releaseAudioFocus mAudioManger == null");
                    return;
                }
                if (!QFSAudioFocusManager.this.f92257c) {
                    QLog.d("QFSAudioFocusManager", 1, "releaseAudioFocus not has focus ");
                    return;
                }
                QLog.d("QFSAudioFocusManager", 1, "releaseAudioFocus \uff1a" + QFSAudioFocusManager.this.f92256b);
                int abandonAudioFocus = QFSAudioFocusManager.this.f92255a.abandonAudioFocus(QFSAudioFocusManager.this.f92256b);
                QLog.d("QFSAudioFocusManager", 1, "releaseAudioFocus result:" + abandonAudioFocus + QFSAudioFocusManager.this.f92256b);
                if (abandonAudioFocus == 1) {
                    QFSAudioFocusManager.this.f92257c = false;
                }
            }
        });
    }

    public void i(final Context context) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.widget.video.QFSAudioFocusManager.2
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if ((context2 instanceof QCircleFolderActivity) && !QCirclePluginUtil.isNewFolderPage(context2) && !QCircleHostGlobalInfo.isCurrentTabActive()) {
                    QLog.d("QFSAudioFocusManager", 1, "not need requestAudioFocus , bottom tab not selected ");
                    return;
                }
                Context context3 = context;
                if ((context3 instanceof QCircleFolderActivity) && QCirclePluginUtil.isFromPadNavigation(context3) && !QCircleHostGlobalInfo.isCurrentTabActive()) {
                    QLog.d("QFSAudioFocusManager", 1, "not need requestAudioFocus , bottom tab not selected in pad ");
                    return;
                }
                if (QFSAudioFocusManager.this.f92255a == null) {
                    QFSAudioFocusManager.this.g();
                }
                if (QFSAudioFocusManager.this.f92257c) {
                    QLog.d("QFSAudioFocusManager", 1, "requestAudioFocus hasFocus ");
                    return;
                }
                int requestAudioFocus = QFSAudioFocusManager.this.f92255a.requestAudioFocus(QFSAudioFocusManager.this.f92256b, 3, 2);
                QLog.d("QFSAudioFocusManager", 1, "requestAudioFocus result:" + requestAudioFocus + QFSAudioFocusManager.this.f92256b);
                if (requestAudioFocus == 1) {
                    QFSAudioFocusManager.this.f92257c = true;
                }
            }
        });
    }
}
