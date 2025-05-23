package com.tencent.mobileqq.wxmini.clean;

import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wxmini/clean/WxMiniCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "", "getOldXWebKeepPath", "getNewXWebKeepPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getWhiteList", "<init>", "()V", "Companion", "a", "wxmini_lib_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WxMiniCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "WxMiniCleanUpThoroughCacheTool";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wxmini/clean/WxMiniCleanUpThoroughCacheTool$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wxmini_lib_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.clean.WxMiniCleanUpThoroughCacheTool$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WxMiniCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<String> getNewXWebKeepPath() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(d.f195978a.a() + "/app_xweb_data");
        return listOf;
    }

    private final List<String> getOldXWebKeepPath() {
        List<String> emptyList;
        File[] listFiles = new File(d.f195978a.a()).listFiles(new FilenameFilter() { // from class: com.tencent.mobileqq.wxmini.clean.a
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean oldXWebKeepPath$lambda$1;
                oldXWebKeepPath$lambda$1 = WxMiniCleanUpThoroughCacheTool.getOldXWebKeepPath$lambda$1(file, str);
                return oldXWebKeepPath$lambda$1;
            }
        });
        if (listFiles == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File file : listFiles) {
            arrayList.add(file.getPath());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOldXWebKeepPath$lambda$1(File file, String name) {
        boolean startsWith$default;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "app_xwalk_", false, 2, null);
        return startsWith$default;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            y.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return y.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList arrayListOf;
        List plus;
        List plus2;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(d.f195978a.d() + "/files/ilinkservice");
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayListOf, (Iterable) getOldXWebKeepPath());
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) getNewXWebKeepPath());
        ArrayList<String> arrayList = new ArrayList<>(plus2);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        QLog.d(TAG, 1, "getWhiteList: ", joinToString$default);
        return arrayList;
    }
}
