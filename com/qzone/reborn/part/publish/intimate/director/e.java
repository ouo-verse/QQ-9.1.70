package com.qzone.reborn.part.publish.intimate.director;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.publish.business.task.QZoneBaseUploadTask;
import com.qzone.publish.business.task.intimate.QZoneUploadIntimateTask;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.qzone.reborn.part.publish.common.inputarea.QZoneInputAreaInfo;
import com.qzone.reborn.part.publish.common.mediapick.QZoneMediaPickInfo;
import com.qzone.reborn.part.publish.intimate.QZoneIntimateDraftInfo;
import com.qzone.reborn.util.i;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sm.j;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e extends k {
    private vl.f C;
    private QZoneIntimateWriteMoodInitBean D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    List<ql.a> f58636d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ActionSheet f58637e;

    /* renamed from: f, reason: collision with root package name */
    private tl.h f58638f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.reborn.part.publish.common.inputarea.d f58639h;

    /* renamed from: i, reason: collision with root package name */
    private ul.d f58640i;

    /* renamed from: m, reason: collision with root package name */
    private sl.b f58641m;

    private void G9() {
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "clearDraft");
        rl.a.b("INTIMATE_MOOD", LoginData.getInstance().getUin());
    }

    private String I9(String str) {
        return "INTIMATE_MOOD_" + str;
    }

    private void J9() {
        QZoneIntimateDraftInfo qZoneIntimateDraftInfo = (QZoneIntimateDraftInfo) rl.a.d("INTIMATE_MOOD", LoginData.getInstance().getUin(), QZoneIntimateDraftInfo.class);
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "[initDraft] draftInfo:" + qZoneIntimateDraftInfo);
        if (qZoneIntimateDraftInfo != null) {
            this.f58638f.N1(qZoneIntimateDraftInfo.mediaPickInfo);
            this.f58639h.N1(qZoneIntimateDraftInfo.inputAreaInfo);
        }
        boolean d16 = i.b().d(I9("SYNC_FRIEND_FEED_FLAG"), false);
        this.f58640i.N1(Boolean.valueOf(d16));
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "[initDraft] needSyncFriendFeed:" + d16);
    }

    private void K9(Activity activity) {
        String spaceId;
        QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = (QZoneIntimateWriteMoodInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        this.D = qZoneIntimateWriteMoodInitBean;
        if (qZoneIntimateWriteMoodInitBean == null) {
            spaceId = "";
        } else {
            spaceId = qZoneIntimateWriteMoodInitBean.getSpaceId();
        }
        this.E = spaceId;
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "[initViewModel] mSpaceId:" + this.E);
        this.f58638f = (tl.h) getViewModel(tl.h.class);
        this.f58639h = (com.qzone.reborn.part.publish.common.inputarea.d) getViewModel(com.qzone.reborn.part.publish.common.inputarea.d.class);
        this.f58640i = (ul.d) getViewModel(ul.d.class);
        this.f58641m = (sl.b) getViewModel(sl.b.class);
        this.C = (vl.f) getViewModel(vl.f.class);
        this.f58636d.add(this.f58638f);
        this.f58636d.add(this.f58639h);
        DynamicArrayList<String> value = this.f58638f.P1().getValue();
        if (value != null) {
            value.getLiveData().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.part.publish.intimate.director.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.this.M9((ArrayList) obj);
                }
            });
        }
        this.f58639h.T1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.part.publish.intimate.director.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.N9((ExtendEditText) obj);
            }
        });
    }

    private void L9() {
        QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = this.D;
        if (qZoneIntimateWriteMoodInitBean == null || qZoneIntimateWriteMoodInitBean.getInsertSpacePage() != 1 || getPartHost() == null || getPartHost().getHostActivity() == null) {
            return;
        }
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        qZoneIntimateMainPageInitBean.setSpaceId(this.E);
        qZoneIntimateMainPageInitBean.setAdId(this.D.getAdId());
        ho.i.o().r(getPartHost().getHostActivity(), qZoneIntimateMainPageInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(ArrayList arrayList) {
        Q9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(ExtendEditText extendEditText) {
        Q9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(Activity activity, View view, int i3) {
        if (this.f58637e == null) {
            return;
        }
        if (i3 == 0) {
            R9();
        } else if (i3 == 1) {
            G9();
            S9(false);
        }
        L9();
        activity.finish();
        this.f58637e.superDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "user click cancel");
        this.f58637e.superDismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Q9() {
        boolean U1 = this.f58638f.U1();
        boolean X1 = this.f58639h.X1();
        boolean z16 = true;
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "[onContentChange] haveMediaContent:" + U1 + ",haveTextContent:" + X1);
        MutableLiveData<Boolean> O1 = this.C.O1();
        if (!U1 && !X1) {
            z16 = false;
        }
        O1.postValue(Boolean.valueOf(z16));
    }

    private void R9() {
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "saveDraft");
        QZoneMediaPickInfo O1 = this.f58638f.O1();
        QZoneInputAreaInfo O12 = this.f58639h.O1();
        QZoneIntimateDraftInfo qZoneIntimateDraftInfo = new QZoneIntimateDraftInfo();
        qZoneIntimateDraftInfo.mediaPickInfo = O1;
        qZoneIntimateDraftInfo.inputAreaInfo = O12;
        rl.a.e("INTIMATE_MOOD", qZoneIntimateDraftInfo, LoginData.getInstance().getUin());
        S9(false);
    }

    private void S9(boolean z16) {
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "[setNeedSyncFriendFeedFlag] " + z16);
        i.b().l(I9("SYNC_FRIEND_FEED_FLAG"), z16);
    }

    private void T9() {
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        broadcastMessage("close_input_panel", null);
        ActionSheet actionSheet = this.f58637e;
        if (actionSheet == null || !actionSheet.isShowing()) {
            ActionSheet create = ActionSheet.create(activity);
            this.f58637e = create;
            create.setMainTitle(R.string.glm);
            this.f58637e.addButton(R.string.gnh, 1);
            this.f58637e.addButton(R.string.f173019gi3, 3);
            this.f58637e.addCancelButton(R.string.cancel);
            this.f58637e.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.part.publish.intimate.director.c
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    e.this.O9(activity, view, i3);
                }
            });
            this.f58637e.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.intimate.director.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.P9(view);
                }
            });
            this.f58637e.show();
        }
    }

    public void H9() {
        RFWLog.d("QZoneIntimateDirectorPart", RFWLog.USR, "[doPublish]");
        MutableLiveData<Boolean> O1 = this.f58640i.O1();
        boolean booleanValue = (O1 == null || O1.getValue() == null) ? false : O1.getValue().booleanValue();
        S9(booleanValue);
        QZoneMediaPickInfo O12 = this.f58638f.O1();
        QZoneUploadIntimateTask.IntimatePublishParams intimatePublishParams = new QZoneUploadIntimateTask.IntimatePublishParams(this.E);
        intimatePublishParams.content = this.f58639h.P1().inputContent;
        QZoneBaseUploadTask.UploadParams d16 = j.d(getContext(), "INTIMATE_MOOD", O12.selectMediaPathList, O12.selectedMediaInfoMap, false);
        d16.extendInfo.put("uid", LoginData.getInstance().getUid());
        intimatePublishParams.uploadParams = d16;
        intimatePublishParams.needSyncFriendFeed = booleanValue;
        intimatePublishParams.poiInfo = this.f58641m.O1().getValue();
        intimatePublishParams.publishTime = System.currentTimeMillis() / 1000;
        new QZoneUploadIntimateTask(6, intimatePublishParams).addToTaskQueen();
        G9();
        L9();
        getPartHost().getHostActivity().finish();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "publish_btn_clk")) {
            H9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Iterator<ql.a> it = this.f58636d.iterator();
        while (it.hasNext()) {
            if (it.next().M1()) {
                T9();
                return true;
            }
        }
        L9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        K9(activity);
        J9();
    }
}
