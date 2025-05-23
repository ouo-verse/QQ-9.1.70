package com.tencent.mobileqq.aio.msglist.holder.component.nick.block;

import android.content.Context;
import android.util.SparseArray;
import android.widget.LinearLayout;
import androidx.annotation.WorkerThread;
import androidx.core.util.SparseArrayKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.robot.NickNameRobotBlock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.vas.vipicon.f;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR4\u0010\u0018\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00150\u0004j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0015`\u00068\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R+\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u0016\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/NickBlockInject;", "", "", "g", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/b;", "Lkotlin/collections/ArrayList;", h.F, "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "e", "f", "c", "d", "", "bizId", "a", "Ljava/lang/Class;", "b", "Ljava/util/ArrayList;", "blockProviderClass", "Lkotlin/Lazy;", "()Ljava/util/ArrayList;", "blockProvider", "", "Z", "inited", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NickBlockInject {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NickBlockInject f191343a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ConfigInject(configPath = "AutoInjectYml/Business/AIO/nick/Inject_AIO_Nick_Block_Provider.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends b>> blockProviderClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy blockProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean inited;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f191343a = new NickBlockInject();
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        blockProviderClass = arrayList;
        arrayList.add(e.class);
        arrayList.add(com.tencent.qqnt.aio.nick.d.class);
        arrayList.add(f.class);
        lazy = LazyKt__LazyJVMKt.lazy(NickBlockInject$blockProvider$2.INSTANCE);
        blockProvider = lazy;
    }

    NickBlockInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<b> b() {
        return (ArrayList) blockProvider.getValue();
    }

    @Nullable
    public final a a(int bizId, @NotNull Context context, @NotNull LinearLayout rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(bizId), context, rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Iterator<T> it = b().iterator();
        while (it.hasNext()) {
            a b16 = ((b) it.next()).b(bizId, context, rootView);
            if (b16 != null) {
                return b16;
            }
        }
        return null;
    }

    @NotNull
    public final SparseArray<a> c(@NotNull Context context, @NotNull LinearLayout rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SparseArray) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        SparseArray<a> sparseArray = new SparseArray<>();
        sparseArray.put(0, new NickNameRobotBlock(context, rootView));
        sparseArray.put(2, new MainNickNameBlock(context, rootView));
        return sparseArray;
    }

    @NotNull
    public final SparseArray<a> d(@NotNull Context context, @NotNull LinearLayout rootView) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SparseArray) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 1, 2, 3, 4, 8);
        SparseArray<a> sparseArray = new SparseArray<>();
        SparseArray<a> e16 = e(context, rootView);
        int size = e16.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = e16.keyAt(i3);
            a valueAt = e16.valueAt(i3);
            if (arrayListOf.contains(Integer.valueOf(keyAt))) {
                sparseArray.put(keyAt, valueAt);
            }
        }
        return sparseArray;
    }

    @NotNull
    public final SparseArray<a> e(@NotNull Context context, @NotNull LinearLayout rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SparseArray) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        SparseArray<a> sparseArray = new SparseArray<>();
        Iterator<T> it = b().iterator();
        while (it.hasNext()) {
            SparseArrayKt.putAll(sparseArray, ((b) it.next()).c(context, rootView));
        }
        return sparseArray;
    }

    @NotNull
    public final SparseArray<a> f(@NotNull Context context, @NotNull LinearLayout rootView) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SparseArray) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 1, 2, 3, 4, 8, 5);
        SparseArray<a> sparseArray = new SparseArray<>();
        SparseArray<a> e16 = e(context, rootView);
        int size = e16.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = e16.keyAt(i3);
            a valueAt = e16.valueAt(i3);
            if (arrayListOf.contains(Integer.valueOf(keyAt))) {
                sparseArray.put(keyAt, valueAt);
            }
        }
        return sparseArray;
    }

    @WorkerThread
    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (inited) {
            return;
        }
        inited = true;
        LinearLayout linearLayout = new LinearLayout(BaseApplication.context);
        for (b bVar : b()) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bVar.c(context, linearLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<b> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<b> arrayList = new ArrayList<>();
        Iterator<T> it = blockProviderClass.iterator();
        while (it.hasNext()) {
            arrayList.add(((Class) it.next()).newInstance());
        }
        return arrayList;
    }
}
