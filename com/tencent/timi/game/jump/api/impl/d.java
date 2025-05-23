package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.utils.ax;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/d;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class d extends av {
    @Override // com.tencent.mobileqq.app.parser.av
    @NotNull
    public ax a(@Nullable BaseQQAppInterface app, @Nullable Context context, @NotNull String jump, @Nullable JumpParserResult jumpParserResult) {
        List split$default;
        List split$default2;
        List split$default3;
        Intrinsics.checkNotNullParameter(jump, "jump");
        com.tencent.timi.game.utils.l.i("TimiGameParserBase_", "parse jump:" + jump);
        ax b16 = b(app, context);
        b16.f307438c = jump;
        split$default = StringsKt__StringsKt.split$default((CharSequence) jump, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) strArr[1], new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Object[] array2 = split$default2.toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (String str : (String[]) array2) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                Object[] array3 = split$default3.toArray(new String[0]);
                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array3;
                if (strArr2.length == 2) {
                    b16.r(strArr2[0], strArr2[1]);
                }
            }
            return b16;
        }
        return b16;
    }

    @NotNull
    public abstract ax b(@Nullable BaseQQAppInterface app, @Nullable Context context);
}
