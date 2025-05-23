package com.tencent.qqnt.aio.fav;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.fav.d;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/fav/c;", "Lcom/tencent/qqnt/aio/fav/d;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "e", "", "selectedText", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c implements d {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(final QQAppInterface app, final Context context, final AIOMsgItem msgItem) {
        QLog.i("NTMsgFav", 1, "addFileMsgToFav");
        if (msgItem.q0() != msgItem.getMsgRecord().msgId) {
            Contact contact = new Contact(msgItem.p0(), msgItem.r0(), "");
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.getMsgsIncludeSelf(contact, msgItem.q0(), 1, true, new IMsgOperateCallback() { // from class: com.tencent.qqnt.aio.fav.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String str, ArrayList arrayList) {
                        c.f(QQAppInterface.this, context, msgItem, i3, str, arrayList);
                    }
                });
                return;
            }
            return;
        }
        QfavBuilder.Y().y(app, context, msgItem, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(QQAppInterface app, Context context, AIOMsgItem msgItem, int i3, String str, ArrayList msgList) {
        boolean z16;
        Object orNull;
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        boolean z17 = true;
        if (msgList != null && !msgList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.i("NTMsgFav", 1, "getSingleMsg onResult result:" + i3 + " errMsg:" + str + ", msgListEmpty:" + z16);
        if (i3 == 0) {
            if (msgList != null && !msgList.isEmpty()) {
                z17 = false;
            }
            if (!z17) {
                Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
                orNull = CollectionsKt___CollectionsKt.getOrNull(msgList, 0);
                QfavBuilder.Y().y(app, context, msgItem, (MsgRecord) orNull);
                return;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.fav.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        QQToast.makeText(BaseApplication.getContext(), R.string.b3o, 0).show();
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
        e(app, context, msgItem);
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
