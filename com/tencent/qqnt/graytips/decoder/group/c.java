package com.tencent.qqnt.graytips.decoder.group;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.GroupGrayElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/group/c;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GroupGrayElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/graytips/util/h$a;", "a", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull c cVar, @NotNull GroupGrayElement element) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(element, "element");
            if (!TextUtils.isEmpty(element.adminRemark)) {
                str = element.adminRemark;
                str2 = "element.adminRemark";
            } else {
                str = element.adminNick;
                str2 = "element.adminNick";
            }
            Intrinsics.checkNotNullExpressionValue(str, str2);
            return str;
        }
    }

    @NotNull
    h.a a(@NotNull GroupGrayElement element);
}
