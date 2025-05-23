package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.ExtendEditText;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.util.LiuHaiUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends u implements View.OnClickListener {
    private View C;
    private int D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private QzEditVideoPartManager f66409d;

    /* renamed from: e, reason: collision with root package name */
    private String f66410e;

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f66411f;

    /* renamed from: h, reason: collision with root package name */
    private CheckBox f66412h;

    /* renamed from: i, reason: collision with root package name */
    private ExtendEditText f66413i;

    /* renamed from: m, reason: collision with root package name */
    private Button f66414m;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.activity.richmedia.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0575a implements CompoundButton.OnCheckedChangeListener {
        C0575a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            a.this.f66409d.B0 = z16;
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public a(QzEditVideoPartManager qzEditVideoPartManager) {
        super(qzEditVideoPartManager);
        this.f66410e = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(1);
        this.D = 0;
        this.f66409d = qzEditVideoPartManager;
    }

    public static boolean m0(int i3) {
        if (i3 != 16 && i3 != 128) {
            return false;
        }
        return true;
    }

    private void p0() {
        Typeface createFromFile;
        ExtendEditText extendEditText = this.f66413i;
        if (extendEditText == null) {
            return;
        }
        extendEditText.setTextEffect(this.f66409d.L0);
        String trueTypeFont = ((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(this.f66409d.H0, null, null, true, null);
        if (TextUtils.isEmpty(trueTypeFont)) {
            this.f66409d.H0 = -1;
            createFromFile = null;
        } else {
            createFromFile = Typeface.createFromFile(trueTypeFont);
        }
        this.f66413i.setTypeface(createFromFile);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (message.what != 11) {
            this.D = message.arg1;
            return super.handleEditVideoMessage(message);
        }
        this.mAnimationEndTime = ((Long) message.obj).longValue();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        if (r9 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String l0(String str) {
        String str2 = "";
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + str), null, "uin=?", new String[]{str}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("name");
                    if (columnIndex >= 0) {
                        String string = cursor.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            str2 = SecurityUtile.decode(new String(string.getBytes(), "utf-8"));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("EditVideoQzComment", 2, "getNickName by ContentProvider success, name =" + str2);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EditVideoQzComment", 2, "getNickName by ContentProvider  Exception, trace=" + QLog.getStackTraceString(e16));
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        Bundle bundle;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("EditVideoQzComment", 2, "onActivityResult:requestCode=" + i3 + "  resultCode=" + i16);
            }
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                    this.f66409d.f66341w0 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                }
                if (extras.containsKey("uin_list")) {
                    QzEditVideoPartManager qzEditVideoPartManager = this.f66409d;
                    if (qzEditVideoPartManager.f66340v0 == null) {
                        qzEditVideoPartManager.f66340v0 = new ArrayList<>();
                    }
                    this.f66409d.f66340v0.clear();
                    ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
                    if (stringArrayList != null) {
                        this.f66409d.f66340v0.addAll(stringArrayList);
                    }
                }
                if (m0(this.f66409d.f66341w0)) {
                    this.f66409d.f66343y0 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                    this.f66409d.f66342x0 = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
                }
                if (SlideShowPhotoListManager.n().m() == 22) {
                    LpReportInfo_pf00064.allReport(680, 5, 2);
                }
                q0();
                return;
            }
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 5, 3);
                return;
            }
            return;
        }
        if (i3 == 1009) {
            View view = this.f66409d.f66339u0;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mParent.s(Message.obtain((Handler) null, 22));
            if (intent != null) {
                Bundle extras2 = intent.getExtras();
                if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY) && (bundle = extras2.getBundle(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY)) != null) {
                    this.f66409d.f66341w0 = bundle.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                    QzEditVideoPartManager qzEditVideoPartManager2 = this.f66409d;
                    if (qzEditVideoPartManager2.f66340v0 == null) {
                        qzEditVideoPartManager2.f66340v0 = new ArrayList<>();
                    }
                    this.f66409d.f66340v0.clear();
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("uin_list");
                    if (stringArrayList2 != null) {
                        this.f66409d.f66340v0.addAll(stringArrayList2);
                    }
                    if (m0(this.f66409d.f66341w0)) {
                        this.f66409d.f66343y0 = bundle.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                        this.f66409d.f66342x0 = bundle.getString(UgcSettingUtil.KEY_TAG_INFO);
                    }
                    q0();
                }
                if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE)) {
                    this.f66412h.setChecked(extras2.getBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE));
                }
                if (extras2.containsKey("contentIntentKey")) {
                    String string = extras2.getString("contentIntentKey");
                    if (string == null) {
                        string = "";
                    }
                    this.f66409d.f66344z0 = string;
                    if (SlideShowPhotoListManager.n().m() == 22) {
                        LpReportInfo_pf00064.allReport(680, 2, 8);
                    }
                }
                if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO)) {
                    this.f66413i.setText(extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO));
                }
                this.f66409d.H0 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1);
                this.f66409d.I0 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE);
                this.f66409d.J0 = extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
                this.f66409d.K0 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, -1);
                this.f66409d.L0 = extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
                p0();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        k0();
        this.f66411f = (RelativeLayout) findViewSure(R.id.cdy);
        this.f66412h = (CheckBox) findViewSure(R.id.cfa);
        this.f66413i = (ExtendEditText) findViewSure(R.id.cdz);
        this.f66414m = (Button) findViewSure(R.id.cf5);
        this.C = findViewSure(R.id.cf_);
        this.f66413i.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        this.f66413i.setOnClickListener(this);
        this.f66414m.setOnClickListener(this);
        if (!this.f66409d.F0) {
            this.f66414m.setVisibility(8);
        }
        QzEditVideoPartManager qzEditVideoPartManager = this.f66409d;
        if (qzEditVideoPartManager.C0 || qzEditVideoPartManager.E0) {
            this.f66414m.setVisibility(8);
            this.f66412h.setVisibility(0);
            this.f66412h.setOnCheckedChangeListener(new C0575a());
            this.f66412h.setChecked(true);
        }
        if (n0(QQStoryContext.h().d())) {
            p0();
        }
    }

    public void q0() {
        String privacyDescriptionForShuoShuo = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(this.f66409d.f66341w0);
        this.f66410e = privacyDescriptionForShuoShuo;
        this.f66414m.setText(privacyDescriptionForShuoShuo);
    }

    private boolean n0(String str) {
        try {
            long longValue = Long.valueOf(str).longValue();
            o0(longValue);
            DefaultFontInfo defaultFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultFont(longValue);
            if (defaultFont == null) {
                return false;
            }
            QzEditVideoPartManager qzEditVideoPartManager = this.f66409d;
            int i3 = defaultFont.fontId;
            qzEditVideoPartManager.H0 = i3;
            qzEditVideoPartManager.I0 = defaultFont.formatType;
            qzEditVideoPartManager.J0 = defaultFont.fontUrl;
            return i3 > 0;
        } catch (Throwable th5) {
            QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + th5.getMessage());
            return false;
        }
    }

    private void k0() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewSure(R.id.rsr);
        this.f66411f = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.bkb, (ViewGroup) relativeLayout, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(50.0f, getResources()));
        this.f66411f.setVisibility(this.f66409d.D0 ? 0 : 8);
        layoutParams.addRule(12);
        int i3 = LiuHaiUtils.BOTTOM_HEIGHT;
        if (i3 <= 0) {
            i3 = BaseAIOUtils.f(60.0f, getResources());
        }
        layoutParams.bottomMargin = i3;
        relativeLayout.addView(this.f66411f, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mAnimationEndTime <= System.currentTimeMillis()) {
            int id5 = view.getId();
            String str = "";
            if (id5 == R.id.cf5) {
                String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, QZoneHelper.Constants.UGC_PERMIT_SETTING_PAGE).replace("{uin}", QQStoryContext.h().d()).replace("{qua}", QUA.getQUA3());
                this.f66409d.v1(3004);
                Bundle bundle = new Bundle();
                bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f66409d.f66341w0);
                ArrayList<String> arrayList = this.f66409d.f66340v0;
                if (arrayList != null && arrayList.size() > 0) {
                    bundle.putStringArrayList("uin_list", this.f66409d.f66340v0);
                    ArrayList<String> arrayList2 = new ArrayList<>(this.f66409d.f66340v0.size());
                    Iterator<String> it = this.f66409d.f66340v0.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(l0(it.next()));
                    }
                    bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
                }
                if (m0(this.f66409d.f66341w0) && !TextUtils.isEmpty(this.f66409d.f66343y0)) {
                    bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f66409d.f66343y0);
                }
                if (SlideShowPhotoListManager.n().m() == 22) {
                    LpReportInfo_pf00064.allReport(680, 2, 4);
                    LpReportInfo_pf00064.allReport(680, 5, 1);
                }
                QZoneHelper.forwardToBrowser((BaseActivity) this.mUi, replace, 1, bundle, "");
            } else if (id5 == R.id.cdz) {
                this.f66409d.v1(3001);
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                Bundle bundle2 = new Bundle();
                bundle2.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f66409d.f66341w0);
                ArrayList<String> arrayList3 = this.f66409d.f66340v0;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    bundle2.putStringArrayList("uin_list", this.f66409d.f66340v0);
                    ArrayList<String> arrayList4 = new ArrayList<>(this.f66409d.f66340v0.size());
                    Iterator<String> it5 = this.f66409d.f66340v0.iterator();
                    while (it5.hasNext()) {
                        arrayList4.add(l0(it5.next()));
                    }
                    bundle2.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList4);
                }
                if (m0(this.f66409d.f66341w0) && !TextUtils.isEmpty(this.f66409d.f66343y0)) {
                    bundle2.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f66409d.f66343y0);
                }
                bundle2.putBoolean("is_need_auto_close_from_pri", true);
                View view2 = this.f66409d.f66339u0;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ExtendEditText extendEditText = this.f66413i;
                if (extendEditText != null) {
                    str = extendEditText.getText().toString();
                }
                String str2 = str;
                if (SlideShowPhotoListManager.n().m() == 22) {
                    LpReportInfo_pf00064.allReport(680, 2, 3);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean(QZoneHelper.QzoneFeedActionPanelConstants.KEY_AT_CLICK_HIDE_KEYBOARD, true);
                this.mParent.s(Message.obtain((Handler) null, 21));
                BaseActivity baseActivity = (BaseActivity) this.mUi;
                QzEditVideoPartManager qzEditVideoPartManager = this.f66409d;
                boolean z16 = qzEditVideoPartManager.C0;
                QZoneHelper.forwardToVideoEditActionPanel(baseActivity, userInfo, 1009, "", str2, "", "", 0, !z16 ? 1 : 0, 1, 0, 0, 0, "", 10000, bundle2, z16, qzEditVideoPartManager.B0, qzEditVideoPartManager.H0, qzEditVideoPartManager.K0, false, bundle3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        boolean z16 = i3 == 4;
        this.E = z16;
        if (i3 == 0) {
            this.f66411f.setVisibility(this.f66409d.D0 ? 0 : 8);
            return;
        }
        if (i3 == 4) {
            this.f66411f.setVisibility((!this.f66409d.D0 || z16) ? 8 : 0);
        } else if (i3 != 5) {
            this.f66411f.setVisibility(8);
        } else {
            this.f66411f.setVisibility(8);
        }
    }

    private void o0(long j3) {
    }
}
