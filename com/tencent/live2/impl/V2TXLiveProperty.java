package com.tencent.live2.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class V2TXLiveProperty {
    static IPatchRedirector $redirector_ = null;
    public static final String kV2ClearLastImage = "clearLastImage";
    public static final String kV2EnableHardwareAcceleration = "enableHardwareAcceleration";
    public static final String kV2EnableHevcEncode = "enableHevcEncode";
    public static final String kV2EnableIPMultiplexing = "enableIPMultiplexing";
    public static final String kV2EnableVideoNonUniformScale = "enableVideoNonUniformScale";
    public static final String kV2MaxNumberOfReconnection = "maxNumberOfReconnection";
    public static final String kV2SecondsBetweenReconnection = "secondsBetweenReconnection";
    public static final String kV2SetHeaders = "setHeaders";
    public static final String kV2SetMetaData = "setMetaData";
    public static final String kV2SetVideoQualityEx = "setVideoQualityEx";

    public V2TXLiveProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
