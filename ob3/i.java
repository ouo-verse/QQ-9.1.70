package ob3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.ui.WechatBindingAndAuthContentView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.wxsetting.WxMiniBindingLogic;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lob3/i;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/View;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "", "J", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wxsetting/WxMiniBindingLogic;", "k", "Lcom/tencent/mobileqq/wxsetting/WxMiniBindingLogic;", "mWxMiniBindingLogic", "l", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends w<View> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private WxMiniBindingLogic mWxMiniBindingLogic;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Lifecycle lifecycle;

    @Override // com.tencent.mobileqq.widget.listitem.w
    public String C() {
        String string = MobileQQ.sMobileQQ.getString(R.string.xzn);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026x_mini_use_binding_title)");
        return string;
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    protected View H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QLog.i("WxMiniBindingSettingConfig", 1, "WxMiniBindingSettingConfig onCreateView");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        WechatBindingAndAuthContentView wechatBindingAndAuthContentView = new WechatBindingAndAuthContentView(context);
        wechatBindingAndAuthContentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        WxMiniBindingLogic wxMiniBindingLogic = new WxMiniBindingLogic(wechatBindingAndAuthContentView);
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.addObserver(wxMiniBindingLogic);
        }
        this.mWxMiniBindingLogic = wxMiniBindingLogic;
        Intrinsics.checkNotNull(wxMiniBindingLogic);
        wxMiniBindingLogic.x(1);
        WxMiniBindingLogic wxMiniBindingLogic2 = this.mWxMiniBindingLogic;
        Intrinsics.checkNotNull(wxMiniBindingLogic2);
        wxMiniBindingLogic2.w(1);
        return wechatBindingAndAuthContentView;
    }

    public final void J(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        WxMiniBindingLogic wxMiniBindingLogic = this.mWxMiniBindingLogic;
        if (wxMiniBindingLogic != null) {
            lifecycle.addObserver(wxMiniBindingLogic);
        }
        this.lifecycle = lifecycle;
    }
}
