package com.tencent.filament.zplan.animation;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0010j\b\u0012\u0004\u0012\u00020\u0002`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/animation/a;", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "animation", "", "a", "", "now", "Lkotlin/Pair;", "b", "", "c", "()[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "d", "Lorg/json/JSONObject;", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "animations", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<FilamentAnimation> animations = new ArrayList<>();

    public final void a(@NotNull FilamentAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.animations.add(animation);
    }

    @NotNull
    public final Pair<FilamentAnimation, Double> b(double now) {
        FilamentAnimation filamentAnimation;
        double d16 = now % d();
        Iterator<FilamentAnimation> it = this.animations.iterator();
        while (true) {
            if (it.hasNext()) {
                filamentAnimation = it.next();
                if (d16 - filamentAnimation.getDuration() < 0) {
                    break;
                }
                d16 -= filamentAnimation.getDuration();
            } else {
                filamentAnimation = null;
                break;
            }
        }
        return new Pair<>(filamentAnimation, Double.valueOf(d16));
    }

    @NotNull
    public final FilamentAnimation[] c() {
        Object[] array = this.animations.toArray(new FilamentAnimation[0]);
        if (array != null) {
            return (FilamentAnimation[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final double d() {
        Iterator<FilamentAnimation> it = this.animations.iterator();
        double d16 = 0.0d;
        while (it.hasNext()) {
            d16 += it.next().getDuration();
        }
        return d16;
    }

    @NotNull
    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.animations.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((FilamentAnimation) it.next()).toJSON());
        }
        jSONObject.put("animations", jSONArray);
        return jSONObject;
    }
}
