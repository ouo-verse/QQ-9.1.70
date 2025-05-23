package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.app.Activity;
import android.content.ContextWrapper;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ha1.a;

/* loaded from: classes15.dex */
public class QQVoiceColorNoteProxy {

    /* renamed from: a, reason: collision with root package name */
    private IColorNoteController f238114a;

    /* renamed from: b, reason: collision with root package name */
    private IQQVoiceServiceInfo f238115b;

    public QQVoiceColorNoteProxy(boolean z16, boolean z17) {
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.f238114a = iColorNoteController;
        iColorNoteController.init(BaseApplication.getContext(), z16, z17);
    }

    public static void showColorNote(boolean z16) {
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, z16);
    }

    public void addHistoryNote() {
        this.f238114a.addHistoryNote();
    }

    public void addToRecentNote() {
        this.f238114a.addToRecentNote();
    }

    public void attachToActivity(ContextWrapper contextWrapper) {
        Activity actFromShadowContext = QQVoiceUtil.getActFromShadowContext(contextWrapper);
        if (actFromShadowContext != null) {
            this.f238114a.attachToActivity(actFromShadowContext);
        }
        QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy attachToActivity");
    }

    public boolean canAddColorNote() {
        return this.f238114a.canAddColorNote();
    }

    public void deleteColorNote() {
        this.f238114a.deleteColorNote();
    }

    public void exitAnimation() {
        this.f238114a.exitAnimation();
    }

    public IQQVoiceServiceInfo getServiceInfo() {
        return this.f238115b;
    }

    public void insertColorNote() {
        this.f238114a.insertColorNote();
    }

    public boolean isColorNoteExist() {
        return this.f238114a.isColorNoteExist();
    }

    public void onCannotAdd() {
        this.f238114a.onCannotAdd();
    }

    public void onDestroy() {
        this.f238114a.onDestroy();
    }

    public void onPause() {
        this.f238114a.onPause();
        QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
    }

    public void onResume() {
        if (this.f238114a.shouldDisplayColorNote()) {
            this.f238114a.onResume();
        }
        QLog.d("QQVoiceColorNoteProxy", 1, "QQVoiceColorNoteProxy onResume");
    }

    public void setColorNoteAnimFinishCallback(final OnColorNoteAnimFinish onColorNoteAnimFinish) {
        this.f238114a.setOnColorNoteAnimFinishListener(new a() { // from class: com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy.1
            @Override // ha1.a
            public void onColorNoteAnimFinish() {
                OnColorNoteAnimFinish onColorNoteAnimFinish2 = onColorNoteAnimFinish;
                if (onColorNoteAnimFinish2 != null) {
                    onColorNoteAnimFinish2.onColorNoteAnimFinish();
                }
            }
        });
    }

    public void setServiceInfo(final IQQVoiceServiceInfo iQQVoiceServiceInfo) {
        this.f238115b = iQQVoiceServiceInfo;
        this.f238114a.setServiceInfo(new f() { // from class: com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceColorNoteProxy.2
            @Override // com.tencent.mobileqq.colornote.f
            public ColorNote getColorNote() {
                return iQQVoiceServiceInfo.getColorNote().mColorNote;
            }
        });
    }

    public boolean shouldDisplayColorNote() {
        return this.f238114a.shouldDisplayColorNote();
    }

    public void updateColorNote(QQVoiceColorNote qQVoiceColorNote) {
        this.f238114a.updateColorNote(qQVoiceColorNote.mColorNote);
    }
}
