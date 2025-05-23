package com.tencent.qqnt.emotion.msg.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/emotion/msg/utils/a;", "", "", "", "arrArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "", "isAPNG", "e", "hasIPProduct", "c", "type", "", "d", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "a", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f356292a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f356292a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<Integer> b(List<Integer> arrArray) {
        if (arrArray != null) {
            return new ArrayList<>(arrArray);
        }
        return new ArrayList<>();
    }

    private final String d(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        return "";
                    }
                    String qqStr = HardCodeUtil.qqStr(R.string.f170887zv3);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.emotion_source_reading)");
                    return qqStr;
                }
                String qqStr2 = HardCodeUtil.qqStr(R.string.f170886zv2);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.emotion_source_cartoon)");
                return qqStr2;
            }
            String qqStr3 = HardCodeUtil.qqStr(R.string.zv5);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.emotion_source_type_game)");
            return qqStr3;
        }
        String qqStr4 = HardCodeUtil.qqStr(R.string.f170888zv4);
        Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.emotion_source_type_film)");
        return qqStr4;
    }

    private final int e(boolean isAPNG) {
        if (isAPNG) {
            return 2;
        }
        return 1;
    }

    @NotNull
    public final MarketFaceElement a(@NotNull MarkFaceMessage marketFaceMsg) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MarketFaceElement) iPatchRedirector.redirect((short) 2, (Object) this, (Object) marketFaceMsg);
        }
        Intrinsics.checkNotNullParameter(marketFaceMsg, "marketFaceMsg");
        int i3 = marketFaceMsg.dwMSGItemType;
        int i16 = marketFaceMsg.cFaceInfo;
        int i17 = marketFaceMsg.dwTabID;
        int i18 = marketFaceMsg.cSubType;
        int i19 = marketFaceMsg.mediaType;
        int i26 = marketFaceMsg.imageWidth;
        int i27 = marketFaceMsg.imageHeight;
        String str = "[" + marketFaceMsg.faceName + "]";
        byte[] bArr = marketFaceMsg.sbufID;
        Intrinsics.checkNotNullExpressionValue(bArr, "marketFaceMsg.sbufID");
        b16 = b.b(bArr);
        byte[] bArr2 = marketFaceMsg.sbfKey;
        Intrinsics.checkNotNullExpressionValue(bArr2, "marketFaceMsg.sbfKey");
        return new MarketFaceElement(i3, i16, i17, i18, i19, i26, i27, str, b16, new String(bArr2, Charsets.UTF_8), new byte[0], marketFaceMsg.mobileparam, Integer.valueOf(marketFaceMsg.copywritingType), Integer.valueOf((int) marketFaceMsg.beginTime), Integer.valueOf((int) marketFaceMsg.endTime), Integer.valueOf(e(marketFaceMsg.isAPNG)), Integer.valueOf(c(marketFaceMsg.hasIpProduct)), b(marketFaceMsg.voicePrintItems), marketFaceMsg.copywritingContent, marketFaceMsg.jumpUrl, d(marketFaceMsg.copywritingType), marketFaceMsg.backColor, marketFaceMsg.volumeColor, "", "", marketFaceMsg.supportSize, marketFaceMsg.apngSupportSize);
    }

    private final int c(boolean hasIPProduct) {
        return hasIPProduct ? 1 : 0;
    }
}
