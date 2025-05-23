package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class QConfPushProcessor extends BaseConfigParser<ax> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ax defaultConfig() {
        return new ax();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable ax axVar) {
        super.doOnConfigUpdate(axVar);
        ((PushNotificationManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER)).i(axVar);
        QLog.i("QConfPushProcessor", 1, "onUpdate " + axVar);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ax parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (!TextUtils.isEmpty(str)) {
            ax e16 = ax.e(str);
            QLog.i("QConfPushProcessor", 1, "onParsed " + str);
            return e16;
        }
        return new ax();
    }
}
