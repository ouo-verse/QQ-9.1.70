package com.tencent.thumbplayer.core.datatransport.apiinner;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportNativeLibLoader;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportOfflineTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportPreloadTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportServiceListener;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;

/* loaded from: classes26.dex */
public interface ITPDataTransportMgrBridge {
    int checkFileCacheStatus(int i3, String str, int i16);

    boolean clearCache(int i3, String str, int i16);

    boolean clearRangeCache(int i3, String str, int i16, int i17);

    String getBizAccessibleNativeInfo(int i3, int i16);

    long getFileCacheSize(int i3, String str);

    String getGlobalAccessibleNativeInfo(int i3);

    String getNativeLibVersion();

    ITPDataTransportOfflineTaskMgr getOfflineTaskMgr();

    ITPDataTransportPreloadTaskMgr getPreloadTaskMgr();

    ITPDataTransportTaskMgr getTaskMgr();

    boolean init(Context context);

    boolean isNativeInit();

    int registerBizId(int i3, String str);

    int registerBizId(@NonNull String str);

    void registerCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener);

    void registerServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener);

    boolean setBizOptionalConfigParam(int i3, String str, String str2);

    boolean setGlobalOptionalConfigParam(String str, String str2);

    void setThirdNativeLibLoader(ITPDataTransportNativeLibLoader iTPDataTransportNativeLibLoader);

    void startBindingService();

    void unregisterBizId(int i3);

    void unregisterCommonInfoListener(ITPDataTransportCommonInfoListener iTPDataTransportCommonInfoListener);

    void unregisterServiceListener(ITPDataTransportServiceListener iTPDataTransportServiceListener);
}
