package com.tencent.icgame.game.liveroom.impl.room.like;

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
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.utils.k;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0002',B\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\u0019\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J \u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0010\u0010&\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\bR\u001a\u0010+\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u001a\u00101\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010*R\"\u00106\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u00105R\"\u0010:\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010(\u001a\u0004\b8\u0010*\"\u0004\b9\u00105R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010I\u001a\b\u0012\u0004\u0012\u00020C0B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010<\u001a\u0004\bR\u0010>\"\u0004\bS\u0010@R.\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR.\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u001a\u0010_\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001c\u0010<\u001a\u0004\bK\u0010>\u00a8\u0006b"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/c;", "", "", "u", "", BdhLogUtil.LogTag.Tag_Conn, WidgetCacheConstellationData.NUM, "level", "", ReportConstant.COSTREPORT_PREFIX, "iconIdx", "k", "w", "realNum", "r", "t", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", "filename", "reqWidthPx", "reqHeightPx", "g", "", DomainData.DOMAIN_NAME, "l", "Landroid/widget/ImageView;", "imageView", "E", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", HippyTKDListViewAdapter.X, "p", "v", "y", "a", "Ljava/lang/String;", "getPathCombo", "()Ljava/lang/String;", "pathCombo", "b", "getPathFirework", "pathFirework", "c", "getPathIcon", "pathIcon", "d", "getRootPath", "G", "(Ljava/lang/String;)V", "rootPath", "e", "getPagFilePath", UserInfo.SEX_FEMALE, Constants.PAG_FILE_PATH, "f", "I", "getIconCount", "()I", "setIconCount", "(I)V", "iconCount", "", "Lcom/tencent/icgame/game/liveroom/impl/room/like/c$b;", "Ljava/util/List;", "j", "()Ljava/util/List;", "setCombo", "(Ljava/util/List;)V", "combo", "Lkotlin/random/Random;", h.F, "Lkotlin/random/Random;", "getRandom", "()Lkotlin/random/Random;", "setRandom", "(Lkotlin/random/Random;)V", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "materialID", "", "Ljava/util/Map;", "getIconBitmapCache", "()Ljava/util/Map;", "setIconBitmapCache", "(Ljava/util/Map;)V", "iconBitmapCache", "getNumBitmapCache", "setNumBitmapCache", "numBitmapCache", "avatarMaterialId", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final String f115382n = "like.json";

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final c f115383o = new c();

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private static c f115384p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private static Bitmap f115385q;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int materialID;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pathCombo = "combo";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pathFirework = "firework";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pathIcon = "icon";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String rootPath = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilePath = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int iconCount = 1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<b> combo = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Random random = Random.INSTANCE;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Bitmap> iconBitmapCache = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Bitmap> numBitmapCache = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int avatarMaterialId = BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/c$a;", "", "Lcom/tencent/icgame/game/liveroom/impl/room/like/c;", "a", "", "materialID", "", "b", "DEFAULT", "Lcom/tencent/icgame/game/liveroom/impl/room/like/c;", "PRASED", "", "TAG", "Ljava/lang/String;", "configJsonFileName", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.like.c$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/like/c$a$a", "Lqh2/b;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "path", "onLoadSuccess", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.icgame.game.liveroom.impl.room.like.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C5836a implements qh2.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f115398d;

            C5836a(int i3) {
                this.f115398d = i3;
            }

            @Override // qh2.g
            public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
                com.tencent.icgame.game.utils.g.d("LikeConfig", " LikeConfig onLoadFail   res Id" + id5 + " ,errorCode=" + errorCode + ",httpCode=" + httpCode + ",errorMessage=" + errorMessage);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x008e A[Catch: Exception -> 0x00a6, TryCatch #2 {Exception -> 0x00a6, blocks: (B:10:0x006c, B:12:0x0082, B:17:0x008e, B:20:0x009f), top: B:9:0x006c }] */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // qh2.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onLoadSuccess(int id5, @Nullable String path) {
                boolean z16;
                String str = "";
                com.tencent.icgame.game.utils.g.d("LikeConfig", " LikeConfig onLoadSuccess   res Id" + id5 + " ,path=" + path);
                QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(QQGiftResourceBusiness.class);
                String rootPath = qQGiftResourceBusiness.getSavePath(qQGiftResourceBusiness.f(id5, 2));
                File file = new File(rootPath + File.separator + c.f115382n);
                if (file.exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            String readText = TextStreamsKt.readText(new InputStreamReader(fileInputStream, Charsets.UTF_8));
                            CloseableKt.closeFinally(fileInputStream, null);
                            try {
                                Object e16 = com.tencent.mobileqq.jsonconverter.a.e(readText, c.class);
                                Intrinsics.checkNotNullExpressionValue(e16, "convertFromJSONObject(\n \u2026                        )");
                                c cVar = (c) e16;
                                List<b> j3 = cVar.j();
                                if (j3 != null && !j3.isEmpty()) {
                                    z16 = false;
                                    if (z16) {
                                        Intrinsics.checkNotNullExpressionValue(rootPath, "rootPath");
                                        cVar.G(rootPath);
                                        cVar.D(this.f115398d);
                                        if (path == null) {
                                            path = "";
                                        }
                                        cVar.F(path);
                                        c.f115384p = cVar;
                                        return;
                                    }
                                    return;
                                }
                                z16 = true;
                                if (z16) {
                                }
                            } catch (Exception e17) {
                                e = e17;
                                str = readText;
                                com.tencent.icgame.game.utils.g.e("LikeConfig", "parse json Exception! content:" + str, e);
                            }
                        } finally {
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a() {
            if (c.f115384p != null) {
                c cVar = c.f115384p;
                Intrinsics.checkNotNull(cVar);
                return cVar;
            }
            return c.f115383o;
        }

        public final void b(int materialID) {
            if (c.f115384p != null) {
                c cVar = c.f115384p;
                boolean z16 = false;
                if (cVar != null && cVar.getMaterialID() == materialID) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
            }
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId()).b().g(materialID, new C5836a(materialID));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\r\u0010\bR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/like/c$b;", "", "", "a", "I", "c", "()I", "setIndex", "(I)V", "index", "b", "setBegin", "begin", "setEnd", "end", "", "d", UserInfo.SEX_FEMALE, "()F", "setScale", "(F)V", "scale", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int index = 1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int begin = 1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int end = -1;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float scale = 1.0f;

        /* renamed from: a, reason: from getter */
        public final int getBegin() {
            return this.begin;
        }

        /* renamed from: b, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: c, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: d, reason: from getter */
        public final float getScale() {
            return this.scale;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/like/c$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.like.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5837c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f115403d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f115404e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f115405f;

        C5837c(URLDrawable uRLDrawable, c cVar, String str) {
            this.f115403d = uRLDrawable;
            this.f115404e = cVar;
            this.f115405f = str;
        }

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
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Drawable currDrawable = this.f115403d.getCurrDrawable();
            if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
                this.f115404e.z(bitmap, this.f115405f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(c this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Bitmap i3 = this$0.i(bitmap);
        if (i3 != null) {
            f115385q = i3;
        }
    }

    private final boolean C() {
        if (!TextUtils.isEmpty(this.rootPath)) {
            return true;
        }
        return false;
    }

    private final Bitmap g(String filename, int reqWidthPx, int reqHeightPx) {
        rt0.a.INSTANCE.g("ICGameAudience|ICGameLikeConfig", "decodeFromFile", "filename:" + filename + ", reqW:" + reqWidthPx + ", reqH:" + reqHeightPx);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);
        options.inSampleSize = BaseImageUtil.calculateInSampleSize(options, reqWidthPx, reqHeightPx);
        options.inJustDecodeBounds = false;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(filename, options);
            Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(filename, options)");
            return decodeFile;
        } catch (OutOfMemoryError unused) {
            options.inSampleSize *= 2;
            Bitmap decodeFile2 = BitmapFactory.decodeFile(filename, options);
            Intrinsics.checkNotNullExpressionValue(decodeFile2, "decodeFile(filename, options)");
            return decodeFile2;
        }
    }

    private final Bitmap i(Bitmap bitmap) {
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

    private final String k(int iconIdx) {
        String str = this.rootPath;
        String str2 = File.separator;
        return str + str2 + this.pathIcon + str2 + iconIdx + ".png";
    }

    private final String r(int num, int level, int realNum) {
        if (num >= 0) {
            String str = this.rootPath;
            String str2 = File.separator;
            return str + str2 + this.pathCombo + str2 + level + str2 + realNum + ".png";
        }
        String str3 = this.rootPath;
        String str4 = File.separator;
        return str3 + str4 + this.pathCombo + str4 + level + str4 + "x.png";
    }

    private final String s(int num, int level) {
        int i3 = num % 10;
        if (C()) {
            String r16 = r(i3, level, i3 % 10);
            if (new File(r16).exists()) {
                return r16;
            }
            return "";
        }
        return "";
    }

    private final int t(int num, int level) {
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

    private final int u() {
        int nextInt = Random.INSTANCE.nextInt(0, 3);
        if (nextInt != 1) {
            if (nextInt != 2) {
                return R.drawable.o87;
            }
            return R.drawable.o89;
        }
        return R.drawable.o88;
    }

    private final String w(int level) {
        String str = this.rootPath;
        String str2 = File.separator;
        return str + str2 + this.pathFirework + str2 + level + ".pag";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final Bitmap bitmap, String url) {
        k.a(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.like.b
            @Override // java.lang.Runnable
            public final void run() {
                c.A(c.this, bitmap);
            }
        });
    }

    public final int B() {
        return this.random.nextInt(0, this.iconCount + 1);
    }

    public final void D(int i3) {
        this.materialID = i3;
    }

    public final void E(@NotNull ImageView imageView, int num, int level) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        String s16 = s(num, level);
        if (TextUtils.isEmpty(s16)) {
            imageView.setImageResource(t(num, level));
            return;
        }
        if (this.numBitmapCache.get(s16) != null) {
            imageView.setImageBitmap(this.numBitmapCache.get(s16));
            return;
        }
        if (new File(s16).exists()) {
            Map<String, Bitmap> map = this.numBitmapCache;
            Bitmap decodeFile = BitmapFactory.decodeFile(s16);
            Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(path)");
            map.put(s16, decodeFile);
            imageView.setImageBitmap(this.numBitmapCache.get(s16));
            return;
        }
        imageView.setImageResource(t(num, level));
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pagFilePath = str;
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rootPath = str;
    }

    /* renamed from: h, reason: from getter */
    public final int getAvatarMaterialId() {
        return this.avatarMaterialId;
    }

    @NotNull
    public final List<b> j() {
        return this.combo;
    }

    public final int l(int num) {
        boolean z16;
        Object obj;
        boolean z17;
        List<b> list = this.combo;
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
                b bVar = (b) obj;
                if (bVar.getBegin() <= num && (bVar.getEnd() >= num || bVar.getEnd() == -1)) {
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
        b bVar2 = (b) obj;
        if (bVar2 == null) {
            return 1;
        }
        return bVar2.getIndex();
    }

    @Nullable
    public final Bitmap m(int iconIdx, int reqWidthPx, int reqHeightPx) {
        if (iconIdx == this.avatarMaterialId) {
            return f115385q;
        }
        if (C()) {
            String k3 = k(iconIdx);
            if (this.iconBitmapCache.get(k3) != null) {
                return this.iconBitmapCache.get(k3);
            }
            if (new File(k3).exists()) {
                this.iconBitmapCache.put(k3, g(k3, reqWidthPx, reqHeightPx));
                return this.iconBitmapCache.get(k3);
            }
        }
        Drawable b16 = cy0.b.b(u());
        if (b16 instanceof BitmapDrawable) {
            return ((BitmapDrawable) b16).getBitmap();
        }
        if (b16 instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) b16).getBitmap();
        }
        return null;
    }

    public final float n(int level) {
        boolean z16;
        Object obj;
        boolean z17;
        List<b> list = this.combo;
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
                if (((b) obj).getIndex() == level) {
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
        b bVar = (b) obj;
        if (bVar == null) {
            return 1.0f;
        }
        return bVar.getScale();
    }

    @NotNull
    public final String o() {
        if (C() && new File(this.pagFilePath).exists()) {
            return this.pagFilePath;
        }
        return "";
    }

    @NotNull
    public final String p() {
        return "pag/tg_like.pag";
    }

    /* renamed from: q, reason: from getter */
    public final int getMaterialID() {
        return this.materialID;
    }

    @NotNull
    public final String v() {
        return "pag/tg_like_upgrade.pag";
    }

    @NotNull
    public final String x(int level) {
        if (C()) {
            String w3 = w(level);
            if (new File(w3).exists()) {
                return w3;
            }
            return "";
        }
        return "";
    }

    public final void y(@Nullable String url) {
        boolean z16;
        Bitmap bitmap;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || f115385q != null) {
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, com.tencent.icgame.game.utils.c.f116096a.b(uu0.a.b(44), R.drawable.ovu));
        Drawable currDrawable = drawable.getCurrDrawable();
        if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
            z(bitmap, url);
        } else {
            drawable.setURLDrawableListener(new C5837c(drawable, this, url));
            drawable.startDownload(true);
        }
    }
}
