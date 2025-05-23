package com.tencent.mobileqq.matchfriend.utils;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f245592a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f245593a = new b();
    }

    b() {
    }

    public static String a(String str) {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + str;
    }

    public static b d() {
        return a.f245593a;
    }

    public String b() {
        return this.f245592a.decodeString(a("match_friend_peer_openid"), "");
    }

    public long c(String str) {
        return this.f245592a.decodeLong(a("match_friend_icebreaktopic_msgid" + str), 0L);
    }

    public boolean e() {
        return this.f245592a.decodeBool(a("match_friend_entrance_switch"), false);
    }

    public p72.a f() {
        return p72.a.a(this.f245592a.decodeBytes(a("match_friend_login_cache"), null));
    }

    public boolean g(String str) {
        return this.f245592a.decodeBool(a("match_friend_has_minicard" + str), false);
    }

    public boolean h(String str) {
        return this.f245592a.decodeBool(a("match_friend_has_topic" + str), false);
    }

    public boolean i() {
        return this.f245592a.decodeBool(a("match_friend_notification_switch"), false);
    }

    public String j() {
        p72.a f16 = f();
        if (f16 != null) {
            return f16.f425671a;
        }
        return "";
    }

    public boolean k() {
        return this.f245592a.containsKey(a("match_friend_entrance_switch"));
    }

    public boolean l(String str) {
        return this.f245592a.decodeBool(a(str + "_match_friend_first_enter_session"), true);
    }

    public void m(String str, boolean z16) {
        this.f245592a.encodeBool(a(str + "_match_friend_first_enter_session"), z16);
    }

    public void n(String str) {
        this.f245592a.encodeString(a("match_friend_peer_openid"), str);
    }

    public void o(boolean z16) {
        this.f245592a.encodeBool(a("match_friend_entrance_switch"), z16);
    }

    public void q(String str, boolean z16) {
        this.f245592a.encodeBool(a("match_friend_has_minicard" + str), z16);
    }

    public void r(String str, boolean z16) {
        this.f245592a.encodeBool(a("match_friend_has_topic" + str), z16);
    }

    public void s(boolean z16) {
        this.f245592a.encodeBool(a("match_friend_notification_switch"), z16);
    }

    public void t(String str, String str2) {
        this.f245592a.encodeString(a(str + "_match_friend_topicId"), str2);
    }

    public void p(p72.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f245592a.encodeBytes(a("match_friend_login_cache"), aVar.b());
    }
}
