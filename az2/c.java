package az2;

import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Laz2/c;", "", "", "appId", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Laz2/c$a;", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R>\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Laz2/c$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "mExpGrayId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setMExpParams", "(Ljava/util/HashMap;)V", "mExpParams", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String mExpGrayId = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<String, String> mExpParams = new HashMap<>();

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getMExpGrayId() {
            return this.mExpGrayId;
        }

        @NotNull
        public final HashMap<String, String> b() {
            return this.mExpParams;
        }

        public final void c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mExpGrayId = str;
        }
    }

    @NotNull
    a a(@NotNull String appId, @NotNull String expName);
}
