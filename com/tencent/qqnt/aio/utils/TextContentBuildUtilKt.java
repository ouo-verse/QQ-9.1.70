package com.tencent.qqnt.aio.utils;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0006\u001a2\u0010\u0007\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0002\u00a8\u0006\u000b"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "Lkotlin/Function2;", "", "", "filter", "b", "hasFace", "result", "d", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TextContentBuildUtilKt {
    @JvmOverloads
    @NotNull
    public static final CharSequence b(@NotNull List<MsgElement> msgElements, @NotNull Function2<? super Boolean, ? super CharSequence, ? extends CharSequence> filter) {
        int intValue;
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(filter, "filter");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z16 = false;
        for (MsgElement msgElement : msgElements) {
            int i3 = msgElement.elementType;
            if (i3 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    QRouteApi api = QRoute.api(IEmojiSpanService.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                    IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api;
                    int i16 = faceElement.faceType;
                    int i17 = faceElement.faceIndex;
                    Integer num = faceElement.imageType;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num, "it.imageType ?: 0");
                        intValue = num.intValue();
                    }
                    spannableStringBuilder.append(IEmojiSpanService.a.a(iEmojiSpanService, i16, i17, intValue, true, 0, 16, null));
                    z16 = true;
                }
            } else if (i3 == 1) {
                spannableStringBuilder.append((CharSequence) s.f352317a.b(msgElement));
            }
        }
        return filter.invoke(Boolean.valueOf(z16), spannableStringBuilder);
    }

    public static /* synthetic */ CharSequence c(List list, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = TextContentBuildUtilKt$buildContent$1.INSTANCE;
        }
        return b(list, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence d(boolean z16, CharSequence charSequence) {
        return charSequence;
    }
}
