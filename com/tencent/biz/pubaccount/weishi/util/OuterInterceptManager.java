package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stCallInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class OuterInterceptManager {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(Dialog dialog);

        void b();

        void onNegativeClick();

        void onPositiveClick();
    }

    public static void a(Activity activity, a aVar) {
        stCallInfo n3 = iz.a.g().n();
        if (n3 == null || !n3.switch_call_live) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            x.j("OuterInterceptManager", "stGlobalConfig.callinfo: " + n3);
            b(activity, aVar);
        }
    }

    private static void b(final Activity activity, final a aVar) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.1

            /* compiled from: P */
            /* renamed from: com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager$1$a */
            /* loaded from: classes32.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.onPositiveClick();
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager$1$b */
            /* loaded from: classes32.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.onNegativeClick();
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager$1$c */
            /* loaded from: classes32.dex */
            class c implements DialogInterface.OnCancelListener {
                c() {
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.onNegativeClick();
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(activity, "\u6b63\u5728\u79bb\u5f00QQ\uff0c\u524d\u5f80\u201c\u817e\u8baf\u5fae\u89c6\u201d", R.string.cancel, R.string.f171151ok, new a(), new b());
                createNoTitleDialog.setOnCancelListener(new c());
                createNoTitleDialog.setCanceledOnTouchOutside(true);
                createNoTitleDialog.show();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(createNoTitleDialog);
                }
            }
        });
    }
}
