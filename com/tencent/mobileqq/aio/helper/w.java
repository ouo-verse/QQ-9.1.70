package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001 \b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/w;", "Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "i", tl.h.F, "", "k", "", "getId", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "com/tencent/mobileqq/aio/helper/w$b", "f", "Lcom/tencent/mobileqq/aio/helper/w$b;", "mAction", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class w implements com.tencent.aio.main.businesshelper.e, com.tencent.aio.api.runtime.emitter.a, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/w$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.w$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/w$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                w.this.j(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49871);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction = new b();
        }
    }

    private final void e() {
        AIOSession aIOSession;
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        final ArrayList<Long> i3 = i();
        if (i3.isEmpty()) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null) {
            aIOSession = g16.r();
        } else {
            aIOSession = null;
        }
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        Intrinsics.checkNotNull(aIOSession);
        iMsgService.deleteMsg(new Contact(aIOSession.c().e(), k(), ""), i3, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.helper.v
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                w.g(w.this, i3, i16, str);
            }
        });
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(w this$0, ArrayList msgIdList, int i3, String str) {
        com.tencent.aio.main.businesshelper.b bVar;
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgIdList, "$msgIdList");
        QLog.i("DeleteMessageHelper", 4, "deleteMessage(res:" + i3 + ", errMsg:" + str);
        if (i3 == 0 && (bVar = this$0.mHelperParam) != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
            e16.h(new AIOMsgListEvent.OnDeleteMsgs(msgIdList));
        }
    }

    private final void h() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
            e16.h(new MultiSelectEvent.SetSelectMode(false));
            e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("DeleteMessageHelper", false));
        }
    }

    private final ArrayList<Long> i() {
        com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
        Intrinsics.checkNotNull(bVar2);
        List<AIOMsgItem> e16 = bVar.e(bVar2.a());
        ArrayList<Long> arrayList = new ArrayList<>();
        for (AIOMsgItem aIOMsgItem : e16) {
            if (!com.tencent.qqnt.aio.msg.d.i(aIOMsgItem)) {
                arrayList.add(Long.valueOf(aIOMsgItem.getMsgId()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(MsgIntent intent) {
        if (intent instanceof MultiSelectEvent.MultiDeleteMessageEvent) {
            m();
        }
    }

    private final void m() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        final ActionSheet create = ActionSheet.create(context);
        create.setMainTitle(R.string.f168852gr);
        create.addButton(R.string.f168842gq, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.aio.helper.u
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                w.n(w.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(w this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.e();
        }
        actionSheet.dismiss();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 11;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Set) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.MultiDeleteMessageEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "DeleteMessageHelper";
    }

    @Nullable
    public final String k() {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            return c16.j();
        }
        return null;
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        param.a().e().f(this, this.mAction);
        Fragment c16 = param.a().c();
        if (c16 != null) {
            context = c16.getContext();
        } else {
            context = null;
        }
        this.mContext = context;
        param.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.aio.api.runtime.a a16;
        ml3.b b16;
        ml3.a a17;
        com.tencent.aio.api.runtime.a a18;
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        e.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar != null && (a18 = bVar.a()) != null && (e16 = a18.e()) != null) {
            e16.i(this, this.mAction);
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
        if (bVar2 != null && (a16 = bVar2.a()) != null && (b16 = a16.b()) != null && (a17 = b16.a(com.tencent.aio.api.runtime.emitter.a.class)) != null) {
            a17.c(this);
        }
    }
}
