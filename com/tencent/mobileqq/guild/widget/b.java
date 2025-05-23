package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.banner.GuildCoverBelowList;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes14.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static final int f236259f = ch.i().getResources().getDimensionPixelSize(R.dimen.cbw) - ch.i().getResources().getDimensionPixelSize(R.dimen.cdq);

    /* renamed from: a, reason: collision with root package name */
    private final Context f236260a;

    /* renamed from: b, reason: collision with root package name */
    private int f236261b;

    /* renamed from: c, reason: collision with root package name */
    private GuildFacadeType f236262c;

    /* renamed from: d, reason: collision with root package name */
    private int f236263d;

    /* renamed from: e, reason: collision with root package name */
    private final String f236264e;

    public b(@NonNull Context context, String str) {
        this(context, str, GuildFacadeType.Tab);
    }

    public static int b() {
        return ViewUtils.dip2px(154.0f);
    }

    private String e() {
        return this.f236264e + ":BannerAnimHelper";
    }

    private void j() {
        this.f236261b = b();
        if (QLog.isColorLevel()) {
            QLog.d(e(), 2, "updateBannerHeight:", Integer.valueOf(this.f236261b));
        }
    }

    public int a() {
        return this.f236261b;
    }

    public int c(int i3, boolean z16) {
        int i16;
        int b16;
        int i17;
        GuildFacadeType guildFacadeType = this.f236262c;
        if (guildFacadeType == GuildFacadeType.Tab) {
            i16 = f236259f;
        } else {
            if (guildFacadeType.isStandaloneStyle()) {
                b16 = GuildCoverBelowList.b();
                i17 = f236259f;
            } else if (this.f236262c == GuildFacadeType.Dialog) {
                b16 = GuildCoverBelowList.b();
                i17 = f236259f;
            } else {
                i16 = 0;
            }
            i16 = b16 + i17;
        }
        return ((a() - GuildCoverBelowList.b()) - i3) - i16;
    }

    public int d() {
        int a16 = ((a() / 3) - GuildCoverBelowList.INSTANCE.a()) - this.f236263d;
        if (a16 < 0) {
            return 0;
        }
        return a16;
    }

    public void f(Configuration configuration) {
        j();
    }

    public void g(int i3, int i16, int i17, int i18) {
        j();
    }

    public void h(GuildFacadeType guildFacadeType) {
        this.f236262c = guildFacadeType;
        j();
    }

    public void i(int i3) {
        this.f236263d = i3;
    }

    public b(@NonNull Context context, String str, GuildFacadeType guildFacadeType) {
        this.f236263d = 0;
        this.f236262c = guildFacadeType;
        this.f236260a = context;
        this.f236264e = str;
        j();
    }
}
