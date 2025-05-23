package com.tencent.videocut.render;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u0003\u001f#&B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b6\u00107J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000bR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010'R\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002030\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010$\u00a8\u00069"}, d2 = {"Lcom/tencent/videocut/render/k;", "Lcom/tencent/videocut/render/i;", "", "Lcom/tencent/videocut/model/MediaClip;", "newClips", "j", "", "r", "l", "newItem", "oldItem", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mediaClip", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "fromPosition", "toPosition", "o", "position", "count", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "d", "enable", "i", "Lcom/tencent/tavcut/core/session/ICutSession;", "a", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "", "b", "Ljava/util/List;", "oldList", "c", "Z", "needAutoLoop", "Lcom/tencent/videocut/render/j;", "Lcom/tencent/videocut/render/j;", "lutFilterModelRender", "", "Lorg/light/lightAssetKit/Entity;", "e", "Ljava/util/Map;", "entitys", "f", "enableFilter", "Lcom/tencent/videocut/render/k$b;", "g", "mediaClipChangedDataList", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", tl.h.F, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class k implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MediaClip> oldList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean needAutoLoop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j lutFilterModelRender;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Entity> entitys;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableFilter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<b> mediaClipChangedDataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/render/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.k$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/videocut/render/k$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "position", "b", "count", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(IILjava/lang/Object;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int count;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Object payload;

        public b(int i3, int i16, @Nullable Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
                return;
            }
            this.position = i3;
            this.count = i16;
            this.payload = obj;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.count;
        }

        @Nullable
        public final Object b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.payload;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.position == bVar.position && this.count == bVar.count && Intrinsics.areEqual(this.payload, bVar.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int i3 = ((this.position * 31) + this.count) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "MediaClipChangedData(position=" + this.position + ", count=" + this.count + ", payload=" + this.payload + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/videocut/render/k$c;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "", "Lcom/tencent/videocut/model/MediaClip;", "a", "Ljava/util/List;", "getOldClips", "()Ljava/util/List;", "oldClips", "b", "getNewClips", "newClips", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class c extends DiffUtil.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MediaClip> oldClips;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MediaClip> newClips;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull List<? extends MediaClip> oldClips, @NotNull List<? extends MediaClip> newClips) {
            Intrinsics.checkNotNullParameter(oldClips, "oldClips");
            Intrinsics.checkNotNullParameter(newClips, "newClips");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oldClips, (Object) newClips);
            } else {
                this.oldClips = oldClips;
                this.newClips = newClips;
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            if (Intrinsics.areEqual(this.oldClips.get(oldItemPosition).resource, this.newClips.get(newItemPosition).resource) && Intrinsics.areEqual(this.oldClips.get(oldItemPosition).matrix, this.newClips.get(newItemPosition).matrix) && Intrinsics.areEqual(this.oldClips.get(oldItemPosition).filter, this.newClips.get(newItemPosition).filter)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
            }
            ResourceModel resourceModel = this.oldClips.get(oldItemPosition).resource;
            String str2 = null;
            if (resourceModel != null) {
                str = resourceModel.id;
            } else {
                str = null;
            }
            ResourceModel resourceModel2 = this.newClips.get(newItemPosition).resource;
            if (resourceModel2 != null) {
                str2 = resourceModel2.id;
            }
            return Intrinsics.areEqual(str, str2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @Nullable
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return iPatchRedirector.redirect((short) 8, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition));
            }
            return this.newClips.get(newItemPosition);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.newClips.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.oldClips.size();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/videocut/render/k$d", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "position", "count", "", "onInserted", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class d implements ListUpdateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<MediaClip> f384169e;

        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends MediaClip> list) {
            this.f384169e = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) list);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, @Nullable Object payload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), Integer.valueOf(count), payload);
            } else {
                k.this.mediaClipChangedDataList.add(new b(position, count, payload));
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                k.this.n(count, position, this.f384169e);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), Integer.valueOf(count));
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                k.this.o(fromPosition, toPosition);
            } else {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                k.this.p(position, count);
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), Integer.valueOf(count));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
            return;
        }
        this.tavCutSession = tavCutSession;
        this.oldList = new ArrayList();
        this.lutFilterModelRender = new j(tavCutSession);
        this.entitys = new LinkedHashMap();
        this.enableFilter = true;
        this.mediaClipChangedDataList = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<MediaClip> j(List<? extends MediaClip> newClips) {
        FilterModel filterModel;
        long j3;
        Long l3;
        if (!this.enableFilter) {
            return newClips;
        }
        ArrayList arrayList = new ArrayList();
        long j16 = 0;
        for (MediaClip mediaClip : newClips) {
            FilterModel filterModel2 = mediaClip.filter;
            if (filterModel2 != null) {
                Long valueOf = Long.valueOf(j16);
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    l3 = Long.valueOf(resourceModel.scaleDuration);
                } else {
                    l3 = null;
                }
                filterModel = FilterModel.copy$default(filterModel2, null, null, null, valueOf, l3, null, null, 103, null);
            } else {
                filterModel = null;
            }
            arrayList.add(MediaClip.copy$default(mediaClip, null, null, filterModel, null, null, null, null, 123, null));
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                j3 = resourceModel2.scaleDuration;
            } else {
                j3 = 0;
            }
            j16 += j3;
        }
        return arrayList;
    }

    private final String k(MediaClip mediaClip) {
        String str;
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null || (str = resourceModel.id) == null) {
            str = "default";
        }
        return "mediaClip_" + str;
    }

    private final void l() {
        LAKRenderModel allInputSourceRenderModel;
        List<ClipSource> clipsAssets;
        int collectionSizeOrDefault;
        List<ClipSource> mutableList;
        IntRange until;
        int collectionSizeOrDefault2;
        ClipSource clipSource;
        Boolean bool;
        List<ClipSource> clipsAssets2;
        ClipSource copy;
        if (!this.mediaClipChangedDataList.isEmpty() && (allInputSourceRenderModel = this.tavCutSession.getAllInputSourceRenderModel()) != null && (clipsAssets = allInputSourceRenderModel.getClipsAssets()) != null) {
            List<ClipSource> list = clipsAssets;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                copy = r5.copy((r30 & 1) != 0 ? r5.sourceId : null, (r30 & 2) != 0 ? r5.path : null, (r30 & 4) != 0 ? r5.type : null, (r30 & 8) != 0 ? r5.duration : 0L, (r30 & 16) != 0 ? r5.speed : null, (r30 & 32) != 0 ? r5.volume : null, (r30 & 64) != 0 ? r5.startOffset : null, (r30 & 128) != 0 ? r5.matrix : null, (r30 & 256) != 0 ? r5.photoEffectPath : null, (r30 & 512) != 0 ? r5.transform : null, (r30 & 1024) != 0 ? r5.clipRect : null, (r30 & 2048) != 0 ? r5.byteArray : null, (r30 & 4096) != 0 ? ((ClipSource) it.next()).autoLoop : null);
                arrayList.add(copy);
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            if (mutableList != null) {
                ArrayList arrayList2 = new ArrayList();
                boolean z16 = true;
                for (b bVar : this.mediaClipChangedDataList) {
                    until = RangesKt___RangesKt.until(0, bVar.a());
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                    Iterator<Integer> it5 = until.iterator();
                    while (it5.hasNext()) {
                        arrayList3.add(Integer.valueOf(bVar.c() + ((IntIterator) it5).nextInt()));
                    }
                    Iterator it6 = arrayList3.iterator();
                    while (it6.hasNext()) {
                        int intValue = ((Number) it6.next()).intValue();
                        MediaClip mediaClip = this.oldList.get(intValue);
                        LAKRenderModel allInputSourceRenderModel2 = this.tavCutSession.getAllInputSourceRenderModel();
                        if (allInputSourceRenderModel2 != null && (clipsAssets2 = allInputSourceRenderModel2.getClipsAssets()) != null) {
                            clipSource = clipsAssets2.get(intValue);
                        } else {
                            clipSource = null;
                        }
                        Object b16 = bVar.b();
                        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.videocut.model.MediaClip");
                        MediaClip mediaClip2 = (MediaClip) b16;
                        this.oldList.set(intValue, mediaClip2);
                        if (clipSource != null) {
                            bool = clipSource.getAutoLoop();
                        } else {
                            bool = null;
                        }
                        ClipSource A = com.tencent.videocut.render.extension.e.A(mediaClip2, false, bool, 1, null);
                        if (A != null) {
                            arrayList2.add(A);
                            if (intValue < mutableList.size()) {
                                mutableList.set(intValue, A);
                            }
                        }
                        if (z16 && q(mediaClip2, mediaClip)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        m(mediaClip2, mediaClip);
                    }
                }
                w53.b.a("MediaClipProcessor", "onChanged  isOnlyFilterChanged " + z16);
                if (!z16 || arrayList2.isEmpty()) {
                    this.tavCutSession.getIClipSourceOperator().e(0, mutableList);
                }
                this.mediaClipChangedDataList.clear();
            }
        }
    }

    private final void m(MediaClip newItem, MediaClip oldItem) {
        Entity b16;
        String str;
        FilterModel filterModel;
        String str2;
        if (!this.enableFilter) {
            return;
        }
        String k3 = k(newItem);
        Entity entity = this.entitys.get(k3);
        String str3 = null;
        if (entity != null) {
            FilterModel filterModel2 = newItem.filter;
            if (filterModel2 != null) {
                j jVar = this.lutFilterModelRender;
                if (oldItem != null) {
                    filterModel = oldItem.filter;
                } else {
                    filterModel = null;
                }
                jVar.a(entity, filterModel, filterModel2);
                ResourceModel resourceModel = newItem.resource;
                if (resourceModel != null) {
                    str2 = resourceModel.path;
                } else {
                    str2 = null;
                }
                FilterModel filterModel3 = newItem.filter;
                LutFilterModel lutFilterModel = filterModel3.lut;
                if (lutFilterModel != null) {
                    str3 = lutFilterModel.name;
                }
                w53.b.a("MediaClipProcessor", "update entity:" + str2 + ",filter:" + str3 + "," + filterModel3.startTimeUs + "," + filterModel3.durationUs);
                return;
            }
            this.entitys.remove(k3);
            this.lutFilterModelRender.removeEntity(entity);
            ResourceModel resourceModel2 = newItem.resource;
            if (resourceModel2 != null) {
                str3 = resourceModel2.path;
            }
            w53.b.a("MediaClipProcessor", "remove entity:" + str3);
            return;
        }
        FilterModel filterModel4 = newItem.filter;
        if (filterModel4 != null && (b16 = this.lutFilterModelRender.b(com.tencent.videocut.render.extension.c.b(filterModel4, false))) != null) {
            this.entitys.put(k3, b16);
            ResourceModel resourceModel3 = newItem.resource;
            if (resourceModel3 != null) {
                str = resourceModel3.path;
            } else {
                str = null;
            }
            LutFilterModel lutFilterModel2 = filterModel4.lut;
            if (lutFilterModel2 != null) {
                str3 = lutFilterModel2.name;
            }
            w53.b.a("MediaClipProcessor", "add entity:" + str + ",filter:" + str3 + "," + filterModel4.startTimeUs + "," + filterModel4.durationUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int count, int position, List<? extends MediaClip> newClips) {
        Iterable withIndex;
        int i3;
        int i16;
        IntRange until;
        l();
        ArrayList arrayList = new ArrayList();
        if (position == 0) {
            i16 = 0;
        } else {
            MediaClip mediaClip = this.oldList.get(position - 1);
            withIndex = CollectionsKt___CollectionsKt.withIndex(newClips);
            Object obj = null;
            for (Object obj2 : withIndex) {
                if (Intrinsics.areEqual(com.tencent.videocut.render.extension.e.n((MediaClip) ((IndexedValue) obj2).getValue()), com.tencent.videocut.render.extension.e.n(mediaClip))) {
                    obj = obj2;
                }
            }
            IndexedValue indexedValue = (IndexedValue) obj;
            if (indexedValue != null) {
                i3 = indexedValue.getIndex();
            } else {
                i3 = 0;
            }
            i16 = i3 + 1;
        }
        until = RangesKt___RangesKt.until(0, count);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            int i17 = i16 + nextInt;
            if (i17 >= newClips.size()) {
                i17 = newClips.size() - 1;
            }
            MediaClip mediaClip2 = newClips.get(i17);
            this.oldList.add(nextInt + position, mediaClip2);
            ClipSource A = com.tencent.videocut.render.extension.e.A(mediaClip2, false, Boolean.valueOf(this.needAutoLoop), 1, null);
            if (A != null) {
                arrayList.add(A);
            }
            m(mediaClip2, null);
            w53.b.a("MediaClipProcessor", "onInserted  position " + position + ", count " + count + ", newItem " + mediaClip2);
        }
        this.tavCutSession.getIClipSourceOperator().d(position, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int fromPosition, int toPosition) {
        l();
        w53.b.a("MediaClipProcessor", "onMoved  fromPosition " + fromPosition + ", toPosition " + toPosition);
        this.oldList.add(toPosition, this.oldList.remove(fromPosition));
        this.tavCutSession.getIClipSourceOperator().a(fromPosition, toPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
    
        if (r2 == com.tencent.tavcut.core.render.builder.light.model.type.ClipType.PHOTO) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(int position, int count) {
        ClipType clipType;
        int i3;
        ClipSource clipSource;
        boolean z16;
        List<ClipSource> clipsAssets;
        List<ClipSource> clipsAssets2;
        FilterModel filterModel;
        String str;
        l();
        boolean z17 = false;
        int i16 = 0;
        while (true) {
            clipType = null;
            String str2 = null;
            if (i16 >= count) {
                break;
            }
            MediaClip remove = this.oldList.remove(position);
            if (this.enableFilter && (filterModel = remove.filter) != null) {
                ResourceModel resourceModel = remove.resource;
                if (resourceModel != null) {
                    str = resourceModel.path;
                } else {
                    str = null;
                }
                LutFilterModel lutFilterModel = filterModel.lut;
                if (lutFilterModel != null) {
                    str2 = lutFilterModel.name;
                }
                w53.b.a("MediaClipProcessor", "remove entity:" + str + ",filter:" + str2 + "," + filterModel.startTimeUs + "," + filterModel.durationUs);
                String k3 = k(remove);
                Entity entity = this.entitys.get(k3);
                if (entity != null) {
                    this.lutFilterModelRender.removeEntity(entity);
                    this.entitys.remove(k3);
                }
            }
            i16++;
        }
        LAKRenderModel allInputSourceRenderModel = this.tavCutSession.getAllInputSourceRenderModel();
        if (allInputSourceRenderModel != null && (clipsAssets2 = allInputSourceRenderModel.getClipsAssets()) != null) {
            i3 = clipsAssets2.size();
        } else {
            i3 = 0;
        }
        if (position < i3) {
            LAKRenderModel allInputSourceRenderModel2 = this.tavCutSession.getAllInputSourceRenderModel();
            if (allInputSourceRenderModel2 != null && (clipsAssets = allInputSourceRenderModel2.getClipsAssets()) != null) {
                clipSource = clipsAssets.get(position);
            } else {
                clipSource = null;
            }
            if (clipSource != null) {
                z16 = Intrinsics.areEqual(clipSource.getAutoLoop(), Boolean.TRUE);
            } else {
                z16 = false;
            }
            if (!z16) {
                if (clipSource != null) {
                    clipType = clipSource.getType();
                }
            }
            z17 = true;
            this.needAutoLoop = z17;
        }
        this.tavCutSession.getIClipSourceOperator().c(position, count + position);
    }

    private final boolean q(MediaClip newItem, MediaClip oldItem) {
        ResourceModel resourceModel;
        ResourceModel resourceModel2 = newItem.resource;
        List<Float> list = null;
        if (oldItem != null) {
            resourceModel = oldItem.resource;
        } else {
            resourceModel = null;
        }
        if (Intrinsics.areEqual(resourceModel2, resourceModel)) {
            List<Float> list2 = newItem.matrix;
            if (oldItem != null) {
                list = oldItem.matrix;
            }
            if (Intrinsics.areEqual(list2, list)) {
                return true;
            }
        }
        return false;
    }

    private final void r(List<? extends MediaClip> newClips) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new c(this.oldList, newClips));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(MediaClips\u2026lBack(oldList, newClips))");
        calculateDiff.dispatchUpdatesTo(new d(newClips));
        l();
    }

    @Override // com.tencent.videocut.render.i
    public void d(@NotNull MediaModel mediaModel) {
        List emptyList;
        String str;
        List<ClipSource> clipsAssets;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaModel);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        List<MediaClip> j3 = j(new ArrayList(mediaModel.videos));
        if (this.oldList.isEmpty()) {
            LAKRenderModel allInputSourceRenderModel = this.tavCutSession.getAllInputSourceRenderModel();
            if (allInputSourceRenderModel == null || (clipsAssets = allInputSourceRenderModel.getClipsAssets()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                List<ClipSource> list = clipsAssets;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                emptyList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    emptyList.add(((ClipSource) it.next()).getSourceId());
                }
            }
            for (MediaClip mediaClip : j3) {
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    str = resourceModel.id;
                } else {
                    str = null;
                }
                if (emptyList.contains(str)) {
                    this.oldList.add(MediaClip.copy$default(mediaClip, null, null, null, null, null, null, null, 123, null));
                }
            }
        }
        r(j3);
    }

    public final void i(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, enable);
        } else {
            this.enableFilter = enable;
        }
    }
}
