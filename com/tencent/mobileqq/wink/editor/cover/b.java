package com.tencent.mobileqq.wink.editor.cover;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.util.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.extension.e;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.TemplateConfig;
import org.light.lightAssetKit.components.Size;
import rd4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004JR\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/cover/b;", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "editData", "", "templateDir", "a", "Lcom/tencent/tavcut/core/session/ICutSession;", "cutSession", "", "atTimeMs", "Lorg/light/lightAssetKit/components/Size;", "size", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "renderNodes", "Ljava/util/HashMap;", "assetData", "Landroid/graphics/Bitmap;", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a */
    @NotNull
    public static final b f319709a = new b();

    b() {
    }

    public static /* synthetic */ Bitmap c(b bVar, ICutSession iCutSession, long j3, Size size, String str, List list, HashMap hashMap, int i3, Object obj) {
        List list2;
        HashMap hashMap2;
        if ((i3 & 16) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        if ((i3 & 32) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        return bVar.b(iCutSession, j3, size, str, list2, hashMap2);
    }

    @Nullable
    public final String a(@NotNull WinkEditData editData, @NotNull String templateDir) {
        TemplateConfig templateConfig;
        long j3;
        float f16;
        long j16;
        Intrinsics.checkNotNullParameter(editData, "editData");
        Intrinsics.checkNotNullParameter(templateDir, "templateDir");
        MediaModel mediaModel = editData.getMediaModel();
        WinkExportUtils.R();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        c.t(context, "", "lightsdk_qq", WinkContext.Companion.j(WinkContext.INSTANCE, false, 1, null));
        LightAsset Load = LightAsset.Load(templateDir, 0);
        if (Load != null) {
            templateConfig = Load.getMovieConfig();
        } else {
            templateConfig = null;
        }
        if (templateConfig != null) {
            j3 = templateConfig.preferredCoverTime;
        } else {
            j3 = 0;
        }
        long j17 = 1000;
        long j18 = j3 / j17;
        if (templateConfig != null) {
            f16 = templateConfig.preferredCoverTimePercent;
        } else {
            f16 = -1.0f;
        }
        if (f16 >= 0.0f) {
            j18 = (((float) editData.getDurationUs()) * f16) / j17;
        }
        if (j18 <= 0) {
            j16 = 200;
        } else {
            j16 = j18;
        }
        w53.b.a("WinkCoverExtractor", "[extraVideoCover] preferredCoverTimeMs is " + j16);
        ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
        createLAKCutSession.setTemplateDir(templateDir);
        createLAKCutSession.setRenderModel(c.f431135f.y(e.B(mediaModel.videos, false, null, 3, null)));
        Bitmap b16 = b(createLAKCutSession, j16, m.f322645a.j(mediaModel), templateDir, null, editData.getAssetData());
        if (b16 == null) {
            w53.b.c("WinkCoverExtractor", "[extraVideoCover] bitmap is null");
            return null;
        }
        String str = u53.b.f438374e + "/video_cover_" + System.currentTimeMillis() + ".jpg";
        boolean saveBitmapToFile = FileUtils.saveBitmapToFile(b16, str);
        w53.b.f("WinkCoverExtractor", "[extraVideoCover] isSuccess=" + saveBitmapToFile + ", coverFilePath=" + str);
        b16.recycle();
        createLAKCutSession.release();
        if (!saveBitmapToFile) {
            return null;
        }
        return str;
    }

    @Nullable
    public final Bitmap b(@NotNull ICutSession cutSession, long atTimeMs, @NotNull Size size, @NotNull String templateDir, @Nullable List<? extends BaseEffectNode> renderNodes, @Nullable HashMap<String, String> assetData) {
        Intrinsics.checkNotNullParameter(cutSession, "cutSession");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(templateDir, "templateDir");
        LAKRenderModel allInputSourceRenderModel = cutSession.getAllInputSourceRenderModel();
        Bitmap bitmap = null;
        if (allInputSourceRenderModel != null) {
            LAKRenderModel renderModel = WinkExportUtils.E(cutSession, size, allInputSourceRenderModel);
            c cVar = c.f431135f;
            Intrinsics.checkNotNullExpressionValue(renderModel, "renderModel");
            ICoverProvider d16 = cVar.d(renderModel, size, templateDir, renderNodes, assetData);
            try {
                try {
                    Bitmap coverAtTime = d16.getCoverAtTime(atTimeMs);
                    d16.release();
                    bitmap = coverAtTime;
                } catch (Exception e16) {
                    w53.b.c("WinkCoverExtractor", "[getCoverAtTime] atTimeMs=" + atTimeMs + ", Exception=" + e16);
                    d16.release();
                }
            } catch (Throwable th5) {
                d16.release();
                throw th5;
            }
        }
        return bitmap;
    }
}
