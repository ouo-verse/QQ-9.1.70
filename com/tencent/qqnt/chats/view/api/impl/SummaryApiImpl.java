package com.tencent.qqnt.chats.view.api.impl;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.chats.view.api.ISummaryApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/view/api/impl/SummaryApiImpl;", "Lcom/tencent/qqnt/chats/view/api/ISummaryApi;", "", "getIsSupportSummaryNickEmojiAnimationFromConfig", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "getSummartContentTextView", "", "nick", "getSummaryNick", "_isSupportSummaryNickEmojiAnimation", "Z", "Lmqq/app/IAccountCallback;", "accountCallback", "Lmqq/app/IAccountCallback;", "isSupportSummaryNickEmojiAnimation", "()Z", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SummaryApiImpl implements ISummaryApi {
    private static final String TAG = "SummaryApiImpl";
    private boolean _isSupportSummaryNickEmojiAnimation;
    private final IAccountCallback accountCallback;

    public SummaryApiImpl() {
        b bVar = new b();
        this.accountCallback = bVar;
        this._isSupportSummaryNickEmojiAnimation = getIsSupportSummaryNickEmojiAnimationFromConfig();
        MobileQQ.sMobileQQ.registerAccountCallback(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIsSupportSummaryNickEmojiAnimationFromConfig() {
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getTestAndVibrateValue()) {
            return true;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105692", false);
    }

    @Override // com.tencent.qqnt.chats.view.api.ISummaryApi
    public TextView getSummartContentTextView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (get_isSupportSummaryNickEmojiAnimation()) {
            return new AIOMsgTextView(context, null, 0, 6, null);
        }
        return new AnimationTextView(context);
    }

    @Override // com.tencent.qqnt.chats.view.api.ISummaryApi
    public CharSequence getSummaryNick(CharSequence nick) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new QQText(nick, get_isSupportSummaryNickEmojiAnimation() ? 23 : 19, 16);
    }

    @Override // com.tencent.qqnt.chats.view.api.ISummaryApi
    /* renamed from: isSupportSummaryNickEmojiAnimation, reason: from getter */
    public boolean get_isSupportSummaryNickEmojiAnimation() {
        return this._isSupportSummaryNickEmojiAnimation;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/chats/view/api/impl/SummaryApiImpl$b", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IAccountCallback {
        b() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            SummaryApiImpl summaryApiImpl = SummaryApiImpl.this;
            summaryApiImpl._isSupportSummaryNickEmojiAnimation = summaryApiImpl.getIsSupportSummaryNickEmojiAnimationFromConfig();
            QLog.i(SummaryApiImpl.TAG, 1, "accountCallback onAccountChanged: " + SummaryApiImpl.this._isSupportSummaryNickEmojiAnimation);
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
            SummaryApiImpl.this._isSupportSummaryNickEmojiAnimation = false;
            QLog.i(SummaryApiImpl.TAG, 1, "accountCallback onLogout, reason = " + reason);
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }
    }
}
