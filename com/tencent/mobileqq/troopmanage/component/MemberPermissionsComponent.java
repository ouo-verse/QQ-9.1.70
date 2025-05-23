package com.tencent.mobileqq.troopmanage.component;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#Jx\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062@\u0010\u0011\u001a<\u0012\u001d\u0012\u001b\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0002J\"\u0010\u0014\u001a\u00020\u00102\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\"\u0010\u0016\u001a\u00020\u00102\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/MemberPermissionsComponent;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "titleId", "", "elementId", "", "initState", NodeProps.VISIBLE, "Lkotlin/Function2;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lkotlin/ParameterName;", "name", DownloadInfo.spKey_Config, "isChecked", "", "onChecked", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "B", "G", "state", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/Group;", "E", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "g", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class MemberPermissionsComponent extends bv {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/MemberPermissionsComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPermissionsComponent(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        }
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> B(int titleId, final String elementId, boolean initState, boolean visible, final Function2<? super com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, ? super Boolean, Unit> onChecked) {
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> p16 = p(titleId, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>(onChecked, this, elementId) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$createSingleLineSwitch$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $elementId;
            final /* synthetic */ Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit> $onChecked;
            final /* synthetic */ MemberPermissionsComponent this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.$onChecked = onChecked;
                this.this$0 = this;
                this.$elementId = elementId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, onChecked, this, elementId);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, config, Boolean.valueOf(z16));
                    return;
                }
                Intrinsics.checkNotNullParameter(config, "config");
                this.$onChecked.invoke(config, Boolean.valueOf(z16));
                HashMap hashMap = new HashMap();
                hashMap.put("after_click_state", Integer.valueOf(z16 ? 1 : 2));
                this.this$0.k(this.$elementId, hashMap);
            }
        });
        p16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.ay
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                MemberPermissionsComponent.D(com.tencent.mobileqq.widget.listitem.x.this, this, elementId, view);
            }
        });
        p16.O().f(initState);
        p16.p(visible);
        return p16;
    }

    static /* synthetic */ com.tencent.mobileqq.widget.listitem.x C(MemberPermissionsComponent memberPermissionsComponent, int i3, String str, boolean z16, boolean z17, Function2 function2, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 8) != 0) {
                z17 = true;
            }
            return memberPermissionsComponent.B(i3, str, z16, z17, function2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSingleLineSwitch");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(com.tencent.mobileqq.widget.listitem.x this_apply, MemberPermissionsComponent this$0, String elementId, View view) {
        int i3;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        HashMap hashMap = new HashMap();
        if (((x.c.f) this_apply.O()).getIsChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("after_click_state", Integer.valueOf(i3));
        this$0.m(elementId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean state) {
        com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
        String string = b().getString(R.string.cpo);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.operation_error)");
        gVar.b(string);
        j(config, state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(final com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, final boolean isChecked) {
        final String j3 = g().j();
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyEnableHistoryForNewMember(j3, isChecked, e(), new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.component.ax
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str) {
                MemberPermissionsComponent.H(MemberPermissionsComponent.this, j3, isChecked, config, z16, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final MemberPermissionsComponent this$0, String troopUin, boolean z16, final com.tencent.mobileqq.widget.listitem.x config, boolean z17, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        this$0.h().X1().k(z17, troopUin, z16, new Function1<Boolean, Unit>(config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$setEnableHistoryForNewMember$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$config = config;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this, (Object) config);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z18) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    MemberPermissionsComponent.this.F(this.$config, z18);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z18);
                }
            }
        });
    }

    @NotNull
    public Group E() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = b().getString(R.string.z9j);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026_member_permissions_desc)");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[5];
        if ((g().h().troopPrivilegeFlag & 2) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVarArr[0] = C(this, R.string.z9k, "em_group_upload_file", z16, false, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean z26) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, config, Boolean.valueOf(z26));
                    return;
                }
                Intrinsics.checkNotNullParameter(config, "config");
                MemberPermissionsComponent memberPermissionsComponent = MemberPermissionsComponent.this;
                memberPermissionsComponent.o(config, new Function0<Unit>(z26, config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;
                    final /* synthetic */ boolean $isChecked;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$isChecked = z26;
                        this.$config = config;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, MemberPermissionsComponent.this, Boolean.valueOf(z26), config);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            MemberPermissionsComponent.this.h().X1().o(MemberPermissionsComponent.this.g().j(), this.$isChecked, new Function1<Boolean, Unit>(this.$config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent.getComponentGroup.1.1.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    this.$config = r5;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this, (Object) r5);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z27) {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 == null || !iPatchRedirector4.hasPatch((short) 2)) {
                                        MemberPermissionsComponent.this.F(this.$config, z27);
                                    } else {
                                        iPatchRedirector4.redirect((short) 2, (Object) this, z27);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }, 8, null);
        if ((g().h().troopPrivilegeFlag & 1) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        aVarArr[1] = B(R.string.z9l, "em_group_upload_photo_album", z17, !g().e(), new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean z26) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, config, Boolean.valueOf(z26));
                    return;
                }
                Intrinsics.checkNotNullParameter(config, "config");
                MemberPermissionsComponent memberPermissionsComponent = MemberPermissionsComponent.this;
                memberPermissionsComponent.o(config, new Function0<Unit>(z26, config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$2.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;
                    final /* synthetic */ boolean $isChecked;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$isChecked = z26;
                        this.$config = config;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, MemberPermissionsComponent.this, Boolean.valueOf(z26), config);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            MemberPermissionsComponent.this.h().X1().f(MemberPermissionsComponent.this.g().j(), this.$isChecked, new Function1<Boolean, Unit>(this.$config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent.getComponentGroup.2.1.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                    this.$config = r5;
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                        iPatchRedirector4.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this, (Object) r5);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z27) {
                                    IPatchRedirector iPatchRedirector4 = $redirector_;
                                    if (iPatchRedirector4 == null || !iPatchRedirector4.hasPatch((short) 2)) {
                                        MemberPermissionsComponent.this.F(this.$config, z27);
                                    } else {
                                        iPatchRedirector4.redirect((short) 2, (Object) this, z27);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
        if (!g().e() && g().h().isAllowCreateTempConv()) {
            z18 = true;
        } else {
            z18 = false;
        }
        aVarArr[2] = C(this, R.string.z9g, "em_group_start_temporary_chat", z18, false, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean z26) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, config, Boolean.valueOf(z26));
                    return;
                }
                Intrinsics.checkNotNullParameter(config, "config");
                if (MemberPermissionsComponent.this.g().i().bOwner) {
                    MemberPermissionsComponent memberPermissionsComponent = MemberPermissionsComponent.this;
                    memberPermissionsComponent.o(config, new Function0<Unit>(z26, config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$3.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;
                        final /* synthetic */ boolean $isChecked;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$isChecked = z26;
                            this.$config = config;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, MemberPermissionsComponent.this, Boolean.valueOf(z26), config);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                MemberPermissionsComponent.this.h().n2(this.$isChecked, MemberPermissionsComponent.this.g().j(), this.$isChecked ? 0L : 65536L, 65536L, new Function1<Boolean, Unit>(this.$config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent.getComponentGroup.3.1.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                        this.$config = r5;
                                        IPatchRedirector iPatchRedirector4 = $redirector_;
                                        if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                            iPatchRedirector4.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this, (Object) r5);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z27) {
                                        IPatchRedirector iPatchRedirector4 = $redirector_;
                                        if (iPatchRedirector4 == null || !iPatchRedirector4.hasPatch((short) 2)) {
                                            MemberPermissionsComponent.this.F(this.$config, z27);
                                        } else {
                                            iPatchRedirector4.redirect((short) 2, (Object) this, z27);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                MemberPermissionsComponent.this.j(config, !z26);
                com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                String string2 = MemberPermissionsComponent.this.b().getString(R.string.esz);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t\u2026ly_owner_can_set_discuss)");
                gVar.d(string2);
            }
        }, 8, null);
        if (!g().e() && g().h().isAllowCreateDiscuss()) {
            z19 = true;
        } else {
            z19 = false;
        }
        aVarArr[3] = C(this, R.string.z9f, "em_group_start_new_chat", z19, false, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean z26) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, config, Boolean.valueOf(z26));
                    return;
                }
                Intrinsics.checkNotNullParameter(config, "config");
                if (MemberPermissionsComponent.this.g().i().bOwner) {
                    MemberPermissionsComponent memberPermissionsComponent = MemberPermissionsComponent.this;
                    memberPermissionsComponent.o(config, new Function0<Unit>(z26, config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$4.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;
                        final /* synthetic */ boolean $isChecked;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$isChecked = z26;
                            this.$config = config;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, MemberPermissionsComponent.this, Boolean.valueOf(z26), config);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                MemberPermissionsComponent.this.h().n2(this.$isChecked, MemberPermissionsComponent.this.g().j(), this.$isChecked ? 0L : 32768L, 32768L, new Function1<Boolean, Unit>(this.$config) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent.getComponentGroup.4.1.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                        this.$config = r5;
                                        IPatchRedirector iPatchRedirector4 = $redirector_;
                                        if (iPatchRedirector4 != null && iPatchRedirector4.hasPatch((short) 1)) {
                                            iPatchRedirector4.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this, (Object) r5);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z27) {
                                        IPatchRedirector iPatchRedirector4 = $redirector_;
                                        if (iPatchRedirector4 == null || !iPatchRedirector4.hasPatch((short) 2)) {
                                            MemberPermissionsComponent.this.F(this.$config, z27);
                                        } else {
                                            iPatchRedirector4.redirect((short) 2, (Object) this, z27);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                MemberPermissionsComponent.this.j(config, !z26);
                com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                String string2 = MemberPermissionsComponent.this.b().getString(R.string.esz);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t\u2026ly_owner_can_set_discuss)");
                gVar.d(string2);
            }
        }, 8, null);
        aVarArr[4] = B(R.string.z97, "em_group_recent_history_visible_default", g().h().isHistoryMsgReadEnableForNewMember(), !g().e(), new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MemberPermissionsComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> config, boolean z26) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, config, Boolean.valueOf(z26));
                    return;
                }
                Intrinsics.checkNotNullParameter(config, "config");
                MemberPermissionsComponent memberPermissionsComponent = MemberPermissionsComponent.this;
                memberPermissionsComponent.o(config, new Function0<Unit>(config, z26) { // from class: com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent$getComponentGroup$5.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<?, x.c.f> $config;
                    final /* synthetic */ boolean $isChecked;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$config = config;
                        this.$isChecked = z26;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, MemberPermissionsComponent.this, config, Boolean.valueOf(z26));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            MemberPermissionsComponent.this.G(this.$config, this.$isChecked);
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        });
        return new Group(string, aVarArr);
    }
}
