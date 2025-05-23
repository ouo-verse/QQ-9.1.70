package com.tencent.mobileqq.aio.animation.api.impl;

import android.content.SharedPreferences;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.animation.api.IAIOAnimationMsgManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/api/impl/AIOAnimationMsgManagerImpl;", "Lcom/tencent/mobileqq/aio/animation/api/IAIOAnimationMsgManager;", "", "newSeq", "localSeq", "", "isInvalidMsgSeq", "Landroid/content/SharedPreferences;", "getSharedPreference", "", "getSPName", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "getKey", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "seq", "updateParsedMsgSeq", "setParsedMsgSeq", "getLatestParsedMsgSeq", "Lmqq/app/AppRuntime;", "<init>", "()V", "Companion", "a", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOAnimationMsgManagerImpl implements IAIOAnimationMsgManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final long EMPTY_MSG_SEQ = -1;

    @NotNull
    private static final String SP_NAME = "AIOAnimationUnreadManager";

    @NotNull
    private static final String TAG = "AIOAnimationUnreadManager";
    private AppRuntime appRuntime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/api/impl/AIOAnimationMsgManagerImpl$a;", "", "", "EMPTY_MSG_SEQ", "J", "", "SP_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.api.impl.AIOAnimationMsgManagerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOAnimationMsgManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String getKey(Contact contact) {
        return contact.chatType + "-" + contact.peerUid;
    }

    private final String getSPName() {
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        return "AIOAnimationUnreadManager_" + appRuntime.getCurrentUid();
    }

    private final SharedPreferences getSharedPreference() {
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(appRuntime.getApplicationContext(), getSPName(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromSpAdapter, "fromSpAdapter(appRuntime\u2026), QMMKVFile.FILE_COMMON)");
        return fromSpAdapter;
    }

    private final boolean isInvalidMsgSeq(long newSeq, long localSeq) {
        if (Math.abs(localSeq - newSeq) > TTL.MAX_VALUE) {
            QLog.w("AIOAnimationUnreadManager", 1, "invalid local msg seq found, newSeq: " + newSeq + ", localSeq: " + localSeq);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAIOAnimationMsgManager
    public long getLatestParsedMsgSeq(@NotNull Contact contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, (Object) contact)).longValue();
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        return getSharedPreference().getLong(getKey(contact), -1L);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            this.appRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAIOAnimationMsgManager
    public void setParsedMsgSeq(@NotNull Contact contact, long seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, contact, Long.valueOf(seq));
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        long latestParsedMsgSeq = getLatestParsedMsgSeq(contact);
        if (seq != latestParsedMsgSeq) {
            getSharedPreference().edit().putLong(getKey(contact), seq).apply();
            QLog.i("AIOAnimationUnreadManager", 1, "[setParsedMsgSeq] contact: " + contact + ", seq: " + latestParsedMsgSeq + " -> " + seq);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.api.IAIOAnimationMsgManager
    public void updateParsedMsgSeq(@NotNull Contact contact, long seq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, contact, Long.valueOf(seq));
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        long latestParsedMsgSeq = getLatestParsedMsgSeq(contact);
        if (seq > latestParsedMsgSeq || isInvalidMsgSeq(seq, latestParsedMsgSeq)) {
            getSharedPreference().edit().putLong(getKey(contact), seq).apply();
            if (QLog.isColorLevel()) {
                QLog.i("AIOAnimationUnreadManager", 2, "[updateParsedMsgSeq] contact: " + contact + ", seq: " + seq);
            }
        }
    }
}
