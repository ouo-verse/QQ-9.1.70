package com.tencent.ams.dsdk.event;

import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKEventCenter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKEventCenter";
    private CopyOnWriteArrayList<DKEventHandler> handlerList;
    private String mCallId;
    private EngineType mEngineType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class EngineType {
        private static final /* synthetic */ EngineType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final EngineType HIPPY;
        public static final EngineType MOSAIC;
        public static final EngineType WORMHOLE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18063);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EngineType engineType = new EngineType("HIPPY", 0);
            HIPPY = engineType;
            EngineType engineType2 = new EngineType("WORMHOLE", 1);
            WORMHOLE = engineType2;
            EngineType engineType3 = new EngineType("MOSAIC", 2);
            MOSAIC = engineType3;
            $VALUES = new EngineType[]{engineType, engineType2, engineType3};
        }

        EngineType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static EngineType valueOf(String str) {
            return (EngineType) Enum.valueOf(EngineType.class, str);
        }

        public static EngineType[] values() {
            return (EngineType[]) $VALUES.clone();
        }
    }

    public DKEventCenter(EngineType engineType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) engineType);
            return;
        }
        this.mCallId = DynamicUtils.getUUID();
        this.mEngineType = engineType;
        this.handlerList = new CopyOnWriteArrayList<>();
    }

    public void addEventHandler(DKEventHandler dKEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dKEventHandler);
            return;
        }
        DLog.i(TAG, "addEventHandler, handler: " + dKEventHandler);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && dKEventHandler != null && !copyOnWriteArrayList.contains(dKEventHandler)) {
            this.handlerList.add(dKEventHandler);
        }
    }

    public void fireCreateView(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        DLog.i(TAG, "fireCreateView, adType: " + str);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onCreateView(this.mCallId, this.mEngineType, str, str2);
                }
            }
        }
    }

    public void fireEngineCreateFail(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        DLog.i(TAG, "fireEngineCreated");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onEngineCreateFail(this.mCallId, this.mEngineType, i3);
                }
            }
        }
    }

    public void fireEngineCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        DLog.i(TAG, "fireEngineCreated");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onEngineCreated(this.mCallId, this.mEngineType);
                }
            }
        }
    }

    public void fireEngineInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        DLog.i(TAG, "fireEngineInitd");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onEngineInit(this.mCallId, this.mEngineType);
                }
            }
        }
    }

    public void fireEngineInitFail(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        DLog.i(TAG, "fireEngineInitFail");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onEngineInitFail(this.mCallId, this.mEngineType, i3);
                }
            }
        }
    }

    public void fireEngineInitParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        DLog.i(TAG, "fireEngineInitParams");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onEngineInitParams(this.mCallId, this.mEngineType);
                }
            }
        }
    }

    public void fireEngineInitSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        DLog.i(TAG, "fireEngineInitSuccess");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onEngineInitSuccess(this.mCallId, this.mEngineType);
                }
            }
        }
    }

    public void fireJsBundleLoadComplete(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3);
            return;
        }
        DLog.i(TAG, "fireJsBundleLoadComplete, adType: " + str);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onJsBundleLoadComplete(this.mCallId, this.mEngineType, str, i3);
                }
            }
        }
    }

    public void fireViewCreateFail(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) str);
            return;
        }
        DLog.i(TAG, "fireViewCreateFail, errorCode: " + i3 + ", adType: " + str);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onViewCreateFail(this.mCallId, this.mEngineType, i3, str);
                }
            }
        }
    }

    public void fireViewCreated(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "fireViewCreated, adType: " + str);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onViewCreated(this.mCallId, this.mEngineType, str);
                }
            }
        }
    }

    public void fireViewLoadComplete(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "fireViewLoadComplete, adType: " + str);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<DKEventHandler> it = this.handlerList.iterator();
            while (it.hasNext()) {
                DKEventHandler next = it.next();
                if (next != null) {
                    next.onViewLoadComplete(this.mCallId, this.mEngineType, str);
                }
            }
        }
    }

    public void removeAllHandlers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        DLog.i(TAG, "removeAllHandlers");
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
    }

    public void removeEventHandler(DKEventHandler dKEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dKEventHandler);
            return;
        }
        DLog.i(TAG, "removeEventHandler, dkEventHandler: " + dKEventHandler);
        CopyOnWriteArrayList<DKEventHandler> copyOnWriteArrayList = this.handlerList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(dKEventHandler);
        }
    }
}
