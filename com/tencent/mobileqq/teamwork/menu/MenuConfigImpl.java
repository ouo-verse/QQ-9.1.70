package com.tencent.mobileqq.teamwork.menu;

import com.tencent.mobileqq.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MenuConfigImpl {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<Integer, au> f292179a = new HashMap<Integer, au>() { // from class: com.tencent.mobileqq.teamwork.menu.MenuConfigImpl.1
        {
            put(1, new au(1, "\u5728\u7ebf\u7f16\u8f91", R.drawable.kgu));
            put(2, new au(2, "\u5c4f\u5e55\u9002\u5e94", R.drawable.kh7, R.drawable.kh8));
            put(4, new au(4, "\u4fdd\u5b58\u5230\u4e91\u7aef", R.drawable.kgw));
            put(5, new au(5, "\u66f4\u591a", R.drawable.kgv));
            put(6, new au(6, "\u6587\u6863\u8f6c\u56fe\u7247", R.drawable.khb));
            put(10, new au(10, "\u5bfc\u51fa\u4e3aPDF", R.drawable.kh5));
            put(11, new au(11, "\u4fdd\u5b58\u4e3a\u4e91\u7aef\u526f\u672c", R.drawable.kgw));
            put(14, new au(14, "\u67e5\u627e", R.drawable.kh6));
            put(15, new au(15, "\u67e5\u627e\u548c\u66ff\u6362", R.drawable.kh6));
            put(16, new au(16, "\u663e\u793a\u76ee\u5f55", R.drawable.f161620kh3));
            put(17, new au(17, "\u8f6c\u4e3a\u7b80\u5386", R.drawable.f161621kh4));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final List<Integer> f292180b = Arrays.asList(1, 2, 4, 5);

    /* renamed from: c, reason: collision with root package name */
    public static final List<MenuConfig$ToolBoxPageConfig> f292181c = Arrays.asList(new MenuConfig$ToolBoxPageConfig("\u5de5\u5177", Arrays.asList(6, 17)), new MenuConfig$ToolBoxPageConfig("\u6587\u4ef6", Arrays.asList(11, 10)), new MenuConfig$ToolBoxPageConfig("\u67e5\u770b", Arrays.asList(14, 16, 2)));

    /* renamed from: d, reason: collision with root package name */
    public static final a f292182d = new a(R.drawable.khe, "\u4fdd\u5b58\u4e3a\u4e91\u7aef\u526f\u672c", "\u804a\u5929\u6587\u4ef6\u4e0a\u4e91\u6c38\u4e0d\u8fc7\u671f", "\u4e91\u7aef\u96c6\u4e2d\u7ba1\u7406\u6c38\u4e0d\u4e22\u5931", "\u591a\u7aef\u540c\u6b65\u6f2b\u6e38\u968f\u65f6\u67e5\u770b", "\u5f00\u59cb\u4e0a\u4f20");

    /* renamed from: e, reason: collision with root package name */
    public static final a f292183e = new a(R.drawable.khe, "\u751f\u6210\u5728\u7ebf\u6587\u6863\u7f16\u8f91", "\u652f\u6301\u591a\u4eba\u5728\u7ebf\u7f16\u8f91", "\u4fee\u6539\u5185\u5bb9\u5b9e\u65f6\u66f4\u65b0", "\u591a\u7aef\u540c\u6b65\u968f\u65f6\u67e5\u770b", "\u5f00\u59cb\u7f16\u8f91", "\u5c06\u751f\u6210\u4e00\u4efd\u65b0\u6587\u6863\uff0c\u4fdd\u5b58\u4f4d\u7f6e: \u817e\u8baf\u6587\u6863/\u6211\u7684\u6587\u6863");

    /* renamed from: f, reason: collision with root package name */
    public static final a f292184f = new a(R.drawable.khd, "\u5bfc\u51fa\u4e3aPDF", "\u683c\u5f0f\u65e0\u635f\u8f6c\u6362", "\u4e91\u7aef\u6c38\u4e45\u4fdd\u5b58", "\u591a\u7aef\u6f2b\u6e38\u67e5\u770b", "\u5f00\u59cb\u8f6c\u6362");

    /* renamed from: g, reason: collision with root package name */
    public static final a f292185g = new a(R.drawable.khf, "\u8f6c\u4e3a\u7b80\u5386", "\u6d77\u91cf\u7b80\u5386\u8303\u6587\u548c\u53c2\u8003\u6848\u4f8b\uff0c\u544a\u522b\u4ece0\u5f00\u59cb", "\u4e30\u5bcc\u6a21\u677f\uff0c\u514d\u6392\u7248\u4e00\u952e\u7f8e\u5316", "\u667a\u80fd\u5206\u6790\u6da6\u8272\uff0c\u83b7\u53d6\u4e13\u4e1a\u5efa\u8bae", "\u7acb\u5373\u4f7f\u7528");

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f292186a;

        /* renamed from: b, reason: collision with root package name */
        public String f292187b;

        /* renamed from: c, reason: collision with root package name */
        public String f292188c;

        /* renamed from: d, reason: collision with root package name */
        public String f292189d;

        /* renamed from: e, reason: collision with root package name */
        public String f292190e;

        /* renamed from: f, reason: collision with root package name */
        public String f292191f;

        /* renamed from: g, reason: collision with root package name */
        public String f292192g;

        public a(int i3, String str, String str2, String str3, String str4, String str5) {
            this(i3, str, str2, str3, str4, str5, "\u5c06\u751f\u6210\u4e00\u4efd\u65b0\u6587\u6863\uff0c\u4fdd\u5b58\u4f4d\u7f6e: \u817e\u8baf\u6587\u6863/\u6765\u81eaQQ\u6587\u4ef6");
        }

        public a(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f292186a = i3;
            this.f292187b = str;
            this.f292188c = str2;
            this.f292189d = str3;
            this.f292190e = str4;
            this.f292191f = str5;
            this.f292192g = str6;
        }
    }

    public static au a(int i3) {
        return f292179a.get(Integer.valueOf(i3));
    }
}
