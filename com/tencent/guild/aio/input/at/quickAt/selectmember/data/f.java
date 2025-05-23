package com.tencent.guild.aio.input.at.quickAt.selectmember.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends a {

    /* renamed from: d, reason: collision with root package name */
    private IGProGuildRoleInfo f110996d;

    /* renamed from: e, reason: collision with root package name */
    private int f110997e = 0;

    @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.data.a
    public int a() {
        return 5;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.data.a
    public long c() {
        IGProGuildRoleInfo iGProGuildRoleInfo = this.f110996d;
        if (iGProGuildRoleInfo != null && !TextUtils.isEmpty(iGProGuildRoleInfo.getRoleId())) {
            return Long.parseLong(this.f110996d.getRoleId()) << 1;
        }
        return -1L;
    }

    public IGProGuildRoleInfo i() {
        return this.f110996d;
    }
}
