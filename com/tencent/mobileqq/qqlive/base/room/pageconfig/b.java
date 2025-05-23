package com.tencent.mobileqq.qqlive.base.room.pageconfig;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\t\n\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b;", "", "Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$b;", "c", "Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$a;", "grayInfo", "", "componentKey", "", "a", "b", "configType", "d", "", "I", "configStatus", "Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$b;", "<init>", "()V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f271112a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int configStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static C8358b grayInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$a;", "", "", "", "blackList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$c;", "grayList", "b", "setGrayList", "<init>", "()V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        @SerializedName("black_list")
        @Nullable
        private List<String> blackList;

        @SerializedName("gray_list")
        @Nullable
        private List<c> grayList;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final List<String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.blackList;
        }

        @Nullable
        public final List<c> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.grayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$b;", "", "", "configType", "Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$a;", "a", "toString", "entertainment", "Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$a;", "getEntertainment", "()Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$a;", "setEntertainment", "(Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$a;)V", "game", "getGame", "setGame", "od", "getOd", "setOd", "entertainmentAnchor", "getEntertainmentAnchor", "setEntertainmentAnchor", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.base.room.pageconfig.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8358b {
        static IPatchRedirector $redirector_;

        @SerializedName("entertainment")
        @Nullable
        private a entertainment;

        @SerializedName("entertainment_anchor")
        @Nullable
        private a entertainmentAnchor;

        @SerializedName("game")
        @Nullable
        private a game;

        @SerializedName("od")
        @Nullable
        private a od;

        @Nullable
        public final a a(@NotNull String configType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) configType);
            }
            Intrinsics.checkNotNullParameter(configType, "configType");
            int hashCode = configType.hashCode();
            if (hashCode != 3541) {
                if (hashCode != 3165170) {
                    if (hashCode != 500006792) {
                        if (hashCode == 1671968588 && configType.equals("entertainment_anchor")) {
                            return this.entertainmentAnchor;
                        }
                    } else if (configType.equals("entertainment")) {
                        return this.entertainment;
                    }
                } else if (configType.equals("game")) {
                    return this.game;
                }
            } else if (configType.equals("od")) {
                return this.od;
            }
            return null;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "ComponentSwitch(entertainment=" + this.entertainment + ", game=" + this.game + ", od=" + this.od + ", entertainmentAnchor=" + this.entertainmentAnchor + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/pageconfig/b$c;", "", "", HippyQQConstants.URL_COMPONENT_NAME, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setComponent", "(Ljava/lang/String;)V", "", "startTime", "J", "c", "()J", "setStartTime", "(J)V", "endTime", "b", "setEndTime", "<init>", "()V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        @SerializedName(HippyQQConstants.URL_COMPONENT_NAME)
        @NotNull
        private String component;

        @SerializedName("end_time")
        private long endTime;

        @SerializedName("start_time")
        private long startTime;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.component = "";
            this.startTime = -1L;
            this.endTime = -1L;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.component;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.endTime;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.startTime;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21309);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f271112a = new b();
            configStatus = -1;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(a grayInfo2, String componentKey) {
        List<String> a16 = grayInfo2.a();
        if (a16 == null) {
            return false;
        }
        int size = a16.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(a16.get(i3), componentKey)) {
                return true;
            }
        }
        return false;
    }

    private final boolean b(a grayInfo2, String componentKey) {
        List<c> b16 = grayInfo2.b();
        if (b16 == null) {
            return true;
        }
        for (c cVar : b16) {
            if (TextUtils.equals(componentKey, cVar.a())) {
                long c16 = cVar.c();
                long b17 = cVar.b();
                long currentTimeMillis = System.currentTimeMillis();
                if (c16 + 1 <= currentTimeMillis && currentTimeMillis < b17) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private final C8358b c() {
        int i3 = configStatus;
        if (i3 == 1) {
            return grayInfo;
        }
        if (i3 == -1) {
            return null;
        }
        return grayInfo;
    }

    public final boolean d(@NotNull String configType, @NotNull String componentKey) {
        a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configType, (Object) componentKey)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(componentKey, "componentKey");
        C8358b c16 = c();
        if (c16 == null) {
            return true;
        }
        try {
            a16 = c16.a(configType);
        } catch (JSONException unused) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("ComponentSwitchConfig", "json parse error:" + c16);
        }
        if (a16 == null) {
            return true;
        }
        if (a(a16, componentKey)) {
            return false;
        }
        if (b(a16, componentKey)) {
            return true;
        }
        return false;
    }
}
