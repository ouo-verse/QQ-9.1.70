package com.tencent.qqnt.notification.inject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.h;
import com.tencent.qqnt.kernel.nativeinterface.AvatarSize;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/notification/inject/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "", "useSenderUid", "Landroid/graphics/Bitmap;", "f", "i", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.notification.inject.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9663a {
        @Nullable
        public static Bitmap a(@NotNull a aVar, @NotNull RecentContactInfo msgRecord, boolean z16) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            h avatarService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getAvatarService();
            if (avatarService != null) {
                if (z16) {
                    str2 = msgRecord.senderUid;
                } else {
                    str2 = msgRecord.peerUid;
                }
                Intrinsics.checkNotNullExpressionValue(str2, "if (useSenderUid) msgRec\u2026id else msgRecord.peerUid");
                str = avatarService.getAvatarPath(str2, AvatarSize.SMALL);
            } else {
                str = null;
            }
            return BitmapFactory.decodeFile(str);
        }

        @Nullable
        public static Bitmap b(@NotNull a aVar, @NotNull RecentContactInfo msgRecord) {
            String str;
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            h avatarService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getAvatarService();
            if (avatarService != null) {
                str = avatarService.getGroupAvatarPath(msgRecord.peerUin, AvatarSize.SMALL);
            } else {
                str = null;
            }
            return BitmapFactory.decodeFile(str);
        }
    }

    @Nullable
    Bitmap f(@NotNull RecentContactInfo msgRecord, boolean useSenderUid);

    @Nullable
    Bitmap i(@NotNull RecentContactInfo msgRecord);
}
