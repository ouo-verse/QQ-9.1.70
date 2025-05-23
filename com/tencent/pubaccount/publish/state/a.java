package com.tencent.pubaccount.publish.state;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<QQPublicAccountPublishFeedFragment> f342335a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray<View> f342336b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f342337c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f342338d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f342339e;

    /* renamed from: f, reason: collision with root package name */
    protected long f342340f;

    /* renamed from: g, reason: collision with root package name */
    protected ActionSheet f342341g;

    public a(QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        this.f342335a = new WeakReference<>(qQPublicAccountPublishFeedFragment);
    }

    public void c() {
        u5.b.f(this.f342340f, "_qq_public_account_publish");
    }

    public boolean e() {
        return true;
    }

    public int g() {
        return 0;
    }

    public void j() {
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        qQPublicAccountPublishFeedFragment.f342285v2.setText(u5.b.a0("_qq_public_account_publish", this.f342340f));
        qQPublicAccountPublishFeedFragment.f45104j0.setText(u5.b.S("_qq_public_account_publish", this.f342340f));
    }

    public void k() {
        throw null;
    }

    public void l(boolean z16) {
        this.f342339e = z16;
    }

    public void m() {
        throw null;
    }

    public static a d(int i3, QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        if (i3 != 1) {
            return new UIStateNormal(qQPublicAccountPublishFeedFragment);
        }
        return new b(qQPublicAccountPublishFeedFragment);
    }

    public static Activity f(Activity activity) {
        if (activity == null) {
            return null;
        }
        return activity instanceof BasePluginActivity ? ((BasePluginActivity) activity).getOutActivity() : activity;
    }

    public void h(Intent intent) {
        boolean z16 = false;
        this.f342337c = intent == null || intent.getBooleanExtra("key_need_save_draft", true);
        if (intent != null && intent.getBooleanExtra("key_isfrom_photobubble", false)) {
            z16 = true;
        }
        this.f342338d = z16;
        this.f342340f = LoginData.getInstance().getUin();
    }

    public void a() {
    }

    public void b() {
    }

    public void i() {
    }
}
