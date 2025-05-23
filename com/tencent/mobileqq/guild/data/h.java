package com.tencent.mobileqq.guild.data;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/data/g;", "a", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {
    @NotNull
    public static final g a(@NotNull LocalMediaInfo localMediaInfo) {
        String str;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        long j3 = localMediaInfo._id;
        String str2 = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str2, "this.path");
        long j16 = localMediaInfo.fileSize;
        String str3 = localMediaInfo.thumbnailPath;
        if (str3 == null) {
            str3 = "";
        }
        int i3 = localMediaInfo.mediaWidth;
        int i16 = localMediaInfo.mediaHeight;
        String str4 = localMediaInfo.mMimeType;
        if (str4 == null) {
            com.tencent.mobileqq.guild.util.i iVar = com.tencent.mobileqq.guild.util.i.f235563a;
            String str5 = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str5, "this.path");
            String c16 = iVar.c(str5);
            if (c16 == null) {
                str = "";
            } else {
                str = c16;
            }
        } else {
            str = str4;
        }
        return new g(j3, str2, j16, str3, i3, i16, str, localMediaInfo.rotation, localMediaInfo.mDuration, localMediaInfo.isRwa, localMediaInfo.mediaOriginWidth, localMediaInfo.mediaOriginHeight, localMediaInfo.mediaOriginBitrate);
    }
}
