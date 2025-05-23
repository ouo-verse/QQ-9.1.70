package com.tencent.guild.aio.util;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.EditText;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import dr0.LottieFaceInfo;
import dr0.MarketSmallFaceInfo;
import fo0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J>\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001a\u001a\u00020\u0019J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 J0\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/util/e;", "", "Ldr0/b;", "faceInfo", "Lsr0/a$b;", "d", "", "serverId", "", "isSingleLottie", "c", "", "content", "position", "j", "atType", "", "atUid", "atTinyId", "Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "atRoleInfo", "", "Lsr0/b;", "f", "k", "Lfo0/e$l;", "intent", "e", "Landroid/widget/EditText;", "editText", "a", "inputString", "Landroid/text/Spannable;", "editableText", "b", "Landroid/content/Context;", "context", "tinyId", "nickname", "", tl.h.F, "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a */
    @NotNull
    public static final e f112380a = new e();

    e() {
    }

    private final a.FaceElement c(int serverId, boolean isSingleLottie) {
        int i3 = 2;
        if (((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).isSupportLottie(serverId)) {
            LottieFaceInfo lottieEmoInfo = ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).getLottieEmoInfo(serverId);
            a.FaceElement faceElement = new a.FaceElement(0, 0, null, 0, null, null, 0, 0, null, null, 0, 2047, null);
            if (isSingleLottie) {
                i3 = 3;
            }
            faceElement.m(i3);
            faceElement.k(serverId);
            faceElement.s(lottieEmoInfo.getAniStickerType());
            faceElement.r(lottieEmoInfo.getAniStickerId());
            faceElement.q(1);
            faceElement.p(1);
            faceElement.o(lottieEmoInfo.getAniStickerPackId());
            faceElement.l(lottieEmoInfo.getText());
            return faceElement;
        }
        String emoDsc = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getEmoDsc(serverId);
        a.FaceElement faceElement2 = new a.FaceElement(0, 0, null, 0, null, null, 0, 0, null, null, 0, 2047, null);
        faceElement2.m(2);
        faceElement2.k(serverId);
        Intrinsics.checkNotNullExpressionValue(emoDsc, "emoDsc");
        faceElement2.l(emoDsc);
        return faceElement2;
    }

    private final a.FaceElement d(MarketSmallFaceInfo faceInfo) {
        a.FaceElement faceElement = new a.FaceElement(0, 0, null, 0, null, null, 0, 0, null, null, 0, 2047, null);
        faceElement.m(4);
        faceElement.k(faceInfo.getFaceId());
        faceElement.o(String.valueOf(faceInfo.getPackId()));
        faceElement.n(faceInfo.getImageType());
        faceElement.l(faceInfo.getDsc());
        faceElement.q(2);
        return faceElement;
    }

    public static /* synthetic */ List g(e eVar, String str, int i3, long j3, long j16, AtRoleInfo atRoleInfo, int i16, Object obj) {
        int i17;
        long j17;
        AtRoleInfo atRoleInfo2;
        if ((i16 & 2) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        long j18 = 0;
        if ((i16 & 4) != 0) {
            j17 = 0;
        } else {
            j17 = j3;
        }
        if ((i16 & 8) == 0) {
            j18 = j16;
        }
        if ((i16 & 16) != 0) {
            atRoleInfo2 = null;
        } else {
            atRoleInfo2 = atRoleInfo;
        }
        return eVar.f(str, i17, j17, j18, atRoleInfo2);
    }

    public static /* synthetic */ void i(e eVar, Context context, EditText editText, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = 2;
        }
        eVar.h(context, editText, str, str2, i3);
    }

    @NotNull
    public final List<e.InputSendTextIntent> a(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        String obj = editText.getText().toString();
        Editable editableText = editText.getEditableText();
        Intrinsics.checkNotNullExpressionValue(editableText, "editText.editableText");
        return b(obj, editableText);
    }

    @NotNull
    public final List<e.InputSendTextIntent> b(@NotNull String inputString, @NotNull Spannable editableText) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(inputString, "inputString");
        Intrinsics.checkNotNullParameter(editableText, "editableText");
        isBlank = StringsKt__StringsJVMKt.isBlank(inputString);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(editableText);
            if (!isBlank2) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                AtTroopMemberSpan.d(editableText, arrayList2);
                Iterator it = arrayList2.iterator();
                short s16 = 0;
                while (it.hasNext()) {
                    kp0.a aVar = (kp0.a) it.next();
                    short s17 = aVar.f412784a;
                    if (s17 > s16) {
                        String substring = inputString.substring(s16, s17);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        arrayList.add(new e.InputSendTextIntent(substring, 0, 0L, 0L, null, 30, null));
                    }
                    byte b16 = aVar.f412786c;
                    if (b16 == 0) {
                        String atMemName = aVar.f412791h;
                        long j3 = aVar.f412787d;
                        Intrinsics.checkNotNullExpressionValue(atMemName, "atMemName");
                        arrayList.add(new e.InputSendTextIntent(atMemName, 2, 0L, j3, null, 20, null));
                    } else if (b16 == 1) {
                        String atMemName2 = aVar.f412791h;
                        long j16 = aVar.f412787d;
                        Intrinsics.checkNotNullExpressionValue(atMemName2, "atMemName");
                        arrayList.add(new e.InputSendTextIntent(atMemName2, 1, 0L, j16, null, 20, null));
                    } else if (b16 == 3) {
                        String atMemName3 = aVar.f412791h;
                        long j17 = aVar.f412787d;
                        Intrinsics.checkNotNullExpressionValue(atMemName3, "atMemName");
                        arrayList.add(new e.InputSendTextIntent(atMemName3, 64, 0L, j17, null, 20, null));
                    } else if (b16 == 4) {
                        String atMemName4 = aVar.f412791h;
                        long j18 = aVar.f412787d;
                        AtRoleInfo atRoleInfo = aVar.f412792i;
                        Intrinsics.checkNotNullExpressionValue(atMemName4, "atMemName");
                        arrayList.add(new e.InputSendTextIntent(atMemName4, 8, 0L, j18, atRoleInfo, 4, null));
                    } else if (b16 == 2) {
                        String atMemName5 = aVar.f412791h;
                        long j19 = aVar.f412788e;
                        Intrinsics.checkNotNullExpressionValue(atMemName5, "atMemName");
                        arrayList.add(new e.InputSendTextIntent(atMemName5, 16, 0L, j19, null, 20, null));
                    } else if (b16 == 5) {
                        String atMemName6 = aVar.f412791h;
                        long j26 = aVar.f412788e;
                        Intrinsics.checkNotNullExpressionValue(atMemName6, "atMemName");
                        arrayList.add(new e.InputSendTextIntent(atMemName6, 512, 0L, j26, null, 20, null));
                    }
                    s16 = (short) (aVar.f412784a + aVar.f412785b);
                }
                if (s16 < inputString.length()) {
                    String substring2 = inputString.substring(s16, inputString.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    arrayList.add(new e.InputSendTextIntent(substring2, 0, 0L, 0L, null, 30, null));
                }
                return arrayList;
            }
        }
        return new ArrayList();
    }

    @NotNull
    public final List<sr0.b> e(@NotNull e.InputSendTextIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return f(intent.getContent(), intent.getAtType(), intent.getAtUid(), intent.getAtTinyId(), intent.getAtRoleInfo());
    }

    @NotNull
    public final List<sr0.b> f(@NotNull String content, int atType, long atUid, long atTinyId, @Nullable AtRoleInfo atRoleInfo) {
        boolean z16;
        Long l3;
        Integer num;
        String str;
        String roleId;
        boolean z17;
        Long l16;
        Integer num2;
        String str2;
        String roleId2;
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        boolean a16 = o.f112412a.a(content);
        QLog.i("GuildEmoMsgUtils", 1, "isSingleLottie=" + a16);
        int length = content.length();
        int i3 = -1;
        for (int i16 = 0; i16 < length; i16++) {
            if (i16 > i3) {
                if (j(content, i16)) {
                    if (sb5.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        String sb6 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                        if (atRoleInfo != null && (roleId2 = atRoleInfo.getRoleId()) != null) {
                            l16 = Long.valueOf(Long.parseLong(roleId2));
                        } else {
                            l16 = null;
                        }
                        if (atRoleInfo != null) {
                            num2 = Integer.valueOf((int) atRoleInfo.getColor());
                        } else {
                            num2 = null;
                        }
                        if (atRoleInfo != null) {
                            str2 = atRoleInfo.getName();
                        } else {
                            str2 = null;
                        }
                        a.TextElement textElement = new a.TextElement(sb6, atType, atUid, atTinyId, l16, num2, str2);
                        sr0.b bVar = new sr0.b(1, 0, 2, null);
                        bVar.l(textElement);
                        arrayList.add(bVar);
                        sb5.delete(0, sb5.length());
                    }
                    if (((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).isValidEmojiFaceId(content, i16)) {
                        a.FaceElement c16 = c(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmojiFaceStrToServerId(content, i16), a16);
                        sr0.b bVar2 = new sr0.b(6, 0, 2, null);
                        bVar2.h(c16);
                        arrayList.add(bVar2);
                        i3 = i16 + 1;
                    } else if (k(content, i16)) {
                        MarketSmallFaceInfo faceInfo = ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).parseMarketSmallFace(content, i16);
                        Intrinsics.checkNotNullExpressionValue(faceInfo, "faceInfo");
                        a.FaceElement d16 = d(faceInfo);
                        sr0.b bVar3 = new sr0.b(6, 0, 2, null);
                        bVar3.h(d16);
                        arrayList.add(bVar3);
                        i3 = i16 + 4;
                    }
                } else {
                    sb5.append(content.charAt(i16));
                }
            }
        }
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
            if (atRoleInfo != null && (roleId = atRoleInfo.getRoleId()) != null) {
                l3 = Long.valueOf(Long.parseLong(roleId));
            } else {
                l3 = null;
            }
            if (atRoleInfo != null) {
                num = Integer.valueOf((int) atRoleInfo.getColor());
            } else {
                num = null;
            }
            if (atRoleInfo != null) {
                str = atRoleInfo.getName();
            } else {
                str = null;
            }
            a.TextElement textElement2 = new a.TextElement(sb7, atType, atUid, atTinyId, l3, num, str);
            sr0.b bVar4 = new sr0.b(1, 0, 2, null);
            bVar4.l(textElement2);
            arrayList.add(bVar4);
        }
        return arrayList;
    }

    public final void h(@NotNull Context context, @NotNull EditText editText, @NotNull String tinyId, @NotNull String nickname, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        SpannableString p16 = com.tencent.guild.aio.input.at.utils.b.p(context, tinyId, nickname, nickname, editText, 0, false, i3);
        if (p16 == null) {
            QLog.e("GuildEmoMsgUtils", 1, "tinyId=" + tinyId + " nickName=" + nickname);
            return;
        }
        editText.getEditableText().insert(editText.getSelectionStart(), p16);
    }

    public final boolean j(@NotNull String content, int position) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (content.charAt(position) == 20 && position + 1 < content.length()) {
            return true;
        }
        return false;
    }

    public final boolean k(@NotNull String content, int position) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (j(content, position) && position + 4 < content.length()) {
            return true;
        }
        return false;
    }
}
