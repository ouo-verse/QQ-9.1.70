package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes18.dex */
public class RedDotConfProcessor extends BaseConfigParser<f> {
    private String d() {
        return ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f defaultConfig() {
        return new f();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable f fVar) {
        boolean z16;
        boolean z17;
        super.doOnConfigUpdate(fVar);
        if (fVar == null) {
            return;
        }
        int i3 = fVar.f287864d;
        int i16 = fVar.f287865e;
        int i17 = fVar.f287866f;
        int i18 = fVar.f287867h;
        String d16 = d();
        if (ShortVideoUtils.getHotPiCRedDotConfigVersion(d16) != i16) {
            ShortVideoUtils.setHotPiCRedDotConfigVersion(d16, i16);
            if (i3 == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            ShortVideoUtils.setHotPicRedDotStatus(d16, z17);
            ShortVideoUtils.isHotPicConfiginitied = false;
        }
        if (ShortVideoUtils.getPtvRedDotConfigVersion(d16) != i18) {
            ShortVideoUtils.setPtvRedDotConfigVersion(d16, i18);
            if (i17 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            ShortVideoUtils.setPtvRedDotStatus(d16, z16);
            ShortVideoUtils.isPtvConfiginitied = false;
        }
        QLog.i("ShortVideoAndHotPicRedDotConfProcessor", 1, "doOnConfigUpdate" + fVar.toString());
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public f parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (!TextUtils.isEmpty(str)) {
            f a16 = f.a(str);
            QLog.i("ShortVideoAndHotPicRedDotConfProcessor", 1, "onParsed " + str);
            return a16;
        }
        return new f();
    }
}
