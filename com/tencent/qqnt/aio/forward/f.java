package com.tencent.qqnt.aio.forward;

import android.content.Intent;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsg2TextUtil;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/forward/f;", "Lcom/tencent/qqnt/aio/forward/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Landroid/content/Intent;", "intent", "", "f", "c", "e", "b", "d", "Lcom/tencent/aio/data/AIOContact;", "contact", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/forward/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.forward.f$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(AIOMsgItem msgItem, Intent intent) {
        FaceElement faceElement;
        intent.putExtra("forward_type", 48);
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(6);
        if (firstTypeElement != null && (faceElement = firstTypeElement.faceElement) != null) {
            int convertToLocal = QQSysFaceUtil.convertToLocal(faceElement.faceIndex);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, QQSysFaceUtil.getFaceString(convertToLocal));
            intent.putExtra(AppConstants.Key.FORWARD_EXTRA, convertToLocal);
            return true;
        }
        return false;
    }

    private final boolean c(AIOMsgItem msgItem, Intent intent) {
        intent.putExtra("k_dataline", false);
        intent.putExtra(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, ((IMsg2TextUtil) QRoute.api(IMsg2TextUtil.class)).getMsgForwardText(msgItem));
        return true;
    }

    private final boolean d(AIOMsgItem msgItem, Intent intent) {
        intent.putExtra("forward_type", -5);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, ((IMsg2TextUtil) QRoute.api(IMsg2TextUtil.class)).getMsgForwardText(msgItem));
        return true;
    }

    private final boolean e(AIOMsgItem msgItem, Intent intent) {
        PicElement picElement;
        String str;
        String str2;
        intent.putExtra("forward_type", 1);
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(2);
        if (firstTypeElement == null || (picElement = firstTypeElement.picElement) == null) {
            return false;
        }
        String a16 = aj.a(picElement);
        Iterator<T> it = aj.c(picElement).iterator();
        while (true) {
            if (it.hasNext()) {
                str = (String) it.next();
                if (k.f349976a.a(str)) {
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (a16 != null && FileManagerUtil.getFileType(a16) != 0) {
            if (new File(a16).exists()) {
                str2 = a16 + ".jpg";
            } else {
                str2 = ((Object) str) + ".jpg";
            }
            intent.putExtra("add_file_suffix", str2);
        }
        QLog.d("MixMsgForwardHandler", 1, "buildPicIntent thumbPath=" + ((Object) str) + ", sourcePath=" + a16);
        if (str == null && a16 == null) {
            return false;
        }
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, a16);
        intent.putExtra(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
        return true;
    }

    private final boolean f(AIOMsgItem msgItem, Intent intent) {
        intent.putExtra("forward_type", -1);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, ((IMsg2TextUtil) QRoute.api(IMsg2TextUtil.class)).getMsgForwardText(msgItem));
        return true;
    }

    @Override // com.tencent.qqnt.aio.forward.c
    public boolean a(@NotNull AIOMsgItem msgItem, @NotNull AIOContact contact, @NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, msgItem, contact, intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (com.tencent.mobileqq.aio.utils.d.q(msgItem)) {
            return b(msgItem, intent);
        }
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem)) {
            return e(msgItem, intent);
        }
        if (com.tencent.mobileqq.aio.utils.d.Z(msgItem)) {
            return f(msgItem, intent);
        }
        if (com.tencent.mobileqq.aio.utils.d.G(msgItem.getMsgRecord())) {
            return c(msgItem, intent);
        }
        return d(msgItem, intent);
    }
}
