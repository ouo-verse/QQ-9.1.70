package com.tencent.tavcut.core.operator;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tavcut.core.dataprocessor.EntityNodeType;
import com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher;
import com.tencent.tavcut.core.operator.IClipSourceOperator;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.TransitionTrigger;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u00108\u001a\u000206\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J&\u0010\u001e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J \u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J&\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010,\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0016J\u001f\u0010-\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b-\u0010.J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015R\u0016\u0010\u001a\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00101R\"\u00105\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000b028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/tavcut/core/operator/ClipSourceOperator;", "Lcom/tencent/tavcut/core/operator/IClipSourceOperator;", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "oldSource", "newSource", "", "j", "Lorg/light/lightAssetKit/Entity;", "entity", "", "index", "", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "isEmptyTemplate", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "l", "k", "", "clipSources", "u", "v", "Lcom/tencent/tavcut/core/operator/b;", "iStrategy", h.F, "g", "d", "b", "fromIndex", "toIndex", "c", "t", "a", "updatedSources", "e", "size", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "addClipEffect", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setOriginVolumeForClip", "r", "(IZ)V", "p", "Lcom/tencent/tavcut/core/operator/c;", "Lcom/tencent/tavcut/core/operator/c;", "Lkotlin/Function1;", "Lcom/tencent/tavcut/core/operator/IClipSourceOperator$InvalidStatus;", "Lkotlin/jvm/functions/Function1;", "errorCallBack", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "dataDispatcher", "<init>", "(Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ClipSourceOperator implements IClipSourceOperator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private c iStrategy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super IClipSourceOperator.InvalidStatus, Unit> errorCallBack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RenderDataDispatcher dataDispatcher;

    public ClipSourceOperator(@NotNull RenderDataDispatcher dataDispatcher) {
        Intrinsics.checkParameterIsNotNull(dataDispatcher, "dataDispatcher");
        this.dataDispatcher = dataDispatcher;
        this.iStrategy = new b();
        this.errorCallBack = new Function1<IClipSourceOperator.InvalidStatus, Unit>() { // from class: com.tencent.tavcut.core.operator.ClipSourceOperator$errorCallBack$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IClipSourceOperator.InvalidStatus it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IClipSourceOperator.InvalidStatus invalidStatus) {
                invoke2(invalidStatus);
                return Unit.INSTANCE;
            }
        };
    }

    private final void f(Entity entity, int index) {
        TavLogger.d("ClipSourceOperator", "add transition in addTransition index: " + index);
        this.dataDispatcher.d(entity, EntityNodeType.TRANSITION_TRIGGER, index);
    }

    static /* synthetic */ void i(ClipSourceOperator clipSourceOperator, Entity entity, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        clipSourceOperator.f(entity, i3);
    }

    private final boolean j(ClipSource oldSource, ClipSource newSource) {
        if (TextUtils.equals(oldSource.getSourceId(), newSource.getSourceId()) && TextUtils.equals(oldSource.getPath(), newSource.getPath()) && oldSource.getType() == newSource.getType() && Intrinsics.areEqual(oldSource.getMatrix(), newSource.getMatrix()) && TextUtils.equals(oldSource.getPhotoEffectPath(), newSource.getPhotoEffectPath()) && Intrinsics.areEqual(oldSource.getTransform(), newSource.getTransform()) && Intrinsics.areEqual(oldSource.getClipRect(), newSource.getClipRect())) {
            if (!Intrinsics.areEqual(oldSource.getSpeed(), newSource.getSpeed())) {
                return true;
            }
            if (oldSource.getDuration() == newSource.getDuration() && Intrinsics.areEqual(oldSource.getStartOffset(), newSource.getStartOffset())) {
                return true;
            }
        }
        return false;
    }

    private final boolean k(int index) {
        if (o() == -1 || index < 0 || index >= o()) {
            return false;
        }
        return true;
    }

    private final boolean l(int index) {
        if (o() == -1 || index < 0 || index > o()) {
            return false;
        }
        return true;
    }

    private final List<ClipSource> m() {
        List<ClipSource> clipsAssets;
        ClipSource copy;
        LAKRenderModel lakRenderModel = this.dataDispatcher.getLakRenderModel();
        if (lakRenderModel != null && (clipsAssets = lakRenderModel.getClipsAssets()) != null) {
            ArrayList arrayList = new ArrayList();
            int size = clipsAssets.size();
            for (int i3 = 0; i3 < size; i3++) {
                copy = r6.copy((r30 & 1) != 0 ? r6.sourceId : null, (r30 & 2) != 0 ? r6.path : null, (r30 & 4) != 0 ? r6.type : null, (r30 & 8) != 0 ? r6.duration : 0L, (r30 & 16) != 0 ? r6.speed : null, (r30 & 32) != 0 ? r6.volume : null, (r30 & 64) != 0 ? r6.startOffset : null, (r30 & 128) != 0 ? r6.matrix : null, (r30 & 256) != 0 ? r6.photoEffectPath : null, (r30 & 512) != 0 ? r6.transform : null, (r30 & 1024) != 0 ? r6.clipRect : null, (r30 & 2048) != 0 ? r6.byteArray : null, (r30 & 4096) != 0 ? clipsAssets.get(i3).autoLoop : null);
                arrayList.add(copy);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private final int o() {
        Integer num;
        List<ClipSource> clipsAssets;
        LAKRenderModel lakRenderModel = this.dataDispatcher.getLakRenderModel();
        if (lakRenderModel != null && (clipsAssets = lakRenderModel.getClipsAssets()) != null) {
            num = Integer.valueOf(clipsAssets.size());
        } else {
            num = null;
        }
        return num.intValue();
    }

    private final boolean s(boolean isEmptyTemplate) {
        if (!isEmptyTemplate && !Intrinsics.areEqual("/", this.dataDispatcher.getTemplateDir())) {
            return false;
        }
        return true;
    }

    private final void u(List<ClipSource> clipSources) {
        RenderDataDispatcher.H(this.dataDispatcher, clipSources, this.iStrategy.getF318735b(), false, 4, null);
        n();
    }

    private final void v(List<ClipSource> clipSources) {
        this.dataDispatcher.I(clipSources, this.iStrategy.getF318735b());
        n();
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    @Nullable
    public ClipSource a(int fromIndex, int toIndex) {
        if (k(fromIndex) && k(toIndex)) {
            List<ClipSource> m3 = m();
            ClipSource remove = m3.remove(fromIndex);
            m3.add(toIndex, remove);
            u(m3);
            return remove;
        }
        this.errorCallBack.invoke(IClipSourceOperator.InvalidStatus.REORDER_INVALID_INDEX);
        return null;
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    public void addClipEffect(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        RenderDataDispatcher.e(this.dataDispatcher, entity, EntityNodeType.MULTI_MEDIA, 0, 4, null);
    }

    public boolean b(int index, @NotNull List<ClipSource> clipSources, boolean isEmptyTemplate) {
        ClipSource copy;
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        if (!l(index)) {
            this.errorCallBack.invoke(IClipSourceOperator.InvalidStatus.ADD_INVALID_INDEX);
            return false;
        }
        List<ClipSource> m3 = m();
        ArrayList arrayList = new ArrayList();
        Iterator<ClipSource> it = clipSources.iterator();
        while (it.hasNext()) {
            copy = r8.copy((r30 & 1) != 0 ? r8.sourceId : null, (r30 & 2) != 0 ? r8.path : null, (r30 & 4) != 0 ? r8.type : null, (r30 & 8) != 0 ? r8.duration : 0L, (r30 & 16) != 0 ? r8.speed : null, (r30 & 32) != 0 ? r8.volume : null, (r30 & 64) != 0 ? r8.startOffset : null, (r30 & 128) != 0 ? r8.matrix : null, (r30 & 256) != 0 ? r8.photoEffectPath : null, (r30 & 512) != 0 ? r8.transform : null, (r30 & 1024) != 0 ? r8.clipRect : null, (r30 & 2048) != 0 ? r8.byteArray : null, (r30 & 4096) != 0 ? it.next().autoLoop : null);
            arrayList.add(copy);
        }
        boolean addAll = m3.addAll(index, arrayList);
        if (s(isEmptyTemplate)) {
            if (p().isEmpty()) {
                q(m3.size() - 1);
            } else {
                int size = clipSources.size();
                for (int i3 = 0; i3 < size; i3++) {
                    f(td4.c.f435876a.b(), index + i3);
                }
            }
        }
        u(m3);
        return addAll;
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    public void c(int fromIndex, int toIndex) {
        t(fromIndex, toIndex, false);
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    public boolean d(int index, @NotNull List<ClipSource> clipSources) {
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        return b(index, clipSources, false);
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    @Nullable
    public List<ClipSource> e(int index, @NotNull List<ClipSource> updatedSources) {
        List<ClipSource> emptyList;
        Intrinsics.checkParameterIsNotNull(updatedSources, "updatedSources");
        if (!k(index) || !l(updatedSources.size() + index)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<ClipSource> m3 = m();
        ArrayList arrayList = new ArrayList();
        boolean z16 = true;
        for (ClipSource clipSource : updatedSources) {
            ClipSource clipSource2 = m3.get(index);
            if (!Intrinsics.areEqual(clipSource2, clipSource)) {
                m3.set(index, clipSource);
                arrayList.add(clipSource2);
            }
            index++;
            if (!j(clipSource2, clipSource)) {
                z16 = false;
            }
        }
        if (z16) {
            v(m3);
        } else {
            u(m3);
        }
        return arrayList;
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    public boolean g(@NotNull List<ClipSource> clipSources) {
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        return d(o(), clipSources);
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    public void h(@NotNull b iStrategy) {
        Intrinsics.checkParameterIsNotNull(iStrategy, "iStrategy");
        this.iStrategy = iStrategy;
    }

    @NotNull
    public final List<Entity> p() {
        Object firstOrNull;
        List<Entity> emptyList;
        List<Entity> children;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.B(Reflection.getOrCreateKotlinClass(TransitionTrigger.class)));
        Entity entity = (Entity) firstOrNull;
        if (entity == null || (children = entity.getChildren()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return children;
    }

    public final void q(int size) {
        for (int i3 = 0; i3 < size; i3++) {
            i(this, td4.c.f435876a.b(), 0, 2, null);
        }
    }

    public final void r(int index, boolean isEmptyTemplate) {
        Object firstOrNull;
        if (s(isEmptyTemplate)) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.B(Reflection.getOrCreateKotlinClass(TransitionTrigger.class)));
            Entity entity = (Entity) firstOrNull;
            if (entity != null && index >= 0 && index < entity.getChildren().size()) {
                Entity transition = entity.getChildren().get(index);
                RenderDataDispatcher renderDataDispatcher = this.dataDispatcher;
                Intrinsics.checkExpressionValueIsNotNull(transition, "transition");
                renderDataDispatcher.s(transition);
            }
        }
    }

    @Override // com.tencent.tavcut.core.operator.IClipSourceOperator
    public void setOriginVolumeForClip(int index, float volume) {
        if (k(index)) {
            this.dataDispatcher.J(index, volume);
        }
    }

    public void t(int fromIndex, int toIndex, boolean isEmptyTemplate) {
        if (k(fromIndex) && toIndex > fromIndex && toIndex <= o()) {
            if (o() <= this.iStrategy.a()) {
                this.errorCallBack.invoke(IClipSourceOperator.InvalidStatus.DELETE_LIMIT);
                return;
            }
            List<ClipSource> m3 = m();
            int i3 = toIndex - 1;
            if (i3 >= fromIndex) {
                while (true) {
                    m3.remove(i3);
                    r(i3, isEmptyTemplate);
                    if (i3 == fromIndex) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
            r(m3.size() - 1, isEmptyTemplate);
            u(m3);
        }
    }

    private final void n() {
    }
}
