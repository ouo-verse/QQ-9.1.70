package com.tencent.mobileqq.guild.profile.impl;

import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.common.upload.UploadEndPoint;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.profile.IGuildProfileRuntimeService;
import com.tencent.mobileqq.guild.profile.impl.GuildProfileRuntimeServiceImpl;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import vh2.cc;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\b\b*\u0001 \u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0017\u001a\u00020\u000bR\u0016\u0010\u0018\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/impl/GuildProfileRuntimeServiceImpl;", "Lcom/tencent/mobileqq/guild/profile/IGuildProfileRuntimeService;", "Llv1/c;", "callback", "", "callbackSuccess", "", "result", "", "errorMsg", "callbackError", "", "isCallbackError", "taskName", "taskStatus", "updateStatus", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, PhotoCategorySummaryInfo.AVATAR_URL, "nickName", "setMyGuildProfile", "isSuccess", "runtime", "Lmqq/app/AppRuntime;", "", "defaultStatus", "Ljava/util/Map;", "taskStatusMap", "setting", "Z", "com/tencent/mobileqq/guild/profile/impl/GuildProfileRuntimeServiceImpl$c", "taskStatusMapUpdateListener", "Lcom/tencent/mobileqq/guild/profile/impl/GuildProfileRuntimeServiceImpl$c;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileRuntimeServiceImpl implements IGuildProfileRuntimeService {
    private static final int DEFAULT_STATUS = 0;
    private static final int DOWNLOAD_TASK = 1;
    private static final int FAILED_STATUS = -1;
    private static final int NICKNAME_TASK = 3;
    private static final int SUCCESS_STATUS = 1;

    @NotNull
    private static final String TAG = "GuildProfileRuntimeServiceImpl";
    private static final int UPLOAD_TASK = 2;

    @NotNull
    private final Map<Integer, Integer> defaultStatus;
    private AppRuntime runtime;
    private boolean setting;

    @NotNull
    private Map<Integer, Integer> taskStatusMap;

    @NotNull
    private final c taskStatusMapUpdateListener;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/profile/impl/GuildProfileRuntimeServiceImpl$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ lv1.c f231102f;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f231103a;

            static {
                int[] iArr = new int[LoadState.values().length];
                try {
                    iArr[LoadState.STATE_CANCEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LoadState.STATE_DOWNLOAD_FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LoadState.STATE_DECODE_FAILED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LoadState.STATE_URL_ILLEGAL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[LoadState.STATE_DOWNLOAD_SUCCESS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[LoadState.STATE_SUCCESS.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f231103a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(lv1.c cVar) {
            super(true);
            this.f231102f = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(final GuildProfileRuntimeServiceImpl this$0, final lv1.c callback, IUploadApi.c cVar, final IUploadApi.d dVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: mv1.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildProfileRuntimeServiceImpl.b.g(IUploadApi.d.this, this$0, callback);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(IUploadApi.d dVar, GuildProfileRuntimeServiceImpl this$0, lv1.c callback) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            int i3 = dVar.f230931a;
            if (i3 != -1) {
                if (i3 == 1) {
                    QLog.d(GuildProfileRuntimeServiceImpl.TAG, 1, "upload Image success " + i3 + ", " + this$0.taskStatusMap);
                    this$0.updateStatus(2, 1);
                    this$0.callbackSuccess(callback);
                    return;
                }
                if (i3 != 2) {
                    return;
                }
            }
            QLog.e(GuildProfileRuntimeServiceImpl.TAG, 1, "upload Image error " + i3 + ", " + this$0.taskStatusMap);
            String r16 = QQGuildUIUtil.r(R.string.f1520519c);
            Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026ile_avatar_update_failed)");
            this$0.callbackError(-2, r16, callback);
            this$0.updateStatus(2, -1);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            switch (a.f231103a[state.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    QLog.e(GuildProfileRuntimeServiceImpl.TAG, 1, "download Image error " + state + ", " + GuildProfileRuntimeServiceImpl.this.taskStatusMap);
                    GuildProfileRuntimeServiceImpl guildProfileRuntimeServiceImpl = GuildProfileRuntimeServiceImpl.this;
                    String r16 = QQGuildUIUtil.r(R.string.f1520519c);
                    Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026ile_avatar_update_failed)");
                    guildProfileRuntimeServiceImpl.callbackError(-1, r16, this.f231102f);
                    GuildProfileRuntimeServiceImpl.this.updateStatus(1, -1);
                    GuildProfileRuntimeServiceImpl.this.updateStatus(2, -1);
                    return;
                case 5:
                case 6:
                    QLog.d(GuildProfileRuntimeServiceImpl.TAG, 1, "download Image success " + state + ", " + GuildProfileRuntimeServiceImpl.this.taskStatusMap);
                    GuildProfileRuntimeServiceImpl.this.updateStatus(1, 1);
                    AppRuntime appRuntime = GuildProfileRuntimeServiceImpl.this.runtime;
                    if (appRuntime == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("runtime");
                        appRuntime = null;
                    }
                    GuildCgiUploader guildCgiUploader = new GuildCgiUploader(appRuntime.getAccount(), "0");
                    String localPath = option.getLocalPath();
                    UploadEndPoint uploadEndPoint = com.tencent.mobileqq.guild.common.upload.c.personalAvatar;
                    HashMap<String, String> a16 = com.tencent.mobileqq.guild.common.upload.b.a();
                    final GuildProfileRuntimeServiceImpl guildProfileRuntimeServiceImpl2 = GuildProfileRuntimeServiceImpl.this;
                    final lv1.c cVar = this.f231102f;
                    guildCgiUploader.f(localPath, uploadEndPoint, a16, new IUploadApi.b() { // from class: mv1.b
                        @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
                        public final void a(IUploadApi.c cVar2, IUploadApi.d dVar) {
                            GuildProfileRuntimeServiceImpl.b.f(GuildProfileRuntimeServiceImpl.this, cVar, cVar2, dVar);
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/profile/impl/GuildProfileRuntimeServiceImpl$c", "", "", "b", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c {
        c() {
        }

        private final boolean b() {
            Iterator it = GuildProfileRuntimeServiceImpl.this.taskStatusMap.entrySet().iterator();
            while (it.hasNext()) {
                if (((Number) ((Map.Entry) it.next()).getValue()).intValue() == 0) {
                    return false;
                }
            }
            return true;
        }

        public void a() {
            QLog.d(GuildProfileRuntimeServiceImpl.TAG, 1, "afterUpdate " + GuildProfileRuntimeServiceImpl.this.taskStatusMap);
            if (b()) {
                GuildProfileRuntimeServiceImpl.this.setting = false;
            }
        }
    }

    public GuildProfileRuntimeServiceImpl() {
        Map<Integer, Integer> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(1, 0), TuplesKt.to(2, 0), TuplesKt.to(3, 0));
        this.defaultStatus = mutableMapOf;
        this.taskStatusMap = new LinkedHashMap();
        this.taskStatusMapUpdateListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackError(int result, String errorMsg, lv1.c callback) {
        if (isCallbackError()) {
            callback.a(result, errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackSuccess(lv1.c callback) {
        if (isSuccess()) {
            callback.a(0, "");
        }
    }

    private final boolean isCallbackError() {
        Iterator<Map.Entry<Integer, Integer>> it = this.taskStatusMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().intValue() == -1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMyGuildProfile$lambda$0(GuildProfileRuntimeServiceImpl this$0, lv1.c callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 != 0) {
            QLog.e(TAG, 1, "setNickName error " + i3 + ", " + str + ", " + this$0.taskStatusMap);
            String r16 = QQGuildUIUtil.r(R.string.f1521919q);
            Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026e_nickname_update_failed)");
            this$0.callbackError(-3, r16, callback);
            this$0.updateStatus(3, -1);
            return;
        }
        QLog.d(TAG, 1, "setNickName success " + i3 + ", " + this$0.taskStatusMap);
        this$0.updateStatus(3, 1);
        this$0.callbackSuccess(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatus(int taskName, int taskStatus) {
        this.taskStatusMap.put(Integer.valueOf(taskName), Integer.valueOf(taskStatus));
        this.taskStatusMapUpdateListener.a();
    }

    public final boolean isSuccess() {
        Iterator<Map.Entry<Integer, Integer>> it = this.taskStatusMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().intValue() != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.runtime = appRuntime;
        this.taskStatusMap.putAll(this.defaultStatus);
    }

    @Override // com.tencent.mobileqq.guild.profile.IGuildProfileRuntimeService
    public void setMyGuildProfile(@NotNull String avatarUrl, @NotNull String nickName, @NotNull final lv1.c callback) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.setting) {
            QLog.w(TAG, 1, "setMyGuildProfile too frequently " + avatarUrl + ", " + nickName + ", " + this.taskStatusMap);
            String r16 = QQGuildUIUtil.r(R.string.f141240g5);
            Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026ge_category_too_frequent)");
            callback.a(-4, r16);
            return;
        }
        if (!TextUtils.isEmpty(avatarUrl) && !TextUtils.isEmpty(nickName)) {
            QLog.d(TAG, 1, "setMyGuildProfile " + avatarUrl + ", " + nickName + ", " + this.taskStatusMap);
            this.taskStatusMap.putAll(this.defaultStatus);
            this.setting = true;
            Option obtain = Option.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            obtain.setUrl(avatarUrl);
            e.a().f(obtain, new b(callback));
            AppRuntime appRuntime = this.runtime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("runtime");
                appRuntime = null;
            }
            ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).setNickName(nickName, new cc() { // from class: mv1.a
                @Override // vh2.cc
                public final void onResult(int i3, String str) {
                    GuildProfileRuntimeServiceImpl.setMyGuildProfile$lambda$0(GuildProfileRuntimeServiceImpl.this, callback, i3, str);
                }
            });
            return;
        }
        QLog.w(TAG, 1, "setMyGuildProfile avatarUrl or nickName is empty " + avatarUrl + ", " + nickName + ", " + this.taskStatusMap);
        String r17 = QQGuildUIUtil.r(R.string.f140560ea);
        Intrinsics.checkNotNullExpressionValue(r17, "getString(R.string.guild_avatar_nickname_invalid)");
        callback.a(-5, r17);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
