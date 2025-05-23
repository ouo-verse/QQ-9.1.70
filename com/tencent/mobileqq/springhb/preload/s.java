package com.tencent.mobileqq.springhb.preload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.springhb.preload.g;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/s;", "", "", "key", "Lcom/tencent/mobileqq/springhb/preload/SpringRes;", "a", "url", "b", "", "c", "zipFolderPath", "Lcom/tencent/mobileqq/springhb/preload/SpringHbZipMappingBean;", "zipMappingBean", "e", "zipResId", "", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f289542a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f289542a = new s();
        }
    }

    s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00fa  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpringRes a(@NotNull String key) {
        int i3;
        String str;
        boolean z16;
        String str2;
        String str3;
        String g16;
        String str4;
        String str5;
        String url;
        boolean contains$default;
        boolean z17;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(key, "key");
        g.Companion companion = g.INSTANCE;
        Integer num = companion.b().get(key);
        boolean z18 = false;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        String str6 = companion.a().get(key);
        if (str6 == null) {
            str = "";
        } else {
            str = str6;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = "";
        } else {
            str2 = r.f289531a.f() + str;
        }
        r rVar = r.f289531a;
        SpringHbZipMappingBean j3 = rVar.j(key);
        String str7 = null;
        if (j3 != null) {
            String str8 = j3.zipResId;
            if (str8 != null && str8.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String str9 = j3.zipResId;
                Intrinsics.checkNotNullExpressionValue(str9, "zipMappingBean.zipResId");
                IPreloadResource h16 = rVar.h(str9);
                if (h16 != null) {
                    str7 = h16.getUrl();
                }
                if (str7 == null) {
                    str7 = "";
                }
                isBlank = StringsKt__StringsJVMKt.isBlank(str7);
                if (!(!isBlank)) {
                    str3 = "";
                    g16 = str3;
                    str4 = str7;
                    str5 = g16;
                } else {
                    String p16 = com.tencent.mobileqq.qwallet.preload.a.p(str7);
                    if (p16 == null) {
                        p16 = "";
                    }
                    g16 = f289542a.e(p16, j3);
                    str3 = "";
                    str4 = str7;
                    str5 = p16;
                }
                SpringRes springRes = new SpringRes(str3, key, null, i3, str, g16, str2, str4, str5, 4, null);
                if (QLog.isColorLevel()) {
                    QLog.d("SpringResReader", 2, "getByKey: key, " + key + "; res," + springRes);
                }
                return springRes;
            }
        }
        IPreloadResource h17 = rVar.h(key);
        if (h17 != null && (url = h17.getUrl()) != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ".zip", false, 2, (Object) null);
            if (contains$default) {
                z18 = true;
            }
        }
        if (z18) {
            String url2 = h17.getUrl();
            Intrinsics.checkNotNullExpressionValue(url2, "preloadRes.url");
            str4 = url2;
            str5 = com.tencent.mobileqq.qwallet.preload.a.p(url2);
            str3 = "";
            g16 = str3;
        } else {
            if (h17 == null || (str3 = h17.getUrl()) == null) {
                str3 = companion.d().get(key);
            }
            g16 = com.tencent.mobileqq.qwallet.preload.a.g(str3, f289542a.c());
            str4 = "";
            str5 = str4;
        }
        SpringRes springRes2 = new SpringRes(str3, key, null, i3, str, g16, str2, str4, str5, 4, null);
        if (QLog.isColorLevel()) {
        }
        return springRes2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpringRes b(@NotNull String url) {
        String str;
        boolean contains$default;
        boolean z16;
        String g16;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i3;
        String str7;
        boolean z17;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(url, "url");
        r rVar = r.f289531a;
        SpringHbZipMappingBean k3 = rVar.k(url);
        String str8 = null;
        boolean z18 = true;
        if (k3 != null) {
            String str9 = k3.zipResId;
            if (str9 != null && str9.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String str10 = k3.resName;
                String str11 = k3.zipResId;
                Intrinsics.checkNotNullExpressionValue(str11, "zipMappingBean.zipResId");
                IPreloadResource h16 = rVar.h(str11);
                if (h16 != null) {
                    str8 = h16.getUrl();
                }
                if (str8 == null) {
                    str8 = "";
                }
                isBlank = StringsKt__StringsJVMKt.isBlank(str8);
                if (!isBlank) {
                    String p16 = com.tencent.mobileqq.qwallet.preload.a.p(str8);
                    if (p16 == null) {
                        p16 = "";
                    }
                    str3 = str8;
                    str5 = str10;
                    str4 = p16;
                    str2 = f289542a.e(p16, k3);
                } else {
                    str3 = str8;
                    str4 = "";
                    str5 = str10;
                    str2 = str4;
                }
                if (str5 != null) {
                    str6 = "";
                    i3 = 0;
                } else {
                    g.Companion companion = g.INSTANCE;
                    Integer num = companion.b().get(str5);
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    String str12 = companion.a().get(str5);
                    if (str12 == null) {
                        str12 = "";
                    }
                    str6 = str12;
                }
                if (str6.length() != 0) {
                    z18 = false;
                }
                if (!z18) {
                    str7 = "";
                } else {
                    str7 = rVar.f() + ((Object) str6);
                }
                SpringRes springRes = new SpringRes(url, str5, null, i3, str6, str2, str7, str3, str4, 4, null);
                if (QLog.isColorLevel()) {
                    QLog.d("SpringResReader", 2, "getByUrl: url, " + url + "; res," + springRes);
                }
                return springRes;
            }
        }
        IPreloadResource i16 = rVar.i(url);
        String g17 = rVar.g(url);
        if (g17 == null) {
            g17 = "";
        }
        if (i16 != null) {
            str = i16.getResId();
        } else {
            str = null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ".zip", false, 2, (Object) null);
        if (contains$default) {
            str4 = com.tencent.mobileqq.qwallet.preload.a.p(url);
            str2 = "";
            str3 = url;
        } else {
            if (g17.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                g16 = rVar.f() + g17;
            } else {
                g16 = com.tencent.mobileqq.qwallet.preload.a.g(url, f289542a.c());
                Intrinsics.checkNotNullExpressionValue(g16, "getFilePath(url, getFilePos())");
            }
            str2 = g16;
            str3 = "";
            str4 = str3;
        }
        str5 = str;
        if (str5 != null) {
        }
        if (str6.length() != 0) {
        }
        if (!z18) {
        }
        SpringRes springRes2 = new SpringRes(url, str5, null, i3, str6, str2, str7, str3, str4, 4, null);
        if (QLog.isColorLevel()) {
        }
        return springRes2;
    }

    private final int c() {
        return com.tencent.mobileqq.qwallet.preload.a.f278999a ? 1 : 0;
    }

    private final CharSequence d(String zipResId) {
        int i3;
        CharSequence subSequence;
        if (zipResId != null) {
            i3 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) zipResId, ".zip", 0, false, 6, (Object) null);
        } else {
            i3 = -1;
        }
        if (i3 == -1 || zipResId == null || (subSequence = zipResId.subSequence(0, i3)) == null) {
            return "";
        }
        return subSequence;
    }

    private final String e(String zipFolderPath, SpringHbZipMappingBean zipMappingBean) {
        String str = File.separator;
        String str2 = zipFolderPath + str + zipMappingBean.resName;
        if (!FileUtils.fileExists(str2)) {
            CharSequence d16 = d(zipMappingBean.zipResId);
            String str3 = zipFolderPath + str + ((Object) d16) + str + zipMappingBean.resName;
            if (FileUtils.fileExists(str3)) {
                return str3;
            }
            return str2;
        }
        return str2;
    }
}
