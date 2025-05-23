package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SmoothModel;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.Smooth;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.enums.SmoothSharpenType;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u001c\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J0\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J:\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/videocut/render/n;", "Lcom/tencent/videocut/render/a;", "Lkotlin/Pair;", "Lcom/tencent/videocut/model/MediaClip;", "", "Lcom/tencent/videocut/render/l;", "Lcom/tencent/videocut/model/SmoothModel;", "openSmooth", "Lorg/light/lightAssetKit/components/Smooth;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "sharpenType", "Lorg/light/lightAssetKit/enums/SmoothSharpenType;", HippyTKDListViewAdapter.X, "Lcom/tencent/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "w", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "y", "Lorg/light/lightAssetKit/Entity;", "entity", "", "removeEntity", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "B", "data", "v", "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "e", "Ljava/lang/String;", "TAG", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class n extends a<Pair<? extends MediaClip, ? extends Long>, l> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    public n(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
            this.TAG = "NewSmoothRender";
        }
    }

    private final Smooth A(SmoothModel openSmooth) {
        Smooth n3 = rd4.c.f431135f.o().n();
        n3.setSmooth(0.0f);
        n3.setBrightenEyeStrength(0.0f);
        n3.setSmoothVersion(AdMetricTag.FALLBACK);
        n3.setOverallSmooth(false);
        n3.setSharpenStrength(openSmooth.sharpenStrength);
        n3.setSharpenType(x(openSmooth.sharpenType));
        n3.setEnabled(openSmooth.enableSharp);
        return n3;
    }

    private final SmoothSharpenType x(int sharpenType) {
        boolean z16;
        for (SmoothSharpenType smoothSharpenType : SmoothSharpenType.values()) {
            if (smoothSharpenType.value == sharpenType) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return smoothSharpenType;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable Pair<? extends MediaClip, Long> old, @NotNull Pair<? extends MediaClip, Long> r102) {
        TimeOffset timeOffset;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, entity, old, r102);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(r102, "new");
        WinkHDRPicQualityDetectUtils winkHDRPicQualityDetectUtils = WinkHDRPicQualityDetectUtils.f320445a;
        SmoothModel j3 = winkHDRPicQualityDetectUtils.j(old);
        SmoothModel j16 = winkHDRPicQualityDetectUtils.j(r102);
        if (j16 == null) {
            return;
        }
        Smooth smooth = (Smooth) entity.getComponent(Smooth.class);
        boolean z18 = true;
        if (smooth != null) {
            if (smooth.getSharpenType() != x(j16.sharpenType)) {
                smooth.setSharpenType(x(j16.sharpenType));
            }
            float sharpenStrength = smooth.getSharpenStrength();
            float f16 = j16.sharpenStrength;
            if (sharpenStrength == f16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                smooth.setSharpenStrength(f16);
            }
            if (j3 != null && j3.enableSharp == j16.enableSharp) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                this.tavCutSession.switchEntity(entity, j16.enableSharp);
            }
        }
        if (j3 == null || j3.startOffsetUs != j16.startOffsetUs) {
            z18 = false;
        }
        if ((!z18 || j3.durationUs != j16.durationUs) && (timeOffset = (TimeOffset) entity.getComponent(TimeOffset.class)) != null) {
            timeOffset.setStartOffset(j16.startOffsetUs);
            timeOffset.setDuration(j16.durationUs);
        }
        w53.b.a(this.TAG, "updateEntity " + entity.toJson());
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a(this.TAG, "removeEntity " + entity.toJson());
        this.tavCutSession.removeEntity(entity);
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<Pair<? extends MediaClip, ? extends Long>> s(@NotNull MediaModel model) {
        List<Pair<? extends MediaClip, ? extends Long>> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        Boolean bool = model.openSuperHDR;
        Boolean bool2 = Boolean.TRUE;
        if (!Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(bool2, model.openHDR)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        for (MediaClip mediaClip : model.videos) {
            arrayList.add(new Pair(mediaClip, Long.valueOf(j3)));
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                j3 += resourceModel.scaleDuration;
            }
        }
        return arrayList;
    }

    @Override // com.tencent.videocut.render.m
    @Nullable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Entity b(@Nullable l data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Entity) iPatchRedirector.redirect((short) 8, (Object) this, (Object) data);
        }
        if (data == null) {
            return null;
        }
        w53.b.a(this.TAG, "addEntity " + data.a().toJson());
        com.tencent.videocut.render.utils.a.f384204a.e(this.tavCutSession, data.a());
        return data.a();
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull Pair<? extends MediaClip, Long> model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        w53.b.a(this.TAG, "getItemIdentity " + com.tencent.videocut.render.extension.e.n(model.getFirst()));
        return com.tencent.videocut.render.extension.e.n(model.getFirst());
    }

    @Override // com.tencent.videocut.render.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public boolean l(@NotNull Pair<? extends MediaClip, Long> newModel, @NotNull Pair<? extends MediaClip, Long> oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (Intrinsics.areEqual(newModel.getFirst(), oldModel.getFirst()) && newModel.getSecond().longValue() == oldModel.getSecond().longValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.videocut.render.a
    @Nullable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public l q(@NotNull Pair<? extends MediaClip, Long> model) {
        List<? extends Component> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (l) iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        SmoothModel j3 = WinkHDRPicQualityDetectUtils.f320445a.j(model);
        if (j3 == null) {
            return null;
        }
        td4.f q16 = rd4.c.f431135f.q();
        TimeOffset timeOffset = new TimeOffset();
        timeOffset.setStartOffset(j3.startOffsetUs);
        timeOffset.setDuration(j3.durationUs);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Component[]{A(j3), timeOffset});
        return new l(q16.a(LightConstants.DowngradeStrategyKey.SMOOTH, listOf), new InputSource(null, null, null, null, null, null, null, null, null, null, null, 2047, null), null, 4, null);
    }
}
