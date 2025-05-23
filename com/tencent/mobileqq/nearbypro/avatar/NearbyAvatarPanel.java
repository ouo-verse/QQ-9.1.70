package com.tencent.mobileqq.nearbypro.avatar;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.status.SquareOnlineStatusViewPanel;
import com.tencent.state.status.StatusPanelData;
import com.tencent.state.view.TitleData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0014R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarPanel;", "Lcom/tencent/state/status/SquareOnlineStatusViewPanel;", "", "f", "getHeightOutScreen", "e", "Lcom/tencent/state/view/TitleData;", "data", "", "reportTitleClick", "Lcom/tencent/state/status/StatusPanelData;", "", "hasRecorded", "reportPanelItemClick", "titleData", "reportTitleImp", "Lcom/tencent/state/square/mmkv/IMMKV;", "getMmkv", "()Lcom/tencent/state/square/mmkv/IMMKV;", "mmkv", "Lcom/tencent/state/square/IReporter;", "getReporter", "()Lcom/tencent/state/square/IReporter;", "reporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyAvatarPanel extends SquareOnlineStatusViewPanel {

    /* renamed from: e, reason: collision with root package name */
    private static final int f253188e = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cwg);

    /* renamed from: f, reason: collision with root package name */
    private static final int f253189f = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cwh);

    /* renamed from: h, reason: collision with root package name */
    private static final int f253190h = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cwf);

    /* renamed from: i, reason: collision with root package name */
    private static final int f253191i = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cwj);

    /* renamed from: m, reason: collision with root package name */
    private static final int f253192m = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cwk);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NearbyAvatarPanel(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int f() {
        try {
            int e16 = e();
            j.c().c("NearbyAvatarPanel", "avatarHeight:" + f253188e + " bubbleHeight:" + f253189f + " marginHeight:" + f253190h + " panelHeight:" + f253191i + " screenHeight:" + e16);
            if (e16 <= 0) {
                j.c().d("NearbyAvatarPanel", "screenHeight <= 0");
                return 0;
            }
            int i3 = f253188e;
            int i16 = f253189f;
            int i17 = f253190h;
            int i18 = f253191i;
            int i19 = f253192m;
            if (i3 + i16 + i17 + i18 + i19 <= e16) {
                return 0;
            }
            j.c().e("NearbyAvatarPanel", "avatarHeight:" + f253188e + " bubbleHeight:" + f253189f + " marginHeight:" + f253190h + " panelHeight:" + f253191i + " screenHeight:" + e16);
            return ((((i3 + i16) + i17) + i18) + i19) - e16;
        } catch (Exception e17) {
            j.c().d("NearbyAvatarPanel", "heightOutScreen " + e17);
            return 0;
        }
    }

    public final int e() {
        WindowManager windowManager;
        Object systemService = BaseApplication.getContext().getSystemService("window");
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        if (windowManager == null) {
            return 0;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel
    public int getHeightOutScreen() {
        return f();
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel
    @NotNull
    public IMMKV getMmkv() {
        return e.f253209a;
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel
    @NotNull
    public IReporter getReporter() {
        return c.f253205a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel
    public void reportPanelItemClick(@NotNull StatusPanelData data, boolean hasRecorded) {
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        hashMap.put("nearby_event_type", "clck");
        hashMap.put("nearby_status_id", String.valueOf(data.getStatus().getTopStatusId()));
        hashMap.put("nearby_action_id", String.valueOf(data.getStatus().getRichStatus()));
        VideoReport.reportEvent("ev_nearby_status_icon", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel
    public void reportTitleClick(@NotNull TitleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        hashMap.put("nearby_event_type", "clck");
        hashMap.put("nearby_tab_type", data.getText());
        VideoReport.reportEvent("ev_nearby_status_choose_tab", hashMap);
    }

    @Override // com.tencent.state.status.SquareOnlineStatusViewPanel
    protected void reportTitleImp(@NotNull TitleData titleData) {
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        hashMap.put("nearby_event_type", "imp");
        hashMap.put("nearby_tab_type", titleData.getText());
        VideoReport.reportEvent("ev_nearby_status_choose_tab", hashMap);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NearbyAvatarPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NearbyAvatarPanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NearbyAvatarPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
