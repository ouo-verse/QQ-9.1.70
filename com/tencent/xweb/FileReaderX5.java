package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileReaderX5 {
    public static final int ERR_CODE_DISABLE = -100005;
    public static final int ERR_CODE_INIT_FAILED = -100003;
    public static final int ERR_CODE_NOT_SUPPORT = -100002;
    public static final int ERR_CODE_NOT_SUPPORT_64 = -100004;
    public static final int ERR_CODE_PARAM = -100001;

    public static void readFile(int i3, Context context, String str, String str2, String str3, boolean z16, HashMap<String, String> hashMap, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2) {
        String str4;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("readFile by x5, fileExt: ");
        String str5 = "null";
        if (str2 == null) {
            str4 = "null";
        } else {
            str4 = str2;
        }
        sb5.append(str4);
        x0.d("FileReaderX5", sb5.toString());
        long reportFileSize = FileReaderHelper.reportFileSize(str, str2);
        FileReaderHelper.reportPVUV(str2, FileReaderHelper.ReaderType.X5.name());
        FileReaderHelper.reportReadByX5Scene(str2, i3);
        FileReaderHelper.OpenFileReportData openFileReportData = new FileReaderHelper.OpenFileReportData(FileReaderHelper.getOpenFileScene(hashMap), str2, reportFileSize, FileReaderHelper.READER_TYPE_MINIQB, -1, FileReaderHelper.convertOpenFileFrom(i3));
        openFileReportData.markStart(context);
        FileReaderHelper.reportOpenFile(openFileReportData);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("readFile by x5, disable x5, fileExt: ");
        if (str2 != null) {
            str5 = str2;
        }
        sb6.append(str5);
        x0.d("FileReaderX5", sb6.toString());
        FileReaderHelper.reportX5ErrorCode(str2, ERR_CODE_DISABLE, true, i3, context, openFileReportData);
        valueCallback2.onReceiveValue(-102);
    }

    public static void finishReadFile(Context context, String str, String str2) {
    }
}
