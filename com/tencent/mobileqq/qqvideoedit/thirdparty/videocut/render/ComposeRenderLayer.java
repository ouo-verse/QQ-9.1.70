package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.tavcut.model.TextPlaceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B#\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", com.tencent.mobileqq.msf.service.b.f250814q, "", "d", "e", "c", "", HippyTKDListViewAdapter.X, "y", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/t;", "a", "Lcom/tencent/tavcut/session/a;", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "current", "", "Z", "getNeedUpdateVideo", "()Z", "setNeedUpdateVideo", "(Z)V", "needUpdateVideo", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/j;", "Ljava/util/List;", "renderLayers", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer$RenderScene;", "renderScene", "<init>", "(Lcom/tencent/tavcut/session/a;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer$RenderScene;)V", "RenderScene", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ComposeRenderLayer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.a tavCutSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediaModel current;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateVideo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<j> renderLayers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer$RenderScene;", "", "(Ljava/lang/String;I)V", "VIDEO", "PIC", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public enum RenderScene {
        VIDEO,
        PIC
    }

    public ComposeRenderLayer(@NotNull com.tencent.tavcut.session.a tavCutSession, @NotNull MediaModel current, @NotNull RenderScene renderScene) {
        List<j> mutableListOf;
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(renderScene, "renderScene");
        this.tavCutSession = tavCutSession;
        this.current = current;
        this.needUpdateVideo = true;
        if (renderScene != RenderScene.VIDEO) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new f(tavCutSession), new l(tavCutSession), new s(tavCutSession), new t(tavCutSession), new k(tavCutSession), new g(tavCutSession));
        } else {
            p pVar = new p(tavCutSession);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new f(tavCutSession), new l(tavCutSession), new e(tavCutSession), new t(tavCutSession), new k(tavCutSession), new g(tavCutSession), new y(tavCutSession), new x(tavCutSession), new s(tavCutSession), new v(tavCutSession), pVar, new o(tavCutSession), new n(pVar, tavCutSession), new m(pVar, tavCutSession));
        }
        this.renderLayers = mutableListOf;
    }

    @Nullable
    public final t a() {
        Object obj;
        Iterator<T> it = this.renderLayers.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((j) obj) instanceof t) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (!(obj instanceof t)) {
            return null;
        }
        return (t) obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
    
        if (r11.equals("text_background_fit") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0135, code lost:
    
        if (r9 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0137, code lost:
    
        r8 = ((int) r9.layerWidth) + 60;
        r9 = ((int) r9.layerHeight) + 60;
        r12 = r10.scale;
        r11 = r8 * r12;
        r13 = r9 * r12;
        r12 = r10.centerX;
        r14 = 1;
        r0 = r5.width;
        r45 = r4;
        r4 = 2;
        r11 = r11 / r4;
        r15 = (((r12 + r14) * r0) / 2.0f) - r11;
        r12 = (((r12 + r14) * r0) / 2.0f) + r11;
        r0 = r10.centerY;
        r11 = -1;
        r46 = r6;
        r6 = r5.height;
        r13 = r13 / r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0188, code lost:
    
        if (com.tencent.videocut.utils.m.f384255a.b(r48, r49, new android.graphics.RectF(r15, ((((r0 * r11) + r14) * r6) / 2.0f) - r13, r12, ((((r0 * r11) + r14) * r6) / 2.0f) + r13), r10.rotate * (-1.0f)) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x018c, code lost:
    
        r0 = r10.textItems;
        r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, 10);
        r4 = new java.util.ArrayList(r6);
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01a3, code lost:
    
        if (r0.hasNext() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01a5, code lost:
    
        r4.add(com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem.copy$default((com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem) r0.next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size(java.lang.Integer.valueOf(r8), java.lang.Integer.valueOf(r9), null, 4, null), null, null, 917503, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01ee, code lost:
    
        r3.add(com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel.copy$default(r10, null, null, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, r4, null, 0, null, null, null, null, 0, 0, 0, null, null, null, null, null, 536854527, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0133, code lost:
    
        if (r11.equals("text_fit") != false) goto L38;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<Object> b(float x16, float y16) {
        Iterator it;
        Object d16;
        int i3;
        ComposeRenderLayer composeRenderLayer = this;
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList<Integer> entitiesUnderPoint = composeRenderLayer.tavCutSession.getEntitiesUnderPoint(x16, y16);
        BackgroundModel backgroundModel = composeRenderLayer.current.backgroundModel;
        if (backgroundModel == null || (r5 = backgroundModel.renderSize) == null) {
            SizeF sizeF = new SizeF(0.0f, 0.0f, null, 4, null);
        }
        Iterator it5 = entitiesUnderPoint.iterator();
        while (it5.hasNext()) {
            int intValue = ((Number) it5.next()).intValue();
            Iterator<T> it6 = composeRenderLayer.renderLayers.iterator();
            while (true) {
                if (it6.hasNext()) {
                    j jVar = (j) it6.next();
                    if ((jVar instanceof r) && (d16 = ((r) jVar).d(intValue)) != null) {
                        if (d16 instanceof StickerModel) {
                            TextPlaceInfo editableTextUnderPoint = composeRenderLayer.tavCutSession.getEditableTextUnderPoint(x16, y16);
                            StickerModel stickerModel = (StickerModel) d16;
                            String str = stickerModel.configType;
                            int hashCode = str.hashCode();
                            if (hashCode != -1003314689) {
                                if (hashCode != 3556653) {
                                    if (hashCode == 1912754898) {
                                    }
                                } else if (str.equals("text")) {
                                    if (editableTextUnderPoint == null) {
                                        arrayList.add(StickerModel.copy$default(stickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, -1, 0L, null, null, null, null, null, 532676607, null));
                                    } else {
                                        arrayList.add(StickerModel.copy$default(stickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, editableTextUnderPoint.replaceIndex, 0L, null, null, null, null, null, 532676607, null));
                                    }
                                }
                                it = it5;
                                i3 = intValue;
                                arrayList.add(d16);
                            }
                        } else {
                            it = it5;
                            i3 = intValue;
                            arrayList.add(d16);
                        }
                        composeRenderLayer = this;
                        it5 = it;
                        intValue = i3;
                    }
                    it = it5;
                    i3 = intValue;
                    composeRenderLayer = this;
                    it5 = it;
                    intValue = i3;
                } else {
                    it = it5;
                    break;
                }
            }
            composeRenderLayer = this;
            it5 = it;
        }
        return arrayList;
    }

    public final void c(@NotNull MediaModel newModel) {
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        if (Intrinsics.areEqual(newModel, this.current)) {
            return;
        }
        Iterator<T> it = this.renderLayers.iterator();
        while (it.hasNext()) {
            ((j) it.next()).c(newModel);
        }
        this.current = newModel;
    }

    public final void d(@NotNull MediaModel newModel) {
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        if (Intrinsics.areEqual(newModel, this.current)) {
            return;
        }
        for (j jVar : this.renderLayers) {
            if (!(jVar instanceof l) || this.needUpdateVideo) {
                jVar.c(newModel);
            }
        }
        this.current = newModel;
        this.tavCutSession.flush();
    }

    public final void e(@NotNull MediaModel newModel) {
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        if (Intrinsics.areEqual(newModel, this.current)) {
            return;
        }
        for (j jVar : this.renderLayers) {
            if (!(jVar instanceof l) || this.needUpdateVideo) {
                jVar.c(newModel);
            }
        }
        this.current = newModel;
        this.tavCutSession.flushWithoutDelay();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ ComposeRenderLayer(com.tencent.tavcut.session.a r24, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel r25, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer.RenderScene r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r23 = this;
            r0 = r27 & 2
            if (r0 == 0) goto L28
            com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel r0 = new com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel
            r1 = r0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 524287(0x7ffff, float:7.34683E-40)
            r22 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            goto L2a
        L28:
            r0 = r25
        L2a:
            r1 = r27 & 4
            if (r1 == 0) goto L35
            com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer$RenderScene r1 = com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer.RenderScene.VIDEO
            r2 = r23
            r3 = r24
            goto L3b
        L35:
            r2 = r23
            r3 = r24
            r1 = r26
        L3b:
            r2.<init>(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer.<init>(com.tencent.tavcut.session.a, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer$RenderScene, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
