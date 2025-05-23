package com.tencent.gamecenter.wadl.api;

import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameProviderService extends IRuntimeService {
    public static final String AUTHORITY = "com.tencent.mobileqq.openapi.provider";
    public static final String COLUMN_NAME_RS_CODE = "rs_code";
    public static final String PATH_MINI_APP = "/mini_app";
    public static final String PATH_TGPA_RES_TASK = "/res_task";
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PARAM_ERROR = -6;
    public static final int RESULT_SUPPORT = 1;
    public static final int RESULT_UNSUPPORTED = -5;

    int delete(Uri uri, String str, String[] strArr);

    boolean notifyInstall(String str);

    ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str);

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);
}
