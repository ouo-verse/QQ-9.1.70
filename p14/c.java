package p14;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import com.tencent.robot.adelie.homepage.cards.role.AdelieRoleTopBarRelativeLayout;
import com.tencent.robot.adelie.homepage.category.viewmodel.RoleDelegateData;
import com.tencent.robot.adelie.homepage.utils.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J*\u0010\u001f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dH\u0014J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010?\u00a8\u0006E"}, d2 = {"Lp14/c;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/g;", "Lp14/f;", "", "B", "t", "data", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "containerWidth", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "u", "", HippyTKDListViewAdapter.X, "", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "position", "", "payload", "y", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "attached", "onAttachedChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/robot/adelie/homepage/cards/role/AdelieRoleTopBarRelativeLayout;", "d", "Lcom/tencent/robot/adelie/homepage/cards/role/AdelieRoleTopBarRelativeLayout;", "roleTopBar", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "moreImageView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "roleRecyclerView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "roleTitle", "i", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/g;", "roleData", "Lmqq/util/WeakReference;", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "weakContent", "Lp14/e;", "Lp14/e;", "adapter", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends Section<RoleDelegateData> implements f {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private e adapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieRoleTopBarRelativeLayout roleTopBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView moreImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView roleRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView roleTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoleDelegateData roleData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> weakContent;

    private final void A(RoleDelegateData data) {
        this.roleData = data;
        TextView textView = this.roleTitle;
        if (textView != null) {
            textView.setText(data.getCard().name);
        }
        ImageView imageView = this.moreImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (s()) {
            ImageView imageView2 = this.moreImageView;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            AdelieRoleTopBarRelativeLayout adelieRoleTopBarRelativeLayout = this.roleTopBar;
            if (adelieRoleTopBarRelativeLayout != null) {
                VideoReport.reportEvent("imp", adelieRoleTopBarRelativeLayout, z());
            }
        }
        e eVar = this.adapter;
        if (eVar != null) {
            ArrayList<RobotCoreInfo> arrayList = data.getCard().robots;
            Intrinsics.checkNotNullExpressionValue(arrayList, "data.card.robots");
            String str = data.getCard().name;
            Intrinsics.checkNotNullExpressionValue(str, "data.card.name");
            eVar.k0(arrayList, str);
        }
    }

    private final void B() {
        Context context;
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            int w3 = w(r());
            g gVar = new g(context, w3);
            e eVar = new e();
            this.adapter = eVar;
            RecyclerView recyclerView = this.roleRecyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(eVar);
            }
            RecyclerView recyclerView2 = this.roleRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(gVar);
            }
            RecyclerView recyclerView3 = this.roleRecyclerView;
            if (recyclerView3 != null) {
                ViewUtils viewUtils = ViewUtils.f352270a;
                recyclerView3.addItemDecoration(new d(w3, -viewUtils.a(8.0f), viewUtils.a(1.0f)));
            }
        }
    }

    private final void C() {
        Context context;
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            Drawable o16 = ie0.a.f().o(context, R.drawable.qui_chevron_right, R.color.qui_common_icon_primary, 1000);
            ImageView imageView = this.moreImageView;
            if (imageView != null) {
                imageView.setImageDrawable(o16);
            }
        }
    }

    private final int q() {
        Context context;
        int i3 = ScreenUtil.SCREEN_WIDTH;
        int a16 = ViewUtils.f352270a.a(6.0f);
        WeakReference<Context> weakReference = this.weakContent;
        if (weakReference != null && (context = weakReference.get()) != null) {
            i3 = ScreenUtil.getRealWidth(context);
            a16 = (int) context.getResources().getDimension(R.dimen.bx5);
        }
        return i3 - (a16 * 4);
    }

    private final int r() {
        int i3;
        RecyclerView recyclerView = this.roleRecyclerView;
        if (recyclerView != null) {
            i3 = recyclerView.getWidth();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return q();
        }
        return i3;
    }

    private final boolean s() {
        if (x().length() > 0) {
            return true;
        }
        return false;
    }

    private final void t() {
        VideoReport.setElementId(getRootView(), "em_bas_theme_card");
        View rootView = getRootView();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(rootView, clickPolicy);
        AdelieRoleTopBarRelativeLayout adelieRoleTopBarRelativeLayout = this.roleTopBar;
        if (adelieRoleTopBarRelativeLayout != null) {
            VideoReport.setElementId(adelieRoleTopBarRelativeLayout, "em_bas_top_right_arrow");
            VideoReport.setElementClickPolicy(adelieRoleTopBarRelativeLayout, clickPolicy);
        }
    }

    private final void u() {
        AdelieRoleTopBarRelativeLayout adelieRoleTopBarRelativeLayout = this.roleTopBar;
        if (adelieRoleTopBarRelativeLayout != null) {
            adelieRoleTopBarRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: p14.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.v(c.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, View view) {
        boolean z16;
        WeakReference<Context> weakReference;
        Context cxt;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            if (this$0.x().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (weakReference = this$0.weakContent) != null && (cxt = weakReference.get()) != null) {
                n nVar = n.f366680a;
                Intrinsics.checkNotNullExpressionValue(cxt, "cxt");
                nVar.f(cxt, this$0.x());
            }
            VideoReport.reportEvent("clck", this$0.roleTopBar, this$0.z());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int w(int containerWidth) {
        int a16 = containerWidth / ViewUtils.f352270a.a(150.0f);
        if (a16 != 4) {
            return 2;
        }
        return a16;
    }

    private final String x() {
        String str;
        RobotRecommendCardInfo card;
        RoleDelegateData roleDelegateData = this.roleData;
        if (roleDelegateData != null && (card = roleDelegateData.getCard()) != null) {
            str = card.jumpUrl;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final Map<String, Object> z() {
        String str;
        Map<String, Object> mapOf;
        RobotRecommendCardInfo card;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("dt_pgid", "pg_bas_agent_home_page_new");
        RoleDelegateData roleDelegateData = this.roleData;
        if (roleDelegateData != null && (card = roleDelegateData.getCard()) != null) {
            str = card.name;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("subject_name", str);
        pairArr[2] = TuplesKt.to(IPublicAccountConfigAttr.CARD_STYLE, 2);
        pairArr[3] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_theme_card");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        if (attached) {
            VideoReport.reportEvent("imp", getRootView(), z());
        }
    }

    @Override // p14.f
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        Integer num;
        e eVar;
        if (newConfig != null) {
            num = Integer.valueOf(newConfig.orientation);
        } else {
            num = null;
        }
        QLog.i("AdelieHomeRoleCardSection", 1, "onConfigurationChanged, orientation=" + num);
        RecyclerView recyclerView = this.roleRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeItemDecorationAt(0);
        }
        B();
        RoleDelegateData roleDelegateData = this.roleData;
        if (roleDelegateData != null && (eVar = this.adapter) != null) {
            ArrayList<RobotCoreInfo> arrayList = roleDelegateData.getCard().robots;
            Intrinsics.checkNotNullExpressionValue(arrayList, "this.card.robots");
            String str = roleDelegateData.getCard().name;
            Intrinsics.checkNotNullExpressionValue(str, "this.card.name");
            eVar.k0(arrayList, str);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        this.weakContent = null;
        RecyclerView recyclerView = this.roleRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeItemDecorationAt(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        AdelieRoleTopBarRelativeLayout adelieRoleTopBarRelativeLayout;
        ImageView imageView;
        TextView textView;
        Context context;
        if (containerView != null && (context = containerView.getContext()) != null) {
            this.weakContent = new WeakReference<>(context);
            FontSettingManager.resetViewSize2Normal(context, containerView);
        }
        RecyclerView recyclerView = null;
        if (containerView != null) {
            adelieRoleTopBarRelativeLayout = (AdelieRoleTopBarRelativeLayout) containerView.findViewById(R.id.f779245o);
        } else {
            adelieRoleTopBarRelativeLayout = null;
        }
        this.roleTopBar = adelieRoleTopBarRelativeLayout;
        if (adelieRoleTopBarRelativeLayout != null) {
            adelieRoleTopBarRelativeLayout.setCallback(this);
        }
        if (containerView != null) {
            imageView = (ImageView) containerView.findViewById(R.id.f06);
        } else {
            imageView = null;
        }
        this.moreImageView = imageView;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.f779145n);
        } else {
            textView = null;
        }
        this.roleTitle = textView;
        u();
        C();
        if (containerView != null) {
            recyclerView = (RecyclerView) containerView.findViewById(R.id.f777845a);
        }
        this.roleRecyclerView = recyclerView;
        B();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable RoleDelegateData data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            A(data);
        }
    }
}
