package com.tencent.mobileqq.text.processor;

import android.text.Spanned;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.GuildEmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b implements ITextProcessor {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.text.processor.ITextProcessor
    public void doSubSequence(int i3, int i16, StringBuilder sb5, Spanned spanned) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), sb5, spanned);
            return;
        }
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spanned.getSpans(i3, i16, EmoticonSpan.class);
        if (i16 - i3 > 0) {
            for (GuildEmoticonSpan guildEmoticonSpan : emoticonSpanArr) {
                int spanStart = spanned.getSpanStart(guildEmoticonSpan);
                int spanEnd = spanned.getSpanEnd(guildEmoticonSpan);
                if (spanStart < i3) {
                    spanStart = i3;
                }
                if (spanEnd > i16) {
                    spanEnd = i16;
                }
                int i17 = guildEmoticonSpan.emojiType;
                if (i17 != 0) {
                    if (i17 != 1) {
                        if (i17 == 2) {
                            ISmallEmojiSpan iSmallEmojiSpan = (ISmallEmojiSpan) guildEmoticonSpan;
                            char[] b16 = com.tencent.qqnt.emotion.utils.a.b(iSmallEmojiSpan.getEpId(), iSmallEmojiSpan.getEId());
                            sb5.replace(spanStart - i3, spanEnd - i3, String.valueOf(new char[]{20, b16[3], b16[2], b16[1], b16[0]}));
                        }
                    } else {
                        sb5.replace(spanStart - i3, spanEnd - i3, com.tencent.qqnt.emotion.text.c.c(guildEmoticonSpan.index));
                    }
                } else {
                    try {
                        sb5.replace(spanStart - i3, spanEnd - i3, com.tencent.qqnt.emotion.text.c.a(guildEmoticonSpan.index));
                    } catch (Exception e16) {
                        QLog.e("QQEmoticonTextProcessor", 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ITextProcessor
    public void doToPlain(int i3, StringBuffer stringBuffer, Spanned spanned) {
        int i16;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), stringBuffer, spanned);
            return;
        }
        String str = AbsQQText.EMOJI_SYMBOL;
        int length2 = str.length();
        int i17 = 0;
        for (EmoticonSpan emoticonSpan : (EmoticonSpan[]) spanned.getSpans(0, i3, EmoticonSpan.class)) {
            int spanStart = spanned.getSpanStart(emoticonSpan);
            int spanEnd = spanned.getSpanEnd(emoticonSpan);
            int i18 = emoticonSpan.emojiType;
            if (i18 != 0) {
                if (i18 != 1) {
                    if (i18 == 2) {
                        String description = emoticonSpan.getDescription();
                        stringBuffer.replace(spanStart + i17, spanEnd + i17, description);
                        length = description.length();
                    }
                } else {
                    String faceDescription = QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                    stringBuffer.replace(spanStart + i17, spanEnd + i17, faceDescription);
                    length = faceDescription.length();
                }
                i16 = length - (spanEnd - spanStart);
            } else {
                stringBuffer.replace(spanStart + i17, spanEnd + i17, str);
                i16 = length2 - (spanEnd - spanStart);
            }
            i17 += i16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.text.processor.ITextProcessor
    public void doToString(int i3, StringBuilder sb5, Spanned spanned) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), sb5, spanned);
            return;
        }
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spanned.getSpans(0, i3, EmoticonSpan.class);
        int length = sb5.length();
        for (GuildEmoticonSpan guildEmoticonSpan : emoticonSpanArr) {
            int spanStart = spanned.getSpanStart(guildEmoticonSpan);
            int spanEnd = spanned.getSpanEnd(guildEmoticonSpan);
            if (spanStart < length && spanEnd <= length) {
                int i16 = guildEmoticonSpan.emojiType;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            ISmallEmojiSpan iSmallEmojiSpan = (ISmallEmojiSpan) guildEmoticonSpan;
                            char[] b16 = com.tencent.qqnt.emotion.utils.a.b(iSmallEmojiSpan.getEpId(), iSmallEmojiSpan.getEId());
                            sb5.replace(spanStart, spanEnd, String.valueOf(new char[]{20, b16[3], b16[2], b16[1], b16[0]}));
                            if (QLog.isColorLevel()) {
                                QLog.d("QQEmoticonTextProcessor", 2, "start:" + spanStart + ",end:" + spanEnd);
                            }
                        }
                    } else {
                        sb5.replace(spanStart, spanEnd, com.tencent.qqnt.emotion.text.c.c(guildEmoticonSpan.index));
                    }
                } else {
                    sb5.replace(spanStart, spanEnd, com.tencent.qqnt.emotion.text.c.a(guildEmoticonSpan.index));
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("QQEmoticonTextProcessor", 2, "error emo pos. start:" + spanStart + " end: " + spanEnd + " length: " + length);
            }
        }
    }
}
