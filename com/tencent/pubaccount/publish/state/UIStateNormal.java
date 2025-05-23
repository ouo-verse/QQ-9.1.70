package com.tencent.pubaccount.publish.state;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneEffectPanel;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes34.dex */
public class UIStateNormal extends com.tencent.pubaccount.publish.state.a {

    /* renamed from: h, reason: collision with root package name */
    private String f342319h;

    /* renamed from: i, reason: collision with root package name */
    private String f342320i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<String> f342321j;

    /* renamed from: k, reason: collision with root package name */
    private final String f342322k;

    /* renamed from: l, reason: collision with root package name */
    private String f342323l;

    /* renamed from: m, reason: collision with root package name */
    private ShuoshuoContent f342324m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements SubscribeDraftManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShuoshuoContent f342328a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQPublicAccountPublishFeedFragment f342329b;

        a(ShuoshuoContent shuoshuoContent, QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
            this.f342328a = shuoshuoContent;
            this.f342329b = qQPublicAccountPublishFeedFragment;
        }

        @Override // com.tencent.biz.subscribe.utils.SubscribeDraftManager.c
        public void a(int i3, boolean z16, String str, Object... objArr) {
            UIStateNormal.this.t(z16, str, this.f342328a, this.f342329b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c implements ActionSheet.OnButtonClickListener {
        c() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            UIStateNormal uIStateNormal;
            ActionSheet actionSheet;
            QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = UIStateNormal.this.f342335a.get();
            if (qQPublicAccountPublishFeedFragment == null || (actionSheet = (uIStateNormal = UIStateNormal.this).f342341g) == null) {
                return;
            }
            if (!uIStateNormal.f342337c) {
                if (i3 == 2) {
                    actionSheet.superDismiss();
                    return;
                } else {
                    qQPublicAccountPublishFeedFragment.f342289z2 = false;
                    qQPublicAccountPublishFeedFragment.finish();
                    return;
                }
            }
            if (i3 == 0) {
                uIStateNormal.c();
                qQPublicAccountPublishFeedFragment.f342289z2 = false;
                Intent intent = new Intent();
                intent.putExtra("finish_video_component", true);
                qQPublicAccountPublishFeedFragment.getActivity().setResult(-1, intent);
                qQPublicAccountPublishFeedFragment.finish();
                VSReporter.p(String.valueOf(UIStateNormal.this.f342340f), "auth_pubish", "unsave", 0, 0, new String[0]);
            } else if (i3 == 1) {
                if (qQPublicAccountPublishFeedFragment.Wj()) {
                    UIStateNormal.this.k();
                    VSReporter.p(String.valueOf(UIStateNormal.this.f342340f), "auth_pubish", "save", 0, 0, new String[0]);
                    qQPublicAccountPublishFeedFragment.f342289z2 = false;
                    qQPublicAccountPublishFeedFragment.finish();
                } else {
                    QQToast.makeText(qQPublicAccountPublishFeedFragment.getActivity(), R.string.vyq, 1).show();
                }
            }
            if (qQPublicAccountPublishFeedFragment.G2 == 1) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qQPublicAccountPublishFeedFragment.getActivity(), QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA, QzoneConfig.DEFAULT_PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA), 2016, null, null);
            }
            UIStateNormal.this.f342341g.superDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements SubscribeDraftManager.c {
        d() {
        }

        @Override // com.tencent.biz.subscribe.utils.SubscribeDraftManager.c
        public void a(int i3, boolean z16, String str, Object... objArr) {
            if (z16) {
                QIPCClientHelper.getInstance().callServer(SimpleEventBus.IPC_SERVICE_MODULE_NAME, SimpleEventBus.ACTION_DRAFT_SYSTEM_CHANGE, null, null);
                QLog.d("[publish2]PublishMoodStateNormal", 4, "delete draft success");
            } else {
                QLog.d("[publish2]PublishMoodStateNormal", 4, "delete draft failed after push");
            }
        }
    }

    public UIStateNormal(QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        super(qQPublicAccountPublishFeedFragment);
        this.f342319h = "";
        this.f342320i = "";
        this.f342322k = "[publish2]PublishMoodStateNormal";
    }

