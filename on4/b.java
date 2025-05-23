package on4;

import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import ln4.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lon4/b;", "Lln4/c;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "c", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "a", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "v2TIMGroupMember", "b", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "<init>", "(Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final V2TIMGroupMemberInfo v2TIMGroupMember;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    public b(@NotNull V2TIMGroupMemberInfo v2TIMGroupMember) {
        Intrinsics.checkNotNullParameter(v2TIMGroupMember, "v2TIMGroupMember");
        this.v2TIMGroupMember = v2TIMGroupMember;
    }

    @Override // ln4.c
    @NotNull
    public CommonOuterClass$QQUserId c() {
        long j3;
        if (this.qqUserId == null) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            PBUInt64Field pBUInt64Field = commonOuterClass$QQUserId.uid;
            String userID = this.v2TIMGroupMember.getUserID();
            Intrinsics.checkNotNullExpressionValue(userID, "v2TIMGroupMember.userID");
            ULong uLongOrNull = UStringsKt.toULongOrNull(userID);
            long j16 = 0;
            if (uLongOrNull != null) {
                j3 = uLongOrNull.getData();
            } else {
                j3 = 0;
            }
            pBUInt64Field.set(j3);
            PBUInt64Field pBUInt64Field2 = commonOuterClass$QQUserId.yes_uid;
            String userID2 = this.v2TIMGroupMember.getUserID();
            Intrinsics.checkNotNullExpressionValue(userID2, "v2TIMGroupMember.userID");
            ULong uLongOrNull2 = UStringsKt.toULongOrNull(userID2);
            if (uLongOrNull2 != null) {
                j16 = uLongOrNull2.getData();
            }
            pBUInt64Field2.set(j16);
            this.qqUserId = commonOuterClass$QQUserId;
        }
        CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = this.qqUserId;
        Intrinsics.checkNotNull(commonOuterClass$QQUserId2);
        return commonOuterClass$QQUserId2;
    }
}
