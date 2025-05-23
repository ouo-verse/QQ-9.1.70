package com.tencent.mobileqq.gamecenter.qa.editor.span;

import android.text.style.TypefaceSpan;
import zd1.b;
import zd1.c;

/* loaded from: classes12.dex */
public class CopyParagraphSpan extends TypefaceSpan {

    /* renamed from: d, reason: collision with root package name */
    private String f212443d;

    public CopyParagraphSpan(String str) {
        super(str);
        this.f212443d = str;
    }

    public static CopyParagraphSpan a(b bVar) {
        return new CopyParagraphSpan("BulletSpan_" + bVar.h() + "_" + bVar.j());
    }

    public static CopyParagraphSpan b(c cVar) {
        return new CopyParagraphSpan("NumberSpan_" + cVar.g() + "_" + cVar.f() + "_" + cVar.i());
    }

    public static b c(String str) {
        if (str.startsWith("BulletSpan")) {
            String[] split = str.split("_");
            return new b(Integer.parseInt(split[1]), Boolean.parseBoolean(split[2]));
        }
        return null;
    }

    public static c e(String str) {
        if (str.startsWith("NumberSpan")) {
            String[] split = str.split("_");
            return new c(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Boolean.parseBoolean(split[3]));
        }
        return null;
    }
}
