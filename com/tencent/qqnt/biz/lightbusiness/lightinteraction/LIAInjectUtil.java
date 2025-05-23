package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessClearType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ4\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u0017RF\u0010$\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u001c0\u001bj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u001c`\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RF\u0010(\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u001c0\u001bj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u001c`\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAInjectUtil;", "", "", "j", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/c;", "k", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/e;", "l", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAScene;", "scene", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAInjectUtil$a;", "extraInfo", "d", "Landroid/view/View;", "view", tl.h.F, "", "uid", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "res", "Lkotlin/Function1;", "", "doneCallback", "i", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getSLIAClickProcessorClzs", "()Ljava/util/ArrayList;", "setSLIAClickProcessorClzs", "(Ljava/util/ArrayList;)V", "sLIAClickProcessorClzs", "c", "getSLIAResourcePreloadClzs", "setSLIAResourcePreloadClzs", "sLIAResourcePreloadClzs", "Lkotlin/Lazy;", "f", "()Ljava/util/List;", "sLIAClickProcessors", "e", "g", "sLIAResourcePreloaders", "<init>", "()V", "a", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAInjectUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LIAInjectUtil f353125a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/LightBusiness/Inject_LiteHelper.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends c>> sLIAClickProcessorClzs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/LightBusiness/Inject_LiteHelper.yml", version = 1)
    @NotNull
    private static ArrayList<Class<? extends e>> sLIAResourcePreloadClzs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sLIAClickProcessors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sLIAResourcePreloaders;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f353125a = new LIAInjectUtil();
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        sLIAClickProcessorClzs = arrayList;
        arrayList.add(com.tencent.qqnt.aio.litebussiness.liteaction.a.class);
        sLIAClickProcessorClzs.add(g61.a.class);
        sLIAResourcePreloadClzs = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) LIAInjectUtil$sLIAClickProcessors$2.INSTANCE);
        sLIAClickProcessors = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LIAInjectUtil$sLIAResourcePreloaders$2.INSTANCE);
        sLIAResourcePreloaders = lazy2;
        j();
    }

    LIAInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(LIAScene scene, a extraInfo) {
        final String str;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        HashSet<LiteBusinessClearType> hashSetOf;
        if (extraInfo.c() && scene != LIAScene.AIO) {
            if (extraInfo.b() != null) {
                str = extraInfo.b().peerUid;
            } else {
                com.tencent.aio.api.runtime.a a16 = extraInfo.a();
                if (a16 != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                    str = c16.j();
                } else {
                    str = null;
                }
            }
            if (str != null) {
                com.tencent.qqnt.biz.lightbusiness.d dVar = com.tencent.qqnt.biz.lightbusiness.d.f353112a;
                hashSetOf = SetsKt__SetsKt.hashSetOf(LiteBusinessClearType.KLITEACTIONMSGLIST);
                dVar.c(str, hashSetOf, new IOperateCallback() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.o
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str2) {
                        LIAInjectUtil.e(str, i3, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str, int i3, String str2) {
        QLog.d("LIAInjectUtil", 1, "[clearLiteAction] uid=" + str + ", res=" + i3 + ", errMsg=" + str2);
    }

    private final List<c> f() {
        return (List) sLIAClickProcessors.getValue();
    }

    private final List<e> g() {
        return (List) sLIAResourcePreloaders.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<c> k() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sLIAClickProcessorClzs.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Class) it.next()).newInstance();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        arrayList.add(new DefaultLIAClickProcessor());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<e> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sLIAResourcePreloadClzs.iterator();
        while (it.hasNext()) {
            e eVar = (e) ((Class) it.next()).newInstance();
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public final void h(@Nullable View view, @NotNull LIAScene scene, @NotNull a extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, scene, extraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        d(scene, extraInfo);
        for (c cVar : f()) {
            if (cVar.a(view, scene, extraInfo)) {
                QLog.d("LIAInjectUtil", 1, "[handleClick] it=" + cVar.getClass().getName() + ", scene=" + scene + ", item=" + extraInfo.d().getType());
                return;
            }
        }
    }

    public final void i(@NotNull String uid, @NotNull LIAActionItem item, @Nullable com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res, @NotNull Function1<? super Boolean, Unit> doneCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, uid, item, res, doneCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(doneCallback, "doneCallback");
        for (e eVar : g()) {
            if (eVar.b(uid, item)) {
                eVar.a(uid, item, res, doneCallback);
                return;
            }
        }
        doneCallback.invoke(Boolean.TRUE);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u0010\u0010\u001cR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u0016\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/LIAInjectUtil$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", "a", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", "d", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "b", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "e", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "res", "Lcom/tencent/aio/api/runtime/a;", "c", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Z", "()Z", "fromSend", "<init>", "(Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;Lcom/tencent/aio/api/runtime/a;Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Z)V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LIAActionItem item;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.api.runtime.a aioContext;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Contact contact;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean fromSend;

        public a(@NotNull LIAActionItem item, @NotNull com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res, @Nullable com.tencent.aio.api.runtime.a aVar, @Nullable Contact contact, boolean z16) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(res, "res");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, item, res, aVar, contact, Boolean.valueOf(z16));
                return;
            }
            this.item = item;
            this.res = res;
            this.aioContext = aVar;
            this.contact = contact;
            this.fromSend = z16;
        }

        @Nullable
        public final com.tencent.aio.api.runtime.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.aioContext;
        }

        @Nullable
        public final Contact b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Contact) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.contact;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.fromSend;
        }

        @NotNull
        public final LIAActionItem d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LIAActionItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.item;
        }

        @NotNull
        public final com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.res;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.item, aVar.item) && Intrinsics.areEqual(this.res, aVar.res) && Intrinsics.areEqual(this.aioContext, aVar.aioContext) && Intrinsics.areEqual(this.contact, aVar.contact) && this.fromSend == aVar.fromSend) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode2 = ((this.item.hashCode() * 31) + this.res.hashCode()) * 31;
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            int i3 = 0;
            if (aVar == null) {
                hashCode = 0;
            } else {
                hashCode = aVar.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            Contact contact = this.contact;
            if (contact != null) {
                i3 = contact.hashCode();
            }
            int i17 = (i16 + i3) * 31;
            boolean z16 = this.fromSend;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            return i17 + i18;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "LIAClickExtraInfo(item=" + this.item + ", res=" + this.res + ", aioContext=" + this.aioContext + ", contact=" + this.contact + ", fromSend=" + this.fromSend + ")";
        }

        public /* synthetic */ a(LIAActionItem lIAActionItem, com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar, com.tencent.aio.api.runtime.a aVar, Contact contact, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(lIAActionItem, bVar, (i3 & 4) != 0 ? null : aVar, (i3 & 8) != 0 ? null : contact, (i3 & 16) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, lIAActionItem, bVar, aVar, contact, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void j() {
    }
}
