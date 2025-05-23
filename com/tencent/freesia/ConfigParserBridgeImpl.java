package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!BO\u0012\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0016\u0012\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\tJ5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0006RR\u0010\u0017\u001a>\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u00020\u0014j\u001e\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002`\u00168\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bRR\u0010\u001c\u001a>\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u00020\u0014j\u001e\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u0002`\u00168\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/freesia/ConfigParserBridgeImpl;", "Lcom/tencent/freesia/ConfigParserBridge;", "", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/freesia/ConfigParser;", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/String;)Lcom/tencent/freesia/ConfigParser;", "Ljava/util/ArrayList;", "getAllGroups", "()Ljava/util/ArrayList;", "getAllGroupsNOLogin", "", "success", "noLogin", "uin", "groups", "", "onReceive", "(ZZLjava/lang/String;Ljava/util/ArrayList;)V", "get", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "Lkotlin/collections/HashMap;", "cfgParsersNoLoginCls", "Ljava/util/HashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "parsers", "Ljava/util/concurrent/ConcurrentHashMap;", "cfgParserCls", "cfgParsers", "cfgParsersNoLogin", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "Companion", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ConfigParserBridgeImpl implements ConfigParserBridge {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final String TAG = "ConfigParserBridgeImpl";
    private final HashMap<String, String> cfgParserCls;
    private final HashMap<String, String> cfgParsersNoLoginCls;
    private final ConcurrentHashMap<String, ConfigParser> parsers;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/freesia/ConfigParserBridgeImpl$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ConfigParserBridgeImpl(@NotNull HashMap<String, String> cfgParsers, @NotNull HashMap<String, String> cfgParsersNoLogin) {
        Intrinsics.checkNotNullParameter(cfgParsers, "cfgParsers");
        Intrinsics.checkNotNullParameter(cfgParsersNoLogin, "cfgParsersNoLogin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cfgParsers, (Object) cfgParsersNoLogin);
            return;
        }
        this.cfgParserCls = new HashMap<>(cfgParsers);
        this.cfgParsersNoLoginCls = new HashMap<>(cfgParsersNoLogin);
        this.parsers = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.freesia.ConfigParserBridge
    @Nullable
    public ConfigParser create(@NotNull String group) {
        String stackTraceToString;
        String stackTraceToString2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConfigParser) iPatchRedirector.redirect((short) 3, (Object) this, (Object) group);
        }
        Intrinsics.checkNotNullParameter(group, "group");
        if (this.cfgParserCls.containsKey(group)) {
            try {
                Object newInstance = Class.forName(this.cfgParserCls.get(group)).newInstance();
                if (newInstance != null) {
                    ConfigParser configParser = (ConfigParser) newInstance;
                    this.parsers.put(group, configParser);
                    return configParser;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.freesia.ConfigParser");
            } catch (Throwable th5) {
                ILogger logger = UnitedConfig.INSTANCE.getLOGGER();
                if (logger != null) {
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th5);
                    logger.e(TAG, stackTraceToString);
                }
            }
        }
        if (this.cfgParsersNoLoginCls.containsKey(group)) {
            try {
                Object newInstance2 = Class.forName(this.cfgParsersNoLoginCls.get(group)).newInstance();
                if (newInstance2 != null) {
                    ConfigParser configParser2 = (ConfigParser) newInstance2;
                    this.parsers.put(group, configParser2);
                    return configParser2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.freesia.ConfigParser");
            } catch (Throwable th6) {
                ILogger logger2 = UnitedConfig.INSTANCE.getLOGGER();
                if (logger2 != null) {
                    stackTraceToString2 = ExceptionsKt__ExceptionsKt.stackTraceToString(th6);
                    logger2.e(TAG, stackTraceToString2);
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    @Nullable
    public final ConfigParser get(@NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConfigParser) iPatchRedirector.redirect((short) 7, (Object) this, (Object) group);
        }
        Intrinsics.checkNotNullParameter(group, "group");
        ConfigParser configParser = this.parsers.get(group);
        if (configParser == null) {
            return create(group);
        }
        return configParser;
    }

    @Override // com.tencent.freesia.ConfigParserBridge
    @NotNull
    public ArrayList<String> getAllGroups() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ArrayList<>(this.cfgParserCls.keySet());
    }

    @Override // com.tencent.freesia.ConfigParserBridge
    @NotNull
    public ArrayList<String> getAllGroupsNOLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ArrayList<>(this.cfgParsersNoLoginCls.keySet());
    }

    @Override // com.tencent.freesia.ConfigParserBridge
    public void onReceive(boolean success, boolean noLogin, @NotNull String uin, @NotNull ArrayList<String> groups) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(success), Boolean.valueOf(noLogin), uin, groups);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(groups, "groups");
        if (!groups.isEmpty()) {
            UnitedConfig orNull = UnitedConfig.INSTANCE.getOrNull();
            if (orNull != null) {
                orNull.updateCacheTime$unitedconfig_android_release(false);
            }
            Iterator<String> it = groups.iterator();
            while (it.hasNext()) {
                String group = it.next();
                UnitedConfig orNull2 = UnitedConfig.INSTANCE.getOrNull();
                if (orNull2 != null) {
                    Intrinsics.checkNotNullExpressionValue(group, "group");
                    orNull2.removeCache$unitedconfig_android_release(uin, group);
                }
            }
            UnitedConfig orNull3 = UnitedConfig.INSTANCE.getOrNull();
            if (orNull3 != null) {
                orNull3.updateCacheTime$unitedconfig_android_release(true);
            }
        }
    }
}
