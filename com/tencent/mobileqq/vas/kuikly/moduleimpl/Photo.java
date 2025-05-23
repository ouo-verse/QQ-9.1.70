package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.api.IDiyCardBgUtils;
import com.tencent.mobileqq.vas.kuikly.ProxyFragment;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.TabType;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001a B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJS\u0010\u0016\u001a\u00020\u00102+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u00112\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0002J3\u0010\u0017\u001a\u00020\u00102+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011J3\u0010\u0018\u001a\u00020\u00102+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#\u00b2\u0006\f\u0010\"\u001a\u00020!8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "businessId", "businessScene", "", "permissions", "", "g", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "Lkotlin/Function2;", "", "otherResultHandler", "e", tl.h.F, "j", "Landroid/net/Uri;", "a", "Landroid/net/Uri;", "uploadCardBackgroundUri", "<init>", "()V", "b", "PickerCustomizeWithoutPreview", "Lcom/tencent/mobileqq/vas/api/IDiyCardBgUtils;", "diyCardBgUtils", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class Photo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Uri uploadCardBackgroundUri;

    @Keep
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo$PickerCustomizeWithoutPreview;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "layoutPosition", "onItemClickEvent", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class PickerCustomizeWithoutPreview extends PickerCustomizationBase<com.tencent.qqnt.qbasealbum.customization.common.a> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PickerCustomizeWithoutPreview(@NotNull FragmentActivity activity, @NotNull com.tencent.qqnt.qbasealbum.customization.common.b<com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData) {
            super(activity, photoCommonData);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        }

        @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if (resultCode != -1) {
                QLog.i("PickerCustomizeWithoutPreview", 1, "onActivityResult: request " + requestCode + " failure.");
                return;
            }
            if (requestCode == 1) {
                getActivity().setResult(resultCode, data);
                getActivity().finish();
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
        public void onItemClickEvent(@NotNull View view, @NotNull LocalMediaInfo mediaInfo, int layoutPosition) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            String path = mediaInfo.getPath();
            if (path == null) {
                QLog.i("PickerCustomizeWithoutPreview", 1, "[picker] onItemClickEvent layoutPosition:" + layoutPosition + " path is null");
                return;
            }
            QLog.i("PickerCustomizeWithoutPreview", 1, "[picker] onItemClickEvent layoutPosition:" + layoutPosition);
            ((IDiyCardBgUtils) QRoute.api(IDiyCardBgUtils.class)).jumpToCropForResult(getActivity(), 1, path);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/Photo$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "", "", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f309748a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f309749b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f309750c;

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes20.dex */
        static final class a implements DialogInterface.OnDismissListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f309751d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f309752e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Continuation<Boolean> f309753f;

            /* JADX WARN: Multi-variable type inference failed */
            a(String str, String str2, Continuation<? super Boolean> continuation) {
                this.f309751d = str;
                this.f309752e = str2;
                this.f309753f = continuation;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ReportInfo.report$default(VasCommonReporter.getDiyCard().setValue1("no permission: businessId " + this.f309751d + ", businessScene " + this.f309752e), false, 1, null);
                QLog.i("Photo", 1, "permission not granted");
                Continuation<Boolean> continuation = this.f309753f;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Boolean> continuation, String str, String str2) {
            this.f309748a = continuation;
            this.f309749b = str;
            this.f309750c = str2;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.i("Photo", 1, "permission granted");
            Continuation<Boolean> continuation = this.f309748a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            if (dialog != null) {
                dialog.setOnDismissListener(new a(this.f309749b, this.f309750c, this.f309748a));
            }
        }
    }

    private final void e(final Function1<Object, Unit> callback, final Function2<? super Activity, ? super Integer, Unit> otherResultHandler) {
        ProxyFragment.INSTANCE.c(new Function4<FragmentActivity, Integer, Integer, Intent, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$defineOnResultThenStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity, Integer num, Integer num2, Intent intent) {
                invoke(fragmentActivity, num.intValue(), num2.intValue(), intent);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FragmentActivity activity, int i3, int i16, @Nullable Intent intent) {
                String str;
                Map mapOf;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (i16 != -1) {
                    QLog.i("Photo", 1, "onActivityResult: request " + i3 + " failure.");
                    Function1<Object, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(null);
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    if (intent == null || (str = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) == null) {
                        str = "";
                    }
                    QLog.i("Photo", 1, "crop result path: " + str);
                    Function1<Object, Unit> function12 = callback;
                    if (function12 != null) {
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("cropResultPath", str));
                        function12.invoke(mapOf);
                        return;
                    }
                    return;
                }
                Function2<Activity, Integer, Unit> function2 = otherResultHandler;
                if (function2 != null) {
                    function2.invoke(activity, Integer.valueOf(i3));
                }
            }
        });
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void f(Photo photo, Function1 function1, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        photo.e(function1, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(Activity activity, String str, String str2, String[] strArr, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(str, str2));
        boolean z16 = true;
        for (String str3 : strArr) {
            if (!z16 || qQPermission.hasPermission(str3) != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
        }
        if (!z16) {
            qQPermission.requestPermissions(strArr, 2, new b(safeContinuation, str, str2));
        } else {
            QLog.i("Photo", 1, "already have permission");
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IDiyCardBgUtils i(Lazy<? extends IDiyCardBgUtils> lazy) {
        return lazy.getValue();
    }

    public final void h(@Nullable final Function1<Object, Unit> callback) {
        final Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IDiyCardBgUtils>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openCameraWithEdit$diyCardBgUtils$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IDiyCardBgUtils invoke() {
                return (IDiyCardBgUtils) QRoute.api(IDiyCardBgUtils.class);
            }
        });
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.b(false);
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openCameraWithEdit$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openCameraWithEdit$1$1", f = "Photo.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openCameraWithEdit$1$1, reason: invalid class name */
            /* loaded from: classes20.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ FragmentActivity $activity;
                final /* synthetic */ Function1<Object, Unit> $callback;
                final /* synthetic */ Lazy<IDiyCardBgUtils> $diyCardBgUtils$delegate;
                int label;
                final /* synthetic */ Photo this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(Photo photo, FragmentActivity fragmentActivity, Function1<Object, Unit> function1, Lazy<? extends IDiyCardBgUtils> lazy, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = photo;
                    this.$activity = fragmentActivity;
                    this.$callback = function1;
                    this.$diyCardBgUtils$delegate = lazy;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$activity, this.$callback, this.$diyCardBgUtils$delegate, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    IDiyCardBgUtils i3;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i16 = this.label;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Photo photo = this.this$0;
                        FragmentActivity fragmentActivity = this.$activity;
                        String[] strArr = {QQPermissionConstants.Permission.CAMERA};
                        this.label = 1;
                        obj = photo.g(fragmentActivity, QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.CARD_CAMERA, strArr, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        QLog.e("Photo", 1, "\u65e0\u62cd\u7167\u6743\u9650");
                        Function1<Object, Unit> function1 = this.$callback;
                        if (function1 != null) {
                            function1.invoke(null);
                        }
                        return Unit.INSTANCE;
                    }
                    Photo photo2 = this.this$0;
                    i3 = Photo.i(this.$diyCardBgUtils$delegate);
                    photo2.uploadCardBackgroundUri = i3.enterSnapshot(this.$activity, 0);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new AnonymousClass1(Photo.this, activity, callback, lazy, null), 3, null);
            }
        });
        e(callback, new Function2<Activity, Integer, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openCameraWithEdit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Activity activity, Integer num) {
                invoke(activity, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Activity activity, int i3) {
                Uri uri;
                IDiyCardBgUtils i16;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (i3 == 0) {
                    uri = Photo.this.uploadCardBackgroundUri;
                    String imagePath = FileProvider7Helper.getRealPathFromContentURI(activity, uri);
                    i16 = Photo.i(lazy);
                    Intrinsics.checkNotNullExpressionValue(imagePath, "imagePath");
                    i16.jumpToCropForResult(activity, 1, imagePath);
                }
            }
        });
    }

    public final void j(@Nullable final Function1<Object, Unit> callback) {
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.b(false);
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openQAlbumWithEdit$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openQAlbumWithEdit$1$1", f = "Photo.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.vas.kuikly.moduleimpl.Photo$openQAlbumWithEdit$1$1, reason: invalid class name */
            /* loaded from: classes20.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ FragmentActivity $activity;
                final /* synthetic */ Function1<Object, Unit> $callback;
                int label;
                final /* synthetic */ Photo this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Photo photo, FragmentActivity fragmentActivity, Function1<Object, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = photo;
                    this.$activity = fragmentActivity;
                    this.$callback = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$activity, this.$callback, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Photo photo = this.this$0;
                        FragmentActivity fragmentActivity = this.$activity;
                        String[] GROUP_STORAGE = QQPermissionConstants.Permission.GROUP_STORAGE;
                        Intrinsics.checkNotNullExpressionValue(GROUP_STORAGE, "GROUP_STORAGE");
                        this.label = 1;
                        obj = photo.g(fragmentActivity, QQPermissionConstants.Business.ID.QQ_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_ALBUM, GROUP_STORAGE, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        QLog.e("Photo", 1, "\u65e0\u8bbf\u95ee\u76f8\u518c\u6743\u9650");
                        Function1<Object, Unit> function1 = this.$callback;
                        if (function1 != null) {
                            function1.invoke(null);
                        }
                        return Unit.INSTANCE;
                    }
                    com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
                    FragmentActivity fragmentActivity2 = this.$activity;
                    Config.Companion companion = Config.INSTANCE;
                    Config.a aVar2 = new Config.a();
                    aVar2.f(TabType.TAB_IMAGE);
                    aVar2.q(true);
                    aVar2.l(true);
                    Unit unit = Unit.INSTANCE;
                    this.$activity.startActivityForResult(com.tencent.qqnt.qbasealbum.a.e(aVar, fragmentActivity2, aVar2.a(), null, Photo.PickerCustomizeWithoutPreview.class, null, 20, null), 1);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new AnonymousClass1(Photo.this, activity, callback, null), 3, null);
            }
        });
        f(this, callback, null, 2, null);
    }
}
