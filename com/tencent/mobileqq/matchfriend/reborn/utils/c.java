package com.tencent.mobileqq.matchfriend.reborn.utils;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/c;", "", "", "chatType", "b", "appId", "a", "c", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f245468a = new c();

    c() {
    }

    public final int a(int appId) {
        if (appId != 1) {
            if (appId != 2) {
                return 0;
            }
            return 119;
        }
        return 104;
    }

    public final int b(int chatType) {
        if (chatType != 104) {
            if (chatType != 119) {
                return 0;
            }
            return 2;
        }
        return 1;
    }

    public final int c(int chatType) {
        if (chatType == 104) {
            return com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.b();
        }
        if (chatType != 119) {
            return 0;
        }
        return com.tencent.mobileqq.matchfriend.reborn.couple.model.b.f245072a.a();
    }
}
