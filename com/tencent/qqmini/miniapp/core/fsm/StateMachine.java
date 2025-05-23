package com.tencent.qqmini.miniapp.core.fsm;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class StateMachine<T, E> {
    private static final String TAG = "StateMachine";
    private StateMachine<T, E>.State<T> mCurrState;
    private Map<State, List<StateTransfer>> mStateTransferMap = new HashMap();
    private List<E> mEvents = new ArrayList();
    private List<OnStateChangeListener> mStateListeners = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnStateChangeListener {
        void onStateChanged();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class StateTransfer<E> {
        private E event;
        private StateMachine<T, E>.State<T> fromState;
        private StateMachine<T, E>.State<T> nextState;

        public StateTransfer() {
        }

        public StateTransfer from(StateMachine<T, E>.State<T> state) {
            this.fromState = state;
            return this;
        }

        public StateTransfer next(StateMachine<T, E>.State<T> state) {
            this.nextState = state;
            return this;
        }

        public StateTransfer registEvent(E e16) {
            this.event = e16;
            return this;
        }

        public StateMachine<T, E>.State<T> from() {
            return this.fromState;
        }

        public StateMachine<T, E>.State<T> next() {
            return this.nextState;
        }
    }

    private void autoConsumeCacheEvents() {
        ArrayList arrayList = new ArrayList(this.mEvents);
        if (arrayList.size() <= 0) {
            return;
        }
        for (E e16 : arrayList) {
            if (e16 != null) {
                for (Map.Entry<State, List<StateTransfer>> entry : this.mStateTransferMap.entrySet()) {
                    if (this.mCurrState == entry.getKey()) {
                        Iterator<StateTransfer> it = entry.getValue().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            StateTransfer next = it.next();
                            if (next != null && e16.equals(next.event)) {
                                setCurrState(next.nextState);
                                this.mEvents.remove(e16);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void addStateChangeListener(OnStateChangeListener onStateChangeListener) {
        if (!this.mStateListeners.contains(onStateChangeListener)) {
            this.mStateListeners.add(onStateChangeListener);
        }
    }

    public void addStateTransfer(StateMachine<T, E>.StateTransfer<E> stateTransfer) {
        if (stateTransfer != null && ((StateTransfer) stateTransfer).fromState != null) {
            List<StateTransfer> list = this.mStateTransferMap.get(stateTransfer.from());
            if (list == null) {
                list = new ArrayList<>();
                this.mStateTransferMap.put(((StateTransfer) stateTransfer).fromState, list);
            }
            list.add(stateTransfer);
        }
    }

    public void appendEvent(E e16) {
        if (e16 != null && this.mCurrState != null) {
            boolean z16 = false;
            for (Map.Entry<State, List<StateTransfer>> entry : this.mStateTransferMap.entrySet()) {
                if (this.mCurrState == entry.getKey()) {
                    Iterator<StateTransfer> it = entry.getValue().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StateTransfer next = it.next();
                        if (next != null && e16.equals(next.event)) {
                            setCurrState(next.nextState);
                            z16 = true;
                            break;
                        }
                    }
                }
            }
            if (!z16) {
                this.mEvents.add(e16);
            }
        }
    }

    public State getCurrState() {
        return this.mCurrState;
    }

    protected synchronized void notifyStateChange(State state, State state2) {
        for (OnStateChangeListener onStateChangeListener : this.mStateListeners) {
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged();
            }
        }
    }

    public synchronized boolean removeStateChangeListener(OnStateChangeListener onStateChangeListener) {
        return this.mStateListeners.remove(onStateChangeListener);
    }

    public void sendEvent(E e16) {
        if (e16 != null && this.mCurrState != null) {
            for (Map.Entry<State, List<StateTransfer>> entry : this.mStateTransferMap.entrySet()) {
                if (this.mCurrState == entry.getKey()) {
                    Iterator<StateTransfer> it = entry.getValue().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StateTransfer next = it.next();
                        if (next != null && e16.equals(next.event)) {
                            setCurrState(next.nextState);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void setCurrState(State state) {
        Object obj;
        State currState = getCurrState();
        if (state != null && state != this.mCurrState) {
            if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick(TAG, 500L)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(getClass().getSimpleName());
                sb5.append("(");
                sb5.append(this);
                sb5.append(") change state from ");
                StateMachine<T, E>.State<T> state2 = this.mCurrState;
                if (state2 != null) {
                    obj = state2.f346224id;
                } else {
                    obj = WiFiDash.NOT_AVALIBLE;
                }
                sb5.append(obj);
                sb5.append(" to ");
                sb5.append(state.f346224id);
                QMLog.i(TAG, sb5.toString());
            }
            this.mCurrState = state;
            if (state != currState) {
                notifyStateChange(currState, state);
            }
            this.mCurrState.onStart();
            autoConsumeCacheEvents();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class State<T> {

        /* renamed from: id, reason: collision with root package name */
        public T f346224id;

        public State(T t16) {
            this.f346224id = t16;
        }

        public void onEnd() {
        }

        public void onStart() {
        }
    }
}
