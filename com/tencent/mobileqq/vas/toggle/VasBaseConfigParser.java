package com.tencent.mobileqq.vas.toggle;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u0003B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser$c;", "c", "", "content", "d", "", "success", "", "onCdnDownload", "<init>", "()V", "a", "b", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasBaseConfigParser extends BaseConfigParser<c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArrayList<a> f310988e = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser$a;", "", "", "success", "", "b", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void b(boolean success);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser$b;", "", "Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser$a;", "callback", "", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "list", "Ljava/util/concurrent/CopyOnWriteArrayList;", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.toggle.VasBaseConfigParser$b, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull a callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (VasBaseConfigParser.f310988e.contains(callback)) {
                return;
            }
            VasBaseConfigParser.f310988e.add(callback);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/VasBaseConfigParser$c;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "str", "<init>", "(Ljava/lang/String;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String str;

        public c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.str = str;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c defaultConfig() {
        return new c("");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new c(new String(content, UTF_8));
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        super.onCdnDownload(success);
        Iterator<T> it = f310988e.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(success);
        }
    }
}
