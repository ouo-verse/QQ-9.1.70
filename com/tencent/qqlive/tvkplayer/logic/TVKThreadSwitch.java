package com.tencent.qqlive.tvkplayer.logic;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKFutureGetter;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKFutureSetter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKFuture;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKThreadSwitch {
    private static final int API_CALL_TIME_OUT_MS = 500;
    private final Class<?> mClass;
    private final Handler mEventHandler;
    private final String mLogTag;
    private final Looper mLooper;
    private final Object mTargetObj;
    private final Queue<Integer> mWaitingExecuteApiQueue = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class EventHandler extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (TVKThreadSwitch.this.mTargetObj != null) {
                TVKThreadSwitch.this.invokeMethod(message.what, message.obj);
                synchronized (TVKThreadSwitch.this.mWaitingExecuteApiQueue) {
                    Integer num = (Integer) TVKThreadSwitch.this.mWaitingExecuteApiQueue.remove();
                    if (num == null || message.what != num.intValue()) {
                        TVKLogUtil.e(TVKThreadSwitch.this.mLogTag, "msg.what=" + message.what + " msgIndex=" + num + " is not equal!");
                    }
                }
                return;
            }
            TVKLogUtil.e(TVKThreadSwitch.this.mLogTag, "handle listener is null, return");
        }

        EventHandler(Looper looper) {
            super(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MessageParams {
        Object params;
        ITVKFutureSetter result = new TVKFuture();

        MessageParams(Object obj) {
            this.params = obj;
        }
    }

    public TVKThreadSwitch(String str, Looper looper, @NonNull Object obj) {
        this.mLogTag = str;
        this.mLooper = looper;
        this.mEventHandler = new EventHandler(looper);
        this.mTargetObj = obj;
        Class<?> cls = obj.getClass();
        this.mClass = cls;
        if (TVKThreadAnnotations.register(cls, 0)) {
            return;
        }
        TVKLogUtil.e(str, "Register " + cls.getName() + " @ThreadSwitch method failed, version: " + TVKVersion.getPlayerVersion());
        throw new RuntimeException("register @ThreadSwitch method failed, player can not work");
    }

    private Object dealResult(String str, Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        String name = TVKThreadAnnotations.getMethod(this.mClass, str, getMethodParams(obj2)).getReturnType().getName();
        if (HippyControllerProps.BOOLEAN.equals(name)) {
            return Boolean.FALSE;
        }
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(name)) {
            return 0;
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(name)) {
            return 0L;
        }
        return null;
    }

    private Object[] getMethodParams(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof MessageParams) {
            Object obj2 = ((MessageParams) obj).params;
            if (obj2 == null) {
                return null;
            }
            return (Object[]) obj2;
        }
        return (Object[]) obj;
    }

    private boolean internalMessage(int i3, Object obj) {
        return internalMessage(i3, obj, false, false);
    }

    private ITVKFutureGetter internalMessageLock(int i3, Object obj) throws Throwable {
        MessageParams messageParams = new MessageParams(obj);
        internalMessage(i3, messageParams);
        return (ITVKFutureGetter) messageParams.result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeMethod(int i3, Object obj) {
        ITVKFutureSetter iTVKFutureSetter;
        Object invoke;
        if (obj instanceof MessageParams) {
            iTVKFutureSetter = ((MessageParams) obj).result;
        } else {
            iTVKFutureSetter = null;
        }
        Method methodByMethodId = TVKThreadAnnotations.getMethodByMethodId(this.mClass, i3);
        if (methodByMethodId == null) {
            TVKLogUtil.e(this.mLogTag, "invokeMethod, handle method name is empty, msg:" + i3);
            if (iTVKFutureSetter != null) {
                iTVKFutureSetter.setException(new RuntimeException("invokeMethod, handle method name is empty"));
                return;
            }
            return;
        }
        try {
            if (methodByMethodId.getParameterTypes().length == 0) {
                invoke = methodByMethodId.invoke(this.mTargetObj, new Object[0]);
            } else {
                invoke = methodByMethodId.invoke(this.mTargetObj, getMethodParams(obj));
            }
            if (iTVKFutureSetter != null) {
                iTVKFutureSetter.setResult(invoke);
            }
        } catch (InvocationTargetException e16) {
            TVKLogUtil.e(this.mLogTag, "invokeMethod " + methodByMethodId.getName() + " has exception: " + e16.getTargetException().toString());
            if (iTVKFutureSetter != null) {
                iTVKFutureSetter.setException(e16.getTargetException());
            }
        } catch (Exception e17) {
            TVKLogUtil.e(this.mLogTag, "invokeMethod " + methodByMethodId.getName() + " has exception: " + e17.toString());
            if (iTVKFutureSetter != null) {
                iTVKFutureSetter.setException(e17);
            }
        }
    }

    private boolean isNeedThreadSwitch(Class<?> cls, int i3) {
        LinkedList<Integer> linkedList;
        if (!TVKThreadAnnotations.hasWaitApiSignatures(cls, i3)) {
            return true;
        }
        synchronized (this.mWaitingExecuteApiQueue) {
            linkedList = new LinkedList(this.mWaitingExecuteApiQueue);
        }
        for (Integer num : linkedList) {
            if (num == null) {
                TVKLogUtil.e(this.mLogTag, "mWaitingExecuteApiQueue has null methodId");
            } else if (TVKThreadAnnotations.isInvokeMethodNeedWaitOtherApi(this.mClass, i3, num.intValue())) {
                return true;
            }
        }
        return false;
    }

    private String messageToCommand(int i3) {
        String api = TVKThreadAnnotations.getApi(this.mClass, i3);
        if (!TextUtils.isEmpty(api) && !"unknown".equals(api)) {
            return api;
        }
        return i3 + " not find";
    }

    private void recycle() {
        this.mEventHandler.removeCallbacksAndMessages(null);
    }

    public Object dealThreadSwitch(String str, Object obj) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            Object[] methodParams = getMethodParams(obj);
            int methodId = TVKThreadAnnotations.getMethodId(this.mClass, str, methodParams);
            if (methodId >= 0) {
                if (TVKThreadAnnotations.isLetCallerThreadWait(this.mClass, methodId)) {
                    if (!isNeedThreadSwitch(this.mClass, methodId)) {
                        TVKLogUtil.i(this.mLogTag, "method[" + str + "] no need to switch thread");
                        try {
                            return TVKThreadAnnotations.getMethodByMethodId(this.mClass, methodId).invoke(this.mTargetObj, methodParams);
                        } catch (InvocationTargetException e16) {
                            throw e16.getTargetException();
                        }
                    }
                    return internalMessageLock(methodId, obj).getResult(500L);
                }
                internalMessage(methodId, obj);
                return null;
            }
            TVKLogUtil.e(this.mLogTag, "dealThreadSwitch failed , not match method:" + str);
            throw new RuntimeException("dealThreadSwitch failed , not match method:" + str);
        }
        TVKLogUtil.e(this.mLogTag, "dealThreadSwitch failed , methodName is null");
        throw new RuntimeException("dealThreadSwitch failed , methodName is null");
    }

    public Object dealThreadSwitchWithResult(String str, Object obj) throws Throwable {
        return dealResult(str, dealThreadSwitch(str, obj), obj);
    }

    private boolean internalMessage(int i3, Object obj, boolean z16, boolean z17) {
        if (this.mEventHandler == null) {
            TVKLogUtil.e(this.mLogTag, messageToCommand(i3) + " , send failed , handler null");
            return false;
        }
        if (z16 && obj == null) {
            TVKLogUtil.e(this.mLogTag, messageToCommand(i3) + ", send failed , params null");
            return false;
        }
        if (!this.mLooper.getThread().isAlive()) {
            TVKLogUtil.e(this.mLogTag, messageToCommand(i3) + ", send failed , thread had dead");
            return false;
        }
        if (z17) {
            this.mEventHandler.removeMessages(i3);
        }
        if (this.mLooper == Looper.myLooper()) {
            invokeMethod(i3, obj);
            return true;
        }
        Message obtainMessage = this.mEventHandler.obtainMessage();
        obtainMessage.what = i3;
        obtainMessage.obj = obj;
        synchronized (this.mWaitingExecuteApiQueue) {
            this.mWaitingExecuteApiQueue.add(Integer.valueOf(i3));
            this.mEventHandler.sendMessage(obtainMessage);
        }
        return true;
    }
}
