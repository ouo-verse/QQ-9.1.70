package com.tencent.mobileqq.fts.v2.tokenizer.cjk;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v2.tokenizer.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.Reader;
import java.lang.Character;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private int f211796b;

    /* renamed from: c, reason: collision with root package name */
    private int f211797c;

    /* renamed from: d, reason: collision with root package name */
    private int f211798d;

    /* renamed from: e, reason: collision with root package name */
    private int f211799e;

    /* renamed from: f, reason: collision with root package name */
    private final char[] f211800f;

    /* renamed from: g, reason: collision with root package name */
    private final char[] f211801g;

    /* renamed from: h, reason: collision with root package name */
    private String f211802h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f211803i;

    public a(Reader reader, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reader, i3);
            return;
        }
        this.f211797c = 0;
        this.f211798d = 0;
        this.f211799e = 0;
        this.f211800f = new char[255];
        this.f211801g = new char[1024];
        this.f211802h = "word";
        this.f211803i = false;
        this.f211795a = reader;
        this.f211796b = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0131, code lost:
    
        r12.f211797c--;
        r12.f211798d--;
        r12.f211802h = "digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013f, code lost:
    
        if (r12.f211803i != true) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0141, code lost:
    
        r12.f211803i = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003c, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f0, code lost:
    
        r12.f211797c--;
        r12.f211798d--;
        r12.f211802h = "letter";
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fe, code lost:
    
        if (r12.f211803i != true) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0100, code lost:
    
        r12.f211803i = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.mobileqq.fts.v2.tokenizer.a a() throws IOException {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.fts.v2.tokenizer.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        int i16 = this.f211797c;
        loop0: while (true) {
            i3 = 0;
            while (true) {
                this.f211797c++;
                if (this.f211798d >= this.f211799e) {
                    this.f211799e = this.f211795a.read(this.f211801g);
                    this.f211798d = 0;
                }
                if (this.f211799e == -1) {
                    if (i3 <= 0) {
                        return null;
                    }
                    if (this.f211803i) {
                        this.f211803i = false;
                    }
                } else {
                    char[] cArr = this.f211801g;
                    int i17 = this.f211798d;
                    this.f211798d = i17 + 1;
                    char c16 = cArr[i17];
                    Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
                    if (of5 != Character.UnicodeBlock.BASIC_LATIN && of5 != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                        if (Character.isLetter(c16)) {
                            if (i3 == 0) {
                                i16 = this.f211797c - 1;
                                this.f211800f[i3] = c16;
                                this.f211802h = "double";
                                i3++;
                            } else {
                                if (TextUtils.equals(this.f211802h, "letter") || TextUtils.equals(this.f211802h, "digit")) {
                                    break loop0;
                                }
                                int i18 = i3 + 1;
                                this.f211800f[i3] = c16;
                                this.f211802h = "double";
                                if (i18 == 2) {
                                    this.f211797c--;
                                    this.f211798d--;
                                    this.f211803i = true;
                                    i3 = i18;
                                    break loop0;
                                }
                                i3 = i18;
                            }
                        } else if (i3 > 0) {
                            if (!this.f211803i) {
                                break;
                            }
                            this.f211803i = false;
                        }
                    } else {
                        if (of5 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                            c16 = (char) (c16 - '\ufee0');
                        }
                        if (Character.isLetter(c16)) {
                            if (i3 == 0) {
                                i16 = this.f211797c - 1;
                            } else if (TextUtils.equals(this.f211802h, "double") || TextUtils.equals(this.f211802h, "digit")) {
                                break loop0;
                            }
                            int i19 = i3 + 1;
                            this.f211800f[i3] = Character.toLowerCase(c16);
                            this.f211802h = "letter";
                            i3 = i19;
                            if (i19 == 255) {
                                break loop0;
                            }
                        } else if (Character.isDigit(c16)) {
                            if (i3 == 0) {
                                i16 = this.f211797c - 1;
                            } else if (TextUtils.equals(this.f211802h, "double") || TextUtils.equals(this.f211802h, "letter")) {
                                break loop0;
                            }
                            int i26 = i3 + 1;
                            this.f211800f[i3] = Character.toLowerCase(c16);
                            this.f211802h = "digit";
                            i3 = i26;
                            if (i26 == 255) {
                                break loop0;
                            }
                        } else if (i3 > 0) {
                            if (!this.f211803i) {
                                break;
                            }
                            this.f211803i = false;
                        }
                    }
                }
            }
        }
        this.f211797c--;
        this.f211798d--;
        if (i16 == this.f211796b - 1 && i3 == 0) {
            return null;
        }
        return new com.tencent.mobileqq.fts.v2.tokenizer.a(new String(this.f211800f, 0, i3), i16, i3 + i16, this.f211802h);
    }
}
