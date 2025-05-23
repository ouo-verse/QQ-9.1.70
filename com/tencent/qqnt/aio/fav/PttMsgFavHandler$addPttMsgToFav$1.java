package com.tencent.qqnt.aio.fav;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class PttMsgFavHandler$addPttMsgToFav$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQAppInterface $app;
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<Drawable> $faceDrawable;
    final /* synthetic */ String $localFilePath;
    final /* synthetic */ MessageForPtt $pttMsg;
    final /* synthetic */ int $time;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PttMsgFavHandler$addPttMsgToFav$1(Context context, QQAppInterface qQAppInterface, MessageForPtt messageForPtt, String str, int i3, Ref.ObjectRef<Drawable> objectRef) {
        super(0);
        this.$context = context;
        this.$app = qQAppInterface;
        this.$pttMsg = messageForPtt;
        this.$localFilePath = str;
        this.$time = i3;
        this.$faceDrawable = objectRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, messageForPtt, str, Integer.valueOf(i3), objectRef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQAppInterface app, MessageForPtt pttMsg, Context context, String str, int i3, String str2) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(pttMsg, "$pttMsg");
        Intrinsics.checkNotNullParameter(context, "$context");
        cooperation.qqfav.d.b(app, 6, 0, pttMsg.istroop);
        QfavBuilder.X(str, i3, str2).R(app, pttMsg).j(context, app.getAccount());
        cooperation.qqfav.d.d(app, "User_AddFav", 4, 0, 6, !TextUtils.isEmpty(str2) ? 1 : 0, "", "");
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
        final Context context = this.$context;
        final QQAppInterface qQAppInterface = this.$app;
        final MessageForPtt messageForPtt = this.$pttMsg;
        cooperation.qqfav.widget.d dVar = new cooperation.qqfav.widget.d(context, qQAppInterface, messageForPtt.voiceType, new d.a() { // from class: com.tencent.qqnt.aio.fav.i
            @Override // cooperation.qqfav.widget.d.a
            public final void a(String str, int i3, String str2) {
                PttMsgFavHandler$addPttMsgToFav$1.b(QQAppInterface.this, messageForPtt, context, str, i3, str2);
            }
        });
        if (dVar.N(this.$localFilePath, this.$time, this.$faceDrawable.element)) {
            QLog.i("NTMsgFav", 1, "addPttMsgToFav showDialog");
            dVar.show();
        } else {
            QLog.e("NTMsgFav", 1, "addPttMsgToFav fail");
            QfavUtil.Q(this.$context, R.string.b3o, 1);
        }
        PttInfoCollector.reportLongPressPtt(1);
    }
}
