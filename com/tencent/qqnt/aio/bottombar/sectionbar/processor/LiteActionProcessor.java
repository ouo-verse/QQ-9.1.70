package com.tencent.qqnt.aio.bottombar.sectionbar.processor;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.api.IAIOLiteActionApi;
import com.tencent.mobileqq.aio.helper.j;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.d;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAHelper;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAScene;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J&\u0010%\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00122\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\u0011H\u0016R\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020#0)j\b\u0012\u0004\u0012\u00020#`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u0018\u00102\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/LiteActionProcessor;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lcom/tencent/qqnt/biz/lightbusiness/a;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "resList", HippyTKDListViewAdapter.X, "", "objectType", "type", QCircleLpReportDc010001.KEY_SUBTYPE, "", "", "", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "f", "e", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", h.F, "Lol3/b;", "i", "j", "k", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "data", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isKeyboardShow", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "bizTypeSet", "D", "firstHandled", "E", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", "curItem", "<init>", "()V", UserInfo.SEX_FEMALE, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LiteActionProcessor extends BottomSectionBarBaseProcessor implements com.tencent.qqnt.biz.lightbusiness.a {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashSet<LiteBusinessType> bizTypeSet;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean firstHandled;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LIAActionItem curItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isKeyboardShow;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/LiteActionProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.processor.LiteActionProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiteActionProcessor() {
        HashSet<LiteBusinessType> hashSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(LiteBusinessType.KLITEACTION);
            this.bizTypeSet = hashSetOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f(), new ArrayList()));
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(LIAActionItem item) {
        List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> z16 = z(item.getType());
        QLog.d("LiteActionProcessor", 1, "addLiteAction, LIAActionItem=" + item + ", resList size=" + z16.size());
        this.curItem = item;
        x(item, z16);
        ArrayList arrayList = new ArrayList();
        for (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar : z16) {
            int f16 = f();
            LIAHelper lIAHelper = LIAHelper.f353124a;
            String p16 = lIAHelper.p(bVar);
            if (p16 == null) {
                p16 = "";
            }
            arrayList.add(new com.tencent.qqnt.aio.bottombar.sectionbar.model.a(f16, p16, bVar.g(), lIAHelper.l(item, bVar)));
        }
        p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f(), arrayList));
    }

    private final Map<String, Object> v(int objectType, int type, int subType) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("object_type", Integer.valueOf(objectType)), TuplesKt.to("light_interaction_type", Integer.valueOf(type)), TuplesKt.to("sub_light_interaction_type", Integer.valueOf(subType)));
        return mapOf;
    }

    private final void w() {
        LIAActionItem lIAActionItem = this.curItem;
        if (lIAActionItem == null) {
            return;
        }
        com.tencent.mobileqq.aio.utils.b.t("em_bas_shortcut_bar_above_c2c_input_box", v(lIAActionItem.b(), lIAActionItem.getType(), lIAActionItem.c()));
        this.curItem = null;
    }

    private final void x(LIAActionItem item, List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> resList) {
        Iterator<T> it = resList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.aio.utils.b.q("em_bas_shortcut_bar_above_c2c_input_box", v(item.b(), item.getType(), ((com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) it.next()).m()));
        }
    }

    private final void y() {
        HashMap hashMapOf;
        if (QLog.isDevelopLevel()) {
            QLog.d("LiteActionProcessor", 4, "doLiteAction");
        }
        if (this.firstHandled) {
            QLog.d("LiteActionProcessor", 1, "[doLiteAction] no need because handled already");
            return;
        }
        LIAActionItem lIAActionItem = (LIAActionItem) d().g().l().getParcelable("KEY_ACTION_ITEM");
        if (lIAActionItem != null) {
            QLog.d("LiteActionProcessor", 1, "[doLiteAction] use cache to show");
            String j3 = d().g().r().c().j();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(LiteBusinessType.KLITEACTION, lIAActionItem));
            a(j3, hashMapOf);
            return;
        }
        new StopWatch("LiteActionProcessor", QLog.isColorLevel()).j(new LiteActionProcessor$doLiteAction$1(this));
    }

    private final List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b> z(int type) {
        return LIAConfigManager.INSTANCE.a().i(type, LIAScene.AIO);
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.a
    public void a(@Nullable String uid, @NotNull Map<LiteBusinessType, ? extends Object> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uid, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (uid != null && Intrinsics.areEqual(uid, d().g().r().c().j())) {
            this.firstHandled = true;
            LiteBusinessType liteBusinessType = LiteBusinessType.KLITEACTION;
            final Object obj = data.get(liteBusinessType);
            if (obj instanceof LIAActionItem) {
                j.f189071a.a(liteBusinessType);
                LIAHelper.f353124a.j(uid, (LIAActionItem) obj, LIAScene.AIO, new Function3<Boolean, Integer, Integer, Unit>(obj) { // from class: com.tencent.qqnt.aio.bottombar.sectionbar.processor.LiteActionProcessor$onChanged$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Object $item;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.$item = obj;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteActionProcessor.this, obj);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, Integer num2) {
                        invoke(bool.booleanValue(), num.intValue(), num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, int i3, int i16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                        } else if (z16 || i3 > 0) {
                            LiteActionProcessor.this.u((LIAActionItem) this.$item);
                        } else {
                            QLog.d("LiteActionProcessor", 1, "[onChanged] preload fail. remove!");
                            LiteActionProcessor.this.A();
                        }
                    }
                });
            } else {
                QLog.d("LiteActionProcessor", 1, "[onChanged] type err. remove!");
                A();
            }
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.EnterAIOAnimationEnd");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean h(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            this.isKeyboardShow = ((KeyboardMsgIntent.OnKeyboardStateChanged) intent).b();
            return true;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) {
            y();
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void i(@NotNull ol3.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return !this.isKeyboardShow;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.k();
        this.firstHandled = false;
        w();
        ((IAIOLiteActionApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOLiteActionApi.class)).onDestroy();
        d.f353112a.l(this);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.l();
        if (d().g().r().c().e() != 1) {
            return;
        }
        d.f353112a.b(this);
        ((IAIOLiteActionApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOLiteActionApi.class)).onCreate(d());
    }
}
