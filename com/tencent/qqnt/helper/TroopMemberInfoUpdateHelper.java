package com.tencent.qqnt.helper;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.qqnt.troopmemberlist.f;
import com.tencent.qqnt.troopmemberlist.j;
import com.tencent.qqnt.troopmemberlist.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\fH\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/helper/TroopMemberInfoUpdateHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "", "j", "i", "k", "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "d", "Z", "isProcessorInit", "", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor;", "e", "Ljava/util/List;", "processorList", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/AIOContact;", h.F, "Lcom/tencent/aio/data/AIOContact;", "aioContact", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopMemberInfoUpdateHelper implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_troop_member_info_update_processor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<ITroopMemberInfoUpdateProcessor>> f356933m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isProcessorInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ITroopMemberInfoUpdateProcessor> processorList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AIOContact aioContact;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R6\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/helper/TroopMemberInfoUpdateHelper$a;", "", "", "TAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor;", "Lkotlin/collections/ArrayList;", "processorClassList", "Ljava/util/ArrayList;", "getProcessorClassList$annotations", "()V", "<init>", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.helper.TroopMemberInfoUpdateHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356938a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62146);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ITroopMemberInfoUpdateProcessor.Strategy.values().length];
            try {
                iArr[ITroopMemberInfoUpdateProcessor.Strategy.NET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ITroopMemberInfoUpdateProcessor.Strategy.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f356938a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62154);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<ITroopMemberInfoUpdateProcessor>> arrayList = new ArrayList<>();
        f356933m = arrayList;
        arrayList.add(x.class);
        arrayList.add(com.tencent.mobileqq.troop.troopgag.a.class);
        arrayList.add(j.class);
    }

    public TroopMemberInfoUpdateHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.processorList = new ArrayList();
        }
    }

    private final void g() {
        if (!this.isProcessorInit) {
            this.isProcessorInit = true;
            Iterator<Class<ITroopMemberInfoUpdateProcessor>> it = f356933m.iterator();
            while (it.hasNext()) {
                Class<ITroopMemberInfoUpdateProcessor> next = it.next();
                List<ITroopMemberInfoUpdateProcessor> list = this.processorList;
                ITroopMemberInfoUpdateProcessor newInstance = next.newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.newInstance()");
                list.add(newInstance);
            }
        }
        if (!j()) {
            i();
            k();
        }
        for (ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor : this.processorList) {
            AIOContact aIOContact = this.aioContact;
            if (aIOContact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                aIOContact = null;
            }
            iTroopMemberInfoUpdateProcessor.f(aIOContact.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TroopMemberInfoUpdateHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    private final void i() {
        AIOContact aIOContact;
        boolean z16;
        boolean z17;
        Iterator<ITroopMemberInfoUpdateProcessor> it = this.processorList.iterator();
        while (true) {
            aIOContact = null;
            z16 = false;
            if (it.hasNext()) {
                ITroopMemberInfoUpdateProcessor next = it.next();
                AIOContact aIOContact2 = this.aioContact;
                if (aIOContact2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                    aIOContact2 = null;
                }
                int i3 = b.f356938a[next.b(aIOContact2.j()).ordinal()];
                z17 = true;
                if (i3 != 1) {
                    if (i3 == 2) {
                        break;
                    }
                } else {
                    z17 = false;
                    z16 = true;
                    break;
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            AIOContact aIOContact3 = this.aioContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            } else {
                aIOContact = aIOContact3;
            }
            QLog.d("TroopMemberInfoUpdateHelper", 2, "tryLoadTroopAdminUin: " + aIOContact.j() + ", needNet=" + z16 + ", needDB=" + z17);
        }
        if (z16) {
            o();
        } else if (z17) {
            m();
        }
    }

    private final boolean j() {
        AIOContact aIOContact;
        boolean z16;
        Iterator<ITroopMemberInfoUpdateProcessor> it = this.processorList.iterator();
        while (true) {
            aIOContact = null;
            if (it.hasNext()) {
                ITroopMemberInfoUpdateProcessor next = it.next();
                AIOContact aIOContact2 = this.aioContact;
                if (aIOContact2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                    aIOContact2 = null;
                }
                if (next.a(aIOContact2.j())) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            AIOContact aIOContact3 = this.aioContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            } else {
                aIOContact = aIOContact3;
            }
            QLog.d("TroopMemberInfoUpdateHelper", 2, "onLoadData: " + aIOContact.j() + ", needUpdateTroopMemberInfo=" + z16);
        }
        if (z16) {
            p();
        }
        return z16;
    }

    private final void k() {
        AIOContact aIOContact;
        boolean z16;
        Iterator<ITroopMemberInfoUpdateProcessor> it = this.processorList.iterator();
        while (true) {
            aIOContact = null;
            if (it.hasNext()) {
                ITroopMemberInfoUpdateProcessor next = it.next();
                AIOContact aIOContact2 = this.aioContact;
                if (aIOContact2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContact");
                    aIOContact2 = null;
                }
                if (next.c(aIOContact2.j())) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (QLog.isColorLevel()) {
            AIOContact aIOContact3 = this.aioContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            } else {
                aIOContact = aIOContact3;
            }
            QLog.d("TroopMemberInfoUpdateHelper", 2, "tryLoadTroopOwnerUin: " + aIOContact.j() + ", needUpdate=" + z16);
        }
        if (z16) {
            r();
        }
    }

    private final void m() {
        AIOContact aIOContact = this.aioContact;
        com.tencent.aio.api.runtime.a aVar = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        final String j3 = aIOContact.j();
        TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        troopMemberListRepo.fetchTroopMemberList(j3, aVar.d(), false, "TroopMemberInfoUpdateHelper", new f() { // from class: com.tencent.qqnt.helper.b
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                TroopMemberInfoUpdateHelper.n(TroopMemberInfoUpdateHelper.this, j3, z16, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TroopMemberInfoUpdateHelper this$0, String groupCode, boolean z16, List troopMemberList) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupCode, "$groupCode");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoUpdateHelper", 2, "updateTroopAdminFromDB: isSuccess=" + z16 + ", troopMemberList.size=" + troopMemberList.size());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = troopMemberList.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            if (troopMemberInfo.role == MemberRole.ADMIN) {
                str = troopMemberInfo.memberuin;
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        Iterator<ITroopMemberInfoUpdateProcessor> it5 = this$0.processorList.iterator();
        while (it5.hasNext()) {
            it5.next().e(groupCode, false, z16, arrayList);
        }
    }

    private final void o() {
        AIOContact aIOContact = this.aioContact;
        com.tencent.aio.api.runtime.a aVar = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        final String j3 = aIOContact.j();
        TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        troopMemberExtInfoRepo.fetchTroopAdmin(j3, aVar.d(), new Function2<Boolean, List<? extends String>, Unit>(j3) { // from class: com.tencent.qqnt.helper.TroopMemberInfoUpdateHelper$updateTroopAdminUin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$groupCode = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberInfoUpdateHelper.this, (Object) j3);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends String> list) {
                invoke(bool.booleanValue(), (List<String>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull List<String> uinList) {
                List list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uinList);
                    return;
                }
                Intrinsics.checkNotNullParameter(uinList, "uinList");
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberInfoUpdateHelper", 2, "updateTroopAdminUin: isSuccess=" + z16 + ", uinList.size=" + uinList.size());
                }
                list = TroopMemberInfoUpdateHelper.this.processorList;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ITroopMemberInfoUpdateProcessor) it.next()).e(this.$groupCode, true, z16, uinList);
                }
            }
        });
    }

    private final void p() {
        AIOContact aIOContact = this.aioContact;
        com.tencent.aio.api.runtime.a aVar = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        final String j3 = aIOContact.j();
        TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        troopMemberListRepo.fetchTroopMemberList(j3, aVar.d(), true, "TroopMemberInfoUpdateHelper", new f() { // from class: com.tencent.qqnt.helper.c
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                TroopMemberInfoUpdateHelper.q(TroopMemberInfoUpdateHelper.this, j3, z16, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TroopMemberInfoUpdateHelper this$0, String groupCode, boolean z16, List troopMemberList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupCode, "$groupCode");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoUpdateHelper", 2, "updateTroopMemberInfo: isSuccess=" + z16 + ", troopMemberList.size=" + troopMemberList.size());
        }
        Iterator<ITroopMemberInfoUpdateProcessor> it = this$0.processorList.iterator();
        while (it.hasNext()) {
            it.next().d(groupCode, z16, troopMemberList);
        }
    }

    private final void r() {
        AIOContact aIOContact = this.aioContact;
        com.tencent.aio.api.runtime.a aVar = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContact");
            aIOContact = null;
        }
        final String j3 = aIOContact.j();
        TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        troopMemberExtInfoRepo.fetchTroopOwner(j3, aVar.d(), new Function2<Boolean, List<? extends String>, Unit>(j3) { // from class: com.tencent.qqnt.helper.TroopMemberInfoUpdateHelper$updateTroopOwnerUin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$groupCode = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberInfoUpdateHelper.this, (Object) j3);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends String> list) {
                invoke(bool.booleanValue(), (List<String>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull List<String> uinList) {
                List<ITroopMemberInfoUpdateProcessor> list;
                Object firstOrNull;
                Object firstOrNull2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uinList);
                    return;
                }
                Intrinsics.checkNotNullParameter(uinList, "uinList");
                if (QLog.isColorLevel()) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) uinList);
                    QLog.d("TroopMemberInfoUpdateHelper", 2, "updateTroopOwnerUin: isSuccess=" + z16 + ", uin=" + firstOrNull2);
                }
                list = TroopMemberInfoUpdateHelper.this.processorList;
                for (ITroopMemberInfoUpdateProcessor iTroopMemberInfoUpdateProcessor : list) {
                    String str = this.$groupCode;
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) uinList);
                    iTroopMemberInfoUpdateProcessor.g(str, z16, (String) firstOrNull);
                }
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350663p1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopMemberInfoUpdateHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
        this.aioContact = param.a().g().r().c();
        h.a.a(this, param);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        } else if (state == 4) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberInfoUpdateHelper.h(TroopMemberInfoUpdateHelper.this);
                }
            }, 16, null, false);
        }
    }
}
