package com.tencent.qqnt.aio.fav;

import android.content.Context;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.activity.aio.item.o;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.aio.fav.d;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qqfav.QfavBuilder;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0012H\u0002J*\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/fav/MixMsgFavHandler;", "Lcom/tencent/qqnt/aio/fav/d;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "g", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "selectedText", "", "f", "Lcom/tencent/mobileqq/data/MessageForPic;", "e", "c", "Lcom/tencent/mobileqq/data/MessageForMixedMsg;", "d", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MixMsgFavHandler implements d {
    static IPatchRedirector $redirector_;

    public MixMsgFavHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(QQAppInterface app, Context context, MessageForPic message) {
        QLog.i("NTMsgFav", 1, "addFlashPicMsgToFav");
        ChatMessage n3 = NtMultiFavUtils.f349920a.n(app, message);
        if (n3 instanceof MessageForText) {
            f(app, context, n3, n3.f203106msg);
        }
    }

    private final void d(final QQAppInterface app, final Context context, MessageForMixedMsg message) {
        QLog.i("NTMsgFav", 1, "addMixMsgToFav");
        final QfavBuilder R = QfavBuilder.g0(message).R(app, message);
        PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.MixMsgFavHandler$addMixMsgToFav$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQAppInterface $app;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.$app = app;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QfavBuilder.this, context, app);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QfavBuilder.this.j(this.$context, this.$app.getAccount());
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        cooperation.qqfav.d.b(app, 4, 0, message.istroop);
    }

    private final void e(final QQAppInterface app, final Context context, MessageForPic message) {
        QLog.i("NTMsgFav", 1, "addPicMsgToFav");
        final QfavBuilder R = QfavBuilder.d0(message).R(app, message);
        PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.MixMsgFavHandler$addPicMsgToFav$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQAppInterface $app;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.$app = app;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QfavBuilder.this, context, app);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QfavBuilder.this.j(this.$context, this.$app.getAccount());
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        cooperation.qqfav.d.e(app, 6, 3);
        cooperation.qqfav.d.b(app, 2, 0, message.istroop);
    }

    private final void f(final QQAppInterface app, final Context context, MessageRecord message, String selectedText) {
        boolean z16;
        QLog.i("NTMsgFav", 1, "addTextMsgToFav");
        String b16 = o.b(selectedText, true);
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("NTMsgFav", 1, "text is null");
            return;
        }
        final QfavBuilder R = QfavBuilder.k0(null, b16).R(app, message);
        PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.MixMsgFavHandler$addTextMsgToFav$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQAppInterface $app;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.$app = app;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QfavBuilder.this, context, app);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QfavBuilder.this.j(this.$context, this.$app.getAccount());
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        cooperation.qqfav.d.e(app, 6, 1);
    }

    private final String g(AIOMsgItem msgItem) {
        HashMap<Integer, CharSequence> textMapFromMsgItem;
        Collection<CharSequence> values;
        Object firstOrNull;
        if (com.tencent.mobileqq.aio.utils.d.f0(msgItem)) {
            return com.tencent.mobileqq.aio.utils.d.n(msgItem);
        }
        if (com.tencent.mobileqq.aio.utils.d.Z(msgItem)) {
            CharSequence textFromMsgItem = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getTextFromMsgItem(msgItem);
            if (textFromMsgItem != null) {
                return textFromMsgItem.toString();
            }
        } else if (com.tencent.mobileqq.aio.utils.d.E(msgItem) && (textMapFromMsgItem = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getTextMapFromMsgItem(msgItem)) != null && (values = textMapFromMsgItem.values()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(values);
            CharSequence charSequence = (CharSequence) firstOrNull;
            if (charSequence != null) {
                return charSequence.toString();
            }
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.fav.d
    public void a(@NotNull QQAppInterface app, @NotNull Context context, @NotNull AIOMsgItem msgItem, @Nullable CharSequence selectedText) {
        String g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, context, msgItem, selectedText);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(app, msgItem.getMsgRecord());
        if (convertToChatMessage instanceof MessageForText) {
            if (selectedText == null || (g16 = selectedText.toString()) == null) {
                g16 = g(msgItem);
            }
            f(app, context, convertToChatMessage, g16);
            return;
        }
        if (convertToChatMessage instanceof MessageForPic) {
            if (com.tencent.mobileqq.aio.utils.d.y(msgItem)) {
                c(app, context, (MessageForPic) convertToChatMessage);
                return;
            } else {
                e(app, context, (MessageForPic) convertToChatMessage);
                return;
            }
        }
        if (convertToChatMessage instanceof MessageForAniSticker) {
            f(app, context, convertToChatMessage, ((MessageForAniSticker) convertToChatMessage).getSummaryMsg());
            return;
        }
        if (convertToChatMessage instanceof MessageForMixedMsg) {
            if (selectedText != null && selectedText.length() != 0) {
                z16 = false;
            }
            if (z16) {
                d(app, context, (MessageForMixedMsg) convertToChatMessage);
            } else {
                f(app, context, convertToChatMessage, selectedText.toString());
            }
        }
    }

    @Override // com.tencent.qqnt.aio.fav.d
    public boolean b(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord)).booleanValue();
        }
        return d.a.a(this, msgRecord);
    }
}
