package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.util.i;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\t\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\n\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\r\u001a\u00020\u0007J.\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/i;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "Lcom/tencent/qqnt/ntrelation/util/b;", "getResult", "", "f", "g", "j", "", "i", "d", "uid", "obj1", "obj2", "stringBuilder", tl.h.F, "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f360262a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/util/i$a", "Lcom/tencent/qqnt/ntrelation/util/b;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.qqnt.ntrelation.util.b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/util/i$a$a", "Lcom/tencent/qqnt/ntrelation/util/b;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.ntrelation.util.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9672a implements com.tencent.qqnt.ntrelation.util.b {
            C9672a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(StringBuilder result) {
                Intrinsics.checkNotNullParameter(result, "$result");
                i.f360262a.j(result);
            }

            @Override // com.tencent.qqnt.ntrelation.util.b
            public void a(final StringBuilder result) {
                Intrinsics.checkNotNullParameter(result, "result");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.ntrelation.util.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.a.C9672a.c(result);
                    }
                });
            }
        }

        a() {
        }

        @Override // com.tencent.qqnt.ntrelation.util.b
        public void a(StringBuilder result) {
            Intrinsics.checkNotNullParameter(result, "result");
            i.f360262a.g(result, new C9672a());
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        f360262a.f(new StringBuilder(), new a());
    }

    private final void f(StringBuilder result, com.tencent.qqnt.ntrelation.util.b getResult) {
        String i3 = i();
        if (i3 == null || i3.length() == 0) {
            ToastUtil.a().e("uin is null");
        } else {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(i3, "NTFriendDBCheckManager", new b(i3, result, getResult));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(StringBuilder result, com.tencent.qqnt.ntrelation.util.b getResult) {
        String i3 = i();
        if (i3 == null || i3.length() == 0) {
            ToastUtil.a().e("uin is null");
        } else {
            ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(i3, "NTFriendDBCheckManager", new c(i3, result, getResult));
        }
    }

    private final String i() {
        String str;
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> allFriend;
        int size;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            str = "";
        } else {
            str = peekAppRuntime.getAccount();
        }
        if ((str == null || str.length() == 0) || (size = (allFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend("NTFriendDBCheckManager")).size()) <= 0) {
            return "";
        }
        return allFriend.get(new Random().nextInt(size)).getUid();
    }

    public final void d() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.util.g
            @Override // java.lang.Runnable
            public final void run() {
                i.e();
            }
        }, 16, null, false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/util/i$b", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f360263a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f360264b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.ntrelation.util.b f360265c;

        b(String str, StringBuilder sb5, com.tencent.qqnt.ntrelation.util.b bVar) {
            this.f360263a = str;
            this.f360264b = sb5;
            this.f360265c = bVar;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/util/i$b$a", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f360266a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.c f360267b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ StringBuilder f360268c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.ntrelation.util.b f360269d;

            a(String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar, StringBuilder sb5, com.tencent.qqnt.ntrelation.util.b bVar) {
                this.f360266a = str;
                this.f360267b = cVar;
                this.f360268c = sb5;
                this.f360269d = bVar;
            }

            @Override // hx3.b
            public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> responseData) {
                if (!(responseData != null && responseData.a() == 0)) {
                    QLog.d("NTFriendDBCheckManager", 1, "code error");
                    return;
                }
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> b16 = responseData.b();
                if (b16 == null || b16.isEmpty()) {
                    QLog.d("NTFriendDBCheckManager", 1, "ntFriendDetailInfoList isNullOrEmpty");
                    return;
                }
                com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = b16.get(0);
                Intrinsics.checkNotNullExpressionValue(cVar, "ntFriendDetailInfoList[0]");
                i.f360262a.h(this.f360266a, this.f360267b, cVar, this.f360268c);
                this.f360269d.a(this.f360268c);
            }
        }

        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> responseData) {
            if (!(responseData != null && responseData.a() == 0)) {
                QLog.d("NTFriendDBCheckManager", 1, "code error");
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> b16 = responseData.b();
            if (b16 == null || b16.isEmpty()) {
                QLog.d("NTFriendDBCheckManager", 1, "ntFriendDetailInfoList isNullOrEmpty ");
                return;
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = b16.get(0);
            Intrinsics.checkNotNullExpressionValue(cVar, "ntFriendDetailInfoList[0]");
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            String str = this.f360263a;
            iFriendsInfoService.getControlGroupFriendsDetailInfoWithUid(str, "NTFriendDBCheckManager", new a(str, cVar, this.f360264b, this.f360265c));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/util/i$c", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f360270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f360271b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.ntrelation.util.b f360272c;

        c(String str, StringBuilder sb5, com.tencent.qqnt.ntrelation.util.b bVar) {
            this.f360270a = str;
            this.f360271b = sb5;
            this.f360272c = bVar;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/util/i$c$a", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f360273a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.a f360274b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ StringBuilder f360275c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.ntrelation.util.b f360276d;

            a(String str, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar, StringBuilder sb5, com.tencent.qqnt.ntrelation.util.b bVar) {
                this.f360273a = str;
                this.f360274b = aVar;
                this.f360275c = sb5;
                this.f360276d = bVar;
            }

            @Override // hx3.b
            public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> responseData) {
                if (!(responseData != null && responseData.a() == 0)) {
                    QLog.d("NTFriendDBCheckManager", 1, "code error");
                    return;
                }
                ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16 = responseData.b();
                if (b16 == null || b16.isEmpty()) {
                    QLog.d("NTFriendDBCheckManager", 1, "ntFriendDetailInfoList isNullOrEmpty");
                    return;
                }
                com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = b16.get(0);
                Intrinsics.checkNotNullExpressionValue(aVar, "ntOtherDetailInfoList[0]");
                i.f360262a.h(this.f360273a, this.f360274b, aVar, this.f360275c);
                this.f360276d.a(this.f360275c);
            }
        }

        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> responseData) {
            if (!(responseData != null && responseData.a() == 0)) {
                QLog.d("NTFriendDBCheckManager", 1, "code error");
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16 = responseData.b();
            if (b16 == null || b16.isEmpty()) {
                QLog.d("NTFriendDBCheckManager", 1, "ntFriendDetailInfoList isNullOrEmpty ");
                return;
            }
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = b16.get(0);
            Intrinsics.checkNotNullExpressionValue(aVar, "ntOtherDetailInfoList[0]");
            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
            String str = this.f360270a;
            iOtherInfoService.getControlGroupOtherInfoWithUid(str, "NTFriendDBCheckManager", new a(str, aVar, this.f360271b, this.f360272c));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(StringBuilder result) {
        if (result == null || result.length() == 0) {
            ToastUtil.a().e("brother,friendDetail congratulations \uff01\uff01\uff01");
            return;
        }
        ToastUtil.a().e("brother,friendDetail error happen!error Info:" + ((Object) result));
        QLog.d("NTFriendDBCheckManager", 1, "brother,error happen!error Info:" + ((Object) result));
    }

    public final void h(String uid, Object obj1, Object obj2, StringBuilder stringBuilder) throws IllegalAccessException {
        Object obj = obj1;
        Object obj3 = obj2;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        if (obj == obj3 || obj == null || obj3 == null) {
            return;
        }
        Class<?> cls = obj1.getClass();
        if (Intrinsics.areEqual(cls, obj2.getClass())) {
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "clazz.declaredFields");
            int length = declaredFields.length;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                field.setAccessible(true);
                try {
                    Object obj4 = field.get(obj);
                    Object obj5 = field.get(obj3);
                    if (obj4 != null || obj5 != null) {
                        if (obj4 == null || obj5 == null) {
                            stringBuilder.append("uid= " + uid + "  ClassName = " + cls.getName() + "  FieldName = " + field.getName() + " nt value = " + obj4 + " qq value =" + obj5 + " \n");
                        }
                        if (!Intrinsics.areEqual(obj4, obj5)) {
                            stringBuilder.append("uid= " + uid + "ClassName = " + cls.getName() + "  FieldName = " + field.getName() + " nt value = " + obj4 + " qq value =" + obj5 + " \n");
                        }
                    }
                } catch (NullPointerException e16) {
                    QLog.d("NTFriendDBCheckManager", 1, "error class =  " + cls.getName() + " field = " + field.getName() + " exception = " + e16);
                }
                i3++;
                obj = obj1;
                obj3 = obj2;
            }
        }
    }
}
