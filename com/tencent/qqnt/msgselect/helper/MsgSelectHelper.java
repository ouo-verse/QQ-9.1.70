package com.tencent.qqnt.msgselect.helper;

import android.os.Bundle;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.msgselect.e;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\b\b*\u0001&\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000fH\u0016R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/msgselect/helper/MsgSelectHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "k", h.F, "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItemList", "o", "", "isCancel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "d", "Z", "startLoadMsg", "e", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "", "f", "Ljava/util/List;", "mSelectMsgList", "mOriginMsgList", "com/tencent/qqnt/msgselect/helper/MsgSelectHelper$b", "i", "Lcom/tencent/qqnt/msgselect/helper/MsgSelectHelper$b;", "mAction", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectHelper implements com.tencent.aio.main.businesshelper.h, g {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final String C;

    @NotNull
    private static final String D;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean startLoadMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AIOMsgItem> mSelectMsgList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AIOMsgItem> mOriginMsgList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/msgselect/helper/MsgSelectHelper$a;", "", "", "FROM_FINISH", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "SELECT_MSG_COUNT", "b", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msgselect.helper.MsgSelectHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return MsgSelectHelper.C;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return MsgSelectHelper.D;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/msgselect/helper/MsgSelectHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgSelectHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                MsgSelectHelper.this.k(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        C = "is_from_finish";
        D = "select_msg_count";
    }

    public MsgSelectHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSelectMsgList = new ArrayList();
        this.mOriginMsgList = new ArrayList();
        this.mAction = new b();
    }

    private final void h() {
        boolean z16;
        List list;
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        long[] longArray = bVar.a().g().l().getLongArray("key_selected_msg_id");
        if (longArray != null) {
            if (longArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                } else {
                    bVar2 = bVar3;
                }
                AIOContact c16 = bVar2.a().g().r().c();
                w e16 = f.e();
                if (e16 != null) {
                    Contact contact = new Contact(c16.e(), c16.j(), c16.f());
                    list = ArraysKt___ArraysKt.toList(longArray);
                    e16.getMsgsByMsgId(contact, new ArrayList<>(list), new IMsgOperateCallback() { // from class: com.tencent.qqnt.msgselect.helper.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                        public final void onResult(int i3, String str, ArrayList arrayList) {
                            MsgSelectHelper.i(MsgSelectHelper.this, i3, str, arrayList);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final MsgSelectHelper this$0, int i3, String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.msgselect.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    MsgSelectHelper.j(arrayList, this$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ArrayList msgList, MsgSelectHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgListUtil msgListUtil = MsgListUtil.f24918a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        List q16 = MsgListUtil.q(msgListUtil, msgList, null, null, 4, null);
        this$0.mSelectMsgList.addAll(q16);
        this$0.mOriginMsgList.addAll(q16);
        com.tencent.aio.main.businesshelper.b bVar = this$0.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(MultiSelectEvent.UpdateMsgCheckMode.f188677d);
        com.tencent.aio.main.businesshelper.b bVar3 = this$0.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k(final MsgIntent intent) {
        boolean z16;
        boolean z17 = true;
        if (intent instanceof MultiSelectEvent.GetSelectMode) {
            ((MultiSelectEvent.GetSelectMode) intent).b(true);
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = null;
        if (intent instanceof MultiSelectEvent.IsMsgSelect) {
            MultiSelectEvent.IsMsgSelect isMsgSelect = (MultiSelectEvent.IsMsgSelect) intent;
            Iterator<T> it = this.mSelectMsgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((AIOMsgItem) next).getMsgId() == isMsgSelect.a().getMsgId()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    bVar = next;
                    break;
                }
            }
            if (bVar == null) {
                z17 = false;
            }
            isMsgSelect.c(z17);
            return;
        }
        if (intent instanceof AIOTitleEvent.ClickFinishBtnEvent) {
            n(this, false, 1, null);
            return;
        }
        if (intent instanceof MultiSelectEvent.IsMsgSelectPage) {
            ((MultiSelectEvent.IsMsgSelectPage) intent).b(true);
            return;
        }
        if (intent instanceof MultiSelectEvent.GetSelectMsgSum) {
            ((MultiSelectEvent.GetSelectMsgSum) intent).b(this.mSelectMsgList.size());
            return;
        }
        if (intent instanceof MultiSelectEvent.GetSelectMsgList) {
            ((MultiSelectEvent.GetSelectMsgList) intent).b(this.mSelectMsgList);
            return;
        }
        if (intent instanceof AIOMsgListEvent.StartLoadMsg) {
            this.startLoadMsg = true;
            return;
        }
        if (intent instanceof MultiSelectEvent.ReachMsgTimeLimit) {
            if (!this.startLoadMsg) {
                return;
            }
            com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            } else {
                bVar = bVar2;
            }
            QQToast.makeText(bVar.a().c().getContext(), R.string.f234847a2, 0).show();
            com.tencent.qqnt.msgselect.DTReport.b.f359718a.f("em_bas_message_view_time_upper_toast");
            this.startLoadMsg = false;
            return;
        }
        if (intent instanceof MultiSelectEvent.SetSelectMsgList) {
            o(((MultiSelectEvent.SetSelectMsgList) intent).a());
            com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            } else {
                bVar = bVar3;
            }
            bVar.a().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
            return;
        }
        if (intent instanceof MultiSelectEvent.AddSelectMsg) {
            com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar4 = null;
            }
            int i3 = bVar4.a().g().l().getInt("key_limited_count");
            if (i3 <= 0) {
                i3 = 100;
            }
            if (this.mSelectMsgList.size() + 1 > i3) {
                com.tencent.aio.main.businesshelper.b bVar5 = this.mHelperParam;
                if (bVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                } else {
                    bVar = bVar5;
                }
                bVar.a().e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent("MsgSelectHelper", true));
                String string = BaseApplication.context.getString(R.string.f6w, Integer.valueOf(i3));
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026l_chaoguo, limitMsgCount)");
                QQToast.makeText(BaseApplication.context, string, 0).show();
                com.tencent.qqnt.msgselect.DTReport.b.f359718a.f("em_bas_message_selection_upper_toast_number");
                return;
            }
            MultiSelectEvent.AddSelectMsg addSelectMsg = (MultiSelectEvent.AddSelectMsg) intent;
            this.mSelectMsgList.add(addSelectMsg.a());
            addSelectMsg.b(true);
            com.tencent.aio.main.businesshelper.b bVar6 = this.mHelperParam;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            } else {
                bVar = bVar6;
            }
            bVar.a().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
            return;
        }
        if (intent instanceof MultiSelectEvent.RemoveSelectMsg) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.mSelectMsgList, (Function1) new Function1<AIOMsgItem, Boolean>() { // from class: com.tencent.qqnt.msgselect.helper.MsgSelectHelper$handleAction$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgIntent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull AIOMsgItem it5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it5);
                    }
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return Boolean.valueOf(it5.getMsgId() == ((MultiSelectEvent.RemoveSelectMsg) MsgIntent.this).a().getMsgId());
                }
            });
            com.tencent.aio.main.businesshelper.b bVar7 = this.mHelperParam;
            if (bVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            } else {
                bVar = bVar7;
            }
            bVar.a().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
            return;
        }
        if (intent instanceof MultiSelectEvent.RemoveAllSelectMsg) {
            this.mSelectMsgList.clear();
            com.tencent.aio.main.businesshelper.b bVar8 = this.mHelperParam;
            if (bVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar8 = null;
            }
            bVar8.a().e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
            com.tencent.aio.main.businesshelper.b bVar9 = this.mHelperParam;
            if (bVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            } else {
                bVar = bVar9;
            }
            bVar.a().e().h(MultiSelectEvent.UpdateMsgCheckMode.f188677d);
            com.tencent.qqnt.msgselect.DTReport.b.e("em_bas_deselect_button", new HashMap());
            return;
        }
        if (intent instanceof AIOTitleEvent.ClearAndResetList) {
            this.mSelectMsgList.clear();
            this.mSelectMsgList.addAll(this.mOriginMsgList);
            m(true);
        }
    }

    private final void m(boolean isCancel) {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        int i3 = bVar.a().g().l().getInt("key_from", 0);
        QLog.i("MsgSelectHelper", 1, "[handleFinishEvent]: size is " + this.mSelectMsgList.size() + " from: " + i3);
        Bundle bundle = new Bundle();
        bundle.putBoolean(C, true);
        bundle.putInt(D, this.mSelectMsgList.size());
        bundle.putBoolean("key_is_cancel", isCancel);
        com.tencent.qqnt.msgselect.b a16 = e.f359744a.a(i3);
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar3 = null;
        }
        com.tencent.aio.api.runtime.a a17 = bVar3.a();
        com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar4 = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
        com.tencent.aio.main.businesshelper.b bVar5 = this.mHelperParam;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar5 = null;
        }
        a16.a(a17, bVar4.e(bVar5.a()), bundle);
        com.tencent.aio.main.businesshelper.b bVar6 = this.mHelperParam;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar6;
        }
        bVar2.a().e().h(new ExternalCommIntent("close_msg_select", bundle));
    }

    static /* synthetic */ void n(MsgSelectHelper msgSelectHelper, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        msgSelectHelper.m(z16);
    }

    private final void o(List<? extends AIOMsgItem> msgItemList) {
        this.mSelectMsgList.clear();
        this.mSelectMsgList.addAll(msgItemList);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 33;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectMode");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.IsMsgSelect");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.AddSelectMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.SetSelectMsgList");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.RemoveSelectMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectMsgList");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.ClickFinishBtnEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.IsMsgSelectPage");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectMsgSum");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.RemoveAllSelectMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.ReachMsgTimeLimit");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.StartLoadMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.ClearAndResetList");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
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
        return "MsgSelectHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        param.a().e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = null;
        if (state != 0) {
            if (state == 3) {
                h();
                com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    bVar2 = null;
                }
                bVar2.a().e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent("MsgSelectHelper", true));
                com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                } else {
                    bVar = bVar3;
                }
                bVar.a().e().h(new AIOMsgListEvent.NeedPreLoadMsg(false));
                return;
            }
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar4 = null;
        }
        bVar4.a().e().h(new AIOTitleEvent.UpdateRight1IvEvent(false, false, null, 3, null, 16, null));
        com.tencent.aio.main.businesshelper.b bVar5 = this.mHelperParam;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar5 = null;
        }
        bVar5.a().e().h(new AIOTitleEvent.UpdateRight2IvEvent(false, false, null, 0, ""));
        com.tencent.aio.main.businesshelper.b bVar6 = this.mHelperParam;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar = bVar6;
        }
        bVar.a().e().h(new AIOTitleEvent.UpdateRight3IvEvent(false, false, null, "", null, 16, null));
    }
}
