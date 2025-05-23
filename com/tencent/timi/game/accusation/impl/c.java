package com.tencent.timi.game.accusation.impl;

import android.text.TextUtils;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends a {

    /* renamed from: u, reason: collision with root package name */
    public String f376222u;

    /* renamed from: v, reason: collision with root package name */
    public String f376223v;

    public c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, String str2) {
        this.f376222u = "";
        this.f376223v = "";
        this.f376206e = commonOuterClass$QQUserId;
        if (!TextUtils.isEmpty(str)) {
            this.f376222u = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f376223v = str2;
        }
        a();
    }

    private void a() {
        this.f376212k = "roomID=" + this.f376222u + "|msgID=" + this.f376223v;
    }
}
