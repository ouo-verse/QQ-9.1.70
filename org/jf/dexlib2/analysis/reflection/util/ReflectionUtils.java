package org.jf.dexlib2.analysis.reflection.util;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.collect.ImmutableBiMap;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReflectionUtils {
    private static ImmutableBiMap<String, String> primitiveMap = ImmutableBiMap.builder().c(HippyControllerProps.BOOLEAN, "Z").c(PoiListCacheRecord.WEIGHT_TYPE, "I").c(PoiListCacheRecord.TIMESTAMP_TYPE, "J").c("double", "D").c("void", "V").c("float", UserInfo.SEX_FEMALE).c(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, BdhLogUtil.LogTag.Tag_Conn).c(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, ExifInterface.LATITUDE_SOUTH).c("byte", "B").a();

    public static String dexToJavaName(String str) {
        if (str.charAt(0) == '[') {
            return str.replace('/', '.');
        }
        if (primitiveMap.inverse().containsKey(str)) {
            return primitiveMap.inverse().get(str);
        }
        return str.replace('/', '.').substring(1, str.length() - 2);
    }

    public static String javaToDexName(String str) {
        if (str.charAt(0) == '[') {
            return str.replace('.', '/');
        }
        if (primitiveMap.containsKey(str)) {
            return primitiveMap.get(str);
        }
        return 'L' + str.replace('.', '/') + ';';
    }
}
