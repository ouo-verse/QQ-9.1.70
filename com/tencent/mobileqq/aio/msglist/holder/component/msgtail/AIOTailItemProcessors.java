package com.tencent.mobileqq.aio.msglist.holder.component.msgtail;

import android.content.Context;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fR+\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000fj\b\u0012\u0004\u0012\u00020\r`\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOTailItemProcessors;", "", "Landroid/content/Context;", "context", "", "viewType", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "aioEmoReplyAdapter", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "parentVB", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "a", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/a;", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Lkotlin/Lazy;", "()Ljava/util/ArrayList;", "mMsgTailItemProcessorInstanceList", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTailItemProcessors {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOTailItemProcessors f191237a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mMsgTailItemProcessorInstanceList;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a) t16).c()), Integer.valueOf(((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a) t17).c()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62137);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f191237a = new AIOTailItemProcessors();
        lazy = LazyKt__LazyJVMKt.lazy(AIOTailItemProcessors$mMsgTailItemProcessorInstanceList$2.INSTANCE);
        mMsgTailItemProcessorInstanceList = lazy;
    }

    AIOTailItemProcessors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a> b() {
        return (ArrayList) mMsgTailItemProcessorInstanceList.getValue();
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c a(@NotNull Context context, int viewType, @NotNull AIOEmoReplyAdapter aioEmoReplyAdapter, @Nullable com.tencent.mobileqq.aio.msglist.holder.component.c parentVB) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(viewType), aioEmoReplyAdapter, parentVB);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioEmoReplyAdapter, "aioEmoReplyAdapter");
        Iterator<T> it = b().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a) obj).d() == viewType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a aVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a) obj;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, aioEmoReplyAdapter, parentVB);
    }

    @NotNull
    public final List<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a> c() {
        List<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a> sortedWith;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(b(), new a());
            return sortedWith;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
