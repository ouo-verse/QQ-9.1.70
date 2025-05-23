package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.reborn.qzmoment.bean.QZMMessageInitBean;
import com.qzone.reborn.qzmoment.bean.QZMMyMomentInitBean;
import com.qzone.reborn.qzmoment.comment.event.QZoneFeedUnreadUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZMFolderTitlePart extends an.a implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f58930d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f58931e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f58932f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f58933h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f58934i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f58935m;

    private void E9() {
        fo.c.o(this.f58930d, "em_bas_back_button", null);
        fo.c.o(this.f58932f, "em_bas_message_button", null);
        fo.c.o(this.f58931e, "em_bas_entrance_personal_historical", null);
    }

    private void F9() {
        ((jn.b) ho.i.t(jn.b.class)).d(getActivity(), new QZMMessageInitBean());
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(66);
        I9(false);
    }

    private void G9() {
        ((jn.b) ho.i.t(jn.b.class)).e(getActivity(), new QZMMyMomentInitBean());
    }

    private void H9() {
        rn.h.a(this.f58930d, "qui_chevron_left", R.color.qui_common_icon_secondary);
        rn.h.a(this.f58931e, "qui_user", R.color.qui_common_icon_secondary);
        rn.h.a(this.f58932f, "qui_remind", R.color.qui_common_icon_secondary);
        rn.h.a(this.f58933h, "qui_upload", R.color.qui_common_icon_secondary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9(boolean z16) {
        TextView textView = this.f58934i;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z16 ? 0 : 8);
    }

    private void J9() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMFolderTitlePart.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZMFolderTitlePart.this.f58934i == null) {
                    QLog.e("QZMFolderTitlePart", 1, "message red dot is null");
                    return;
                }
                int singleUnreadCount = QZoneFeedAlertService.getInstance().getSingleUnreadCount(66);
                QLog.d("QZMFolderTitlePart", 1, "moment message red dot cnt is " + singleUnreadCount);
                if (singleUnreadCount <= 0) {
                    QZMFolderTitlePart.this.I9(false);
                } else if (singleUnreadCount < 99) {
                    QZMFolderTitlePart.this.f58934i.setText(String.valueOf(singleUnreadCount));
                    QZMFolderTitlePart.this.I9(true);
                } else {
                    QZMFolderTitlePart.this.f58934i.setText(QZMFolderTitlePart.this.getContext().getString(R.string.w_k));
                    QZMFolderTitlePart.this.I9(true);
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedUnreadUpdateEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.lfd) {
            F9();
        } else if (id5 != R.id.lob) {
            if (id5 == R.id.lvk && getActivity() != null) {
                getActivity().onBackPressed();
            }
        } else {
            G9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        TextView textView = (TextView) view.findViewById(R.id.nkf);
        this.f58935m = textView;
        textView.setTextColor(ie0.a.f().g(view.getContext(), R.color.qui_common_text_nav_primary, 1002));
        this.f58930d = (ImageView) view.findViewById(R.id.lvk);
        this.f58931e = (ImageView) view.findViewById(R.id.lob);
        this.f58932f = (ImageView) view.findViewById(R.id.lfd);
        this.f58933h = (ImageView) view.findViewById(R.id.lvq);
        this.f58934i = (TextView) view.findViewById(R.id.mks);
        this.f58930d.setOnClickListener(this);
        this.f58931e.setOnClickListener(this);
        this.f58932f.setOnClickListener(this);
        H9();
        J9();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedUnreadUpdateEvent) {
            QLog.d("QZMFolderTitlePart", 1, "update red dot info by event");
            J9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QLog.d("QZMFolderTitlePart", 1, "update red dot info resume");
        J9();
    }
}
