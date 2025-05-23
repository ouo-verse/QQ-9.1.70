package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ChooseCoverController;
import com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi;
import com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\"\u0010\u0013\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0015\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010:\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController;", "", "", "p", "", "e", tl.h.F, "", "path", "clipInfo", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "j", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "type", "k", "l", "o", "a", "Landroid/content/Context;", "mContext", "", "b", "[I", "mCurShowItemIndex", "", "c", "[Ljava/lang/String;", "mMenuItems", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "mApp", "Lcom/tencent/mobileqq/guild/common/upload/GuildCgiUploader;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/guild/common/upload/GuildCgiUploader;", "mGuildCgiUploader", "Landroid/net/Uri;", "Landroid/net/Uri;", "getUploadPhotoUri", "()Landroid/net/Uri;", "setUploadPhotoUri", "(Landroid/net/Uri;)V", "uploadPhotoUri", "Ljava/lang/String;", "mUploadType", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mLoadingDialog", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "mQQPermission", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "mConfig", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lmqq/app/AppRuntime;", "appRuntime", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lmqq/app/AppRuntime;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ChooseCoverController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int[] mCurShowItemIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String[] mMenuItems;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface mApp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGuildCgiUploader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Uri uploadPhotoUri;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mUploadType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQProgressDialog mLoadingDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQPermission mQQPermission;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BusinessConfig mConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController$b", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$b;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$c;", "task", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$d;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IUploadApi.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ChooseCoverController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ChooseCoverController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.guild.util.aa.a(R.string.f14860101);
            this$0.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(ChooseCoverController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f();
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
        public void a(@NotNull IUploadApi.c task, @NotNull IUploadApi.d state) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = state.f230931a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        QLog.d("QGL.ChooseCoverController", 1, "[onTaskStateUpdate] UPLOAD_FAILURE " + state);
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final ChooseCoverController chooseCoverController = ChooseCoverController.this;
                        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                ChooseCoverController.b.f(ChooseCoverController.this);
                            }
                        });
                        return;
                    }
                    return;
                }
                QLog.d("QGL.ChooseCoverController", 1, "[onTaskStateUpdate] UPLOAD_SUCCESS " + state);
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final ChooseCoverController chooseCoverController2 = ChooseCoverController.this;
                uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChooseCoverController.b.g(ChooseCoverController.this);
                    }
                });
                return;
            }
            QLog.d("QGL.ChooseCoverController", 1, "[onTaskStateUpdate] UPLOADING " + state);
            Handler uIHandlerV23 = ThreadManagerV2.getUIHandlerV2();
            final ChooseCoverController chooseCoverController3 = ChooseCoverController.this;
            uIHandlerV23.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.b
                @Override // java.lang.Runnable
                public final void run() {
                    ChooseCoverController.b.e(ChooseCoverController.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "uncertainPermission", "onUncertain", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ChooseCoverController.this.h();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(@NotNull String uncertainPermission) {
            Intrinsics.checkNotNullParameter(uncertainPermission, "uncertainPermission");
            super.onUncertain(uncertainPermission);
            ChooseCoverController.this.h();
        }
    }

    public ChooseCoverController(@NotNull Context context, @NotNull final IGProGuildInfo guildInfo, @NotNull final AppRuntime appRuntime) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mContext = context;
        this.mApp = (AppInterface) appRuntime;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildCgiUploader>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ChooseCoverController$mGuildCgiUploader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildCgiUploader invoke() {
                return new GuildCgiUploader(AppRuntime.this.getCurrentUin(), guildInfo.getGuildID());
            }
        });
        this.mGuildCgiUploader = lazy;
        this.mUploadType = "";
        this.mConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CHANNEL_LIVE, QQPermissionConstants.Business.SCENE.ENTER_AUDIO_ROOM);
    }

    private final boolean e() {
        QQPermission qQPermission = this.mQQPermission;
        Intrinsics.checkNotNull(qQPermission);
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        QQProgressDialog qQProgressDialog = this.mLoadingDialog;
        if (qQProgressDialog != null) {
            QQProgressDialog qQProgressDialog2 = null;
            if (qQProgressDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingDialog");
                qQProgressDialog = null;
            }
            if (qQProgressDialog.isShowing()) {
                QQProgressDialog qQProgressDialog3 = this.mLoadingDialog;
                if (qQProgressDialog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadingDialog");
                } else {
                    qQProgressDialog2 = qQProgressDialog3;
                }
                qQProgressDialog2.dismiss();
            }
        }
    }

    private final void g(String path, String clipInfo) {
        HashMap<String, String> a16 = com.tencent.mobileqq.guild.common.upload.b.a();
        a16.put("liveType", this.mUploadType);
        i().f(path, com.tencent.mobileqq.guild.common.upload.c.liveCover, a16, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.uploadPhotoUri = ((ISnapshotApi) QRoute.api(ISnapshotApi.class)).enterSnapshot((Activity) this.mContext, 257);
    }

    private final GuildCgiUploader i() {
        return (GuildCgiUploader) this.mGuildCgiUploader.getValue();
    }

    private final boolean j(Context context) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ChooseCoverController this$0, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        int[] iArr = this$0.mCurShowItemIndex;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
            iArr = null;
        }
        int i16 = iArr[i3];
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    return;
                }
            } else {
                ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoPick((Activity) this$0.mContext, 104);
            }
        } else {
            this$0.p();
        }
        try {
            sheet.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void p() {
        QLog.d("QGL.ChooseCoverController", 1, "[openCamera]");
        MobileQQ.sMobileQQ.peekAppRuntime();
        if (((ISnapshotApi) QRoute.api(ISnapshotApi.class)).isOnVideoCalling()) {
            QQToast.makeText(this.mContext, 0, R.string.f142640jx, 0).show();
        }
        if (this.mQQPermission == null) {
            this.mQQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, this.mConfig);
        }
        if (e()) {
            h();
            return;
        }
        String[] strArr = {QQPermissionConstants.Permission.CAMERA};
        QQPermission qQPermission = this.mQQPermission;
        Intrinsics.checkNotNull(qQPermission);
        qQPermission.requestPermissions(strArr, 2, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new QQProgressDialog(this.mContext);
        }
        QQProgressDialog qQProgressDialog = this.mLoadingDialog;
        QQProgressDialog qQProgressDialog2 = null;
        if (qQProgressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingDialog");
            qQProgressDialog = null;
        }
        if (!qQProgressDialog.isShowing()) {
            QQProgressDialog qQProgressDialog3 = this.mLoadingDialog;
            if (qQProgressDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingDialog");
                qQProgressDialog3 = null;
            }
            Context context = qQProgressDialog3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mLoadingDialog.context");
            if (j(context)) {
                QQProgressDialog qQProgressDialog4 = this.mLoadingDialog;
                if (qQProgressDialog4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLoadingDialog");
                } else {
                    qQProgressDialog2 = qQProgressDialog4;
                }
                qQProgressDialog2.show();
            }
        }
    }

    public final void k(@Nullable String path, @Nullable String clipInfo, int type) {
        this.mUploadType = String.valueOf(type);
        l(path, clipInfo);
    }

    public final boolean l(@Nullable String path, @Nullable String clipInfo) {
        boolean z16;
        QLog.d("QGL.ChooseCoverController", 1, "onPicPicked " + path + " " + clipInfo);
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        g(path, clipInfo);
        return true;
    }

    public final void m() {
        QLog.d("QGL.ChooseCoverController", 1, "[onPickPic]");
        this.mCurShowItemIndex = r0;
        int[] iArr = {0};
        int[] iArr2 = this.mCurShowItemIndex;
        if (iArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
            iArr2 = null;
        }
        iArr2[1] = 1;
        int[] iArr3 = this.mCurShowItemIndex;
        if (iArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
            iArr3 = null;
        }
        iArr3[2] = 2;
        String[] stringArray = this.mContext.getResources().getStringArray(R.array.f155208bn);
        Intrinsics.checkNotNullExpressionValue(stringArray, "mContext.resources.getSt\u2026live_choose_avatar_items)");
        this.mMenuItems = stringArray;
        Dialog createDialog = ActionSheetHelper.createDialog(this.mContext, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        int[] iArr4 = this.mCurShowItemIndex;
        if (iArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
            iArr4 = null;
        }
        int length = iArr4.length;
        for (int i3 = 0; i3 < length; i3++) {
            int[] iArr5 = this.mCurShowItemIndex;
            if (iArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
                iArr5 = null;
            }
            if (iArr5[i3] == 2) {
                String[] strArr = this.mMenuItems;
                if (strArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMenuItems");
                    strArr = null;
                }
                int[] iArr6 = this.mCurShowItemIndex;
                if (iArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
                    iArr6 = null;
                }
                actionSheet.addCancelButton(strArr[iArr6[i3]]);
            } else {
                String[] strArr2 = this.mMenuItems;
                if (strArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMenuItems");
                    strArr2 = null;
                }
                int[] iArr7 = this.mCurShowItemIndex;
                if (iArr7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurShowItemIndex");
                    iArr7 = null;
                }
                actionSheet.addButton(strArr2[iArr7[i3]], 0);
            }
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                ChooseCoverController.n(ChooseCoverController.this, actionSheet, view, i16);
            }
        });
        actionSheet.show();
    }

    public final void o() {
        Uri uri = this.uploadPhotoUri;
        if (uri != null) {
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(this.mContext, uri);
            if (!TextUtils.isEmpty(realPathFromContentURI)) {
                ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoEdit((Activity) this.mContext, realPathFromContentURI, 104);
            }
        }
    }
}
