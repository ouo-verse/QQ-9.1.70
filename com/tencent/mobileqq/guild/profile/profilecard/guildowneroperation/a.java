package com.tencent.mobileqq.guild.profile.profilecard.guildowneroperation;

import com.tencent.mobileqq.R;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f231434b;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<Integer, C7866a> f231435a = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.guildowneroperation.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C7866a {

        /* renamed from: a, reason: collision with root package name */
        public int f231436a;

        /* renamed from: b, reason: collision with root package name */
        public int f231437b;

        /* renamed from: c, reason: collision with root package name */
        public String f231438c;

        /* renamed from: d, reason: collision with root package name */
        public int f231439d;

        /* renamed from: e, reason: collision with root package name */
        public int f231440e;

        /* renamed from: f, reason: collision with root package name */
        public String f231441f;

        /* renamed from: g, reason: collision with root package name */
        public String f231442g;

        /* renamed from: h, reason: collision with root package name */
        public String f231443h;

        public C7866a(int i3, int i16, String str, int i17, int i18, String str2, String str3, String str4) {
            this.f231436a = i3;
            this.f231437b = i16;
            this.f231438c = str;
            this.f231439d = i17;
            this.f231440e = i18;
            this.f231441f = str2;
            this.f231442g = str3;
            this.f231443h = str4;
        }
    }

    a() {
        c();
    }

    public static a a() {
        if (f231434b == null) {
            synchronized (a.class) {
                a aVar = f231434b;
                if (aVar != null) {
                    return aVar;
                }
                f231434b = new a();
            }
        }
        return f231434b;
    }

    private void c() {
        this.f231435a.put(1, new C7866a(R.string.f1516818c, R.string.f1516718b, "https://downv6.qq.com/innovate/guild/operation_center/Guild_Info_Setting_Page_Guide_Image.png", 254, 360, "pg_sgrp_channel_set", "em_sgrp_task_layer", "em_sgrp_task_layerbutton"));
        this.f231435a.put(2, new C7866a(R.string.f1517018e, R.string.f1516918d, "https://downv6.qq.com/innovate/guild/operation_center/Sub_Channel_Manage_Page_Guide_Image_v1.png", 254, 360, "pg_sgrp_channel_mange", "em_sgrp_task_layer", "em_sgrp_task_layerbutton"));
        this.f231435a.put(3, new C7866a(R.string.f1516618a, R.string.f1516518_, "https://downv6.qq.com/innovate/guild/operation_center/Create_Guild_Role_Page_Guide_Image_New.png", 203, 360, "pg_sgrp_role_new", "em_sgrp_task_layer", "em_sgrp_task_layerbutton"));
    }

    public C7866a b(int i3) {
        return this.f231435a.get(Integer.valueOf(i3));
    }
}
