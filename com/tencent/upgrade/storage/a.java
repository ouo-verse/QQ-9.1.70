package com.tencent.upgrade.storage;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.standard.storage.IRStorage;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/upgrade/storage/a;", "Lcom/tencent/upgrade/storage/d;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "getParam", "value", "", "a", "remove", "Lcom/tencent/raft/standard/storage/IRStorage;", "Lcom/tencent/raft/standard/storage/IRStorage;", "commonStorage", "<init>", "(Lcom/tencent/raft/standard/storage/IRStorage;)V", "upgrade_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IRStorage commonStorage;

    public a(@Nullable IRStorage iRStorage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iRStorage);
        } else {
            this.commonStorage = iRStorage;
        }
    }

    private final Object b(String key, Object defaultValue) {
        String string;
        IRStorage iRStorage = this.commonStorage;
        String str = "";
        if (iRStorage != null && (string = iRStorage.getString(key, "")) != null) {
            str = string;
        }
        try {
            return new Gson().fromJson(str, (Class) defaultValue.getClass());
        } catch (JsonSyntaxException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.tencent.upgrade.storage.d
    public void a(@Nullable String key, @Nullable Object value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, value);
            return;
        }
        if (key != null && value != null) {
            String simpleName = value.getClass().getSimpleName();
            Intrinsics.checkExpressionValueIsNotNull(simpleName, "value.javaClass.simpleName");
            if (Intrinsics.areEqual(Entry.DATA_TYPE_STRING, simpleName)) {
                IRStorage iRStorage = this.commonStorage;
                if (iRStorage != null) {
                    iRStorage.putString(key, value.toString());
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("Integer", simpleName)) {
                IRStorage iRStorage2 = this.commonStorage;
                if (iRStorage2 != null) {
                    iRStorage2.putString(key, value.toString());
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("Boolean", simpleName)) {
                IRStorage iRStorage3 = this.commonStorage;
                if (iRStorage3 != null) {
                    iRStorage3.putString(key, value.toString());
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("Float", simpleName)) {
                IRStorage iRStorage4 = this.commonStorage;
                if (iRStorage4 != null) {
                    iRStorage4.putString(key, value.toString());
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("Long", simpleName)) {
                IRStorage iRStorage5 = this.commonStorage;
                if (iRStorage5 != null) {
                    iRStorage5.putString(key, value.toString());
                    return;
                }
                return;
            }
            if (value instanceof Serializable) {
                String json = new Gson().toJson(value);
                IRStorage iRStorage6 = this.commonStorage;
                if (iRStorage6 != null) {
                    iRStorage6.putString(key, json);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(value.getClass().getName() + " \u5fc5\u987b\u5b9e\u73b0Serializable\u63a5\u53e3!");
        }
    }

    @Override // com.tencent.upgrade.storage.d
    @Nullable
    public Object getParam(@Nullable String key, @Nullable Object defaultValue) {
        Long longOrNull;
        Float floatOrNull;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this, (Object) key, defaultValue);
        }
        if (key == null) {
            return null;
        }
        if (defaultValue != null) {
            String simpleName = defaultValue.getClass().getSimpleName();
            Intrinsics.checkExpressionValueIsNotNull(simpleName, "defaultValue.javaClass.simpleName");
            String str = "";
            if (Intrinsics.areEqual(Entry.DATA_TYPE_STRING, simpleName)) {
                IRStorage iRStorage = this.commonStorage;
                if (iRStorage == null) {
                    return null;
                }
                if (!(defaultValue instanceof String)) {
                    defaultValue = null;
                }
                String str2 = (String) defaultValue;
                if (str2 != null) {
                    str = str2;
                }
                return iRStorage.getString(key, str);
            }
            if (Intrinsics.areEqual("Integer", simpleName)) {
                IRStorage iRStorage2 = this.commonStorage;
                if (iRStorage2 == null) {
                    return null;
                }
                if (!(defaultValue instanceof String)) {
                    defaultValue = null;
                }
                String str3 = (String) defaultValue;
                if (str3 != null) {
                    str = str3;
                }
                String string = iRStorage2.getString(key, str);
                if (string != null) {
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
                    return intOrNull;
                }
                return null;
            }
            if (Intrinsics.areEqual("Boolean", simpleName)) {
                IRStorage iRStorage3 = this.commonStorage;
                if (iRStorage3 == null) {
                    return null;
                }
                if (!(defaultValue instanceof String)) {
                    defaultValue = null;
                }
                String str4 = (String) defaultValue;
                if (str4 != null) {
                    str = str4;
                }
                String string2 = iRStorage3.getString(key, str);
                if (string2 == null) {
                    return null;
                }
                return Boolean.valueOf(Boolean.parseBoolean(string2));
            }
            if (Intrinsics.areEqual("Float", simpleName)) {
                IRStorage iRStorage4 = this.commonStorage;
                if (iRStorage4 == null) {
                    return null;
                }
                if (!(defaultValue instanceof String)) {
                    defaultValue = null;
                }
                String str5 = (String) defaultValue;
                if (str5 != null) {
                    str = str5;
                }
                String string3 = iRStorage4.getString(key, str);
                if (string3 != null) {
                    floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(string3);
                    return floatOrNull;
                }
                return null;
            }
            if (Intrinsics.areEqual("Long", simpleName)) {
                IRStorage iRStorage5 = this.commonStorage;
                if (iRStorage5 == null) {
                    return null;
                }
                if (!(defaultValue instanceof String)) {
                    defaultValue = null;
                }
                String str6 = (String) defaultValue;
                if (str6 != null) {
                    str = str6;
                }
                String string4 = iRStorage5.getString(key, str);
                if (string4 != null) {
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string4);
                    return longOrNull;
                }
                return null;
            }
            return b(key, defaultValue);
        }
        throw new IllegalArgumentException("\u9ed8\u8ba4\u503c\u4e0d\u80fd\u4e3anull!".toString());
    }

    @Override // com.tencent.upgrade.storage.d
    public void remove(@Nullable String key) {
        IRStorage iRStorage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
        } else if (key != null && (iRStorage = this.commonStorage) != null) {
            iRStorage.remove(key);
        }
    }
}
