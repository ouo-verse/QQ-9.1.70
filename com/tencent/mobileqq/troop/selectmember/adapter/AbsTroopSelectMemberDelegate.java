package com.tencent.mobileqq.troop.selectmember.adapter;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.selectmember.bean.a;
import com.tencent.mobileqq.troop.selectmember.bean.b;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0005:\u0001,B\u0007\u00a2\u0006\u0004\b*\u0010+R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\u0004\u0018\u00010\"8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u000f\u0010#R\u001f\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&\u0018\u00010%8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "d", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "g", "()Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "j", "(Lcom/tencent/mobileqq/troop/selectmember/vm/a;)V", "vmOperator", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "e", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "i", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;)V", "launchConfig", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;", "f", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;", "c", "()Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;", h.F, "(Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;)V", "itemClickListener", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "curTroopInfo", "Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "()Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "robotService", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "()Landroidx/lifecycle/LiveData;", "selectedItemsLiveData", "<init>", "()V", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class AbsTroopSelectMemberDelegate<I extends com.tencent.mobileqq.troop.selectmember.bean.a, VH extends RecyclerView.ViewHolder> extends AbsListItemAdapterDelegate<I, com.tencent.mobileqq.troop.selectmember.bean.a, VH> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.selectmember.vm.a vmOperator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopSelectMemberConfig launchConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a itemClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy curTroopInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy robotService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "data", "", "position", "", "l6", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "r3", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void l6(@NotNull c data, int position);

        void r3(@NotNull b data, int position);
    }

    public AbsTroopSelectMemberDelegate() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopInfo>(this) { // from class: com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate$curTroopInfo$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AbsTroopSelectMemberDelegate<I, VH> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final TroopInfo invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopInfo) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ITroopInfoRepoApi iTroopInfoRepoApi = (ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class);
                    TroopSelectMemberConfig d16 = this.this$0.d();
                    return iTroopInfoRepoApi.getTroopInfoFromCache(d16 != null ? d16.q() : null);
                }
            });
            this.curTroopInfo = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ITroopRobotService>() { // from class: com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate$robotService$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final ITroopRobotService invoke() {
                    return (ITroopRobotService) bg.m(ITroopRobotService.class, "all");
                }
            });
            this.robotService = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Nullable
    public final TroopInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (TroopInfo) this.curTroopInfo.getValue();
    }

    @Nullable
    public final a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.itemClickListener;
    }

    @Nullable
    public final TroopSelectMemberConfig d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.launchConfig;
    }

    @Nullable
    public final ITroopRobotService e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ITroopRobotService) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (ITroopRobotService) this.robotService.getValue();
    }

    @Nullable
    public final LiveData<List<c>> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        com.tencent.mobileqq.troop.selectmember.vm.a aVar = this.vmOperator;
        if (aVar != null) {
            return aVar.P();
        }
        return null;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.selectmember.vm.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.selectmember.vm.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.vmOperator;
    }

    public final void h(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.itemClickListener = aVar;
        }
    }

    public final void i(@Nullable TroopSelectMemberConfig troopSelectMemberConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopSelectMemberConfig);
        } else {
            this.launchConfig = troopSelectMemberConfig;
        }
    }

    public final void j(@Nullable com.tencent.mobileqq.troop.selectmember.vm.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.vmOperator = aVar;
        }
    }
}
