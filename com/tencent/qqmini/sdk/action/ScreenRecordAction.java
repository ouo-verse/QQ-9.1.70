package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ScreenRecordAction implements Action<Boolean> {
    private int what;

    ScreenRecordAction() {
    }

    public static ScreenRecordAction obtain(int i3) {
        ScreenRecordAction screenRecordAction = new ScreenRecordAction();
        screenRecordAction.what = i3;
        return screenRecordAction;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        QMLog.i(Action.TAG, "[perform]");
        IScreenRecord screenRecordMgr = baseRuntime.getScreenRecordMgr();
        if (screenRecordMgr == null) {
            return Boolean.FALSE;
        }
        int i3 = this.what;
        if (i3 == 1) {
            screenRecordMgr.detachRecordView(1);
            return null;
        }
        if (i3 == 2) {
            screenRecordMgr.attachRecordView();
            screenRecordMgr.prepareAndStartRecord(1);
            return null;
        }
        if (i3 == 4) {
            screenRecordMgr.stopRecord(1);
            return null;
        }
        if (i3 != 1001) {
            return null;
        }
        screenRecordMgr.removePreview();
        return null;
    }
}
