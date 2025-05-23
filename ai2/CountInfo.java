package ai2;

import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGraySampleRate;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildPublicSampleRate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lai2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "scene", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "b", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "()Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "pubPolicy", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "()Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "grayPolicy", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ai2.a, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class CountInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildPublicSampleRate pubPolicy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildGraySampleRate grayPolicy;

    public CountInfo(@NotNull String scene, @NotNull GuildPublicSampleRate pubPolicy, @NotNull GuildGraySampleRate grayPolicy) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(pubPolicy, "pubPolicy");
        Intrinsics.checkNotNullParameter(grayPolicy, "grayPolicy");
        this.scene = scene;
        this.pubPolicy = pubPolicy;
        this.grayPolicy = grayPolicy;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildGraySampleRate getGrayPolicy() {
        return this.grayPolicy;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GuildPublicSampleRate getPubPolicy() {
        return this.pubPolicy;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountInfo)) {
            return false;
        }
        CountInfo countInfo = (CountInfo) other;
        if (Intrinsics.areEqual(this.scene, countInfo.scene) && this.pubPolicy == countInfo.pubPolicy && this.grayPolicy == countInfo.grayPolicy) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.scene.hashCode() * 31) + this.pubPolicy.hashCode()) * 31) + this.grayPolicy.hashCode();
    }

    @NotNull
    public String toString() {
        return "CountInfo(scene=" + this.scene + ", pubPolicy=" + this.pubPolicy + ", grayPolicy=" + this.grayPolicy + ')';
    }
}
