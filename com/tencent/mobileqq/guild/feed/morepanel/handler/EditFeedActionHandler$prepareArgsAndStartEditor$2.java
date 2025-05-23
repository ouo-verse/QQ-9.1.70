package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.EditFeedActionHandler$prepareArgsAndStartEditor$2", f = "EditFeedActionHandler.kt", i = {}, l = {134, 204}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class EditFeedActionHandler$prepareArgsAndStartEditor$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EditFeedActionHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFeedActionHandler$prepareArgsAndStartEditor$2(EditFeedActionHandler editFeedActionHandler, PanelContext<Activity, vk1.b> panelContext, Continuation<? super EditFeedActionHandler$prepareArgsAndStartEditor$2> continuation) {
        super(2, continuation);
        this.this$0 = editFeedActionHandler;
        this.$panelContext = panelContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        EditFeedActionHandler$prepareArgsAndStartEditor$2 editFeedActionHandler$prepareArgsAndStartEditor$2 = new EditFeedActionHandler$prepareArgsAndStartEditor$2(this.this$0, this.$panelContext, continuation);
        editFeedActionHandler$prepareArgsAndStartEditor$2.L$0 = obj;
        return editFeedActionHandler$prepareArgsAndStartEditor$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b6, code lost:
    
        if (r6 != false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac A[Catch: all -> 0x0205, TryCatch #0 {all -> 0x0205, blocks: (B:16:0x002d, B:18:0x0079, B:20:0x007d, B:23:0x009d, B:25:0x00ac, B:27:0x00bb, B:29:0x00c7, B:31:0x00d0, B:32:0x00d3, B:34:0x00d6, B:36:0x00e5, B:38:0x00e8, B:40:0x019c, B:42:0x01ac, B:46:0x01e4, B:52:0x01b8, B:53:0x0088, B:55:0x0040, B:57:0x0050, B:58:0x0056, B:60:0x005c, B:64:0x0093), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: all -> 0x0205, TryCatch #0 {all -> 0x0205, blocks: (B:16:0x002d, B:18:0x0079, B:20:0x007d, B:23:0x009d, B:25:0x00ac, B:27:0x00bb, B:29:0x00c7, B:31:0x00d0, B:32:0x00d3, B:34:0x00d6, B:36:0x00e5, B:38:0x00e8, B:40:0x019c, B:42:0x01ac, B:46:0x01e4, B:52:0x01b8, B:53:0x0088, B:55:0x0040, B:57:0x0050, B:58:0x0056, B:60:0x005c, B:64:0x0093), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x023c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        Dialog dialog;
        PanelContext<Activity, vk1.b> panelContext;
        GuildFeedPublishInfo guildFeedPublishInfo;
        EditFeedActionHandler editFeedActionHandler;
        vk1.b j3;
        Object f16;
        PanelContext<Activity, vk1.b> panelContext2;
        Dialog dialog2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    dialog = this.this$0.loadDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Logger.f235387a.d().i("EditFeedActionHandler", 1, "prepareArgsAndStartEditor finish");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            EditFeedActionHandler editFeedActionHandler2 = (EditFeedActionHandler) this.L$1;
            panelContext2 = (PanelContext) this.L$0;
            ResultKt.throwOnFailure(obj);
            editFeedActionHandler = editFeedActionHandler2;
            f16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            panelContext = this.$panelContext;
            EditFeedActionHandler editFeedActionHandler3 = this.this$0;
            Result.Companion companion2 = Result.INSTANCE;
            com.tencent.mobileqq.guild.feed.morepanel.cooperate.l lVar = (com.tencent.mobileqq.guild.feed.morepanel.cooperate.l) panelContext.getApiRouter().b(com.tencent.mobileqq.guild.feed.morepanel.cooperate.l.class);
            if (lVar != null) {
                guildFeedPublishInfo = lVar.provide();
            } else {
                guildFeedPublishInfo = null;
            }
            if (com.tencent.mobileqq.guild.feed.feedsquare.data.g.f(guildFeedPublishInfo)) {
                GuildFeedMorePanelHandlerUtils guildFeedMorePanelHandlerUtils = GuildFeedMorePanelHandlerUtils.f220288a;
                this.L$0 = panelContext;
                this.L$1 = editFeedActionHandler3;
                this.label = 1;
                editFeedActionHandler = editFeedActionHandler3;
                f16 = GuildFeedMorePanelHandlerUtils.f(guildFeedMorePanelHandlerUtils, panelContext, 2000L, false, this, 2, null);
                if (f16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                panelContext2 = panelContext;
            } else {
                editFeedActionHandler = editFeedActionHandler3;
                j3 = panelContext.j();
                EditFeedActionHandler editFeedActionHandler4 = editFeedActionHandler;
                editFeedActionHandler4.j(j3);
                if (!panelContext.h().isFinishing()) {
                    Logger.f235387a.d().i("EditFeedActionHandler", 1, "prepareArgsAndStartEditor context is finished");
                    return Unit.INSTANCE;
                }
                if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(j3.getFeedType())) {
                    editFeedActionHandler4.l(panelContext, j3);
                    dialog2 = editFeedActionHandler4.loadDialog;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                    return Unit.INSTANCE;
                }
                String b16 = new FeedRichTextConvertTool().b(j3.a());
                if (b16 == null) {
                    return Unit.INSTANCE;
                }
                jj1.b c16 = jj1.b.c();
                Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
                com.tencent.mobileqq.guild.feed.util.p.a(c16, j3.getFeedId(), b16);
                GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
                guildFeedBaseInitBean.setBusinessType(5);
                guildFeedBaseInitBean.setGuildId(String.valueOf(j3.getGuildId()));
                guildFeedBaseInitBean.setChannelId(String.valueOf(j3.getChannelId()));
                guildFeedBaseInitBean.setChannelName(j3.q());
                editFeedActionHandler4.k(guildFeedBaseInitBean, panelContext);
                boolean z16 = false;
                Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("launch_feed_id", j3.getFeedId()), TuplesKt.to("launch_json_feed_store_id", j3.getFeedId()), TuplesKt.to(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedBaseInitBean), TuplesKt.to("launch_published_flag", Boxing.boxBoolean(true)), TuplesKt.to("launch_edit_flag", Boxing.boxBoolean(true)), TuplesKt.to("launch_request_id", Boxing.boxInt(panelContext.h().hashCode())), TuplesKt.to("launch_draft_key", j3.getFeedId()));
                if (panelContext.getExtra().getInt("src_business_type") != 20) {
                    Bundle extras = panelContext.h().getIntent().getExtras();
                    if (extras != null && extras.getInt("business_type") == 20) {
                        z16 = true;
                    }
                }
                bundleOf.putParcelable("launch_config", new FeedEditorConfiguration(false, false, false, false, false, false, false, false, 127, null));
                bundleOf.putBundle("topic_element_append", panelContext.getExtra().getBundle("topic_element_append"));
                em1.a aVar = em1.a.f396585a;
                Activity h16 = panelContext.h();
                FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
                aVar.h(h16, 5, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.f("reedit feed"), feedPublishEditorLaunchCompat.c()));
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    i.e eVar = i.e.f261783e;
                    EditFeedActionHandler$prepareArgsAndStartEditor$2$2$1 editFeedActionHandler$prepareArgsAndStartEditor$2$2$1 = new EditFeedActionHandler$prepareArgsAndStartEditor$2$2$1(m479exceptionOrNullimpl, null);
                    this.L$0 = m476constructorimpl;
                    this.L$1 = null;
                    this.label = 2;
                    if (CorountineFunKt.i(eVar, null, null, editFeedActionHandler$prepareArgsAndStartEditor$2$2$1, this, 6, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                dialog = this.this$0.loadDialog;
                if (dialog != null) {
                }
                Logger.f235387a.d().i("EditFeedActionHandler", 1, "prepareArgsAndStartEditor finish");
                return Unit.INSTANCE;
            }
        }
        GProStFeed gProStFeed = (GProStFeed) f16;
        if (gProStFeed != null) {
            j3 = new vk1.a(new GProStFeedDetailRspWrapper(gProStFeed, null, 2, null));
        } else {
            j3 = panelContext2.j();
        }
        panelContext = panelContext2;
        EditFeedActionHandler editFeedActionHandler42 = editFeedActionHandler;
        editFeedActionHandler42.j(j3);
        if (!panelContext.h().isFinishing()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((EditFeedActionHandler$prepareArgsAndStartEditor$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
