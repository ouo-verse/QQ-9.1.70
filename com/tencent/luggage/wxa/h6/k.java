package com.tencent.luggage.wxa.h6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final List f126898a = Arrays.asList(QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_CONNECT, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f126899a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f126900b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f126901c;

        public a(Activity activity, String str, int i3) {
            this.f126899a = activity;
            this.f126900b = str;
            this.f126901c = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ActivityCompat.requestPermissions(this.f126899a, new String[]{this.f126900b}, this.f126901c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f126902a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f126903b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f126904c;

        public b(Activity activity, String[] strArr, int i3) {
            this.f126902a = activity;
            this.f126903b = strArr;
            this.f126904c = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ActivityCompat.requestPermissions(this.f126902a, this.f126903b, this.f126904c);
        }
    }

    public static boolean a(Activity activity, com.tencent.luggage.wxa.xd.d dVar, String str, int i3, String str2, String str3) {
        f126898a.contains(str);
        try {
            if (ContextCompat.checkSelfPermission(activity, str) == 0) {
                return true;
            }
            if (!w0.c(str3)) {
                a((Context) activity, str3, str2, false, (DialogInterface.OnClickListener) new a(activity, str, i3), (DialogInterface.OnClickListener) null);
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{str}, i3);
            }
            return false;
        } catch (Exception e16) {
            w.b("Luggage.PermissionUtil", "check mpermission exception:%s.", e16);
            return true;
        }
    }

    public static boolean a(Context context, com.tencent.luggage.wxa.xd.d dVar, String[] strArr, int i3, String str, String str2) {
        boolean z16;
        try {
            int length = strArr.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    z16 = true;
                    break;
                }
                if (ContextCompat.checkSelfPermission(context, strArr[i16]) != 0) {
                    z16 = false;
                    break;
                }
                i16++;
            }
            if (z16) {
                return true;
            }
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                return false;
            }
            if (!w0.c(str2)) {
                a(context, str2, str, false, (DialogInterface.OnClickListener) new b(activity, strArr, i3), (DialogInterface.OnClickListener) null);
            } else {
                ActivityCompat.requestPermissions(activity, strArr, i3);
            }
            return false;
        } catch (Exception e16) {
            w.b("Luggage.PermissionUtil", "check mpermission exception:%s.", e16);
            return true;
        }
    }

    public static boolean a(Context context, String... strArr) {
        if (strArr.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (!a(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        return a(context, null, str);
    }

    public static boolean a(Context context, com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (str.equals(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) && Build.VERSION.SDK_INT > 30) {
            str = QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE;
        }
        if (QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE.equals(str) && Build.VERSION.SDK_INT >= 33) {
            return a(context);
        }
        f126898a.contains(str);
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Exception e16) {
            w.b("Luggage.PermissionUtil", "check mpermission exception:%s.", e16);
            return false;
        }
    }

    public static boolean a(Context context) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 33 || !(ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VIDEO") == 0)) {
            return (i3 >= 34 && ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0) || ContextCompat.checkSelfPermission(context, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0;
        }
        return true;
    }

    public static void a(Context context, String str, String str2, boolean z16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        a(context, str, str2, context.getString(R.string.f173462t8), context.getString(R.string.f173452t7), z16, onClickListener, onClickListener2);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str).setTitle(str2).setCancelable(z16).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2);
        builder.show();
    }
}
