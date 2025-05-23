package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/model/a;", "", "", "Lfeedcloud/FeedCloudMeta$StComment;", "comments", "", "a", "", "d", "e", "f", "Landroid/text/SpannableStringBuilder;", "b", "c", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lfeedcloud/FeedCloudMeta$StFeed;", "getFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "Ljava/util/List;", "burningComments", "Lfeedcloud/FeedCloudMeta$StComment;", "firstComment", "<init>", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedCloudMeta$StFeed feed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<FeedCloudMeta$StComment> burningComments;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StComment firstComment;

    public a(@NotNull FeedCloudMeta$StFeed feed) {
        List<FeedCloudMeta$StComment> list;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        ArrayList arrayList = new ArrayList();
        this.burningComments = arrayList;
        PBRepeatMessageField<FeedCloudMeta$StComment> pBRepeatMessageField = feed.vecComment;
        String str = null;
        if (pBRepeatMessageField != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        a(list);
        int size = arrayList.size();
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.firstComment;
        if (feedCloudMeta$StComment != null && (pBStringField = feedCloudMeta$StComment.content) != null) {
            str = pBStringField.get();
        }
        QLog.d("QFSPublicAccountStaggeredItemCommentModel", 4, "burningCommentSize:" + size + ", replayComment:" + str);
    }

    private final void a(List<FeedCloudMeta$StComment> comments) {
        boolean z16;
        List<FeedCloudMeta$StComment> list = comments;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        for (FeedCloudMeta$StComment feedCloudMeta$StComment : comments) {
            if (!TextUtils.isEmpty(feedCloudMeta$StComment.content.get())) {
                if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 4)) {
                    this.burningComments.add(feedCloudMeta$StComment);
                } else if (QFSCommentHelper.V(feedCloudMeta$StComment.typeFlag2.get(), 16) && this.firstComment == null) {
                    this.firstComment = feedCloudMeta$StComment;
                }
            }
        }
    }

    private final boolean d() {
        return false;
    }

    @NotNull
    public final SpannableStringBuilder b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d()) {
            String str = this.burningComments.get(0).content.get();
            if (str == null) {
                str = "";
            }
            SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) str);
            Intrinsics.checkNotNullExpressionValue(append, "{\n            builder.ap\u2026nt.get() ?: \"\")\n        }");
            return append;
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableStringBuilder c() {
        String str;
        PBStringField pBStringField;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!f()) {
            return spannableStringBuilder;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.firstComment;
        if (feedCloudMeta$StComment != null && (pBStringField = feedCloudMeta$StComment.content) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        spannableStringBuilder.append((CharSequence) str);
        QLog.d("QFSPublicAccountStaggeredItemCommentModel", 4, "[getReplayCommentBuilder] builder:" + ((Object) spannableStringBuilder));
        return spannableStringBuilder;
    }

    public final boolean e() {
        return d();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f() {
        boolean z16;
        PBStringField pBStringField;
        String str;
        boolean z17;
        if (QFSBaseCommentPresenter.l(this.feed) || d()) {
            return false;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = this.firstComment;
        if (feedCloudMeta$StComment != null && (pBStringField = feedCloudMeta$StComment.content) != null && (str = pBStringField.get()) != null) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    return false;
                }
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
