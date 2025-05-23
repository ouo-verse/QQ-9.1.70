package com.samskivert.mustache;

/* loaded from: classes3.dex */
public class MustacheParseException extends MustacheException {
    public MustacheParseException(String str) {
        super(str);
    }

    public MustacheParseException(String str, int i3) {
        super(str + " @ line " + i3);
    }
}
