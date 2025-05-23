package com.tencent.could.huiyansdk.entity;

import com.google.gson.annotations.SerializedName;
import com.tencent.could.huiyansdk.entity.LiveTypeDataConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OperationModeConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("angle_detect")
    private LiveTypeDataConfig.AngleDetectConfig angleDetectConfig;

    @SerializedName("cameraConfig")
    private String cameraConfig;

    @SerializedName("asymmetric_pub_key")
    private String encryptPubKey;

    @SerializedName("errorcode")
    private int errorCode;

    @SerializedName("errormsg")
    private String errorMsg;

    @SerializedName("nonce")
    private String nonce;

    @SerializedName("operation_mode")
    private String operationMode;

    public OperationModeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.errorCode = 210;
        this.operationMode = SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL;
        this.encryptPubKey = "";
    }

    public LiveTypeDataConfig.AngleDetectConfig getAngleDetectConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveTypeDataConfig.AngleDetectConfig) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.angleDetectConfig;
    }

    public String getCameraConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.cameraConfig;
    }

    public String getEncryptPubKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.encryptPubKey;
    }

    public int getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    public String getErrorMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.errorMsg;
    }

    public String getNonce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.nonce;
    }

    public String getOperationMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.operationMode;
    }

    public void setAngleDetectConfig(LiveTypeDataConfig.AngleDetectConfig angleDetectConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) angleDetectConfig);
        } else {
            this.angleDetectConfig = angleDetectConfig;
        }
    }

    public void setCameraConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.cameraConfig = str;
        }
    }

    public void setEncryptPubKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.encryptPubKey = str;
        }
    }

    public void setErrorCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.errorCode = i3;
        }
    }

    public void setErrorMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.errorMsg = str;
        }
    }

    public void setNonce(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.nonce = str;
        }
    }

    public void setOperationMode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.operationMode = str;
        }
    }
}
