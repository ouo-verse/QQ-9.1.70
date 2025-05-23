package com.tencent.mobileqq.guild.feed.widget.comment;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\f\u001a\u00020\nR&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\r8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/comment/a;", "Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "", "id", "Landroid/text/Spannable;", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "draft", "mediaInfo", "", "b", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "getCommentDraftMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "commentDraftMap", "e", "getCommentMediaDraftMap", "commentMediaDraftMap", "<init>", "()V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a implements e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Spannable> commentDraftMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, LocalMediaInfo> commentMediaDraftMap = new ConcurrentHashMap<>();

    @Override // com.tencent.mobileqq.guild.feed.widget.comment.e
    @Nullable
    public LocalMediaInfo a(@Nullable String id5) {
        boolean z16;
        LocalMediaInfo localMediaInfo;
        if (id5 != null && id5.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            localMediaInfo = this.commentMediaDraftMap.get(id5);
        } else {
            localMediaInfo = null;
        }
        QLog.d("AbsGuildFeedCommentDraftMrg", 1, "[getMediaDraft] isComment = " + id5 + ", draft = " + localMediaInfo);
        if (localMediaInfo == null) {
            return null;
        }
        return localMediaInfo;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.comment.e
    public void b(@Nullable String id5, @NotNull Spannable draft, @Nullable LocalMediaInfo mediaInfo) {
        String str;
        Intrinsics.checkNotNullParameter(draft, "draft");
        boolean z16 = true;
        QLog.d("AbsGuildFeedCommentDraftMrg", 1, "[updateDraft] feedId = " + id5 + ", draft = " + ((Object) draft) + " mediaInfo=" + mediaInfo);
        if (id5 != null) {
            if (id5.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                str = id5;
            } else {
                str = null;
            }
            if (str != null) {
                this.commentDraftMap.put(str, draft);
                if (mediaInfo != null) {
                    this.commentMediaDraftMap.put(id5, mediaInfo);
                } else {
                    this.commentMediaDraftMap.remove(id5);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.comment.e
    @NotNull
    public Spannable c(@Nullable String id5) {
        boolean z16;
        Spannable spannable;
        if (id5 != null && id5.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            spannable = this.commentDraftMap.get(id5);
        } else {
            spannable = null;
        }
        QLog.d("AbsGuildFeedCommentDraftMrg", 1, "[getDraft] isComment = " + id5 + ", draft = " + ((Object) spannable));
        if (spannable == null) {
            return new SpannableStringBuilder();
        }
        return spannable;
    }

    public final void d() {
        QLog.d("AbsGuildFeedCommentDraftMrg", 1, "[clearDraft]");
        this.commentDraftMap.clear();
        this.commentMediaDraftMap.clear();
    }
}
