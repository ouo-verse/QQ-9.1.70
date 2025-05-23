package com.tencent.mobileqq.aio.factory;

import android.content.Context;
import com.tencent.aio.api.factory.j;
import com.tencent.mobileqq.aio.msglist.AIOMsgListVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bp\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\f\u0012#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0016\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\f\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R2\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/AIOMsgAdornApiImpl;", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/aio/api/list/f;", "b", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVB;", h.F, "Lcom/tencent/aio/api/refreshLoad/e;", "f", "Landroid/content/Context;", "context", "", "c", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "getMsgCellGetter", "()Lkotlin/jvm/functions/Function0;", "msgCellGetter", "getListVBGetter", "listVBGetter", "getMsgRefreshMsgHeadFooterGetter", "msgRefreshMsgHeadFooterGetter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "d", "Lkotlin/jvm/functions/Function1;", "getHeadPaddingGetter", "()Lkotlin/jvm/functions/Function1;", "headPaddingGetter", "", "e", "getListVBTokenGetter", "listVBTokenGetter", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOMsgAdornApiImpl implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.aio.api.list.f> msgCellGetter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<AIOMsgListVB> listVBGetter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.aio.api.refreshLoad.e> msgRefreshMsgHeadFooterGetter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Context, Integer> headPaddingGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<String> listVBTokenGetter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.aio.factory.AIOMsgAdornApiImpl$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Context, Integer> {
        static IPatchRedirector $redirector_;
        public static final AnonymousClass4 INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43792);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new AnonymousClass4();
            }
        }

        AnonymousClass4() {
            super(1, a.class, "getMsgListHeadPadding", "getMsgListHeadPadding(Landroid/content/Context;)I", 1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Integer invoke(@NotNull Context p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            return Integer.valueOf(a.a(p06));
        }
    }

    public AIOMsgAdornApiImpl(@NotNull Function0<? extends com.tencent.aio.api.list.f> msgCellGetter, @NotNull Function0<? extends AIOMsgListVB> listVBGetter, @NotNull Function0<? extends com.tencent.aio.api.refreshLoad.e> msgRefreshMsgHeadFooterGetter, @NotNull Function1<? super Context, Integer> headPaddingGetter, @NotNull Function0<String> listVBTokenGetter) {
        Intrinsics.checkNotNullParameter(msgCellGetter, "msgCellGetter");
        Intrinsics.checkNotNullParameter(listVBGetter, "listVBGetter");
        Intrinsics.checkNotNullParameter(msgRefreshMsgHeadFooterGetter, "msgRefreshMsgHeadFooterGetter");
        Intrinsics.checkNotNullParameter(headPaddingGetter, "headPaddingGetter");
        Intrinsics.checkNotNullParameter(listVBTokenGetter, "listVBTokenGetter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgCellGetter, listVBGetter, msgRefreshMsgHeadFooterGetter, headPaddingGetter, listVBTokenGetter);
            return;
        }
        this.msgCellGetter = msgCellGetter;
        this.listVBGetter = listVBGetter;
        this.msgRefreshMsgHeadFooterGetter = msgRefreshMsgHeadFooterGetter;
        this.headPaddingGetter = headPaddingGetter;
        this.listVBTokenGetter = listVBTokenGetter;
    }

    @Override // com.tencent.aio.api.factory.j
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return j.a.b(this);
    }

    @Override // com.tencent.aio.api.factory.j
    @NotNull
    public com.tencent.aio.api.list.f b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.api.list.f) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.msgCellGetter.invoke();
    }

    @Override // com.tencent.aio.api.factory.j
    public int c(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return this.headPaddingGetter.invoke(context).intValue();
    }

    @Override // com.tencent.aio.api.factory.j
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return j.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.j
    public int e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context)).intValue();
        }
        return j.a.c(this, context);
    }

    @Override // com.tencent.aio.api.factory.j
    @Nullable
    public com.tencent.aio.api.refreshLoad.e f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.aio.api.refreshLoad.e) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.msgRefreshMsgHeadFooterGetter.invoke();
    }

    @Override // com.tencent.aio.api.factory.h
    @Nullable
    public com.tencent.aio.api.b getLayoutDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.aio.api.b) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return j.a.e(this);
    }

    @Override // com.tencent.aio.api.factory.j
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AIOMsgListVB getViewBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AIOMsgListVB) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.listVBGetter.invoke();
    }

    public /* synthetic */ AIOMsgAdornApiImpl(Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function0 function04, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? AnonymousClass1.INSTANCE : function0, (i3 & 2) != 0 ? AnonymousClass2.INSTANCE : function02, (i3 & 4) != 0 ? AnonymousClass3.INSTANCE : function03, (i3 & 8) != 0 ? AnonymousClass4.INSTANCE : function1, (i3 & 16) != 0 ? AnonymousClass5.INSTANCE : function04);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, function0, function02, function03, function1, function04, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
