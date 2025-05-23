package en1;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.picshare.restorer.media.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Len1/a;", "", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Len1/a$a;", "", "", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/b;", "a", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "Landroid/text/SpannableStringBuilder;", "b", "Landroid/text/SpannableStringBuilder;", "()Landroid/text/SpannableStringBuilder;", "textContent", "<init>", "(Ljava/util/List;Landroid/text/SpannableStringBuilder;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: en1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C10251a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<b> mediaList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SpannableStringBuilder textContent;

        public C10251a(@NotNull List<b> mediaList, @NotNull SpannableStringBuilder textContent) {
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            Intrinsics.checkNotNullParameter(textContent, "textContent");
            this.mediaList = mediaList;
            this.textContent = textContent;
        }

        @NotNull
        public final List<b> a() {
            return this.mediaList;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final SpannableStringBuilder getTextContent() {
            return this.textContent;
        }

        public /* synthetic */ C10251a(List list, SpannableStringBuilder spannableStringBuilder, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? new SpannableStringBuilder() : spannableStringBuilder);
        }
    }

    void a(@NotNull JSONObject contentJson, @NotNull C10251a result);
}
