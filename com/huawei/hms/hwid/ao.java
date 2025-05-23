package com.huawei.hms.hwid;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ao {
    public static void a(Activity activity) {
        if (aq.a()) {
            b(activity);
        }
    }

    protected static void b(Activity activity) {
        as.b("AccountSdkUtil", "enter initOnApplyWindowInsets", true);
        final ViewGroup viewGroup = (ViewGroup) activity.getWindow().findViewById(R.id.content);
        if (viewGroup == null) {
            as.b("AccountSdkUtil", "rootView is null", true);
        } else {
            c(activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.hms.hwid.ao.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    try {
                        Object invoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                        if (invoke == null) {
                            as.b("AccountSdkUtil", "sideRegion is null", true);
                        } else {
                            Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(invoke, new Object[0]);
                            as.b("AccountSdkUtil", "safeInsets LR: " + rect.left + ":" + rect.right, true);
                            as.b("AccountSdkUtil", "safeInsets TB: " + rect.top + ":" + rect.bottom, true);
                            ViewGroup viewGroup2 = viewGroup;
                            if (viewGroup2 != null) {
                                viewGroup2.setPadding(rect.left, 0, rect.right, 0);
                            }
                        }
                    } catch (ClassNotFoundException unused) {
                        as.d("AccountSdkUtil", "ClassNotFoundException onApplyWindowInsets", true);
                    } catch (IllegalAccessException unused2) {
                        as.d("AccountSdkUtil", "IllegalAccessException onApplyWindowInsets", true);
                    } catch (NoSuchMethodException unused3) {
                        as.d("AccountSdkUtil", "NoSuchMethodException onApplyWindowInsets", true);
                    } catch (InvocationTargetException unused4) {
                        as.d("AccountSdkUtil", "InvocationTargetException onApplyWindowInsets", true);
                    } catch (Throwable th5) {
                        as.d("AccountSdkUtil", "onApplyWindowInsets--" + th5.getClass().getSimpleName(), true);
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
        }
    }

    protected static void c(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
        } catch (ClassNotFoundException unused) {
            as.d("AccountSdkUtil", "ClassNotFoundException setDisplaySideMode", true);
        } catch (IllegalAccessException unused2) {
            as.d("AccountSdkUtil", "IllegalAccessException setDisplaySideMode", true);
        } catch (InstantiationException unused3) {
            as.d("AccountSdkUtil", "InstantiationException setDisplaySideMode", true);
        } catch (NoSuchMethodException unused4) {
            as.d("AccountSdkUtil", "NoSuchMethodException setDisplaySideMode", true);
        } catch (InvocationTargetException unused5) {
            as.d("AccountSdkUtil", "InvocationTargetException setDisplaySideMode", true);
        } catch (Throwable th5) {
            as.d("AccountSdkUtil", "setDisplaySideMode--" + th5.getClass().getSimpleName(), true);
        }
    }

    public static long a() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static void a(ResponseErrorCode responseErrorCode, Status status) {
        if (responseErrorCode != null && status != null) {
            if (responseErrorCode.getParcelable() == null) {
                as.b("AccountSdkUtil", "parcelable is null", true);
                return;
            }
            try {
                if (responseErrorCode.getParcelable() instanceof PendingIntent) {
                    as.b("AccountSdkUtil", "doExecute is PendingIntent", true);
                    status.setPendingIntent((PendingIntent) responseErrorCode.getParcelable());
                }
                if (responseErrorCode.getParcelable() instanceof Intent) {
                    as.b("AccountSdkUtil", "doExecute is Intent", true);
                    status.setIntent((Intent) responseErrorCode.getParcelable());
                    return;
                }
                return;
            } catch (ClassCastException unused) {
                as.d("AccountSdkUtil", "doExecuteIntent ClassCastException", true);
                return;
            } catch (Throwable th5) {
                as.d("AccountSdkUtil", "doExecuteIntent--" + th5.getClass().getSimpleName(), true);
                return;
            }
        }
        as.b("AccountSdkUtil", "response or status is null", true);
    }
}
