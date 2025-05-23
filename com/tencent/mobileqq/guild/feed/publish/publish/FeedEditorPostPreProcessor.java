package com.tencent.mobileqq.guild.feed.publish.publish;

import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.data.p;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publish/FeedEditorPostPreProcessor;", "", "Lorg/json/JSONObject;", "urlContent", "", "", "Lcom/tencent/mobileqq/guild/data/o;", "mediaTasks", "", "b", "feed", "a", "Ljava/lang/String;", "logTag", "mainTaskId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorPostPreProcessor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mainTaskId;

    public FeedEditorPostPreProcessor(@NotNull String logTag, @NotNull String mainTaskId) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        this.logTag = logTag;
        this.mainTaskId = mainTaskId;
    }

    private final void b(JSONObject urlContent, Map<String, ? extends o> mediaTasks) {
        boolean z16;
        String str;
        c.g gVar = c.g.f220911a;
        Object remove = urlContent.remove("media_task_id");
        if (remove instanceof String) {
            boolean z17 = false;
            if (((CharSequence) remove).length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                o oVar = mediaTasks.get(remove);
                String str2 = null;
                if (oVar != null) {
                    str = oVar.getUrl();
                } else {
                    str = null;
                }
                if (str == null || str.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    String str3 = this.logTag;
                    String str4 = this.mainTaskId;
                    if (oVar != null) {
                        str2 = p.a(oVar);
                    }
                    QLog.e(str3, 1, "[replaceImageUrlToUploadResult]: mainTaskId=" + str4 + ", mediaTaskId=" + remove + ", imageUrl is empty, taskInfo=" + str2);
                    return;
                }
                switch (urlContent.optInt("type")) {
                    case 6:
                        JSONObject optJSONObject = urlContent.optJSONObject("third_share_info");
                        if (optJSONObject != null) {
                            optJSONObject.put("image_url", str);
                            return;
                        }
                        return;
                    case 7:
                    case 8:
                    case 9:
                        JSONObject optJSONObject2 = urlContent.optJSONObject("third_video_info");
                        if (optJSONObject2 != null) {
                            optJSONObject2.put("cover", str);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
        QLog.e(this.logTag, 1, "[replaceImageUrlToUploadResult]: mainTaskId=" + this.mainTaskId + ", no task id provided");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        r3 = kotlin.sequences.SequencesKt___SequencesKt.filterNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        r3 = kotlin.sequences.SequencesKt___SequencesKt.filter(r3, com.tencent.mobileqq.guild.feed.publish.publish.FeedEditorPostPreProcessor$replaceLocalMediaPathToRemoteUrlExtended$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull JSONObject feed, @NotNull Map<String, ? extends o> mediaTasks) {
        JSONArray optJSONArray;
        Sequence filterNotNull;
        Sequence filter;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(mediaTasks, "mediaTasks");
        JSONObject optJSONObject = feed.optJSONObject("contents");
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("contents")) != null && (r3 = yl1.i.f450608a.a(optJSONArray)) != null && filterNotNull != null && filter != null) {
            Iterator it = filter.iterator();
            while (it.hasNext()) {
                JSONObject optJSONObject2 = ((JSONObject) it.next()).optJSONObject("url_content");
                if (optJSONObject2 != null) {
                    b(optJSONObject2, mediaTasks);
                }
            }
        }
    }
}
