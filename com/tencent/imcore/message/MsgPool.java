package com.tencent.imcore.message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.imcore.message.core.MsgLock;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

@Deprecated
/* loaded from: classes7.dex */
public class MsgPool {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f116423d;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, List<MessageRecord>> f116424a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, List<MessageRecord>> f116425b;

    /* renamed from: c, reason: collision with root package name */
    protected ConcurrentHashMap<String, Lock> f116426c;

    /* loaded from: classes7.dex */
    public static class LogConcurrentHashMap<K> extends ConcurrentHashMap<K, List<MessageRecord>> {
        static IPatchRedirector $redirector_;
        private long lastGetLogTime;
        private long lastPutLogTime;

        public LogConcurrentHashMap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.lastPutLogTime = 0L;
                this.lastGetLogTime = 0L;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public /* bridge */ /* synthetic */ Object put(@NonNull Object obj, @NonNull Object obj2) {
            return put((LogConcurrentHashMap<K>) obj, (List<MessageRecord>) obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public void putAll(@NonNull Map<? extends K, ? extends List<MessageRecord>> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
                return;
            }
            if (System.currentTimeMillis() - this.lastPutLogTime > 10000) {
                QLog.d("MsgPool", 1, "MsgPool.putAll() call from: ", new Throwable());
                this.lastPutLogTime = System.currentTimeMillis();
            }
            super.putAll(map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        @Nullable
        public /* bridge */ /* synthetic */ Object putIfAbsent(@NonNull Object obj, @NonNull Object obj2) {
            return putIfAbsent((LogConcurrentHashMap<K>) obj, (List<MessageRecord>) obj2);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public List<MessageRecord> get(@NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this, obj);
            }
            if (System.currentTimeMillis() - this.lastGetLogTime > 10000) {
                QLog.d("MsgPool", 1, "MsgPool.get() call from: ", new Throwable());
                this.lastGetLogTime = System.currentTimeMillis();
            }
            return (List) super.get(obj);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        @Nullable
        public List<MessageRecord> getOrDefault(@NonNull Object obj, @Nullable List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this, obj, (Object) list);
            }
            if (System.currentTimeMillis() - this.lastGetLogTime > 10000) {
                QLog.d("MsgPool", 1, "MsgPool.getOrDefault() call from: ", new Throwable());
                this.lastGetLogTime = System.currentTimeMillis();
            }
            return (List) super.getOrDefault(obj, (Object) list);
        }

        @Nullable
        public List<MessageRecord> put(@NonNull K k3, @NonNull List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3, (Object) list);
            }
            if (System.currentTimeMillis() - this.lastPutLogTime > 10000) {
                QLog.d("MsgPool", 1, "MsgPool.put() call from: ", new Throwable());
                this.lastPutLogTime = System.currentTimeMillis();
            }
            if (MsgPool.f116423d && (list instanceof ArrayList)) {
                MessageList messageList = new MessageList();
                messageList.addAll(list);
                return (List) super.put((LogConcurrentHashMap<K>) k3, (K) messageList);
            }
            return (List) super.put((LogConcurrentHashMap<K>) k3, (K) list);
        }

        @Nullable
        public List<MessageRecord> putIfAbsent(@NonNull K k3, @NonNull List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3, (Object) list);
            }
            if (System.currentTimeMillis() - this.lastPutLogTime > 10000) {
                QLog.d("MsgPool", 1, "MsgPool.putIfAbsent() call from: ", new Throwable());
                this.lastPutLogTime = System.currentTimeMillis();
            }
            return (List) super.putIfAbsent((LogConcurrentHashMap<K>) k3, (K) list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class MessageList extends ArrayList<MessageRecord> {
        static IPatchRedirector $redirector_;
        private long lastAddLogTime;
        private Class<?> structMsgForGeneralShareClass;

        MessageList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.lastAddLogTime = 0L;
            }
        }

        private boolean a(MessageRecord messageRecord) {
            if (this.structMsgForGeneralShareClass == null) {
                try {
                    String str = StructMsgForGeneralShare.LOGO_URL_POSTFIX;
                    this.structMsgForGeneralShareClass = StructMsgForGeneralShare.class;
                } catch (ClassNotFoundException unused) {
                    return false;
                }
            }
            return this.structMsgForGeneralShareClass.isInstance(messageRecord);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(MessageRecord messageRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
            }
            if (size() >= 100) {
                removeRange(0, 50);
                if (System.currentTimeMillis() - this.lastAddLogTime > 10000) {
                    QLog.i("MsgPool", 1, "add too many records, type is " + messageRecord.getClass().getSimpleName(), new Throwable());
                    this.lastAddLogTime = System.currentTimeMillis();
                }
            }
            if (!a(messageRecord)) {
                return super.add((MessageList) messageRecord);
            }
            if (System.currentTimeMillis() - this.lastAddLogTime > 10000) {
                QLog.i("MsgPool", 1, "add struct msg share from: ", new Throwable());
                this.lastAddLogTime = System.currentTimeMillis();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37296);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f116423d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("msg_limit_msg_cache_size_9065_124775635", true);
        }
    }

    public MsgPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgPool", 2, "MsgPool() called " + this);
        }
        this.f116426c = new ConcurrentHashMap<>();
        this.f116425b = new LogConcurrentHashMap();
        this.f116424a = new LogConcurrentHashMap();
    }

    public Map<String, List<MessageRecord>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f116425b;
    }

    public Lock c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Lock) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!this.f116426c.containsKey(str)) {
            synchronized (this.f116426c) {
                if (!this.f116426c.containsKey(str)) {
                    this.f116426c.put(str, new MsgLock("MsgPool" + str));
                }
            }
        }
        return this.f116426c.get(str);
    }

    public ConcurrentHashMap<String, List<MessageRecord>> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116424a;
    }

    public Lock e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Lock) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        return c(ao.f(str, i3));
    }
}
