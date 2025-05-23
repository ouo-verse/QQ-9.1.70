package com.tencent.mobileqq.qqlive.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveFollowApiImpl implements IQQLiveFollowApi {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_QQ_LIVE_WEB_FOLLOW_STATE = "ACTION_QQ_LIVE_WEB_FOLLOW_STATE";
    public static final String KEY_FOLLOWED_UID = "followedUid";
    public static final String KEY_IS_FOLLOWED = "isFollowed";
    public static final String KEY_ROOM_ID = "roomId";
    public static final String KEY_UID = "uid";
    private static final String TAG = "QQLiveFollowApiImpl";
    private static final AtomicBoolean isInitBroadCast;
    private static final BroadcastReceiver mWebFollowChangeReceiver;
    private static final List<IQQLiveFollowApi.IQQLiveFollowStateListener> sWebFollowChangeListeners;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        sWebFollowChangeListeners = new ArrayList();
        isInitBroadCast = new AtomicBoolean(false);
        mWebFollowChangeReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqlive.api.impl.QQLiveFollowApiImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                if (intent != null && "ACTION_QQ_LIVE_WEB_FOLLOW_STATE".equals(intent.getAction())) {
                    synchronized (QQLiveFollowApiImpl.sWebFollowChangeListeners) {
                        if (QQLiveFollowApiImpl.sWebFollowChangeListeners.size() == 0) {
                            return;
                        }
                        long longExtra = intent.getLongExtra("uid", 0L);
                        long longExtra2 = intent.getLongExtra("followedUid", 0L);
                        int intExtra = intent.getIntExtra("isFollowed", 0);
                        String stringExtra = intent.getStringExtra("roomId");
                        Iterator it = QQLiveFollowApiImpl.sWebFollowChangeListeners.iterator();
                        while (it.hasNext()) {
                            ((IQQLiveFollowApi.IQQLiveFollowStateListener) it.next()).onFollowStateChange(longExtra, longExtra2, intExtra, stringExtra);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(QQLiveFollowApiImpl.TAG, 2, "[mWebFollowChangeReceiver],size:" + QQLiveFollowApiImpl.sWebFollowChangeListeners.size() + ",uid:" + longExtra + ",followedUid:" + longExtra2 + ",isFollowed:" + intExtra + ",roomId:" + stringExtra);
                        }
                    }
                }
            }
        };
    }

    public QQLiveFollowApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            registerBroadcast();
        }
    }

    private static void registerBroadcast() {
        if (MobileQQ.sMobileQQ != null && !isInitBroadCast.getAndSet(true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_QQ_LIVE_WEB_FOLLOW_STATE");
            try {
                MobileQQ.sMobileQQ.registerReceiver(mWebFollowChangeReceiver, intentFilter);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi
    public void addWebFollowStateChangeListener(IQQLiveFollowApi.IQQLiveFollowStateListener iQQLiveFollowStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveFollowStateListener);
        } else {
            if (iQQLiveFollowStateListener == null) {
                return;
            }
            List<IQQLiveFollowApi.IQQLiveFollowStateListener> list = sWebFollowChangeListeners;
            synchronized (list) {
                list.add(iQQLiveFollowStateListener);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi
    public void removeWebFollowStateChangeListener(IQQLiveFollowApi.IQQLiveFollowStateListener iQQLiveFollowStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveFollowStateListener);
            return;
        }
        List<IQQLiveFollowApi.IQQLiveFollowStateListener> list = sWebFollowChangeListeners;
        synchronized (list) {
            list.remove(iQQLiveFollowStateListener);
        }
    }
}
