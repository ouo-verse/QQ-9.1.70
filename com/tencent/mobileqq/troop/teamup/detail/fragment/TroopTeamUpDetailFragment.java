package com.tencent.mobileqq.troop.teamup.detail.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.detail.common.a;
import com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailContentPart;
import com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart;
import com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailOwnerPart;
import com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleBarPart;
import com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleInfoPart;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/fragment/TroopTeamUpDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/content/Intent;", "intent", "onNewIntent", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "vm", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/fragment/TroopTeamUpDetailFragment$a;", "", "Landroid/content/Context;", "context", "", "troopUin", "teamId", "tempId", "", "showMore", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detail", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.fragment.TroopTeamUpDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Context context, @NotNull String troopUin, @NotNull TeamUpTeamDetail detail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, context, troopUin, detail);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intent intent = new Intent();
            intent.putExtra("KEY_DETAIL", detail);
            intent.putExtra("KEY_TROOP_UIN", troopUin);
            intent.putExtra("KEY_TEAM_ID", detail.teamId);
            intent.putExtra("KEY_TEMP_ID", detail.templateId);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, TroopTeamUpDetailFragment.class);
        }

        public final void b(@NotNull Context context, @NotNull String troopUin, @NotNull String teamId, @NotNull String tempId, boolean showMore) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, troopUin, teamId, tempId, Boolean.valueOf(showMore));
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(teamId, "teamId");
            Intrinsics.checkNotNullParameter(tempId, "tempId");
            Intent intent = new Intent();
            intent.putExtra("KEY_TROOP_UIN", troopUin);
            intent.putExtra("KEY_TEAM_ID", teamId);
            intent.putExtra("KEY_TEMP_ID", tempId);
            intent.putExtra("KEY_SHOW_MORE", showMore);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, TroopTeamUpDetailFragment.class);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpDetailFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpDetailVM>() { // from class: com.tencent.mobileqq.troop.teamup.detail.fragment.TroopTeamUpDetailFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopTeamUpDetailVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? TroopTeamUpDetailVM.INSTANCE.a(TroopTeamUpDetailFragment.this) : (TroopTeamUpDetailVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TroopTeamUpDetailVM ph() {
        return (TroopTeamUpDetailVM) this.vm.getValue();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopTeamUpDetailTitleBarPart(), new TroopTeamUpDetailTitleInfoPart(), new TroopTeamUpDetailContentPart(), new TroopTeamUpDetailOwnerPart(), new TroopTeamUpDetailCustomPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g1v;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        ph().init(arguments);
        a.f298875a.e(this, ph().k2(), ph().i2(), ph().j2());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        PartManager partManager = getPartManager();
        if (partManager != null) {
            partManager.onNewIntent(intent);
        }
    }
}
