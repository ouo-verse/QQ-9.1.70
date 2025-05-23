package com.tencent.biz.richframework.localupload.recommend.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.mobileqq.app.AppConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J \u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004J\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/utils/RFWRecommendUtil;", "", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "", "jsonStr", "parseFromJson", "", "isExistSDCard", "", "getSDCardAvailableSize", "getSystemAvailableSize", "paramString", "", "jsonToMap", "configKey", "convertConfigToMap", "getResidentCityConfig", "getClassifyTitleConfig", "getClassifyConfig", "Landroid/media/ExifInterface;", "exifInterface", "path", "", "getRationalLatLon", "rationalString", "ref", "", "convertRationalLatLonToFloat", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWRecommendUtil {

    @NotNull
    public static final RFWRecommendUtil INSTANCE = new RFWRecommendUtil();

    RFWRecommendUtil() {
    }

    private final String parseFromJson(RecommendContext context, String jsonStr) {
        boolean startsWith$default;
        if (TextUtils.isEmpty(jsonStr)) {
            return "";
        }
        Intrinsics.checkNotNull(jsonStr);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jsonStr, "{", false, 2, null);
        if (!startsWith$default) {
            return jsonStr;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonStr);
            jSONObject.optString("name");
            JSONArray optJSONArray = jSONObject.optJSONArray("titles");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                return optJSONArray.get((int) (Math.random() * optJSONArray.length())).toString();
            }
        } catch (JSONException e16) {
            context.e("RFWRecommendUtil", "parseFromJson error " + e16);
        }
        return "";
    }

    @NotNull
    public final Map<String, String> convertConfigToMap(@NotNull RecommendContext context, @NotNull String configKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        String config = context.getDelegate().getConfigDelegate().getConfig(configKey);
        context.d("RFWRecommendUtil", "convertConfigToMap configKey=" + configKey + " localConfig=" + config);
        return jsonToMap(context, config);
    }

    public final float convertRationalLatLonToFloat(@NotNull RecommendContext context, @NotNull String rationalString, @NotNull String ref) {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        int i17;
        boolean z18;
        int i18;
        boolean z19;
        int i19;
        boolean z26;
        int i26;
        boolean z27;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rationalString, "rationalString");
        Intrinsics.checkNotNullParameter(ref, "ref");
        try {
            Object[] array = new Regex(",").split(rationalString, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            Object[] array2 = new Regex("/").split(strArr[0], 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            String str = strArr2[0];
            int i27 = 1;
            int length = str.length() - 1;
            int i28 = 0;
            boolean z28 = false;
            while (i28 <= length) {
                if (!z28) {
                    i26 = i28;
                } else {
                    i26 = length;
                }
                if (Intrinsics.compare((int) str.charAt(i26), 32) <= 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (!z28) {
                    if (!z27) {
                        z28 = true;
                    } else {
                        i28++;
                    }
                } else {
                    if (!z27) {
                        break;
                    }
                    length--;
                }
            }
            double parseDouble = Double.parseDouble(str.subSequence(i28, length + 1).toString());
            String str2 = strArr2[1];
            int length2 = str2.length() - 1;
            int i29 = 0;
            boolean z29 = false;
            while (i29 <= length2) {
                if (!z29) {
                    i19 = i29;
                } else {
                    i19 = length2;
                }
                if (Intrinsics.compare((int) str2.charAt(i19), 32) <= 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (!z29) {
                    if (!z26) {
                        z29 = true;
                    } else {
                        i29++;
                    }
                } else {
                    if (!z26) {
                        break;
                    }
                    length2--;
                }
            }
            double parseDouble2 = parseDouble / Double.parseDouble(str2.subSequence(i29, length2 + 1).toString());
            Object[] array3 = new Regex("/").split(strArr[1], 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr3 = (String[]) array3;
            String str3 = strArr3[0];
            int length3 = str3.length() - 1;
            int i36 = 0;
            boolean z36 = false;
            while (i36 <= length3) {
                if (!z36) {
                    i18 = i36;
                } else {
                    i18 = length3;
                }
                if (Intrinsics.compare((int) str3.charAt(i18), 32) <= 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z36) {
                    if (!z19) {
                        z36 = true;
                    } else {
                        i36++;
                    }
                } else {
                    if (!z19) {
                        break;
                    }
                    length3--;
                }
            }
            double parseDouble3 = Double.parseDouble(str3.subSequence(i36, length3 + 1).toString());
            String str4 = strArr3[1];
            int length4 = str4.length() - 1;
            int i37 = 0;
            boolean z37 = false;
            while (true) {
                if (i37 > length4) {
                    break;
                }
                if (!z37) {
                    i17 = i37;
                } else {
                    i17 = length4;
                }
                if (Intrinsics.compare((int) str4.charAt(i17), 32) <= 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z37) {
                    if (!z18) {
                        i27 = 1;
                        z37 = true;
                    } else {
                        i37++;
                    }
                } else {
                    if (!z18) {
                        i27 = 1;
                        break;
                    }
                    length4--;
                }
                i27 = 1;
            }
            double parseDouble4 = parseDouble3 / Double.parseDouble(str4.subSequence(i37, length4 + i27).toString());
            Object[] array4 = new Regex("/").split(strArr[2], 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr4 = (String[]) array4;
            String str5 = strArr4[0];
            int length5 = str5.length() - 1;
            boolean z38 = false;
            int i38 = 0;
            while (i38 <= length5) {
                if (!z38) {
                    i16 = i38;
                } else {
                    i16 = length5;
                }
                if (Intrinsics.compare((int) str5.charAt(i16), 32) <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z38) {
                    if (!z17) {
                        z38 = true;
                    } else {
                        i38++;
                    }
                } else {
                    if (!z17) {
                        break;
                    }
                    length5--;
                }
            }
            double parseDouble5 = Double.parseDouble(str5.subSequence(i38, length5 + 1).toString());
            String str6 = strArr4[1];
            int length6 = str6.length() - 1;
            boolean z39 = false;
            int i39 = 0;
            while (i39 <= length6) {
                if (!z39) {
                    i3 = i39;
                } else {
                    i3 = length6;
                }
                if (Intrinsics.compare((int) str6.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z39) {
                    if (!z16) {
                        z39 = true;
                    } else {
                        i39++;
                    }
                } else {
                    if (!z16) {
                        break;
                    }
                    length6--;
                }
            }
            double parseDouble6 = parseDouble2 + (parseDouble4 / 60.0d) + ((parseDouble5 / Double.parseDouble(str6.subSequence(i39, length6 + 1).toString())) / 3600.0d);
            if (!Intrinsics.areEqual(ref, ExifInterface.LATITUDE_SOUTH)) {
                if (!Intrinsics.areEqual(ref, "W")) {
                    return (float) parseDouble6;
                }
            }
            return -((float) parseDouble6);
        } catch (ArrayIndexOutOfBoundsException e16) {
            context.e("RFWRecommendUtil", "[convertRationalLatLonToFloat] error1 " + e16);
            throw new IllegalArgumentException();
        } catch (NumberFormatException e17) {
            context.e("RFWRecommendUtil", "[convertRationalLatLonToFloat] error " + e17);
            throw new IllegalArgumentException();
        }
    }

    @NotNull
    public final String getClassifyConfig(@NotNull RecommendContext context, @NotNull String configKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Map<String, String> classifyCountConfig = context.getDelegate().getConfigDelegate().getClassifyCountConfig();
        if (!classifyCountConfig.isEmpty() && classifyCountConfig.get(configKey) != null) {
            return parseFromJson(context, classifyCountConfig.get(configKey));
        }
        return "";
    }

    @NotNull
    public final String getClassifyTitleConfig(@NotNull RecommendContext context, @NotNull String configKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Map<String, String> classifyTitleConfig = context.getDelegate().getConfigDelegate().getClassifyTitleConfig();
        if (!classifyTitleConfig.isEmpty() && classifyTitleConfig.get(configKey) != null) {
            return parseFromJson(context, classifyTitleConfig.get(configKey));
        }
        return "";
    }

    @Nullable
    public final float[] getRationalLatLon(@NotNull RecommendContext context, @NotNull android.media.ExifInterface exifInterface, @NotNull String path) {
        String attribute;
        String attribute2;
        String attribute3;
        String attribute4;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Intrinsics.checkNotNullParameter(path, "path");
        float[] fArr = new float[2];
        try {
            if (exifInterface.getLatLong(fArr)) {
                float f16 = fArr[0];
                if (f16 == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (fArr[1] == 0.0f) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        context.dev("RFWRecommendUtil", "[fillInfoByExif] getLatLong mLatitude: " + f16 + ", mLongitude: " + f16);
                        return fArr;
                    }
                }
            }
            attribute = exifInterface.getAttribute("GPSLatitude");
            attribute2 = exifInterface.getAttribute("GPSLongitude");
            attribute3 = exifInterface.getAttribute("GPSLatitudeRef");
            attribute4 = exifInterface.getAttribute("GPSLongitudeRef");
        } catch (Exception e16) {
            context.e("RFWRecommendUtil", "[fillInfoByExif] getLatLong error: " + e16);
        }
        if (attribute != null && attribute2 != null && attribute3 != null && attribute4 != null) {
            fArr[0] = convertRationalLatLonToFloat(context, attribute, attribute3);
            fArr[1] = convertRationalLatLonToFloat(context, attribute2, attribute4);
            float f17 = fArr[0];
            context.dev("RFWRecommendUtil", "[fillInfoByExif] getLatLong mLatitude: " + f17 + ", mLongitude: " + f17 + "\uff0c latValue: " + attribute + ", lngValue: " + attribute2 + ", latRef: " + attribute3 + ", lngRef: " + attribute4);
            return fArr;
        }
        context.e("RFWRecommendUtil", "[fillInfoByExif] getLatLong fail: " + path);
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        return fArr;
    }

    @NotNull
    public final String getResidentCityConfig(@NotNull RecommendContext context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, String> convertConfigToMap = convertConfigToMap(context, "resident_login_city");
        if (convertConfigToMap.isEmpty() || !convertConfigToMap.containsKey("frequent_login") || (str = convertConfigToMap.get("frequent_login")) == null) {
            return "";
        }
        return str;
    }

    public final long getSDCardAvailableSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long j3 = 1024;
            return ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / j3) / j3;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long getSystemAvailableSize() {
        try {
            StatFs statFs = new StatFs(AppConstants.GPROSDK_DATABASE_PATH);
            long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            long j3 = 1024;
            return (availableBlocks / j3) / j3;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final boolean isExistSDCard() {
        try {
            return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    @NotNull
    public final Map<String, String> jsonToMap(@NotNull RecommendContext context, @Nullable String paramString) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(paramString)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(paramString);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object opt = jSONObject.opt(key);
                if (opt != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, opt.toString());
                }
            }
        } catch (JSONException e16) {
            context.e("RFWRecommendUtil", "convertJsonToMap exception !" + e16);
        }
        return hashMap;
    }
}
