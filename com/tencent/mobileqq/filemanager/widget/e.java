package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f209535f = {1, 5};

    /* renamed from: a, reason: collision with root package name */
    protected Context f209536a;

    /* renamed from: b, reason: collision with root package name */
    protected QQAppInterface f209537b;

    /* renamed from: c, reason: collision with root package name */
    protected QFileSendBottomView f209538c;

    /* renamed from: d, reason: collision with root package name */
    protected Bundle f209539d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f209540e;

    public e(QQAppInterface qQAppInterface, Context context, QFileSendBottomView qFileSendBottomView) {
        this.f209537b = qQAppInterface;
        this.f209536a = context;
        this.f209538c = qFileSendBottomView;
    }

    public static e a(QQAppInterface qQAppInterface, Context context, QFileSendBottomView qFileSendBottomView, Bundle bundle) {
        int i3;
        e qFileSendBarManager;
        if (bundle != null) {
            i3 = bundle.getInt("qfile_search_param_exparams_busi_type");
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            qFileSendBarManager = new fc1.b(qQAppInterface, context, qFileSendBottomView);
        } else if (i3 == 5) {
            qFileSendBarManager = new fc1.a(qQAppInterface, context, qFileSendBottomView);
        } else {
            qFileSendBarManager = new QFileSendBarManager(qQAppInterface, context, qFileSendBottomView);
        }
        qFileSendBarManager.d(bundle);
        return qFileSendBarManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i3, Intent intent) {
        Intent intent2;
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.putExtra("qfile_send_bottom_bar_finish_result_code", -1);
        Activity activity = (Activity) this.f209536a;
        activity.setResult(i3, intent2);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Intent intent) {
        b(-1, intent);
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.f209539d = bundle;
            this.f209540e = true;
        } else {
            this.f209540e = false;
        }
    }

    public void f() {
        throw null;
    }

    public void e() {
    }
}
