package com.tencent.mobileqq.onlinestatus.api.impl;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.avatar.AvatarViewConfig;
import com.tencent.mobileqq.config.avatar.BaseConfigItem;
import com.tencent.mobileqq.config.avatar.ConfigData;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache;
import com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusViewApiImpl;
import com.tencent.mobileqq.onlinestatus.avatar.AvatarPreviewUtil;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.v;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewManager;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusViewLoadStrategy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJM\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0002JM\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016JM\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0016J=\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J5\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J5\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\tH\u0016J]\u0010#\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000e0\u001fH\u0016J5\u0010$\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0016JP\u0010(\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000426\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000e0%2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J+\u0010.\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\u0010\u00101\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J=\u00104\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000102\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0018\u00105\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J*\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u001a\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J0\u00109\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002H\u0016J\u0018\u0010;\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0002H\u0016J#\u0010>\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020\u000eH\u0016\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusViewApiImpl;", "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarStatusViewApi;", "", "uin", "", "onlineStatus", "Lcom/tencent/mobileqq/onlinestatus/model/a;", "actionKey", "dressKey", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "callback", "getFriendPreviewImage", "getSelfPreviewImage", "", "isDeviceSupportFilament", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "scene", "Lcom/tencent/mobileqq/onlinestatus/view/aj;", "createIAvatarStatusView", "getPreviewImage", "onlineStatusId", "subIndex", "getCachedDressKey", "getDressKey", "Lkotlin/Function3;", "suc", "hasCustomDressUp", "fromNet", "checkIsCustomDressUp", "getFallbackPreviewImage", "Lkotlin/Function2;", "imageUrl", "color", "getNormalBackground", "getTofuBackgroundImage", "isTofuBackgroundImageReady", "downloadFallbackPreviewImages", "downloadResource", "success", "downloadAllTofuBg", "preloadConfig", "clearResource", "isSupportAvatarView", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", "getFilamentActionResource", "isActionResourcesReady", "isAvatarFirstFramePngReady", "getFilamentActionKey", "previewPath", "saveSelfPreviewToLocal", "imagePath", "uploadSelfActionPreview", "showPreview", "showFilament", "setAvatarViewShowStrategy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "forceReleaseFilamentView", "<init>", "()V", "Companion", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusViewApiImpl implements IAvatarStatusViewApi {
    private static final int GET_DRESS_KEY_SERVICE_TYPE = 20;

    @NotNull
    private static final String TAG = "OnlineStatusAvatar.AvatarViewImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusViewApiImpl$b", "Lji3/g;", "", "success", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "result", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements ji3.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f255433a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Boolean, Boolean, Unit> f255434b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusViewApiImpl$b$a", "Lji3/g;", "", "success", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "result", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a implements ji3.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function3<Boolean, Boolean, Boolean, Unit> f255435a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function3<? super Boolean, ? super Boolean, ? super Boolean, Unit> function3) {
                this.f255435a = function3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(Function3 callback, boolean z16, ZPlanUserInfo zPlanUserInfo) {
                boolean z17;
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Boolean valueOf = Boolean.valueOf(z16);
                if (zPlanUserInfo != null) {
                    z17 = zPlanUserInfo.hasCustomDressUp();
                } else {
                    z17 = false;
                }
                callback.invoke(valueOf, Boolean.valueOf(z17), Boolean.TRUE);
            }

            @Override // ji3.g
            public void a(final boolean success, @Nullable final ZPlanUserInfo result) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Function3<Boolean, Boolean, Boolean, Unit> function3 = this.f255435a;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        AvatarStatusViewApiImpl.b.a.c(Function3.this, success, result);
                    }
                });
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function3<? super Boolean, ? super Boolean, ? super Boolean, Unit> function3) {
            this.f255433a = str;
            this.f255434b = function3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function3 callback, boolean z16, ZPlanUserInfo zPlanUserInfo) {
            boolean z17;
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Boolean valueOf = Boolean.valueOf(z16);
            if (zPlanUserInfo != null) {
                z17 = zPlanUserInfo.hasCustomDressUp();
            } else {
                z17 = false;
            }
            callback.invoke(valueOf, Boolean.valueOf(z17), Boolean.FALSE);
        }

        @Override // ji3.g
        public void a(final boolean success, @Nullable final ZPlanUserInfo result) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function3<Boolean, Boolean, Boolean, Unit> function3 = this.f255434b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.l
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.b.c(Function3.this, success, result);
                }
            });
            if (!success) {
                ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfoFromNet(this.f255433a, 20, new a(this.f255434b));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusViewApiImpl$c", "Lji3/g;", "", "success", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "result", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements ji3.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f255436a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super String, Unit> function1) {
            this.f255436a = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 callback, Ref.ObjectRef dressKey) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(dressKey, "$dressKey");
            callback.invoke(dressKey.element);
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
        @Override // ji3.g
        public void a(boolean success, @Nullable ZPlanUserInfo result) {
            QLog.i(AvatarStatusViewApiImpl.TAG, 1, "[getDressKey]: onResp success: " + success);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (success && result != null) {
                objectRef.element = result.appearanceKey;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<String, Unit> function1 = this.f255436a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.n
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.c.c(Function1.this, objectRef);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusViewApiImpl$d", "Lcom/tencent/mobileqq/onlinestatus/api/impl/q;", "", "path", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Drawable, Unit> f255437a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Drawable, Unit> function1) {
            this.f255437a = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function1 callback) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            callback.invoke(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function1 callback, BitmapDrawable drawable) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(drawable, "$drawable");
            callback.invoke(drawable);
        }

        @Override // com.tencent.mobileqq.onlinestatus.api.impl.q
        public void a(@Nullable String path) {
            if (TextUtils.isEmpty(path)) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final Function1<Drawable, Unit> function1 = this.f255437a;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        AvatarStatusViewApiImpl.d.d(Function1.this);
                    }
                });
            } else {
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.context.getResources(), BitmapFactory.decodeFile(path));
                MqqHandler uIHandler2 = ThreadManager.getUIHandler();
                final Function1<Drawable, Unit> function12 = this.f255437a;
                uIHandler2.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        AvatarStatusViewApiImpl.d.e(Function1.this, bitmapDrawable);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIsCustomDressUp$lambda$1(String uin, Function3 callback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin, 20, new b(uin, callback), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDressKey$lambda$0(String uin, Function1 callback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QRouteApi api = QRoute.api(IZPlanDataHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanDataHelper::class.java)");
        IZPlanDataHelper.b.a((IZPlanDataHelper) api, uin, 20, new c(callback), false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFallbackPreviewImage$lambda$8(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(BaseApplication.context.getDrawable(R.drawable.f161160n50));
    }

    private final void getFriendPreviewImage(final String uin, final int onlineStatus, final com.tencent.mobileqq.onlinestatus.model.a actionKey, final String dressKey, final Function1<? super Drawable, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusViewApiImpl.getFriendPreviewImage$lambda$4(uin, onlineStatus, actionKey, dressKey, callback);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendPreviewImage$lambda$4(String uin, int i3, com.tencent.mobileqq.onlinestatus.model.a actionKey, String dressKey, final Function1 callback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(actionKey, "$actionKey");
        Intrinsics.checkNotNullParameter(dressKey, "$dressKey");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, i3, actionKey.getActionKey(), dressKey);
        String i16 = AvatarStatusPreviewCache.INSTANCE.a().i(key);
        if (i16 != null && new File(i16).exists()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getPreviewImage: local cache exist");
            }
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.context.getResources(), BitmapFactory.decodeFile(i16));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.getFriendPreviewImage$lambda$4$lambda$2(Function1.this, bitmapDrawable);
                }
            });
            return;
        }
        if (!be.e()) {
            QLog.i(TAG, 1, "getPreviewImage: switch close");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.getFriendPreviewImage$lambda$4$lambda$3(Function1.this);
                }
            });
        } else {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getPreviewImage: try to download from server");
            }
            AvatarPreviewUtil.f255541a.c(key, new d(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendPreviewImage$lambda$4$lambda$2(Function1 callback, BitmapDrawable drawable) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        callback.invoke(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendPreviewImage$lambda$4$lambda$3(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSelfPreviewImage$lambda$7(String uin, int i3, com.tencent.mobileqq.onlinestatus.model.a actionKey, String dressKey, AvatarStatusViewApiImpl this$0, final Function1 callback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(actionKey, "$actionKey");
        Intrinsics.checkNotNullParameter(dressKey, "$dressKey");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        String i16 = AvatarStatusPreviewCache.INSTANCE.a().i(new AvatarStatusPreviewCache.Key(uin, i3, actionKey.getActionKey(), dressKey));
        if (i16 != null && new File(i16).exists()) {
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.context.getResources(), BitmapFactory.decodeFile(i16));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.getSelfPreviewImage$lambda$7$lambda$5(Function1.this, bitmapDrawable);
                }
            });
        } else if (!be.e()) {
            QLog.i(TAG, 1, "getSelfPreviewImage: switch close");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.getSelfPreviewImage$lambda$7$lambda$6(Function1.this);
                }
            });
        } else {
            this$0.getFriendPreviewImage(uin, i3, actionKey, dressKey, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSelfPreviewImage$lambda$7$lambda$5(Function1 callback, BitmapDrawable drawable) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        callback.invoke(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSelfPreviewImage$lambda$7$lambda$6(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadConfig$lambda$9() {
        AvatarViewConfig.INSTANCE.a().j(false);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void checkIsCustomDressUp(@NotNull final String uin, @NotNull final Function3<? super Boolean, ? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanUserInfo userZPlanInfoFromCache = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfoFromCache(uin);
        if (userZPlanInfoFromCache != null) {
            callback.invoke(Boolean.TRUE, Boolean.valueOf(userZPlanInfoFromCache.hasCustomDressUp()), Boolean.FALSE);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusViewApiImpl.checkIsCustomDressUp$lambda$1(uin, callback);
                }
            }, 240, null, false);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void clearResource() {
        try {
            FileUtils.delete(com.tencent.mobileqq.config.avatar.d.f202369a.h(), false);
        } catch (Exception e16) {
            QLog.i(TAG, 1, "clearResource exception: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    @NotNull
    public aj createIAvatarStatusView(@NotNull Context context, @NotNull AvatarStatusViewScene scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        return com.tencent.mobileqq.onlinestatus.view.zplan.h.f256841a.a(context, scene);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void downloadAllTofuBg(@NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.config.avatar.download.g.f202388a.d(callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void downloadResource(int onlineStatusId, int subIndex) {
        com.tencent.mobileqq.config.avatar.d.f202369a.b(onlineStatusId, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void forceReleaseFilamentView() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[forceReleaseFilamentView]");
        }
        AvatarStatusFilamentViewManager.INSTANCE.a().h();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    @Nullable
    public String getCachedDressKey(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZPlanUserInfo userZPlanInfoFromCache = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfoFromCache(uin);
        if (userZPlanInfoFromCache != null) {
            return userZPlanInfoFromCache.appearanceKey;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getDressKey(@NotNull final String uin, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusViewApiImpl.getDressKey$lambda$0(uin, callback);
            }
        });
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getFallbackPreviewImage(int onlineStatusId, @NotNull final Function1<? super Drawable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusViewApiImpl.getFallbackPreviewImage$lambda$8(Function1.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    @Nullable
    public com.tencent.mobileqq.onlinestatus.model.a getFilamentActionKey(int onlineStatusId, int subIndex) {
        return com.tencent.mobileqq.config.avatar.d.f202369a.d(onlineStatusId, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getFilamentActionResource(int onlineStatusId, int subIndex, @NotNull Function1<? super com.tencent.mobileqq.onlinestatus.model.b, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.config.avatar.d.f202369a.e(onlineStatusId, callback, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getNormalBackground(int onlineStatusId, @NotNull Function2<? super String, ? super String, Unit> callback, int subIndex) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AvatarViewConfig.INSTANCE.a().h(onlineStatusId, callback, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getPreviewImage(@NotNull String uin, int onlineStatus, @NotNull com.tencent.mobileqq.onlinestatus.model.a actionKey, @NotNull String dressKey, @NotNull Function1<? super Drawable, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(actionKey, "actionKey");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (Intrinsics.areEqual(peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null, uin)) {
            getSelfPreviewImage(uin, onlineStatus, actionKey, dressKey, callback);
        } else {
            getFriendPreviewImage(uin, onlineStatus, actionKey, dressKey, callback);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getSelfPreviewImage(final int onlineStatusId, @NotNull final Function1<? super Drawable, Unit> callback, int subIndex) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AvatarViewConfig.Companion companion = AvatarViewConfig.INSTANCE;
        final BaseConfigItem g16 = companion.a().g();
        final ConfigData f16 = companion.a().f(onlineStatusId, subIndex);
        if (g16 != null && f16 != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                QLog.i(TAG, 1, "[getPreviewImage] cannot get self uin, onlineStatus=" + onlineStatusId);
                callback.invoke(null);
                return;
            }
            final String str = currentAccountUin;
            getDressKey(currentAccountUin, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusViewApiImpl$getSelfPreviewImage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str2) {
                    if (str2 == null) {
                        QLog.i("OnlineStatusAvatar.AvatarViewImpl", 1, "[getPreviewImage] failed to get dress key, uin=" + str);
                        callback.invoke(null);
                        return;
                    }
                    this.getPreviewImage(str, onlineStatusId, new com.tencent.mobileqq.onlinestatus.model.a(g16.getActionResUrlMd5(), f16.getActionResUrlMd5()), str2, callback);
                }
            });
            return;
        }
        QLog.i(TAG, 1, "[getPreviewImage] config not exist, onlineStatus=" + onlineStatusId);
        callback.invoke(null);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    @NotNull
    public String getTofuBackgroundImage(int onlineStatusId, int subIndex) {
        return com.tencent.mobileqq.config.avatar.download.g.f202388a.i(onlineStatusId, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public boolean isActionResourcesReady(int onlineStatusId, int subIndex) {
        return com.tencent.mobileqq.config.avatar.d.f202369a.i(onlineStatusId, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    @Nullable
    public String isAvatarFirstFramePngReady(@NotNull String uin, int onlineStatusId, @NotNull String dressKey, int subIndex) {
        String i3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = getFilamentActionKey(onlineStatusId, subIndex);
        if (filamentActionKey == null || (i3 = AvatarStatusPreviewCache.INSTANCE.a().i(new AvatarStatusPreviewCache.Key(uin, onlineStatusId, filamentActionKey.getActionKey(), dressKey))) == null || !new File(i3).exists()) {
            return null;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public boolean isDeviceSupportFilament() {
        if (com.tencent.mobileqq.onlinestatus.view.zplan.i.f256842a.a()) {
            return true;
        }
        QLog.i(TAG, 1, "this device does not support filament");
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public boolean isSupportAvatarView(int onlineStatusId) {
        if (com.tencent.mobileqq.config.avatar.d.f202369a.d(onlineStatusId, -1) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public boolean isTofuBackgroundImageReady(int onlineStatusId, int subIndex) {
        return com.tencent.mobileqq.config.avatar.download.g.f202388a.k(onlineStatusId, subIndex);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void preloadConfig() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusViewApiImpl.preloadConfig$lambda$9();
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void saveSelfPreviewToLocal(@NotNull String uin, int onlineStatusId, @NotNull String actionKey, @NotNull String dressKey, @NotNull String previewPath) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(actionKey, "actionKey");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(previewPath, "previewPath");
        AvatarStatusPreviewCache.INSTANCE.a().l(new AvatarStatusPreviewCache.Key(uin, onlineStatusId, actionKey, dressKey), previewPath);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void setAvatarViewShowStrategy(@Nullable Boolean showPreview, @Nullable Boolean showFilament) {
        AvatarStatusViewLoadStrategy a16 = AvatarStatusViewLoadStrategy.INSTANCE.a();
        a16.f(showPreview);
        a16.e(showFilament);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void uploadSelfActionPreview(int onlineStatusId, @NotNull String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v17, types: [T, java.lang.Object, java.lang.String] */
    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void getPreviewImage(@NotNull String uin, @NotNull final Function1<? super Drawable, Unit> callback) {
        AppRuntime.Status z16;
        long e06;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 1, "[getPreviewImage] failed to get runtime, uin=" + uin);
            callback.invoke(null);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = uin;
        if (uin.length() == 0) {
            ?? currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "appRuntime.currentUin");
            objectRef.element = currentUin;
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c A = bs.A((String) objectRef.element, TAG);
        if (A == null) {
            QLog.i(TAG, 1, "[getPreviewImage] failed to get simpleInfo, uin=" + objectRef.element);
            callback.invoke(null);
            return;
        }
        if (Intrinsics.areEqual(objectRef.element, peekAppRuntime.getCurrentUin())) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            z16 = ((IOnlineStatusService) runtimeService).getOnlineStatus();
            e06 = af.C().M(peekAppRuntime);
        } else {
            z16 = bs.z(A);
            e06 = A.e0();
        }
        if (z16 == null) {
            QLog.i(TAG, 1, "[getPreviewImage] failed to get status, uin=" + objectRef.element);
            callback.invoke(null);
            return;
        }
        final v r16 = bs.r(z16, e06);
        final com.tencent.mobileqq.onlinestatus.model.a d16 = com.tencent.mobileqq.config.avatar.d.f202369a.d(r16.f256383a, bs.t(A, r16.f256383a));
        if (d16 == null) {
            QLog.i(TAG, 1, "[getPreviewImage] failed to get action key, uin=" + objectRef.element);
            callback.invoke(null);
            return;
        }
        getDressKey((String) objectRef.element, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusViewApiImpl$getPreviewImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                if (str == null) {
                    QLog.i("OnlineStatusAvatar.AvatarViewImpl", 1, "[getPreviewImage] failed to get dress key, uin=" + ((Object) objectRef.element));
                    callback.invoke(null);
                    return;
                }
                this.getPreviewImage(objectRef.element, r16.f256383a, d16, str, callback);
            }
        });
    }

    private final void getSelfPreviewImage(final String uin, final int onlineStatus, final com.tencent.mobileqq.onlinestatus.model.a actionKey, final String dressKey, final Function1<? super Drawable, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusViewApiImpl.getSelfPreviewImage$lambda$7(uin, onlineStatus, actionKey, dressKey, this, callback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi
    public void downloadFallbackPreviewImages() {
    }
}
