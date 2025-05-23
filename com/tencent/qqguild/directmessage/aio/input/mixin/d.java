package com.tencent.qqguild.directmessage.aio.input.mixin;

import android.os.Bundle;
import android.text.Spannable;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.guild.api.msg.service.l;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001*\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/mixin/a;", "Lcom/tencent/mvi/api/ability/b;", "T", "", "d", "(Lcom/tencent/qqguild/directmessage/aio/input/mixin/a;)V", "Lcom/tencent/qqguild/directmessage/aio/input/mixin/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "c", "(Lcom/tencent/qqguild/directmessage/aio/input/mixin/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052*\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b2\u0006\u0010\n\u001a\u00020\u000bH\n\u00a2\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "msgElements", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "draftTime", "", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    static final class a implements IGetDraftOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<MsgElement>> f345116a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super List<MsgElement>> continuation) {
            this.f345116a = continuation;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
        public final void onResult(int i3, String str, ArrayList<MsgElement> arrayList, long j3) {
            Logger.f235387a.d().i("Guild.C2C.AIO.AioMessageDraftMixin", 1, "getDraft() result:" + i3 + ", errMsg:" + str + ", msgElements:" + arrayList + ", draftTime:" + j3);
            this.f345116a.resumeWith(Result.m476constructorimpl(arrayList));
        }
    }

    @Nullable
    public static final Object c(@NotNull e eVar, @NotNull Continuation<? super List<MsgElement>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        AIOParam getDraft$lambda$8$lambda$7 = eVar.a().g();
        Intrinsics.checkNotNullExpressionValue(getDraft$lambda$8$lambda$7, "getDraft$lambda$8$lambda$7");
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(new Contact(com.tencent.guild.aio.util.a.e(getDraft$lambda$8$lambda$7), com.tencent.guild.aio.util.a.b(getDraft$lambda$8$lambda$7), com.tencent.guild.aio.util.a.g(getDraft$lambda$8$lambda$7)), new a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <T extends com.tencent.qqguild.directmessage.aio.input.mixin.a & com.tencent.mvi.api.ability.b> void d(@NotNull T t16) {
        String take;
        CharSequence charSequence;
        String take2;
        List<e.InputSendTextIntent> emptyList;
        List<com.tencent.guild.api.media.album.e> arrayList;
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Bundle b16 = t16.fetchVBState(t.a.f111174a).b();
        Long valueOf = Long.valueOf(b16.getLong("guild_draft_input_reply_msg_id"));
        e.ReplyData replyData = null;
        if (valueOf.longValue() == QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR) {
            valueOf = null;
        }
        String string = b16.getString("guild_draft_input_reply_nick");
        String str = "";
        if (string == null) {
            string = "";
        }
        String string2 = b16.getString("guild_draft_input_reply_content");
        if (string2 == null) {
            string2 = "";
        }
        CharSequence charSequence2 = b16.getCharSequence("guild_draft_input_editable_text");
        String string3 = b16.getString("guild_draft_input_text");
        if (string3 != null) {
            str = string3;
        }
        AIOParam it = t16.a().g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        Logger.a d16 = Logger.f235387a.d();
        take = StringsKt___StringsKt.take(string2, 5);
        if (charSequence2 != null) {
            charSequence = StringsKt___StringsKt.take(charSequence2, 5);
        } else {
            charSequence = null;
        }
        take2 = StringsKt___StringsKt.take(str, 5);
        d16.d("Guild.C2C.AIO.AioMessageDraftMixin", 1, "[saveDraft] replyMsgId = " + valueOf + ", replyNickName = " + string + ", replySourceTxt= " + take + ", editableInputText= " + ((Object) charSequence) + ", inputText=" + take2);
        if (!(charSequence2 instanceof Spannable)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = com.tencent.guild.aio.util.e.f112380a.b(str, (Spannable) charSequence2);
        }
        if (valueOf != null) {
            replyData = new e.ReplyData(valueOf.longValue(), string, string2);
        }
        ArrayList<MsgElement> a16 = l.f112634a.a(lp0.a.f415333a.e(new e.InputSendMultiTextIntent(emptyList, replyData)));
        GuildAIOMediasRepository mediaRepo = t16.getMediaRepo();
        if (mediaRepo == null || (arrayList = mediaRepo.k()) == null) {
            arrayList = new ArrayList<>();
        }
        a16.addAll(((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).guildMediaInfo2MsgElement(arrayList));
        if (a16.isEmpty()) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.qqguild.directmessage.aio.input.mixin.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    d.e(i3, str2);
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setDraft(contact, a16, new IOperateCallback() { // from class: com.tencent.qqguild.directmessage.aio.input.mixin.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    d.f(i3, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, String str) {
        Logger.f235387a.d().i("Guild.C2C.AIO.AioMessageDraftMixin", 1, "deleteDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String str) {
        Logger.f235387a.d().i("Guild.C2C.AIO.AioMessageDraftMixin", 1, "saveDraft() result:" + i3 + ", errMsg:" + str);
    }
}
