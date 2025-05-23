package com.tencent.mobileqq.aio.reserve1.toptip;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredNtTipsBar;
import com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopNtTipsBar;
import com.tencent.mobileqq.aio.reserve1.toptip.event.TopTipsEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.troop.troopownertask.TroopOwnerTaskTipsBar;
import com.tencent.mobileqq.troop.trooptodo.TroopToDoHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.toptip.LocationShareTipsBar;
import com.tencent.qqnt.aio.toptip.TroopHelperTipsBar;
import com.tencent.qqnt.aio.toptip.VideoStatusTipsBar;
import com.tencent.qqnt.aio.toptips.event.ForbiddenShowTips;
import com.tencent.qqnt.aio.utils.j;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001/\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J/\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0013\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0007H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R&\u0010.\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/d;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/qqnt/aio/toptips/c;", "Lcom/tencent/qqnt/aio/toptips/b;", "tipsTask", "", "g", "", "eventType", "", "", "data", "", "j", "(I[Ljava/lang/Object;)V", "tipsBarTask", "e", h.F, "needAnim", "i", "Lcom/tencent/aio/api/runtime/a;", "a", "b", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/qqnt/aio/toptips/b;", "curTipsBar", "Z", "forbiddenShow", "f", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParams", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/toptips/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mTipsTaskList", "com/tencent/mobileqq/aio/reserve1/toptip/d$b", "Lcom/tencent/mobileqq/aio/reserve1/toptip/d$b;", "forbiddenShowAction", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class d implements com.tencent.aio.main.businesshelper.h, com.tencent.qqnt.aio.toptips.c {
    static IPatchRedirector $redirector_;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/tips/aio_tips_inject_config.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.aio.toptips.a>> C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.toptips.b curTipsBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean forbiddenShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.qqnt.aio.toptips.a> mTipsTaskList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b forbiddenShowAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/toptip/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.toptip.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/toptip/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.forbiddenShow = ((ForbiddenShowTips) i3).a();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.aio.toptips.a>> arrayList = new ArrayList<>();
        C = arrayList;
        arrayList.add(NetStateTipsBar.class);
        arrayList.add(c.class);
        arrayList.add(com.tencent.qqnt.aio.toptip.h.class);
        arrayList.add(LocationShareTipsBar.class);
        arrayList.add(VideoStatusTipsBar.class);
        arrayList.add(com.tencent.qqnt.aio.toptip.a.class);
        arrayList.add(TroopHelperTipsBar.class);
        arrayList.add(BigTroopExpiredNtTipsBar.class);
        arrayList.add(UpgradeBigTroopNtTipsBar.class);
        arrayList.add(TroopOwnerTaskTipsBar.class);
        arrayList.add(TroopToDoHelper.class);
    }

    public d() {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<com.tencent.qqnt.aio.toptips.a> arrayList = new ArrayList<>();
        Iterator<Class<com.tencent.qqnt.aio.toptips.a>> it = C.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = it.next().getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "value.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.aio.toptips.BaseTipsBar");
            arrayList.add((com.tencent.qqnt.aio.toptips.a) newInstance);
        }
        this.mTipsTaskList = arrayList;
        this.forbiddenShowAction = new b();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean g(com.tencent.qqnt.aio.toptips.b tipsTask) {
        com.tencent.qqnt.aio.toptips.b bVar;
        String valueOf = String.valueOf(tipsTask.getType());
        int b16 = b();
        int[] b17 = tipsTask.b();
        boolean z16 = false;
        boolean z17 = true;
        if (b17 != null) {
            for (int i3 : b17) {
                if (b16 == i3) {
                    valueOf = ((Object) valueOf) + ", not allowed by excludeType: " + i3 + " ";
                    z17 = false;
                }
            }
        }
        if (z17 && (bVar = this.curTipsBar) != null) {
            Intrinsics.checkNotNull(bVar);
            if (bVar.j() < tipsTask.j()) {
                valueOf = ((Object) valueOf) + ", not allowed: priority is low ";
                if (QLog.isColorLevel()) {
                    QLog.d("TopTipsHelper", 2, "allowShow(): result = " + z16 + APLogFileUtil.SEPARATOR_LOG + ((Object) valueOf) + "|curTipsBarType" + b16);
                }
                return z16;
            }
        }
        z16 = z17;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    private final void j(int eventType, Object... data) {
        if (QLog.isColorLevel()) {
            QLog.i("TopTipsHelper", 2, "onAIOEvent eventType:" + eventType + " , count=" + this.mTipsTaskList.size());
        }
        Iterator<com.tencent.qqnt.aio.toptips.a> it = this.mTipsTaskList.iterator();
        while (it.hasNext()) {
            it.next().g(this, eventType, Arrays.copyOf(data, data.length));
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.c, com.tencent.mobileqq.aio.notification.c
    @NotNull
    public com.tencent.aio.api.runtime.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParams;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParams");
            bVar = null;
        }
        return bVar.a();
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        com.tencent.qqnt.aio.toptips.b bVar = this.curTipsBar;
        if (bVar != null) {
            return bVar.getType();
        }
        return -1;
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public boolean e(@NotNull com.tencent.qqnt.aio.toptips.b tipsBarTask) {
        MsgIntent topTipsShowEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tipsBarTask)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tipsBarTask, "tipsBarTask");
        if (this.forbiddenShow) {
            return false;
        }
        if (Intrinsics.areEqual(this.curTipsBar, tipsBarTask)) {
            if (QLog.isColorLevel()) {
                QLog.d("TopTipsHelper", 2, "showTipsBar() " + tipsBarTask.getType() + " is already show");
            }
            return true;
        }
        if (!g(tipsBarTask)) {
            if (QLog.isColorLevel()) {
                QLog.d("TopTipsHelper", 2, "showTipsBar() failure: mTipsMgr not allow");
            }
            return false;
        }
        com.tencent.qqnt.aio.toptips.b bVar = this.curTipsBar;
        if (bVar != null) {
            topTipsShowEvent = new TopTipsEvent.TopTipsReplaceShowEvent(bVar, tipsBarTask);
        } else {
            topTipsShowEvent = new TopTipsEvent.TopTipsShowEvent(tipsBarTask);
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParams;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParams");
            bVar2 = null;
        }
        bVar2.a().e().h(topTipsShowEvent);
        this.curTipsBar = tipsBarTask;
        if (QLog.isColorLevel()) {
            QLog.d("TopTipsHelper", 2, "showTipsBar() success: from " + tipsBarTask.getType());
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 12;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "TopTipsHelper";
    }

    @Override // com.tencent.qqnt.aio.toptips.c
    public void h(@Nullable com.tencent.qqnt.aio.toptips.b tipsBarTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tipsBarTask);
        } else {
            i(tipsBarTask, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.toptips.c
    public void i(@Nullable com.tencent.qqnt.aio.toptips.b tipsBarTask, boolean needAnim) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tipsBarTask, Boolean.valueOf(needAnim));
            return;
        }
        if (tipsBarTask != null && b() == tipsBarTask.getType()) {
            b16 = true;
        } else {
            b16 = false;
        }
        com.tencent.aio.main.businesshelper.b bVar = null;
        Integer num = null;
        if (b16 == false) {
            Object[] objArr = new Object[4];
            objArr[0] = "curTipsBarType : ";
            objArr[1] = Integer.valueOf(b());
            objArr[2] = " hide tips type : ";
            if (tipsBarTask != null) {
                num = Integer.valueOf(tipsBarTask.getType());
            }
            objArr[3] = num;
            QLog.d("TopTipsHelper", 1, objArr);
            return;
        }
        this.curTipsBar = null;
        j(2000, new Object[0]);
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParams;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParams");
        } else {
            bVar = bVar2;
        }
        bVar.a().e().h(new TopTipsEvent.TopTipsHideEvent(needAnim));
        HashMap hashMap = new HashMap();
        hashMap.put("horizontal_service_id", Integer.valueOf(tipsBarTask.getType()));
        hashMap.putAll(tipsBarTask.d());
        com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_small_horizontal", hashMap);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new int[]{4, 7, 8, 3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParams = param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParams");
            param = null;
        }
        param.a().e().d(j.f352301a.a(Reflection.getOrCreateKotlinClass(ForbiddenShowTips.class)), this.forbiddenShowAction);
        j(1005, new Object[0]);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParams;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParams");
            bVar = null;
        }
        bVar.a().e().b(j.f352301a.a(Reflection.getOrCreateKotlinClass(ForbiddenShowTips.class)), this.forbiddenShowAction);
        j(1004, new Object[0]);
        h(this.curTipsBar);
        this.curTipsBar = null;
        this.forbiddenShow = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, state);
            return;
        }
        if (state != 3) {
            if (state != 4) {
                if (state != 7) {
                    if (state == 8) {
                        j(1003, new Object[0]);
                        return;
                    }
                    return;
                }
                j(1000, new Object[0]);
                return;
            }
            j(1006, new Object[0]);
            return;
        }
        j(1007, new Object[0]);
    }
}
