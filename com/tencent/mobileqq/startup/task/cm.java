package com.tencent.mobileqq.startup.task;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.JpegExifReader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.SharpSoLoader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableParams;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.emoticon.api.IVasExtensionDownloaderService;
import com.tencent.mobileqq.emoticon.download.QQSysAndEmojiDownloader;
import com.tencent.mobileqq.emoticonview.FavoriteDownloader;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.AIOFlowerImgDownloader;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.AlbumPreviewThumbDownloader;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.DataLineFaceDownloader;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.EmotionDownloader;
import com.tencent.mobileqq.transfile.FavoriteImageDownloader;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.mobileqq.transfile.LocalBilldDownloader;
import com.tencent.mobileqq.transfile.LocalFileDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.PicFileGalleryOrigDecoder;
import com.tencent.mobileqq.transfile.ProfileImgDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.QZoneCoverDownloader;
import com.tencent.mobileqq.transfile.QZoneRecentPhotoDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.ShortVideoForPicThumbDownloader;
import com.tencent.mobileqq.transfile.ShortVideoThumbDownloader;
import com.tencent.mobileqq.transfile.SignatureTemplateDownloader;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;
import com.tencent.mobileqq.transfile.ThirdPartAppIconDownloader;
import com.tencent.mobileqq.transfile.ThumbnailDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.VasApngDownloader;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.mobileqq.transfile.VideoCoverDownloader;
import com.tencent.mobileqq.transfile.VideoThumbDownloader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.vas.theme.effect.QEffectGifImageView;
import com.tencent.mobileqq.vas.theme.effect.QEffectLoad;
import com.tencent.mobileqq.vas.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.qq.effect.engine.QEffectType;
import com.tencent.qqnt.emotion.api.IEmotionDownloaderFactory;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecApi;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qzonehub.api.contentbox.IQzoneContentBoxDownloader;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0004\r\u000e\u000f\u0007B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cm;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "Lcom/tencent/xaction/log/a;", "d", "Lcom/tencent/xaction/log/a;", "xaLog", "<init>", "()V", "e", "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class cm extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f289837f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private static DiskCache f289838h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.xaction.log.a xaLog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cm$a;", "", "Lcom/tencent/mobileqq/transfile/DiskCache;", "sDiskCache", "Lcom/tencent/mobileqq/transfile/DiskCache;", "a", "()Lcom/tencent/mobileqq/transfile/DiskCache;", "b", "(Lcom/tencent/mobileqq/transfile/DiskCache;)V", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.cm$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final DiskCache a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return cm.f289838h;
            }
            return (DiskCache) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        public final void b(@Nullable DiskCache diskCache) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                cm.f289838h = diskCache;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) diskCache);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016Jd\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cm$b;", "Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;", "", "readEnableFromDPC", "", "uin", "tagName", "success", "", "duration", "size", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "reserved", "", "doReport", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class b implements JpegExifReader.JpegExifReaderInterface {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.JpegExifReader.JpegExifReaderInterface
        public void doReport(@Nullable String uin, @NotNull String tagName, boolean success, long duration, long size, @Nullable HashMap<String, String> params, @Nullable String reserved) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, uin, tagName, Boolean.valueOf(success), Long.valueOf(duration), Long.valueOf(size), params, reserved);
            } else {
                Intrinsics.checkNotNullParameter(tagName, "tagName");
            }
        }

        @Override // com.tencent.image.JpegExifReader.JpegExifReaderInterface
        public boolean readEnableFromDPC() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            try {
                String configStr = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name(), null);
                if (QLog.isColorLevel()) {
                    QLog.d("JpegExifReader", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + configStr);
                }
                if (TextUtils.isEmpty(configStr)) {
                    return true;
                }
                Intrinsics.checkNotNullExpressionValue(configStr, "configStr");
                Object[] array = new Regex("\\|").split(configStr, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr.length < 9) {
                    return true;
                }
                if (Integer.parseInt(strArr[8]) == 1) {
                    return true;
                }
                return false;
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e("JpegExifReader", 2, "read dpc", e16);
                return true;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cm$c;", "Lcom/tencent/qq/effect/engine/QEffectEngine$JsonConvert;", "T", "", ReportConstant.COSTREPORT_PREFIX, "Ljava/lang/Class;", "aClass", "parseArray", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "parseObject", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements QEffectEngine.JsonConvert {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/startup/task/cm$c$a", "Lcom/tencent/qq/effect/engine/QEffectData;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class a extends QEffectData {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qq.effect.engine.QEffectEngine.JsonConvert
        public <T> T parseArray(@NotNull String s16, @Nullable Class<?> aClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16, (Object) aClass);
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            new a();
            return (T) com.tencent.mobileqq.jsonconverter.a.c(s16, a.class.getGenericSuperclass());
        }

        @Override // com.tencent.qq.effect.engine.QEffectEngine.JsonConvert
        public <T> T parseObject(@NotNull String s16, @Nullable Class<?> aClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) s16, (Object) aClass);
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            return (T) com.tencent.mobileqq.jsonconverter.a.e(s16, aClass);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/startup/task/cm$d;", "Lcom/tencent/image/URLDrawableParams;", "Lcom/tencent/image/ApngSoLoader;", "getApngSoLoader", "Lcom/tencent/image/SharpSoLoader;", "getSharpSoLoader", "", AudienceReportConst.PROTOCOL, "", "httpDownloaderParams", "Lcom/tencent/image/ProtocolDownloader;", "doGetDownloader", "doGetLocalFilePath", "Landroid/graphics/drawable/Drawable;", "getDefaultLoadingDrawable", "getDefualtFailedDrawable", "a", "Lcom/tencent/image/ProtocolDownloader;", "mHttpDownloader", "b", "mLocalBilldDownloader", "c", "mProfileImgDownloader", "d", "mNearbyImgDownloader", "e", "mHotPicDownLoader", "f", "mKeywordEmotionDownLoader", "g", "mAlbumPreviewThumbDownloader", tl.h.F, "mLocalFileDownloader", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class d extends URLDrawableParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mHttpDownloader;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mLocalBilldDownloader;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mProfileImgDownloader;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mNearbyImgDownloader;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mHotPicDownLoader;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mKeywordEmotionDownLoader;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mAlbumPreviewThumbDownloader;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ProtocolDownloader mLocalFileDownloader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull Application app) {
            super(app);
            Intrinsics.checkNotNullParameter(app, "app");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
            } else {
                this.mFadeInImage = false;
                this.mUseGifAnimation = false;
            }
        }

        @Override // com.tencent.image.URLDrawableParams
        @Nullable
        protected ProtocolDownloader doGetDownloader(@NotNull String protocol2, @Nullable Object httpDownloaderParams) {
            boolean endsWith$default;
            ProtocolDownloader httpDownloader;
            boolean equals;
            boolean endsWith$default2;
            boolean endsWith$default3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ProtocolDownloader) iPatchRedirector.redirect((short) 4, (Object) this, (Object) protocol2, httpDownloaderParams);
            }
            Intrinsics.checkNotNullParameter(protocol2, "protocol");
            boolean z16 = true;
            if (!Intrinsics.areEqual("http", protocol2) && !Intrinsics.areEqual("https", protocol2)) {
                if (!Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE, protocol2) && !Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_NEARBY_LOCAL_IMAGE, protocol2)) {
                    if (!Intrinsics.areEqual("chatthumb", protocol2) && !Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, protocol2) && !Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW, protocol2)) {
                        if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_DATALINE_IMAGE, protocol2)) {
                            return new DataLineDownloader(BaseApplicationImpl.getApplication());
                        }
                        if (Intrinsics.areEqual(DataLineFaceDownloader.PROTOCOL_DATALINE_FACE, protocol2)) {
                            return new DataLineFaceDownloader(BaseApplicationImpl.getApplication());
                        }
                        if (Intrinsics.areEqual("emotion", protocol2)) {
                            return new EmotionDownloader(BaseApplicationImpl.getApplication());
                        }
                        if (Intrinsics.areEqual(EmotionConstants.PROTOCOL_EMOTION_PIC, protocol2)) {
                            return ((IEmotionDownloaderFactory) QRoute.api(IEmotionDownloaderFactory.class)).getDownloader(protocol2);
                        }
                        if (Intrinsics.areEqual("favorite", protocol2)) {
                            return new FavoriteDownloader();
                        }
                        if (Intrinsics.areEqual(QAlbumUtil.PROTOCOL_ALBUM_THUMB, protocol2)) {
                            return new AlbumThumbDownloader();
                        }
                        if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_VIDEO_THUMB, protocol2)) {
                            return new VideoThumbDownloader();
                        }
                        if (Intrinsics.areEqual(QAlbumUtil.PROTOCOL_VIDEO_COVER, protocol2)) {
                            return new VideoCoverDownloader();
                        }
                        if (!Intrinsics.areEqual("qbasealbumthumb", protocol2) && !Intrinsics.areEqual("qbasevideocover", protocol2)) {
                            if (Intrinsics.areEqual("pubaccountimage", protocol2)) {
                                Object httpDownloader2 = ((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).getHttpDownloader();
                                Intrinsics.checkNotNull(httpDownloader2, "null cannot be cast to non-null type com.tencent.image.ProtocolDownloader");
                                return (ProtocolDownloader) httpDownloader2;
                            }
                            if (!Intrinsics.areEqual(LocalBilldDownloader.PROTOCOL_BILLD_THUMB, protocol2) && !Intrinsics.areEqual(LocalBilldDownloader.PROTOCOL_BILLD_IMG, protocol2)) {
                                if (!Intrinsics.areEqual(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_BIG, protocol2) && !Intrinsics.areEqual(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_THUMB, protocol2) && !Intrinsics.areEqual(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_ICON, protocol2) && !Intrinsics.areEqual(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_BIG_FHD, protocol2)) {
                                    if (Intrinsics.areEqual(IProfileCardConst.PROTOCOL_QZONE_COVER, protocol2)) {
                                        return new QZoneCoverDownloader();
                                    }
                                    if (Intrinsics.areEqual(AbsDownloader.PROTOCAL_FAVORITE_IMAGE, protocol2)) {
                                        return new FavoriteImageDownloader(BaseApplicationImpl.getApplication());
                                    }
                                    if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_FILE_ASSISTANT_IMAGE, protocol2)) {
                                        return new FileAssistantDownloader(BaseApplicationImpl.getApplication());
                                    }
                                    if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_FILE_GALLERYORIGIMAGE, protocol2)) {
                                        return new PicFileGalleryOrigDecoder(BaseApplicationImpl.getApplication());
                                    }
                                    if (Intrinsics.areEqual(QZoneRecentPhotoDownloader.PROTOCOL_TROOP_PHOTO_QZONE, protocol2)) {
                                        return new QZoneRecentPhotoDownloader();
                                    }
                                    if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_AIO_THUMB, protocol2)) {
                                        return ((IPicFactory) QRoute.api(IPicFactory.class)).getChatImageDownloader(BaseApplication.getContext(), protocol2);
                                    }
                                    if (Intrinsics.areEqual("file", protocol2)) {
                                        String qQProcessName = BaseApplicationImpl.sApplication.getQQProcessName();
                                        Intrinsics.checkNotNullExpressionValue(qQProcessName, "sApplication.qqProcessName");
                                        endsWith$default3 = StringsKt__StringsJVMKt.endsWith$default(qQProcessName, ":peak", false, 2, null);
                                        if (endsWith$default3) {
                                            return new com.tencent.mobileqq.activity.aio.photo.k(BaseApplicationImpl.getApplication());
                                        }
                                    }
                                    if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_REGIONAL_THUMB, protocol2)) {
                                        return new RegionalThumbDownloader(BaseApplicationImpl.getApplication());
                                    }
                                    if (Intrinsics.areEqual(ThirdPartAppIconDownloader.PROTOCOL_THIRD_PART, protocol2)) {
                                        return new ThirdPartAppIconDownloader(BaseApplicationImpl.getApplication());
                                    }
                                    if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_GAMEAD, protocol2)) {
                                        return new LastModifySupportDownloader();
                                    }
                                    if (Intrinsics.areEqual(ShortVideoThumbDownloader.PROTOCOL_SHORT_VIDEO_THUMB, protocol2)) {
                                        return new ShortVideoThumbDownloader();
                                    }
                                    if (Intrinsics.areEqual(ShortVideoForPicThumbDownloader.PROTOCOL_SHORT_VIDEO_FOR_PIC_THUMB, protocol2)) {
                                        return new ShortVideoForPicThumbDownloader();
                                    }
                                    if (Intrinsics.areEqual(DeviceMsgThumbDownloader.PROTOCOL_DEVICE_MSG_THUMB, protocol2)) {
                                        return new DeviceMsgThumbDownloader();
                                    }
                                    if (Intrinsics.areEqual(CarrierImgDownloader.PROTOCAL_CARRIER_IMG, protocol2)) {
                                        return new CarrierImgDownloader();
                                    }
                                    if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_AIO_FLOWER, protocol2)) {
                                        return new AIOFlowerImgDownloader();
                                    }
                                    if (!Intrinsics.areEqual(SignatureTemplateDownloader.PROTOCAL_SIGNATURE_COVER, protocol2) && !Intrinsics.areEqual(SignatureTemplateDownloader.PROTOCAL_SIGNATURE_ZIP, protocol2)) {
                                        if (Intrinsics.areEqual(ThemeDIYDownloader.PROTOCAL_THEME_DIY_PIC, protocol2)) {
                                            return new ThemeDIYDownloader();
                                        }
                                        if (Intrinsics.areEqual("vasapngdownloader", protocol2)) {
                                            return new VasApngDownloader();
                                        }
                                        if (Intrinsics.areEqual("funny_pic", protocol2)) {
                                            return ((IFunnyPicHelperService) QRoute.api(IFunnyPicHelperService.class)).createFunnyPicDownloader();
                                        }
                                        if (Intrinsics.areEqual(RedTouchConst.PicDownload.REDTOUCHPIC_PROTOC, protocol2)) {
                                            return new com.tencent.mobileqq.redtouch.f(BaseApplicationImpl.getApplication());
                                        }
                                        if (Intrinsics.areEqual(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, protocol2)) {
                                            return ((IVasExtensionDownloaderService) QRoute.api(IVasExtensionDownloaderService.class)).createVasExtensionDownloader();
                                        }
                                        if (Intrinsics.areEqual(ShortVideoConstants.FILE_SOURCE_HOT_PIC, protocol2)) {
                                            if (this.mHotPicDownLoader == null) {
                                                this.mHotPicDownLoader = new com.tencent.mobileqq.hotpic.b();
                                            }
                                            ProtocolDownloader protocolDownloader = this.mHotPicDownLoader;
                                            Intrinsics.checkNotNull(protocolDownloader);
                                            return protocolDownloader;
                                        }
                                        if (Intrinsics.areEqual("hot_pic_origin", protocol2)) {
                                            return new com.tencent.mobileqq.hotpic.h();
                                        }
                                        if (Intrinsics.areEqual(IPublicAccountGifPlayTimeHttpDownloader.PROTOCOL_GIF_PLAY_ACCOUNT, protocol2)) {
                                            Object httpDownloader3 = ((IPublicAccountGifPlayTimeHttpDownloader) QRoute.api(IPublicAccountGifPlayTimeHttpDownloader.class)).getHttpDownloader();
                                            Intrinsics.checkNotNull(httpDownloader3, "null cannot be cast to non-null type com.tencent.image.ProtocolDownloader");
                                            return (ProtocolDownloader) httpDownloader3;
                                        }
                                        if (Intrinsics.areEqual(IQzoneContentBoxDownloader.PROTOCAL_QZONE_CONTENT_BOX, protocol2)) {
                                            Object api = QRoute.api(IQzoneContentBoxDownloader.class);
                                            Intrinsics.checkNotNull(api, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.AbsDownloader");
                                            return (AbsDownloader) api;
                                        }
                                        if (Intrinsics.areEqual(QWalletPicHelper.PROTOCOL_QWALLET_DOWNLOAD, protocol2)) {
                                            return ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQWalletPicDownloader();
                                        }
                                        if (Intrinsics.areEqual("sticker_recommended_pic", protocol2)) {
                                            if (this.mKeywordEmotionDownLoader == null) {
                                                this.mKeywordEmotionDownLoader = ((IStickerRecApi) QRoute.api(IStickerRecApi.class)).getStickerRecDownloader();
                                            }
                                            ProtocolDownloader protocolDownloader2 = this.mKeywordEmotionDownLoader;
                                            Intrinsics.checkNotNull(protocolDownloader2);
                                            return protocolDownloader2;
                                        }
                                        if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCOL_ALBUM_THUMB_PREVIEW, protocol2)) {
                                            if (this.mAlbumPreviewThumbDownloader == null) {
                                                this.mAlbumPreviewThumbDownloader = new AlbumPreviewThumbDownloader();
                                            }
                                            ProtocolDownloader protocolDownloader3 = this.mAlbumPreviewThumbDownloader;
                                            Intrinsics.checkNotNull(protocolDownloader3);
                                            return protocolDownloader3;
                                        }
                                        if (Intrinsics.areEqual(ProtocolDownloaderConstants.PROTOCAL_WEB_COVER, protocol2)) {
                                            return new com.tencent.mobileqq.colornote.list.j();
                                        }
                                        if (Intrinsics.areEqual("qqsys_emoji", protocol2)) {
                                            return new QQSysAndEmojiDownloader();
                                        }
                                        if (!Intrinsics.areEqual("assets_img", protocol2)) {
                                            equals = StringsKt__StringsJVMKt.equals("file", protocol2, true);
                                            if (equals) {
                                                String qQProcessName2 = BaseApplicationImpl.sApplication.getQQProcessName();
                                                Intrinsics.checkNotNullExpressionValue(qQProcessName2, "sApplication.qqProcessName");
                                                endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(qQProcessName2, ":weiyun", false, 2, null);
                                                if (endsWith$default2) {
                                                    if (this.mLocalFileDownloader == null) {
                                                        this.mLocalFileDownloader = new LocalFileDownloader();
                                                    }
                                                    ProtocolDownloader protocolDownloader4 = this.mLocalFileDownloader;
                                                    Intrinsics.checkNotNull(protocolDownloader4);
                                                    return protocolDownloader4;
                                                }
                                            }
                                            return null;
                                        }
                                        return new com.tencent.mobileqq.downloader.a();
                                    }
                                    return new SignatureTemplateDownloader();
                                }
                                if (this.mProfileImgDownloader == null) {
                                    this.mProfileImgDownloader = new ProfileImgDownloader();
                                }
                                ProtocolDownloader protocolDownloader5 = this.mProfileImgDownloader;
                                Intrinsics.checkNotNull(protocolDownloader5);
                                return protocolDownloader5;
                            }
                            if (this.mLocalBilldDownloader == null) {
                                this.mLocalBilldDownloader = new LocalBilldDownloader(BaseApplicationImpl.getApplication());
                            }
                            ProtocolDownloader protocolDownloader6 = this.mLocalBilldDownloader;
                            Intrinsics.checkNotNull(protocolDownloader6);
                            return protocolDownloader6;
                        }
                        return new com.tencent.qqnt.qbasealbum.urldrawable.a();
                    }
                    return ((IPicFactory) QRoute.api(IPicFactory.class)).getChatImageDownloader(BaseApplication.getContext(), protocol2);
                }
                if (this.mNearbyImgDownloader == null) {
                    this.mNearbyImgDownloader = new NearbyImgDownloader();
                }
                ProtocolDownloader protocolDownloader7 = this.mNearbyImgDownloader;
                Intrinsics.checkNotNull(protocolDownloader7);
                return protocolDownloader7;
            }
            if (this.mHttpDownloader == null) {
                String qQProcessName3 = BaseApplicationImpl.sApplication.getQQProcessName();
                Intrinsics.checkNotNullExpressionValue(qQProcessName3, "sApplication.qqProcessName");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(qQProcessName3, ":weiyun", false, 2, null);
                if (endsWith$default) {
                    httpDownloader = new ThumbnailDownloader(BaseApplication.getContext(), false);
                } else {
                    if (MobileQQ.sProcessId != 1) {
                        z16 = false;
                    }
                    httpDownloader = new HttpDownloader(z16, httpDownloaderParams);
                }
                this.mHttpDownloader = httpDownloader;
            }
            ProtocolDownloader protocolDownloader8 = this.mHttpDownloader;
            Intrinsics.checkNotNull(protocolDownloader8);
            return protocolDownloader8;
        }

        @Override // com.tencent.image.URLDrawableParams
        @Nullable
        protected String doGetLocalFilePath(@NotNull String protocol2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) protocol2);
            }
            Intrinsics.checkNotNullParameter(protocol2, "protocol");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.image.URLDrawableParams
        @NotNull
        public ApngSoLoader getApngSoLoader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ApngSoLoader) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.mobileqq.vas.an h16 = com.tencent.mobileqq.vas.an.h();
            Intrinsics.checkNotNullExpressionValue(h16, "getInstance()");
            return h16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.image.URLDrawableParams
        @NotNull
        public Drawable getDefaultLoadingDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Drawable) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            try {
                Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.aio_image_default);
                Intrinsics.checkNotNullExpressionValue(drawable, "{\n                BaseAp\u2026ge_default)\n            }");
                return drawable;
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.image.URLDrawableParams
        @NotNull
        public Drawable getDefualtFailedDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            try {
                Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.aio_image_fail);
                Intrinsics.checkNotNullExpressionValue(drawable, "{\n                BaseAp\u2026image_fail)\n            }");
                return drawable;
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.image.URLDrawableParams
        @NotNull
        public SharpSoLoader getSharpSoLoader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SharpSoLoader) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            com.tencent.mobileqq.startup.step.c b16 = com.tencent.mobileqq.startup.step.c.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getInstance()");
            return b16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public cm() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.xaLog = new com.tencent.xaction.log.a() { // from class: com.tencent.mobileqq.startup.task.cl
                @Override // com.tencent.xaction.log.a
                public final void trace(int i3, String str, int i16, String str2, Throwable th5) {
                    cm.d(i3, str, i16, str2, th5);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, String str, int i16, String str2, Throwable th5) {
        if (1 == i16 || QLog.isColorLevel()) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        QLog.i(str, i16, str2, th5);
                        return;
                    } else {
                        QLog.e(str, i16, str2, th5);
                        return;
                    }
                }
                QLog.w(str, i16, str2, th5);
                return;
            }
            QLog.d(str, i16, str2, th5);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (f289837f) {
            return;
        }
        f289837f = true;
        com.tencent.xaction.log.b.e(this.xaLog);
        QEffectEngine.getInstance().setJsonConvert(new c());
        QEffectEngine.getInstance().registerLoad(new QEffectLoad());
        QEffectEngine.getInstance().registerEffect(2, QEffectType.APNG_TAG, QEffectApngImageView.class);
        QEffectEngine.getInstance().registerEffect(3, QEffectType.LOTTIE_TAG, QEffectLottieImageView.class);
        QEffectEngine.getInstance().registerEffect(8, "gif", QEffectGifImageView.class);
        BaseApplicationImpl application = BaseApplicationImpl.sApplication;
        URLDrawable.DEBUG = false;
        try {
            URLDrawableDepWrap c16 = com.tencent.mobileqq.pic.ab.c();
            Intrinsics.checkNotNullExpressionValue(application, "application");
            URLDrawable.init(c16, new d(application));
        } catch (Throwable th5) {
            QLog.e("AutoMonitor", 1, "", th5);
        }
        DiskCache diskCache = AbsDownloader.sDiskCache;
        f289838h = diskCache;
        if (diskCache != null) {
            file = diskCache.getDirectory();
        } else {
            file = null;
        }
        URLDrawableHelper.diskCachePath = file;
        JpegExifReader.initJpegExifReader(new b());
    }
}
