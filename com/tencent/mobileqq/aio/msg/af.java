package com.tencent.mobileqq.aio.msg;

import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ae;", "other", "", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class af {
    public static final boolean a(@NotNull ae aeVar, @NotNull ae other) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        RichStatus richStatus;
        Intrinsics.checkNotNullParameter(aeVar, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        LinkInfo r26 = aeVar.r2();
        RichStatus richStatus2 = null;
        if (r26 != null) {
            str = r26.title;
        } else {
            str = null;
        }
        LinkInfo r27 = other.r2();
        if (r27 != null) {
            str2 = r27.title;
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            LinkInfo r28 = aeVar.r2();
            if (r28 != null) {
                str3 = r28.icon;
            } else {
                str3 = null;
            }
            LinkInfo r29 = other.r2();
            if (r29 != null) {
                str4 = r29.icon;
            } else {
                str4 = null;
            }
            if (Intrinsics.areEqual(str3, str4)) {
                LinkInfo r210 = aeVar.r2();
                if (r210 != null) {
                    str5 = r210.desc;
                } else {
                    str5 = null;
                }
                LinkInfo r211 = other.r2();
                if (r211 != null) {
                    str6 = r211.desc;
                } else {
                    str6 = null;
                }
                if (Intrinsics.areEqual(str5, str6)) {
                    LinkInfo r212 = aeVar.r2();
                    if (r212 != null) {
                        richStatus = r212.richStatus;
                    } else {
                        richStatus = null;
                    }
                    LinkInfo r213 = other.r2();
                    if (r213 != null) {
                        richStatus2 = r213.richStatus;
                    }
                    if (richStatus == richStatus2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
