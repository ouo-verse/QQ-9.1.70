package com.tencent.mobileqq.wink.editor.effect;

import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.SpecialEffectModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0010*\u0001\u001e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001e\u0010\u0012\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001fR*\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00028\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/b;", "Lcom/tencent/mobileqq/wink/editor/effect/a;", "", "withCrop", "", "g", "", "b", "getDurationUs", "positionUs", "", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "play", "pause", "", "Lcom/tencent/mobileqq/wink/editor/effect/EffectStatusManager$a;", JsonUtils.KEY_EFFECTS, "targetTime", "c", "Lcom/tencent/videocut/model/SpecialEffectModel;", "a", "destroy", "endUs", "d", "Lcom/tencent/mobileqq/wink/editor/dr;", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutDelegate", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "pauseAction", "com/tencent/mobileqq/wink/editor/effect/b$b", "Lcom/tencent/mobileqq/wink/editor/effect/b$b;", "playerListener", "value", "Z", "getLoop", "()Z", "setLoop", "(Z)V", "loop", "getFrameDuration", "()J", "frameDuration", "<init>", "(Lcom/tencent/mobileqq/wink/editor/dr;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements com.tencent.mobileqq.wink.editor.effect.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dr tavCutDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> pauseAction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C9025b playerListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean loop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((EffectStatusManager.AppliedEffect) t16).getEffectType().ordinal()), Integer.valueOf(((EffectStatusManager.AppliedEffect) t17).getEffectType().ordinal()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/b$b", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.effect.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9025b implements IPlayer.PlayerListener {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.wink.editor.effect.b$b$a */
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f320050a;

            static {
                int[] iArr = new int[IPlayer.PlayerStatus.values().length];
                try {
                    iArr[IPlayer.PlayerStatus.PAUSED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f320050a = iArr;
            }
        }

        C9025b() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            IPlayer.PlayerListener.DefaultImpls.onPlayerSourceReady(this, iPlayer);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long j3, long j16) {
            IPlayer.PlayerListener.DefaultImpls.onPositionChanged(this, j3, j16);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            int i3;
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (status == null) {
                i3 = -1;
            } else {
                i3 = a.f320050a[status.ordinal()];
            }
            if (i3 == 1) {
                Function0 function0 = b.this.pauseAction;
                if (function0 != null) {
                    function0.invoke();
                }
                b.this.pauseAction = null;
            }
        }
    }

    public b(@NotNull dr tavCutDelegate) {
        Intrinsics.checkNotNullParameter(tavCutDelegate, "tavCutDelegate");
        this.tavCutDelegate = tavCutDelegate;
        C9025b c9025b = new C9025b();
        this.playerListener = c9025b;
        tavCutDelegate.addPlayerListener(c9025b);
        this.loop = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private final float g(boolean withCrop) {
        Float f16;
        ?? r56;
        ?? r06;
        int collectionSizeOrDefault;
        ?? r36;
        int collectionSizeOrDefault2;
        ?? r37;
        RectF rectF;
        SizeF sizeF;
        SizeF sizeF2;
        List<MediaClip> a06 = this.tavCutDelegate.a0();
        ArrayList<Pair> arrayList = new ArrayList();
        Iterator it = a06.iterator();
        while (true) {
            f16 = null;
            r3 = null;
            Pair pair = null;
            if (!it.hasNext()) {
                break;
            }
            MediaClip mediaClip = (MediaClip) it.next();
            if (!withCrop) {
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    sizeF2 = resourceModel.size;
                } else {
                    sizeF2 = null;
                }
                if (sizeF2 != null) {
                    pair = TuplesKt.to(Float.valueOf(sizeF2.width), Float.valueOf(sizeF2.height));
                }
            } else {
                ResourceModel resourceModel2 = mediaClip.resource;
                if (resourceModel2 != null) {
                    rectF = resourceModel2.picClipRect;
                } else {
                    rectF = null;
                }
                if (resourceModel2 != null) {
                    sizeF = resourceModel2.size;
                } else {
                    sizeF = null;
                }
                if (rectF != null) {
                    pair = TuplesKt.to(Float.valueOf(Math.abs(rectF.right - rectF.left)), Float.valueOf(Math.abs(rectF.bottom - rectF.top)));
                } else if (sizeF != null) {
                    pair = TuplesKt.to(Float.valueOf(sizeF.width), Float.valueOf(sizeF.height));
                }
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        boolean G = this.tavCutDelegate.G();
        if (!arrayList.isEmpty()) {
            for (Pair pair2 : arrayList) {
                if (((Number) pair2.getFirst()).floatValue() <= ((Number) pair2.getSecond()).floatValue()) {
                    r56 = true;
                } else {
                    r56 = false;
                }
                if (r56 != false) {
                    r06 = true;
                    break;
                }
            }
        }
        r06 = false;
        if (r06 != false) {
            if (!G) {
                ArrayList<Pair> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    Pair pair3 = (Pair) obj;
                    if (((Number) pair3.getFirst()).floatValue() <= ((Number) pair3.getSecond()).floatValue()) {
                        r37 = true;
                    } else {
                        r37 = false;
                    }
                    if (r37 != false) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                for (Pair pair4 : arrayList2) {
                    arrayList3.add(Float.valueOf(((Number) pair4.getSecond()).floatValue() / ((Number) pair4.getFirst()).floatValue()));
                }
                f16 = CollectionsKt___CollectionsKt.m910maxOrNull((Iterable<Float>) arrayList3);
            }
        } else {
            ArrayList<Pair> arrayList4 = new ArrayList();
            for (Object obj2 : arrayList) {
                Pair pair5 = (Pair) obj2;
                if (((Number) pair5.getFirst()).floatValue() > ((Number) pair5.getSecond()).floatValue()) {
                    r36 = true;
                } else {
                    r36 = false;
                }
                if (r36 != false) {
                    arrayList4.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
            ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
            for (Pair pair6 : arrayList4) {
                arrayList5.add(Float.valueOf(((Number) pair6.getSecond()).floatValue() / ((Number) pair6.getFirst()).floatValue()));
            }
            f16 = CollectionsKt___CollectionsKt.m910maxOrNull((Iterable<Float>) arrayList5);
        }
        if (f16 != null) {
            return f16.floatValue();
        }
        return 1.7777778f;
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    @NotNull
    public List<SpecialEffectModel> a() {
        return this.tavCutDelegate.y();
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public long b() {
        return this.tavCutDelegate.getCurrentPlayUs();
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void c(@NotNull List<EffectStatusManager.AppliedEffect> effects, long targetTime) {
        List sortedWith;
        int collectionSizeOrDefault;
        String str;
        String str2;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(effects, "effects");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(effects, new a());
        List list = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            EffectStatusManager.AppliedEffect appliedEffect = (EffectStatusManager.AppliedEffect) obj;
            List<String> m3 = appliedEffect.m();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<T> it = m3.iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) next, (CharSequence) "_landscape", false, 2, (Object) null);
                Boolean valueOf = Boolean.valueOf(contains$default);
                Object obj2 = linkedHashMap.get(valueOf);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(valueOf, obj2);
                }
                ((List) obj2).add(next);
            }
            String valueOf2 = String.valueOf(appliedEffect.getId());
            String name = appliedEffect.getName();
            int color = appliedEffect.getColor();
            List list2 = (List) linkedHashMap.get(Boolean.FALSE);
            if (list2 != null) {
                str2 = (String) list2.get(0);
            } else {
                str2 = null;
            }
            float g16 = g(false);
            String materialId = appliedEffect.getMaterialId();
            long durationUs = appliedEffect.getDurationUs();
            long startOffsetUs = appliedEffect.getStartOffsetUs();
            List list3 = (List) linkedHashMap.get(Boolean.TRUE);
            if (list3 != null) {
                str = (String) list3.get(0);
            }
            arrayList.add(new SpecialEffectModel(valueOf2, name, Integer.valueOf(color), Long.valueOf(startOffsetUs), Long.valueOf(durationUs), null, Float.valueOf(g16), str2, null, null, Integer.valueOf(i3), materialId, null, null, str, null, null, null, Integer.valueOf(appliedEffect.getScaleMode()), Float.valueOf(g(true)), Integer.valueOf(appliedEffect.getTemporary() ? 1 : 0), Integer.valueOf(appliedEffect.getEffectType().ordinal()), null, 4436768, null));
            i3 = i16;
        }
        this.tavCutDelegate.N(arrayList, targetTime);
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void d(long endUs) {
        dr drVar = this.tavCutDelegate;
        drVar.seek(Math.max(0L, endUs - drVar.getFrameDuration()));
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void destroy() {
        this.tavCutDelegate.removePlayerListener(this.playerListener);
        this.pauseAction = null;
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public long getDurationUs() {
        return this.tavCutDelegate.getDurationUs();
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public long getFrameDuration() {
        return this.tavCutDelegate.getFrameDuration();
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void pause() {
        this.tavCutDelegate.pause();
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void play() {
        this.tavCutDelegate.play();
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void seek(long positionUs) {
        this.tavCutDelegate.seek(positionUs);
    }

    @Override // com.tencent.mobileqq.wink.editor.effect.a
    public void setLoop(boolean z16) {
        this.tavCutDelegate.setLoopPlay(z16);
        this.loop = z16;
    }
}
