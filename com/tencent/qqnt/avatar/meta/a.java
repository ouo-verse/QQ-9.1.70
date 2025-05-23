package com.tencent.qqnt.avatar.meta;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\t\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002R.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u00028\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/avatar/meta/a;", "Lcom/tencent/qqnt/avatar/bean/a;", "", "d", h.F, "key", "", "defValue", "f", "", "i", "j", "", "", "e", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "k", "(Ljava/util/Map;)V", QQBrowserActivity.APP_PARAM, "Ljava/lang/String;", "beanInfoKey", "getBeanKey", "()Ljava/lang/String;", "beanKey", "fetcherType", "avatarType", "id", "size", "<init>", "(IILjava/lang/String;I)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class a extends com.tencent.qqnt.avatar.bean.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> extraParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String beanInfoKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String beanKey;

    public a(int i3, int i16, @Nullable String str, int i17) {
        super(i3, i16, str, i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17));
            return;
        }
        this.extraParams = new LinkedHashMap();
        String str2 = i3 + "_" + i16 + "_" + str;
        this.beanInfoKey = str2;
        this.beanKey = str2 + "_" + i17;
    }

    @Override // com.tencent.qqnt.avatar.bean.a
    @NotNull
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.beanKey;
    }

    public final boolean f(@NotNull String key, boolean defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, key, Boolean.valueOf(defValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.extraParams.get(key);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return defValue;
    }

    @NotNull
    public final Map<String, Object> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.extraParams;
    }

    @NotNull
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.beanInfoKey;
    }

    public final int i(@NotNull String key, int defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, defValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.extraParams.get(key);
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        return defValue;
    }

    @Nullable
    public final String j(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.extraParams.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final void k(@NotNull Map<String, ? extends Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.extraParams = map;
        }
    }
}
