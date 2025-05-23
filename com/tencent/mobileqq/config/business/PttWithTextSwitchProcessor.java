package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class PttWithTextSwitchProcessor extends BaseConfigParser<av> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public av defaultConfig() {
        return new av();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(av avVar) {
        if (QLog.isColorLevel()) {
            QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + avVar.toString());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public av parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("PttWithTextSwitchProcessor", 2, "PttWithTextSwitchBean parse null");
            }
            return new av();
        }
        av c16 = av.c(str);
        if (QLog.isColorLevel()) {
            QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + str);
        }
        return c16;
    }
}
