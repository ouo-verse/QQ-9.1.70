package com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler;

import android.net.Uri;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/clickhandler/a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/AIOInlineBoardClickHandler;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "b", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final C7305a f191047a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/clickhandler/a$a;", "", "", "AUTHORITY", "Ljava/lang/String;", "PARAM_ANCHOR", "PARAM_CMD", "PARAM_ENTER", "PARAM_REPLY", AEEditorConstants.PATH, "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.clickhandler.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static final class C7305a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ C7305a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        C7305a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191047a = new C7305a(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable AIOMsgItem payload) {
        InlineKeyboardButton inlineKeyboardButton;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, ctx, btnView, btnModel, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        com.tencent.aio.api.runtime.a a16 = ctx.a();
        if (a16 == null) {
            return;
        }
        Object e16 = btnModel.e();
        if (e16 instanceof InlineKeyboardButton) {
            inlineKeyboardButton = (InlineKeyboardButton) e16;
        } else {
            inlineKeyboardButton = null;
        }
        if (inlineKeyboardButton == null) {
            return;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(SchemaUtils.SCHEMA_MQQAPI).authority("aio").path("/inlinecmd").appendQueryParameter("command", btnModel.a().a()).appendQueryParameter("reply", String.valueOf(btnModel.a().e())).appendQueryParameter(BaseConstants.BROADCAST_USERSYNC_ENTER, String.valueOf(inlineKeyboardButton.enter)).appendQueryParameter("anchor", String.valueOf(inlineKeyboardButton.anchor));
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class);
        String uri = appendQueryParameter.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        iRobotServiceApi.doSchemaAction("InlineBtnAtBotClickHandler", a16, uri, new Object[]{payload});
    }
}
