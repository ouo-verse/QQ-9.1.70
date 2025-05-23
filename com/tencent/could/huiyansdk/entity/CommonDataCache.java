package com.tencent.could.huiyansdk.entity;

import com.tencent.could.huiyansdk.api.HuiYanAuthResultListener;
import com.tencent.could.huiyansdk.callback.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonDataCache {
    static IPatchRedirector $redirector_;
    private String actionData;
    private ConfigEntity configEntity;
    private List<c> configListeners;
    private CustomerConfig customerConfig;
    private volatile CustomerTokenEntity customerTokenEntity;
    private boolean isStreamRiskDataFinish;
    private OperationModeConfig operationModeConfig;
    private String pubKey;
    private HuiYanAuthResultListener resultListener;
    private String selectData;
    private boolean shouldShowCustomerTxt;
    private String turingActiveParam;

    public CommonDataCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.configListeners = new LinkedList();
        this.isStreamRiskDataFinish = false;
        this.shouldShowCustomerTxt = false;
        this.pubKey = "";
        this.turingActiveParam = "";
        this.selectData = "";
        this.actionData = "";
    }

    public void addConfigListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
        } else {
            this.configListeners.add(cVar);
        }
    }

    public String getActionData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.actionData;
    }

    public ConfigEntity getConfigEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ConfigEntity) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ConfigEntity configEntity = this.configEntity;
        if (configEntity == null) {
            return new ConfigEntity();
        }
        return configEntity;
    }

    public CustomerConfig getCustomerConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CustomerConfig) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.customerConfig;
    }

    public CustomerTokenEntity getCustomerTokenEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CustomerTokenEntity) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.customerTokenEntity;
    }

    public OperationModeConfig getOperationModeConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (OperationModeConfig) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        OperationModeConfig operationModeConfig = this.operationModeConfig;
        if (operationModeConfig == null) {
            return new OperationModeConfig();
        }
        return operationModeConfig;
    }

    public String getPubKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.pubKey;
    }

    public HuiYanAuthResultListener getResultListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HuiYanAuthResultListener) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.resultListener;
    }

    public String getSelectData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.selectData;
    }

    public String getTuringActiveParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.turingActiveParam;
    }

    public boolean isShouldShowCustomerTxt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.shouldShowCustomerTxt;
    }

    public boolean isStreamRiskDataFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.isStreamRiskDataFinish;
    }

    public void onConfigListenerSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Iterator<c> it = this.configListeners.iterator();
        while (it.hasNext()) {
            it.next().onSuccess();
        }
    }

    public void removeConfigListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
        } else if (this.configListeners.contains(cVar)) {
            this.configListeners.remove(cVar);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.customerTokenEntity != null) {
            this.customerTokenEntity.reset();
        }
        if (this.resultListener != null) {
            this.resultListener = null;
        }
        if (this.customerConfig != null) {
            this.customerConfig = null;
        }
        this.configListeners.clear();
        this.isStreamRiskDataFinish = false;
        this.shouldShowCustomerTxt = false;
        this.pubKey = "";
        this.turingActiveParam = "";
        this.selectData = "";
        this.actionData = "";
    }

    public void setActionData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.actionData = str;
        }
    }

    public void setConfigEntity(ConfigEntity configEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) configEntity);
        } else {
            this.configEntity = configEntity;
        }
    }

    public void setCustomerConfig(CustomerConfig customerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) customerConfig);
        } else {
            this.customerConfig = customerConfig;
        }
    }

    public void setOperationModeConfig(OperationModeConfig operationModeConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) operationModeConfig);
        } else {
            this.operationModeConfig = operationModeConfig;
        }
    }

    public void setPubKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.pubKey = str;
        }
    }

    public void setResultListener(HuiYanAuthResultListener huiYanAuthResultListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) huiYanAuthResultListener);
        } else {
            this.resultListener = huiYanAuthResultListener;
        }
    }

    public void setSelectData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.selectData = str;
        }
    }

    public void setShouldShowCustomerTxt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.shouldShowCustomerTxt = z16;
        }
    }

    public void setStreamRiskDataFinish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.isStreamRiskDataFinish = z16;
        }
    }

    public void setTuringActiveParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.turingActiveParam = str;
        }
    }

    public void updateCustomerTokenEntity(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
        } else if (this.customerTokenEntity == null) {
            this.customerTokenEntity = new CustomerTokenEntity(z16, str);
        } else {
            this.customerTokenEntity.updateTokenEntity(z16, str);
        }
    }
}
