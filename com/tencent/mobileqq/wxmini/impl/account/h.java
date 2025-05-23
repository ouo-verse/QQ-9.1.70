package com.tencent.mobileqq.wxmini.impl.account;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/account/h;", "", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0010R\u0014\u0010!\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/account/h$a;", "", "", "weChatUserInfoJson", "", "d", "", "showDialogCurrentTime", "f", "miniAppOpenTime", "e", "account", "a", "c", "b", "ACCOUNT_TYPE_WX", "I", "BIND_RESULT_CANCEL", "BIND_RESULT_EXIST_BIND", "BIND_RESULT_NEED_SECURE_CHECK", "BIND_RESULT_SUCCESS", "BIND_RESULT_UNKNOWN", "KEY_BINDING_WECHAT_USER_INFO", "Ljava/lang/String;", "KEY_MINI_APP_OPEN_TIME", "KEY_SHOW_DIALOG_CURRENT_TIME", "LOGIN_MODULE", "SERVICE_TYPE_QQ_BINDING_WX_MINIAPP", "TAG", "UNBIND_RESULT_CANCEL", "UNBIND_RESULT_NEED_SECURE_CHECK", "UNBIND_RESULT_NEED_SEC_CHECK", "UNBIND_RESULT_NO_BIND", "UNBIND_RESULT_SUCCESS", "UNBIND_RESULT_UNKNOWN", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.impl.account.h$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(String account) {
            String str;
            Intrinsics.checkNotNullParameter(account, "account");
            if (account.length() == 0) {
                str = "qq_login" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount() + "key_binding_wechat_user_info";
            } else {
                str = "qq_login" + account + "key_binding_wechat_user_info";
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026 QMMKVFile.FILE_MINI_APP)");
            return fromV2.getString(str, "");
        }

        @JvmStatic
        public final int b() {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026 QMMKVFile.FILE_MINI_APP)");
            return fromV2.getInt("qq_loginkey_mini_app_open_time", 0);
        }

        @JvmStatic
        public final int c() {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026 QMMKVFile.FILE_MINI_APP)");
            return fromV2.getInt("qq_loginkey_show_dialog_current_time", 0);
        }

        @JvmStatic
        public final void d(String weChatUserInfoJson) {
            String str = "qq_login" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount() + "key_binding_wechat_user_info";
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026 QMMKVFile.FILE_MINI_APP)");
            fromV2.putString(str, weChatUserInfoJson);
            fromV2.apply();
        }

        @JvmStatic
        public final void e(int miniAppOpenTime) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026 QMMKVFile.FILE_MINI_APP)");
            fromV2.putInt("qq_loginkey_mini_app_open_time", miniAppOpenTime);
            fromV2.apply();
        }

        @JvmStatic
        public final void f(int showDialogCurrentTime) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026 QMMKVFile.FILE_MINI_APP)");
            fromV2.putInt("qq_loginkey_show_dialog_current_time", showDialogCurrentTime);
            fromV2.apply();
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final String a(String str) {
        return INSTANCE.a(str);
    }

    @JvmStatic
    public static final int b() {
        return INSTANCE.b();
    }

    @JvmStatic
    public static final int c() {
        return INSTANCE.c();
    }

    @JvmStatic
    public static final void d(String str) {
        INSTANCE.d(str);
    }

    @JvmStatic
    public static final void e(int i3) {
        INSTANCE.e(i3);
    }

    @JvmStatic
    public static final void f(int i3) {
        INSTANCE.f(i3);
    }
}
