package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\u0018\u0000 ?2\u00020\u0001:\u0002@AB\u0097\u0001\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u00b4\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0010H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u000b\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b(\u0010'R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u000e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b,\u0010+R&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0011\u0010-\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b2\u0010/R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0016\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u00103\u001a\u0004\b6\u00105R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b7\u0010'R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b8\u0010'R\u0017\u0010\u0019\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b9\u0010+R\u0017\u0010\u001a\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/Config;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "getQZoneMediaType", "Lcom/tencent/mobileqq/wink/picker/TabType;", "localMediaTabType", "initLocalMediaTab", "initLocalDbQueryType", "qZoneMediaTabType", "", "needDragSelect", "needScrollTimeline", "", "maxSelectMediaSize", "startCountNum", "", "", "alreadySelectedMediaPath", "Lcom/tencent/mobileqq/wink/picker/MediaInfo;", "alreadySelectedMedia", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "queryMediaFilter", "selectMediaFilter", "needShowExitDialog", "firstIconCamera", "businessRequestCode", "from", "copy", "toString", "Lcom/tencent/mobileqq/wink/picker/TabType;", "getLocalMediaTabType", "()Lcom/tencent/mobileqq/wink/picker/TabType;", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "getInitLocalMediaTab", "()Lcom/tencent/mobileqq/wink/picker/MediaType;", "getInitLocalDbQueryType", "getQZoneMediaTabType", "Z", "getNeedDragSelect", "()Z", "getNeedScrollTimeline", "I", "getMaxSelectMediaSize", "()I", "getStartCountNum", "Ljava/util/List;", "getAlreadySelectedMediaPath", "()Ljava/util/List;", "getAlreadySelectedMediaPath$annotations", "()V", "getAlreadySelectedMedia", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "getQueryMediaFilter", "()Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "getSelectMediaFilter", "getNeedShowExitDialog", "getFirstIconCamera", "getBusinessRequestCode", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "<init>", "(Lcom/tencent/mobileqq/wink/picker/TabType;Lcom/tencent/mobileqq/wink/picker/MediaType;Lcom/tencent/mobileqq/wink/picker/TabType;Lcom/tencent/mobileqq/wink/picker/TabType;ZZIILjava/util/List;Ljava/util/List;Lcom/tencent/mobileqq/wink/picker/MediaFilter;Lcom/tencent/mobileqq/wink/picker/MediaFilter;ZZILjava/lang/String;)V", "Companion", "a", "b", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class Config implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final List<MediaInfo> alreadySelectedMedia;

    @NotNull
    private final List<String> alreadySelectedMediaPath;
    private final int businessRequestCode;
    private final boolean firstIconCamera;

    @NotNull
    private final String from;

    @NotNull
    private final TabType initLocalDbQueryType;

    @NotNull
    private final MediaType initLocalMediaTab;

    @NotNull
    private final TabType localMediaTabType;
    private final int maxSelectMediaSize;
    private final boolean needDragSelect;
    private final boolean needScrollTimeline;
    private final boolean needShowExitDialog;

    /* renamed from: qZoneMediaTabType, reason: from kotlin metadata and from toString */
    @Nullable
    private final TabType ZoneMediaTabType;

    @NotNull
    private final MediaFilter queryMediaFilter;

    @NotNull
    private final MediaFilter selectMediaFilter;
    private final int startCountNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bS\u00108J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\f\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010)\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R.\u00109\u001a\b\u0012\u0004\u0012\u000202018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\b\u00103\u0012\u0004\b7\u00108\u001a\u0004\b4\u00105\"\u0004\b\u0017\u00106R(\u0010<\u001a\b\u0012\u0004\u0012\u00020:018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00103\u001a\u0004\b;\u00105\"\u0004\b\u0013\u00106R\"\u0010C\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010G\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010>\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR\"\u0010I\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\bH\u0010\u001f\"\u0004\bD\u0010!R\"\u0010K\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001d\u001a\u0004\bJ\u0010\u001f\"\u0004\b#\u0010!R\"\u0010M\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010)\u001a\u0004\bL\u0010*\"\u0004\b\u001c\u0010,R\"\u0010R\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010N\u001a\u0004\bO\u0010P\"\u0004\b(\u0010Q\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/Config$a;", "", "Lcom/tencent/mobileqq/wink/picker/Config;", "a", "Lcom/tencent/mobileqq/wink/picker/TabType;", "Lcom/tencent/mobileqq/wink/picker/TabType;", "getLocalMediaTabType", "()Lcom/tencent/mobileqq/wink/picker/TabType;", "i", "(Lcom/tencent/mobileqq/wink/picker/TabType;)V", "localMediaTabType", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "b", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "getInitLocalMediaTab", "()Lcom/tencent/mobileqq/wink/picker/MediaType;", tl.h.F, "(Lcom/tencent/mobileqq/wink/picker/MediaType;)V", "initLocalMediaTab", "c", "getInitLocalDbQueryType", "setInitLocalDbQueryType", "initLocalDbQueryType", "d", "getQZoneMediaTabType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qZoneMediaTabType", "", "e", "Z", "getNeedDragSelect", "()Z", "k", "(Z)V", "needDragSelect", "f", "getNeedScrollTimeline", "setNeedScrollTimeline", "needScrollTimeline", "", "g", "I", "()I", "j", "(I)V", "maxSelectMediaSize", "getStartCountNum", "p", "startCountNum", "", "", "Ljava/util/List;", "getAlreadySelectedMediaPath", "()Ljava/util/List;", "(Ljava/util/List;)V", "getAlreadySelectedMediaPath$annotations", "()V", "alreadySelectedMediaPath", "Lcom/tencent/mobileqq/wink/picker/MediaInfo;", "getAlreadySelectedMedia", "alreadySelectedMedia", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "getQueryMediaFilter", "()Lcom/tencent/mobileqq/wink/picker/MediaFilter;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/wink/picker/MediaFilter;)V", "queryMediaFilter", "l", "getSelectMediaFilter", "o", "selectMediaFilter", "getNeedShowExitDialog", "needShowExitDialog", "getFirstIconCamera", "firstIconCamera", "getBusinessRequestCode", "businessRequestCode", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "from", "<init>", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private TabType localMediaTabType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MediaType initLocalMediaTab;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private TabType initLocalDbQueryType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TabType qZoneMediaTabType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean needDragSelect;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean needScrollTimeline;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int maxSelectMediaSize;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int startCountNum;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<String> alreadySelectedMediaPath;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<MediaInfo> alreadySelectedMedia;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MediaFilter queryMediaFilter;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MediaFilter selectMediaFilter;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean needShowExitDialog;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean firstIconCamera;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int businessRequestCode;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String from;

        public a() {
            List<String> emptyList;
            List<MediaInfo> emptyList2;
            TabType tabType = TabType.ALL_MEDIA;
            this.localMediaTabType = tabType;
            this.initLocalMediaTab = MediaType.LOCAL_ALL;
            this.initLocalDbQueryType = tabType;
            this.needScrollTimeline = true;
            this.maxSelectMediaSize = 35;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.alreadySelectedMediaPath = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.alreadySelectedMedia = emptyList2;
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            this.queryMediaFilter = new MediaFilter.a().a();
            this.selectMediaFilter = new MediaFilter.a().a();
            this.needShowExitDialog = true;
            this.from = "";
        }

        @NotNull
        public final Config a() {
            return new Config(this.localMediaTabType, this.initLocalMediaTab, this.initLocalDbQueryType, this.qZoneMediaTabType, this.needDragSelect, this.needScrollTimeline, this.maxSelectMediaSize, this.startCountNum, this.alreadySelectedMediaPath, this.alreadySelectedMedia, this.queryMediaFilter, this.selectMediaFilter, this.needShowExitDialog, this.firstIconCamera, this.businessRequestCode, this.from, null);
        }

        /* renamed from: b, reason: from getter */
        public final int getMaxSelectMediaSize() {
            return this.maxSelectMediaSize;
        }

        public final void c(@NotNull List<MediaInfo> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.alreadySelectedMedia = list;
        }

        public final void d(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.alreadySelectedMediaPath = list;
        }

        public final void e(int i3) {
            this.businessRequestCode = i3;
        }

        public final void f(boolean z16) {
            this.firstIconCamera = z16;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.from = str;
        }

        public final void h(@NotNull MediaType mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "<set-?>");
            this.initLocalMediaTab = mediaType;
        }

        public final void i(@NotNull TabType tabType) {
            Intrinsics.checkNotNullParameter(tabType, "<set-?>");
            this.localMediaTabType = tabType;
        }

        public final void j(int i3) {
            this.maxSelectMediaSize = i3;
        }

        public final void k(boolean z16) {
            this.needDragSelect = z16;
        }

        public final void l(boolean z16) {
            this.needShowExitDialog = z16;
        }

        public final void m(@Nullable TabType tabType) {
            this.qZoneMediaTabType = tabType;
        }

        public final void n(@NotNull MediaFilter mediaFilter) {
            Intrinsics.checkNotNullParameter(mediaFilter, "<set-?>");
            this.queryMediaFilter = mediaFilter;
        }

        public final void o(@NotNull MediaFilter mediaFilter) {
            Intrinsics.checkNotNullParameter(mediaFilter, "<set-?>");
            this.selectMediaFilter = mediaFilter;
        }

        public final void p(int i3) {
            this.startCountNum = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/Config$b;", "", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.Config$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324400a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.ALL_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.ONLY_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.ONLY_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f324400a = iArr;
        }
    }

    public /* synthetic */ Config(TabType tabType, MediaType mediaType, TabType tabType2, TabType tabType3, boolean z16, boolean z17, int i3, int i16, List list, List list2, MediaFilter mediaFilter, MediaFilter mediaFilter2, boolean z18, boolean z19, int i17, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(tabType, mediaType, tabType2, tabType3, z16, z17, i3, i16, list, list2, mediaFilter, mediaFilter2, z18, z19, i17, str);
    }

    @NotNull
    public final Config copy(@NotNull TabType localMediaTabType, @NotNull MediaType initLocalMediaTab, @NotNull TabType initLocalDbQueryType, @Nullable TabType qZoneMediaTabType, boolean needDragSelect, boolean needScrollTimeline, int maxSelectMediaSize, int startCountNum, @NotNull List<String> alreadySelectedMediaPath, @NotNull List<MediaInfo> alreadySelectedMedia, @NotNull MediaFilter queryMediaFilter, @NotNull MediaFilter selectMediaFilter, boolean needShowExitDialog, boolean firstIconCamera, int businessRequestCode, @NotNull String from) {
        Intrinsics.checkNotNullParameter(localMediaTabType, "localMediaTabType");
        Intrinsics.checkNotNullParameter(initLocalMediaTab, "initLocalMediaTab");
        Intrinsics.checkNotNullParameter(initLocalDbQueryType, "initLocalDbQueryType");
        Intrinsics.checkNotNullParameter(alreadySelectedMediaPath, "alreadySelectedMediaPath");
        Intrinsics.checkNotNullParameter(alreadySelectedMedia, "alreadySelectedMedia");
        Intrinsics.checkNotNullParameter(queryMediaFilter, "queryMediaFilter");
        Intrinsics.checkNotNullParameter(selectMediaFilter, "selectMediaFilter");
        Intrinsics.checkNotNullParameter(from, "from");
        return new Config(localMediaTabType, initLocalMediaTab, initLocalDbQueryType, qZoneMediaTabType, needDragSelect, needScrollTimeline, maxSelectMediaSize, startCountNum, alreadySelectedMediaPath, alreadySelectedMedia, queryMediaFilter, selectMediaFilter, needShowExitDialog, firstIconCamera, businessRequestCode, from);
    }

    @NotNull
    public final List<MediaInfo> getAlreadySelectedMedia() {
        return this.alreadySelectedMedia;
    }

    @NotNull
    public final List<String> getAlreadySelectedMediaPath() {
        return this.alreadySelectedMediaPath;
    }

    public final int getBusinessRequestCode() {
        return this.businessRequestCode;
    }

    public final boolean getFirstIconCamera() {
        return this.firstIconCamera;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    public final TabType getInitLocalDbQueryType() {
        return this.initLocalDbQueryType;
    }

    @NotNull
    public final MediaType getInitLocalMediaTab() {
        return this.initLocalMediaTab;
    }

    @NotNull
    public final TabType getLocalMediaTabType() {
        return this.localMediaTabType;
    }

    public final int getMaxSelectMediaSize() {
        return this.maxSelectMediaSize;
    }

    public final boolean getNeedDragSelect() {
        return this.needDragSelect;
    }

    public final boolean getNeedScrollTimeline() {
        return this.needScrollTimeline;
    }

    public final boolean getNeedShowExitDialog() {
        return this.needShowExitDialog;
    }

    @Nullable
    /* renamed from: getQZoneMediaTabType, reason: from getter */
    public final TabType getZoneMediaTabType() {
        return this.ZoneMediaTabType;
    }

    @NotNull
    public final MediaType getQZoneMediaType() {
        int i3;
        TabType tabType = this.ZoneMediaTabType;
        if (tabType == null) {
            i3 = -1;
        } else {
            i3 = c.f324400a[tabType.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return MediaType.QZONE_ALL;
                }
                return MediaType.QZONE_VIDEO;
            }
            return MediaType.QZONE_IMAGE;
        }
        return MediaType.QZONE_ALL;
    }

    @NotNull
    public final MediaFilter getQueryMediaFilter() {
        return this.queryMediaFilter;
    }

    @NotNull
    public final MediaFilter getSelectMediaFilter() {
        return this.selectMediaFilter;
    }

    public final int getStartCountNum() {
        return this.startCountNum;
    }

    @NotNull
    public String toString() {
        return "Config(localMediaTabType=" + this.localMediaTabType + ", initLocalMediaTab=" + this.initLocalMediaTab + ", initLocalDbQueryType=" + this.initLocalDbQueryType + ", ZoneMediaTabType=" + this.ZoneMediaTabType + ", needDragSelect=" + this.needDragSelect + ", needScrollTimeline=" + this.needScrollTimeline + ", maxSelectMediaSize=" + this.maxSelectMediaSize + ", startCountNum=" + this.startCountNum + ", alreadySelectedMediaPath=" + this.alreadySelectedMediaPath.size() + ", alreadySelectedMedia=" + this.alreadySelectedMedia.size() + ", needShowExitDialog=" + this.needShowExitDialog + ", firstIconCamera=" + this.firstIconCamera + ", businessRequestCode=" + this.businessRequestCode + ", from='" + this.from + "'";
    }

    Config(TabType tabType, MediaType mediaType, TabType tabType2, TabType tabType3, boolean z16, boolean z17, int i3, int i16, List<String> list, List<MediaInfo> list2, MediaFilter mediaFilter, MediaFilter mediaFilter2, boolean z18, boolean z19, int i17, String str) {
        this.localMediaTabType = tabType;
        this.initLocalMediaTab = mediaType;
        this.initLocalDbQueryType = tabType2;
        this.ZoneMediaTabType = tabType3;
        this.needDragSelect = z16;
        this.needScrollTimeline = z17;
        this.maxSelectMediaSize = i3;
        this.startCountNum = i16;
        this.alreadySelectedMediaPath = list;
        this.alreadySelectedMedia = list2;
        this.queryMediaFilter = mediaFilter;
        this.selectMediaFilter = mediaFilter2;
        this.needShowExitDialog = z18;
        this.firstIconCamera = z19;
        this.businessRequestCode = i17;
        this.from = str;
    }

    @Deprecated(message = "replace with `alreadySelectedMedia`")
    public static /* synthetic */ void getAlreadySelectedMediaPath$annotations() {
    }
}
