package com.tencent.imcore.message.facade.send.sender;

import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0005j\b\u0012\u0004\u0012\u00020\u0012`\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/imcore/message/facade/send/sender/d;", "", "", "", "arrArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "", "isAPNG", "f", "hasIPProduct", "d", "type", "", "e", "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "faceMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "b", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f116641a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f116641a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<Integer> c(List<Integer> arrArray) {
        if (arrArray != null) {
            return new ArrayList<>(arrArray);
        }
        return new ArrayList<>();
    }

    private final String e(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        return "";
                    }
                    return "\u9605\u8bfb";
                }
                return "\u52a8\u6f2b";
            }
            return "\u6e38\u620f";
        }
        return "\u7535\u5f71";
    }

    private final int f(boolean isAPNG) {
        if (isAPNG) {
            return 2;
        }
        return 1;
    }

    @NotNull
    public final MarketFaceElement a(@NotNull MessageForMarketFace msg2) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MarketFaceElement) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        MarkFaceMessage markFaceMessage = msg2.mMarkFaceMessage;
        int i3 = markFaceMessage.dwMSGItemType;
        int i16 = markFaceMessage.cFaceInfo;
        int i17 = markFaceMessage.dwTabID;
        int i18 = markFaceMessage.cSubType;
        int i19 = markFaceMessage.mediaType;
        int i26 = markFaceMessage.imageWidth;
        int i27 = markFaceMessage.imageHeight;
        String str = "[" + markFaceMessage.faceName + "]";
        byte[] bArr = markFaceMessage.sbufID;
        Intrinsics.checkNotNullExpressionValue(bArr, "faceMsg.sbufID");
        b16 = e.b(bArr);
        byte[] bArr2 = markFaceMessage.sbfKey;
        Intrinsics.checkNotNullExpressionValue(bArr2, "faceMsg.sbfKey");
        String str2 = new String(bArr2, Charsets.UTF_8);
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = markFaceMessage.mobileparam;
        Integer valueOf = Integer.valueOf(markFaceMessage.copywritingType);
        Integer valueOf2 = Integer.valueOf((int) markFaceMessage.beginTime);
        Integer valueOf3 = Integer.valueOf((int) markFaceMessage.endTime);
        Integer valueOf4 = Integer.valueOf(f(markFaceMessage.isAPNG));
        Integer valueOf5 = Integer.valueOf(d(markFaceMessage.hasIpProduct));
        ArrayList<Integer> c16 = c(markFaceMessage.voicePrintItems);
        String str3 = markFaceMessage.copywritingContent;
        String str4 = markFaceMessage.jumpUrl;
        String e16 = e(markFaceMessage.copywritingType);
        String str5 = markFaceMessage.backColor;
        String str6 = markFaceMessage.volumeColor;
        ArrayList<MarketFaceSupportSize> arrayList = markFaceMessage.supportSize;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList<MarketFaceSupportSize> arrayList2 = arrayList;
        ArrayList<MarketFaceSupportSize> arrayList3 = markFaceMessage.apngSupportSize;
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>();
        }
        return new MarketFaceElement(i3, i16, i17, i18, i19, i26, i27, str, b16, str2, bArr3, bArr4, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, c16, str3, str4, e16, str5, str6, "", "", arrayList2, arrayList3);
    }

    @NotNull
    public final ArrayList<MsgElement> b(@NotNull MessageForMarketFace faceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) faceMsg);
        }
        Intrinsics.checkNotNullParameter(faceMsg, "faceMsg");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 11;
        msgElement.marketFaceElement = a(faceMsg);
        arrayList.add(msgElement);
        return arrayList;
    }

    private final int d(boolean hasIPProduct) {
        return hasIPProduct ? 1 : 0;
    }
}
