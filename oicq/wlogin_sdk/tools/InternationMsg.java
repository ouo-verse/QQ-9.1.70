package oicq.wlogin_sdk.tools;

import oicq.wlogin_sdk.request.u;

/* compiled from: P */
/* loaded from: classes28.dex */
public class InternationMsg {

    /* renamed from: a, reason: collision with root package name */
    public static a[] f422974a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum MSG_TYPE {
        MSG_0,
        MSG_1,
        MSG_2,
        MSG_3,
        MSG_4,
        MSG_5
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f422975a;

        /* renamed from: b, reason: collision with root package name */
        public MSG_TYPE f422976b;

        /* renamed from: c, reason: collision with root package name */
        public String f422977c;

        public a(int i3, MSG_TYPE msg_type, String str) {
            this.f422975a = i3;
            this.f422976b = msg_type;
            this.f422977c = str;
        }
    }

    static {
        MSG_TYPE msg_type = MSG_TYPE.MSG_0;
        MSG_TYPE msg_type2 = MSG_TYPE.MSG_1;
        MSG_TYPE msg_type3 = MSG_TYPE.MSG_2;
        MSG_TYPE msg_type4 = MSG_TYPE.MSG_3;
        MSG_TYPE msg_type5 = MSG_TYPE.MSG_4;
        MSG_TYPE msg_type6 = MSG_TYPE.MSG_5;
        f422974a = new a[]{new a(2052, msg_type, "\u767b\u5f55\u5931\u8d25"), new a(1028, msg_type, "\u767b\u9304\u5931\u6557"), new a(1033, msg_type, "Unable to login"), new a(2052, msg_type2, "\u8bf7\u4f60\u7a0d\u540e\u91cd\u8bd5\u3002"), new a(1028, msg_type2, "\u8acb\u4f60\u7a0d\u5f8c\u91cd\u8a66\u3002"), new a(1033, msg_type2, "Please try again later."), new a(2052, msg_type3, "\u624b\u673a\u5b58\u50a8\u5f02\u5e38\uff0c\u8bf7\u5220\u9664\u5e10\u53f7\u91cd\u8bd5\u3002"), new a(1028, msg_type3, "\u624b\u6a5f\u5b58\u5132\u7570\u5e38\uff0c\u8acb\u522a\u9664\u5e33\u865f\u91cd\u8a66\u3002"), new a(1033, msg_type3, "Phone memory error, please delete the account and try again."), new a(2052, msg_type4, "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u4f60\u7a0d\u540e\u91cd\u8bd5\u3002"), new a(1028, msg_type4, "\u8acb\u6c42\u5931\u6557\uff0c\u8acb\u4f60\u7a0d\u5f8c\u91cd\u8a66\u3002"), new a(1033, msg_type4, "Request failed, please try again later."), new a(2052, msg_type5, "\u7f51\u7edc\u8d85\u65f6\uff0c\u8bf7\u4f60\u7a0d\u540e\u91cd\u8bd5\u3002"), new a(1028, msg_type5, "\u7db2\u7d61\u8d85\u6642\uff0c\u8acb\u4f60\u7a0d\u5f8c\u91cd\u8a66\u3002"), new a(1033, msg_type5, "Network timeout, please try again later."), new a(2052, msg_type6, "\u767b\u5f55\u8bbe\u5907\u4fdd\u62a4"), new a(1028, msg_type6, "\u767b\u9304\u8a2d\u5099\u4fdd\u8b77"), new a(1033, msg_type6, "Device Protection")};
    }

    public static String a(MSG_TYPE msg_type) {
        int i3 = 0;
        while (true) {
            a[] aVarArr = f422974a;
            if (i3 < aVarArr.length) {
                if (msg_type == aVarArr[i3].f422976b) {
                    int i16 = u.f422951x;
                    a aVar = f422974a[i3];
                    if (i16 == aVar.f422975a) {
                        return aVar.f422977c;
                    }
                }
                i3++;
            } else {
                return "";
            }
        }
    }
}
