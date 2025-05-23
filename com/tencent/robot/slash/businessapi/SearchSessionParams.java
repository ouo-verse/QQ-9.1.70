package com.tencent.robot.slash.businessapi;

import com.tencent.qqnt.kernel.nativeinterface.CommonBotFilter;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotScene;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0017\u0010!\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0016\u0010 R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b\u0011\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/slash/businessapi/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "f", "()Ljava/util/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "e", "tinyIds", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotScene;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotScene;", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotScene;", "scene", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFilter;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFilter;", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFilter;", "filter", "Ljava/lang/String;", "()Ljava/lang/String;", "cookieKey", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotScene;Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFilter;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.slash.businessapi.d, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SearchSessionParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Contact contact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<Long> uinList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<Long> tinyIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CommonBotScene scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CommonBotFilter filter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String cookieKey;

    public SearchSessionParams(@NotNull Contact contact, @NotNull ArrayList<Long> uinList, @NotNull ArrayList<Long> tinyIds, @NotNull CommonBotScene scene, @NotNull CommonBotFilter filter, @NotNull String cookieKey) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(cookieKey, "cookieKey");
        this.contact = contact;
        this.uinList = uinList;
        this.tinyIds = tinyIds;
        this.scene = scene;
        this.filter = filter;
        this.cookieKey = cookieKey;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCookieKey() {
        return this.cookieKey;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final CommonBotFilter getFilter() {
        return this.filter;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final CommonBotScene getScene() {
        return this.scene;
    }

    @NotNull
    public final ArrayList<Long> e() {
        return this.tinyIds;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchSessionParams)) {
            return false;
        }
        SearchSessionParams searchSessionParams = (SearchSessionParams) other;
        if (Intrinsics.areEqual(this.contact, searchSessionParams.contact) && Intrinsics.areEqual(this.uinList, searchSessionParams.uinList) && Intrinsics.areEqual(this.tinyIds, searchSessionParams.tinyIds) && this.scene == searchSessionParams.scene && this.filter == searchSessionParams.filter && Intrinsics.areEqual(this.cookieKey, searchSessionParams.cookieKey)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<Long> f() {
        return this.uinList;
    }

    public int hashCode() {
        return (((((((((this.contact.hashCode() * 31) + this.uinList.hashCode()) * 31) + this.tinyIds.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.filter.hashCode()) * 31) + this.cookieKey.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchSessionParams(contact=" + this.contact + ", uinList=" + this.uinList + ", tinyIds=" + this.tinyIds + ", scene=" + this.scene + ", filter=" + this.filter + ", cookieKey=" + this.cookieKey + ")";
    }
}
