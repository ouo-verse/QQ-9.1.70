package com.tencent.mobileqq.qqgift.updatasystem;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqgift/updatasystem/c;", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftResourceBusiness;", "", "getBusinessDir", "", "getBid", "", "isEnableCheckFile", "", "id", "type", "f", "scid", "e", "scId", "Lcom/tencent/vas/update/callback/listener/IUpdateListener;", "updateListener", "", "i", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "onLoadFail", "onLoadSuccess", "onProgress", "", "Ljava/util/concurrent/CopyOnWriteArraySet;", "b", "Ljava/util/Map;", "updateListenerMap", "<init>", "()V", "c", "a", "vas-gift-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends QQGiftResourceBusiness {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f265033d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f265034e;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, CopyOnWriteArraySet<IUpdateListener>> updateListenerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqgift/updatasystem/c$a;", "", "", "c", "", "BID", "J", "b", "()J", "", "ANIMATION_SUFFIX", "Ljava/lang/String;", "ARK_SUFFIX", "PANEL_DIR", "PANEL_PREFIX", "PANEL_SUFFIX", "TAG", "TEST_PREFIX", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "Z", "<init>", "()V", "vas-gift-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqgift.updatasystem.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c() {
            if (!VasNormalToggle.VAS_DEBUG_GIFT_BID_SWITCH.isEnable(true)) {
                QLog.e("VasGiftResourceBusiness", 1, "switch is close");
                return false;
            }
            QLog.e("VasGiftResourceBusiness", 1, "is gray or publish");
            return false;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return c.f265034e;
            }
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
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
        long j3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        boolean c16 = companion.c();
        f265033d = c16;
        if (c16) {
            j3 = 330;
        } else {
            j3 = 312;
        }
        f265034e = j3;
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.updateListenerMap = new LinkedHashMap();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[Catch: Exception -> 0x0023, TryCatch #0 {Exception -> 0x0023, blocks: (B:24:0x001a, B:12:0x0028, B:14:0x004b), top: B:23:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(@Nullable String scid, int type) {
        boolean z16;
        List split$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) scid, type)).intValue();
        }
        if (scid != null) {
            try {
                if (scid.length() != 0) {
                    z16 = false;
                    if (z16) {
                        split$default = StringsKt__StringsKt.split$default((CharSequence) scid, new String[]{"."}, false, 0, 6, (Object) null);
                        Object[] array = split$default.toArray(new String[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String[] strArr = (String[]) array;
                        if (strArr.length <= 1) {
                            return 0;
                        }
                        return Integer.parseInt(strArr[1]);
                    }
                    return 0;
                }
            } catch (Exception e16) {
                QLog.e("VasGiftResourceBusiness", 2, "get id throw exception e:" + e16.getMessage());
                return 0;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness
    @NotNull
    public String f(int id5, int type) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(id5), Integer.valueOf(type));
        }
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    QLog.e("VasGiftResourceBusiness", 1, "getScid error! suffix is empty! id:" + id5 + ", type:" + type);
                    String scid = super.getScid(id5);
                    Intrinsics.checkNotNullExpressionValue(scid, "super.getScid(id)");
                    return scid;
                }
                str = ".ark.zip";
            } else {
                str = ".animation.zip";
            }
        } else {
            str = ".panel.zip";
        }
        if (f265033d) {
            return "qqgifttest." + id5 + str;
        }
        return "qqgift." + id5 + str;
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return f265034e;
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness, com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AegisLogger.GIFT;
    }

    public final void i(@NotNull String scId, @Nullable IUpdateListener updateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) scId, (Object) updateListener);
            return;
        }
        Intrinsics.checkNotNullParameter(scId, "scId");
        if (updateListener != null) {
            if (this.updateListenerMap.get(scId) != null) {
                CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet = this.updateListenerMap.get(scId);
                if (copyOnWriteArraySet != null) {
                    copyOnWriteArraySet.add(updateListener);
                    return;
                }
                return;
            }
            Map<String, CopyOnWriteArraySet<IUpdateListener>> map = this.updateListenerMap;
            CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet2.add(updateListener);
            map.put(scId, copyOnWriteArraySet2);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness, com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return QQVasUpdateBusiness.isEnableFileCheck(getBid());
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness, com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NotNull UpdateListenerParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        super.onLoadFail(params);
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null && f265034e == businessUpdateParams.mBid) {
            CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet = this.updateListenerMap.get(businessUpdateParams.mScid);
            if (copyOnWriteArraySet != null) {
                Iterator<T> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    ((IUpdateListener) it.next()).onLoadFail(params);
                }
            }
            CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet2 = this.updateListenerMap.get(params.mBusinessUpdateParams.mScid);
            if (copyOnWriteArraySet2 != null) {
                copyOnWriteArraySet2.clear();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness, com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NotNull UpdateListenerParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        super.onLoadSuccess(params);
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null && f265034e == businessUpdateParams.mBid) {
            CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet = this.updateListenerMap.get(businessUpdateParams.mScid);
            if (copyOnWriteArraySet != null) {
                Iterator<T> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    ((IUpdateListener) it.next()).onLoadSuccess(params);
                }
            }
            CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet2 = this.updateListenerMap.get(params.mBusinessUpdateParams.mScid);
            if (copyOnWriteArraySet2 != null) {
                copyOnWriteArraySet2.clear();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onProgress(@NotNull UpdateListenerParams params) {
        CopyOnWriteArraySet<IUpdateListener> copyOnWriteArraySet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        super.onProgress(params);
        BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
        if (businessUpdateParams != null && f265034e == businessUpdateParams.mBid && (copyOnWriteArraySet = this.updateListenerMap.get(businessUpdateParams.mScid)) != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ((IUpdateListener) it.next()).onProgress(params);
            }
        }
    }
}
