package com.qzone.publish.ui.activity;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.service.QzoneNewCardSkinService;
import com.qzone.publish.ui.controller.QZoneSyncBubbleController;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.util.ToastUtil;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.RedDotImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.mobileqq.qqexpand.utils.ICampusHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.Switch;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes39.dex */
public abstract class QZonePublishMoodBaseActivity extends PhotoActivity {

    /* renamed from: h6, reason: collision with root package name */
    public static Bundle f51439h6;
    public HashMap<String, String> A2;
    protected boolean A5;
    public View B2;
    protected boolean B5;
    public CheckBox C2;
    protected View C4;
    protected boolean C5;
    public View D2;
    protected RelativeLayout D4;
    public CheckBox E2;
    protected TextView E4;
    public View F2;
    protected TextView F4;
    public CheckBox G2;
    protected Switch G4;
    public CheckBox H2;
    public View I2;
    public ShuoshuoVideoInfo I4;
    public CheckBox J2;
    protected TextView J4;
    public View K2;
    protected Button K4;
    public View L2;
    protected com.qzone.publish.ui.model.e L4;
    public ImageView M2;
    protected long M4;
    protected boolean M5;
    public ImageView N2;
    public boolean N4;
    protected boolean N5;
    public TextView O2;
    public View O4;
    public FeedSkinData O5;
    public AsyncImageView P4;
    public boolean P5;
    public ArrayList<DynamicPhotoData> Q4;
    protected volatile boolean Q5;
    protected QQProgressDialog R5;
    protected int S2;
    protected ShuoshuoContent S4;
    protected boolean S5;
    public RelativeLayout T2;
    protected boolean T4;
    protected boolean T5;
    public ro.a U4;
    protected QbossAdvDesc U5;
    protected String V5;
    protected String W5;
    protected String X5;
    public com.qzone.publish.ui.state.a Y2;
    protected LinearLayout Y5;
    protected int Z2;
    protected ImageView Z5;

    /* renamed from: a3, reason: collision with root package name */
    protected RelativeLayout f51440a3;

    /* renamed from: a5, reason: collision with root package name */
    protected QZonePublishMoodTabActivity f51441a5;

    /* renamed from: a6, reason: collision with root package name */
    protected TextView f51442a6;

    /* renamed from: b3, reason: collision with root package name */
    protected View f51443b3;

    /* renamed from: b6, reason: collision with root package name */
    public final HashMap<String, Pair<String, String>> f51446b6;

    /* renamed from: c3, reason: collision with root package name */
    protected ImageView f51447c3;

    /* renamed from: c5, reason: collision with root package name */
    protected AsyncImageView f51448c5;

    /* renamed from: c6, reason: collision with root package name */
    protected String f51449c6;

    /* renamed from: d3, reason: collision with root package name */
    protected TextView f51450d3;

    /* renamed from: d4, reason: collision with root package name */
    protected View f51451d4;

    /* renamed from: d6, reason: collision with root package name */
    protected String f51453d6;

    /* renamed from: e6, reason: collision with root package name */
    private QZoneSyncBubbleController f51456e6;

    /* renamed from: f6, reason: collision with root package name */
    public String f51459f6;

    /* renamed from: g5, reason: collision with root package name */
    protected SharedPreferences f51461g5;

    /* renamed from: g6, reason: collision with root package name */
    TianShuGetAdvCallback f51462g6;

    /* renamed from: h3, reason: collision with root package name */
    protected View f51463h3;
    protected TextView i3;

    /* renamed from: k5, reason: collision with root package name */
    public View f51467k5;

    /* renamed from: l5, reason: collision with root package name */
    public View f51468l5;
    public String m3;

    /* renamed from: m5, reason: collision with root package name */
    protected MoodPicLabel f51469m5;
    public String n3;

    /* renamed from: n5, reason: collision with root package name */
    protected MoodPicLabel f51470n5;

