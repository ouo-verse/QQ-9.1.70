package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.wink.editor.export.j;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorOrderBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AEEditorOrderBroadcastReceiver";
    private AEEditorOrderListener mAEEditorOrderListener;
    private boolean mReceiverActive = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEEditorOrderListener {
        void onAEEditorCancel(String str);

        void onAEEditorRemove(String str);
    }

    public AEEditorOrderBroadcastReceiver(AEEditorOrderListener aEEditorOrderListener) {
        this.mAEEditorOrderListener = aEEditorOrderListener;
    }

    private IntentFilter getBroadcastIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AEEditorConstants.AEEDITOR_ORDER_CANCEL);
        intentFilter.addAction(AEEditorConstants.AEEDITOR_ORDER_SAVE);
        intentFilter.addAction(AEEditorConstants.AEEDITOR_ORDER_REMOVE_MISSION);
        intentFilter.addAction(AEEditorConstants.AEEDITOR_ORDER_QFS_CANCEL);
        intentFilter.addAction(AEEditorConstants.AEEDITOR_ORDER_QFS_CANCEL_V2);
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra(AEEditorConstants.GENERATE_MISSION);
        ms.a.f(TAG, "[onReceive] action :" + action);
        ms.a.f(TAG, "[onReceive] mission :" + stringExtra);
        if (AEEditorConstants.AEEDITOR_ORDER_CANCEL.equals(action)) {
            this.mAEEditorOrderListener.onAEEditorCancel(stringExtra);
        } else if (AEEditorConstants.AEEDITOR_ORDER_REMOVE_MISSION.equals(action)) {
            this.mAEEditorOrderListener.onAEEditorRemove(stringExtra);
        } else if (AEEditorConstants.AEEDITOR_ORDER_QFS_CANCEL.equals(action)) {
            j.t().i();
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
