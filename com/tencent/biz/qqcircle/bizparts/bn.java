package com.tencent.biz.qqcircle.bizparts;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleSpecialFollowListBlock;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bn extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name */
    private QUISecNavBar f82956d;

    /* renamed from: e, reason: collision with root package name */
    private QUISettingsRecyclerView f82957e;

    /* renamed from: f, reason: collision with root package name */
    private QUIListItemAdapter f82958f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                bn.this.B9();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f82960d;

        b(Runnable runnable) {
            this.f82960d = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Runnable runnable = this.f82960d;
            if (runnable != null) {
                runnable.run();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B9() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    private Group C9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(D9(com.tencent.biz.qqcircle.utils.h.a(R.string.f185123nq), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.bl
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.H9();
            }
        }));
        arrayList.add(D9(com.tencent.biz.qqcircle.utils.h.a(R.string.f184113l0), new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.bm
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.G9();
            }
        }));
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private com.tencent.mobileqq.widget.listitem.x D9(String str, Runnable runnable) {
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(str), new x.c.g("", true, false));
        xVar.x(new b(runnable));
        return xVar;
    }

    private String E9(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSMoreSettingContentPart", 1, "[getNoticeSettingPageUrl] PushSetting Config is null");
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("items");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject == null) {
                    string = null;
                } else {
                    string = jSONObject.getString("imgToken");
                }
                if (string != null && TextUtils.equals("small_world_02", string)) {
                    return jSONObject.getString(WadlProxyConsts.KEY_JUMP_URL);
                }
            }
        } catch (JSONException e16) {
            QLog.e("QFSMoreSettingContentPart", 1, "[getNoticeSettingPageUrl] JSON Convert failed: " + e16);
        }
        return null;
    }

    private void F9(View view) {
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.f47421x9);
        this.f82956d = qUISecNavBar;
        qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        this.f82956d.setAutoAdaptTransparent(true);
        this.f82956d.setTitleAlpha(0.0f);
        this.f82956d.setLeftImageRes(R.drawable.qui_chevron_left);
        this.f82956d.setOnBaseTitleBarClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        String E9 = E9(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("growth_business_push_switch_config", ""));
        if (TextUtils.isEmpty(E9)) {
            QLog.e("QFSMoreSettingContentPart", 1, "[jumpNoticeSetting] jumpUrl is null");
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), E9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9() {
        QCircleFollowUserBean qCircleFollowUserBean = new QCircleFollowUserBean();
        qCircleFollowUserBean.setFromReportBean(getReportBean());
        qCircleFollowUserBean.setAdapterClassName(QCircleSpecialFollowListBlock.class.getName());
        com.tencent.biz.qqcircle.launcher.c.J(getContext(), qCircleFollowUserBean);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMoreSettingContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        F9(view);
        this.f82957e = (QUISettingsRecyclerView) view.findViewById(R.id.f47411x8);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        this.f82958f = qUIListItemAdapter;
        this.f82957e.setAdapter(qUIListItemAdapter);
        this.f82958f.t0(C9());
    }
}