    /* renamed from: o3, reason: collision with root package name */
    protected View f51471o3;

    /* renamed from: o5, reason: collision with root package name */
    public MoodPicLabel f51472o5;

    /* renamed from: p3, reason: collision with root package name */
    protected Switch f51473p3;

    /* renamed from: p4, reason: collision with root package name */
    protected AsyncImageView f51474p4;

    /* renamed from: p5, reason: collision with root package name */
    public MoodPicLabel f51475p5;

    /* renamed from: q5, reason: collision with root package name */
    protected MoodPicLabel f51477q5;

    /* renamed from: r4, reason: collision with root package name */
    protected TextView f51479r4;

    /* renamed from: r5, reason: collision with root package name */
    protected MoodPicLabel f51480r5;

    /* renamed from: s5, reason: collision with root package name */
    protected ImageView f51482s5;

    /* renamed from: t5, reason: collision with root package name */
    protected QbossAdvDesc f51485t5;

    /* renamed from: u2, reason: collision with root package name */
    public HashMap<String, PicInfo> f51486u2;

    /* renamed from: u5, reason: collision with root package name */
    protected ImageView f51487u5;

    /* renamed from: v2, reason: collision with root package name */
    protected ImageView f51488v2;

    /* renamed from: v5, reason: collision with root package name */
    public PublishEventTag f51489v5;

    /* renamed from: w2, reason: collision with root package name */
    protected ImageView f51490w2;

    /* renamed from: x2, reason: collision with root package name */
    protected RedDotImageView f51492x2;

    /* renamed from: y2, reason: collision with root package name */
    protected RedDotImageView f51495y2;

    /* renamed from: t2, reason: collision with root package name */
    private int f51483t2 = 293;

    /* renamed from: z2, reason: collision with root package name */
    protected boolean f51498z2 = false;
    public long P2 = -1;
    public long Q2 = -1;
    protected List<String> R2 = new ArrayList();
    public boolean U2 = true;
    protected long V2 = -1;
    protected long W2 = -1;
    protected boolean X2 = false;

    /* renamed from: e3, reason: collision with root package name */
    public long f51454e3 = 0;

    /* renamed from: f3, reason: collision with root package name */
    public long f51457f3 = 0;

    /* renamed from: g3, reason: collision with root package name */
    public long f51460g3 = 0;
    protected String j3 = com.qzone.feed.utils.h.f(1);
    public int k3 = 1;
    public ArrayList<String> l3 = null;

    /* renamed from: q3, reason: collision with root package name */
    public int f51476q3 = 30;

    /* renamed from: r3, reason: collision with root package name */
    boolean f51478r3 = false;

    /* renamed from: s3, reason: collision with root package name */
    boolean f51481s3 = false;

    /* renamed from: t3, reason: collision with root package name */
    public boolean f51484t3 = false;

    /* renamed from: x3, reason: collision with root package name */
    boolean f51493x3 = false;

    /* renamed from: y3, reason: collision with root package name */
    boolean f51496y3 = false;

    /* renamed from: b4, reason: collision with root package name */
    public boolean f51444b4 = false;
    protected boolean H4 = false;
    protected ArrayList<LocalMediaInfo> R4 = new ArrayList<>();
    public boolean V4 = false;
    public boolean W4 = false;
    public boolean X4 = false;
    public boolean Y4 = false;
    public boolean Z4 = false;

    /* renamed from: b5, reason: collision with root package name */
    public boolean f51445b5 = false;

    /* renamed from: d5, reason: collision with root package name */
    protected String f51452d5 = null;

    /* renamed from: e5, reason: collision with root package name */
    protected boolean f51455e5 = false;

    /* renamed from: f5, reason: collision with root package name */
    protected boolean f51458f5 = false;

    /* renamed from: h5, reason: collision with root package name */
    public boolean f51464h5 = false;

    /* renamed from: i5, reason: collision with root package name */
    public boolean f51465i5 = false;

