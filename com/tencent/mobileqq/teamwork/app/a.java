package com.tencent.mobileqq.teamwork.app;

import com.tencent.qphone.base.util.QLog;
import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/teamwork/app/a;", "", "a", "b", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/teamwork/app/a$a;", "", "", "url", "b", "d", "a", "offlineEnabledUrl", "e", "c", "TAG", "Ljava/lang/String;", "Lcom/tencent/mobileqq/teamwork/app/a$b;", "resourceInterceptorListener", "Lcom/tencent/mobileqq/teamwork/app/a$b;", "<init>", "()V", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.teamwork.app.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0067, code lost:
        
            if (r0 != null) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
        
            r5 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0093, code lost:
        
            r8 = new kotlin.text.Regex('/' + r5 + "/(.*)").replace(r8, '/' + r5 + "/index.html");
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x00cc, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x00ce, code lost:
        
            com.tencent.qphone.base.util.QLog.d("CategoryResourceInterceptor", 1, " correctToResourceUrl replacedUrl  replacedUrl=" + r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x00e3, code lost:
        
            return r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
        
            if (r0 != null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String b(String url) {
            String group;
            if (QLog.isColorLevel()) {
                QLog.d("CategoryResourceInterceptor", 1, " correctToResourceUrl url=" + url);
            }
            Pattern compile = Pattern.compile("^https://weboffice\\.qq\\.com/(doc|sheet|slide|pdf)/.*");
            Pattern compile2 = Pattern.compile("^https://weboffice\\.qq\\.com/open/weboffice/(pptx|doc|docx|xls|xlsx|ppt|pdf|txt)/.*");
            Matcher matcher = compile.matcher(url);
            Intrinsics.checkNotNullExpressionValue(matcher, "urlPattern.matcher(url)");
            Matcher matcher2 = compile2.matcher(url);
            Intrinsics.checkNotNullExpressionValue(matcher2, "urlPatternOpen.matcher(url)");
            String str = null;
            if (matcher.matches()) {
                if (QLog.isColorLevel()) {
                    QLog.d("CategoryResourceInterceptor", 1, " correctToResourceUrl matcher urlPattern  url=" + url);
                }
                group = matcher.group(1);
            } else if (matcher2.matches()) {
                if (QLog.isColorLevel()) {
                    QLog.d("CategoryResourceInterceptor", 1, " correctToResourceUrl matcher urlPatternOpen url=" + url);
                }
                group = matcher2.group(1);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("CategoryResourceInterceptor", 1, " correctToResourceUrl no matcher url=" + url);
                }
                return url;
            }
        }

        private final String d(String url) {
            boolean startsWith$default;
            String str;
            boolean startsWith$default2;
            if (Regex.find$default(new Regex("_bid=([^&]+)"), url, 0, 2, null) != null) {
                try {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
                    if (!startsWith$default) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                        if (!startsWith$default2) {
                            str = "https://" + url;
                            URL url2 = new URL(str);
                            URI uri = new URI(url2.getProtocol(), url2.getHost(), url2.getPath(), url2.getQuery(), null);
                            String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
                            Intrinsics.checkNotNullExpressionValue(uri2, "URI(uri.scheme, uri.auth\u2026 uri.fragment).toString()");
                            return uri2;
                        }
                    }
                    str = url;
                    URL url22 = new URL(str);
                    URI uri3 = new URI(url22.getProtocol(), url22.getHost(), url22.getPath(), url22.getQuery(), null);
                    String uri22 = new URI(uri3.getScheme(), uri3.getAuthority(), uri3.getPath(), null, uri3.getFragment()).toString();
                    Intrinsics.checkNotNullExpressionValue(uri22, "URI(uri.scheme, uri.auth\u2026 uri.fragment).toString()");
                    return uri22;
                } catch (Exception e16) {
                    QLog.e("CategoryResourceInterceptor", 1, "removeBidParameterFromUrl, exception=" + e16);
                }
            }
            return url;
        }

        @JvmStatic
        @NotNull
        public final String a(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (QLog.isColorLevel()) {
                QLog.i("CategoryResourceInterceptor", 1, " checkAndMakeResourceUrlAvailable routeUrl=" + url);
            }
            a.a();
            return b(url);
        }

        @JvmStatic
        @Nullable
        public final String c(@Nullable String url) {
            return null;
        }

        @JvmStatic
        @Nullable
        public final String e(@Nullable String offlineEnabledUrl) {
            boolean z16;
            String str;
            boolean z17;
            boolean z18 = false;
            if (offlineEnabledUrl != null && offlineEnabledUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.e("CategoryResourceInterceptor", 1, "tryGetResourceFromExistingPackage offlineEnabledUrl is empty");
                }
                return null;
            }
            MatchResult find$default = Regex.find$default(new Regex("_bid=([^&]+)"), offlineEnabledUrl, 0, 2, null);
            if (find$default != null) {
                MatchGroup matchGroup = find$default.getGroups().get(1);
                if (matchGroup != null) {
                    str = matchGroup.getValue();
                } else {
                    str = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CategoryResourceInterceptor", 1, " tryGetResourceFromExistingPackage bid=" + str);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("CategoryResourceInterceptor", 1, " tryGetResourceFromExistingPackage matchResult==null, routeUrl=" + offlineEnabledUrl);
                }
                str = "";
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                if (QLog.isColorLevel()) {
                    QLog.e("CategoryResourceInterceptor", 1, "tryGetResourceFromExistingPackage currentBid is empty,offlineEnabledUrl :" + offlineEnabledUrl);
                }
                return null;
            }
            ResourcePackageManager resourcePackageManager = ResourcePackageManager.f291881a;
            if (!resourcePackageManager.c(str)) {
                QLog.e("CategoryResourceInterceptor", 1, "tryGetResourceFromExistingPackage offlinePackage is not Available, offlineEnabledUrl :" + offlineEnabledUrl);
                return null;
            }
            String n3 = w11.a.f444159a.n(d(offlineEnabledUrl));
            if (n3.length() > 0) {
                z18 = true;
            }
            if (!z18) {
                n3 = null;
            }
            if (n3 == null) {
                QLog.e("CategoryResourceInterceptor", 1, "tryGetResourceFromExistingPackage invalid path: " + offlineEnabledUrl);
                return null;
            }
            String d16 = d(n3);
            String d17 = resourcePackageManager.d(str, d16);
            if (d17 == null) {
                QLog.e("CategoryResourceInterceptor", 1, "tryGetResourceFromExistingPackage ,no file for url " + offlineEnabledUrl + " within offline package " + str + " ,filePath " + d16);
                return null;
            }
            return d17;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/teamwork/app/a$b;", "", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
    }

    public static final /* synthetic */ b a() {
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String str) {
        return INSTANCE.a(str);
    }

    @JvmStatic
    @Nullable
    public static final String c(@Nullable String str) {
        return INSTANCE.c(str);
    }

    @JvmStatic
    @Nullable
    public static final String d(@Nullable String str) {
        return INSTANCE.e(str);
    }
}
