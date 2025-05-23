package com.tencent.pubaccount.publish;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StModifyFeedRsp;
import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.aj;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.util.P2VUtil;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.ExtendScrollView;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import com.tencent.pubaccount.publish.state.UIStateNormal;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MediaUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.widget.QzoneEmotionUtils;
import e9.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class QQPublicAccountPublishFeedFragment extends PhotoActivity implements View.OnClickListener {
    public com.tencent.pubaccount.publish.state.a A2;
    protected int B2;
    public ShuoshuoVideoInfo D2;
    public CertifiedAccountMeta$StFeed E2;
    protected ShuoshuoContent F2;
    public int G2;
    private boolean H2;
    private boolean J2;
    private boolean K2;
    private MoodPicLabel L2;
    private CommodityListView M2;
    private boolean N2;
    private String O2;
    private AttachGoodsBroadcastReceiver P2;
    ActionSheet R2;

    /* renamed from: t2, reason: collision with root package name */
    Activity f342283t2;

    /* renamed from: u2, reason: collision with root package name */
    protected RelativeLayout f342284u2;

    /* renamed from: v2, reason: collision with root package name */
    public EditText f342285v2;

    /* renamed from: w2, reason: collision with root package name */
    public View f342286w2;

    /* renamed from: x2, reason: collision with root package name */
    public MoodPicLabel f342287x2;

    /* renamed from: y2, reason: collision with root package name */
    public MoodPicLabel f342288y2;

    /* renamed from: z2, reason: collision with root package name */
    public boolean f342289z2 = true;
    protected boolean C2 = false;
    public final HashMap<String, Pair<String, String>> I2 = new HashMap<>();
    public View.OnClickListener Q2 = new g();
    protected boolean S2 = false;
    public View.OnClickListener T2 = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "clk_goods", 0, 0, "", "", "", "");
            com.tencent.biz.subscribe.d.l(com.tencent.biz.subscribe.b.a(QQPublicAccountPublishFeedFragment.this.O2, QQPublicAccountPublishFeedFragment.this.M2 == null ? null : QQPublicAccountPublishFeedFragment.this.M2.x()));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f342297d;

        c(int i3) {
            this.f342297d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QQPublicAccountPublishFeedFragment.this.hn(this.f342297d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f342299d;

        d(String str) {
            this.f342299d = str;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QQPublicAccountPublishFeedFragment.this.simpleClassname + " QQCustomDialog click :" + this.f342299d);
            QQPublicAccountPublishFeedFragment.this.R2.dismiss();
            QQPublicAccountPublishFeedFragment.this.Hn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class e implements ActionSheet.OnDismissListener {
        e() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QQPublicAccountPublishFeedFragment.this.simpleClassname + " QQCustomDialog click :\u53d6\u6d88");
            QQPublicAccountPublishFeedFragment.this.gm(true);
        }
    }

    /* loaded from: classes34.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQPublicAccountPublishFeedFragment.this.fm(view);
            QQPublicAccountPublishFeedFragment.this.gm(false);
            if (QQPublicAccountPublishFeedFragment.this.Ui() <= QQPublicAccountPublishFeedFragment.this.ej() && QQPublicAccountPublishFeedFragment.this.rn() <= 30) {
                QQPublicAccountPublishFeedFragment.this.dn();
                QQPublicAccountPublishFeedFragment.this.A2.c();
            } else {
                QQPublicAccountPublishFeedFragment.this.toast(R.string.f173054gr0);
            }
            ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "button", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes34.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQPublicAccountPublishFeedFragment.this.onBack();
            VSReporter.p(QQPublicAccountPublishFeedFragment.this.O2, "auth_pubish", "cancel", 0, 0, new String[0]);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = QQPublicAccountPublishFeedFragment.this;
            if (qQPublicAccountPublishFeedFragment.A2 != null && qQPublicAccountPublishFeedFragment.Wj()) {
                QQPublicAccountPublishFeedFragment.this.A2.k();
                VSReporter.p(LoginData.getInstance().getUinString(), "auth_pubish", "clk_save", 0, 0, new String[0]);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class i implements View.OnTouchListener {
        i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            View view2 = QQPublicAccountPublishFeedFragment.this.f45125q0;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            QQPublicAccountPublishFeedFragment.this.ak();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class k implements AdapterView.OnItemClickListener {
        k() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QQPublicAccountPublishFeedFragment.this.T.d0(i3) && QQPublicAccountPublishFeedFragment.this.T.H(view)) {
                QQPublicAccountPublishFeedFragment.this.Cn();
                return;
            }
            Intent intent = QQPublicAccountPublishFeedFragment.this.getIntent();
            int intExtra = intent != null ? intent.getIntExtra("key_photo_oprate_type", 1) : 1;
            if (1 == QQPublicAccountPublishFeedFragment.this.getShowType()) {
                intExtra = 4;
            }
            QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = QQPublicAccountPublishFeedFragment.this;
            qQPublicAccountPublishFeedFragment.Wk(qQPublicAccountPublishFeedFragment.P, i3, qQPublicAccountPublishFeedFragment.oj(), intExtra, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class l extends a.i {
        l() {
        }

        @Override // e9.a.i
        public boolean a() {
            return QQPublicAccountPublishFeedFragment.this.T.U() < com.qzone.publish.ui.model.b.f51929c && !QQPublicAccountPublishFeedFragment.this.I0;
        }

        @Override // e9.a.i
        public boolean b() {
            QQPublicAccountPublishFeedFragment.this.Cn();
            return true;
        }

        @Override // e9.a.i
        public boolean c(int i3) {
            QQPublicAccountPublishFeedFragment.this.tn(i3);
            return true;
        }

        @Override // e9.a.i
        public void d() {
            QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = QQPublicAccountPublishFeedFragment.this;
            ExtendScrollView extendScrollView = qQPublicAccountPublishFeedFragment.M;
            if (extendScrollView != null) {
                extendScrollView.e(qQPublicAccountPublishFeedFragment.P.getId());
            }
        }

        @Override // e9.a.i
        public void e() {
            QQPublicAccountPublishFeedFragment.this.ui();
        }

        @Override // e9.a.i
        public boolean f(View view) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class n implements DynamicGridView.s {
        n() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void a(int i3, int i16) {
            QQPublicAccountPublishFeedFragment.this.Zk(i3, i16);
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void b(int i3, int i16) {
            if (i16 == 0) {
                ClickReport.m("46", "5", "1");
            } else if (i16 == 1) {
                ClickReport.m("46", "5", "3");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public static class p implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<QQPublicAccountPublishFeedFragment> f342312d;

        public p(QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
            this.f342312d = new WeakReference<>(qQPublicAccountPublishFeedFragment);
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342312d.get();
            if (qQPublicAccountPublishFeedFragment != null) {
                if (z16 && bundle != null) {
                    long j3 = bundle.getLong("retCode", -1L);
                    String string = bundle.getString("errMsg", "");
                    if (j3 == 0) {
                        CertifiedAccountWrite$StModifyFeedRsp c16 = ze0.b.c(bundle.getByteArray("key_data"));
                        if (c16 == null) {
                            QZLog.e("[publish2]QQPublicAccountPublishFeedFragment", "certified account publish feed failed! Empty response");
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QZLog.d("[publish2]QQPublicAccountPublishFeedFragment", 2, "certified account publish feed success! feedId: " + c16.feed.f24925id.get());
                        }
                        QQToast.makeText(BaseApplication.getContext(), 2, BaseApplicationImpl.getApplication().getString(R.string.brb), 0).show();
                        Intent intent = new Intent();
                        intent.putExtra("feed", c16.feed.toByteArray());
                        qQPublicAccountPublishFeedFragment.getActivity().setResult(-1, intent);
                        qQPublicAccountPublishFeedFragment.an();
                        return;
                    }
                    QZLog.e("[publish2]QQPublicAccountPublishFeedFragment", "certified account publish feed failed! retCode: " + j3 + "; errorMsg: " + string);
                } else {
                    QZLog.e("[publish2]QQPublicAccountPublishFeedFragment", "certified account publish feed failed!" + bundle);
                }
                QQToast.makeText(BaseApplication.getContext(), 1, BaseApplicationImpl.getApplication().getString(R.string.bra), 0).show();
                qQPublicAccountPublishFeedFragment.an();
                return;
            }
            QZLog.e("[publish2]QQPublicAccountPublishFeedFragment", "certified account publish feed onReceived but QZoneUploadShuoShuoTask reference is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cn() {
        tm();
        ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "clk_pic", 0, 0, "", "", "", "");
    }

    private void Gn(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), ze0.c.class);
        newIntent.putExtra("key_request_feed_bytes", certifiedAccountMeta$StFeed.toByteArray());
        newIntent.setObserver(new p(this));
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jn(boolean z16) {
        MoodPicLabel moodPicLabel = this.L2;
        if (moodPicLabel != null) {
            moodPicLabel.setCheck(z16);
            this.L2.setContainerBackgroundResource(z16 ? R.drawable.av8 : R.drawable.av7);
        }
    }

    private void Mn(int i3) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpPhoto", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u5f20\u7167\u7247\u5417\uff1f");
        e9.a aVar = this.T;
        if (aVar != null && aVar.h0(i3)) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpVideo", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u4e2a\u89c6\u9891\u5417\uff1f");
        }
        new com.qzone.component.e().g(getActivity(), config, null, new c(i3), null);
    }

    private void Nn() {
        if (this.f342286w2 != null && !this.f45131t0 && !this.f45135v0 && bn()) {
            this.f342286w2.setVisibility(0);
            return;
        }
        View view = this.f342286w2;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void On(String str) {
        ActionSheet actionSheet = this.R2;
        if (actionSheet == null) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogUpload", "\u7acb\u5373\u4e0a\u4f20");
            ActionSheet create = ActionSheet.create(getActivity());
            this.R2 = create;
            create.setMainTitle(str);
            this.R2.addButton(config, 0);
            this.R2.addCancelButton(com.qzone.util.l.a(R.string.j6l));
            this.R2.setOnButtonClickListener(new d(config));
            this.R2.setOnDismissListener(new e());
            this.R2.show();
            return;
        }
        if (actionSheet.isShowing()) {
            return;
        }
        this.R2.show();
    }

    private void Zm(Intent intent) {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null && extendEditText.getEditableText() != null) {
            this.f45129s0 = this.f45104j0.getEditableText().toString();
        }
        com.tencent.pubaccount.publish.state.a aVar = this.A2;
        if (aVar == null || !aVar.e()) {
            return;
        }
        ((tq3.a) hj(tq3.a.class)).J();
    }

    private boolean bn() {
        return false;
    }

    private void cn() {
        if (u5.b.D(QZoneHelper.QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG, false)) {
            u5.b.o0(QZoneHelper.QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG, false);
            fl();
        }
    }

    private CertifiedAccountMeta$StFeed pn(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        CommodityListView commodityListView = this.M2;
        if (commodityListView != null && commodityListView.f() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.M2.f().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof CommodityBean) {
                    arrayList.add(((CommodityBean) next).convertToYouzanGood());
                }
            }
            QZLog.d("[publish2]QQPublicAccountPublishFeedFragment", 4, "getModifiedFeed size:" + arrayList.size());
            certifiedAccountMeta$StFeed.goods.set(arrayList);
        }
        return certifiedAccountMeta$StFeed;
    }

    private boolean yn() {
        return this.B2 == 1;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int Aj() {
        return R.layout.c77;
    }

    protected void An() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("shareAfterFinish", this.H2);
        com.tencent.biz.subscribe.d.x(getActivity(), LoginData.getInstance().getPostUin(), intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Bk(MotionEvent motionEvent) {
        if (super.Bk(motionEvent)) {
            return true;
        }
        if (this.f342285v2 == null) {
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) (motionEvent.getY() + getTitleBarHeight() + this.mStatusBarHeight);
        Rect h16 = aj.h(this.f342285v2);
        return h16 != null && h16.contains(x16, y16);
    }

    protected boolean Bn(String str, int i3, int i16) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(20);
            int i17 = (int) (i3 * i16 * 10.1d);
            QLog.d("[publish2]QQPublicAccountPublishFeedFragment", 4, "bitrate:" + extractMetadata + "  maxbitrate:" + i17);
            return Integer.valueOf(extractMetadata).intValue() > i17;
        } catch (Exception unused) {
            QLog.d("[publish2]QQPublicAccountPublishFeedFragment", 4, "get bitrate failed");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Di(String str) {
        boolean Di = super.Di(str);
        if (Di) {
            u5.b.q("_qq_public_account_publish", LoginData.getInstance().getUin());
        }
        return Di;
    }

    protected void En(ArrayList<String> arrayList) {
        final ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (o7.b.a(next)) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment.18
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        String str = (String) it5.next();
                        MediaUtil.saveFileToSystemAlbum(QQPublicAccountPublishFeedFragment.this.getActivity(), str, System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END);
                    }
                }
            });
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Fi(MotionEvent motionEvent) {
        View childAt;
        DynamicGridView dynamicGridView = this.P;
        if (dynamicGridView != null && this.T != null) {
            int lastVisiblePosition = dynamicGridView.getLastVisiblePosition();
            if (!this.f45084c1 && this.T.d0(lastVisiblePosition) && (childAt = this.P.getChildAt(lastVisiblePosition)) != null && this.T.H(childAt) && aj.k(motionEvent, childAt, getTitleBarHeight(), this.mStatusBarHeight) && (dk(true) || ak() || bk())) {
                Cn();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Fk(Intent intent) {
        super.Fk(intent);
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.u0(this.W, this.X, this.f45080b0, true);
        }
    }

    public void Fn() {
        if (this.I2 == null) {
            fn();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Pair<String, String>> entry : this.I2.entrySet()) {
                String key = entry.getKey();
                Pair<String, String> value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    String str = (String) value.first;
                    String str2 = (String) value.second;
                    jSONObject.put(URLEncoder.encode(key, "UTF-8"), str + "_" + str2);
                }
            }
            u5.b.x0("peitu_entry_sourceid", jSONObject.toString(), LoginData.getInstance().getUin());
        } catch (UnsupportedEncodingException e16) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, e16, new Object[0]);
        } catch (JSONException e17) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, e17, new Object[0]);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Kk() {
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Km() {
        if (yn()) {
            this.P.setEnabled(false);
            this.P.setAlpha(0.3f);
            this.f342287x2.setEnabled(false);
            this.f342287x2.setAlpha(0.3f);
            this.f342285v2.setEnabled(false);
            this.f342285v2.setAlpha(0.3f);
            this.f45104j0.setEnabled(false);
            this.f45104j0.setAlpha(0.3f);
        }
    }

    public void Kn(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.E2 = certifiedAccountMeta$StFeed;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Lk() {
        return false;
    }

    protected void Ln(int i3) {
        this.f342286w2.setVisibility(i3);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Mi() {
        ArrayList<String> oj5;
        return (this.f342285v2 == null || this.f45104j0 == null || (oj5 = oj()) == null || oj5.isEmpty()) ? false : true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Mk() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Nk() {
        return false;
    }

    public void Qn(ArrayList arrayList) {
        if (this.M2 != null) {
            if (arrayList.size() == 0) {
                this.M2.w();
                this.M2.setVisibility(8);
                Jn(false);
            } else {
                Jn(true);
                if (this.M2.getVisibility() == 8) {
                    this.M2.setVisibility(0);
                }
                this.M2.setData(arrayList);
            }
        }
    }

    public void Rn(LbsDataV2.PoiInfo poiInfo) {
        this.M0 = poiInfo;
        Yl(poiInfo.poiName);
    }

    public void Sn() {
        if (yn()) {
            EditText editText = this.f342285v2;
            if (editText != null) {
                editText.setText(this.E2.title.get());
            }
            if (this.f45104j0 != null) {
                String str = this.E2.content.get();
                if (TextUtils.isEmpty(str)) {
                    this.f45104j0.setHint("");
                } else {
                    this.f45104j0.setText(QzoneEmotionUtils.emCodesToQQcodes(str));
                }
            }
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Wj() {
        ArrayList<String> oj5 = oj();
        if (oj5 != null && !oj5.isEmpty()) {
            return true;
        }
        if ((ln() == null || ln().size() <= 0) && TextUtils.isEmpty(PhotoActivity.tj(this.f342285v2).trim())) {
            return super.Wj();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Xk(View view, MotionEvent motionEvent) {
        boolean Xk = super.Xk(view, motionEvent);
        View view2 = this.f45125q0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        return Xk;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Yl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(getString(R.string.f173025gk1)) && !str.equals(getString(R.string.f173026gk2)) && !str.equals(getString(R.string.gns))) {
                MoodPicLabel moodPicLabel = this.f342287x2;
                if (moodPicLabel != null) {
                    moodPicLabel.setCheck(true);
                    this.f342287x2.setImageAndText(getResources().getDrawable(R.drawable.f162315gd4), str);
                    this.f342287x2.setContainerBackgroundResource(R.drawable.av8);
                    this.f342287x2.setVisibility(0);
                }
                MoodPicLabel moodPicLabel2 = this.f342288y2;
                if (moodPicLabel2 != null) {
                    moodPicLabel2.setCheck(true);
                    this.f342288y2.setImageAndText(getResources().getDrawable(R.drawable.f162315gd4), str);
                    this.f342288y2.setContainerBackgroundResource(R.drawable.av8);
                    this.f342288y2.setVisibility(0);
                }
            } else {
                String string = getString(R.string.f173026gk2);
                MoodPicLabel moodPicLabel3 = this.f342287x2;
                if (moodPicLabel3 != null) {
                    moodPicLabel3.setCheck(false);
                    this.f342287x2.setImageAndText(getResources().getDrawable(R.drawable.aw_), string);
                    this.f342287x2.setContainerBackgroundResource(R.drawable.av7);
                }
                MoodPicLabel moodPicLabel4 = this.f342288y2;
                if (moodPicLabel4 != null) {
                    moodPicLabel4.setCheck(false);
                    this.f342288y2.setImageAndText(getResources().getDrawable(R.drawable.aw_), string);
                    this.f342288y2.setContainerBackgroundResource(R.drawable.av7);
                }
            }
        }
        ui();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, c5.a
    public boolean checkNetworkConnect() {
        if (super.checkNetworkConnect()) {
            return true;
        }
        getHandler().sendEmptyMessage(100001);
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int dj() {
        return 9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void dl(Bundle bundle) {
        super.dl(bundle);
        int i3 = bundle.getInt("mStateType");
        this.B2 = i3;
        com.tencent.pubaccount.publish.state.a d16 = com.tencent.pubaccount.publish.state.a.d(i3, this);
        this.A2 = d16;
        d16.l(this.J);
    }

    protected void dn() {
        long C;
        if (yn()) {
            Gn(pn(this.E2));
            return;
        }
        if (NetworkState.isWifiConn()) {
            Hn();
            return;
        }
        if (this.f45084c1) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.D2;
            if (shuoshuoVideoInfo != null) {
                C = 1 == shuoshuoVideoInfo.mIsNew ? 0L : Math.round(shuoshuoVideoInfo.mEstimateSize);
            } else {
                C = this.f45099h1;
            }
        } else {
            C = com.qzone.util.image.c.C(kn(), oj(), this.D0, this.E0);
        }
        if (com.qzone.util.image.c.M(C)) {
            On(com.qzone.util.image.c.H(C, this.f45084c1));
        } else {
            Hn();
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int ej() {
        return 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void el(Bundle bundle) {
        super.el(bundle);
        bundle.putInt("mStateType", this.B2);
    }

    protected boolean en() {
        HashMap<String, LocalMediaInfo> hashMap;
        if (zk()) {
            return false;
        }
        HashMap<String, ShuoshuoVideoInfo> hashMap2 = this.Z;
        return (hashMap2 != null && hashMap2.size() > 0) || (this.U.size() > 0 && (hashMap = this.W) != null && hashMap.size() > 0 && QAlbumUtil.getMediaType(this.W.get(this.U.get(0))) == 1);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        if (this.G && this.A2 != null && this.f342289z2 && Wj()) {
            this.A2.k();
        }
        vi();
        com.tencent.pubaccount.publish.state.a aVar = this.A2;
        if (aVar != null) {
            aVar.b();
        }
        super.finish();
        overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
    }

    public void fn() {
        u5.b.A0("peitu_entry_sourceid", LoginData.getInstance().getUin());
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public int getAppId() {
        return WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.c76;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public Activity getRealActivity() {
        if (this.f342283t2 == null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (activity instanceof QzonePluginProxyActivity)) {
                Object realPluginActivity = ((QzonePluginProxyActivity) activity).getRealPluginActivity();
                if (realPluginActivity != null && (realPluginActivity instanceof Activity)) {
                    this.f342283t2 = (Activity) realPluginActivity;
                }
            } else {
                this.f342283t2 = activity;
            }
        }
        return this.f342283t2;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public View getRoot() {
        return this.f342284u2;
    }

    protected e9.a gn() {
        return new e9.a(getActivity(), this.P, 1000, 1.15f, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void hl() {
        super.hl();
        if (this.J2) {
            return;
        }
        this.J2 = true;
        ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "text", 0, 0, "", "", "", "");
    }

    protected void hn(int i3) {
        final String str = (oj() == null || i3 >= oj().size()) ? null : oj().get(i3);
        Yk(i3);
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap != null && hashMap.size() > 0) {
                this.Z.remove(str);
            }
            HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = this.U1;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                this.U1.remove(str);
            }
            HashMap<String, Boolean> hashMap3 = this.V1;
            if (hashMap3 != null && hashMap3.containsKey(str)) {
                this.V1.remove(str);
            }
            HashMap<String, ArrayList<FaceData>> hashMap4 = this.X1;
            if (hashMap4 != null && hashMap4.containsKey(str)) {
                this.X1.remove(str);
            }
            HashMap<String, Boolean> hashMap5 = this.W1;
            if (hashMap5 != null && hashMap5.containsKey(str)) {
                this.W1.remove(str);
            }
        }
        this.P.n1(i3, new Runnable() { // from class: com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment.13
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && ((PhotoActivity) QQPublicAccountPublishFeedFragment.this).A0 != null && ((PhotoActivity) QQPublicAccountPublishFeedFragment.this).A0.size() > 0) {
                    ((PhotoActivity) QQPublicAccountPublishFeedFragment.this).A0.remove(str);
                }
                if (QQPublicAccountPublishFeedFragment.this.oj() != null && QQPublicAccountPublishFeedFragment.this.oj().size() < QQPublicAccountPublishFeedFragment.this.dj() && QQPublicAccountPublishFeedFragment.this.in()) {
                    QQPublicAccountPublishFeedFragment.this.T.o0(true, true);
                }
                QQPublicAccountPublishFeedFragment.this.ui();
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void im(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f169032bq0, (ViewGroup) null);
        this.f342286w2 = inflate;
        inflate.setVisibility(4);
        linearLayout.addView(this.f342286w2, layoutParams);
    }

    protected boolean in() {
        return true;
    }

    protected void initUI() {
        un();
        vn();
        wn();
        P2VUtil.d().j(getActivity().getApplicationContext());
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void jk() {
        Nn();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x010a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jn(ShuoshuoContent shuoshuoContent) {
        EditText editText = this.f342285v2;
        if (editText == null || this.f45104j0 == null) {
            return false;
        }
        String trim = PhotoActivity.tj(editText).trim();
        String trim2 = PhotoActivity.tj(this.f45104j0).trim();
        ArrayList<String> oj5 = oj();
        ArrayList ln5 = ln();
        LbsDataV2.PoiInfo poiInfo = this.M0;
        boolean z16 = true;
        if (shuoshuoContent == null) {
            boolean z17 = !TextUtils.isEmpty(trim);
            if (!TextUtils.isEmpty(trim2)) {
                z17 = true;
            }
            if (oj5 != null && !oj5.isEmpty()) {
                z17 = true;
            }
            if (ln() == null || ln().size() <= 0) {
                z16 = z17;
            }
        } else {
            String titleTextDraft = shuoshuoContent.getTitleTextDraft();
            String textDraft = shuoshuoContent.getTextDraft();
            ArrayList arrayList = (ArrayList) shuoshuoContent.getSelectedImage();
            ArrayList<CommodityBean> commdityLists = shuoshuoContent.getCommdityLists();
            LbsDataV2.PoiInfo currentPoiInfo = shuoshuoContent.getCurrentPoiInfo();
            boolean z18 = (trim == titleTextDraft || trim.equals(titleTextDraft)) ? false : true;
            if (trim2 != textDraft && !trim2.equals(textDraft)) {
                z18 = true;
            }
            if ((oj5 != null || arrayList == null || arrayList.size() == 0) && (arrayList != null || oj5 == null || oj5.size() == 0)) {
                if (oj5 != null && arrayList != null) {
                    if (oj5.size() == arrayList.size()) {
                        for (int i3 = 0; i3 < oj5.size(); i3++) {
                            String str = oj5.get(i3);
                            String str2 = (String) arrayList.get(i3);
                            if (str == str2 || str.equals(str2)) {
                            }
                        }
                    }
                }
                if ((ln5 == null || commdityLists == null || commdityLists.size() == 0) && (commdityLists != null || ln5 == null || ln5.size() == 0)) {
                    if (ln5 != null && commdityLists != null) {
                        if (ln5.size() == commdityLists.size()) {
                            for (int i16 = 0; i16 < ln5.size(); i16++) {
                                if (((CommodityBean) ln5.get(i16)).mItemID == commdityLists.get(i16).mItemID) {
                                }
                            }
                        }
                    }
                    if (Wj() || ((poiInfo == null || currentPoiInfo != null) && ((poiInfo != null || currentPoiInfo == null) && (poiInfo == null || currentPoiInfo.poiName.equals(poiInfo.poiName))))) {
                        z16 = z18;
                    }
                }
                z18 = true;
                if (Wj()) {
                }
                z16 = z18;
            }
            z18 = true;
            if (ln5 == null) {
            }
            if (ln5 != null) {
                if (ln5.size() == commdityLists.size()) {
                }
                z18 = true;
                break;
            }
            if (Wj()) {
            }
            z16 = z18;
        }
        if (Wj()) {
            return z16;
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void kk() {
        this.I1 = new tq3.b(this);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void kl(ArrayList<String> arrayList) {
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            String[] split = ((String) arrayList2.get(i3)).split("\\<");
            if (split.length == 1) {
                arrayList3.add(split[0]);
            } else if (split.length == 3) {
                PicInfo picInfo = new PicInfo();
                picInfo.imageId = split[2];
                picInfo.sourceType = 1;
                arrayList3.add(split[1]);
            } else if (split.length == 5) {
                PicInfo picInfo2 = new PicInfo();
                picInfo2.pic_url = split[1];
                picInfo2.imageId = split[2];
                try {
                    picInfo2.picwidth = Integer.valueOf(split[3]).intValue();
                    picInfo2.picheight = Integer.valueOf(split[4]).intValue();
                } catch (Throwable th5) {
                    QZLog.e("[publish2]QQPublicAccountPublishFeedFragment", "failed to parse picInfo->picwidth/picheight.", th5);
                }
                picInfo2.sourceType = 2;
                arrayList3.add(picInfo2.pic_url);
            }
        }
        yl(arrayList3);
        zn();
    }

    public HashMap<String, ShuoshuoVideoInfo> kn() {
        HashMap<String, ShuoshuoVideoInfo> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.X.get(this.U.get(i3));
            if (shuoshuoVideoInfo == null) {
                shuoshuoVideoInfo = this.Z.get(this.U.get(i3));
            }
            if (shuoshuoVideoInfo != null) {
                hashMap.put(this.U.get(i3), shuoshuoVideoInfo);
            }
        }
        return hashMap;
    }

    public ArrayList ln() {
        CommodityListView commodityListView = this.M2;
        if (commodityListView != null) {
            return commodityListView.f();
        }
        return null;
    }

    protected void mn() {
        if (this.T.N() == null || this.U == null) {
            return;
        }
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            if (this.T.N() != null && this.T.N().containsKey(this.U.get(i3)) && this.T.N().get(this.U.get(i3)) != null) {
                String str = this.T.N().get(this.U.get(i3));
                this.U.remove(i3);
                this.U.add(str);
            }
        }
    }

    public void nn() {
        com.tencent.pubaccount.publish.state.a aVar = this.A2;
        if (aVar == null || !aVar.e()) {
            return;
        }
        ((tq3.a) hj(tq3.a.class)).J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean oi() {
        if (this.f45084c1 && !TextUtils.isEmpty(this.f45096g1)) {
            return super.oi();
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean ok() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void ol() {
        com.tencent.pubaccount.publish.state.a aVar = this.A2;
        if (aVar != null) {
            aVar.i();
        }
    }

    public String on() {
        if (this.f342287x2.c().equals(getString(R.string.f173026gk2)) || this.f342287x2.c().equals(getString(R.string.f173025gk1)) || this.f342287x2.c().equals(getString(R.string.gns))) {
            return null;
        }
        return this.f342287x2.c();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWindow().setSoftInputMode(3);
        if (getActivity() != null) {
            getActivity().setTheme(R.style.a6t);
        }
        Intent intent = getIntent();
        if (bundle != null) {
            dl(bundle);
        } else {
            xn(intent);
        }
        initUI();
        initData(intent);
        Zm(intent);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        com.tencent.pubaccount.publish.state.a aVar;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 6000 && (aVar = this.A2) != null) {
            aVar.l(false);
        }
        if (i3 == 23333333 && i16 != 0) {
            Uj(i3);
        } else if (i16 == 8215 && i3 == 6000) {
            Uj(i3);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.publish.ui.controller.a
    public void onBack() {
        VSReporter.p(LoginData.getInstance().getUinString(), "auth_pubish", "left_cancel", 0, 0, new String[0]);
        ck();
        this.A2.m();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f342287x2 || view == this.f342288y2) {
            sn(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
        if (this.P2 != null && getActivity() != null) {
            getActivity().unregisterReceiver(this.P2);
        }
        super.onDestroy();
        this.f342283t2 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.S1 = intent.getIntExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, 0);
        }
        Km();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ui();
        qi();
        cn();
        super.onResume();
        ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "page_expo", 0, 0, "", "", "", "");
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ik();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        Intent intent;
        super.onWindowFocusChanged(z16);
        if (z16 && (intent = getIntent()) != null && intent.getBooleanExtra("key_show_input_panel", false)) {
            intent.removeExtra("key_show_input_panel");
            ExtendEditText extendEditText = this.f45104j0;
            if (extendEditText != null) {
                extendEditText.setFocusable(true);
                this.f45104j0.requestFocus();
                this.f45104j0.setClearFocusOnBack(true);
                getHandler().postDelayed(new Runnable() { // from class: com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment.16
                    @Override // java.lang.Runnable
                    public void run() {
                        ExtendEditText extendEditText2 = QQPublicAccountPublishFeedFragment.this.f45104j0;
                        if (extendEditText2 != null) {
                            Editable text = extendEditText2.getText();
                            QQPublicAccountPublishFeedFragment.this.f45104j0.setSelection(text != null ? text.length() : 0);
                        }
                        QQPublicAccountPublishFeedFragment.this.showKeyboard();
                    }
                }, 300L);
            }
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void qi() {
        boolean z16;
        DynamicArrayList<String> dynamicArrayList = this.U;
        boolean z17 = false;
        if (dynamicArrayList != null) {
            z16 = dynamicArrayList.size() < dj();
            if (en()) {
                z16 = false;
            }
        } else {
            z16 = true;
        }
        e9.a aVar = this.T;
        if (aVar != null) {
            if (z16 && in()) {
                z17 = true;
            }
            aVar.o0(z17, true);
        }
    }

    public ShuoshuoVideoInfo qn() {
        return this.D2;
    }

    protected int rn() {
        Editable editableText;
        EditText editText = this.f342285v2;
        if (editText == null || (editableText = editText.getEditableText()) == null) {
            return 0;
        }
        return editableText.length();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            onResume();
        } else {
            onPause();
        }
    }

    protected void sn(View view) {
        ((tq3.a) hj(tq3.a.class)).C();
        ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "geography", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void tm() {
        ek();
        if (!Mk()) {
            Kl();
            return;
        }
        ActionSheet actionSheet = this.f45089e0;
        if (actionSheet == null || !actionSheet.isShowing()) {
            ActionSheet create = ActionSheet.create(getActivity());
            create.addButton(R.string.gnp, 1);
            DynamicArrayList<String> dynamicArrayList = this.U;
            if (dynamicArrayList == null || dynamicArrayList.size() < 1) {
                create.addButton(R.string.gnr, 1);
            }
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new b(create));
            create.show();
            this.f45089e0 = create;
        }
    }

    protected void tn(int i3) {
        if (this.f45139x0) {
            Mn(i3);
            this.f45139x0 = false;
        } else {
            hn(i3);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void ui() {
        String str;
        super.ui();
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || !(aVar instanceof com.tencent.pubaccount.publish.b)) {
            return;
        }
        com.tencent.pubaccount.publish.state.a aVar2 = this.A2;
        if (aVar2 instanceof UIStateNormal) {
            boolean jn5 = jn(((UIStateNormal) aVar2).r());
            com.tencent.pubaccount.publish.b bVar = (com.tencent.pubaccount.publish.b) this.C;
            int i3 = yn() ? 8 : 0;
            int i16 = R.string.vxg;
            if (!jn5 && Wj()) {
                i16 = R.string.vys;
            }
            String string = getString(i16);
            if (jn5) {
                str = TipsElementData.DEFAULT_COLOR;
            } else {
                str = "#03081A";
            }
            bVar.E(i3, string, Color.parseColor(str), jn5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean uk() {
        EditText editText = this.f342285v2;
        if (editText == null || !editText.hasFocus()) {
            return super.uk();
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean vk() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int wj() {
        return R.drawable.gd7;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int xj() {
        return R.drawable.gd_;
    }

    protected void xn(Intent intent) {
        this.A2 = com.tencent.pubaccount.publish.state.a.d(intent.getBooleanExtra("is_edit", false) ? 1 : 0, this);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int yj() {
        return R.drawable.gd9;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean yk() {
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int zj() {
        return R.drawable.gd8;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean zk() {
        return false;
    }

    public void zn() {
        String[] split;
        String j06 = u5.b.j0("peitu_entry_sourceid", "", LoginData.getInstance().getUin());
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(j06);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(str) && (split = optString.split("_")) != null && split.length == 2) {
                    hashMap.put(URLDecoder.decode(str, "UTF-8"), new Pair(split[0], split[1]));
                }
            }
        } catch (UnsupportedEncodingException e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, 1, e16, new Object[0]);
        } catch (JSONException e17) {
            QZLog.e(QZLog.TO_DEVICE_TAG, 1, e17, new Object[0]);
        }
        this.I2.clear();
        this.I2.putAll(hashMap);
    }

    /* loaded from: classes34.dex */
    public class AttachGoodsBroadcastReceiver extends BroadcastReceiver {
        public AttachGoodsBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("attach_goods");
                if (!TextUtils.equals(action, "action_attach_goods") || parcelableArrayListExtra == null || QQPublicAccountPublishFeedFragment.this.M2 == null) {
                    return;
                }
                if (parcelableArrayListExtra.size() != 0) {
                    QQPublicAccountPublishFeedFragment.this.Jn(true);
                    if (QQPublicAccountPublishFeedFragment.this.M2.getVisibility() == 8) {
                        QQPublicAccountPublishFeedFragment.this.M2.setVisibility(0);
                    }
                    QQPublicAccountPublishFeedFragment.this.M2.setData(parcelableArrayListExtra);
                    return;
                }
                QQPublicAccountPublishFeedFragment.this.M2.w();
                QQPublicAccountPublishFeedFragment.this.M2.setVisibility(8);
                QQPublicAccountPublishFeedFragment.this.Jn(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class m implements DynamicGridView.t {
        m() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.t
        public void onEditModeChanged(boolean z16) {
            if (!z16 || QQPublicAccountPublishFeedFragment.this.T.e0()) {
                return;
            }
            QQPublicAccountPublishFeedFragment.this.T.L(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class o implements CommodityListView.c {
        o() {
        }

        @Override // com.tencent.biz.subscribe.widget.commodity.CommodityListView.c
        public void a(int i3) {
            if (i3 == 0) {
                QQPublicAccountPublishFeedFragment.this.Jn(false);
            }
            QQPublicAccountPublishFeedFragment.this.ui();
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Cm(ArrayList<String> arrayList, ConcurrentHashMap<String, String> concurrentHashMap, String str) {
        this.f45121o2 = false;
        int i3 = this.f45084c1 ? 2 : 3;
        boolean z16 = !QZoneVideoCommonUtils.getTrimSupport().isAvailable();
        Activity realActivity = getRealActivity();
        int dj5 = dj() - 0;
        HashMap<String, PicInfo> hashMap = this.A0;
        return cl(realActivity, arrayList, dj5 + (hashMap != null ? hashMap.size() : 0), false, i3, z16, concurrentHashMap, false, false, str);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void El() {
        ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "clk_mobile", 0, 0, "", "", "", "");
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Gl() {
        ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "clk_screen", 0, 0, "", "", "", "");
    }

    public void an() {
        this.f342289z2 = false;
        finish();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void ik() {
        Ln(4);
    }

    protected void Hn() {
        String str;
        int i3;
        if (this.S2) {
            return;
        }
        if (this.f45084c1 && this.D2 == null) {
            QZLog.w("videomood", "sendMood mVideo == null");
            gm(true);
            return;
        }
        ek();
        this.S2 = true;
        Editable text = this.f342285v2.getText();
        String trim = text != null ? text.toString().trim() : null;
        String Vi = Vi();
        QZonePreUploadInfo qZonePreUploadInfo = new QZonePreUploadInfo();
        qZonePreUploadInfo.preUploadedPaths = null;
        qZonePreUploadInfo.preUploadingRequest = null;
        qZonePreUploadInfo.preUploadType = 0;
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("key_ext_param") : null;
        boolean z16 = !this.V0 && ((i3 = this.K0) == 1 || i3 == 3) && this.T0 == null;
        HashMap<String, String> hashMap = new HashMap<>();
        if (1 != getShowType()) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("is_feeds_long_pics_browsing_mode", str);
        Dn(hashMap);
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.D2;
        if (shuoshuoVideoInfo != null) {
            boolean z17 = this.C2;
            shuoshuoVideoInfo.mIsUploadOrigin = z17;
            shuoshuoVideoInfo.mNeedProcess = shuoshuoVideoInfo.mNeedProcess && !(z17 && shuoshuoVideoInfo.mDuration == shuoshuoVideoInfo.mTotalDuration);
        }
        this.f45121o2 = false;
        mn();
        Map<String, String> z18 = ((tq3.a) hj(tq3.a.class)).z();
        if (z18 == null) {
            z18 = new HashMap<>();
        }
        String postUin = LoginData.getInstance().getPostUin();
        if (TextUtils.isEmpty(postUin)) {
            postUin = LoginData.getInstance().getUinString();
            QZLog.e("[publish2]QQPublicAccountPublishFeedFragment", "error! send mood with not puin, use uin default!");
        }
        com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
        cVar.X = true;
        cVar.Y = postUin;
        cVar.f51932a = trim;
        cVar.f51934b = Vi;
        cVar.f51936c = oj();
        cVar.f51946h = this.D2;
        cVar.f51948j = z16 ? this.M0 : null;
        cVar.f51954p = z18;
        cVar.f51949k = false;
        cVar.f51953o = qZonePreUploadInfo;
        cVar.f51956r = this.D0;
        cVar.f51961w = stringExtra;
        cVar.f51962x = this.M0;
        cVar.f51964z = this.f45111l1;
        cVar.E = hashMap;
        CommodityListView commodityListView = this.M2;
        if (commodityListView != null && commodityListView.f() != null && this.M2.f().size() > 0) {
            ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "suc_goods", 0, 0, "", "", "", "");
            cVar.Z = this.M2.f();
        }
        In(cVar);
        if (this.U.size() > 0) {
            final ArrayList arrayList = new ArrayList(this.U);
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment.17
                @Override // java.lang.Runnable
                public void run() {
                    EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList.toArray());
                }
            });
        }
        this.f45120o1 = true;
        if (this.D2 != null) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_UPLOAD, "0", null);
        }
        this.f45103i2 = 0;
        Intent intent2 = new Intent();
        intent2.putExtra("finish_video_component", true);
        if (!TextUtils.isEmpty(Vi)) {
            intent2.putExtra("BULLET_CONTENT", Vi);
        }
        getActivity().setResult(-1, intent2);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            int i16 = this.G2;
            if (i16 == 1 || i16 == 2) {
                An();
            }
            an();
            return;
        }
        int i17 = this.G2;
        if (i17 == 1 || i17 == 2) {
            An();
        }
        an();
        this.A2.c();
        com.tencent.pubaccount.publish.state.a aVar = this.A2;
        if (aVar instanceof UIStateNormal) {
            ((UIStateNormal) aVar).u();
        }
        getActivity().sendBroadcast(new Intent(QZoneHelper.Constants.ACTION_SEND_MOOD_FINISH));
        En(oj());
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Zh(Intent intent) {
        if (intent != null) {
            intent.putExtra(PictureConst.KEY_NEED_BACK_ANIMATION, false);
            intent.putExtra(PictureConst.KEY_NEED_FACE_FUNTION, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean bl(Activity activity, ArrayList<String> arrayList, int i3, boolean z16, int i16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, Bundle bundle, String str) {
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putBoolean(PeakConstants.QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW, true);
        return super.bl(activity, arrayList, i3, z16, i16, z17, concurrentHashMap, bundle2, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class j implements TextWatcher {
        j() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null) {
                return;
            }
            QQPublicAccountPublishFeedFragment.this.f342285v2.removeTextChangedListener(this);
            QQPublicAccountPublishFeedFragment.this.ui();
            if (!QQPublicAccountPublishFeedFragment.this.K2) {
                QQPublicAccountPublishFeedFragment.this.K2 = true;
                ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "name", 0, 0, "", "", "", "");
            }
            int length = charSequence.length() - 30;
            if (length > 0) {
                ToastUtil.s(com.qzone.util.l.a(R.string.r1s) + length + com.qzone.util.l.a(R.string.r1r), 1);
            }
            QQPublicAccountPublishFeedFragment.this.f342285v2.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    public void Dn(Map<String, String> map) {
        if (map == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        if (oj() != null) {
            Iterator<String> it = oj().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.I2.containsKey(next)) {
                    Pair<String, String> pair = this.I2.get(next);
                    String str = (String) pair.first;
                    String str2 = (String) pair.second;
                    sb5.append(str);
                    sb5.append("_");
                    sb6.append(str2);
                    sb6.append("_");
                }
            }
        }
        int length = sb5.length();
        int length2 = sb6.length();
        if (length < 1 || length <= 1) {
            return;
        }
        sb5.delete(length - 1, length);
        sb6.delete(length2 - 1, length2);
        map.put("peitu_entrance", sb5.toString());
        map.put("peitu_source", sb6.toString());
        if (QZLog.isColorLevel()) {
            QZLog.d("[publish2]QQPublicAccountPublishFeedFragment", 2, "peitu_entrance:", sb5.toString(), ",peitu_source:", sb6.toString());
        }
    }

    protected void initData(Intent intent) {
        if (intent == null) {
            return;
        }
        this.F2 = new ShuoshuoContent();
        this.A2.h(intent);
        Dm();
        this.B2 = this.A2.g();
        this.A2.a();
        String stringExtra = intent.getStringExtra("postUin");
        this.O2 = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            LoginData.getInstance().setPostUin(this.O2);
        }
        this.G2 = intent.getIntExtra(GetAdInfoRequest.SOURCE_FROM, 0);
        this.H2 = intent.getBooleanExtra("shareAfterFinish", true);
    }

    protected void un() {
        this.f342284u2 = (RelativeLayout) $(R.id.hkh);
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.T3(R.string.gd5, this.Q2);
            this.C.P(R.string.d7o, this.T2, false);
            this.C.x().setTextSize(17.0f);
            this.C.u().setTextSize(17.0f);
        }
        com.qzone.common.activities.titlebuilder.a aVar2 = this.C;
        if (aVar2 instanceof com.tencent.pubaccount.publish.b) {
            ((com.tencent.pubaccount.publish.b) aVar2).E(yn() ? 8 : 0, getString(R.string.vxg), Color.parseColor("#03081A"), false);
            ((com.tencent.pubaccount.publish.b) this.C).f342318a0.setTextSize(17.0f);
            ((com.tencent.pubaccount.publish.b) this.C).f342318a0.setOnClickListener(new h());
        }
        EditText editText = (EditText) $(R.id.mai);
        this.f342285v2 = editText;
        editText.setOnTouchListener(new i());
        this.f342285v2.addTextChangedListener(new j());
        ExtendEditText extendEditText = (ExtendEditText) $(R.id.led);
        this.f45104j0 = extendEditText;
        extendEditText.setFixedHeight(true);
        ExtendScrollView extendScrollView = (ExtendScrollView) $(R.id.l57);
        this.M = extendScrollView;
        extendScrollView.b(R.id.mai);
        this.M.b(R.id.led);
        this.M.setOnDownListener(this.f45112l2);
        Yh();
        this.f45110l0 = (ImageView) $(R.id.ius);
        Sl();
        Ul();
    }

    protected void vn() {
        this.N = (ViewGroup) $(R.id.fpg);
        DynamicGridView dynamicGridView = (DynamicGridView) $(R.id.fpf);
        this.P = dynamicGridView;
        dynamicGridView.setNumColumns(3);
        this.P.setTranscriptMode(1);
        this.P.setStretchable(true);
        this.P.setOnItemClickListener(new k());
        e9.a gn5 = gn();
        this.T = gn5;
        gn5.x0(true);
        this.T.y0(new l());
        this.P.setAdapter((ListAdapter) this.T);
        this.P.setLetParentInterceptTouchEventAt23(false);
        this.P.setEditModeEnabled(true);
        this.P.setOnEditModeChangeListener(new m());
        if (this.f45134u1) {
            this.T.H0(0);
            this.f45134u1 = false;
        }
        this.P.setOnDragListener(new n());
        this.D0 = v5.a.a().d(ImageQualityPreference.TYPE_SHUOSHUO_ALL_PIC);
        this.B0 = $(R.id.f164258p8);
    }

    protected void wn() {
        this.f342287x2 = (MoodPicLabel) $(R.id.f0z);
        this.f342288y2 = (MoodPicLabel) this.f342286w2.findViewById(R.id.f166324f10);
        this.f342287x2.setOnClickListener(this);
        this.f342288y2.setOnClickListener(this);
        MoodPicLabel moodPicLabel = (MoodPicLabel) $(R.id.lw5);
        this.L2 = moodPicLabel;
        moodPicLabel.setOnClickListener(this);
        CommodityListView commodityListView = (CommodityListView) $(R.id.ldg);
        this.M2 = commodityListView;
        commodityListView.setPublishUI(true);
        if (getIntent() != null) {
            this.N2 = getIntent().getBooleanExtra("has_shop", false);
        }
        if (this.N2) {
            if (getActivity() != null) {
                this.P2 = new AttachGoodsBroadcastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_attach_goods");
                getActivity().registerReceiver(this.P2, intentFilter);
            }
            this.M2.setOnDataChangeListener(new o());
            ReportController.o(null, "dc00898", "", LoginData.getInstance().getUinString(), "auth_pubish", "exp_goods", 0, 0, "", "", "", "");
            this.L2.setVisibility(0);
            this.L2.setOnClickListener(new a());
        }
    }

    private void In(com.qzone.publish.ui.model.c cVar) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 >= this.U.size()) {
                break;
            }
            String str = this.U.get(i3);
            LocalMediaInfo Pn = Pn(this.Z.get(str));
            if (Pn == null) {
                Pn = this.W.get(str);
            }
            if (Pn != null) {
                arrayList.add(Pn);
                if (Pn.isRecord) {
                    i16++;
                    if (this.D2 == null) {
                        ShuoshuoVideoInfo y16 = ag.y(getActivity(), Pn._id, Pn.path, Pn.fileSize, Pn.mVideoType, Pn.thumbnailPath, Pn.mediaHeight, Pn.mediaWidth, Pn.mStartTime, Pn.mDuration, Pn.mTotalDuration, Pn.needProcess, Pn.bundle);
                        this.D2 = y16;
                        if (y16 != null) {
                            y16.mIsUploadOrigin = this.C2;
                            y16.fakeVid = Pn.fakeVid;
                        }
                    }
                } else if (QAlbumUtil.getMediaType(Pn) != 0 && QAlbumUtil.getMediaType(Pn) == 1) {
                    i16++;
                    boolean z16 = Bn(Pn.path, Pn.mediaWidth, Pn.mediaHeight) && !Pn.isMakeVideo;
                    Pn.needProcess = z16;
                    Pn.mIsUploadOrigin = !z16;
                    if (this.D2 == null) {
                        FragmentActivity activity = getActivity();
                        long j3 = Pn._id;
                        String str2 = Pn.path;
                        long j16 = Pn.fileSize;
                        String str3 = Pn.thumbnailPath;
                        int i17 = Pn.mediaHeight;
                        int i18 = Pn.mediaWidth;
                        long j17 = Pn.mDuration;
                        this.D2 = ag.y(activity, j3, str2, j16, 1, str3, i17, i18, 0L, j17, j17, false, null);
                    }
                }
            } else {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.path = this.U.get(i3);
                arrayList.add(localMediaInfo);
            }
            i3++;
        }
        boolean z17 = i16 >= 1;
        HashMap hashMap = new HashMap();
        HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = this.U1;
        if (hashMap2 != null) {
            for (String str4 : hashMap2.keySet()) {
                hashMap.put(str4, this.U1.get(str4).toByteArray());
            }
        }
        ConcurrentHashMap<String, float[]> concurrentHashMap = this.f45140x1;
        HashMap hashMap3 = (concurrentHashMap == null || concurrentHashMap.isEmpty()) ? null : new HashMap();
        cVar.f51940e = arrayList;
        cVar.G = hashMap3;
        cVar.B = this.f45132t1;
        cVar.a(this.U1);
        CommodityListView commodityListView = this.M2;
        if (commodityListView != null && commodityListView.f() != null) {
            cVar.Z = this.M2.f();
        }
        if (com.qzone.publish.ui.model.b.f51931e && z17) {
            QZoneWriteOperationService.v0().S1(getActivity(), cVar);
            QZLog.d("[upload2][uploadalbum]", 1, "publish MixVideoPicUpload" + cVar.toString());
            return;
        }
        QZoneWriteOperationService.v0().Q1(cVar);
        QZLog.d("[upload2][uploadalbum]", 1, "publish Nornmal" + cVar.toString());
    }

    protected LocalMediaInfo Pn(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.isRecord = true;
        localMediaInfo.path = shuoshuoVideoInfo.mVideoPath;
        localMediaInfo.thumbnailPath = shuoshuoVideoInfo.mCoverUrl;
        localMediaInfo.fileSize = shuoshuoVideoInfo.mSize;
        localMediaInfo.mVideoType = shuoshuoVideoInfo.mVideoType;
        localMediaInfo.mStartTime = shuoshuoVideoInfo.mStartTime;
        localMediaInfo.mTotalDuration = shuoshuoVideoInfo.mTotalDuration;
        localMediaInfo.mDuration = shuoshuoVideoInfo.mDuration;
        localMediaInfo.needProcess = shuoshuoVideoInfo.mNeedProcess;
        localMediaInfo.bundle = shuoshuoVideoInfo.mExtras;
        localMediaInfo.fakeVid = shuoshuoVideoInfo.fakeVid;
        localMediaInfo.mIsUploadOrigin = this.C2;
        int i3 = shuoshuoVideoInfo.mVideoHeight;
        localMediaInfo.mediaHeight = i3;
        int i16 = shuoshuoVideoInfo.mVideoWidth;
        localMediaInfo.mediaWidth = i16;
        localMediaInfo.thumbHeight = i3;
        localMediaInfo.thumbWidth = i16;
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f342295d;

        b(ActionSheet actionSheet) {
            this.f342295d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                QQPublicAccountPublishFeedFragment.this.Ml(0);
            } else if (i3 == 1) {
                QQPublicAccountPublishFeedFragment.this.Bm();
            }
            this.f342295d.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Oj(String str, int i3, int i16, long j3, long j16, long j17, boolean z16, Bundle bundle) {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Cl() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Dl() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ej() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Fl() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Pl() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void lm() {
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Bj(Boolean bool, String str, String str2, String str3) {
    }
}
