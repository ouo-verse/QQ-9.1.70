package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.wink.model.WinkEditorVideoInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorGenerateBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AEEditorGenerateBroadcastReceiver";
    private AEEditorGenerateListener mAETavSessionStatusListener;
    private boolean mReceiverActive = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEEditorGenerateListener {
        void onAETavSessionExportCompleted(WinkEditorVideoInfo winkEditorVideoInfo);

        void onAETavSessionExportError(String str, long j3, String str2);

        void onAETavSessionExporting(WinkEditorVideoInfo winkEditorVideoInfo);
    }

    public AEEditorGenerateBroadcastReceiver(AEEditorGenerateListener aEEditorGenerateListener) {
        this.mAETavSessionStatusListener = aEEditorGenerateListener;
    }

    private IntentFilter getBroadcastIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AEEditorConstants.AEEDITOR_GENERATE_STATUS_ERROR);
        intentFilter.addAction(AEEditorConstants.AEEDITOR_GENERATE_STATUS_DOWNLOADING);
        intentFilter.addAction(AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY);
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            ms.a.c(TAG, "[onReceive] : action is null");
            return;
        }
        WinkEditorVideoInfo winkEditorVideoInfo = (WinkEditorVideoInfo) intent.getSerializableExtra(AEEditorConstants.GENERATE_WINK_EDIT_DATA);
        if (winkEditorVideoInfo == null) {
            ms.a.c(TAG, "[onReceive] : winkEditorVideoInfo == null");
            return;
        }
        ms.a.f(TAG, "[onReceive] action :" + action);
        ms.a.f(TAG, "[onReceive] winkEditorVideoInfo :" + winkEditorVideoInfo.toString());
        if (this.mAETavSessionStatusListener != null) {
            if (AEEditorConstants.AEEDITOR_GENERATE_STATUS_ERROR.equals(action)) {
                this.mAETavSessionStatusListener.onAETavSessionExportError(winkEditorVideoInfo.missionID, winkEditorVideoInfo.errorCode, winkEditorVideoInfo.errorMsg);
                return;
            } else if (AEEditorConstants.AEEDITOR_GENERATE_STATUS_DOWNLOADING.equals(action)) {
                this.mAETavSessionStatusListener.onAETavSessionExporting(winkEditorVideoInfo);
                return;
            } else {
                if (AEEditorConstants.AEEDITOR_GENERATE_STATUS_READY.equals(action)) {
                    this.mAETavSessionStatusListener.onAETavSessionExportCompleted(winkEditorVideoInfo);
                    return;
                }
                return;
            }
        }
        ms.a.f(TAG, "[onReceive] mAETavSessionStatusListener is null");
    }

    public void registerSelf(Context context) {
        if (this.mReceiverActive || context == null) {
            return;
        }
        context.registerReceiver(this, getBroadcastIntentFilter());
        this.mReceiverActive = true;
    }

    public void unRegisterSelf(Context context) {
        if (!this.mReceiverActive || context == null) {
            return;
        }
        context.unregisterReceiver(this);
        this.mReceiverActive = false;
    }
}
