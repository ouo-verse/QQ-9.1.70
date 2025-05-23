package com.tencent.mobileqq.vas.pendant.drawable.api;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantSticker;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IDiyPendantDrawable;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.LoadFinishCallback;
import com.tencent.util.LRULinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 ;2\u00020\u0001:\u0001;J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH&J(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&JX\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H&J$\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH&J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0%H&J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0%H&J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170(H&J\u0014\u0010)\u001a\u0004\u0018\u00010\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130,H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130,H&J\u0012\u0010.\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0013H&J*\u00101\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0006H&J\u0012\u00105\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0013H&J\u001a\u00106\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u00020\rH&J\u0012\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010:H&\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/api/IDiyPendantFetcher;", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "decodeOrDownloadPaster", "fetchDiyBaseInfo", "", "Lcom/tencent/mobileqq/vas/pendant/drawable/bean/DiyPendantSticker;", "drawable", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IDiyPendantDrawable;", "fetchDiyPaster", "Landroid/graphics/Bitmap;", "index", "", "fetchDiyPendant", "Lcom/tencent/mobileqq/vas/pendant/drawable/bean/DiyPendantEntity;", "app", "Lcom/tencent/common/app/AppInterface;", "uinAndDiyId", "", "observer", "Lcom/tencent/mobileqq/app/BusinessObserver;", "fetchTextBitmap", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/Invalidatable;", "text", MessageForRichState.SIGN_MSG_FONT_ID, MessageForRichState.SIGN_MSG_FONT_TYPE, "fontSize", "", "fontColor", "width", "height", "paint", "Landroid/graphics/Paint;", "fetchTextTypeface", "Landroid/graphics/Typeface;", "getDiyFontBitmapCache", "Lcom/tencent/util/LRULinkedHashMap;", "getDiyPendantCache", "getNotRefreshAIODrawables", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getStickerKey", "sticker", "getUnCacheDiyId", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getUnCachePasterId", "loadPendantDiyAsync", "notifyFontDownloadComplete", "key", "notifyLoadFinish", "insert", "", "diyEntityList", "notifyPasterDownloadComplete", "postLoadPendantDiy", "delay", "setLoadFinishCallback", "callback", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/LoadFinishCallback;", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IDiyPendantFetcher {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String DIY_PENDANT_CMD = "ReadDiyAddonInfo.1";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/api/IDiyPendantFetcher$Companion;", "", "()V", "DIY_PENDANT_CMD", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String DIY_PENDANT_CMD = "ReadDiyAddonInfo.1";

        Companion() {
        }
    }

    void clearCache();

    void decodeOrDownloadPaster();

    @Nullable
    List<DiyPendantSticker> fetchDiyBaseInfo(@NotNull IDiyPendantDrawable drawable);

    @Nullable
    Bitmap fetchDiyPaster(@Nullable IDiyPendantDrawable drawable, int index);

    @Nullable
    DiyPendantEntity fetchDiyPendant(@Nullable AppInterface app, @Nullable String uinAndDiyId, @Nullable BusinessObserver observer);

    @Nullable
    Bitmap fetchTextBitmap(@Nullable Invalidatable drawable, @Nullable String text, int fontId, int fontType, float fontSize, int fontColor, int width, int height, @Nullable Paint paint);

    @Nullable
    Typeface fetchTextTypeface(@Nullable Invalidatable drawable, int fontId, int fontType);

    @NotNull
    LRULinkedHashMap<String, Bitmap> getDiyFontBitmapCache();

    @NotNull
    LRULinkedHashMap<String, DiyPendantEntity> getDiyPendantCache();

    @NotNull
    CopyOnWriteArrayList<Invalidatable> getNotRefreshAIODrawables();

    @Nullable
    String getStickerKey(@Nullable DiyPendantSticker sticker);

    @NotNull
    CopyOnWriteArraySet<String> getUnCacheDiyId();

    @NotNull
    CopyOnWriteArraySet<String> getUnCachePasterId();

    void loadPendantDiyAsync(@Nullable AppInterface app);

    void notifyFontDownloadComplete(@Nullable String key);

    void notifyLoadFinish(@Nullable AppInterface app, boolean insert, @Nullable List<? extends DiyPendantEntity> diyEntityList);

    void notifyPasterDownloadComplete(@Nullable String key);

    void postLoadPendantDiy(@Nullable AppInterface app, int delay);

    void setLoadFinishCallback(@Nullable LoadFinishCallback callback);
}
