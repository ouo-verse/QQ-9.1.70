package com.tencent.thumbplayer.common.annotation;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* loaded from: classes26.dex */
public class TPOptionalParamUtil {
    @Nullable
    public static TPOptionalParam<?> optOptionalParam(String str, TPOptionalParamValueAnnotation tPOptionalParamValueAnnotation) {
        if (!TextUtils.isEmpty(str) && tPOptionalParamValueAnnotation != null) {
            if (tPOptionalParamValueAnnotation.type() == Integer.TYPE) {
                return TPOptionalParam.buildInt(str, tPOptionalParamValueAnnotation.intValue());
            }
            if (tPOptionalParamValueAnnotation.type() == Long.TYPE) {
                return TPOptionalParam.buildLong(str, tPOptionalParamValueAnnotation.longValue());
            }
            if (tPOptionalParamValueAnnotation.type() == Float.TYPE) {
                return TPOptionalParam.buildFloat(str, tPOptionalParamValueAnnotation.floatValue());
            }
            if (tPOptionalParamValueAnnotation.type() == String.class) {
                return TPOptionalParam.buildString(str, tPOptionalParamValueAnnotation.stringValue());
            }
            if (tPOptionalParamValueAnnotation.type() == Boolean.TYPE) {
                return TPOptionalParam.buildBoolean(str, tPOptionalParamValueAnnotation.booleanValue());
            }
            if (tPOptionalParamValueAnnotation.type() == int[].class) {
                return TPOptionalParam.buildQueueInt(str, tPOptionalParamValueAnnotation.queueIntValue());
            }
            if (tPOptionalParamValueAnnotation.type() == String[].class) {
                return TPOptionalParam.buildQueueString(str, tPOptionalParamValueAnnotation.queueStringValue());
            }
        }
        return null;
    }
}
