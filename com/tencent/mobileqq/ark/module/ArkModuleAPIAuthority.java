package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public class ArkModuleAPIAuthority {
    static String a(String str, ArrayList<String> arrayList) {
        StringBuilder sb5 = new StringBuilder("");
        boolean z16 = false;
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str2 = arrayList.get(i16);
            if (!TextUtils.isEmpty(str2)) {
                if (i3 > 0) {
                    sb5.append(";");
                }
                sb5.append(str2);
                i3++;
                if (str2.equals(str)) {
                    z16 = true;
                }
            }
        }
        if (!z16) {
            if (i3 > 0) {
                sb5.append(";");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static ArrayList<String> b(String str) {
        String[] split;
        ArrayList<String> arrayList = new ArrayList<>();
        String string = d().getString("key_ark_authority_app_list_" + str, "");
        if (!TextUtils.isEmpty(string) && (split = string.split(";")) != null && split.length > 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static int c(String str, String str2, String str3) {
        return d().getInt("key_ark_authority_info_" + str + "_" + str2 + "_" + str3, 0);
    }

    static SharedPreferences d() {
        return BaseApplication.getContext().getSharedPreferences(IArkModuleAPIAuthority.SP_ARK_AUTHORITY, 0);
    }

    public static void e(final String str, final String str2, final String str3, final String str4, final String str5, final f fVar) {
        String str6;
        String applicationDesc = ArkAppCacheMgr.getApplicationDesc(str2);
        if (TextUtils.isEmpty(applicationDesc)) {
            str6 = str2;
        } else {
            str6 = applicationDesc;
        }
        SharedPreferences d16 = d();
        String str7 = "key_ark_authority_show_dialog_" + str6 + "_" + str4 + "_" + str;
        boolean z16 = d16.getBoolean(str7, false);
        if (TextUtils.isEmpty(str)) {
            if (fVar != null) {
                fVar.onSuccess();
                return;
            }
            return;
        }
        if (!z16 && b.f199564k) {
            final String str8 = str6;
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1

                /* renamed from: com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority$1$a */
                /* loaded from: classes11.dex */
                class a implements ArkAppCacheMgr.OnGetAppIcon {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ QQCustomDialog f199557a;

                    a(QQCustomDialog qQCustomDialog) {
                        this.f199557a = qQCustomDialog;
                    }

                    @Override // com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon
                    public void callback(String str, Bitmap bitmap) {
                        if (bitmap != null) {
                            ((ImageView) this.f199557a.findViewById(R.id.bib)).setImageBitmap(bitmap);
                        }
                    }
                }

                /* renamed from: com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority$1$b */
                /* loaded from: classes11.dex */
                class b implements DialogInterface.OnClickListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQCustomDialog f199559d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Activity f199560e;

                    b(QQCustomDialog qQCustomDialog, Activity activity) {
                        this.f199559d = qQCustomDialog;
                        this.f199560e = activity;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        f fVar = fVar;
                        if (fVar != null) {
                            fVar.onFail();
                        }
                        if (this.f199559d.isShowing()) {
                            try {
                                this.f199559d.dismiss();
                            } catch (Exception unused) {
                            }
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ArkModuleAPIAuthority.g(str8, str4, str, 2);
                        Activity activity = this.f199560e;
                        try {
                            DialogUtil.createNoTitleDialog(activity, activity.getString(R.string.f170443r5), R.string.hkf, R.string.hkf, new DialogUtil.DialogOnClickAdapter(), null).show();
                        } catch (Exception unused2) {
                        }
                    }
                }

                /* renamed from: com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority$1$c */
                /* loaded from: classes11.dex */
                class c implements DialogInterface.OnClickListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQCustomDialog f199562d;

                    c(QQCustomDialog qQCustomDialog) {
                        this.f199562d = qQCustomDialog;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        f fVar = fVar;
                        if (fVar != null) {
                            fVar.onSuccess();
                        }
                        if (this.f199562d.isShowing()) {
                            try {
                                this.f199562d.dismiss();
                            } catch (Exception unused) {
                            }
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ArkModuleAPIAuthority.g(str8, str4, str, 1);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity f16 = com.tencent.mobileqq.ark.module.b.f();
                    QQCustomDialog qQCustomDialog = new QQCustomDialog(f16, R.style.qZoneInputDialog);
                    qQCustomDialog.setContentView(R.layout.j3);
                    qQCustomDialog.setTitle(f16.getString(R.string.f170431qn, str8));
                    ((ImageView) qQCustomDialog.findViewById(R.id.bib)).setImageDrawable(f16.getResources().getDrawable(R.drawable.c_h));
                    ((TextView) qQCustomDialog.findViewById(R.id.bid)).setText(str8);
                    ((TextView) qQCustomDialog.findViewById(R.id.dialogText)).setText(str5);
                    qQCustomDialog.setCanceledOnTouchOutside(false);
                    ArkAppCacheMgr.getAppIcon(str2, str3, new a(qQCustomDialog));
                    qQCustomDialog.setNegativeButton(R.string.igj, new b(qQCustomDialog, f16));
                    qQCustomDialog.setPositiveButton(R.string.igh, new c(qQCustomDialog));
                    try {
                        qQCustomDialog.show();
                    } catch (Exception unused) {
                    }
                    if (ArkModuleAPIAuthority.c(str8, str4, str) == 0) {
                        ArkModuleAPIAuthority.g(str8, str4, str, 2);
                    }
                }
            });
            d16.edit().putBoolean(str7, true).apply();
            f(str6, str);
            return;
        }
        if (1 == c(str6, str4, str)) {
            if (fVar != null) {
                fVar.onSuccess();
            }
        } else if (fVar != null) {
            fVar.onFail();
        }
    }

    public static void f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a16 = a(str, b(str2));
        d().edit().putString("key_ark_authority_app_list_" + str2, a16).apply();
    }

    public static void g(String str, String str2, String str3, int i3) {
        d().edit().putInt("key_ark_authority_info_" + str + "_" + str2 + "_" + str3, i3).apply();
    }
}
