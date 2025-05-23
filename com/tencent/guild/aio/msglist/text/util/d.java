package com.tencent.guild.aio.msglist.text.util;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J6\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002J6\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\fH\u0002J2\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J*\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\fJ*\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u001f\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", DTConstants.TAG.ELEMENT, "Landroid/widget/EditText;", "ed", "", "k", "l", "faceElement", "", "emoSize", "", "isAnim", "Lcom/tencent/mobileqq/text/ISpanRefreshCallback;", "callback", "useGuildSpan", "Landroid/text/SpannableStringBuilder;", tl.h.F, "f", "", "emoCodeStr", "flag", "j", "useGuildEmoticon", "c", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sourceType", "a", "(Ljava/lang/Integer;)Z", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f111941a = new d();

    d() {
    }

    public static /* synthetic */ CharSequence d(d dVar, FaceElement faceElement, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        if ((i16 & 8) != 0) {
            z17 = false;
        }
        return dVar.c(faceElement, i3, z16, z17);
    }

    private final SpannableStringBuilder f(FaceElement faceElement, int emoSize, boolean isAnim, ISpanRefreshCallback callback, boolean useGuildSpan) {
        int i3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        com.tencent.qqnt.msg.a aVar = com.tencent.qqnt.msg.a.f359552a;
        int c16 = aVar.c(faceElement.faceIndex);
        int b16 = aVar.b(faceElement.faceIndex);
        if (isAnim) {
            i3 = 5;
        } else {
            i3 = 3;
        }
        int i16 = i3;
        IGuildEmojiApi iGuildEmojiApi = (IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class);
        Integer num = faceElement.imageType;
        Intrinsics.checkNotNullExpressionValue(num, "faceElement.imageType");
        spannableStringBuilder.append(j(iGuildEmojiApi.parseSmallEmo(c16, b16, num.intValue()), emoSize, i16, useGuildSpan, callback));
        return spannableStringBuilder;
    }

    static /* synthetic */ SpannableStringBuilder g(d dVar, FaceElement faceElement, int i3, boolean z16, ISpanRefreshCallback iSpanRefreshCallback, boolean z17, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            iSpanRefreshCallback = null;
        }
        ISpanRefreshCallback iSpanRefreshCallback2 = iSpanRefreshCallback;
        if ((i16 & 16) != 0) {
            z17 = false;
        }
        return dVar.f(faceElement, i3, z16, iSpanRefreshCallback2, z17);
    }

    private final SpannableStringBuilder h(FaceElement faceElement, int emoSize, boolean isAnim, ISpanRefreshCallback callback, boolean useGuildSpan) {
        int i3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String convertEmoServerIdToEmoCode = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).convertEmoServerIdToEmoCode(faceElement.faceIndex, 1);
        if (isAnim) {
            i3 = 5;
        } else {
            i3 = 3;
        }
        spannableStringBuilder.append(j(convertEmoServerIdToEmoCode, emoSize, i3, useGuildSpan, callback));
        return spannableStringBuilder;
    }

    static /* synthetic */ SpannableStringBuilder i(d dVar, FaceElement faceElement, int i3, boolean z16, ISpanRefreshCallback iSpanRefreshCallback, boolean z17, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            iSpanRefreshCallback = null;
        }
        ISpanRefreshCallback iSpanRefreshCallback2 = iSpanRefreshCallback;
        if ((i16 & 16) != 0) {
            z17 = false;
        }
        return dVar.h(faceElement, i3, z16, iSpanRefreshCallback2, z17);
    }

    private final CharSequence j(CharSequence emoCodeStr, int emoSize, int flag, boolean useGuildSpan, ISpanRefreshCallback callback) {
        Integer num;
        if (useGuildSpan) {
            num = 10014;
        } else {
            num = null;
        }
        return ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(emoCodeStr, emoSize, flag, num, callback);
    }

    private final void k(FaceElement element, EditText ed5) {
        com.tencent.qqnt.msg.a aVar = com.tencent.qqnt.msg.a.f359552a;
        int c16 = aVar.c(element.faceIndex);
        int b16 = aVar.b(element.faceIndex);
        IGuildEmojiApi iGuildEmojiApi = (IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class);
        Integer num = element.imageType;
        Intrinsics.checkNotNullExpressionValue(num, "element.imageType");
        CharSequence parseSmallEmo = iGuildEmojiApi.parseSmallEmo(c16, b16, num.intValue());
        ed5.getEditableText().replace(ed5.getSelectionStart(), ed5.getSelectionEnd(), parseSmallEmo);
        ed5.requestFocus();
    }

    private final void l(FaceElement element, EditText ed5) {
        ed5.getEditableText().replace(ed5.getSelectionStart(), ed5.getSelectionEnd(), ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).convertEmoServerIdToEmoCode(element.faceIndex, 1));
        ed5.requestFocus();
    }

    public final boolean a(@Nullable Integer sourceType) {
        if (sourceType != null && 4 == sourceType.intValue()) {
            return true;
        }
        return false;
    }

    public final boolean b(@Nullable Integer sourceType) {
        if (sourceType == null || 4 != sourceType.intValue()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final CharSequence c(@NotNull FaceElement element, int emoSize, boolean isAnim, boolean useGuildEmoticon) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (a(Integer.valueOf(element.faceType))) {
            return g(this, element, emoSize, isAnim, null, useGuildEmoticon, 8, null);
        }
        if (b(Integer.valueOf(element.faceType))) {
            return i(this, element, emoSize, isAnim, null, useGuildEmoticon, 8, null);
        }
        return GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI;
    }

    @NotNull
    public final CharSequence e(@NotNull FaceElement element, int emoSize, boolean isAnim, @Nullable ISpanRefreshCallback callback) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (a(Integer.valueOf(element.faceType))) {
            return g(this, element, emoSize, isAnim, callback, false, 16, null);
        }
        if (b(Integer.valueOf(element.faceType))) {
            return i(this, element, emoSize, isAnim, callback, false, 16, null);
        }
        return GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI;
    }

    public final void m(@NotNull FaceElement element, @NotNull EditText ed5) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(ed5, "ed");
        if (a(Integer.valueOf(element.faceType))) {
            k(element, ed5);
        } else if (b(Integer.valueOf(element.faceType))) {
            l(element, ed5);
        }
    }
}
