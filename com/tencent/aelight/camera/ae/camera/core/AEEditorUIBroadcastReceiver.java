package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.constants.AEEditorConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorUIBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AEEditorUIBroadcastReceiver";
    private AEEditorUIListener mAEUIListener;
    private boolean mReceiverActive = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEEditorUIListener {
        void deteleMedia(int i3);
    }

    public AEEditorUIBroadcastReceiver(AEEditorUIListener aEEditorUIListener) {
        this.mAEUIListener = aEEditorUIListener;
    }

    private IntentFilter getBroadcastIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AEEditorConstants.AEEDITOR_GENERATE_STATUS_DELETE);
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            ms.a.c(TAG, "[onReceive] : action is null");
        } else if (AEEditorConstants.AEEDITOR_GENERATE_STATUS_DELETE.equals(action)) {
            this.mAEUIListener.deteleMedia(intent.getIntExtra(AEEditorConstants.DELETE_POSITION, 0));
        }
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
