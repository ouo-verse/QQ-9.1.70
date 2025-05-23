package com.tencent.mobileqq.vas.gxh;

import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.gxh.BusinessStrategyFactory;
import com.tencent.mobileqq.vas.gxh.a;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 \u00022\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory;", "", "a", "b", "c", "d", "e", "f", "g", "ThemeUpdateStrategy", tl.h.F, "i", "j", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BusinessStrategyFactory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$a;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        public a(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            boolean optBoolean = data.optBoolean("isVoice");
            this.proxy.a(setKey, data.optInt("itemId"), optBoolean);
            callback.invoke(new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J;\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$b;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONArray;", "batchSet", "", "c", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "callback", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        public b(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        private final void c(JSONArray batchSet) {
            int length = batchSet.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = batchSet.optJSONObject(i3);
                String uin = optJSONObject.optString("uin");
                int optInt = optJSONObject.optInt("type");
                String imageName = optJSONObject.optString("imageName");
                int optInt2 = optJSONObject.optInt("effectId");
                IGXHManager gxh = VasUtil.getService().getGxh();
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                Intrinsics.checkNotNullExpressionValue(imageName, "imageName");
                gxh.setCustomChatBackground(uin, imageName, optInt2, optInt, true);
            }
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            String shopBgPath;
            String valueOf;
            JSONArray optJSONArray;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            int optInt = data.optInt("itemId");
            if (optInt == 99 && (optJSONArray = data.optJSONArray("batchSet")) != null) {
                c(optJSONArray);
                callback.invoke(new w33.b(0, "").toString());
                return;
            }
            if (optInt == 100) {
                shopBgPath = "null";
            } else {
                shopBgPath = ChatBackgroundUtil.getShopBgPath(String.valueOf(optInt));
                Intrinsics.checkNotNullExpressionValue(shopBgPath, "{\n                ChatBa\u2026toString())\n            }");
            }
            String str = shopBgPath;
            String optString = data.optString("friendUin");
            int optInt2 = data.optInt("uinType");
            if (optInt == 100) {
                valueOf = "theme_1000";
            } else {
                valueOf = String.valueOf(optInt);
            }
            VasUtil.getService().getJsbCallManager().setChatBackground(valueOf, optString, str, "", "", 0, optInt2, 999);
            VasUtil.getService().getGxh().forceUpdateVasUserData(1);
            b(this.proxy.getReport(), setKey, valueOf);
            callback.invoke(new w33.b(0, "").toString());
        }

        public void b(@NotNull VasJsbCommonReport vasJsbCommonReport, @NotNull String str, @NotNull String str2) {
            a.C8910a.a(this, vasJsbCommonReport, str, str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$c;", "", "", "business", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "Lcom/tencent/mobileqq/vas/gxh/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.gxh.BusinessStrategyFactory$c, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final com.tencent.mobileqq.vas.gxh.a a(@NotNull String business, @NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Long longOrNull;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            Intrinsics.checkNotNullParameter(business, "business");
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(business);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                boolean z26 = false;
                if (longValue == 0 || longValue == 23) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 || longValue == 4) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    return new i();
                }
                if (longValue == 5) {
                    return new e(proxy);
                }
                if (longValue == 2) {
                    return new a(proxy);
                }
                Long l3 = ChatBackgroundBusiness.BID;
                if (l3 != null && longValue == l3.longValue()) {
                    return new b(proxy);
                }
                if (longValue == 15) {
                    return new g(proxy);
                }
                if (longValue == 25) {
                    return new h();
                }
                if (longValue == 17) {
                    return new f();
                }
                if (longValue == 333 || longValue == 54) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 || longValue == 57) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19 || longValue == 327) {
                    z26 = true;
                }
                if (z26) {
                    return new j(proxy);
                }
                if (longValue == 3) {
                    return new ThemeUpdateStrategy(proxy);
                }
                return new d(proxy);
            }
            if (Intrinsics.areEqual(business, "vipdata")) {
                return new j(proxy);
            }
            return new d(proxy);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$d;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        public d(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (TextUtils.isEmpty(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
                return;
            }
            b(this.proxy.getReport(), setKey, String.valueOf(data.optInt("itemId")));
            callback.invoke(new w33.b(0, "default").toString());
        }

        public void b(@NotNull VasJsbCommonReport vasJsbCommonReport, @NotNull String str, @NotNull String str2) {
            a.C8910a.a(this, vasJsbCommonReport, str, str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$e;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        public e(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (data.has("themeFontId")) {
                this.proxy.g(setKey, data.optInt("themeFontId"));
            } else {
                int optInt = data.optInt("type");
                this.proxy.d(setKey, data.optInt("itemId"), optInt);
            }
            callback.invoke(new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$f;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements com.tencent.mobileqq.vas.gxh.a {
        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            VasUtil.getService().getGxh().forceUpdateVasUserData(2);
            callback.invoke(new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$g;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class g implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$g$a", "Leipc/EIPCCallback$Stub;", "Leipc/EIPCResult;", "result", "", "callback", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a extends EIPCCallback.Stub {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f309418e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f309419f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Function1<String, Unit> f309420h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ JSONObject f309421i;

            /* JADX WARN: Multi-variable type inference failed */
            a(String str, int i3, Function1<? super String, Unit> function1, JSONObject jSONObject) {
                this.f309418e = str;
                this.f309419f = i3;
                this.f309420h = function1;
                this.f309421i = jSONObject;
            }

            @Override // eipc.EIPCCallback
            public void callback(@NotNull EIPCResult result) throws RemoteException {
                String str;
                Intrinsics.checkNotNullParameter(result, "result");
                int i3 = result.data.getInt("result");
                try {
                    g.this.proxy.c(this.f309418e, this.f309419f, 2, i3);
                    Function1<String, Unit> function1 = this.f309420h;
                    if (i3 == 0) {
                        str = "";
                    } else {
                        str = "\u83b7\u53d6\u8d44\u6599\u5361\u540d\u7247\u534f\u8bae\u63a5\u53e3\u8fd4\u56de\u5931\u8d25";
                    }
                    function1.invoke(new w33.b(i3, str).toString());
                } catch (Exception unused) {
                    QLog.e("BusinessStrategyFactory", 1, "cardProfileGetInfo parse error" + this.f309421i);
                }
            }
        }

        public g(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.proxy.b(setKey, true, new a(setKey, data.optInt("itemId"), callback, data));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$h;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class h implements com.tencent.mobileqq.vas.gxh.a {
        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 callback, String it) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            callback.invoke(it);
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull final Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            IGXHManager gxh = VasUtil.getService().getGxh();
            String jSONObject = data.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
            EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.gxh.b
                @Override // com.tencent.mobileqq.vas.api.f.b
                public final void onCallback(String str) {
                    BusinessStrategyFactory.h.c(Function1.this, str);
                }
            });
            Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
            gxh.updateTroopEnterEffectInfo(jSONObject, a16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$i;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class i implements com.tencent.mobileqq.vas.gxh.a {
        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                callback.invoke(new w33.b(1, "no account").toString());
                return;
            }
            VasUtil.getService().getVipDataProxy().requestAndUpdateData(currentAccountUin);
            VasUtil.getService().getGxh().forceUpdateVasUserData(0);
            callback.invoke(new w33.b(0, "").toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$j;", "Lcom/tencent/mobileqq/vas/gxh/a;", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class j implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        public j(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            if (TextUtils.isEmpty(currentAccountUin)) {
                return;
            }
            b(this.proxy.getReport(), setKey, String.valueOf(data.optInt("itemId")));
            VasUtil.getService().getVipDataProxy().requestAndUpdateData(currentAccountUin);
            callback.invoke(new w33.b(0, "").toString());
        }

        public void b(@NotNull VasJsbCommonReport vasJsbCommonReport, @NotNull String str, @NotNull String str2) {
            a.C8910a.a(this, vasJsbCommonReport, str, str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J;\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\u000bH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$ThemeUpdateStrategy;", "Lcom/tencent/mobileqq/vas/gxh/a;", "", "themeId", "Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$ThemeUpdateStrategy$MyThemeSwitchListener;", "callback", "", "b", "Lorg/json/JSONObject;", "data", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "a", "Lcom/tencent/mobileqq/vas/gxh/d;", "Lcom/tencent/mobileqq/vas/gxh/d;", "proxy", "<init>", "(Lcom/tencent/mobileqq/vas/gxh/d;)V", "MyThemeSwitchListener", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class ThemeUpdateStrategy implements com.tencent.mobileqq.vas.gxh.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.gxh.d proxy;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$ThemeUpdateStrategy$a", "Leipc/EIPCCallback$Stub;", "Leipc/EIPCResult;", "result", "", "callback", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a extends EIPCCallback.Stub {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f309410d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MyThemeSwitchListener f309411e;

            a(String str, MyThemeSwitchListener myThemeSwitchListener) {
                this.f309410d = str;
                this.f309411e = myThemeSwitchListener;
            }

            @Override // eipc.EIPCCallback
            public void callback(@NotNull EIPCResult result) throws RemoteException {
                Intrinsics.checkNotNullParameter(result, "result");
                boolean areEqual = Intrinsics.areEqual(result.data.getString("choose", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM), MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                if (areEqual && !SimpleUIUtil.getSimpleUISwitch()) {
                    VasLogReporter.INSTANCE.getTheme().reportHighest("web change theme");
                    ThemeSwitcher.startSwitch(this.f309410d, "200", this.f309411e);
                    return;
                }
                VasLogReporter.INSTANCE.getTheme().reportHighest("web nochange theme : isConfirm=" + areEqual);
                this.f309411e.getCallback().invoke(new w33.b(1, "simple ui").toString());
            }
        }

        public ThemeUpdateStrategy(@NotNull com.tencent.mobileqq.vas.gxh.d proxy) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.proxy = proxy;
        }

        private final void b(String themeId, MyThemeSwitchListener callback) {
            VasUtil.getService().getJsbCallManager().detailWithDarkMode(themeId, new a(themeId, callback));
        }

        @Override // com.tencent.mobileqq.vas.gxh.a
        public void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(callback, "callback");
            String themeId = data.optString("itemId");
            String currentThemeId = ThemeUtil.getCurrentThemeId();
            if (QLog.isColorLevel()) {
                QLog.i("BusinessStrategyFactory", 2, "ThemeJsHandler setup,themeId=" + themeId + " currentThemeId:" + currentThemeId);
            }
            this.proxy.getReport().removeTimeoutDelayTask(setKey);
            if (Intrinsics.areEqual(currentThemeId, themeId)) {
                w33.b bVar = new w33.b(0, "set the same theme");
                VasJsbCommonReport report = this.proxy.getReport();
                Intrinsics.checkNotNullExpressionValue(themeId, "themeId");
                report.reportSingleStepSuccess(setKey, themeId, 0L, 2);
                VasJsbCommonReport.TimeRecord timeRecord = this.proxy.getReport().getMSetKeyToStartTime().get(setKey);
                if (timeRecord != null) {
                    this.proxy.getReport().reportSetEndSetSuccess(setKey, themeId, System.currentTimeMillis() - timeRecord.getFirstQueryTime());
                }
                callback.invoke(bVar.toString());
                return;
            }
            if (Intrinsics.areEqual("1103", themeId)) {
                Intrinsics.checkNotNullExpressionValue(themeId, "themeId");
                ThemeSwitcher.startSwitch(themeId, "200", new MyThemeSwitchListener(setKey, themeId, callback));
            } else {
                Intrinsics.checkNotNullExpressionValue(themeId, "themeId");
                b(themeId, new MyThemeSwitchListener(setKey, themeId, callback));
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001'B:\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0017\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R2\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/BusinessStrategyFactory$ThemeUpdateStrategy$MyThemeSwitchListener;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitchCallback;", "", "themeId", "", "errorCode", "", "reportThemeSwitch", "beginSwitch", "", "dwProgress", "dwProgressMax", "onProgress", "Lcom/tencent/mobileqq/vas/theme/api/ThemeLocator;", "themeLocator", "", "beforeSwitch", "postSwitch", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Ljava/lang/String;", "getSetKey", "()Ljava/lang/String;", "getThemeId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "callback", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "report", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "getReport", "()Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class MyThemeSwitchListener implements IThemeSwitchCallback {
            public static final int THEME_OPTION_ERROR = -1;
            public static final int THEME_OPTION_PKG_UNZIP_ERROR = 2;
            public static final int THEME_OPTION_SUCCESS = 0;

            @NotNull
            private final Function1<String, Unit> callback;

            @NotNull
            private final VasJsbCommonReport report;

            @NotNull
            private final String setKey;

            @NotNull
            private final String themeId;

            /* JADX WARN: Multi-variable type inference failed */
            public MyThemeSwitchListener(@NotNull String setKey, @NotNull String themeId, @NotNull Function1<? super String, Unit> callback) {
                Intrinsics.checkNotNullParameter(setKey, "setKey");
                Intrinsics.checkNotNullParameter(themeId, "themeId");
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.setKey = setKey;
                this.themeId = themeId;
                this.callback = callback;
                this.report = VasJsbCommonReport.INSTANCE;
            }

            private final void reportThemeSwitch(String themeId, int errorCode) {
                VasJsbCommonReport.TimeRecord timeRecord;
                if (!TextUtils.isEmpty(this.setKey) && (timeRecord = this.report.getMSetKeyToStartTime().get(this.setKey)) != null) {
                    if (errorCode == 0) {
                        this.report.reportSingleStepSuccess(this.setKey, timeRecord.getSetupId(), System.currentTimeMillis() - timeRecord.getSetupTime(), 2);
                        this.report.reportSetEndSetSuccess(this.setKey, themeId, System.currentTimeMillis() - timeRecord.getFirstQueryTime());
                    } else {
                        this.report.reportSingleStepFail(this.setKey, themeId, System.currentTimeMillis() - timeRecord.getSetupTime(), errorCode, 5);
                        this.report.reportSetEndSetFail(this.setKey, themeId, System.currentTimeMillis() - timeRecord.getFirstQueryTime(), errorCode);
                    }
                }
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean beforeSwitch(@Nullable ThemeLocator themeLocator) {
                return false;
            }

            @NotNull
            public final Function1<String, Unit> getCallback() {
                return this.callback;
            }

            @NotNull
            public final VasJsbCommonReport getReport() {
                return this.report;
            }

            @NotNull
            public final String getSetKey() {
                return this.setKey;
            }

            @NotNull
            public final String getThemeId() {
                return this.themeId;
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean postSwitch(int errorCode) {
                String str;
                reportThemeSwitch(this.themeId, errorCode);
                int i3 = -1;
                if (errorCode != -202 && errorCode != -201) {
                    if (errorCode != 0) {
                        if (errorCode != 3) {
                            str = "other error";
                        } else {
                            QLog.i("BusinessStrategyFactory", 1, "ThemeJsHandler return because setupping.");
                            i3 = 2;
                            str = "unzip error";
                        }
                    } else {
                        i3 = 0;
                        str = "success";
                    }
                } else {
                    str = "timeout";
                }
                this.callback.invoke(new w33.b(i3, str).toString());
                return true;
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public void beginSwitch() {
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public void onProgress(long dwProgress, long dwProgressMax) {
            }
        }
    }
}
