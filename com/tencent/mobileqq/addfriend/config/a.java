package com.tencent.mobileqq.addfriend.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tR0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\rj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/addfriend/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "appId", "Lcom/tencent/mobileqq/addfriend/config/b;", DownloadInfo.spKey_Config, "", "b", "c", "", "sourceId", "", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", Constants.Configs.CONFIGS, "<init>", "()V", "e", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, b> configs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/addfriend/config/a$a;", "", "", "content", "Lcom/tencent/mobileqq/addfriend/config/a;", "a", "tag", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002f\u0012b\u0012`\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0018\u00010\u0002j:\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012,\u0012*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0004\u0018\u0001`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/addfriend/config/a$a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.addfriend.config.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C7226a extends TypeToken<HashMap<String, HashMap<String, String>>> {
            static IPatchRedirector $redirector_;

            C7226a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final a a(@NotNull String content) {
            String sourceId;
            String subSourceId;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
            }
            Intrinsics.checkNotNullParameter(content, "content");
            a aVar = new a();
            try {
                Gson gson = new Gson();
                Type type = new C7226a().getType();
                Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<HashM\u2026?, String?>?>?>() {}.type");
                Object fromJson = gson.fromJson(content, type);
                Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(content, type)");
                HashMap hashMap = (HashMap) fromJson;
                for (String appId : hashMap.keySet()) {
                    HashMap hashMap2 = (HashMap) hashMap.get(appId);
                    if (hashMap2 != null && (sourceId = (String) hashMap2.get("androidSourceId")) != null && (subSourceId = (String) hashMap2.get("androidSubSourceId")) != null) {
                        Intrinsics.checkNotNullExpressionValue(sourceId, "sourceId");
                        int parseInt = Integer.parseInt(sourceId);
                        Intrinsics.checkNotNullExpressionValue(subSourceId, "subSourceId");
                        b bVar = new b(parseInt, Integer.parseInt(subSourceId));
                        Intrinsics.checkNotNullExpressionValue(appId, "appId");
                        aVar.b(appId, bVar);
                        QLog.i("AddFriendOpenSdkConfigData", 1, "addConfig,appId=" + appId + ",sourceId=" + sourceId + ",subSourceId=" + subSourceId);
                    }
                }
            } catch (Exception e16) {
                QLog.e("AddFriendOpenSdkConfigData", 1, e16.getMessage(), e16);
            }
            return aVar;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<String, b> hashMap = new HashMap<>();
        this.configs = hashMap;
        hashMap.put("102060558", new b(0, 0, 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String appId, b config) {
        this.configs.put(appId, config);
    }

    @Nullable
    public final b c(@NotNull String appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appId);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (!this.configs.containsKey(appId)) {
            return null;
        }
        return this.configs.get(appId);
    }

    public final boolean d(int sourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, sourceId)).booleanValue();
        }
        Iterator<String> it = this.configs.keySet().iterator();
        while (it.hasNext()) {
            b bVar = this.configs.get(it.next());
            if (bVar != null && sourceId == bVar.a()) {
                return true;
            }
        }
        return false;
    }
}
