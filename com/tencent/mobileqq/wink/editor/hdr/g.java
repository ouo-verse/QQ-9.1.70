package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.tavcut.core.session.LAKCutSession;
import com.tencent.videocut.model.HDRModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.AITextureComponent;
import org.light.lightAssetKit.components.Camera;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/g;", "", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "", "d", "inputMediaClip", "c", "Lcom/tencent/tavcut/core/session/LAKCutSession;", "lakCutSession", "b", "", "a", "", "", "Ljava/util/Map;", "mediaFpsMap", "I", "maxDelogoFrameRate", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f320477a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> mediaFpsMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int maxDelogoFrameRate;

    g() {
    }

    @NotNull
    public final String a() {
        if (com.tencent.mobileqq.wink.editor.util.d.f322631a.b()) {
            return LightConstants.AgentType.PIC_ENHANCE_AGENT;
        }
        return LightConstants.AgentType.REALTIME_PIC_ENHANCE_AGENT;
    }

    public final boolean b(@NotNull LAKCutSession lakCutSession) {
        Entity entity;
        boolean z16;
        AITextureComponent aITextureComponent;
        Intrinsics.checkNotNullParameter(lakCutSession, "lakCutSession");
        Entity rootEntity = lakCutSession.getRootEntity();
        if (rootEntity != null) {
            entity = com.tencent.videocut.render.extension.d.e(rootEntity, Reflection.getOrCreateKotlinClass(Camera.class));
        } else {
            entity = null;
        }
        boolean z17 = false;
        if (entity == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.a("WinkHDRHelper", "hasHDREntity cameraEntity is not null " + z16);
        if (entity != null && (aITextureComponent = (AITextureComponent) com.tencent.videocut.render.extension.d.d(entity, Reflection.getOrCreateKotlinClass(AITextureComponent.class))) != null) {
            z17 = Intrinsics.areEqual(aITextureComponent.getAiType(), f320477a.a());
        }
        w53.b.a("WinkHDRHelper", "hasHDREntity " + z17);
        return z17;
    }

    public final boolean c(@Nullable MediaClip inputMediaClip) {
        ResourceModel resourceModel;
        SizeF sizeF;
        int i3;
        boolean z16;
        if (maxDelogoFrameRate <= 0) {
            int maxDelogoFrameRate2 = ((IEnhanceHelper) QRoute.api(IEnhanceHelper.class)).getEnhanceConfig().getMaxDelogoFrameRate();
            maxDelogoFrameRate = maxDelogoFrameRate2;
            w53.b.a("WinkHDRHelper", "maxDelogoFrameRate is " + maxDelogoFrameRate2);
        }
        if (inputMediaClip != null && (resourceModel = inputMediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
            float f16 = sizeF.width;
            if (f16 >= 100.0f) {
                float f17 = sizeF.height;
                if (f17 >= 100.0f) {
                    float f18 = f16 / f17;
                    if (f18 <= 2.6666667f && f18 >= 0.375f) {
                        String str = resourceModel.path;
                        Map<String, Integer> map = mediaFpsMap;
                        Integer num = map.get(str);
                        if (num != null) {
                            i3 = num.intValue();
                        } else {
                            i3 = -1;
                        }
                        if (i3 < 0) {
                            String str2 = resourceModel.extras.get(QQWinkConstants.LOCAL_MEDIA_INFO_EXT_FPS);
                            if (str2 != null && str2.length() != 0) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!z16) {
                                i3 = Integer.parseInt(str2);
                            } else {
                                i3 = com.tencent.mobileqq.wink.editor.export.j.x(resourceModel.path);
                            }
                            map.put(str, Integer.valueOf(i3));
                        }
                        int i16 = maxDelogoFrameRate;
                        if (i16 > 0 && i3 >= i16) {
                            w53.b.c("WinkHDRHelper", "media fps " + i3 + " is more than 50");
                            return false;
                        }
                        LinkedHashMap<String, HDRModel> c16 = WinkHDRCacheManager.INSTANCE.a().c();
                        String str3 = resourceModel.path;
                        for (Map.Entry<String, HDRModel> entry : c16.entrySet()) {
                            String key = entry.getKey();
                            HDRModel value = entry.getValue();
                            if (Intrinsics.areEqual(str3, key) || Intrinsics.areEqual(str3, value.hdrVideoPath)) {
                                return false;
                            }
                        }
                        return true;
                    }
                    w53.b.c("WinkHDRHelper", "media ratio " + f18 + " is not in (0.375,2.6666667)");
                    return false;
                }
            }
            w53.b.c("WinkHDRHelper", "media size " + sizeF + " is smaller than 100 px");
        }
        return false;
    }

    public final boolean d(@Nullable List<? extends MediaClip> mediaClips) {
        if (mediaClips == null) {
            return false;
        }
        Iterator<? extends MediaClip> it = mediaClips.iterator();
        while (it.hasNext()) {
            if (c(it.next())) {
                return true;
            }
        }
        return false;
    }
}
