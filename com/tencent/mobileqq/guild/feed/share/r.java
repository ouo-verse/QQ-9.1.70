package com.tencent.mobileqq.guild.feed.share;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.QQToastUtil;

/* compiled from: P */
/* loaded from: classes13.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f223440a;

    /* renamed from: b, reason: collision with root package name */
    private final v f223441b = new v();

    /* renamed from: c, reason: collision with root package name */
    private final GuildFeedArkShareInfo f223442c;

    public r(@NonNull Activity activity, @NonNull GuildFeedArkShareInfo guildFeedArkShareInfo) {
        this.f223442c = guildFeedArkShareInfo;
        this.f223440a = activity;
    }

    public void a(int i3) {
        this.f223441b.y(i3);
    }

    public void b() {
        this.f223441b.g("guildShare", this.f223440a, this.f223442c);
    }

    public void c() {
        String z16 = this.f223442c.z();
        boolean k3 = com.tencent.mobileqq.guild.share.shorturl.a.k(z16);
        String a16 = com.tencent.mobileqq.guild.share.util.c.a(z16, String.valueOf(2));
        if (k3) {
            z16 = a16;
        }
        this.f223441b.k(this.f223440a, ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getString(R.string.f156651ks, this.f223442c.y(), z16), ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getString(R.string.f156601kn));
    }

    public void d() {
        this.f223441b.e("guildShare", this.f223440a, this.f223442c);
    }

    public void e(String str, int i3) {
        this.f223441b.f("guildShare", this.f223440a, this.f223442c, i3, str);
    }

    public void f() {
        this.f223441b.h("guildShare", this.f223440a, this.f223442c);
    }

    public void g(Runnable runnable) {
        if (!m02.d.i()) {
            QQToastUtil.showQQToast(R.string.f156731l0);
            runnable.run();
        } else {
            this.f223441b.i(this.f223440a, this.f223442c, runnable);
        }
    }

    @Deprecated
    public void h(Runnable runnable) {
        if (!m02.d.i()) {
            QQToastUtil.showQQToast(R.string.f156731l0);
            runnable.run();
        } else {
            this.f223441b.j(this.f223440a, this.f223442c, runnable);
        }
    }
}