    private String s(Editable editable) {
        if (editable == null || !(editable instanceof QQTextBuilder)) {
            return "";
        }
        return QzoneEmotionUtils.splash2Emo(((QQTextBuilder) editable).toPlainText().replaceAll(HardCodeUtil.qqStr(R.string.f172111ng0), HardCodeUtil.qqStr(R.string.f172113ng2)).replaceAll(HardCodeUtil.qqStr(R.string.nfz), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2192465w), "/chigua"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z16, String str, ShuoshuoContent shuoshuoContent, final QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putString("draftId", str);
            bundle.putBoolean("save_draft", true);
            QIPCClientHelper.getInstance().callServer(SimpleEventBus.IPC_SERVICE_MODULE_NAME, SimpleEventBus.ACTION_DRAFT_SYSTEM_CHANGE, bundle, null);
            QQToast.makeText(BaseApplication.context, R.string.vyt, 1).show();
            x(shuoshuoContent);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.pubaccount.publish.state.UIStateNormal.2
                @Override // java.lang.Runnable
                public void run() {
                    qQPublicAccountPublishFeedFragment.ui();
                    QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment2 = qQPublicAccountPublishFeedFragment;
                    qQPublicAccountPublishFeedFragment2.f342289z2 = false;
                    qQPublicAccountPublishFeedFragment2.finish();
                }
            });
            QLog.d("[publish2]PublishMoodStateNormal", 4, "draft save or modify failed");
            return;
        }
        QQToast.makeText(BaseApplication.context, R.string.vyr, 0).show();
        QLog.d("[publish2]PublishMoodStateNormal", 4, "draft save or modify failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final ShuoshuoContent shuoshuoContent, final QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.pubaccount.publish.state.UIStateNormal.4
            @Override // java.lang.Runnable
            public void run() {
                QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment2 = qQPublicAccountPublishFeedFragment;
                if (qQPublicAccountPublishFeedFragment2 == null || qQPublicAccountPublishFeedFragment2.isFinishing()) {
                    return;
                }
                UIStateNormal.this.x(shuoshuoContent);
                ArrayList<String> arrayList = (ArrayList) shuoshuoContent.getSelectedImage();
                if (arrayList != null) {
                    qQPublicAccountPublishFeedFragment.dm(arrayList);
                }
                HashMap<String, PicInfo> selectedQzonePhotos = shuoshuoContent.getSelectedQzonePhotos();
                if (selectedQzonePhotos != null && selectedQzonePhotos.size() > 0) {
                    qQPublicAccountPublishFeedFragment.em(selectedQzonePhotos);
                }
                HashMap<String, LocalMediaInfo> selectedMeidaInfo = shuoshuoContent.getSelectedMeidaInfo();
                if (selectedMeidaInfo != null && selectedMeidaInfo.size() > 0) {
                    qQPublicAccountPublishFeedFragment.Al(selectedMeidaInfo);
                }
                HashMap<String, ShuoshuoVideoInfo> recordedVideoInfoMap = shuoshuoContent.getRecordedVideoInfoMap();
                if (recordedVideoInfoMap != null && recordedVideoInfoMap.size() > 0) {
                    qQPublicAccountPublishFeedFragment.xl(recordedVideoInfoMap);
                }
                HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap = shuoshuoContent.getSelectedVideoInfoMap();
                if (selectedVideoInfoMap != null && selectedVideoInfoMap.size() > 0) {
                    qQPublicAccountPublishFeedFragment.Bl(selectedVideoInfoMap);
                }
                HashMap<String, Boolean> hashMap = shuoshuoContent.getmMarkHasCheckFacesMap();
                if (hashMap != null) {
                    qQPublicAccountPublishFeedFragment.V1 = hashMap;
                }
                HashMap<String, ArrayList<FaceData>> hashMap2 = shuoshuoContent.getmMarksFaceDataMap();
                if (hashMap2 != null) {
                    qQPublicAccountPublishFeedFragment.X1 = hashMap2;
                }
                HashMap<String, MarkUinInfoBeforeUpload> hashMap3 = shuoshuoContent.getmMarksUploadMap();
                if (hashMap3 != null) {
                    qQPublicAccountPublishFeedFragment.U1 = hashMap3;
                }
                HashMap<String, Boolean> hashMap4 = shuoshuoContent.getmMarkNeedShowFaceIconMap();
                if (hashMap4 != null) {
                    qQPublicAccountPublishFeedFragment.W1 = hashMap4;
                }
                qQPublicAccountPublishFeedFragment.f342285v2.setText(shuoshuoContent.getTitleTextDraft());
                qQPublicAccountPublishFeedFragment.f45104j0.setText(shuoshuoContent.getTextDraft());
                if (shuoshuoContent.getCommdityLists() != null) {
                    qQPublicAccountPublishFeedFragment.Qn(new ArrayList(shuoshuoContent.getCommdityLists()));
                }
                if (shuoshuoContent.getCurrentPoiInfo() != null) {
                    qQPublicAccountPublishFeedFragment.Rn(shuoshuoContent.getCurrentPoiInfo());
                }
                qQPublicAccountPublishFeedFragment.Dm();
                qQPublicAccountPublishFeedFragment.qi();
            }
        });
    }

    private void w(ShuoshuoContent shuoshuoContent, QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
        SubscribeDraftBean subscribeDraftBean = new SubscribeDraftBean();
        subscribeDraftBean.setTitle(shuoshuoContent.getTitleTextDraft());
        subscribeDraftBean.setDescirbe(shuoshuoContent.getTextDraft());
        subscribeDraftBean.setDescribeSource(shuoshuoContent.getTextDraftSource());
        String str = (shuoshuoContent.getSelectedImage() == null || shuoshuoContent.getSelectedImage().size() <= 0) ? "" : shuoshuoContent.getSelectedImage().get(0);
        if (qQPublicAccountPublishFeedFragment.Zj()) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = (TextUtils.isEmpty(str) || shuoshuoContent.getSelectedVideoInfoMap() == null || shuoshuoContent.getSelectedMeidaInfo().size() <= 0) ? null : shuoshuoContent.getSelectedVideoInfoMap().get(str);
            if (TextUtils.isEmpty(shuoshuoVideoInfo != null ? shuoshuoVideoInfo.mCoverUrl : "") && shuoshuoContent.getRecordedVideoInfoMap() != null && shuoshuoContent.getRecordedVideoInfoMap().size() > 0) {
                shuoshuoVideoInfo = shuoshuoContent.getRecordedVideoInfoMap().get(str);
            }
            if (shuoshuoVideoInfo != null) {
                subscribeDraftBean.setCoverUrl(shuoshuoVideoInfo.mCoverUrl);
                subscribeDraftBean.setWidth(shuoshuoVideoInfo.mVideoWidth);
                subscribeDraftBean.setHeight(shuoshuoVideoInfo.mVideoHeight);
                subscribeDraftBean.setDuration(shuoshuoVideoInfo.mDuration);
                QLog.d("draftBean", 4, "video cover:" + subscribeDraftBean.getCoverUrl() + " width:" + subscribeDraftBean.getWidth() + " height:" + subscribeDraftBean.getHeight());
            }
            subscribeDraftBean.setDrafTtype(SubscribeDraftBean.TYPE_VIDEO);
        } else {
            subscribeDraftBean.setCoverUrl(str);
            if (!TextUtils.isEmpty(str)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                SafeBitmapFactory.decodeFile(str, options);
                int rotateDegree = BaseImageUtil.getRotateDegree(str);
                if (rotateDegree != 90 && rotateDegree != 270) {
                    subscribeDraftBean.setWidth(options.outWidth);
                    subscribeDraftBean.setHeight(options.outHeight);
                } else {
                    subscribeDraftBean.setWidth(options.outHeight);
                    subscribeDraftBean.setHeight(options.outWidth);
                }
                QLog.d("draftBean", 4, "img cover:" + subscribeDraftBean.getCoverUrl() + " width:" + subscribeDraftBean.getWidth() + " height:" + subscribeDraftBean.getHeight() + ": degree" + rotateDegree);
            }
            subscribeDraftBean.setDrafTtype(SubscribeDraftBean.TYPE_IMAGES);
        }
        String valueOf = TextUtils.isEmpty(this.f342323l) ? String.valueOf(System.currentTimeMillis()) : this.f342323l;
        this.f342323l = valueOf;
        subscribeDraftBean.setDraftId(Long.valueOf(valueOf).longValue());
        SubscribeDraftManager.f().l(com.tencent.pubaccount.publish.state.a.f(qQPublicAccountPublishFeedFragment.getRealActivity()), String.valueOf(this.f342340f), this.f342323l, shuoshuoContent.toJsonString(), com.tencent.biz.pubaccount.util.d.b().c(subscribeDraftBean), new a(shuoshuoContent, qQPublicAccountPublishFeedFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(ShuoshuoContent shuoshuoContent) {
        this.f342324m = shuoshuoContent;
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void a() {
        ExtendEditText extendEditText;
        ExtendEditText extendEditText2;
        super.a();
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f342319h) && (extendEditText2 = qQPublicAccountPublishFeedFragment.f45104j0) != null) {
            extendEditText2.setText(this.f342319h);
            LocalMultiProcConfig.putString(LocalMultiProcConfig.PREFS_NAME_QZ_VIDEO_SETTING, QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "");
        }
        if (!TextUtils.isEmpty(this.f342320i) && (extendEditText = qQPublicAccountPublishFeedFragment.f45104j0) != null) {
            extendEditText.setText(this.f342320i);
        }
        if (this.f342339e) {
            qQPublicAccountPublishFeedFragment.Ql(true);
            qQPublicAccountPublishFeedFragment.fl();
        }
        int i3 = qQPublicAccountPublishFeedFragment.F0;
        if (i3 == 1) {
            qQPublicAccountPublishFeedFragment.Ql(true);
            qQPublicAccountPublishFeedFragment.Kl();
        } else if (i3 == 12) {
            qQPublicAccountPublishFeedFragment.Ql(true);
            qQPublicAccountPublishFeedFragment.Ll(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID);
        }
        qQPublicAccountPublishFeedFragment.nn();
        qQPublicAccountPublishFeedFragment.Dm();
        qQPublicAccountPublishFeedFragment.ui();
        qQPublicAccountPublishFeedFragment.qi();
    }

    @Override // com.tencent.pubaccount.publish.state.a
    @Deprecated
    public void c() {
        super.c();
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public boolean e() {
        return TextUtils.isEmpty(this.f342323l);
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void h(Intent intent) {
        super.h(intent);
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null || intent == null) {
            return;
        }
        this.f342319h = intent.getStringExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT);
        this.f342320i = intent.getStringExtra("summary");
        this.f342323l = intent.getStringExtra("subscribeDraftID");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("images");
        this.f342321j = stringArrayListExtra;
        if (stringArrayListExtra != null) {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!qQPublicAccountPublishFeedFragment.oj().contains(next)) {
                    qQPublicAccountPublishFeedFragment.fi(next);
                    qQPublicAccountPublishFeedFragment.gi(next);
                }
            }
            qQPublicAccountPublishFeedFragment.am();
        }
        qQPublicAccountPublishFeedFragment.f45111l1 = intent.getIntExtra(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE, 23);
        qQPublicAccountPublishFeedFragment.G = true;
        qQPublicAccountPublishFeedFragment.setTitle("");
        if (!this.f342337c || qQPublicAccountPublishFeedFragment.pk() || this.f342339e) {
            return;
        }
        j();
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void j() {
        super.j();
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (qQPublicAccountPublishFeedFragment.oj() == null || qQPublicAccountPublishFeedFragment.oj().size() == 0) {
            qQPublicAccountPublishFeedFragment.dm((ArrayList) u5.b.W("_qq_public_account_publish", uin));
        }
        if (TextUtils.isEmpty(this.f342323l)) {
            return;
        }
        SubscribeDraftManager.f().k(String.valueOf(uin), this.f342323l, new b(qQPublicAccountPublishFeedFragment));
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void k() {
        QZoneEffectPanel qZoneEffectPanel;
        QZoneSuperFontPanel qZoneSuperFontPanel;
        QZoneFontPanel qZoneFontPanel;
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null || !qQPublicAccountPublishFeedFragment.isAdded()) {
            return;
        }
        qQPublicAccountPublishFeedFragment.Fn();
        ShuoshuoContent shuoshuoContent = new ShuoshuoContent();
        if (!TextUtils.isEmpty(qQPublicAccountPublishFeedFragment.on())) {
            shuoshuoContent.setCurrentPoiInfo(qQPublicAccountPublishFeedFragment.M0);
        }
        shuoshuoContent.setmMarkHasCheckFacesMap(qQPublicAccountPublishFeedFragment.V1);
        shuoshuoContent.setmMarksFaceDataMap(qQPublicAccountPublishFeedFragment.X1);
        shuoshuoContent.setmMarksUploadMap(qQPublicAccountPublishFeedFragment.U1);
        shuoshuoContent.setmMarkNeedShowFaceIconMap(qQPublicAccountPublishFeedFragment.W1);
        shuoshuoContent.setShowType(qQPublicAccountPublishFeedFragment.getShowType());
        if (qQPublicAccountPublishFeedFragment.f342287x2 != null) {
            shuoshuoContent.setImageShootInfoLbs(qQPublicAccountPublishFeedFragment.on());
        }
        QZoneFontTabView qZoneFontTabView = qQPublicAccountPublishFeedFragment.f45098h0;
        if (qZoneFontTabView != null && (qZoneFontPanel = qZoneFontTabView.f45368i) != null) {
            qZoneFontPanel.g0();
        }
        QZoneFontTabView qZoneFontTabView2 = qQPublicAccountPublishFeedFragment.f45098h0;
        if (qZoneFontTabView2 != null && (qZoneSuperFontPanel = qZoneFontTabView2.f45369m) != null) {
            qZoneSuperFontPanel.X();
        }
        QZoneFontTabView qZoneFontTabView3 = qQPublicAccountPublishFeedFragment.f45098h0;
        if (qZoneFontTabView3 != null && (qZoneEffectPanel = qZoneFontTabView3.C) != null) {
            qZoneEffectPanel.s();
        }
        shuoshuoContent.setmCurrentShootPoiInfo(qQPublicAccountPublishFeedFragment.L0);
        if (qQPublicAccountPublishFeedFragment.oj() != null && qQPublicAccountPublishFeedFragment.oj().size() > 0) {
            shuoshuoContent.setSelectedImage(new ArrayList(qQPublicAccountPublishFeedFragment.oj()));
        }
        shuoshuoContent.setVideoInfo(qQPublicAccountPublishFeedFragment.qn());
        shuoshuoContent.setRecordedVideoInfoMap(qQPublicAccountPublishFeedFragment.nj());
        shuoshuoContent.setSelectedQzonePhotos(qQPublicAccountPublishFeedFragment.rj());
        shuoshuoContent.setSelectedMeidaInfo(qQPublicAccountPublishFeedFragment.pj());
        shuoshuoContent.setSelectedVideoInfoMap(qQPublicAccountPublishFeedFragment.sj());
        if (qQPublicAccountPublishFeedFragment.ln() != null) {
            shuoshuoContent.setCommdityLists(new ArrayList(qQPublicAccountPublishFeedFragment.ln()));
        }
        EditText editText = qQPublicAccountPublishFeedFragment.f342285v2;
        if (editText != null) {
            shuoshuoContent.setTitleTextDraft(editText.getText().toString());
        }
        ExtendEditText extendEditText = qQPublicAccountPublishFeedFragment.f45104j0;
        if (extendEditText != null) {
            shuoshuoContent.setTextDraft(extendEditText.getText().toString());
            shuoshuoContent.setTextDraftSource(s(qQPublicAccountPublishFeedFragment.f45104j0.getText()));
        }
        w(shuoshuoContent, qQPublicAccountPublishFeedFragment);
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void m() {
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        qQPublicAccountPublishFeedFragment.getActivity().setResult(0);
        if (r() != null) {
            if (qQPublicAccountPublishFeedFragment.Wj() && !qQPublicAccountPublishFeedFragment.jn(r())) {
                qQPublicAccountPublishFeedFragment.an();
                return;
            } else {
                q();
                return;
            }
        }
        if (qQPublicAccountPublishFeedFragment.Wj()) {
            q();
        } else {
            qQPublicAccountPublishFeedFragment.an();
        }
    }

    public void q() {
        QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment = this.f342335a.get();
        if (qQPublicAccountPublishFeedFragment == null) {
            return;
        }
        ActionSheet actionSheet = this.f342341g;
        if (actionSheet == null || !actionSheet.isShowing()) {
            ActionSheet create = ActionSheet.create(qQPublicAccountPublishFeedFragment.getActivity());
            this.f342341g = create;
            if (!this.f342337c) {
                if (!qQPublicAccountPublishFeedFragment.Wj()) {
                    qQPublicAccountPublishFeedFragment.finish();
                    return;
                }
                this.f342341g.addButton(R.string.gd6, 3);
            } else {
                create.setMainTitle(R.string.glm);
                this.f342341g.addButton(R.string.glf, 3);
                this.f342341g.addButton(R.string.vxg, 1);
            }
            this.f342341g.addCancelButton(R.string.cancel);
            this.f342341g.setOnButtonClickListener(new c());
            this.f342341g.show();
        }
    }

    public synchronized ShuoshuoContent r() {
        return this.f342324m;
    }

    public void u() {
        if (TextUtils.isEmpty(this.f342323l)) {
            return;
        }
        SubscribeDraftManager.f().e(String.valueOf(this.f342340f), this.f342323l, new d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements SubscribeDraftManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQPublicAccountPublishFeedFragment f342331a;

        b(QQPublicAccountPublishFeedFragment qQPublicAccountPublishFeedFragment) {
            this.f342331a = qQPublicAccountPublishFeedFragment;
        }

        @Override // com.tencent.biz.subscribe.utils.SubscribeDraftManager.c
        public void a(int i3, boolean z16, String str, Object... objArr) {
            ShuoshuoContent shuoshuoContent;
            if (!z16 || objArr == null || objArr.length <= 0) {
                return;
            }
            Object obj = objArr[0];
            if (!(obj instanceof String) || (shuoshuoContent = ShuoshuoContent.toShuoshuoContent((String) obj)) == null) {
                return;
            }
            UIStateNormal.this.v(shuoshuoContent, this.f342331a);
        }
    }

    @Override // com.tencent.pubaccount.publish.state.a
    public void i() {
    }
}
