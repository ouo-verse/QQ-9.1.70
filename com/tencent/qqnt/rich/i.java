package com.tencent.qqnt.rich;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JD\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042*\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007`\bH\u0016J@\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u0006j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u0001`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u009e\u0002\u0010\u0012\u001a\u008b\u0002\u0012\u0004\u0012\u00020\u000e\u0012z\u0012x\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u000f0\u0006jR\u0012\u0004\u0012\u00020\u0004\u0012H\u0012F\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u000fj,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007`\b`\u0010`\b0\u0006j\u0084\u0001\u0012\u0004\u0012\u00020\u000e\u0012z\u0012x\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u000f0\u0006jR\u0012\u0004\u0012\u00020\u0004\u0012H\u0012F\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u000fj,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007`\b`\u0010`\b`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/rich/i;", "Lcom/tencent/qqnt/rich/d;", "Landroid/content/Context;", "context", "", "templateId", "Ljava/util/HashMap;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "", "a", "b", "c", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/HashMap;", "cacheMap", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f362001a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, HashMap<String, ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>>>> cacheMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f362001a = new i();
            cacheMap = new HashMap<>();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.rich.d
    public void a(@NotNull Context context, @NotNull String templateId, @NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, templateId, cache);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(cache, "cache");
        HashMap<Integer, HashMap<String, ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>>>> hashMap = cacheMap;
        HashMap<String, ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>>> hashMap2 = hashMap.get(Integer.valueOf(context.hashCode()));
        if (hashMap2 == null) {
            hashMap.put(Integer.valueOf(context.hashCode()), new HashMap<>());
            hashMap2 = hashMap.get(Integer.valueOf(context.hashCode()));
        }
        if (hashMap2 != null) {
            arrayList = hashMap2.get(templateId);
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(cache);
        if (hashMap2 != null) {
            hashMap2.put(templateId, arrayList);
        }
    }

    @Override // com.tencent.qqnt.rich.d
    @Nullable
    public HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> b(@NotNull Context context, @NotNull String templateId) {
        ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>> arrayList;
        Object removeFirstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) templateId);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        HashMap<String, ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>>> hashMap = cacheMap.get(Integer.valueOf(context.hashCode()));
        if (hashMap != null && (arrayList = hashMap.get(templateId)) != null) {
            removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(arrayList);
            return (HashMap) removeFirstOrNull;
        }
        return null;
    }

    public final void c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i("MorphisViewCache", 1, "[clearCache]: context=" + context);
        HashMap<String, ArrayList<HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>>>> hashMap = cacheMap.get(Integer.valueOf(context.hashCode()));
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
