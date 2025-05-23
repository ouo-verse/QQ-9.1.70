package com.tencent.hippy.qq.obj;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class HippyPadConfigBean implements IConfigData {

    @SerializedName("bundles")
    public List<String> bundleList = new ArrayList();

    @SerializedName("width")
    public int width;

    public String toString() {
        return "HippyPadConfigBean{width=" + this.width + ", bundleList=" + this.bundleList + '}';
    }
}
