package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import java.util.Map;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IReportService extends IBaseService {
    void reportEvent(String str, Object obj, Map<String, String> map) throws NoSuchMethodException;

    void reportEvent(String str, Map<String, Object> map) throws NoSuchMethodException;

    void setElementClickPolicy(Object obj, ClickPolicy clickPolicy) throws NoSuchMethodException;

    void setElementEndExposePolicy(Object obj, EndExposurePolicy endExposurePolicy) throws NoSuchMethodException;

    void setElementExposePolicy(Object obj, ExposurePolicy exposurePolicy) throws NoSuchMethodException;

    void setElementId(Object obj, String str) throws NoSuchMethodException;

    void setElementParams(Object obj, Map<String, String> map) throws NoSuchMethodException;

    void setPageId(Object obj, String str) throws NoSuchMethodException;

    void setPageParams(Object obj, Map<String, Object> map) throws NoSuchMethodException;
}
