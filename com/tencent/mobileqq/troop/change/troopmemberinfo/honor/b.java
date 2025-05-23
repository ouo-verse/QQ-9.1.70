package com.tencent.mobileqq.troop.change.troopmemberinfo.honor;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/change/troopmemberinfo/honor/b;", "Lcom/tencent/mobileqq/troop/change/troopmemberinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "b", "a", "c", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/troop/change/troopmemberinfo/honor/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mTroopMemberInfoHonorMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mInfoChangedSet", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements com.tencent.mobileqq.troop.change.troopmemberinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, a> mTroopMemberInfoHonorMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> mInfoChangedSet;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mTroopMemberInfoHonorMap = new HashMap<>();
            this.mInfoChangedSet = new HashSet<>();
        }
    }

    @Override // com.tencent.mobileqq.troop.change.troopmemberinfo.a
    public void a(@Nullable TroopMemberInfo troopMemberInfo) {
        a aVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopMemberInfo);
            return;
        }
        if (troopMemberInfo != null && (aVar = this.mTroopMemberInfoHonorMap.get(troopMemberInfo.memberuin)) != null) {
            if (Intrinsics.areEqual(aVar.a(), troopMemberInfo.honorList)) {
                String a16 = aVar.a();
                boolean z17 = true;
                if (a16 != null && a16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Byte b16 = aVar.b();
                    if (b16 == null || b16.byteValue() != troopMemberInfo.mHonorRichFlag) {
                        z17 = false;
                    }
                    if (z17) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.mInfoChangedSet.add(troopMemberInfo.memberuin);
            aVar.e(troopMemberInfo.honorList);
            aVar.f(Byte.valueOf(troopMemberInfo.mHonorRichFlag));
        }
    }

    @Override // com.tencent.mobileqq.troop.change.troopmemberinfo.a
    public void b(@Nullable TroopMemberInfo troopMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
            return;
        }
        if (troopMemberInfo != null) {
            HashMap<String, a> hashMap = this.mTroopMemberInfoHonorMap;
            String str = troopMemberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "it.memberuin");
            String str2 = troopMemberInfo.troopuin;
            Intrinsics.checkNotNullExpressionValue(str2, "troopMemberInfo.troopuin");
            String str3 = troopMemberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str3, "troopMemberInfo.memberuin");
            hashMap.put(str, new a(str2, str3, troopMemberInfo.honorList, Byte.valueOf(troopMemberInfo.mHonorRichFlag)));
        }
    }

    @Override // com.tencent.mobileqq.troop.change.troopmemberinfo.a
    public void c() {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<T> it = this.mInfoChangedSet.iterator();
        while (it.hasNext()) {
            a aVar = this.mTroopMemberInfoHonorMap.get((String) it.next());
            if (aVar != null) {
                ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) QRoute.api(ITroopUtilApi.class);
                String d16 = aVar.d();
                String c16 = aVar.c();
                String a16 = aVar.a();
                Byte b17 = aVar.b();
                if (b17 != null) {
                    b16 = b17.byteValue();
                } else {
                    b16 = 0;
                }
                iTroopUtilApi.onTroopMemberHonorInfoChanged(d16, c16, a16, b16);
            }
        }
        this.mTroopMemberInfoHonorMap.clear();
        this.mInfoChangedSet.clear();
    }
}
