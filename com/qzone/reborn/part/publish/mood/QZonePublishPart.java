package com.qzone.reborn.part.publish.mood;

import NS_MOBILE_PHOTO.shuoshuo_privacy;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.business.share.ShareUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.reborn.base.k;
import com.qzone.reborn.part.publish.mood.sync.o;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.widget.QzoneEmotionUtils;
import gm.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes37.dex */
public class QZonePublishPart extends k {
    private fm.b C;

    /* renamed from: d, reason: collision with root package name */
    private final QZonePublishMoodNewStyleActivity f58651d;

    /* renamed from: f, reason: collision with root package name */
    protected QQProgressDialog f58653f;

    /* renamed from: h, reason: collision with root package name */
    private o f58654h;

    /* renamed from: i, reason: collision with root package name */
    private c f58655i;

    /* renamed from: m, reason: collision with root package name */
    private hm.b f58656m;

    /* renamed from: e, reason: collision with root package name */
    protected volatile boolean f58652e = false;
    IQzoneShareApi.WXShareListener D = new b();

    /* loaded from: classes37.dex */
    class b implements IQzoneShareApi.WXShareListener {
        b() {
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            int i3 = baseResp.errCode;
            if (i3 == 0) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShared", "\u5df2\u5206\u4eab"), 5);
            } else if (i3 != -2) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShareFail", ShareJsPlugin.ERRMSG_INVITE_REQUIRE), 4);
            }
        }
    }

    public QZonePublishPart(QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity) {
        this.f58651d = qZonePublishMoodNewStyleActivity;
    }

    private void H9(Intent intent) {
        QZLog.d("QZonePublishPart", 4, "Need syncDynamicToWechat");
        if (intent == null) {
            QZLog.d("QZonePublishPart", 4, "Need syncDynamicToWechat intent ==null");
            return;
        }
        String h06 = u5.b.h0("key_dynamic_share_url", "null");
        String h07 = u5.b.h0("key_dynamic_share_cover_url", "null");
        String stringExtra = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_NAME);
        if (!h06.equals("null") && !h07.equals("null")) {
            ShareUtils.g gVar = new ShareUtils.g();
            gVar.f44740a = h06;
            gVar.f44743d = h07;
            gVar.f44741b = stringExtra;
            ShareUtils.q(getActivity(), 10, gVar);
        } else {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSyncWechatFailForWeakNetWork", "\u7f51\u7edc\u4e0d\u4f73\uff0c\u540c\u6b65\u670b\u53cb\u5708\u5931\u8d25"), 6);
        }
        ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 3, "3", true, new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9(String str) {
        String str2;
        DynamicArrayList<String> value = this.f58655i.S1().getValue();
        MoodPicLabel moodPicLabel = this.f58651d.f51472o5;
        if (moodPicLabel == null) {
            str2 = "";
        } else {
            str2 = moodPicLabel.c();
        }
        String str3 = str2.equals(BaseApplication.getContext().getString(R.string.f173026gk2)) ? "" : str2;
        if (value != null && !value.isEmpty()) {
            com.qzone.publish.utils.a aVar = new com.qzone.publish.utils.a(getActivity(), str, str3, this.f58651d.uj(this.f58651d.Zi(null)));
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap e16 = aVar.e(value);
            if (QZLog.isColorLevel()) {
                QZLog.i("QZonePublishPart", "bitmap create time cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (e16 != null) {
                String str4 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                StringBuilder sb5 = new StringBuilder();
                String str5 = IQzoneShareApi.PHOTO_PATH;
                sb5.append(str5);
                sb5.append(str4);
                String sb6 = sb5.toString();
                try {
                    File file = new File(str5);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Throwable th5) {
                    QZLog.e("QZonePublishPart", th5.getMessage());
                }
                com.qzone.util.image.c.V(e16, sb6, Bitmap.CompressFormat.JPEG, 100, true);
                if (this.f58652e) {
                    ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(this.D);
                    ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), sb6, null, 1);
                    L9();
                    if (QZLog.isColorLevel()) {
                        QZLog.i("QZonePublishPart", "wxshare time cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    return;
                }
                return;
            }
            L9();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                L9();
                String emoToWechatEmo = QzoneEmotionUtils.emoToWechatEmo(lp.a.c(str));
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(this.D);
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareText(emoToWechatEmo, 1);
                return;
            } catch (Throwable th6) {
                QZLog.e("QZonePublishPart", th6.getMessage());
                return;
            }
        }
        L9();
    }

    private void L9() {
        QQProgressDialog qQProgressDialog = this.f58653f;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && getActivity() != null && !getActivity().isFinishing()) {
            this.f58652e = false;
            try {
                this.f58653f.dismiss();
            } catch (Exception e16) {
                QZLog.e("QZonePublishPart", "dialog dismiss error", e16);
            }
            this.f58651d.Vo();
            return;
        }
        this.f58652e = false;
        this.f58651d.Vo();
    }

    public void E9(Intent intent) {
        Boolean value = this.f58654h.U1().getValue();
        if (value == null || !value.booleanValue()) {
            return;
        }
        if (this.C.T1()) {
            H9(intent);
            return;
        }
        DynamicArrayList<String> value2 = this.f58655i.S1().getValue();
        if (value2 != null && value2.size() > 0) {
            if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHAREWX_MULTIPIC, 0) == 0) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), ViewUtils.dip2px(100.0f));
                this.f58653f = qQProgressDialog;
                qQProgressDialog.setMessage(l.a(R.string.f172567s61));
                this.f58653f.show();
                this.f58653f.O(new a());
                J9();
                return;
            }
            K9(value2);
            return;
        }
        J9();
    }

    public boolean F9() {
        return this.f58652e;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f58655i = (c) getViewModel(c.class);
        this.f58656m = (hm.b) getViewModel(hm.b.class);
        this.C = (fm.b) getViewModel(fm.b.class);
        this.f58654h = (o) getViewModel(o.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this.D);
    }

    protected void J9() {
        this.f58652e = true;
        ClickReport.q(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, "1", "1", true);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.part.publish.mood.QZonePublishPart.2
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishPart qZonePublishPart = QZonePublishPart.this;
                qZonePublishPart.I9(qZonePublishPart.f58651d.Vi());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements QQProgressDialog.b {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            ToastUtil.s(l.a(R.string.s69), 3);
            QZonePublishPart.this.f58652e = false;
            QZonePublishPart.this.f58651d.Vo();
        }
    }

    protected void K9(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList(arrayList);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.part.publish.mood.QZonePublishPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (arrayList2.size() == 0) {
                    return;
                }
                ArrayList<File> arrayList3 = new ArrayList<>();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (URLUtil.isNetworkUrl(str)) {
                        File imageFile = ImageLoader.getInstance().getImageFile(str);
                        if (imageFile != null && imageFile.exists()) {
                            arrayList3.add(imageFile);
                        }
                    } else {
                        arrayList3.add(new File(str));
                    }
                    if (arrayList3.size() >= 9) {
                        break;
                    }
                }
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareMutilPicToWehat(BaseApplication.getContext(), arrayList3);
            }
        });
    }

    public void G9(Intent intent, String str, com.qzone.publish.ui.model.c cVar) {
        String str2;
        String str3;
        ArrayList<String> value = this.f58656m.W1().getValue();
        Integer value2 = this.f58656m.T1().getValue();
        String stringExtra = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_NAME);
        String stringExtra2 = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_DESC);
        String stringExtra3 = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID);
        String stringExtra4 = intent.getStringExtra("music_id");
        String stringExtra5 = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID);
        String stringExtra6 = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START);
        String stringExtra7 = intent.getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE);
        shuoshuo_privacy shuoshuo_privacyVar = new shuoshuo_privacy();
        shuoshuo_privacyVar.mood_permission = String.valueOf(value2);
        if (value == null || value.size() <= 0) {
            str2 = stringExtra7;
            str3 = stringExtra6;
        } else {
            ArrayList<Long> arrayList = new ArrayList<>();
            str2 = stringExtra7;
            str3 = stringExtra6;
            for (int i3 = 0; i3 < value.size(); i3++) {
                arrayList.add(Long.valueOf(value.get(i3)));
            }
            shuoshuo_privacyVar.mood_allowuins = arrayList;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_NAME, stringExtra);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_DESC, stringExtra2);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID, stringExtra3);
        hashMap.put("music_id", stringExtra4);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID, stringExtra5);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START, str3);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE, str2);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_MOOD_TEXT, str);
        ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 3, "2", true, new String[0]);
        QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = this.f58651d;
        qZonePublishMoodNewStyleActivity.wq(qZonePublishMoodNewStyleActivity.I4);
        cVar.f51944g = shuoshuo_privacyVar;
        cVar.f51942f = hashMap;
        ((pc.b) getViewModel(pc.b.class)).Q1(getActivity(), cVar, false);
    }
}
