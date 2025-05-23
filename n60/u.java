package n60;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSCommonEllipsizeLayout;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalDecorateBottomSheet;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cs;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n60.u;
import qqcircle.QQCircleBase$UserCircleInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends n60.b implements View.OnClickListener {
    private TextView C;
    private ImageView D;
    private TextView E;
    private LinearLayout F;
    private ImageView G;
    private QCircleTailExpandText H;
    private TextView I;
    private View J;
    private TextView K;
    private LinearLayout L;
    private SquareImageView M;
    private TextView N;
    private ImageView P;
    private FrameLayout Q;
    private ImageView R;
    private View S;
    private FrameLayout T;
    private TextView U;
    private ViewStub V;
    private LinearLayout W;
    private TextView X;
    private LinearLayout Y;
    private SquareImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f418483a0;

    /* renamed from: b0, reason: collision with root package name */
    private Size f418484b0;

    /* renamed from: c0, reason: collision with root package name */
    private Toast f418485c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f418486d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f418487e0;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f418488f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f418489f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f418490g0;

    /* renamed from: h, reason: collision with root package name */
    private QFSVipNickNameAndIconView f418491h;

    /* renamed from: h0, reason: collision with root package name */
    private QFSPersonalDecorateBottomSheet f418492h0;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f418493i;

    /* renamed from: i0, reason: collision with root package name */
    private QFSPersonalDecorateBottomSheet.a f418494i0;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f418495m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements QFSPersonalDecorateBottomSheet.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalDecorateBottomSheet.a
        public void a() {
            com.tencent.biz.qqcircle.helpers.d.a(3, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements QFSVipNickNameAndIconView.a {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c extends v.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_user_base_info", "key_update_version_main_basic_base_rsp", "update_version_base_user_busi_data", "key_update_version_main_basic_busi_base_data");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            u.this.j0(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f418499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.data.w f418500e;

        d(boolean z16, com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            this.f418499d = z16;
            this.f418500e = wVar;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess() && u.this.S != null && this.f418499d) {
                u.this.S.setVisibility(8);
            }
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = this.f418500e.b().extInfo;
            int S = u.this.S(feedCloudCommon$StCommonExt);
            if (loadState.isFinishSuccess() && u.this.K(S)) {
                u.this.T(S, cs.a(feedCloudCommon$StCommonExt, "lb_bubble_icon", ""), cs.a(feedCloudCommon$StCommonExt, "lb_bubble_arrows", ""));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f418502d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f418503e;

        e(int i3, String str) {
            this.f418502d = i3;
            this.f418503e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(int i3) {
            if (i3 < 0) {
                uq3.k.a().j("show_benefit_bubble_tip", true);
            } else {
                uq3.k.a().j("show_benefit_2_bubble_tip", true);
            }
            QLog.d("QFSPersonalInfoViewCompact", 1, "show benefit bubble success. ");
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess()) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                com.tencent.mobileqq.widget.tip.a T = com.tencent.mobileqq.widget.tip.a.r(u.this.b()).S(u.this.Q).b0(3000L).R(0).k0(0).Y(136, 55).X(bitmapDrawable).T(u.this.N(this.f418502d, this.f418503e));
                final int i3 = this.f418502d;
                T.f(new a.b() { // from class: n60.v
                    @Override // com.tencent.mobileqq.widget.tip.a.b
                    public /* synthetic */ void onClick(View view) {
                        l53.d.a(this, view);
                    }

                    @Override // com.tencent.mobileqq.widget.tip.a.b
                    public /* synthetic */ void onDismiss() {
                        l53.d.b(this);
                    }

                    @Override // com.tencent.mobileqq.widget.tip.a.b
                    public final void onShow() {
                        u.e.b(i3);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class i implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<u> f418509a;

        /* renamed from: b, reason: collision with root package name */
        private final int f418510b;

        public i(u uVar, int i3) {
            this.f418509a = new WeakReference<>(uVar);
            this.f418510b = i3;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar;
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            u uVar = this.f418509a.get();
            if (uVar != null && (tVar = uVar.mUserViewModel) != null && tVar.N1() != null) {
                com.tencent.biz.qqcircle.immersive.personal.data.w N1 = uVar.mUserViewModel.N1();
                int i3 = this.f418510b;
                if (i3 == 2) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_STATE, Integer.valueOf(!TextUtils.isEmpty(N1.c().iconDecorate.mainpageUrl.get()) ? 1 : 0));
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, new String(N1.c().busiReport.get().toByteArray()));
                } else if (i3 == 1) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST, N1.c().f398463id.get());
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, N1.c().f398463id.get());
                    if (N1.z()) {
                        str2 = "host";
                    } else {
                        str2 = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, str2);
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_VERIFY_MARK_LEVEL1_TYPE, Integer.valueOf(N1.a().certification.get()));
                } else if (i3 == 3) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CREATOR_LEVEL, Long.valueOf(uVar.f418487e0));
                }
            }
            return buildElementParams;
        }
    }

    public u(@NonNull n60.a aVar) {
        super(aVar);
        this.f418486d0 = false;
        this.f418487e0 = 0L;
        this.f418490g0 = false;
        this.f418494i0 = new a();
    }

    private void D(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (!this.f418490g0 && wVar.z() && this.T != null && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            this.f418490g0 = true;
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: n60.t
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.biz.qqcircle.utils.k.j("exp_qqvideo_homepage_EditProfile");
                }
            });
        }
    }

    private void E(SpannableStringBuilder spannableStringBuilder, @NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        int i3 = wVar.c().constellation.get();
        if (i3 > 0) {
            int i16 = i3 - 1;
            String[] strArr = com.tencent.biz.qqcircle.h.f84538a;
            if (i16 < strArr.length) {
                spannableStringBuilder.append((CharSequence) strArr[i16]);
                F(spannableStringBuilder);
                return;
            }
        }
        RFWLog.i("QFSPersonalInfoViewCompact", RFWLog.USR, "[addConstellation] -> uin = " + wVar.c().f398463id.get() + " , constellation = " + i3);
    }

    private void F(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append("  |  ");
    }

    private void G(SpannableStringBuilder spannableStringBuilder, com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (TextUtils.isEmpty(wVar.c().location.get())) {
            return;
        }
        spannableStringBuilder.append((CharSequence) wVar.c().location.get());
        F(spannableStringBuilder);
    }

    private void H(SpannableStringBuilder spannableStringBuilder, @NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String str;
        if (wVar.g().hideSchool.get() != 1 && !wVar.a().schoolInfos.get().isEmpty()) {
            this.D.setVisibility(8);
            StringBuilder sb5 = new StringBuilder();
            Iterator<QQCircleBase$UserCircleInfo> it = wVar.a().schoolInfos.get().iterator();
            while (it.hasNext()) {
                sb5.append(it.next().name.get());
            }
            String sb6 = sb5.toString();
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) sb6);
            spannableStringBuilder.setSpan(new h(), length, sb6.length() + length, 33);
            F(spannableStringBuilder);
            QCircleLpReportDc05504.DataBuilder thrActionType = L().setSubActionType(51).setThrActionType(1);
            if (wVar.z()) {
                str = "1";
            } else {
                str = "2";
            }
            QCircleLpReportDc05504.report(thrActionType.setExt6(str).setExt7(sb6));
            return;
        }
        this.D.setVisibility(8);
    }

    private void I() {
        VideoReport.setElementId(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_CREATOR_LEVEL_TAG);
        VideoReport.setEventDynamicParams(this.Q, new i(this, 3));
    }

    private void J() {
        VideoReport.setElementId(this.H, QCircleDaTongConstant.ElementId.EM_XSJ_PERSONAL_PROFILE);
        VideoReport.setElementParams(this.H, new QCircleDTParamBuilder().buildElementParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K(int i3) {
        if (Q()) {
            QLog.d("QFSPersonalInfoViewCompact", 1, "canShowBenefitBubbleTip, needScrollTop: true.");
            return false;
        }
        QLog.d("QFSPersonalInfoViewCompact", 1, "[canShowBenefitBubbleTip] flag=" + i3);
        if (i3 < 0) {
            return !uq3.k.a().c("show_benefit_bubble_tip", false);
        }
        if (i3 != 1) {
            return false;
        }
        return !uq3.k.a().c("show_benefit_2_bubble_tip", false);
    }

    private QCircleLpReportDc05504.DataBuilder L() {
        String L;
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.mUserViewModel;
        if (tVar == null) {
            L = "";
        } else {
            L = tVar.N1().L();
        }
        return dataBuilder.setToUin(L).setActionType(11).setPageId(e());
    }

    private void M() {
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_OTHER_TAG);
        VideoReport.setElementParams(this.C, new QCircleDTParamBuilder().buildElementParams());
        VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_REAL_NAME_AUTHENTICATION_BUTTON);
        VideoReport.setElementParams(this.E, new QCircleDTParamBuilder().buildElementParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable N(int i3, String str) {
        if (i3 < 0) {
            return ResourcesCompat.getDrawable(b().getResources(), R.drawable.osg, null);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSPersonalInfoViewCompact", 1, "[getBenefitBubbleArrowDrawable] empty url");
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        return URLDrawable.getDrawable(str, obtain);
    }

    private void O() {
        ViewStub viewStub = (ViewStub) a(R.id.f57422n_);
        this.V = viewStub;
        if (viewStub.getParent() == null) {
            return;
        }
        View inflate = this.V.inflate();
        this.W = (LinearLayout) inflate.findViewById(R.id.f43441mh);
        this.X = (TextView) inflate.findViewById(R.id.f43431mg);
        this.W.setOnClickListener(this);
    }

    private boolean Q() {
        QCircleInitBean initBean = getMParentView().getInitBean();
        if (initBean == null || initBean.getSchemeAttrs() == null || !initBean.getSchemeAttrs().containsKey(QCircleSchemeAttr.MainPage.IS_SCROLL_TOP)) {
            return false;
        }
        return "1".equals(initBean.getSchemeAttrs().get(QCircleSchemeAttr.MainPage.IS_SCROLL_TOP));
    }

    private boolean R() {
        if (((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).isExperiment("exp_qqvideo_homepage_EditProfile") && this.T != null && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int S(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudCommon$StCommonExt.mapInfo.get()) {
            if (feedCloudCommon$Entry != null && TextUtils.equals(feedCloudCommon$Entry.key.get(), "level_benefit_bubble")) {
                return TextUtils.equals(feedCloudCommon$Entry.value.get(), "1") ? 1 : 0;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i3, String str, String str2) {
        QLog.d("QFSPersonalInfoViewCompact", 1, "showBenefitBubble");
        if (i3 < 0) {
            str = QCircleSkinHelper.getInstance().getUrl("qvideo_rank_tooltip_qipao");
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSPersonalInfoViewCompact", 1, "[showBenefitBubble] url is null.");
        } else {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(DisplayUtil.dip2px(b(), 136.0f)).setRequestHeight(DisplayUtil.dip2px(b(), 55.0f)).setUrl(str), new e(i3, str2));
        }
    }

    private void U(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.P == null) {
            return;
        }
        int i3 = wVar.a().achievement.rocket.get();
        String str = wVar.a().achievement.rocketIconUrl.get();
        if (i3 != 0 && !TextUtils.isEmpty(str)) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setRequestWidth(ViewUtils.dip2px(19.0f)).setRequestHeight(ViewUtils.dip2px(19.0f)).setTargetView(this.P));
            this.P.setVisibility(0);
            wVar.a().achievement.rocketToast.get();
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(wVar.L()).setActionType(11).setSubActionType(54).setThrActionType(1).setExt6(i3 + ""));
            return;
        }
        this.P.setVisibility(8);
    }

    private void V(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.L != null && this.M != null && this.N != null) {
            if (wVar.a().certification.get() == 0) {
                this.L.setVisibility(8);
                return;
            }
            String d16 = com.tencent.biz.qqcircle.immersive.utils.p.d(wVar.a());
            String e16 = com.tencent.biz.qqcircle.immersive.utils.p.e(wVar.a());
            if (TextUtils.isEmpty(e16)) {
                return;
            }
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setEnableAutoDeleteLocalCache(false).setUrl(d16).setTargetView(this.M));
            this.N.setText(e16);
            this.L.setVisibility(8);
            VideoReport.setElementReuseIdentifier(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_VERIFY_MARK + wVar.L());
            VideoReport.setElementId(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_VERIFY_MARK);
            VideoReport.setEventDynamicParams(this.L, new i(this, 1));
            VideoReport.setElementEndExposePolicy(this.L, EndExposurePolicy.REPORT_ALL);
        }
    }

    private void W(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.f418488f == null) {
            return;
        }
        RFWLog.i("QFSPersonalInfoViewCompact", RFWLog.USR, "[updateAvatar] -> uin = " + wVar.L() + " , iconUrl = " + wVar.c().icon.iconUrl.get());
        this.f418488f.setUser(wVar.c(), this.f418484b0);
        VideoReport.setElementId(this.f418488f, "em_xsj_author_avatar");
        VideoReport.setEventDynamicParams(this.f418488f, new i(this, 2));
    }

    private void X(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.S != null && this.R != null && this.Q != null) {
            long j3 = wVar.c().level_benefit.get();
            boolean z16 = true;
            if (wVar.b().redPoint.level_benefit_flag.get() != 1) {
                z16 = false;
            }
            if (this.f418487e0 == j3 && z16 == this.f418489f0) {
                return;
            }
            this.f418487e0 = j3;
            this.f418489f0 = z16;
            this.Q.setVisibility(8);
            this.S.setVisibility(8);
            String str = wVar.c().level_benefit_icon.get();
            if (j3 != 0 && !TextUtils.isEmpty(str)) {
                this.Q.setVisibility(0);
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.R).setRequestWidth(ViewUtils.dip2px(72.0f)).setRegionHeight(ViewUtils.dip2px(23.0f)).setUrl(str), new d(z16, wVar));
                I();
            }
        }
    }

    private void Y(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String str;
        if (TextUtils.isEmpty(wVar.c().desc.get())) {
            if (!wVar.x() && wVar.z()) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f1924247g);
                this.G.setVisibility(8);
                this.F.setVisibility(8);
                this.H.setOnExpandCallback(new f());
            } else {
                this.F.setVisibility(8);
                return;
            }
        } else {
            this.H.setOnExpandCallback(new g(wVar));
            str = wVar.c().desc.get();
            this.F.setVisibility(0);
            this.G.setVisibility(8);
        }
        if (wVar.z()) {
            Z(str);
        } else {
            this.H.setContent(str);
        }
    }

    private void Z(String str) {
        this.G.setVisibility(8);
        if (!R()) {
            FrameLayout frameLayout = this.T;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            Drawable drawable = ContextCompat.getDrawable(b(), R.drawable.qui_edit_text_primary);
            if (drawable != null) {
                int lineHeight = this.H.getLineHeight();
                drawable.setBounds(0, 0, lineHeight, lineHeight);
                tc0.b bVar = new tc0.b(drawable, 0, ViewUtils.dip2px(2.0f));
                SpannableString spannableString = new SpannableString(" " + str);
                spannableString.setSpan(bVar, 0, 1, 17);
                this.H.setContent(spannableString);
            }
        } else {
            this.F.setVisibility(8);
            FrameLayout frameLayout2 = this.T;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        this.F.setOnClickListener(this);
    }

    private void a0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.W != null && this.X != null) {
            boolean equals = "1".equals(bh.d(wVar.b().extInfo.mapInfo.get(), "show_channel"));
            QLog.d("QFSPersonalInfoViewCompact", 1, "[updateGuildView] isShowGuild =" + equals);
            if (QCirclePluginUtil.isOwner(wVar.c()) && equals) {
                this.W.setVisibility(0);
                this.X.setText(com.tencent.biz.qqcircle.immersive.personal.utils.k.e());
            } else {
                this.W.setVisibility(8);
            }
        }
    }

    private void b0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.Y != null && this.Z != null && this.f418483a0 != null) {
            String str = wVar.a().f429290id.get();
            if (TextUtils.isEmpty(str)) {
                this.Y.setVisibility(8);
                return;
            }
            String url = QCircleSkinHelper.getInstance().getUrl("qvideo_icon_general_qqworld_id");
            QLog.i("QFSPersonalInfoViewCompact", 1, "updateId: " + ac.f90062a.a(str));
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setEnableAutoDeleteLocalCache(false).setUrl(url).setTargetView(this.Z));
            this.f418483a0.setText(str);
            this.Y.setVisibility(8);
        }
    }

    private void c0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        boolean z16;
        g0(wVar);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        E(spannableStringBuilder, wVar);
        G(spannableStringBuilder, wVar);
        H(spannableStringBuilder, wVar);
        if (spannableStringBuilder.length() > 5) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 5, spannableStringBuilder.length());
        }
        if (!TextUtils.isEmpty(spannableStringBuilder) && this.f418495m.getVisibility() == 0) {
            spannableStringBuilder.replace(0, 0, "  |  ");
        }
        this.C.setText(spannableStringBuilder);
        this.C.setMovementMethod(LinkMovementMethod.getInstance());
        boolean has = wVar.a().realNameAuthInfo.has();
        if (TextUtils.isEmpty(spannableStringBuilder) && this.f418495m.getVisibility() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !has) {
            this.f418493i.setVisibility(8);
        } else {
            this.f418493i.setVisibility(0);
        }
        if (has) {
            String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183493jb);
            if (z16) {
                a16 = "  |  " + a16;
            }
            this.E.setText(a16);
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
        M();
    }

    private void d0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String str = wVar.c().login_ip_location.get();
        if (!TextUtils.isEmpty(str)) {
            this.I.setVisibility(0);
            this.I.setText("IP\u5c5e\u5730\uff1a" + str);
            return;
        }
        this.I.setVisibility(8);
    }

    private void e0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String str = wVar.c().mcn_name.get();
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(8);
            this.K.setText(str);
        }
    }

    private void f0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.f418491h == null) {
            return;
        }
        if (R() && (this.f418491h.getParent() instanceof QFSCommonEllipsizeLayout)) {
            ViewGroup.LayoutParams layoutParams = ((QFSCommonEllipsizeLayout) this.f418491h.getParent()).getLayoutParams();
            layoutParams.width = bz.i(b()) - ViewUtils.dpToPx(104.0f);
            ((QFSCommonEllipsizeLayout) this.f418491h.getParent()).setLayoutParams(layoutParams);
        }
        this.f418491h.setUser(wVar.c());
        this.f418491h.setReportData(new QFSVipNickNameAndIconView.b().h(90));
        this.f418491h.w0(wVar.c().nick.get());
        ViewGroup.LayoutParams layoutParams2 = this.f418491h.getLayoutParams();
        layoutParams2.width = -2;
        this.f418491h.setLayoutParams(layoutParams2);
    }

    private void g0(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar.c().sex.get() == 1) {
            this.f418495m.setVisibility(0);
            this.f418495m.setBackground(b().getResources().getDrawable(R.drawable.kke));
        } else if (wVar.c().sex.get() == 2) {
            this.f418495m.setVisibility(0);
            this.f418495m.setBackground(b().getResources().getDrawable(R.drawable.f161627kj0));
        } else {
            this.f418495m.setVisibility(8);
        }
    }

    private void i0(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (this.f418492h0 == null) {
            QLog.d("QFSPersonalInfoViewCompact", 1, "MAI-[updateToSheetData] personal decorate bottom sheet should not be null.");
            return;
        }
        if (wVar != null && wVar.c() != null && wVar.c().icon != null && wVar.c().icon.iconUrl != null) {
            QLog.d("QFSPersonalInfoViewCompact", 1, "MAI-[updateToSheetData] magic icon:" + wVar.c().icon.iconUrl.get());
            this.f418492h0.W(wVar);
            return;
        }
        QLog.d("QFSPersonalInfoViewCompact", 1, "MAI-[updateToSheetData] current param is null, illegality.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar == null) {
            return;
        }
        f0(wVar);
        e0(wVar);
        V(wVar);
        b0(wVar);
        Y(wVar);
        d0(wVar);
        c0(wVar);
        U(wVar);
        W(wVar);
        i0(wVar);
        X(wVar);
        D(wVar);
        a0(wVar);
    }

    @Override // n60.b
    public void j(@NonNull QFSBaseFragment qFSBaseFragment) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) qFSBaseFragment.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.mUserViewModel = tVar;
        tVar.O1().c(qFSBaseFragment, new c());
    }

    @Override // n60.b
    public void m(@Nullable Configuration configuration) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.mUserViewModel;
        if (tVar != null && tVar.N1() != null) {
            j0(this.mUserViewModel.N1());
        }
    }

    @Override // n60.b
    public void o() {
        this.f418484b0 = com.tencent.biz.qqcircle.immersive.utils.n.a(b(), R.dimen.d3x);
        View a16 = a(R.id.f44491pb);
        this.f418491h = (QFSVipNickNameAndIconView) a(R.id.f56522ku);
        this.f418493i = (LinearLayout) a(R.id.f46081tm);
        this.f418495m = (ImageView) a(R.id.f44571pj);
        this.C = (TextView) a(R.id.f56272k6);
        this.D = (ImageView) a(R.id.f44301ot);
        this.E = (TextView) a(R.id.f56562ky);
        this.f418488f = (QCircleAvatarView) a(R.id.f44481pa);
        this.F = (LinearLayout) a(R.id.f45971tb);
        this.G = (ImageView) a(R.id.f44201oj);
        QCircleTailExpandText qCircleTailExpandText = (QCircleTailExpandText) a(R.id.f56042jj);
        this.H = qCircleTailExpandText;
        qCircleTailExpandText.initShowWidth(ImmersiveUtils.getScreenWidth() - ImmersiveUtils.dpToPx(36.0f));
        this.I = (TextView) a(R.id.f56282k7);
        this.J = a(R.id.f46191tx);
        this.K = (TextView) a(R.id.f56492kr);
        this.L = (LinearLayout) a(R.id.f45921t7);
        this.M = (SquareImageView) a(R.id.f44121ob);
        this.N = (TextView) a(R.id.f55932j9);
        this.P = (ImageView) a(R.id.f44101o_);
        this.Y = (LinearLayout) a(R.id.f46071tl);
        this.Z = (SquareImageView) a(R.id.f44291os);
        this.f418483a0 = (TextView) a(R.id.f56262k5);
        this.Q = (FrameLayout) a(R.id.f41791i1);
        this.R = (ImageView) a(R.id.f34260yo);
        this.S = a(R.id.f34270yp);
        this.T = (FrameLayout) a(R.id.f3703166);
        this.U = (TextView) a(R.id.f3704167);
        O();
        if (a16 != null) {
            a16.setOnClickListener(this);
        }
        this.f418491h.setNickNameClickListener(new b());
        this.f418488f.setOnClickListener(this);
        ImageView imageView = this.P;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.G.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.E.setOnClickListener(this);
        FrameLayout frameLayout = this.Q;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
        TextView textView = this.U;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        J();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f44481pa && id5 != R.id.f44101o_ && id5 != R.id.f44201oj && id5 != R.id.f45971tb && id5 != R.id.f3704167 && id5 != R.id.f45921t7 && id5 != R.id.f56562ky && id5 != R.id.f41791i1 && id5 == R.id.f43441mh && !fb0.a.b("QFSPersonalInfoViewCompact_channel", 1000L)) {
            com.tencent.biz.qqcircle.launcher.c.g(b(), com.tencent.biz.qqcircle.immersive.personal.utils.k.a());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // n60.b
    public void p(Activity activity) {
        super.p(activity);
        Toast toast = this.f418485c0;
        if (toast != null) {
            toast.cancel();
            this.f418485c0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements QCircleTailExpandText.g {
        f() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.g
        public void onContentClick() {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_DESCRIPTION_EDIT_BUTTON);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", u.this.H, buildElementParams);
        }

        @Override // com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.g
        public void a(boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements QCircleTailExpandText.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.data.w f418506a;

        g(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            this.f418506a = wVar;
        }

        @Override // com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.g
        public void onContentClick() {
            this.f418506a.z();
        }

        @Override // com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.g
        public void a(boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h extends ClickableSpan {
        h() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
        }
    }
}
