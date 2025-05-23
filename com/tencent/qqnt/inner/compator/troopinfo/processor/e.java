package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/e;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "c", "a", "", "Z", "isOriginNewTroop", "isOriginSetTroopHead", "isOriginHadJoinTroop", "", "d", "I", "originMemberNum", "", "", "e", "Ljava/util/List;", "needRefreshNewTroopList", "<init>", "()V", "f", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isOriginNewTroop;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isOriginSetTroopHead;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isOriginHadJoinTroop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int originMemberNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> needRefreshNewTroopList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.inner.compator.troopinfo.processor.e$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isOriginNewTroop = true;
            this.needRefreshNewTroopList = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TroopInfo troopInfo) {
        AvatarInfoCheck.b(8, troopInfo.troopuin);
        AvatarInfoCheck.b(4, troopInfo.troopuin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TroopInfo troopInfo) {
        AvatarInfoCheck.b(8, troopInfo.troopuin);
        AvatarInfoCheck.b(4, troopInfo.troopuin);
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void a() {
        BusinessHandler businessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.needRefreshNewTroopList.size() > 1) {
            AppInterface e16 = bg.e();
            TroopMemberListHandler troopMemberListHandler = null;
            if (e16 != null) {
                businessHandler = e16.getBusinessHandler(TroopMemberListHandler.class.getName());
            } else {
                businessHandler = null;
            }
            if (businessHandler instanceof TroopMemberListHandler) {
                troopMemberListHandler = (TroopMemberListHandler) businessHandler;
            }
            if (troopMemberListHandler != null) {
                troopMemberListHandler.F2(this.needRefreshNewTroopList);
                return;
            }
            return;
        }
        if (this.needRefreshNewTroopList.size() == 1) {
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(String.valueOf(this.needRefreshNewTroopList.get(0).longValue()));
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void b(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo != null) {
            this.isOriginNewTroop = troopInfo.isNewTroop;
            this.isOriginSetTroopHead = troopInfo.hasSetNewTroopHead;
            this.isOriginHadJoinTroop = troopInfo.hadJoinTroop();
            this.originMemberNum = troopInfo.getMemberNum();
            return;
        }
        this.isOriginNewTroop = true;
        this.isOriginSetTroopHead = false;
        this.isOriginHadJoinTroop = false;
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable final TroopInfo troopInfo) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo == null) {
            return;
        }
        boolean z16 = troopInfo.isNewTroop;
        boolean z17 = troopInfo.hasSetNewTroopHead;
        int memberNum = troopInfo.getMemberNum();
        boolean z18 = true;
        if (!troopInfo.hadJoinTroop() && this.isOriginHadJoinTroop) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopFaceInfoChangedProcessor", 2, "afterUpdateInfo: had quit troop, troopUin=" + troopInfo.troopuin);
            }
            com.tencent.qqnt.troop.inner.a.f362725a.d(troopInfo.troopuin, true);
            bg.k(new Runnable() { // from class: com.tencent.qqnt.inner.compator.troopinfo.processor.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(TroopInfo.this);
                }
            });
            return;
        }
        com.tencent.qqnt.troop.inner.a aVar = com.tencent.qqnt.troop.inner.a.f362725a;
        boolean a16 = aVar.a(troopInfo.getTroopUin());
        boolean hasSetTroopHead = troopInfo.hasSetTroopHead();
        if (a16 != hasSetTroopHead) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopFaceInfoChangedProcessor", 2, "afterUpdateInfo: notifyRefresh troopUin=" + troopInfo.troopuin + ", isNew=" + troopInfo.isNewTroop + ", hasSet=" + hasSetTroopHead);
            }
            aVar.d(troopInfo.troopuin, hasSetTroopHead);
            bg.k(new Runnable() { // from class: com.tencent.qqnt.inner.compator.troopinfo.processor.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(TroopInfo.this);
                }
            });
        }
        if (z16 && !z17 && memberNum > 1) {
            long a17 = com.tencent.qqnt.troop.inner.b.f362726a.a(troopInfo.troopuin, troopInfo);
            long j3 = troopInfo.mMemberNumSeq;
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106148", true);
            int i3 = this.originMemberNum;
            if (i3 <= 0 || memberNum == i3) {
                z18 = false;
            }
            if (j3 > a17 || (isSwitchOn && z18)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFaceInfoChangedProcessor", 2, "afterUpdateInfo: needRefreshNewTroopList, troopUin=" + troopInfo.troopuin + ", troopMemSeq=" + j3 + ", oldnum=" + this.originMemberNum + ", wMemberNum=" + memberNum);
                }
                String str = troopInfo.troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                if (longOrNull != null) {
                    this.needRefreshNewTroopList.add(Long.valueOf(longOrNull.longValue()));
                }
            }
        }
    }
}
