package org.junit.runner;

/* loaded from: classes29.dex */
public final class FilterFactoryParams {
    private final String args;
    private final Description topLevelDescription;

    public FilterFactoryParams(Description description, String str) {
        if (str != null && description != null) {
            this.topLevelDescription = description;
            this.args = str;
            return;
        }
        throw null;
    }

    public String getArgs() {
        return this.args;
    }

    public Description getTopLevelDescription() {
        return this.topLevelDescription;
    }
}
