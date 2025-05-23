package i54;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.api.IRichMediaDepend;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.robot.share.layer.RobotLayerShareActionManager;
import com.tencent.robot.share.layer.RobotLayerShareContext;
import com.tencent.robot.share.layer.g;
import i54.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Li54/b;", "Li54/a;", "", "", "c", "Lcom/tencent/robot/share/layer/RobotLayerShareActionManager$ShareLine;", "a", "Lcom/tencent/robot/share/layer/f;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class b implements a {
    @Override // i54.a
    @NotNull
    public RobotLayerShareActionManager.ShareLine a() {
        return RobotLayerShareActionManager.ShareLine.SECOND;
    }

    @Override // i54.a
    public void b(@NotNull RobotLayerShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        boolean z16;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        String a16 = g.f368413a.a(shareContext.getLayerItemInfo());
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("SaveToAlbumAction", 1, "onSaveBtnClick localFilePath isEmpty return.");
            return;
        }
        if (!new File(a16).exists()) {
            QLog.e("SaveToAlbumAction", 1, "onSaveBtnClick not exists. error!");
            return;
        }
        RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
        if (layerPicInfo != null) {
            rFWPicInfo = layerPicInfo.getOriginPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            rFWPicInfo.setLocalPath(a16);
        }
        ((IRichMediaDepend) QRoute.api(IRichMediaDepend.class)).saveToAlbum(shareContext.getActivity(), shareContext.getLayerItemInfo());
    }

    @Override // i54.a
    @NotNull
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(39);
        return arrayListOf;
    }

    @Override // i54.a
    public boolean d(@NotNull RobotLayerShareContext robotLayerShareContext) {
        return a.C10507a.a(this, robotLayerShareContext);
    }
}
