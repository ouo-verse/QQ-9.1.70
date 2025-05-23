package f22;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\t\n\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lf22/b;", "", "Lf22/b$b;", "c", "Lf22/b$a;", "grayInfo", "", "componentKey", "", "a", "b", "configType", "d", "", "I", "configStatus", "Lf22/b$b;", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f397711a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int configStatus = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ComponentSwitch grayInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lf22/b$a;", "", "", "", "blackList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "Lf22/b$c;", "grayList", "b", "setGrayList", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {

        @SerializedName("black_list")
        @Nullable
        private List<String> blackList;

        @SerializedName("gray_list")
        @Nullable
        private List<c> grayList;

        @Nullable
        public final List<String> a() {
            return this.blackList;
        }

        @Nullable
        public final List<c> b() {
            return this.grayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lf22/b$b;", "", "", "configType", "Lf22/b$a;", "a", "toString", "entertainment", "Lf22/b$a;", "getEntertainment", "()Lf22/b$a;", "setEntertainment", "(Lf22/b$a;)V", "game", "getGame", "setGame", "od", "getOd", "setOd", "entertainmentAnchor", "getEntertainmentAnchor", "setEntertainmentAnchor", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f22.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes15.dex */
    public static final class ComponentSwitch {

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
            return "ComponentSwitch(entertainment=" + this.entertainment + ", game=" + this.game + ", od=" + this.od + ", entertainmentAnchor=" + this.entertainmentAnchor + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lf22/b$c;", "", "", HippyQQConstants.URL_COMPONENT_NAME, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setComponent", "(Ljava/lang/String;)V", "", "startTime", "J", "c", "()J", "setStartTime", "(J)V", "endTime", "b", "setEndTime", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c {

        @SerializedName(HippyQQConstants.URL_COMPONENT_NAME)
        @NotNull
        private String component = "";

        @SerializedName("start_time")
        private long startTime = -1;

        @SerializedName("end_time")
        private long endTime = -1;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getComponent() {
            return this.component;
        }

        /* renamed from: b, reason: from getter */
        public final long getEndTime() {
            return this.endTime;
        }

        /* renamed from: c, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }
    }

    b() {
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
            if (TextUtils.equals(componentKey, cVar.getComponent())) {
                long startTime = cVar.getStartTime();
                long endTime = cVar.getEndTime();
                long currentTimeMillis = System.currentTimeMillis();
                if (startTime + 1 <= currentTimeMillis && currentTimeMillis < endTime) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private final ComponentSwitch c() {
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
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(componentKey, "componentKey");
        ComponentSwitch c16 = c();
        if (c16 == null) {
            return true;
        }
        try {
            a16 = c16.a(configType);
        } catch (JSONException unused) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("ICGameComponentSwitchConfig", "json parse error:" + c16);
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
