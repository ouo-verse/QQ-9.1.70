package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/jsp/j;", "Lcom/tencent/mobileqq/webview/swift/f;", "Landroid/content/Intent;", "intent", "", "url", ZPlanPublishSource.FROM_SCHEME, "", "providePreCreatePlugins", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "", "onPreInit", "<init>", "()V", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j implements com.tencent.mobileqq.webview.swift.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/jsp/j$a;", "", "Landroid/content/Intent;", "intent", "", "url", ZPlanPublishSource.FROM_SCHEME, "", "k", "j", "i", DomainData.DOMAIN_NAME, QZoneDTLoginReporter.SCHEMA, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "l", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.jsp.j$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean i(Intent intent, String url, String scheme) {
            String string;
            Bundle extras = intent.getExtras();
            return (extras == null || (string = extras.getString("forward_ark_app_view")) == null || !string.equals("music")) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean j(Intent intent, String url, String scheme) {
            Bundle extras = intent.getExtras();
            return (extras != null ? extras.getSerializable("fragmentClass") : null) instanceof ArkBrowserFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k(Intent intent, String url, String scheme) {
            Bundle extras = intent.getExtras();
            return (extras != null ? extras.getParcelable(AppConstants.Key.H5_ARK_URL_WEB_CHECKER) : null) != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean l(Intent intent, String url, String scheme) {
            return intent.getIntExtra("uintype", -1) == 1030;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean m(Intent intent, String url, String schema) {
            boolean contains$default;
            boolean contains$default2;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "docx.qq.com", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ITeamWorkHandler.DOCS_DOMAIN, false, 2, (Object) null);
                if (!contains$default2) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean p(Intent intent, String url, String scheme) {
            if (intent.getBooleanExtra("key_from_splash_ad", false)) {
                return "http".equals(scheme) || "https".equals(scheme);
            }
            return false;
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean n(Intent intent, String url, String scheme) {
            boolean contains$default;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "lbs.qidian.qq.com/authorize/voiceShow", false, 2, (Object) null);
            return contains$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean o(Intent intent, String url, String schema) {
            boolean contains$default;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "kandian.qq.com", false, 2, (Object) null);
            return contains$default;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        if (r1 != false) goto L22;
     */
    @Override // com.tencent.mobileqq.webview.swift.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] providePreCreatePlugins(Intent intent, String url, String scheme) {
        boolean contains$default;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(url, "url");
        ArrayList arrayList = new ArrayList();
        arrayList.add("Gdt");
        if ("qqjsbridge".equals(scheme)) {
            arrayList.add(QWalletPayJsPlugin.OBJECT_NAME_NEW);
            arrayList.add(QWalletPayJsPlugin.OBJECT_NAME_NEW_COMPATIBLE_IOS);
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "mp.qq.com", false, 2, (Object) null);
        if (contains$default) {
            arrayList.add("pubAccountUI");
        }
        if (MusicGeneWebViewPlugin.N(url)) {
            arrayList.add("qqmusic");
        }
        if (BusinessReporter.a() && BusinessReporter.b(url)) {
            arrayList.add("JD_REPORT");
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, MessageRoamJsPlugin.listenPswEventUrl, false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://mapp.3g.qq.com/touch/psw/verify.jsp", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "https://mapp.3g.qq.com/touch/psw/create.jsp", false, 2, null);
            }
        }
        arrayList.add(MessageRoamJsPlugin.PKGNAME);
        Companion companion = INSTANCE;
        if (companion.k(intent, url, scheme)) {
            arrayList.add("ArkSecurity");
        }
        if (companion.j(intent, url, scheme)) {
            arrayList.add("lightapp");
        }
        if (companion.n(intent, url, scheme)) {
            arrayList.add("qidian");
        }
        if (companion.l(intent, url, scheme)) {
            arrayList.add("campus_circle");
        }
        if (companion.i(intent, url, scheme)) {
            arrayList.add("aioShareMusic");
        }
        if (companion.p(intent, url, scheme)) {
            arrayList.add("splashADPlugin");
        }
        if (companion.o(intent, url, scheme)) {
            arrayList.add("readInJoyWebRender");
        }
        if (companion.m(intent, url, scheme)) {
            arrayList.add(FileReaderHelper.DOCX_EXT);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @Override // com.tencent.mobileqq.webview.swift.c
    public void onPreInit() {
    }
}
