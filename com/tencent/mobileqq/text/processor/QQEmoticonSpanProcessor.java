package com.tencent.mobileqq.text.processor;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.GuildEmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;
import com.tencent.oskplayer.contrib.ImageHashError;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class QQEmoticonSpanProcessor implements ISpanProcessor {
    static IPatchRedirector $redirector_;

    public QQEmoticonSpanProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01bc A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int doGrabEMotcation(int i3, int i16, int i17, int i18, Object obj, StringBuilder sb5, ISpanCallback iSpanCallback) {
        boolean z16;
        float f16;
        boolean z17;
        int i19;
        int singleEmoji;
        int codePointAt;
        int i26;
        boolean z18;
        boolean z19;
        int i27;
        int i28;
        boolean z26;
        int i29;
        int i36;
        int i37;
        int i38;
        boolean z27;
        int length = sb5.length();
        int i39 = 1;
        boolean z28 = false;
        if (obj != null && obj.equals(10014)) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        } catch (NullPointerException e16) {
            QLog.d(QQText.TAG, 1, e16, new Object[0]);
            f16 = 1.0f;
        }
        int i46 = (int) ((i18 * f16) + 0.5f);
        int i47 = (int) ((22.0f * f16) + 0.5f);
        int i48 = (int) ((f16 * 32.0f) + 0.5f);
        int i49 = i3;
        int i56 = i16;
        int i57 = 0;
        while (i49 < i56) {
            int codePointAt2 = sb5.codePointAt(i49);
            if ((i17 & 4) == 4) {
                z17 = i39;
            } else {
                z17 = z28;
            }
            int handleFilterColorNick = handleFilterColorNick(sb5, length, i49);
            if (handleFilterColorNick > i49) {
                i49 = handleFilterColorNick;
                z28 = false;
            } else {
                int i58 = 2;
                if ((i17 & 6) > 0 && codePointAt2 == 20 && i49 < length - 1) {
                    int i59 = i49 + 1;
                    int charAt = sb5.charAt(i59);
                    if (QQSysFaceUtil.isValidFaceId(charAt)) {
                        if (QQText.IS_FXXKED_MTK) {
                            sb5.replace(i49, i49 + 2, "##");
                        } else if (charAt == 10) {
                            sb5.setCharAt(i59, AbsQQText.RF);
                        }
                        if (z17 != 0) {
                            charAt |= Integer.MIN_VALUE;
                        }
                        iSpanCallback.addSpan(createEmoticonSpan(z16, charAt, i46, 1), i49, i49 + 2, 33);
                        i57++;
                        i49 = i59;
                        i19 = i47;
                    } else if (charAt >= 255 && (i38 = i49 + 4) < length) {
                        i19 = i47;
                        char[] cArr = new char[4];
                        cArr[0] = sb5.charAt(i38);
                        cArr[1] = sb5.charAt(i49 + 3);
                        cArr[2] = sb5.charAt(i49 + 2);
                        cArr[3] = sb5.charAt(i59);
                        int i65 = 0;
                        for (int i66 = 3; i65 < i66; i66 = 3) {
                            char c16 = cArr[i65];
                            if (c16 == '\u00fa') {
                                cArr[i65] = '\n';
                            } else if (c16 == '\u00fe') {
                                cArr[i65] = '\r';
                            }
                            i65++;
                        }
                        ISmallEmojiSpanService iSmallEmojiSpanService = (ISmallEmojiSpanService) QRoute.api(ISmallEmojiSpanService.class);
                        if (charAt == 511) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        iSpanCallback.addSpan(iSmallEmojiSpanService.createSmallEmojiSpan(cArr, i46, z17, z27), i49, i49 + 5, 33);
                        for (int i67 = 2; i67 < 5; i67++) {
                            int i68 = i49 + i67;
                            if (sb5.charAt(i68) == '\n') {
                                sb5.setCharAt(i68, AbsQQText.RF);
                            } else if (sb5.charAt(i68) == '\r') {
                                sb5.setCharAt(i68, AbsQQText.ENTER_REPLACE);
                            }
                        }
                        i57++;
                        i49 = i38;
                    } else {
                        i19 = i47;
                        int i69 = 10;
                        if (charAt == 250) {
                            if (QQText.IS_FXXKED_MTK) {
                                sb5.replace(i49, i49 + 2, "##");
                            }
                            if (z17 != 0) {
                                i69 = ImageHashError.ERROR_DECODE_FLOW;
                            }
                            iSpanCallback.addSpan(createEmoticonSpan(z16, i69, i46, 1), i49, i49 + 2, 33);
                            i57++;
                            i49 = i59;
                        }
                    }
                } else {
                    i19 = i47;
                    if ((i17 & 1) == 1) {
                        if (QQSysFaceSwitcher.f204652a.r()) {
                            if (Character.charCount(codePointAt2) == 1) {
                                singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt2);
                            } else {
                                singleEmoji = -1;
                            }
                        } else {
                            singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt2);
                        }
                        if (codePointAt2 > 65535) {
                            int i75 = i49 + 2;
                            if (length > i75) {
                                codePointAt = sb5.codePointAt(i75);
                                z18 = false;
                                boolean isSkinEmoji = EmotcationConstants.isSkinEmoji(codePointAt);
                                if (singleEmoji == -1 && !isSkinEmoji) {
                                    z19 = false;
                                } else {
                                    int i76 = singleEmoji;
                                    singleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                                    if (singleEmoji == -1) {
                                        singleEmoji = i76;
                                    }
                                    z19 = true;
                                }
                                if (singleEmoji != -1) {
                                    if (z19) {
                                        if (codePointAt2 > 65535 && length >= (i37 = i49 + 2)) {
                                            if (QQText.IS_FXXKED_MTK) {
                                                sb5.replace(i49, i37, "##");
                                            }
                                            i29 = 65535;
                                        } else {
                                            if (QQText.IS_FXXKED_MTK) {
                                                sb5.replace(i49, i49 + 1, "#");
                                            }
                                            i29 = 65535;
                                            i58 = 1;
                                        }
                                        if (codePointAt > i29 && length >= (i36 = i49 + 2)) {
                                            if (QQText.IS_FXXKED_MTK) {
                                                sb5.replace(i36, i49 + 4, "##");
                                            }
                                            i58 += 2;
                                        } else {
                                            if (QQText.IS_FXXKED_MTK) {
                                                sb5.replace(i49 + 2, i49 + 3, "#");
                                            }
                                            i58++;
                                        }
                                        if (z18) {
                                            i58++;
                                        }
                                    } else if (codePointAt2 > 65535 && length >= (i27 = i49 + 2)) {
                                        if (QQText.IS_FXXKED_MTK) {
                                            sb5.replace(i49, i27, "##");
                                        }
                                    } else {
                                        if (QQText.IS_FXXKED_MTK) {
                                            sb5.replace(i49, i49 + 1, "#");
                                        }
                                        i58 = 1;
                                    }
                                    if (i46 == i48) {
                                        i28 = i19;
                                    } else {
                                        i28 = i46;
                                    }
                                    z26 = false;
                                    iSpanCallback.addSpan(createEmoticonSpan(z16, singleEmoji, i28, 0), i49, i49 + i58, 33);
                                    i39 = 1;
                                    i49 += i58 - 1;
                                }
                            }
                            codePointAt = -1;
                            z18 = false;
                            boolean isSkinEmoji2 = EmotcationConstants.isSkinEmoji(codePointAt);
                            if (singleEmoji == -1) {
                            }
                            int i762 = singleEmoji;
                            singleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                            if (singleEmoji == -1) {
                            }
                            z19 = true;
                            if (singleEmoji != -1) {
                            }
                        } else {
                            int i77 = i49 + 1;
                            if (length > i77) {
                                codePointAt = sb5.codePointAt(i77);
                                if (codePointAt == 65039 && length > (i26 = i49 + 2)) {
                                    codePointAt = sb5.codePointAt(i26);
                                    z18 = true;
                                    boolean isSkinEmoji22 = EmotcationConstants.isSkinEmoji(codePointAt);
                                    if (singleEmoji == -1) {
                                    }
                                    int i7622 = singleEmoji;
                                    singleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                                    if (singleEmoji == -1) {
                                    }
                                    z19 = true;
                                    if (singleEmoji != -1) {
                                    }
                                }
                                z18 = false;
                                boolean isSkinEmoji222 = EmotcationConstants.isSkinEmoji(codePointAt);
                                if (singleEmoji == -1) {
                                }
                                int i76222 = singleEmoji;
                                singleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                                if (singleEmoji == -1) {
                                }
                                z19 = true;
                                if (singleEmoji != -1) {
                                }
                            }
                            codePointAt = -1;
                            z18 = false;
                            boolean isSkinEmoji2222 = EmotcationConstants.isSkinEmoji(codePointAt);
                            if (singleEmoji == -1) {
                            }
                            int i762222 = singleEmoji;
                            singleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                            if (singleEmoji == -1) {
                            }
                            z19 = true;
                            if (singleEmoji != -1) {
                            }
                        }
                        i49 += i39;
                        i56 = i16;
                        z28 = z26;
                        i47 = i19;
                    } else {
                        i39 = 1;
                        z26 = false;
                        i49 += i39;
                        i56 = i16;
                        z28 = z26;
                        i47 = i19;
                    }
                }
                i39 = 1;
                z26 = false;
                i49 += i39;
                i56 = i16;
                z28 = z26;
                i47 = i19;
            }
        }
        return i57;
    }

    private int handleFilterColorNick(StringBuilder sb5, int i3, int i16) {
        int i17;
        if (!QQSysFaceSwitcher.f204652a.k()) {
            return i16;
        }
        if (sb5.charAt(i16) == '<' && i16 < i3 - 2) {
            char charAt = sb5.charAt(i16 + 1);
            if (charAt == '$' && i16 < i3 - 3) {
                char charAt2 = sb5.charAt(i16 + 2);
                if (charAt2 != '\u00ff' && charAt2 != '\u01ff' && charAt2 != '\u00fa') {
                    if (sb5.charAt(i16 + 3) == '>') {
                        int convertToLocal = QQSysFaceUtil.convertToLocal(charAt2 & '\u00ff');
                        if (convertToLocal == 250) {
                            convertToLocal = 10;
                        }
                        if (QQSysFaceUtil.isValidFaceId(convertToLocal)) {
                            return i16 + 4;
                        }
                        return i16;
                    }
                    return i16;
                }
                if (charAt2 >= '\u00ff' && (i17 = i16 + 6) < i3) {
                    if (sb5.charAt(i17) == '>') {
                        return i16 + 7;
                    }
                    return i16;
                }
                if (charAt2 == '\u00fa') {
                    return i16 + 4;
                }
                return i16;
            }
            if ((charAt == '%' || charAt == '&') && i16 < i3 - 6) {
                return i16 + 7;
            }
            return i16;
        }
        return i16;
    }

    protected EmoticonSpan createEmoticonSpan(boolean z16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EmoticonSpan) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        if (z16) {
            return new GuildEmoticonSpan(i3, i16, i17);
        }
        return new EmoticonSpan(i3, i16, i17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public void doGrab(GrabParams grabParams, ISpanCallback iSpanCallback) {
        EmoticonSpan[] emoticonSpanArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) grabParams, (Object) iSpanCallback);
            return;
        }
        if (grabParams != null && iSpanCallback != null && !TextUtils.isEmpty(grabParams.text)) {
            StringBuilder sb5 = new StringBuilder(grabParams.text);
            int doGrabEMotcation = doGrabEMotcation(grabParams.start, grabParams.end, grabParams.flag, grabParams.emoSize, grabParams.message, sb5, iSpanCallback);
            grabParams.text = sb5.toString();
            if (doGrabEMotcation >= QQSysFaceUtil.getAnimEmoCount() && (emoticonSpanArr = (EmoticonSpan[]) iSpanCallback.acquireSpans(grabParams.start, grabParams.end, EmoticonSpan.class)) != 0) {
                for (GuildEmoticonSpan guildEmoticonSpan : emoticonSpanArr) {
                    int i3 = guildEmoticonSpan.emojiType;
                    if (i3 == 1) {
                        guildEmoticonSpan.index &= Integer.MAX_VALUE;
                    } else if (i3 == 2) {
                        ((ISmallEmojiSpan) guildEmoticonSpan).setIsAnim(false);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public int doPlain(Object obj, int i3, int i16, int i17, StringBuffer stringBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), stringBuffer)).intValue();
        }
        if (i3 < 0 || i16 < 0) {
            return 0;
        }
        EmoticonSpan emoticonSpan = (EmoticonSpan) obj;
        int i19 = emoticonSpan.emojiType;
        String str = "";
        if (i19 != 0) {
            if (i19 != 1) {
                if (i19 != 2) {
                    return 0;
                }
                String description = emoticonSpan.getDescription();
                stringBuffer.replace(i3, i16, description);
                return description.length() - (i16 - i3);
            }
            if (i17 == 4) {
                str = AbsQQText.EMOTICON_CONTENT_DESCRIPTION_SYMBOL + QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                i18 = str.length();
            } else if (i17 != 1) {
                str = QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                i18 = str.length();
            }
            stringBuffer.replace(i3, i16, str);
        } else {
            if (i17 == 3) {
                return 0;
            }
            if (i17 == 2) {
                str = AbsQQText.EMOJI_SYMBOL;
                i18 = str.length();
            } else if (i17 == 4) {
                str = QQEmojiUtil.getEmojiDescription(emoticonSpan.index & Integer.MAX_VALUE);
                i18 = str.length();
            }
            stringBuffer.replace(i3, i16, str);
        }
        return i18 - (i16 - i3);
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchGrab(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        if (i3 > 0 && ((i3 & 1) == 1 || (i3 & 6) > 0)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchPlain(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        return obj instanceof EmoticonSpan;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public /* synthetic */ void setBizSrc(String str, Object[] objArr) {
        a.a(this, str, objArr);
    }
}
