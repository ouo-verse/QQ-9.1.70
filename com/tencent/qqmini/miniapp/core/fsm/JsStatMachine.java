package com.tencent.qqmini.miniapp.core.fsm;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class JsStatMachine extends StateMachine<Integer, Integer> {
    protected JsStateListener mJsStateListener;
    protected Handler mMainHandler = new Handler(Looper.getMainLooper());
    public static final Integer EVENT_JS_EVALUATE_SUCC = 1;
    public static final Integer EVENT_JS_EVALUATE_FAIL = 2;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class JsState extends StateMachine.State {
        private String jsContent;
        private String jsPath;
        private StateMachine.State nextState;

        public JsState(int i3) {
            super(Integer.valueOf(i3));
        }

        public String getJsContent() {
            return this.jsContent;
        }

        public String getJsPath() {
            return this.jsPath;
        }

        public JsState nextState(StateMachine.State state) {
            this.nextState = state;
            return this;
        }

        @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine.State
        public void onStart() {
            super.onStart();
            if (TextUtils.isEmpty(this.jsContent)) {
                JsStatMachine.this.sendEvent(JsStatMachine.EVENT_JS_EVALUATE_SUCC);
                return;
            }
            JsStateListener jsStateListener = JsStatMachine.this.mJsStateListener;
            if (jsStateListener != null) {
                jsStateListener.onJsStateStart(this);
            }
            JsStatMachine.this.evaluateJs(this.jsContent, new ValueCallback() { // from class: com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Object obj) {
                    JsState jsState = JsState.this;
                    JsStateListener jsStateListener2 = JsStatMachine.this.mJsStateListener;
                    if (jsStateListener2 != null) {
                        jsStateListener2.onJsStateStart(jsState);
                    }
                    JsStatMachine.this.sendEvent(JsStatMachine.EVENT_JS_EVALUATE_SUCC);
                }
            }, this.jsPath);
        }

        public void setJsContent(String str) {
            setJsContent(str, null);
        }

        public void setJsContent(String str, String str2) {
            this.jsContent = str;
            this.jsPath = str2;
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String str3 = this.jsContent;
                str3.substring(0, str3.length() > 150 ? 150 : this.jsContent.length());
                String str4 = this.jsContent;
                str4.substring(str4.length() > 150 ? this.jsContent.length() - 150 : 0);
            } catch (Throwable th5) {
                QMLog.i("JsDebugInfo", " (" + this + ")", th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface JsStateListener {
        void onJsStateEnd(JsState jsState);

        void onJsStateStart(JsState jsState);
    }

    public abstract void evaluateJs(String str, ValueCallback valueCallback, String str2);

    public void setJsStateListener(JsStateListener jsStateListener) {
        this.mJsStateListener = jsStateListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendEvent(Integer num) {
        boolean z16;
        StateMachine.State currState = getCurrState();
        if (currState instanceof JsState) {
            JsState jsState = (JsState) currState;
            if (jsState.nextState != null && EVENT_JS_EVALUATE_SUCC == num) {
                setCurrState(jsState.nextState);
                z16 = true;
                if (z16) {
                    super.sendEvent((JsStatMachine) num);
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
