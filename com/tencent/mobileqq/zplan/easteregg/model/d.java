package com.tencent.mobileqq.zplan.easteregg.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.meme.Priority;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001\tB\u0089\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010,\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000201\u0018\u000100\u0012\b\u0010:\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\t\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b\u0015\u0010\"R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u0017\u0010+\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u001f\u0010*R\u0019\u0010/\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b(\u0010.R%\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000201\u0018\u0001008\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b\u000f\u00103R$\u0010:\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00106\u001a\u0004\b$\u00107\"\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "id", "", "b", "Ljava/util/List;", "e", "()Ljava/util/List;", "idList", "Lcom/tencent/mobileqq/zplan/easteregg/model/PortraitQueryType;", "c", "Lcom/tencent/mobileqq/zplan/easteregg/model/PortraitQueryType;", "j", "()Lcom/tencent/mobileqq/zplan/easteregg/model/PortraitQueryType;", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "appearanceKey", "k", "uin", "f", "I", "l", "()I", "width", "g", "height", h.F, "scene", "i", "Z", "()Z", "needRecord", "Lcom/tencent/zplan/common/model/AppTheme;", "Lcom/tencent/zplan/common/model/AppTheme;", "()Lcom/tencent/zplan/common/model/AppTheme;", "theme", "Lkotlin/Pair;", "", "Lkotlin/Pair;", "()Lkotlin/Pair;", "errorAppearanceInfo", "Lcom/tencent/zplan/meme/Priority;", "Lcom/tencent/zplan/meme/Priority;", "()Lcom/tencent/zplan/meme/Priority;", "setRecordPriority", "(Lcom/tencent/zplan/meme/Priority;)V", "recordPriority", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Lcom/tencent/mobileqq/zplan/easteregg/model/PortraitQueryType;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLcom/tencent/zplan/common/model/AppTheme;Lkotlin/Pair;Lcom/tencent/zplan/meme/Priority;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class d {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> idList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PortraitQueryType type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appearanceKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean needRecord;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppTheme theme;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Pair<String, Long> errorAppearanceInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Priority recordPriority;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/d$a;", "", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "", "", "newIdList", "", "newAppearanceKey", "b", "Lkotlin/Pair;", "", "errorInfo", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.easteregg.model.d$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a(@NotNull d param, @NotNull Pair<String, Long> errorInfo) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
            return new d(param.getId(), param.e(), param.getType(), param.getAppearanceKey(), param.getUin(), param.getWidth(), param.getHeight(), param.getScene(), param.getNeedRecord(), param.getTheme(), errorInfo, param.getRecordPriority());
        }

        @NotNull
        public final d b(@NotNull d param, @NotNull List<Integer> newIdList, @NotNull String newAppearanceKey) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(newIdList, "newIdList");
            Intrinsics.checkNotNullParameter(newAppearanceKey, "newAppearanceKey");
            return new d(param.getId(), newIdList, param.getType(), newAppearanceKey, param.getUin(), param.getWidth(), param.getHeight(), param.getScene(), param.getNeedRecord(), param.getTheme(), null, param.getRecordPriority(), 1024, null);
        }

        Companion() {
        }
    }

    public d(@Nullable Integer num, @NotNull List<Integer> idList, @NotNull PortraitQueryType type, @NotNull String appearanceKey, @NotNull String uin, int i3, int i16, @NotNull String scene, boolean z16, @Nullable AppTheme appTheme, @Nullable Pair<String, Long> pair, @Nullable Priority priority) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.id = num;
        this.idList = idList;
        this.type = type;
        this.appearanceKey = appearanceKey;
        this.uin = uin;
        this.width = i3;
        this.height = i16;
        this.scene = scene;
        this.needRecord = z16;
        this.theme = appTheme;
        this.errorAppearanceInfo = pair;
        this.recordPriority = priority;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppearanceKey() {
        return this.appearanceKey;
    }

    @Nullable
    public final Pair<String, Long> b() {
        return this.errorAppearanceInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @NotNull
    public final List<Integer> e() {
        return this.idList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.id, dVar.id) && Intrinsics.areEqual(this.idList, dVar.idList) && this.type == dVar.type && Intrinsics.areEqual(this.appearanceKey, dVar.appearanceKey) && Intrinsics.areEqual(this.uin, dVar.uin) && this.width == dVar.width && this.height == dVar.height && Intrinsics.areEqual(this.scene, dVar.scene) && this.needRecord == dVar.needRecord && this.theme == dVar.theme && Intrinsics.areEqual(this.errorAppearanceInfo, dVar.errorAppearanceInfo) && this.recordPriority == dVar.recordPriority) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getNeedRecord() {
        return this.needRecord;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Priority getRecordPriority() {
        return this.recordPriority;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        Integer num = this.id;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode4 = ((((((((((((((hashCode * 31) + this.idList.hashCode()) * 31) + this.type.hashCode()) * 31) + this.appearanceKey.hashCode()) * 31) + this.uin.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.scene.hashCode()) * 31;
        boolean z16 = this.needRecord;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode4 + i16) * 31;
        AppTheme appTheme = this.theme;
        if (appTheme == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = appTheme.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        Pair<String, Long> pair = this.errorAppearanceInfo;
        if (pair == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = pair.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        Priority priority = this.recordPriority;
        if (priority != null) {
            i3 = priority.hashCode();
        }
        return i19 + i3;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final AppTheme getTheme() {
        return this.theme;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final PortraitQueryType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: l, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "id: " + this.id + ", idList: " + this.idList + ", type: " + this.type + ", appearanceKey: " + this.appearanceKey + ", uin: " + this.uin + ", scene: " + this.scene + ", needRecord: " + this.needRecord;
    }

    public /* synthetic */ d(Integer num, List list, PortraitQueryType portraitQueryType, String str, String str2, int i3, int i16, String str3, boolean z16, AppTheme appTheme, Pair pair, Priority priority, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : num, list, portraitQueryType, str, str2, i3, i16, str3, (i17 & 256) != 0 ? false : z16, (i17 & 512) != 0 ? AppTheme.DAY : appTheme, (i17 & 1024) != 0 ? null : pair, priority);
    }
}
