package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.QFSFolderFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.requests.QCircleDeleteQZoneVideoAlbumRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSDeleteQZoneVideoAlbumEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import feedcloud.DeleteAlbumRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aq extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f88870d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f88871e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r f88872f;

    /* renamed from: h, reason: collision with root package name */
    private Observer<QFSPersonalInfo> f88873h;

    /* renamed from: i, reason: collision with root package name */
    private QFSPersonalInfo f88874i;

    /* renamed from: m, reason: collision with root package name */
    private String f88875m = "";
    private boolean C = true;
    private boolean D = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<QFSPersonalInfo> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            aq.this.L9(qFSPersonalInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            aq.this.F9();
            dialogInterface.dismiss();
            aq.this.D9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<DeleteAlbumRsp> {
        e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, DeleteAlbumRsp deleteAlbumRsp) {
            QLog.d("QFSPersonalTitleMorePart", 1, "request DeleteAlbum | onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
            if (z16 || j3 == 0) {
                QLog.d("QFSPersonalTitleMorePart", 1, "[handleDeleteAlbumRsp] send QFSDeleteQZoneVideoAlbumEvent");
                SimpleEventBus.getInstance().dispatchEvent(new QFSDeleteQZoneVideoAlbumEvent(true), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            aq.this.D9();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements DialogInterface.OnDismissListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QLog.d("QFSPersonalTitleMorePart", 1, "[showClientHintDialog] onDismiss");
            if (aq.this.getActivity() != null) {
                aq.this.getActivity().finish();
            }
        }
    }

    private void C9() {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
        actionSheet.addButton(R.string.f184233lb);
        actionSheet.addButton(R.string.f184203l9);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.ap
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                aq.this.E9(actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.z5w);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9() {
        if (QCircleHostGlobalInfo.isNowFlatState() && QCirclePluginUtil.isTabMode()) {
            QLog.d("QFSPersonalTitleMorePart", 1, "[handleBackEvent] in split view mode");
            QCirclePluginUtil.setIsSplitModeInnerBackClk(true);
        }
        if (QCirclePluginUtil.isQFSTabNativeFragmentMode(getActivity()) && getHostFragment() != null && (getHostFragment().getParentFragment() instanceof QFSFolderFragment) && ((QFSFolderFragment) getHostFragment().getParentFragment()).onBackEvent()) {
            QLog.d("QFSPersonalTitleMorePart", 1, "[handleBackEvent] in fragmentMode");
        } else if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E9(ActionSheet actionSheet, View view, int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                actionSheet.dismiss();
                H9();
                return;
            }
            return;
        }
        actionSheet.dismiss();
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), com.tencent.biz.qqcircle.immersive.personal.utils.k.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        VSNetworkHelper.getInstance().sendRequest(new QCircleDeleteQZoneVideoAlbumRequest(), new e());
    }

    private void J9() {
        if (this.C && !com.tencent.biz.qqcircle.immersive.utils.r.e0(this.f88875m) && !QCirclePluginUtil.isOwner(this.f88875m)) {
            QLog.d("QFSPersonalTitleMorePart", 1, "[updatePersonalInfo] show client dialog");
            G9();
        }
    }

    private void K9() {
        if (this.D && !com.tencent.biz.qqcircle.immersive.utils.r.e0(this.f88875m) && QCirclePluginUtil.isOwner(this.f88875m)) {
            QLog.d("QFSPersonalTitleMorePart", 1, "[updatePersonalInfo] show owner dialog");
            if (com.tencent.biz.qqcircle.f.L() && QCirclePluginUtil.isOwner(this.f88875m)) {
                I9();
                com.tencent.biz.qqcircle.f.b0();
                this.D = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(QFSPersonalInfo qFSPersonalInfo) {
        if (qFSPersonalInfo == null) {
            QLog.e("QFSPersonalTitleMorePart", 1, "[updatePersonalInfo] mPersonalInfo is null");
            return;
        }
        this.f88874i = qFSPersonalInfo;
        this.f88875m = qFSPersonalInfo.f88420g;
        QLog.d("QFSPersonalTitleMorePart", 1, "[updatePersonalInfo] mUserUin =" + this.f88875m + ", personalInfo.isOwner =" + qFSPersonalInfo.f88425l);
        M9();
        J9();
        K9();
    }

    private void M9() {
        QFSPersonalInfo qFSPersonalInfo = this.f88874i;
        if (qFSPersonalInfo != null && qFSPersonalInfo.f88416c != null) {
            if (!QCirclePluginUtil.isOwner(this.f88875m)) {
                QLog.e("QFSPersonalTitleMorePart", 1, "[updateTitleBar] is not owner");
                return;
            }
            ImageView imageView = this.f88870d;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f88871e;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    private void initViewModel() {
        this.f88872f = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.f88873h = new a();
        this.f88872f.g2().observeForever(this.f88873h);
    }

    public void G9() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.tencent.biz.qqcircle.immersive.personal.utils.k.b(), com.tencent.biz.qqcircle.immersive.personal.utils.k.f89090c, (String) null, (DialogInterface.OnClickListener) null, new f());
            createCustomDialog.show();
            createCustomDialog.setOnDismissListener(new g());
            this.C = false;
            return;
        }
        QLog.e("QFSPersonalTitleMorePart", 1, "[showClientHintDialog] activity is finish");
    }

    public void H9() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getContext(), 230).setTitle((String) null).setMessage(com.tencent.biz.qqcircle.immersive.personal.utils.k.c()).setNegativeButton(com.tencent.biz.qqcircle.immersive.personal.utils.k.f89088a, new d()).setPositiveButton(com.tencent.biz.qqcircle.immersive.personal.utils.k.f89089b, getContext().getResources().getColor(R.color.qui_common_feedback_error), new c());
            if (positiveButton.isShowing()) {
                QLog.e("QFSPersonalTitleMorePart", 1, "[showDeleteDialog] dialog is showing");
                return;
            } else {
                positiveButton.show();
                return;
            }
        }
        QLog.e("QFSPersonalTitleMorePart", 1, "[showDeleteDialog] activity is finish");
    }

    public void I9() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.tencent.biz.qqcircle.immersive.personal.utils.k.f(), com.tencent.biz.qqcircle.immersive.personal.utils.k.f89090c, (String) null, (DialogInterface.OnClickListener) null, new b());
            if (createCustomDialog.isShowing()) {
                QLog.e("QFSPersonalTitleMorePart", 1, "[showWarningDialog] dialog is showing");
                return;
            } else {
                createCustomDialog.show();
                return;
            }
        }
        QLog.e("QFSPersonalTitleMorePart", 1, "[showWarningDialog] activity is finish");
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalTitleMorePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f44511pd) {
            C9();
        } else if (id5 == R.id.f44521pe && !fb0.a.b("QFSPersonalTitleMorePart_showWarningDialog", 1000L)) {
            I9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f44511pd);
        this.f88870d = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f44521pe);
        this.f88871e = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        this.f88872f.g2().removeObserver(this.f88873h);
        super.onPartDestroy(activity);
    }
}
