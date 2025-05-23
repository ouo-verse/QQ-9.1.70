package com.tencent.hlyyb.downloader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class DownloaderTaskCategory {
    static IPatchRedirector $redirector_;
    public static final DownloaderTaskCategory Cate_CustomMass1;
    public static final DownloaderTaskCategory Cate_CustomMass2;
    public static final DownloaderTaskCategory Cate_DefaultEase;
    public static final DownloaderTaskCategory Cate_DefaultMass;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloaderTaskCategory[] f114361a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12628);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DownloaderTaskCategory downloaderTaskCategory = new DownloaderTaskCategory("Cate_DefaultMass", 0);
        Cate_DefaultMass = downloaderTaskCategory;
        DownloaderTaskCategory downloaderTaskCategory2 = new DownloaderTaskCategory("Cate_DefaultEase", 1);
        Cate_DefaultEase = downloaderTaskCategory2;
        DownloaderTaskCategory downloaderTaskCategory3 = new DownloaderTaskCategory("Cate_CustomMass1", 2);
        Cate_CustomMass1 = downloaderTaskCategory3;
        DownloaderTaskCategory downloaderTaskCategory4 = new DownloaderTaskCategory("Cate_CustomMass2", 3);
        Cate_CustomMass2 = downloaderTaskCategory4;
        f114361a = new DownloaderTaskCategory[]{downloaderTaskCategory, downloaderTaskCategory2, downloaderTaskCategory3, downloaderTaskCategory4};
    }

    public DownloaderTaskCategory(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DownloaderTaskCategory valueOf(String str) {
        return (DownloaderTaskCategory) Enum.valueOf(DownloaderTaskCategory.class, str);
    }

    public static DownloaderTaskCategory[] values() {
        return (DownloaderTaskCategory[]) f114361a.clone();
    }
}
