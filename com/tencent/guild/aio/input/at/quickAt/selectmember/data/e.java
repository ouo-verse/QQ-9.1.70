package com.tencent.guild.aio.input.at.quickAt.selectmember.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends a {

    /* renamed from: d, reason: collision with root package name */
    private IGProUserInfo f110995d;

    @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.data.a
    public int a() {
        return 2;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.data.a
    public long c() {
        IGProUserInfo iGProUserInfo = this.f110995d;
        if (iGProUserInfo != null && !TextUtils.isEmpty(iGProUserInfo.getTinyId())) {
            return Long.parseLong(this.f110995d.getTinyId());
        }
        return -1L;
    }

    public IGProUserInfo i() {
        return this.f110995d;
    }

    public void j(IGProUserInfo iGProUserInfo) {
        this.f110995d = iGProUserInfo;
    }
}
