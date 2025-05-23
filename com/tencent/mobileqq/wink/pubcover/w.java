package com.tencent.mobileqq.wink.pubcover;

import android.graphics.Matrix;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u0005\r\n\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u000b\u001a\u00020\u0004R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/w;", "", "", "e", "", "a", "d", "Landroid/graphics/Matrix;", "matrix", "g", "c", "f", "Lcom/tencent/mobileqq/wink/pubcover/w$c;", "b", "Lcom/tencent/mobileqq/wink/pubcover/w$c;", "getBeforeDraft", "()Lcom/tencent/mobileqq/wink/pubcover/w$c;", "setBeforeDraft", "(Lcom/tencent/mobileqq/wink/pubcover/w$c;)V", "beforeDraft", "setCurrentDraft", "currentDraft", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f325612a = new w();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static c beforeDraft = new c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static c currentDraft = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0002\u001a\u00020\u0000J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/w$a;", "Lcom/tencent/mobileqq/wink/pubcover/w$b;", "c", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends b {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<? extends LocalMediaInfo> localMediaInfos;

        @NotNull
        public final a c() {
            a aVar = new a();
            if (getLastMatrix() != null) {
                aVar.b(new Matrix(getLastMatrix()));
            }
            aVar.localMediaInfos = this.localMediaInfos;
            return aVar;
        }

        @Nullable
        public final List<LocalMediaInfo> d() {
            return this.localMediaInfos;
        }

        public final void e(@Nullable List<? extends LocalMediaInfo> list) {
            this.localMediaInfos = list;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof a)) {
                return false;
            }
            return Intrinsics.areEqual(this.localMediaInfos, ((a) other).localMediaInfos);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/w$b;", "", "Landroid/graphics/Matrix;", "a", "Landroid/graphics/Matrix;", "()Landroid/graphics/Matrix;", "b", "(Landroid/graphics/Matrix;)V", "lastMatrix", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Matrix lastMatrix;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Matrix getLastMatrix() {
            return this.lastMatrix;
        }

        public final void b(@Nullable Matrix matrix) {
            this.lastMatrix = matrix;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\u0006\u0010\u0002\u001a\u00020\u0000J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0002\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010 \u001a\u0004\b\u001b\u0010!\"\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R2\u00104\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/w$c;", "", "a", "other", "", "equals", "", "I", "c", "()I", "j", "(I)V", "currentTabType", "Lcom/tencent/mobileqq/wink/pubcover/w$d;", "b", "Lcom/tencent/mobileqq/wink/pubcover/w$d;", "g", "()Lcom/tencent/mobileqq/wink/pubcover/w$d;", "setVideoDraft", "(Lcom/tencent/mobileqq/wink/pubcover/w$d;)V", "videoDraft", "Lcom/tencent/mobileqq/wink/pubcover/w$a;", "Lcom/tencent/mobileqq/wink/pubcover/w$a;", "()Lcom/tencent/mobileqq/wink/pubcover/w$a;", "i", "(Lcom/tencent/mobileqq/wink/pubcover/w$a;)V", "albumDraft", "d", "e", "l", "lastCoverBgSelectPostion", "", "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "lastCoverBgSelectColor", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "f", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "templateMetaMaterial", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", tl.h.F, "()Ljava/util/ArrayList;", DomainData.DOMAIN_NAME, "(Ljava/util/ArrayList;)V", "winkStickerModels", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int currentTabType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastCoverBgSelectPostion;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MetaMaterial templateMetaMaterial;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private d videoDraft = new d();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private a albumDraft = new a();

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String lastCoverBgSelectColor = "";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<WinkStickerModel> winkStickerModels = new ArrayList<>();

        @NotNull
        public final c a() {
            MetaMaterial metaMaterial;
            c cVar = new c();
            cVar.currentTabType = this.currentTabType;
            cVar.videoDraft = this.videoDraft.c();
            cVar.albumDraft = this.albumDraft.c();
            cVar.lastCoverBgSelectPostion = this.lastCoverBgSelectPostion;
            cVar.lastCoverBgSelectColor = this.lastCoverBgSelectColor;
            MetaMaterial metaMaterial2 = this.templateMetaMaterial;
            if (metaMaterial2 != null) {
                metaMaterial = metaMaterial2.copy();
            } else {
                metaMaterial = null;
            }
            cVar.templateMetaMaterial = metaMaterial;
            ArrayList<WinkStickerModel> arrayList = this.winkStickerModels;
            ArrayList<WinkStickerModel> arrayList2 = new ArrayList<>();
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((WinkStickerModel) it.next()).copy());
            }
            cVar.winkStickerModels = arrayList2;
            return cVar;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final a getAlbumDraft() {
            return this.albumDraft;
        }

        /* renamed from: c, reason: from getter */
        public final int getCurrentTabType() {
            return this.currentTabType;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getLastCoverBgSelectColor() {
            return this.lastCoverBgSelectColor;
        }

        /* renamed from: e, reason: from getter */
        public final int getLastCoverBgSelectPostion() {
            return this.lastCoverBgSelectPostion;
        }

        public boolean equals(@Nullable Object other) {
            boolean z16;
            String str;
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.currentTabType == cVar.currentTabType) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.albumDraft.d() == null && this.currentTabType == 0) {
                z16 = true;
            }
            if (!z16 || !Intrinsics.areEqual(this.videoDraft, cVar.videoDraft) || !Intrinsics.areEqual(this.albumDraft, cVar.albumDraft) || this.lastCoverBgSelectPostion != cVar.lastCoverBgSelectPostion || !Intrinsics.areEqual(this.lastCoverBgSelectColor, cVar.lastCoverBgSelectColor)) {
                return false;
            }
            MetaMaterial metaMaterial = this.templateMetaMaterial;
            String str2 = null;
            if (metaMaterial != null) {
                str = metaMaterial.f30533id;
            } else {
                str = null;
            }
            MetaMaterial metaMaterial2 = cVar.templateMetaMaterial;
            if (metaMaterial2 != null) {
                str2 = metaMaterial2.f30533id;
            }
            if (!Intrinsics.areEqual(str, str2) || !Intrinsics.areEqual(this.winkStickerModels, cVar.winkStickerModels)) {
                return false;
            }
            return true;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final MetaMaterial getTemplateMetaMaterial() {
            return this.templateMetaMaterial;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final d getVideoDraft() {
            return this.videoDraft;
        }

        @NotNull
        public final ArrayList<WinkStickerModel> h() {
            return this.winkStickerModels;
        }

        public final void i(@NotNull a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.albumDraft = aVar;
        }

        public final void j(int i3) {
            this.currentTabType = i3;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lastCoverBgSelectColor = str;
        }

        public final void l(int i3) {
            this.lastCoverBgSelectPostion = i3;
        }

        public final void m(@Nullable MetaMaterial metaMaterial) {
            this.templateMetaMaterial = metaMaterial;
        }

        public final void n(@NotNull ArrayList<WinkStickerModel> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.winkStickerModels = arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0000J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0005\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/w$d;", "Lcom/tencent/mobileqq/wink/pubcover/w$b;", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "", "isDoubleCut", "", "e", "c", "", "other", "equals", "", "b", "J", "d", "()J", "f", "(J)V", "coverTimeProgress", "Z", "()Z", "g", "(Z)V", "", UserInfo.SEX_FEMALE, "getOriginalHeight", "()F", "i", "(F)V", "originalHeight", "getOriginWidth", tl.h.F, "originWidth", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends b {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isDoubleCut;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long coverTimeProgress = -1;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float originalHeight = 1.0f;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float originWidth = 1.0f;

        @NotNull
        public final d c() {
            d dVar = new d();
            if (getLastMatrix() != null) {
                dVar.b(new Matrix(getLastMatrix()));
            }
            dVar.coverTimeProgress = this.coverTimeProgress;
            return dVar;
        }

        /* renamed from: d, reason: from getter */
        public final long getCoverTimeProgress() {
            return this.coverTimeProgress;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(@Nullable TimelineViewModelV2 timelineViewModel, boolean isDoubleCut) {
            float f16;
            float f17;
            boolean z16;
            List<MediaClip> u26;
            Object orNull;
            if (this.isDoubleCut && !isDoubleCut && this.originalHeight >= 100.0f && this.originWidth >= 100.0f) {
                boolean z17 = false;
                if (timelineViewModel != null && (u26 = timelineViewModel.u2()) != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(u26, 0);
                    MediaClip mediaClip = (MediaClip) orNull;
                    if (mediaClip != null) {
                        f17 = com.tencent.videocut.render.extension.e.o(mediaClip).width;
                        f16 = com.tencent.videocut.render.extension.e.o(mediaClip).height;
                        if (f17 != 0.0f) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            if (f16 == 0.0f) {
                                z17 = true;
                            }
                            if (!z17 && getLastMatrix() != null) {
                                float f18 = f17 / this.originWidth;
                                Matrix lastMatrix = getLastMatrix();
                                Intrinsics.checkNotNull(lastMatrix);
                                float f19 = f18 * com.tencent.mobileqq.wink.editor.crop.a.f(lastMatrix);
                                float f26 = f16 / this.originalHeight;
                                Matrix lastMatrix2 = getLastMatrix();
                                Intrinsics.checkNotNull(lastMatrix2);
                                float g16 = f26 * com.tencent.mobileqq.wink.editor.crop.a.g(lastMatrix2);
                                Matrix lastMatrix3 = getLastMatrix();
                                Intrinsics.checkNotNull(lastMatrix3);
                                Matrix lastMatrix4 = getLastMatrix();
                                Intrinsics.checkNotNull(lastMatrix4);
                                float f27 = f19 - com.tencent.mobileqq.wink.editor.crop.a.f(lastMatrix4);
                                Matrix lastMatrix5 = getLastMatrix();
                                Intrinsics.checkNotNull(lastMatrix5);
                                lastMatrix3.postTranslate(f27, g16 - com.tencent.mobileqq.wink.editor.crop.a.g(lastMatrix5));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                f16 = 0.0f;
                f17 = 0.0f;
                if (f17 != 0.0f) {
                }
                if (z16) {
                }
            }
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof d)) {
                return false;
            }
            long j3 = this.coverTimeProgress;
            if ((j3 != 0 || ((d) other).coverTimeProgress != -1) && ((j3 != -1 || ((d) other).coverTimeProgress != 0) && j3 != ((d) other).coverTimeProgress)) {
                return false;
            }
            return true;
        }

        public final void f(long j3) {
            this.coverTimeProgress = j3;
        }

        public final void g(boolean z16) {
            this.isDoubleCut = z16;
        }

        public final void h(float f16) {
            this.originWidth = f16;
        }

        public final void i(float f16) {
            this.originalHeight = f16;
        }
    }

    w() {
    }

    public final void a() {
        beforeDraft = new c();
        currentDraft = new c();
    }

    @NotNull
    public final c b() {
        return currentDraft;
    }

    @Nullable
    public final Matrix c() {
        if (currentDraft.getCurrentTabType() == 1) {
            return currentDraft.getAlbumDraft().getLastMatrix();
        }
        return currentDraft.getVideoDraft().getLastMatrix();
    }

    public final void d() {
        beforeDraft = currentDraft.a();
    }

    public final boolean e() {
        return !Intrinsics.areEqual(beforeDraft, currentDraft);
    }

    public final void f() {
        currentDraft = beforeDraft;
    }

    public final void g(@Nullable Matrix matrix) {
        if (currentDraft.getCurrentTabType() == 1) {
            currentDraft.getAlbumDraft().b(matrix);
        } else {
            currentDraft.getVideoDraft().b(matrix);
        }
    }
}
