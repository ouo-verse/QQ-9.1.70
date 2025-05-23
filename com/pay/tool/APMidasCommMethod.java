package com.pay.tool;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class APMidasCommMethod {
    private static Stack<Activity> activityStack;

    public static String MaptoString(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(entry.getValue());
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static String dealString(String str) {
        String rawString = rawString(str);
        if (rawString.length() <= 3) {
            return str;
        }
        if (rawString.length() > 3 && rawString.length() <= 6) {
            return str.substring(0, 3) + " " + str.substring(4, str.length());
        }
        if (rawString.length() > 6 && rawString.length() <= 9) {
            return str.substring(3, 6) + " " + str.substring(7, str.length());
        }
        if (rawString.length() > 9 && rawString.length() <= 12) {
            return str.substring(6, 9) + " " + str.substring(10, str.length());
        }
        return str;
    }

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String fenToYuan(String str, int i3) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
        if (i3 == 0) {
            decimalFormat.applyPattern("0");
        } else if (i3 == 1) {
            decimalFormat.applyPattern("0.0");
        } else if (i3 == 2) {
            decimalFormat.applyPattern("0.00");
        }
        try {
            return decimalFormat.format(Float.valueOf(str).floatValue() / 100.0f);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getAnimId(Context context, String str) {
        return context.getApplicationContext().getResources().getIdentifier(str, "anim", context.getApplicationContext().getPackageName());
    }

    public static String getApplicationPackageName() {
        PackageManager packageManager;
        try {
            Context context = APMidasPayAPI.fromApplicationContext;
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return "";
            }
            return InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 0).packageName;
        } catch (Exception e16) {
            APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + e16.toString());
            return "";
        }
    }

    public static String getApplicationVersion() {
        try {
            return InstalledAppListMonitor.getPackageInfo(APMidasPayAPI.fromApplicationContext.getPackageManager(), APMidasPayAPI.fromApplicationContext.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            APLog.i("APMidasCommMethod", "getApplicationVersion error:" + e16.toString());
            return "";
        }
    }

    public static int getColorId(Context context, String str) {
        return context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName()));
    }

    public static Drawable getDrawable(Context context, String str) {
        return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
    }

    public static int getDrawableId(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static int getId(Context context, String str) {
        return context.getResources().getIdentifier(str, "id", context.getPackageName());
    }

    public static int getLayoutId(Context context, String str) {
        return context.getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, context.getPackageName());
    }

    public static String getStringId(Context context, String str) {
        return context.getResources().getString(context.getResources().getIdentifier(str, HippyControllerProps.STRING, context.getPackageName()));
    }

    public static int getStyleId(Context context, String str) {
        return context.getResources().getIdentifier(str, "style", context.getPackageName());
    }

    public static void popActivity() {
        APLog.i("jar popActivity", "1");
        try {
        } catch (Exception e16) {
            APLog.i("jar popActivity ex", e16.toString());
        }
        if (activityStack == null) {
            return;
        }
        for (int i3 = 0; i3 < activityStack.size(); i3++) {
            if (activityStack.get(i3) != null) {
                activityStack.get(i3).finish();
            }
        }
        releaseActivityStack();
    }

    public static void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.push(activity);
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String rawString(String str) {
        return str.replace(" ", "");
    }

    public static void releaseActivityStack() {
        Stack<Activity> stack = activityStack;
        if (stack != null) {
            stack.clear();
        }
        activityStack = null;
    }

    public static void transformStrToList(String str, List<String> list) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        list.clear();
        if (indexOf != -1 && indexOf2 != -1 && indexOf2 > indexOf) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() != 0) {
                for (String str2 : substring.split(",")) {
                    list.add(str2);
                }
            }
        }
    }

    public static void transformStrToMap(String str, TreeMap<String, String> treeMap) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (indexOf != -1 && indexOf2 != -1 && indexOf2 > indexOf) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() == 0) {
                treeMap.clear();
                return;
            }
            String[] split = substring.split(",");
            int length = split.length;
            if (length > 0 && length % 2 == 0) {
                treeMap.clear();
                for (int i3 = 0; i3 < length / 2; i3++) {
                    int i16 = i3 * 2;
                    treeMap.put(split[i16], split[i16 + 1]);
                }
            }
        }
    }

    public static void transformStrToMpInfoList(String str, List<String> list, List<String> list2) {
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (indexOf != -1 && indexOf2 != -1 && indexOf2 > indexOf) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() == 0) {
                list.clear();
                list2.clear();
                return;
            }
            String[] split = substring.split(",");
            int length = split.length;
            if (length > 0 && length % 2 == 0) {
                list.clear();
                list2.clear();
                for (int i3 = 0; i3 < length / 2; i3++) {
                    int i16 = i3 * 2;
                    String str2 = split[i16];
                    String str3 = split[i16 + 1];
                    list.add(str2);
                    list2.add(str3);
                }
            }
        }
    }

    public static String MaptoString(HashMap<String, String> hashMap, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getValue());
            stringBuffer.append(str);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }
}
