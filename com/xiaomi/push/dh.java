package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes28.dex */
public class dh extends Notification.Builder {

    /* renamed from: a, reason: collision with root package name */
    private Context f388591a;

    public dh(Context context) {
        super(context);
        this.f388591a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    public final int b(String str) {
        return a(c().getResources(), str, "id", c().getPackageName());
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        g();
        return super.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context c() {
        return this.f388591a;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public dh addExtras(Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public dh setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    public dh f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                y.e(this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e16) {
                jz4.c.B("fail to set color. " + e16);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
    }
}
