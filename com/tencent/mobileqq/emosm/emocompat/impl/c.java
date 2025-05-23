package com.tencent.mobileqq.emosm.emocompat.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.api.IHotPicPageApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
        QQToast.makeText(QBaseActivity.sTopActivity, R.string.fkh, 0).show();
    }

    public static void c(com.tencent.aio.api.runtime.a aVar, EmotionSearchItem emotionSearchItem, String str, String str2) {
        String str3;
        File diskFile = com.tencent.mobileqq.hotpic.b.getDiskFile(emotionSearchItem.originalUrl);
        if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
            str3 = diskFile.getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d("GuildHotPicSenderApi", 2, "senHotPic, urlHotPicOringinal = " + emotionSearchItem.originalUrl + ", paths = " + str3);
            }
        } else if (((IHotPicPageApi) QRoute.api(IHotPicPageApi.class)).checkAndDownLoadHotPic(emotionSearchItem) == 0) {
            str3 = com.tencent.mobileqq.hotpic.b.getDiskFile(emotionSearchItem.url).getAbsolutePath();
            if (QLog.isColorLevel()) {
                QLog.d("GuildHotPicSenderApi", 2, "senHotPic, urlHotPic = " + emotionSearchItem.url + ", paths = " + str3);
            }
        } else {
            str3 = null;
        }
        String str4 = str3;
        if (str4 == null && TextUtils.isEmpty(emotionSearchItem.videoFileId)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.emocompat.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.b();
                }
            });
        } else {
            GuildPicSenderApi.c(aVar, str4, str, str2, 2, false);
        }
    }
}
