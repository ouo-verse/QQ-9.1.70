package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e extends com.qzone.reborn.feedx.part.g {

    /* renamed from: d, reason: collision with root package name */
    public ActionSheet f55357d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f55358e;

    /* renamed from: f, reason: collision with root package name */
    protected ActionSheet.WatchDismissActions f55359f = new ActionSheet.WatchDismissActions() { // from class: com.qzone.reborn.feedx.part.userhome.d
        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public final void onDismissOperations() {
            e.this.L9();
        }
    };

    /* renamed from: h, reason: collision with root package name */
    protected ActionSheet.OnButtonClickListener f55360h = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            e eVar = e.this;
            if (eVar.f55357d == null) {
                return;
            }
            ActionSheetHelper.dismissActionSheet(eVar.getActivity(), e.this.f55357d);
            ActionMenuItem actionMenuItem = e.this.f55357d.getActionMenuItem(i3);
            if (actionMenuItem == null) {
                return;
            }
            int i16 = actionMenuItem.action;
            if (i16 == 207) {
                e.this.f55358e.m3(e.this.getActivity());
                return;
            }
            if (i16 == 223) {
                ho.i.z().k(e.this.getActivity(), e.this.f55358e.getMUin());
                LpReportInfo_pf00064.allReport(308, 9, 22);
                return;
            }
            if (i16 == 229) {
                ho.i.z().e(e.this.getActivity(), e.this.f55358e.C2().getValue());
                return;
            }
            if (i16 == 233) {
                vo.c.N(e.this.getActivity(), false);
                return;
            }
            if (i16 != 234) {
                switch (i16) {
                    case 225:
                        ho.i.z().q(e.this.getActivity(), e.this.f55358e.C2().getValue(), false);
                        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(308, 9, 24), false, false);
                        return;
                    case 226:
                        e.this.H9();
                        return;
                    case 227:
                        ho.i.z().v(e.this.getActivity(), e.this.f55358e.getMUin());
                        return;
                    default:
                        return;
                }
            }
            vo.c.G(e.this.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(x6.a aVar) {
        if (this.f55358e.M2()) {
            J9(aVar);
        } else {
            I9(aVar);
        }
    }

    public ActionMenuItem G9(int i3, int i16, int i17) {
        return new ActionMenuItem(i3, ActionSheetHelper.getStringById(getActivity(), i16), i3, 0, i17);
    }

    protected void H9() {
        com.qzone.adapter.feedcomponent.i.H().s(TextCellParser.toPlainText(this.f55358e.getMUin() + ""));
        LpReportInfo_pf00064.allReport(308, 9, 11);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeActionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        ActionSheet actionSheet;
        super.handleBroadcastMessage(str, obj);
        if (!TextUtils.equals(str, "OPEN_USER_HOME_ACTION_PANEL") || (actionSheet = this.f55357d) == null) {
            return;
        }
        actionSheet.show();
        Window window = this.f55357d.getWindow();
        if (window != null) {
            QUIImmersiveHelper.u(window, true, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f55358e = wVar;
        wVar.C2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.userhome.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.K9((x6.a) obj);
            }
        });
    }

    public ActionMenuItem F9(int i3, int i16) {
        return G9(i3, i16, 1);
    }

    private void I9(x6.a aVar) {
        if (aVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(F9(225, R.string.gha));
        arrayList.add(F9(226, R.string.gh7));
        boolean z16 = aVar.isFollowed;
        arrayList.add(G9(207, z16 ? R.string.ia6 : R.string.bbc, z16 ? 2 : 1));
        if (!aVar.isCertification && !aVar.isStarSpaceUser()) {
            if (aVar.isSchoolSpaceUser() && QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_HOMEPAGE_BAR, QzoneConfig.SECONDARY_USERHOME_MORE_MENU_FRIEND_FEED_SETTING_SHOW, 1) != 0) {
                arrayList.add(F9(227, R.string.gh5));
            }
        } else if (aVar.isFollowed) {
            arrayList.add(F9(229, R.string.gh8));
        }
        arrayList.add(F9(223, R.string.f21929661));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, this.f55360h);
        this.f55357d = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        this.f55357d.registerWatchDisMissActionListener(this.f55359f);
    }

    protected void J9(x6.a aVar) {
        if (aVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(F9(225, R.string.gha));
        arrayList.add(F9(233, R.string.f2196166w));
        if (aVar.isSchoolSpaceUser() && QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_HOMEPAGE_BAR, QzoneConfig.SECONDARY_USERHOME_MORE_MENU_FRIEND_FEED_SETTING_SHOW, 0) != 0) {
            arrayList.add(F9(227, R.string.gh5));
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_master_more_feed_back", true)) {
            arrayList.add(F9(234, R.string.f2196366y));
        }
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, this.f55360h);
        this.f55357d = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        this.f55357d.registerWatchDisMissActionListener(this.f55359f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L9() {
        LpReportInfo_pf00064.allReport(308, 9, 8);
    }
}
