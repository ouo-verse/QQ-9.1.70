package em;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.core.content.ContextCompat;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.reborn.base.k;
import com.qzone.reborn.part.publish.mood.imageai.f;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.util.l;
import com.qzone.util.ar;
import com.qzone.widget.MoodPicLabel;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import fo.c;
import hm.b;
import java.util.HashMap;
import rn.h;
import yo.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends k implements View.OnClickListener, IObserver.main {
    protected MoodPicLabel C;
    public MoodPicLabel D;
    private b E;
    private QZonePublishMoodInitBean F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private final QZonePublishMoodNewStyleActivity f396576d;

    /* renamed from: e, reason: collision with root package name */
    private fm.b f396577e;

    /* renamed from: f, reason: collision with root package name */
    private MoodPicLabel f396578f;

    /* renamed from: h, reason: collision with root package name */
    private MoodPicLabel f396579h;

    /* renamed from: i, reason: collision with root package name */
    private View f396580i;

    /* renamed from: m, reason: collision with root package name */
    private View f396581m;

    public a(QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity) {
        this.f396576d = qZonePublishMoodNewStyleActivity;
    }

    private void C9() {
        if (this.f396579h == null || this.f396578f == null) {
            return;
        }
        int l3 = ar.l() - ar.d(280.0f);
        String c16 = this.f396579h.c();
        String c17 = this.f396578f.c();
        float textSize = this.f396579h.b().getTextSize();
        int l16 = ar.l() / 5;
        int q16 = ar.q(textSize, c16);
        int q17 = ar.q(textSize, c17);
        if (q16 + q17 > l3) {
            int max = Math.max(l3 - q17, l16);
            this.f396579h.b().setMaxWidth(max);
            MoodPicLabel moodPicLabel = this.C;
            if (moodPicLabel != null) {
                moodPicLabel.b().setMaxWidth(max);
                return;
            }
            return;
        }
        int i3 = (int) (textSize * 6.0f);
        this.f396579h.b().setMaxWidth(i3);
        MoodPicLabel moodPicLabel2 = this.C;
        if (moodPicLabel2 != null) {
            moodPicLabel2.b().setMaxWidth(i3);
        }
    }

    private boolean E9() {
        return !this.f396577e.T1();
    }

    private PublishEventTag F9(Intent intent) {
        cooperation.qzone.model.PublishEventTag publishEventTag = (cooperation.qzone.model.PublishEventTag) intent.getParcelableExtra(QZoneShareManager.QZONE_SHARE_EVENT_TAG);
        if (publishEventTag == null) {
            return null;
        }
        PublishEventTag publishEventTag2 = new PublishEventTag();
        publishEventTag2.f45886id = publishEventTag.f390868id;
        publishEventTag2.title = publishEventTag.title;
        publishEventTag2.picUrl = publishEventTag.picUrl;
        publishEventTag2.f45887protocol = publishEventTag.f390869protocol;
        publishEventTag2.desc = publishEventTag.desc;
        String str = publishEventTag.truncateNum;
        if (str != null) {
            publishEventTag2.descTruncateNum = Integer.valueOf(str).intValue();
        }
        return publishEventTag2;
    }

    private PublishEventTag G9(Intent intent) {
        PublishEventTag t16 = l.f59550a.t(this.F, intent);
        if (t16 == null) {
            t16 = F9(intent);
        }
        if (t16 == null) {
            t16 = u5.b.b0("_shuoshuo", LoginData.getInstance().getUin());
        }
        return t16 == null ? H9(intent) : t16;
    }

    private PublishEventTag H9(Intent intent) {
        l lVar = l.f59550a;
        String E = lVar.E(this.F, intent);
        String F = lVar.F(this.F, intent);
        String f16 = lVar.f(this.F, intent);
        String D = lVar.D(this.F, intent);
        if (TextUtils.isEmpty(E)) {
            return null;
        }
        if (!TextUtils.isEmpty(D)) {
            PublishEventTag publishEventTag = new PublishEventTag();
            publishEventTag.title = E;
            publishEventTag.uin = F;
            publishEventTag.f45887protocol = D;
            publishEventTag.advId = f16;
            return publishEventTag;
        }
        if (TextUtils.isEmpty(F)) {
            return null;
        }
        PublishEventTag assembleFakeTag = PublishEventTag.assembleFakeTag(E, F);
        if (assembleFakeTag == null) {
            return assembleFakeTag;
        }
        assembleFakeTag.advId = f16;
        return assembleFakeTag;
    }

    private void N9() {
        if (this.f396579h == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("default_tag_name", this.f396579h.c());
        fo.b l3 = new fo.b().l(hashMap);
        l3.g(ClickPolicy.REPORT_NONE);
        c.b("dt_clck", this.f396579h, "em_qz_add_tag", l3);
    }

    private void Q9() {
        if (this.f396581m != null) {
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = this.f396576d;
            if (!qZonePublishMoodNewStyleActivity.f45131t0 && !qZonePublishMoodNewStyleActivity.f45135v0 && D9()) {
                this.f396581m.setVisibility(0);
                return;
            }
        }
        View view = this.f396581m;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void I9() {
        String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_MOOD_EVENT_TAG_JUMP_PAGE, QzoneConfig.QZONE_MOOD_EVENT_TAG_H5_URL, QzoneConfig.DefaultValue.QZONE_MOOD_ADD_EVENT_TAG_PAGE_H5_URL_DEFAULT).replace("{hostuin}", String.valueOf(LoginData.getInstance().getUin()));
        PublishEventTag value = this.E.O1().getValue();
        if (value != null) {
            if (!TextUtils.isEmpty(value.f45886id)) {
                replace = replace + "&tagid=" + value.f45886id;
            } else {
                replace = replace + "&tagid=0";
            }
        }
        d.d(replace, getActivity(), null);
    }

    public void J9() {
        I9();
        LpReportInfo_pf00064.allReport(586, 25);
        if (!this.G) {
            this.f396576d.D5.append(3);
            this.G = true;
        }
        N9();
    }

    protected void O9(String str) {
        QZLog.d("QZonePublishMoodLocTagPart", 1, "setLocationInfo locationInfo:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(BaseApplication.getContext().getString(R.string.f173025gk1)) && !str.equals(BaseApplication.getContext().getString(R.string.f173026gk2))) {
            MoodPicLabel moodPicLabel = this.f396578f;
            if (moodPicLabel != null) {
                moodPicLabel.setCheck(true);
                this.f396578f.setVisibility(0);
                this.f396578f.b().setTextColor(BaseApplication.getContext().getColor(R.color.qui_common_text_primary));
                h.a(this.f396578f.a(), "qui_position", R.color.qui_common_brand_standard);
            }
            MoodPicLabel moodPicLabel2 = this.D;
            if (moodPicLabel2 != null) {
                moodPicLabel2.setCheck(true);
                this.D.setVisibility(0);
                this.D.b().setTextColor(BaseApplication.getContext().getColor(R.color.qui_common_text_primary));
                h.a(this.D.a(), "qui_position", R.color.qui_common_brand_standard);
            }
            this.E.P1().postValue(str);
        } else {
            str = BaseApplication.getContext().getString(R.string.f173026gk2);
            MoodPicLabel moodPicLabel3 = this.f396578f;
            if (moodPicLabel3 != null) {
                moodPicLabel3.setCheck(false);
                this.f396578f.b().setTextColor(BaseApplication.getContext().getColor(R.color.qui_common_text_secondary));
                h.a(this.f396578f.a(), "qui_position", R.color.qui_common_icon_secondary);
            }
            MoodPicLabel moodPicLabel4 = this.D;
            if (moodPicLabel4 != null) {
                moodPicLabel4.setCheck(false);
                this.D.b().setTextColor(BaseApplication.getContext().getColor(R.color.qui_common_text_secondary));
                h.a(this.D.a(), "qui_position", R.color.qui_common_icon_secondary);
            }
            this.E.P1().postValue(null);
        }
        MoodPicLabel moodPicLabel5 = this.f396578f;
        if (moodPicLabel5 != null) {
            moodPicLabel5.setText(str);
        }
        MoodPicLabel moodPicLabel6 = this.D;
        if (moodPicLabel6 != null) {
            moodPicLabel6.setText(str);
        }
        C9();
    }

    public void P9(PublishEventTag publishEventTag) {
        String config;
        boolean z16 = true;
        QZLog.d("QZonePublishMoodLocTagPart", 1, "showEventTag");
        if (publishEventTag != null && !TextUtils.isEmpty(publishEventTag.title)) {
            config = publishEventTag.title;
        } else {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleEventTagActivity", "\u6dfb\u52a0\u6807\u7b7e");
            publishEventTag = null;
            z16 = false;
        }
        this.E.O1().postValue(publishEventTag);
        this.f396579h.setText(config);
        this.f396579h.setCheck(z16);
        int i3 = z16 ? R.color.qui_common_brand_standard : R.color.qui_common_icon_secondary;
        int color = ContextCompat.getColor(BaseApplication.getContext(), z16 ? R.color.qui_common_text_primary : R.color.qui_common_text_secondary);
        this.f396579h.b().setTextColor(color);
        h.a(this.f396579h.a(), "qui_label", i3);
        MoodPicLabel moodPicLabel = this.C;
        if (moodPicLabel != null) {
            moodPicLabel.setText(config);
            this.C.setCheck(z16);
            this.C.b().setTextColor(color);
            h.a(this.C.a(), "qui_label", i3);
        }
        if (z16) {
            this.f396579h.setVisibility(0);
            MoodPicLabel moodPicLabel2 = this.C;
            if (moodPicLabel2 != null) {
                moodPicLabel2.setVisibility(0);
            }
        }
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishMoodLocTagPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (!TextUtils.equals(str, "hide_bottom_lab_bar") && !TextUtils.equals(str, "keyboard_hide")) {
            if (TextUtils.equals(str, "input_menu_open")) {
                Q9();
                return;
            } else if (TextUtils.equals(str, "location_select")) {
                O9((String) obj);
                return;
            } else {
                if (TextUtils.equals(str, "add_tag_click")) {
                    J9();
                    return;
                }
                return;
            }
        }
        View view = this.f396581m;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != this.f396579h && view != this.C) {
            if (view == this.f396578f || view == this.D) {
                this.f396576d.wp(view);
            }
        } else {
            J9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        L9(view);
        K9(view);
        PublishEventTag G9 = G9(getActivity().getIntent());
        if (G9 != null) {
            P9(G9);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f396577e = (fm.b) getViewModel(fm.b.class);
        this.E = (b) getViewModel(b.class);
        M9(activity);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 63);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 64);
    }

    private boolean D9() {
        int[] iArr = new int[2];
        this.f396580i.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.f396576d.getRoot().getLocationInWindow(iArr2);
        int height = this.f396576d.getRoot().getHeight();
        int height2 = this.f396580i.getHeight();
        int height3 = this.f396576d.f45125q0.getHeight();
        if (height3 == 0) {
            height3 = this.f396576d.f45125q0.getMeasuredHeight();
        }
        if ((iArr[1] + height2) - ((f.b() && f.f58673a.g()) ? ar.e(50.0f) : 0) > (iArr2[1] + height) - height3) {
            return E9();
        }
        return false;
    }

    private void M9(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        Intent intent = activity.getIntent();
        if (intent.getParcelableExtra("qzone_route_bean") instanceof QZonePublishMoodInitBean) {
            this.F = (QZonePublishMoodInitBean) intent.getParcelableExtra("qzone_route_bean");
        }
    }

    private void K9(View view) {
        View inflate = ((ViewStub) view.findViewById(R.id.f69233i7)).inflate();
        this.f396581m = inflate;
        MoodPicLabel moodPicLabel = (MoodPicLabel) inflate.findViewById(R.id.f0y);
        this.C = moodPicLabel;
        if (moodPicLabel != null) {
            h.a(moodPicLabel.a(), "qui_label", R.color.qui_common_icon_secondary);
            this.C.setVisibility(8);
            this.C.setOnClickListener(this);
        }
        MoodPicLabel moodPicLabel2 = (MoodPicLabel) this.f396581m.findViewById(R.id.f166324f10);
        this.D = moodPicLabel2;
        if (moodPicLabel2 != null) {
            moodPicLabel2.setVisibility(8);
            this.D.setOnClickListener(this);
        }
    }

    private void L9(View view) {
        View findViewById = view.findViewById(R.id.f69223i6);
        if (this.f396577e.T1()) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        this.f396580i = findViewById;
        MoodPicLabel moodPicLabel = (MoodPicLabel) findViewById.findViewById(R.id.f0x);
        this.f396579h = moodPicLabel;
        moodPicLabel.b().setMaxEms(6);
        this.f396579h.setOnClickListener(this);
        MoodPicLabel moodPicLabel2 = (MoodPicLabel) findViewById.findViewById(R.id.f0z);
        this.f396578f = moodPicLabel2;
        moodPicLabel2.b().setMaxEms(6);
        this.f396578f.setOnClickListener(this);
        h.a(this.f396579h.a(), "qui_label", R.color.qui_common_icon_secondary);
        h.a(this.f396578f.a(), "qui_position", R.color.qui_common_icon_secondary);
        c.n(this.f396578f, "em_qz_add_location");
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (event != null && "WriteOperation".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 63) {
                Object obj = event.params;
                if (obj instanceof Object[]) {
                    P9((PublishEventTag) ((Object[]) obj)[0]);
                    return;
                } else {
                    P9(null);
                    return;
                }
            }
            if (i3 != 64) {
                return;
            }
            Object obj2 = event.params;
            if (obj2 instanceof Object[]) {
                P9((PublishEventTag) ((Object[]) obj2)[0]);
            }
        }
    }
}
