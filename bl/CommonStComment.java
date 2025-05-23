package bl;

import com.qzone.proxy.feedcomponent.model.n;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\b\u0002\u0010'\u001a\u00020 \u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002030\u0018\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u0018\u00a2\u0006\u0004\b<\u0010=J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00107\u001a\b\u0012\u0004\u0012\u0002030\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR(\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u001b\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b:\u0010\u001e\u00a8\u0006>"}, d2 = {"Lbl/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "getUser", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "setUser", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", QCircleAlphaUserReporter.KEY_USER, "", "Lbl/h;", "c", "Ljava/util/List;", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "content", "", "d", "J", "getTime", "()J", "setTime", "(J)V", "time", "e", "getClientKey", "setClientKey", "clientKey", "f", "I", "getReplyNum", "()I", "setReplyNum", "(I)V", "replyNum", "Lbl/g;", "g", "getReplys", "setReplys", "replys", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", tl.h.F, "setMediaItems", "mediaItems", "<init>", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;Ljava/util/List;JLjava/lang/String;ILjava/util/List;Ljava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl.e, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonStComment {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private CommonStUser user;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<CommonStRichMsg> content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long time;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String clientKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int replyNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private List<CommonStReply> replys;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private List<CommonStMedia> mediaItems;

    public CommonStComment() {
        this(null, null, null, 0L, null, 0, null, null, 255, null);
    }

    public final List<CommonStRichMsg> a() {
        return this.content;
    }

    public final List<CommonStMedia> b() {
        return this.mediaItems;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.user.hashCode()) * 31) + this.content.hashCode()) * 31) + n.a(this.time)) * 31) + this.clientKey.hashCode()) * 31) + this.replyNum) * 31) + this.replys.hashCode()) * 31) + this.mediaItems.hashCode();
    }

    public String toString() {
        return "CommonStComment(id=" + this.id + ", user=" + this.user + ", content=" + this.content + ", time=" + this.time + ", clientKey=" + this.clientKey + ", replyNum=" + this.replyNum + ", replys=" + this.replys + ", mediaItems=" + this.mediaItems + ")";
    }

    public CommonStComment(String id5, CommonStUser user, List<CommonStRichMsg> content, long j3, String clientKey, int i3, List<CommonStReply> replys, List<CommonStMedia> mediaItems) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(replys, "replys");
        Intrinsics.checkNotNullParameter(mediaItems, "mediaItems");
        this.id = id5;
        this.user = user;
        this.content = content;
        this.time = j3;
        this.clientKey = clientKey;
        this.replyNum = i3;
        this.replys = replys;
        this.mediaItems = mediaItems;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonStComment)) {
            return false;
        }
        CommonStComment commonStComment = (CommonStComment) other;
        return Intrinsics.areEqual(this.id, commonStComment.id) && Intrinsics.areEqual(this.user, commonStComment.user) && Intrinsics.areEqual(this.content, commonStComment.content) && this.time == commonStComment.time && Intrinsics.areEqual(this.clientKey, commonStComment.clientKey) && this.replyNum == commonStComment.replyNum && Intrinsics.areEqual(this.replys, commonStComment.replys) && Intrinsics.areEqual(this.mediaItems, commonStComment.mediaItems);
    }

    public /* synthetic */ CommonStComment(String str, CommonStUser commonStUser, List list, long j3, String str2, int i3, List list2, List list3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? new CommonStUser() : commonStUser, (i16 & 4) != 0 ? new ArrayList() : list, (i16 & 8) != 0 ? 0L : j3, (i16 & 16) == 0 ? str2 : "", (i16 & 32) != 0 ? 0 : i3, (i16 & 64) != 0 ? new ArrayList() : list2, (i16 & 128) != 0 ? new ArrayList() : list3);
    }
}
