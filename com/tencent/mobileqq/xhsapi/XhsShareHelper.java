package com.tencent.mobileqq.xhsapi;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.callback.XhsShareCallback;
import com.xingin.xhssharesdk.callback.XhsShareRegisterCallback;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import com.xingin.xhssharesdk.model.config.XhsShareGlobalConfig;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import com.xingin.xhssharesdk.model.sharedata.XhsImageInfo;
import com.xingin.xhssharesdk.model.sharedata.XhsImageResourceBean;
import com.xingin.xhssharesdk.model.sharedata.XhsNote;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0005)*+\u0019!B\u0007\u00a2\u0006\u0004\b'\u0010(J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0002J6\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0002J+\u0010\u0015\u001a\u00020\u000b2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J4\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004J4\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004J\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\rJ\u001a\u0010&\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\r\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/xhsapi/XhsShareHelper;", "", "", "callFrom", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "contextWR", "Lcom/xingin/xhssharesdk/model/sharedata/XhsNote;", "xhsNote", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "shareListener", "", "j", "Landroid/content/Context;", "k", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasInit", "cb", "g", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$c;", "data", "Lcom/xingin/xhssharesdk/model/sharedata/XhsImageResourceBean;", "d", "activityWR", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$b;", "imageData", "shareListenerWR", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "e", "context", "Lcom/xingin/xhssharesdk/model/other/VersionCheckResult;", h.F, "from", "i", "<init>", "()V", "a", "b", "c", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class XhsShareHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f327843b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static String f327844c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static d f327845d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$a;", "", "", "hasInit", "Z", "getHasInit", "()Z", "a", "(Z)V", "", "APP_KEY", "Ljava/lang/String;", "PACKAGE_NAME_PROVIDER", "TAG", "TARGET_PATH", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$d;", "xhsShareListenerWithWR", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$d;", "xhsSharePath", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.xhsapi.XhsShareHelper$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                XhsShareHelper.f327843b = z16;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "b", "content", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "imageDatas", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<c> imageDatas;

        public b(@NotNull String title, @NotNull String content, @NotNull ArrayList<c> imageDatas) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(imageDatas, "imageDatas");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, title, content, imageDatas);
                return;
            }
            this.title = title;
            this.content = content;
            this.imageDatas = imageDatas;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.content;
        }

        @NotNull
        public final ArrayList<c> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.imageDatas;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.title, bVar.title) && Intrinsics.areEqual(this.content, bVar.content) && Intrinsics.areEqual(this.imageDatas, bVar.imageDatas)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.imageDatas.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "XhsImageData(title=" + this.title + ", content=" + this.content + ", imageDatas=" + this.imageDatas + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/io/File;", "a", "Ljava/io/File;", "()Ljava/io/File;", "file", "Landroid/net/Uri;", "b", "Landroid/net/Uri;", "()Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "c", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "<init>", "(Ljava/io/File;Landroid/net/Uri;Ljava/lang/String;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final File file;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Uri uri;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String url;

        public c(@Nullable File file, @Nullable Uri uri, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, file, uri, str);
                return;
            }
            this.file = file;
            this.uri = uri;
            this.url = str;
        }

        @Nullable
        public final File a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.file;
        }

        @Nullable
        public final Uri b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Uri) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.uri;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.file, cVar.file) && Intrinsics.areEqual(this.uri, cVar.uri) && Intrinsics.areEqual(this.url, cVar.url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            File file = this.file;
            int i3 = 0;
            if (file == null) {
                hashCode = 0;
            } else {
                hashCode = file.hashCode();
            }
            int i16 = hashCode * 31;
            Uri uri = this.uri;
            if (uri == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = uri.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str = this.url;
            if (str != null) {
                i3 = str.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "XhsRichMediaData(file=" + this.file + ", uri=" + this.uri + ", url=" + this.url + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J2\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$d;", "Lcom/xingin/xhssharesdk/callback/XhsShareCallback;", "", "sessionId", "", "onSuccess", "p0", "", "p1", "p2", "", "p3", "onError", "newErrorCode", "oldErrorCode", "errorMessage", "throwable", "onError2", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "a", "Lmqq/util/WeakReference;", "getShareListenerWR", "()Lmqq/util/WeakReference;", "(Lmqq/util/WeakReference;)V", "shareListenerWR", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements XhsShareCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<e> shareListenerWR;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a(@Nullable WeakReference<e> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference);
            } else {
                this.shareListenerWR = weakReference;
            }
        }

        @Override // com.xingin.xhssharesdk.callback.XhsShareCallback
        public void onError(@NotNull String p06, int p16, @NotNull String p26, @Nullable Throwable p36) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, p06, Integer.valueOf(p16), p26, p36);
            } else {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p26, "p2");
            }
        }

        @Override // com.xingin.xhssharesdk.callback.XhsShareCallback
        public void onError2(@NotNull String sessionId, int newErrorCode, int oldErrorCode, @NotNull String errorMessage, @Nullable Throwable throwable) {
            e eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, sessionId, Integer.valueOf(newErrorCode), Integer.valueOf(oldErrorCode), errorMessage, throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.i("XhsShareHelper", 1, " sessionId: " + sessionId + " newErrorCode: " + newErrorCode + " oldErrorCode: " + oldErrorCode + " errorMessage: " + errorMessage);
            WeakReference<e> weakReference = this.shareListenerWR;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.onError(sessionId, newErrorCode, errorMessage, throwable);
            }
        }

        @Override // com.xingin.xhssharesdk.callback.XhsShareCallback
        public void onSuccess(@Nullable String sessionId) {
            e eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) sessionId);
                return;
            }
            QLog.i("XhsShareHelper", 1, "share success sessionId: " + sessionId);
            WeakReference<e> weakReference = this.shareListenerWR;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.onSuccess(sessionId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface e {
        void onError(@NotNull String sessionId, int errorCode, @NotNull String errorMessage, @Nullable Throwable throwable);

        void onSuccess(@Nullable String sessionId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/xhsapi/XhsShareHelper$f", "Lcom/xingin/xhssharesdk/callback/XhsShareRegisterCallback;", "", "onSuccess", "", "errorCode", "", "errorMessage", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "onError", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements XhsShareRegisterCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f327853a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function1<? super Boolean, Unit> function1) {
            this.f327853a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        @Override // com.xingin.xhssharesdk.callback.XhsShareRegisterCallback
        public void onError(int errorCode, @NotNull String errorMessage, @Nullable Exception exception) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMessage, exception);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.i("XhsShareHelper", 1, "registerApp fail errorCode:" + errorCode + " errorMessage " + errorMessage);
            XhsShareHelper.INSTANCE.a(false);
            this.f327853a.invoke(Boolean.FALSE);
        }

        @Override // com.xingin.xhssharesdk.callback.XhsShareRegisterCallback
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("XhsShareHelper", 1, "registerApp success");
            XhsShareHelper.INSTANCE.a(true);
            this.f327853a.invoke(Boolean.TRUE);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        f327844c = "";
        f327845d = new d();
    }

    public XhsShareHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final XhsImageResourceBean d(c data) {
        if (data == null) {
            return null;
        }
        if (data.a() != null) {
            return new XhsImageResourceBean(data.a());
        }
        if (data.b() != null) {
            return new XhsImageResourceBean(data.b());
        }
        if (data.c() == null) {
            return null;
        }
        return XhsImageResourceBean.fromUrl(data.c());
    }

    private final void g(Function1<? super Boolean, Unit> cb5) {
        if (f327843b) {
            cb5.invoke(Boolean.TRUE);
            return;
        }
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            QLog.i("XhsShareHelper", 1, "init sdk fail because context is null");
            cb5.invoke(Boolean.FALSE);
            return;
        }
        XhsShareSdk.registerApp(applicationContext, "397b1d74521649b33531409dd0d42dd6", new XhsShareGlobalConfig().setEnableLog(true).setClearCacheWhenShareComplete(true).setCacheDirPath(f()).setFileProviderAuthority(applicationContext.getPackageName() + ".fileprovider").setNeedRegisterReceiverWithOutsideActivity(true), new f(cb5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String callFrom, WeakReference<Activity> contextWR, XhsNote xhsNote, WeakReference<e> shareListener) {
        Unit unit;
        if (shareListener != null) {
            f327845d.a(shareListener);
            XhsShareSdk.setShareCallback(f327845d);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            f327845d.a(new WeakReference<>(null));
            XhsShareSdk.setShareCallback(null);
        }
        QLog.i("XhsShareHelper", 1, "realShare " + contextWR.get());
        Activity activity = contextWR.get();
        if (activity != null) {
            String shareNote = XhsShareSdk.shareNote(activity, xhsNote);
            Intrinsics.checkNotNullExpressionValue(shareNote, "shareNote(it, xhsNote)");
            QLog.i("XhsShareHelper", 1, "calFrom " + callFrom + ", sessionId: " + shareNote + " startShareToShx");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String callFrom, WeakReference<Context> contextWR, XhsNote xhsNote, WeakReference<e> shareListener) {
        Unit unit;
        if (shareListener != null) {
            f327845d.a(shareListener);
            XhsShareSdk.setShareCallback(f327845d);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            f327845d.a(new WeakReference<>(null));
            XhsShareSdk.setShareCallback(null);
        }
        QLog.i("XhsShareHelper", 1, "realShare " + contextWR.get());
        Context context = contextWR.get();
        if (context != null) {
            String shareNote = XhsShareSdk.shareNote(context, xhsNote);
            Intrinsics.checkNotNullExpressionValue(shareNote, "shareNote(it, xhsNote)");
            QLog.i("XhsShareHelper", 1, "calFrom " + callFrom + ", sessionId: " + shareNote + " startShareToShx");
        }
    }

    @NotNull
    public final XhsNote e(@NotNull b imageData) {
        XhsImageResourceBean d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (XhsNote) iPatchRedirector.redirect((short) 6, (Object) this, (Object) imageData);
        }
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        XhsNote xhsNote = new XhsNote();
        xhsNote.setTitle(imageData.c());
        xhsNote.setContent(imageData.a());
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = imageData.b().iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && (d16 = d(next)) != null) {
                arrayList.add(d16);
            }
        }
        xhsNote.setImageInfo(new XhsImageInfo(arrayList));
        return xhsNote;
    }

    @NotNull
    public final String f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!TextUtils.isEmpty(f327844c)) {
            return f327844c;
        }
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            QLog.i("XhsShareHelper", 1, "getXhsSharePath fail because context is null");
            return "";
        }
        File externalCacheDir = applicationContext.getExternalCacheDir();
        if (externalCacheDir != null) {
            str = externalCacheDir.getPath();
        } else {
            str = null;
        }
        String str2 = str + "/xhs_share_cache_dir";
        f327844c = str2;
        return str2;
    }

    @NotNull
    public final VersionCheckResult h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (VersionCheckResult) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        VersionCheckResult isSupportShareNote = XhsShareSdkTools.isSupportShareNote(context);
        Intrinsics.checkNotNullExpressionValue(isSupportShareNote, "isSupportShareNote(context)");
        return isSupportShareNote;
    }

    public final boolean i(@Nullable String from, @Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) from, (Object) context)).booleanValue();
        }
        if (context == null) {
            QLog.e("XhsShareHelper", 1, "args is null error!");
            return false;
        }
        VersionCheckResult h16 = h(context);
        if (h16 == null) {
            QLog.e("XhsShareHelper", 1, "from\uff1a" + from + " checkResult is null error!");
            return false;
        }
        int i3 = h16.checkResultCode;
        if (i3 == -1) {
            QQToast.makeText(context, R.string.f2047553r, 0).show();
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        QQToast.makeText(context, R.string.f2047653s, 0).show();
        return false;
    }

    public final void l(@NotNull final String callFrom, @NotNull final WeakReference<Activity> activityWR, @NotNull final b imageData, @Nullable final WeakReference<e> shareListenerWR) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, callFrom, activityWR, imageData, shareListenerWR);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(activityWR, "activityWR");
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        if (!f327843b) {
            g(new Function1<Boolean, Unit>(imageData, callFrom, activityWR, shareListenerWR) { // from class: com.tencent.mobileqq.xhsapi.XhsShareHelper$startImageShare$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference<Activity> $activityWR;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ XhsShareHelper.b $imageData;
                final /* synthetic */ WeakReference<XhsShareHelper.e> $shareListenerWR;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$imageData = imageData;
                    this.$callFrom = callFrom;
                    this.$activityWR = activityWR;
                    this.$shareListenerWR = shareListenerWR;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, XhsShareHelper.this, imageData, callFrom, activityWR, shareListenerWR);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    XhsShareHelper.e eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    if (z16) {
                        XhsShareHelper.this.j(this.$callFrom, this.$activityWR, XhsShareHelper.this.e(this.$imageData), this.$shareListenerWR);
                        return;
                    }
                    QLog.i("XhsShareHelper", 1, "callFrom: " + this.$callFrom + " init Xhs Sdk fail");
                    WeakReference<XhsShareHelper.e> weakReference = this.$shareListenerWR;
                    if (weakReference == null || (eVar = weakReference.get()) == null) {
                        return;
                    }
                    eVar.onError("", -1, "callFrom: " + this.$callFrom + " init Xhs Sdk fail", null);
                }
            });
        } else {
            j(callFrom, activityWR, e(imageData), shareListenerWR);
        }
    }

    public final void m(@NotNull final String callFrom, @NotNull final WeakReference<Context> activityWR, @NotNull final b imageData, @Nullable final WeakReference<e> shareListenerWR) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, callFrom, activityWR, imageData, shareListenerWR);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(activityWR, "activityWR");
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        if (!f327843b) {
            g(new Function1<Boolean, Unit>(imageData, callFrom, activityWR, shareListenerWR) { // from class: com.tencent.mobileqq.xhsapi.XhsShareHelper$startImageShareByContext$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference<Context> $activityWR;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ XhsShareHelper.b $imageData;
                final /* synthetic */ WeakReference<XhsShareHelper.e> $shareListenerWR;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$imageData = imageData;
                    this.$callFrom = callFrom;
                    this.$activityWR = activityWR;
                    this.$shareListenerWR = shareListenerWR;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, XhsShareHelper.this, imageData, callFrom, activityWR, shareListenerWR);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    XhsShareHelper.e eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    if (z16) {
                        XhsShareHelper.this.k(this.$callFrom, this.$activityWR, XhsShareHelper.this.e(this.$imageData), this.$shareListenerWR);
                        return;
                    }
                    QLog.i("XhsShareHelper", 1, "callFrom: " + this.$callFrom + " init Xhs Sdk fail");
                    WeakReference<XhsShareHelper.e> weakReference = this.$shareListenerWR;
                    if (weakReference == null || (eVar = weakReference.get()) == null) {
                        return;
                    }
                    eVar.onError("", -1, "callFrom: " + this.$callFrom + " init Xhs Sdk fail", null);
                }
            });
        } else {
            k(callFrom, activityWR, e(imageData), shareListenerWR);
        }
    }
}
