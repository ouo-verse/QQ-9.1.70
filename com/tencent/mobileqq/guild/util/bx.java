package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static final Context f235487a = MobileQQ.sMobileQQ.getApplicationContext();

    private static SharedPreferences A() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0);
    }

    private static String B(String str) {
        return str + "_" + ch.g();
    }

    public static boolean a(String str) {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean("SP_KEY_CLIENT_AUTHORIZATION_FLAG" + str, false);
    }

    public static boolean b() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean("SP_KEY_ENTER_CLIENT_CONNECT_PAGE", false);
    }

    public static int c() {
        return A().getInt("SP_KEY_GRAY_USER_TYPE", 0);
    }

    public static boolean d(String str) {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean(str + "HAS_ENTERED_TEXT_CHANNEL", false);
    }

    public static boolean e() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean("SP_KEY_GUILD_SCHEDULE_CREATE_TIPS", false);
    }

    public static String f() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getString("SP_KEY_GUILD_FIVE_RECENT_TALKED_CHANNELS", ",");
    }

    public static Set<String> g() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getStringSet("SP_KEY_SECURITY_MSG_SHOWED_ROOM", new HashSet());
    }

    public static long h() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getLong("SP_KEY_SHOWED_ROOM_SAVE_TIME", 0L);
    }

    public static Set<String> i() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getStringSet("SP_KEY_SLOW_MODE_TIMESTAMP", new HashSet());
    }

    public static boolean j(String str) {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean("SP_APP_AUTH_FLAG" + str, false);
    }

    public static boolean k() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean("SP_KEY_AIO_NEW_GUIDE_HAS_SHOW", false);
    }

    public static boolean l() {
        return f235487a.getSharedPreferences(B("QQGuild"), 0).getBoolean("SP_KEY_NEW_GUIDE_HAS_SHOW", false);
    }

    public static void m() {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_KEY_AIO_NEW_GUIDE_HAS_SHOW", true).apply();
    }

    public static void n(String str) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_KEY_CLIENT_AUTHORIZATION_FLAG" + str, true).apply();
    }

    public static void o() {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_KEY_ENTER_CLIENT_CONNECT_PAGE", true).apply();
    }

    public static void p(int i3) {
        A().edit().putInt("SP_KEY_GRAY_USER_TYPE", i3).apply();
    }

    public static void q(String str) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean(str + "HAS_ENTERED_TEXT_CHANNEL", true).apply();
    }

    public static void r(boolean z16) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_KEY_GUILD_SCHEDULE_CREATE_TIPS", z16).apply();
    }

    public static void s(String str) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putString("SP_KEY_GUILD_LAST_SELECT_SUB_CHANNEL_UIN", str).apply();
    }

    public static void t() {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_KEY_NEW_GUIDE_HAS_SHOW", true).apply();
    }

    public static void u(String str) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putString("SP_KEY_GUILD_FIVE_RECENT_TALKED_CHANNELS", str).apply();
    }

    public static void v(Set<String> set) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putStringSet("SP_KEY_SECURITY_MSG_SHOWED_ROOM", set).apply();
    }

    public static void w(String str) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_APP_AUTH_FLAG" + str, true).apply();
    }

    public static void x(boolean z16) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putBoolean("SP_KEY_SHOW_GUILD_TAB", z16).apply();
    }

    public static void y(long j3) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putLong("SP_KEY_SHOWED_ROOM_SAVE_TIME", j3).apply();
    }

    public static void z(Set<String> set) {
        f235487a.getSharedPreferences(B("QQGuild"), 0).edit().putStringSet("SP_KEY_SLOW_MODE_TIMESTAMP", set).apply();
    }
}
