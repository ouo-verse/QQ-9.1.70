package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchHistoryItemInfo {
    private static final String REGEX = "_";
    private static final String TAG = "QFSSearchHistoryItemInfo";
    public int count = 1;
    public boolean needLabel;
    public String searchHistoryWord;
    public String showText;

    @NotNull
    public static QFSSearchHistoryItemInfo fromConcatString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new QFSSearchHistoryItemInfo();
        }
        QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo = new QFSSearchHistoryItemInfo();
        String[] split = str.split("_");
        if (split.length > 0) {
            qFSSearchHistoryItemInfo.searchHistoryWord = split[0];
        }
        if (split.length > 1) {
            try {
                qFSSearchHistoryItemInfo.count = Integer.parseInt(split[1]);
            } catch (NumberFormatException e16) {
                QLog.e(TAG, 1, "NumberFormatException: ", e16);
            }
        }
        return qFSSearchHistoryItemInfo;
    }

    public String toConcatString() {
        return this.searchHistoryWord + "_" + this.count;
    }
}
