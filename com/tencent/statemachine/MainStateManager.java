package com.tencent.statemachine;

import android.text.TextUtils;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.api.MainState;
import com.tencent.statemachine.api.StateObserver;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MainStateManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MainStateManager";
    private static volatile MainStateManager sMainStateManager;
    private String mCurrentState;
    private int mCurrentTabIndex;
    private boolean mIsDrawerOpened;
    private Object mObserverLock;
    private ArrayList<StateObserver> mStateObservers;

    MainStateManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mCurrentTabIndex = Integer.MIN_VALUE;
        this.mIsDrawerOpened = false;
        this.mObserverLock = new Object();
        this.mStateObservers = new ArrayList<>();
        registerObservers();
    }

    private String convertTabIndexToState(int i3) {
        if (i3 == a.f183038a) {
            return MainState.MAIN_STATE_MESSAGE_TAB_SHOW;
        }
        if (i3 == a.f183040c) {
            return MainState.MAIN_STATE_CONTACTS_TAB_SHOW;
        }
        if (i3 == a.f183044g) {
            return MainState.MAIN_STATE_KANDIAN_TAB_SHOW;
        }
        if (i3 == a.f183041d) {
            return MainState.MAIN_STATE_DYNAMIC_TAB_SHOW;
        }
        if (i3 == a.f183045h) {
            return MainState.MAIN_STATE_QZONE_TAB_SHOW;
        }
        return null;
    }

    public static MainStateManager getInstance() {
        if (sMainStateManager == null) {
            synchronized (MainStateManager.class) {
                if (sMainStateManager == null) {
                    sMainStateManager = new MainStateManager();
                }
            }
        }
        return sMainStateManager;
    }

    private void onMainFragmentShow(int i3) {
        if (this.mIsDrawerOpened) {
            changeMainState(MainState.MAIN_STATE_DRAWER_TAB_SHOW);
            return;
        }
        String convertTabIndexToState = convertTabIndexToState(i3);
        if (!TextUtils.isEmpty(convertTabIndexToState)) {
            this.mCurrentTabIndex = i3;
            changeMainState(convertTabIndexToState);
        }
    }

    private void registerObservers() {
        addMainStateObserver(TabPreloadManager.getInstance().getStateObserver());
    }

    public void addMainStateObserver(StateObserver stateObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) stateObserver);
        } else {
            if (stateObserver == null) {
                return;
            }
            synchronized (this.mObserverLock) {
                if (!this.mStateObservers.contains(stateObserver)) {
                    this.mStateObservers.add(stateObserver);
                }
            }
        }
    }

    public void changeMainState(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (!MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin()) {
            return;
        }
        if (str != null && str.equals(this.mCurrentState)) {
            return;
        }
        synchronized (this.mObserverLock) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "changeMainState newState:" + str + " oldState:" + this.mCurrentState);
            }
            Iterator<StateObserver> it = this.mStateObservers.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onStateChanged(str, this.mCurrentState);
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "changeMainState newState:" + str + " oldState:" + this.mCurrentState + " error:" + th5);
                }
            }
            this.mCurrentState = str;
        }
    }

    public String getCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mCurrentState;
    }

    public void onAppDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "AppInterface destroyed");
        }
        synchronized (this.mObserverLock) {
            this.mStateObservers.clear();
            registerObservers();
        }
    }

    public void onMainDrawerChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (z16) {
            this.mIsDrawerOpened = true;
            changeMainState(MainState.MAIN_STATE_DRAWER_TAB_SHOW);
        } else {
            this.mIsDrawerOpened = false;
            onMainFragmentShow(this.mCurrentTabIndex);
        }
    }

    public void onMainFragmentChange(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (z16) {
            onMainFragmentShow(i3);
        } else {
            changeMainState(MainState.MAIN_STATE_ACTIVITY_HIDE);
        }
    }

    public void onMainTabChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        String convertTabIndexToState = convertTabIndexToState(i3);
        if (!TextUtils.isEmpty(convertTabIndexToState)) {
            this.mCurrentTabIndex = i3;
            changeMainState(convertTabIndexToState);
        }
    }

    public void removeMainStateObserver(StateObserver stateObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) stateObserver);
            return;
        }
        synchronized (this.mObserverLock) {
            this.mStateObservers.remove(stateObserver);
        }
    }
}
