package com.tencent.mobileqq.kandian.biz.video;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IReadInJoyVideoInteract;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import r62.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b implements d.b {

    /* renamed from: a, reason: collision with root package name */
    private final PendingIntent f239557a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<QQAppInterface> f239558b;

    /* renamed from: c, reason: collision with root package name */
    private d.c f239559c;

    /* renamed from: d, reason: collision with root package name */
    String f239560d;

    /* renamed from: e, reason: collision with root package name */
    String f239561e;

    /* renamed from: f, reason: collision with root package name */
    String f239562f;

    /* renamed from: g, reason: collision with root package name */
    String f239563g;

    /* renamed from: h, reason: collision with root package name */
    boolean f239564h;

    public b(PendingIntent pendingIntent, QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, boolean z16) {
        this.f239557a = pendingIntent;
        this.f239558b = new WeakReference<>(qQAppInterface);
        this.f239560d = str;
        this.f239561e = str2;
        this.f239562f = str3;
        this.f239563g = str4;
        this.f239564h = z16;
    }

    private void a(String str) {
        String str2;
        if (this.f239558b.get() != null) {
            b.a aVar = new b.a(this.f239563g, this.f239560d, this.f239562f, this.f239561e);
            aVar.c(this.f239561e);
            QQAppInterface qQAppInterface = this.f239558b.get();
            String str3 = this.f239560d;
            if (this.f239564h) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            PublicAccountReportUtils.l(qQAppInterface, str3, str, str, 0, 0, str2, "", "", aVar.g().b(), false);
        }
    }

    public static void b(QQAppInterface qQAppInterface, Intent intent, PendingIntent pendingIntent, String str, String str2) {
        int intExtra = intent.getIntExtra("banner_iconIdx", -1);
        if (pendingIntent != null && intExtra >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b bVar = new b(pendingIntent, qQAppInterface, intent.getStringExtra(IReadInJoyVideoInteract.INTENT_KEY_READINJOY_PUIN), intent.getStringExtra(IReadInJoyVideoInteract.INTENT_KEY_READINJOY_ARTICLE_ID), intent.getStringExtra(IReadInJoyVideoInteract.INTENT_KEY_READINJOY_VID), intent.getStringExtra(IReadInJoyVideoInteract.INTENT_KEY_READINJOY_MD5), intent.getBooleanExtra(IReadInJoyVideoInteract.INTENT_KEY_READINJOY_IS_WEISHI_MODE, false));
            d.c g16 = com.tencent.mobileqq.activity.recent.bannerprocessor.d.g(qQAppInterface, intExtra, str, str2, bVar);
            bVar.c();
            bVar.d(g16);
            return;
        }
        QLog.e("ReadInjoyVideoInteract", 1, "invalid intent extra from ReadinjoyVideo, " + str + " / " + str2 + " / " + pendingIntent + " / " + intExtra);
    }

    public void c() {
        a("0X80097F8");
    }

    public void d(d.c cVar) {
        this.f239559c = cVar;
    }

    @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
    public boolean isNeedAutoCloseWhenAccountChange() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
    public void onClose() {
        QQAppInterface qQAppInterface;
        if (this.f239559c == null || (qQAppInterface = this.f239558b.get()) == null) {
            return;
        }
        com.tencent.mobileqq.activity.recent.bannerprocessor.d.f(qQAppInterface, this.f239559c);
        a("0X80097FA");
    }

    @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
    public void onEnter() {
        QQAppInterface qQAppInterface;
        if (this.f239559c == null || (qQAppInterface = this.f239558b.get()) == null) {
            return;
        }
        try {
            this.f239557a.send();
        } catch (PendingIntent.CanceledException e16) {
            QLog.e("ReadInjoyVideoInteract", 1, "send pending intent fail with " + this.f239557a + "\r\n" + e16);
        }
        com.tencent.mobileqq.activity.recent.bannerprocessor.d.f(qQAppInterface, this.f239559c);
        a("0X80097F9");
    }

    @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.d.b
    public void onOverride() {
    }
}
