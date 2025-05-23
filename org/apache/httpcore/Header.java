package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
