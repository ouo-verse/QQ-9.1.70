package com.google.protobuf;

import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(au auVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    private static String a(List<String> list) {
        StringBuilder sb5 = new StringBuilder("Message missing required fields: ");
        boolean z16 = true;
        for (String str : list) {
            if (z16) {
                z16 = false;
            } else {
                sb5.append(", ");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public UninitializedMessageException(List<String> list) {
        super(a(list));
        this.missingFields = list;
    }
}
