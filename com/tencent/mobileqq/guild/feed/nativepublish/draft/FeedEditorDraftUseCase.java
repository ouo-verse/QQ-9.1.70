package com.tencent.mobileqq.guild.feed.nativepublish.draft;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import cm1.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zl1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001c\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/draft/FeedEditorDraftUseCase;", "Lqz0/a;", "", "g", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "draft", "f", "Lkotlin/Result;", "d", "()Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "e", h.F, "j", "c", "i", "", "a", "Ljava/lang/String;", "logTag", "b", "Lcom/tencent/base/api/runtime/a;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "autoSaveJob", "<init>", "(Ljava/lang/String;Lcom/tencent/base/api/runtime/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorDraftUseCase implements qz0.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f221823d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.base.api.runtime.a<zl1.a> context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job autoSaveJob;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/draft/FeedEditorDraftUseCase$a;", "", "", "SAVE_INTERVAL", "J", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FeedEditorDraftUseCase(@NotNull String logTag, @NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(context, "context");
        this.logTag = logTag;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(com.tencent.base.api.runtime.a<zl1.a> context, GProGuildFeedDraft draft) {
        String str;
        if (draft == null) {
            return;
        }
        String h16 = context.h().h();
        zl1.a h17 = context.h();
        Intrinsics.checkNotNullExpressionValue(h17, "context.baseParam");
        Long f16 = b.f(h17);
        if (f16 == null || (str = f16.toString()) == null) {
            str = "";
        }
        com.tencent.mobileqq.guild.feed.nativepublish.draft.a.b(h16, true, str, context.h().getFeedId());
    }

    private final void g() {
        Boolean bool;
        a.MakeJsonMsgResult makeJsonMsgResult;
        boolean z16;
        zl1.a h16 = this.context.h();
        Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
        String a16 = b.a(h16);
        zl1.a h17 = this.context.h();
        Intrinsics.checkNotNullExpressionValue(h17, "context.baseParam");
        int b16 = b.b(h17);
        k k3 = this.context.e().k(FeedEditorRestrictionSupervisorMsgIntent.FetchContentStatisticMsgIntent.f221805d);
        String str = null;
        if (!(k3 instanceof FeedEditorRestrictionSupervisorVMDelegate.b)) {
            k3 = null;
        }
        FeedEditorRestrictionSupervisorVMDelegate.b bVar = (FeedEditorRestrictionSupervisorVMDelegate.b) k3;
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.getHasSomethingToSave());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            c();
            return;
        }
        if (bool == null) {
            return;
        }
        k k16 = this.context.e().k(FeedEditorContentMsgIntent.MakeJsonForDraft.f221793d);
        if (k16 instanceof a.MakeJsonMsgResult) {
            makeJsonMsgResult = (a.MakeJsonMsgResult) k16;
        } else {
            makeJsonMsgResult = null;
        }
        if (makeJsonMsgResult != null) {
            str = makeJsonMsgResult.getFeedJson();
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w(this.logTag, 1, "[triggerSaveDraft]: draftResult is empty, something went wrong");
            return;
        }
        LifecycleOwner d16 = this.context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), ae.a().d(), null, new FeedEditorDraftUseCase$saveDraftInternal$1(a16, b16, this, makeJsonMsgResult, null), 2, null);
    }

    public final void c() {
        LifecycleOwner d16 = this.context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), ae.a().d(), null, new FeedEditorDraftUseCase$discardDraft$1(this, null), 2, null);
    }

    @NotNull
    public final Object d() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Object obj = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IFeedDraftServiceV2.class, "");
        } else {
            iRuntimeService = null;
        }
        IFeedDraftServiceV2 iFeedDraftServiceV2 = (IFeedDraftServiceV2) iRuntimeService;
        if (iFeedDraftServiceV2 != null) {
            zl1.a h16 = this.context.h();
            Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
            String a16 = b.a(h16);
            zl1.a h17 = this.context.h();
            Intrinsics.checkNotNullExpressionValue(h17, "context.baseParam");
            Object mo185peekFeedDraftCache0E7RQCE = iFeedDraftServiceV2.mo185peekFeedDraftCache0E7RQCE(a16, b.b(h17), this.context.h().getDraftKey());
            com.tencent.base.api.runtime.a<zl1.a> aVar = this.context;
            if (!Result.m482isFailureimpl(mo185peekFeedDraftCache0E7RQCE)) {
                obj = mo185peekFeedDraftCache0E7RQCE;
            }
            f(aVar, (GProGuildFeedDraft) obj);
            return mo185peekFeedDraftCache0E7RQCE;
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m476constructorimpl(ResultKt.createFailure(new Exception("no service")));
    }

    public final void e(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        BuildersKt__Builders_commonKt.launch$default(scope, ae.a().c(), null, new FeedEditorDraftUseCase$queryLastDraft$1(this, null), 2, null);
    }

    public final void h(@NotNull CoroutineScope scope) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Job job = this.autoSaveJob;
        boolean z16 = false;
        if (job != null && job.isActive()) {
            z16 = true;
        }
        if (!z16) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(scope, ae.a().e(), null, new FeedEditorDraftUseCase$startAutoSaveTimer$1(this, null), 2, null);
            this.autoSaveJob = launch$default;
        }
    }

    public final void i() {
        Job job = this.autoSaveJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void j() {
        if (this.context.h().q().getIsTriggerPost()) {
            return;
        }
        g();
    }
}
