package com.tencent.sqshow.zootopia.role.logic;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.IZPlanModComponentHelper;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.role.ui.RetentionPopupWindow;
import com.tencent.sqshow.zootopia.role.ui.RoleLoadingButton;
import com.tencent.sqshow.zootopia.role.ui.a;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import n74.ar;
import pv4.u;
import pv4.y;
import qv4.ab;
import qv4.bb;
import qv4.bd;
import qv4.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 A2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010.\u001a\u00020)\u0012\u0006\u00104\u001a\u00020/\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0014\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\b\u0010\u001b\u001a\u00020\u001aH&J\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u0006\u0010\"\u001a\u00020\u0002R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u0014R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep;", "", "", HippyTKDListViewAdapter.X, "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "p", "B", "K", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqv4/ab;", "result", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "Lqv4/bp;", "templateMaterial", "v", "O", "N", "P", "I", "H", "", "Lqv4/bb;", "materialInfoList", "M", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "r", "D", "", "position", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "u", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", DomainData.DOMAIN_NAME, "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln74/ar;", "b", "Ln74/ar;", ReportConstant.COSTREPORT_PREFIX, "()Ln74/ar;", "mBinding", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "c", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "t", "()Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "d", "gender", "", "e", "Z", "hasInitRecyclerView", "Lcom/tencent/sqshow/zootopia/role/ui/a;", "o", "()Lcom/tencent/sqshow/zootopia/role/ui/a;", "adapter", "<init>", "(Landroid/app/Activity;Ln74/ar;Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseCreateRoleSelectStep {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ar mBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CreateRoleController mController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int gender;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasInitRecyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bd;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<bd> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bd result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("BaseCreateRoleSelectStep", 1, "registerAvatar success, isRegistered:" + result.f430053b);
            BaseCreateRoleSelectStep.this.getMBinding().f418693d.setClickable(true);
            if (result.f430053b == 0) {
                BaseCreateRoleSelectStep.this.N();
                BaseCreateRoleSelectStep.this.getMController().w();
            } else {
                QQToastUtil.showQQToast(R.string.f169797xn4);
                BaseCreateRoleSelectStep.this.getActivity().finish();
                QLog.i("BaseCreateRoleSelectStep", 1, "registerAvatar success but has registered!!");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("BaseCreateRoleSelectStep", 1, "registerAvatar failed, error:" + error + ", message:" + message);
            BaseCreateRoleSelectStep.this.getMBinding().f418693d.setClickable(true);
            BaseCreateRoleSelectStep.this.N();
            QQToastUtil.showQQToast(1, R.string.xmy);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ab;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ab> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ab result) {
            Intrinsics.checkNotNullParameter(result, "result");
            BaseCreateRoleSelectStep.this.getMBinding().A.setText(result.f429892g);
            BaseCreateRoleSelectStep.this.getMBinding().f418691b.h();
            u uVar = result.f429893h;
            String str = uVar != null ? uVar.f427702a : null;
            if (str == null) {
                str = "";
            }
            BaseCreateRoleSelectStep.this.getMBinding().f418697h.setText(str);
            if (result.f429890e == 0 || BaseCreateRoleSelectStep.this.getMController().getStayInPageWhenHasRegistered()) {
                BaseCreateRoleSelectStep.this.w(result);
                BaseCreateRoleSelectStep.this.B();
                BaseCreateRoleSelectStep.this.J();
                BaseCreateRoleSelectStep.this.A(result);
                BaseCreateRoleSelectStep.this.m();
                return;
            }
            QQToastUtil.showQQToast(R.string.f169797xn4);
            BaseCreateRoleSelectStep.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("BaseCreateRoleSelectStep", 1, "handleViewEnter onResultFailure error:" + error + " message:" + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep$d", "Lcom/tencent/sqshow/zootopia/role/ui/a$b;", "", "position", "Lqv4/bb;", "materialInfo", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements a.b {
        d() {
        }

        @Override // com.tencent.sqshow.zootopia.role.ui.a.b
        public void a(int position, bb materialInfo) {
            Intrinsics.checkNotNullParameter(materialInfo, "materialInfo");
            BaseCreateRoleSelectStep.this.L(position);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ljw4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<jw4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f372715d;

        e(int i3) {
            this.f372715d = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(jw4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("BaseCreateRoleSelectStep", 1, "doCheckLimiterReq :: success , result == " + result);
            ((IZPlanModComponentHelper) QRoute.api(IZPlanModComponentHelper.class)).silentDownloadModInZPlan(false, true, this.f372715d);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("BaseCreateRoleSelectStep", 1, "onResultFailure :: failed , error == " + error + " , message == " + message);
        }
    }

    public BaseCreateRoleSelectStep(Activity activity, ar mBinding, CreateRoleController mController) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(mController, "mController");
        this.activity = activity;
        this.mBinding = mBinding;
        this.mController = mController;
        this.gender = UEAvatarGender.FEMALE.getIndex();
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(ab result) {
        boolean isBlank;
        if (result.f429891f != 0) {
            String str = result.f429888c;
            Intrinsics.checkNotNullExpressionValue(str, "result.downloadTips");
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                this.mBinding.f418715z.setVisibility(0);
                this.mBinding.f418698i.setText(result.f429888c);
                this.mController.K(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        int i3;
        ab r16 = this.mController.r();
        if (r16 != null) {
            i3 = r16.f429898m;
        } else {
            i3 = this.gender;
        }
        this.gender = i3;
        this.mBinding.f418713x.setVisibility(0);
        I();
        RelativeLayout relativeLayout = this.mBinding.f418713x;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.switchGenderRl");
        aa.d(relativeLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseCreateRoleSelectStep.C(BaseCreateRoleSelectStep.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(BaseCreateRoleSelectStep this$0, View view) {
        int index;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.gender;
        UEAvatarGender uEAvatarGender = UEAvatarGender.FEMALE;
        if (i3 == uEAvatarGender.getIndex()) {
            index = UEAvatarGender.MALE.getIndex();
        } else {
            index = uEAvatarGender.getIndex();
        }
        this$0.gender = index;
        this$0.I();
        this$0.J();
        this$0.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(BaseCreateRoleSelectStep this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        reportHelper.e(it, "em_zplan_set_avatar", this$0.mController.h());
        this$0.v(this$0.mController.getMTemplateMaterial());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(BaseCreateRoleSelectStep this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mController.getIsChecked()) {
            this$0.mBinding.f418710u.setBackgroundResource(R.drawable.ilc);
        } else {
            this$0.mBinding.f418710u.setBackgroundResource(R.drawable.ilb);
        }
        this$0.mController.K(!r1.getIsChecked());
    }

    private final void I() {
        this.mBinding.f418712w.setImageResource(this.gender == UEAvatarGender.FEMALE.getIndex() ? R.drawable.ieg : R.drawable.iel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        List<bb> mutableList;
        QLog.d("BaseCreateRoleSelectStep", 1, "onResultSuccess");
        List<bb> o16 = this.mController.o();
        if (o16 == null) {
            o16 = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = o16.iterator();
        while (true) {
            if (!it.hasNext()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                M(mutableList);
                L(0);
                return;
            } else {
                Object next = it.next();
                if (((bb) next).f430049f == this.gender) {
                    arrayList.add(next);
                }
            }
        }
    }

    private final void K() {
        ZplanViewReportHelper reportHelper = this.mController.getReportHelper();
        RelativeLayout relativeLayout = this.mBinding.f418713x;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.switchGenderRl");
        Map<String, String> h16 = this.mController.h();
        h16.put("zplan_gender", String.valueOf(this.gender));
        Unit unit = Unit.INSTANCE;
        reportHelper.e(relativeLayout, "em_zplan_gender_switch", h16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        this.mBinding.f418697h.b();
        this.mBinding.f418713x.setClickable(true);
    }

    private final void O() {
        this.mBinding.f418697h.e();
        this.mBinding.f418713x.setClickable(false);
    }

    private final void P() {
        y yVar;
        QLog.d("BaseCreateRoleSelectStep", 1, "handleNextStep, isDownloadChecked isChecked: " + this.mController.getIsChecked());
        if (this.mController.getIsChecked()) {
            ab r16 = this.mController.r();
            int i3 = (r16 == null || (yVar = r16.f429887b) == null) ? AdMetricID.Click.SUCCESS : yVar.f427728a;
            QLog.d("BaseCreateRoleSelectStep", 1, "isDownloadChecked true, try download , mapId == " + i3);
            pb4.a.b(pb4.a.f425864a, new jw4.a(), new e(i3), 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        ZplanViewReportHelper reportHelper = this.mController.getReportHelper();
        HashMap hashMap = new HashMap();
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(this.mController.getSourceCurrent()));
        hashMap.put("zplan_refer_external_entrance", this.mController.getReferExternalEntrance());
        hashMap.put("zplan_template_back", 1);
        VideoReport.resetPageStats();
        Activity activity = this.activity;
        ConstraintLayout constraintLayout = this.mBinding.f418709t;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.root");
        reportHelper.a(activity, constraintLayout, "pg_zplan_template_avatar", hashMap);
        VideoReport.traverseExposure();
        RelativeLayout relativeLayout = this.mBinding.f418713x;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.switchGenderRl");
        Map<String, String> h16 = this.mController.h();
        h16.put("zplan_gender", String.valueOf(this.gender));
        Unit unit = Unit.INSTANCE;
        reportHelper.g(relativeLayout, "em_zplan_gender_switch", (r16 & 4) != 0 ? null : h16, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        RoleLoadingButton roleLoadingButton = this.mBinding.f418697h;
        Intrinsics.checkNotNullExpressionValue(roleLoadingButton, "mBinding.confirmBtn");
        reportHelper.g(roleLoadingButton, "em_zplan_set_avatar", (r16 & 4) != 0 ? null : this.mController.h(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ImageView imageView = this.mBinding.f418693d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIcon");
        reportHelper.g(imageView, "em_zplan_back_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZootopiaRecycleView zootopiaRecycleView = this.mBinding.f418699j;
        Intrinsics.checkNotNullExpressionValue(zootopiaRecycleView, "mBinding.faceRv");
        reportHelper.c(zootopiaRecycleView, "em_zplan_avatar_switch", p());
    }

    private final IDynamicParams p() {
        return new IDynamicParams() { // from class: com.tencent.sqshow.zootopia.role.logic.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map q16;
                q16 = BaseCreateRoleSelectStep.q(BaseCreateRoleSelectStep.this, str);
                return q16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map q(BaseCreateRoleSelectStep this$0, String str) {
        String str2;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("zplan_avatar_id", this$0.o().getAvatarId());
        pairArr[1] = TuplesKt.to("zplan_avatar_pos", String.valueOf(this$0.o().getSelectedPosition()));
        if (this$0.o() instanceof com.tencent.sqshow.zootopia.role.ui.h) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        pairArr[2] = TuplesKt.to("is_new_type", str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(bp templateMaterial) {
        O();
        P();
        this.mController.x(templateMaterial, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(ab result) {
        pu4.g gVar;
        String str;
        u uVar = result.f429894i;
        if (uVar != null && (str = uVar.f427702a) != null) {
            this.mBinding.f418708s.setText(str);
            QLog.i("BaseCreateRoleSelectStep", 1, "handleUI :: mod text == " + str);
        }
        u uVar2 = result.f429894i;
        if (uVar2 != null && (gVar = uVar2.f427705d) != null && result.f429891f != 0) {
            this.mBinding.f418708s.setIcon(gVar);
            QLog.i("BaseCreateRoleSelectStep", 1, "handleUI :: mod icon == " + gVar);
        }
        String str2 = result.f429892g;
        if (str2 != null) {
            this.mBinding.A.setText(str2);
            QLog.i("BaseCreateRoleSelectStep", 1, "handleUI :: title text == " + str2);
        }
    }

    private final void x() {
        this.mController.q(new c());
        this.mBinding.f418699j.setVisibility(0);
        ImageView imageView = this.mBinding.f418693d;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIcon");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseCreateRoleSelectStep.y(BaseCreateRoleSelectStep.this, view);
            }
        });
        this.mBinding.f418702m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(BaseCreateRoleSelectStep this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZplanViewReportHelper.f(reportHelper, it, "em_zplan_back_btn", null, 4, null);
    }

    public final void D() {
        this.mBinding.f418699j.setAdapter(o());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity);
        linearLayoutManager.setOrientation(0);
        this.mBinding.f418699j.setLayoutManager(linearLayoutManager);
        this.mBinding.f418699j.setHorizontalFadingEdgeEnabled(true);
        this.mBinding.f418699j.setFadingEdgeLength(com.tencent.sqshow.zootopia.utils.i.b(10));
        this.mBinding.f418699j.addItemDecoration(r());
        com.tencent.sqshow.zootopia.role.ui.a o16 = o();
        if (o16 != null) {
            o16.s0(new d());
        }
    }

    public void E() {
        this.mBinding.f418691b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mBinding.f418708s.setTextSize(16.0f);
        this.mBinding.f418697h.setTextSize(14.0f);
        this.mBinding.f418697h.setOnClickListenerWithLoading(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseCreateRoleSelectStep.F(BaseCreateRoleSelectStep.this, view);
            }
        });
        this.mBinding.f418715z.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseCreateRoleSelectStep.G(BaseCreateRoleSelectStep.this, view);
            }
        });
        this.mBinding.f418693d.setVisibility(0);
    }

    public void H() {
        x();
        D();
        z();
    }

    public final void L(int position) {
        List<bb> data;
        List<bb> data2;
        bb bbVar;
        bp a16;
        List<bb> data3;
        com.tencent.sqshow.zootopia.role.ui.a o16 = o();
        if (position >= ((o16 == null || (data3 = o16.getData()) == null) ? 0 : data3.size())) {
            return;
        }
        com.tencent.sqshow.zootopia.role.ui.a o17 = o();
        if (o17 != null && (data2 = o17.getData()) != null && (bbVar = data2.get(position)) != null && (a16 = CreateRoleController.INSTANCE.a(bbVar)) != null) {
            CreateRoleController createRoleController = this.mController;
            pu4.g gVar = a16.f430094a;
            Intrinsics.checkNotNullExpressionValue(gVar, "it.body");
            createRoleController.M(gVar);
            this.mController.J(a16);
        }
        CreateRoleController createRoleController2 = this.mController;
        com.tencent.sqshow.zootopia.role.ui.a o18 = o();
        createRoleController2.I((o18 == null || (data = o18.getData()) == null) ? null : data.get(position));
        com.tencent.sqshow.zootopia.role.ui.a o19 = o();
        if (o19 != null) {
            o19.t0(position);
        }
    }

    public final void M(List<bb> materialInfoList) {
        Intrinsics.checkNotNullParameter(materialInfoList, "materialInfoList");
        if (!this.hasInitRecyclerView) {
            this.hasInitRecyclerView = true;
            D();
        }
        o().r0(this.gender);
        o().setData(materialInfoList);
    }

    /* renamed from: n, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public abstract com.tencent.sqshow.zootopia.role.ui.a o();

    public abstract RecyclerView.ItemDecoration r();

    /* renamed from: s, reason: from getter */
    public final ar getMBinding() {
        return this.mBinding;
    }

    /* renamed from: t, reason: from getter */
    public final CreateRoleController getMController() {
        return this.mController;
    }

    public final void u() {
        boolean a16 = qb4.a.f428794a.a();
        QLog.i("BaseCreateRoleSelectStep", 1, "handleBackBtnClick, enableRetention:" + a16);
        if (!a16) {
            this.activity.finish();
            return;
        }
        com.tencent.sqshow.zootopia.role.ui.a o16 = o();
        final List<bb> data = o16 != null ? o16.getData() : null;
        List<bb> list = data;
        if (list == null || list.isEmpty()) {
            QLog.i("BaseCreateRoleSelectStep", 1, "handleBackBtnClick currentMaterialList empty, finish!");
            this.activity.finish();
        } else {
            Activity activity = this.activity;
            ConstraintLayout constraintLayout = this.mBinding.f418709t;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.root");
            new RetentionPopupWindow(activity, constraintLayout, null, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep$handleBackBtnClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QLog.i("BaseCreateRoleSelectStep", 1, "closeWindow invoke!");
                    BaseCreateRoleSelectStep.this.getActivity().finish();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep$handleBackBtnClick$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int random;
                    BaseCreateRoleSelectStep.this.getMBinding().f418693d.setClickable(false);
                    random = RangesKt___RangesKt.random(new IntRange(0, data.size()), Random.INSTANCE);
                    com.tencent.sqshow.zootopia.role.ui.a o17 = BaseCreateRoleSelectStep.this.o();
                    if (o17 != null) {
                        o17.p0(random);
                    }
                    BaseCreateRoleSelectStep.this.L(random);
                    bb mSelectMaterialInfo = BaseCreateRoleSelectStep.this.getMController().getMSelectMaterialInfo();
                    bp a17 = mSelectMaterialInfo != null ? CreateRoleController.INSTANCE.a(mSelectMaterialInfo) : null;
                    QLog.i("BaseCreateRoleSelectStep", 1, "randomCreate invoke, randomTemplateMaterial id:" + (a17 != null ? a17.f430096c : null));
                    BaseCreateRoleSelectStep baseCreateRoleSelectStep = BaseCreateRoleSelectStep.this;
                    baseCreateRoleSelectStep.v(baseCreateRoleSelectStep.getMController().getMTemplateMaterial());
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, 4, null).w();
        }
    }

    public abstract void z();
}
