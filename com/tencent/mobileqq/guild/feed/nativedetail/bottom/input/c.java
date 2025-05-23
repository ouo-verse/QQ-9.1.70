package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.PicButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SendButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\t*\u0002RU\u0018\u0000 [2\u00020\u0001:\u0001\\B1\u0012\u0006\u0010-\u001a\u00020*\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c;", "Lcom/tencent/biz/richframework/part/Part;", "", "I9", "", "initData", "", "args", "H9", "G9", "", "bottomInteractiveViewHeight", "K9", "Landroid/os/Bundle;", "extra", "D9", "E9", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "C9", "Landroid/content/Context;", "context", "Landroid/net/NetworkInfo;", "F9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "handleBroadcastMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "d", "Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "draftMgr", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "e", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/a;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/a;", "albumOpenDelegate", tl.h.F, "Z", "isSendingInterceptedWhenNetworkUnavailable", "i", "Ljava/lang/String;", "feedId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "guildId", BdhLogUtil.LogTag.Tag_Conn, "channelId", "D", "I", "businessType", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", "E", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", "inputDirector", "Landroid/graphics/Canvas;", UserInfo.SEX_FEMALE, "Landroid/graphics/Canvas;", "canvasForCapture", "G", "Landroid/graphics/Bitmap;", "cacheBitmap", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "H", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputParam", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c$d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c$d;", "sendCallback", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c$c", "J", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c$c;", "dismissCallback", "<init>", "(Lcom/tencent/mobileqq/guild/feed/widget/comment/e;Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/a;Z)V", "K", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private String channelId;

    /* renamed from: D, reason: from kotlin metadata */
    private int businessType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private NativeDetailInputWindowDirector inputDirector;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Canvas canvasForCapture;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Bitmap cacheBitmap;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ShowInputComponentArgs inputParam;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private d sendCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final C7748c dismissCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.widget.comment.e draftMgr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IDynamicParams dynamicParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a albumOpenDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isSendingInterceptedWhenNetworkUnavailable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220533a;

        static {
            int[] iArr = new int[SpeakPermissionType.values().length];
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f220533a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7748c implements NativeDetailInputWindowDirector.d {
        C7748c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.d
        public void a(@NotNull NativeDetailInputWindowDirector.InputBarDismissCause cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            QLog.i("InputComponentPart", 1, "OnDismissListener cause=" + cause);
            c.this.broadcastMessage("message_dismiss_input_dialog", cause);
            c cVar = c.this;
            cVar.broadcastMessage("message_update_hint_when_dismiss", Boolean.valueOf(cVar.I9()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JI\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/c$d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "", "content", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "originalPic", "", "b", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "Landroid/content/Intent;", "intent", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d() {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f144630pa, 0).show();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b
        public boolean a(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            QLog.i("InputComponentPart", 1, "onOpenAlbumActivity");
            if (c.this.albumOpenDelegate != null) {
                c.this.albumOpenDelegate.l4(intent);
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        
            if (r0 == false) goto L16;
         */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(@Nullable String content, @Nullable ShowInputComponentArgs inputArgs, @Nullable ArrayList<LocalMediaInfo> localMediaInfos, @Nullable Boolean originalPic) {
            boolean z16;
            boolean z17 = false;
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (localMediaInfos == null || localMediaInfos.isEmpty()) {
                    z17 = true;
                }
            }
            if (inputArgs != null) {
                if (c.this.isSendingInterceptedWhenNetworkUnavailable) {
                    c cVar = c.this;
                    Context context = cVar.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    if (!cVar.J9(context)) {
                        QLog.e("InputComponentPart", 1, "sendCallback network error!");
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.d.d();
                            }
                        });
                        return;
                    }
                }
                c.this.broadcastMessage("message_try_to_send_input_content", new a.TryToSendInputContentMessage(true, inputArgs, content, null, localMediaInfos, originalPic, 8, null));
                NativeDetailInputWindowDirector nativeDetailInputWindowDirector = c.this.inputDirector;
                if (nativeDetailInputWindowDirector != null) {
                    nativeDetailInputWindowDirector.l();
                    return;
                }
                return;
            }
            QLog.e("InputComponentPart", 1, "sendCallback invoke args error!");
        }
    }

    public /* synthetic */ c(com.tencent.mobileqq.guild.feed.widget.comment.e eVar, IDynamicParams iDynamicParams, a aVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, (i3 & 2) != 0 ? null : iDynamicParams, (i3 & 4) != 0 ? null : aVar, (i3 & 8) != 0 ? false : z16);
    }

    private final Bitmap C9(View view) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.cacheBitmap == null) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                this.cacheBitmap = createBitmap;
                this.canvasForCapture.setBitmap(createBitmap);
            }
            view.draw(this.canvasForCapture);
            m476constructorimpl = Result.m476constructorimpl(this.cacheBitmap);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (Bitmap) m476constructorimpl;
    }

    private final void D9(Bundle extra) {
        String str = this.guildId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        extra.putString("guild_id", str);
        String str3 = this.channelId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
            str3 = null;
        }
        extra.putString("channel_id", str3);
        String str4 = this.feedId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedId");
            str4 = null;
        }
        extra.putString("feed_id", str4);
        extra.putInt("business_type", this.businessType);
        extra.putBoolean("guild_feed_support_at_entrance", n.w(this));
        Intent a16 = com.tencent.mobileqq.guild.feed.part.a.a(this);
        if (a16 != null) {
            str2 = a16.getStringExtra("feed_comment_input_bar_hint");
        }
        extra.putString("feed_comment_input_bar_hint", str2);
        E9(extra);
    }

    private final void E9(Bundle extra) {
        if (this.businessType == 7) {
            extra.putString("guild_feed_channel_name", n.m(this));
        }
    }

    private final NetworkInfo F9(Context context) {
        try {
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            return ((ConnectivityManager) systemService).getActiveNetworkInfo();
        } catch (Throwable th5) {
            QLog.e("InputComponentPart", 1, "error " + th5);
            return null;
        }
    }

    private final void G9(Object args) {
        boolean z16 = true;
        if (!(args instanceof a.ShowInputComponentMessage)) {
            QLog.e("InputComponentPart", 1, "handleShowInputComponentMessage args error!");
            return;
        }
        a.ShowInputComponentMessage showInputComponentMessage = (a.ShowInputComponentMessage) args;
        this.inputParam = showInputComponentMessage.getInputArgs();
        boolean u16 = n.u(this);
        String str = this.feedId;
        View view = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedId");
            str = null;
        }
        QLog.i("InputComponentPart", 1, "showInputComponent isMember = " + u16 + " feedId = " + str);
        Object broadcastGetMessage = broadcastGetMessage("message_find_view_by_id", Integer.valueOf(R.id.v1n));
        if (broadcastGetMessage instanceof View) {
            view = (View) broadcastGetMessage;
        }
        if (view == null) {
            view = new View(getContext());
        }
        K9(view.getHeight());
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        Intrinsics.checkNotNull(nativeDetailInputWindowDirector);
        nativeDetailInputWindowDirector.x(new ColorDrawable(getContext().getResources().getColor(R.color.qui_common_fill_allblack_medium)));
        nativeDetailInputWindowDirector.t(view.getHeight());
        nativeDetailInputWindowDirector.s(u16);
        nativeDetailInputWindowDirector.w(C9(view));
        nativeDetailInputWindowDirector.u(showInputComponentMessage.getInputArgs());
        if (!u16 || !n.w(this)) {
            z16 = false;
        }
        nativeDetailInputWindowDirector.v(z16);
    }

    private final void H9(Object args) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector;
        if (!(args instanceof a.OnSpeakPermissionChangedMessage)) {
            QLog.e("InputComponentPart", 1, "handleSpeakPermissionChangedMessage args error!");
            return;
        }
        int i3 = b.f220533a[((a.OnSpeakPermissionChangedMessage) args).getNewSpeakPermission().ordinal()];
        if ((i3 == 1 || i3 == 2) && (nativeDetailInputWindowDirector = this.inputDirector) != null) {
            nativeDetailInputWindowDirector.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I9() {
        com.tencent.mobileqq.guild.feed.widget.comment.e eVar = this.draftMgr;
        LocalMediaInfo localMediaInfo = null;
        String str = null;
        if (eVar != null) {
            String str2 = this.feedId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedId");
            } else {
                str = str2;
            }
            localMediaInfo = eVar.a(str);
        }
        if (localMediaInfo != null) {
            return true;
        }
        return false;
    }

    private final void K9(int bottomInteractiveViewHeight) {
        if (this.inputDirector == null) {
            NativeDetailInputWindowDirector nativeDetailInputWindowDirector = new NativeDetailInputWindowDirector();
            D9(nativeDetailInputWindowDirector.f());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            nativeDetailInputWindowDirector.i(context);
            nativeDetailInputWindowDirector.t(bottomInteractiveViewHeight);
            Object b16 = nativeDetailInputWindowDirector.getRouter().b(SendButtonActor.class);
            Intrinsics.checkNotNull(b16);
            ((SendButtonActor) b16).l(this.sendCallback);
            Object b17 = nativeDetailInputWindowDirector.getRouter().b(PicButtonActor.class);
            Intrinsics.checkNotNull(b17);
            ((PicButtonActor) b17).l(this.sendCallback);
            Object b18 = nativeDetailInputWindowDirector.getRouter().b(com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d.class);
            Intrinsics.checkNotNull(b18);
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d) b18).l(this.draftMgr);
            nativeDetailInputWindowDirector.m(this.dismissCallback);
            gl1.b reporter = nativeDetailInputWindowDirector.getReporter();
            if (reporter != null) {
                reporter.b(this.dynamicParams);
            }
            this.inputDirector = nativeDetailInputWindowDirector;
        }
    }

    private final void initData() {
        this.feedId = n.o(this);
        this.guildId = n.r(this);
        this.channelId = n.l(this);
        this.businessType = n.k(this);
        String str = this.feedId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedId");
            str = null;
        }
        String str3 = this.guildId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str3 = null;
        }
        String str4 = this.channelId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        } else {
            str2 = str4;
        }
        QLog.i("InputComponentPart", 1, "initData feedId=" + str + " guildId=" + str3 + " channelId=" + str2 + " businessType=" + this.businessType);
    }

    public final boolean J9(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NetworkInfo F9 = F9(context);
        if (F9 != null && F9.isConnected()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector;
        if (action != null) {
            switch (action.hashCode()) {
                case -1357264245:
                    if (action.equals("message_close_input")) {
                        QLog.i("InputComponentPart", 1, "close input, caller: " + args);
                        NativeDetailInputWindowDirector nativeDetailInputWindowDirector2 = this.inputDirector;
                        if (nativeDetailInputWindowDirector2 != null) {
                            nativeDetailInputWindowDirector2.r();
                            return;
                        }
                        return;
                    }
                    return;
                case 69131257:
                    if (action.equals("message_on_speak_permission_changed")) {
                        H9(args);
                        return;
                    }
                    return;
                case 1179209504:
                    if (action.equals("message_clear_input") && (nativeDetailInputWindowDirector = this.inputDirector) != null) {
                        nativeDetailInputWindowDirector.q();
                        return;
                    }
                    return;
                case 1670269089:
                    if (action.equals("message_check_input_speak_permission_succ")) {
                        G9(args);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        if (nativeDetailInputWindowDirector != null) {
            nativeDetailInputWindowDirector.j(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        this.cacheBitmap = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        if (nativeDetailInputWindowDirector != null) {
            nativeDetailInputWindowDirector.k();
        }
    }

    public c(@NotNull com.tencent.mobileqq.guild.feed.widget.comment.e draftMgr, @Nullable IDynamicParams iDynamicParams, @Nullable a aVar, boolean z16) {
        Intrinsics.checkNotNullParameter(draftMgr, "draftMgr");
        this.draftMgr = draftMgr;
        this.dynamicParams = iDynamicParams;
        this.albumOpenDelegate = aVar;
        this.isSendingInterceptedWhenNetworkUnavailable = z16;
        this.canvasForCapture = new Canvas();
        this.sendCallback = new d();
        this.dismissCallback = new C7748c();
    }
}
