package com.qzone.publish.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.component.banner.NetStateCheckBanner;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.business.task.QZoneQunUploadPicTask;
import com.qzone.publish.business.task.QZoneUploadAlbumVideoTask;
import com.qzone.publish.business.task.QZoneUploadPicTask;
import com.qzone.publish.business.task.QZoneUploadShuoShuoTask;
import com.qzone.publish.business.task.QzoneQuoteQunPicTask;
import com.qzone.publish.ui.fragment.QzoneUploadMessageFragment;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.PercentProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.pubaccount.publish.PubAccountTaskQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes39.dex */
public class QZonePublishQueueAcitvity extends QZoneTitleBarFragmentV2 implements IWeakNetStatusHandler {

    /* renamed from: z0, reason: collision with root package name */
    public static boolean f51628z0 = true;

    /* renamed from: i0, reason: collision with root package name */
    private SlideDetectListView f51630i0;

    /* renamed from: j0, reason: collision with root package name */
    private j f51631j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f51632k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f51633l0;

    /* renamed from: m0, reason: collision with root package name */
    private com.qzone.publish.business.publishqueue.a f51634m0;

    /* renamed from: o0, reason: collision with root package name */
    public ActionSheet f51636o0;

    /* renamed from: p0, reason: collision with root package name */
    private IQueueTask f51637p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f51638q0;

    /* renamed from: r0, reason: collision with root package name */
    NetStateCheckBanner f51639r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f51640s0;

    /* renamed from: h0, reason: collision with root package name */
    public int f51629h0 = 1;

    /* renamed from: n0, reason: collision with root package name */
    private List<IQueueTask> f51635n0 = new ArrayList();

    /* renamed from: t0, reason: collision with root package name */
    private final String f51641t0 = com.qzone.reborn.configx.g.f53821a.b().k1();

