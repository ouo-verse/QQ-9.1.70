package org.jf.dexlib2;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ValueType {
    public static final int ANNOTATION = 29;
    public static final int ARRAY = 28;
    public static final int BOOLEAN = 31;
    public static final int BYTE = 0;
    public static final int CHAR = 3;
    public static final int DOUBLE = 17;
    public static final int ENUM = 27;
    public static final int FIELD = 25;
    public static final int FLOAT = 16;
    public static final int INT = 4;
    public static final int LONG = 6;
    public static final int METHOD = 26;
    public static final int METHOD_HANDLE = 22;
    public static final int METHOD_TYPE = 21;
    public static final int NULL = 30;
    public static final int SHORT = 2;
    public static final int STRING = 23;
    public static final int TYPE = 24;

    ValueType() {
    }

    public static String getValueTypeName(int i3) {
        if (i3 != 0) {
            if (i3 != 6) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 16) {
                                if (i3 != 17) {
                                    switch (i3) {
                                        case 21:
                                            return "method_type";
                                        case 22:
                                            return "method_handle";
                                        case 23:
                                            return HippyControllerProps.STRING;
                                        case 24:
                                            return "type";
                                        case 25:
                                            return "field";
                                        case 26:
                                            return "method";
                                        case 27:
                                            return "enum";
                                        case 28:
                                            return HippyControllerProps.ARRAY;
                                        case 29:
                                            return "annotation";
                                        case 30:
                                            return "null";
                                        case 31:
                                            return HippyControllerProps.BOOLEAN;
                                        default:
                                            throw new IllegalArgumentException("Unknown encoded value type: " + i3);
                                    }
                                }
                                return "double";
                            }
                            return "float";
                        }
                        return PoiListCacheRecord.WEIGHT_TYPE;
                    }
                    return WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR;
                }
                return Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
            }
            return PoiListCacheRecord.TIMESTAMP_TYPE;
        }
        return "byte";
    }
}
