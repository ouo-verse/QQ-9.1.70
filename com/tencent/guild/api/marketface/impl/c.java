package com.tencent.guild.api.marketface.impl;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\u0006J\u0014\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n*\u00020\tH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/api/marketface/impl/c;", "", "", "APNG", "", "c", "(Ljava/lang/Integer;)Z", "iPProductType", "b", "", "", "kotlin.jvm.PlatformType", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "ele", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "d", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f112587a = new c();

    c() {
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

    /* JADX WARN: Code restructure failed: missing block: B:4:0x003c, code lost:
    
        if (r1 == null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        if (r1 == null) goto L11;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MarkFaceMessage d(@NotNull MarketFaceElement ele) {
        byte[] bArr;
        byte[] bArr2;
        long j3;
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
        int i3 = 0;
        if (emojiId != null) {
            c cVar = f112587a;
            Intrinsics.checkNotNullExpressionValue(emojiId, "emojiId");
            bArr = cVar.a(emojiId);
        }
        bArr = new byte[0];
        markFaceMessage.sbufID = bArr;
        String key = ele.key;
        if (key != null) {
            Intrinsics.checkNotNullExpressionValue(key, "key");
            bArr2 = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
        }
        bArr2 = new byte[0];
        markFaceMessage.sbfKey = bArr2;
        markFaceMessage.mobileparam = ele.mobileParam;
        Integer num = ele.sourceType;
        if (num != null) {
            Intrinsics.checkNotNullExpressionValue(num, "ele.sourceType ?: 0");
            i3 = num.intValue();
        }
        markFaceMessage.copywritingType = i3;
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
        c cVar2 = f112587a;
        markFaceMessage.isAPNG = cVar2.c(ele.emojiType);
        markFaceMessage.hasIpProduct = cVar2.b(ele.hasIpProduct);
        markFaceMessage.voicePrintItems = new ArrayList();
        markFaceMessage.copywritingContent = ele.sourceName;
        markFaceMessage.jumpUrl = ele.sourceJumpUrl;
        markFaceMessage.backColor = ele.backColor;
        markFaceMessage.volumeColor = ele.volumeColor;
        return markFaceMessage;
    }
}
