package com.tencent.kuikly.core.render.android.css.ktx;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.SizeF;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.exception.KRKotlinBizException;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tdf.utils.TDFListUtils;
import com.tencent.tdf.utils.TDFMapUtils;
import d01.e;
import d01.f;
import d01.u;
import i01.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001f\u0010\u0006\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001f\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001f\u0010\r\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\r\u0010\u0007\u001a\u0014\u0010\u000e\u001a\u00020\b*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001f\u0010\u000f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u000f\u0010\u000b\u001a\u001f\u0010\u0010\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0007\u001a\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\b*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001f\u0010\u0015\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0015\u0010\u000b\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0016\u001a\u0014\u0010\u001a\u001a\u00020\u0018*\u0004\u0018\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u0018\u001a\u001f\u0010\u001b\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u0018*\u0004\u0018\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u0018\u001a\u001f\u0010\u001e\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001c\u001a\u0006\u0010\u001f\u001a\u00020\u0004\u001a\f\u0010\"\u001a\u00020!*\u00020 H\u0000\u001a\u001a\u0010&\u001a\u00020%*\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\u00160#H\u0000\u001a\u0012\u0010)\u001a\u00020(*\b\u0012\u0004\u0012\u00020\u00160'H\u0000\u001a\u0016\u0010+\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00160**\u00020%\u001a\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160,*\u00020(\u001a)\u00100\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'2\u0006\u0010/\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b0\u00101\u001a!\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'H\u0000\u00a2\u0006\u0004\b2\u00103\u001a!\u00104\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'H\u0000\u00a2\u0006\u0004\b4\u00103\u001a!\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'H\u0000\u00a2\u0006\u0004\b5\u00103\u001a!\u00106\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'H\u0000\u00a2\u0006\u0004\b6\u00103\u001a!\u00107\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'H\u0000\u00a2\u0006\u0004\b7\u00103\u001a!\u00108\u001a\u00028\u0000\"\u0004\b\u0000\u0010.*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160'H\u0000\u00a2\u0006\u0004\b8\u00103\u001a\f\u0010:\u001a\u00020$*\u000209H\u0000\u001a\n\u0010;\u001a\u00020$*\u000209\u001a\n\u0010<\u001a\u00020\b*\u00020$\u001a\n\u0010=\u001a\u00020$*\u00020\u0016\"\u0015\u0010A\u001a\u00020\b*\u00020>8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\"\u0015\u0010C\u001a\u00020\b*\u00020>8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010@\"(\u0010I\u001a\u00020>*\u00020D2\u0006\u0010\u0002\u001a\u00020>8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\"\u0015\u0010L\u001a\u00020\b*\u00020D8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0015\u0010N\u001a\u00020\b*\u00020D8F\u00a2\u0006\u0006\u001a\u0004\bM\u0010K\"\u001a\u0010R\u001a\u0004\u0018\u00010O*\u00020 8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010Q\u00a8\u0006S"}, d2 = {"Lcom/tencent/kuikly/core/render/android/a;", "", "value", "I", "", "useHostDisplayMetrics", "J", "(Ljava/lang/Boolean;F)F", "", "K", "L", "(Ljava/lang/Boolean;F)I", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "Landroid/util/DisplayMetrics;", "e", "(Ljava/lang/Boolean;)Landroid/util/DisplayMetrics;", ReportConstant.COSTREPORT_PREFIX, "t", "", "H", "Landroid/util/SizeF;", "sizeF", "M", "N", "(Ljava/lang/Boolean;Landroid/util/SizeF;)Landroid/util/SizeF;", "B", BdhLogUtil.LogTag.Tag_Conn, "l", "Li01/c;", "", DomainData.DOMAIN_NAME, "", "", "Lorg/json/JSONObject;", "E", "", "Lorg/json/JSONArray;", "D", "", "G", "", UserInfo.SEX_FEMALE, "T", "index", "a", "(Ljava/util/List;I)Ljava/lang/Object;", "c", "(Ljava/util/List;)Ljava/lang/Object;", "o", "v", "d", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "O", "Landroid/graphics/Rect;", "j", "(Landroid/graphics/Rect;)I", "krWidth", "i", "krHeight", "Landroid/view/View;", "f", "(Landroid/view/View;)Landroid/graphics/Rect;", "p", "(Landroid/view/View;Landroid/graphics/Rect;)V", AIInput.KEY_FRAME, h.F, "(Landroid/view/View;)I", "frameWidth", "g", "frameHeight", "Landroid/view/ViewGroup;", "k", "(Li01/c;)Landroid/view/ViewGroup;", "viewGroup", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {
    public static final int A(@Nullable Boolean bool, float f16) {
        return (int) (y(bool, f16) + 0.5f);
    }

    @NotNull
    public static final SizeF B(@Nullable com.tencent.kuikly.core.render.android.a aVar, @NotNull SizeF sizeF) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(sizeF, "sizeF");
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return C(bool, sizeF);
    }

    @NotNull
    public static final SizeF C(@Nullable Boolean bool, @NotNull SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "sizeF");
        return new SizeF(y(bool, sizeF.getWidth()), y(bool, sizeF.getHeight()));
    }

    @NotNull
    public static final JSONArray D(@NotNull List<? extends Object> toJSONArray) {
        Intrinsics.checkNotNullParameter(toJSONArray, "$this$toJSONArray");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : toJSONArray) {
            if (obj instanceof Integer) {
                jSONArray.put(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                jSONArray.put(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                jSONArray.mo162put(obj);
            } else if (obj instanceof Double) {
                jSONArray.put(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                jSONArray.mo162put(obj);
            } else if (obj instanceof Boolean) {
                jSONArray.put(((Boolean) obj).booleanValue());
            } else if (obj instanceof Map) {
                if (obj != null) {
                    jSONArray.mo162put(E((Map) obj));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                }
            } else if (!(obj instanceof List)) {
                continue;
            } else if (obj != null) {
                jSONArray.mo162put(D((List) obj));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            }
        }
        return jSONArray;
    }

    @NotNull
    public static final JSONObject E(@NotNull Map<String, ? extends Object> toJSONObject) {
        Intrinsics.checkNotNullParameter(toJSONObject, "$this$toJSONObject");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : toJSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (value instanceof Integer) {
                    jSONObject.put(key, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    jSONObject.put(key, ((Number) value).longValue());
                } else if (value instanceof Double) {
                    jSONObject.put(key, ((Number) value).doubleValue());
                } else if (value instanceof Float) {
                    jSONObject.put(key, value);
                } else if (value instanceof String) {
                    jSONObject.put(key, value);
                } else if (value instanceof Boolean) {
                    jSONObject.put(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Map) {
                    if (value != null) {
                        jSONObject.put(key, E((Map) value));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                    }
                } else if (!(value instanceof List)) {
                    continue;
                } else if (value != null) {
                    jSONObject.put(key, D((List) value));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                }
            }
        }
        return jSONObject;
    }

    @NotNull
    public static final List<Object> F(@NotNull JSONArray toList) {
        Intrinsics.checkNotNullParameter(toList, "$this$toList");
        ArrayList arrayList = new ArrayList();
        int length = toList.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object opt = toList.opt(i3);
            if (opt instanceof Integer) {
                arrayList.add(opt);
            } else if (opt instanceof Long) {
                arrayList.add(opt);
            } else if (opt instanceof Float) {
                arrayList.add(opt);
            } else if (opt instanceof Double) {
                arrayList.add(opt);
            } else if (opt instanceof String) {
                arrayList.add(opt);
            } else if (opt instanceof Boolean) {
                arrayList.add(opt);
            } else if (opt instanceof JSONObject) {
                arrayList.add(G((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                arrayList.add(F((JSONArray) opt));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Map<String, Object> G(@NotNull JSONObject toMap) {
        Intrinsics.checkNotNullParameter(toMap, "$this$toMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = toMap.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object opt = toMap.opt(key);
            if (opt instanceof Integer) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            } else if (opt instanceof Long) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            } else if (opt instanceof Double) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            } else if (opt instanceof Float) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            } else if (opt instanceof String) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            } else if (opt instanceof Boolean) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt);
            } else if (opt instanceof JSONObject) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, G((JSONObject) opt));
            } else if (opt instanceof JSONArray) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, F((JSONArray) opt));
            }
        }
        return linkedHashMap;
    }

    public static final float H(@NotNull Object toNumberFloat) {
        Intrinsics.checkNotNullParameter(toNumberFloat, "$this$toNumberFloat");
        return ((Number) toNumberFloat).floatValue();
    }

    public static final float I(@Nullable com.tencent.kuikly.core.render.android.a aVar, float f16) {
        Boolean bool;
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return J(bool, f16);
    }

    public static final float J(@Nullable Boolean bool, float f16) {
        return TypedValue.applyDimension(1, f16, e(bool));
    }

    public static final int K(@Nullable com.tencent.kuikly.core.render.android.a aVar, float f16) {
        Boolean bool;
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return L(bool, f16);
    }

    public static final int L(@Nullable Boolean bool, float f16) {
        return (int) (J(bool, f16) + 0.5f);
    }

    @NotNull
    public static final SizeF M(@Nullable com.tencent.kuikly.core.render.android.a aVar, @NotNull SizeF sizeF) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(sizeF, "sizeF");
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return N(bool, sizeF);
    }

    @NotNull
    public static final SizeF N(@Nullable Boolean bool, @NotNull SizeF sizeF) {
        Intrinsics.checkNotNullParameter(sizeF, "sizeF");
        return new SizeF(J(bool, sizeF.getWidth()), J(bool, sizeF.getHeight()));
    }

    @NotNull
    public static final String O(@NotNull Object toTDFModuleCallResult) {
        Intrinsics.checkNotNullParameter(toTDFModuleCallResult, "$this$toTDFModuleCallResult");
        JSONObject jSONObject = new JSONObject();
        if (toTDFModuleCallResult instanceof Byte) {
            jSONObject.put("result", (int) ((Number) toTDFModuleCallResult).byteValue());
        } else if (toTDFModuleCallResult instanceof Integer) {
            jSONObject.put("result", ((Number) toTDFModuleCallResult).intValue());
        } else if (toTDFModuleCallResult instanceof Long) {
            jSONObject.put("result", ((Number) toTDFModuleCallResult).longValue());
        } else if (toTDFModuleCallResult instanceof Double) {
            jSONObject.put("result", ((Number) toTDFModuleCallResult).doubleValue());
        } else if (toTDFModuleCallResult instanceof Float) {
            jSONObject.put("result", toTDFModuleCallResult);
        } else if (toTDFModuleCallResult instanceof String) {
            jSONObject.put("result", toTDFModuleCallResult);
        } else if (toTDFModuleCallResult instanceof Boolean) {
            jSONObject.put("result", ((Boolean) toTDFModuleCallResult).booleanValue());
        } else if (toTDFModuleCallResult instanceof Map) {
            jSONObject.put("result", TDFMapUtils.toJSONObject((Map) toTDFModuleCallResult));
        } else if (toTDFModuleCallResult instanceof List) {
            jSONObject.put("result", TDFListUtils.toJSONArray((List) toTDFModuleCallResult));
        } else {
            jSONObject.put("result", toTDFModuleCallResult.toString());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObj.toString()");
        return jSONObject2;
    }

    public static final <T> T a(@NotNull List<? extends Object> arg, int i3) {
        Intrinsics.checkNotNullParameter(arg, "$this$arg");
        return (T) arg.get(i3);
    }

    public static final <T> T b(@NotNull List<? extends Object> fifthArg) {
        Intrinsics.checkNotNullParameter(fifthArg, "$this$fifthArg");
        return (T) a(fifthArg, 4);
    }

    public static final <T> T c(@NotNull List<? extends Object> firstArg) {
        Intrinsics.checkNotNullParameter(firstArg, "$this$firstArg");
        return (T) a(firstArg, 0);
    }

    public static final <T> T d(@NotNull List<? extends Object> fourthArg) {
        Intrinsics.checkNotNullParameter(fourthArg, "$this$fourthArg");
        return (T) a(fourthArg, 3);
    }

    private static final DisplayMetrics e(Boolean bool) {
        DisplayMetrics c16;
        f c17 = u.f392615m.c();
        if (c17 == null || (c16 = c17.c(bool)) == null) {
            Resources system = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
            DisplayMetrics displayMetrics = system.getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "Resources.getSystem().displayMetrics");
            return displayMetrics;
        }
        return c16;
    }

    @NotNull
    public static final Rect f(@NotNull View frame) {
        Intrinsics.checkNotNullParameter(frame, "$this$frame");
        Rect rect = new Rect();
        ViewGroup.LayoutParams layoutParams = frame.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(0, 0);
        }
        rect.left = marginLayoutParams.leftMargin;
        rect.top = marginLayoutParams.topMargin;
        rect.right = marginLayoutParams.width;
        rect.bottom = marginLayoutParams.height;
        return rect;
    }

    public static final int g(@NotNull View frameHeight) {
        Intrinsics.checkNotNullParameter(frameHeight, "$this$frameHeight");
        ViewGroup.LayoutParams layoutParams = frameHeight.getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    public static final int h(@NotNull View frameWidth) {
        Intrinsics.checkNotNullParameter(frameWidth, "$this$frameWidth");
        ViewGroup.LayoutParams layoutParams = frameWidth.getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.width;
        }
        return 0;
    }

    public static final int i(@NotNull Rect krHeight) {
        Intrinsics.checkNotNullParameter(krHeight, "$this$krHeight");
        return krHeight.bottom;
    }

    public static final int j(@NotNull Rect krWidth) {
        Intrinsics.checkNotNullParameter(krWidth, "$this$krWidth");
        return krWidth.right;
    }

    @Nullable
    public static final ViewGroup k(@NotNull c viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$viewGroup");
        View f16 = viewGroup.f();
        if (!(f16 instanceof ViewGroup)) {
            f16 = null;
        }
        return (ViewGroup) f16;
    }

    public static final boolean l() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        return Intrinsics.areEqual(currentThread, mainLooper.getThread());
    }

    @NotNull
    public static final String m(@NotNull Throwable kuiklyExceptionStackTraceToString) {
        Intrinsics.checkNotNullParameter(kuiklyExceptionStackTraceToString, "$this$kuiklyExceptionStackTraceToString");
        if (kuiklyExceptionStackTraceToString instanceof KRKotlinBizException) {
            String message = kuiklyExceptionStackTraceToString.getMessage();
            if (message == null) {
                return "null";
            }
            return message;
        }
        return u(kuiklyExceptionStackTraceToString);
    }

    public static final void n(@NotNull c removeFromParent) {
        Intrinsics.checkNotNullParameter(removeFromParent, "$this$removeFromParent");
        View f16 = removeFromParent.f();
        ViewParent parent = f16.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(f16);
            removeFromParent.e(viewGroup);
        }
    }

    public static final <T> T o(@NotNull List<? extends Object> secondArg) {
        Intrinsics.checkNotNullParameter(secondArg, "$this$secondArg");
        return (T) a(secondArg, 1);
    }

    public static final void p(@NotNull View frame, @NotNull Rect value) {
        Intrinsics.checkNotNullParameter(frame, "$this$frame");
        Intrinsics.checkNotNullParameter(value, "value");
        if (KRCSSViewExtensionKt.z()) {
            KRCSSViewExtensionKt.X(frame, value);
            return;
        }
        ViewGroup.LayoutParams layoutParams = frame.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(0, 0);
        }
        marginLayoutParams.leftMargin = value.left;
        marginLayoutParams.topMargin = value.top;
        marginLayoutParams.width = value.right;
        marginLayoutParams.height = value.bottom;
        frame.setLayoutParams(marginLayoutParams);
    }

    public static final <T> T q(@NotNull List<? extends Object> sixthArg) {
        Intrinsics.checkNotNullParameter(sixthArg, "$this$sixthArg");
        return (T) a(sixthArg, 5);
    }

    public static final float r(@Nullable Boolean bool, float f16) {
        return TypedValue.applyDimension(2, f16, e(bool));
    }

    public static final int s(@Nullable com.tencent.kuikly.core.render.android.a aVar, float f16) {
        Boolean bool;
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return t(bool, f16);
    }

    public static final int t(@Nullable Boolean bool, float f16) {
        return (int) (r(bool, f16) + 0.5f);
    }

    @NotNull
    public static final String u(@NotNull Throwable stackTraceToString) {
        Intrinsics.checkNotNullParameter(stackTraceToString, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        stackTraceToString.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    public static final <T> T v(@NotNull List<? extends Object> thirdArg) {
        Intrinsics.checkNotNullParameter(thirdArg, "$this$thirdArg");
        return (T) a(thirdArg, 2);
    }

    public static final int w(@NotNull String toColor) {
        Integer a16;
        Intrinsics.checkNotNullParameter(toColor, "$this$toColor");
        e b16 = u.f392615m.b();
        if (b16 != null && (a16 = b16.a(toColor)) != null) {
            return a16.intValue();
        }
        return (int) Long.parseLong(toColor);
    }

    public static final float x(@Nullable com.tencent.kuikly.core.render.android.a aVar, float f16) {
        Boolean bool;
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return y(bool, f16);
    }

    public static final float y(@Nullable Boolean bool, float f16) {
        return f16 / e(bool).density;
    }

    public static final int z(@Nullable com.tencent.kuikly.core.render.android.a aVar, float f16) {
        Boolean bool;
        if (aVar != null) {
            bool = Boolean.valueOf(aVar.M0());
        } else {
            bool = null;
        }
        return A(bool, f16);
    }
}
