package com.tencent.mobileqq.troop.troopsetting.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/api/impl/a;", "Lcom/tencent/mobileqq/troop/api/ITroopMemberInfoService$b;", "Ljava/util/ArrayList;", "", "troopList", "", "g", "troopUin", "a", "memberUin", "b", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "changeList", "e", "remark", "c", "d", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class a implements ITroopMemberInfoService.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
    public void a(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
    public void b(@Nullable String troopUin, @Nullable String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) memberUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
    public void c(@Nullable String memberUin, @Nullable String remark) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) memberUin, (Object) remark);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
    public void d(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
    public void e(@Nullable String troopUin, @Nullable List<TroopMemberInfo> changeList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin, (Object) changeList);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.b
    public void g(@Nullable ArrayList<String> troopList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopList);
        }
    }
}