    /* renamed from: j5, reason: collision with root package name */
    protected boolean f51466j5 = false;

    /* renamed from: w5, reason: collision with root package name */
    protected boolean f51491w5 = false;

    /* renamed from: x5, reason: collision with root package name */
    protected boolean f51494x5 = false;

    /* renamed from: y5, reason: collision with root package name */
    protected boolean f51497y5 = false;

    /* renamed from: z5, reason: collision with root package name */
    protected String f51499z5 = "";
    public StringBuilder D5 = new StringBuilder();
    protected int E5 = 0;
    protected boolean F5 = false;
    public boolean G5 = false;
    protected boolean H5 = false;
    protected boolean I5 = false;
    String J5 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionWhiteList", "\u90e8\u5206\u597d\u53cb\u53ef\u89c1");
    String K5 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionBlackList", "\u90e8\u5206\u597d\u53cb\u4e0d\u53ef\u89c1");
    protected boolean L5 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements QZoneSyncBubbleController.a {
        a() {
        }

        @Override // com.qzone.publish.ui.controller.QZoneSyncBubbleController.a
        public void a() {
            QZonePublishMoodBaseActivity.this.fn();
        }

        @Override // com.qzone.publish.ui.controller.QZoneSyncBubbleController.a
        public void b(String str, String str2, String str3) {
            QZonePublishMoodBaseActivity.this.zn(str, str2, str3);
        }
    }

