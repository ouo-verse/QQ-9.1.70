package d73;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010%\u001a\u00020\u0011\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\b\b\u0002\u0010,\u001a\u00020\u0011\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00107\u001a\u00020\u0007\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bG\u0010HJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010!\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u0012\u0010\u001c\"\u0004\b \u0010\u001eR\"\u0010%\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\"\u0010,\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b+\u0010\u0017R$\u00102\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010.\u001a\u0004\b&\u0010/\"\u0004\b0\u00101R\"\u00107\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00103\u001a\u0004\b*\u00104\"\u0004\b5\u00106R$\u0010=\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00109\u001a\u0004\b\n\u0010:\"\u0004\b;\u0010<R$\u0010D\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010?\u001a\u0004\b>\u0010A\"\u0004\bE\u0010C\u00a8\u0006I"}, d2 = {"Ld73/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "d", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "p", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", WadlProxyConsts.KEY_MATERIAL, "", "b", "J", "i", "()J", "u", "(J)V", IOnlineStatusService.SONG_ID, "Ld73/b;", "c", "Ld73/b;", "()Ld73/b;", "o", "(Ld73/b;)V", "lyric", DomainData.DOMAIN_NAME, "foreignLyric", "e", "j", "v", "songStartTimeUs", "f", h.F, "t", "songDurationUs", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mediaDurationUs", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "()Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "r", "(Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)V", "referenceSticker", "Z", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "refreshReferenceStickerFromTavCut", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;)V", "editMode", "k", "Ljava/lang/String;", "l", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "templatePath", "w", "templateLyricStyleId", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;JLd73/b;Ld73/b;JJJLcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;ZLcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d73.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class LyricSticker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private MetaMaterial material;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long songId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private b lyric;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private b foreignLyric;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long songStartTimeUs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long songDurationUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long mediaDurationUs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private WinkStickerModel referenceSticker;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean refreshReferenceStickerFromTavCut;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private WinkEditorViewModel.EditMode editMode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String templatePath;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String templateLyricStyleId;

    public LyricSticker() {
        this(null, 0L, null, null, 0L, 0L, 0L, null, false, null, null, null, 4095, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final WinkEditorViewModel.EditMode getEditMode() {
        return this.editMode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final b getForeignLyric() {
        return this.foreignLyric;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final b getLyric() {
        return this.lyric;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    /* renamed from: e, reason: from getter */
    public final long getMediaDurationUs() {
        return this.mediaDurationUs;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LyricSticker)) {
            return false;
        }
        LyricSticker lyricSticker = (LyricSticker) other;
        if (Intrinsics.areEqual(this.material, lyricSticker.material) && this.songId == lyricSticker.songId && Intrinsics.areEqual(this.lyric, lyricSticker.lyric) && Intrinsics.areEqual(this.foreignLyric, lyricSticker.foreignLyric) && this.songStartTimeUs == lyricSticker.songStartTimeUs && this.songDurationUs == lyricSticker.songDurationUs && this.mediaDurationUs == lyricSticker.mediaDurationUs && Intrinsics.areEqual(this.referenceSticker, lyricSticker.referenceSticker) && this.refreshReferenceStickerFromTavCut == lyricSticker.refreshReferenceStickerFromTavCut && this.editMode == lyricSticker.editMode && Intrinsics.areEqual(this.templatePath, lyricSticker.templatePath) && Intrinsics.areEqual(this.templateLyricStyleId, lyricSticker.templateLyricStyleId)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final WinkStickerModel getReferenceSticker() {
        return this.referenceSticker;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getRefreshReferenceStickerFromTavCut() {
        return this.refreshReferenceStickerFromTavCut;
    }

    /* renamed from: h, reason: from getter */
    public final long getSongDurationUs() {
        return this.songDurationUs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        MetaMaterial metaMaterial = this.material;
        int i3 = 0;
        if (metaMaterial == null) {
            hashCode = 0;
        } else {
            hashCode = metaMaterial.hashCode();
        }
        int a16 = ((hashCode * 31) + androidx.fragment.app.a.a(this.songId)) * 31;
        b bVar = this.lyric;
        if (bVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bVar.hashCode();
        }
        int i16 = (a16 + hashCode2) * 31;
        b bVar2 = this.foreignLyric;
        if (bVar2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bVar2.hashCode();
        }
        int a17 = (((((((i16 + hashCode3) * 31) + androidx.fragment.app.a.a(this.songStartTimeUs)) * 31) + androidx.fragment.app.a.a(this.songDurationUs)) * 31) + androidx.fragment.app.a.a(this.mediaDurationUs)) * 31;
        WinkStickerModel winkStickerModel = this.referenceSticker;
        if (winkStickerModel == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = winkStickerModel.hashCode();
        }
        int i17 = (a17 + hashCode4) * 31;
        boolean z16 = this.refreshReferenceStickerFromTavCut;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        WinkEditorViewModel.EditMode editMode = this.editMode;
        if (editMode == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = editMode.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str = this.templatePath;
        if (str == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str2 = this.templateLyricStyleId;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i27 + i3;
    }

    /* renamed from: i, reason: from getter */
    public final long getSongId() {
        return this.songId;
    }

    /* renamed from: j, reason: from getter */
    public final long getSongStartTimeUs() {
        return this.songStartTimeUs;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getTemplateLyricStyleId() {
        return this.templateLyricStyleId;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getTemplatePath() {
        return this.templatePath;
    }

    public final void m(@Nullable WinkEditorViewModel.EditMode editMode) {
        this.editMode = editMode;
    }

    public final void n(@Nullable b bVar) {
        this.foreignLyric = bVar;
    }

    public final void o(@Nullable b bVar) {
        this.lyric = bVar;
    }

    public final void p(@Nullable MetaMaterial metaMaterial) {
        this.material = metaMaterial;
    }

    public final void q(long j3) {
        this.mediaDurationUs = j3;
    }

    public final void r(@Nullable WinkStickerModel winkStickerModel) {
        this.referenceSticker = winkStickerModel;
    }

    public final void s(boolean z16) {
        this.refreshReferenceStickerFromTavCut = z16;
    }

    public final void t(long j3) {
        this.songDurationUs = j3;
    }

    @NotNull
    public String toString() {
        return "LyricSticker(material=" + this.material + ", songId=" + this.songId + ", lyric=" + this.lyric + ", foreignLyric=" + this.foreignLyric + ", songStartTimeUs=" + this.songStartTimeUs + ", songDurationUs=" + this.songDurationUs + ", mediaDurationUs=" + this.mediaDurationUs + ", referenceSticker=" + this.referenceSticker + ", refreshReferenceStickerFromTavCut=" + this.refreshReferenceStickerFromTavCut + ", editMode=" + this.editMode + ", templatePath=" + this.templatePath + ", templateLyricStyleId=" + this.templateLyricStyleId + ")";
    }

    public final void u(long j3) {
        this.songId = j3;
    }

    public final void v(long j3) {
        this.songStartTimeUs = j3;
    }

    public final void w(@Nullable String str) {
        this.templateLyricStyleId = str;
    }

    public final void x(@Nullable String str) {
        this.templatePath = str;
    }

    public LyricSticker(@Nullable MetaMaterial metaMaterial, long j3, @Nullable b bVar, @Nullable b bVar2, long j16, long j17, long j18, @Nullable WinkStickerModel winkStickerModel, boolean z16, @Nullable WinkEditorViewModel.EditMode editMode, @Nullable String str, @Nullable String str2) {
        this.material = metaMaterial;
        this.songId = j3;
        this.lyric = bVar;
        this.foreignLyric = bVar2;
        this.songStartTimeUs = j16;
        this.songDurationUs = j17;
        this.mediaDurationUs = j18;
        this.referenceSticker = winkStickerModel;
        this.refreshReferenceStickerFromTavCut = z16;
        this.editMode = editMode;
        this.templatePath = str;
        this.templateLyricStyleId = str2;
    }

    public /* synthetic */ LyricSticker(MetaMaterial metaMaterial, long j3, b bVar, b bVar2, long j16, long j17, long j18, WinkStickerModel winkStickerModel, boolean z16, WinkEditorViewModel.EditMode editMode, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : metaMaterial, (i3 & 2) != 0 ? -1L : j3, (i3 & 4) != 0 ? null : bVar, (i3 & 8) != 0 ? null : bVar2, (i3 & 16) != 0 ? 0L : j16, (i3 & 32) != 0 ? 0L : j17, (i3 & 64) == 0 ? j18 : 0L, (i3 & 128) != 0 ? null : winkStickerModel, (i3 & 256) != 0 ? false : z16, (i3 & 512) != 0 ? WinkEditorViewModel.EditMode.Video : editMode, (i3 & 1024) != 0 ? null : str, (i3 & 2048) != 0 ? null : str2);
    }
}
