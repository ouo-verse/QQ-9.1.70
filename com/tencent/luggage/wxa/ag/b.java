package com.tencent.luggage.wxa.ag;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f121391a = true;

        /* renamed from: b, reason: collision with root package name */
        public double f121392b = 1.0d;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ag.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6005b {
        NONE,
        PUSH,
        POP,
        PUSH_AND_POP;

        public static EnumC6005b a(String str) {
            String trim = str.trim();
            trim.hashCode();
            char c16 = '\uffff';
            switch (trim.hashCode()) {
                case 0:
                    if (trim.equals("")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 111185:
                    if (trim.equals("pop")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 3452698:
                    if (trim.equals("push")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1077886132:
                    if (trim.equals("pushAndPop")) {
                        c16 = 3;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    return NONE;
                case 1:
                    return POP;
                case 2:
                    return PUSH;
                case 3:
                    return PUSH_AND_POP;
                default:
                    return null;
            }
        }

        public static boolean a(EnumC6005b enumC6005b) {
            return (enumC6005b == null || NONE == enumC6005b) ? false : true;
        }
    }

    Boolean a();

    a b();

    EnumC6005b c();
}
