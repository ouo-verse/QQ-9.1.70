package oh3;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.zplan.emoticon.tab.manager.ZPlanEmoticonTabAvatarManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IEmotionTabCreateListener {

    /* renamed from: a, reason: collision with root package name */
    private IEmoticonMainPanelApp f422685a;

    /* renamed from: b, reason: collision with root package name */
    private CoroutineScope f422686b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f422687c;

    /* renamed from: d, reason: collision with root package name */
    private int f422688d = -1;

    public a(IEmoticonMainPanelApp iEmoticonMainPanelApp, CoroutineScope coroutineScope) {
        this.f422685a = iEmoticonMainPanelApp;
        this.f422686b = coroutineScope;
    }

    private String a() {
        if (ZPlanFeatureSwitch.f369852a.d0()) {
            return "130105.130105002";
        }
        return "1000205";
    }

    public void b(int i3) {
        QLog.i("[zplan][ZPlanEmoticonTabListener]", 1, "onZPlanTabRedDotClick, position:" + i3);
        IEmoticonMainPanelApp iEmoticonMainPanelApp = this.f422685a;
        if (iEmoticonMainPanelApp == null || iEmoticonMainPanelApp.getQQAppInterface() == null || this.f422688d != i3) {
            return;
        }
        ZPlanEmoticonTabAvatarManager.f333345a.H();
        ImageView imageView = this.f422687c;
        if (imageView == null || imageView.getVisibility() == 8) {
            return;
        }
        ((IRedTouchManager) this.f422685a.getQQAppInterface().getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(a());
        this.f422687c.setVisibility(8);
    }

    public void c() {
        IEmoticonMainPanelApp iEmoticonMainPanelApp;
        if (this.f422687c != null && (iEmoticonMainPanelApp = this.f422685a) != null && iEmoticonMainPanelApp.getQQAppInterface() != null) {
            if (ZPlanFeatureSwitch.f369852a.b3()) {
                String a16 = a();
                IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f422685a.getQQAppInterface().getRuntimeService(IRedTouchManager.class, "");
                BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(a16);
                if (appInfoByPath == null) {
                    QLog.w("[zplan][ZPlanEmoticonTabListener]", 1, "updateZPlanRedDot, info == null");
                    return;
                }
                QLog.i("[zplan][ZPlanEmoticonTabListener]", 1, "updateZPlanRedDot, newFlag:" + appInfoByPath.iNewFlag.get());
                if (appInfoByPath.iNewFlag.get() == 1) {
                    this.f422687c.setVisibility(0);
                    iRedTouchManager.reportLevelOneRedInfo(a16, 30);
                    return;
                } else {
                    this.f422687c.setVisibility(8);
                    return;
                }
            }
            return;
        }
        QLog.w("[zplan][ZPlanEmoticonTabListener]", 1, "updateZPlanRedDot, view or app is null, mRedDotView=" + this.f422687c + ", app=" + this.f422685a);
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionTabCreateListener
    public void onCreateTabView(View view, URLImageView uRLImageView, ImageView imageView, int i3) {
        this.f422687c = imageView;
        this.f422688d = i3;
        ZPlanEmoticonTabAvatarManager.f333345a.O(this.f422686b, new WeakReference<>(uRLImageView));
    }
}
