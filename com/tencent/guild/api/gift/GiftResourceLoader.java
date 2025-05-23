package com.tencent.guild.api.gift;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.gift.GiftResourceLoader;
import com.tencent.guild.api.gift.GuildGiftView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.ui.FakeCanvas;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J$\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00060\nJ\u0006\u0010\u000e\u001a\u00020\u0006R\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/api/gift/GiftResourceLoader;", "", "Lcom/tencent/aio/data/msglist/a;", "guildMsgItem", "Lcom/tencent/guild/api/gift/GuildGiftView$b;", "listener", "", "d", "", "url", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "callback", "c", "e", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "PAG_FILE_SAVE_PATH", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GiftResourceLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GiftResourceLoader f112513a = new GiftResourceLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PAG_FILE_SAVE_PATH = VasConstant.GUILD_DOWN_LOAD_DIR + "guild_aio_gift_head.pag";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guild/api/gift/GiftResourceLoader$b", "Lqh2/c;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "pagFile", "onLoadSuccess", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements qh2.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f112516d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildGiftView.b f112517e;

        b(String str, GuildGiftView.b bVar) {
            this.f112516d = str;
            this.f112517e = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildGiftView.b bVar) {
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.e("GiftResourceLoader", 1, "onLoadFail id: " + id5 + " , message: " + errorMessage);
        }

        @Override // qh2.c
        public void onLoadSuccess(int id5, @NotNull String pagFile) {
            Intrinsics.checkNotNullParameter(pagFile, "pagFile");
            QLog.d("GiftResourceLoader", 1, "onLoadSuccess", id5 + " " + this.f112516d + " , " + pagFile + " " + new File(pagFile).exists());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildGiftView.b bVar = this.f112517e;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.guild.api.gift.b
                @Override // java.lang.Runnable
                public final void run() {
                    GiftResourceLoader.b.b(GuildGiftView.b.this);
                }
            }, 0L);
        }
    }

    GiftResourceLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new com.tencent.mobileqq.vip.g("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/vas_qq_arnopeng/guild_aio_gift_head.pag", new File(PAG_FILE_SAVE_PATH)), MobileQQ.sMobileQQ.peekAppRuntime());
    }

    @NotNull
    public final String b() {
        return PAG_FILE_SAVE_PATH;
    }

    public final void c(@NotNull String url, @NotNull Function1<? super Drawable, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseImageUtil.getDefaultFaceBitmap(true));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = bitmapDrawable;
        obtain.mMemoryCacheKeySuffix = "guild_gift_icon";
        final URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        a aVar = new a(callback);
        if (drawable != null) {
            drawable.setURLDrawableListener(aVar);
        }
        drawable.setTag(new int[]{ViewUtils.dip2px(140.0f), ViewUtils.dip2px(140.0f)});
        drawable.setDecodeHandler(com.tencent.mobileqq.guild.robot.utils.a.f232291a);
        int status = drawable.getStatus();
        if (status != 1) {
            if (status != 2) {
                drawable.startDownload();
            } else {
                drawable.restartDownload();
            }
        } else {
            drawable.setURLDrawableListener(null);
            callback.invoke(drawable);
        }
        FakeCanvas.INSTANCE.use(new Function1<Canvas, Unit>() { // from class: com.tencent.guild.api.gift.GiftResourceLoader$loaderAvatarImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                invoke2(canvas);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Canvas it) {
                Intrinsics.checkNotNullParameter(it, "it");
                URLDrawable.this.draw(it);
            }
        });
    }

    public final void d(@NotNull com.tencent.aio.data.msglist.a guildMsgItem, @Nullable GuildGiftView.b listener) {
        BaseQQAppInterface baseQQAppInterface;
        oh2.a b16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        if (!(guildMsgItem instanceof GuildMsgItem)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        QQVasUpdateBusiness businessInstance = QQVasUpdateBusinessUtil.getBusinessInstance(com.tencent.mobileqq.qqgift.updatasystem.c.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "getBusinessInstance(VasG\u2026urceBusiness::class.java)");
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) businessInstance;
        TextGiftElement c16 = c.f112540a.c((GuildMsgItem) guildMsgItem);
        if (c16 == null) {
            QLog.d("GiftResourceLoader", 2, "textGiftElement is null");
            return;
        }
        int i3 = (int) c16.tianquanId;
        String f16 = qQGiftResourceBusiness.f(i3, 3);
        String savePath = qQGiftResourceBusiness.getSavePath(f16);
        if (!new File(savePath).exists()) {
            nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(10007);
            if (sDKImpl != null && !sDKImpl.isInited()) {
                sDKImpl.c(baseQQAppInterface, com.tencent.mobileqq.qqgift.sdk.config.a.a().d(10007).a("m9iyc4gnzlkt9g7yq71v3v0oyi2xr3p3").b());
            }
            QLog.d("GiftResourceLoader", 2, "start download", f16 + " " + savePath);
            if (sDKImpl != null && (b16 = sDKImpl.b()) != null) {
                b16.R(i3, new b(savePath, listener));
                return;
            }
            return;
        }
        if (listener != null) {
            listener.a();
        }
    }

    public final void e() {
        if (new File(PAG_FILE_SAVE_PATH).exists()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.api.gift.a
            @Override // java.lang.Runnable
            public final void run() {
                GiftResourceLoader.f();
            }
        }, 128, null, true);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/guild/api/gift/GiftResourceLoader$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Drawable, Unit> f112515d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Drawable, Unit> function1) {
            this.f112515d = function1;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            if (drawable != null) {
                drawable.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            if (drawable != null) {
                drawable.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            if (drawable != null) {
                Function1<Drawable, Unit> function1 = this.f112515d;
                drawable.setURLDrawableListener(null);
                function1.invoke(drawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
