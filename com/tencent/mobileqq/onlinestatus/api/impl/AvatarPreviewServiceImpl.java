package com.tencent.mobileqq.onlinestatus.api.impl;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache;
import com.tencent.mobileqq.onlinestatus.avatar.GetUrlResult;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAvatarPreviewHandler;
import com.tencent.mobileqq.onlinestatus.networkhandler.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.weiyun.transmission.db.JobDbManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J5\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u000fH\u0016JP\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001626\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0018H\u0016J;\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J;\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u000fH\u0016JS\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00022!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010!\u001a\u00020\u0016H\u0016J9\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u000fJ;\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J\b\u0010%\u001a\u00020\u0004H\u0016JR\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r28\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00040\u0018H\u0016R\u0016\u0010\n\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarPreviewServiceImpl;", "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarPreviewService;", "", "key", "", "setLastKey", "checkAndClearLastKey", "", "isLastKey", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "uin", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/onlinestatus/avatar/a;", "Lkotlin/ParameterName;", "name", "result", "callback", "getUrl", "", "onlineStatusId", "Lkotlin/Function2;", "success", "exist", "isUrlExist", "addUrl", "keepUrl", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "dressKey", "subIndex", "uploadPreview", "imagePath", JobDbManager.TBL_UPLOAD, "clearPreviewDir", "type", ZPlanPublishSource.FROM_SCHEME, "getStatusJumpScheme", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/OnlineStatusAvatarPreviewHandler;", "handler", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/OnlineStatusAvatarPreviewHandler;", "lastKey", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarPreviewServiceImpl implements IAvatarPreviewService {

    @NotNull
    private static final String TAG = "OnlineStatusAvatar.PreviewService";
    private BaseQQAppInterface appRuntime;

    @NotNull
    private final OnlineStatusAvatarPreviewHandler handler = new OnlineStatusAvatarPreviewHandler();

    @Nullable
    private volatile String lastKey;

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void checkAndClearLastKey(String key) {
        if (isLastKey(key)) {
            this.lastKey = null;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "clearLastKey: " + key);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean isLastKey(String key) {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(key, this.lastKey, true);
        return equals;
    }

    private final synchronized void setLastKey(String key) {
        this.lastKey = key;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setLastKey: " + key);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void addUrl(@NotNull String uin, int onlineStatusId, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getFilamentActionKey(onlineStatusId, -1);
        if (filamentActionKey == null) {
            QLog.i(TAG, 1, "[addUrl] actionKey is null");
            callback.invoke(Boolean.FALSE);
            return;
        }
        AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, onlineStatusId, filamentActionKey.getActionKey(), ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey);
        String i3 = AvatarStatusPreviewCache.INSTANCE.a().i(key);
        if (TextUtils.isEmpty(i3)) {
            QLog.i(TAG, 1, "[addUrl] path is null, key=" + key);
            callback.invoke(Boolean.FALSE);
            return;
        }
        com.tencent.mobileqq.onlinestatus.networkhandler.d dVar = com.tencent.mobileqq.onlinestatus.networkhandler.d.f256083a;
        Intrinsics.checkNotNull(i3);
        d.a a16 = dVar.a(i3);
        if (a16 == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler = this.handler;
        BaseQQAppInterface baseQQAppInterface = this.appRuntime;
        if (baseQQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            baseQQAppInterface = null;
        }
        String c16 = key.c();
        String bytes2HexStr = HexUtil.bytes2HexStr(a16.getMd5());
        Intrinsics.checkNotNullExpressionValue(bytes2HexStr, "bytes2HexStr(fileInfo.md5)");
        String bytes2HexStr2 = HexUtil.bytes2HexStr(a16.getSha1());
        Intrinsics.checkNotNullExpressionValue(bytes2HexStr2, "bytes2HexStr(fileInfo.sha1)");
        onlineStatusAvatarPreviewHandler.d(baseQQAppInterface, c16, bytes2HexStr, bytes2HexStr2, a16.getFileSize(), a16.getCom.tencent.ams.dsdk.monitor.metric.event.TagName.FILE_TYPE java.lang.String(), callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void clearPreviewDir() {
        FileUtils.delete(AvatarStatusPreviewCache.INSTANCE.a().h(), false);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void getStatusJumpScheme(long uin, long type, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uin == 0) {
            QLog.i(TAG, 1, "[getStatusJumpScheme] uin invalid");
            return;
        }
        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler = this.handler;
        BaseQQAppInterface baseQQAppInterface = this.appRuntime;
        if (baseQQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            baseQQAppInterface = null;
        }
        onlineStatusAvatarPreviewHandler.h(baseQQAppInterface, uin, type, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void getUrl(long uin, @NotNull Function1<? super GetUrlResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler = this.handler;
        BaseQQAppInterface baseQQAppInterface = this.appRuntime;
        if (baseQQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            baseQQAppInterface = null;
        }
        onlineStatusAvatarPreviewHandler.i(baseQQAppInterface, uin, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void isUrlExist(@NotNull String uin, int onlineStatusId, @NotNull Function2<? super Boolean, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getFilamentActionKey(onlineStatusId, -1);
        if (filamentActionKey == null) {
            QLog.i(TAG, 1, "[addUrl] actionKey is null");
            Boolean bool = Boolean.FALSE;
            callback.invoke(bool, bool);
            return;
        }
        AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, onlineStatusId, filamentActionKey.getActionKey(), ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey);
        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler = this.handler;
        BaseQQAppInterface baseQQAppInterface = this.appRuntime;
        if (baseQQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            baseQQAppInterface = null;
        }
        onlineStatusAvatarPreviewHandler.k(baseQQAppInterface, Long.parseLong(uin), key.c(), callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void keepUrl(@NotNull String uin, int onlineStatusId, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getFilamentActionKey(onlineStatusId, -1);
        if (filamentActionKey == null) {
            QLog.i(TAG, 1, "[keepUrl] actionKey is null");
            callback.invoke(Boolean.FALSE);
            return;
        }
        AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, onlineStatusId, filamentActionKey.getActionKey(), ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey);
        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler = this.handler;
        BaseQQAppInterface baseQQAppInterface = this.appRuntime;
        if (baseQQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            baseQQAppInterface = null;
        }
        onlineStatusAvatarPreviewHandler.l(baseQQAppInterface, key.c(), callback);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.appRuntime = (BaseQQAppInterface) appRuntime;
    }

    public final void upload(@NotNull String uin, @NotNull String imagePath, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new com.tencent.mobileqq.onlinestatus.networkhandler.b().g(uin, imagePath, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void uploadPreview(@NotNull final BaseQQAppInterface app, @NotNull String uin, int onlineStatusId, @NotNull String dressKey, @NotNull Function1<? super Boolean, Unit> callback, int subIndex) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!be.e()) {
            QLog.i(TAG, 1, "[uploadPreview]: switch close");
            callback.invoke(Boolean.FALSE);
            return;
        }
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getFilamentActionKey(onlineStatusId, subIndex);
        if (filamentActionKey == null) {
            QLog.i(TAG, 1, "[uploadPreview] actionKey is null");
            return;
        }
        final AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, onlineStatusId, filamentActionKey.getActionKey(), dressKey);
        final String i3 = AvatarStatusPreviewCache.INSTANCE.a().i(key);
        if (TextUtils.isEmpty(i3)) {
            QLog.i(TAG, 1, "[uploadPreview] path is null, key=" + key);
            callback.invoke(Boolean.FALSE);
            return;
        }
        setLastKey(key.c());
        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler = this.handler;
        String currentUin = app.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        onlineStatusAvatarPreviewHandler.k(app, Long.parseLong(currentUin), key.c(), new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarPreviewServiceImpl$uploadPreview$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, boolean z17) {
                boolean isLastKey;
                OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler2;
                if (!z16) {
                    QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] failed to check url exist, key=" + AvatarStatusPreviewCache.Key.this.c());
                    this.checkAndClearLastKey(AvatarStatusPreviewCache.Key.this.c());
                    return;
                }
                if (z17) {
                    isLastKey = this.isLastKey(AvatarStatusPreviewCache.Key.this.c());
                    if (isLastKey) {
                        onlineStatusAvatarPreviewHandler2 = this.handler;
                        BaseQQAppInterface baseQQAppInterface = app;
                        String c16 = AvatarStatusPreviewCache.Key.this.c();
                        final AvatarStatusPreviewCache.Key key2 = AvatarStatusPreviewCache.Key.this;
                        onlineStatusAvatarPreviewHandler2.l(baseQQAppInterface, c16, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarPreviewServiceImpl$uploadPreview$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z18) {
                                QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] keep url, key=" + AvatarStatusPreviewCache.Key.this.c() + ", success=" + z18);
                            }
                        });
                        this.checkAndClearLastKey(AvatarStatusPreviewCache.Key.this.c());
                        return;
                    }
                    QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] keep url, not last, do not set, key=" + AvatarStatusPreviewCache.Key.this.c());
                    return;
                }
                AvatarPreviewServiceImpl avatarPreviewServiceImpl = this;
                String currentAccountUin = app.getCurrentAccountUin();
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
                String str = i3;
                Intrinsics.checkNotNull(str);
                final AvatarStatusPreviewCache.Key key3 = AvatarStatusPreviewCache.Key.this;
                final AvatarPreviewServiceImpl avatarPreviewServiceImpl2 = this;
                final BaseQQAppInterface baseQQAppInterface2 = app;
                final String str2 = i3;
                avatarPreviewServiceImpl.upload(currentAccountUin, str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarPreviewServiceImpl$uploadPreview$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z18) {
                        boolean isLastKey2;
                        OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler3;
                        if (!z18) {
                            QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] failed to upload, key=" + AvatarStatusPreviewCache.Key.this.c());
                            avatarPreviewServiceImpl2.checkAndClearLastKey(AvatarStatusPreviewCache.Key.this.c());
                            return;
                        }
                        QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] upload file success, key=" + AvatarStatusPreviewCache.Key.this.c());
                        isLastKey2 = avatarPreviewServiceImpl2.isLastKey(AvatarStatusPreviewCache.Key.this.c());
                        if (isLastKey2) {
                            onlineStatusAvatarPreviewHandler3 = avatarPreviewServiceImpl2.handler;
                            BaseQQAppInterface baseQQAppInterface3 = baseQQAppInterface2;
                            String c17 = AvatarStatusPreviewCache.Key.this.c();
                            String str3 = str2;
                            final AvatarStatusPreviewCache.Key key4 = AvatarStatusPreviewCache.Key.this;
                            final AvatarPreviewServiceImpl avatarPreviewServiceImpl3 = avatarPreviewServiceImpl2;
                            final BaseQQAppInterface baseQQAppInterface4 = baseQQAppInterface2;
                            onlineStatusAvatarPreviewHandler3.e(baseQQAppInterface3, c17, str3, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarPreviewServiceImpl.uploadPreview.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z19) {
                                    OnlineStatusAvatarPreviewHandler onlineStatusAvatarPreviewHandler4;
                                    QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] add url, success=" + z19 + ", key=" + AvatarStatusPreviewCache.Key.this.c());
                                    onlineStatusAvatarPreviewHandler4 = avatarPreviewServiceImpl3.handler;
                                    BaseQQAppInterface baseQQAppInterface5 = baseQQAppInterface4;
                                    String c18 = AvatarStatusPreviewCache.Key.this.c();
                                    final AvatarStatusPreviewCache.Key key5 = AvatarStatusPreviewCache.Key.this;
                                    onlineStatusAvatarPreviewHandler4.l(baseQQAppInterface5, c18, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarPreviewServiceImpl.uploadPreview.1.2.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z26) {
                                            QLog.i("OnlineStatusAvatar.PreviewService", 1, "[uploadPreview] keep url, key=" + AvatarStatusPreviewCache.Key.this.c() + ", success=" + z26);
                                        }
                                    });
                                }
                            });
                            avatarPreviewServiceImpl2.checkAndClearLastKey(AvatarStatusPreviewCache.Key.this.c());
                            return;
                        }
                        QLog.i("OnlineStatusAvatar.PreviewService", 1, "not lastUpload, do not create and set, key=" + AvatarStatusPreviewCache.Key.this.c() + " ");
                    }
                });
            }
        });
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IAvatarPreviewService
    public void upload(@NotNull String uin, int onlineStatusId, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.model.a filamentActionKey = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getFilamentActionKey(onlineStatusId, -1);
        if (filamentActionKey == null) {
            QLog.i(TAG, 1, "[uploadPreview] actionKey is null");
            return;
        }
        AvatarStatusPreviewCache.Key key = new AvatarStatusPreviewCache.Key(uin, onlineStatusId, filamentActionKey.getActionKey(), ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey);
        String i3 = AvatarStatusPreviewCache.INSTANCE.a().i(key);
        if (TextUtils.isEmpty(i3)) {
            QLog.i(TAG, 1, "[uploadPreview] path is null, key=" + key);
            callback.invoke(Boolean.FALSE);
            return;
        }
        Intrinsics.checkNotNull(i3);
        upload(uin, i3, callback);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
