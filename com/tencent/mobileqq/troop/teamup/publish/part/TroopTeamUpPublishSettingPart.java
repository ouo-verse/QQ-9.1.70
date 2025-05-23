package com.tencent.mobileqq.troop.teamup.publish.part;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.data.TroopTeamUpJoinType;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpPublishLayout;
import com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishSettingPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "d", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "data", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "e", "F9", "()Lcom/tencent/mobileqq/widget/listitem/x;", "joinTypeConfig", "f", "E9", "deadlineConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishSettingPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy joinTypeConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy deadlineConfig;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishSettingPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<TroopTeamUpPublishVM> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopTeamUpPublishVM cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f299145e;

        public a(Part part) {
            this.f299145e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopTeamUpPublishVM getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopTeamUpPublishVM troopTeamUpPublishVM = this.cached;
            Object partHost = this.f299145e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopTeamUpPublishVM == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopTeamUpPublishVM.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopTeamUpPublishVM;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public TroopTeamUpPublishSettingPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new TroopTeamUpPublishSettingPart$joinTypeConfig$2(this));
        this.joinTypeConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new TroopTeamUpPublishSettingPart$deadlineConfig$2(this));
        this.deadlineConfig = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeamUpPublishVM D9() {
        return (TroopTeamUpPublishVM) this.data.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x<x.b.d, x.c.g> E9() {
        return (x) this.deadlineConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x<x.b.d, x.c.g> F9() {
        return (x) this.joinTypeConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopTeamUp.PublishPublishSettingPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable final View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (!(rootView instanceof TroopTeamUpPublishLayout)) {
            return;
        }
        MutableLiveData<List<Group>> S1 = D9().S1();
        List<Group> value = S1.getValue();
        List<Group> list = null;
        if (value != null) {
            value.add(new Group(F9()));
        } else {
            value = null;
        }
        S1.postValue(value);
        MutableLiveData<TroopTeamUpJoinType> N1 = D9().N1();
        LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        Intrinsics.checkNotNull(a16);
        final Function1<TroopTeamUpJoinType, Unit> function1 = new Function1<TroopTeamUpJoinType, Unit>(rootView) { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishSettingPart$onInitView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $rootView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$rootView = rootView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpPublishSettingPart.this, (Object) rootView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopTeamUpJoinType troopTeamUpJoinType) {
                invoke2(troopTeamUpJoinType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopTeamUpJoinType troopTeamUpJoinType) {
                x F9;
                x F92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopTeamUpJoinType);
                    return;
                }
                F9 = TroopTeamUpPublishSettingPart.this.F9();
                x.c.g gVar = (x.c.g) F9.O();
                String string = TroopTeamUpPublishSettingPart.this.getContext().getString(troopTeamUpJoinType != null ? troopTeamUpJoinType.getDescriptionRes() : R.string.f236407e_);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026ease_choose\n            )");
                gVar.h(string);
                QUIListItemAdapter adapter = ((TroopTeamUpPublishLayout) this.$rootView).e().getAdapter();
                if (adapter != null) {
                    F92 = TroopTeamUpPublishSettingPart.this.F9();
                    adapter.l0(F92);
                }
            }
        };
        N1.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpPublishSettingPart.G9(Function1.this, obj);
            }
        });
        MutableLiveData<List<Group>> S12 = D9().S1();
        List<Group> value2 = S12.getValue();
        if (value2 != null) {
            value2.add(new Group(E9()));
            list = value2;
        }
        S12.postValue(list);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M\u6708d\u65e5 E H\u65f6m\u5206", Locale.getDefault());
        MutableLiveData<Calendar> M1 = D9().M1();
        LifecycleOwner a17 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        Intrinsics.checkNotNull(a17);
        final Function1<Calendar, Unit> function12 = new Function1<Calendar, Unit>(simpleDateFormat, rootView) { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishSettingPart$onInitView$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ SimpleDateFormat $formatter;
            final /* synthetic */ View $rootView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$formatter = simpleDateFormat;
                this.$rootView = rootView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopTeamUpPublishSettingPart.this, simpleDateFormat, rootView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Calendar calendar) {
                invoke2(calendar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Calendar calendar) {
                x E9;
                String format;
                x E92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) calendar);
                    return;
                }
                E9 = TroopTeamUpPublishSettingPart.this.E9();
                x.c.g gVar = (x.c.g) E9.O();
                if (calendar == null) {
                    format = TroopTeamUpPublishSettingPart.this.getContext().getString(R.string.f236407e_);
                    Intrinsics.checkNotNullExpressionValue(format, "{\n                contex\u2026ase_choose)\n            }");
                } else {
                    format = this.$formatter.format(calendar.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "{\n                format\u2026at(it.time)\n            }");
                }
                gVar.h(format);
                QUIListItemAdapter adapter = ((TroopTeamUpPublishLayout) this.$rootView).e().getAdapter();
                if (adapter != null) {
                    E92 = TroopTeamUpPublishSettingPart.this.E9();
                    adapter.l0(E92);
                }
            }
        };
        M1.observe(a17, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpPublishSettingPart.H9(Function1.this, obj);
            }
        });
    }
}
