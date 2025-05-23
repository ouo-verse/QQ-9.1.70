package com.tencent.mobileqq.troop.homework.clockin.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailBottomPart;
import com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailLoadingPart;
import com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailRecyclerRootPart;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$2;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$3;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$4;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001\u001b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/HWClockInDetailFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "wh", "", "teacher", "yh", "", "uh", OcrConfig.CHINESE, "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "useQUISecNavBar", "onDestroyView", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "vh", "()Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", "viewModel", "com/tencent/mobileqq/troop/homework/clockin/detail/HWClockInDetailFragment$moreBtnAction$1", "D", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/HWClockInDetailFragment$moreBtnAction$1;", "moreBtnAction", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HWClockInDetailFragment$moreBtnAction$1 moreBtnAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/HWClockInDetailFragment$a;", "", "", "troopUin", "clockInId", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "from", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.HWClockInDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull String troopUin, @NotNull String clockInId, @NotNull IHWTroopUIApi.DetailPageFrom from) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, clockInId, from);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(clockInId, "clockInId");
            Intrinsics.checkNotNullParameter(from, "from");
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToast(0, R.string.f171139ci4);
                return;
            }
            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
            if (troopInfoFromCache != null && troopInfoFromCache.isMember()) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("troop_uin", troopUin);
                intent.putExtra("clock_in_id", clockInId);
                intent.putExtra("detail_from", from);
                QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, HWClockInDetailFragment.class);
                QLog.i("HW.ClockIn.DETAIL.", 1, "SchoolPartner CheckIn list page click item");
                return;
            }
            QQToastUtil.showQQToastInUiThread(0, "\u6682\u65e0\u67e5\u770b\u8be5\u6253\u5361\u6743\u9650");
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296282a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41443);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IHWTroopUIApi.DetailPageFrom.values().length];
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.GROUP_ARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.C2C_ARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.NOTICE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.GROUP_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f296282a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41567);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.troop.homework.clockin.detail.HWClockInDetailFragment$moreBtnAction$1] */
    public HWClockInDetailFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HWClockInDetailViewModel.class), new HWViewModelsExtKt$hwViewModels$3(new HWViewModelsExtKt$hwViewModels$2(this)), new HWViewModelsExtKt$hwViewModels$4(this));
        this.moreBtnAction = new com.tencent.biz.qui.quisecnavbar.a() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.HWClockInDetailFragment$moreBtnAction$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final int drawable;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final int drawableInTransparent;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInDetailFragment.this);
                } else {
                    this.drawable = R.drawable.qui_more_icon_navigation_01_selector;
                    this.drawableInTransparent = R.drawable.qui_more;
                }
            }

            @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
            public void a(@Nullable View view) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(HWClockInDetailFragment.this), null, null, new HWClockInDetailFragment$moreBtnAction$1$onRightClick$1(HWClockInDetailFragment.this, null), 3, null);
                } else {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) view);
                }
            }

            @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
            public int d() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 3, (Object) this)).intValue();
                }
                return this.drawableInTransparent;
            }

            @Override // com.tencent.biz.qui.quisecnavbar.b
            public int getDrawable() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this)).intValue();
                }
                return this.drawable;
            }
        };
    }

    private final int uh() {
        int i3 = b.f296282a[vh().W1().ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 == 4) {
            return 4;
        }
        if (i3 == 5) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWClockInDetailViewModel vh() {
        return (HWClockInDetailViewModel) this.viewModel.getValue();
    }

    private final void wh() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> obtainUiState = vh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.HWClockInDetailFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.detail.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.detail.vm.a aVar) {
                HWClockInDetailFragment$moreBtnAction$1 hWClockInDetailFragment$moreBtnAction$1;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.g) {
                    HWClockInDetailFragment.this.yh(((a.g) aVar).a());
                    return;
                }
                if (aVar instanceof a.k) {
                    HWClockInDetailFragment.this.zh();
                    return;
                }
                if (aVar instanceof a.f) {
                    FragmentActivity activity = HWClockInDetailFragment.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                if (aVar instanceof a.j) {
                    HWClockInDetailFragment hWClockInDetailFragment = HWClockInDetailFragment.this;
                    QUISecNavBar qUISecNavBar = hWClockInDetailFragment.quiSecNavBar;
                    hWClockInDetailFragment$moreBtnAction$1 = hWClockInDetailFragment.moreBtnAction;
                    View h16 = qUISecNavBar.h(hWClockInDetailFragment$moreBtnAction$1);
                    if (h16 != null) {
                        ab.c(h16);
                    }
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInDetailFragment.xh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh(boolean teacher) {
        String str;
        HashMap<String, Object> hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (teacher) {
            str = "pg_group_teacher_clock_in_detail";
        } else {
            str = "pg_group_parent_clock_in_detail";
        }
        com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", vh().a2()), TuplesKt.to(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(uh())));
        aVar.b(activity, str, hashMapOf, true);
        VideoReport.reportPgIn(activity.getWindow().getDecorView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        if (this.quiSecNavBar.h(this.moreBtnAction) != null) {
            return;
        }
        this.quiSecNavBar.setRightType(2);
        this.quiSecNavBar.d(this.moreBtnAction);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new HWClockInDetailRecyclerRootPart(), new HWClockInDetailBottomPart(), new HWClockInDetailLoadingPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f168600g00;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        VideoReport.reportPgOut(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u6253\u5361\u8be6\u60c5");
        wh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
