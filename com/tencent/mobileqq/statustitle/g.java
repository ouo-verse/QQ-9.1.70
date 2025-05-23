package com.tencent.mobileqq.statustitle;

import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import friendlist.GetOnlineInfoResp;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0004\u001a!%\u000eB\u000f\u0012\u0006\u0010 \u001a\u00020\u0019\u00a2\u0006\u0004\b.\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/statustitle/g;", "", "", "from", "nickName", "", tl.h.F, "nickname", "l", "o", "e", "f", "g", "k", "d", "p", "", "color", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/common/app/AppInterface;", "appInterface", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "i", "j", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getNickNameView", "()Landroid/widget/TextView;", "setNickNameView", "(Landroid/widget/TextView;)V", "nickNameView", "b", "Ljava/lang/String;", "nickNameText", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "c", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "profileCardObserver", "Lcom/tencent/mobileqq/statustitle/g$c;", "Lcom/tencent/mobileqq/statustitle/g$c;", "selfCardObserver", "Lcom/tencent/mobileqq/statustitle/g$a;", "Lcom/tencent/mobileqq/statustitle/g$a;", "friendListObserver", "<init>", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String nickNameText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ProfileCardObserver profileCardObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c selfCardObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a friendListObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0014J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/statustitle/g$a;", "Lcom/tencent/mobileqq/app/ar;", "", "isSuccess", "isComplete", "", "onUpdateFriendList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "uins", "onGetStoreFace", "uin", "onUpdateFriendInfo", "", "type", "uinOrMobileStr", "Lfriendlist/GetOnlineInfoResp;", "resp", "onGetOnlineInfoByUinOrMobile", "isVisible", "onSetVisibilityForNetWorkStatus", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/statustitle/g;", "d", "Ljava/lang/ref/WeakReference;", "mNickNameAssistantRef", "nickNameAssistant", "<init>", "(Lcom/tencent/mobileqq/statustitle/g;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a extends ar {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<g> mNickNameAssistantRef;

        public a(g nickNameAssistant) {
            Intrinsics.checkNotNullParameter(nickNameAssistant, "nickNameAssistant");
            this.mNickNameAssistantRef = new WeakReference<>(nickNameAssistant);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean isSuccess, long type, String uinOrMobileStr, GetOnlineInfoResp resp) {
            Intrinsics.checkNotNullParameter(uinOrMobileStr, "uinOrMobileStr");
            Intrinsics.checkNotNullParameter(resp, "resp");
            QLog.d("NickNameAssistant", 2, "onGetOnlineInfoByUinOrMobile");
            super.onGetOnlineInfoByUinOrMobile(isSuccess, type, uinOrMobileStr, resp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetStoreFace(boolean isSuccess, HashSet<String> uins) {
            Intrinsics.checkNotNullParameter(uins, "uins");
            QLog.d("NickNameAssistant", 2, "onGetStoreFace: uins:" + uins + ", success :" + isSuccess);
            super.onGetStoreFace(isSuccess, uins);
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String uin, boolean isSuccess) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            g gVar = this.mNickNameAssistantRef.get();
            if (gVar == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NickNameAssistant", 2, "onUpdateFriendInfo uin = " + uin + ", isSc = " + isSuccess);
            }
            if (isSuccess) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                if (qQAppInterface == null || !Utils.p(uin, qQAppInterface.getAccount())) {
                    return;
                }
                gVar.k("onUpdateFriendInfo");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean isSuccess, boolean isComplete) {
            g gVar = this.mNickNameAssistantRef.get();
            if (gVar != null && isSuccess && isComplete) {
                if (QLog.isColorLevel()) {
                    QLog.i("NickNameAssistant", 2, "refresh recent, from_onupdatefriendlist");
                }
                gVar.k("onUpdateFriendList");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onSetVisibilityForNetWorkStatus(boolean isSuccess, boolean isVisible) {
            QLog.d("NickNameAssistant", 2, "onSetVisibilityForNetWorkStatus");
            super.onSetVisibilityForNetWorkStatus(isSuccess, isVisible);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0014J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/statustitle/g$c;", "Lcom/tencent/mobileqq/app/CardObserver;", "", "isSuccess", "", "uin", "", QzoneIPCModule.RESULT_CODE, "", "onUpdateAvatar", "finalTime", "from", "onGetNotDisturb", "onSetNotDisturb", "success", "nick", "onSetNick", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/statustitle/g;", "d", "Ljava/lang/ref/WeakReference;", "mNickNameAssistantRef", "nickNameAssistant", "<init>", "(Lcom/tencent/mobileqq/statustitle/g;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class c extends CardObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<g> mNickNameAssistantRef;

        public c(g nickNameAssistant) {
            Intrinsics.checkNotNullParameter(nickNameAssistant, "nickNameAssistant");
            this.mNickNameAssistantRef = new WeakReference<>(nickNameAssistant);
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        public void onGetNotDisturb(boolean isSuccess, String finalTime, String from) {
            Intrinsics.checkNotNullParameter(finalTime, "finalTime");
            Intrinsics.checkNotNullParameter(from, "from");
            super.onGetNotDisturb(isSuccess, finalTime, from);
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetNick(boolean success, String nick) {
            Intrinsics.checkNotNullParameter(nick, "nick");
            g gVar = this.mNickNameAssistantRef.get();
            if (gVar != null && success) {
                gVar.l("onSetNick", nick);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetNotDisturb(boolean isSuccess, String finalTime, String from) {
            Intrinsics.checkNotNullParameter(finalTime, "finalTime");
            Intrinsics.checkNotNullParameter(from, "from");
            super.onSetNotDisturb(isSuccess, finalTime, from);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean isSuccess, String uin, int resultCode) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            super.onUpdateAvatar(isSuccess, uin, resultCode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/statustitle/g$d;", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "", "isSuccess", "", "data", "", "onGetProfileCard", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/statustitle/g;", "d", "Ljava/lang/ref/WeakReference;", "mNickNameAssistantRef", "nickNameAssistant", "<init>", "(Lcom/tencent/mobileqq/statustitle/g;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class d extends ProfileCardObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<g> mNickNameAssistantRef;

        public d(g nickNameAssistant) {
            Intrinsics.checkNotNullParameter(nickNameAssistant, "nickNameAssistant");
            this.mNickNameAssistantRef = new WeakReference<>(nickNameAssistant);
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            g gVar = this.mNickNameAssistantRef.get();
            if (gVar == null) {
                return;
            }
            Card card = data instanceof Card ? (Card) data : null;
            if (card != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                if (qQAppInterface != null && isSuccess && Utils.p(card.uin, qQAppInterface.getCurrentAccountUin())) {
                    gVar.k("onCardDownload");
                }
            }
        }
    }

    public g(TextView nickNameView) {
        Intrinsics.checkNotNullParameter(nickNameView, "nickNameView");
        this.nickNameView = nickNameView;
        this.nickNameText = "";
        this.profileCardObserver = new d(this);
        this.selfCardObserver = new c(this);
        this.friendListObserver = new a(this);
    }

    private final String e() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString(f(), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(getNicknameCacheKey(), \"\")");
        return decodeString;
    }

    private final String f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return "KEY_SELF_NICKNAME_FOR_CONVERSATION-" + peekAppRuntime.getCurrentAccountUin();
        }
        return "";
    }

    private final void h(String from, String nickName) {
        if (Intrinsics.areEqual(nickName, this.nickNameText)) {
            if (QLog.isColorLevel()) {
                QLog.d("NickNameAssistant", 1, "realUpdateNickname:: ignore from: " + from);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NickNameAssistant", 2, "realUpdateNickname:: updateNickName() from: " + from);
        }
        this.nickNameView.setText(nickName);
        this.nickNameText = nickName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final String from, final String nickname) {
        QLog.i("NickNameAssistant", 1, "updateNickName:: from=" + from);
        if (nickname != null) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                h(from, nickname);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.statustitle.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.n(g.this, from, nickname);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QQAppInterface this_apply, g this$0, String from) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "$from");
        String nickname = ac.G(this_apply, this_apply.getCurrentUin());
        Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
        this$0.o(nickname);
        this$0.l(from, nickname);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(g this$0, String from, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "$from");
        this$0.h(from, str);
    }

    private final void o(String nickname) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
        from.encodeString(f(), nickname);
    }

    public final void d() {
        this.nickNameView.setTextSize(18.0f);
    }

    public final void g(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("NickNameAssistant", 1, "initNickname:" + from);
        String e16 = e();
        if (!TextUtils.isEmpty(e16)) {
            h(from, e16);
        } else {
            k(from);
        }
    }

    public final void i(AppInterface appInterface, boolean isLogin) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        appInterface.addObserver(this.profileCardObserver, true);
        appInterface.addObserver(this.selfCardObserver, true);
        if (isLogin) {
            appInterface.addObserver(this.friendListObserver, true);
        }
    }

    public final void j(AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        appInterface.removeObserver(this.profileCardObserver);
        appInterface.removeObserver(this.selfCardObserver);
        appInterface.removeObserver(this.friendListObserver);
    }

    public final void k(final String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.statustitle.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.m(QQAppInterface.this, this, from);
                }
            }, 16, null, true);
        } else {
            QLog.i("NickNameAssistant", 1, "updateNickName:: but get QQAppInterface failed!!!");
        }
    }

    public final void p() {
        TextView textView = this.nickNameView;
        textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_nav_primary));
    }

    public final void q(int color) {
        this.nickNameView.setTextColor(color);
    }
}
