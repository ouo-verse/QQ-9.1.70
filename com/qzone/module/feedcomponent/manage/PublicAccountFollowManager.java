package com.qzone.module.feedcomponent.manage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class PublicAccountFollowManager {
    private static final String BROADCAST_ACTION_FOLLOW = "action.qzone_public_account_follow";
    private static final String PERMISSION = "com.tencent.qzone.permission.notify";
    private static PublicAccountFollowManager sInstance;
    private PublicAccountFollowReceiver mReceiver;
    private Map<String, Boolean> mUinFollowedMap = new HashMap();
    private List<SoftReference<OnFollowListener>> mListenerList = new LinkedList();

    /* loaded from: classes39.dex */
    public interface OnFollowListener {
        void onFollow(String str, boolean z16);
    }

    PublicAccountFollowManager() {
    }

    public static PublicAccountFollowManager g() {
        if (sInstance == null) {
            synchronized (PublicAccountFollowManager.class) {
                if (sInstance == null) {
                    sInstance = new PublicAccountFollowManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(String str, boolean z16) {
        List<SoftReference<OnFollowListener>> list = this.mListenerList;
        if (list == null) {
            return;
        }
        Iterator<SoftReference<OnFollowListener>> it = list.iterator();
        while (it.hasNext()) {
            OnFollowListener onFollowListener = it.next().get();
            if (onFollowListener != null) {
                onFollowListener.onFollow(str, z16);
            }
        }
    }

    public void setUinFollowed(String str, boolean z16) {
        Map<String, Boolean> map = this.mUinFollowedMap;
        if (map == null) {
            return;
        }
        map.put(str, Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class PublicAccountFollowReceiver extends BroadcastReceiver {
        PublicAccountFollowReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !PublicAccountFollowManager.BROADCAST_ACTION_FOLLOW.equals(intent.getAction())) {
                return;
            }
            int intExtra = intent.getIntExtra(QCircleDaTongConstant.ElementParamValue.FOLLOWED, -1);
            String stringExtra = intent.getStringExtra("uin");
            if (intExtra == -1 || stringExtra == null) {
                return;
            }
            PublicAccountFollowManager.this.setUinFollowed(stringExtra, intExtra == 1);
            PublicAccountFollowManager.this.notifyListeners(stringExtra, intExtra == 1);
        }
    }

    private void registerFollowReceiverIfNeed(Context context) {
        if (context != null && this.mReceiver == null) {
            PublicAccountFollowReceiver publicAccountFollowReceiver = new PublicAccountFollowReceiver();
            this.mReceiver = publicAccountFollowReceiver;
            context.registerReceiver(publicAccountFollowReceiver, new IntentFilter(BROADCAST_ACTION_FOLLOW), PERMISSION, null);
        }
    }

    public void addOnFollowListener(Context context, OnFollowListener onFollowListener) {
        if (onFollowListener == null) {
            return;
        }
        registerFollowReceiverIfNeed(context);
        this.mListenerList.add(new SoftReference<>(onFollowListener));
    }

    public void removeOnFollowListener(OnFollowListener onFollowListener) {
        if (onFollowListener == null) {
            return;
        }
        for (SoftReference<OnFollowListener> softReference : this.mListenerList) {
            if (softReference.get() == onFollowListener) {
                this.mListenerList.remove(softReference);
            }
        }
    }

    public boolean getUinFollowed(String str) {
        if (str == null) {
            return false;
        }
        return this.mUinFollowedMap.get(str).booleanValue();
    }

    public boolean hasUin(String str) {
        if (str == null) {
            return false;
        }
        return this.mUinFollowedMap.containsKey(str);
    }
}
