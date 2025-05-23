package com.tencent.mobileqq.app.message.cleanup.tool;

import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/ChatFileCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "", "getAllPttDir", "str", "", "isNumber", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getWhiteList", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChatFileCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ChatFileCleanUpThorough";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/ChatFileCleanUpThoroughCacheTool$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.cleanup.tool.ChatFileCleanUpThoroughCacheTool$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/app/message/cleanup/tool/ChatFileCleanUpThoroughCacheTool$b", "Ljava/io/FilenameFilter;", "Ljava/io/File;", QzoneZipCacheHelper.DIR, "", "name", "", "accept", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements FilenameFilter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatFileCleanUpThoroughCacheTool.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
        @Override // java.io.FilenameFilter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean accept(@Nullable File dir, @Nullable String name) {
            boolean z16;
            boolean isBlank;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dir, (Object) name)).booleanValue();
            }
            if (name != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(name);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        return ChatFileCleanUpThoroughCacheTool.this.isNumber(name);
                    }
                    return false;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54128);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatFileCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<String> getAllPttDir() {
        ArrayList arrayList = new ArrayList();
        try {
            String[] list = new File(d.f195978a.d() + "/Tencent/MobileQQ/").list(new b());
            Intrinsics.checkNotNullExpressionValue(list, "file.list(filter)");
            for (String str : list) {
                arrayList.add(d.f195978a.d() + "/Tencent/MobileQQ/" + str + "/ptt");
            }
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                arrayList.add(d.f195978a.d() + "/Tencent/MobileQQ/" + peekAppRuntime.getCurrentUin() + "/ptt");
            }
            com.tencent.xaction.log.b.c(TAG, 1, "getAllPttDir failed", e16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNumber(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
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
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.d() + "/Tencent/QQfile_recv", dVar.d() + "/Tencent/MobileQQ/chatpic", dVar.d() + "/Tencent/MobileQQ/shortvideo");
        List<String> allPttDir = getAllPttDir();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ptt list: ");
        sb5.append(allPttDir);
        com.tencent.xaction.log.b.a(TAG, 1, sb5.toString());
        arrayListOf.addAll(allPttDir);
        return arrayListOf;
    }
}