    /* loaded from: classes39.dex */
    class b implements TianShuGetAdvCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            TianShuAccess.AdPlacementInfo adPlacementInfo;
            if (QZLog.isColorLevel()) {
                QZLog.i(BaseFragment.TAG, "onGetAdvs isSucc:" + z16);
            }
            if (!z16 || getAdsRsp == null) {
                return;
            }
            List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.has() ? getAdsRsp.mapAds.get() : null;
            if (list == null) {
                QZLog.e(BaseFragment.TAG, "rspEntries == null");
                return;
            }
            HashMap hashMap = new HashMap();
            for (TianShuAccess.RspEntry rspEntry : list) {
                if (rspEntry != null && rspEntry.key.has()) {
                    hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
                }
            }
            TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(QZonePublishMoodBaseActivity.this.f51483t2));
            if (rspEntry2 != null && (adPlacementInfo = rspEntry2.value) != null && adPlacementInfo.lst.size() != 0 && rspEntry2.value.lst.get(0) != null && rspEntry2.value.lst.get(0).argList != null && rspEntry2.value.lst.get(0).argList.get() != null) {
                List<TianShuAccess.MapEntry> list2 = rspEntry2.value.lst.get(0).argList.get();
                HashMap hashMap2 = new HashMap();
                for (TianShuAccess.MapEntry mapEntry : list2) {
                    String str = mapEntry.key.get();
                    String str2 = mapEntry.value.get();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        hashMap2.put(str, str2);
                    }
                }
                if (hashMap2.size() > 0) {
                    String str3 = (String) hashMap2.get("text");
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    LocalMultiProcConfig.putString4Uin("kuoliehint_text", str3, LoginData.getInstance().getUin());
                    QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = QZonePublishMoodBaseActivity.this;
                    ExtendEditText extendEditText = qZonePublishMoodBaseActivity.f45104j0;
                    if (extendEditText == null || !qZonePublishMoodBaseActivity.F1) {
                        return;
                    }
                    extendEditText.setHint(str3);
                    return;
                }
                return;
            }
            QZLog.e(BaseFragment.TAG, "data is error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(84, 22, 2), false, false);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ((ICampusHelper) QRoute.api(ICampusHelper.class)).jumpToSchoolFillInWebPage(QZonePublishMoodBaseActivity.this.getActivity(), "");
        }
    }

    public QZonePublishMoodBaseActivity() {
        this.M5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_MOOD_SCHEDULE_DELETE_VIDEO, 1) > 0;
        this.N5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_MOOD_SCHEDULE_PUBLISH_VIDEO, 1) > 0;
        this.P5 = false;
        this.Q5 = false;
        this.S5 = false;
        this.T5 = false;
        this.U5 = null;
        this.V5 = "";
        this.W5 = "";
        this.X5 = "";
        this.f51446b6 = new HashMap<>();
        this.f51449c6 = "0";
        this.f51453d6 = "sync=1";
        this.f51462g6 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        View view = this.L2;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.L2.startAnimation((AnimationSet) AnimationUtils.loadAnimation(getActivity(), Rm()));
        an().e();
        an().j(true);
    }

    private void Cn() {
        View view = this.L2;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(getActivity(), Tm());
        animationSet.setAnimationListener(new h());
        this.L2.startAnimation(animationSet);
    }

    private void qn() {
        this.J2.setChecked(false);
        fn();
    }

    public abstract void An();

    public abstract void Dn();

    public abstract void En(long j3);

    public void Fn(boolean z16) {
        QZLog.d("[PhotoAlbum]" + BaseFragment.TAG, 1, "updateSyncWezoneIcon... isHasSelectedVideo:", Boolean.valueOf(z16), " size:", Integer.valueOf(this.U.size()));
        CheckBox checkBox = this.J2;
        if (checkBox == null) {
            return;
        }
        if (!this.Y4) {
            checkBox.setVisibility(8);
            return;
        }
        if (this.f51457f3 <= 0 && this.f51460g3 <= 0) {
            if (this.U.size() == 0) {
                qn();
                this.J2.setVisibility(8);
                return;
            }
            if (jn()) {
                qn();
                this.J2.setVisibility(8);
                return;
            }
            if (z16 && this.U.size() > 1) {
                qn();
                this.J2.setVisibility(8);
                return;
            }
            if (!z16 && this.U.size() > 9) {
                qn();
                this.J2.setVisibility(8);
                return;
            } else if (getShowType() == 1) {
                qn();
                this.J2.setVisibility(8);
                return;
            } else {
                LpReportInfo_pf00064.allReport(586, 51, 1);
                this.J2.setVisibility(0);
                this.J2.setChecked(this.f51444b4);
                an().a(new a());
                return;
            }
        }
        qn();
        this.J2.setVisibility(8);
    }

    public abstract void Gn(boolean z16);

    public abstract void Pm();

    public abstract void Qm();

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ri(Intent intent) {
        intent.putExtra(WinkPreviewFragment.ENTRY_FROM, 1);
    }

    protected abstract int Rm();

    public abstract String Sm();

    protected abstract int Tm();

    public abstract String Um();

    public abstract HashMap<String, PicInfo> Vm();

    public abstract void Wm();

    public abstract String Xm();

    public abstract ShuoshuoVideoInfo Ym();

    /* JADX INFO: Access modifiers changed from: protected */
    public int Zm() {
        if (QZoneJsConstants.SHARE_SOURCE_TYPE_MSGTAB_CAMERA.equals(this.V5)) {
            return 6;
        }
        ro.a aVar = this.U4;
        if (aVar != null && aVar.b() != null) {
            String b16 = this.U4.b();
            if ("shuoshuoPlus".equals(b16)) {
                return 1;
            }
            if ("shuoshuoList".equals(b16)) {
                return 2;
            }
            if ("shuoshuoFeeds".equals(b16)) {
                return 3;
            }
            if ("shuoshuoFeedsBubble".equals(b16)) {
                return 4;
            }
            if ("shuoshuoFeedsBanner".equals(b16)) {
                return 8;
            }
            if ("shuoshuoPlusUserHome".equals(b16)) {
                return 9;
            }
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QZoneSyncBubbleController an() {
        if (this.f51456e6 == null) {
            this.f51456e6 = new QZoneSyncBubbleController();
        }
        return this.f51456e6;
    }

    public void bn() {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 293;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, this.f51462g6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cn() {
        if (TextUtils.isEmpty(LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOLNAME, "", LoginData.getInstance().getUin()))) {
            xn();
            return;
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(84, 21, 2), false, false);
        int i3 = this.k3;
        if (i3 != 1 && i3 != 128 && !this.f51493x3) {
            yn();
            return;
        }
        if (!this.f51493x3) {
            wn();
        }
        boolean z16 = !this.f51493x3;
        this.f51493x3 = z16;
        if (z16) {
            ToastUtil.s("\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230\u6269\u5217", -1);
        } else {
            ToastUtil.s("\u5df2\u53d6\u6d88\u540c\u6b65\u6269\u5217", -1);
        }
        this.E2.setChecked(this.f51493x3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Xj()) {
            MobileReportManager.getInstance().reportAction("qzone_pri", "2", "10", 144, 1, currentTimeMillis);
        }
        if (Yj()) {
            MobileReportManager.getInstance().reportAction("qzone_pri", "2", "11", 144, 1, currentTimeMillis);
        }
        if (QzoneNewCardSkinService.F().G() != null) {
            MobileReportManager.getInstance().reportAction("qzone_pri", "2", "14", 144, 1, currentTimeMillis);
        }
    }

    public abstract void en(boolean z16);

    public void fn() {
        Cn();
    }

    public abstract void gn();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hn() {
        this.f51449c6 = LocalMultiProcConfig.getString4Uin(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_RENZHENHAO, "0", LoginData.getInstance().getUin());
        return !"0".equals(r0);
    }

    public boolean jn() {
        if (this.U == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            if (o7.b.b(this.U.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public boolean kn() {
        if (this.U != null && this.W != null) {
            for (int i3 = 0; i3 < this.U.size(); i3++) {
                LocalMediaInfo localMediaInfo = this.W.get(this.U.get(i3));
                if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                    QZLog.d(BaseFragment.TAG, 2, "has normal video");
                    return true;
                }
                HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
                if (hashMap != null && hashMap.containsKey(this.U.get(i3))) {
                    QZLog.d(BaseFragment.TAG, 2, "has record video");
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ln() {
        if (this.C4 == null || this.F4 == null || !QQTheme.isNowThemeIsNightForQzone()) {
            return;
        }
        this.C4.setBackgroundColor(-16777216);
        this.F4.setTextColor(-1);
    }

    public abstract void mn(boolean z16);

    public abstract void nn();

    public abstract void on();

    @Override // com.qzone.common.activities.base.PhotoActivity, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.qzone.business.tianshu.o.i().a();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QZoneSyncBubbleController qZoneSyncBubbleController = this.f51456e6;
        if (qZoneSyncBubbleController != null) {
            qZoneSyncBubbleController.g();
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        fn();
    }

    public abstract void pn(boolean z16);

    public abstract void rn();

    protected abstract void sn();

    public abstract void tn(String str);

    public abstract void un(ShuoshuoVideoInfo shuoshuoVideoInfo);

    public void vn() {
        an().k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean wk() {
        return true;
    }

    public void wn() {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("kuoliedialogshow", 0, LoginData.getInstance().getUin());
        if (int4Uin >= 2) {
            return;
        }
        LocalMultiProcConfig.putInt4Uin("kuoliedialogshow", int4Uin + 1, LoginData.getInstance().getUin());
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(84, 22, 1), false, false);
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getString(R.string.cal)).setPositiveButton(getString(R.string.cak), new c());
        positiveButton.setTitleMutiLine();
        positiveButton.show();
    }

    public void xn() {
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getString(R.string.f168072en)).setPositiveButton(getString(R.string.f168082eo), new e()).setNegativeButton(getString(R.string.w5w), new d());
        negativeButton.setTitleMutiLine();
        negativeButton.show();
    }

    public void zn(final String str, final String str2, final String str3) {
        CheckBox checkBox = this.J2;
        if (checkBox == null || checkBox.getVisibility() == 8 || str2 == null || str3 == null) {
            return;
        }
        this.J2.post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity.8

            /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity$8$a */
            /* loaded from: classes39.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    QZonePublishMoodBaseActivity.this.fn();
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = QZonePublishMoodBaseActivity.this;
                if (qZonePublishMoodBaseActivity.f51440a3 != null && qZonePublishMoodBaseActivity.J2 != null && qZonePublishMoodBaseActivity.N2 != null && qZonePublishMoodBaseActivity.O2 != null) {
                    qZonePublishMoodBaseActivity.sn();
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = QZonePublishMoodBaseActivity.this.N2.getLayoutParams().width;
                    obtain.mRequestHeight = QZonePublishMoodBaseActivity.this.N2.getLayoutParams().height;
                    QZonePublishMoodBaseActivity.this.N2.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
                    QZonePublishMoodBaseActivity.this.O2.setText(str);
                    QZonePublishMoodBaseActivity.this.O2.measure(0, 0);
                    ViewGroup.LayoutParams layoutParams = QZonePublishMoodBaseActivity.this.M2.getLayoutParams();
                    layoutParams.width = QZonePublishMoodBaseActivity.this.O2.getMeasuredWidth();
                    QZonePublishMoodBaseActivity.this.M2.setLayoutParams(layoutParams);
                    URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                    obtain2.mRequestWidth = layoutParams.width;
                    obtain2.mRequestHeight = layoutParams.height;
                    QZonePublishMoodBaseActivity.this.M2.setImageDrawable(URLDrawable.getDrawable(str3, obtain2));
                    QZonePublishMoodBaseActivity.this.getHandler().postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePublishMoodBaseActivity.this.Bn();
                        }
                    }, 800L);
                    QZonePublishMoodBaseActivity.this.L2.setOnClickListener(new a());
                    return;
                }
                QLog.e(BaseFragment.TAG, 1, "showSyncQCircleBubble error: view is null");
            }
        });
    }

    public boolean in(boolean z16) {
        return z16 && !this.N5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(84, 53, 2);
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = QZonePublishMoodBaseActivity.this;
            qZonePublishMoodBaseActivity.k3 = 1;
            qZonePublishMoodBaseActivity.n3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionPublic", PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL);
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity2 = QZonePublishMoodBaseActivity.this;
            qZonePublishMoodBaseActivity2.f51493x3 = true;
            qZonePublishMoodBaseActivity2.E2.setChecked(true);
            QZonePublishMoodBaseActivity.this.Pm();
            if (QZonePublishMoodBaseActivity.this.f51493x3) {
                ToastUtil.s("\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230\u6269\u5217", -1);
            } else {
                ToastUtil.s("\u5df2\u53d6\u6d88\u540c\u6b65\u6269\u5217", -1);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(84, 53, 2);
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = QZonePublishMoodBaseActivity.this;
            qZonePublishMoodBaseActivity.f51493x3 = false;
            qZonePublishMoodBaseActivity.E2.setChecked(false);
            QZonePublishMoodBaseActivity.this.Pm();
            if (QZonePublishMoodBaseActivity.this.f51493x3) {
                ToastUtil.s("\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230\u6269\u5217", -1);
            } else {
                ToastUtil.s("\u5df2\u53d6\u6d88\u540c\u6b65\u6269\u5217", -1);
            }
            dialogInterface.dismiss();
        }
    }

    public void yn() {
        LpReportInfo_pf00064.allReport(84, 53, 1);
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getString(R.string.w1t)).setNegativeButton(getString(R.string.gmu), new g()).setPositiveButton(getString(R.string.w1u), new f());
        positiveButton.setTitleMutiLine();
        positiveButton.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements Animation.AnimationListener {
        h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = QZonePublishMoodBaseActivity.this.L2;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Pk() {
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void ni() {
    }
}
