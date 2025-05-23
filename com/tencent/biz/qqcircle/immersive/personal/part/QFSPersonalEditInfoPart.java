package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSPersonalGroupInfoInitBean;
import com.tencent.biz.qqcircle.beans.QFSPersonalGuildInfoInitBean;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleRefreshIconDecorateEvent;
import com.tencent.biz.qqcircle.events.QFSClearDecorateRedPointEvent;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalEditInfoPart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.manager.QCircleAvatarDecorateManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.ActionSheet;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleProfile$SetProfileRsp;

/* loaded from: classes4.dex */
public class QFSPersonalEditInfoPart extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver {
    private com.tencent.mobileqq.widget.listitem.x C;
    private com.tencent.mobileqq.widget.listitem.x D;
    private com.tencent.mobileqq.widget.listitem.x E;
    private com.tencent.mobileqq.widget.listitem.x F;
    private com.tencent.mobileqq.widget.listitem.x G;
    private com.tencent.mobileqq.widget.listitem.x I;
    private com.tencent.mobileqq.widget.listitem.x K;
    private com.tencent.mobileqq.widget.listitem.x L;
    private com.tencent.mobileqq.widget.listitem.x M;
    private com.tencent.mobileqq.widget.listitem.x P;
    private boolean T;

    /* renamed from: d, reason: collision with root package name */
    private QCircleLoadingDialog f88744d;

    /* renamed from: e, reason: collision with root package name */
    private QFSPersonalEditViewModel f88745e;

    /* renamed from: f, reason: collision with root package name */
    private QUISettingsRecyclerView f88746f;

