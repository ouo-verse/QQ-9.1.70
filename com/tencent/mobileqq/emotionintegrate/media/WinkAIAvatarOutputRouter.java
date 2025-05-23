package com.tencent.mobileqq.emotionintegrate.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarMediaPickerViewModel;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.editor.c;
import com.tencent.qphone.base.util.QLog;
import e93.i;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "ai\u5934\u50cf\u62cd\u7167\u8f93\u51fa\u8def\u7531", path = WinkAIAvatarOutputRouter.ROUTE_PATH)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/media/WinkAIAvatarOutputRouter;", "Lb93/a;", "Landroid/content/Context;", "context", "Lb93/b;", "outputData", "", "handleCaptureResult", "", "interceptExitWink", "Landroid/os/Bundle;", "bundle", "onBack", "onOutput", "Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "viewModel", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class WinkAIAvatarOutputRouter implements b93.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String OUTPUT_MEDIA = "OUTPUT_MEDIA";

    @NotNull
    public static final String ROUTE_PATH = "/wink/output/aiAvatar";

    @NotNull
    public static final String TAG = "WinkAIAvatarOutputRouter";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/media/WinkAIAvatarOutputRouter$a;", "", "", "OUTPUT_MEDIA", "Ljava/lang/String;", "ROUTE_PATH", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emotionintegrate.media.WinkAIAvatarOutputRouter$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WinkAIAvatarOutputRouter() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(WinkAIAvatarOutputRouter$viewModel$2.INSTANCE);
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIAvatarMediaPickerViewModel getViewModel() {
        return (WinkAIAvatarMediaPickerViewModel) this.viewModel.getValue();
    }

    private final void handleCaptureResult(final Context context, OutputData outputData) {
        Activity activity;
        QLog.d(TAG, 1, "[handleCaptureResult]");
        if (context == null) {
            QLog.w(TAG, 1, "[handleExportResult] no context");
            return;
        }
        if (outputData.e().isEmpty()) {
            QLog.d(TAG, 1, "[handleExportResult] no medias");
            return;
        }
        boolean z16 = false;
        final LocalMediaInfo localMediaInfo = outputData.e().get(0);
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            Serializable serializableExtra = activity.getIntent().getSerializableExtra("selected_style_material");
            if (serializableExtra instanceof MetaMaterial) {
                z16 = c.Z0((MetaMaterial) serializableExtra);
            }
            if (z16) {
                QRouteApi api = QRoute.api(IWinkAPI.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
                IWinkAPI iWinkAPI = (IWinkAPI) api;
                Intent intent = new Intent();
                Bundle bundle = outputData.getBundle();
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                intent.putExtra("OUTPUT_MEDIA", new ArrayList(outputData.e()));
                Unit unit = Unit.INSTANCE;
                IWinkAPI.DefaultImpls.exitWink$default(iWinkAPI, false, -1, intent, 1, null);
                return;
            }
            d93.c.INSTANCE.b(activity, i.x(localMediaInfo), new Function0<Unit>(context, localMediaInfo) { // from class: com.tencent.mobileqq.emotionintegrate.media.WinkAIAvatarOutputRouter$handleCaptureResult$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ LocalMediaInfo $outputMedia;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.$outputMedia = localMediaInfo;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, WinkAIAvatarOutputRouter.this, context, localMediaInfo);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WinkAIAvatarMediaPickerViewModel viewModel;
                    ArrayList<LocalMediaInfo> arrayListOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    viewModel = WinkAIAvatarOutputRouter.this.getViewModel();
                    Context context2 = this.$context;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.$outputMedia);
                    viewModel.a2(context2, arrayListOf, AnonymousClass1.INSTANCE);
                }
            });
        }
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d(TAG, 1, "[handleCaptureResult] onBack");
        QRouteApi api = QRoute.api(IWinkAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
        IWinkAPI iWinkAPI = (IWinkAPI) api;
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Unit unit = Unit.INSTANCE;
        IWinkAPI.DefaultImpls.exitWink$default(iWinkAPI, false, 0, intent, 3, null);
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) outputData);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        QLog.d(TAG, 1, "[handleCaptureResult] begin");
        if (outputData.getOutputPoint() == 8) {
            handleCaptureResult(context, outputData);
        }
    }
}
