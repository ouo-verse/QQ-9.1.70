package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.samestyle.SameStyleEntrySource;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import com.tencent.sqshow.zootopia.samestyle.ZplanEntranceInfo;
import com.tencent.sqshow.zootopia.samestyle.data.MaterialWrapper;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import n74.dh;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/c;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "", "u", "w", "p", "t", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "arEntrySource", ReportConstant.COSTREPORT_PREFIX, "Lsb4/a;", "D", "Lsb4/a;", "previewPage", "Landroid/app/Dialog;", "E", "Landroid/app/Dialog;", "mProcessWaitingDialog", "", UserInfo.SEX_FEMALE, "Z", "mEntranceDisable", "<init>", "(Lsb4/a;)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends d {

    /* renamed from: G, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private final sb4.a previewPage;

    /* renamed from: E, reason: from kotlin metadata */
    private Dialog mProcessWaitingDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mEntranceDisable;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J,\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0002J*\u0010\u0010\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nJ4\u0010\u0013\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/c$a;", "", "", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "template", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "arEntrySource", "b", "", "c", "f", "a", "", "downloadUrl", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.mix.helper.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(Activity activity, ZPlanTemplate template, ZootopiaSource source, @SameStyleEntrySource int arEntrySource) {
            BaseApplication context = BaseApplication.getContext();
            if (!NetworkUtil.isNetworkAvailable(context)) {
                QLog.e("ARTemplateHelper_", 1, "applyARTemplate, but network not available");
                QQToast.makeText(context, 1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, 0).show();
                return false;
            }
            c();
            return f(activity, template, source, arEntrySource);
        }

        private final void c() {
            if (((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(BaseApplication.getContext())) {
                return;
            }
            ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplication.getContext());
        }

        private final boolean e() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(210001L, peekAppRuntime.getLongAccountUin());
        }

        private final boolean f(Activity activity, ZPlanTemplate template, ZootopiaSource source, @SameStyleEntrySource int arEntrySource) {
            String downloadUrl;
            if (template.isMixAR()) {
                ZplanEntranceInfo entranceInfo = template.getEntranceInfo();
                downloadUrl = entranceInfo != null ? entranceInfo.getSdkUrl() : null;
            } else {
                downloadUrl = template.getDownloadUrl();
            }
            String d16 = d(downloadUrl, activity, template, source, arEntrySource);
            QLog.i("ARTemplateHelper_", 1, "jumpToLittleWorld schemeUrl:" + d16);
            Intent intent = new Intent(activity == null ? BaseApplication.context : activity, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(d16));
            if (activity != null) {
                activity.startActivity(intent);
            }
            return true;
        }

        public final boolean a(Activity activity, ZPlanTemplate template, ZootopiaSource source, @SameStyleEntrySource int arEntrySource) {
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(source, "source");
            if (!e()) {
                QLog.i("ARTemplateHelper_", 1, "not In Zplan AR White List");
                QQToast.makeText(BaseApplication.getContext(), R.string.xhq, 0).show();
                return false;
            }
            return b(activity, template, source, arEntrySource);
        }

        public final String d(String downloadUrl, Activity activity, ZPlanTemplate template, ZootopiaSource source, @SameStyleEntrySource int arEntrySource) {
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(source, "source");
            StringBuilder sb5 = new StringBuilder("mqqapi://qcircle/openqqpublish?target=0");
            sb5.append("&meterial=" + template.getTemplateId());
            sb5.append("&download_url=" + downloadUrl);
            sb5.append("&from=zPlanList");
            sb5.append("&zplan_external_entrance=" + ah.b(source));
            sb5.append("&zplan_samestyle_clip_cnt=" + template.getClipCount());
            sb5.append("&zplan_samestyle_length=" + template.getLength());
            sb5.append("&zplan_samestyle_id=" + template.getId());
            sb5.append("&zplan_samestyle_type=" + template.getContentType());
            sb5.append(com.tencent.sqshow.zootopia.samestyle.b.f372897a.b(activity != null ? activity.getIntent() : null, Integer.valueOf(arEntrySource), template.getId(), template.getContentType()));
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(\"mqqapi://\u2026              .toString()");
            return sb6;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(sb4.a previewPage) {
        super(previewPage.getF372926a(), previewPage.getF372927b(), previewPage.getF372928c(), previewPage.getF372929d(), previewPage.b(), previewPage.getLifecycleOwner(), previewPage.getSource());
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
    }

    private final void p() {
        Dialog dialog = this.mProcessWaitingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mProcessWaitingDialog = null;
    }

    private final void u() {
        final dh mBinding = getMBinding();
        ZplanEntranceInfo entranceInfo = getMTemplate().getEntranceInfo();
        if (getMTemplate().isMixAR() && entranceInfo != null) {
            mBinding.f419254i.setVisibility(0);
            mBinding.f419255j.e(MaterialWrapper.INSTANCE.a(entranceInfo.getIconMaterial()));
            String title = entranceInfo.getTitle();
            List split$default = title != null ? StringsKt__StringsKt.split$default((CharSequence) title, new String[]{"\n"}, false, 0, 6, (Object) null) : null;
            if (split$default != null && (split$default.isEmpty() ^ true)) {
                mBinding.f419257l.setText((CharSequence) split$default.get(0));
                if (split$default.size() > 1) {
                    mBinding.f419256k.setText((CharSequence) split$default.get(1));
                } else {
                    mBinding.f419256k.setVisibility(8);
                }
            }
            final String schema = entranceInfo.getSchema();
            LinearLayout linearLayout = mBinding.f419254i;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.entranceArea");
            aa.d(linearLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.v(c.this, mBinding, schema, view);
                }
            });
            id3.d mReporter = getMReporter();
            LinearLayout linearLayout2 = mBinding.f419254i;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.entranceArea");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(getMTemplate().getId()));
            linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(getMTemplate().getContentType()));
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(getMSource()));
            Unit unit = Unit.INSTANCE;
            id3.d.h(mReporter, linearLayout2, "em_zplan_ar_samestyle_entrance", linkedHashMap, false, true, null, 40, null);
            return;
        }
        mBinding.f419254i.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, dh binding, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        boolean z16 = true;
        if (this$0.mEntranceDisable) {
            QLog.i("ARTemplateHelper_", 1, "mEntranceDisable ");
            return;
        }
        id3.d mReporter = this$0.getMReporter();
        LinearLayout linearLayout = binding.f419254i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.entranceArea");
        mReporter.c("dt_clck", linearLayout, new LinkedHashMap());
        this$0.getMViewModel().O1();
        QLog.i("ARTemplateHelper_", 1, "click to arButton");
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(this$0.getMContext(), str);
        } else {
            this$0.s(6);
        }
    }

    private final void w() {
        Dialog dialog = this.mProcessWaitingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mProcessWaitingDialog = qc4.b.d(qc4.b.f428851a, this.previewPage.getActivity(), false, 2, null);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                c.x(c.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mProcessWaitingDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void l() {
        super.l();
        p();
    }

    public final void q() {
        getMBinding().f419254i.setAlpha(0.5f);
        this.mEntranceDisable = true;
        getMBinding().f419254i.setClickable(false);
    }

    public final void r() {
        getMBinding().f419254i.setAlpha(1.0f);
        this.mEntranceDisable = false;
        getMBinding().f419254i.setClickable(true);
    }

    public final void s(@SameStyleEntrySource int arEntrySource) {
        if (INSTANCE.a(this.previewPage.getActivity(), getMTemplate(), getMSource(), arEntrySource)) {
            w();
        }
    }

    public void t() {
        u();
    }
}
