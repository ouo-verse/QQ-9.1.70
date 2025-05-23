package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;

/* loaded from: classes22.dex */
public class PathDataUtils {
    public static boolean canCollect(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return false;
        }
        return isExistElementId(dataEntity);
    }

    private static boolean isExistElementId(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return false;
        }
        return !TextUtils.isEmpty(DataEntityOperator.getElementId(dataEntity));
    }

    public static boolean shouldStop(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return false;
        }
        return !TextUtils.isEmpty(DataEntityOperator.getPageId(dataEntity));
    }
}
