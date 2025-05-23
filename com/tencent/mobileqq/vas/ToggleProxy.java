package com.tencent.mobileqq.vas;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IToggleData;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ToggleProxy extends BaseConfigProxy {
    public static final String TAG = "VasToggle";
    private boolean isLogResult;

    public ToggleProxy(String str) {
        super(str, false);
        this.isLogResult = false;
    }

    public <T> T getBean(Class<T> cls, @Nullable T t16) {
        T t17 = (T) ((IToggleData) QRoute.api(IToggleData.class)).onGetBean(getName(), cls, t16);
        if (this.isLogResult) {
            ((IToggleData) QRoute.api(IToggleData.class)).i(getName(), String.valueOf(t17));
        }
        return t17;
    }

    @Deprecated
    public JSONObject getJsonString() {
        JSONObject onGetJsonString = ((IToggleData) QRoute.api(IToggleData.class)).onGetJsonString(getName());
        if (this.isLogResult) {
            ((IToggleData) QRoute.api(IToggleData.class)).i(getName(), String.valueOf(onGetJsonString));
        }
        return onGetJsonString;
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public int onGetInt(int i3) {
        return ((IToggleData) QRoute.api(IToggleData.class)).onGetInt(getName(), i3);
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public JSONObject onGetJson() {
        return getJsonString();
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public String onGetStringData(String str) {
        return ((IToggleData) QRoute.api(IToggleData.class)).onGetStringData(getName(), str);
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public String onGetStringDataSet(String str, String str2) {
        return ((IToggleData) QRoute.api(IToggleData.class)).onGetStringDataSet(getName(), str, str2);
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public boolean onIsEnable(boolean z16) {
        boolean onIsEnable = ((IToggleData) QRoute.api(IToggleData.class)).onIsEnable(this.isLogResult, getName(), z16);
        if (this.isLogResult) {
            ((IToggleData) QRoute.api(IToggleData.class)).i(getName(), String.valueOf(onIsEnable));
        }
        return onIsEnable;
    }

    public ToggleProxy(String str, boolean z16) {
        super(str, false);
        this.isLogResult = z16;
    }

    public ToggleProxy(String str, boolean z16, boolean z17) {
        super(str, z17);
        this.isLogResult = false;
    }
}
