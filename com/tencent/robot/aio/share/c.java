package com.tencent.robot.aio.share;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.guild.api.IGuildDataApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/aio/share/c;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "", "p0", "Landroid/view/View;", "o0", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "param", "<init>", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;)V", "J0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends ShareActionSheetV2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ShareActionSheetV2.Param param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        if (p0()) {
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(171);
            Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026m.ACTION_SEND_TO_CHANNEL)");
            arrayList.add(build2);
        }
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build4);
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build5);
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(241);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026em.ACTION_GENERATE_IMAGE)");
        arrayList2.add(build6);
        ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(1);
        Intrinsics.checkNotNullExpressionValue(build7, "build(ShareActionSheetBu\u2026heetItem.ACTION_COPYLINK)");
        arrayList2.add(build7);
        setRowVisibility(8, 0, 0);
        setIntentForStartForwardRecentActivity(new Intent());
        setActionSheetItems(arrayList, arrayList2);
    }

    private final boolean p0() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return false;
        }
        boolean isExtendTabShow = TabDataHelper.isExtendTabShow(BaseApplication.getContext(), str, "GUILD");
        boolean z16 = !((IGuildDataApi) QRoute.api(IGuildDataApi.class)).getGuildIds().isEmpty();
        if (!isExtendTabShow || !z16) {
            return false;
        }
        return true;
    }

    @Nullable
    public final View o0() {
        if (this.G == null) {
            this.G = C();
        }
        return this.G;
    }
}
