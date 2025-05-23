package com.tencent.qqnt.avatar.fetch;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J,\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/avatar/fetch/ResourceFetchResultRecord;", "", "", "fetcherType", "", "hasLayer", "", "c", "Lcom/tencent/qqnt/avatar/fetch/c;", Const.BUNDLE_KEY_REQUEST, "", "Lcom/tencent/qqnt/avatar/layer/d;", "map", "a", "b", "", "Ljava/lang/String;", "getRequestKey", "()Ljava/lang/String;", "requestKey", "", "Ljava/util/Map;", "resultMap", "<init>", "(Ljava/lang/String;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ResourceFetchResultRecord {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String requestKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Boolean> resultMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/fetch/ResourceFetchResultRecord$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.fetch.ResourceFetchResultRecord$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39513);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ResourceFetchResultRecord(@NotNull String requestKey) {
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) requestKey);
        } else {
            this.requestKey = requestKey;
            this.resultMap = new LinkedHashMap();
        }
    }

    public final boolean a(@NotNull c request, @Nullable Map<Integer, ? extends com.tencent.qqnt.avatar.layer.d<? extends Object>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) map)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (map == null) {
            com.tencent.qqnt.avatar.util.d.f352991a.a("ResourceFetchResultRecord", ResourceFetchResultRecord$checkResourceLayersComplete$1.INSTANCE);
            return false;
        }
        if (this.resultMap.get(0) == null) {
            com.tencent.qqnt.avatar.util.d.f352991a.a("ResourceFetchResultRecord", ResourceFetchResultRecord$checkResourceLayersComplete$2.INSTANCE);
            return false;
        }
        List<com.tencent.qqnt.avatar.bean.a> d16 = request.d();
        if (d16 != null) {
            for (final com.tencent.qqnt.avatar.bean.a aVar : d16) {
                if (this.resultMap.get(Integer.valueOf(aVar.b())) == null) {
                    com.tencent.qqnt.avatar.util.d.f352991a.a("ResourceFetchResultRecord", new Function0<String>() { // from class: com.tencent.qqnt.avatar.fetch.ResourceFetchResultRecord$checkResourceLayersComplete$3$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.avatar.bean.a.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "checkResourceLayersComplete fetcher[" + com.tencent.qqnt.avatar.bean.a.this.b() + "] is null";
                        }
                    });
                    return false;
                }
            }
        }
        for (final Map.Entry<Integer, Boolean> entry : this.resultMap.entrySet()) {
            if (entry.getValue().booleanValue() && map.get(entry.getKey()) == null) {
                com.tencent.qqnt.avatar.util.d.f352991a.a("ResourceFetchResultRecord", new Function0<String>(entry) { // from class: com.tencent.qqnt.avatar.fetch.ResourceFetchResultRecord$checkResourceLayersComplete$4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Map.Entry<Integer, Boolean> $entry;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$entry = entry;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) entry);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "checkResourceLayersComplete map[" + this.$entry.getKey() + "] is null";
                    }
                });
                return false;
            }
        }
        return true;
    }

    public final boolean b(@NotNull c request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) request)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Boolean bool = this.resultMap.get(0);
        if (bool == null) {
            return false;
        }
        bool.booleanValue();
        List<com.tencent.qqnt.avatar.bean.a> d16 = request.d();
        if (d16 != null) {
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                Boolean bool2 = this.resultMap.get(Integer.valueOf(((com.tencent.qqnt.avatar.bean.a) it.next()).b()));
                if (bool2 == null) {
                    return false;
                }
                bool2.booleanValue();
            }
            return true;
        }
        return true;
    }

    public final void c(int fetcherType, boolean hasLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(fetcherType), Boolean.valueOf(hasLayer));
        } else {
            this.resultMap.put(Integer.valueOf(fetcherType), Boolean.valueOf(hasLayer));
        }
    }
}
