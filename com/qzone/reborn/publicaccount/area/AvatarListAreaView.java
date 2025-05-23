package com.qzone.reborn.publicaccount.area;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/publicaccount/area/AvatarListAreaView;", "Landroid/widget/FrameLayout;", "", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$UserInfo;", "userInfoList", "", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class AvatarListAreaView extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private static final int f58750e = ViewUtils.dpToPx(14.0f);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarListAreaView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(List<QZoneOfficialAccountBase$UserInfo> userInfoList) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        if (userInfoList.isEmpty()) {
            return;
        }
        removeAllViews();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(userInfoList.size(), 5);
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            QZoneOfficialAccountBase$UserInfo qZoneOfficialAccountBase$UserInfo = userInfoList.get(i3);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AvatarElement avatarElement = new AvatarElement(context, true);
            avatarElement.setUin(String.valueOf(qZoneOfficialAccountBase$UserInfo.uin.get()));
            avatarElement.setTranslationX(f58750e * i3);
            addView(avatarElement, i3);
        }
    }
}
