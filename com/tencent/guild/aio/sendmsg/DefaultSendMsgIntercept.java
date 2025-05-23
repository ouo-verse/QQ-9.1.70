package com.tencent.guild.aio.sendmsg;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import st1.k;
import st1.l;
import st1.m;
import st1.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001\u000eB#\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010*R&\u0010.\u001a\u0012\u0012\u0004\u0012\u00020,0\bj\b\u0012\u0004\u0012\u00020,`\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/guild/aio/sendmsg/DefaultSendMsgIntercept;", "Lst1/k;", "Lst1/l;", "Lst1/m;", "subProcessIntercept", "f", "", h.F, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "selfProcessIntercept", "", "isIntercept", "a", "Lcom/tencent/aio/msgservice/k;", "Lcom/tencent/aio/msgservice/k;", "getSendMsgsReq", "()Lcom/tencent/aio/msgservice/k;", "sendMsgsReq", "Lcom/tencent/aio/api/runtime/a;", "b", "Lcom/tencent/aio/api/runtime/a;", "getContext", "()Lcom/tencent/aio/api/runtime/a;", "setContext", "(Lcom/tencent/aio/api/runtime/a;)V", "context", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "getExtData", "()Landroid/os/Bundle;", "setExtData", "(Landroid/os/Bundle;)V", "extData", "d", "Lkotlin/Lazy;", "g", "()Ljava/util/ArrayList;", "subInterceptList", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Ljava/util/ArrayList;", "msgElements", "<init>", "(Lcom/tencent/aio/msgservice/k;Lcom/tencent/aio/api/runtime/a;Landroid/os/Bundle;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class DefaultSendMsgIntercept implements k, l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.msgservice.k sendMsgsReq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.aio.api.runtime.a context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle extData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subInterceptList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Contact peer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<MsgElement> msgElements;

    public DefaultSendMsgIntercept(@NotNull com.tencent.aio.msgservice.k sendMsgsReq, @NotNull com.tencent.aio.api.runtime.a context, @Nullable Bundle bundle) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(sendMsgsReq, "sendMsgsReq");
        Intrinsics.checkNotNullParameter(context, "context");
        this.sendMsgsReq = sendMsgsReq;
        this.context = context;
        this.extData = bundle;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<m>>() { // from class: com.tencent.guild.aio.sendmsg.DefaultSendMsgIntercept$subInterceptList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<m> invoke() {
                return DefaultSendMsgIntercept.this.e();
            }
        });
        this.subInterceptList = lazy;
    }

    private final m f(m subProcessIntercept) {
        int indexOf = g().indexOf(subProcessIntercept);
        if (indexOf < g().size() - 1 && indexOf >= 0) {
            return g().get(indexOf + 1);
        }
        return null;
    }

    private final ArrayList<m> g() {
        return (ArrayList) this.subInterceptList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(final DefaultSendMsgIntercept this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
        this$0.peer = lVar.c(this$0.sendMsgsReq.a());
        List<Object> b16 = this$0.sendMsgsReq.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.guild.msg.GuildAIOMsgElement>");
        this$0.msgElements = lVar.a(b16);
        QLog.i("DefaultSendMsgIntercept", 1, "processIntercept transformAioMsgToElements sendMsgsReq:" + this$0.sendMsgsReq.a());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.guild.aio.sendmsg.b
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSendMsgIntercept.j(DefaultSendMsgIntercept.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DefaultSendMsgIntercept this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<MsgElement> arrayList = null;
        if (this$0.g().isEmpty()) {
            Contact contact = this$0.peer;
            if (contact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peer");
                contact = null;
            }
            ArrayList<MsgElement> arrayList2 = this$0.msgElements;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgElements");
            } else {
                arrayList = arrayList2;
            }
            this$0.b(false, new n(contact, arrayList), this$0.extData);
            return;
        }
        m mVar = this$0.g().get(0);
        Contact contact2 = this$0.peer;
        if (contact2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peer");
            contact2 = null;
        }
        ArrayList<MsgElement> arrayList3 = this$0.msgElements;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgElements");
        } else {
            arrayList = arrayList3;
        }
        mVar.a(contact2, arrayList);
    }

    @Override // st1.l
    public void a(@NotNull m selfProcessIntercept, boolean isIntercept) {
        Unit unit;
        Intrinsics.checkNotNullParameter(selfProcessIntercept, "selfProcessIntercept");
        ArrayList<MsgElement> arrayList = null;
        if (isIntercept) {
            Contact contact = this.peer;
            if (contact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peer");
                contact = null;
            }
            ArrayList<MsgElement> arrayList2 = this.msgElements;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgElements");
            } else {
                arrayList = arrayList2;
            }
            b(true, new n(contact, arrayList), this.extData);
            return;
        }
        m f16 = f(selfProcessIntercept);
        if (f16 != null) {
            Contact contact2 = this.peer;
            if (contact2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peer");
                contact2 = null;
            }
            ArrayList<MsgElement> arrayList3 = this.msgElements;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgElements");
                arrayList3 = null;
            }
            f16.a(contact2, arrayList3);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Contact contact3 = this.peer;
            if (contact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peer");
                contact3 = null;
            }
            ArrayList<MsgElement> arrayList4 = this.msgElements;
            if (arrayList4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgElements");
            } else {
                arrayList = arrayList4;
            }
            b(false, new n(contact3, arrayList), this.extData);
        }
    }

    @NotNull
    public ArrayList<m> e() {
        Bundle bundle = this.extData;
        boolean z16 = true;
        if (bundle != null) {
            z16 = bundle.getBoolean("IS_SHOW_PROCESS_DIALOG", true);
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getSubTextLinkInterceptProcessor(this, this.context));
        arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getSubQrCodePicInterceptProcessor(this, this.context, Boolean.valueOf(z16)));
        arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getHongbaoInterceptProcessor(this, this.context));
        arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getSubTextAtInterceptProcessor(this, this.context));
        arrayList.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getSubKeywordInterceptProcessor(this, this.context));
        return arrayList;
    }

    public void h() {
        QLog.i("DefaultSendMsgIntercept", 1, "processIntercept sendMsgsReq:" + this.sendMsgsReq.a());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.sendmsg.a
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSendMsgIntercept.i(DefaultSendMsgIntercept.this);
            }
        }, 16, null, true);
    }
}
