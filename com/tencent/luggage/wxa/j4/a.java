package com.tencent.luggage.wxa.j4;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements com.tencent.luggage.wxa.xd.l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f130780a = false;

    /* renamed from: b, reason: collision with root package name */
    public EnumC6326a f130781b = EnumC6326a.NORMAL;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.j4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6326a {
        NORMAL,
        FULLSCREEN,
        HIDE_STATUS_BAR,
        HIDE_NAVIGATION_BAR;

        public boolean b() {
            if (this != FULLSCREEN && this != HIDE_STATUS_BAR) {
                return false;
            }
            return true;
        }
    }
}
