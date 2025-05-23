package com.tencent.timi.game.liveroom.impl.room.like;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.timi.game.liveroom.impl.room.like.LikeConfig;
import com.tencent.timi.game.utils.w;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u00104\u001a\u0004\u0018\u00010\u00112\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\u00112\u0006\u00109\u001a\u00020\u0011H\u0002J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0004H\u0002J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004J \u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010;\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0004J\u0006\u0010B\u001a\u00020\u0010J\u0006\u0010C\u001a\u00020\u0010J \u0010D\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0004H\u0002J\u0018\u0010F\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0002J\u0018\u0010G\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0002J\b\u0010H\u001a\u00020\u0004H\u0002J\u0006\u0010I\u001a\u00020\u0010J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0004H\u0002J\u000e\u0010K\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0004J\u0010\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0010J\u001a\u0010O\u001a\u00020M2\u0006\u00109\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010\u0010H\u0002J\u0006\u0010P\u001a\u00020\u0004J\b\u0010Q\u001a\u00020RH\u0002J\u001e\u0010S\u001a\u00020M2\u0006\u0010T\u001a\u00020U2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\u0019R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010 \u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0010X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u0010X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u0010X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$\u00a8\u0006X"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeConfig;", "", "()V", "avatarMaterialId", "", "getAvatarMaterialId", "()I", "combo", "", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikeConfig$LikeComboConfig;", "getCombo", "()Ljava/util/List;", "setCombo", "(Ljava/util/List;)V", "iconBitmapCache", "", "", "Landroid/graphics/Bitmap;", "getIconBitmapCache", "()Ljava/util/Map;", "setIconBitmapCache", "(Ljava/util/Map;)V", "iconCount", "getIconCount", "setIconCount", "(I)V", "materialID", "getMaterialID", "setMaterialID", "numBitmapCache", "getNumBitmapCache", "setNumBitmapCache", Constants.PAG_FILE_PATH, "getPagFilePath", "()Ljava/lang/String;", "setPagFilePath", "(Ljava/lang/String;)V", "pathCombo", "getPathCombo", "pathFirework", "getPathFirework", "pathIcon", "getPathIcon", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lkotlin/random/Random;", "getRandom", "()Lkotlin/random/Random;", "setRandom", "(Lkotlin/random/Random;)V", "rootPath", "getRootPath", "setRootPath", "decodeFromFile", "filename", "reqWidthPx", "reqHeightPx", "getCircularBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getIconPNGFilePath", "iconIdx", "getLevelByNum", WidgetCacheConstellationData.NUM, "getLikeImg", "getLikeNumScale", "", "level", "getLikePagPath", "getLikePageAssert", "getNumPNGFilePath", "realNum", "getNumPathByLevel", "getNumResId", "getTempLikeIcon", "getUpgradePagAssert", "getUpgradePagFilePath", "getUpgradePagPath", "loadAvatarBitmap", "", "url", "putAvatarInCache", "randomIconIdx", "resLoaded", "", "setNumImageRes", "imageView", "Landroid/widget/ImageView;", "Companion", "LikeComboConfig", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class LikeConfig {

    @NotNull
    private static final String TAG = "Like_Biz|LikeConfig";

    @Nullable
    private static Bitmap avatarBitmapCache = null;

    @NotNull
    private static final String configJsonFileName = "like.json";

    @Nullable
    private static LikeConfig remoteLikeConfig;
    private int materialID;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final LikeConfig defaultLikeConfig = new LikeConfig();

    @NotNull
    private final String pathCombo = "combo";

    @NotNull
    private final String pathFirework = "firework";

    @NotNull
    private final String pathIcon = "icon";

    @NotNull
    private String rootPath = "";

    @NotNull
    private String pagFilePath = "";
    private int iconCount = 1;

    @NotNull
    private List<LikeComboConfig> combo = new ArrayList();

    @NotNull
    private Random random = Random.INSTANCE;

    @NotNull
    private Map<String, Bitmap> iconBitmapCache = new LinkedHashMap();

    @NotNull
    private Map<String, Bitmap> numBitmapCache = new LinkedHashMap();
    private final int avatarMaterialId = BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeConfig$Companion;", "", "()V", "TAG", "", "avatarBitmapCache", "Landroid/graphics/Bitmap;", "configJsonFileName", "defaultLikeConfig", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikeConfig;", "remoteLikeConfig", "getConfig", "loadConfig", "", "materialID", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LikeConfig getConfig() {
            if (LikeConfig.remoteLikeConfig != null) {
                LikeConfig likeConfig = LikeConfig.remoteLikeConfig;
                Intrinsics.checkNotNull(likeConfig);
                return likeConfig;
            }
            return LikeConfig.defaultLikeConfig;
        }

        public final void loadConfig(final int materialID) {
            if (LikeConfig.remoteLikeConfig != null) {
                LikeConfig likeConfig = LikeConfig.remoteLikeConfig;
                boolean z16 = false;
                if (likeConfig != null && likeConfig.getMaterialID() == materialID) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
            }
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId()).b().g(materialID, new qh2.b() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LikeConfig$Companion$loadConfig$1
                @Override // qh2.g
                public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
                    AegisLogger.INSTANCE.e("Like_Biz|LikeConfig", "loadConfig onLoadFail", "resId=" + id5 + ", errorCode=" + errorCode + ", httpCode=" + httpCode + ", errorMessage=" + errorMessage);
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x0092 A[Catch: Exception -> 0x00aa, TryCatch #0 {Exception -> 0x00aa, blocks: (B:10:0x0070, B:12:0x0086, B:17:0x0092, B:20:0x00a3), top: B:9:0x0070 }] */
                /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
                @Override // qh2.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onLoadSuccess(int id5, @Nullable String path) {
                    String readText;
                    boolean z17;
                    String str = "";
                    AegisLogger.INSTANCE.i("Like_Biz|LikeConfig", "loadConfig onLoadSuccess", "resId=" + id5 + ", path=" + path);
                    QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(QQGiftResourceBusiness.class);
                    String rootPath = qQGiftResourceBusiness.getSavePath(qQGiftResourceBusiness.f(id5, 2));
                    File file = new File(rootPath + File.separator + "like.json");
                    if (file.exists()) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            try {
                                readText = TextStreamsKt.readText(new InputStreamReader(fileInputStream, Charsets.UTF_8));
                                CloseableKt.closeFinally(fileInputStream, null);
                            } finally {
                            }
                        } catch (Exception e16) {
                            e = e16;
                        }
                        try {
                            Object e17 = com.tencent.mobileqq.jsonconverter.a.e(readText, LikeConfig.class);
                            Intrinsics.checkNotNullExpressionValue(e17, "convertFromJSONObject(\n \u2026                        )");
                            LikeConfig likeConfig2 = (LikeConfig) e17;
                            List<LikeConfig.LikeComboConfig> combo = likeConfig2.getCombo();
                            if (combo != null && !combo.isEmpty()) {
                                z17 = false;
                                if (z17) {
                                    Intrinsics.checkNotNullExpressionValue(rootPath, "rootPath");
                                    likeConfig2.setRootPath(rootPath);
                                    likeConfig2.setMaterialID(materialID);
                                    if (path == null) {
                                        path = "";
                                    }
                                    likeConfig2.setPagFilePath(path);
                                    LikeConfig.remoteLikeConfig = likeConfig2;
                                    return;
                                }
                                return;
                            }
                            z17 = true;
                            if (z17) {
                            }
                        } catch (Exception e18) {
                            e = e18;
                            str = readText;
                            AegisLogger.INSTANCE.e("Like_Biz|LikeConfig", "parse json Exception", "content:" + str + ", e:" + e);
                        }
                    }
                }
            });
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikeConfig$LikeComboConfig;", "", "()V", "begin", "", "getBegin", "()I", "setBegin", "(I)V", "end", "getEnd", "setEnd", "index", "getIndex", "setIndex", "scale", "", "getScale", "()F", "setScale", "(F)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class LikeComboConfig {
        private int index = 1;
        private int begin = 1;
        private int end = -1;
        private float scale = 1.0f;

        public final int getBegin() {
            return this.begin;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getIndex() {
            return this.index;
        }

        public final float getScale() {
            return this.scale;
        }

        public final void setBegin(int i3) {
            this.begin = i3;
        }

        public final void setEnd(int i3) {
            this.end = i3;
        }

        public final void setIndex(int i3) {
            this.index = i3;
        }

        public final void setScale(float f16) {
            this.scale = f16;
        }
    }

    private final Bitmap decodeFromFile(String filename, int reqWidthPx, int reqHeightPx) {
        AegisLogger.INSTANCE.d(TAG, "decodeFromFile", "filename:" + filename + ", reqW:" + reqWidthPx + ", reqH:" + reqHeightPx);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);
        options.inSampleSize = BaseImageUtil.calculateInSampleSize(options, reqWidthPx, reqHeightPx);
        options.inJustDecodeBounds = false;
        try {
            try {
                return BitmapFactory.decodeFile(filename, options);
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e(TAG, "decodeFromFile", "exception:" + e16 + ", filename:" + filename + ", reqW:" + reqWidthPx + ", reqH:" + reqHeightPx);
                return null;
            }
        } catch (OutOfMemoryError unused) {
            options.inSampleSize *= 2;
            return BitmapFactory.decodeFile(filename, options);
        }
    }

    private final Bitmap getCircularBitmap(Bitmap bitmap) {
        Bitmap createBitmap;
        int width;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n            Bitmap.cre\u2026nfig.ARGB_8888)\n        }");
        } else {
            createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n            Bitmap.cre\u2026nfig.ARGB_8888)\n        }");
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (bitmap.getWidth() > bitmap.getHeight()) {
            width = bitmap.getHeight() / 2;
        } else {
            width = bitmap.getWidth() / 2;
        }
        float f16 = width;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(f16, f16, f16, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private final String getIconPNGFilePath(int iconIdx) {
        String str = this.rootPath;
        String str2 = File.separator;
        return str + str2 + this.pathIcon + str2 + iconIdx + ".png";
    }

    private final String getNumPNGFilePath(int num, int level, int realNum) {
        if (num >= 0) {
            String str = this.rootPath;
            String str2 = File.separator;
            return str + str2 + this.pathCombo + str2 + level + str2 + realNum + ".png";
        }
        String str3 = this.rootPath;
        String str4 = File.separator;
        return str3 + str4 + this.pathCombo + str4 + level + str4 + "x.png";
    }

    private final String getNumPathByLevel(int num, int level) {
        int i3 = num % 10;
        if (resLoaded()) {
            String numPNGFilePath = getNumPNGFilePath(i3, level, i3 % 10);
            if (new File(numPNGFilePath).exists()) {
                return numPNGFilePath;
            }
            return "";
        }
        return "";
    }

    private final int getNumResId(int num, int level) {
        switch (num % 10) {
            case 0:
                return R.drawable.o5k;
            case 1:
                return R.drawable.o5l;
            case 2:
                return R.drawable.o5m;
            case 3:
                return R.drawable.o5n;
            case 4:
                return R.drawable.o5o;
            case 5:
                return R.drawable.o5p;
            case 6:
                return R.drawable.o5q;
            case 7:
                return R.drawable.o5r;
            case 8:
                return R.drawable.o5s;
            case 9:
                return R.drawable.o5t;
            default:
                return R.drawable.o5u;
        }
    }

    private final int getTempLikeIcon() {
        int nextInt = Random.INSTANCE.nextInt(0, 3);
        if (nextInt != 1) {
            if (nextInt != 2) {
                return R.drawable.o87;
            }
            return R.drawable.o89;
        }
        return R.drawable.o88;
    }

    private final String getUpgradePagFilePath(int level) {
        String str = this.rootPath;
        String str2 = File.separator;
        return str + str2 + this.pathFirework + str2 + level + ".pag";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putAvatarInCache(final Bitmap bitmap, String url) {
        w.a(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.a
            @Override // java.lang.Runnable
            public final void run() {
                LikeConfig.putAvatarInCache$lambda$3(LikeConfig.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putAvatarInCache$lambda$3(LikeConfig this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Bitmap circularBitmap = this$0.getCircularBitmap(bitmap);
        if (circularBitmap != null) {
            avatarBitmapCache = circularBitmap;
        }
    }

    private final boolean resLoaded() {
        if (!TextUtils.isEmpty(this.rootPath)) {
            return true;
        }
        return false;
    }

    public final int getAvatarMaterialId() {
        return this.avatarMaterialId;
    }

    @NotNull
    public final List<LikeComboConfig> getCombo() {
        return this.combo;
    }

    @NotNull
    public final Map<String, Bitmap> getIconBitmapCache() {
        return this.iconBitmapCache;
    }

    public final int getIconCount() {
        return this.iconCount;
    }

    public final int getLevelByNum(int num) {
        boolean z16;
        Object obj;
        boolean z17;
        List<LikeComboConfig> list = this.combo;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 1;
        }
        Iterator<T> it = this.combo.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                LikeComboConfig likeComboConfig = (LikeComboConfig) obj;
                if (likeComboConfig.getBegin() <= num && (likeComboConfig.getEnd() >= num || likeComboConfig.getEnd() == -1)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LikeComboConfig likeComboConfig2 = (LikeComboConfig) obj;
        if (likeComboConfig2 == null) {
            return 1;
        }
        return likeComboConfig2.getIndex();
    }

    @Nullable
    public final Bitmap getLikeImg(int iconIdx, int reqWidthPx, int reqHeightPx) {
        if (iconIdx == this.avatarMaterialId) {
            return avatarBitmapCache;
        }
        if (resLoaded()) {
            String iconPNGFilePath = getIconPNGFilePath(iconIdx);
            if (this.iconBitmapCache.get(iconPNGFilePath) != null) {
                return this.iconBitmapCache.get(iconPNGFilePath);
            }
            if (new File(iconPNGFilePath).exists()) {
                Bitmap decodeFromFile = decodeFromFile(iconPNGFilePath, reqWidthPx, reqHeightPx);
                if (decodeFromFile == null) {
                    return null;
                }
                this.iconBitmapCache.put(iconPNGFilePath, decodeFromFile);
                return this.iconBitmapCache.get(iconPNGFilePath);
            }
        }
        Drawable b16 = yn4.c.b(getTempLikeIcon());
        if (b16 instanceof BitmapDrawable) {
            return ((BitmapDrawable) b16).getBitmap();
        }
        if (!(b16 instanceof SkinnableBitmapDrawable)) {
            return null;
        }
        return ((SkinnableBitmapDrawable) b16).getBitmap();
    }

    public final float getLikeNumScale(int level) {
        boolean z16;
        Object obj;
        boolean z17;
        List<LikeComboConfig> list = this.combo;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 1.0f;
        }
        Iterator<T> it = this.combo.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((LikeComboConfig) obj).getIndex() == level) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LikeComboConfig likeComboConfig = (LikeComboConfig) obj;
        if (likeComboConfig == null) {
            return 1.0f;
        }
        return likeComboConfig.getScale();
    }

    @NotNull
    public final String getLikePagPath() {
        if (resLoaded() && new File(this.pagFilePath).exists()) {
            return this.pagFilePath;
        }
        return "";
    }

    @NotNull
    public final String getLikePageAssert() {
        return "pag/tg_like.pag";
    }

    public final int getMaterialID() {
        return this.materialID;
    }

    @NotNull
    public final Map<String, Bitmap> getNumBitmapCache() {
        return this.numBitmapCache;
    }

    @NotNull
    public final String getPagFilePath() {
        return this.pagFilePath;
    }

    @NotNull
    public final String getPathCombo() {
        return this.pathCombo;
    }

    @NotNull
    public final String getPathFirework() {
        return this.pathFirework;
    }

    @NotNull
    public final String getPathIcon() {
        return this.pathIcon;
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    @NotNull
    public final String getRootPath() {
        return this.rootPath;
    }

    @NotNull
    public final String getUpgradePagAssert() {
        return "pag/tg_like_upgrade.pag";
    }

    @NotNull
    public final String getUpgradePagPath(int level) {
        if (resLoaded()) {
            String upgradePagFilePath = getUpgradePagFilePath(level);
            if (new File(upgradePagFilePath).exists()) {
                return upgradePagFilePath;
            }
            return "";
        }
        return "";
    }

    public final void loadAvatarBitmap(@Nullable final String url) {
        boolean z16;
        Bitmap bitmap;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || avatarBitmapCache != null) {
            return;
        }
        final URLDrawable drawable = URLDrawable.getDrawable(url, com.tencent.timi.game.utils.d.f380295a.b(fh4.b.b(44), R.drawable.ovu));
        Drawable currDrawable = drawable.getCurrDrawable();
        if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
            putAvatarInCache(bitmap, url);
        } else {
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LikeConfig$loadAvatarBitmap$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
                    Bitmap bitmap2;
                    Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                    Drawable currDrawable2 = URLDrawable.this.getCurrDrawable();
                    if ((currDrawable2 instanceof RegionDrawable) && (bitmap2 = ((RegionDrawable) currDrawable2).getBitmap()) != null) {
                        this.putAvatarInCache(bitmap2, url);
                    }
                }
            });
            drawable.startDownload(true);
        }
    }

    public final int randomIconIdx() {
        return this.random.nextInt(0, this.iconCount + 1);
    }

    public final void setCombo(@NotNull List<LikeComboConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.combo = list;
    }

    public final void setIconBitmapCache(@NotNull Map<String, Bitmap> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.iconBitmapCache = map;
    }

    public final void setIconCount(int i3) {
        this.iconCount = i3;
    }

    public final void setMaterialID(int i3) {
        this.materialID = i3;
    }

    public final void setNumBitmapCache(@NotNull Map<String, Bitmap> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.numBitmapCache = map;
    }

    public final void setNumImageRes(@NotNull ImageView imageView, int num, int level) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String numPathByLevel = getNumPathByLevel(num, level);
        if (TextUtils.isEmpty(numPathByLevel)) {
            imageView.setImageResource(getNumResId(num, level));
            return;
        }
        if (this.numBitmapCache.get(numPathByLevel) != null) {
            imageView.setImageBitmap(this.numBitmapCache.get(numPathByLevel));
            return;
        }
        if (new File(numPathByLevel).exists()) {
            Map<String, Bitmap> map = this.numBitmapCache;
            Bitmap decodeFile = BitmapFactory.decodeFile(numPathByLevel);
            Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(path)");
            map.put(numPathByLevel, decodeFile);
            imageView.setImageBitmap(this.numBitmapCache.get(numPathByLevel));
            return;
        }
        imageView.setImageResource(getNumResId(num, level));
    }

    public final void setPagFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pagFilePath = str;
    }

    public final void setRandom(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<set-?>");
        this.random = random;
    }

    public final void setRootPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rootPath = str;
    }
}
