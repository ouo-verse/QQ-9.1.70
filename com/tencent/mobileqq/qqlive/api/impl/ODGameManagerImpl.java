package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.GiftUserTranParam;
import com.tencent.mobileqq.qqlive.api.IODAnchorJudgeStrategyAdapter;
import com.tencent.mobileqq.qqlive.api.IODGameManager;
import com.tencent.mobileqq.qqlive.api.ODRoomShareParam;
import com.tencent.mobileqq.qqlive.room.od.component.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import on3.b;
import on3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/ODGameManagerImpl;", "Lcom/tencent/mobileqq/qqlive/api/IODGameManager;", "()V", "preSetSentUserIdMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearPreSelectedUserId", "", "roomId", "getCovertTranParamLastSelectedOrHost", "Lcom/tencent/mobileqq/qqlive/api/GiftUserTranParam;", "userId", "getODMiniCardAnchorJudgeHandle", "Lcom/tencent/mobileqq/qqlive/api/IODAnchorJudgeStrategyAdapter;", "uid", "getODRoomHostId", "getPreSelectedSendGiftUserId", "getShareRoomInfo", "Lcom/tencent/mobileqq/qqlive/api/ODRoomShareParam;", "recordSelectedSendGiftUserId", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ODGameManagerImpl implements IODGameManager {
    static IPatchRedirector $redirector_;

    @NotNull
    private final HashMap<Long, Long> preSetSentUserIdMap;

    public ODGameManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.preSetSentUserIdMap = new HashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    public void clearPreSelectedUserId(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, roomId);
        } else {
            this.preSetSentUserIdMap.remove(Long.valueOf(roomId));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    @Nullable
    public GiftUserTranParam getCovertTranParamLastSelectedOrHost(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GiftUserTranParam) iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Long.valueOf(userId));
        }
        b b16 = a.f271851a.b(roomId);
        if (b16 == null) {
            return null;
        }
        if (userId == -1) {
            getPreSelectedSendGiftUserId(roomId);
        }
        new Ref.ObjectRef();
        b16.a();
        throw null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    @NotNull
    public IODAnchorJudgeStrategyAdapter getODMiniCardAnchorJudgeHandle(long roomId, long uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IODAnchorJudgeStrategyAdapter) iPatchRedirector.redirect((short) 7, this, Long.valueOf(roomId), Long.valueOf(uid));
        }
        final xn3.a aVar = new xn3.a(a.f271851a.b(roomId), uid);
        return new IODAnchorJudgeStrategyAdapter() { // from class: com.tencent.mobileqq.qqlive.api.impl.ODGameManagerImpl$getODMiniCardAnchorJudgeHandle$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) xn3.a.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.IODAnchorJudgeStrategyAdapter
            public long acquireAnchorUid(long roomId2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Long) iPatchRedirector2.redirect((short) 3, (Object) this, roomId2)).longValue();
                }
                return xn3.a.this.a(roomId2);
            }

            @Override // com.tencent.mobileqq.qqlive.api.IODAnchorJudgeStrategyAdapter
            public boolean isOpenAnchorProfile(long roomId2, long uid2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, this, Long.valueOf(roomId2), Long.valueOf(uid2))).booleanValue();
                }
                return xn3.a.this.b(roomId2, uid2);
            }

            @Override // com.tencent.mobileqq.qqlive.api.IODAnchorJudgeStrategyAdapter
            public boolean isShowGiftBtn() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 4, (Object) this)).booleanValue();
                }
                return xn3.a.this.c();
            }
        };
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    public long getODRoomHostId(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, roomId)).longValue();
        }
        b b16 = a.f271851a.b(roomId);
        if (b16 != null) {
            b16.a();
            return -1L;
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    public long getPreSelectedSendGiftUserId(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, roomId)).longValue();
        }
        Long l3 = this.preSetSentUserIdMap.get(Long.valueOf(roomId));
        if (l3 == null) {
            return -1L;
        }
        return l3.longValue();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    @NotNull
    public ODRoomShareParam getShareRoomInfo(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ODRoomShareParam) iPatchRedirector.redirect((short) 8, (Object) this, roomId);
        }
        a aVar = a.f271851a;
        String a16 = aVar.a(roomId);
        String str = "";
        if (a16 == null) {
            a16 = "";
        }
        b b16 = aVar.b(roomId);
        if (b16 != null) {
            b16.a();
            c a17 = on3.a.a(null);
            if (a17 != null) {
                a17.getUser();
            }
        }
        a.C8375a c16 = aVar.c(roomId);
        if (c16 != null) {
            String a18 = c16.a();
            if (a18 == null) {
                a18 = "";
            }
            String b17 = c16.b();
            if (b17 != null) {
                str = b17;
            }
            return new ODRoomShareParam(a18, str, a16);
        }
        return new ODRoomShareParam("", "", a16);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IODGameManager
    public void recordSelectedSendGiftUserId(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), Long.valueOf(userId));
        } else {
            this.preSetSentUserIdMap.put(Long.valueOf(roomId), Long.valueOf(userId));
        }
    }
}
