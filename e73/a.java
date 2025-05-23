package e73;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import d73.LyricSticker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0010"}, d2 = {"Le73/a;", "", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutDelegate", "Ld73/d;", "lyricSticker", "", "startOffsetTimeUs", "", "b", "tavCut", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f395827a = new a();

    a() {
    }

    @NotNull
    public final List<WinkStickerModel> a(@Nullable dr tavCut) {
        List<WinkStickerModel> emptyList;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        if (tavCut == null || (m3 = tavCut.m()) == null || (values = m3.values()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((WinkStickerModel) obj).isLyricSticker()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void b(@Nullable dr tavCutDelegate, @NotNull LyricSticker lyricSticker, long startOffsetTimeUs) {
        Object first;
        Intrinsics.checkNotNullParameter(lyricSticker, "lyricSticker");
        long currentTimeMillis = System.currentTimeMillis();
        w53.b.a("wink_sticker_lyric", "updateLyricStickers begin");
        if (tavCutDelegate != null && (tavCutDelegate instanceof WinkVideoTavCut)) {
            List<WinkStickerModel> a16 = f395827a.a(tavCutDelegate);
            if (lyricSticker.getRefreshReferenceStickerFromTavCut()) {
                lyricSticker.s(false);
                if (!a16.isEmpty()) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) a16);
                    lyricSticker.r(((WinkStickerModel) first).copy());
                }
            }
            tavCutDelegate.T(a16);
            if (lyricSticker.getMaterial() != null) {
                WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) tavCutDelegate;
                tavCutDelegate.W(b.f395828a.b(winkVideoTavCut, lyricSticker, startOffsetTimeUs));
                l73.a aVar = l73.a.f413927a;
                MetaMaterial material = lyricSticker.getMaterial();
                Intrinsics.checkNotNull(material);
                if (aVar.l(material)) {
                    winkVideoTavCut.getSession().notifyReloadAsset();
                }
            }
        }
        w53.b.a("wink_sticker_lyric", "updateLyricStickers begin end, cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
