package com.tencent.aekit.api.standard.filter;

import java.util.List;
import java.util.Map;
import org.light.bean.WMElement;
import org.light.listener.OnClickWatermarkListener;
import org.light.listener.OnWatermarkDataListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IWatermarkHandle {
    void wmAddInfoDict(Map<String, String> map);

    List<WMElement> wmGetEditableWMElements();

    void wmSetLocation(String str);

    void wmSetOnClickWatermarkListener(OnClickWatermarkListener onClickWatermarkListener);

    void wmSetOnlineUsrCountDelegate(String str, OnWatermarkDataListener onWatermarkDataListener);

    void wmSetTemperature(String str);

    void wmSetWeatherCode(int i3);

    void wmSetWeatherStr(String str);
}
