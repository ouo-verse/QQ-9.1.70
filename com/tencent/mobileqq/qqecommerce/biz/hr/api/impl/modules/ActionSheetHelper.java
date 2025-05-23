package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ActionSheetHelper implements ActionSheet.WatchDismissActions {

    /* renamed from: i, reason: collision with root package name */
    public static String f262630i = "BridgeModule.ActionSheetHelper";

    /* renamed from: d, reason: collision with root package name */
    private ActionSheet f262631d;

    /* renamed from: e, reason: collision with root package name */
    private int f262632e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f262633f = false;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> f262634h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f262637d;

        a(String str) {
            this.f262637d = str;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("index", i3);
                if (ActionSheetHelper.this.f262633f && i3 == 0) {
                    jSONObject.put("type", 2);
                } else {
                    jSONObject.put("type", 0);
                }
                if (ActionSheetHelper.this.f262634h != null) {
                    ((com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a) ActionSheetHelper.this.f262634h.get()).T(this.f262637d, jSONObject);
                }
            } catch (JSONException unused) {
            }
            ActionSheetHelper.this.f262631d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f262639d;

        b(String str) {
            this.f262639d = str;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("index", -1);
                jSONObject.put("type", 1);
                if (ActionSheetHelper.this.f262634h != null) {
                    ((com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a) ActionSheetHelper.this.f262634h.get()).T(this.f262639d, jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f262641d;

        c(String str) {
            this.f262641d = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("index", ActionSheetHelper.this.f262632e);
                jSONObject.put("type", 1);
                if (ActionSheetHelper.this.f262634h != null) {
                    ((com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a) ActionSheetHelper.this.f262634h.get()).T(this.f262641d, jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public ActionSheetHelper(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar) {
        this.f262634h = null;
        this.f262634h = new WeakReference<>(aVar);
    }

    public void e(final JSONObject jSONObject, final String str, Activity activity) {
        if (this.f262634h == null) {
            return;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        new Handler(activity.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.ActionSheetHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ActionSheetHelper.this.f(jSONObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(JSONObject jSONObject, String str) {
        WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference;
        Activity a16;
        int i3;
        if (jSONObject == null || (weakReference = this.f262634h) == null || (a16 = weakReference.get().getViolaInstance().a()) == null) {
            return;
        }
        try {
            ActionSheet create = ActionSheet.create(a16);
            String optString = jSONObject.optString("title");
            if (!TextUtils.isEmpty(optString)) {
                create.setMainTitle(optString);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            int optInt = jSONObject.optInt("selected", -1);
            this.f262633f = false;
            String optString2 = jSONObject.optString("close");
            if (TextUtils.isEmpty(optString2)) {
                i3 = 0;
            } else {
                this.f262633f = true;
                create.addButton(optString2, 3);
                i3 = 1;
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                if (optInt < 0 || optInt >= length) {
                    for (int i16 = 0; i16 < length; i16++) {
                        create.addButton(optJSONArray.getString(i16));
                    }
                } else {
                    int i17 = 0;
                    while (i17 < length) {
                        create.addRadioButton(optJSONArray.getString(i17), i17 == optInt);
                        i17++;
                    }
                }
                i3 += length;
            }
            String optString3 = jSONObject.optString("cancel");
            if (!TextUtils.isEmpty(optString3)) {
                create.addCancelButton(optString3);
            }
            create.setOnButtonClickListener(new a(str));
            create.setOnDismissListener(new b(str));
            create.setOnCancelListener(new c(str));
            create.registerWatchDisMissActionListener(this);
            this.f262631d = create;
            this.f262632e = i3;
            create.show();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f262630i, 2, "showActionSheet error:" + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.widget.ActionSheet.WatchDismissActions
    public void onDismissOperations() {
    }
}