    /* renamed from: u0, reason: collision with root package name */
    com.qzone.publish.business.publishqueue.b f51642u0 = new com.qzone.publish.business.publishqueue.b() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.4
        @Override // com.qzone.publish.business.publishqueue.b
        public void onQueueChanged() {
            QZonePublishQueueAcitvity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.4.1
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishQueueAcitvity.this.Hi();
                }
            });
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void H(final IQueueTask iQueueTask) {
            if (iQueueTask == null) {
                return;
            }
            QZonePublishQueueAcitvity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.4.2
                @Override // java.lang.Runnable
                public void run() {
                    View findViewWithTag = QZonePublishQueueAcitvity.this.f51630i0.findViewWithTag(iQueueTask);
                    if (findViewWithTag == null || findViewWithTag.getTag(R.id.f166945jb2) == null) {
                        return;
                    }
                    QZonePublishQueueAcitvity.this.f51631j0.b((k) findViewWithTag.getTag(R.id.f166945jb2), iQueueTask);
                }
            });
        }
    };

    /* renamed from: v0, reason: collision with root package name */
    private View.OnClickListener f51643v0 = new i();

    /* renamed from: w0, reason: collision with root package name */
    private View.OnLongClickListener f51644w0 = new a();

    /* renamed from: x0, reason: collision with root package name */
    private View.OnClickListener f51645x0 = new b();

    /* renamed from: y0, reason: collision with root package name */
    private SlideDetectListView.c f51646y0 = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity$5, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass5 implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IQueueTask f51653d;

        AnonymousClass5(IQueueTask iQueueTask) {
            this.f51653d = iQueueTask;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishQueueAcitvity.this.simpleClassname, view);
            ActionSheet actionSheet = QZonePublishQueueAcitvity.this.f51636o0;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
            ActionSheet actionSheet2 = QZonePublishQueueAcitvity.this.f51636o0;
            if (actionSheet2 == null || actionSheet2.getActionMenuItem(i3) == null) {
                return;
            }
            int i16 = QZonePublishQueueAcitvity.this.f51636o0.getActionMenuItem(i3).action;
            if (i16 == 1) {
                this.f51653d.increaseManualRetryNum();
                QZonePublishQueueAcitvity.this.Ci(this.f51653d);
                QLog.i("QZonePublishQueueAcitvity", 1, "showUploadDialog handlePublishSingleClick task=" + this.f51653d + ", taskId=" + this.f51653d.getTaskId());
                QZonePublishQueueAcitvity.this.f51634m0.j(this.f51653d);
                return;
            }
            if (i16 == 2) {
                final boolean Bi = QZonePublishQueueAcitvity.this.Bi(this.f51653d);
                final String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogDeleteAll", "\u5168\u90e8\u5220\u9664");
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Bi && QZonePublishQueueAcitvity.f51628z0 && QZonePublishQueueAcitvity.this.f51634m0.e().size() > 0) {
                            QZonePublishQueueAcitvity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZonePublishQueueAcitvity qZonePublishQueueAcitvity = QZonePublishQueueAcitvity.this;
                                    qZonePublishQueueAcitvity.Fi(qZonePublishQueueAcitvity.getString(R.string.gie), config, com.qzone.util.l.a(R.string.j6l));
                                    QZonePublishQueueAcitvity.f51628z0 = false;
                                }
                            });
                        }
                    }
                });
            } else if (i16 == 3) {
                QZonePublishQueueAcitvity.this.Di(this.f51653d);
            } else {
                if (i16 != 4) {
                    return;
                }
                String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancelUpload", "\u653e\u5f03\u4e0a\u4f20");
                QZonePublishQueueAcitvity qZonePublishQueueAcitvity = QZonePublishQueueAcitvity.this;
                qZonePublishQueueAcitvity.Fi(qZonePublishQueueAcitvity.getString(R.string.gif), config2, com.qzone.util.l.a(R.string.j6l));
            }
        }
    }

    /* loaded from: classes39.dex */
    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Object tag;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (QZLog.isColorLevel() && (tag = view.getTag()) != null && (tag instanceof QZoneQueueTask)) {
                FragmentTransaction beginTransaction = QZonePublishQueueAcitvity.this.getParentFragmentManager().beginTransaction();
                QzoneUploadMessageFragment qzoneUploadMessageFragment = new QzoneUploadMessageFragment();
                qzoneUploadMessageFragment.setArguments(QzoneUploadMessageFragment.rh((QZoneQueueTask) tag));
                String simpleName = QzoneUploadMessageFragment.class.getSimpleName();
                beginTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
                beginTransaction.add(R.id.kjm, qzoneUploadMessageFragment, simpleName);
                beginTransaction.addToBackStack(simpleName);
                beginTransaction.commitAllowingStateLoss();
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishQueueAcitvity.this.simpleClassname, view);
            Button button = (Button) view.findViewById(R.id.f164960bf0);
            if (button.getTag() != null) {
                int intValue = ((Integer) button.getTag()).intValue();
                if (QZonePublishQueueAcitvity.this.f51631j0 != null) {
                    if (QZonePublishQueueAcitvity.this.Bi((QZoneQueueTask) QZonePublishQueueAcitvity.this.f51631j0.getItem(intValue))) {
                        if (QZonePublishQueueAcitvity.this.f51630i0 != null) {
                            QZonePublishQueueAcitvity.this.f51630i0.j0();
                        }
                        QZonePublishQueueAcitvity.this.f51631j0.d("");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishQueueAcitvity.this.f51639r0.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (QZonePublishQueueAcitvity.this.f51631j0.isEmpty()) {
                QZonePublishQueueAcitvity.this.zi();
                QZonePublishQueueAcitvity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QZonePublishQueueAcitvity.this.f51637p0 = null;
            QZonePublishQueueAcitvity.this.f51638q0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f51665d;

        g(CopyOnWriteArrayList copyOnWriteArrayList) {
            this.f51665d = copyOnWriteArrayList;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishQueueAcitvity.this.Ai(this.f51665d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes39.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishQueueAcitvity.this.simpleClassname, view);
            Object tag = view.getTag();
            if (tag != null && (tag instanceof QZoneQueueTask)) {
                QZoneQueueTask qZoneQueueTask = (QZoneQueueTask) tag;
                if (!QZonePublishQueueAcitvity.this.isFinishing()) {
                    try {
                        QZonePublishQueueAcitvity.this.Gi(qZoneQueueTask);
                    } catch (Throwable th5) {
                        QLog.e("QZonePublishQueueAcitvity", 1, "[onClick] error: ", th5);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f51675a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f51676b;

        /* renamed from: c, reason: collision with root package name */
        AsyncImageView f51677c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f51678d;

        /* renamed from: e, reason: collision with root package name */
        CellTextView f51679e;

        /* renamed from: f, reason: collision with root package name */
        TextView f51680f;

        /* renamed from: g, reason: collision with root package name */
        TextView f51681g;

        /* renamed from: h, reason: collision with root package name */
        ShaderAnimLayout f51682h;

        /* renamed from: i, reason: collision with root package name */
        Button f51683i;

        /* renamed from: j, reason: collision with root package name */
        PercentProgressBar f51684j;

        /* renamed from: k, reason: collision with root package name */
        ProgressBar f51685k;

        k() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai(CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList) {
        if (this.f51634m0 == null) {
            return;
        }
        Iterator<IQueueTask> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            this.f51634m0.f(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(IQueueTask iQueueTask) {
        if ((iQueueTask instanceof QZoneUploadShuoShuoTask) && ((QZoneUploadShuoShuoTask) iQueueTask).isVideoTask()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("manual_retry_count", String.valueOf(iQueueTask.getManualRetryNum()));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), "ManualRetryCount_Video", true, 0L, 0L, hashMap, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi(String str, String str2, String str3) {
        com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
        if (aVar == null) {
            return;
        }
        CopyOnWriteArrayList<IQueueTask> e16 = aVar.e();
        if (e16.size() == 0) {
            return;
        }
        DialogUtil.createCustomDialog(getActivity(), 230, (String) null, str, str3, str2, new g(e16), new h()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi() {
        IQueueTask iQueueTask;
        IQueueTask iQueueTask2;
        com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
        CopyOnWriteArrayList<IQueueTask> a16 = aVar != null ? aVar.a() : null;
        if ((a16 != null ? a16.size() : 0) == 0) {
            this.f51635n0.clear();
            this.f51631j0.notifyDataSetChanged();
            return;
        }
        if (a16 != null && (iQueueTask2 = this.f51637p0) != null && !a16.contains(iQueueTask2)) {
            xi();
        } else if (a16 != null && (iQueueTask = this.f51637p0) != null) {
            int state = iQueueTask.getState();
            if (this.f51638q0 != state && state == 2) {
                xi();
            } else {
                this.f51638q0 = state;
            }
        }
        this.f51635n0.clear();
        this.f51635n0.addAll(a16);
        this.f51631j0.notifyDataSetChanged();
        wi();
    }

    private void parseIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f51640s0 = intent.getStringExtra("key_left_button_title");
            this.f51629h0 = intent.getIntExtra(QZoneHelper.Constants.KEY_TYPE_QUEUE, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wi() {
        boolean z16;
        List<IQueueTask> list = this.f51635n0;
        if (list != null) {
            int size = list.size();
            z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                IQueueTask iQueueTask = this.f51635n0.get(i3);
                if (iQueueTask != null) {
                    if (iQueueTask.getState() == 2 || (super.checkNetworkConnect() && iQueueTask.getState() == 6)) {
                        z16 = true;
                    }
                    com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
                    if (aVar != null && aVar.h(iQueueTask, false)) {
                    }
                }
            }
            if (!z16) {
                this.E.setVisibility(0);
                return;
            } else {
                this.E.setVisibility(4);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private void xi() {
        try {
            ActionSheet actionSheet = this.f51636o0;
            if (actionSheet == null || !actionSheet.isShowing()) {
                return;
            }
            this.f51636o0.dismiss();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        Intent intent = new Intent();
        intent.setAction("troop_upload");
        intent.putExtra("count", 0);
        intent.putExtra("fail", false);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
    }

    public void Di(IQueueTask iQueueTask) {
        String str;
        com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
        if (aVar instanceof QZonePublishQueue) {
            QZonePublishQueue qZonePublishQueue = (QZonePublishQueue) aVar;
            Intent x16 = ak.x(getActivity(), getString(R.string.gp6), 0);
            x16.putExtra("refer", "QZonePublishQueueAcitvity");
            if (iQueueTask instanceof QZoneUploadPicTask) {
                str = ((QZoneUploadPicTask) iQueueTask).getAlbumId();
            } else if (iQueueTask instanceof QZoneQunUploadPicTask) {
                str = ((QZoneQunUploadPicTask) iQueueTask).getAlbumId();
            } else if (iQueueTask instanceof QZoneUploadAlbumVideoTask) {
                str = ((QZoneUploadAlbumVideoTask) iQueueTask).sAlbumID;
            } else {
                str = "";
            }
            x16.putExtra("albumid", str);
            x16.putExtra(QZoneQueueTask.RESUMENUM, qZonePublishQueue.v(str));
            startActivityForResult(x16, 2);
        }
    }

    protected void initUI() {
        this.f51632k0 = getResources().getDimensionPixelSize(R.dimen.a1i);
        this.f51633l0 = getResources().getDimensionPixelSize(R.dimen.a1h);
        setTitle(getResources().getString(R.string.glu));
        NetStateCheckBanner netStateCheckBanner = (NetStateCheckBanner) findViewById(R.id.h_8);
        this.f51639r0 = netStateCheckBanner;
        netStateCheckBanner.B().setTextColor(getResources().getColor(R.color.aa9));
        this.f51639r0.B().setText(R.string.cmc);
        this.f51639r0.D().setBackgroundResource(R.drawable.cin);
        this.f51639r0.D().setMinimumHeight(ViewUtils.dip2px(42.0f));
        this.f51639r0.setOnClickListener(new d());
        this.f51639r0.A().setImageResource(R.drawable.bvg);
        if (!super.checkNetworkConnect()) {
            this.f51639r0.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.f51640s0)) {
            this.C.setText(R.string.f170549u3);
        } else {
            this.C.setText(this.f51640s0);
        }
        setRightButton(R.string.d7p, new View.OnClickListener() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (QZonePublishQueueAcitvity.this.f51635n0 != null) {
                    int size = QZonePublishQueueAcitvity.this.f51635n0.size();
                    QLog.i("QZonePublishQueueAcitvity", 1, "initUI handlePublishAllBtnClick size=" + size);
                    for (int i3 = 0; i3 < size; i3++) {
                        IQueueTask iQueueTask = (IQueueTask) QZonePublishQueueAcitvity.this.f51635n0.get(i3);
                        if ((iQueueTask.getState() == 2 || iQueueTask.getState() == 6) && QZonePublishQueueAcitvity.this.f51634m0 != null) {
                            QZonePublishQueueAcitvity.this.f51634m0.j(iQueueTask);
                        }
                    }
                }
                QZonePublishQueueAcitvity.this.f51631j0.notifyDataSetChanged();
                QZonePublishQueueAcitvity.this.getHandler().postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishQueueAcitvity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZonePublishQueueAcitvity.this.wi();
                    }
                }, 500L);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.E.setVisibility(8);
        SlideDetectListView slideDetectListView = (SlideDetectListView) findViewById(R.id.g58);
        this.f51630i0 = slideDetectListView;
        slideDetectListView.setOnSlideListener(this.f51646y0);
        j jVar = new j(getActivity());
        this.f51631j0 = jVar;
        jVar.h(this.f51630i0);
        this.f51631j0.f(this.f51643v0);
        this.f51631j0.e(this.f51645x0);
        this.f51631j0.g(this.f51644w0);
        this.f51630i0.setAdapter((ListAdapter) this.f51631j0);
        SlideDetectListView slideDetectListView2 = this.f51630i0;
        slideDetectListView2.setDivider(ContextCompat.getDrawable(slideDetectListView2.getContext(), R.drawable.qui_common_border_standard_bg));
        this.f51630i0.setDividerHeight(ImmersiveUtils.dpToPx(0.5f));
        this.f51631j0.registerDataSetObserver(new e());
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
        if (aVar instanceof QZonePublishQueue) {
            QZonePublishQueue qZonePublishQueue = (QZonePublishQueue) aVar;
            if (i16 == -1 && i3 == 2 && intent != null) {
                BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO);
                String stringExtra = intent.getStringExtra("albumid");
                if (businessAlbumInfo == null || TextUtils.isEmpty(stringExtra) || !(this.f51634m0 instanceof QZonePublishQueue)) {
                    return;
                }
                qZonePublishQueue.Y(stringExtra, businessAlbumInfo.mAlbumId, businessAlbumInfo.mTitle);
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.f51641t0)) {
            return;
        }
        AppNetConnInfo.registerWeakNetStatusHandler(null, this);
        QLog.d("QZonePublishQueueAcitvity", 1, "onCreate registerWeakNetStatusHandler");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onNetStateChanged(boolean z16) {
        wi();
        if (!z16) {
            NetStateCheckBanner netStateCheckBanner = this.f51639r0;
            if (netStateCheckBanner != null) {
                netStateCheckBanner.setVisibility(0);
                return;
            }
            return;
        }
        NetStateCheckBanner netStateCheckBanner2 = this.f51639r0;
        if (netStateCheckBanner2 != null) {
            netStateCheckBanner2.setVisibility(8);
        }
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        parseIntent();
        initUI();
        if (this.f51629h0 != 2) {
            this.f51634m0 = QZonePublishQueue.w();
        } else {
            this.f51634m0 = PubAccountTaskQueue.t();
        }
        this.f51634m0.i(this.f51642u0);
        Hi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f51669d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f51670e;

        /* renamed from: f, reason: collision with root package name */
        private String f51671f = "";

        /* renamed from: h, reason: collision with root package name */
        private com.tencent.mobileqq.widget.u f51672h = null;

        /* renamed from: i, reason: collision with root package name */
        private View.OnClickListener f51673i = null;

        /* renamed from: m, reason: collision with root package name */
        private View.OnClickListener f51674m = null;
        private View.OnLongClickListener C = null;

        public j(Context context) {
            this.f51669d = context;
            this.f51670e = LayoutInflater.from(context);
        }

        public void d(String str) {
            this.f51671f = str;
        }

        public void e(View.OnClickListener onClickListener) {
            this.f51673i = onClickListener;
        }

        public void f(View.OnClickListener onClickListener) {
            this.f51674m = onClickListener;
        }

        public void g(View.OnLongClickListener onLongClickListener) {
            this.C = onLongClickListener;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return QZonePublishQueueAcitvity.this.f51635n0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void h(com.tencent.mobileqq.widget.u uVar) {
            this.f51672h = uVar;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public IQueueTask getItem(int i3) {
            if (i3 < 0 || i3 >= QZonePublishQueueAcitvity.this.f51635n0.size()) {
                return null;
            }
            return (IQueueTask) QZonePublishQueueAcitvity.this.f51635n0.get(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(k kVar, IQueueTask iQueueTask) {
            if (iQueueTask == null) {
                return;
            }
            kVar.f51680f.setVisibility(4);
            kVar.f51678d.setVisibility(8);
            com.qzone.publish.business.task.c info = iQueueTask.getInfo();
            String str = "";
            if (info != null) {
                kVar.f51679e.setCellClickable(false);
                kVar.f51679e.setClickable(false);
                kVar.f51679e.setLongclickable(false);
                kVar.f51679e.setRichText(info.f51185a);
                kVar.f51679e.setMaxLine(1);
                int i3 = info.f51187c;
                if (i3 != 0 && i3 != 4 && i3 != 1 && i3 != 6) {
                    if (i3 == 3) {
                        kVar.f51681g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    } else {
                        kVar.f51681g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.esx, 0, 0, 0);
                    }
                    kVar.f51684j.setVisibility(4);
                } else {
                    int i16 = info.f51190f;
                    if (i16 > 0) {
                        kVar.f51684j.setProgress(i16);
                        kVar.f51684j.setVisibility(0);
                    } else {
                        kVar.f51684j.setVisibility(4);
                    }
                    kVar.f51681g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
                kVar.f51681g.setText(info.f51186b);
                if (info.f51191g) {
                    kVar.f51685k.setVisibility(0);
                } else {
                    kVar.f51685k.setVisibility(8);
                }
                if (info.f51193i) {
                    kVar.f51678d.setVisibility(0);
                } else {
                    kVar.f51678d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(info.f51192h)) {
                    try {
                        File file = new File(info.f51192h);
                        if (file.exists() && !file.isDirectory()) {
                            str = info.f51192h;
                        }
                    } catch (Throwable th5) {
                        QLog.e("QZonePublishQueueAcitvity", 1, "[fillValue] find file fail, error: ", th5);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = iQueueTask.getPhotoSource();
                }
                int i17 = info.f51194j;
                if (i17 > 0) {
                    kVar.f51680f.setText(String.valueOf(i17));
                    kVar.f51680f.setVisibility(0);
                } else {
                    kVar.f51680f.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                kVar.f51677c.setDefaultImage(R.drawable.asd);
                kVar.f51677c.setAsyncClipSize(QZonePublishQueueAcitvity.this.f51632k0, QZonePublishQueueAcitvity.this.f51633l0);
                kVar.f51677c.setAsyncImage(str);
                return;
            }
            kVar.f51677c.setImageResource(R.drawable.gct);
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            k kVar;
            if (view == null) {
                view = this.f51670e.inflate(R.layout.bq_, (ViewGroup) null);
                kVar = new k();
                kVar.f51675a = (RelativeLayout) view.findViewById(R.id.drr);
                kVar.f51676b = (LinearLayout) view.findViewById(R.id.f166907j23);
                CellTextView cellTextView = (CellTextView) view.findViewById(R.id.g4x);
                kVar.f51679e = cellTextView;
                cellTextView.setPadding(0, 0, ViewUtils.dpToPx(16.0f), 0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.f51679e.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.rightMargin = 0;
                }
                kVar.f51679e.setLineBreakNeeded(false);
                kVar.f51680f = (TextView) view.findViewById(R.id.e7h);
                kVar.f51677c = (AsyncImageView) view.findViewById(R.id.kkc);
                kVar.f51678d = (ImageView) view.findViewById(R.id.f166751hu3);
                kVar.f51684j = (PercentProgressBar) view.findViewById(R.id.kjx);
                kVar.f51681g = (TextView) view.findViewById(R.id.i6s);
                kVar.f51682h = (ShaderAnimLayout) view.findViewById(R.id.iqk);
                kVar.f51683i = (Button) view.findViewById(R.id.f164960bf0);
                kVar.f51685k = (ProgressBar) view.findViewById(R.id.d0v);
                view.setTag(R.id.f166945jb2, kVar);
            } else {
                kVar = (k) view.getTag(R.id.f166945jb2);
            }
            IQueueTask item = getItem(i3);
            String yi5 = QZonePublishQueueAcitvity.this.yi(item, i3);
            b(kVar, item);
            String str = this.f51671f;
            if (str != null && str.equals(yi5)) {
                kVar.f51682h.g();
                com.tencent.mobileqq.widget.u uVar = this.f51672h;
                if (uVar != null) {
                    uVar.setMotionView(view, i3);
                }
                kVar.f51683i.setOnClickListener(this.f51673i);
                kVar.f51683i.setTag(Integer.valueOf(i3));
                kVar.f51676b.setVisibility(4);
            } else {
                kVar.f51682h.b();
                kVar.f51683i.setOnClickListener(null);
                kVar.f51683i.setTag(null);
                kVar.f51676b.setVisibility(0);
            }
            view.setTag(item);
            view.setOnClickListener(this.f51674m);
            View.OnLongClickListener onLongClickListener = this.C;
            if (onLongClickListener != null) {
                view.setOnLongClickListener(onLongClickListener);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f51636o0 = null;
        super.onDestroy();
        if (TextUtils.isEmpty(this.f51641t0)) {
            return;
        }
        AppNetConnInfo.unRegisterWeakNetStatusHandler(this);
        QLog.d("QZonePublishQueueAcitvity", 1, "onDestroy unRegisterWeakNetStatusHandler");
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onNormalToWeakNet(int i3) {
        QLog.d("QZonePublishQueueAcitvity", 1, "onNormalToWeakNet reason:", Integer.valueOf(i3));
        if (isFinishing() || !isResumed() || TextUtils.isEmpty(this.f51641t0) || this.f51635n0.isEmpty()) {
            return;
        }
        QQToastUtil.showQQToastInUiThread(0, "\u5f53\u524d\u7f51\u7edc\u8fde\u63a5\u8f83\u5f31\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85~");
    }

    /* loaded from: classes39.dex */
    class c implements SlideDetectListView.c {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.SlideDetectListView.c
        public void c(SlideDetectListView slideDetectListView, View view, int i3) {
            View findViewById = view.findViewById(R.id.iqk);
            QZonePublishQueueAcitvity.this.f51631j0.d(QZonePublishQueueAcitvity.this.yi((QZoneQueueTask) QZonePublishQueueAcitvity.this.f51631j0.getItem(i3), i3));
            if (findViewById != null) {
                Button button = (Button) findViewById.findViewById(R.id.f164960bf0);
                button.setTag(Integer.valueOf(i3));
                button.setOnClickListener(QZonePublishQueueAcitvity.this.f51645x0);
                ((ShaderAnimLayout) findViewById).f();
                QZonePublishQueueAcitvity.this.f51630i0.setDeleteAreaWidth(findViewById.getLayoutParams().width);
            }
        }

        @Override // com.tencent.mobileqq.widget.SlideDetectListView.c
        public void d(SlideDetectListView slideDetectListView, View view, int i3) {
            View findViewById = view.findViewById(R.id.iqk);
            QZonePublishQueueAcitvity.this.f51631j0.d("");
            if (findViewById != null) {
                ((ShaderAnimLayout) findViewById).a();
                Button button = (Button) findViewById.findViewById(R.id.f164960bf0);
                button.setTag(null);
                button.setOnClickListener(null);
            }
        }
    }

    private boolean Ei(IQueueTask iQueueTask) {
        com.qzone.publish.business.publishqueue.a aVar;
        if (iQueueTask == null || iQueueTask.getState() != 2 || (aVar = this.f51634m0) == null) {
            return false;
        }
        CopyOnWriteArrayList<IQueueTask> a16 = aVar.a();
        int size = a16.size();
        Iterator<IQueueTask> it = a16.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().getState() == 2) {
                i3++;
            }
        }
        return (size == i3 && size > 1) || i3 >= 5;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bq9, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bi(IQueueTask iQueueTask) {
        boolean z16 = false;
        if (iQueueTask == null) {
            return false;
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotCancelThisTask", "\u4e0d\u80fd\u53d6\u6d88\u8be5\u4e0a\u4f20\u4efb\u52a1!");
        try {
            com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
            if (aVar != null && !(z16 = aVar.f(iQueueTask))) {
                toast(config);
            }
        } catch (Exception e16) {
            QZLog.e("QZonePublishQueueAcitvity", "syncronized ", e16);
            toast(config);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yi(IQueueTask iQueueTask, int i3) {
        if (iQueueTask == null) {
            return null;
        }
        return iQueueTask.getClientKey() + "_" + iQueueTask.getUploadTime() + "_" + i3;
    }

    public void Gi(IQueueTask iQueueTask) {
        int i3;
        if (iQueueTask == null) {
            return;
        }
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(iQueueTask);
        ArrayList arrayList = new ArrayList();
        if (iQueueTask.getState() == 2) {
            if (iQueueTask.getResultCode() != -207 && (TextUtils.isEmpty(iQueueTask.getResultMsg()) || !iQueueTask.getResultMsg().contains("-207") || iQueueTask.getResultCode() != -2000)) {
                if (iQueueTask instanceof QZoneUploadShuoShuoTask) {
                    i3 = R.string.f173036gm2;
                } else {
                    i3 = iQueueTask instanceof QzoneQuoteQunPicTask ? R.string.f173037gm3 : R.string.f173038gm4;
                }
                com.qzone.publish.business.publishqueue.a aVar = this.f51634m0;
                if (aVar != null && !aVar.h(iQueueTask, false)) {
                    arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(getActivity(), i3), 1, 0));
                }
            } else {
                arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(getActivity(), R.string.f173035gm1), 3, 0));
            }
        }
        if (Ei(iQueueTask)) {
            arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(getActivity(), R.string.f173034gm0), 4, 0, 2));
        }
        arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(getActivity(), R.string.glz), 2, 0, 2));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, anonymousClass5);
        this.f51636o0 = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        this.f51636o0.setOnDismissListener(new f());
        this.f51637p0 = iQueueTask;
        this.f51638q0 = iQueueTask.getState();
        ActionSheetHelper.showActionSheet(getActivity(), this.f51636o0);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onWeakNetToNormal(int i3) {
    }
}
