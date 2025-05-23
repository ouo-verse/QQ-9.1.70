package com.tencent.mobileqq.cardcontainer.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/ChatListTestAndVibrateApiImpl;", "Lcom/tencent/mobileqq/cardcontainer/api/IChatListTestAndVibrateApi;", "", "isSwitch", "", "changeTestAndVibrateValue", "getTestAndVibrateValue", "getPublicAccountPluginSwitch", "", "MSGLIST_TEST_AND_VERIFY", "Ljava/lang/String;", "getMSGLIST_TEST_AND_VERIFY", "()Ljava/lang/String;", "<init>", "()V", "Companion", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChatListTestAndVibrateApiImpl implements IChatListTestAndVibrateApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChatListTestAndVibrateApiImpl";
    private static final boolean publicAccountPluginSwitch;

    @NotNull
    private final String MSGLIST_TEST_AND_VERIFY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/ChatListTestAndVibrateApiImpl$a;", "", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.impl.ChatListTestAndVibrateApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        public final boolean b() {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("public_account_plugin_switch", "");
            if (TextUtils.isEmpty(loadAsString)) {
                return false;
            }
            try {
                boolean optBoolean = new JSONObject(loadAsString).optBoolean("publicAccountPluginSwitch");
                QLog.i(ChatListTestAndVibrateApiImpl.TAG, 1, "switchBoolean " + optBoolean + "  parse from " + loadAsString);
                return optBoolean;
            } catch (JSONException e16) {
                QLog.i(ChatListTestAndVibrateApiImpl.TAG, 1, "getPublicAccountPluginSwitch fail because jsonException " + e16);
                return false;
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        publicAccountPluginSwitch = companion.b();
    }

    public ChatListTestAndVibrateApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.MSGLIST_TEST_AND_VERIFY = "msgList_test_and_verify_switch";
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi
    public void changeTestAndVibrateValue(boolean isSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isSwitch);
            return;
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        withAccount.putBoolean(this.MSGLIST_TEST_AND_VERIFY + "_mCurrentUin", isSwitch);
    }

    @NotNull
    public final String getMSGLIST_TEST_AND_VERIFY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.MSGLIST_TEST_AND_VERIFY;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi
    public boolean getPublicAccountPluginSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean testAndVibrateValue = getTestAndVibrateValue();
        boolean z16 = publicAccountPluginSwitch;
        QLog.i(TAG, 1, "getPublicAccountPluginSwitch plugin " + z16 + " msgList " + testAndVibrateValue);
        if (z16 || testAndVibrateValue) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi
    public boolean getTestAndVibrateValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
