package o54;

import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.dialog.content.middle.TroopSlashListContainerVB;
import com.tencent.robot.slash.dialog.content.tip.SlashTipContentUIState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.d;
import w64.e;
import w64.f;
import w64.i;
import w64.k;
import w64.l;
import w64.m;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010>\u001a\u00020<\u0012\u0006\u0010@\u001a\u00020\u001c\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000e\u001a\u00020\r2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u000f2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J \u0010\u0013\u001a\u00020\u000f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\tH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\"2\u0006\u0010!\u001a\u00020 H\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020*H\u0016J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u001cH\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u001cH\u0016J\u0010\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016J\u0010\u00104\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016J\u0018\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bH\u0016J \u0010;\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00172\u0006\u0010:\u001a\u000209H\u0016R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010=R\u0014\u0010@\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010ER\u0014\u0010H\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010G\u00a8\u0006K"}, d2 = {"Lo54/a;", "Lcom/tencent/robot/slash/businessapi/c;", "Lw64/m;", "r", "o54/a$b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lo54/a$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatures;", "Lkotlin/collections/ArrayList;", "robotFeaturesList", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Lb74/a;", "functionItemDataList", "p", "t", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "commandInfo", "u", "v", "w", "Landroid/view/View;", "l", "Lu54/c;", h.F, "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "j", "", "hideKeyboard", "itemData", "a", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "Lb54/a;", "itemArgs", "g", "e", "robotUin", "robotTinyId", "b", "functionInfo", "", "functionType", "i", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/view/View;", "mAnchorView", "Lq54/a;", "c", "Lq54/a;", "mStorageHelper", "Ljava/lang/String;", "mChatCookie", "Z", "mIsInlineSearchEnable", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.robot.slash.businessapi.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q54.a mStorageHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mChatCookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsInlineSearchEnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0001J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u000f"}, d2 = {"o54/a$a", "Lw64/n;", "Lu54/c;", "Lw64/d;", "f", "Lw64/f;", "c", "Lw64/k;", "a", "Lw64/i;", "d", "Lw64/l;", "e", "Lw64/m;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: o54.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10885a implements n<u54.c> {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ u54.a f422144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f422145b;

        C10885a(com.tencent.mvi.api.runtime.b bVar, a aVar) {
            this.f422145b = aVar;
            this.f422144a = new u54.a(bVar, aVar);
        }

        @Override // w64.n
        @NotNull
        public k<u54.c> a() {
            return this.f422144a.a();
        }

        @Override // w64.n
        @NotNull
        public m b() {
            return this.f422145b.r();
        }

        @Override // w64.n
        @NotNull
        public f c() {
            return this.f422144a.c();
        }

        @Override // w64.n
        @NotNull
        public i d() {
            return this.f422144a.d();
        }

        @Override // w64.n
        @NotNull
        public l<u54.c> e() {
            return this.f422144a.e();
        }

        @Override // w64.n
        @NotNull
        public d<u54.c> f() {
            return this.f422144a.f();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"o54/a$b", "Lcom/tencent/robot/slash/dialog/content/middle/a;", "Lcom/tencent/robot/slash/dialog/content/middle/TroopSlashListContainerVB;", "c", "Lh64/d;", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.robot.slash.dialog.content.middle.a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001J \u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0006H\u0016J*\u0010\n\u001a\u00020\t2 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"o54/a$b$a", "Lnl3/a;", "Lh64/a;", "Lcom/tencent/robot/slash/dialog/content/tip/SlashTipContentUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/mvi/mvvm/BaseVM;", "a", "mUIModel", "", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: o54.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C10886a implements nl3.a<h64.a, SlashTipContentUIState, e<u54.c>> {
            C10886a() {
            }

            @Override // nl3.a
            @NotNull
            public BaseVM<h64.a, SlashTipContentUIState, e<u54.c>> a() {
                return new r54.a();
            }

            @Override // nl3.a
            public void b(@Nullable BaseVM<h64.a, SlashTipContentUIState, e<u54.c>> mUIModel) {
                if (mUIModel != null) {
                    mUIModel.create();
                }
            }
        }

        b() {
        }

        @Override // com.tencent.robot.slash.dialog.content.middle.a
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public TroopSlashListContainerVB a() {
            return new TroopSlashListContainerVB();
        }

        @Override // com.tencent.robot.slash.dialog.content.middle.a
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h64.d b() {
            h64.d dVar = new h64.d();
            dVar.setMVmIVMProvider(new C10886a());
            return dVar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"o54/a$c", "Lw64/m;", "Lcom/tencent/mvi/runtime/strategy/b;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements m {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0000\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"o54/a$c$a", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/robot/slash/dialog/content/middle/a;", "o54/a$b", "c", "()Lo54/a$b;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: o54.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C10887a extends IStrategyFetcher<com.tencent.robot.slash.dialog.content.middle.a> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f422147b;

            C10887a(a aVar) {
                this.f422147b = aVar;
            }

            @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
            @NotNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b getF447332b() {
                return this.f422147b.q();
            }
        }

        c() {
        }

        @Override // w64.m
        @NotNull
        public com.tencent.mvi.runtime.strategy.b a() {
            k64.d dVar = new k64.d();
            dVar.c(com.tencent.robot.slash.dialog.content.middle.a.class, new C10887a(a.this));
            return dVar;
        }
    }

    public a(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
        this.mStorageHelper = new q54.a();
        AIOContact c16 = mAIOContext.g().r().c();
        this.mChatCookie = c16.f() + "_" + c16.j();
        this.mIsInlineSearchEnable = ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).isInlineSearchEnable(mAnchorView.getContext());
    }

    private final void p(ArrayList<b74.a> functionItemDataList) {
        List<m64.a> a16 = this.mStorageHelper.a(t());
        if (a16.isEmpty()) {
            return;
        }
        ConvertSearchTools.f368422a.a(a16, functionItemDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b q() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m r() {
        return new c();
    }

    private final com.tencent.robot.slash.businessapi.a s(ArrayList<CommonBotFeatures> robotFeaturesList, String keyword) {
        ArrayList<b74.a> f16;
        x(robotFeaturesList);
        if (this.mIsInlineSearchEnable) {
            f16 = ConvertSearchTools.f368422a.g(robotFeaturesList, keyword);
        } else {
            f16 = ConvertSearchTools.f368422a.f(robotFeaturesList, keyword);
        }
        ArrayList<b74.a> arrayList = f16;
        p(arrayList);
        List<b.UIModelData> b16 = ConvertSearchTools.f368422a.b(arrayList);
        CollectionsKt__MutableCollectionsKt.removeFirstOrNull(arrayList);
        return new com.tencent.robot.slash.businessapi.a(arrayList, b16, 0, 4, null);
    }

    private final String t() {
        return this.mAIOContext.g().r().c().f();
    }

    private final void u(CommonBotInfo robotInfo, CommonBotFeatureInfo commandInfo) {
        i(robotInfo, commandInfo, 1);
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).handleSlashOnCommandItemClick(this.mAIOContext, robotInfo, commandInfo);
    }

    private final void v(CommonBotInfo robotInfo, CommonBotFeatureInfo commandInfo) {
        i(robotInfo, commandInfo, 2);
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).handleSlashOnServiceItemClick(this.mAIOContext, robotInfo, commandInfo);
    }

    private final void w(CommonBotInfo robotInfo) {
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).handleSlashOnTitleClick(this.mAIOContext, String.valueOf(robotInfo.tinyid));
    }

    private final void x(ArrayList<CommonBotFeatures> robotFeaturesList) {
        if (robotFeaturesList.isEmpty()) {
            return;
        }
        List<String> b16 = this.mStorageHelper.b(t());
        if (b16.isEmpty()) {
            return;
        }
        ConvertSearchTools.f368422a.m(b16, robotFeaturesList);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData instanceof x54.b) {
            x54.b bVar = (x54.b) itemData;
            u(bVar.getRobotInfo(), bVar.getCommandInfo());
            return;
        }
        if (itemData instanceof z54.b) {
            z54.b bVar2 = (z54.b) itemData;
            u(bVar2.getRobotInfo(), bVar2.getCommandInfo());
            return;
        }
        if (itemData instanceof d64.b) {
            d64.b bVar3 = (d64.b) itemData;
            v(bVar3.getRobotInfo(), bVar3.getServiceInfo());
        } else if (itemData instanceof a64.b) {
            a64.b bVar4 = (a64.b) itemData;
            v(bVar4.getRobotInfo(), bVar4.getServiceInfo());
        } else if (itemData instanceof e64.b) {
            w(((e64.b) itemData).getRobotInfo());
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String robotUin, @NotNull String robotTinyId) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(robotTinyId, "robotTinyId");
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).handleSlashOnTitleClick(this.mAIOContext, robotTinyId);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        c.a.c(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).reportSlashPageIn(rootView, this.mAIOContext);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        if (itemArgs.getFunctionType() == 1) {
            b54.c.f27957a.a(itemArgs);
            ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).reportRobotCommandJump(itemArgs.getItemView());
        } else if (itemArgs.getFunctionType() == 2) {
            b54.c.f27957a.c(itemArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).reportSlashPageOut(rootView, this.mAIOContext);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs itemArgs) {
        Intrinsics.checkNotNullParameter(itemArgs, "itemArgs");
        if (itemArgs.getFunctionType() == 1) {
            b54.c.f27957a.b(itemArgs);
        } else if (itemArgs.getFunctionType() == 2) {
            b54.c.f27957a.d(itemArgs);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    public u54.c h() {
        AIOContact c16 = this.mAIOContext.g().r().c();
        return new o54.b(((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).isDirectRobotAIO(this.mAIOContext), c16.f(), c16.j(), c16.e());
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public boolean hideKeyboard() {
        InputMethodManager inputMethodManager;
        IBinder windowToken = this.mAnchorView.getWindowToken();
        if (windowToken != null && (inputMethodManager = (InputMethodManager) this.mAnchorView.getContext().getSystemService(InputMethodManager.class)) != null) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void i(@NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo functionInfo, int functionType) {
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(functionInfo, "functionInfo");
        this.mStorageHelper.e(t(), robotInfo, functionInfo, functionType);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (searchResponse instanceof List) {
            ArrayList<CommonBotFeatures> arrayList = new ArrayList<>();
            for (Object obj : (Iterable) searchResponse) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatures");
                arrayList.add((CommonBotFeatures) obj);
            }
            return s(arrayList, keyword);
        }
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public SearchSessionParams k(@Nullable Object args) {
        AIOContact c16 = this.mAIOContext.g().r().c();
        return new SearchSessionParams(new Contact(c16.e(), c16.j(), c16.f()), new ArrayList(), new ArrayList(), CommonBotScene.KCHANNEL, CommonBotFilter.KNONE, this.mChatCookie);
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    /* renamed from: l, reason: from getter */
    public View getMAnchorView() {
        return this.mAnchorView;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public n<u54.c> m(@NotNull com.tencent.mvi.api.runtime.b mviContext) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        return new C10885a(mviContext, this);
    }
}
