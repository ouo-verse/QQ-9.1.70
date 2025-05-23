package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qshadow.ShadowAIGCStatus$ActionStatus;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u0000*\u00020\u0000\u00a8\u0006\r"}, d2 = {"Lqshadow/ShadowAIGCStatus$GetStatusReply;", "", "f", "g", h.F, "j", "", "c", "b", "e", "d", "i", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @NotNull
    public static final ShadowAIGCStatus$GetStatusReply a(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply2 = new ShadowAIGCStatus$GetStatusReply();
        try {
            shadowAIGCStatus$GetStatusReply2.mergeFrom(shadowAIGCStatus$GetStatusReply.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return shadowAIGCStatus$GetStatusReply2;
    }

    @NotNull
    public static final String b(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        String str = shadowAIGCStatus$GetStatusReply.button_info.text.get();
        Intrinsics.checkNotNullExpressionValue(str, "button_info.text.get()");
        return str;
    }

    @NotNull
    public static final String c(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        String str = shadowAIGCStatus$GetStatusReply.button_info.description.get();
        Intrinsics.checkNotNullExpressionValue(str, "button_info.description.get()");
        return str;
    }

    @NotNull
    public static final String d(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        String str = shadowAIGCStatus$GetStatusReply.button_info.detail.get();
        Intrinsics.checkNotNullExpressionValue(str, "button_info.detail.get()");
        return str;
    }

    @NotNull
    public static final String e(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        String str = shadowAIGCStatus$GetStatusReply.button_info.popup_text.get();
        Intrinsics.checkNotNullExpressionValue(str, "button_info.popup_text.get()");
        return str;
    }

    public static final boolean f(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        if (shadowAIGCStatus$GetStatusReply.button_info.type.get() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Object obj;
        PBInt32Field pBInt32Field;
        boolean z16;
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        List<ShadowAIGCStatus$ActionStatus> list = shadowAIGCStatus$GetStatusReply.actions.get();
        Intrinsics.checkNotNullExpressionValue(list, "actions.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((ShadowAIGCStatus$ActionStatus) obj).type.get() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ShadowAIGCStatus$ActionStatus shadowAIGCStatus$ActionStatus = (ShadowAIGCStatus$ActionStatus) obj;
        if (shadowAIGCStatus$ActionStatus != null && (pBInt32Field = shadowAIGCStatus$ActionStatus.available) != null && pBInt32Field.get() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean h(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        if (shadowAIGCStatus$GetStatusReply.button_info.type.get() == 2) {
            return true;
        }
        return false;
    }

    public static final boolean i(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        if (shadowAIGCStatus$GetStatusReply.pay_info.is_vip.get() && shadowAIGCStatus$GetStatusReply.pay_info.vip_type.get() == 1) {
            return true;
        }
        return false;
    }

    public static final boolean j(@NotNull ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(shadowAIGCStatus$GetStatusReply, "<this>");
        if (shadowAIGCStatus$GetStatusReply.button_info.type.get() == 5) {
            return true;
        }
        return false;
    }
}
