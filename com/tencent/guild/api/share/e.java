package com.tencent.guild.api.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.guild.api.share.IGuildForwarder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeakLimitApi;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qqguildsdk.data.eo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/api/share/e;", "Lcom/tencent/guild/api/share/IGuildForwarder;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "filePath", "", "g", "Landroid/content/Intent;", "intent", "b", "", "a", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements IGuildForwarder {
    private final boolean g(Contact contact, String filePath) {
        boolean isNeedInterceptQrCode = ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptQrCode(contact.guildId, contact.peerUid);
        if (QLog.isColorLevel()) {
            QLog.i("GuildPhotoForwarder", 1, "guildId: " + contact.guildId + ", isNeedInterceptQrCode: " + isNeedInterceptQrCode);
        }
        if (!isNeedInterceptQrCode) {
            return true;
        }
        ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(filePath).getAbsolutePath()), (Context) BaseApplication.getContext(), 3, false);
        if (QLog.isColorLevel()) {
            QLog.i("GuildPhotoForwarder", 1, "guildId: " + contact.guildId + ", result: " + decodeQQCodeFromFile);
        }
        if (decodeQQCodeFromFile == null || (!decodeQQCodeFromFile.l() && !decodeQQCodeFromFile.j())) {
            return true;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.share.d
            @Override // java.lang.Runnable
            public final void run() {
                e.h();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    public static final void i(e this$0, Contact it, String forwardFilePath, Intent intent, int i3, String str, eo eoVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(forwardFilePath, "$forwardFilePath");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        if (eoVar != null && !eoVar.e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !this$0.g(it, forwardFilePath)) {
            return;
        }
        IGuildSpeakLimitApi iGuildSpeakLimitApi = (IGuildSpeakLimitApi) QRoute.api(IGuildSpeakLimitApi.class);
        String str2 = it.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "it.guildId");
        int speakLimitStatus = iGuildSpeakLimitApi.getSpeakLimitStatus(str2, it.peerUid);
        if (!GuildSpeakLimitStatus.INSTANCE.d(speakLimitStatus, it.getGuildId())) {
            QLog.i("GuildPhotoForwarder", 1, "[doSendMsg]. canISpeakInChannel = false. guildId: " + it.guildId + ", channelId: " + it.peerUid + ", speakStatus:" + speakLimitStatus + ", " + forwardFilePath);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.share.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.j();
                }
            });
            return;
        }
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createPicElementForGuild(forwardFilePath, false, intent.getIntExtra(AppConstants.Key.FORWARD_PIC_SUB_TYPE, 0)));
        this$0.m(intent, it, arrayList);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? stringExtra = intent.getStringExtra(IGuildForwardUtilsApi.EXTRA_GUILD_SHOW_TOAST);
        objectRef.element = stringExtra;
        if (TextUtils.isEmpty((CharSequence) stringExtra)) {
            objectRef.element = HardCodeUtil.qqStr(R.string.f142790kb);
        }
        if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.share.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.k(Ref.ObjectRef.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        QQToastUtil.showQQToast(1, HardCodeUtil.qqStr(R.string.f142760k9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Ref.ObjectRef toastMsg) {
        Intrinsics.checkNotNullParameter(toastMsg, "$toastMsg");
        QQToastUtil.showQQToast(2, (String) toastMsg.element);
    }

    @Override // com.tencent.guild.api.share.IGuildForwarder
    public void a(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        new g().a(intent);
    }

    @Override // com.tencent.guild.api.share.IGuildForwarder
    public boolean b(@NotNull final Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        final String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        if (stringExtra == null) {
            stringExtra = "";
        }
        final Contact l3 = l(intent);
        if (l3 == null) {
            return false;
        }
        if (!new File(stringExtra).exists()) {
            QLog.i("GuildPhotoForwarder", 1, "[doSendMsg]. file not exist! " + stringExtra);
            return false;
        }
        ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).preloadSpeakRule(l3.guildId, new wh2.f() { // from class: com.tencent.guild.api.share.a
            @Override // wh2.f
            public final void a(int i3, String str, eo eoVar) {
                e.i(e.this, l3, stringExtra, intent, i3, str, eoVar);
            }
        });
        intent.putExtra("is_need_show_toast", false);
        return true;
    }

    @Nullable
    public Contact l(@NotNull Intent intent) {
        return IGuildForwarder.DefaultImpls.a(this, intent);
    }

    public void m(@NotNull Intent intent, @NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList) {
        IGuildForwarder.DefaultImpls.b(this, intent, contact, arrayList);
    }
}
