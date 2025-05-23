package e73;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicInfo;
import com.tencent.mobileqq.wink.utils.n;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.log.TavLogger;
import d73.LyricSticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Component;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Le73/c;", "", "Lcom/google/gson/Gson;", "b", "Lorg/light/lightAssetKit/LightAssetDataContext;", "lightAssetDataContext", "", "path", "Ljava/io/File;", "parentFolder", "Ld73/b;", "c", "key", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "a", "templatePath", "Ld73/d;", "lyricSticker", "", "d", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f395829a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Gson gson;

    c() {
    }

    private final InputSource a(LightAssetDataContext lightAssetDataContext, String key) {
        JsonObject jsonObject;
        JsonElement jsonElement;
        JsonObject inputSources;
        if (key == null) {
            return null;
        }
        boolean z16 = false;
        if (lightAssetDataContext != null && (inputSources = lightAssetDataContext.getInputSources()) != null && inputSources.has(key)) {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        try {
            JsonObject inputSources2 = lightAssetDataContext.getInputSources();
            if (inputSources2 != null && (jsonElement = inputSources2.get(key)) != null) {
                jsonObject = jsonElement.getAsJsonObject();
            } else {
                jsonObject = null;
            }
            Gson b16 = b();
            if (b16 == null) {
                return null;
            }
            return (InputSource) b16.fromJson(String.valueOf(jsonObject), InputSource.class);
        } catch (Exception e16) {
            TavLogger.e("wink_sticker_lyric", "accessInputSource error: " + e16.getMessage());
            return null;
        }
    }

    private final Gson b() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }

    private final d73.b c(LightAssetDataContext lightAssetDataContext, String path, File parentFolder) {
        String path2;
        InputSource a16 = a(lightAssetDataContext, path);
        if (a16 != null && (path2 = a16.getPath()) != null) {
            w53.b.a("wink_sticker_lyric", "originLyricsPath is  " + path2 + "}");
            return com.tencent.mobileqq.wink.editor.music.lyric.a.a(FileUtils.readFileContent(new File(parentFolder, path2)), LyricParseHelper.LYRIC_FROMAT_LRC);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    public final void d(@NotNull String templatePath, @NotNull LyricSticker lyricSticker) {
        boolean z16;
        long j3;
        AudioSource audioSource;
        AudioSource audioSource2;
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        Intrinsics.checkNotNullParameter(lyricSticker, "lyricSticker");
        LightAssetDataContext d16 = com.tencent.videocut.render.utils.b.f384205a.d(templatePath);
        if (d16 == null) {
            return;
        }
        List<Entity> f16 = WinkVideoTavCut.INSTANCE.f(d16.getRootEntity(), n.a.INSTANCE.a());
        ArrayList<AudioSource> arrayList = new ArrayList();
        Iterator it = f16.iterator();
        while (it.hasNext()) {
            Collection<Component> components = ((Entity) it.next()).getComponents();
            Intrinsics.checkNotNullExpressionValue(components, "entity.components");
            Iterator it5 = components.iterator();
            while (true) {
                audioSource = null;
                if (it5.hasNext()) {
                    audioSource2 = it5.next();
                    if (((Component) audioSource2) instanceof AudioSource) {
                        break;
                    }
                } else {
                    audioSource2 = 0;
                    break;
                }
            }
            if (audioSource2 instanceof AudioSource) {
                audioSource = audioSource2;
            }
            if (audioSource != null) {
                arrayList.add(audioSource);
            }
        }
        for (AudioSource audioSource3 : arrayList) {
            String originLyricsPath = audioSource3.getOriginLyricsPath();
            boolean z17 = false;
            if (originLyricsPath != null && originLyricsPath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                String translatedLyricsPath = audioSource3.getTranslatedLyricsPath();
                if (translatedLyricsPath == null || translatedLyricsPath.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                }
            }
            File parentFile = new File(templatePath).getParentFile();
            if (parentFile != null) {
                c cVar = f395829a;
                lyricSticker.o(cVar.c(d16, audioSource3.getOriginLyricsPath(), parentFile));
                lyricSticker.n(cVar.c(d16, audioSource3.getTranslatedLyricsPath(), parentFile));
                MusicInfo k3 = com.tencent.mobileqq.wink.editor.smartclip.c.k(d16);
                long j16 = 0;
                if (k3 != null) {
                    j3 = k3.getSelectedStartInMillis();
                } else {
                    j3 = 0;
                }
                long j17 = 1000;
                lyricSticker.v(j3 * j17);
                if (k3 != null) {
                    j16 = k3.getSelectedDurationInMillis();
                }
                lyricSticker.t(j16 * j17);
            }
        }
    }
}
