package n44;

import a54.a;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureInfo;
import com.tencent.robot.profile.data.RobotProfileMyCmdsData;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.robot.relation.api.IRobotRelationService;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import i44.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\b\t*\u000226\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J*\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Ln44/c;", "Ln44/f;", "Landroid/view/View;", "containerView", "", HippyTKDListViewAdapter.X, "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "u", "", QCircleDaTongConstant.ElementParamValue.PYMK_FOLD, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/robot/profile/data/j;", "data", "y", "onInitView", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "attached", "onAttachedChanged", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "commandTitle", "f", "commandHint", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "moreCommandLayout", "i", "moreCommandText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "moreCommandArrow", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/profile/data/j;", "itemData", "Li44/b;", "D", "Li44/b;", "adapter", "E", "Z", "isFolded", "n44/c$b", UserInfo.SEX_FEMALE, "Ln44/c$b;", "lifecycleListener", "n44/c$c", "G", "Ln44/c$c;", "relationObserver", "<init>", "()V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends f {

    /* renamed from: C, reason: from kotlin metadata */
    private RobotProfileMyCmdsData itemData;

    /* renamed from: D, reason: from kotlin metadata */
    private i44.b adapter;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFolded = true;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b lifecycleListener = new b();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final C10820c relationObserver = new C10820c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView commandTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView commandHint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup moreCommandLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView moreCommandText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView moreCommandArrow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"n44/c$b", "Lj44/b;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements j44.b {
        b() {
        }

        @Override // j44.b
        public void onDestroy() {
            IRuntimeService iRuntimeService;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
            if (iRobotRelationService != null) {
                iRobotRelationService.removeRelationObserver(c.this.relationObserver);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"n44/c$c", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "f", "c", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: n44.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10820c implements a54.a {
        C10820c() {
        }

        @Override // a54.a
        public void a(@NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            c cVar = c.this;
            RobotProfileMyCmdsData robotProfileMyCmdsData = cVar.itemData;
            if (robotProfileMyCmdsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                robotProfileMyCmdsData = null;
            }
            cVar.u(robotProfileMyCmdsData);
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            c cVar = c.this;
            RobotProfileMyCmdsData robotProfileMyCmdsData = cVar.itemData;
            if (robotProfileMyCmdsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                robotProfileMyCmdsData = null;
            }
            cVar.u(robotProfileMyCmdsData);
        }

        @Override // a54.a
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            c cVar = c.this;
            RobotProfileMyCmdsData robotProfileMyCmdsData = cVar.itemData;
            if (robotProfileMyCmdsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                robotProfileMyCmdsData = null;
            }
            cVar.u(robotProfileMyCmdsData);
        }

        @Override // a54.a
        public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
            a.C0013a.b(this, str, str2, obj);
        }

        @Override // a54.a
        public void f(@NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            c cVar = c.this;
            RobotProfileMyCmdsData robotProfileMyCmdsData = cVar.itemData;
            if (robotProfileMyCmdsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                robotProfileMyCmdsData = null;
            }
            cVar.u(robotProfileMyCmdsData);
        }
    }

    private final void A(boolean fold) {
        String string;
        float f16;
        this.isFolded = fold;
        i44.b bVar = this.adapter;
        ImageView imageView = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            bVar = null;
        }
        RobotProfileMyCmdsData robotProfileMyCmdsData = this.itemData;
        if (robotProfileMyCmdsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            robotProfileMyCmdsData = null;
        }
        bVar.n0(robotProfileMyCmdsData.h(), this.isFolded);
        TextView textView = this.moreCommandText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreCommandText");
            textView = null;
        }
        if (this.isFolded) {
            string = getRootView().getContext().getString(R.string.f222446dj);
        } else {
            string = getRootView().getContext().getString(R.string.f222366db);
        }
        textView.setText(string);
        ImageView imageView2 = this.moreCommandArrow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreCommandArrow");
            imageView2 = null;
        }
        if (this.isFolded) {
            f16 = 0.0f;
        } else {
            f16 = 180.0f;
        }
        imageView2.setRotation(f16);
        ImageView imageView3 = this.moreCommandArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreCommandArrow");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_chevron_down_icon_secondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final com.tencent.robot.profile.data.g item) {
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.robot.profile.data.RobotProfileMyCmdsData");
        RobotProfileMyCmdsData robotProfileMyCmdsData = (RobotProfileMyCmdsData) item;
        this.itemData = robotProfileMyCmdsData;
        View rootView = getRootView();
        Boolean valueOf = Boolean.valueOf(robotProfileMyCmdsData.h().isEmpty());
        rootView.setVisibility(8);
        if (((View) au.a(valueOf, rootView)) == null) {
            rootView.setVisibility(0);
        }
        getRootView().setBackgroundColor(getRootView().getContext().getColor(R.color.qui_common_bg_bottom_light));
        TextView textView = this.commandTitle;
        i44.b bVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandTitle");
            textView = null;
        }
        textView.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_primary));
        TextView textView2 = this.commandHint;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHint");
            textView2 = null;
        }
        textView2.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_secondary));
        TextView textView3 = this.moreCommandText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreCommandText");
            textView3 = null;
        }
        textView3.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_secondary));
        RobotProfileMyCmdsData robotProfileMyCmdsData2 = this.itemData;
        if (robotProfileMyCmdsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            robotProfileMyCmdsData2 = null;
        }
        final boolean y16 = y(robotProfileMyCmdsData2);
        boolean z16 = true;
        QLog.d("RobotMyCmdsSection", 1, "bindData isAdded=" + y16);
        TextView textView4 = this.commandHint;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHint");
            textView4 = null;
        }
        Boolean valueOf2 = Boolean.valueOf(y16);
        textView4.setVisibility(8);
        if (((View) au.a(valueOf2, textView4)) == null) {
            textView4.setVisibility(0);
        }
        this.adapter = new i44.b();
        RecyclerView recyclerView = (RecyclerView) getRootView().findViewById(R.id.u1c);
        i44.b bVar2 = this.adapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            bVar2 = null;
        }
        recyclerView.setAdapter(bVar2);
        A(true);
        ViewGroup viewGroup = this.moreCommandLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreCommandLayout");
            viewGroup = null;
        }
        if (robotProfileMyCmdsData.h().size() > 4) {
            z16 = false;
        }
        Boolean valueOf3 = Boolean.valueOf(z16);
        viewGroup.setVisibility(8);
        if (((View) au.a(valueOf3, viewGroup)) == null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.moreCommandLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreCommandLayout");
            viewGroup2 = null;
        }
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: n44.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.v(c.this, view);
            }
        });
        i44.b bVar3 = this.adapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            bVar = bVar3;
        }
        bVar.m0(new b.c() { // from class: n44.b
            @Override // i44.b.c
            public final void a(View view, RobotFeatureInfo robotFeatureInfo) {
                c.w(y16, item, view, robotFeatureInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A(!this$0.isFolded);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(boolean z16, com.tencent.robot.profile.data.g gVar, View v3, RobotFeatureInfo cmd) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        if (!u64.g.f438512a.g()) {
            if (z16) {
                RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                RobotProfileMyCmdsData robotProfileMyCmdsData = (RobotProfileMyCmdsData) gVar;
                String robotUin = robotProfileMyCmdsData.getRobotUin();
                String robotName = robotProfileMyCmdsData.getRobotName();
                String troopUin = robotProfileMyCmdsData.getTroopUin();
                String str = cmd.name;
                Intrinsics.checkNotNullExpressionValue(str, "cmd.name");
                robotProfileUtils.o(context, robotUin, robotName, troopUin, "inputKeyOp://sendToRobot", str);
                return;
            }
            QQToast.makeText(v3.getContext(), R.string.f222206cw, 0).show();
        }
    }

    private final void x(View containerView) {
        j44.a aVar = (j44.a) RFWIocAbilityProvider.g().getIocInterface(j44.a.class, RobotProfileUtils.f368193a.j(containerView), null);
        if (aVar != null) {
            aVar.a(this.lifecycleListener);
        }
    }

    private final boolean y(RobotProfileMyCmdsData data) {
        if (!data.g()) {
            return data.getRelationShip().getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.PARAM_IS_FRIEND java.lang.String();
        }
        if (data.getRelationShip().getRobotMemberShip() != -1) {
            return true;
        }
        return false;
    }

    @Override // n44.f, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        QLog.i("RobotMyCmdsSection", 1, "onAttachedChanged attached=" + attached + ", hash=" + hashCode());
        IRuntimeService iRuntimeService = null;
        if (attached) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
            }
            IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
            if (iRobotRelationService != null) {
                iRobotRelationService.addRelationObserver(this.relationObserver);
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 != null) {
            iRuntimeService = peekAppRuntime2.getRuntimeService(IRobotRelationService.class, "");
        }
        IRobotRelationService iRobotRelationService2 = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService2 != null) {
            iRobotRelationService2.removeRelationObserver(this.relationObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f106956_4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tv_command_title)");
        this.commandTitle = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f106936_2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_command_hint)");
        this.commandHint = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.zeg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026R.id.more_command_layout)");
        this.moreCommandLayout = (ViewGroup) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.zeh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.more_command_text)");
        this.moreCommandText = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.zef);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026(R.id.more_command_arrow)");
        this.moreCommandArrow = (ImageView) findViewById5;
        x(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.robot.profile.data.g item, int position, @Nullable List<Object> payload) {
        u(item);
    }
}
