package com.tencent.qqguild.base.aio.helpers;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qqguild.base.mvvm.b;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import in0.c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqguild/base/aio/helpers/ArticlePageNavigateHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/qqguild/base/mvvm/b;", "e", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "c", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/qqguild/base/mvvm/b;", "messageEventHandler", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mvi/base/route/j;", "b", "()Lcom/tencent/mvi/base/route/j;", "messenger", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ArticlePageNavigateHelper implements h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b messageEventHandler = e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    private final j b() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        j e16 = aVar.e();
        Intrinsics.checkNotNullExpressionValue(e16, "aioContext.messenger");
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(com.tencent.aio.data.msglist.a msgItem) {
        GuildMsgItem guildMsgItem;
        MsgRecord msgRecord;
        com.tencent.aio.api.runtime.a aVar;
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null) {
            if (MsgExtKt.R(msgRecord) && MsgExtKt.U(msgRecord)) {
                com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar2 = null;
                }
                FragmentActivity activity = aVar2.c().getActivity();
                if (activity == null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("jumpToArticleDetailPage: activity is null");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.ArticlePageNavigateHelper", 1, (String) it.next(), null);
                    }
                    return;
                }
                Contact contact = new Contact(4, msgRecord.peerUid, msgRecord.guildId);
                long j3 = msgRecord.msgSeq;
                com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar = null;
                } else {
                    aVar = aVar3;
                }
                c.c(activity, contact, j3, null, aVar, 0, 32, null);
                return;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str = "jumpToArticleDetailPage: reject! isMixMsg()=" + MsgExtKt.y(msgRecord) + " isRoam()=" + MsgExtKt.R(msgRecord) + ", isSendSuccess()=" + MsgExtKt.U(msgRecord);
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.ArticlePageNavigateHelper", 1, (String) it5.next(), null);
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        String str2 = "jumpToArticleDetailPage: msgItem is not a GuildMsgItem " + msgItem;
        if (str2 instanceof String) {
            bVar3.a().add(str2);
        }
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("Guild.ArticlePageNavigateHelper", 1, (String) it6.next(), null);
        }
    }

    private final b e() {
        return new b(new Function1<MsgIntent, Unit>() { // from class: com.tencent.qqguild.base.aio.helpers.ArticlePageNavigateHelper$newMessageEventHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgIntent msgIntent) {
                invoke2(msgIntent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MsgIntent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof GuildMsgListIntent.GuildMsgItemContentViewClickEvent) {
                    com.tencent.aio.data.msglist.a msgItem = ((GuildMsgListIntent.GuildMsgItemContentViewClickEvent) event).getMsgItem();
                    GuildMsgItem guildMsgItem = msgItem instanceof GuildMsgItem ? (GuildMsgItem) msgItem : null;
                    if (guildMsgItem != null && guildMsgItem.isMixMsg()) {
                        ArticlePageNavigateHelper.this.c(guildMsgItem);
                    }
                }
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 22;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "Guild.ArticlePageNavigateHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.aioContext = param.a();
        b().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), this.messageEventHandler);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        b().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), this.messageEventHandler);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
