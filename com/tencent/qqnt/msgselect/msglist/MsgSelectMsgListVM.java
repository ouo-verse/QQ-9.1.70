package com.tencent.qqnt.msgselect.msglist;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVM;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.w;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0014\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u001d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00140\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/msgselect/msglist/MsgSelectMsgListVM;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM;", "Lcom/tencent/qqnt/msgselect/msglist/a;", "", "dividingLine", "", "N0", "M0", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "b0", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/qqnt/msgselect/msglist/MsgSelectMsgListVM$b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/msgselect/msglist/MsgSelectMsgListVM$b;", "mAction", "", "Lkotlin/Pair;", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/List;", "messageList", "Lcom/tencent/mobileqq/aio/msglist/w;", "mListFetcher", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/w;)V", ExifInterface.LATITUDE_SOUTH, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectMsgListVM extends AIOMsgListVM implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msgselect/msglist/MsgSelectMsgListVM$a;", "", "", "MSG_SELECT_LIMIT", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msgselect.msglist.MsgSelectMsgListVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/msgselect/msglist/MsgSelectMsgListVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgSelectMsgListVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                MsgSelectMsgListVM.this.E(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65803);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgSelectMsgListVM(@NotNull w mListFetcher) {
        super(mListFetcher);
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(mListFetcher, "mListFetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mListFetcher);
            return;
        }
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectFromTop.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(MultiSelectEvent.UpdateMsgCheckMode.class).getQualifiedName(), bVar)});
        this.messageList = listOf;
    }

    private final void M0() {
        BuildersKt__Builders_commonKt.launch$default(vmScope(), zs.b.a(Dispatchers.INSTANCE), null, new MsgSelectMsgListVM$handleUpdateCheckMode$1(this, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N0(int dividingLine) {
        com.tencent.qqnt.msgselect.DTReport.b.e("em_bas_select_the_following_message_selector", new HashMap());
        int q06 = g0().q0(dividingLine, 3);
        int size = l().size() - 1;
        if (q06 < 0 || size < 0 || q06 >= size) {
            return;
        }
        List<com.tencent.aio.data.msglist.a> subList = l().subList(q06, size + 1);
        Intrinsics.checkNotNull(subList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.aio.msg.AIOMsgItem>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : subList) {
            if (((AIOMsgItem) obj).e2()) {
                arrayList.add(obj);
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
        QLog.i("AbsMsgListVM", 1, "hasCount is " + bVar.f((com.tencent.aio.api.runtime.a) getMContext()) + ", willTotalCount is " + bVar.d(arrayList));
        int i3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getInt("key_limited_count");
        if (i3 <= 0) {
            i3 = 100;
        }
        if (arrayList.size() > i3) {
            String string = BaseApplication.context.getString(R.string.f6w, Integer.valueOf(i3));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026l_chaoguo, limitMsgCount)");
            QQToast.makeText(BaseApplication.context, string, 0).show();
            com.tencent.qqnt.msgselect.DTReport.b.f359718a.f("em_bas_message_selection_upper_toast_number");
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MultiSelectEvent.SetSelectMsgList(arrayList));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MultiSelectEvent.UpdateSelectCount.f188678d);
        M0();
    }

    public final void E(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgListEvent.MultiSelectFromTop) {
            N0(((AIOMsgListEvent.MultiSelectFromTop) intent).a());
        } else if (intent instanceof MultiSelectEvent.UpdateMsgCheckMode) {
            M0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM
    @NotNull
    public AIOMsgRepo b0(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgRepo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) scope);
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new MsgSelectRepo(this, aioContext, scope, new WeakReference(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.mobileqq.aio.msglist.BaseMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
