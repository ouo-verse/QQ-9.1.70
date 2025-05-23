package com.tencent.mobileqq.vas.adv.maskad.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes20.dex */
public class MaskAdConfigParser extends BaseConfigParser<MaskAdConfigBean> {
    public static final String GROUP_ID = "100225";
    private static final String TAG = "MaskAdConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public MaskAdConfigBean defaultConfig() {
        return new MaskAdConfigBean();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    public MaskAdConfigBean parse(@NotNull byte[] bArr) {
        MaskAdConfigBean maskAdConfigBean = new MaskAdConfigBean();
        if (bArr == null) {
            return maskAdConfigBean;
        }
        MaskAdConfigBean parse = MaskAdConfigBean.parse(new String(bArr, StandardCharsets.UTF_8));
        QLog.d(TAG, 1, "configs parse\uff1a" + parse);
        return parse;
    }
}
