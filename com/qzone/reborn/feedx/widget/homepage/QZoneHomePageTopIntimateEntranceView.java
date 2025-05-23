package com.qzone.reborn.feedx.widget.homepage;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.homepage.ui.component.newpanel.HomePanelItem;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTopIntimateEntranceView;", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneHomePageTopEntrancePanelItemView;", "Lcom/qzone/homepage/ui/component/newpanel/HomePanelItem;", "itemInfo", "", "A0", "B0", "w0", "p0", "", "r0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneHomePageTopIntimateEntranceView extends QZoneHomePageTopEntrancePanelItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneHomePageTopIntimateEntranceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A0(HomePanelItem itemInfo) {
        B0(itemInfo);
    }

    private final void B0(HomePanelItem itemInfo) {
        if (this.C == null || itemInfo.tabId != 16) {
            return;
        }
        final ArrayList<String> g16 = QZoneIntimateEntranceManager.g(1);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.homepage.g
            @Override // java.lang.Runnable
            public final void run() {
                QZoneHomePageTopIntimateEntranceView.C0(g16, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(ArrayList arrayList, QZoneHomePageTopIntimateEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            this$0.D = (String) arrayList.get(0);
        }
        if (!TextUtils.isEmpty(this$0.D)) {
            this$0.f56386i.setVisibility(8);
            QLog.i("QZoneHomePageTopEntrancePanelItemView", 1, "entrance uin is " + this$0.D);
            try {
                String mEntranceAvatarUin = this$0.D;
                Intrinsics.checkNotNullExpressionValue(mEntranceAvatarUin, "mEntranceAvatarUin");
                this$0.C.setUser(Long.parseLong(mEntranceAvatarUin));
                this$0.C.setVisibility(0);
                return;
            } catch (Exception e16) {
                QLog.e("QZoneHomePageTopEntrancePanelItemView", 1, "exception is " + e16);
                this$0.C.setVisibility(8);
                this$0.f56386i.setVisibility(0);
                return;
            }
        }
        this$0.f56386i.setVisibility(0);
        this$0.C.setVisibility(8);
    }

    @Override // com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntrancePanelItemView
    public int r0() {
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntrancePanelItemView
    public void w0(HomePanelItem itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        super.w0(itemInfo);
        A0(itemInfo);
    }

    @Override // com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntrancePanelItemView
    public void onDestroy() {
    }

    @Override // com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntrancePanelItemView
    protected void p0() {
    }
}
