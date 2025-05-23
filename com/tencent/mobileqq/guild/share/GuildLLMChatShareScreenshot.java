package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot;
import com.tencent.mobileqq.guild.share.views.ShareActionSheetWithScrollPreview;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0003()\u0011B!\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "l", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", tl.h.F, "Landroid/content/Context;", "curActivity", "preView", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "b", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "pageSource", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;", "mPictureOriginParams", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "task", "", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "e", "Ljava/util/List;", "sharePlatforms", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;)V", "f", "Companion", "PictureShareSheet", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLLMChatShareScreenshot {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity mActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSharePageSource pageSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSearchLLMChatPictureGenerator.GeneratorParam mPictureOriginParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b task;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> sharePlatforms;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$Companion;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;", "params", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", "b", "(Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "GENERATE_FAILED", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object b(GuildSearchLLMChatPictureGenerator.GeneratorParam generatorParam, Activity activity, Continuation<? super Bitmap> continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            GuildSearchLLMChatPictureGenerator.f217767a.o(activity, generatorParam, new Function3<Boolean, View, Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot$Companion$assembleImage$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, View view, Bitmap bitmap) {
                    invoke(bool.booleanValue(), view, bitmap);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable View view, @Nullable Bitmap bitmap) {
                    Logger.f235387a.d().a("guild.ai.search.AIChatListPart", 1, "startGenerate finish isAllAsyncResourcesOk:" + z16 + " view:" + view + " bitmap:" + bitmap);
                    if (z16 && bitmap != null) {
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(bitmap));
                        return;
                    }
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Throwable("generate bitmap failed, null bmp?" + (bitmap == null) + " ,ResourcesOk?" + z16))));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$PictureShareSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "", "platformType", "b", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "sheet", "onItemClick", "Landroid/app/Activity;", "c", "()Landroid/app/Activity;", "e", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "f", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "<init>", "(Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot;Landroid/app/Activity;Landroid/graphics/Bitmap;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class PictureShareSheet implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Activity activity;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Bitmap bitmap;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private QQPermission qqPermission;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ GuildLLMChatShareScreenshot f234942h;

        public PictureShareSheet(@NotNull GuildLLMChatShareScreenshot guildLLMChatShareScreenshot, @NotNull Activity activity, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.f234942h = guildLLMChatShareScreenshot;
            this.activity = activity;
            this.bitmap = bitmap;
        }

        private final void a(Activity activity, Bitmap bitmap) {
            Unit unit;
            if (this.qqPermission == null) {
                this.qqPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CHANNEL_CONTENT_SHARE, QQPermissionConstants.Business.SCENE.QQCHANNEL_CONTENT_SHARE_SAVE_ALBUM));
            }
            QQPermission qQPermission = this.qqPermission;
            if (qQPermission != null) {
                ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).saveToAlbum(activity, qQPermission, bitmap, new GuildLLMChatShareScreenshot$PictureShareSheet$doSave$1$1(activity));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.e("ShareScreenshot", 1, "qqpermission is null");
            }
        }

        private final void b(Bitmap bitmap, Activity activity, int platformType) {
            File createCacheFile = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile(bitmap);
            Intent intent = activity.getIntent();
            if (intent != null) {
                intent.putExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, this.f234942h.pageSource.ordinal());
            }
            if (platformType != 0) {
                if (platformType != 1) {
                    if (platformType != 2) {
                        if (platformType != 3) {
                            if (platformType != 4) {
                                if (platformType == 5) {
                                    d();
                                    return;
                                }
                                return;
                            } else {
                                String absolutePath = createCacheFile.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheFile.absolutePath");
                                m02.d.u(activity, absolutePath);
                                return;
                            }
                        }
                        String absolutePath2 = createCacheFile.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "cacheFile.absolutePath");
                        m02.d.r(absolutePath2, bitmap);
                        return;
                    }
                    String absolutePath3 = createCacheFile.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath3, "cacheFile.absolutePath");
                    m02.d.q(absolutePath3, bitmap);
                    return;
                }
                String absolutePath4 = createCacheFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath4, "cacheFile.absolutePath");
                String string = activity.getString(R.string.f142790kb);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ld_content_share_success)");
                m02.d.p(activity, absolutePath4, string);
                return;
            }
            String absolutePath5 = createCacheFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath5, "cacheFile.absolutePath");
            m02.d.n(activity, absolutePath5, false, 4, null);
        }

        private final void d() {
            GuildSearchLLMChatPictureGenerator.GeneratorParam b16 = GuildSearchLLMChatPictureGenerator.GeneratorParam.b(this.f234942h.mPictureOriginParams, null, null, null, true, null, null, 0L, null, 247, null);
            GuildSearchLLMChatPictureGenerator guildSearchLLMChatPictureGenerator = GuildSearchLLMChatPictureGenerator.f217767a;
            Activity activity = this.activity;
            final GuildLLMChatShareScreenshot guildLLMChatShareScreenshot = this.f234942h;
            guildSearchLLMChatPictureGenerator.o(activity, b16, new Function3<Boolean, View, Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot$PictureShareSheet$sharePictureToXHS$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, View view, Bitmap bitmap) {
                    invoke(bool.booleanValue(), view, bitmap);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable View view, @Nullable Bitmap bitmap) {
                    if (z16 && bitmap != null) {
                        m02.d.f415923a.s(GuildLLMChatShareScreenshot.PictureShareSheet.this.getActivity(), ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile(bitmap).getAbsolutePath(), guildLLMChatShareScreenshot.mPictureOriginParams.getShareTitle(), "");
                        return;
                    }
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "sharePictureToXHS startGenerate error " + z16 + " " + bitmap;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().b("ShareScreenshot", 1, (String) it.next(), null);
                    }
                }
            });
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet sheet) {
            if (sheet != null && item != null) {
                sheet.dismiss();
                QLog.d("ShareScreenshot", 2, " showMyQrCodeActionSheet() click item = " + item.action);
                int i3 = item.action;
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 39) {
                                    if (i3 != 171) {
                                        if (i3 == 218) {
                                            if (!m02.d.f415923a.d(this.activity)) {
                                                QLog.w("ShareScreenshot", 1, "isSupportShareToXhs false");
                                                return;
                                            } else {
                                                b(this.bitmap, this.activity, 5);
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    b(this.bitmap, this.activity, 1);
                                    return;
                                }
                                a(this.activity, this.bitmap);
                                return;
                            }
                            b(this.bitmap, this.activity, 3);
                            return;
                        }
                        b(this.bitmap, this.activity, 2);
                        return;
                    }
                    b(this.bitmap, this.activity, 4);
                    return;
                }
                b(this.bitmap, this.activity, 0);
                return;
            }
            QLog.e("ShareScreenshot", 1, "onItemClick null object: item = [" + item + "], sheet = [" + sheet + "]");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\t\n\u000b\f\r\u000eB\u0011\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "", "", "a", "I", "()I", "actionId", "<init>", "(I)V", "b", "c", "d", "e", "f", "g", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$a;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$b;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$c;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$d;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$e;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$f;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$g;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int actionId;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$a;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "label", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7904a extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C7904a(@NotNull String label) {
                super(39, null);
                Intrinsics.checkNotNullParameter(label, "label");
                this.label = label;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final String getLabel() {
                return this.label;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$b;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class b extends a {
            public b() {
                super(171, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$c;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class c extends a {
            public c() {
                super(2, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$d;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class d extends a {
            public d() {
                super(3, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$e;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class e extends a {
            public e() {
                super(9, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$f;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class f extends a {
            public f() {
                super(10, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a$g;", "Lcom/tencent/mobileqq/guild/share/GuildLLMChatShareScreenshot$a;", "", "b", "Ljava/lang/String;", "getShareTitle", "()Ljava/lang/String;", "setShareTitle", "(Ljava/lang/String;)V", "shareTitle", "c", "getContent", "setContent", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public static final class g extends a {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String shareTitle;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String content;

            public /* synthetic */ g(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(@NotNull String shareTitle, @NotNull String content) {
                super(218, null);
                Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
                Intrinsics.checkNotNullParameter(content, "content");
                this.shareTitle = shareTitle;
                this.content = content;
            }
        }

        public /* synthetic */ a(int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3);
        }

        /* renamed from: a, reason: from getter */
        public final int getActionId() {
            return this.actionId;
        }

        a(int i3) {
            this.actionId = i3;
        }
    }

    public GuildLLMChatShareScreenshot(@NotNull Activity mActivity, @NotNull GuildSharePageSource pageSource, @NotNull GuildSearchLLMChatPictureGenerator.GeneratorParam mPictureOriginParams) {
        List<a> mutableListOf;
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(pageSource, "pageSource");
        Intrinsics.checkNotNullParameter(mPictureOriginParams, "mPictureOriginParams");
        this.mActivity = mActivity;
        this.pageSource = pageSource;
        this.mPictureOriginParams = mPictureOriginParams;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new a.C7904a("\u4fdd\u5b58\u56fe\u7247"), new a.c(), new a.b(), new a.e(), new a.f(), new a.d(), new a.g(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this.sharePlatforms = mutableListOf;
    }

    private final void h(ShareActionSheet shareActionSheet) {
        int collectionSizeOrDefault;
        List<a> list = this.sharePlatforms;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (a aVar : list) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(aVar.getActionId());
            if (aVar instanceof a.C7904a) {
                build.label = ((a.C7904a) aVar).getLabel();
            }
            arrayList.add(build);
        }
        shareActionSheet.setActionSheetItems(arrayList, new ArrayList());
    }

    private final ShareActionSheet i(Context curActivity, Bitmap preView) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.canceledOnTouchOutside = true;
        param.context = curActivity;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        final q qVar = new q();
        param.actionSheetRender = new ShareActionSheetV2.l() { // from class: com.tencent.mobileqq.guild.share.c
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.l
            public final void b(ActionSheet actionSheet) {
                GuildLLMChatShareScreenshot.j(q.this, this, actionSheet);
            }
        };
        param.itemRender = new ShareActionSheetV2.m() { // from class: com.tencent.mobileqq.guild.share.d
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.m
            public final void a(View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
                GuildLLMChatShareScreenshot.k(q.this, view, imageView, textView, actionSheetItem);
            }
        };
        ShareActionSheetWithScrollPreview shareActionSheetWithScrollPreview = new ShareActionSheetWithScrollPreview(param, curActivity);
        shareActionSheetWithScrollPreview.C0(preView);
        shareActionSheetWithScrollPreview.B0("\u5206\u4eab");
        shareActionSheetWithScrollPreview.setRowVisibility(8, 0, 8);
        shareActionSheetWithScrollPreview.setExtras(BundleKt.bundleOf(TuplesKt.to("no_need_report", Boolean.TRUE)));
        h(shareActionSheetWithScrollPreview);
        return shareActionSheetWithScrollPreview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(q shareDtReportHelper, GuildLLMChatShareScreenshot this$0, ActionSheet actionSheet) {
        String str;
        a.AnswerItem e16;
        Intrinsics.checkNotNullParameter(shareDtReportHelper, "$shareDtReportHelper");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSharePageSource guildSharePageSource = this$0.pageSource;
        AiChatSession m06 = this$0.mPictureOriginParams.c().m0();
        String str2 = null;
        if (m06 != null) {
            str = m06.getSessionId();
        } else {
            str = null;
        }
        AiChatSession m07 = this$0.mPictureOriginParams.c().m0();
        if (m07 != null && (e16 = m07.e()) != null) {
            str2 = e16.getMessageId();
        }
        shareDtReportHelper.b(actionSheet, guildSharePageSource, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(q shareDtReportHelper, View view, ImageView imageView, TextView nickView, ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        Intrinsics.checkNotNullParameter(shareDtReportHelper, "$shareDtReportHelper");
        Intrinsics.checkNotNullExpressionValue(nickView, "nickView");
        Intrinsics.checkNotNullExpressionValue(sheetItem, "sheetItem");
        shareDtReportHelper.a(view, imageView, nickView, sheetItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Activity activity, Bitmap bitmap) {
        ShareActionSheet i3 = i(activity, bitmap);
        i3.setItemClickListenerV2(new PictureShareSheet(this, activity, bitmap));
        i3.show();
    }

    public final boolean m() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
        if (f16 != null) {
            bVar = CorountineFunKt.e(f16, "ShareScreenshot share", null, null, Boolean.TRUE, new GuildLLMChatShareScreenshot$startShare$1(this, null), 6, null);
        }
        this.task = bVar;
        return true;
    }
}
