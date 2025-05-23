package com.qzone.publish.ui.state;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneEffectPanel;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.common.event.EventCenter;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.activity.QZonePublishMoodActivity;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.publish.ui.publishmodule.LBSModule;
import com.qzone.reborn.part.publish.mood.sync.o;
import com.qzone.reborn.util.l;
import com.qzone.util.P2VUtil;
import com.qzone.widget.ExtendEditText;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends com.qzone.publish.ui.state.a {

    /* renamed from: j, reason: collision with root package name */
    private String f52070j;

    /* renamed from: k, reason: collision with root package name */
    private String f52071k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<String> f52072l;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<ResultRecord> f52073m;

    /* renamed from: n, reason: collision with root package name */
    private final String f52074n;

    /* renamed from: o, reason: collision with root package name */
    private SharedPreferences f52075o;

    /* renamed from: p, reason: collision with root package name */
    final Pattern f52076p;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            c cVar;
            ActionSheet actionSheet;
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = c.this.f52057a.get();
            if (qZonePublishMoodBaseActivity == null || (actionSheet = (cVar = c.this).f52063g) == null) {
                return;
            }
            if (!cVar.f52059c) {
                if (i3 == 2) {
                    actionSheet.superDismiss();
                    return;
                } else {
                    qZonePublishMoodBaseActivity.U2 = false;
                    qZonePublishMoodBaseActivity.finish();
                    return;
                }
            }
            if (i3 == 0) {
                cVar.o();
                qZonePublishMoodBaseActivity.on();
                qZonePublishMoodBaseActivity.U2 = false;
                qZonePublishMoodBaseActivity.finish();
            } else if (i3 == 1) {
                cVar.d();
                qZonePublishMoodBaseActivity.nn();
                qZonePublishMoodBaseActivity.U2 = false;
                Intent intent = new Intent();
                intent.putExtra("finish_video_component", true);
                intent.putExtra("PUBLISH_RESULT_CODE", 2);
                qZonePublishMoodBaseActivity.getActivity().setResult(-1, intent);
                qZonePublishMoodBaseActivity.finish();
            }
            qZonePublishMoodBaseActivity.mn(true);
            qZonePublishMoodBaseActivity.pn(true);
            c.this.f52063g.superDismiss();
        }
    }

    public c(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        super(qZonePublishMoodBaseActivity);
        this.f52070j = "";
        this.f52071k = "";
        this.f52074n = "PublishMoodStateNormal";
        this.f52076p = Pattern.compile("@\\{uin:(\\d+),nick:(.+?)\\}");
    }

    private void s() {
        long g16 = g();
        if (this.f52075o == null) {
            this.f52075o = PreferenceManager.getCachePreference(BaseApplication.getContext(), g16);
        }
        SharedPreferences sharedPreferences = this.f52075o;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(g16 + "SP_SHUOSHUO_PIC_KEY");
            edit.remove(g16 + "SP_SHUOSHUO_REPORT_PIC_KEY");
            edit.commit();
        }
        QZLog.i("PublishMoodStateNormal", " deleteShuoshuoPicUrlAndReport ");
    }

    private ShuoshuoContent t(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        QZoneEffectPanel qZoneEffectPanel;
        QZoneSuperFontPanel qZoneSuperFontPanel;
        QZoneFontPanel qZoneFontPanel;
        ShuoshuoContent shuoshuoContent = new ShuoshuoContent();
        shuoshuoContent.setClientKey(qZonePublishMoodBaseActivity.f51459f6);
        shuoshuoContent.setEventTag(qZonePublishMoodBaseActivity.O1.O1().getValue());
        shuoshuoContent.setAtFriends(qZonePublishMoodBaseActivity.f45141y0);
        shuoshuoContent.setCurrentPoiInfo(qZonePublishMoodBaseActivity.M0);
        shuoshuoContent.setFinalPoiInfo(((LBSModule) qZonePublishMoodBaseActivity.hj(LBSModule.class)).y());
        shuoshuoContent.setEggsUrlMap(qZonePublishMoodBaseActivity.Vm());
        shuoshuoContent.setmMarkHasCheckFacesMap(qZonePublishMoodBaseActivity.V1);
        shuoshuoContent.setmMarksFaceDataMap(qZonePublishMoodBaseActivity.X1);
        shuoshuoContent.setmMarksUploadMap(qZonePublishMoodBaseActivity.U1);
        shuoshuoContent.setmMarkNeedShowFaceIconMap(qZonePublishMoodBaseActivity.W1);
        shuoshuoContent.setShowType(qZonePublishMoodBaseActivity.getShowType());
        if (qZonePublishMoodBaseActivity.f51472o5 != null) {
            shuoshuoContent.setImageShootInfoLbs(qZonePublishMoodBaseActivity.Xm());
        }
        QZoneFontTabView qZoneFontTabView = qZonePublishMoodBaseActivity.f45098h0;
        if (qZoneFontTabView != null && (qZoneFontPanel = qZoneFontTabView.f45368i) != null) {
            qZoneFontPanel.g0();
        }
        QZoneFontTabView qZoneFontTabView2 = qZonePublishMoodBaseActivity.f45098h0;
        if (qZoneFontTabView2 != null && (qZoneSuperFontPanel = qZoneFontTabView2.f45369m) != null) {
            qZoneSuperFontPanel.X();
        }
        QZoneFontTabView qZoneFontTabView3 = qZonePublishMoodBaseActivity.f45098h0;
        if (qZoneFontTabView3 != null && (qZoneEffectPanel = qZoneFontTabView3.C) != null) {
            qZoneEffectPanel.s();
        }
        int U1 = qZonePublishMoodBaseActivity.O1.U1();
        ArrayList<String> value = qZonePublishMoodBaseActivity.O1.W1().getValue();
        shuoshuoContent.setmPriv(U1);
        shuoshuoContent.setmPrivUinList(value);
        shuoshuoContent.setmCurrentShootPoiInfo(qZonePublishMoodBaseActivity.L0);
        shuoshuoContent.setSelectedImage(new ArrayList(qZonePublishMoodBaseActivity.oj()));
        shuoshuoContent.setVideoInfo(qZonePublishMoodBaseActivity.Ym());
        shuoshuoContent.setRecordedVideoInfoMap(qZonePublishMoodBaseActivity.nj());
        shuoshuoContent.setSelectedQzonePhotos(qZonePublishMoodBaseActivity.rj());
        shuoshuoContent.setSelectedMeidaInfo(qZonePublishMoodBaseActivity.pj());
        shuoshuoContent.setSelectedVideoInfoMap(qZonePublishMoodBaseActivity.sj());
        o vj5 = qZonePublishMoodBaseActivity.vj();
        Boolean value2 = vj5.T1().getValue();
        if (value2 != null) {
            shuoshuoContent.setSyncQQ(value2.booleanValue());
        }
        Boolean value3 = vj5.U1().getValue();
        if (value3 != null) {
            shuoshuoContent.setSyncWechat(value3.booleanValue());
        }
        CheckBox checkBox = qZonePublishMoodBaseActivity.J2;
        if (checkBox != null) {
            shuoshuoContent.setSynBitWezone(checkBox.isChecked());
        }
        ExtendEditText extendEditText = qZonePublishMoodBaseActivity.f45104j0;
        if (extendEditText != null) {
            shuoshuoContent.setTextDraft(extendEditText.getText().toString());
            shuoshuoContent.setTextDraftSource(qZonePublishMoodBaseActivity.Vi());
        }
        Long value4 = qZonePublishMoodBaseActivity.O1.Z1().getValue();
        if (value4 != null) {
            shuoshuoContent.setTimer(value4.longValue());
        }
        Boolean value5 = qZonePublishMoodBaseActivity.O1.Q1().getValue();
        if (value5 != null) {
            shuoshuoContent.setLongPicModeOpen(value5);
        }
        return shuoshuoContent;
    }

    private String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList<ResultRecord> arrayList = new ArrayList<>(2);
        Matcher matcher = this.f52076p.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        matcher.reset();
        while (matcher.find()) {
            if (QZLog.isDevelopLevel()) {
                QZLog.i("PublishMoodStateNormal", 4, "match:" + matcher.group() + " uin=" + matcher.group(1) + " nick=" + matcher.group(2));
            }
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uin = matcher.group(1);
            resultRecord.name = matcher.group(2);
            arrayList.add(resultRecord);
            matcher.appendReplacement(stringBuffer, "@" + resultRecord.name);
        }
        this.f52057a.get().il(arrayList);
        return matcher.appendTail(stringBuffer).toString();
    }

    private void w() {
        ShuoshuoContent f16;
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || (f16 = un.c.e().f()) == null) {
            return;
        }
        qZonePublishMoodBaseActivity.f45104j0.setText(f16.getTextDraft());
        qZonePublishMoodBaseActivity.f45103i2 = 0;
        List<Friend> atFriends = f16.getAtFriends();
        qZonePublishMoodBaseActivity.f45141y0 = atFriends;
        if (atFriends != null) {
            int size = atFriends.size();
            for (int i3 = 0; i3 < size; i3++) {
                Friend friend = qZonePublishMoodBaseActivity.f45141y0.get(i3);
                if (friend != null) {
                    qZonePublishMoodBaseActivity.f45103i2 = Math.max(qZonePublishMoodBaseActivity.f45103i2, ("@" + friend.mName).length());
                }
            }
        }
        qZonePublishMoodBaseActivity.En(f16.getTimer());
        qZonePublishMoodBaseActivity.k3 = f16.getmPriv();
        List<String> list = f16.getmPrivUinList();
        if (list != null && !list.isEmpty()) {
            qZonePublishMoodBaseActivity.l3 = new ArrayList<>(list);
        }
        qZonePublishMoodBaseActivity.Dn();
        qZonePublishMoodBaseActivity.dm(new ArrayList<>(f16.getSelectedImage()));
        ShuoshuoVideoInfo videoInfo = f16.getVideoInfo();
        if (videoInfo != null && !this.f52060d) {
            qZonePublishMoodBaseActivity.km(videoInfo.mVideoPath);
            qZonePublishMoodBaseActivity.un(videoInfo);
            qZonePublishMoodBaseActivity.f45114m1 = true;
            qZonePublishMoodBaseActivity.Gn(true);
        }
        HashMap<String, PicInfo> selectedQzonePhotos = f16.getSelectedQzonePhotos();
        if (selectedQzonePhotos != null && selectedQzonePhotos.size() > 0) {
            qZonePublishMoodBaseActivity.em(selectedQzonePhotos);
        }
        HashMap<String, LocalMediaInfo> selectedMeidaInfo = f16.getSelectedMeidaInfo();
        if (selectedMeidaInfo != null && selectedMeidaInfo.size() > 0) {
            qZonePublishMoodBaseActivity.Al(selectedMeidaInfo);
        }
        HashMap<String, ShuoshuoVideoInfo> recordedVideoInfoMap = f16.getRecordedVideoInfoMap();
        if (recordedVideoInfoMap != null && recordedVideoInfoMap.size() > 0) {
            qZonePublishMoodBaseActivity.xl(recordedVideoInfoMap);
        }
        HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap = f16.getSelectedVideoInfoMap();
        if (selectedVideoInfoMap != null && selectedVideoInfoMap.size() > 0) {
            qZonePublishMoodBaseActivity.Bl(selectedVideoInfoMap);
        }
        HashMap<String, Boolean> hashMap = f16.getmMarkHasCheckFacesMap();
        if (hashMap != null) {
            qZonePublishMoodBaseActivity.V1 = hashMap;
        }
        HashMap<String, ArrayList<FaceData>> hashMap2 = f16.getmMarksFaceDataMap();
        if (hashMap2 != null) {
            qZonePublishMoodBaseActivity.X1 = hashMap2;
        }
        HashMap<String, MarkUinInfoBeforeUpload> hashMap3 = f16.getmMarksUploadMap();
        if (hashMap3 != null) {
            qZonePublishMoodBaseActivity.U1 = hashMap3;
        }
        HashMap<String, Boolean> hashMap4 = f16.getmMarkNeedShowFaceIconMap();
        if (hashMap4 != null) {
            qZonePublishMoodBaseActivity.W1 = hashMap4;
        }
        LbsDataV2.PoiInfo finalPoiInfo = f16.getFinalPoiInfo();
        if (finalPoiInfo != null) {
            ((LBSModule) qZonePublishMoodBaseActivity.hj(LBSModule.class)).H(finalPoiInfo);
        }
        if (f16.getEventTag() != null) {
            EventCenter.getInstance().post("WriteOperation", 63, f16.getEventTag());
        }
        if (f16.getIsLongPicModeOpen() != null) {
            qZonePublishMoodBaseActivity.getPartManager().broadcastMessage("long_pic_check_box_toggle", f16.getIsLongPicModeOpen());
        }
        qZonePublishMoodBaseActivity.Km();
        qZonePublishMoodBaseActivity.Im();
        qZonePublishMoodBaseActivity.Em();
    }

    @Override // com.qzone.publish.ui.state.a
    public void b() {
        ExtendEditText extendEditText;
        ExtendEditText extendEditText2;
        ExtendEditText extendEditText3;
        super.b();
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f52070j) && (extendEditText3 = qZonePublishMoodBaseActivity.f45104j0) != null) {
            extendEditText3.setText(this.f52070j);
            LocalMultiProcConfig.putString(LocalMultiProcConfig.PREFS_NAME_QZ_VIDEO_SETTING, QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "");
        }
        if (!TextUtils.isEmpty(this.f52071k) && (extendEditText2 = qZonePublishMoodBaseActivity.f45104j0) != null) {
            extendEditText2.setText(this.f52071k);
        }
        ArrayList<ResultRecord> arrayList = this.f52073m;
        if (arrayList != null && arrayList.size() > 0 && (extendEditText = qZonePublishMoodBaseActivity.f45104j0) != null) {
            qZonePublishMoodBaseActivity.f45104j0.setSelection(extendEditText.length());
            qZonePublishMoodBaseActivity.Xh(this.f52073m);
        }
        if (this.f52061e) {
            qZonePublishMoodBaseActivity.Ql(true);
            qZonePublishMoodBaseActivity.fl();
        }
        u(qZonePublishMoodBaseActivity);
        int i3 = qZonePublishMoodBaseActivity.F0;
        if (i3 == 1) {
            qZonePublishMoodBaseActivity.Ql(true);
            qZonePublishMoodBaseActivity.Kl();
        } else if (i3 == 12) {
            qZonePublishMoodBaseActivity.Ql(true);
            qZonePublishMoodBaseActivity.Ll(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID);
        }
        qZonePublishMoodBaseActivity.Wm();
        qZonePublishMoodBaseActivity.Dm();
        qZonePublishMoodBaseActivity.ui();
        qZonePublishMoodBaseActivity.qi();
    }

    @Override // com.qzone.publish.ui.state.a
    public void d() {
        super.d();
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        s();
        long g16 = g();
        if (qZonePublishMoodBaseActivity != null) {
            if (qZonePublishMoodBaseActivity.Um() != null) {
                qZonePublishMoodBaseActivity.tn("");
            }
            qZonePublishMoodBaseActivity.Qm();
        }
        u5.b.b("_shuoshuo", g16);
    }

    @Override // com.qzone.publish.ui.state.a
    public void f() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        ActionSheet actionSheet = this.f52063g;
        if (actionSheet == null || !actionSheet.isShowing()) {
            ActionSheet create = ActionSheet.create(qZonePublishMoodBaseActivity.getActivity());
            this.f52063g = create;
            if (!this.f52059c) {
                if (!qZonePublishMoodBaseActivity.Wj()) {
                    qZonePublishMoodBaseActivity.finish();
                    return;
                }
                this.f52063g.addButton(R.string.gd6, 3);
            } else {
                create.setMainTitle(R.string.glm);
                this.f52063g.addButton(R.string.gnh, 1);
                this.f52063g.addButton(R.string.f173019gi3, 3);
            }
            this.f52063g.addCancelButton(R.string.cancel);
            this.f52063g.setOnButtonClickListener(new a());
            this.f52063g.show();
        }
    }

    @Override // com.qzone.publish.ui.state.a
    public void i(Intent intent) {
        super.i(intent);
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || intent == null) {
            return;
        }
        this.f52070j = l.f59550a.s(qZonePublishMoodBaseActivity.bj(), intent);
        String stringExtra = intent.getStringExtra("summary");
        this.f52071k = stringExtra;
        this.f52071k = v(stringExtra);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("images");
        this.f52072l = stringArrayListExtra;
        if (stringArrayListExtra != null) {
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!qZonePublishMoodBaseActivity.oj().contains(next)) {
                    qZonePublishMoodBaseActivity.fi(next);
                    qZonePublishMoodBaseActivity.gi(next);
                }
            }
            qZonePublishMoodBaseActivity.am();
        }
        this.f52073m = intent.getParcelableArrayListExtra(QZoneShareManager.QZONE_SHARE_AT_FRIEND);
        qZonePublishMoodBaseActivity.f45111l1 = l.f59550a.p(qZonePublishMoodBaseActivity.bj(), intent);
        qZonePublishMoodBaseActivity.G = true;
        qZonePublishMoodBaseActivity.en(intent.getBooleanExtra(QZoneShareManager.QZONE_SHARE_FROM_MINI_APP, false));
        if (!P2VUtil.d().g()) {
            qZonePublishMoodBaseActivity.gn();
        }
        qZonePublishMoodBaseActivity.setTitle(R.string.i1w);
        if (this.f52059c && !qZonePublishMoodBaseActivity.pk() && !this.f52061e) {
            m();
        }
        if (this.f52065i) {
            w();
        }
    }

    @Override // com.qzone.publish.ui.state.a
    public void k() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        qZonePublishMoodBaseActivity.rn();
        ShuoshuoContent t16 = t(qZonePublishMoodBaseActivity);
        un.c.e().n(LoginData.getInstance().getUin(), t16);
    }

    @Override // com.qzone.publish.ui.state.a
    public void l() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        long g16 = g();
        String d06 = u5.b.d0("_shuoshuo", g16, QzoneConfig.DefaultValue.DEFAULT_LOCATION_TEXT);
        if (d06.equals(com.qzone.util.l.a(R.string.poj)) || d06.equals(qZonePublishMoodBaseActivity.Sm())) {
            return;
        }
        LbsDataV2.PoiInfo poiInfo = qZonePublishMoodBaseActivity.L0;
        if (poiInfo != null) {
            poiInfo.poiDefaultName = d06;
            poiInfo.address = d06;
            poiInfo.poiName = d06;
            String e06 = u5.b.e0("_shuoshuo", g16);
            if (!TextUtils.isEmpty(e06)) {
                qZonePublishMoodBaseActivity.L0.poiId = e06;
            }
            String c06 = u5.b.c0("_shuoshuo", g16);
            if (!TextUtils.isEmpty(c06)) {
                qZonePublishMoodBaseActivity.L0.dianPingId = c06;
            }
            if (TextUtils.isEmpty(u5.b.f0("_shuoshuo", g16))) {
                qZonePublishMoodBaseActivity.X0 = false;
                return;
            }
            return;
        }
        LbsDataV2.PoiInfo poiInfo2 = qZonePublishMoodBaseActivity.M0;
        if (poiInfo2 != null) {
            qZonePublishMoodBaseActivity.Y0 = true;
            poiInfo2.poiDefaultName = d06;
            poiInfo2.poiName = d06;
            poiInfo2.address = d06;
            String e07 = u5.b.e0("_shuoshuo", g16);
            if (!TextUtils.isEmpty(e07)) {
                qZonePublishMoodBaseActivity.M0.poiId = e07;
            }
            String c07 = u5.b.c0("_shuoshuo", g16);
            if (TextUtils.isEmpty(c07)) {
                return;
            }
            qZonePublishMoodBaseActivity.M0.dianPingId = c07;
        }
    }

    @Override // com.qzone.publish.ui.state.a
    public void m() {
        super.m();
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        if (qZonePublishMoodBaseActivity.oj() != null && !qZonePublishMoodBaseActivity.oj().isEmpty()) {
            RFWLog.i("PublishMoodStateNormal", RFWLog.USR, "[resetDraft] PublishMoodPage already has media, stop restore draft.");
            return;
        }
        long g16 = g();
        qZonePublishMoodBaseActivity.tn(u5.b.F("_shuoshuo", g16));
        if (qZonePublishMoodBaseActivity.oj() == null || qZonePublishMoodBaseActivity.oj().size() == 0) {
            ArrayList<String> arrayList = (ArrayList) u5.b.W("_shuoshuo", g16);
            qZonePublishMoodBaseActivity.dm(arrayList);
            if (bl.c(arrayList)) {
                qZonePublishMoodBaseActivity.N4 = true;
            }
        }
        ShuoshuoVideoInfo Y = u5.b.Y("_shuoshuo", g16);
        if (Y != null && !this.f52060d) {
            qZonePublishMoodBaseActivity.km(Y.mVideoPath);
            qZonePublishMoodBaseActivity.un(Y);
            qZonePublishMoodBaseActivity.f45114m1 = true;
            qZonePublishMoodBaseActivity.Gn(true);
        }
        HashMap<String, PicInfo> X = u5.b.X("_shuoshuo", g16);
        if (X != null && X.size() > 0) {
            qZonePublishMoodBaseActivity.em(X);
        }
        Map<String, LocalMediaInfo> T = u5.b.T("_shuoshuo", g16);
        if (T != null && T.size() > 0) {
            qZonePublishMoodBaseActivity.Al(T);
        }
        HashMap<String, ShuoshuoVideoInfo> P = u5.b.P("_shuoshuo", g16);
        if (P != null && P.size() > 0) {
            qZonePublishMoodBaseActivity.xl(P);
        }
        HashMap<String, ShuoshuoVideoInfo> Q = u5.b.Q("_shuoshuo", g16);
        if (Q != null && Q.size() > 0) {
            qZonePublishMoodBaseActivity.Bl(Q);
        }
        HashMap<String, Boolean> k06 = u5.b.k0("_shuoshuo", g16);
        if (k06 != null) {
            qZonePublishMoodBaseActivity.V1 = k06;
        }
        HashMap<String, ArrayList<FaceData>> m06 = u5.b.m0("_shuoshuo", g16);
        if (m06 != null) {
            qZonePublishMoodBaseActivity.X1 = m06;
        }
        HashMap<String, MarkUinInfoBeforeUpload> n06 = u5.b.n0("_shuoshuo", g16);
        if (n06 != null) {
            qZonePublishMoodBaseActivity.U1 = n06;
        }
        HashMap<String, Boolean> l06 = u5.b.l0("_shuoshuo", g16);
        if (l06 != null) {
            qZonePublishMoodBaseActivity.W1 = l06;
        }
        qZonePublishMoodBaseActivity.Km();
        qZonePublishMoodBaseActivity.Im();
        qZonePublishMoodBaseActivity.Em();
    }

    @Override // com.qzone.publish.ui.state.a
    public void n() {
        ExtendEditText extendEditText;
        super.n();
        long g16 = g();
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || (extendEditText = qZonePublishMoodBaseActivity.f45104j0) == null) {
            return;
        }
        u5.b.P0("_shuoshuo", extendEditText.getText().toString(), g16);
    }

    @Override // com.qzone.publish.ui.state.a
    public void o() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        qZonePublishMoodBaseActivity.rn();
        ShuoshuoContent t16 = t(qZonePublishMoodBaseActivity);
        long g16 = g();
        u5.b.N0(t16, g16);
        u5.b.C0("_shuoshuo", qZonePublishMoodBaseActivity.Um(), g16);
    }

    @Override // com.qzone.publish.ui.state.a
    public void p() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        long g16 = g();
        Boolean value = qZonePublishMoodBaseActivity.vj().T1().getValue();
        u5.b.q0(QZonePublishMoodActivity.Vo("shuoshuo_sync_bits", g16), (value == null || !value.booleanValue()) ? 0 : 1);
    }

    private void u(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        if (qZonePublishMoodBaseActivity != null && qZonePublishMoodBaseActivity.f45111l1 == 22) {
            qZonePublishMoodBaseActivity.L1 = QZoneMediaBusiness.QZONE_MYSHUOSHUO_LIST_PHOTO;
        }
    }
}
