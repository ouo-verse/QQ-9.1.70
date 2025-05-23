package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.vivo.push.PushClientConstants;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, HippyControllerProps.BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, BdhLogUtil.LogTag.Tag_Conn, "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(PrimitiveType.INT, PoiListCacheRecord.WEIGHT_TYPE, "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", UserInfo.SEX_FEMALE, "java.lang.Float"),
    LONG(PrimitiveType.LONG, PoiListCacheRecord.TIMESTAMP_TYPE, "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");

    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;
    private static final Set<FqName> WRAPPERS_CLASS_NAMES = new HashSet();
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = new HashMap();
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        Object[] objArr;
        if (i3 != 2 && i3 != 4) {
            switch (i3) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i3 != 2 && i3 != 4) {
                switch (i3) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        i16 = 3;
                        break;
                }
                objArr = new Object[i16];
                switch (i3) {
                    case 1:
                    case 7:
                        objArr[0] = "name";
                        break;
                    case 2:
                    case 4:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                        break;
                    case 3:
                        objArr[0] = "type";
                        break;
                    case 5:
                    case 8:
                        objArr[0] = "desc";
                        break;
                    case 6:
                        objArr[0] = "primitiveType";
                        break;
                    case 9:
                        objArr[0] = "wrapperClassName";
                        break;
                    default:
                        objArr[0] = PushClientConstants.TAG_CLASS_NAME;
                        break;
                }
                if (i3 == 2 && i3 != 4) {
                    switch (i3) {
                        case 10:
                            objArr[1] = "getPrimitiveType";
                            break;
                        case 11:
                            objArr[1] = "getJavaKeywordName";
                            break;
                        case 12:
                            objArr[1] = "getDesc";
                            break;
                        case 13:
                            objArr[1] = "getWrapperFqName";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                            break;
                    }
                } else {
                    objArr[1] = "get";
                }
                switch (i3) {
                    case 1:
                    case 3:
                        objArr[2] = "get";
                        break;
                    case 2:
                    case 4:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    case 5:
                        objArr[2] = "getByDesc";
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        objArr[2] = "<init>";
                        break;
                    default:
                        objArr[2] = "isWrapperClassName";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 2 && i3 != 4) {
                    switch (i3) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i16 = 2;
            objArr = new Object[i16];
            switch (i3) {
            }
            if (i3 == 2) {
            }
            objArr[1] = "get";
            switch (i3) {
            }
            String format2 = String.format(str, objArr);
            if (i3 != 2) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 2) {
            switch (i3) {
            }
            objArr = new Object[i16];
            switch (i3) {
            }
            if (i3 == 2) {
            }
            objArr[1] = "get";
            switch (i3) {
            }
            String format22 = String.format(str, objArr);
            if (i3 != 2) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        objArr = new Object[i16];
        switch (i3) {
        }
        if (i3 == 2) {
        }
        objArr[1] = "get";
        switch (i3) {
        }
        String format222 = String.format(str, objArr);
        if (i3 != 2) {
        }
        throw new IllegalStateException(format222);
    }

    static {
        for (JvmPrimitiveType jvmPrimitiveType : values()) {
            WRAPPERS_CLASS_NAMES.add(jvmPrimitiveType.getWrapperFqName());
            TYPE_BY_NAME.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            TYPE_BY_PRIMITIVE_TYPE.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            TYPE_BY_DESC.put(jvmPrimitiveType.getDesc(), jvmPrimitiveType);
        }
    }

    JvmPrimitiveType(@NotNull PrimitiveType primitiveType, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        if (primitiveType == null) {
            $$$reportNull$$$0(6);
        }
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        if (str2 == null) {
            $$$reportNull$$$0(8);
        }
        if (str3 == null) {
            $$$reportNull$$$0(9);
        }
        this.primitiveType = primitiveType;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new FqName(str3);
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_NAME.get(str);
        if (jvmPrimitiveType != null) {
            return jvmPrimitiveType;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    @NotNull
    public String getDesc() {
        String str = this.desc;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        return str;
    }

    @NotNull
    public String getJavaKeywordName() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return str;
    }

    @NotNull
    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType = this.primitiveType;
        if (primitiveType == null) {
            $$$reportNull$$$0(10);
        }
        return primitiveType;
    }

    @NotNull
    public FqName getWrapperFqName() {
        FqName fqName = this.wrapperFqName;
        if (fqName == null) {
            $$$reportNull$$$0(13);
        }
        return fqName;
    }

    @NotNull
    public static JvmPrimitiveType get(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(3);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get(primitiveType);
        if (jvmPrimitiveType == null) {
            $$$reportNull$$$0(4);
        }
        return jvmPrimitiveType;
    }
}
