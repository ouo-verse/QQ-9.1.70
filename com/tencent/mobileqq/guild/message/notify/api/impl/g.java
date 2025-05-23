package com.tencent.mobileqq.guild.message.notify.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "", "a", "", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {
    @NotNull
    public static final String a(@NotNull MsgRecord msg2) {
        Object firstOrNull;
        String str;
        TextElement textElement;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ArrayList<MsgElement> arrayList = msg2.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.elements");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        MsgElement msgElement = (MsgElement) firstOrNull;
        if (msgElement != null && (textElement = msgElement.textElement) != null) {
            str = textElement.content;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final boolean b() {
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isUserOnLine();
    }
}
