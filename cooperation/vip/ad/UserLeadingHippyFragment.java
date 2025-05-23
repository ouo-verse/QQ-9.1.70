package cooperation.vip.ad;

import android.view.ViewGroup;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UserLeadingHippyFragment extends CommonHippyFragment {
    private HippyMap C;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void loadHippy(ViewGroup viewGroup) {
        super.loadHippy(viewGroup);
        HippyMap hippyMap = this.C;
        if (hippyMap != null) {
            this.mHippyQQEngine.setPropsMap(hippyMap);
        }
    }
}
