package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b!\u0010\"J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/d;", "T", "V", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/r;", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "j", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "k", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;)Ljava/lang/Object;", "", "f", "(Ljava/lang/Object;)Ljava/lang/String;", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", "", tl.h.F, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "g", "mediaModel", "c", "", TemplateParser.KEY_ENTITY_ID, "", "d", "a", "Ljava/lang/Object;", "currentModel", "b", "Ljava/lang/Integer;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class d<T, V> implements r<V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T currentModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer entityId;

    private final void j(T newModel, T oldModel) {
        if (g(newModel, oldModel)) {
            return;
        }
        if (newModel == null) {
            Integer num = this.entityId;
            if (num != null) {
                a(num.intValue());
            }
            this.entityId = null;
            return;
        }
        V i3 = i(newModel);
        if (oldModel == null) {
            this.entityId = Integer.valueOf(b(i3));
            return;
        }
        V i16 = i(oldModel);
        if (h(newModel, oldModel)) {
            Integer num2 = this.entityId;
            if (num2 != null) {
                e(num2.intValue(), i16, i3);
                return;
            }
            return;
        }
        Integer num3 = this.entityId;
        if (num3 != null) {
            a(num3.intValue());
        }
        this.entityId = Integer.valueOf(b(i3));
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.j
    public void c(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        T k3 = k(mediaModel);
        j(k3, this.currentModel);
        this.currentModel = k3;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    @Nullable
    public Object d(int entityId) {
        Integer num = this.entityId;
        if (num != null && entityId == num.intValue()) {
            return this.currentModel;
        }
        return null;
    }

    @Nullable
    public abstract String f(@Nullable T model);

    public boolean g(@Nullable T newModel, @Nullable T oldModel) {
        return Intrinsics.areEqual(newModel, oldModel);
    }

    public boolean h(@Nullable T newModel, @Nullable T oldModel) {
        if (newModel == null && oldModel == null) {
            return true;
        }
        if (newModel != null && oldModel != null) {
            return Intrinsics.areEqual(f(newModel), f(oldModel));
        }
        return false;
    }

    public abstract V i(T model);

    @Nullable
    public abstract T k(@NotNull MediaModel model);
}
