package com.tencent.richframework.data.base.converter;

import androidx.annotation.NonNull;
import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BoolDataConverter implements IDataConverter<Boolean> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    public Boolean cloneConvertData(Boolean bool) {
        return bool;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    public String getObserverKey(Boolean bool) {
        return null;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    public void update(@NonNull Boolean bool, @NonNull Boolean bool2) {
    }
}
