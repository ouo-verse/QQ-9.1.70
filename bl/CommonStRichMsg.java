package bl;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB]\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b#\u0010\u0014R(\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010'\u001a\u0004\b\u0010\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lbl/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "setType", "(I)V", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "content", "c", "e", "setUid", "uid", "setName", "name", tl.h.F, "setWho", "who", "f", "g", "setUrl", "url", "setUin", "uin", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Ljava/util/List;", "()Ljava/util/List;", "setMediaItems", "(Ljava/util/List;)V", "mediaItems", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl.h, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonStRichMsg {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String uid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int who;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String url;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String uin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private List<CommonStMedia> mediaItems;

    public CommonStRichMsg() {
        this(0, null, null, null, 0, null, null, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final List<CommonStMedia> b() {
        return this.mediaItems;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: f, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: h, reason: from getter */
    public final int getWho() {
        return this.who;
    }

    public int hashCode() {
        return (((((((((((((this.type * 31) + this.content.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.name.hashCode()) * 31) + this.who) * 31) + this.url.hashCode()) * 31) + this.uin.hashCode()) * 31) + this.mediaItems.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public String toString() {
        return "CommonStRichMsg(type=" + this.type + ", content=" + this.content + ", uid=" + this.uid + ", name=" + this.name + ", who=" + this.who + ", url=" + this.url + ", uin=" + this.uin + ", mediaItems=" + this.mediaItems + ")";
    }

    public CommonStRichMsg(int i3, String content, String uid, String name, int i16, String url, String uin, List<CommonStMedia> mediaItems) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(mediaItems, "mediaItems");
        this.type = i3;
        this.content = content;
        this.uid = uid;
        this.name = name;
        this.who = i16;
        this.url = url;
        this.uin = uin;
        this.mediaItems = mediaItems;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonStRichMsg)) {
            return false;
        }
        CommonStRichMsg commonStRichMsg = (CommonStRichMsg) other;
        return this.type == commonStRichMsg.type && Intrinsics.areEqual(this.content, commonStRichMsg.content) && Intrinsics.areEqual(this.uid, commonStRichMsg.uid) && Intrinsics.areEqual(this.name, commonStRichMsg.name) && this.who == commonStRichMsg.who && Intrinsics.areEqual(this.url, commonStRichMsg.url) && Intrinsics.areEqual(this.uin, commonStRichMsg.uin) && Intrinsics.areEqual(this.mediaItems, commonStRichMsg.mediaItems);
    }

    public /* synthetic */ CommonStRichMsg(int i3, String str, String str2, String str3, int i16, String str4, String str5, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? "" : str3, (i17 & 16) == 0 ? i16 : 0, (i17 & 32) != 0 ? "" : str4, (i17 & 64) == 0 ? str5 : "", (i17 & 128) != 0 ? new ArrayList() : list);
    }
}
