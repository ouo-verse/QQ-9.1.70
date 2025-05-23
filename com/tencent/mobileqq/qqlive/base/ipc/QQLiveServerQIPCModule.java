package com.tencent.mobileqq.qqlive.base.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.nearby.profilecard.api.IQQProfileApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.api.profile.QQProfile;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveTempApi;
import com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart;
import com.tencent.mobileqq.qqlive.widget.verify.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveServerQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "Leipc/EIPCResult;", "c", "", "e", "d", "", "callbackId", "f", "", "action", "onCall", "moduleName", "<init>", "(Ljava/lang/String;)V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveServerQIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<QQLiveServerQIPCModule> f271016e;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveServerQIPCModule$a;", "", "", "action", "Landroid/os/Bundle;", "params", "Leipc/EIPCResultCallback;", "callback", "", "a", "Leipc/EIPCResult;", "b", "Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveServerQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/qqlive/base/ipc/QQLiveServerQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.base.ipc.QQLiveServerQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable String action, @Nullable Bundle params, @Nullable EIPCResultCallback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, action, params, callback);
            } else {
                QIPCClientHelper.getInstance().callServer("QQLiveServerQIPCModule", action, params, callback);
            }
        }

        @Nullable
        public final EIPCResult b(@Nullable String action, @Nullable Bundle params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (EIPCResult) iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, (Object) params);
            }
            return QIPCClientHelper.getInstance().callServer("QQLiveServerQIPCModule", action, params);
        }

        @NotNull
        public final QQLiveServerQIPCModule c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQLiveServerQIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (QQLiveServerQIPCModule) QQLiveServerQIPCModule.f271016e.getValue();
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
        Lazy<QQLiveServerQIPCModule> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(QQLiveServerQIPCModule$Companion$instance$2.INSTANCE);
        f271016e = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveServerQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) moduleName);
        }
    }

    private final EIPCResult c(Bundle params) {
        return EIPCResult.createResult(((IQQLiveTempApi) QRoute.api(IQQLiveTempApi.class)).isAudioChating() ? 1 : 0, null);
    }

    private final EIPCResult d(Bundle params) {
        String str;
        if (params != null) {
            str = params.getString(QQLiveIPCConstants.Param.PARAM_ACCOUNT_UIN);
        } else {
            str = null;
        }
        QLog.i("QQLiveServerQIPCModule", 1, "onGetQQProfile uin:" + str);
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            EIPCResult createResult = EIPCResult.createResult(0, bundle);
            Intrinsics.checkNotNullExpressionValue(createResult, "createResult(0, bundle)");
            return createResult;
        }
        bundle.putParcelable(QQLiveIPCConstants.Param.PARAM_QQ_PROFILE, new QQProfile(((IQQProfileApi) QRoute.api(IQQProfileApi.class)).getGender(str)));
        EIPCResult createResult2 = EIPCResult.createResult(0, bundle);
        Intrinsics.checkNotNullExpressionValue(createResult2, "createResult(0, bundle)");
        return createResult2;
    }

    private final void e(Bundle params) {
        params.setClassLoader(QQLiveQualityReportData.class.getClassLoader());
        int i3 = params.getInt(QQLiveIPCConstants.Param.PARAM_ATTA_ID);
        QQLiveQualityReportData qQLiveQualityReportData = (QQLiveQualityReportData) params.getParcelable(QQLiveIPCConstants.Param.PARAM_REPORT_DATA);
        if (qQLiveQualityReportData != null) {
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).qualityReport(i3, qQLiveQualityReportData.toEntry());
        }
    }

    private final void f(Bundle params, final int callbackId) {
        QQLivePreparePlayTogetherPart.GameData gameData;
        if (params != null) {
            params.setClassLoader(QQLivePreparePlayTogetherPart.GameData.class.getClassLoader());
        }
        if (params != null) {
            gameData = (QQLivePreparePlayTogetherPart.GameData) params.getParcelable(QQLiveIPCConstants.Param.PARAM_PLAY_TOGETHER_GAME_DATA);
        } else {
            gameData = null;
        }
        ri2.a.f431480a.a(gameData, new Function2<Integer, String, Unit>(callbackId) { // from class: com.tencent.mobileqq.qqlive.base.ipc.QQLiveServerQIPCModule$playTogetherLaunchApp$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$callbackId = callbackId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveServerQIPCModule.this, callbackId);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String msg2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) msg2);
                    return;
                }
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Bundle bundle = new Bundle();
                bundle.putString(QQLiveIPCConstants.Param.PARAM_PLAY_TOGETHER_CALLBACK_MSG, msg2);
                QQLiveServerQIPCModule.this.callbackResult(this.$callbackId, EIPCResult.createResult(i3, bundle));
            }
        });
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_GET_QQ_PROFILE, action)) {
            return d(params);
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_QQLIVE_QUALITY_REPORT, action)) {
            if (params != null) {
                e(params);
                return null;
            }
            return null;
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_QQLIVE_VERIFY_CALLBACK, action)) {
            l.f274086a.h(params);
            return null;
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_ROOM_REGISTER_CHAT_AUDIO_OBSERVER, action)) {
            ((IQQLiveTempApi) QRoute.api(IQQLiveTempApi.class)).registerQQLiveChatObserver();
            return null;
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_ROOM_REMOVE_CHAT_AUDIO_OBSERVER, action)) {
            ((IQQLiveTempApi) QRoute.api(IQQLiveTempApi.class)).removeQQLiveChatObserver();
            return null;
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_ROOM_IS_AUDIO_CHATTING, action)) {
            return c(params);
        }
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_QQLIVE_PLAY_TOGETHER_LAUNCH_APP, action)) {
            f(params, callbackId);
            return null;
        }
        return null;
    }
}
