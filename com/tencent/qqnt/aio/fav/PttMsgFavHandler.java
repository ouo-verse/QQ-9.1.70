package com.tencent.qqnt.aio.fav;

import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.aio.fav.d;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/fav/PttMsgFavHandler;", "Lcom/tencent/qqnt/aio/fav/d;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/MessageForPtt;", "pttMsg", "", "c", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "selectedText", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PttMsgFavHandler implements d {
    static IPatchRedirector $redirector_;

    public PttMsgFavHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [T, com.tencent.mobileqq.proavatar.QQProAvatarDrawable] */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.tencent.mobileqq.proavatar.QQProAvatarDrawable] */
    private final void c(QQAppInterface app, Context context, MessageForPtt pttMsg) {
        String localFilePath;
        String str;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_121804349", true)) {
            localFilePath = pttMsg.getLocalFilePathWithoutReplaceSuffix();
        } else {
            localFilePath = pttMsg.getLocalFilePath();
        }
        String str2 = localFilePath;
        int i3 = pttMsg.voiceLength;
        if (i3 <= 0) {
            i3 = ((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(str2);
        }
        int i16 = i3;
        if (i16 <= 0) {
            QLog.e("NTMsgFav", 1, "ptt msg time is invalid " + i16);
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (com.tencent.biz.anonymous.a.m(pttMsg) && !pttMsg.isSend()) {
            objectRef.element = ResourcesCompat.getDrawable(context.getResources(), R.drawable.f161530e21, null);
        } else {
            if (pttMsg.isSend()) {
                str = pttMsg.selfuin;
            } else {
                str = pttMsg.senderuin;
            }
            if (str != null) {
                ?? qQProAvatarDrawable = new QQProAvatarDrawable();
                objectRef.element = qQProAvatarDrawable;
                qQProAvatarDrawable.q(context, 1, str);
            }
            if (objectRef.element == 0 && pttMsg.frienduin != null) {
                ?? qQProAvatarDrawable2 = new QQProAvatarDrawable();
                objectRef.element = qQProAvatarDrawable2;
                qQProAvatarDrawable2.q(context, 1, pttMsg.frienduin);
            }
        }
        PostUtilKt.b(new PttMsgFavHandler$addPttMsgToFav$1(context, app, pttMsg, str2, i16, objectRef));
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
        if (convertToChatMessage instanceof MessageForPtt) {
            c(app, context, (MessageForPtt) convertToChatMessage);
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
