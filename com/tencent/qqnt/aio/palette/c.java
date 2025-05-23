package com.tencent.qqnt.aio.palette;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004RH\u0010\u0010\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f0\u000bj\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/palette/c;", "", "Landroid/content/Context;", "context", "", "profileId", "Lae0/a;", "palette", "", "b", "a", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "recordMap", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f351747a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, List<WeakReference<Context>>> recordMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f351747a = new c();
            recordMap = new HashMap<>();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Context context, @NotNull String profileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) profileId);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profileId, "profileId");
        List<WeakReference<Context>> list = recordMap.get(profileId);
        if (list == null) {
            QLog.d("ActivityPaletteManager", 1, "clearCustomTheme no id=" + profileId);
            return;
        }
        Iterator<WeakReference<Context>> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), context)) {
                it.remove();
            }
        }
        if (list.isEmpty()) {
            recordMap.remove(profileId);
            be0.a.b(profileId).a();
            return;
        }
        QLog.d("ActivityPaletteManager", 1, "clearCustomTheme id=" + profileId + " record isNotEmpty");
    }

    public final void b(@NotNull Context context, @NotNull String profileId, @NotNull ae0.a palette) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, profileId, palette);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profileId, "profileId");
        Intrinsics.checkNotNullParameter(palette, "palette");
        HashMap<String, List<WeakReference<Context>>> hashMap = recordMap;
        List<WeakReference<Context>> list = hashMap.get(profileId);
        if (list == null) {
            list = new ArrayList<>();
            hashMap.put(profileId, list);
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WeakReference) obj).get(), context)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            list.add(new WeakReference<>(context));
        }
        be0.a.b(profileId).c(palette);
    }
}
