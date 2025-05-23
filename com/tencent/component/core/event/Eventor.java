package com.tencent.component.core.event;

import com.tencent.component.core.event.impl.EventImpl;
import com.tencent.component.core.event.impl.OnEvent;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Eventor {
    private static final String TAG = "event_log";
    private final Logger logger = LoggerFactory.getLogger(TAG);
    ConcurrentHashMap<Integer, OnEvent> cbMap = new ConcurrentHashMap<>();

    private Class getGenericClass(OnEvent onEvent) {
        if (onEvent != null) {
            Type type = onEvent.getClass().getGenericInterfaces()[0];
            if (type instanceof ParameterizedType) {
                try {
                    return ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).getClass();
                } catch (Exception e16) {
                    this.logger.warn(e16.getMessage());
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public <T> Eventor addOnEvent(OnEvent<T> onEvent) {
        int parseCode = parseCode(onEvent);
        if (parseCode != -1) {
            this.cbMap.put(Integer.valueOf(parseCode), onEvent);
            EventImpl.getInstance().register(onEvent);
            return this;
        }
        throw new RuntimeException("addOnEvent ERROR!!!");
    }

    int parseCode(OnEvent onEvent) {
        if (onEvent != null) {
            Type type = onEvent.getClass().getGenericInterfaces()[0];
            if (type instanceof ParameterizedType) {
                return ((ParameterizedType) type).getActualTypeArguments()[0].hashCode();
            }
            return -1;
        }
        return -1;
    }

    public void remove(Class... clsArr) {
        for (Class cls : clsArr) {
            int hashCode = cls.hashCode();
            if (this.cbMap.containsKey(Integer.valueOf(hashCode))) {
                EventImpl.getInstance().remove(this.cbMap.get(Integer.valueOf(hashCode)));
                this.cbMap.remove(Integer.valueOf(hashCode));
            }
        }
    }

    public void removeAll() {
        for (Map.Entry<Integer, OnEvent> entry : this.cbMap.entrySet()) {
            if (!EventImpl.getInstance().remove(entry.getValue())) {
                this.logger.info("remove fail:" + getGenericClass(entry.getValue()));
            }
        }
        this.cbMap.clear();
    }
}
