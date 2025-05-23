package com.qzone.business.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {
    public static void a(Activity activity, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleAttention", "\u6ce8\u610f");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogSharing", "\u7ee7\u7eed\u5206\u4eab");
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle(config);
        if (TextUtils.isEmpty(str)) {
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogPermision", "\u4f60\u7684\u7a7a\u95f4\u6709\u6743\u9650\uff0c\u5206\u4eab\u540e\u7684\u9875\u9762\u6240\u6709\u4eba\u53ef\u89c1\uff0c\u662f\u5426\u7ee7\u7eed\u5206\u4eab\uff1f");
        }
        qQCustomDialog.setMessage(new StringBuilder(str));
        qQCustomDialog.setPositiveButton(config2, onClickListener);
        qQCustomDialog.setNegativeButton(R.string.cancel, onClickListener2);
        qQCustomDialog.show();
    }
}
