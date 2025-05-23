package com.tencent.qqlive.superplayer.tools.utils;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private StringBuffer f345516a = new StringBuffer();

    public i a(String str, String str2) {
        String stringBuffer = this.f345516a.toString();
        String str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (stringBuffer.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = ContainerUtils.FIELD_DELIMITER;
        }
        this.f345516a.append(str3);
        this.f345516a.append(str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
        return this;
    }

    public i b(@NonNull Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public String c() {
        return this.f345516a.toString();
    }

    public i d(@NonNull String str) {
        this.f345516a.delete(0, this.f345516a.length());
        this.f345516a.append(str);
        return this;
    }
}
