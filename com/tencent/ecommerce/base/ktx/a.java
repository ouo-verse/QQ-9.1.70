package com.tencent.ecommerce.base.ktx;

import android.os.Bundle;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/os/Bundle;", "", "key", "Lcom/tencent/ecommerce/base/ktx/ECSchemeExtUserDataMap;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a {
    public static final ECSchemeExtUserDataMap a(Bundle bundle, String str) {
        Serializable serializable = bundle.getSerializable(str);
        int i3 = 1;
        Map map = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (serializable != null) {
            if (!(serializable instanceof ECSchemeExtUserDataMap)) {
                serializable = null;
            }
            ECSchemeExtUserDataMap eCSchemeExtUserDataMap = (ECSchemeExtUserDataMap) serializable;
            if (eCSchemeExtUserDataMap != null) {
                return eCSchemeExtUserDataMap;
            }
            return new ECSchemeExtUserDataMap(map, i3, b18 == true ? 1 : 0);
        }
        return new ECSchemeExtUserDataMap(b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
    }
}
