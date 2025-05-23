package com.qzone.common.event;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EventSource {
    private String mName;
    private Object mSender;

    public EventSource(String str) {
        this(str, (Object) null);
    }

    public String getName() {
        return this.mName;
    }

    public Object getSender() {
        return this.mSender;
    }

    public int hashCode() {
        String str = this.mName;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "EventSource [mName=" + this.mName + ", mSender=" + this.mSender + "]";
    }

    public EventSource(String str, Object obj) {
        if (str != null && str.length() != 0) {
            this.mSender = obj;
            this.mName = str;
            return;
        }
        throw new NullPointerException("The mEventName of EventSource cannot be empty");
    }

    public EventSource(Class<?> cls, Object obj) {
        this(cls.getName(), obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventSource eventSource = (EventSource) obj;
        String str = this.mName;
        if (str == null) {
            if (eventSource.mName != null) {
                return false;
            }
        } else if (!str.equals(eventSource.mName)) {
            return false;
        }
        return true;
    }
}
