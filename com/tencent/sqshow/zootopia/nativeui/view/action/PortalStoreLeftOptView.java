package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b94.d;
import b94.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.nativeui.view.AvatarPanelViewData;
import com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import n74.bz;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001\u0016B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0012\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0016\u0010-\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\"R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/g;", "", "k", "u", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "l", ReportConstant.COSTREPORT_PREFIX, "w", "Ln74/bz;", "binding", "panelChannel", "o", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "ueAvatarGender", "v", "", "style", "setStyle", DomainData.DOMAIN_NAME, "a", "b", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Ln74/bz;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "e", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "mCurrentPanelViewData", "f", "I", "genderRedDotId", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getMChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setMChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "i", "mStyle", "currentSlotId", "Landroidx/lifecycle/Observer;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/Observer;", "slotIdObserve", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreLeftOptView extends FrameLayout implements com.tencent.sqshow.zootopia.nativeui.view.history.g {

    /* renamed from: C, reason: from kotlin metadata */
    private final Observer<Integer> slotIdObserve;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bz mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AvatarPanelViewData mCurrentPanelViewData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int genderRedDotId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mStyle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentSlotId;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<uv4.w> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371438e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371439f;

        b(com.tencent.sqshow.zootopia.nativeui.data.j jVar, com.tencent.sqshow.zootopia.nativeui.data.j jVar2) {
            this.f371438e = jVar;
            this.f371439f = jVar2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.w result) {
            Intrinsics.checkNotNullParameter(result, "result");
            PortalStoreLeftOptView.this.l(this.f371438e);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b94.e O = this.f371439f.O();
            if (O != null) {
                O.S2();
            }
            this.f371439f.getCameraController().i();
            QLog.e("PortalStoreLeftOptView_", 1, "changeGenderV1 failed, error=" + error + ", message=" + message);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView$c", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements m94.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371440a;

        c(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371440a = jVar;
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            b94.e O = this.f371440a.O();
            if (O != null) {
                O.S2();
            }
            this.f371440a.getCameraController().i();
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            b94.e O = this.f371440a.O();
            if (O != null) {
                O.S2();
            }
            this.f371440a.getCameraController().i();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView$d", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements m94.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371442b;

        d(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371442b = jVar;
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            PortalStoreLeftOptView.this.l(this.f371442b);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView$e", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements m94.h {
        e() {
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreLeftOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void k() {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 == null || (lifecycleOwner = jVar2.getLifecycleOwner()) == null || (jVar = this.mChannel) == null) {
            return;
        }
        this.mBinding.f418951b.k(lifecycleOwner, jVar.t(), this.currentSlotId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        channel.k().setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PortalStoreLeftOptView this$0, final com.tencent.sqshow.zootopia.nativeui.data.j panelChannel, bz binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this$0.mChannel;
        if (jVar != null && u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_gender", Integer.valueOf(n3.getIndex()));
            ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
            RelativeLayout relativeLayout = binding.f418955f;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.switchGenderRl");
            mReporter.e(relativeLayout, "em_zplan_gender_switch", hashMap);
            b94.e O = panelChannel.O();
            if (O != null) {
                e.a.h(O, 0L, 1, null);
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.w
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreLeftOptView.r(com.tencent.sqshow.zootopia.nativeui.data.j.this);
                }
            };
            panelChannel.getCameraController().h();
            b94.d avatarDressController = panelChannel.getAvatarDressController();
            if (avatarDressController != null) {
                d.a.c(avatarDressController, null, new b(jVar, panelChannel), runnable, 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        b94.d avatarDressController = panelChannel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.h(avatarDressController, new c(panelChannel), true, false, 4, null);
        }
    }

    private final void s() {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        LifecycleOwner lifecycleOwner;
        bz bzVar = this.mBinding;
        if (bzVar == null || (jVar = this.mChannel) == null || (lifecycleOwner = jVar.getLifecycleOwner()) == null) {
            return;
        }
        bzVar.f418951b.p(jVar);
        o(bzVar, jVar);
        LiveData<Boolean> a16 = jVar.getUeStatusController().a();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreLeftOptView$initViews$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PortalStoreLeftOptView.this.w();
            }
        };
        a16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreLeftOptView.t(Function1.this, obj);
            }
        });
        bzVar.f418951b.setListener(this);
        bzVar.f418951b.j(lifecycleOwner, jVar.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void u() {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (lifecycleOwner = jVar.getLifecycleOwner()) == null) {
            return;
        }
        g94.e.f401573a.c().observe(lifecycleOwner, this.slotIdObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(bz binding, UEAvatarGender ueAvatarGender) {
        QLog.d("PortalStoreLeftOptView_", 1, "refreshGenderView ueAvatarGender:" + ueAvatarGender);
        binding.f418954e.setImageResource(ueAvatarGender == UEAvatarGender.FEMALE ? R.drawable.ieg : R.drawable.iel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return;
        }
        b94.a engineApi = jVar.getEngineApi();
        int l3 = r94.b.l(this.mCurrentPanelViewData.getCategoryGroup());
        if (l3 == 1) {
            engineApi.f();
            engineApi.c(true);
        } else if (l3 != 2) {
            engineApi.f();
            engineApi.c(true);
        } else {
            engineApi.i();
            engineApi.c(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(PortalStoreLeftOptView this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.currentSlotId = it.intValue();
        this$0.k();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.g
    public void a() {
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar != null && u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            if (this.mStyle == 1) {
                com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
                if (jVar2 == null || (avatarFaceController = jVar2.getAvatarFaceController()) == null) {
                    return;
                }
                t.a.a(avatarFaceController, this.currentSlotId, null, 2, null);
                return;
            }
            com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
            if (jVar3 == null || (avatarDressController = jVar3.getAvatarDressController()) == null) {
                return;
            }
            avatarDressController.Y6(new d(jVar));
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.g
    public void b() {
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.ue.t avatarFaceController;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar != null && u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            if (this.mStyle == 1) {
                com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
                if (jVar2 == null || (avatarFaceController = jVar2.getAvatarFaceController()) == null) {
                    return;
                }
                t.a.b(avatarFaceController, this.currentSlotId, null, 2, null);
                return;
            }
            com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
            if (jVar3 == null || (avatarDressController = jVar3.getAvatarDressController()) == null) {
                return;
            }
            avatarDressController.E9(new e());
        }
    }

    public final void m() {
        this.mBinding.f418952c.setVisibility(8);
    }

    public final void n(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
        s();
        u();
    }

    public final void setStyle(int style) {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        PortalStoreHistoryControllerView portalStoreHistoryControllerView;
        PortalStoreHistoryControllerView portalStoreHistoryControllerView2;
        PortalStoreHistoryControllerView portalStoreHistoryControllerView3;
        PortalStoreHistoryControllerView portalStoreHistoryControllerView4;
        this.mStyle = style;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 == null || (lifecycleOwner = jVar2.getLifecycleOwner()) == null || (jVar = this.mChannel) == null) {
            return;
        }
        int i3 = this.mStyle;
        if (i3 == 0) {
            bz bzVar = this.mBinding;
            if (bzVar != null && (portalStoreHistoryControllerView = bzVar.f418951b) != null) {
                portalStoreHistoryControllerView.j(lifecycleOwner, jVar.r());
            }
            x();
            return;
        }
        if (i3 == 1) {
            bz bzVar2 = this.mBinding;
            if (bzVar2 != null && (portalStoreHistoryControllerView2 = bzVar2.f418951b) != null) {
                portalStoreHistoryControllerView2.k(lifecycleOwner, jVar.t(), this.currentSlotId);
            }
            m();
            return;
        }
        if (i3 != 2) {
            bz bzVar3 = this.mBinding;
            if (bzVar3 == null || (portalStoreHistoryControllerView4 = bzVar3.f418951b) == null) {
                return;
            }
            portalStoreHistoryControllerView4.j(lifecycleOwner, jVar.r());
            return;
        }
        bz bzVar4 = this.mBinding;
        if (bzVar4 != null && (portalStoreHistoryControllerView3 = bzVar4.f418951b) != null) {
            portalStoreHistoryControllerView3.j(lifecycleOwner, jVar.r());
        }
        m();
    }

    public final void x() {
        this.mBinding.f418952c.setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreLeftOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreLeftOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreLeftOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bz f16 = bz.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mCurrentPanelViewData = new AvatarPanelViewData(null, null, null, 0, false, null, 63, null);
        this.genderRedDotId = -1;
        this.mStyle = -1;
        this.slotIdObserve = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreLeftOptView.y(PortalStoreLeftOptView.this, (Integer) obj);
            }
        };
    }

    private final void o(final bz binding, final com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        UEAvatarGender n3 = cVar.n();
        v(binding, n3);
        LifecycleOwner lifecycleOwner = panelChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        LiveData<m94.a> a16 = cVar.m().a();
        final Function1<m94.a, Unit> function1 = new Function1<m94.a, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreLeftOptView$initGenderView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m94.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m94.a aVar) {
                PortalStoreLeftOptView.this.v(binding, aVar.getGender());
                HashMap hashMap = new HashMap();
                hashMap.put("zplan_gender", Integer.valueOf(aVar.getGender().getIndex()));
                ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
                RelativeLayout relativeLayout = binding.f418955f;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.switchGenderRl");
                mReporter.g(relativeLayout, "em_zplan_gender_switch", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        };
        a16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreLeftOptView.p(Function1.this, obj);
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_gender", Integer.valueOf(n3.getIndex()));
        ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
        RelativeLayout relativeLayout = binding.f418955f;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.switchGenderRl");
        mReporter.g(relativeLayout, "em_zplan_gender_switch", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        RelativeLayout relativeLayout2 = binding.f418955f;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.switchGenderRl");
        com.tencent.sqshow.zootopia.utils.aa.d(relativeLayout2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreLeftOptView.q(PortalStoreLeftOptView.this, panelChannel, binding, view);
            }
        });
    }
}
