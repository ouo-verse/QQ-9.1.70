package i54;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import com.tencent.robot.share.layer.RobotLayerShareActionManager;
import com.tencent.robot.share.layer.RobotLayerShareContext;
import com.tencent.robot.share.layer.g;
import cooperation.peak.PeakConstants;
import i54.a;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Li54/e;", "Li54/a;", "", "", "c", "Lcom/tencent/robot/share/layer/RobotLayerShareActionManager$ShareLine;", "a", "Lcom/tencent/robot/share/layer/f;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements a {
    @Override // i54.a
    @NotNull
    public RobotLayerShareActionManager.ShareLine a() {
        return RobotLayerShareActionManager.ShareLine.NONE;
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
            QLog.e("ShareToSpecifiedAction", 1, "avatar file error!");
            return;
        }
        File file = new File(a16);
        if (!file.exists()) {
            QLog.e("ShareToSpecifiedAction", 1, "avatar not exists. error!");
            return;
        }
        Bundle bundle = new Bundle(shareContext.getActivity().getIntent().getExtras());
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, new File(a16).toURI().toURL().toString());
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, new File(a16).toURI().toURL().toString());
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, file.getAbsolutePath());
        bundle.putInt("forward_type", 1);
        bundle.putInt(PeakConstants.SEND_SIZE_SPEC, 2);
        IRobotExtApi iRobotExtApi = (IRobotExtApi) QRoute.api(IRobotExtApi.class);
        Activity activity = shareContext.getActivity();
        String str = item.uin;
        Intrinsics.checkNotNullExpressionValue(str, "item.uin");
        iRobotExtApi.shareRobotLocalPicToFriend(activity, bundle, str, item.uinType);
    }

    @Override // i54.a
    @NotNull
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(72);
        return listOf;
    }

    @Override // i54.a
    public boolean d(@NotNull RobotLayerShareContext robotLayerShareContext) {
        return a.C10507a.a(this, robotLayerShareContext);
    }
}
