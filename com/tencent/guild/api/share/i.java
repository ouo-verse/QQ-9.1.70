package com.tencent.guild.api.share;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.guild.api.share.IGuildForwarder;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.element_ext_buf_for_ui$ElementExtBufForUI;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/api/share/i;", "Lcom/tencent/guild/api/share/IGuildForwarder;", "", "forwardFilePath", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Landroid/content/Intent;", "intent", "", "d", "", "b", "a", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i implements IGuildForwarder {
    private final void d(final String forwardFilePath, final Contact contact, final Intent intent) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.api.share.h
            @Override // java.lang.Runnable
            public final void run() {
                i.e(forwardFilePath, this, intent, contact);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String forwardFilePath, i this$0, Intent intent, Contact contact) {
        Intrinsics.checkNotNullParameter(forwardFilePath, "$forwardFilePath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        MsgElement createVideoElement = ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createVideoElement(forwardFilePath, 4601, false, null);
        element_ext_buf_for_ui$ElementExtBufForUI element_ext_buf_for_ui_elementextbufforui = new element_ext_buf_for_ui$ElementExtBufForUI();
        element_ext_buf_for_ui_elementextbufforui.mergeFrom(createVideoElement.extBufForUI);
        ((IGuildVideoApi) QRoute.api(IGuildVideoApi.class)).initVideoElement(createVideoElement, element_ext_buf_for_ui_elementextbufforui);
        ((IGuildVideoApi) QRoute.api(IGuildVideoApi.class)).copyVideoToNTDIR(createVideoElement);
        ((IGuildVideoApi) QRoute.api(IGuildVideoApi.class)).copyThumbPicToNTDIR(createVideoElement);
        arrayList.add(createVideoElement);
        QLog.i("GuildVideoForwarder", 1, "doSendMsg. type:video. filePath: " + forwardFilePath);
        this$0.g(intent, contact, arrayList);
    }

    @Override // com.tencent.guild.api.share.IGuildForwarder
    public void a(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        new g().a(intent);
    }

    @Override // com.tencent.guild.api.share.IGuildForwarder
    public boolean b(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Contact f16 = f(intent);
        if (f16 != null) {
            String stringExtra = intent.getStringExtra("file_send_path");
            String str = "";
            if (stringExtra == null) {
                stringExtra = "";
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(Sh\u2026nts.FILE_SEND_PATH) ?: \"\"");
            if (TextUtils.isEmpty(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("file_name");
                if (stringExtra2 != null) {
                    Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(Sh\u2026onstants.FILE_NAME) ?: \"\"");
                    str = stringExtra2;
                }
                stringExtra = str;
            }
            if (new File(stringExtra).exists()) {
                d(stringExtra, f16, intent);
                return true;
            }
            QLog.i("GuildVideoForwarder", 1, "[doSendMsg] File not exist! filePath: " + stringExtra);
            return false;
        }
        return false;
    }

    @Nullable
    public Contact f(@NotNull Intent intent) {
        return IGuildForwarder.DefaultImpls.a(this, intent);
    }

    public void g(@NotNull Intent intent, @NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList) {
        IGuildForwarder.DefaultImpls.b(this, intent, contact, arrayList);
    }
}
