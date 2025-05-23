package com.tencent.mobileqq.app.message.filescan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/a;", "", "", QzoneZipCacheHelper.DIR, "", "level", "", "a", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f195976a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195976a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final long a(@NotNull String dir, int level) {
        ArrayList arrayListOf;
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dir, level)).longValue();
        }
        Intrinsics.checkNotNullParameter(dir, "dir");
        long j3 = 0;
        if (!new File(dir).exists()) {
            return 0L;
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z16 = true;
        int i3 = 0;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dir);
        int i16 = 0;
        while (true) {
            ArrayList arrayList3 = arrayList2;
            arrayList2 = arrayListOf;
            arrayListOf = arrayList3;
            if (i16 > level || !(arrayList2.isEmpty() ^ z16)) {
                break;
            }
            arrayListOf.clear();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                File file = new File((String) it.next());
                if (file.isFile()) {
                    j3 += file.length();
                } else {
                    if (i16 < level) {
                        String[] list = file.list();
                        if (list != null) {
                            arrayList = new ArrayList(list.length);
                            int length = list.length;
                            for (int i17 = i3; i17 < length; i17++) {
                                arrayList.add(file.getAbsoluteFile() + '/' + list[i17]);
                            }
                        } else {
                            arrayList = null;
                        }
                        if (arrayList != null && !arrayList.isEmpty()) {
                            arrayListOf.addAll(arrayList);
                        }
                    }
                    i3 = 0;
                }
            }
            i16++;
            z16 = true;
            i3 = 0;
        }
        return j3;
    }
}
