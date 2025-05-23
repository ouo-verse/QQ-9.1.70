package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.ExtendEditText;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends u implements View.OnClickListener {
    private View C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private QzoneEditPicturePartManager f66439d;

    /* renamed from: e, reason: collision with root package name */
    private String f66440e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f66441f;

    /* renamed from: h, reason: collision with root package name */
    private CheckBox f66442h;

    /* renamed from: i, reason: collision with root package name */
    private ExtendEditText f66443i;

    /* renamed from: m, reason: collision with root package name */
    private Button f66444m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            e.this.f66439d.D0 = z16;
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public e(QzoneEditPicturePartManager qzoneEditPicturePartManager) {
        super(qzoneEditPicturePartManager);
        this.f66440e = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(1);
        this.D = 0;
        this.f66439d = qzoneEditPicturePartManager;
    }

    public static boolean l0(int i3) {
        if (i3 != 16 && i3 != 128) {
            return false;
        }
        return true;
    }

    private void o0() {
        Typeface createFromFile;
        ExtendEditText extendEditText = this.f66443i;
        if (extendEditText == null) {
            return;
        }
        extendEditText.setTextEffect(this.f66439d.M0);
        String trueTypeFont = ((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(this.f66439d.I0, null, null, true, null);
        if (TextUtils.isEmpty(trueTypeFont)) {
            this.f66439d.I0 = -1;
            createFromFile = null;
        } else {
            createFromFile = Typeface.createFromFile(trueTypeFont);
        }
        this.f66443i.setTypeface(createFromFile);
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a4, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
    
        if (r9 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String k0(String str) {
        String str2 = "";
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + str), null, "uin=?", new String[]{str}, null);
                if (cursor != null && cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    if (!TextUtils.isEmpty(string)) {
                        str2 = SecurityUtile.decode(new String(string.getBytes(), "utf-8"));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("EditPicQzComment", 2, "getNickName by ContentProvider success, name =" + str2);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EditPicQzComment", 2, "getNickName by ContentProvider  Exception, trace=" + QLog.getStackTraceString(e16));
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
                QLog.d("EditPicQzComment", 2, "onActivityResult:requestCode=" + i3 + "  resultCode=" + i16);
            }
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                this.f66439d.f66353z0 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
            }
            if (extras.containsKey("uin_list")) {
                QzoneEditPicturePartManager qzoneEditPicturePartManager = this.f66439d;
                if (qzoneEditPicturePartManager.f66352y0 == null) {
                    qzoneEditPicturePartManager.f66352y0 = new ArrayList<>();
                }
                this.f66439d.f66352y0.clear();
                ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
                if (stringArrayList != null) {
                    this.f66439d.f66352y0.addAll(stringArrayList);
                }
            }
            if (l0(this.f66439d.f66353z0)) {
                this.f66439d.B0 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                this.f66439d.A0 = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
            }
            p0();
            return;
        }
        if (i3 == 1009) {
            View view = this.f66439d.f66351x0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            Bundle extras2 = intent.getExtras();
            if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY) && (bundle = extras2.getBundle(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY)) != null) {
                this.f66439d.f66353z0 = bundle.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                QzoneEditPicturePartManager qzoneEditPicturePartManager2 = this.f66439d;
                if (qzoneEditPicturePartManager2.f66352y0 == null) {
                    qzoneEditPicturePartManager2.f66352y0 = new ArrayList<>();
                }
                this.f66439d.f66352y0.clear();
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("uin_list");
                if (stringArrayList2 != null) {
                    this.f66439d.f66352y0.addAll(stringArrayList2);
                }
                if (l0(this.f66439d.f66353z0)) {
                    this.f66439d.B0 = bundle.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                    this.f66439d.A0 = bundle.getString(UgcSettingUtil.KEY_TAG_INFO);
                }
                p0();
            }
            if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE)) {
                this.f66442h.setChecked(extras2.getBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE));
            }
            if (extras2.containsKey("contentIntentKey")) {
                String string = extras2.getString("contentIntentKey");
                if (string == null) {
                    string = "";
                }
                this.f66439d.C0 = string;
            }
            if (extras2.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO)) {
                this.f66443i.setText(extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO));
            }
            this.f66439d.I0 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1);
            this.f66439d.J0 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE);
            this.f66439d.K0 = extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
            this.f66439d.L0 = extras2.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, -1);
            this.f66439d.M0 = extras2.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
            o0();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f66441f = (RelativeLayout) findViewSure(R.id.cdy);
        this.f66442h = (CheckBox) findViewSure(R.id.cfa);
        this.f66443i = (ExtendEditText) findViewSure(R.id.cdz);
        this.f66444m = (Button) findViewSure(R.id.cf5);
        this.C = findViewSure(R.id.cf_);
        this.f66443i.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        this.f66443i.setOnClickListener(this);
        this.f66444m.setOnClickListener(this);
        if (!this.f66439d.H0) {
            this.f66444m.setVisibility(8);
        }
        QzoneEditPicturePartManager qzoneEditPicturePartManager = this.f66439d;
        if (qzoneEditPicturePartManager.E0 || qzoneEditPicturePartManager.G0) {
            this.f66444m.setVisibility(8);
            this.f66442h.setVisibility(0);
            this.f66442h.setOnCheckedChangeListener(new a());
            this.f66442h.setChecked(true);
        }
        if (m0(QQStoryContext.h().d())) {
            o0();
        }
    }

    public void p0() {
        String privacyDescriptionForShuoShuo = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(this.f66439d.f66353z0);
        this.f66440e = privacyDescriptionForShuoShuo;
        this.f66444m.setText(privacyDescriptionForShuoShuo);
    }

    private boolean m0(String str) {
        try {
            long longValue = Long.valueOf(str).longValue();
            n0(longValue);
            DefaultFontInfo defaultFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultFont(longValue);
            if (defaultFont == null) {
                return false;
            }
            QzoneEditPicturePartManager qzoneEditPicturePartManager = this.f66439d;
            int i3 = defaultFont.fontId;
            qzoneEditPicturePartManager.I0 = i3;
            qzoneEditPicturePartManager.J0 = defaultFont.formatType;
            qzoneEditPicturePartManager.K0 = defaultFont.fontUrl;
            return i3 > 0;
        } catch (Throwable th5) {
            QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + th5.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mAnimationEndTime <= System.currentTimeMillis()) {
            int id5 = view.getId();
            if (id5 == R.id.cf5) {
                String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, QZoneHelper.Constants.UGC_PERMIT_SETTING_PAGE).replace("{uin}", QQStoryContext.h().d()).replace("{qua}", QUA.getQUA3());
                ((QzoneEditPicturePartManager) this.mParent).K1(3004);
                Bundle bundle = new Bundle();
                bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f66439d.f66353z0);
                ArrayList<String> arrayList = this.f66439d.f66352y0;
                if (arrayList != null && arrayList.size() > 0) {
                    bundle.putStringArrayList("uin_list", this.f66439d.f66352y0);
                    ArrayList<String> arrayList2 = new ArrayList<>(this.f66439d.f66352y0.size());
                    Iterator<String> it = this.f66439d.f66352y0.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(k0(it.next()));
                    }
                    bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
                }
                if (l0(this.f66439d.f66353z0) && !TextUtils.isEmpty(this.f66439d.B0)) {
                    bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f66439d.B0);
                }
                QZoneHelper.forwardToBrowser((BaseActivity) this.mUi, replace, 1, bundle, "");
            } else if (id5 == R.id.cdz) {
                ((QzoneEditPicturePartManager) this.mParent).K1(3001);
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                Bundle bundle2 = new Bundle();
                bundle2.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f66439d.f66353z0);
                ArrayList<String> arrayList3 = this.f66439d.f66352y0;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    bundle2.putStringArrayList("uin_list", this.f66439d.f66352y0);
                    ArrayList<String> arrayList4 = new ArrayList<>(this.f66439d.f66352y0.size());
                    Iterator<String> it5 = this.f66439d.f66352y0.iterator();
                    while (it5.hasNext()) {
                        arrayList4.add(k0(it5.next()));
                    }
                    bundle2.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList4);
                }
                if (l0(this.f66439d.f66353z0) && !TextUtils.isEmpty(this.f66439d.B0)) {
                    bundle2.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f66439d.B0);
                }
                View view2 = this.f66439d.f66351x0;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean(QZoneHelper.QzoneFeedActionPanelConstants.KEY_AT_CLICK_HIDE_KEYBOARD, true);
                BaseActivity baseActivity = (BaseActivity) this.mUi;
                QzoneEditPicturePartManager qzoneEditPicturePartManager = this.f66439d;
                String str = qzoneEditPicturePartManager.C0;
                boolean z16 = qzoneEditPicturePartManager.E0;
                QZoneHelper.forwardToVideoEditActionPanel(baseActivity, userInfo, 1009, "", str, "", "", 0, !z16 ? 1 : 0, 1, 0, 0, 0, "", 10000, bundle2, z16, qzoneEditPicturePartManager.D0, qzoneEditPicturePartManager.I0, qzoneEditPicturePartManager.L0, true, bundle3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 == 0) {
            this.f66441f.setVisibility(this.f66439d.F0 ? 0 : 8);
            return;
        }
        if (i3 == 4) {
            this.f66441f.setVisibility(8);
        } else if (i3 != 5) {
            this.f66441f.setVisibility(8);
        } else {
            this.f66441f.setVisibility(8);
        }
    }

    private void n0(long j3) {
    }
}
