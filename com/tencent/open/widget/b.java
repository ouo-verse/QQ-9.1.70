package com.tencent.open.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/OpenSdkApi/Inject_JumpAction.yml", version = 1)
    static d f341795a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f341796b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements DialogInterface.OnClickListener {
        a(c cVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("OpenSDKDialogHelper", 2, "showBackOrStayDialog stay");
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.open.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class DialogInterfaceOnClickListenerC9287b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f341797d;

        DialogInterfaceOnClickListenerC9287b(Activity activity, c cVar) {
            this.f341797d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("OpenSDKDialogHelper", 2, "showBackOrStayDialog back");
            Activity activity = this.f341797d;
            if (activity != null) {
                activity.finish();
                b.b(this.f341797d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        String a();
    }

    static {
        ArrayList arrayList = new ArrayList();
        f341796b = arrayList;
        arrayList.add(xp3.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity) {
        String str;
        if (activity != null && activity.getIntent() != null) {
            try {
                String stringExtra = activity.getIntent().getStringExtra("extra");
                c();
                d dVar = f341795a;
                if (dVar != null) {
                    str = dVar.a();
                } else {
                    str = "action_game_make_friend";
                }
                f(activity, true, str, Long.parseLong(stringExtra));
            } catch (Exception e16) {
                QLog.e("OpenSDKDialogHelper", 1, "backToApp error = " + e16);
            }
            activity.moveTaskToBack(true);
            return;
        }
        QLog.e("OpenSDKDialogHelper", 1, "backToApp error = activity null");
    }

    static void c() {
        boolean z16;
        if (f341795a == null) {
            d();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[AutoInject] result:");
                if (f341795a != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("OpenSDKDialogHelper", 2, sb5.toString());
            }
        }
    }

    @QAutoInitMethod
    static void d() {
        f341795a = (d) com.tencent.mobileqq.qroute.utils.b.a(f341796b);
    }

    public static void e(@NonNull Activity activity, String str, String str2, c cVar) {
        String string = activity.getResources().getString(R.string.ppw);
        if (!TextUtils.isEmpty(str2)) {
            string = string + str2;
        }
        try {
            DialogUtil.createCustomDialog(activity, 232, (String) null, str, string, activity.getResources().getString(R.string.zmk), new a(cVar), new DialogInterfaceOnClickListenerC9287b(activity, cVar)).show();
        } catch (Throwable th5) {
            QLog.e("OpenSDKDialogHelper", 2, "showBackOrStayDialog: failed. ", th5);
        }
    }

    private static final void f(Activity activity, boolean z16, String str, long j3) {
        if (activity == null) {
            return;
        }
        QLog.d("OpenSDKDialogHelper", 2, "sdk_share:sdk callback=" + z16 + " appId=" + j3 + " action=" + str);
        Intent intent = new Intent();
        if (z16) {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), str)));
        } else {
            intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Long.valueOf(j3), str)));
        }
        if (activity.getIntent() != null) {
            intent.setPackage(activity.getIntent().getStringExtra("pkg_name"));
        }
        try {
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e("OpenSDKDialogHelper", 2, "startOpenSdkCallback: " + e16.getMessage());
        }
    }
}
