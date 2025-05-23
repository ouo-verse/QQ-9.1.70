package com.tencent.mobileqq.colornote.ipc.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.e;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* loaded from: classes5.dex */
public class ColorNoteProcessStateImpl implements IColorNoteProcessState {
    public static final String MODULE_NAME = "color_note_client_module";
    private static final String TAG = "ColorNoteQIPCModule";
    private static ColorNoteProcessStateImpl sInstance;
    private WeakReference<g> mColorNoteCurdListener;
    private WeakReference<o> mServiceSyncListener;
    private static final byte[] S_INSTANCE_LOCK = new byte[0];
    private static final byte[] S_DATA_LOCK = new byte[0];
    private Point mFloatingWindowPosition = new Point();
    private boolean mCanAddColorNote = true;
    private Set<String> mColorNoteSet = new HashSet();
    private boolean mSyncState = true;
    private BroadcastReceiver mReceiver = new a();

    /* loaded from: classes5.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            o oVar;
            int i3;
            g gVar;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ColorNoteProcessStateImpl.TAG, 1, "action receive: " + action);
            }
            if (action.equals("key_float_window_position")) {
                int intExtra = intent.getIntExtra("key_float_window_position_x", 0);
                int intExtra2 = intent.getIntExtra("key_float_window_position_y", 0);
                synchronized (ColorNoteProcessStateImpl.S_DATA_LOCK) {
                    ColorNoteProcessStateImpl.this.mFloatingWindowPosition.set(intExtra, intExtra2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ColorNoteProcessStateImpl.TAG, 1, "KEY_FLOAT_WINDOW_POSITION receive: " + intExtra + ", " + intExtra2);
                    return;
                }
                return;
            }
            if (action.equals("key_delete_item_call")) {
                ColorNoteProcessStateImpl.this.mCanAddColorNote = intent.getBooleanExtra("extra_can_add_colornote", true);
                String[] stringArrayExtra = intent.getStringArrayExtra("key_color_note_servicetype_list");
                String[] stringArrayExtra2 = intent.getStringArrayExtra("key_color_note_suptype_list");
                if (ColorNoteProcessStateImpl.this.mColorNoteCurdListener != null && stringArrayExtra != null && stringArrayExtra2 != null && stringArrayExtra.length == stringArrayExtra2.length) {
                    for (int i16 = 0; i16 < stringArrayExtra2.length; i16++) {
                        try {
                            i3 = Integer.valueOf(stringArrayExtra[i16]).intValue();
                        } catch (Exception e16) {
                            QLog.e(ColorNoteProcessStateImpl.TAG, 2, "integer cast error", e16);
                            i3 = -1;
                        }
                        if (i3 != -1 && (gVar = (g) ColorNoteProcessStateImpl.this.mColorNoteCurdListener.get()) != null) {
                            gVar.onDeleteColorNote(i3, stringArrayExtra2[i16], false);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    com.tencent.mobileqq.colornote.data.a.b(ColorNoteProcessStateImpl.TAG, "[onReceive->ACTION_DELETE_ITEM_CALL]\n[mCanAddColorNote]: " + ColorNoteProcessStateImpl.this.mCanAddColorNote + "\n");
                    return;
                }
                return;
            }
            if (action.equals("key_after_sync_msg") && ColorNoteProcessStateImpl.this.mServiceSyncListener != null && (oVar = (o) ColorNoteProcessStateImpl.this.mServiceSyncListener.get()) != null) {
                boolean booleanExtra = intent.getBooleanExtra("extra_after_sync_msg", true);
                oVar.onServiceSyncSucc(booleanExtra);
                ColorNoteProcessStateImpl.this.setSyncState(booleanExtra);
                QLog.d(ColorNoteProcessStateImpl.TAG, 1, "invoke listener: " + booleanExtra);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public boolean getCanAddColorNote() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[getCanAddColorNote] " + com.tencent.mobileqq.colornote.data.a.l());
        }
        return this.mCanAddColorNote;
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public Point getFloatingWindowPosition() {
        return this.mFloatingWindowPosition;
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public boolean getSyncState() {
        return this.mSyncState;
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public boolean isColorNoteExist(int i3, String str) {
        return isColorNoteExist(i3, str, 0);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public boolean isRecentColorNoteTurnOn(AppRuntime appRuntime) {
        return e.d(appRuntime);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void registerBroadcast() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.ipc.impl.ColorNoteProcessStateImpl.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter("key_float_window_position");
                intentFilter.addAction("key_delete_item_call");
                intentFilter.addAction("key_after_sync_msg");
                try {
                    BaseApplication.getContext().registerReceiver(ColorNoteProcessStateImpl.this.mReceiver, intentFilter);
                } catch (Exception e16) {
                    QLog.e(ColorNoteProcessStateImpl.TAG, 2, "register failed", e16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ColorNoteProcessStateImpl.TAG, 1, "register broadcast");
                }
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void setCanAddColorNote(boolean z16) {
        this.mCanAddColorNote = z16;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[setCanAddColorNote] " + com.tencent.mobileqq.colornote.data.a.l());
        }
    }

    public void setColorNoteCache(Set<String> set) {
        this.mColorNoteSet = set;
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void setColorNoteCurdListener(g gVar) {
        this.mColorNoteCurdListener = new WeakReference<>(gVar);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void setRecentColorNoteSwitch(AppRuntime appRuntime, boolean z16) {
        e.h(appRuntime, z16);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void setServiceSyncListener(o oVar) {
        this.mServiceSyncListener = new WeakReference<>(oVar);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void setSyncState(boolean z16) {
        this.mSyncState = z16;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[setSyncState] " + com.tencent.mobileqq.colornote.data.a.l());
        }
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void unregisterBroadcast() {
        try {
            BaseApplication.getContext().unregisterReceiver(this.mReceiver);
        } catch (Exception e16) {
            QLog.e(TAG, 2, "unregister failed", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "unregister broadcast");
        }
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void updateColorNoteSet(int i3, String str, boolean z16) {
        updateColorNoteSet(i3, str, z16, 0);
    }

    @Override // com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState
    public void updateFloatingWindowPosition(Point point) {
        if (point != null && point.x != 0 && point.y != 0) {
            this.mFloatingWindowPosition = point;
        }
    }

    public boolean isColorNoteExist(int i3, String str, int i16) {
        if (i16 != 2) {
            if (this.mColorNoteSet.contains(i3 + str + i16)) {
                return true;
            }
        }
        return false;
    }

    public void updateColorNoteSet(int i3, String str, boolean z16, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[updateColorNoteSet] " + com.tencent.mobileqq.colornote.data.a.l());
        }
        if (i16 == 2) {
            return;
        }
        String str2 = i3 + str + i16;
        if (z16) {
            this.mColorNoteSet.add(str2);
        } else {
            this.mColorNoteSet.remove(str2);
        }
    }
}
