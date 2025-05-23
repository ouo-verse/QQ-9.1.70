package com.tencent.mobileqq.filemanager.fileviewer.docs;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;

/* loaded from: classes12.dex */
public class TroopDocsPreviewConfigProcessor extends BaseConfigParser<b> {
    public static b c() {
        return (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_local_file_web_online_preview");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        b l3 = b.l(new String(bArr, StandardCharsets.UTF_8));
        if (l3 == null) {
            return defaultConfig();
        }
        return l3;
    }
}
