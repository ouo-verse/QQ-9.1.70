package com.tencent.mobileqq.widget.share;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class Validator {

    /* renamed from: a, reason: collision with root package name */
    private ShareActionSheetV2 f317496a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f317497b = false;

    public Validator(ShareActionSheetV2 shareActionSheetV2) {
        this.f317496a = shareActionSheetV2;
    }

    private boolean c() {
        Context context;
        WeakReference<Context> weakReference = this.f317496a.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            context = this.f317496a.f317430e.get();
        } else {
            context = null;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        if (!TextUtils.isEmpty(((Activity) context).getIntent().getStringExtra("big_brother_source_key"))) {
            return true;
        }
        return !TextUtils.isEmpty(r0.getStringExtra("url"));
    }

    private boolean d() {
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : this.f317496a.F()) {
            Iterator<ShareActionSheetBuilder.ActionSheetItem> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().isValidCreate()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean e() {
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : this.f317496a.F()) {
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
                if (!actionSheetItem.isValidIcon()) {
                    QLog.e("Validator", 1, "item is invalidLabel item icon:" + actionSheetItem.icon);
                    return false;
                }
            }
        }
        return true;
    }

    private boolean f() {
        for (List<ShareActionSheetBuilder.ActionSheetItem> list : this.f317496a.F()) {
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
                if (!actionSheetItem.isValidLabel()) {
                    QLog.e("Validator", 1, "item is invalidLabel item label:" + actionSheetItem.label);
                    return false;
                }
            }
        }
        return true;
    }

    private void g(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.Validator.1
            @Override // java.lang.Runnable
            public void run() {
                Context context;
                if (Validator.this.f317496a.f317430e != null && Validator.this.f317496a.f317430e.get() != null) {
                    context = Validator.this.f317496a.f317430e.get();
                } else {
                    context = null;
                }
                if (context != null) {
                    QQToast.makeText(context, str, 0).show();
                }
            }
        });
    }

    public boolean b() {
        boolean z16 = true;
        if (!this.f317497b) {
            return true;
        }
        if (!c()) {
            g("share component no biz id");
            z16 = false;
        }
        if (!e()) {
            g("share component icon invalid");
            z16 = false;
        }
        if (!f()) {
            g("share component label invalid");
            z16 = false;
        }
        if (!d()) {
            g("share component item invalid");
            return false;
        }
        return z16;
    }
}
