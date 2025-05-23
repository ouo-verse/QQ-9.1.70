package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.feedx.event.QZoneChooseUserHomeQuestionEvent;
import com.qzone.reborn.feedx.event.QZoneShowUserHomeQuestionListEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cn extends com.qzone.reborn.base.k implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.t f55128d;

    private void E9(String str) {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneChooseUserHomeQuestionEvent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9(ActionSheet actionSheet, View view, int i3, String str) {
        E9(str);
        actionSheet.dismiss();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneShowUserHomeQuestionListEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneUserHomeQuestionListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55128d = (com.qzone.reborn.feedx.viewmodel.t) getViewModel(com.qzone.reborn.feedx.viewmodel.t.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneShowUserHomeQuestionListEvent) {
            G9(((QZoneShowUserHomeQuestionListEvent) simpleBaseEvent).mQuestionList);
        }
    }

    private void D9(ActionSheet actionSheet, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            actionSheet.addButton(arrayList.get(i3));
        }
    }

    private void G9(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
        D9(actionSheet, arrayList);
        actionSheet.setOnButtonClickListenerV2(new ActionSheet.OnButtonClickListenerV2() { // from class: com.qzone.reborn.feedx.part.cm
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
            public final void OnClick(View view, int i3, String str) {
                cn.this.F9(actionSheet, view, i3, str);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }
}
