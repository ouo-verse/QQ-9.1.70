package com.tencent.qqnt.emotion.text.style.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.text.a;
import com.tencent.qqnt.emotion.text.b;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.emotion.utils.c;
import com.tencent.qqnt.emotion.utils.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016J0\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J0\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/emotion/text/style/api/impl/EmojiSpanServiceImpl;", "Lcom/tencent/qqnt/emotion/text/style/api/IEmojiSpanService;", "", EmojiManagerServiceProxy.EPID, "eId", "type", "", "parseSmallEmo", "serverEmoId", "emojiType", "", "convertEmoServerIdToEmoCode", "content", "index", "", "isValidEmojiFaceId", "emoCode", "convertEmoCodeToServerId", "faceType", "faceIndex", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "isAnim", "emoSize", "createEmojiSpanText", "createSysAndEmojiSpanText", "serverId", "getFaceDescription", "startIndex", "Lcom/tencent/qqnt/emotion/data/a;", "parseMarketSmallFace", "packId", "faceId", "combineEmoIndex", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class EmojiSpanServiceImpl implements IEmojiSpanService {
    static IPatchRedirector $redirector_;

    public EmojiSpanServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    public int combineEmoIndex(int packId, int faceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(packId), Integer.valueOf(faceId))).intValue();
        }
        return a.f356677a.a(packId, faceId);
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    public int convertEmoCodeToServerId(@NotNull String emoCode, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoCode, index)).intValue();
        }
        Intrinsics.checkNotNullParameter(emoCode, "emoCode");
        if (isValidEmojiFaceId(emoCode, index)) {
            char charAt = emoCode.charAt(index + 1);
            if (charAt == '\u00fa') {
                charAt = '\n';
            }
            return c.f356686a.a(String.valueOf((int) charAt), 1);
        }
        return -1;
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    @NotNull
    public String convertEmoServerIdToEmoCode(int serverEmoId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(serverEmoId), Integer.valueOf(emojiType));
        }
        int b16 = c.f356686a.b(String.valueOf(serverEmoId), emojiType);
        if (b16 < 0) {
            QLog.i("MsgExt", 1, "convertEmoServerIdToEmoCode error: localeCode invalid");
            return "";
        }
        String a16 = r.a(emojiType, b16);
        Intrinsics.checkNotNullExpressionValue(a16, "getEmoString(emojiType, localeCode)");
        return a16;
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    @NotNull
    public CharSequence createEmojiSpanText(int faceType, int faceIndex, int imageType, boolean isAnim, int emoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(faceType), Integer.valueOf(faceIndex), Integer.valueOf(imageType), Boolean.valueOf(isAnim), Integer.valueOf(emoSize));
        }
        return b.f356678a.a(faceType, faceIndex, emoSize, isAnim, imageType, true);
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    @NotNull
    public CharSequence createSysAndEmojiSpanText(int faceType, int faceIndex, int imageType, boolean isAnim, int emoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(faceType), Integer.valueOf(faceIndex), Integer.valueOf(imageType), Boolean.valueOf(isAnim), Integer.valueOf(emoSize));
        }
        return b.f356678a.a(faceType, faceIndex, emoSize, isAnim, imageType, false);
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    @NotNull
    public String getFaceDescription(int serverId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(serverId), Integer.valueOf(emojiType));
        }
        String faceDescription = QQSysFaceUtil.getFaceDescription(c.f356686a.b(String.valueOf(serverId), emojiType));
        Intrinsics.checkNotNullExpressionValue(faceDescription, "getFaceDescription(localId)");
        return faceDescription;
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    public boolean isValidEmojiFaceId(@NotNull String content, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) content, index)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(content, "content");
        int i3 = index + 1;
        if (i3 > content.length() - 1) {
            return false;
        }
        char charAt = content.charAt(i3);
        if (charAt == '\u00fa') {
            charAt = '\n';
        }
        return QQSysFaceUtil.isValidFaceId(charAt);
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    @NotNull
    public com.tencent.qqnt.emotion.data.a parseMarketSmallFace(@NotNull String content, int startIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.emotion.data.a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) content, startIndex);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        char[] cArr = new char[4];
        cArr[3] = content.charAt(startIndex + 1);
        int i3 = 2;
        cArr[2] = content.charAt(startIndex + 2);
        cArr[1] = content.charAt(startIndex + 3);
        cArr[0] = content.charAt(startIndex + 4);
        for (int i16 = 0; i16 < 4; i16++) {
            char c16 = cArr[i16];
            if (c16 == '\u00fa') {
                cArr[i16] = '\n';
            } else if (c16 == '\u00fe') {
                cArr[i16] = '\r';
            }
        }
        int[] m3 = com.tencent.qqnt.emotion.emosm.b.m(cArr);
        char c17 = cArr[3];
        if (c17 != '\u01ff') {
            if (c17 == '\u00ff') {
                i3 = 1;
            } else {
                i3 = 0;
            }
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        String dsc = AbsQQText.SMALL_EMOJI_SYMBOL;
        if (appInterface != null) {
            IRuntimeService runtimeService = appInterface.getRuntimeService(IEmoticonManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026nstant.MAIN\n            )");
            Emoticon syncFindEmoticonById = ((IEmoticonManagerService) runtimeService).syncFindEmoticonById(Integer.toString(m3[0]), Integer.toString(m3[1]));
            if (syncFindEmoticonById != null) {
                dsc = syncFindEmoticonById.character;
            }
        }
        int i17 = m3[0];
        int i18 = m3[1];
        Intrinsics.checkNotNullExpressionValue(dsc, "dsc");
        return new com.tencent.qqnt.emotion.data.a(i17, i18, i3, dsc);
    }

    @Override // com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService
    @NotNull
    public CharSequence parseSmallEmo(int epId, int eId, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(epId), Integer.valueOf(eId), Integer.valueOf(type));
        }
        char[] o16 = com.tencent.qqnt.emotion.emosm.b.o(epId, eId, type);
        Intrinsics.checkNotNullExpressionValue(o16, "getSmallChatAryFormat(epId, eId, type)");
        return new String(o16);
    }
}
