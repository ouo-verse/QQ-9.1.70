package gk1;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mk1.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lgk1/a;", "Lxj1/a;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "b", "", "a", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/part/Part;", "hostPart", "<init>", "(Lcom/tencent/biz/richframework/part/Part;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements xj1.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final C10381a f402350b = new C10381a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Part hostPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lgk1/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gk1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C10381a {
        public /* synthetic */ C10381a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        C10381a() {
        }
    }

    public a(@NotNull Part hostPart) {
        Intrinsics.checkNotNullParameter(hostPart, "hostPart");
        this.hostPart = hostPart;
    }

    private final String b(GProStFeed stFeed) {
        Object first;
        Object first2;
        Object first3;
        if (stFeed.externalCommentList.size() == 1) {
            ArrayList<GProStComment> arrayList = stFeed.externalCommentList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "stFeed.externalCommentList");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            if (((GProStComment) first).externalShowLine > 1) {
                ArrayList<GProStComment> arrayList2 = stFeed.externalCommentList;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "stFeed.externalCommentList");
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                String str = ((GProStComment) first2).idd;
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    Logger.a d16 = logger.d();
                    int size = stFeed.externalCommentList.size();
                    ArrayList<GProStComment> arrayList3 = stFeed.externalCommentList;
                    Intrinsics.checkNotNullExpressionValue(arrayList3, "stFeed.externalCommentList");
                    first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList3);
                    d16.d("GuildFeedCommentBroadcastHelper", 1, "getSingleCommentInsertId--commentSize:" + size + ",lineCnt:" + ((GProStComment) first3).externalShowLine + "," + str);
                }
                Intrinsics.checkNotNullExpressionValue(str, "stFeed.externalCommentLi\u2026          }\n            }");
                return str;
            }
        }
        return "";
    }

    @Override // xj1.a
    public void a(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        this.hostPart.broadcastMessage("message_on_comment_panel_show", new GuildFeedGalleryMessage.CommentPanelShowArgs(g.c(stFeed), true, false, b(stFeed), GuildFeedCommentUtil.h(stFeed), false, 32, null));
    }
}
