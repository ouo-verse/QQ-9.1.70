package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MessageCodecV2 extends MessageCodec {
    @Override // com.huawei.hms.core.aidl.MessageCodec
    protected List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i3 = bundle.getInt("_list_size_");
        ArrayList arrayList = new ArrayList(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            Object obj = bundle.get("_list_item_" + i16);
            if (!obj.getClass().isPrimitive() && !(obj instanceof String) && !(obj instanceof Serializable)) {
                if (obj instanceof Bundle) {
                    Bundle bundle2 = (Bundle) obj;
                    int i17 = bundle2.getInt("_val_type_", -1);
                    if (i17 != 1) {
                        if (i17 == 0) {
                            arrayList.add(decode(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                        } else {
                            throw new InstantiationException("Unknown type can not be supported");
                        }
                    } else {
                        throw new InstantiationException("Nested List can not be supported");
                    }
                } else {
                    continue;
                }
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    protected void writeList(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            writeValue("_list_item_" + i3, list.get(i3), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
