package com.tencent.guild.api.share;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.guild.api.share.IGuildForwarder;
import com.tencent.guild.api.share.impl.GuildForwardUtilsApiImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import dr0.MarketSmallFaceInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/api/share/g;", "Lcom/tencent/guild/api/share/IGuildForwarder;", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "", tl.h.F, "content", "e", "", "position", "g", "f", "Landroid/content/Intent;", "intent", "b", "", "a", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g implements IGuildForwarder {
    private final ArrayList<MsgElement> e(String content) {
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        StringBuilder sb5 = new StringBuilder();
        int length = content.length();
        int i3 = -1;
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            boolean z17 = true;
            if (i16 >= length) {
                break;
            }
            if (i16 > i3) {
                if (f(content, i16)) {
                    if (sb5.length() <= 0) {
                        z17 = false;
                    }
                    if (z17) {
                        String sb6 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                        TextElement textElement = new TextElement();
                        textElement.content = sb6;
                        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(textElement));
                        sb5.delete(0, sb5.length());
                    }
                    int i17 = i16 + 1;
                    char charAt = content.charAt(i17);
                    if (charAt == '\u00fa') {
                        charAt = '\n';
                    }
                    if (QQSysFaceUtil.isValidFaceId(charAt)) {
                        int convertToServer = QQSysFaceUtil.convertToServer(charAt);
                        String desc = QQSysFaceUtil.getFaceDescription(charAt);
                        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
                        Intrinsics.checkNotNullExpressionValue(desc, "desc");
                        arrayList.add(iMsgUtilApi.createFaceElement(0, convertToServer, "0", 0, desc));
                        i3 = i17;
                    } else if (g(content, i16)) {
                        MarketSmallFaceInfo parseMarketSmallFace = ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).parseMarketSmallFace(content, i16);
                        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createFaceElement(4, parseMarketSmallFace.getFaceId(), String.valueOf(parseMarketSmallFace.getPackId()), parseMarketSmallFace.getImageType(), parseMarketSmallFace.getDsc()));
                        i3 = i16 + 4;
                    }
                } else {
                    sb5.append(content.charAt(i16));
                }
            }
            i16++;
        }
        if (sb5.length() > 0) {
            z16 = true;
        }
        if (z16) {
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
            TextElement textElement2 = new TextElement();
            textElement2.content = sb7;
            arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(textElement2));
        }
        return arrayList;
    }

    private final boolean f(String content, int position) {
        if (content.charAt(position) == 20 && position + 1 < content.length()) {
            return true;
        }
        return false;
    }

    private final boolean g(String content, int position) {
        if (f(content, position) && position + 4 < content.length()) {
            return true;
        }
        return false;
    }

    private final boolean h(String guildId, String channelId, ArrayList<MsgElement> msgElements) {
        for (MsgElement msgElement : msgElements) {
            if (msgElement.textElement != null && ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptKeyword(guildId, channelId, msgElement.textElement.content)) {
                QLog.i("GuildTextForwarder", 1, "isNeedIntercept=true. dstChannelId: " + channelId);
                ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptKeywordSendToast();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(GuildForwardUtilsApiImpl.TAG, 1, "doSendMsg. result: " + i3 + ", errMsg: " + errMsg);
    }

    @Override // com.tencent.guild.api.share.IGuildForwarder
    public void a(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Contact d16 = d(intent);
        if (d16 != null) {
            String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
            if (!TextUtils.isEmpty(stringExtra)) {
                QLog.i("GuildTextForwarder", 1, "sendComment. dstChannelId: " + d16.peerUid);
                Intrinsics.checkNotNull(stringExtra);
                ArrayList<MsgElement> e16 = e(stringExtra);
                String str = d16.guildId;
                Intrinsics.checkNotNullExpressionValue(str, "it.guildId");
                String str2 = d16.peerUid;
                Intrinsics.checkNotNullExpressionValue(str2, "it.peerUid");
                if (h(str, str2, e16)) {
                    return;
                }
                ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(d16, e16, new IOperateCallback() { // from class: com.tencent.guild.api.share.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str3) {
                        g.i(i3, str3);
                    }
                });
            }
        }
    }

    @Override // com.tencent.guild.api.share.IGuildForwarder
    public boolean b(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Contact d16 = d(intent);
        if (d16 == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_TEXT);
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.i("GuildTextForwarder", 1, "doSendMsg FAIL. forwardText is empty!");
            return false;
        }
        Intrinsics.checkNotNull(stringExtra);
        ArrayList<MsgElement> e16 = e(stringExtra);
        String str = d16.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "it.guildId");
        String str2 = d16.peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "it.peerUid");
        if (h(str, str2, e16)) {
            return false;
        }
        j(intent, d16, e16);
        return true;
    }

    @Nullable
    public Contact d(@NotNull Intent intent) {
        return IGuildForwarder.DefaultImpls.a(this, intent);
    }

    public void j(@NotNull Intent intent, @NotNull Contact contact, @NotNull ArrayList<MsgElement> arrayList) {
        IGuildForwarder.DefaultImpls.b(this, intent, contact, arrayList);
    }
}
