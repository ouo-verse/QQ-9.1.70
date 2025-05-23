package f61;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.common.GenericCardPB$GenericCard;
import tencent.im.oidb.common.GenericCardPB$GenericCardItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\tBg\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010&\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR'\u0010&\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u0017\u0010%R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b#\u0010(\"\u0004\b)\u0010*R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b,\u0010\u000e\u00a8\u00060"}, d2 = {"Lf61/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "iconUrl", "b", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "title", "c", "g", "backgroundUrl", "d", "k", WadlProxyConsts.KEY_JUMP_URL, "I", "getStyle", "()I", "l", "(I)V", "style", "Ljava/util/ArrayList;", "Ltencent/im/oidb/common/GenericCardPB$GenericCardItem;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "kvList", "Z", "()Z", tl.h.F, "(Z)V", "isEmpty", "j", "intro", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZLjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String iconUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String backgroundUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jumpUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int style;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<GenericCardPB$GenericCardItem> kvList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isEmpty;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String intro;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lf61/c$a;", "", "Lf61/c;", "info", "Ltencent/im/oidb/common/GenericCardPB$GenericCard;", "model", "", "a", "", "tag", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f61.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull c info, @Nullable GenericCardPB$GenericCard model) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (model == null) {
                return;
            }
            info.h(false);
            String str = model.icon_url.get();
            Intrinsics.checkNotNullExpressionValue(str, "modelNotNull.icon_url.get()");
            info.i(str);
            String str2 = model.title.get();
            Intrinsics.checkNotNullExpressionValue(str2, "modelNotNull.title.get()");
            info.m(str2);
            String str3 = model.background_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "modelNotNull.background_url.get()");
            info.g(str3);
            String str4 = model.jump_url.get();
            Intrinsics.checkNotNullExpressionValue(str4, "modelNotNull.jump_url.get()");
            info.k(str4);
            info.l(model.style.get());
            String str5 = model.intro.get();
            Intrinsics.checkNotNullExpressionValue(str5, "modelNotNull.intro.get()");
            info.j(str5);
            info.d().clear();
            PBRepeatMessageField<GenericCardPB$GenericCardItem> pBRepeatMessageField = model.items;
            if (pBRepeatMessageField == null) {
                return;
            }
            for (GenericCardPB$GenericCardItem genericCardPB$GenericCardItem : pBRepeatMessageField.get()) {
                if (genericCardPB$GenericCardItem != null) {
                    info.d().add(genericCardPB$GenericCardItem);
                }
            }
            QLog.i("GenericCardInfo", 1, "mergePB=" + info);
        }

        Companion() {
        }
    }

    public c() {
        this(null, null, null, null, 0, null, false, null, 255, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final ArrayList<GenericCardPB$GenericCardItem> d() {
        return this.kvList;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.iconUrl, cVar.iconUrl) && Intrinsics.areEqual(this.title, cVar.title) && Intrinsics.areEqual(this.backgroundUrl, cVar.backgroundUrl) && Intrinsics.areEqual(this.jumpUrl, cVar.jumpUrl) && this.style == cVar.style && Intrinsics.areEqual(this.kvList, cVar.kvList) && this.isEmpty == cVar.isEmpty && Intrinsics.areEqual(this.intro, cVar.intro)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundUrl = str;
    }

    public final void h(boolean z16) {
        this.isEmpty = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.iconUrl.hashCode() * 31) + this.title.hashCode()) * 31) + this.backgroundUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.style) * 31) + this.kvList.hashCode()) * 31;
        boolean z16 = this.isEmpty;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.intro.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.intro = str;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void l(int i3) {
        this.style = i3;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        Iterator<GenericCardPB$GenericCardItem> it = this.kvList.iterator();
        String str = "[";
        while (it.hasNext()) {
            GenericCardPB$GenericCardItem next = it.next();
            str = str + next.key.get() + ":" + next.value.get() + ",";
        }
        String str2 = str + "]";
        return "GenericCardInfo[iconUrl=" + this.iconUrl + ", title=" + this.title + ", backgroundUrl=" + this.backgroundUrl + ",jumpUrl=" + this.jumpUrl + ", style=" + this.style + ", kvMap=" + str2 + ", isEmpty=" + this.isEmpty + ", intro=" + this.intro + "]";
    }

    public c(@NotNull String iconUrl, @NotNull String title, @NotNull String backgroundUrl, @NotNull String jumpUrl, int i3, @NotNull ArrayList<GenericCardPB$GenericCardItem> kvList, boolean z16, @NotNull String intro) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(kvList, "kvList");
        Intrinsics.checkNotNullParameter(intro, "intro");
        this.iconUrl = iconUrl;
        this.title = title;
        this.backgroundUrl = backgroundUrl;
        this.jumpUrl = jumpUrl;
        this.style = i3;
        this.kvList = kvList;
        this.isEmpty = z16;
        this.intro = intro;
    }

    public /* synthetic */ c(String str, String str2, String str3, String str4, int i3, ArrayList arrayList, boolean z16, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) != 0 ? 1 : i3, (i16 & 32) != 0 ? new ArrayList() : arrayList, (i16 & 64) == 0 ? z16 : true, (i16 & 128) == 0 ? str5 : "");
    }
}
