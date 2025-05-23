package com.tencent.sqshow.zootopia.role.logic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.role.ui.RetentionPopupWindow;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsKt;
import n74.ar;
import qv4.ab;
import qv4.bb;
import qv4.bd;
import qv4.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0002\u001d#B\u001f\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010-\u001a\u00020(\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0004068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep;", "", "", "w", "", "contentStr", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqv4/bp;", "templateMaterial", "Lqv4/bb;", "registerMaterial", "v", "B", "l", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "p", "t", "url", "Landroid/graphics/drawable/Drawable;", ToastView.ICON_LOADING, "failed", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "u", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", DomainData.DOMAIN_NAME, "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln74/ar;", "b", "Ln74/ar;", "r", "()Ln74/ar;", "mBinding", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "c", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "", "d", "Z", "isRegistering", "", "e", "I", "realPosition", "", "f", "[Ljava/lang/String;", "pic", "<init>", "(Landroid/app/Activity;Ln74/ar;Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", "g", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CreateRoleGuideStep {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ar mBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CreateRoleController mController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRegistering;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int realPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String[] pic;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "textView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView imageView;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.q1e);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<ImageView>(R.id.image_view)");
            this.imageView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.qql);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<TextView>(R.id.text_view)");
            this.textView = (TextView) findViewById2;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bd;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<bd> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ bp f372750e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ bb f372751f;

        c(bp bpVar, bb bbVar) {
            this.f372750e = bpVar;
            this.f372751f = bbVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bd result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("CreateRoleGuideStep", 1, "registerAvatar success, isRegistered:" + result.f430053b);
            CreateRoleGuideStep.this.getMBinding().f418693d.setClickable(true);
            CreateRoleGuideStep.this.getMBinding().f418701l.setClickable(true);
            CreateRoleGuideStep.this.isRegistering = false;
            if (result.f430053b == 0) {
                CreateRoleGuideStep.this.B(this.f372750e, this.f372751f);
                VideoReport.reportPgOut(CreateRoleGuideStep.this.getMBinding().f418709t);
                CreateRoleGuideStep.this.getMController().G();
            } else {
                QQToastUtil.showQQToast(R.string.f169797xn4);
                CreateRoleGuideStep.this.getActivity().finish();
                QLog.i("CreateRoleGuideStep", 1, "registerAvatar failed, has registered");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("CreateRoleGuideStep", 1, "registerAvatar failed, error:" + error + ", message:" + message);
            CreateRoleGuideStep.this.isRegistering = false;
            CreateRoleGuideStep.this.getMBinding().f418693d.setClickable(true);
            CreateRoleGuideStep.this.getMBinding().f418701l.setClickable(true);
            QQToastUtil.showQQToast(1, R.string.xmy);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep$d", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends pg1.d {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep$d$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a extends ViewPager2.OnPageChangeCallback {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CreateRoleGuideStep f372753b;

            a(CreateRoleGuideStep createRoleGuideStep) {
                this.f372753b = createRoleGuideStep;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                CreateRoleGuideStep createRoleGuideStep = this.f372753b;
                createRoleGuideStep.realPosition = createRoleGuideStep.getMBinding().f418700k.c(position);
                this.f372753b.getMBinding().f418705p.b(this.f372753b.realPosition);
                if (this.f372753b.realPosition == this.f372753b.pic.length - 1) {
                    this.f372753b.getMController().L();
                }
            }
        }

        d() {
        }

        @Override // pg1.d
        public void a(ViewPager2 viewPager2, RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.mobileqq.guild.component.banner.viewpager2.b.d(viewPager2, 0.5f);
            com.tencent.mobileqq.guild.component.banner.viewpager2.b.b(viewPager2, 3.2f);
            viewPager2.setOffscreenPageLimit(1);
            recyclerView.setOverScrollMode(2);
            viewPager2.registerOnPageChangeCallback(new a(CreateRoleGuideStep.this));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep$e", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends RecyclerView.Adapter<b> {
        final /* synthetic */ String[] C;

        e(String[] strArr) {
            this.C = strArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CreateRoleGuideStep.this.pic.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            CreateRoleGuideStep createRoleGuideStep = CreateRoleGuideStep.this;
            holder.getImageView().setImageDrawable(createRoleGuideStep.o(createRoleGuideStep.pic[position], new ColorDrawable(0), new ColorDrawable(0)));
            CreateRoleGuideStep createRoleGuideStep2 = CreateRoleGuideStep.this;
            holder.getTextView().setText(createRoleGuideStep2.m(this.C[position], createRoleGuideStep2.getActivity()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.db8, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new b(view);
        }
    }

    public CreateRoleGuideStep(Activity activity, ar mBinding, CreateRoleController mController) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(mController, "mController");
        this.activity = activity;
        this.mBinding = mBinding;
        this.mController = mController;
        this.pic = new String[]{"https://image.superqqshow.qq.com/qq/register_resource/zplan_create_role_guide_p1.jpg", "https://image.superqqshow.qq.com/qq/register_resource/zplan_create_role_guide_p2.jpg", "https://image.superqqshow.qq.com/qq/register_resource/zplan_create_role_guide_p3.jpg"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(bp templateMaterial, bb registerMaterial) {
        this.mBinding.f418702m.setVisibility(8);
        this.mBinding.f418691b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mController.B();
        CreateRoleController createRoleController = this.mController;
        pu4.g gVar = templateMaterial.f430094a;
        Intrinsics.checkNotNullExpressionValue(gVar, "templateMaterial.body");
        createRoleController.M(gVar);
        this.mController.J(templateMaterial);
        this.mController.I(registerMaterial);
    }

    private final void l() {
        ZplanViewReportHelper reportHelper = this.mController.getReportHelper();
        HashMap hashMap = new HashMap();
        Activity activity = this.activity;
        ConstraintLayout constraintLayout = this.mBinding.f418709t;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.root");
        reportHelper.a(activity, constraintLayout, "pg_zplan_create_avatar_guide", hashMap);
        BannerLayout bannerLayout = this.mBinding.f418700k;
        Intrinsics.checkNotNull(bannerLayout, "null cannot be cast to non-null type android.view.View");
        reportHelper.c(bannerLayout, "em_zplan_guide_photo", p());
        ImageView imageView = this.mBinding.f418701l;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.guideButton");
        reportHelper.c(imageView, "em_zplan_create_btn", p());
        ImageView imageView2 = this.mBinding.f418693d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.backIcon");
        reportHelper.c(imageView2, "em_zplan_back_btn", p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannableString m(String contentStr, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData("\u88c5\u626e\u514d\u8d39\u9001", ""));
        arrayList.add(new RichTextHelper.RichTextData("\u597d\u53cb\u5728\u53ec\u5524", ""));
        arrayList.add(new RichTextHelper.RichTextData("\u793e\u4ea4\u65b0\u73a9\u6cd5", ""));
        return RichTextHelper.buildSpannable(contentStr, context, false, arrayList, new RichTextHelper.SpanColors(Color.parseColor("#0099FF"), -16777216, -16777216));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable o(String url, Drawable loading, Drawable failed) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = loading;
        obtain.mFailedDrawable = failed;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options)");
        return drawable;
    }

    private final IDynamicParams p() {
        return new IDynamicParams() { // from class: com.tencent.sqshow.zootopia.role.logic.k
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map q16;
                q16 = CreateRoleGuideStep.q(CreateRoleGuideStep.this, str);
                return q16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map q(CreateRoleGuideStep this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("zplan_guide_photo_id", this$0.t()), TuplesKt.to("zplan_guide_photo_pos", String.valueOf(this$0.realPosition + 1)));
        return mapOf;
    }

    private final String t() {
        List split$default;
        Object last;
        split$default = StringsKt__StringsKt.split$default((CharSequence) this.pic[this.realPosition], new String[]{"/"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        return (String) last;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(bp templateMaterial, bb registerMaterial) {
        this.mController.x(templateMaterial, new c(templateMaterial, registerMaterial));
    }

    private final void w() {
        this.mBinding.f418705p.a(this.pic.length);
        this.mBinding.f418700k.setAdapter(new e(new String[]{"\u9996\u6b21\u521b\u5efa\u89d2\u8272\n\u8d85\u9177\u88c5\u626e\u514d\u8d39\u9001", "\u597d\u53cb\u5728\u53ec\u5524\n\u5feb\u70b9\u52a0\u5165\u5427", "\u8d85\u591a\u793e\u4ea4\u65b0\u73a9\u6cd5\n\u7b49\u4f60\u6765\u63a2\u7d22"}));
        this.mBinding.f418700k.setLoop(false);
        this.mBinding.f418700k.setAutoLoopInterval(2000L);
        this.mBinding.f418700k.getStyleManager().a(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(CreateRoleGuideStep this$0, View it) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("zplan_guide_photo_id", this$0.t()), TuplesKt.to("zplan_guide_photo_pos", String.valueOf(this$0.realPosition + 1)));
        reportHelper.e(it, "em_zplan_create_btn", mapOf);
        VideoReport.reportPgOut(this$0.mBinding.f418709t);
        this$0.mController.L();
        this$0.mController.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(CreateRoleGuideStep this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        ZplanViewReportHelper reportHelper = this$0.mController.getReportHelper();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZplanViewReportHelper.f(reportHelper, it, "em_zplan_back_btn", null, 4, null);
    }

    public void A() {
        x();
        w();
        l();
    }

    /* renamed from: n, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* renamed from: r, reason: from getter */
    public final ar getMBinding() {
        return this.mBinding;
    }

    /* renamed from: s, reason: from getter */
    public final CreateRoleController getMController() {
        return this.mController;
    }

    public final void u() {
        int index;
        final ArrayList arrayList;
        boolean z16 = this.isRegistering;
        boolean a16 = qb4.a.f428794a.a();
        QLog.i("CreateRoleGuideStep", 1, "handleBackBtnClick, enableRetention:" + a16 + ", isRegistering:" + z16);
        if (!a16) {
            this.activity.finish();
            return;
        }
        ab r16 = this.mController.r();
        if (r16 != null) {
            index = r16.f429898m;
        } else {
            index = UEAvatarGender.FEMALE.getIndex();
        }
        List<bb> o16 = this.mController.o();
        if (o16 != null) {
            arrayList = new ArrayList();
            for (Object obj : o16) {
                if (((bb) obj).f430049f == index) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            QLog.i("CreateRoleGuideStep", 1, "handleBackBtnClick allRegisterMaterialList empty, finish");
            this.activity.finish();
        } else {
            if (z16) {
                return;
            }
            Activity activity = this.activity;
            ConstraintLayout constraintLayout = this.mBinding.f418709t;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.root");
            new RetentionPopupWindow(activity, constraintLayout, null, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.role.logic.CreateRoleGuideStep$handleBackBtnClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QLog.i("CreateRoleGuideStep", 1, "closeWindow invoke!");
                    CreateRoleGuideStep.this.getActivity().finish();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.role.logic.CreateRoleGuideStep$handleBackBtnClick$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object random;
                    random = CollectionsKt___CollectionsKt.random(arrayList, Random.INSTANCE);
                    bb bbVar = (bb) random;
                    bp a17 = CreateRoleController.INSTANCE.a(bbVar);
                    QLog.i("CreateRoleGuideStep", 1, "randomCreate invoke, randomTemplateMaterial id:" + (a17 != null ? a17.f430096c : null));
                    if (bbVar != null && a17 != null) {
                        this.getMBinding().f418693d.setClickable(false);
                        this.getMBinding().f418701l.setClickable(false);
                        this.isRegistering = true;
                        this.v(a17, bbVar);
                        return;
                    }
                    QLog.e("CreateRoleGuideStep", 1, "randomCreate invoke, randomTemplateMaterial null!!");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, 4, null).w();
        }
    }

    public final void x() {
        QQToastUtil.showQQToast(R.string.xmz);
        this.mBinding.f418702m.setVisibility(0);
        this.mBinding.f418703n.setImageDrawable(o("https://image.superqqshow.qq.com/qq/register_resource/zplan_create_role_guide_text.png", new ColorDrawable(0), new ColorDrawable(0)));
        this.mBinding.f418701l.setImageDrawable(o("https://image.superqqshow.qq.com/qq/register_resource/zplan_create_role_guide_button.png", new ColorDrawable(0), new ColorDrawable(0)));
        ImageView imageView = this.mBinding.f418701l;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.guideButton");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoleGuideStep.y(CreateRoleGuideStep.this, view);
            }
        });
        this.mBinding.f418693d.setVisibility(0);
        ImageView imageView2 = this.mBinding.f418693d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.backIcon");
        aa.d(imageView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.logic.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoleGuideStep.z(CreateRoleGuideStep.this, view);
            }
        });
    }
}
