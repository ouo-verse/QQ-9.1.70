package com.tencent.qqnt.aio.fav;

import android.content.Context;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.aio.fav.d;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qqfav.QfavBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/fav/MultiForwardMsgFavHandler;", "Lcom/tencent/qqnt/aio/fav/d;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/MessageForStructing;", "message", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "c", "", "selectedText", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MultiForwardMsgFavHandler implements d {
    static IPatchRedirector $redirector_;

    public MultiForwardMsgFavHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(final QQAppInterface app, final Context context, MessageForStructing message, AIOMsgItem msgItem) {
        List listOf;
        QLog.i("NTMsgFav", 1, "addMultiForwardMsgToFav");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msgItem);
        final QfavBuilder qfavBuilder = null;
        QfavBuilder c06 = QfavBuilder.c0(app, msgItem.v(), message, null, NtMultiFavUtils.l(listOf));
        if (c06 != null) {
            qfavBuilder = c06.R(app, message);
        }
        PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.MultiForwardMsgFavHandler$addMultiForwardMsgToFav$1
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
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QfavBuilder qfavBuilder2 = QfavBuilder.this;
                if (qfavBuilder2 == null) {
                    QLog.e("NTMsgFav", 1, "addMultiForwardMsgToFav favBuilder is null");
                    QQToast.makeText(this.$context, R.string.sk5, 0).show();
                    return;
                }
                QLog.i("NTMsgFav", 1, "addMultiForwardMsgToFav success = " + qfavBuilder2.j(this.$context, this.$app.getAccount()));
            }
        });
    }

    @Override // com.tencent.qqnt.aio.fav.d
    public void a(@NotNull QQAppInterface app, @NotNull Context context, @NotNull AIOMsgItem msgItem, @Nullable CharSequence selectedText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, context, msgItem, selectedText);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(app, msgItem.getMsgRecord());
        if (convertToChatMessage instanceof MessageForStructing) {
            c(app, context, (MessageForStructing) convertToChatMessage, msgItem);
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
