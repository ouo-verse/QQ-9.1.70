package bl;

import com.qzone.proxy.feedcomponent.model.n;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\b\b\u0002\u0010(\u001a\u00020!\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0010\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\"\u00100\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016\u00a8\u00063"}, d2 = {"Lbl/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "getUser", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "setUser", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", QCircleAlphaUserReporter.KEY_USER, "", "Lbl/h;", "c", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "content", "", "d", "J", "getTime", "()J", "setTime", "(J)V", "time", "e", "getClientKey", "setClientKey", "clientKey", "f", "getTargetUser", "setTargetUser", "targetUser", "<init>", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;Ljava/util/List;JLjava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl.g, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class CommonStReply {

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
    private CommonStUser targetUser;

    public CommonStReply() {
        this(null, null, null, 0L, null, null, 63, null);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.user.hashCode()) * 31) + this.content.hashCode()) * 31) + n.a(this.time)) * 31) + this.clientKey.hashCode()) * 31) + this.targetUser.hashCode();
    }

    public String toString() {
        return "CommonStReply(id=" + this.id + ", user=" + this.user + ", content=" + this.content + ", time=" + this.time + ", clientKey=" + this.clientKey + ", targetUser=" + this.targetUser + ")";
    }

    public CommonStReply(String id5, CommonStUser user, List<CommonStRichMsg> content, long j3, String clientKey, CommonStUser targetUser) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(targetUser, "targetUser");
        this.id = id5;
        this.user = user;
        this.content = content;
        this.time = j3;
        this.clientKey = clientKey;
        this.targetUser = targetUser;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonStReply)) {
            return false;
        }
        CommonStReply commonStReply = (CommonStReply) other;
        return Intrinsics.areEqual(this.id, commonStReply.id) && Intrinsics.areEqual(this.user, commonStReply.user) && Intrinsics.areEqual(this.content, commonStReply.content) && this.time == commonStReply.time && Intrinsics.areEqual(this.clientKey, commonStReply.clientKey) && Intrinsics.areEqual(this.targetUser, commonStReply.targetUser);
    }

    public /* synthetic */ CommonStReply(String str, CommonStUser commonStUser, List list, long j3, String str2, CommonStUser commonStUser2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? new CommonStUser() : commonStUser, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) == 0 ? str2 : "", (i3 & 32) != 0 ? new CommonStUser() : commonStUser2);
    }
}
