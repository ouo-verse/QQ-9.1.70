package com.tencent.qqnt.aio.nick;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.c;
import com.tencent.mobileqq.text.processor.ISpanCallback;
import com.tencent.mobileqq.text.processor.ISpanProcessor;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqnt.chats.view.api.ISummaryApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J<\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001c\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J4\u0010\u0019\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u001aj\b\u0012\u0004\u0012\u00020\u0013`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001aj\b\u0012\u0004\u0012\u00020\u001e`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/nick/b;", "Lcom/tencent/mobileqq/text/processor/ISpanProcessor;", "", "start", "end", "bound", WadlProxyConsts.FLAGS, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "text", "Lcom/tencent/mobileqq/text/processor/ISpanCallback;", "callback", "", "a", "", "matchGrab", "Lcom/tencent/mobileqq/text/GrabParams;", "params", "doGrab", "", TtmlNode.TAG_SPAN, "matchPlain", "flag", "Ljava/lang/StringBuffer;", "sb", "doPlain", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mSpans", "Lcom/tencent/mobileqq/text/c$a;", "b", "mInfos", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b implements ISpanProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Object> mSpans;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<c.a> mInfos;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSpans = new ArrayList<>();
            this.mInfos = new ArrayList<>();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
    
        r12 = r4 + 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
    
        if (r12 >= r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
    
        if (r22.charAt(r12) != '>') goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
    
        r10 = new char[3];
        r10[0] = r22.charAt(r4 + 3);
        r10[1] = r22.charAt(r4 + 4);
        r10[2] = (char) (r22.charAt(r4 + 5) & '\u00ff');
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ce, code lost:
    
        if (r9 >= 3) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d0, code lost:
    
        r12 = r10[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
    
        if (r12 != '\u00fa') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d4, code lost:
    
        r10[r9] = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d9, code lost:
    
        if (r12 != '\u00fe') goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00db, code lost:
    
        r10[r9] = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e1, code lost:
    
        r9 = (com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e9, code lost:
    
        if (r11 != '\u01ff') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00eb, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
    
        r6 = r9.createSmallEmojiSpan(r10, r20, true, r12);
        r9 = r4 + 7;
        r23.addSpan(r6, r4, r9, 33);
        r6 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fb, code lost:
    
        if (r6 >= 5) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fd, code lost:
    
        r10 = r4 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0105, code lost:
    
        if (r22.charAt(r10) != '\n') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0107, code lost:
    
        r22.setCharAt(r10, com.tencent.mobileqq.text.AbsQQText.RF);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0114, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010f, code lost:
    
        if (r22.charAt(r10) != '\r') goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0111, code lost:
    
        r22.setCharAt(r10, com.tencent.mobileqq.text.AbsQQText.ENTER_REPLACE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ed, code lost:
    
        r12 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(int start, int end, int bound, int flags, StringBuilder text, ISpanCallback callback) {
        int i3;
        int i16;
        boolean z16;
        int i17;
        int i18;
        boolean z17;
        int length = text.length();
        if (((ISummaryApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ISummaryApi.class)).isSupportSummaryNickEmojiAnimation()) {
            if ((flags & 4) == 4) {
                z17 = true;
            } else {
                z17 = false;
            }
            i16 = end;
            z16 = z17;
            i3 = start;
        } else {
            i3 = start;
            i16 = end;
            z16 = false;
        }
        while (i3 < i16) {
            if (text.charAt(i3) == '<' && i3 < length - 2) {
                int i19 = i3 + 1;
                char charAt = text.charAt(i19);
                if (charAt == '$' && i3 < length - 3) {
                    int i26 = i3 + 2;
                    char charAt2 = text.charAt(i26);
                    boolean z18 = QQText.IS_FXXKED_MTK;
                    if (z18) {
                        text.replace(i19, i3 + 3, "##");
                    } else if (charAt2 == '\n') {
                        text.setCharAt(i26, AbsQQText.RF);
                    }
                    if (charAt2 != '\u00ff' && charAt2 != '\u01ff' && charAt2 != '\u00fa') {
                        if (text.charAt(i3 + 3) == '>') {
                            int convertToLocal = QQSysFaceUtil.convertToLocal(charAt2 & '\u00ff');
                            if (convertToLocal == 250) {
                                convertToLocal = 10;
                            }
                            if (QQSysFaceUtil.isValidFaceId(convertToLocal)) {
                                if (z16) {
                                    convertToLocal |= Integer.MIN_VALUE;
                                }
                                EmoticonSpan emoticonSpan = new EmoticonSpan(convertToLocal, bound, 1);
                                i18 = i3 + 4;
                                callback.addSpan(emoticonSpan, i3, i18, 33);
                                i3 = i18;
                            }
                        }
                    } else if (charAt2 == '\u00fa') {
                        if (z18) {
                            text.replace(i19, i3 + 3, "##");
                        }
                        int i27 = i3 + 4;
                        callback.addSpan(new EmoticonSpan(10, bound, 1), i3, i27, 33);
                        i3 = i27;
                    }
                } else if ((charAt == '%' || charAt == '&') && i3 < length - 6) {
                    int charAt3 = (text.charAt(i3 + 2) << 24) + 0 + ((text.charAt(i3 + 3) << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) + ((text.charAt(i3 + 4) << '\b') & 65280) + (text.charAt(i3 + 5) & '\u00ff');
                    if (charAt == '&') {
                        i17 = 2;
                    } else {
                        i17 = 3;
                    }
                    com.tencent.mobileqq.vas.i iVar = new com.tencent.mobileqq.vas.i(i17, charAt3);
                    i18 = i3 + 7;
                    callback.addSpan(iVar, i3, i18, 33);
                    i3 = i18;
                }
            }
            i3++;
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public void doGrab(@Nullable GrabParams params, @Nullable ISpanCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) params, (Object) callback);
            return;
        }
        if (params != null && callback != null && !TextUtils.isEmpty(params.text)) {
            StringBuilder sb5 = new StringBuilder(params.text);
            a(params.start, params.end, ViewUtils.dpToPx(params.emoSize), params.flag, sb5, callback);
            params.text = sb5.toString();
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public int doPlain(@Nullable Object span, int start, int end, int flag, @Nullable StringBuffer sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, span, Integer.valueOf(start), Integer.valueOf(end), Integer.valueOf(flag), sb5)).intValue();
        }
        if (start < 0 || end < 0) {
            return 0;
        }
        String EMOJI_SYMBOL = "";
        if (span instanceof EmoticonSpan) {
            EmoticonSpan emoticonSpan = (EmoticonSpan) span;
            int i16 = emoticonSpan.emojiType;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        return 0;
                    }
                    if (flag == 2) {
                        EMOJI_SYMBOL = emoticonSpan.getDescription();
                        Intrinsics.checkNotNullExpressionValue(EMOJI_SYMBOL, "emoSpan.description");
                    }
                    Intrinsics.checkNotNull(sb5);
                    sb5.replace(start, end, EMOJI_SYMBOL);
                    return EMOJI_SYMBOL.length() - (end - start);
                }
                if (flag != 1) {
                    EMOJI_SYMBOL = QQSysFaceUtil.getFaceDescription(emoticonSpan.index & Integer.MAX_VALUE);
                    Intrinsics.checkNotNullExpressionValue(EMOJI_SYMBOL, "getFaceDescription(Emoti\u2026.inv() and emoSpan.index)");
                    i3 = EMOJI_SYMBOL.length();
                }
                Intrinsics.checkNotNull(sb5);
                sb5.replace(start, end, EMOJI_SYMBOL);
            } else {
                if (flag == 2) {
                    EMOJI_SYMBOL = AbsQQText.EMOJI_SYMBOL;
                    Intrinsics.checkNotNullExpressionValue(EMOJI_SYMBOL, "EMOJI_SYMBOL");
                    i3 = EMOJI_SYMBOL.length();
                }
                Intrinsics.checkNotNull(sb5);
                sb5.replace(start, end, EMOJI_SYMBOL);
            }
            return i3 - (end - start);
        }
        if (!(span instanceof com.tencent.mobileqq.vas.i)) {
            return 0;
        }
        Intrinsics.checkNotNull(sb5);
        sb5.replace(start, end, "");
        return 0 - (end - start);
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchGrab(int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, flags)).booleanValue();
        }
        if (flags > 0 && (flags & 16) == 16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchPlain(@Nullable Object span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, span)).booleanValue();
        }
        if (!(span instanceof EmoticonSpan) && !(span instanceof com.tencent.mobileqq.vas.i)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public /* synthetic */ void setBizSrc(String str, Object[] objArr) {
        com.tencent.mobileqq.text.processor.a.a(this, str, objArr);
    }
}
