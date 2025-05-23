package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001+\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bR\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\r0'j\b\u0012\u0004\u0012\u00020\r`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/ad;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "i", "b", "g", "e", "c", "", "helperID", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "a", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", tl.h.F, "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Ljava/util/HashSet;", "Ljava/util/HashSet;", "lateInitHelperList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "helperList", "com/tencent/mobileqq/aio/helper/ad$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/helper/ad$b;", "mAction", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class ad implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Integer> lateInitHelperList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.aio.helper.LateInitHelper.b> helperList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/ad$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.ad$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/ad$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ad.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                ad.this.h(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lateInitHelperList = new HashSet<>();
        this.helperList = new ArrayList<>();
        this.mAction = new b();
    }

    private final com.tencent.mobileqq.aio.helper.LateInitHelper.b a(int helperID, MsgIntent msgIntent) {
        com.tencent.mobileqq.aio.helper.LateInitHelper.b normalMenuHelper;
        if (!this.lateInitHelperList.contains(Integer.valueOf(helperID))) {
            return null;
        }
        this.lateInitHelperList.remove(Integer.valueOf(helperID));
        if (helperID != 1) {
            if (helperID != 2) {
                if (helperID != 3) {
                    if (helperID != 4) {
                        if (helperID != 5) {
                            normalMenuHelper = null;
                        } else {
                            com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
                            if (bVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                                bVar = null;
                            }
                            normalMenuHelper = new y(bVar, msgIntent);
                        }
                    } else {
                        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
                        if (bVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                            bVar2 = null;
                        }
                        normalMenuHelper = new aj(bVar2, msgIntent);
                    }
                } else {
                    com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                        bVar3 = null;
                    }
                    normalMenuHelper = new LongShotHelper(bVar3, msgIntent);
                }
            } else {
                com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
                if (bVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    bVar4 = null;
                }
                normalMenuHelper = new SelectableMenuHelper(bVar4, msgIntent);
            }
        } else {
            com.tencent.aio.main.businesshelper.b bVar5 = this.mHelperParam;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar5 = null;
            }
            normalMenuHelper = new NormalMenuHelper(bVar5, msgIntent);
        }
        if (normalMenuHelper == null) {
            return null;
        }
        normalMenuHelper.a();
        QLog.i("LateInitMangerHelper", 1, "createLateInitVM " + helperID + " " + normalMenuHelper.getTag());
        this.helperList.add(normalMenuHelper);
        return normalMenuHelper;
    }

    private final void b() {
        QLog.i("LateInitMangerHelper", 1, "doOnCreate " + this.helperList.size());
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().f(this, this.mAction);
    }

    private final void c() {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
        for (com.tencent.mobileqq.aio.helper.LateInitHelper.b bVar2 : this.helperList) {
            QLog.i("LateInitMangerHelper", 1, "doOnDestroy " + bVar2.getTag());
            bVar2.b();
        }
        this.helperList.clear();
    }

    private final void e() {
        for (com.tencent.mobileqq.aio.helper.LateInitHelper.b bVar : this.helperList) {
            QLog.i("LateInitMangerHelper", 1, "doPause " + bVar.getTag());
            bVar.g();
        }
    }

    private final void g() {
        for (com.tencent.mobileqq.aio.helper.LateInitHelper.b bVar : this.helperList) {
            QLog.i("LateInitMangerHelper", 1, "doShow " + bVar.getTag());
            bVar.h();
        }
    }

    private final void i() {
        HashSet<Integer> hashSet = this.lateInitHelperList;
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent.CreateHelperRealIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LateInitMangerHelper";
    }

    public final void h(@NotNull MsgIntent i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) i3);
            return;
        }
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof CreateHelperIntent.CreateHelperRealIntent) {
            CreateHelperIntent.CreateHelperRealIntent createHelperRealIntent = (CreateHelperIntent.CreateHelperRealIntent) i3;
            if (a(createHelperRealIntent.b(), createHelperRealIntent.c()) == null) {
                com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar = null;
                }
                aVar.e().h(createHelperRealIntent.c());
                Unit unit = Unit.INSTANCE;
            }
            com.tencent.mobileqq.aio.helper.LateInitHelper.a a16 = createHelperRealIntent.a();
            if (a16 != null) {
                a16.invoke();
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 7, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mHelperParam = param;
        this.mAIOContext = param.a();
        Context requireContext = param.a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "param.aioContext.fragment.requireContext()");
        this.mContext = requireContext;
        QLog.i("LateInitMangerHelper", 1, "onCreate");
        i();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 12) {
                if (state != 7) {
                    if (state == 8) {
                        e();
                        return;
                    }
                    return;
                }
                g();
                return;
            }
            c();
            return;
        }
        b();
    }
}
