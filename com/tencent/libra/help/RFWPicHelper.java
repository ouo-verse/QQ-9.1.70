package com.tencent.libra.help;

import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.mobileqq.R;

@Deprecated
/* loaded from: classes7.dex */
public class RFWPicHelper {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RFWPicHelper");

    public static void clearViewPicTag(View view) {
        if (view == null) {
            return;
        }
        view.setTag(R.id.yhw, null);
        RFWLog.w(TAG, RFWLog.USR, "[clearViewPicTag] view=" + view);
    }
}
