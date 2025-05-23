package com.tencent.qqnt.emotion.emoreply;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/emoreply/f;", "detailData", "", "a", "(Lcom/tencent/qqnt/aio/emoreply/f;)Ljava/lang/Integer;", "localId", "type", "", "b", "qqemoticonpanel-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h {
    @Nullable
    public static final Integer a(@NotNull com.tencent.qqnt.aio.emoreply.f detailData) {
        Object orNull;
        Intrinsics.checkNotNullParameter(detailData, "detailData");
        orNull = CollectionsKt___CollectionsKt.getOrNull(detailData.a(), detailData.b());
        com.tencent.qqnt.aio.emoreply.i iVar = (com.tencent.qqnt.aio.emoreply.i) orNull;
        if (iVar != null) {
            return Integer.valueOf(((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(iVar.b(), iVar.c()));
        }
        return null;
    }

    @Nullable
    public static final String b(int i3, int i16) {
        String faceDescription;
        boolean startsWith$default;
        if (i16 != 1) {
            if (i16 != 2) {
                faceDescription = null;
            } else {
                faceDescription = QQEmojiUtil.getEmojiDescription(i3);
            }
        } else {
            faceDescription = QQSysFaceUtil.getFaceDescription(i3);
        }
        if (faceDescription != null && faceDescription.length() > 1) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(faceDescription, "/", false, 2, null);
            if (startsWith$default) {
                faceDescription = faceDescription.substring(1);
                Intrinsics.checkNotNullExpressionValue(faceDescription, "this as java.lang.String).substring(startIndex)");
            }
        }
        if (TextUtils.isEmpty(faceDescription)) {
            return HardCodeUtil.qqStr(R.string.f208995e8);
        }
        return faceDescription;
    }
}
