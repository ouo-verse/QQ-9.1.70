package com.tencent.tdf.channel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.com.tencent.tdf.channel.a;
import java.com.tencent.tdf.channel.annotation.Channel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ChannelRegistry {
    static IPatchRedirector $redirector_;
    private final Map<String, Object> mModuleMap;
    private final Object registryLock;

    public ChannelRegistry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mModuleMap = new HashMap();
            this.registryLock = new Object();
        }
    }

    @Nullable
    public static String getChannelMethodsSignature(Object obj) {
        return a.b(obj);
    }

    @Nullable
    public Object getChannel(String str) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        synchronized (this.registryLock) {
            obj = this.mModuleMap.get(str);
        }
        return obj;
    }

    public Class getClazz(String str) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        synchronized (this.registryLock) {
            obj = this.mModuleMap.get(str);
        }
        return obj.getClass();
    }

    public void registerChannel(@NonNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
            return;
        }
        Channel channel = (Channel) obj.getClass().getAnnotation(Channel.class);
        if (channel == null) {
            return;
        }
        synchronized (this.registryLock) {
            if (channel.names().length > 0) {
                for (String str : channel.names()) {
                    this.mModuleMap.put(str, obj);
                }
                return;
            }
            if (channel.name().isEmpty()) {
                return;
            }
            this.mModuleMap.put(channel.name(), obj);
        }
    }
}
