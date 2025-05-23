package com.tencent.xweb.pinus;

import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.xweb.IXWebPreferences;

/* loaded from: classes27.dex */
public class PinusPreferences implements IXWebPreferences {
    public static final String TAG = "PinusPreferences";
    private PSCoreWrapper coreWrapper;
    private final g0 setValueStringbooleanMethod = new g0((Class) null, HippyTextInputController.COMMAND_setValue, new Class[0]);
    private final g0 setValueStringintMethod = new g0((Class) null, HippyTextInputController.COMMAND_setValue, new Class[0]);
    private final g0 setValueStringStringMethod = new g0((Class) null, HippyTextInputController.COMMAND_setValue, new Class[0]);
    private final g0 getValueStringMethod = new g0((Class) null, HippyTextInputController.COMMAND_getValue, new Class[0]);
    private final g0 getBooleanValueStringMethod = new g0((Class) null, "getBooleanValue", new Class[0]);
    private final g0 getIntegerValueStringMethod = new g0((Class) null, "getIntegerValue", new Class[0]);
    private final g0 getStringValueStringMethod = new g0((Class) null, "getStringValue", new Class[0]);

    private void reflectionInit() {
        if (this.coreWrapper != null) {
            return;
        }
        if (PSCoreWrapper.getInstance() == null) {
            x0.f(TAG, "reflectionInit, pinus core wrapper is null");
            return;
        }
        PSCoreWrapper pSCoreWrapper = PSCoreWrapper.getInstance();
        this.coreWrapper = pSCoreWrapper;
        Class<?> cls = pSCoreWrapper.getClass("org.xwalk.core.internal.XWalkPreferencesBridge");
        this.setValueStringbooleanMethod.a(null, cls, HippyTextInputController.COMMAND_setValue, String.class, Boolean.TYPE);
        this.setValueStringintMethod.a(null, cls, HippyTextInputController.COMMAND_setValue, String.class, Integer.TYPE);
        this.setValueStringStringMethod.a(null, cls, HippyTextInputController.COMMAND_setValue, String.class, String.class);
        this.getValueStringMethod.a(null, cls, HippyTextInputController.COMMAND_getValue, String.class);
        this.getBooleanValueStringMethod.a(null, cls, "getBooleanValue", String.class);
        this.getIntegerValueStringMethod.a(null, cls, "getIntegerValue", String.class);
        this.getStringValueStringMethod.a(null, cls, "getStringValue", String.class);
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public boolean getBooleanValue(String str) {
        reflectionInit();
        try {
            return ((Boolean) this.getBooleanValueStringMethod.a(str)).booleanValue();
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return false;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public int getIntegerValue(String str) {
        reflectionInit();
        try {
            return ((Integer) this.getIntegerValueStringMethod.a(str)).intValue();
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return 0;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public String getStringValue(String str) {
        reflectionInit();
        try {
            return (String) this.getStringValueStringMethod.a(str);
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return null;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public boolean getValue(String str) {
        reflectionInit();
        try {
            return ((Boolean) this.getValueStringMethod.a(str)).booleanValue();
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return false;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public void setValue(String str, boolean z16) {
        reflectionInit();
        try {
            this.setValueStringbooleanMethod.a(str, Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public void setValue(String str, int i3) {
        reflectionInit();
        try {
            this.setValueStringintMethod.a(str, Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }

    @Override // com.tencent.xweb.IXWebPreferences
    public void setValue(String str, String str2) {
        reflectionInit();
        try {
            this.setValueStringStringMethod.a(str, str2);
        } catch (UnsupportedOperationException e16) {
            if (this.coreWrapper != null) {
                PSCoreWrapper.handleRuntimeError(e16);
                return;
            }
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
        }
    }
}
