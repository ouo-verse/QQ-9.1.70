package com.qzone.cover.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.EventCenter;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.util.ToastUtil;
import com.qzone.widget.g;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import ho.i;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCoverSetCustomActivity extends BaseFragment {
    private int G;
    private g J;
    private String K;
    private String L;
    protected String C = "QZoneCoverSetCustomActivity";
    private int D = 640;
    private int E = 640;
    private int F = 70;
    private boolean H = false;
    private boolean I = false;
    private boolean M = false;
    private boolean N = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private int S = -1;
    private BroadcastReceiver T = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QZoneCoverSetCustomActivity.this.xh(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CoverCacheData f46796a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, CoverCacheData coverCacheData) {
            super(looper);
            this.f46796a = coverCacheData;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            CoverComponentProxy.f50099g.getServiceInterface().saveCoverIntoCache(this.f46796a);
            return doNext(true);
        }
    }

    private void Ah() {
        startActivityForResult(ak.y(getActivity(), getActivity().getString(R.string.gjv), 2, true), 346);
    }

    private CoverCacheData Bh(JSONObject jSONObject) throws JSONException {
        String str;
        try {
            String optString = jSONObject.optString("coverType");
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(optString)) {
                CoverLog.i(this.C, CoverLog.CLR, "\u7a7a\u95f4\u79c0\u4e0d\u8981\u7528\u5047\u6570\u636e\uff0c\u76f4\u63a5\u5237\u65b0feed data\u597d\u4e86");
                return null;
            }
            CoverCacheData coverCacheData = new CoverCacheData();
            coverCacheData.type = optString;
            coverCacheData.coverId = jSONObject.optString("coverId");
            if (coverCacheData.type.startsWith(QzoneCoverConst.CoverStringType.COVER_TYPE_WEBVIEW_COVER_PREFIX)) {
                coverCacheData.mapExtInfo.put(QzoneCoverConst.COVER_EXTINFO_WEBVIEW_H5_URL, jSONObject.optString(QzoneCoverConst.COVER_EXTINFO_WEBVIEW_H5_URL));
                coverCacheData.urls.put("HigeResolutionCover", jSONObject.optString("url"));
                coverCacheData.urls.put("LowResolutionCover", jSONObject.optString("url"));
                return coverCacheData;
            }
            if (coverCacheData.type.endsWith(QzoneCoverConst.CoverStringType.COVER_TYPE_GAME) && jSONObject.has("extendinfo")) {
                coverCacheData.gameCoverInfo = new CoverCacheData.GameCoverInfo();
                JSONObject jSONObject2 = jSONObject.getJSONObject("extendinfo");
                String[] split = jSONObject2.optString("jumpsite").split("_");
                coverCacheData.gameCoverInfo.xCoordLU = (float) Double.parseDouble(split[0]);
                coverCacheData.gameCoverInfo.yCoordLU = (float) Double.parseDouble(split[1]);
                coverCacheData.gameCoverInfo.xCoordRD = (float) Double.parseDouble(split[2]);
                coverCacheData.gameCoverInfo.yCoordRD = (float) Double.parseDouble(split[3]);
                coverCacheData.gameCoverInfo.jmpType = jSONObject2.getInt("jumptype");
                coverCacheData.gameCoverInfo.jmpUrl = jSONObject2.optString("jumpurl");
                coverCacheData.gameCoverInfo.schema = jSONObject2.optString("jumpschema");
            }
            int i3 = jSONObject.getInt("coverIndex");
            String optString2 = jSONObject.optString("syncFlag");
            if (!TextUtils.isEmpty(optString2) && optString2.equals("1")) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("coverUrls");
            if (coverCacheData.type.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN)) {
                String string = jSONArray.getString(0);
                try {
                    str = jSONObject.getString("LowResolutionCover");
                } catch (JSONException unused) {
                    str = string;
                }
                coverCacheData.urls.put("LowResolutionCover", str);
                coverCacheData.urls.put("HigeResolutionCover", string);
                coverCacheData.mapExtInfo.put(QzoneCoverConst.KEY_TRANSPARENCY, jSONObject.optString("transparency"));
                return coverCacheData;
            }
            if (i3 >= 0 && jSONArray.length() > i3) {
                String string2 = jSONArray.getString(i3);
                coverCacheData.urls.put("LowResolutionCover", string2);
                coverCacheData.urls.put("HigeResolutionCover", string2);
                return coverCacheData;
            }
            if (jSONArray.length() > 1) {
                coverCacheData.urls.put("LowResolutionCover", jSONArray.getString(1));
                coverCacheData.urls.put("HigeResolutionCover", jSONArray.getString(0));
            } else if (jSONArray.length() > 0) {
                String string3 = jSONArray.getString(0);
                coverCacheData.urls.put("HigeResolutionCover", string3);
                coverCacheData.urls.put("LowResolutionCover", string3);
            } else {
                JSONArray jSONArray2 = jSONObject.getJSONArray("coverUrls");
                if (jSONArray2.length() > 1) {
                    coverCacheData.urls.put("LowResolutionCover", jSONArray2.getString(1));
                    coverCacheData.urls.put("HigeResolutionCover", jSONArray2.getString(0));
                } else if (jSONArray2.length() > 0) {
                    String string4 = jSONArray2.getString(0);
                    coverCacheData.urls.put("HigeResolutionCover", string4);
                    coverCacheData.urls.put("LowResolutionCover", string4);
                }
            }
            return coverCacheData;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void Ch() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
        registerReceiver(this.T, intentFilter);
    }

    private void Dh(Map<String, String> map) {
        CoverCacheData coverCacheData = new CoverCacheData();
        coverCacheData.uin = LoginData.getInstance().getUin();
        coverCacheData.type = QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM;
        if (map != null) {
            coverCacheData.urls = (HashMap) map;
            String str = map.get("HigeResolutionCover");
            if (TextUtils.isEmpty(str)) {
                str = map.get("LowResolutionCover");
            }
            if (!TextUtils.isEmpty(str)) {
                String imageFilePath = CacheManager.getImageFilePath(getActivity(), str);
                if (!TextUtils.isEmpty(imageFilePath) && !TextUtils.isEmpty(this.K)) {
                    FileUtils.copyFiles(new File(this.K), new File(imageFilePath));
                }
            }
        } else {
            coverCacheData.local_url = this.K;
        }
        if (this.H) {
            CoverComponentProxy.f50099g.getServiceInterface().saveCoverIntoCache(coverCacheData);
            if (this.G == 0) {
                EventCenter.getInstance().post("Personalize", 8, coverCacheData);
                setResult(-1);
                finish();
                return;
            }
        }
        if (this.I && this.G == 1) {
            setResult(-1);
            EventCenter.getInstance().post("Personalize", 8, coverCacheData);
        }
        QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
        qZoneUserHomeBean.setUin(LoginData.getInstance().getUin());
        qZoneUserHomeBean.setShowFacade(false);
        i.z().t(getActivity(), qZoneUserHomeBean);
        finish();
    }

    private void Eh(String str) {
        if (QLog.isDebugVersion()) {
            CoverLog.i(this.C, CoverLog.CLR, "call setCover");
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final CoverCacheData Bh = Bh(jSONObject);
                boolean z16 = true;
                if (VasToggle.BUG_103762681.isEnable(true)) {
                    EventCenter.getInstance().post("Personalize", 12, null);
                    if (QLog.isDebugVersion()) {
                        CoverLog.i(this.C, CoverLog.CLR, "\u5f3a\u5236\u62c9\u53d6\u7f51\u7edccover\u6570\u636e\u66f4\u65b0");
                    }
                } else if (Bh == null) {
                    EventCenter.getInstance().post("Personalize", 12, Bh);
                } else {
                    Bh.uin = LoginData.getInstance().getUin();
                    CoverEnv.getBackgroundThreadHandler().post(new Runnable() { // from class: com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.2
                        @Override // java.lang.Runnable
                        public void run() {
                            CoverComponentProxy.f50099g.getServiceInterface().saveCoverIntoCache(Bh);
                        }
                    });
                    EventCenter.getInstance().post("Personalize", 8, Bh);
                }
                setResult(-1);
                if (jSONObject.optInt("need_jump") == 1) {
                    QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
                    qZoneUserHomeBean.setUin(LoginData.getInstance().getUin());
                    qZoneUserHomeBean.setShowFacade(false);
                    i.z().t(getActivity(), qZoneUserHomeBean);
                }
                Intent intent = new Intent();
                if (jSONObject.optInt("need_jump") != 1) {
                    z16 = false;
                }
                intent.putExtra("need_jump", z16);
                setResult(-1, intent);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            finish();
        }
    }

    private void Fh(boolean z16, String str) {
        boolean z17;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(this.C, 2, "setCustomCover");
        }
        if (z16) {
            this.H = true;
            this.I = true;
        } else if (this.G == 0) {
            this.H = true;
            this.I = false;
        } else {
            this.H = false;
            this.I = true;
        }
        if (NetworkState.isNetSupport()) {
            z17 = true;
        } else {
            ToastUtil.n(R.string.gdc);
            this.K = str;
            z17 = false;
        }
        if (z17) {
            if (this.J == null) {
                this.J = new g();
            }
            this.J.c(getActivity(), getResources().getString(R.string.gdh));
        }
        q6.a.b().j(getHandler(), str, this.H, this.I, z17, this.G);
        this.K = str;
    }

    private void Gh(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (QLog.isDebugVersion()) {
            CoverLog.i(this.C, CoverLog.CLR, "call setLocalCover:" + str);
        }
        try {
            try {
                jSONObject = new JSONObject(str);
                jSONObject2 = jSONObject.getJSONObject("data");
            } catch (Exception e16) {
                EventCenter.getInstance().post("Personalize", 12, null);
                if (QLog.isDebugVersion()) {
                    CoverLog.e(this.C, "\u5f3a\u5236\u62c9\u53d6\u7f51\u7edccover\u6570\u636e\u66f4\u65b0", e16);
                }
            }
            if (jSONObject2 == null) {
                return;
            }
            CoverCacheData parseCoverJceJson = CoverComponentProxy.f50099g.getServiceInterface().parseCoverJceJson(jSONObject2);
            if (VasToggle.BUG_103762681.isEnable(true)) {
                EventCenter.getInstance().post("Personalize", 12, null);
                if (QLog.isDebugVersion()) {
                    CoverLog.i(this.C, CoverLog.CLR, "\u5f3a\u5236\u62c9\u53d6\u7f51\u7edccover\u6570\u636e\u66f4\u65b0");
                }
            } else {
                if (parseCoverJceJson != null && !QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(parseCoverJceJson.type) && !QzoneCoverConst.CoverStringType.COVER_TYPE_PHOTOWALL.equals(parseCoverJceJson.type)) {
                    parseCoverJceJson.uin = LoginData.getInstance().getUin();
                    HdAsync.with(this).then(new b(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), parseCoverJceJson)).call();
                    EventCenter.getInstance().post("Personalize", 8, parseCoverJceJson);
                    CoverLog.i(this.C, CoverLog.CLR, "\u66f4\u65b0cover\u7f13\u5b58\u5e76\u4e14\u5237\u65b0cover");
                }
                EventCenter.getInstance().post("Personalize", 12, null);
                CoverLog.i(this.C, CoverLog.CLR, "\u62c9\u53d6\u7f51\u7edccover\u6570\u636e\u66f4\u65b0");
            }
            boolean optBoolean = jSONObject.optBoolean("needJump");
            if (optBoolean) {
                QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
                qZoneUserHomeBean.setUin(LoginData.getInstance().getUin());
                qZoneUserHomeBean.setShowFacade(false);
                i.z().t(getActivity(), qZoneUserHomeBean);
            }
            Intent intent = new Intent();
            intent.putExtra("needJump", optBoolean);
            setResult(-1, intent);
        } finally {
            finish();
        }
    }

    private void Hh(String str) {
        try {
            CustomNaviCacheData createFromJson = CustomNaviCacheData.createFromJson(Long.valueOf(LoginData.getInstance().getUin()), new JSONObject(str));
            com.qzone.personalize.business.b.n().A(createFromJson);
            EventCenter.getInstance().post("Personalize", 16, createFromJson);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            finish();
            throw th5;
        }
        finish();
    }

    private void Ih(boolean z16) {
        QzoneWidgetService.setShowWidget(getActivity(), z16, LoginData.getInstance().getUin());
        EventCenter.getInstance().post("Personalize", 9);
        setResult(-1);
        finish();
    }

    private void Jh(int i3) {
        QzoneWidgetService.setWidgetType(getActivity(), i3, LoginData.getInstance().getUin());
        EventCenter.getInstance().post("Personalize", 9);
        setResult(-1);
        finish();
    }

    private int sh() {
        return Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    }

    private String th() {
        if (TextUtils.isEmpty(this.L)) {
            this.L = ImageManager.getCachePath(getActivity()) + File.separator + "photoCropTemp" + (System.currentTimeMillis() / 1000);
        }
        return this.L;
    }

    private String[] uh() {
        return null;
    }

    private void vh() {
        String[] P = QZoneConfigHelper.P();
        String[] O = QZoneConfigHelper.O();
        if (NetworkState.isWifiConn()) {
            this.D = Integer.valueOf(P[4]).intValue();
            this.E = Integer.valueOf(P[5]).intValue();
            this.F = Integer.valueOf(O[2]).intValue();
        } else {
            this.D = Integer.valueOf(P[0]).intValue();
            this.E = Integer.valueOf(P[1]).intValue();
            this.F = Integer.valueOf(O[0]).intValue();
        }
    }

    private void wh(Uri uri) {
        vh();
        com.qzone.common.business.service.b.f().j(getActivity(), this.D, this.E, this.F, sh(), com.qzone.util.image.c.E(getActivity(), uri), th(), uh(), getString(R.string.gdi));
    }

    private void yh() {
        vh();
        com.qzone.common.business.service.b.f().m(getActivity(), this.D, this.E, this.F, sh(), th(), uh());
    }

    private void zh() {
        startActivityForResult(ak.x(getActivity(), getActivity().getString(R.string.gjv), 2), 345);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            return;
        }
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        Ch();
        int intExtra = getIntent().getIntExtra("open_what", -1);
        this.S = intExtra;
        switch (intExtra) {
            case 0:
                this.G = getIntent().getIntExtra("set_source", 0);
                yh();
                return;
            case 1:
                this.G = getIntent().getIntExtra("set_source", 0);
                zh();
                return;
            case 2:
                int intExtra2 = getIntent().getIntExtra("widgetId", -1);
                if (intExtra2 < 0) {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastWidgetIDError", "\u6302\u4ef6ID\u9519\u8bef"), 4);
                    finish();
                }
                Jh(intExtra2);
                return;
            case 3:
                Ih(getIntent().getBooleanExtra("widgetEnable", false));
                return;
            case 4:
                Eh(getIntent().getStringExtra("cover"));
                return;
            case 5:
                this.G = getIntent().getIntExtra("set_source", 0);
                Ah();
                return;
            case 6:
                Gh(getIntent().getStringExtra("cover"));
                return;
            case 7:
                Hh(getIntent().getStringExtra("navi_deco"));
                return;
            default:
                finish();
                return;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.T;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.M && !this.N) {
            finish();
        }
        if (this.P && this.Q) {
            if (!this.R) {
                this.R = true;
            } else if (!this.N) {
                finish();
            }
        }
        int i3 = this.S;
        if (i3 == 0) {
            this.M = true;
        } else if (i3 == 1) {
            this.P = true;
        }
    }

    public void xh(Intent intent) {
        if (intent != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d(this.C, 2, "onCropResult");
            }
            String string = intent.getExtras().getString("PhotoConst.SINGLE_PHOTO_PATH");
            int i3 = intent.getExtras().getInt(PeakConstants.QZONE_COVER_SYNC_FLAG);
            if (this.M || this.P) {
                this.N = true;
            }
            Fh(i3 == 1, string);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void IOnSetTheme() {
        setTheme(R.style.f173748jk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        if (message != null && message.what == 1000011) {
            QZoneResult unpack = QZoneResult.unpack(message);
            if (this.J != null && !isFinishing()) {
                this.J.b();
            }
            if (unpack.getSucceed()) {
                Dh((Map) unpack.getData());
                return;
            }
            if (!TextUtils.isEmpty(unpack.getMessage())) {
                ToastUtil.s(unpack.getMessage(), 4);
            } else {
                ToastUtil.o(R.string.gdg, 4);
            }
            finish();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 345 && i16 == -1) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                wh(Uri.fromFile(new File(stringExtra)));
                this.Q = true;
                return;
            }
            return;
        }
        QZLog.d(this.C, 2, "QZoneCoverSetCustomActivity req code=" + i3 + ",resultCode=" + i16);
        finish();
    }
}
