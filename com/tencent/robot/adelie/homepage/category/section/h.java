package com.tencent.robot.adelie.homepage.category.section;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.adelie.homepage.category.viewmodel.RegularDelegateData;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.qqmc.model.RobotHomeSuperResolutionUinBlacklist;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h extends Section<RegularDelegateData> {
    private Map<String, String> C;
    private AdelieHomeCardHotView D;
    private String E = "";
    private String F = "";

    /* renamed from: d, reason: collision with root package name */
    private RoundImageView f366022d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f366023e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f366024f;

    /* renamed from: h, reason: collision with root package name */
    private View f366025h;

    /* renamed from: i, reason: collision with root package name */
    private View f366026i;

    /* renamed from: m, reason: collision with root package name */
    private Context f366027m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RobotCoreInfo f366028d;

        a(RobotCoreInfo robotCoreInfo) {
            this.f366028d = robotCoreInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FastClickUtils.isFastDoubleClick("AdelieHomePageSection")) {
                if (QLog.isColorLevel()) {
                    QLog.d("AdelieHomePageSection", 1, "mItemContainer onClick return, click too fast");
                }
            } else {
                if (je0.a.a(BaseApplication.getContext())) {
                    str = this.f366028d.bgNight;
                } else {
                    str = this.f366028d.bgDay;
                }
                ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackgroundUrl(str, true);
                com.tencent.robot.profile.utils.a.v(this.f366028d);
                AIOUtil.f366629a.d(h.this.f366027m, this.f366028d, "27", null);
                VideoReport.reportEvent("clck", ((Section) h.this).mRootView, h.this.C);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void s(View view, RobotCoreInfo robotCoreInfo) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_bas_agent_card");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        if (robotCoreInfo != null) {
            HashMap hashMap = new HashMap();
            this.C = hashMap;
            hashMap.put("agent_name", robotCoreInfo.name);
            this.C.put("agent_id", robotCoreInfo.uid);
            this.C.put("creator_uid", robotCoreInfo.creatorUid);
            this.C.put("trace_id", "");
            this.C.put("serial_number", String.valueOf(robotCoreInfo.serialNumber));
            this.C.put("agent_uin", String.valueOf(robotCoreInfo.robotUin));
            this.C.put("found_uin", "");
            this.C.put("tab_name", this.E);
            this.C.put("tabid", this.F);
            VideoReport.setElementParams(view, this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        this.mRootView.setOnClickListener(null);
        this.f366022d = null;
        this.f366023e = null;
        this.f366024f = null;
        this.D = null;
        this.f366026i = null;
        this.f366025h = null;
        this.f366027m = null;
        Map<String, String> map = this.C;
        if (map != null) {
            map.clear();
        }
        this.C = null;
        this.mSectionHost = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f366022d = (RoundImageView) view.findViewById(R.id.dvo);
        this.f366023e = (TextView) view.findViewById(R.id.tv_name);
        this.f366024f = (TextView) view.findViewById(R.id.f167042k73);
        this.f366026i = view.findViewById(R.id.efa);
        this.f366025h = view.findViewById(R.id.f70623ly);
        this.D = (AdelieHomeCardHotView) view.findViewById(R.id.xbw);
        Context context = view.getContext();
        this.f366027m = context;
        FontSettingManager.resetViewSize2Normal(context, view);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean z16) {
        super.onVisibleChanged(z16);
        if (z16) {
            VideoReport.reportEvent("imp", this.mRootView, this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(RegularDelegateData regularDelegateData, int i3, List<Object> list) {
        this.E = regularDelegateData.getTabName();
        this.F = regularDelegateData.getTabId();
        RobotCoreInfo data = regularDelegateData.getData();
        if (data == null) {
            return;
        }
        s(this.mRootView, data);
        this.mRootView.setOnClickListener(new a(data));
        this.f366026i.setVisibility(8);
        this.f366025h.setVisibility(0);
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        if (RobotHomeSuperResolutionUinBlacklist.INSTANCE.b(String.valueOf(data.robotUin))) {
            CommonExKt.g(this.f366022d, data.robotAvatar, drawable, drawable, null);
        } else {
            CommonExKt.i(this.f366022d, com.tencent.robot.adelie.homepage.g.f366352a.b(), data.robotAvatar, drawable, drawable, null, null);
        }
        this.f366023e.setText(data.name);
        this.f366023e.setTypeface(Typeface.defaultFromStyle(1));
        this.f366024f.setText(data.desc);
        AdelieHomeCardHotView adelieHomeCardHotView = this.D;
        if (adelieHomeCardHotView != null) {
            adelieHomeCardHotView.setHotNumber(data.hotNumber);
        }
    }
}
