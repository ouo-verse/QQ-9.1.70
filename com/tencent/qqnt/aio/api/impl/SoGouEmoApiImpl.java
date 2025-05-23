package com.tencent.qqnt.aio.api.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.api.ISogouEmojiService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ct;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.ISoGouEmoApi;
import com.tencent.qqnt.aio.sogou.NTSoGouEmoSenderProcessor;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J2\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J<\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0014H\u0016J*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J*\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J8\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0004H\u0016J\u001c\u0010&\u001a\u00020%2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/SoGouEmoApiImpl;", "Lcom/tencent/qqnt/aio/api/ISoGouEmoApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "path", "", "sendIMEExpression", "Landroid/content/Context;", "context", "selfUin", "appId", "getOpenId", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "packId", "exprId", "trySend", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allPackId", "pullMultipleEmojiKey", "action", "Landroid/net/Uri;", "uriPath", "targetName", "sendNewExp", "outputPath", "sampleRate", "bitRate", "voiceType", "changeType", "pcmPath", "startVoiceChange", "Lcom/tencent/qqnt/aio/api/ISoGouEmoApi$a;", "listener", "", "queryStateByPath", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SoGouEmoApiImpl implements ISoGouEmoApi {
    private static final String ADDRESS = "/sogou";
    private static final String TAG = "NTSogou SoGouEmoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/api/impl/SoGouEmoApiImpl$b", "Lcom/tencent/mobileqq/voicechange/IVoiceChangeHelper$a;", "", "path", "", "voiceType", "totalTime", "", "onCompressFinished", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IVoiceChangeHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISoGouEmoApi.a f348904d;

        b(ISoGouEmoApi.a aVar) {
            this.f348904d = aVar;
        }

        @Override // com.tencent.mobileqq.voicechange.IVoiceChangeHelper.a
        public void onCompressFinished(String path, int voiceType, int totalTime) {
            ISoGouEmoApi.a aVar = this.f348904d;
            if (aVar != null) {
                aVar.onCompressFinished(path, voiceType, totalTime);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/api/impl/SoGouEmoApiImpl$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f348906b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f348907c;

        c(com.tencent.aio.api.runtime.a aVar, String str) {
            this.f348906b = aVar;
            this.f348907c = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            SoGouEmoApiImpl.this.sendIMEExpression(this.f348906b, this.f348907c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendNewExp$lambda$0(Context context, Uri uriPath, String str, SoGouEmoApiImpl this$0, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(uriPath, "$uriPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        File externalCacheDir = context.getExternalCacheDir();
        Intrinsics.checkNotNull(externalCacheDir);
        String b16 = ct.b(context, uriPath, externalCacheDir.getPath() + "/sogou", String.valueOf(str));
        QLog.i(TAG, 1, "sendNewExp path: " + b16);
        this$0.sendIMEExpression(aioContext, b16);
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public String getOpenId(Context context, String selfUin, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(appId, "appId");
        String A = com.tencent.open.agent.util.g.A(context, selfUin, appId);
        Intrinsics.checkNotNullExpressionValue(A, "getOpenId(context, selfUin, appId)");
        return A;
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public void pullMultipleEmojiKey(BaseQQAppInterface app, Context context, com.tencent.aio.api.runtime.a aioContext, ArrayList<String> allPackId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        ((ISogouEmojiService) QRoute.api(ISogouEmojiService.class)).createSogouEmojiForNT((Activity) context, app, new NTSoGouEmoSenderProcessor(context, su3.b.a(g16))).pullMultipleEmojiKey(allPackId);
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public boolean queryStateByPath(String path, ISoGouEmoApi.a listener) {
        return ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).queryStateByPath(path, new b(listener));
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public void sendIMEExpression(Context context, com.tencent.aio.api.runtime.a aioContext, String path, String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(action, "action");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        Activity activity = (Activity) context;
        if (!((context.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) && (context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0))) {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.SOGOU_EMOJI, QQPermissionConstants.Business.SCENE.SEND_SOGOU_EMOJI)).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new c(aioContext, path));
        } else {
            sendIMEExpression(aioContext, path);
        }
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public void sendNewExp(final Context context, final com.tencent.aio.api.runtime.a aioContext, final Uri uriPath, final String targetName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(uriPath, "uriPath");
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.ag
            @Override // java.lang.Runnable
            public final void run() {
                SoGouEmoApiImpl.sendNewExp$lambda$0(context, uriPath, targetName, this, aioContext);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public void startVoiceChange(String outputPath, int sampleRate, int bitRate, int voiceType, int changeType, String pcmPath) {
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        Intrinsics.checkNotNullParameter(pcmPath, "pcmPath");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || peekAppRuntime.getApplicationContext() == null) {
            return;
        }
        com.tencent.mobileqq.voicechange.b bVar = new com.tencent.mobileqq.voicechange.b(outputPath, sampleRate, bitRate, voiceType, changeType);
        QLog.i(TAG, 1, "startVoiceChange outputPath: " + outputPath + ", sampleRate: " + sampleRate + ", voiceType: " + voiceType + ", pcmPath: " + pcmPath);
        ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).requestToStart(peekAppRuntime.getApplicationContext(), bVar, null, null, com.tencent.mobileqq.voicechange.d.b(pcmPath));
    }

    @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi
    public void trySend(BaseQQAppInterface app, Context context, com.tencent.aio.api.runtime.a aioContext, int packId, String exprId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        ((ISogouEmojiService) QRoute.api(ISogouEmojiService.class)).createSogouEmojiForNT((Activity) context, app, new NTSoGouEmoSenderProcessor(context, su3.b.a(g16))).trySend(packId, exprId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendIMEExpression(com.tencent.aio.api.runtime.a aioContext, String path) {
        aioContext.e().h(new AIOMsgSendEvent.PicEmotionSendEvent(String.valueOf(path), 1, null, null, null, 16, null));
    }
}
