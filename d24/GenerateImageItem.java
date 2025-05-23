package d24;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017\u0012\b\b\u0002\u0010$\u001a\u00020\u001e\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\t\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b%\u0010\u000eR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Ld24/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "i", "(I)V", "state", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "b", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "()Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "g", "(Lqshadow/ShadowAIGCGenerate$GenerateRequest;)V", "generateRequest", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "setImageUrl", "(Landroidx/lifecycle/MutableLiveData;)V", "imageUrl", "Ld24/a;", "d", "Ld24/a;", "()Ld24/a;", "f", "(Ld24/a;)V", "extraInfo", tl.h.F, "likeState", "Ljava/lang/String;", "getOriginImageUrl", "()Ljava/lang/String;", "setOriginImageUrl", "(Ljava/lang/String;)V", "originImageUrl", "<init>", "(ILqshadow/ShadowAIGCGenerate$GenerateRequest;Landroidx/lifecycle/MutableLiveData;Ld24/a;ILjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class GenerateImageItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private ShadowAIGCGenerate$GenerateRequest generateRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MutableLiveData<String> imageUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private AdelieAvatarExtraInfo extraInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int likeState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String originImageUrl;

    public GenerateImageItem() {
        this(0, null, null, null, 0, null, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AdelieAvatarExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final ShadowAIGCGenerate$GenerateRequest getGenerateRequest() {
        return this.generateRequest;
    }

    @NotNull
    public final MutableLiveData<String> c() {
        return this.imageUrl;
    }

    /* renamed from: d, reason: from getter */
    public final int getLikeState() {
        return this.likeState;
    }

    /* renamed from: e, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateImageItem)) {
            return false;
        }
        GenerateImageItem generateImageItem = (GenerateImageItem) other;
        if (this.state == generateImageItem.state && Intrinsics.areEqual(this.generateRequest, generateImageItem.generateRequest) && Intrinsics.areEqual(this.imageUrl, generateImageItem.imageUrl) && Intrinsics.areEqual(this.extraInfo, generateImageItem.extraInfo) && this.likeState == generateImageItem.likeState && Intrinsics.areEqual(this.originImageUrl, generateImageItem.originImageUrl)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull AdelieAvatarExtraInfo adelieAvatarExtraInfo) {
        Intrinsics.checkNotNullParameter(adelieAvatarExtraInfo, "<set-?>");
        this.extraInfo = adelieAvatarExtraInfo;
    }

    public final void g(@Nullable ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest) {
        this.generateRequest = shadowAIGCGenerate$GenerateRequest;
    }

    public final void h(int i3) {
        this.likeState = i3;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.state * 31;
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = this.generateRequest;
        if (shadowAIGCGenerate$GenerateRequest == null) {
            hashCode = 0;
        } else {
            hashCode = shadowAIGCGenerate$GenerateRequest.hashCode();
        }
        return ((((((((i3 + hashCode) * 31) + this.imageUrl.hashCode()) * 31) + this.extraInfo.hashCode()) * 31) + this.likeState) * 31) + this.originImageUrl.hashCode();
    }

    public final void i(int i3) {
        this.state = i3;
    }

    @NotNull
    public String toString() {
        return "GenerateImageItem(state=" + this.state + ", generateRequest=" + this.generateRequest + ", imageUrl=" + this.imageUrl + ", extraInfo=" + this.extraInfo + ", likeState=" + this.likeState + ", originImageUrl=" + this.originImageUrl + ")";
    }

    public GenerateImageItem(int i3, @Nullable ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, @NotNull MutableLiveData<String> imageUrl, @NotNull AdelieAvatarExtraInfo extraInfo, int i16, @NotNull String originImageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Intrinsics.checkNotNullParameter(originImageUrl, "originImageUrl");
        this.state = i3;
        this.generateRequest = shadowAIGCGenerate$GenerateRequest;
        this.imageUrl = imageUrl;
        this.extraInfo = extraInfo;
        this.likeState = i16;
        this.originImageUrl = originImageUrl;
    }

    public /* synthetic */ GenerateImageItem(int i3, ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, MutableLiveData mutableLiveData, AdelieAvatarExtraInfo adelieAvatarExtraInfo, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? new ShadowAIGCGenerate$GenerateRequest() : shadowAIGCGenerate$GenerateRequest, (i17 & 4) != 0 ? new MutableLiveData() : mutableLiveData, (i17 & 8) != 0 ? new AdelieAvatarExtraInfo(0, null, null, false, false, null, null, null, 255, null) : adelieAvatarExtraInfo, (i17 & 16) != 0 ? 2 : i16, (i17 & 32) != 0 ? "" : str);
    }
}
