package com.tencent.mobileqq.guild.channellist.process;

import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.channellist.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\bH'J\b\u0010\u0012\u001a\u00020\bH'J\u0013\u0010\u0013\u001a\u00020\bH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u001e\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00028\u0001H'\u00a2\u0006\u0004\b\u001f\u0010 R$\u0010\r\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f8\u0004@BX\u0084.\u00a2\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R$\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n8\u0004@BX\u0084.\u00a2\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010'R$\u0010)\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00188\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b&\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R \u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000/0.8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00106\u001a\u0002038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/a;", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "d", "", "guildId", "", "c", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "e", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/guild/channellist/c;", VideoTemplateParser.ITEM_LIST, "", "isFirstTimeUpdate", "j", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "data", "Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/guild/channellist/c;Ljava/lang/Object;)Lcom/tencent/mobileqq/guild/channellist/process/ReplaceResult;", "<set-?>", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "i", "()Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Lcom/tencent/common/app/AppInterface;", "f", "()Lcom/tencent/common/app/AppInterface;", "Z", "isActive", "()Z", h.F, "()Ljava/lang/String;", "name", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/channellist/process/b;", "g", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a<T> implements CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RuntimeServiceHolder serviceHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AppInterface app;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.process.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7689a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f215329d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7689a(CoroutineExceptionHandler.Companion companion, a aVar) {
            super(companion);
            this.f215329d = aVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            Logger logger = Logger.f235387a;
            String str = "Guild.CLST." + this.f215329d.h();
            Logger.b bVar = new Logger.b();
            String str2 = "coroutine exception: ctx=" + context;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(str, 1, (String) it.next(), exception);
            }
            if (!QLog.isDevelopLevel()) {
            } else {
                throw exception;
            }
        }
    }

    private final CoroutineExceptionHandler d() {
        return new C7689a(CoroutineExceptionHandler.INSTANCE, this);
    }

    @UiThread
    static /* synthetic */ Object k(a<T> aVar, List<? extends c> list, boolean z16, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @UiThread
    static /* synthetic */ Object p(a<T> aVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public final void b() {
        this.isActive = true;
        l();
    }

    @UiThread
    public abstract void c(@NotNull String guildId);

    public final void e() {
        this.isActive = false;
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AppInterface f() {
        AppInterface appInterface = this.app;
        if (appInterface != null) {
            return appInterface;
        }
        Intrinsics.throwUninitializedPropertyAccessException("app");
        return null;
    }

    @NotNull
    public abstract Flow<ItemsProcessEvent<T>> g();

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(GuildAIODispatchers.f112358a.c()).plus(d());
    }

    @NotNull
    public abstract String h();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RuntimeServiceHolder i() {
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder != null) {
            return runtimeServiceHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
        return null;
    }

    @UiThread
    @Nullable
    public Object j(@NotNull List<? extends c> list, boolean z16, @NotNull Continuation<? super Unit> continuation) {
        return k(this, list, z16, continuation);
    }

    @UiThread
    public abstract void l();

    @UiThread
    public abstract void m();

    @UiThread
    @NotNull
    public abstract <T> ReplaceResult n(@NotNull c item, @NotNull T data);

    @UiThread
    @Nullable
    public Object o(@NotNull Continuation<? super Unit> continuation) {
        return p(this, continuation);
    }

    public final void q(@NotNull AppInterface app, @NotNull RuntimeServiceHolder serviceHolder) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(serviceHolder, "serviceHolder");
        this.app = app;
        this.serviceHolder = serviceHolder;
    }
}
