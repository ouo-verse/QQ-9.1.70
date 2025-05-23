package com.tencent.tavcut.operator;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.composition.model.component.MultiMedia;
import com.tencent.tavcut.composition.model.component.SubAssetComponent;
import com.tencent.tavcut.composition.model.component.TransitionTrigger;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u00106\u001a\u000204\u00a2\u0006\u0004\b7\u00108J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0016\u0010\u001f\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u001e\u0010 \u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0016J&\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010-\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b-\u0010+J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010/R\"\u00103\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0010008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/tavcut/operator/ClipSourceOperator;", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "Lcom/tencent/tavcut/model/ClipSource;", "oldSource", "newSource", "", "k", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "", "index", "i", "", DomainData.DOMAIN_NAME, "p", "u", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "clipSources", "w", HippyTKDListViewAdapter.X, "transitionSize", "clipSize", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/tavcut/operator/c;", "iStrategy", h.F, "g", "d", "transition", "f", "fromIndex", "toIndex", "c", "a", "updatedSources", "e", "size", ReportConstant.COSTREPORT_PREFIX, "(I)V", "b", "t", "r", "Lcom/tencent/tavcut/operator/c;", "Lkotlin/Function1;", "Lcom/tencent/tavcut/operator/IClipSourceOperator$InvalidStatus;", "Lkotlin/jvm/functions/Function1;", "errorCallBack", "Lpd4/b;", "Lpd4/b;", "dataDispatcher", "<init>", "(Lpd4/b;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ClipSourceOperator implements IClipSourceOperator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private c iStrategy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super IClipSourceOperator.InvalidStatus, Unit> errorCallBack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final pd4.b dataDispatcher;

    public ClipSourceOperator(@NotNull pd4.b dataDispatcher) {
        Intrinsics.checkParameterIsNotNull(dataDispatcher, "dataDispatcher");
        this.dataDispatcher = dataDispatcher;
        this.iStrategy = new b();
        this.errorCallBack = new Function1<IClipSourceOperator.InvalidStatus, Unit>() { // from class: com.tencent.tavcut.operator.ClipSourceOperator$errorCallBack$1
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

    private final Entity i(Entity entity, int index) {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(TransitionTrigger.class)));
        Entity entity2 = (Entity) firstOrNull;
        if (entity2 != null) {
            return this.dataDispatcher.b(entity, entity2.getId(), index);
        }
        return new Entity(0, null, null, null, false, 0, 63, null);
    }

    static /* synthetic */ Entity j(ClipSourceOperator clipSourceOperator, Entity entity, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return clipSourceOperator.i(entity, i3);
    }

    private final boolean k(ClipSource oldSource, ClipSource newSource) {
        if (TextUtils.equals(oldSource.sourceId, newSource.sourceId) && TextUtils.equals(oldSource.path, newSource.path) && oldSource.type == newSource.type && Intrinsics.areEqual(oldSource.matrix, newSource.matrix) && TextUtils.equals(oldSource.photoEffectPath, newSource.photoEffectPath) && Intrinsics.areEqual(oldSource.transform, newSource.transform) && Intrinsics.areEqual(oldSource.clipRect, newSource.clipRect)) {
            if (!Intrinsics.areEqual(oldSource.speed, newSource.speed)) {
                return true;
            }
            if (oldSource.duration == newSource.duration && Intrinsics.areEqual(oldSource.startOffset, newSource.startOffset)) {
                return true;
            }
        }
        return false;
    }

    private final boolean l(int index) {
        if (p() == -1 || index < 0 || index >= p()) {
            return false;
        }
        return true;
    }

    private final boolean m(int index) {
        if (p() == -1 || index < 0 || index > p()) {
            return false;
        }
        return true;
    }

    private final List<ClipSource> n() {
        List<ClipSource> clipsAssets;
        RenderModel n3 = this.dataDispatcher.n();
        if (n3 != null && (clipsAssets = n3.getClipsAssets()) != null) {
            ArrayList arrayList = new ArrayList();
            int size = clipsAssets.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(ClipSource.copy$default(clipsAssets.get(i3), null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private final void o() {
        SubAssetComponent copy;
        for (Entity entity : this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(SubAssetComponent.class))) {
            Iterator<T> it = entity.getComponents().iterator();
            while (true) {
                if (it.hasNext()) {
                    IdentifyComponent identifyComponent = (IdentifyComponent) it.next();
                    if (identifyComponent.getData() instanceof SubAssetComponent) {
                        Object data = identifyComponent.getData();
                        if (data != null) {
                            SubAssetComponent subAssetComponent = (SubAssetComponent) data;
                            Iterator<ClipSource> it5 = this.dataDispatcher.p().iterator();
                            int i3 = 0;
                            while (true) {
                                if (it5.hasNext()) {
                                    if (Intrinsics.areEqual(it5.next().sourceId, subAssetComponent.resourceId)) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                } else {
                                    i3 = -1;
                                    break;
                                }
                            }
                            copy = subAssetComponent.copy((r35 & 1) != 0 ? subAssetComponent.entityId : null, (r35 & 2) != 0 ? subAssetComponent.componentID : null, (r35 & 4) != 0 ? subAssetComponent.enabled : null, (r35 & 8) != 0 ? subAssetComponent.type : null, (r35 & 16) != 0 ? subAssetComponent.index : Integer.valueOf(i3), (r35 & 32) != 0 ? subAssetComponent.version : null, (r35 & 64) != 0 ? subAssetComponent.resourceId : null, (r35 & 128) != 0 ? subAssetComponent.eIndexVector : null, (r35 & 256) != 0 ? subAssetComponent.subAssetApplyType : null, (r35 & 512) != 0 ? subAssetComponent.indexes : null, (r35 & 1024) != 0 ? subAssetComponent.eApplyRange : null, (r35 & 2048) != 0 ? subAssetComponent.level : null, (r35 & 4096) != 0 ? subAssetComponent.renderAfterTransform : null, (r35 & 8192) != 0 ? subAssetComponent.isUsingPropertiesSize : null, (r35 & 16384) != 0 ? subAssetComponent.isEnable3D : null, (r35 & 32768) != 0 ? subAssetComponent.cacheRenderResult : null, (r35 & 65536) != 0 ? subAssetComponent.unknownFields() : null);
                            this.dataDispatcher.M(entity.getId(), IdentifyComponent.copy$default(identifyComponent, null, null, copy, null, 11, null));
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.SubAssetComponent");
                        }
                    }
                }
            }
        }
    }

    private final int p() {
        Integer num;
        List<ClipSource> clipsAssets;
        RenderModel n3 = this.dataDispatcher.n();
        if (n3 != null && (clipsAssets = n3.getClipsAssets()) != null) {
            num = Integer.valueOf(clipsAssets.size());
        } else {
            num = null;
        }
        return num.intValue();
    }

    private final Entity q(int index) {
        Object firstOrNull;
        Object firstOrNull2;
        List<Entity> E = this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(TransitionTrigger.class));
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) E);
        if (firstOrNull != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) E);
            Entity entity = (Entity) firstOrNull2;
            if (entity != null) {
                List<Entity> children = entity.getChildren();
                if (index < children.size()) {
                    return children.get(index);
                }
                return null;
            }
            throw new IllegalStateException("transitionGroup can't found");
        }
        ee4.b.b("ClipSourceOperator", "transitionGroup can't found!!!");
        return new Entity(0, null, null, null, false, 0, 63, null);
    }

    private final boolean u() {
        return Intrinsics.areEqual("/", this.dataDispatcher.getTemplateDir());
    }

    private final void v(int transitionSize, int clipSize) {
        int i3 = clipSize - 1;
        if (transitionSize < i3) {
            while (transitionSize < i3) {
                j(this, xd4.c.f447837a.b(), 0, 2, null);
                transitionSize++;
            }
        }
    }

    private final void w(List<ClipSource> clipSources) {
        this.dataDispatcher.I(clipSources, this.iStrategy.b());
        o();
    }

    private final void x(List<ClipSource> clipSources) {
        this.dataDispatcher.J(clipSources, this.iStrategy.b());
        o();
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    @Nullable
    public ClipSource a(int fromIndex, int toIndex) {
        if (l(fromIndex) && l(toIndex)) {
            List<ClipSource> n3 = n();
            ClipSource remove = n3.remove(fromIndex);
            n3.add(toIndex, remove);
            w(n3);
            return remove;
        }
        this.errorCallBack.invoke(IClipSourceOperator.InvalidStatus.REORDER_INVALID_INDEX);
        return null;
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    @NotNull
    public Entity b(@NotNull Entity entity) {
        Object firstOrNull;
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(MultiMedia.class)));
        Entity entity2 = (Entity) firstOrNull;
        if (entity2 != null) {
            Entity e16 = pd4.b.e(this.dataDispatcher, entity, entity2.getId(), 0, 4, null);
            o();
            return e16;
        }
        return new Entity(0, null, null, null, false, 0, 63, null);
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    public void c(int fromIndex, int toIndex) {
        if (l(fromIndex) && toIndex > fromIndex && toIndex <= p()) {
            if (p() <= this.iStrategy.a()) {
                this.errorCallBack.invoke(IClipSourceOperator.InvalidStatus.DELETE_LIMIT);
                return;
            }
            List<ClipSource> n3 = n();
            int i3 = toIndex - 1;
            if (i3 >= fromIndex) {
                while (true) {
                    n3.remove(i3);
                    t(i3);
                    if (i3 == fromIndex) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
            t(n3.size() - 1);
            w(n3);
        }
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    public boolean d(int index, @NotNull List<ClipSource> clipSources) {
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        if (!m(index)) {
            this.errorCallBack.invoke(IClipSourceOperator.InvalidStatus.ADD_INVALID_INDEX);
            return false;
        }
        List<ClipSource> n3 = n();
        ArrayList arrayList = new ArrayList();
        Iterator<ClipSource> it = clipSources.iterator();
        while (it.hasNext()) {
            arrayList.add(ClipSource.copy$default(it.next(), null, null, null, 0L, null, null, null, null, null, null, null, null, 4095, null));
        }
        boolean addAll = n3.addAll(index, arrayList);
        if (u()) {
            if (r().isEmpty()) {
                s(n3.size() - 1);
            } else {
                int size = clipSources.size();
                for (int i3 = 0; i3 < size; i3++) {
                    i(xd4.c.f447837a.b(), index + i3);
                }
            }
        }
        w(n3);
        return addAll;
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    @Nullable
    public List<ClipSource> e(int index, @NotNull List<ClipSource> updatedSources) {
        List<ClipSource> emptyList;
        Intrinsics.checkParameterIsNotNull(updatedSources, "updatedSources");
        if (!l(index) || !m(updatedSources.size() + index)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<ClipSource> n3 = n();
        ArrayList arrayList = new ArrayList();
        boolean z16 = true;
        for (ClipSource clipSource : updatedSources) {
            ClipSource clipSource2 = n3.get(index);
            if (!Intrinsics.areEqual(clipSource2, clipSource)) {
                n3.set(index, clipSource);
                arrayList.add(clipSource2);
            }
            index++;
            if (!k(clipSource2, clipSource)) {
                z16 = false;
            }
        }
        if (z16) {
            x(n3);
        } else {
            w(n3);
        }
        return arrayList;
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    @NotNull
    public Entity f(@NotNull Entity transition, int index) {
        Object firstOrNull;
        Object firstOrNull2;
        Entity entity;
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        ee4.b.a("ClipSourceOperator", "setTransition index: " + index + " Entity id: " + transition.getId());
        List<Entity> E = this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(TransitionTrigger.class));
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) E);
        if (firstOrNull != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) E);
            Entity entity2 = (Entity) firstOrNull2;
            if (entity2 != null) {
                int size = entity2.getChildren().size();
                int size2 = this.dataDispatcher.p().size();
                if (size < size2) {
                    ee4.b.b("ClipSourceOperator", "setTransition the index " + index + " out of range");
                    v(size, size2);
                    entity = q(index);
                } else {
                    if (index < 0) {
                        ee4.b.b("ClipSourceOperator", "setTransition the index " + index + " out of range");
                        return new Entity(0, null, null, null, false, 0, 63, null);
                    }
                    entity = null;
                }
                if (entity == null) {
                    ee4.b.b("ClipSourceOperator", "setTransition oldTransition is null.");
                    return new Entity(0, null, null, null, false, 0, 63, null);
                }
                Iterator<T> it = transition.getComponents().iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    if (this.dataDispatcher.w(entity.getId(), IdentifyComponent.copy$default((IdentifyComponent) it.next(), null, null, null, null, 15, null))) {
                        z16 = true;
                    }
                }
                if (z16) {
                    this.dataDispatcher.C();
                }
                Entity F = this.dataDispatcher.F(entity.getId());
                if (F == null) {
                    return new Entity(0, null, null, null, false, 0, 63, null);
                }
                return F;
            }
            throw new IllegalStateException("transitionGroup can't found");
        }
        ee4.b.b("ClipSourceOperator", "transitionGroup can't found!!!");
        return new Entity(0, null, null, null, false, 0, 63, null);
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    public boolean g(@NotNull List<ClipSource> clipSources) {
        Intrinsics.checkParameterIsNotNull(clipSources, "clipSources");
        return d(p(), clipSources);
    }

    @Override // com.tencent.tavcut.operator.IClipSourceOperator
    public void h(@NotNull c iStrategy) {
        Intrinsics.checkParameterIsNotNull(iStrategy, "iStrategy");
        this.iStrategy = iStrategy;
    }

    @NotNull
    public final List<Entity> r() {
        Object firstOrNull;
        List<Entity> emptyList;
        List<Entity> children;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(TransitionTrigger.class)));
        Entity entity = (Entity) firstOrNull;
        if (entity == null || (children = entity.getChildren()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return children;
    }

    public final void s(int size) {
        for (int i3 = 0; i3 < size; i3++) {
            j(this, xd4.c.f447837a.b(), 0, 2, null);
        }
    }

    public final void t(int index) {
        Object firstOrNull;
        if (u()) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.dataDispatcher.E(Reflection.getOrCreateKotlinClass(TransitionTrigger.class)));
            Entity entity = (Entity) firstOrNull;
            if (entity != null && index >= 0 && index < entity.getChildren().size()) {
                this.dataDispatcher.v(entity.getChildren().get(index).getId());
            }
        }
    }
}
