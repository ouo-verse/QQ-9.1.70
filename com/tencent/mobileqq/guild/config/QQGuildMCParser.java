package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class QQGuildMCParser extends BaseConfigParser<QQGuildMCBean> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b>\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bK\u0010LJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fJ&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J>\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0013R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0013R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0013R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0013R\u0014\u0010'\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0013R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0013R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0013R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0013R\u0014\u0010-\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0013R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0013R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0013R\u0014\u00100\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0013R\u0014\u00101\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0013R\u0014\u00102\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0013R\u0014\u00103\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0013R\u0014\u00104\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010\u0013R\u0014\u00105\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010\u0013R\u0014\u00106\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b6\u0010\u0013R\u0014\u00107\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010\u0013R\u0014\u00108\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u0010\u0013R\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010\u0013R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010\u0013R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010\u0013R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010\u0013R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010\u0013R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010\u0013R\u0014\u0010?\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010\u0013R\u0014\u0010@\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010\u0013R\u0014\u0010A\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010\u0013R\u0014\u0010B\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010\u0013R\u0014\u0010C\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bC\u0010\u0013R\u0014\u0010D\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010\u0013R\u0014\u0010E\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bE\u0010\u0013R\u0014\u0010F\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010\u0013R\u0014\u0010G\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bG\u0010\u0013R\u0014\u0010H\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bH\u0010\u0013R\u0014\u0010I\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bI\u0010\u0013R\u0014\u0010J\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bJ\u0010\u0013\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/config/QQGuildMCParser$a;", "", "", "id", "Lcom/tencent/mobileqq/guild/config/QQGuildMCBean;", "e", "configId", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "f", "", "d", "", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "b", "CONFIG_ID_100530", "Ljava/lang/String;", "CONFIG_ID_100533", "CONFIG_ID_100534", "CONFIG_ID_100535", "CONFIG_ID_100539", "CONFIG_ID_100540", "CONFIG_ID_100541", "CONFIG_ID_100543", "CONFIG_ID_100544", "CONFIG_ID_100545", "CONFIG_ID_100546", "CONFIG_ID_100549", "CONFIG_ID_100551", "CONFIG_ID_100554", "CONFIG_ID_100559", "CONFIG_ID_100560", "CONFIG_ID_100561", "CONFIG_ID_100562", "CONFIG_ID_100566", "CONFIG_ID_100567", "CONFIG_ID_100568", "CONFIG_ID_100569", "CONFIG_ID_100573", "CONFIG_ID_100574", "CONFIG_ID_100575", "CONFIG_ID_100576", "CONFIG_ID_100577", "CONFIG_ID_100582", "CONFIG_ID_100584", "CONFIG_ID_100587", "CONFIG_ID_100588", "CONFIG_ID_100589", "CONFIG_ID_100590", "CONFIG_ID_100591", "CONFIG_ID_100592", "CONFIG_ID_100593", "CONFIG_ID_100594", "CONFIG_ID_100595", "CONFIG_ID_100597", "CONFIG_ID_100915", "CONFIG_ID_100960", "CONFIG_ID_101188", "CONFIG_ID_101719", "CONFIG_ID_102429", "CONFIG_ID_102564", "CONFIG_ID_102890", "CONFIG_ID_102984", "CONFIG_ID_103101", "CONFIG_ID_105455", "CONFIG_ID_105748", "CONFIG_ID_105813", "CONFIG_ID_105827", "CONFIG_ID_106048", "CONFIG_ID_106061", "CONFIG_ID_SCHEDULE_TAB_102677", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.QQGuildMCParser$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<String> a(@NotNull String configId, @NotNull String key) {
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(key, "key");
            return b(configId, key, new ArrayList<>());
        }

        @NotNull
        public final ArrayList<String> b(@NotNull String configId, @NotNull String key, @NotNull ArrayList<String> defaultValue) {
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            QQGuildMCBean e16 = e(configId);
            try {
                JSONArray jSONArray = new JSONArray(e16.a().get(key));
                ArrayList<String> arrayList = new ArrayList<>();
                int length = jSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    String optString = jSONArray.optString(i16);
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonArray.optString(i)");
                    int length2 = optString.length() - 1;
                    int i17 = 0;
                    boolean z17 = false;
                    while (i17 <= length2) {
                        if (!z17) {
                            i3 = i17;
                        } else {
                            i3 = length2;
                        }
                        if (Intrinsics.compare((int) optString.charAt(i3), 32) <= 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z17) {
                            if (!z16) {
                                z17 = true;
                            } else {
                                i17++;
                            }
                        } else {
                            if (!z16) {
                                break;
                            }
                            length2--;
                        }
                    }
                    String obj = optString.subSequence(i17, length2 + 1).toString();
                    if (!TextUtils.isEmpty(obj)) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            } catch (Exception unused) {
                QLog.e("QQGuildMCParser", 1, "[getArrayList] key = " + key + " value = " + ((Object) e16.a().get(key)));
                return defaultValue;
            }
        }

        public final boolean c(@NotNull String configId, @NotNull String key, boolean defaultValue) {
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(key, "key");
            QQGuildMCBean e16 = e(configId);
            try {
                String str = e16.a().get(key);
                if (str != null) {
                    return Boolean.parseBoolean(str);
                }
                return defaultValue;
            } catch (Exception unused) {
                QLog.e("QQGuildMCParser", 1, "[getBoolean] key = " + key + " value = " + ((Object) e16.a().get(key)));
                return defaultValue;
            }
        }

        public final int d(@NotNull String configId, @NotNull String key, int defaultValue) {
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(key, "key");
            QQGuildMCBean e16 = e(configId);
            try {
                String str = e16.a().get(key);
                if (str != null) {
                    return Integer.parseInt(str);
                }
                return defaultValue;
            } catch (Exception unused) {
                QLog.e("QQGuildMCParser", 1, "[getInt] key = " + key + " value = " + ((Object) e16.a().get(key)));
                return defaultValue;
            }
        }

        @NotNull
        public final QQGuildMCBean e(@NotNull String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            QQGuildMCBean qQGuildMCBean = (QQGuildMCBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(id5);
            if (qQGuildMCBean == null) {
                return new QQGuildMCBean();
            }
            return qQGuildMCBean;
        }

        @NotNull
        public final String f(@NotNull String configId, @NotNull String key, @NotNull String defaultValue) {
            Intrinsics.checkNotNullParameter(configId, "configId");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            QQGuildMCBean e16 = e(configId);
            try {
                String str = e16.a().get(key);
                if (str != null) {
                    return str;
                }
                return defaultValue;
            } catch (Exception unused) {
                QLog.e("QQGuildMCParser", 1, "[getString] key = " + key + " value = " + ((Object) e16.a().get(key)));
                return defaultValue;
            }
        }

        Companion() {
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QQGuildMCBean defaultConfig() {
        return new QQGuildMCBean();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public QQGuildMCBean parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Logger.f235387a.d().i("QQGuildMCParser", 1, "[" + System.identityHashCode(this) + "] parse()");
        QQGuildMCBean qQGuildMCBean = new QQGuildMCBean();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return qQGuildMCBean.l(new String(content, UTF_8));
    }
}
