package com.tencent.qqnt.biz.lightbusiness;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.lightbusiness.reveal.e;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessClearType;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0004H\u0003J\u0006\u0010\u0011\u001a\u00020\u0002J2\u0010\u0018\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J.\u0010\u001a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u00142\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0007J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0007JF\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0004j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u00072\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0004j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b`\u0007J:\u0010!\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2&\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0007H\u0016RF\u0010*\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060#0\"j\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060#`$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010.\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010/R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\"j\b\u0012\u0004\u0012\u00020\u001b`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/d;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessListener;", "", "i", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/biz/lightbusiness/b;", "Lkotlin/collections/HashMap;", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessService;", "g", "", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "", "dataMap", "j", "e", "Ljava/util/HashSet;", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessClearType;", "Lkotlin/collections/HashSet;", "clearTypeSet", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "c", "bizTypeSet", "f", "Lcom/tencent/qqnt/biz/lightbusiness/a;", "listener", "b", "l", "liteBusiness", "d", "onLiteBusinessChange", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getSLiteConvertorClzs", "()Ljava/util/ArrayList;", "setSLiteConvertorClzs", "(Ljava/util/ArrayList;)V", "sLiteConvertorClzs", "Ljava/lang/Object;", "getEMPTY_ITEM", "()Ljava/lang/Object;", "EMPTY_ITEM", "Ljava/util/HashMap;", "liteConvertorMap", "listeners", "", "Ljava/lang/Long;", "kernelListenerId", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d implements IKernelLiteBusinessListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f353112a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/LightBusiness/Inject_LiteHelper.yml", version = 3)
    @NotNull
    private static ArrayList<Class<? extends b>> sLiteConvertorClzs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object EMPTY_ITEM;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, b> liteConvertorMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<a> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Long kernelListenerId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29622);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        d dVar = new d();
        f353112a = dVar;
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        sLiteConvertorClzs = arrayList;
        arrayList.add(com.tencent.qqnt.biz.lightbusiness.lightinteraction.h.class);
        sLiteConvertorClzs.add(com.tencent.qqnt.chats.main.lightbusiness.reveal.d.class);
        sLiteConvertorClzs.add(e.class);
        sLiteConvertorClzs.add(com.tencent.qqnt.chats.main.lightbusiness.reveal.b.class);
        EMPTY_ITEM = new Object();
        i();
        liteConvertorMap = dVar.h();
        listeners = new ArrayList<>();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IKernelLiteBusinessService g() {
        IKernelService i3 = f.i();
        if (i3 != null) {
            return i3.getLiteBusinessService();
        }
        return null;
    }

    private final HashMap<Integer, b> h() {
        HashMap<Integer, b> hashMap = new HashMap<>();
        Iterator<T> it = sLiteConvertorClzs.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((Class) it.next()).newInstance();
            if (bVar != null) {
                hashMap.put(Integer.valueOf(bVar.getBusinessType().ordinal()), bVar);
            }
        }
        return hashMap;
    }

    @UiThread
    private final void j(String uid, HashMap<LiteBusinessType, Object> dataMap) {
        for (int size = listeners.size() - 1; size >= 0; size--) {
            listeners.get(size).a(uid, dataMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String str, HashMap dataMap) {
        Intrinsics.checkNotNullParameter(dataMap, "$dataMap");
        f353112a.j(str, dataMap);
    }

    @UiThread
    public final void b(@NotNull a listener) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<a> arrayList = listeners;
        if (arrayList.contains(listener)) {
            return;
        }
        arrayList.add(listener);
        if (kernelListenerId == null) {
            IKernelLiteBusinessService g16 = g();
            if (g16 != null) {
                l3 = Long.valueOf(g16.addListener(this));
            } else {
                l3 = null;
            }
            kernelListenerId = l3;
        }
    }

    public final void c(@NotNull String uid, @NotNull HashSet<LiteBusinessClearType> clearTypeSet, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, clearTypeSet, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(clearTypeSet, "clearTypeSet");
        IKernelLiteBusinessService g16 = g();
        if (g16 != null) {
            g16.clearLiteBusiness(uid, clearTypeSet, callback);
        }
    }

    @NotNull
    public final HashMap<LiteBusinessType, Object> d(@NotNull HashMap<LiteBusinessType, String> liteBusiness) {
        boolean z16;
        Object a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (HashMap) iPatchRedirector.redirect((short) 12, (Object) this, (Object) liteBusiness);
        }
        Intrinsics.checkNotNullParameter(liteBusiness, "liteBusiness");
        HashMap<LiteBusinessType, Object> hashMap = new HashMap<>();
        for (Map.Entry<LiteBusinessType, String> entry : liteBusiness.entrySet()) {
            if (entry.getValue().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b bVar = liteConvertorMap.get(Integer.valueOf(entry.getKey().ordinal()));
                if (bVar != null && (a16 = bVar.a(entry.getValue())) != null) {
                    hashMap.put(entry.getKey(), a16);
                }
            } else {
                hashMap.put(entry.getKey(), EMPTY_ITEM);
            }
        }
        return hashMap;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        listeners.clear();
        Long l3 = kernelListenerId;
        if (l3 != null) {
            long longValue = l3.longValue();
            kernelListenerId = null;
            IKernelLiteBusinessService g16 = f353112a.g();
            if (g16 != null) {
                g16.removeListener(longValue);
            }
        }
    }

    public final void f(@NotNull String uid, @NotNull HashSet<LiteBusinessType> bizTypeSet, @NotNull IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, uid, bizTypeSet, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(bizTypeSet, "bizTypeSet");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IKernelLiteBusinessService g16 = g();
        if (g16 != null) {
            g16.getLiteBusiness(uid, bizTypeSet, callback);
        }
    }

    @UiThread
    public final void l(@NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<a> arrayList = listeners;
        if (!arrayList.contains(listener)) {
            return;
        }
        arrayList.remove(listener);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessListener
    public void onLiteBusinessChange(@Nullable final String uid, @Nullable HashMap<LiteBusinessType, String> liteBusiness) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) uid, (Object) liteBusiness);
            return;
        }
        QLog.d("LiteBusinessHelper", 1, "[onLiteBusinessChange] uid=" + uid + ", business=" + liteBusiness);
        if (liteBusiness == null) {
            return;
        }
        final HashMap<LiteBusinessType, Object> d16 = d(liteBusiness);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.c
            @Override // java.lang.Runnable
            public final void run() {
                d.k(uid, d16);
            }
        });
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void i() {
    }
}
