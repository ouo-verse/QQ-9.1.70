package com.tencent.mapsdk.internal;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class d extends f {

    /* renamed from: k, reason: collision with root package name */
    private static final long f148116k = 1;

    public d() {
        h hVar = ((f) this).f148344g;
        hVar.f148610a = (short) 2;
        hVar.f148611b = (byte) 0;
        hVar.f148612c = 0;
        hVar.f148617h = 0;
        hVar.f148616g = new byte[0];
        hVar.f148618i = new HashMap();
        ((f) this).f148344g.f148619j = new HashMap();
    }

    private void a(short s16) {
        ((f) this).f148344g.f148610a = s16;
        if (s16 == 3) {
            g();
        }
    }

    private void b(int i3) {
        ((f) this).f148344g.f148617h = i3;
    }

    private void d(byte[] bArr) {
        ((f) this).f148344g.f148616g = bArr;
    }

    private short h() {
        return ((f) this).f148344g.f148610a;
    }

    private byte i() {
        return ((f) this).f148344g.f148611b;
    }

    private int j() {
        return ((f) this).f148344g.f148612c;
    }

    private int k() {
        return ((f) this).f148344g.f148617h;
    }

    private byte[] l() {
        return ((f) this).f148344g.f148616g;
    }

    private Map<String, String> m() {
        return ((f) this).f148344g.f148618i;
    }

    private Map<String, String> n() {
        return ((f) this).f148344g.f148619j;
    }

    private int o() {
        String str = ((f) this).f148344g.f148619j.get("STATUS_RESULT_CODE");
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    private String p() {
        String str = ((f) this).f148344g.f148619j.get("STATUS_RESULT_DESC");
        if (str != null) {
            return str;
        }
        return "";
    }

    private void b(Map<String, String> map) {
        ((f) this).f148344g.f148619j = map;
    }

    private void a(byte b16) {
        ((f) this).f148344g.f148611b = b16;
    }

    private void a(int i3) {
        ((f) this).f148344g.f148612c = i3;
    }

    private void a(Map<String, String> map) {
        ((f) this).f148344g.f148618i = map;
    }
}
