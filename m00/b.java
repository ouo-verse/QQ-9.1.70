package m00;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements IMiniMsgUnreadCallback {
    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public boolean show(int i3) {
        x.h("AIOLog", 1, "MiniMsgUser show = " + i3);
        return false;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateUnreadCount(int i3, boolean z16) {
        x.h("AIOLog", 1, "MiniMsgUser updateUnreadCount i = " + i3 + ", b = " + z16);
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void destroy() {
        x.h("AIOLog", 1, "MiniMsgUser destroy");
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hide() {
        x.h("AIOLog", 1, "MiniMsgUser hide");
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hideUnread() {
        x.h("AIOLog", 1, "MiniMsgUser hideUnread");
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateOnBackFromMiniAIO(Bundle bundle) {
        x.h("AIOLog", 1, "MiniMsgUser updateOnBackFromMiniAIO");
    }
}
