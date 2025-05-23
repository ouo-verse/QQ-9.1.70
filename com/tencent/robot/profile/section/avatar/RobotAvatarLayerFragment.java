package com.tencent.robot.profile.section.avatar;

import com.tencent.biz.richframework.part.Part;
import com.tencent.richframework.gallery.QQLayerFragment;
import com.tencent.robot.share.layer.RobotLayerControlPart;
import com.tencent.robot.share.layer.RobotLayerMorePart;
import com.tencent.robot.share.layer.RobotLayerShareActionManager;
import com.tencent.robot.share.layer.a;
import com.tencent.robot.share.layer.c;
import com.tencent.robot.share.layer.e;
import i54.b;
import i54.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/profile/section/avatar/RobotAvatarLayerFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotAvatarLayerFragment extends QQLayerFragment {
    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new a());
        arrayList.add(new e());
        arrayList.add(new c());
        RobotLayerShareActionManager robotLayerShareActionManager = new RobotLayerShareActionManager();
        robotLayerShareActionManager.a(new i54.e());
        robotLayerShareActionManager.a(new d());
        robotLayerShareActionManager.a(new i54.c());
        robotLayerShareActionManager.a(new b());
        arrayList.add(new RobotLayerMorePart(robotLayerShareActionManager));
        arrayList.add(new RobotLayerControlPart());
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 168;
    }
}
