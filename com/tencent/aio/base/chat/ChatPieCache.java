package com.tencent.aio.base.chat;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003J\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0014J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/base/chat/ChatPieCache;", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/aio/base/chat/ChatPie;", "()V", "mCapacity", "", "mRemoved", "", "putAndGetRemoved", "key", "value", "removeEldestEntry", "", "eldest", "setCapacity", "", "capacity", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ChatPieCache extends LinkedHashMap<String, ChatPie> {
    static IPatchRedirector $redirector_;
    private int mCapacity;
    private Map.Entry<String, ChatPie> mRemoved;

    public ChatPieCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mCapacity = 4;
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(ChatPie chatPie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? super.containsValue((Object) chatPie) : ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) chatPie)).booleanValue();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, ChatPie>> entrySet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Set) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return getEntries();
    }

    public /* bridge */ ChatPie get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? (ChatPie) super.get((Object) str) : (ChatPie) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
    }

    public /* bridge */ Set getEntries() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Set) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Set) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return super.keySet();
    }

    public /* bridge */ ChatPie getOrDefault(String str, ChatPie chatPie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? (ChatPie) super.getOrDefault((Object) str, (String) chatPie) : (ChatPie) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) chatPie);
    }

    public /* bridge */ int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Collection) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Set) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return getKeys();
    }

    @Nullable
    public final ChatPie putAndGetRemoved(@NotNull String key, @NotNull ChatPie value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ChatPie) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) value);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mRemoved = null;
        put(key, value);
        Map.Entry<String, ChatPie> entry = this.mRemoved;
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public /* bridge */ ChatPie remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (ChatPie) super.remove((Object) str) : (ChatPie) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(@NotNull Map.Entry<String, ChatPie> eldest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) eldest)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(eldest, "eldest");
        if (size() > this.mCapacity) {
            this.mRemoved = eldest;
            return true;
        }
        this.mRemoved = null;
        return false;
    }

    public final void setCapacity(int capacity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, capacity);
        } else {
            this.mCapacity = capacity;
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<ChatPie> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Collection) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? super.containsKey((Object) str) : ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof ChatPie) {
            return containsValue((ChatPie) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return iPatchRedirector.redirect((short) 14, (Object) this, obj);
        }
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? obj instanceof String ? getOrDefault((String) obj, (ChatPie) obj2) : obj2 : iPatchRedirector.redirect((short) 16, (Object) this, obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, obj);
        }
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj, obj2)).booleanValue();
        }
        if (!(obj != null ? obj instanceof String : true)) {
            return false;
        }
        if (obj2 != null ? obj2 instanceof ChatPie : true) {
            return remove((String) obj, (ChatPie) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, ChatPie chatPie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? super.remove((Object) str, (Object) chatPie) : ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) chatPie)).booleanValue();
    }
}
