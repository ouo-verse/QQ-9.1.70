package com.tencent.qqnt.aio.fav;

import android.content.Context;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.activity.aio.item.o;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.aio.fav.d;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qqfav.QfavBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J*\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/fav/ReplyMsgFavHandler;", "Lcom/tencent/qqnt/aio/fav/d;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/MessageForMixedMsg;", "message", "", "c", "Lcom/tencent/mobileqq/data/MessageRecord;", "", "selectedText", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ReplyMsgFavHandler implements d {
    static IPatchRedirector $redirector_;

    public ReplyMsgFavHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(final QQAppInterface app, final Context context, MessageForMixedMsg message) {
        QLog.i("NTMsgFav", 1, "addReplyMixMsgToFav");
        final QfavBuilder R = QfavBuilder.g0(message).R(app, message);
        PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.ReplyMsgFavHandler$addMixMsgToFav$1
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

    private final void d(final QQAppInterface app, final Context context, MessageRecord message, String selectedText) {
        boolean z16;
        QLog.i("NTMsgFav", 1, "addReplyMsgToFav");
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
        PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.ReplyMsgFavHandler$addReplyMsgToFav$1
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

    @Override // com.tencent.qqnt.aio.fav.d
    public void a(@NotNull QQAppInterface app, @NotNull Context context, @NotNull AIOMsgItem msgItem, @Nullable CharSequence selectedText) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, context, msgItem, selectedText);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(app, msgItem.getMsgRecord());
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_116882957", true)) {
            if (convertToChatMessage instanceof MessageForMixedMsg) {
                if (selectedText == null || selectedText.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    c(app, context, (MessageForMixedMsg) convertToChatMessage);
                    return;
                } else {
                    d(app, context, convertToChatMessage, selectedText.toString());
                    return;
                }
            }
            return;
        }
        if (convertToChatMessage == null) {
            QLog.e("NTMsgFav", 1, "ReplyMsgFav convert message is null");
            return;
        }
        if (selectedText != null) {
            str = selectedText.toString();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            str = convertToChatMessage.f203106msg;
        }
        d(app, context, convertToChatMessage, str);
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
