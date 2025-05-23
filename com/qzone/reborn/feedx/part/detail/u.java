package com.qzone.reborn.feedx.part.detail;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.business.tianshu.model.QZoneQuickCommentInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.util.ap;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name */
    private View f55194d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f55195e;

    /* renamed from: f, reason: collision with root package name */
    private gf.a f55196f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f55197h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneUserAvatarView f55198i;

    /* renamed from: m, reason: collision with root package name */
    private View f55199m;

    private void G9(String str) {
        I9();
        if (TextUtils.isEmpty(str)) {
            rn.h.a(this.f55195e, "qui_quick_comment", R.color.qui_common_icon_secondary);
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(str);
        obtain.setTargetView(this.f55195e);
        if (this.f55195e.getLayoutParams() != null) {
            obtain.setRequestWidth(this.f55195e.getLayoutParams().width);
            obtain.setRequestHeight(this.f55195e.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new a());
    }

    private void H9() {
        final BusinessFeedData J9 = J9();
        if (J9 == null) {
            return;
        }
        final String a16 = ef.b.a(J9);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f55194d).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.part.detail.s
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                u.this.M9(a16, J9, (gf.e) obj);
            }
        }).run();
    }

    private void I9() {
        fo.c.o(this.f55195e, "em_qz_quick_review_icon", new fo.b().k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL));
    }

    private void K9(int i3) {
        if (this.f55196f == null) {
            this.f55196f = (gf.a) getIocInterface(gf.a.class);
        }
        BusinessFeedData J9 = J9();
        if (J9 != null) {
            if (this.f55196f != null) {
                com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(J9);
                bVar.f54741b = 5;
                bVar.f54742c = i3;
                this.f55196f.f6(bVar);
                this.f55196f.c1(J9, null, -1);
            }
            ap.f59791b.e(5, 1, 0, J9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(String str, BusinessFeedData businessFeedData, gf.e eVar) {
        eVar.k5(this.f55194d, "em_qz_comment_box", str, businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        K9(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        K9(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Q9() {
        if (L9()) {
            QZoneCommentQuickInputHelper.n().p(new QZoneCommentQuickInputHelper.a() { // from class: com.qzone.reborn.feedx.part.detail.t
                @Override // com.qzone.business.tianshu.QZoneCommentQuickInputHelper.a
                public final void a(QZoneQuickCommentInfo qZoneQuickCommentInfo) {
                    u.this.P9(qZoneQuickCommentInfo);
                }
            });
        }
        BusinessFeedData J9 = J9();
        if (J9 == null) {
            return;
        }
        String g16 = com.qzone.reborn.feedx.util.aa.g(J9);
        if (!TextUtils.isEmpty(g16) && J9.isCommentEmpty()) {
            this.f55197h.setText(g16);
        } else {
            this.f55197h.setText(com.qzone.util.l.a(R.string.f21933665));
        }
    }

    public BusinessFeedData J9() {
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        if (hVar == null) {
            QLog.e("QZoneFeedxDetailQuickCommentPart", 2, "[getCurrentFeedData] detailViewModel is null");
            return null;
        }
        MutableLiveData<UIStateData<BusinessFeedData>> mutableLiveData = hVar.f55901m;
        if (mutableLiveData != null && mutableLiveData.getValue() != null) {
            return hVar.f55901m.getValue().getData();
        }
        QLog.e("QZoneFeedxDetailQuickCommentPart", 2, "[getCurrentFeedData] feedData=" + hVar.f55901m);
        return null;
    }

    protected boolean L9() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailQuickCommentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55199m = view.findViewById(R.id.mz8);
        if (((com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class)).u2()) {
            this.f55199m.setVisibility(8);
            return;
        }
        this.f55199m.setVisibility(0);
        QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) view.findViewById(R.id.mz5);
        this.f55198i = qZoneUserAvatarView;
        qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        this.f55194d = view.findViewById(R.id.mz6);
        this.f55195e = (ImageView) view.findViewById(R.id.mvw);
        this.f55197h = (TextView) view.findViewById(R.id.mz7);
        this.f55195e.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.detail.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u.this.N9(view2);
            }
        });
        if (this.f55194d != null) {
            if (QQTheme.isNowThemeIsNight()) {
                this.f55194d.setBackgroundResource(R.drawable.f15103h);
            } else {
                this.f55194d.setBackgroundResource(R.drawable.f15093g);
            }
            this.f55194d.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.detail.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    u.this.O9(view2);
                }
            });
        }
        Q9();
        AccessibilityUtil.s(this.f55198i, com.qzone.util.l.a(R.string.gqm));
        AccessibilityUtil.s(this.f55194d, com.qzone.util.l.a(R.string.f21933665));
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneCommentQuickInputHelper.n().r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == null || !loadState.isFinishSuccess()) {
                return;
            }
            QLog.i("QZoneFeedxDetailQuickCommentPart", 2, "[bindCommentQuickInput] success ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(QZoneQuickCommentInfo qZoneQuickCommentInfo) {
        if (qZoneQuickCommentInfo != null) {
            G9(qZoneQuickCommentInfo.getEntrancePic());
        }
    }
}
