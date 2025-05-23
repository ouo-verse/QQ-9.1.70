package i54;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.robot.share.layer.RobotLayerShareActionManager;
import com.tencent.robot.share.layer.RobotLayerShareContext;
import com.tencent.robot.share.layer.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"Li54/c;", "Li54/a;", "", "localFilePath", "Lcom/tencent/robot/share/layer/f;", "shareContext", "", "e", "", "d", "", "", "c", "Lcom/tencent/robot/share/layer/RobotLayerShareActionManager$ShareLine;", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements a {
    private final void e(String localFilePath, RobotLayerShareContext shareContext) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, localFilePath);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, localFilePath);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, localFilePath);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, localFilePath);
        ((IRobotExtApi) QRoute.api(IRobotExtApi.class)).shareRobotLocalPicToGuild(shareContext.getActivity(), bundle);
    }

    @Override // i54.a
    @NotNull
    public RobotLayerShareActionManager.ShareLine a() {
        return RobotLayerShareActionManager.ShareLine.FIRST;
    }

    @Override // i54.a
    public void b(@NotNull RobotLayerShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        boolean z16;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        String a16 = g.f368413a.a(shareContext.getLayerItemInfo());
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("ShareToGuildAction", 1, "localFilePath isEmpty. return.");
        } else if (!new File(a16).exists()) {
            QLog.e("ShareToGuildAction", 1, "avatarFilePath not exists. return.");
        } else {
            e(a16, shareContext);
        }
    }

    @Override // i54.a
    @NotNull
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(171);
        return arrayListOf;
    }

    @Override // i54.a
    public boolean d(@NotNull RobotLayerShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
    }
}
