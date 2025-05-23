package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LocalBrdMnger {
    private static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final Object M_LOCK = new Object();
    private static LocalBrdMnger mInstance;
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            return "Receiver{" + this.receiver + " filter=" + this.filter + "}";
        }
    }

    LocalBrdMnger(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.huawei.agconnect.LocalBrdMnger.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBrdMnger.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePendingBroadcasts() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(broadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i3 = 0; i3 < size; i3++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i3];
                for (int i16 = 0; i16 < broadcastRecord.receivers.size(); i16++) {
                    broadcastRecord.receivers.get(i16).receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                }
            }
        }
    }

    public static LocalBrdMnger getInstance(Context context) {
        LocalBrdMnger localBrdMnger;
        synchronized (M_LOCK) {
            if (mInstance == null) {
                mInstance = new LocalBrdMnger(context.getApplicationContext());
            }
            localBrdMnger = mInstance;
        }
        return localBrdMnger;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                String action = intentFilter.getAction(i3);
                ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public boolean sendBroadcast(Intent intent) {
        boolean z16;
        String str;
        String str2;
        int i3;
        ArrayList arrayList;
        Uri uri;
        boolean z17;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(intent.getAction());
            boolean z18 = false;
            if (arrayList2 != null) {
                ArrayList arrayList3 = null;
                int i16 = 0;
                while (i16 < arrayList2.size()) {
                    ReceiverRecord receiverRecord = arrayList2.get(i16);
                    if (receiverRecord.broadcasting) {
                        i3 = i16;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        uri = data;
                        arrayList = arrayList3;
                        z17 = z18;
                    } else {
                        str = action;
                        String str3 = resolveTypeIfNeeded;
                        str2 = resolveTypeIfNeeded;
                        i3 = i16;
                        Uri uri2 = data;
                        arrayList = arrayList3;
                        uri = data;
                        z17 = z18;
                        if (receiverRecord.filter.match(action, str3, scheme, uri2, categories, "LocalBroadcastManager") >= 0) {
                            if (arrayList == null) {
                                arrayList3 = new ArrayList();
                            } else {
                                arrayList3 = arrayList;
                            }
                            arrayList3.add(receiverRecord);
                            receiverRecord.broadcasting = true;
                            i16 = i3 + 1;
                            z18 = z17;
                            action = str;
                            resolveTypeIfNeeded = str2;
                            data = uri;
                        }
                    }
                    arrayList3 = arrayList;
                    i16 = i3 + 1;
                    z18 = z17;
                    action = str;
                    resolveTypeIfNeeded = str2;
                    data = uri;
                }
                ?? r112 = arrayList3;
                z16 = z18;
                if (r112 != 0) {
                    for (?? r95 = z16; r95 < r112.size(); r95++) {
                        ((ReceiverRecord) r112.get(r95)).broadcasting = z16;
                    }
                    this.mPendingBroadcasts.add(new BroadcastRecord(intent, r112));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            } else {
                z16 = false;
            }
            return z16;
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<IntentFilter> remove = this.mReceivers.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int i3 = 0; i3 < remove.size(); i3++) {
                IntentFilter intentFilter = remove.get(i3);
                for (int i16 = 0; i16 < intentFilter.countActions(); i16++) {
                    String action = intentFilter.getAction(i16);
                    ArrayList<ReceiverRecord> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        int i17 = 0;
                        while (i17 < arrayList.size()) {
                            if (arrayList.get(i17).receiver == broadcastReceiver) {
                                arrayList.remove(i17);
                                i17--;
                            }
                            i17++;
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