    /* renamed from: h, reason: collision with root package name */
    private QUIListItemAdapter f88747h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.widget.listitem.x f88748i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f88749m = true;
    private boolean H = true;
    private boolean J = true;
    private boolean N = true;
    private u Q = new u();
    private t R = new t();
    private boolean S = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSPersonalEditViewModel.School> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.School school) {
            if (school != null) {
                if (TextUtils.isEmpty(school.schoolName)) {
                    QFSPersonalEditInfoPart.this.N = false;
                } else {
                    QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
                    qFSPersonalEditInfoPart.Wa(qFSPersonalEditInfoPart.M, school.schoolName);
                    QFSPersonalEditInfoPart qFSPersonalEditInfoPart2 = QFSPersonalEditInfoPart.this;
                    qFSPersonalEditInfoPart2.P = qFSPersonalEditInfoPart2.ta(school.showSchool);
                    QFSPersonalEditInfoPart.this.N = true;
                }
            }
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Observer<QFSPersonalEditViewModel.e> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.e eVar) {
            QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
            qFSPersonalEditInfoPart.Wa(qFSPersonalEditInfoPart.L, eVar.f89126a);
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Observer<QFSPersonalEditViewModel.FrequencyItem> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.FrequencyItem frequencyItem) {
            String string;
            QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
            com.tencent.mobileqq.widget.listitem.x xVar = qFSPersonalEditInfoPart.E;
            if (!TextUtils.isEmpty(frequencyItem.showText)) {
                string = frequencyItem.showText;
            } else {
                string = QFSPersonalEditInfoPart.this.getContext().getString(R.string.f19264482);
            }
            qFSPersonalEditInfoPart.Wa(xVar, string);
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Observer<QFSPersonalEditViewModel.d> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.d dVar) {
            if (!dVar.f89123a) {
                QFSPersonalEditInfoPart.this.H = false;
            } else if (dVar.f89125c != 0) {
                QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
                qFSPersonalEditInfoPart.Wa(qFSPersonalEditInfoPart.I, dVar.f89124b);
            } else {
                QFSPersonalEditInfoPart qFSPersonalEditInfoPart2 = QFSPersonalEditInfoPart.this;
                qFSPersonalEditInfoPart2.Wa(qFSPersonalEditInfoPart2.I, QFSPersonalEditInfoPart.this.getContext().getResources().getString(R.string.f1928048h));
            }
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Observer<QFSPersonalEditViewModel.Group> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.Group group) {
            if (!group.needShow) {
                QFSPersonalEditInfoPart.this.J = false;
            } else if (!TextUtils.isEmpty(group.showText)) {
                QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
                qFSPersonalEditInfoPart.Wa(qFSPersonalEditInfoPart.K, group.showText);
            } else {
                QFSPersonalEditInfoPart qFSPersonalEditInfoPart2 = QFSPersonalEditInfoPart.this;
                qFSPersonalEditInfoPart2.Wa(qFSPersonalEditInfoPart2.K, QFSPersonalEditInfoPart.this.getContext().getResources().getString(R.string.f1928048h));
            }
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Observer<Integer> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num.intValue() == 1) {
                QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f1925047o), 0, true, false);
            }
            QFSPersonalEditInfoPart.this.la();
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class i implements ActionSheet.OnButtonClickListenerV2 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSPersonalEditViewModel.FrequencyItem f88765d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f88766e;

        i(QFSPersonalEditViewModel.FrequencyItem frequencyItem, ActionSheet actionSheet) {
            this.f88765d = frequencyItem;
            this.f88766e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
        public void OnClick(View view, int i3, String str) {
            if (!fb0.a.a("showAvatarActionSheetClick")) {
                if (QFSPersonalEditInfoPart.this.getContext().getResources().getString(R.string.f1924847m).equals(str)) {
                    View decorView = QFSPersonalEditInfoPart.this.getActivity().getWindow().getDecorView();
                    Context activity = QFSPersonalEditInfoPart.this.getActivity();
                    if (decorView.getParent() instanceof View) {
                        activity = ((View) decorView.getParent()).getContext();
                    }
                    ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToAvatarPickerFragment(com.tencent.biz.qqcircle.immersive.utils.r.x(activity), this.f88765d.showText, 10000);
                    QFSPersonalEditInfoPart.va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_EDIT_CHOICE_BUTTON, "ev_xsj_abnormal_clck");
                    QFSPersonalEditInfoPart.this.S = true;
                }
                this.f88766e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class j implements ActionSheet.OnDismissListener {
        j() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            if (QFSPersonalEditInfoPart.this.S) {
                QFSPersonalEditInfoPart.this.S = false;
            } else {
                QFSPersonalEditInfoPart.va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CANCEL_BUTTON, "ev_xsj_abnormal_clck");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class k implements com.tencent.mobileqq.widget.listitem.g {
        k() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.g
        public void M(@NonNull View view) {
            QFSPersonalEditInfoPart.this.wa(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_EDIT_GRP_BUTTON, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class l implements CompoundButton.OnCheckedChangeListener {

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f88771a;

            a(boolean z16) {
                this.f88771a = z16;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
                if (z16 && j3 == 0 && qQCircleProfile$SetProfileRsp != null) {
                    QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928848p), 0);
                } else {
                    QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928648n), 0, true, false);
                    QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
                    qFSPersonalEditInfoPart.P = qFSPersonalEditInfoPart.ta(!this.f88771a);
                }
                QFSPersonalEditInfoPart.this.la();
            }
        }

        l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            QLog.d("QFSPersonalEditInfoPart", 1, "onCheckedChanged... isChecked:" + z16);
            QFSPersonalEditInfoPart.this.Ya(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
            QFSPersonalEditViewModel unused = QFSPersonalEditInfoPart.this.f88745e;
            QFSPersonalEditViewModel.f2(10023, Integer.valueOf(!z16 ? 1 : 0), new a(z16));
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSPersonalEditInfoPart.this.f88744d != null && QFSPersonalEditInfoPart.this.f88744d.isShowing()) {
                QFSPersonalEditInfoPart.this.f88744d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f88774d;

        n(Runnable runnable) {
            this.f88774d = runnable;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Runnable runnable = this.f88774d;
            if (runnable != null) {
                runnable.run();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class o implements com.tencent.mobileqq.widget.listitem.g {
        o() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.g
        public void M(@NonNull View view) {
            QFSPersonalEditInfoPart.this.wa(view, QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_EDIT, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class p implements Observer<QFSPersonalEditViewModel.FrequencyItem> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements com.tencent.mobileqq.widget.listitem.g {
            a() {
            }

            @Override // com.tencent.mobileqq.widget.listitem.g
            public void M(@NonNull View view) {
                QFSPersonalEditInfoPart.this.wa(view, QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_EDIT, null);
            }
        }

        p() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPersonalEditInfoPart.this.Ga();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit d(ImageView imageView, String str) {
            if (TextUtils.isEmpty(str)) {
                com.tencent.biz.qqcircle.utils.al.a(imageView, HostDataTransUtils.getAccount(), com.tencent.biz.qqcircle.immersive.utils.n.a(QFSPersonalEditInfoPart.this.getContext(), R.dimen.daj));
            } else {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(str));
            }
            return Unit.INSTANCE;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.FrequencyItem frequencyItem) {
            String str;
            QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
            x.b.d dVar = new x.b.d(com.tencent.biz.qqcircle.utils.h.a(R.string.f1924947n));
            if (TextUtils.isEmpty(frequencyItem.showText)) {
                str = uq3.c.J0();
            } else {
                str = frequencyItem.showText;
            }
            qFSPersonalEditInfoPart.f88748i = new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.a("", str, true, false));
            QFSPersonalEditInfoPart.this.f88748i.x(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSPersonalEditInfoPart.p.this.c(view);
                }
            });
            QFSPersonalEditInfoPart.this.f88748i.w(new a());
            QFSPersonalEditInfoPart.this.f88748i.R(new Function2() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit d16;
                    d16 = QFSPersonalEditInfoPart.p.this.d((ImageView) obj, (String) obj2);
                    return d16;
                }
            });
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class q implements Observer<QFSPersonalEditViewModel.FrequencyItem> {
        q() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalEditViewModel.FrequencyItem frequencyItem) {
            QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
            qFSPersonalEditInfoPart.Wa(qFSPersonalEditInfoPart.D, frequencyItem.showText);
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class r implements Observer<Integer> {
        r() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
            com.tencent.mobileqq.widget.listitem.x xVar = qFSPersonalEditInfoPart.F;
            QFSPersonalEditViewModel unused = QFSPersonalEditInfoPart.this.f88745e;
            qFSPersonalEditInfoPart.Wa(xVar, QFSPersonalEditViewModel.M[num.intValue()]);
            QFSPersonalEditInfoPart.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class s implements Observer<Integer> {
        s() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                String[] strArr = QFSPersonalEditViewModel.N;
                if (intValue < strArr.length) {
                    QFSPersonalEditInfoPart qFSPersonalEditInfoPart = QFSPersonalEditInfoPart.this;
                    qFSPersonalEditInfoPart.Wa(qFSPersonalEditInfoPart.G, strArr[num.intValue()]);
                    QFSPersonalEditInfoPart.this.Ta();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class t extends BroadcastReceiver {

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {
            a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
                if (z16 && j3 == 0 && qQCircleProfile$SetProfileRsp != null) {
                    QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928848p), 0);
                } else {
                    String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928648n);
                    if (!uq3.l.b().a(j3)) {
                        str = a16;
                    }
                    QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
                }
                QFSPersonalEditInfoPart.this.la();
            }
        }

        t() {
        }

        @NotNull
        private QFSPersonalEditViewModel.e a(Intent intent) {
            String str;
            String str2;
            String[] stringArrayExtra = intent.getStringArrayExtra("code");
            String[] stringArrayExtra2 = intent.getStringArrayExtra("location");
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            if (stringArrayExtra != null) {
                for (int i3 = 0; i3 < stringArrayExtra.length; i3++) {
                    stringArrayExtra[i3] = HostRouteUtils.encodeLocCode(stringArrayExtra[i3]) + "";
                    if (i3 != 0) {
                        str2 = "-";
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    sb5.append(stringArrayExtra[i3]);
                }
            }
            if (stringArrayExtra2 != null) {
                for (int i16 = 0; i16 < stringArrayExtra2.length; i16++) {
                    if (!TextUtils.isEmpty(stringArrayExtra2[i16])) {
                        if (i16 != 0) {
                            str = "-";
                        } else {
                            str = "";
                        }
                        sb6.append(str);
                        sb6.append(stringArrayExtra2[i16]);
                    }
                }
            }
            return new QFSPersonalEditViewModel.e(sb6.toString(), sb5.toString());
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            QLog.d("QFSPersonalEditInfoPart", 1, "onReceive action:" + action);
            if (!"action_get_lbs_location".equals(action) || intent.getIntExtra("select_location_broadcast_callback", 0) != 2222) {
                return;
            }
            QFSPersonalEditViewModel.e a16 = a(intent);
            if (!a16.equals(QFSPersonalEditInfoPart.this.f88745e.T1().getValue())) {
                QFSPersonalEditInfoPart.this.Ya(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
                QFSPersonalEditViewModel unused = QFSPersonalEditInfoPart.this.f88745e;
                QFSPersonalEditViewModel.f2(10003, a16, new a());
                return;
            }
            QLog.d("QFSPersonalEditInfoPart", 1, "onReceive... the same location!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class u extends BroadcastReceiver {

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {
            a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
                QLog.d("QFSPersonalEditInfoPart", 1, "onReceive | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str + " | request=" + baseRequest + " | setProfileRsp=" + qQCircleProfile$SetProfileRsp);
                if (z16 && j3 == 0 && qQCircleProfile$SetProfileRsp != null) {
                    QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928848p), 0);
                } else {
                    String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928648n);
                    if (!uq3.l.b().a(j3)) {
                        str = a16;
                    }
                    QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
                }
                QFSPersonalEditInfoPart.this.la();
            }
        }

        u() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            QLog.d("QFSPersonalEditInfoPart", 1, "onReceive action:" + action);
            if ("action_confirm_school_name".equals(action)) {
                String stringExtra = intent.getStringExtra("schoolName");
                QFSPersonalEditInfoPart.this.Ya(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
                QFSPersonalEditViewModel unused = QFSPersonalEditInfoPart.this.f88745e;
                QFSPersonalEditViewModel.f2(10018, stringExtra, new a());
            }
        }
    }

    private Group Aa() {
        ArrayList arrayList = new ArrayList();
        Qa(arrayList, this.F);
        Qa(arrayList, this.G);
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private Group Ba() {
        ArrayList arrayList = new ArrayList();
        if (this.H) {
            Qa(arrayList, this.I);
        }
        if (this.J) {
            Qa(arrayList, this.K);
        }
        Qa(arrayList, this.L);
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private Group Ca() {
        String str;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            Qa(arrayList, this.M);
        }
        if (this.N) {
            Qa(arrayList, this.P);
        }
        if (!com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            str = "";
        } else {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928948q);
        }
        return new Group("", str, (com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    public static String Da(Context context, int i3, int i16) {
        String str;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (i3 != 1) {
            str = "\u6708";
            if (i3 != 2) {
                if (i3 == 3) {
                    calendar.add(1, 1);
                    calendar.set(6, 1);
                    str = "\u5e74";
                }
            } else {
                calendar.add(2, 1);
                calendar.set(5, 1);
            }
        } else {
            calendar.add(5, 1);
            str = "\u65e5";
        }
        return context.getString(R.string.f1929548w, str, Integer.valueOf(i16), new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(calendar.getTime()));
    }

    private void Ea() {
        this.T = false;
        Za();
        Ta();
    }

    private void Fa() {
        na();
        oa();
        pa();
        qa();
        Ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga() {
        if (com.tencent.biz.qqcircle.helpers.d.a(3, true)) {
            return;
        }
        Xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (com.tencent.biz.qqcircle.helpers.d.a(5, true)) {
            return;
        }
        Ma(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia() {
        if (com.tencent.biz.qqcircle.helpers.d.a(4, true)) {
            return;
        }
        Ma(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        Wa(this.C, "");
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), com.tencent.biz.qqcircle.f.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka() {
        QFSPersonalGuildInfoInitBean qFSPersonalGuildInfoInitBean = new QFSPersonalGuildInfoInitBean();
        if (this.f88745e.O1() != null && this.f88745e.O1().getValue() != null) {
            qFSPersonalGuildInfoInitBean.setSelectGuildId(this.f88745e.O1().getValue().f89125c);
            qFSPersonalGuildInfoInitBean.setIsNeedShow(this.f88745e.O1().getValue().f89123a);
        }
        com.tencent.biz.qqcircle.launcher.c.g0(getContext(), qFSPersonalGuildInfoInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        long j3;
        Bundle bundle = new Bundle();
        bundle.putBoolean("param_is_popup", false);
        bundle.putInt(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2);
        if (this.f88745e.T1().getValue() != null) {
            String str = this.f88745e.T1().getValue().f89126a;
            String str2 = this.f88745e.T1().getValue().f89127b;
            String[] strArr = {"0", "0", "0", "0"};
            if (!TextUtils.isEmpty(str2)) {
                strArr = str2.split("-");
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    try {
                        j3 = Long.parseLong(strArr[i3]);
                    } catch (Exception e16) {
                        QLog.e("QFSPersonalEditInfoPart", 1, "selectLocation:" + e16.toString());
                        j3 = 0;
                    }
                    strArr[i3] = HostRouteUtils.decodeRemoteCode(j3);
                }
            }
            bundle.putStringArray(IProfileCardConst.PARAM_LOCATION_CODE, strArr);
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("param_location_param", str);
            }
        } else {
            bundle.putStringArray(IProfileCardConst.PARAM_LOCATION_CODE, new String[]{"0", "0", "0", "0"});
        }
        bundle.putInt("select_location_broadcast_callback", Constants.Action.ACTION_NOTIFY_MSF_WEAK_NET_SWITCH);
        HostRouteUtils.openLocationSelectActivity(getActivity(), bundle);
    }

    private void Ma(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("item_from", i3);
        if (i3 == 1) {
            bundle.putSerializable("from_item_message", this.f88745e.W1().getValue());
        } else {
            bundle.putSerializable("from_item_message", this.f88745e.Q1().getValue());
        }
        com.tencent.biz.qqcircle.launcher.c.e0(getContext(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Na() {
        try {
            int i3 = this.f88745e.Z1().getValue().allowNum;
            if (i3 == 0) {
                QQToast.makeText(RFWApplication.getApplication(), 0, R.string.f1929048r, 1).show();
                return;
            }
            String str = this.f88745e.Z1().getValue().schoolName;
            String V2 = uq3.c.V2();
            if (!TextUtils.isEmpty(str)) {
                V2 = V2 + "&school=" + str;
            }
            com.tencent.biz.qqcircle.launcher.c.o0(getActivity(), V2 + "&remainnum=" + i3, null, -1);
        } catch (Exception e16) {
            QLog.e("QFSPersonalEditInfoPart", 1, "selectSchool", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        Bundle bundle = new Bundle();
        if (this.f88745e.I != null) {
            QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = new QFSPersonalGroupInfoInitBean();
            qFSPersonalGroupInfoInitBean.setHostUin(this.f88745e.R1().getHostUin());
            qFSPersonalGroupInfoInitBean.setBoundGroupInfoList(this.f88745e.I.getValue());
            bundle.putSerializable("key_bundle_common_init_bean", qFSPersonalGroupInfoInitBean);
        }
        com.tencent.biz.qqcircle.launcher.c.F0(getContext(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ga();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Qa(List list, Object obj) {
        if (obj == null) {
            return;
        }
        list.add(obj);
    }

    private void Ra() {
        if (this.f88745e == null) {
            this.f88745e = (QFSPersonalEditViewModel) getViewModel(QFSPersonalEditViewModel.class);
        }
        this.f88745e.M1().observe(getHostFragment(), new p());
        this.f88745e.W1().observe(getHostFragment(), new q());
        this.f88745e.S1().observe(getHostFragment(), new r());
        this.f88745e.P1().observe(getHostFragment(), new s());
        this.f88745e.Z1().observe(getHostFragment(), new a());
        this.f88745e.T1().observe(getHostFragment(), new b());
        this.f88745e.Q1().observe(getHostFragment(), new c());
        this.f88745e.O1().observe(getHostFragment(), new d());
        this.f88745e.X1().observe(getHostFragment(), new e());
        this.f88745e.N1().observe(getHostFragment(), new f());
    }

    private void Sa() {
        getActivity().registerReceiver(this.Q, new IntentFilter("action_confirm_school_name"));
        getActivity().registerReceiver(this.R, new IntentFilter("action_get_lbs_location"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(za());
        arrayList.add(Aa());
        arrayList.add(Ba());
        arrayList.add(Ca());
        this.f88747h.t0((Group[]) arrayList.toArray(new Group[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ua() {
        pc0.a aVar = new pc0.a(getContext());
        aVar.i(new h(aVar));
        aVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Va() {
        com.tencent.mobileqq.widget.selectorview.f fVar = new com.tencent.mobileqq.widget.selectorview.f(getContext());
        fVar.i(new g(fVar));
        fVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa(com.tencent.mobileqq.widget.listitem.x xVar, String str) {
        if (xVar == null) {
            return;
        }
        xVar.U(new x.c.g(str, true, false));
    }

    private void Xa() {
        QFSPersonalEditViewModel.FrequencyItem value = this.f88745e.f89114i.getValue();
        if (value.allowNum <= 0) {
            QCircleToast.l(QCircleToast.f91644d, Da(getContext(), value.limitType, value.totalNum), 0, true, false);
            va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CHANGE_EXCESS, "ev_xsj_abnormal_imp");
            return;
        }
        ActionSheet a16 = ob0.a.a(getContext());
        a16.setMainTitle(getContext().getString(R.string.f1924747l, xa(value.limitType), Integer.valueOf(value.totalNum), xa(value.limitType), Integer.valueOf(value.allowNum)));
        a16.addButton(R.string.f1924847m, 0);
        a16.addCancelButton(R.string.cancel);
        a16.show();
        a16.setOnButtonClickListenerV2(new i(value, a16));
        a16.setOnDismissListener(new j());
        va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_EDIT_CHOICE_BUTTON, "ev_xsj_abnormal_imp");
        va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CANCEL_BUTTON, "ev_xsj_abnormal_imp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya(String str) {
        if (this.f88744d == null) {
            this.f88744d = new QCircleLoadingDialog(getContext());
        }
        this.f88744d.S(str);
        ImageView U = this.f88744d.U();
        U.setVisibility(0);
        U.setOnClickListener(new m());
        if (!getActivity().isFinishing()) {
            this.f88744d.showDialog();
        }
    }

    private void Za() {
        int i3;
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1925847w);
        Context context = getContext();
        if (this.T) {
            i3 = R.string.f1925747v;
        } else {
            i3 = R.string.f1925947x;
        }
        com.tencent.mobileqq.widget.listitem.x sa5 = sa(a16, context.getString(i3), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.j
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Ja();
            }
        }, Boolean.valueOf(this.T));
        this.C = sa5;
        sa5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalEditInfoPart.5

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalEditInfoPart$5$1, reason: invalid class name */
            /* loaded from: classes4.dex */
            public class AnonymousClass1 implements Runnable {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f88751d;

                AnonymousClass1(View view) {
                    this.f88751d = view;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ Map b(String str) {
                    int i3;
                    Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                    if (QFSPersonalEditInfoPart.this.T) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(i3));
                    return buildElementParams;
                }

                @Override // java.lang.Runnable
                public void run() {
                    VideoReport.setEventDynamicParams(this.f88751d, new IDynamicParams() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.p
                        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                        public final Map getDynamicParams(String str) {
                            Map b16;
                            b16 = QFSPersonalEditInfoPart.AnonymousClass5.AnonymousClass1.this.b(str);
                            return b16;
                        }
                    });
                    QFSPersonalEditInfoPart.this.wa(this.f88751d, QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_PENDANT_EDIT, null);
                }
            }

            @Override // com.tencent.mobileqq.widget.listitem.g
            public void M(@NonNull View view) {
                RFWThreadManager.getInstance().execOnSubThread(new AnonymousClass1(view));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        QCircleLoadingDialog qCircleLoadingDialog = this.f88744d;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            this.f88744d.dismiss();
        }
    }

    private void ma() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if ((qCircleInitBean instanceof QCircleEditProfileBean) && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            if (!QCircleAvatarDecorateManager.INSTANCE.enableDecorateManagerEntrance()) {
                QLog.d("QFSPersonalEditInfoPart", 1, "onInitView enableDecorateManagerEntrance=false");
                this.f88749m = false;
            } else {
                this.T = ((QCircleEditProfileBean) qCircleInitBean).hasDecorateRedPoint();
                Za();
            }
        }
    }

    private void na() {
        com.tencent.mobileqq.widget.listitem.x ra5 = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1924947n), "", new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.k
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Ga();
            }
        });
        this.f88748i = ra5;
        ra5.x(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalEditInfoPart.this.Pa(view);
            }
        });
        this.f88748i.w(new o());
        this.D = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1927948g), com.tencent.biz.qqcircle.utils.h.a(R.string.f19264482), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.m
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Ia();
            }
        });
        ma();
        this.E = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1927448b), com.tencent.biz.qqcircle.utils.h.a(R.string.f19264482), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.n
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Ha();
            }
        });
    }

    private void oa() {
        this.F = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f19265483), com.tencent.biz.qqcircle.utils.h.a(R.string.f1928048h), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Va();
            }
        });
        this.G = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1925447s), com.tencent.biz.qqcircle.utils.h.a(R.string.f1928048h), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.f
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Ua();
            }
        });
    }

    private void pa() {
        this.I = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1925147p), com.tencent.biz.qqcircle.utils.h.a(R.string.f1928048h), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.g
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Ka();
            }
        });
        com.tencent.mobileqq.widget.listitem.x ra5 = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928548m), com.tencent.biz.qqcircle.utils.h.a(R.string.f1928048h), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Oa();
            }
        });
        this.K = ra5;
        ra5.w(new k());
        this.L = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1925647u), com.tencent.biz.qqcircle.utils.h.a(R.string.f1928048h), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.La();
            }
        });
    }

    private void qa() {
        this.M = ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f1929148s), com.tencent.biz.qqcircle.utils.h.a(R.string.f1928048h), new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.e
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalEditInfoPart.this.Na();
            }
        });
        this.P = ta(true);
    }

    private com.tencent.mobileqq.widget.listitem.x ra(String str, String str2, Runnable runnable) {
        return sa(str, str2, runnable, Boolean.FALSE);
    }

    private com.tencent.mobileqq.widget.listitem.x sa(String str, String str2, Runnable runnable, Boolean bool) {
        return (com.tencent.mobileqq.widget.listitem.x) new com.tencent.mobileqq.widget.listitem.x(new x.b.d(str), new x.c.g(str2, true, bool.booleanValue())).x(new n(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.widget.listitem.x ta(boolean z16) {
        return new com.tencent.mobileqq.widget.listitem.x(new x.b.d(com.tencent.biz.qqcircle.utils.h.a(R.string.f1929348u)), new x.c.f(z16, new l()));
    }

    public static void ua() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_AVATAR_ADJUST_PAGE);
        buildElementParams.put("xsj_eid", "em_xsj_complete_button");
        VideoReport.reportEvent("dt_clck", buildElementParams);
    }

    public static void va(String str, String str2) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_EDIT_PAGE);
        VideoReport.reportEvent(str2, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null && !map.isEmpty()) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public static String xa(int i3) {
        if (i3 != 1) {
            if (i3 == 2 || i3 != 3) {
                return "\u6708";
            }
            return "\u5e74";
        }
        return "\u65e5";
    }

    private Group za() {
        ArrayList arrayList = new ArrayList();
        Qa(arrayList, this.f88748i);
        if (this.f88749m) {
            Qa(arrayList, this.C);
        }
        Qa(arrayList, this.D);
        Qa(arrayList, this.E);
        return new Group(com.tencent.biz.qqcircle.utils.h.a(R.string.f1929448v), (com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePersonEditUpdateEvent.class);
        arrayList.add(QCircleRefreshIconDecorateEvent.class);
        arrayList.add(QFSClearDecorateRedPointEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalEditInfoPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (intent == null) {
            return;
        }
        if (i3 == 10000 && i16 == -1) {
            String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            QLog.d("QFSPersonalEditInfoPart", 1, "onActivityResult... path:" + stringExtra);
            this.f88745e.c2(stringExtra);
            Ya(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
        }
        ua();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88746f = (QUISettingsRecyclerView) view.findViewById(R.id.f3705168);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        this.f88747h = qUIListItemAdapter;
        this.f88746f.setAdapter(qUIListItemAdapter);
        Fa();
        Ra();
        Sa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.personal.utils.g.e().c();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QFSPersonalEditViewModel qFSPersonalEditViewModel = this.f88745e;
        if (qFSPersonalEditViewModel != null) {
            qFSPersonalEditViewModel.d2();
        }
        getActivity().unregisterReceiver(this.Q);
        getActivity().unregisterReceiver(this.R);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        la();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePersonEditUpdateEvent) {
            this.f88745e.i2((QCirclePersonEditUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleRefreshIconDecorateEvent) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else if (simpleBaseEvent instanceof QFSClearDecorateRedPointEvent) {
            Ea();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.f f88759d;

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {
            a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
                if (z16) {
                    g gVar = g.this;
                    if (gVar.f88759d != null) {
                        QFSPersonalEditInfoPart.this.f88745e.S1().postValue(Integer.valueOf(g.this.f88759d.o() + 1));
                        QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928848p), 0);
                        QFSPersonalEditInfoPart.this.la();
                    }
                }
                QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
                QFSPersonalEditInfoPart.this.la();
            }
        }

        g(com.tencent.mobileqq.widget.selectorview.f fVar) {
            this.f88759d = fVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            QFSPersonalEditInfoPart.this.Ya(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
            QFSPersonalEditViewModel.f2(10002, Integer.valueOf(this.f88759d.o() + 1), new a());
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pc0.a f88762d;

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {
            a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
                if (z16) {
                    h hVar = h.this;
                    if (hVar.f88762d != null && QFSPersonalEditInfoPart.this.f88745e != null) {
                        QFSPersonalEditInfoPart.this.f88745e.P1().postValue(Integer.valueOf(h.this.f88762d.p() + 1));
                    }
                    QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f1928848p), 0);
                } else {
                    QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
                }
                QFSPersonalEditInfoPart.this.la();
            }
        }

        h(pc0.a aVar) {
            this.f88762d = aVar;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            QFSPersonalEditInfoPart.this.Ya(com.tencent.biz.qqcircle.utils.h.a(R.string.f1928748o));
            QFSPersonalEditViewModel.f2(10017, Integer.valueOf(this.f88762d.p() + 1), new a());
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
