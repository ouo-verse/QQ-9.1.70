package com.tencent.qqnt.emotion.stickerrecommended.mvvm.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<g> f356586a;

    /* renamed from: b, reason: collision with root package name */
    public String f356587b;

    /* renamed from: c, reason: collision with root package name */
    public String f356588c;

    /* renamed from: d, reason: collision with root package name */
    public int f356589d;

    /* renamed from: e, reason: collision with root package name */
    public String f356590e;

    /* renamed from: f, reason: collision with root package name */
    public StickerRecKeywordFrom f356591f;

    public b(List<g> list, String str, String str2, int i3, String str3, StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, str, str2, Integer.valueOf(i3), str3, stickerRecKeywordFrom);
            return;
        }
        this.f356586a = list;
        this.f356587b = str;
        this.f356588c = str2;
        this.f356589d = i3;
        this.f356590e = str3;
        this.f356591f = stickerRecKeywordFrom;
    }
}
