package com.tencent.mobileqq.wink.editor.music.lyric.sticker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.music.lyric.sticker.z;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import d73.LyricSticker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 z2\u00020\u0001:\u0002{|B\u0007\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\b\u0010\u0013\u001a\u00020\u0012H\u0016J:\u0010\u0019\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 J\u0010\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#J\u0006\u0010&\u001a\u00020\u0002J\u0010\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'J\u0006\u0010*\u001a\u00020\u0002J\u0016\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-J\u0016\u00100\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020-J\u0016\u00102\u001a\u00020\u00022\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010J\u0006\u00103\u001a\u00020\u0002R%\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010@\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010G\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001f\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H048\u0006\u00a2\u0006\f\n\u0004\bI\u00106\u001a\u0004\bJ\u00108R\u001c\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u00106R\u001f\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0N8\u0006\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020+048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u00106R\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020+0N8\u0006\u00a2\u0006\f\n\u0004\bV\u0010P\u001a\u0004\bW\u0010RR\u0016\u0010[\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010ZR*\u0010f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010.\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR$\u0010q\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010;\u001a\u0004\bo\u0010=\"\u0004\bp\u0010?R\u0017\u0010w\u001a\u00020r8\u0006\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "m2", "S1", "T1", "Ld73/b;", "lyricString", "", "d2", "updateStickers", "x2", "isShown", "t2", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "X1", "", "Z1", "", "getLogTag", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "referenceSticker", "refreshReferenceStickerFromTavCut", "forceUpdate", "f2", "", "durationUs", "l2", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfoWrapper", "j2", "Lcom/tencent/mobileqq/wink/editor/template/x$b;", "updateTemplateAction", "k2", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "mode", "e2", "r2", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCut", "i2", SemanticAttributes.DbSystemValues.H2, "Ld73/d;", "draftLyricSticker", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "applyMaterialTask", "o2", "Q1", "materialList", "w2", "U1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "c2", "()Landroidx/lifecycle/MutableLiveData;", "winkLyricStickerInfoList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getCachedMetaMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setCachedMetaMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "cachedMetaMaterial", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "getCachedReferenceStickerModel", "()Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "setCachedReferenceStickerModel", "(Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;)V", "cachedReferenceStickerModel", "", "D", "b2", "lyricStyleStickerState", "E", "_currentMetaMaterialLiveData", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "currentMetaMaterial", "G", "_lyricStickerLiveData", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "lyricStickerLiveData", "I", "Ld73/d;", "lyricSticker", "J", "Z", "hasMusicChanged", "K", "L", "Ljava/util/List;", "getAllLyricMetaMaterialList", "()Ljava/util/List;", "setAllLyricMetaMaterialList", "(Ljava/util/List;)V", "allLyricMetaMaterialList", "Lcom/tencent/mobileqq/wink/flow/a;", "M", "Lcom/tencent/mobileqq/wink/flow/a;", "getApplyMaterialTask", "()Lcom/tencent/mobileqq/wink/flow/a;", "u2", "(Lcom/tencent/mobileqq/wink/flow/a;)V", "N", "getMDefaultEmptyMetaMaterial", "v2", "mDefaultEmptyMetaMaterial", "Ljava/lang/Runnable;", "P", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "runnable", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class z extends BaseViewModel {

    /* renamed from: Q */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C */
    @Nullable
    private WinkStickerModel cachedReferenceStickerModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaMaterial> _currentMetaMaterialLiveData;

    /* renamed from: F */
    @NotNull
    private final LiveData<MetaMaterial> currentMetaMaterial;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LyricSticker> _lyricStickerLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<LyricSticker> lyricStickerLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private LyricSticker lyricSticker;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hasMusicChanged;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LyricSticker draftLyricSticker;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private List<MetaMaterial> allLyricMetaMaterialList;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.flow.a applyMaterialTask;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial mDefaultEmptyMetaMaterial;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* renamed from: m */
    @Nullable
    private MetaMaterial cachedMetaMaterial;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MetaMaterial>> winkLyricStickerInfoList = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> lyricStyleStickerState = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z$a;", "", "", "LYRIC_STYLE_ID", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.lyric.sticker.z$a */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z$b;", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b extends ApplyMaterialTask.a {
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f321005a;

        static {
            int[] iArr = new int[ApplyMaterialTask.Status.values().length];
            try {
                iArr[ApplyMaterialTask.Status.ONGOING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApplyMaterialTask.Status.SUCCEEDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f321005a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/music/lyric/sticker/z$d", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z$b;", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", "status", "", "progress", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements b {

        /* renamed from: a */
        final /* synthetic */ ApplyMaterialTask f321006a;

        /* renamed from: b */
        final /* synthetic */ MetaMaterial f321007b;

        d(ApplyMaterialTask applyMaterialTask, MetaMaterial metaMaterial) {
            this.f321006a = applyMaterialTask;
            this.f321007b = metaMaterial;
        }

        public static final void c(ApplyMaterialTask.Status status, ApplyMaterialTask applyMaterialTask, MetaMaterial material) {
            Intrinsics.checkNotNullParameter(status, "$status");
            Intrinsics.checkNotNullParameter(applyMaterialTask, "$applyMaterialTask");
            Intrinsics.checkNotNullParameter(material, "$material");
            if (status != ApplyMaterialTask.Status.FAILED && status == ApplyMaterialTask.Status.SUCCEEDED) {
                applyMaterialTask.g(-1, material);
                com.tencent.mobileqq.wink.editor.c.s1(material, 100);
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
        public void a(@NotNull final ApplyMaterialTask.Status status, int progress) {
            Intrinsics.checkNotNullParameter(status, "status");
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final ApplyMaterialTask applyMaterialTask = this.f321006a;
            final MetaMaterial metaMaterial = this.f321007b;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.aa
                @Override // java.lang.Runnable
                public final void run() {
                    z.d.c(ApplyMaterialTask.Status.this, applyMaterialTask, metaMaterial);
                }
            });
        }
    }

    public z() {
        MutableLiveData<MetaMaterial> mutableLiveData = new MutableLiveData<>();
        this._currentMetaMaterialLiveData = mutableLiveData;
        this.currentMetaMaterial = mutableLiveData;
        MutableLiveData<LyricSticker> mutableLiveData2 = new MutableLiveData<>();
        this._lyricStickerLiveData = mutableLiveData2;
        this.lyricStickerLiveData = mutableLiveData2;
        this.lyricSticker = new LyricSticker(null, 0L, null, null, 0L, 0L, 0L, null, false, null, null, null, 4095, null);
        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.u
            @Override // java.lang.Runnable
            public final void run() {
                z.s2(z.this);
            }
        };
    }

    public static final void R1(MetaMaterial material, ApplyMaterialTask applyMaterialTask, ApplyMaterialTask.Status status, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(applyMaterialTask, "$applyMaterialTask");
        if (status == null) {
            i16 = -1;
        } else {
            i16 = c.f321005a[status.ordinal()];
        }
        if (i16 != 1) {
            if (i16 == 2) {
                applyMaterialTask.F1(ApplyMaterialTask.Status.SUCCEEDED, -1, material, new d(applyMaterialTask, material));
                return;
            }
            return;
        }
        com.tencent.mobileqq.wink.editor.c.s1(material, i3);
    }

    private final void S1() {
        String str;
        boolean z16;
        this.lyricSticker.u(0L);
        this.lyricSticker.o(null);
        this.lyricSticker.n(null);
        this.lyricSticker.t(0L);
        this.lyricSticker.v(0L);
        String templatePath = this.lyricSticker.getTemplatePath();
        if (templatePath != null) {
            LyricSticker lyricSticker = this.lyricSticker;
            Long FAKE_TEMPLATE_SONG_ID = WinkEditorMusicInfo.H;
            Intrinsics.checkNotNullExpressionValue(FAKE_TEMPLATE_SONG_ID, "FAKE_TEMPLATE_SONG_ID");
            lyricSticker.u(FAKE_TEMPLATE_SONG_ID.longValue());
            e73.c.f395829a.d(templatePath, this.lyricSticker);
            if (this.lyricSticker.getLyric() == null && this.lyricSticker.getForeignLyric() == null) {
                x2(true);
                return;
            }
            String templateLyricStyleId = this.lyricSticker.getTemplateLyricStyleId();
            MetaMaterial material = this.lyricSticker.getMaterial();
            if (material != null) {
                str = material.f30533id;
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(templateLyricStyleId, str)) {
                MetaMaterial material2 = this.lyricSticker.getMaterial();
                if (material2 != null && com.tencent.mobileqq.wink.editor.sticker.m.R(material2)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    U1();
                    return;
                }
            }
            y2(this, false, 1, null);
        }
    }

    private final void T1() {
        d73.b lyric = this.lyricSticker.getLyric();
        MetaMaterial material = this.lyricSticker.getMaterial();
        int i3 = 2;
        if (this.lyricSticker.getEditMode() == WinkEditorViewModel.EditMode.Video && d2(lyric)) {
            i3 = (material == null || Intrinsics.areEqual(material.f30533id, "no_lyrics")) ? 3 : 1;
        }
        this.lyricStyleStickerState.postValue(Integer.valueOf(i3));
    }

    private final boolean d2(d73.b lyricString) {
        ArrayList<d73.e> arrayList;
        if (lyricString != null) {
            arrayList = lyricString.f393162b;
        } else {
            arrayList = null;
        }
        if (arrayList == null || lyricString.f393162b.size() <= 1) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void g2(z zVar, MetaMaterial metaMaterial, WinkStickerModel winkStickerModel, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        boolean z19;
        boolean z26;
        if ((i3 & 2) != 0) {
            winkStickerModel = null;
        }
        WinkStickerModel winkStickerModel2 = winkStickerModel;
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        boolean z27 = z16;
        if ((i3 & 8) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i3 & 16) != 0) {
            z26 = false;
        } else {
            z26 = z18;
        }
        zVar.f2(metaMaterial, winkStickerModel2, z27, z19, z26);
    }

    private final void m2() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.y
            @Override // java.lang.Runnable
            public final void run() {
                z.n2(z.this);
            }
        });
    }

    public static final void n2(z this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S1();
        this$0.T1();
    }

    public static final void p2(MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "$material");
        com.tencent.mobileqq.wink.editor.sticker.l.M(material, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.w
            @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
            public final void a(ApplyMaterialTask.Status status, int i3) {
                z.q2(status, i3);
            }
        });
    }

    public static final void q2(ApplyMaterialTask.Status status, int i3) {
        Intrinsics.checkNotNullParameter(status, "<anonymous parameter 0>");
    }

    public static final void s2(z this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._lyricStickerLiveData.postValue(this$0.lyricSticker);
    }

    private final void t2(boolean isShown) {
        int i3;
        if (isShown) {
            i3 = 13;
        } else {
            i3 = 14;
        }
        SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(i3, 102));
    }

    private final void x2(boolean updateStickers) {
        if (this.hasMusicChanged && updateStickers && this.lyricSticker.getMediaDurationUs() > 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runnable);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.runnable, 300L);
        }
        T1();
    }

    static /* synthetic */ void y2(z zVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        zVar.x2(z16);
    }

    public final void Q1(@NotNull final MetaMaterial r26, @NotNull final ApplyMaterialTask applyMaterialTask) {
        Intrinsics.checkNotNullParameter(r26, "material");
        Intrinsics.checkNotNullParameter(applyMaterialTask, "applyMaterialTask");
        com.tencent.mobileqq.wink.flow.c.d(r26, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.x
            @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
            public final void a(ApplyMaterialTask.Status status, int i3) {
                z.R1(MetaMaterial.this, applyMaterialTask, status, i3);
            }
        });
    }

    public final void U1() {
        boolean z16;
        String templateLyricStyleId = this.lyricSticker.getTemplateLyricStyleId();
        if (templateLyricStyleId != null) {
            if (templateLyricStyleId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            w53.b.a("wink_sticker_lyric", "begin download lyricStyleId " + templateLyricStyleId);
            List<MetaMaterial> list = this.allLyricMetaMaterialList;
            if (list != null) {
                for (MetaMaterial metaMaterial : list) {
                    if (Intrinsics.areEqual(templateLyricStyleId, metaMaterial.f30533id)) {
                        w53.b.a("wink_sticker_lyric", "find lyricStyleId " + templateLyricStyleId + " material");
                        com.tencent.mobileqq.wink.flow.a aVar = this.applyMaterialTask;
                        if (aVar != null) {
                            Q1(metaMaterial, aVar);
                        }
                    }
                }
            }
        }
    }

    @NotNull
    public final LiveData<MetaMaterial> W1() {
        return this.currentMetaMaterial;
    }

    @Nullable
    public final MetaMaterial X1() {
        return this.lyricSticker.getMaterial();
    }

    @NotNull
    public final List<MetaMaterial> Z1() {
        if (this.winkLyricStickerInfoList.getValue() == null) {
            return new ArrayList();
        }
        List<MetaMaterial> value = this.winkLyricStickerInfoList.getValue();
        Intrinsics.checkNotNull(value);
        return value;
    }

    @NotNull
    public final LiveData<LyricSticker> a2() {
        return this.lyricStickerLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> b2() {
        return this.lyricStyleStickerState;
    }

    @NotNull
    public final MutableLiveData<List<MetaMaterial>> c2() {
        return this.winkLyricStickerInfoList;
    }

    public final void e2(@Nullable WinkEditorViewModel.EditMode mode) {
        if (this.lyricSticker.getEditMode() == mode) {
            return;
        }
        this.lyricSticker.m(mode);
        this.lyricSticker.s(true);
        y2(this, false, 1, null);
    }

    public final void f2(@Nullable MetaMaterial r46, @Nullable WinkStickerModel referenceSticker, boolean updateStickers, boolean refreshReferenceStickerFromTavCut, boolean forceUpdate) {
        String str;
        boolean z16;
        if (r46 != null) {
            str = r46.f30533id;
        } else {
            str = null;
        }
        w53.b.a("wink_sticker_lyric", "--- onMaterialChanged " + str);
        this._currentMetaMaterialLiveData.postValue(r46);
        if (Intrinsics.areEqual(this.lyricSticker.getMaterial(), r46)) {
            String templateLyricStyleId = this.lyricSticker.getTemplateLyricStyleId();
            if (templateLyricStyleId != null && templateLyricStyleId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 && !forceUpdate) {
                return;
            }
        }
        this.lyricSticker.p(r46);
        this.lyricSticker.r(referenceSticker);
        this.lyricSticker.s(refreshReferenceStickerFromTavCut);
        x2(updateStickers);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "wink_sticker_lyric";
    }

    public final void h2() {
        t2(false);
        this.cachedMetaMaterial = null;
        this.cachedReferenceStickerModel = null;
    }

    public final void i2(@Nullable dr tavCut) {
        Object firstOrNull;
        t2(true);
        this.cachedMetaMaterial = X1();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) e73.a.f395827a.a(tavCut));
        this.cachedReferenceStickerModel = (WinkStickerModel) firstOrNull;
    }

    public final void j2(@Nullable MusicInfoWrapper musicInfoWrapper) {
        boolean z16;
        long j3;
        String str;
        String str2;
        String str3;
        String g16;
        this.hasMusicChanged = true;
        if (musicInfoWrapper != null) {
            w53.b.a("wink_sticker_lyric", "--- onMusicChange thread " + Thread.currentThread() + " " + musicInfoWrapper + " ");
            if (com.tencent.mobileqq.wink.editor.smartclip.a.a(musicInfoWrapper)) {
                m2();
                return;
            }
            WinkEditorMusicInfo musicInfo = musicInfoWrapper.getMusicInfo();
            if (musicInfo != null && this.lyricSticker.getSongId() == musicInfo.o()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || this.lyricSticker.getSongStartTimeUs() != musicInfoWrapper.getStartTime() * 1000) {
                LyricSticker lyricSticker = this.lyricSticker;
                WinkEditorMusicInfo musicInfo2 = musicInfoWrapper.getMusicInfo();
                if (musicInfo2 != null) {
                    j3 = musicInfo2.o();
                } else {
                    j3 = -1;
                }
                lyricSticker.u(j3);
                LyricSticker lyricSticker2 = this.lyricSticker;
                WinkEditorMusicInfo musicInfo3 = musicInfoWrapper.getMusicInfo();
                if (musicInfo3 != null) {
                    str = musicInfo3.k();
                } else {
                    str = null;
                }
                WinkEditorMusicInfo musicInfo4 = musicInfoWrapper.getMusicInfo();
                String str4 = LyricParseHelper.LYRIC_FROMAT_LRC;
                if (musicInfo4 == null || (str2 = musicInfo4.l()) == null) {
                    str2 = LyricParseHelper.LYRIC_FROMAT_LRC;
                }
                lyricSticker2.o(com.tencent.mobileqq.wink.editor.music.lyric.a.a(str, str2));
                LyricSticker lyricSticker3 = this.lyricSticker;
                WinkEditorMusicInfo musicInfo5 = musicInfoWrapper.getMusicInfo();
                if (musicInfo5 != null) {
                    str3 = musicInfo5.f();
                } else {
                    str3 = null;
                }
                WinkEditorMusicInfo musicInfo6 = musicInfoWrapper.getMusicInfo();
                if (musicInfo6 != null && (g16 = musicInfo6.g()) != null) {
                    str4 = g16;
                }
                lyricSticker3.n(com.tencent.mobileqq.wink.editor.music.lyric.a.a(str3, str4));
                this.lyricSticker.v(musicInfoWrapper.getStartTime() * 1000);
                this.lyricSticker.s(true);
                if (musicInfoWrapper.getMusicInfo() != null) {
                    this.lyricSticker.t(r10.n() * 1000);
                }
                y2(this, false, 1, null);
            }
        }
    }

    public final void k2(@Nullable x.UpdateTemplateAction updateTemplateAction) {
        String str;
        boolean z16;
        String str2;
        MetaMaterial metaMaterial;
        String str3 = null;
        if (updateTemplateAction != null) {
            str = updateTemplateAction.getTemplatePath();
        } else {
            str = null;
        }
        boolean z17 = true;
        if (str != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.a("wink_sticker_lyric", "--- onTemplateChanged hasTemplate " + z16);
        LyricSticker lyricSticker = this.lyricSticker;
        if (updateTemplateAction != null) {
            str2 = updateTemplateAction.getTemplatePath();
        } else {
            str2 = null;
        }
        lyricSticker.x(str2);
        LyricSticker lyricSticker2 = this.lyricSticker;
        if (updateTemplateAction != null && (metaMaterial = updateTemplateAction.getMetaMaterial()) != null) {
            str3 = com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "lyricStyleId");
        }
        lyricSticker2.w(str3);
        String templatePath = this.lyricSticker.getTemplatePath();
        if (templatePath != null && templatePath.length() != 0) {
            z17 = false;
        }
        if (z17) {
            g2(this, this.mDefaultEmptyMetaMaterial, null, false, false, false, 30, null);
        }
    }

    public final void l2(long durationUs) {
        w53.b.a("wink_sticker_lyric", "--- onDurationChanged " + durationUs);
        if (durationUs > 0 && this.lyricSticker.getMediaDurationUs() != durationUs) {
            this.lyricSticker.q(durationUs);
            this.lyricSticker.s(true);
            y2(this, false, 1, null);
        }
    }

    public final void o2(@NotNull LyricSticker draftLyricSticker, @NotNull ApplyMaterialTask applyMaterialTask) {
        Intrinsics.checkNotNullParameter(draftLyricSticker, "draftLyricSticker");
        Intrinsics.checkNotNullParameter(applyMaterialTask, "applyMaterialTask");
        this.lyricSticker.x(draftLyricSticker.getTemplatePath());
        this.lyricSticker.w(draftLyricSticker.getTemplateLyricStyleId());
        this.lyricSticker.p(draftLyricSticker.getMaterial());
        MetaMaterial material = this.lyricSticker.getMaterial();
        if (material != null) {
            com.tencent.mobileqq.wink.editor.sticker.m.A0(material, true);
        }
        this.lyricSticker.q(draftLyricSticker.getMediaDurationUs());
        this.lyricSticker.t(draftLyricSticker.getSongDurationUs());
        this.lyricSticker.v(draftLyricSticker.getSongStartTimeUs());
        this.draftLyricSticker = draftLyricSticker;
        final MetaMaterial material2 = draftLyricSticker.getMaterial();
        if (material2 != null) {
            j73.a.f409615a.a(material2);
            g2(this, material2, null, false, true, false, 16, null);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.v
                @Override // java.lang.Runnable
                public final void run() {
                    z.p2(MetaMaterial.this);
                }
            }, 128, null, true);
        }
    }

    public final void r2() {
        this.lyricSticker.r(this.cachedReferenceStickerModel);
        g2(this, this.cachedMetaMaterial, this.cachedReferenceStickerModel, false, false, true, 12, null);
    }

    public final void u2(@Nullable com.tencent.mobileqq.wink.flow.a aVar) {
        this.applyMaterialTask = aVar;
    }

    public final void v2(@Nullable MetaMaterial metaMaterial) {
        this.mDefaultEmptyMetaMaterial = metaMaterial;
    }

    public final void w2(@Nullable List<MetaMaterial> materialList) {
        w53.b.a("wink_sticker_lyric", "material list refreshed");
        this.allLyricMetaMaterialList = materialList;
        if (this.draftLyricSticker == null) {
            U1();
        }
    }
}
