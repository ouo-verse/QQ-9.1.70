package org.tencwebrtc;

import java.util.Locale;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SessionDescription {
    public String description;
    public final Type type;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Type {
        OFFER,
        PRANSWER,
        ANSWER;

        public String canonicalForm() {
            return name().toLowerCase(Locale.US);
        }
    }

    @CalledByNative
    public SessionDescription(Type type, String str) {
        this.type = type;
        this.description = str;
    }

    @CalledByNative
    String getDescription() {
        return this.description;
    }

    @CalledByNative
    String getTypeInCanonicalForm() {
        return this.type.canonicalForm();
    }
}
