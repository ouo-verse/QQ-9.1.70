package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/h;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/e;", "", "id", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "c", "message", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "a", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "getHeader", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "d", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "b", "()Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "liveMessageData", "e", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsg", "f", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "msgHeader", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveMessageData liveMessageData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$TimMsgBody timMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    public h(@NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveMessageData);
        } else {
            this.liveMessageData = liveMessageData;
            this.msgHeader = new i();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.e
    @Nullable
    public MessageOuterClass$TimMsgBody a() {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MessageOuterClass$TimMsgBody) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.timMsg == null) {
            MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = null;
            try {
                ArrayList<LiveMessageData.ExtData> arrayList = this.liveMessageData.msgContent.mExtDatas;
                Intrinsics.checkNotNullExpressionValue(arrayList, "liveMessageData.msgContent.mExtDatas");
                Iterator<T> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((LiveMessageData.ExtData) obj).mId == 100001) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                LiveMessageData.ExtData extData = (LiveMessageData.ExtData) obj;
                if (extData != null) {
                    messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody().mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(extData.mValue, 2));
                }
            } catch (InvalidProtocolBufferMicroException unused) {
            }
            this.timMsg = messageOuterClass$TimMsgBody;
        }
        return this.timMsg;
    }

    @NotNull
    public final LiveMessageData b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveMessageData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.liveMessageData;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.e
    @NotNull
    public LiveMessageData.SpeakerInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveMessageData.SpeakerInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LiveMessageData.SpeakerInfo speakerInfo = this.liveMessageData.mSpeakerInfo;
        Intrinsics.checkNotNullExpressionValue(speakerInfo, "liveMessageData.mSpeakerInfo");
        return speakerInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    @Nullable
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (i) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.msgHeader;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.e
    @NotNull
    public String id() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = this.liveMessageData.mMessageId;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.e
    @NotNull
    public String message() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Intrinsics.checkNotNullExpressionValue(this.liveMessageData.msgContent.mMsgElements, "liveMessageData.msgContent.mMsgElements");
        if (!r0.isEmpty()) {
            String str = this.liveMessageData.msgContent.mMsgElements.get(0).mTextMsg.strText;
            Intrinsics.checkNotNullExpressionValue(str, "liveMessageData.msgConte\u2026ments[0].mTextMsg.strText");
            return str;
        }
        return "";
    }
}
