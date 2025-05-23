package com.tencent.qqnt.miniaio.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.miniaio.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.miniaio.api.IMiniaioApi;
import com.tencent.qqnt.miniaio.c;
import com.tencent.qqnt.miniaio.d;
import com.tencent.qqnt.miniaio.panel.MiniAIOEmoticonPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/miniaio/api/impl/MiniaioApiImpl;", "Lcom/tencent/qqnt/miniaio/api/IMiniaioApi;", "Landroid/view/ViewGroup;", "containerView", "Lcom/tencent/qqnt/miniaio/d;", "callback", "Lcom/tencent/qqnt/miniaio/c;", "getEmoticonPanel", "", "handleHorizontalMiniaioFinish", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "toMainMsgList", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniaioApiImpl implements IMiniaioApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "MiniaioApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/miniaio/api/impl/MiniaioApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.miniaio.api.impl.MiniaioApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MiniaioApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.miniaio.api.IMiniaioApi
    @NotNull
    public c getEmoticonPanel(@NotNull ViewGroup containerView, @NotNull d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new MiniAIOEmoticonPanel(containerView, callback);
    }

    @Override // com.tencent.qqnt.miniaio.api.IMiniaioApi
    public void handleHorizontalMiniaioFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.miniaio.api.IMiniaioApi
    public void toMainMsgList(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d(TAG, 1, "onToConversationClick");
        Intent intent = activity.getIntent();
        QLog.d(TAG, 1, "isNeed=" + intent.getBooleanExtra(MiniChatConstants.KEY_MINI_MSGTAB_ISNEED_BACK_CONVERSATION, true));
        Intent intent2 = (Intent) intent.getParcelableExtra(MiniChatConstants.KEY_MINI_MSGTAB_BACK_PENDING_INTENT);
        if (intent2 != null) {
            intent2.setComponent(SplashActivity.getAliasComponent(activity));
            h.v().z();
        } else {
            intent2 = new Intent();
            intent2.setComponent(SplashActivity.getAliasComponent(activity));
            intent2.setFlags(335544320);
            intent2.putExtra("tab_index", a.f183038a);
            intent2.putExtra(SplashActivity.FRAGMENT_ID, 1);
        }
        activity.startActivity(intent2);
    }
}
