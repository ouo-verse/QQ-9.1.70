package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

/* loaded from: classes23.dex */
public class ParseException extends Exception {
    public int curline;

    public ParseException(String str, Exception exc, int i3) {
        super(str, exc);
        this.curline = i3;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " line: " + this.curline;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ParseException{message = " + getMessage() + "}";
    }
}
