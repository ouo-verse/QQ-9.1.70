package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.detail.ui.component.g;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.QQCustomArkDialogUtil;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import qzonemoment.QZMomentMeta$StShare;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ab extends an.a implements gn.e {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.detail.ui.component.g f58944d;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.qzmoment.viewmodel.g f58945e;

    private List<ShareActionSheetBuilder.ActionSheetItem> H9() {
        ArrayList arrayList = new ArrayList();
        if (N9()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        }
        return arrayList;
    }

    private void I9(String str, bn.b bVar) {
        if (!TextUtils.isEmpty(str) && bVar != null) {
            com.qzone.detail.ui.component.g gVar = this.f58944d;
            if (gVar == null || gVar.getActionSheet() == null || this.f58944d.getActionSheet().getRootView() == null) {
                return;
            }
            ViewGroup rootView = this.f58944d.getActionSheet().getRootView();
            HashMap hashMap = new HashMap();
            hashMap.put("operated_feed", bVar.a().f430362id.get());
            hashMap.put("author_id", bVar.a().poster.f430367id.get());
            fo.b l3 = new fo.b().l(hashMap);
            VideoReport.setLogicParent(rootView, getPartRootView());
            fo.c.b(str, rootView, "em_custom_report_default_element_id", l3);
            return;
        }
        QLog.e("QZMSharePanelPart", 1, "dtCustomReportItem  params error");
    }

    private void K9(final bn.d dVar) {
        DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.f1333960), (CharSequence) null, HardCodeUtil.qqStr(R.string.f133375y), HardCodeUtil.qqStr(R.string.f133385z), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ab.this.O9(dVar, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.aa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    private void L9(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, bn.d dVar) {
        QLog.i("QZMSharePanelPart", 1, "handleOnClickSharePanelItem  action = " + actionSheetItem.action);
        int i3 = actionSheetItem.action;
        if (i3 != 2) {
            if (i3 == 11) {
                QQToast.makeText(getActivity(), 2, R.string.f133335u, 0).show();
                return;
            }
            if (i3 == 26) {
                actionSheetItem.uin = AppConstants.DATALINE_NEW_VERSION_UIN;
                actionSheetItem.label = BaseApplication.getContext().getString(R.string.f187533u9);
            } else if (i3 == 40) {
                K9(dVar);
                return;
            } else if (i3 != 72 && i3 != 73) {
                return;
            }
        }
        com.qzone.reborn.qzmoment.viewmodel.g gVar = this.f58945e;
        if (gVar != null) {
            gVar.b2(dVar, actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M9, reason: merged with bridge method [inline-methods] */
    public void Q9(UIStateData<bn.i> uIStateData) {
        if (uIStateData == null) {
            QLog.e("QZMSharePanelPart", 1, "handleRspOperation  uiStateData == null");
            return;
        }
        if (uIStateData.getRetCode() == 0 && uIStateData.getData() != null && uIStateData.getData().a() != null) {
            QLog.i("QZMSharePanelPart", 1, "handleRspOperation  action = " + uIStateData.getData().a().action);
            int i3 = uIStateData.getData().a().action;
            if (i3 != 2) {
                if (i3 == 72) {
                    U9(uIStateData.getData());
                    return;
                } else if (i3 != 73) {
                    return;
                }
            }
            T9(uIStateData.getData());
            return;
        }
        QQToast.makeText(getActivity(), 1, uIStateData.getMsg(), 0).show();
        QLog.e("QZMSharePanelPart", 1, "handleRspOperation  show error | retCode = " + uIStateData.getRetCode() + " | data = " + uIStateData.getData());
    }

    private boolean N9() {
        return QZoneConfigHelper.r0() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9(bn.d dVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        shareActionSheet.dismiss();
        L9(actionSheetItem, dVar);
    }

    private void S9(final bn.d dVar) {
        if (this.f58944d == null) {
            g.a aVar = new g.a();
            aVar.context = getContext();
            com.qzone.detail.ui.component.g gVar = new com.qzone.detail.ui.component.g(aVar);
            this.f58944d = gVar;
            gVar.setActionSheetTitle(HardCodeUtil.qqStr(R.string.hja));
            this.f58944d.setIntentForStartForwardRecentActivity(new Intent());
        }
        if (this.f58944d.isShowing()) {
            return;
        }
        this.f58944d.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.qzone.reborn.qzmoment.part.y
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                ab.this.R9(dVar, actionSheetItem, shareActionSheet);
            }
        });
        this.f58944d.setRowVisibility(N9() ? 0 : 8, 0, 0);
        this.f58944d.setActionSheetItems(H9(), G9(dVar));
        this.f58944d.show();
    }

    @Override // gn.e
    public void F0(bn.d dVar) {
        V9(dVar);
        S9(dVar);
    }

    public Intent J9(QZMomentMeta$StShare qZMomentMeta$StShare) {
        Intent intent = new Intent(getActivity(), (Class<?>) ForwardRecentActivity.class);
        try {
            JSONObject jSONObject = new JSONObject(qZMomentMeta$StShare.shareCardInfo.get());
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("ver");
            String optString3 = jSONObject.optString("view");
            String optString4 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String optString5 = jSONObject.optString("prompt");
            String optString6 = jSONObject.optString(DownloadInfo.spKey_Config);
            String optString7 = jSONObject.optString("desc");
            intent.putExtra("forward_type", 27);
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", optString);
            intent.putExtra("forward_ark_app_view", optString3);
            intent.putExtra("forward_ark_app_ver", optString2);
            intent.putExtra("forward_ark_app_prompt", optString5);
            intent.putExtra("forward_ark_app_meta", optString4);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString6);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString7);
            if (!TextUtils.isEmpty(optString4) && optString4.contains("\"isAIO\":1")) {
                optString4 = optString4.replace("\"isAIO\":1", "\"isAIO\":0");
            }
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(optString, optString3, optString2, optString4, null));
        } catch (JSONException e16) {
            QLog.d("QZMSharePanelPart", 1, "getShareArkIntent  exception message: " + e16.getMessage());
        }
        return intent;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.qzone.reborn.qzmoment.viewmodel.g gVar = (com.qzone.reborn.qzmoment.viewmodel.g) getViewModel(com.qzone.reborn.qzmoment.viewmodel.g.class);
        this.f58945e = gVar;
        gVar.S1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.qzmoment.part.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.this.Q9((UIStateData) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        registerIoc(this, gn.e.class);
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> G9(bn.d dVar) {
        if (dVar == null || dVar.f28666a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(LoginData.getInstance().getUinString(), dVar.f28666a.a().poster.f430367id.get())) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
            I9("now_delete_exposure", dVar.f28666a);
        } else {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(bn.d dVar, DialogInterface dialogInterface, int i3) {
        bn.b bVar;
        if (dVar == null || (bVar = dVar.f28666a) == null) {
            return;
        }
        com.qzone.reborn.qzmoment.viewmodel.g gVar = this.f58945e;
        if (gVar != null) {
            gVar.a2(bVar.a());
        }
        I9("now_delete_click", dVar.f28666a);
    }

    private void T9(bn.i iVar) {
        if (iVar == null || iVar.b() == null) {
            return;
        }
        getActivity().startActivityForResult(J9(iVar.b()), 21);
    }

    private void U9(bn.i iVar) {
        if (iVar == null || iVar.b() == null || iVar.a() == null) {
            return;
        }
        Intent J9 = J9(iVar.b());
        J9.putExtra(((IForwardApi) QRoute.api(IForwardApi.class)).KEY_REQ(), ((IForwardApi) QRoute.api(IForwardApi.class)).REQ_DIRECT_SHOW_DIALOG());
        J9.putExtra(((IForwardApi) QRoute.api(IForwardApi.class)).KEY_DIRECT_SHOW_UIN_TYPE(), iVar.a().uinType);
        J9.putExtra(((IForwardApi) QRoute.api(IForwardApi.class)).KEY_DIRECT_SHOW_UIN(), iVar.a().uin);
        ForwardBaseOption.startForwardActivityForResult(getActivity(), J9, (Class<?>) ForwardRecentTranslucentActivity.class, 19005);
    }

    private void V9(bn.d dVar) {
        if (dVar == null || dVar.f28666a == null) {
            return;
        }
        PreLoader.remove("qzm_feed_share_data_preload_id");
        PreLoader.preLoad("qzm_feed_share_data_preload_id", new com.qzone.reborn.qzmoment.preload.d(dVar.f28666a.a()));
    }
}
