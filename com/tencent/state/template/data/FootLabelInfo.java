package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ks4.c;
import ks4.d;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B'\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b#\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/template/data/FootLabelInfo;", "", "", "isAsyncLibraryLabel", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;", "component1", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;", "component2", "Lcom/tencent/state/template/data/UniFootLabelStyleInfo;", "component3", "scene", "labelType", "info", "copy", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;", "getScene", "()Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;", "setScene", "(Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;)V", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;", "getLabelType", "()Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;", "setLabelType", "(Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;)V", "Lcom/tencent/state/template/data/UniFootLabelStyleInfo;", "getInfo", "()Lcom/tencent/state/template/data/UniFootLabelStyleInfo;", "setInfo", "(Lcom/tencent/state/template/data/UniFootLabelStyleInfo;)V", "<init>", "(Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;Lcom/tencent/state/template/data/UniFootLabelStyleInfo;)V", "Lks4/d;", "pb", "(Lks4/d;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FootLabelInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UniFootLabelStyleInfo info;
    private Companion.LabelType labelType;
    private Companion.SourceScene scene;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/template/data/FootLabelInfo$Companion;", "", "()V", "parseLabelTypePB", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;", "pbVal", "", "parseScenePB", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;", "LabelType", "SourceScene", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;", "", "(Ljava/lang/String;I)V", "NIL", "SYNC", "ASYNC", "STRANGER", "state_square_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public enum LabelType {
            NIL,
            SYNC,
            ASYNC,
            STRANGER
        }

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;", "", "(Ljava/lang/String;I)V", "NIL", "LIBRARY", "STRANGER", "state_square_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public enum SourceScene {
            NIL,
            LIBRARY,
            STRANGER
        }

        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SourceScene parseScenePB(int pbVal) {
            if (pbVal == 1) {
                return SourceScene.LIBRARY;
            }
            if (pbVal != 99) {
                return SourceScene.NIL;
            }
            return SourceScene.STRANGER;
        }

        public final LabelType parseLabelTypePB(int pbVal) {
            if (pbVal == 1) {
                return LabelType.SYNC;
            }
            if (pbVal == 2) {
                return LabelType.ASYNC;
            }
            if (pbVal != 99) {
                return LabelType.NIL;
            }
            return LabelType.STRANGER;
        }
    }

    public FootLabelInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Companion.SourceScene getScene() {
        return this.scene;
    }

    /* renamed from: component2, reason: from getter */
    public final Companion.LabelType getLabelType() {
        return this.labelType;
    }

    /* renamed from: component3, reason: from getter */
    public final UniFootLabelStyleInfo getInfo() {
        return this.info;
    }

    public final FootLabelInfo copy(Companion.SourceScene scene, Companion.LabelType labelType, UniFootLabelStyleInfo info) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(labelType, "labelType");
        return new FootLabelInfo(scene, labelType, info);
    }

    public final UniFootLabelStyleInfo getInfo() {
        return this.info;
    }

    public final Companion.LabelType getLabelType() {
        return this.labelType;
    }

    public final Companion.SourceScene getScene() {
        return this.scene;
    }

    public int hashCode() {
        Companion.SourceScene sourceScene = this.scene;
        int hashCode = (sourceScene != null ? sourceScene.hashCode() : 0) * 31;
        Companion.LabelType labelType = this.labelType;
        int hashCode2 = (hashCode + (labelType != null ? labelType.hashCode() : 0)) * 31;
        UniFootLabelStyleInfo uniFootLabelStyleInfo = this.info;
        return hashCode2 + (uniFootLabelStyleInfo != null ? uniFootLabelStyleInfo.hashCode() : 0);
    }

    public final boolean isAsyncLibraryLabel() {
        return this.scene == Companion.SourceScene.LIBRARY && this.labelType == Companion.LabelType.ASYNC;
    }

    public final void setInfo(UniFootLabelStyleInfo uniFootLabelStyleInfo) {
        this.info = uniFootLabelStyleInfo;
    }

    public final void setLabelType(Companion.LabelType labelType) {
        Intrinsics.checkNotNullParameter(labelType, "<set-?>");
        this.labelType = labelType;
    }

    public final void setScene(Companion.SourceScene sourceScene) {
        Intrinsics.checkNotNullParameter(sourceScene, "<set-?>");
        this.scene = sourceScene;
    }

    public String toString() {
        return "FootLabelInfo(scene=" + this.scene + ", labelType=" + this.labelType + ", info=" + this.info + ")";
    }

    public FootLabelInfo(Companion.SourceScene scene, Companion.LabelType labelType, UniFootLabelStyleInfo uniFootLabelStyleInfo) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(labelType, "labelType");
        this.scene = scene;
        this.labelType = labelType;
        this.info = uniFootLabelStyleInfo;
    }

    public /* synthetic */ FootLabelInfo(Companion.SourceScene sourceScene, Companion.LabelType labelType, UniFootLabelStyleInfo uniFootLabelStyleInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Companion.SourceScene.NIL : sourceScene, (i3 & 2) != 0 ? Companion.LabelType.NIL : labelType, (i3 & 4) != 0 ? null : uniFootLabelStyleInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FootLabelInfo)) {
            return false;
        }
        FootLabelInfo footLabelInfo = (FootLabelInfo) other;
        return Intrinsics.areEqual(this.scene, footLabelInfo.scene) && Intrinsics.areEqual(this.labelType, footLabelInfo.labelType) && Intrinsics.areEqual(this.info, footLabelInfo.info);
    }

    public static /* synthetic */ FootLabelInfo copy$default(FootLabelInfo footLabelInfo, Companion.SourceScene sourceScene, Companion.LabelType labelType, UniFootLabelStyleInfo uniFootLabelStyleInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            sourceScene = footLabelInfo.scene;
        }
        if ((i3 & 2) != 0) {
            labelType = footLabelInfo.labelType;
        }
        if ((i3 & 4) != 0) {
            uniFootLabelStyleInfo = footLabelInfo.info;
        }
        return footLabelInfo.copy(sourceScene, labelType, uniFootLabelStyleInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FootLabelInfo(d pb5) {
        this(Companion.SourceScene.NIL, Companion.LabelType.NIL, null, 4, null);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        Companion companion = INSTANCE;
        this.scene = companion.parseScenePB(pb5.f412963b);
        this.labelType = companion.parseLabelTypePB(pb5.f412962a);
        c cVar = pb5.f412964c;
        Intrinsics.checkNotNullExpressionValue(cVar, "pb.stypeInfo");
        this.info = new UniFootLabelStyleInfo(cVar);
    }
}
