package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J<\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/utils/y;", "", "", "content", "", "position", "", tl.h.F, "g", "emoServerId", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "e", "f", "atType", "", "atUid", "atTinyId", "senderUid", "", "Lcom/tencent/mobileqq/aio/msg/data/a;", "c", "Lcom/tencent/mobileqq/aio/input/f$e;", "intent", "b", "serverId", "isSingleLottie", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", "a", "input", "i", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f194180a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65291);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f194180a = new y();
        }
    }

    y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ List d(y yVar, String str, int i3, long j3, long j16, String str2, int i16, Object obj) {
        int i17;
        long j17;
        String str3;
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
            str3 = "";
        } else {
            str3 = str2;
        }
        return yVar.c(str, i17, j17, j18, str3);
    }

    private final AniStickerInfo e(int emoServerId) {
        return QQSysFaceUtil.getAniStickerInfo(QQSysFaceUtil.convertToLocal(emoServerId));
    }

    private final boolean g(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        int codePointAt = str.codePointAt(0);
        if (128512 <= codePointAt && codePointAt < 128592) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (127744 <= codePointAt && codePointAt < 128512) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (128640 <= codePointAt && codePointAt < 128768) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (9728 <= codePointAt && codePointAt < 9984) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        if (9984 <= codePointAt && codePointAt < 10176) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        if (!z26) {
                            if (65024 <= codePointAt && codePointAt < 65040) {
                                z27 = true;
                            } else {
                                z27 = false;
                            }
                            if (!z27) {
                                if (127462 <= codePointAt && codePointAt < 127488) {
                                    z28 = true;
                                } else {
                                    z28 = false;
                                }
                                if (!z28) {
                                    if (129280 <= codePointAt && codePointAt < 129536) {
                                        z29 = true;
                                    } else {
                                        z29 = false;
                                    }
                                    if (!z29) {
                                        if (129648 <= codePointAt && codePointAt < 129792) {
                                            z36 = true;
                                        } else {
                                            z36 = false;
                                        }
                                        if (!z36) {
                                            if (127488 <= codePointAt && codePointAt < 127547) {
                                                z37 = true;
                                            } else {
                                                z37 = false;
                                            }
                                            if (!z37) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private final boolean h(String content, int position) {
        if (f(content, position) && position + 4 < content.length()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AIOElementType.b a(int serverId, boolean isSingleLottie) {
        AIOElementType.b bVar;
        int i3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOElementType.b) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(serverId), Boolean.valueOf(isSingleLottie));
        }
        if (ah.f194109a.a(serverId)) {
            AniStickerInfo e16 = e(serverId);
            bVar = r15;
            AIOElementType.b bVar2 = new AIOElementType.b(0, 0, null, 0, null, null, 0, 0, null, null, 0, 0, null, 0, 0, null, null, 0, 0, 0, null, 0, 0, 8388607, null);
            if (!isSingleLottie) {
                if (serverId <= 247) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
            }
            bVar.B(i16);
            bVar.z(serverId);
            if (e16 != null) {
                i3 = e16.aniStickerType;
            } else {
                i3 = 0;
            }
            bVar.Z(i3);
            String str3 = null;
            if (e16 != null) {
                str = e16.aniStickerId;
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "info?.aniStickerId ?: \"\"");
            }
            bVar.V(str);
            bVar.M(1);
            bVar.G(1);
            if (e16 != null) {
                str2 = e16.aniStickerPackId;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "info?.aniStickerPackId ?: \"\"");
            }
            bVar.D(str2);
            if (e16 != null) {
                str3 = e16.text;
            }
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "info?.text ?: \"\"");
                str4 = str3;
            }
            bVar.A(str4);
        } else {
            String faceDescription = ((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).getFaceDescription(serverId, 1);
            bVar = new AIOElementType.b(0, 0, null, 0, null, null, 0, 0, null, null, 0, 0, null, 0, 0, null, null, 0, 0, 0, null, 0, 0, 8388607, null);
            if (serverId <= 247) {
                i17 = 1;
            }
            bVar.B(i17);
            bVar.z(serverId);
            bVar.A(faceDescription);
        }
        return bVar;
    }

    @NotNull
    public final List<com.tencent.mobileqq.aio.msg.data.a> b(@NotNull f.e intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        return c(intent.d(), intent.b(), intent.c(), intent.a(), intent.e());
    }

    @NotNull
    public final List<com.tencent.mobileqq.aio.msg.data.a> c(@NotNull String content, int atType, long atUid, long atTinyId, @NotNull String senderUid) {
        boolean z16;
        int i3;
        int i16;
        boolean z17;
        int i17;
        StringBuilder sb5;
        char c16;
        boolean z18;
        DefaultConstructorMarker defaultConstructorMarker;
        int i18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 6;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, content, Integer.valueOf(atType), Long.valueOf(atUid), Long.valueOf(atTinyId), senderUid);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb6 = new StringBuilder();
        boolean b16 = ah.f194109a.b(content);
        int length = content.length();
        int i19 = -1;
        int i26 = 0;
        while (i26 < length) {
            if (i26 <= i19) {
                i3 = i19;
                i16 = i26;
                z17 = b16;
                i17 = length;
                sb5 = sb6;
                c16 = c17;
            } else if (f(content, i26)) {
                if (sb6.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    String sb7 = sb6.toString();
                    Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
                    defaultConstructorMarker = null;
                    i3 = i19;
                    i18 = i26;
                    z19 = b16;
                    i17 = length;
                    StringBuilder sb8 = sb6;
                    AIOElementType.h hVar = new AIOElementType.h(sb7, atType, atUid, atTinyId, senderUid);
                    com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(1, 0, 2, null);
                    aVar.t(hVar);
                    arrayList.add(aVar);
                    sb5 = sb8;
                    sb5.delete(0, sb8.length());
                } else {
                    defaultConstructorMarker = null;
                    i3 = i19;
                    i18 = i26;
                    z19 = b16;
                    i17 = length;
                    sb5 = sb6;
                }
                QRouteApi api = QRoute.api(IEmojiSpanService.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api;
                i16 = i18;
                if (iEmojiSpanService.isValidEmojiFaceId(content, i16)) {
                    int convertEmoCodeToServerId = iEmojiSpanService.convertEmoCodeToServerId(content, i16);
                    iEmojiSpanService.getFaceDescription(convertEmoCodeToServerId, 1);
                    z17 = z19;
                    AIOElementType.b a16 = a(convertEmoCodeToServerId, z17);
                    com.tencent.mobileqq.aio.msg.data.a aVar2 = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, defaultConstructorMarker);
                    aVar2.m(a16);
                    arrayList.add(aVar2);
                    i19 = i16 + 1;
                    c16 = 6;
                } else {
                    z17 = z19;
                    if (h(content, i16)) {
                        com.tencent.qqnt.emotion.data.a parseMarketSmallFace = iEmojiSpanService.parseMarketSmallFace(content, i16);
                        AIOElementType.b bVar = new AIOElementType.b(4, parseMarketSmallFace.b(), String.valueOf(parseMarketSmallFace.d()), parseMarketSmallFace.c(), parseMarketSmallFace.a(), null, 0, 0, null, null, 0, 0, null, 0, 0, null, null, 0, 0, 0, null, 0, 0, 8388576, null);
                        c16 = 6;
                        com.tencent.mobileqq.aio.msg.data.a aVar3 = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, defaultConstructorMarker);
                        aVar3.m(bVar);
                        arrayList.add(aVar3);
                        i19 = i16 + 4;
                    } else {
                        c16 = 6;
                    }
                }
                sb6 = sb5;
                c17 = c16;
                length = i17;
                b16 = z17;
                i26 = i16 + 1;
            } else {
                i3 = i19;
                i16 = i26;
                z17 = b16;
                i17 = length;
                sb5 = sb6;
                c16 = c17;
                sb5.append(content.charAt(i16));
            }
            i19 = i3;
            sb6 = sb5;
            c17 = c16;
            length = i17;
            b16 = z17;
            i26 = i16 + 1;
        }
        StringBuilder sb9 = sb6;
        if (sb9.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String sb10 = sb9.toString();
            Intrinsics.checkNotNullExpressionValue(sb10, "sb.toString()");
            AIOElementType.h hVar2 = new AIOElementType.h(sb10, atType, atUid, atTinyId, senderUid);
            com.tencent.mobileqq.aio.msg.data.a aVar4 = new com.tencent.mobileqq.aio.msg.data.a(1, 0, 2, null);
            aVar4.t(hVar2);
            arrayList.add(aVar4);
        }
        return arrayList;
    }

    public final boolean f(@NotNull String content, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content, position)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (position + 1 < content.length() && content.charAt(position) == 20) {
            return true;
        }
        return false;
    }

    public final boolean i(@Nullable String input) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) input)).booleanValue();
        }
        if (input != null && input.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        int i3 = 0;
        while (i3 < input.length()) {
            int codePointAt = input.codePointAt(i3);
            i3 += Character.charCount(codePointAt);
            if (codePointAt != 8205 && codePointAt != 65039) {
                if (!Character.isDefined(codePointAt)) {
                    return false;
                }
                char[] chars = Character.toChars(codePointAt);
                Intrinsics.checkNotNullExpressionValue(chars, "toChars(utf32)");
                if (!g(new String(chars))) {
                    return false;
                }
            }
        }
        if (input.length() > 0) {
            return true;
        }
        return false;
    }
}
