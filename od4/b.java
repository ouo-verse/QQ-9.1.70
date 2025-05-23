package od4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.constants.Constants;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.LightAssetModel;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.render.builder.light.c;
import com.tencent.tavcut.render.parser.PagEffectParser;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.session.TavCutSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.FontAsset;
import org.light.LightAsset;
import qd4.DynamicSoConfig;
import tl.h;
import xd4.d;
import xd4.f;
import zd4.e;
import zd4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010KJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\b\u0010\u0011\u001a\u00020\u000fH\u0007J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0010\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010&\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0012J*\u0010,\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\fH\u0007J0\u0010-\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00042\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\fJ\u0006\u0010/\u001a\u00020.J\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u000202J\u0006\u00105\u001a\u000204J\u0016\u00109\u001a\u0002082\u0006\u00107\u001a\u0002062\u0006\u0010(\u001a\u00020'J\u0010\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010:\u001a\u00020\u0004J \u0010?\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010\u00122\f\u0010>\u001a\b\u0012\u0004\u0012\u0002060\fJ\u0011\u0010@\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b@\u0010AR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010BR$\u0010\u0006\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b-\u0010D\u001a\u0004\bE\u0010FR$\u0010\u0007\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b,\u0010D\u001a\u0004\bG\u0010FR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bH\u0010D\u001a\u0004\bI\u0010F\u00a8\u0006L"}, d2 = {"Lod4/b;", "", "Landroid/content/Context;", "context", "", "licencePath", "appId", "appEntry", "", ReportConstant.COSTREPORT_PREFIX, "assetPath", "t", "", "Lqd4/a;", "dynamicSoConfigs", "", "y", "u", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "templateDir", "B", "a", "Lcom/tencent/tavcut/session/a;", h.F, "jsonFilePath", "Lcom/tencent/tavcut/model/LightAssetModel;", "w", "agent", "path", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "v", "Landroid/widget/FrameLayout;", "playerContainer", "Lcom/tencent/tavcut/render/player/IPlayer;", "g", "Lce4/b;", "f", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", "Lfe4/a;", "renderNodes", "Lbe4/b;", "c", "b", "Lxd4/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxd4/f;", "p", "Lxd4/e;", DomainData.DOMAIN_NAME, "Lxd4/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/tavcut/model/ClipSource;", "clipSource", "Lhe4/a;", "i", "filePath", "Lcom/tencent/tavcut/model/PagEffectData;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, TtmlNode.ATTR_TTS_ORIGIN, "clipAssets", "j", "o", "()Landroid/content/Context;", "Landroid/content/Context;", "<set-?>", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "k", "d", "r", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: from kotlin metadata */
    private static Context context;

    /* renamed from: e */
    public static final b f422509e = new b();

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static String appId = "";

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static String appEntry = "";

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private static String licencePath = "";

    b() {
    }

    private final RenderModel B(RenderModel renderModel, String templateDir) {
        Map mutableMap;
        RenderModel copy;
        boolean startsWith$default;
        if (renderModel == null) {
            return renderModel;
        }
        new LinkedHashMap();
        mutableMap = MapsKt__MapsKt.toMutableMap(renderModel.getInputSources());
        Iterator<T> it = renderModel.getInputSources().entrySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = ((InputSource) entry.getValue()).path;
            if (str != null) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "/", false, 2, null);
                if (!startsWith$default) {
                    mutableMap.put(entry.getKey(), InputSource.copy$default((InputSource) entry.getValue(), null, null, templateDir + File.separator + ((InputSource) entry.getValue()).path, null, null, null, null, null, null, null, null, null, 4091, null));
                    z16 = true;
                }
            }
        }
        if (z16) {
            copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : mutableMap, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
            return copy;
        }
        return renderModel;
    }

    private final void a() {
        if (u()) {
        } else {
            throw new IllegalStateException("You maybe forgot involve installLightAssets first!!!");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ be4.b d(b bVar, RenderModel renderModel, Size size, String str, List list, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            list = null;
        }
        return bVar.b(renderModel, size, str, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ be4.b e(b bVar, RenderModel renderModel, Size size, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = null;
        }
        return bVar.c(renderModel, size, list);
    }

    @JvmStatic
    public static final void s(@NotNull Context context2, @NotNull String licencePath2, @NotNull String appId2, @NotNull String appEntry2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(licencePath2, "licencePath");
        Intrinsics.checkParameterIsNotNull(appId2, "appId");
        Intrinsics.checkParameterIsNotNull(appEntry2, "appEntry");
        context = context2.getApplicationContext();
        appId = appId2;
        appEntry = appEntry2;
        licencePath = licencePath2;
    }

    @JvmStatic
    public static final void t(@NotNull String assetPath) {
        Intrinsics.checkParameterIsNotNull(assetPath, "assetPath");
        e.f452395c.c(assetPath);
    }

    @JvmStatic
    public static final boolean u() {
        boolean z16;
        if (!c.f374382c.b()) {
            return false;
        }
        if (e.f452395c.a().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean y(@NotNull List<DynamicSoConfig> dynamicSoConfigs) {
        Intrinsics.checkParameterIsNotNull(dynamicSoConfigs, "dynamicSoConfigs");
        return c.f374382c.d(dynamicSoConfigs);
    }

    public final void A(@NotNull String agent, @NotNull String path) {
        Intrinsics.checkParameterIsNotNull(agent, "agent");
        Intrinsics.checkParameterIsNotNull(path, "path");
        a();
        zd4.c.f452391c.a(agent, path);
    }

    @NotNull
    public final be4.b b(@NotNull RenderModel renderModel, @NotNull Size size, @NotNull String templateDir, @Nullable List<? extends fe4.a> renderNodes) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(size, "size");
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        return be4.a.a(templateDir, renderModel, size, renderNodes);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "this function is deprecated!", replaceWith = @ReplaceWith(expression = "createCoverProvider(renderModel: RenderModel, size: Size, templateDir: String,\n                            renderNodes: List<BaseEffectNode>? = null)", imports = {}))
    @NotNull
    public final be4.b c(@NotNull RenderModel renderModel, @NotNull Size size, @Nullable List<? extends fe4.a> renderNodes) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return b(renderModel, size, "/", renderNodes);
    }

    @NotNull
    public final ce4.b f(@NotNull RenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        return new ce4.c(renderModel);
    }

    @NotNull
    public final IPlayer g(@Nullable FrameLayout playerContainer) {
        return g.f452398a.a(playerContainer, 1);
    }

    @NotNull
    public final com.tencent.tavcut.session.a h() {
        return new TavCutSession();
    }

    @NotNull
    public final he4.a i(@NotNull ClipSource clipSource, @NotNull Size size) {
        Intrinsics.checkParameterIsNotNull(clipSource, "clipSource");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return he4.b.a(clipSource, size);
    }

    @Nullable
    public final RenderModel j(@Nullable RenderModel r36, @NotNull List<ClipSource> clipAssets) {
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        a();
        return ke4.a.f412272a.g(r36, clipAssets, true);
    }

    @NotNull
    public final String k() {
        return appEntry;
    }

    @NotNull
    public final String l() {
        return appId;
    }

    @NotNull
    public final d m() {
        return xd4.a.f447835a;
    }

    @NotNull
    public final xd4.e n() {
        return xd4.b.f447836a;
    }

    @Nullable
    public final Context o() {
        return context;
    }

    @NotNull
    public final f p() {
        return xd4.c.f447837a;
    }

    @NotNull
    public final xd4.g q() {
        return xd4.h.f447838a;
    }

    @NotNull
    public final String r() {
        return licencePath;
    }

    @NotNull
    public final String v() {
        Context context2 = context;
        if (context2 != null) {
            return com.tencent.videocut.utils.g.f384239a.i(context2, Constants.FILE_EMPTY_TEMPLATE);
        }
        throw new IllegalStateException("Before use TavCut, must init it first!");
    }

    @Nullable
    public final LightAssetModel w(@NotNull String jsonFilePath) {
        LightAssetModel.MediaType mediaType;
        List emptyList;
        List list;
        List list2;
        List list3;
        Intrinsics.checkParameterIsNotNull(jsonFilePath, "jsonFilePath");
        a();
        LightAsset Load = LightAsset.Load(jsonFilePath, 0);
        if (Load != null) {
            int i3 = Load.getMovieConfig().type;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        mediaType = LightAssetModel.MediaType.MULTI_MEDIA;
                    } else {
                        mediaType = LightAssetModel.MediaType.MULTI_MEDIA;
                    }
                } else {
                    mediaType = LightAssetModel.MediaType.PHOTO_ONLY;
                }
            } else {
                mediaType = LightAssetModel.MediaType.VIDEO_ONLY;
            }
            LightAssetModel.MaterialConfig materialConfig = new LightAssetModel.MaterialConfig(mediaType, Load.getMovieConfig().minClipAssetCount, Load.getMovieConfig().maxClipAssetCount, Load.getMovieConfig().minVideoDuration, Load.getMovieConfig().minImageDuration, Load.getMovieConfig().maxImageDuration, Load.getMovieConfig().preferredCoverTime, null, 128, null);
            FontAsset[] fontAssets = Load.getFontAssets();
            if (fontAssets == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                list = emptyList;
            } else {
                list = new ArrayList(fontAssets.length);
                for (FontAsset fontAsset : fontAssets) {
                    list.add(new LightAssetModel.FontAsset(fontAsset.fontFamily, fontAsset.fontStyle, null, 4, null));
                }
            }
            String[] bgmMusicIDs = Load.getBgmMusicIDs();
            Intrinsics.checkExpressionValueIsNotNull(bgmMusicIDs, "lightAsset.bgmMusicIDs");
            list2 = ArraysKt___ArraysKt.toList(bgmMusicIDs);
            String[] boundsTrackerPlaceHolders = Load.getBoundsTrackerPlaceHolders();
            Intrinsics.checkExpressionValueIsNotNull(boundsTrackerPlaceHolders, "lightAsset.boundsTrackerPlaceHolders");
            list3 = ArraysKt___ArraysKt.toList(boundsTrackerPlaceHolders);
            return new LightAssetModel(list, list2, materialConfig, list3, null, 16, null);
        }
        return null;
    }

    @Nullable
    public final RenderModel x(@Nullable String str) {
        RenderModel renderModel;
        Context context2 = context;
        if (context2 != null) {
            if (!TextUtils.isEmpty(str)) {
                renderModel = TemplateParser.INSTANCE.fromFile(new File(str));
            } else {
                renderModel = null;
            }
            if (renderModel != null) {
                b bVar = f422509e;
                String parent = new File(str).getParent();
                Intrinsics.checkExpressionValueIsNotNull(parent, "File(jsonFilePath).parent");
                return bVar.B(renderModel, parent);
            }
            return TemplateParser.INSTANCE.fromJson(com.tencent.videocut.utils.g.f384239a.i(context2, Constants.FILE_EMPTY_TEMPLATE));
        }
        throw new IllegalStateException("Before use TavCut, must init it first!");
    }

    @Nullable
    public final PagEffectData z(@NotNull String filePath) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        return PagEffectParser.f374399b.d(filePath);
    }
}
