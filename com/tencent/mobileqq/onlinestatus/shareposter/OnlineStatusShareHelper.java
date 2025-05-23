package com.tencent.mobileqq.onlinestatus.shareposter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.business.ak;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.u;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.z;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Y2\u00020\u0001:\u00028@B\u000f\u0012\u0006\u0010>\u001a\u000207\u00a2\u0006\u0004\bX\u0010=J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ?\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J%\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#J%\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010#J\u001d\u0010&\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J-\u0010*\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010'J\u0012\u0010-\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u001d\u0010.\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010'J\u0012\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\rH\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u0006H\u0002J\u0010\u00102\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u00103\u001a\u00020\u0006J\u0010\u00106\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000104R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/shareposter/OnlineStatusShareHelper;", "", "Lcom/tencent/mobileqq/onlinestatus/model/g;", "onlineStatusData", "", "isAvatarOpened", "", "Y", "(Lcom/tencent/mobileqq/onlinestatus/model/g;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onlineStatusId", "", "backgroundUrl", "Landroid/graphics/Bitmap;", "qrCodeBitmap", "V", "(Lcom/tencent/mobileqq/onlinestatus/model/g;IZLjava/lang/String;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "actionId", "posterBitmap", "L", "Landroid/graphics/drawable/Drawable;", UserInfo.SEX_FEMALE, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "Lcom/tencent/mobileqq/onlinestatus/shareposter/e;", "shareActionSheet", "I", "status", "M", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G", MimeHelper.IMAGE_SUBTYPE_BITMAP, "useBottomHalfPreview", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Landroid/graphics/Bitmap;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "H", BdhLogUtil.LogTag.Tag_Req, "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wechatFriend", "isNewPanel", ExifInterface.LATITUDE_SOUTH, "(Landroid/graphics/Bitmap;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyTKDListViewAdapter.X, "O", "N", "y", "U", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "W", "K", "Lcom/tencent/mobileqq/onlinestatus/shareposter/OnlineStatusShareHelper$b;", "onSuperQQShowSwitchChangeListener", "P", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "mActivity", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "b", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "mWXShareListener", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "c", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mShareActionSheet", "Lcom/tencent/mobileqq/sharepanel/f;", "d", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "mLoadingDialog", "f", "Lcom/tencent/mobileqq/onlinestatus/shareposter/OnlineStatusShareHelper$b;", "mOnSuperQQShowSwitchChangeListener", "Lkotlinx/coroutines/CoroutineScope;", "g", "Lkotlin/Lazy;", "D", "()Lkotlinx/coroutines/CoroutineScope;", "mMainScope", "<init>", tl.h.F, "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Bitmap.CompressFormat f256247i = Bitmap.CompressFormat.JPEG;

    /* renamed from: j, reason: collision with root package name */
    private static final int f256248j = ViewUtils.dip2px(228.0f);

    /* renamed from: k, reason: collision with root package name */
    private static final int f256249k = ViewUtils.dip2px(280.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Activity mActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WXShareHelper.a mWXShareListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet mShareActionSheet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.f sharePanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog mLoadingDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mOnSuperQQShowSwitchChangeListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMainScope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/shareposter/OnlineStatusShareHelper$b;", "", "", "switchFlag", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void a(int switchFlag);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/onlinestatus/shareposter/OnlineStatusShareHelper$c", "Lec2/a;", "", "success", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements ec2.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f256258b;

        c(int i3) {
            this.f256258b = i3;
        }

        @Override // ec2.a
        public void a(boolean success) {
            b bVar;
            OnlineStatusShareHelper.this.A();
            if (success && (bVar = OnlineStatusShareHelper.this.mOnSuperQQShowSwitchChangeListener) != null) {
                bVar.a(this.f256258b);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/shareposter/OnlineStatusShareHelper$d", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.j {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f256260b;

        d(Bitmap bitmap) {
            this.f256260b = bitmap;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            OnlineStatusShareHelper.this.L(channelId, this.f256260b);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            OnlineStatusShareHelper.this.L(actionId, this.f256260b);
        }
    }

    public OnlineStatusShareHelper(@NotNull Activity mActivity) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$mMainScope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.mMainScope = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                try {
                    Dialog dialog2 = this.mLoadingDialog;
                    Intrinsics.checkNotNull(dialog2);
                    dialog2.dismiss();
                } catch (Exception e16) {
                    QLog.e("OnlineStatusShareHelper", 2, "dismissLoadingDialog error! ", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        ShareActionSheet shareActionSheet = this.mShareActionSheet;
        if (shareActionSheet != null) {
            if (shareActionSheet.isShowing()) {
                shareActionSheet.dismiss();
            }
            this.mShareActionSheet = null;
        }
        com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
        if (fVar != null) {
            fVar.dismiss();
        }
        this.sharePanel = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope D() {
        return (CoroutineScope) this.mMainScope.getValue();
    }

    private final Object E(int i3, Continuation<? super String> continuation) {
        Continuation intercepted;
        int i16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusShareHelper");
        if (H != null) {
            i16 = bs.t(H, i3);
        } else {
            i16 = -1;
        }
        ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getNormalBackground(i3, new Function2<String, String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$getNormalBackgroundUrl$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String url, @NotNull String str) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                safeContinuation.resumeWith(Result.m476constructorimpl(url));
            }
        }, i16);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Object F(int i3, Continuation<? super Drawable> continuation) {
        Continuation intercepted;
        int i16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusShareHelper");
        if (H != null) {
            i16 = bs.t(H, i3);
        } else {
            i16 = -1;
        }
        ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getSelfPreviewImage(i3, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$getSelfPreviewImage$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Drawable drawable) {
                safeContinuation.resumeWith(Result.m476constructorimpl(drawable));
            }
        }, i16);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap G(e shareActionSheet) {
        Bitmap a16 = k.a(shareActionSheet.w0(), -1);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("OnlineStatusShareHelper", 2, "getSharePosterBitmap from sharePosterLayout failed, try use sharePosterContainer!");
            }
            return k.a(shareActionSheet.v0(), -1);
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062 A[Catch: OutOfMemoryError -> 0x00b6, TryCatch #0 {OutOfMemoryError -> 0x00b6, blocks: (B:11:0x002c, B:12:0x0058, B:14:0x0062, B:17:0x0069, B:20:0x0076, B:26:0x003c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: OutOfMemoryError -> 0x00b6, TryCatch #0 {OutOfMemoryError -> 0x00b6, blocks: (B:11:0x002c, B:12:0x0058, B:14:0x0062, B:17:0x0069, B:20:0x0076, B:26:0x003c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(Bitmap bitmap, boolean z16, Continuation<? super Intent> continuation) {
        OnlineStatusShareHelper$getShareToQQFriendData$1 onlineStatusShareHelper$getShareToQQFriendData$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        boolean z17;
        try {
            if (continuation instanceof OnlineStatusShareHelper$getShareToQQFriendData$1) {
                onlineStatusShareHelper$getShareToQQFriendData$1 = (OnlineStatusShareHelper$getShareToQQFriendData$1) continuation;
                int i16 = onlineStatusShareHelper$getShareToQQFriendData$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    onlineStatusShareHelper$getShareToQQFriendData$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = onlineStatusShareHelper$getShareToQQFriendData$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = onlineStatusShareHelper$getShareToQQFriendData$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            z16 = onlineStatusShareHelper$getShareToQQFriendData$1.Z$0;
                            objectRef = (Ref.ObjectRef) onlineStatusShareHelper$getShareToQQFriendData$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        CoroutineDispatcher io5 = Dispatchers.getIO();
                        OnlineStatusShareHelper$getShareToQQFriendData$2 onlineStatusShareHelper$getShareToQQFriendData$2 = new OnlineStatusShareHelper$getShareToQQFriendData$2(objectRef2, this, bitmap, null);
                        onlineStatusShareHelper$getShareToQQFriendData$1.L$0 = objectRef2;
                        onlineStatusShareHelper$getShareToQQFriendData$1.Z$0 = z16;
                        onlineStatusShareHelper$getShareToQQFriendData$1.label = 1;
                        if (BuildersKt.withContext(io5, onlineStatusShareHelper$getShareToQQFriendData$2, onlineStatusShareHelper$getShareToQQFriendData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    }
                    if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
                        QQToastUtil.showQQToast(1, R.string.f196814ib);
                        return null;
                    }
                    Bundle bundle = new Bundle();
                    if (z16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    bundle.putBoolean(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, z17);
                    bundle.putInt("forward_type", 1);
                    bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                    bundle.putString(AppConstants.Key.FORWARD_FILEPATH, (String) objectRef.element);
                    bundle.putString(AppConstants.Key.FORWARD_THUMB, (String) objectRef.element);
                    bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, (String) objectRef.element);
                    bundle.putString(AppConstants.Key.FORWARD_EXTRA, (String) objectRef.element);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    return intent;
                }
            }
            if (i3 == 0) {
            }
            if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
            }
        } catch (OutOfMemoryError unused) {
            QQToastUtil.showQQToast(1, R.string.f196824ic);
            return null;
        }
        onlineStatusShareHelper$getShareToQQFriendData$1 = new OnlineStatusShareHelper$getShareToQQFriendData$1(this, continuation);
        Object obj2 = onlineStatusShareHelper$getShareToQQFriendData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$getShareToQQFriendData$1.label;
    }

    private final void I(final e shareActionSheet, boolean isAvatarOpened) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        shareActionSheet.setIntentForStartForwardRecentActivity(intent);
        shareActionSheet.setRowVisibility(8, 0, 0);
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build2);
        boolean e06 = WXShareHelper.b0().e0();
        boolean f06 = WXShareHelper.b0().f0();
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusShareHelper", 2, " showShareActionSheet() isWxInstalled = ", Boolean.valueOf(e06), " isWxSupportApi = ", Boolean.valueOf(f06));
        }
        if (e06 && f06) {
            ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(9);
            Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
            arrayList.add(build3);
            ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(10);
            Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
            arrayList.add(build4);
        }
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build5);
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(6);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026tem.ACTION_ADD_FAVORITER)");
        arrayList2.add(build6);
        if (isAvatarOpened) {
            ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(207);
            Intrinsics.checkNotNullExpressionValue(build7, "build(ShareActionSheetBu\u2026TION_CLOSE_SUPER_QQ_SHOW)");
            arrayList2.add(build7);
        } else {
            ShareActionSheetBuilder.ActionSheetItem build8 = ShareActionSheetBuilder.ActionSheetItem.build(206);
            Intrinsics.checkNotNullExpressionValue(build8, "build(ShareActionSheetBu\u2026CTION_OPEN_SUPER_QQ_SHOW)");
            arrayList2.add(build8);
        }
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
        shareActionSheet.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.g
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
                OnlineStatusShareHelper.J(OnlineStatusShareHelper.this, shareActionSheet, actionSheetItem, shareActionSheet2);
            }
        });
        this.mShareActionSheet = shareActionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(OnlineStatusShareHelper this$0, e shareActionSheet, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet sheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareActionSheet, "$shareActionSheet");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(sheet, "sheet");
        QLog.d("OnlineStatusShareHelper", 2, " showShareActionSheet() click item = " + item.action);
        int i3 = item.action;
        if (i3 == 2) {
            BuildersKt__Builders_commonKt.launch$default(this$0.D(), null, null, new OnlineStatusShareHelper$initShareActionSheetItemList$1$1(this$0, shareActionSheet, null), 3, null);
            z.y(0);
            return;
        }
        if (i3 == 3) {
            BuildersKt__Builders_commonKt.launch$default(this$0.D(), null, null, new OnlineStatusShareHelper$initShareActionSheetItemList$1$2(this$0, shareActionSheet, null), 3, null);
            z.y(2);
            return;
        }
        if (i3 == 6) {
            BuildersKt__Builders_commonKt.launch$default(this$0.D(), null, null, new OnlineStatusShareHelper$initShareActionSheetItemList$1$5(this$0, shareActionSheet, null), 3, null);
            z.y(5);
            return;
        }
        if (i3 != 39) {
            if (i3 == 9) {
                BuildersKt__Builders_commonKt.launch$default(this$0.D(), null, null, new OnlineStatusShareHelper$initShareActionSheetItemList$1$3(this$0, shareActionSheet, null), 3, null);
                z.y(1);
                return;
            }
            if (i3 == 10) {
                BuildersKt__Builders_commonKt.launch$default(this$0.D(), null, null, new OnlineStatusShareHelper$initShareActionSheetItemList$1$4(this$0, shareActionSheet, null), 3, null);
                z.y(3);
                return;
            }
            if (i3 != 206) {
                if (i3 != 207) {
                    this$0.B();
                    return;
                }
                this$0.M(2);
                this$0.B();
                z.z(false);
                return;
            }
            this$0.M(1);
            this$0.B();
            z.z(true);
            return;
        }
        this$0.O(this$0.G(shareActionSheet));
        z.y(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(String actionId, Bitmap posterBitmap) {
        BuildersKt__Builders_commonKt.launch$default(D(), null, null, new OnlineStatusShareHelper$onSharePanelClick$1(actionId, this, posterBitmap, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int status) {
        U();
        bs.A0(status, new c(status));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object N(Bitmap bitmap, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$saveQRCodeReal$1 onlineStatusShareHelper$saveQRCodeReal$1;
        Object coroutine_suspended;
        int i3;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        if (continuation instanceof OnlineStatusShareHelper$saveQRCodeReal$1) {
            onlineStatusShareHelper$saveQRCodeReal$1 = (OnlineStatusShareHelper$saveQRCodeReal$1) continuation;
            int i16 = onlineStatusShareHelper$saveQRCodeReal$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$saveQRCodeReal$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusShareHelper$saveQRCodeReal$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusShareHelper$saveQRCodeReal$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) onlineStatusShareHelper$saveQRCodeReal$1.L$1;
                        booleanRef = (Ref.BooleanRef) onlineStatusShareHelper$saveQRCodeReal$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        CoroutineDispatcher io5 = Dispatchers.getIO();
                        OnlineStatusShareHelper$saveQRCodeReal$2 onlineStatusShareHelper$saveQRCodeReal$2 = new OnlineStatusShareHelper$saveQRCodeReal$2(objectRef2, booleanRef2, bitmap, null);
                        onlineStatusShareHelper$saveQRCodeReal$1.L$0 = booleanRef2;
                        onlineStatusShareHelper$saveQRCodeReal$1.L$1 = objectRef2;
                        onlineStatusShareHelper$saveQRCodeReal$1.label = 1;
                        if (BuildersKt.withContext(io5, onlineStatusShareHelper$saveQRCodeReal$2, onlineStatusShareHelper$saveQRCodeReal$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef = booleanRef2;
                        objectRef = objectRef2;
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f174742wo, 1).show();
                        QLog.e("OnlineStatusShareHelper", 1, "saveQRCodeReal error, invalidate bitmap!");
                        return Unit.INSTANCE;
                    }
                }
                if (!booleanRef.element) {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData((Uri) objectRef.element);
                    BaseApplication.getContext().sendBroadcast(intent);
                    QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(R.string.cwj), 1).show();
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.f174742wo, 1).show();
                }
                return Unit.INSTANCE;
            }
        }
        onlineStatusShareHelper$saveQRCodeReal$1 = new OnlineStatusShareHelper$saveQRCodeReal$1(this, continuation);
        Object obj2 = onlineStatusShareHelper$saveQRCodeReal$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$saveQRCodeReal$1.label;
        if (i3 == 0) {
        }
        if (!booleanRef.element) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(final Bitmap bitmap) {
        if (bitmap == null) {
            QLog.e("OnlineStatusShareHelper", 1, "saveSharePosterToPhoneAlbum error, bitmap is null!");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f174742wo, 1).show();
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            BuildersKt__Builders_commonKt.launch$default(D(), null, null, new OnlineStatusShareHelper$saveSharePosterToPhoneAlbum$1(this, bitmap, null), 3, null);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new QQPermission.BasePermissionsListener() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$saveSharePosterToPhoneAlbum$2
                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    CoroutineScope D;
                    super.onAllGranted();
                    D = OnlineStatusShareHelper.this.D();
                    BuildersKt__Builders_commonKt.launch$default(D, null, null, new OnlineStatusShareHelper$saveSharePosterToPhoneAlbum$2$onAllGranted$1(OnlineStatusShareHelper.this, bitmap, null), 3, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q(Bitmap bitmap, boolean z16, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$shareToQQFriend$1 onlineStatusShareHelper$shareToQQFriend$1;
        Object coroutine_suspended;
        int i3;
        OnlineStatusShareHelper onlineStatusShareHelper;
        Intent intent;
        if (continuation instanceof OnlineStatusShareHelper$shareToQQFriend$1) {
            onlineStatusShareHelper$shareToQQFriend$1 = (OnlineStatusShareHelper$shareToQQFriend$1) continuation;
            int i16 = onlineStatusShareHelper$shareToQQFriend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$shareToQQFriend$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusShareHelper$shareToQQFriend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusShareHelper$shareToQQFriend$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        onlineStatusShareHelper = (OnlineStatusShareHelper) onlineStatusShareHelper$shareToQQFriend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (bitmap == null) {
                        QLog.e("OnlineStatusShareHelper", 1, "shareToQQFriend error, bitmap is null!");
                        QQToastUtil.showQQToast(1, R.string.f172442qg);
                        return Unit.INSTANCE;
                    }
                    onlineStatusShareHelper$shareToQQFriend$1.L$0 = this;
                    onlineStatusShareHelper$shareToQQFriend$1.label = 1;
                    obj = H(bitmap, z16, onlineStatusShareHelper$shareToQQFriend$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    onlineStatusShareHelper = this;
                }
                intent = (Intent) obj;
                if (intent != null) {
                    QLog.e("OnlineStatusShareHelper", 1, "shareToQQFriend share data is null!");
                    return Unit.INSTANCE;
                }
                ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(onlineStatusShareHelper.mActivity, intent, 21);
                return Unit.INSTANCE;
            }
        }
        onlineStatusShareHelper$shareToQQFriend$1 = new OnlineStatusShareHelper$shareToQQFriend$1(this, continuation);
        Object obj2 = onlineStatusShareHelper$shareToQQFriend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$shareToQQFriend$1.label;
        if (i3 == 0) {
        }
        intent = (Intent) obj2;
        if (intent != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object R(Bitmap bitmap, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$shareToQZone$1 onlineStatusShareHelper$shareToQZone$1;
        Object coroutine_suspended;
        int i3;
        OnlineStatusShareHelper onlineStatusShareHelper;
        Ref.ObjectRef objectRef;
        if (continuation instanceof OnlineStatusShareHelper$shareToQZone$1) {
            onlineStatusShareHelper$shareToQZone$1 = (OnlineStatusShareHelper$shareToQZone$1) continuation;
            int i16 = onlineStatusShareHelper$shareToQZone$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$shareToQZone$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusShareHelper$shareToQZone$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusShareHelper$shareToQZone$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) onlineStatusShareHelper$shareToQZone$1.L$1;
                        onlineStatusShareHelper = (OnlineStatusShareHelper) onlineStatusShareHelper$shareToQZone$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (bitmap == null) {
                        QLog.e("OnlineStatusShareHelper", 1, "shareToQZone error, bitmap is null!");
                        QQToastUtil.showQQToast(1, R.string.f172442qg);
                        return Unit.INSTANCE;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    OnlineStatusShareHelper$shareToQZone$2 onlineStatusShareHelper$shareToQZone$2 = new OnlineStatusShareHelper$shareToQZone$2(objectRef2, this, bitmap, null);
                    onlineStatusShareHelper$shareToQZone$1.L$0 = this;
                    onlineStatusShareHelper$shareToQZone$1.L$1 = objectRef2;
                    onlineStatusShareHelper$shareToQZone$1.label = 1;
                    if (BuildersKt.withContext(io5, onlineStatusShareHelper$shareToQZone$2, onlineStatusShareHelper$shareToQZone$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    onlineStatusShareHelper = this;
                    objectRef = objectRef2;
                }
                if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
                    QQToastUtil.showQQToast(1, R.string.f196814ib);
                    return Unit.INSTANCE;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QQToastUtil.showQQToast(1, R.string.f172442qg);
                    QLog.e("OnlineStatusShareHelper", 1, "shareToQZone failed, appRuntime is null!");
                    return Unit.INSTANCE;
                }
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = peekAppRuntime.getAccount();
                Activity activity = onlineStatusShareHelper.mActivity;
                QZoneHelper.forwardToPublishMood(activity, userInfo, (String) objectRef.element, activity.getResources().getString(R.string.f172472qj), "", 20001);
                return Unit.INSTANCE;
            }
        }
        onlineStatusShareHelper$shareToQZone$1 = new OnlineStatusShareHelper$shareToQZone$1(this, continuation);
        Object obj2 = onlineStatusShareHelper$shareToQZone$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$shareToQZone$1.label;
        if (i3 == 0) {
        }
        if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object S(Bitmap bitmap, boolean z16, boolean z17, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$shareToWeChat$1 onlineStatusShareHelper$shareToWeChat$1;
        Object coroutine_suspended;
        int i3;
        Bitmap bitmap2;
        Ref.ObjectRef objectRef;
        if (continuation instanceof OnlineStatusShareHelper$shareToWeChat$1) {
            onlineStatusShareHelper$shareToWeChat$1 = (OnlineStatusShareHelper$shareToWeChat$1) continuation;
            int i16 = onlineStatusShareHelper$shareToWeChat$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$shareToWeChat$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusShareHelper$shareToWeChat$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusShareHelper$shareToWeChat$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        z17 = onlineStatusShareHelper$shareToWeChat$1.Z$1;
                        z16 = onlineStatusShareHelper$shareToWeChat$1.Z$0;
                        objectRef = (Ref.ObjectRef) onlineStatusShareHelper$shareToWeChat$1.L$1;
                        Bitmap bitmap3 = (Bitmap) onlineStatusShareHelper$shareToWeChat$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        bitmap2 = bitmap3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (bitmap == null) {
                        QLog.e("OnlineStatusShareHelper", 1, "shareToWeChat error, bitmap is null!");
                        QQToastUtil.showQQToast(1, R.string.f172442qg);
                        return Unit.INSTANCE;
                    }
                    if (!WXShareHelper.b0().e0()) {
                        Activity activity = this.mActivity;
                        QQToast.makeText(activity, activity.getString(R.string.f173257ih1), 0).show();
                        return Unit.INSTANCE;
                    }
                    if (!WXShareHelper.b0().f0()) {
                        Activity activity2 = this.mActivity;
                        QQToast.makeText(activity2, activity2.getString(R.string.f173258ih2), 0).show();
                        return Unit.INSTANCE;
                    }
                    if (this.mWXShareListener == null) {
                        this.mWXShareListener = new WXShareHelper.a() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.h
                            @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                            public final void onWXShareResp(BaseResp baseResp) {
                                OnlineStatusShareHelper.T(baseResp);
                            }
                        };
                        WXShareHelper.b0().A(this.mWXShareListener);
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    OnlineStatusShareHelper$shareToWeChat$3 onlineStatusShareHelper$shareToWeChat$3 = new OnlineStatusShareHelper$shareToWeChat$3(objectRef2, this, bitmap, null);
                    onlineStatusShareHelper$shareToWeChat$1.L$0 = bitmap;
                    onlineStatusShareHelper$shareToWeChat$1.L$1 = objectRef2;
                    onlineStatusShareHelper$shareToWeChat$1.Z$0 = z16;
                    onlineStatusShareHelper$shareToWeChat$1.Z$1 = z17;
                    onlineStatusShareHelper$shareToWeChat$1.label = 1;
                    if (BuildersKt.withContext(io5, onlineStatusShareHelper$shareToWeChat$3, onlineStatusShareHelper$shareToWeChat$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bitmap2 = bitmap;
                    objectRef = objectRef2;
                }
                if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
                    QQToastUtil.showQQToast(1, R.string.f196814ib);
                    return Unit.INSTANCE;
                }
                if (z17) {
                    if (z16) {
                        WXShareHelper.b0().v0((String) objectRef.element, bitmap2, f256249k, 0, null);
                    } else {
                        WXShareHelper.b0().v0((String) objectRef.element, bitmap2, f256249k, 1, null);
                    }
                    return Unit.INSTANCE;
                }
                if (z16) {
                    WXShareHelper.b0().u0((String) objectRef.element, bitmap2, 0);
                } else {
                    WXShareHelper.b0().u0((String) objectRef.element, bitmap2, 1);
                }
                return Unit.INSTANCE;
            }
        }
        onlineStatusShareHelper$shareToWeChat$1 = new OnlineStatusShareHelper$shareToWeChat$1(this, continuation);
        Object obj2 = onlineStatusShareHelper$shareToWeChat$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$shareToWeChat$1.label;
        if (i3 == 0) {
        }
        if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(BaseResp baseResp) {
        if (baseResp.errCode != 0) {
            QQToastUtil.showQQToast(1, R.string.f172442qg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        if (this.mLoadingDialog == null) {
            Activity activity = this.mActivity;
            this.mLoadingDialog = LoadingUtil.showLoadingDialog(activity, activity.getString(R.string.f172452qh), true);
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (!dialog.isShowing() && !this.mActivity.isFinishing()) {
                Dialog dialog2 = this.mLoadingDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object V(com.tencent.mobileqq.onlinestatus.model.g gVar, int i3, boolean z16, String str, Bitmap bitmap, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$showNewSharePanelInner$1 onlineStatusShareHelper$showNewSharePanelInner$1;
        Object coroutine_suspended;
        int i16;
        int i17;
        String str2;
        OnlineStatusShareHelper onlineStatusShareHelper;
        com.tencent.mobileqq.onlinestatus.model.g gVar2;
        Bitmap bitmap2;
        Drawable drawable;
        com.tencent.mobileqq.onlinestatus.model.g gVar3;
        Bitmap bitmap3;
        OnlineStatusShareHelper onlineStatusShareHelper2;
        int i18;
        boolean z17;
        int i19;
        Object e16;
        final OnlineStatusShareHelper onlineStatusShareHelper3;
        com.tencent.mobileqq.onlinestatus.model.g gVar4;
        boolean z18;
        boolean z19;
        final Bitmap bitmap4;
        boolean z26 = z16;
        if (continuation instanceof OnlineStatusShareHelper$showNewSharePanelInner$1) {
            onlineStatusShareHelper$showNewSharePanelInner$1 = (OnlineStatusShareHelper$showNewSharePanelInner$1) continuation;
            int i26 = onlineStatusShareHelper$showNewSharePanelInner$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$showNewSharePanelInner$1.label = i26 - Integer.MIN_VALUE;
                OnlineStatusShareHelper$showNewSharePanelInner$1 onlineStatusShareHelper$showNewSharePanelInner$12 = onlineStatusShareHelper$showNewSharePanelInner$1;
                Object obj = onlineStatusShareHelper$showNewSharePanelInner$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = onlineStatusShareHelper$showNewSharePanelInner$12.label;
                FragmentActivity fragmentActivity = null;
                if (i16 == 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            boolean z27 = onlineStatusShareHelper$showNewSharePanelInner$12.Z$0;
                            gVar4 = (com.tencent.mobileqq.onlinestatus.model.g) onlineStatusShareHelper$showNewSharePanelInner$12.L$1;
                            onlineStatusShareHelper3 = (OnlineStatusShareHelper) onlineStatusShareHelper$showNewSharePanelInner$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            e16 = obj;
                            i19 = 1;
                            z18 = z27;
                            bitmap4 = (Bitmap) e16;
                            onlineStatusShareHelper3.A();
                            if (bitmap4 != null) {
                                QLog.e("OnlineStatusShareHelper", i19, "showNewSharePanelInner posterBitmap is null");
                                BuildersKt__Builders_commonKt.launch$default(onlineStatusShareHelper3.D(), null, null, new OnlineStatusShareHelper$showNewSharePanelInner$2(onlineStatusShareHelper3, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            Activity activity = onlineStatusShareHelper3.mActivity;
                            if (activity instanceof FragmentActivity) {
                                fragmentActivity = (FragmentActivity) activity;
                            }
                            if (fragmentActivity == null) {
                                return Unit.INSTANCE;
                            }
                            com.tencent.mobileqq.sharepanel.f t06 = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(fragmentActivity, "relationship_state").q0(bitmap4).k0(new n() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$showNewSharePanelInner$3
                                @Override // com.tencent.mobileqq.sharepanel.n
                                public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull m callback) {
                                    CoroutineScope D;
                                    Intrinsics.checkNotNullParameter(targetList, "targetList");
                                    Intrinsics.checkNotNullParameter(callback, "callback");
                                    D = OnlineStatusShareHelper.this.D();
                                    BuildersKt__Builders_commonKt.launch$default(D, null, null, new OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1(OnlineStatusShareHelper.this, bitmap4, callback, null), 3, null);
                                }
                            }).c0("avatar_switch_off", z18).c0("avatar_switch_on", z18 ^ i19).t0(new d(bitmap4));
                            onlineStatusShareHelper3.sharePanel = t06;
                            if (t06 != null) {
                                t06.show();
                            }
                            z.A(false, gVar4.f256023b);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i18 = onlineStatusShareHelper$showNewSharePanelInner$12.I$0;
                    z26 = onlineStatusShareHelper$showNewSharePanelInner$12.Z$0;
                    Bitmap bitmap5 = (Bitmap) onlineStatusShareHelper$showNewSharePanelInner$12.L$3;
                    str2 = (String) onlineStatusShareHelper$showNewSharePanelInner$12.L$2;
                    com.tencent.mobileqq.onlinestatus.model.g gVar5 = (com.tencent.mobileqq.onlinestatus.model.g) onlineStatusShareHelper$showNewSharePanelInner$12.L$1;
                    onlineStatusShareHelper2 = (OnlineStatusShareHelper) onlineStatusShareHelper$showNewSharePanelInner$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    bitmap3 = bitmap5;
                    gVar3 = gVar5;
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (z26 && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(i3)) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    if (i17 != 0) {
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$0 = this;
                        gVar3 = gVar;
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$1 = gVar3;
                        str2 = str;
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$2 = str2;
                        bitmap3 = bitmap;
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$3 = bitmap3;
                        onlineStatusShareHelper$showNewSharePanelInner$12.Z$0 = z26;
                        onlineStatusShareHelper$showNewSharePanelInner$12.I$0 = i17;
                        onlineStatusShareHelper$showNewSharePanelInner$12.label = 1;
                        Object F = F(i3, onlineStatusShareHelper$showNewSharePanelInner$12);
                        if (F == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        onlineStatusShareHelper2 = this;
                        int i27 = i17;
                        obj = F;
                        i18 = i27;
                    } else {
                        str2 = str;
                        onlineStatusShareHelper = this;
                        gVar2 = gVar;
                        bitmap2 = bitmap;
                        drawable = null;
                        String str3 = str2;
                        OnlineStatusSharePosterHelper onlineStatusSharePosterHelper = new OnlineStatusSharePosterHelper();
                        Activity activity2 = onlineStatusShareHelper.mActivity;
                        if (i17 != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$0 = onlineStatusShareHelper;
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$1 = gVar2;
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$2 = null;
                        onlineStatusShareHelper$showNewSharePanelInner$12.L$3 = null;
                        onlineStatusShareHelper$showNewSharePanelInner$12.Z$0 = z26;
                        onlineStatusShareHelper$showNewSharePanelInner$12.label = 2;
                        i19 = 1;
                        e16 = onlineStatusSharePosterHelper.e(activity2, gVar2, str3, bitmap2, z17, drawable, onlineStatusShareHelper$showNewSharePanelInner$12);
                        if (e16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        onlineStatusShareHelper3 = onlineStatusShareHelper;
                        boolean z28 = z26;
                        gVar4 = gVar2;
                        z18 = z28;
                        bitmap4 = (Bitmap) e16;
                        onlineStatusShareHelper3.A();
                        if (bitmap4 != null) {
                        }
                    }
                }
                Drawable drawable2 = (Drawable) obj;
                if (QLog.isColorLevel()) {
                    if (drawable2 != null) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    QLog.d("OnlineStatusShareHelper", 2, "showNewSharePanelInner getSelfPreviewImage " + z19);
                }
                drawable = drawable2;
                onlineStatusShareHelper = onlineStatusShareHelper2;
                i17 = i18;
                gVar2 = gVar3;
                bitmap2 = bitmap3;
                String str32 = str2;
                OnlineStatusSharePosterHelper onlineStatusSharePosterHelper2 = new OnlineStatusSharePosterHelper();
                Activity activity22 = onlineStatusShareHelper.mActivity;
                if (i17 != 0) {
                }
                onlineStatusShareHelper$showNewSharePanelInner$12.L$0 = onlineStatusShareHelper;
                onlineStatusShareHelper$showNewSharePanelInner$12.L$1 = gVar2;
                onlineStatusShareHelper$showNewSharePanelInner$12.L$2 = null;
                onlineStatusShareHelper$showNewSharePanelInner$12.L$3 = null;
                onlineStatusShareHelper$showNewSharePanelInner$12.Z$0 = z26;
                onlineStatusShareHelper$showNewSharePanelInner$12.label = 2;
                i19 = 1;
                e16 = onlineStatusSharePosterHelper2.e(activity22, gVar2, str32, bitmap2, z17, drawable, onlineStatusShareHelper$showNewSharePanelInner$12);
                if (e16 == coroutine_suspended) {
                }
            }
        }
        onlineStatusShareHelper$showNewSharePanelInner$1 = new OnlineStatusShareHelper$showNewSharePanelInner$1(this, continuation);
        OnlineStatusShareHelper$showNewSharePanelInner$1 onlineStatusShareHelper$showNewSharePanelInner$122 = onlineStatusShareHelper$showNewSharePanelInner$1;
        Object obj2 = onlineStatusShareHelper$showNewSharePanelInner$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = onlineStatusShareHelper$showNewSharePanelInner$122.label;
        FragmentActivity fragmentActivity2 = null;
        if (i16 == 0) {
        }
        Drawable drawable22 = (Drawable) obj2;
        if (QLog.isColorLevel()) {
        }
        drawable = drawable22;
        onlineStatusShareHelper = onlineStatusShareHelper2;
        i17 = i18;
        gVar2 = gVar3;
        bitmap2 = bitmap3;
        String str322 = str2;
        OnlineStatusSharePosterHelper onlineStatusSharePosterHelper22 = new OnlineStatusSharePosterHelper();
        Activity activity222 = onlineStatusShareHelper.mActivity;
        if (i17 != 0) {
        }
        onlineStatusShareHelper$showNewSharePanelInner$122.L$0 = onlineStatusShareHelper;
        onlineStatusShareHelper$showNewSharePanelInner$122.L$1 = gVar2;
        onlineStatusShareHelper$showNewSharePanelInner$122.L$2 = null;
        onlineStatusShareHelper$showNewSharePanelInner$122.L$3 = null;
        onlineStatusShareHelper$showNewSharePanelInner$122.Z$0 = z26;
        onlineStatusShareHelper$showNewSharePanelInner$122.label = 2;
        i19 = 1;
        e16 = onlineStatusSharePosterHelper22.e(activity222, gVar2, str322, bitmap2, z17, drawable, onlineStatusShareHelper$showNewSharePanelInner$122);
        if (e16 == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(OnlineStatusShareHelper this$0, com.tencent.mobileqq.onlinestatus.model.g gVar, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(this$0.D(), null, null, new OnlineStatusShareHelper$showShareActionSheet$1$1(this$0, gVar, z16, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0152 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Y(com.tencent.mobileqq.onlinestatus.model.g gVar, boolean z16, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$showShareActionSheetInner$1 onlineStatusShareHelper$showShareActionSheetInner$1;
        OnlineStatusShareHelper$showShareActionSheetInner$1 onlineStatusShareHelper$showShareActionSheetInner$12;
        Object coroutine_suspended;
        int i3;
        int i16;
        boolean z17;
        Object E;
        OnlineStatusShareHelper onlineStatusShareHelper;
        int i17;
        OnlineStatusShareHelper onlineStatusShareHelper2;
        String str;
        ArrayList<au> arrayList;
        CoroutineDispatcher io5;
        OnlineStatusShareHelper$showShareActionSheetInner$2 onlineStatusShareHelper$showShareActionSheetInner$2;
        com.tencent.mobileqq.onlinestatus.model.g gVar2;
        int i18;
        boolean z18;
        Ref.ObjectRef objectRef;
        String str2;
        OnlineStatusShareHelper onlineStatusShareHelper3;
        boolean z19;
        boolean z26;
        a aVar;
        OnlineStatusShareHelper onlineStatusShareHelper4;
        com.tencent.mobileqq.onlinestatus.model.g gVar3;
        String str3;
        boolean z27;
        OnlineStatusShareHelper onlineStatusShareHelper5;
        e eVar;
        boolean z28;
        com.tencent.mobileqq.onlinestatus.model.g gVar4 = gVar;
        if (continuation instanceof OnlineStatusShareHelper$showShareActionSheetInner$1) {
            onlineStatusShareHelper$showShareActionSheetInner$1 = (OnlineStatusShareHelper$showShareActionSheetInner$1) continuation;
            int i19 = onlineStatusShareHelper$showShareActionSheetInner$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$showShareActionSheetInner$1.label = i19 - Integer.MIN_VALUE;
                onlineStatusShareHelper$showShareActionSheetInner$12 = onlineStatusShareHelper$showShareActionSheetInner$1;
                Object obj = onlineStatusShareHelper$showShareActionSheetInner$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusShareHelper$showShareActionSheetInner$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    z26 = onlineStatusShareHelper$showShareActionSheetInner$12.Z$0;
                                    a aVar2 = (a) onlineStatusShareHelper$showShareActionSheetInner$12.L$4;
                                    objectRef = (Ref.ObjectRef) onlineStatusShareHelper$showShareActionSheetInner$12.L$3;
                                    str3 = (String) onlineStatusShareHelper$showShareActionSheetInner$12.L$2;
                                    com.tencent.mobileqq.onlinestatus.model.g gVar5 = (com.tencent.mobileqq.onlinestatus.model.g) onlineStatusShareHelper$showShareActionSheetInner$12.L$1;
                                    onlineStatusShareHelper4 = (OnlineStatusShareHelper) onlineStatusShareHelper$showShareActionSheetInner$12.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    gVar3 = gVar5;
                                    z19 = true;
                                    aVar = aVar2;
                                    Drawable drawable = (Drawable) obj;
                                    if (QLog.isColorLevel()) {
                                        if (drawable != null) {
                                            z28 = z19;
                                        } else {
                                            z28 = false;
                                        }
                                        QLog.d("OnlineStatusShareHelper", 2, "getSelfPreviewImage result = " + z28);
                                    }
                                    aVar.E0(drawable);
                                    str2 = str3;
                                    gVar2 = gVar3;
                                    onlineStatusShareHelper5 = onlineStatusShareHelper4;
                                    z18 = z26;
                                    eVar = aVar;
                                    onlineStatusShareHelper5.I(eVar, z18);
                                    eVar.s0(gVar2, str2, (Bitmap) objectRef.element);
                                    onlineStatusShareHelper5.A();
                                    eVar.show();
                                    z.A(false, gVar2.f256023b);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        i18 = onlineStatusShareHelper$showShareActionSheetInner$12.I$0;
                        boolean z29 = onlineStatusShareHelper$showShareActionSheetInner$12.Z$0;
                        Ref.ObjectRef objectRef2 = (Ref.ObjectRef) onlineStatusShareHelper$showShareActionSheetInner$12.L$3;
                        str2 = (String) onlineStatusShareHelper$showShareActionSheetInner$12.L$2;
                        com.tencent.mobileqq.onlinestatus.model.g gVar6 = (com.tencent.mobileqq.onlinestatus.model.g) onlineStatusShareHelper$showShareActionSheetInner$12.L$1;
                        OnlineStatusShareHelper onlineStatusShareHelper6 = (OnlineStatusShareHelper) onlineStatusShareHelper$showShareActionSheetInner$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        gVar2 = gVar6;
                        z18 = z29;
                        objectRef = objectRef2;
                        onlineStatusShareHelper3 = onlineStatusShareHelper6;
                        if (QLog.isColorLevel()) {
                            if (objectRef.element != 0) {
                                z27 = true;
                            } else {
                                z27 = false;
                            }
                            QLog.d("OnlineStatusShareHelper", 2, "createQRCodeBitmap result = " + z27);
                        }
                        if (!((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("relationship_state")) {
                            Bitmap bitmap = (Bitmap) objectRef.element;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$0 = null;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$1 = null;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$2 = null;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$3 = null;
                            onlineStatusShareHelper$showShareActionSheetInner$12.label = 3;
                            if (onlineStatusShareHelper3.V(gVar2, i18, z18, str2, bitmap, onlineStatusShareHelper$showShareActionSheetInner$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                        param.context = onlineStatusShareHelper3.mActivity;
                        z19 = true;
                        param.fullScreen = true;
                        if (z18 && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(i18)) {
                            a aVar3 = new a(param);
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$0 = onlineStatusShareHelper3;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$1 = gVar2;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$2 = str2;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$3 = objectRef;
                            onlineStatusShareHelper$showShareActionSheetInner$12.L$4 = aVar3;
                            onlineStatusShareHelper$showShareActionSheetInner$12.Z$0 = z18;
                            onlineStatusShareHelper$showShareActionSheetInner$12.label = 4;
                            obj = onlineStatusShareHelper3.F(i18, onlineStatusShareHelper$showShareActionSheetInner$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z26 = z18;
                            aVar = aVar3;
                            onlineStatusShareHelper4 = onlineStatusShareHelper3;
                            gVar3 = gVar2;
                            str3 = str2;
                            Drawable drawable2 = (Drawable) obj;
                            if (QLog.isColorLevel()) {
                            }
                            aVar.E0(drawable2);
                            str2 = str3;
                            gVar2 = gVar3;
                            onlineStatusShareHelper5 = onlineStatusShareHelper4;
                            z18 = z26;
                            eVar = aVar;
                            onlineStatusShareHelper5.I(eVar, z18);
                            eVar.s0(gVar2, str2, (Bitmap) objectRef.element);
                            onlineStatusShareHelper5.A();
                            eVar.show();
                            z.A(false, gVar2.f256023b);
                            return Unit.INSTANCE;
                        }
                        eVar = new e(param);
                        onlineStatusShareHelper5 = onlineStatusShareHelper3;
                        onlineStatusShareHelper5.I(eVar, z18);
                        eVar.s0(gVar2, str2, (Bitmap) objectRef.element);
                        onlineStatusShareHelper5.A();
                        eVar.show();
                        z.A(false, gVar2.f256023b);
                        return Unit.INSTANCE;
                    }
                    int i26 = onlineStatusShareHelper$showShareActionSheetInner$12.I$0;
                    z17 = onlineStatusShareHelper$showShareActionSheetInner$12.Z$0;
                    com.tencent.mobileqq.onlinestatus.model.g gVar7 = (com.tencent.mobileqq.onlinestatus.model.g) onlineStatusShareHelper$showShareActionSheetInner$12.L$1;
                    OnlineStatusShareHelper onlineStatusShareHelper7 = (OnlineStatusShareHelper) onlineStatusShareHelper$showShareActionSheetInner$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    i16 = i26;
                    gVar4 = gVar7;
                    E = obj;
                    onlineStatusShareHelper = onlineStatusShareHelper7;
                } else {
                    ResultKt.throwOnFailure(obj);
                    i16 = bs.r(gVar4.f256022a, gVar4.f256023b).f256383a;
                    if (OnlineStatusToggleUtils.d()) {
                        au i27 = ak.f202506a.a().i(gVar4.f256022a, gVar4.f256023b);
                        Intrinsics.checkNotNullExpressionValue(i27, "OnlineStatusConfigRepo.g\u2026ineStatusData.mExtStatus)");
                        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusShareHelper");
                        if (H != null) {
                            i17 = bs.t(H, i16);
                        } else {
                            i17 = -1;
                        }
                        if (i27.f255489b == 1000 && i27.f255494g == AppRuntime.Status.online && (arrayList = i27.f255512y) != null && arrayList.size() > 0 && i27.f255512y.size() > i17) {
                            String str4 = i27.f255512y.get(i17).f255505r;
                        }
                        onlineStatusShareHelper2 = this;
                        str = i27.f255505r;
                        z17 = z16;
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineStatusShareHelper", 2, "getNormalBackgroundUrl backgroundUrl=" + str);
                        }
                        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        io5 = Dispatchers.getIO();
                        onlineStatusShareHelper$showShareActionSheetInner$2 = new OnlineStatusShareHelper$showShareActionSheetInner$2(objectRef3, onlineStatusShareHelper2, null);
                        onlineStatusShareHelper$showShareActionSheetInner$12.L$0 = onlineStatusShareHelper2;
                        onlineStatusShareHelper$showShareActionSheetInner$12.L$1 = gVar4;
                        onlineStatusShareHelper$showShareActionSheetInner$12.L$2 = str;
                        onlineStatusShareHelper$showShareActionSheetInner$12.L$3 = objectRef3;
                        onlineStatusShareHelper$showShareActionSheetInner$12.Z$0 = z17;
                        onlineStatusShareHelper$showShareActionSheetInner$12.I$0 = i16;
                        onlineStatusShareHelper$showShareActionSheetInner$12.label = 2;
                        if (BuildersKt.withContext(io5, onlineStatusShareHelper$showShareActionSheetInner$2, onlineStatusShareHelper$showShareActionSheetInner$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        gVar2 = gVar4;
                        i18 = i16;
                        String str5 = str;
                        z18 = z17;
                        objectRef = objectRef3;
                        str2 = str5;
                        onlineStatusShareHelper3 = onlineStatusShareHelper2;
                        if (QLog.isColorLevel()) {
                        }
                        if (!((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("relationship_state")) {
                        }
                    } else {
                        onlineStatusShareHelper$showShareActionSheetInner$12.L$0 = this;
                        onlineStatusShareHelper$showShareActionSheetInner$12.L$1 = gVar4;
                        z17 = z16;
                        onlineStatusShareHelper$showShareActionSheetInner$12.Z$0 = z17;
                        onlineStatusShareHelper$showShareActionSheetInner$12.I$0 = i16;
                        onlineStatusShareHelper$showShareActionSheetInner$12.label = 1;
                        E = E(i16, onlineStatusShareHelper$showShareActionSheetInner$12);
                        if (E == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        onlineStatusShareHelper = this;
                    }
                }
                str = (String) E;
                onlineStatusShareHelper2 = onlineStatusShareHelper;
                if (QLog.isColorLevel()) {
                }
                Ref.ObjectRef objectRef32 = new Ref.ObjectRef();
                io5 = Dispatchers.getIO();
                onlineStatusShareHelper$showShareActionSheetInner$2 = new OnlineStatusShareHelper$showShareActionSheetInner$2(objectRef32, onlineStatusShareHelper2, null);
                onlineStatusShareHelper$showShareActionSheetInner$12.L$0 = onlineStatusShareHelper2;
                onlineStatusShareHelper$showShareActionSheetInner$12.L$1 = gVar4;
                onlineStatusShareHelper$showShareActionSheetInner$12.L$2 = str;
                onlineStatusShareHelper$showShareActionSheetInner$12.L$3 = objectRef32;
                onlineStatusShareHelper$showShareActionSheetInner$12.Z$0 = z17;
                onlineStatusShareHelper$showShareActionSheetInner$12.I$0 = i16;
                onlineStatusShareHelper$showShareActionSheetInner$12.label = 2;
                if (BuildersKt.withContext(io5, onlineStatusShareHelper$showShareActionSheetInner$2, onlineStatusShareHelper$showShareActionSheetInner$12) == coroutine_suspended) {
                }
            }
        }
        onlineStatusShareHelper$showShareActionSheetInner$1 = new OnlineStatusShareHelper$showShareActionSheetInner$1(this, continuation);
        onlineStatusShareHelper$showShareActionSheetInner$12 = onlineStatusShareHelper$showShareActionSheetInner$1;
        Object obj2 = onlineStatusShareHelper$showShareActionSheetInner$12.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$showShareActionSheetInner$12.label;
        if (i3 == 0) {
        }
        str = (String) E;
        onlineStatusShareHelper2 = onlineStatusShareHelper;
        if (QLog.isColorLevel()) {
        }
        Ref.ObjectRef objectRef322 = new Ref.ObjectRef();
        io5 = Dispatchers.getIO();
        onlineStatusShareHelper$showShareActionSheetInner$2 = new OnlineStatusShareHelper$showShareActionSheetInner$2(objectRef322, onlineStatusShareHelper2, null);
        onlineStatusShareHelper$showShareActionSheetInner$12.L$0 = onlineStatusShareHelper2;
        onlineStatusShareHelper$showShareActionSheetInner$12.L$1 = gVar4;
        onlineStatusShareHelper$showShareActionSheetInner$12.L$2 = str;
        onlineStatusShareHelper$showShareActionSheetInner$12.L$3 = objectRef322;
        onlineStatusShareHelper$showShareActionSheetInner$12.Z$0 = z17;
        onlineStatusShareHelper$showShareActionSheetInner$12.I$0 = i16;
        onlineStatusShareHelper$showShareActionSheetInner$12.label = 2;
        if (BuildersKt.withContext(io5, onlineStatusShareHelper$showShareActionSheetInner$2, onlineStatusShareHelper$showShareActionSheetInner$12) == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object x(Bitmap bitmap, Continuation<? super Unit> continuation) {
        OnlineStatusShareHelper$addToFavorite$1 onlineStatusShareHelper$addToFavorite$1;
        Object coroutine_suspended;
        int i3;
        OnlineStatusShareHelper onlineStatusShareHelper;
        Ref.ObjectRef objectRef;
        if (continuation instanceof OnlineStatusShareHelper$addToFavorite$1) {
            onlineStatusShareHelper$addToFavorite$1 = (OnlineStatusShareHelper$addToFavorite$1) continuation;
            int i16 = onlineStatusShareHelper$addToFavorite$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                onlineStatusShareHelper$addToFavorite$1.label = i16 - Integer.MIN_VALUE;
                Object obj = onlineStatusShareHelper$addToFavorite$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = onlineStatusShareHelper$addToFavorite$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) onlineStatusShareHelper$addToFavorite$1.L$1;
                        onlineStatusShareHelper = (OnlineStatusShareHelper) onlineStatusShareHelper$addToFavorite$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (bitmap == null) {
                        QLog.e("OnlineStatusShareHelper", 1, "shareToQQFriend error, bitmap is null!");
                        QQToastUtil.showQQToast(1, R.string.ezv);
                        return Unit.INSTANCE;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    OnlineStatusShareHelper$addToFavorite$2 onlineStatusShareHelper$addToFavorite$2 = new OnlineStatusShareHelper$addToFavorite$2(objectRef2, this, bitmap, null);
                    onlineStatusShareHelper$addToFavorite$1.L$0 = this;
                    onlineStatusShareHelper$addToFavorite$1.L$1 = objectRef2;
                    onlineStatusShareHelper$addToFavorite$1.label = 1;
                    if (BuildersKt.withContext(io5, onlineStatusShareHelper$addToFavorite$2, onlineStatusShareHelper$addToFavorite$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    onlineStatusShareHelper = this;
                    objectRef = objectRef2;
                }
                if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
                    QQToastUtil.showQQToast(1, R.string.ezv);
                    return Unit.INSTANCE;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QQToastUtil.showQQToast(1, R.string.ezv);
                    QLog.e("OnlineStatusShareHelper", 1, "addToFavorite failed, appRuntime is null!");
                    return Unit.INSTANCE;
                }
                ((IQQFavHelper) peekAppRuntime.getRuntimeService(IQQFavHelper.class, "all")).addPictureToFavorite(peekAppRuntime, onlineStatusShareHelper.mActivity, (String) objectRef.element);
                return Unit.INSTANCE;
            }
        }
        onlineStatusShareHelper$addToFavorite$1 = new OnlineStatusShareHelper$addToFavorite$1(this, continuation);
        Object obj2 = onlineStatusShareHelper$addToFavorite$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = onlineStatusShareHelper$addToFavorite$1.label;
        if (i3 == 0) {
        }
        if (!TextUtils.isEmpty((CharSequence) objectRef.element)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String y(Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        String str = "temp_online_status_share_" + System.currentTimeMillis() + ".jpg";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "online_status").getAbsolutePath()));
        file.mkdirs();
        BufferedOutputStream bufferedOutputStream2 = null;
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), str);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                file2.delete();
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    bitmap.compress(f256247i, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineStatusShareHelper", 2, e17.getMessage());
                        }
                    }
                    return absolutePath;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.d("OnlineStatusShareHelper", 2, e18.getMessage());
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusShareHelper", 2, e.getMessage());
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e26) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineStatusShareHelper", 2, e26.getMessage());
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap z() {
        return i.i(this.mActivity, j.f().i("https://ti.qq.com/new_open_qq/index.html?appid=65&url=mqqapi%3A%2F%2Fonlinestatus%2Fhome%3Fsrc_type%3Dapp%26version%3D1.0%26sceneType%3D3").h(f256248j).f(-16777216).g(null).e());
    }

    @NotNull
    /* renamed from: C, reason: from getter */
    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final void K() {
        A();
        B();
        if (this.mWXShareListener != null) {
            WXShareHelper.b0().q0(this.mWXShareListener);
            this.mWXShareListener = null;
        }
        CoroutineScopeKt.cancel$default(D(), null, 1, null);
    }

    public final void P(@Nullable b onSuperQQShowSwitchChangeListener) {
        this.mOnSuperQQShowSwitchChangeListener = onSuperQQShowSwitchChangeListener;
    }

    public final void W(@Nullable final com.tencent.mobileqq.onlinestatus.model.g onlineStatusData) {
        if (onlineStatusData == null) {
            QLog.e("OnlineStatusShareHelper", 1, "showShareActionSheet error, onlineStatusData is null!");
        } else {
            U();
            bs.o(new u() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.f
                @Override // com.tencent.mobileqq.onlinestatus.u
                public final void a(boolean z16) {
                    OnlineStatusShareHelper.X(OnlineStatusShareHelper.this, onlineStatusData, z16);
                }
            });
        }
    }
}
