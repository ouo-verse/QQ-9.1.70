package org.junit.runner.notification;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.junit.runner.Description;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Failure implements Serializable {
    private static final long serialVersionUID = 1;
    private final Description fDescription;
    private final Throwable fThrownException;

    public Failure(Description description, Throwable th5) {
        this.fThrownException = th5;
        this.fDescription = description;
    }

    public Description getDescription() {
        return this.fDescription;
    }

    public Throwable getException() {
        return this.fThrownException;
    }

    public String getMessage() {
        return getException().getMessage();
    }

    public String getTestHeader() {
        return this.fDescription.getDisplayName();
    }

    public String getTrace() {
        StringWriter stringWriter = new StringWriter();
        getException().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public String toString() {
        return getTestHeader() + MsgSummary.STR_COLON + this.fThrownException.getMessage();
    }
}
