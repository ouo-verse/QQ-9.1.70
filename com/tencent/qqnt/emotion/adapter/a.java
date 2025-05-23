package com.tencent.qqnt.emotion.adapter;

import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\u0006J\u0014\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n*\u00020\tH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/a;", "", "", "APNG", "", "c", "(Ljava/lang/Integer;)Z", "iPProductType", "b", "", "", "kotlin.jvm.PlatformType", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "ele", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "d", "<init>", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f356140a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f356140a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final byte[] a(String str) {
        return HexUtil.hexStr2Bytes(str);
    }

    private final boolean b(Integer iPProductType) {
        if (iPProductType != null && iPProductType.intValue() == 1) {
            return true;
        }
        return false;
    }

    private final boolean c(Integer APNG) {
        if (APNG != null && APNG.intValue() == 2) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MarkFaceMessage d(@NotNull MarketFaceElement ele) {
        byte[] bArr;
        int intValue;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MarkFaceMessage) iPatchRedirector.redirect((short) 2, (Object) this, (Object) ele);
        }
        Intrinsics.checkNotNullParameter(ele, "ele");
        MarkFaceMessage markFaceMessage = new MarkFaceMessage();
        markFaceMessage.dwMSGItemType = ele.itemType;
        markFaceMessage.cFaceInfo = ele.faceInfo;
        markFaceMessage.dwTabID = ele.emojiPackageId;
        markFaceMessage.cSubType = ele.subType;
        markFaceMessage.mediaType = ele.mediaType;
        markFaceMessage.imageWidth = ele.imageWidth;
        markFaceMessage.imageHeight = ele.imageHeight;
        markFaceMessage.faceName = ele.faceName;
        String emojiId = ele.emojiId;
        byte[] bArr2 = null;
        if (emojiId != null) {
            a aVar = f356140a;
            Intrinsics.checkNotNullExpressionValue(emojiId, "emojiId");
            bArr = aVar.a(emojiId);
        } else {
            bArr = null;
        }
        markFaceMessage.sbufID = bArr;
        String key = ele.key;
        if (key != null) {
            Intrinsics.checkNotNullExpressionValue(key, "key");
            bArr2 = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
        }
        markFaceMessage.sbfKey = bArr2;
        markFaceMessage.mobileparam = ele.mobileParam;
        Integer num = ele.sourceType;
        if (num == null) {
            intValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(num, "ele.sourceType ?: 0");
            intValue = num.intValue();
        }
        markFaceMessage.copywritingType = intValue;
        Integer num2 = ele.startTime;
        long j16 = 0;
        if (num2 != null) {
            j3 = num2.intValue();
        } else {
            j3 = 0;
        }
        markFaceMessage.beginTime = j3;
        Integer num3 = ele.endTime;
        if (num3 != null) {
            j16 = num3.intValue();
        }
        markFaceMessage.endTime = j16;
        a aVar2 = f356140a;
        markFaceMessage.isAPNG = aVar2.c(ele.emojiType);
        markFaceMessage.hasIpProduct = aVar2.b(ele.hasIpProduct);
        markFaceMessage.voicePrintItems = ele.voiceItemHeightArr;
        markFaceMessage.copywritingContent = ele.sourceName;
        markFaceMessage.jumpUrl = ele.sourceJumpUrl;
        markFaceMessage.backColor = ele.backColor;
        markFaceMessage.volumeColor = ele.volumeColor;
        markFaceMessage.supportSize = ele.supportSize;
        markFaceMessage.apngSupportSize = ele.apngSupportSize;
        return markFaceMessage;
    }
}
