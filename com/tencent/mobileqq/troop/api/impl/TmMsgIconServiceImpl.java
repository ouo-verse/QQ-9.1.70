package com.tencent.mobileqq.troop.api.impl;

import android.util.LruCache;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.aionickicon.TroopMemberIconData;
import com.tencent.mobileqq.troop.api.ITmMsgIconService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_general_flags_body$MsgIcon;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TmMsgIconServiceImpl;", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService;", "", "memberUin", "Ltencent/im/msg/nt_im_msg_general_flags_body$MsgIcon;", "getMsgIconFromDB", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService$a;", "callback", "", "getMemberIconData", "icon", "setMemberIconData", "cacheMemberIconData", "getMemberIconDataFromCache", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "Lcom/tencent/mobileqq/persistence/EntityManager;", "Landroid/util/LruCache;", "memberIconDataCache", "Landroid/util/LruCache;", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TmMsgIconServiceImpl implements ITmMsgIconService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int MAX_CACHED_ICON_DATA_COUNT = 100;

    @NotNull
    public static final String TAG = "TmMsgIconServiceImpl";

    @Nullable
    private EntityManager em;

    @NotNull
    private final LruCache<String, nt_im_msg_general_flags_body$MsgIcon> memberIconDataCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TmMsgIconServiceImpl$a;", "", "", "MAX_CACHED_ICON_DATA_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.impl.TmMsgIconServiceImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TmMsgIconServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.memberIconDataCache = new LruCache<>(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMemberIconData$lambda$1(TmMsgIconServiceImpl this$0, String str, ITmMsgIconService.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nt_im_msg_general_flags_body$MsgIcon msgIconFromDB = this$0.getMsgIconFromDB(str);
        if (msgIconFromDB != null) {
            this$0.cacheMemberIconData(str, msgIconFromDB);
        }
        if (aVar != null) {
            aVar.a(msgIconFromDB);
        }
    }

    private final nt_im_msg_general_flags_body$MsgIcon getMsgIconFromDB(String memberUin) {
        Entity entity;
        TroopMemberIconData troopMemberIconData;
        EntityManager entityManager = this.em;
        if (entityManager != null) {
            entity = DBMethodProxy.find(entityManager, (Class<? extends Entity>) TroopMemberIconData.class, memberUin);
        } else {
            entity = null;
        }
        if (entity instanceof TroopMemberIconData) {
            troopMemberIconData = (TroopMemberIconData) entity;
        } else {
            troopMemberIconData = null;
        }
        if (troopMemberIconData == null) {
            return null;
        }
        return troopMemberIconData.getMsgIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMemberIconData$lambda$3(TroopMemberIconData troopMemberIconData, TmMsgIconServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(troopMemberIconData, "$troopMemberIconData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (troopMemberIconData.getStatus() == 1000) {
            EntityManager entityManager = this$0.em;
            if (entityManager != null) {
                entityManager.persistOrReplace(troopMemberIconData);
                return;
            }
            return;
        }
        EntityManager entityManager2 = this$0.em;
        if (entityManager2 != null) {
            entityManager2.update(troopMemberIconData);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITmMsgIconService
    public void cacheMemberIconData(@Nullable String memberUin, @Nullable nt_im_msg_general_flags_body$MsgIcon icon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberUin, (Object) icon);
        } else {
            this.memberIconDataCache.put(memberUin, icon);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITmMsgIconService
    public void getMemberIconData(@Nullable final String memberUin, @Nullable final ITmMsgIconService.a callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) memberUin, (Object) callback);
            return;
        }
        if (memberUin != null && memberUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.a(null);
                return;
            }
            return;
        }
        nt_im_msg_general_flags_body$MsgIcon memberIconDataFromCache = getMemberIconDataFromCache(memberUin);
        if (memberIconDataFromCache != null) {
            if (callback != null) {
                callback.a(memberIconDataFromCache);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                TmMsgIconServiceImpl.getMemberIconData$lambda$1(TmMsgIconServiceImpl.this, memberUin, callback);
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.troop.api.ITmMsgIconService
    @Nullable
    public nt_im_msg_general_flags_body$MsgIcon getMemberIconDataFromCache(@Nullable String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (nt_im_msg_general_flags_body$MsgIcon) iPatchRedirector.redirect((short) 5, (Object) this, (Object) memberUin);
        }
        return this.memberIconDataCache.get(memberUin);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        EntityManager entityManager;
        EntityManagerFactory entityManagerFactory;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime == null) {
            appRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        }
        if (appRuntime != null && (entityManagerFactory = appRuntime.getEntityManagerFactory()) != null) {
            entityManager = entityManagerFactory.createEntityManager();
        } else {
            entityManager = null;
        }
        this.em = entityManager;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.em = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITmMsgIconService
    public void setMemberIconData(@Nullable String memberUin, @Nullable nt_im_msg_general_flags_body$MsgIcon icon) {
        boolean z16;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) memberUin, (Object) icon);
            return;
        }
        if (memberUin != null && memberUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        final TroopMemberIconData troopMemberIconData = new TroopMemberIconData();
        troopMemberIconData.memberUin = memberUin;
        if (icon != null) {
            bArr = icon.toByteArray();
        } else {
            bArr = null;
        }
        troopMemberIconData.nickIconBytes = bArr;
        cacheMemberIconData(memberUin, icon);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                TmMsgIconServiceImpl.setMemberIconData$lambda$3(TroopMemberIconData.this, this);
            }
        }, 32, null, false);
    }
}
