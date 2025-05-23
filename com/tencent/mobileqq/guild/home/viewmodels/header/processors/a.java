package com.tencent.mobileqq.guild.home.viewmodels.header.processors;

import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\bH'J\b\u0010\r\u001a\u00020\bH'J\b\u0010\u000e\u001a\u00020\bH'J\b\u0010\u000f\u001a\u00020\bH'J9\u0010\u0016\u001a\u00020\u0015\"\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00028\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H'\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00068\u0004@BX\u0084.\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u001c8\u0004@BX\u0084\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\u00020!8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020!8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010#R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*0)8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010+R\u0014\u00100\u001a\u00020-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "c", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "d", h.F, "i", "k", "j", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "data", "", VideoTemplateParser.ITEM_LIST, "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "l", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;Ljava/lang/Object;Ljava/util/List;)Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/ProcessResult;", "<set-?>", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "g", "()Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "", "e", "Z", "isActive", "()Z", "", "getActiveGuildId", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "activeGuildId", "f", "name", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", "()Lkotlinx/coroutines/flow/Flow;", "eventSource", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a<T> implements CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RuntimeServiceHolder serviceHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.processors.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7801a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f225429d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7801a(CoroutineExceptionHandler.Companion companion, a aVar) {
            super(companion);
            this.f225429d = aVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            Logger logger = Logger.f235387a;
            String str = "Guild.MF.headerBars." + this.f225429d.f();
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

    private final CoroutineExceptionHandler c() {
        return new C7801a(CoroutineExceptionHandler.INSTANCE, this);
    }

    public final void b() {
        this.isActive = true;
        h();
    }

    public final void d() {
        this.isActive = false;
        i();
    }

    @NotNull
    public abstract Flow<c<T>> e();

    @NotNull
    public abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RuntimeServiceHolder g() {
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder != null) {
            return runtimeServiceHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(GuildAIODispatchers.f112358a.c()).plus(c());
    }

    @UiThread
    public abstract void h();

    @UiThread
    public abstract void i();

    @UiThread
    public abstract void j();

    @UiThread
    public abstract void k();

    @UiThread
    @NotNull
    public abstract <T> ProcessResult l(@Nullable com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b item, @NotNull T data, @NotNull List<? extends com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> itemList);

    public final void m(@NotNull RuntimeServiceHolder serviceHolder) {
        Intrinsics.checkNotNullParameter(serviceHolder, "serviceHolder");
        this.serviceHolder = serviceHolder;
    }

    public abstract void n(@NotNull String str);
}
