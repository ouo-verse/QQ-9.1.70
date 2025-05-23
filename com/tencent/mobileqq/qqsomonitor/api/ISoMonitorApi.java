package com.tencent.mobileqq.qqsomonitor.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ISoMonitorApi extends QRouteApi {
    int getSoFileFlag(Context context, File file);

    String getSoFileMd5(Context context, File file);

    boolean isSoFileLegal(Context context, File file);

    int isSoFileLegalDetail(Context context, File file);

    boolean isSoFileRegistered(Context context, File file);

    boolean isSoPathLegal(Context context, String str);

    boolean isSoPathRegistered(Context context, String str);

    void registerSoFile(Context context, File file);

    void registerSoFilePath(Context context, String str);
}
