package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import fa1.b;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQVoiceLauncher implements b {
    @Override // fa1.b
    public int getType() {
        return R.drawable.alert_dark_frame;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        String subType = colorNote.getSubType();
        if (TextUtils.isEmpty(subType)) {
            QLog.e("QQVoiceLauncher", 1, "roomId is null!");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            ax c16 = bi.c((QQAppInterface) runtime, context, String.format("mqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%s&fromid=10026&first=2&startsrc=10026&source=37&roomtype=10001&odgameid=100&first_jump_mode=plugin&is_record=2&enter_record_if_finish=0&nowplugin_ext=%s", subType, new String(Base64.encode("from_vr=102".getBytes(), 0))));
            if (c16 != null) {
                c16.b();
                return;
            } else {
                QLog.e("QQVoiceLauncher", 1, "jumpAction is null!");
                return;
            }
        }
        QLog.e("QQVoiceLauncher", 1, "QQAppInterface is null!");
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
