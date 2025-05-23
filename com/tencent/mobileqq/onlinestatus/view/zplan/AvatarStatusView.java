package com.tencent.mobileqq.onlinestatus.view.zplan;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.utils.z;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0007\n]^\u0012\u0014<@B\u001f\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020?\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010'\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010+\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u001a\u0010,\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J.\u00105\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\t2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000703H\u0002J\u0012\u00106\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020\u0007H\u0002R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010W\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/onlinestatus/view/aj;", "Landroid/view/View;", "getView", "Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "listener", "", "setEventListener", "", "a", "", "uin", "", "onlineStatusId", "onlineStatusSubIndex", "Lcom/tencent/mobileqq/onlinestatus/view/aj$c;", "option", "b", DKWebViewController.DKHippyWebviewFunction.RELOAD, "c", "stopAnimation", "release", "B", "Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "loadView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "P", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;", "state", "v", "dressKey", "K", "currentLoadState", "y", "w", "Landroid/graphics/drawable/Drawable;", "drawable", "J", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "L", "D", "E", "Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache$Key;", "cacheKey", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "noUpdatePreview", "Lkotlin/Function0;", "callback", "M", UserInfo.SEX_FEMALE, "O", "u", "I", "H", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "d", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "scene", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$e;", "e", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$e;", "showStrategy", "f", "Landroid/widget/FrameLayout;", "loadingView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "previewImage", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer;", "i", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer;", "filamentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;", "loadState", "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarStatusViewApi;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarStatusViewApi;", DTConstants.TAG.API, "Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "eventListener", "Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "avatarLoadView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$e;)V", "FilamentViewListener", "ImageState", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusView extends FrameLayout implements aj {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IAvatarStatusViewApi api;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private aj.a eventListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private aj.b avatarLoadView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AvatarStatusViewScene scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShowStrategy showStrategy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout loadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView previewImage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarStatusFilamentViewContainer filamentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private c loadState;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$FilamentViewListener;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewContainer$c;", "", "success", "", "error", "", "b", "onBind", "a", "", "uin", "onlineStatus", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "c", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;", "getState", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;", "state", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView;Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class FilamentViewListener implements AvatarStatusFilamentViewContainer.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c state;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AvatarStatusView f256786b;

        public FilamentViewListener(@NotNull AvatarStatusView avatarStatusView, c state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.f256786b = avatarStatusView;
            this.state = state;
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer.c
        public void a() {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onUnbind], this=" + hashCode());
            if (this.state.getFilamentState() == ImageState.Loaded) {
                this.state.l(ImageState.Ready);
            }
            AvatarStatusView avatarStatusView = this.f256786b;
            c cVar = avatarStatusView.loadState;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar = null;
            }
            avatarStatusView.y(cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView$c] */
        @Override // com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer.c
        public void b(boolean success, int error) {
            c cVar = this.state;
            c cVar2 = this.f256786b.loadState;
            ImageView imageView = null;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar2 = null;
            }
            if (cVar != cVar2) {
                c cVar3 = this.state;
                ?? r06 = this.f256786b.loadState;
                if (r06 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadState");
                } else {
                    imageView = r06;
                }
                QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onLoad] state is changed, success=" + success + ", state=" + cVar3 + "->" + imageView);
                return;
            }
            d perfData = this.state.getPerfData();
            AvatarStatusView avatarStatusView = this.f256786b;
            perfData.n(success);
            perfData.j(error);
            perfData.k(System.currentTimeMillis());
            perfData.i(System.currentTimeMillis());
            perfData.d();
            perfData.e(avatarStatusView.scene);
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onLoad] complete, success=" + success + ", param=" + this.state.getLoadParam());
            if (!success) {
                this.state.l(ImageState.Fail);
                AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.f256786b.filamentView;
                if (avatarStatusFilamentViewContainer != null) {
                    avatarStatusFilamentViewContainer.setVisibility(8);
                }
                this.f256786b.E(this.state);
            } else {
                this.state.l(ImageState.Loaded);
                this.f256786b.O();
                this.f256786b.z();
                ImageView imageView2 = this.f256786b.previewImage;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewImage");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(8);
            }
            this.f256786b.u();
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer.c
        public void c(@NotNull String uin, int onlineStatus, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(res, "res");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            c cVar = this.state;
            c cVar2 = this.f256786b.loadState;
            c cVar3 = null;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar2 = null;
            }
            if (cVar != cVar2) {
                int hashCode = hashCode();
                c cVar4 = this.state;
                c cVar5 = this.f256786b.loadState;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadState");
                } else {
                    cVar3 = cVar5;
                }
                QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetFirstFrame] state is changed, this=" + hashCode + " state=" + cVar4 + "->" + cVar3);
                return;
            }
            if (this.state.getPreviewImage() == null) {
                this.state.n(ImageState.Ready);
                this.state.m(new BitmapDrawable(this.f256786b.getContext().getResources(), bitmap));
            }
            final String dressKey = this.state.getDressKey();
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetFirstFrame] this=" + hashCode() + " uin=" + uin + " res=" + res + " dressKey=" + dressKey);
            if (dressKey == null) {
                QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetFirstFrame] dress key is null, this=" + hashCode() + " uin=" + uin + " res=" + res);
                this.f256786b.F(dressKey);
                return;
            }
            AvatarStatusView avatarStatusView = this.f256786b;
            AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, onlineStatus, res.getKey().getActionKey(), dressKey);
            boolean noUpdatePreview = this.state.getLoadParam().getOption().getNoUpdatePreview();
            final AvatarStatusView avatarStatusView2 = this.f256786b;
            avatarStatusView.M(key, bitmap, noUpdatePreview, new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView$FilamentViewListener$onGetFirstFrame$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AvatarStatusView.this.F(dressKey);
                }
            });
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewContainer.c
        public void onBind() {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onBind], this=" + hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;", "", "(Ljava/lang/String;I)V", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Prepare", "Ready", "Fail", "Loaded", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum ImageState {
        Init,
        Prepare,
        Ready,
        Fail,
        Loaded
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$b;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "b", "I", "()I", "onlineStatus", "c", "onlineStatusSubIndex", "Lcom/tencent/mobileqq/onlinestatus/view/aj$c;", "Lcom/tencent/mobileqq/onlinestatus/view/aj$c;", "()Lcom/tencent/mobileqq/onlinestatus/view/aj$c;", "option", "<init>", "(Ljava/lang/String;IILcom/tencent/mobileqq/onlinestatus/view/aj$c;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int onlineStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int onlineStatusSubIndex;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final aj.LoadOption option;

        public b(@NotNull String uin, int i3, int i16, @NotNull aj.LoadOption option) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(option, "option");
            this.uin = uin;
            this.onlineStatus = i3;
            this.onlineStatusSubIndex = i16;
            this.option = option;
        }

        /* renamed from: a, reason: from getter */
        public final int getOnlineStatus() {
            return this.onlineStatus;
        }

        /* renamed from: b, reason: from getter */
        public final int getOnlineStatusSubIndex() {
            return this.onlineStatusSubIndex;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final aj.LoadOption getOption() {
            return this.option;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof b)) {
                return false;
            }
            if (other == this) {
                return true;
            }
            b bVar = (b) other;
            if (!Intrinsics.areEqual(this.uin, bVar.uin) || this.onlineStatus != bVar.onlineStatus || this.onlineStatusSubIndex != bVar.onlineStatusSubIndex) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.uin.hashCode() * 31) + this.onlineStatus;
        }

        @NotNull
        public String toString() {
            return "{uin:" + this.uin + ",status:" + this.onlineStatus + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010'\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b(\u0010\u001d\"\u0004\b$\u0010\u001fR\"\u0010,\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u0010/\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001b\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u0011\u00100\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u001dR\u0011\u00101\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u001dR\u0011\u00102\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u001d\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$d;", "", "", "d", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "scene", "e", "", "a", "Z", "getLoadSuccess", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "loadSuccess", "", "b", "I", "getLoadErrorCode", "()I", "j", "(I)V", "loadErrorCode", "c", "isFirstLoad", tl.h.F, "", "J", "getLoadStartTime", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(J)V", "loadStartTime", "getLoadEndTime", "i", "loadEndTime", "f", "getDownloadResourceStartTime", "g", "downloadResourceStartTime", "getDownloadResourceEndTime", "downloadResourceEndTime", "getLoadFilamentStartTime", "l", "loadFilamentStartTime", "getLoadFilamentEndTime", "k", "loadFilamentEndTime", "totalTime", PreDownloadConstants.RPORT_KEY_DOWNLOAD_TIME, "loadFilamentTime", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean loadSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int loadErrorCode = -1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstLoad;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long loadStartTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long loadEndTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long downloadResourceStartTime;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long downloadResourceEndTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long loadFilamentStartTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long loadFilamentEndTime;

        public final long a() {
            long j3 = this.downloadResourceStartTime;
            if (j3 != 0) {
                long j16 = this.downloadResourceEndTime;
                if (j16 != 0) {
                    return j16 - j3;
                }
                return -1L;
            }
            return -1L;
        }

        public final long b() {
            long j3 = this.loadFilamentStartTime;
            if (j3 != 0) {
                long j16 = this.loadFilamentEndTime;
                if (j16 != 0) {
                    return j16 - j3;
                }
                return -1L;
            }
            return -1L;
        }

        public final long c() {
            long j3 = this.loadStartTime;
            if (j3 != 0) {
                long j16 = this.loadEndTime;
                if (j16 != 0) {
                    return j16 - j3;
                }
                return -1L;
            }
            return -1L;
        }

        public final void d() {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "Load-Perf:{success:" + this.loadSuccess + "},first:" + this.isFirstLoad + ",total:" + c() + ",download:" + a() + ",load:" + b());
        }

        public final void e(@NotNull AvatarStatusViewScene scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            z.u(this.loadSuccess, a());
            z.t(scene.toString(), this.isFirstLoad, this.loadSuccess, this.loadErrorCode, b(), c());
        }

        public final void f(long j3) {
            this.downloadResourceEndTime = j3;
        }

        public final void g(long j3) {
            this.downloadResourceStartTime = j3;
        }

        public final void h(boolean z16) {
            this.isFirstLoad = z16;
        }

        public final void i(long j3) {
            this.loadEndTime = j3;
        }

        public final void j(int i3) {
            this.loadErrorCode = i3;
        }

        public final void k(long j3) {
            this.loadFilamentEndTime = j3;
        }

        public final void l(long j3) {
            this.loadFilamentStartTime = j3;
        }

        public final void m(long j3) {
            this.loadStartTime = j3;
        }

        public final void n(boolean z16) {
            this.loadSuccess = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "showPreview", "showFilament", "<init>", "(ZZ)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ShowStrategy {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showPreview;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showFilament;

        public ShowStrategy(boolean z16, boolean z17) {
            this.showPreview = z16;
            this.showFilament = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowFilament() {
            return this.showFilament;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShowPreview() {
            return this.showPreview;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowStrategy)) {
                return false;
            }
            ShowStrategy showStrategy = (ShowStrategy) other;
            if (this.showPreview == showStrategy.showPreview && this.showFilament == showStrategy.showFilament) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.showPreview;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.showFilament;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "ShowStrategy(showPreview=" + this.showPreview + ", showFilament=" + this.showFilament + ")";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f256810a;

        static {
            int[] iArr = new int[ImageState.values().length];
            try {
                iArr[ImageState.Ready.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageState.Loaded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f256810a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarStatusView(@NotNull Context context, @NotNull AvatarStatusViewScene scene, @NotNull ShowStrategy showStrategy) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(showStrategy, "showStrategy");
        this.scene = scene;
        this.showStrategy = showStrategy;
        QRouteApi api = QRoute.api(IAvatarStatusViewApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAvatarStatusViewApi::class.java)");
        this.api = (IAvatarStatusViewApi) api;
        B();
    }

    private final void A(aj.b loadView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        aj.b bVar = this.avatarLoadView;
        if (bVar != null) {
            bVar.hide();
        }
        FrameLayout frameLayout = this.loadingView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        this.avatarLoadView = loadView;
        if (loadView != null) {
            FrameLayout frameLayout3 = this.loadingView;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.addView(loadView.getView(), layoutParams);
            z();
        }
    }

    private final void B() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(R.id.efs);
        frameLayout.setVisibility(8);
        this.loadingView = frameLayout;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(frameLayout, layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setId(R.id.fyj);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        this.previewImage = imageView;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarStatusView.C(AvatarStatusView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AvatarStatusView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aj.a aVar = this$0.eventListener;
        if (aVar != null) {
            aVar.onClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D(c state, boolean reload) {
        boolean z16 = true;
        if (!this.showStrategy.getShowFilament()) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadFilament] disabled, this=" + hashCode());
        }
        if (state.getFilamentResource() == null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadFilament] res path is null, this=" + hashCode());
            return;
        }
        if (state.getFilamentPaused()) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadFilament] animation paused, this=" + hashCode() + ", state=" + state);
            return;
        }
        c cVar = this.loadState;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        cVar.l(ImageState.Ready);
        state.getPerfData().l(System.currentTimeMillis());
        AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.filamentView;
        Intrinsics.checkNotNull(avatarStatusFilamentViewContainer);
        avatarStatusFilamentViewContainer.setVisibility(0);
        avatarStatusFilamentViewContainer.setAlpha(0.001f);
        avatarStatusFilamentViewContainer.setListener(new FilamentViewListener(this, state));
        boolean c16 = avatarStatusFilamentViewContainer.c();
        String uin = state.getLoadParam().getUin();
        int onlineStatus = state.getLoadParam().getOnlineStatus();
        com.tencent.mobileqq.onlinestatus.model.b filamentResource = state.getFilamentResource();
        Intrinsics.checkNotNull(filamentResource);
        if (!c16 && !reload) {
            z16 = false;
        }
        avatarStatusFilamentViewContainer.f(uin, onlineStatus, filamentResource, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(c state) {
        if (!this.showStrategy.getShowPreview()) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadPreview] disabled, this=" + hashCode() + " state=" + state.getPreviewState());
            return;
        }
        if (state.getPreviewImage() == null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadPreview] preview image is null, this=" + hashCode() + " state=" + state.getPreviewState());
            return;
        }
        z();
        ImageState imageState = ImageState.Loaded;
        state.n(imageState);
        ImageView imageView = this.previewImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewImage");
            imageView = null;
        }
        imageView.setImageDrawable(state.getPreviewImage());
        if (state.getFilamentState() != imageState) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadPreview] show preview, state=" + state + "}");
            ImageView imageView3 = this.previewImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewImage");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(0);
            aj.a aVar = this.eventListener;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[loadPreview] filament is showing, hide preview, state=" + state);
        ImageView imageView4 = this.previewImage;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewImage");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final String dressKey) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            aj.a aVar = this.eventListener;
            if (aVar != null) {
                aVar.b(dressKey);
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.f
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusView.G(AvatarStatusView.this, dressKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AvatarStatusView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aj.a aVar = this$0.eventListener;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    private final void H() {
        int hashCode = hashCode();
        c cVar = this.loadState;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[notifyLoadFail], this=" + hashCode + ", state=" + cVar);
        z();
        aj.a aVar = this.eventListener;
        if (aVar != null) {
            aVar.onLoad(false);
        }
    }

    private final void I() {
        int hashCode = hashCode();
        c cVar = this.loadState;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[notifyLoadSuccess], this=" + hashCode + ", state=" + cVar);
        z();
        aj.a aVar = this.eventListener;
        if (aVar != null) {
            aVar.onLoad(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(c state, Drawable drawable) {
        b loadParam = state.getLoadParam();
        c cVar = this.loadState;
        ImageView imageView = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        if (cVar != state) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onFetchPreview] load state changed, this=" + hashCode() + " param=" + loadParam);
            return;
        }
        if (state.getPreviewImage() != null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onFetchPreview] preview already exists, this=" + hashCode() + " param=" + loadParam);
            E(state);
        } else if (drawable == null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onFetchPreview] fail, this=" + hashCode() + " param=" + loadParam);
            state.n(ImageState.Fail);
            ImageView imageView2 = this.previewImage;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewImage");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
        } else {
            state.m(drawable);
            E(state);
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(c state, String dressKey) {
        String str;
        boolean z16;
        c cVar = this.loadState;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        if (cVar != state) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetDressKey] state changed, ignore, this=" + hashCode() + ", param=" + state.getLoadParam());
            return;
        }
        state.i(dressKey);
        b loadParam = state.getLoadParam();
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetDressKey] this=" + hashCode() + ", param=" + loadParam + ", dressKey=" + dressKey);
        if (dressKey != null) {
            str = this.api.isAvatarFirstFramePngReady(loadParam.getUin(), loadParam.getOnlineStatus(), dressKey, loadParam.getOnlineStatusSubIndex());
        } else {
            str = null;
        }
        d perfData = state.getPerfData();
        if (str == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        perfData.h(z16);
        if (str == null) {
            P();
        } else {
            z();
            c cVar3 = this.loadState;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar3 = null;
            }
            cVar3.m(new BitmapDrawable(getContext().getResources(), BitmapFactory.decodeFile(str)));
        }
        if (this.showStrategy.getShowPreview() && state.getDressKey() != null) {
            if (str != null) {
                QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetDressKey] preview from local, this=" + hashCode());
                c cVar4 = this.loadState;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadState");
                    cVar4 = null;
                }
                E(cVar4);
            } else {
                c cVar5 = this.loadState;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadState");
                    cVar5 = null;
                }
                w(cVar5);
            }
        } else {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetDressKey] preview is disabled, this=" + hashCode());
            c cVar6 = this.loadState;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar6 = null;
            }
            cVar6.n(ImageState.Fail);
        }
        if (this.showStrategy.getShowFilament() && this.api.isDeviceSupportFilament()) {
            c cVar7 = this.loadState;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
            } else {
                cVar2 = cVar7;
            }
            x(cVar2);
        } else {
            c cVar8 = this.loadState;
            if (cVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
            } else {
                cVar2 = cVar8;
            }
            cVar2.l(ImageState.Fail);
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetDressKey] filament is disabled, this=" + hashCode() + " ");
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(c state, com.tencent.mobileqq.onlinestatus.model.b res) {
        b loadParam = state.getLoadParam();
        c cVar = this.loadState;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        if (cVar != state) {
            int hashCode = hashCode();
            c cVar3 = this.loadState;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
            } else {
                cVar2 = cVar3;
            }
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[handleFilament] state changed, this=" + hashCode + " state=" + state + "->" + cVar2);
            return;
        }
        if (res == null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[handleFilament] failed to get resources, this=" + hashCode() + " param=" + loadParam);
            state.l(ImageState.Fail);
            E(state);
            u();
            return;
        }
        state.l(ImageState.Ready);
        state.k(res);
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[handleFilament] resource is ready, do load, this=" + hashCode() + " res=" + res);
        D(state, state.getLoadParam().getOption().getForceReload());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(final AvatarStatusPreviewCache.Key cacheKey, final Bitmap bitmap, final boolean noUpdatePreview, final Function0<Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.g
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusView.N(AvatarStatusPreviewCache.Key.this, noUpdatePreview, this, bitmap, callback);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AvatarStatusPreviewCache.Key cacheKey, boolean z16, AvatarStatusView this$0, Bitmap bitmap, Function0 callback) {
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        AvatarStatusPreviewCache.Companion companion = AvatarStatusPreviewCache.INSTANCE;
        String i3 = companion.a().i(cacheKey);
        if (i3 != null && new File(i3).exists() && z16) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetFirstFrame] no update preview, this=" + this$0.hashCode() + " key=" + cacheKey);
            return;
        }
        companion.a().k(cacheKey, bitmap);
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[onGetFirstFrame] update cache, this=" + this$0.hashCode() + " key=" + cacheKey.c());
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.filamentView;
        if (avatarStatusFilamentViewContainer != null) {
            ImageView imageView = this.previewImage;
            c cVar = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewImage");
                imageView = null;
            }
            if (imageView.getVisibility() == 0) {
                c cVar2 = this.loadState;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadState");
                } else {
                    cVar = cVar2;
                }
                if (cVar.getPreviewState() == ImageState.Loaded) {
                    avatarStatusFilamentViewContainer.setAlpha(1.0f);
                    return;
                }
            }
            ObjectAnimator.ofFloat(avatarStatusFilamentViewContainer, com.tencent.luggage.wxa.c8.c.f123400v, 0.01f, 1.0f).setDuration(300L).start();
        }
    }

    private final void P() {
        FrameLayout frameLayout = this.loadingView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        c cVar = null;
        if (QLog.isColorLevel()) {
            int hashCode = hashCode();
            c cVar2 = this.loadState;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar2 = null;
            }
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 2, "[checkLoadState] this=" + hashCode + " currentState=" + cVar2);
        }
        c cVar3 = this.loadState;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar3 = null;
        }
        ImageState filamentState = cVar3.getFilamentState();
        ImageState imageState = ImageState.Loaded;
        if (filamentState == imageState) {
            I();
            return;
        }
        c cVar4 = this.loadState;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar4 = null;
        }
        ImageState filamentState2 = cVar4.getFilamentState();
        ImageState imageState2 = ImageState.Fail;
        if (filamentState2 == imageState2) {
            c cVar5 = this.loadState;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar5 = null;
            }
            if (cVar5.getPreviewState() == imageState) {
                I();
                return;
            }
            c cVar6 = this.loadState;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar6 = null;
            }
            if (cVar6.getPreviewState() == imageState2) {
                H();
                return;
            }
            int hashCode2 = hashCode();
            c cVar7 = this.loadState;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
            } else {
                cVar = cVar7;
            }
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[checkLoadState] filament fail, wait preview, this=" + hashCode2 + " previewState=" + cVar.getPreviewState());
            return;
        }
        int hashCode3 = hashCode();
        c cVar8 = this.loadState;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
        } else {
            cVar = cVar8;
        }
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[checkLoadState] wait filament, this=" + hashCode3 + " filamentState=" + cVar.getFilamentState());
    }

    private final void v(final c state) {
        final WeakReference weakReference = new WeakReference(this);
        this.api.getDressKey(state.getLoadParam().getUin(), new Function1<String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView$fetchDressKey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                AvatarStatusView avatarStatusView = weakReference.get();
                if (avatarStatusView != null) {
                    avatarStatusView.K(state, str);
                }
            }
        });
    }

    private final void w(c state) {
        b loadParam = state.getLoadParam();
        if (QLog.isColorLevel()) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 2, "[fetchAndLoadPreview] start to fetch preview, param=" + loadParam);
        }
        state.n(ImageState.Prepare);
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = this.api.getFilamentActionKey(state.getLoadParam().getOnlineStatus(), loadParam.getOnlineStatusSubIndex());
        if (filamentActionKey != null && state.getDressKey() != null) {
            final WeakReference weakReference = new WeakReference(this);
            final WeakReference weakReference2 = new WeakReference(state);
            IAvatarStatusViewApi iAvatarStatusViewApi = this.api;
            String uin = state.getLoadParam().getUin();
            int onlineStatus = state.getLoadParam().getOnlineStatus();
            String dressKey = state.getDressKey();
            Intrinsics.checkNotNull(dressKey);
            iAvatarStatusViewApi.getPreviewImage(uin, onlineStatus, filamentActionKey, dressKey, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView$fetchPreview$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    AvatarStatusView avatarStatusView;
                    AvatarStatusView.c cVar = weakReference2.get();
                    if (cVar == null || (avatarStatusView = weakReference.get()) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(avatarStatusView, "get()");
                    avatarStatusView.J(cVar, drawable);
                }
            });
            return;
        }
        QLog.w("OnlineStatusAvatar.AvatarStatusView", 1, "[fetchAndLoadPreview] action key is null, param=" + loadParam);
        state.n(ImageState.Fail);
        u();
    }

    private final void x(final c state) {
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[handleFilament] bind filament view and fetch resources, this=" + hashCode() + " param=" + state.getLoadParam());
        if (this.filamentView == null) {
            com.tencent.mobileqq.onlinestatus.view.zplan.d dVar = com.tencent.mobileqq.onlinestatus.view.zplan.d.f256832a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AvatarStatusFilamentViewContainer a16 = dVar.a(context);
            this.filamentView = a16;
            addView(a16, -1, -1);
        }
        AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.filamentView;
        Intrinsics.checkNotNull(avatarStatusFilamentViewContainer);
        avatarStatusFilamentViewContainer.setVisibility(0);
        avatarStatusFilamentViewContainer.setAlpha(0.001f);
        state.l(ImageState.Prepare);
        final WeakReference weakReference = new WeakReference(this);
        state.getPerfData().g(System.currentTimeMillis());
        this.api.getFilamentActionResource(state.getLoadParam().getOnlineStatus(), state.getLoadParam().getOnlineStatusSubIndex(), new Function1<com.tencent.mobileqq.onlinestatus.model.b, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView$handleFilament$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.onlinestatus.model.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.onlinestatus.model.b bVar) {
                AvatarStatusView.c.this.getPerfData().f(System.currentTimeMillis());
                AvatarStatusView avatarStatusView = weakReference.get();
                if (avatarStatusView != null) {
                    avatarStatusView.L(AvatarStatusView.c.this, bVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(c currentLoadState) {
        if (!this.showStrategy.getShowPreview()) {
            return;
        }
        int i3 = f.f256810a[currentLoadState.getPreviewState().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                w(currentLoadState);
                return;
            }
            ImageView imageView = this.previewImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewImage");
                imageView = null;
            }
            imageView.setVisibility(0);
            return;
        }
        E(currentLoadState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        FrameLayout frameLayout = this.loadingView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    public boolean a() {
        if (!this.showStrategy.getShowPreview()) {
            return false;
        }
        c cVar = this.loadState;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        if (cVar.getPreviewState() != ImageState.Ready) {
            c cVar3 = this.loadState;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
            } else {
                cVar2 = cVar3;
            }
            if (cVar2.getPreviewState() != ImageState.Loaded) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    public boolean b(@NotNull String uin, int onlineStatusId, int onlineStatusSubIndex, @NotNull aj.LoadOption option) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(option, "option");
        b bVar = new b(uin, onlineStatusId, onlineStatusSubIndex, option);
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[load] param=" + bVar + " strategy=" + this.showStrategy + " loadingView=" + option.getLoadingView());
        if (this.loadState != null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[load] reuse, uin=" + uin + " status=" + onlineStatusId);
            c cVar = this.loadState;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar = null;
            }
            if (Intrinsics.areEqual(cVar.getLoadParam(), bVar) && !bVar.getOption().getForceReload()) {
                QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[load] same param, ignore, uin=" + uin + " status=" + onlineStatusId);
                return false;
            }
            ImageView imageView = this.previewImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewImage");
                imageView = null;
            }
            imageView.setImageDrawable(null);
            AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.filamentView;
            if (avatarStatusFilamentViewContainer != null) {
                avatarStatusFilamentViewContainer.setVisibility(8);
            }
        }
        A(option.getLoadingView());
        c cVar2 = new c(bVar, null, null, null, null, null, 62, null);
        this.loadState = cVar2;
        cVar2.getPerfData().m(System.currentTimeMillis());
        String cachedDressKey = this.api.getCachedDressKey(uin);
        if (cachedDressKey == null) {
            QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[load] request dress key asynchronously, param=" + bVar);
            P();
            c cVar3 = this.loadState;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar3 = null;
            }
            v(cVar3);
        } else {
            c cVar4 = this.loadState;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar4 = null;
            }
            K(cVar4, cachedDressKey);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    public void c(boolean reload) {
        int hashCode = hashCode();
        c cVar = this.loadState;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[startAnimation] this=" + hashCode + ", loadState=" + cVar);
        c cVar3 = this.loadState;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar3 = null;
        }
        cVar3.j(false);
        c cVar4 = this.loadState;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar4 = null;
        }
        D(cVar4, reload);
        c cVar5 = this.loadState;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar5 = null;
        }
        E(cVar5);
        c cVar6 = this.loadState;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
        } else {
            cVar2 = cVar6;
        }
        if (cVar2.getPreviewState() != ImageState.Loaded) {
            P();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    public void release() {
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[release] this=" + hashCode());
        c cVar = this.loadState;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        this.loadState = new c(cVar.getLoadParam(), null, null, null, null, null, 62, null);
        AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.filamentView;
        if (avatarStatusFilamentViewContainer != null) {
            avatarStatusFilamentViewContainer.setVisibility(8);
            avatarStatusFilamentViewContainer.h();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    public void setEventListener(@Nullable aj.a listener) {
        this.eventListener = listener;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    public void stopAnimation() {
        QLog.i("OnlineStatusAvatar.AvatarStatusView", 1, "[stopAnimation] this=" + hashCode());
        c cVar = this.loadState;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
            cVar = null;
        }
        if (cVar.getFilamentState() == ImageState.Loaded) {
            c cVar3 = this.loadState;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar3 = null;
            }
            cVar3.l(ImageState.Ready);
        }
        AvatarStatusFilamentViewContainer avatarStatusFilamentViewContainer = this.filamentView;
        if (avatarStatusFilamentViewContainer != null) {
            avatarStatusFilamentViewContainer.i();
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100154", true)) {
            c cVar4 = this.loadState;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadState");
                cVar4 = null;
            }
            cVar4.j(true);
        }
        c cVar5 = this.loadState;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadState");
        } else {
            cVar2 = cVar5;
        }
        y(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010%\u001a\u00020\u0015\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u0016\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00102\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010.\u001a\u0004\b\u000f\u0010/\"\u0004\b0\u00101R\u0017\u00106\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\b'\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$b;", "a", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$b;", "e", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$b;", "loadParam", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "dressKey", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;", "c", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;", "d", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;", "l", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;)V", "filamentState", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "()Lcom/tencent/mobileqq/onlinestatus/model/b;", "k", "(Lcom/tencent/mobileqq/onlinestatus/model/b;)V", "filamentResource", tl.h.F, DomainData.DOMAIN_NAME, "previewState", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "g", "()Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/graphics/drawable/Drawable;)V", "previewImage", "Z", "()Z", "j", "(Z)V", "filamentPaused", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$d;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$d;", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$d;", "perfData", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$b;Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;Lcom/tencent/mobileqq/onlinestatus/model/b;Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$ImageState;Landroid/graphics/drawable/Drawable;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b loadParam;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String dressKey;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ImageState filamentState;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.onlinestatus.model.b filamentResource;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ImageState previewState;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable previewImage;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean filamentPaused;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d perfData;

        public c(@NotNull b loadParam, @Nullable String str, @NotNull ImageState filamentState, @Nullable com.tencent.mobileqq.onlinestatus.model.b bVar, @NotNull ImageState previewState, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(loadParam, "loadParam");
            Intrinsics.checkNotNullParameter(filamentState, "filamentState");
            Intrinsics.checkNotNullParameter(previewState, "previewState");
            this.loadParam = loadParam;
            this.dressKey = str;
            this.filamentState = filamentState;
            this.filamentResource = bVar;
            this.previewState = previewState;
            this.previewImage = drawable;
            this.perfData = new d();
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getDressKey() {
            return this.dressKey;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFilamentPaused() {
            return this.filamentPaused;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final com.tencent.mobileqq.onlinestatus.model.b getFilamentResource() {
            return this.filamentResource;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final ImageState getFilamentState() {
            return this.filamentState;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final b getLoadParam() {
            return this.loadParam;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.loadParam, cVar.loadParam) && Intrinsics.areEqual(this.dressKey, cVar.dressKey) && this.filamentState == cVar.filamentState && Intrinsics.areEqual(this.filamentResource, cVar.filamentResource) && this.previewState == cVar.previewState && Intrinsics.areEqual(this.previewImage, cVar.previewImage)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final d getPerfData() {
            return this.perfData;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final Drawable getPreviewImage() {
            return this.previewImage;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final ImageState getPreviewState() {
            return this.previewState;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3 = this.loadParam.hashCode() * 31;
            String str = this.dressKey;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int hashCode4 = (((hashCode3 + hashCode) * 31) + this.filamentState.hashCode()) * 31;
            com.tencent.mobileqq.onlinestatus.model.b bVar = this.filamentResource;
            if (bVar == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = bVar.hashCode();
            }
            int hashCode5 = (((hashCode4 + hashCode2) * 31) + this.previewState.hashCode()) * 31;
            Drawable drawable = this.previewImage;
            if (drawable != null) {
                i3 = drawable.hashCode();
            }
            return hashCode5 + i3;
        }

        public final void i(@Nullable String str) {
            this.dressKey = str;
        }

        public final void j(boolean z16) {
            this.filamentPaused = z16;
        }

        public final void k(@Nullable com.tencent.mobileqq.onlinestatus.model.b bVar) {
            this.filamentResource = bVar;
        }

        public final void l(@NotNull ImageState imageState) {
            Intrinsics.checkNotNullParameter(imageState, "<set-?>");
            this.filamentState = imageState;
        }

        public final void m(@Nullable Drawable drawable) {
            this.previewImage = drawable;
        }

        public final void n(@NotNull ImageState imageState) {
            Intrinsics.checkNotNullParameter(imageState, "<set-?>");
            this.previewState = imageState;
        }

        @NotNull
        public String toString() {
            return "{param:" + this.loadParam + ",filamentState:" + this.filamentState + ",previewState:" + this.previewState + "}";
        }

        public /* synthetic */ c(b bVar, String str, ImageState imageState, com.tencent.mobileqq.onlinestatus.model.b bVar2, ImageState imageState2, Drawable drawable, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(bVar, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? ImageState.Init : imageState, (i3 & 8) != 0 ? null : bVar2, (i3 & 16) != 0 ? ImageState.Init : imageState2, (i3 & 32) == 0 ? drawable : null);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj
    @NotNull
    public View getView() {
        return this;
    }
}
