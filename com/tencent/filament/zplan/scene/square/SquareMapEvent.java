package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.ark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0017\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "", "toJson", AdMetricTag.EVENT_NAME, "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class SquareMapEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String eventName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapEvent$a;", "", "T", "", ark.ARKMETADATA_JSON, "Ljava/lang/Class;", "classOfT", "a", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.square.SquareMapEvent$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final <T> T a(@Nullable String json, @NotNull Class<T> classOfT) {
            Intrinsics.checkNotNullParameter(classOfT, "classOfT");
            if (json == null) {
                return null;
            }
            try {
                return (T) new Gson().fromJson(json, (Class) classOfT);
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SquareMapEvent(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String toJson() {
        try {
            return new Gson().toJson(this);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
