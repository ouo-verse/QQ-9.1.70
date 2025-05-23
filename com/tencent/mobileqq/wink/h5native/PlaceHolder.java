package com.tencent.mobileqq.wink.h5native;

import com.tencent.autotemplate.utils.JsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00c6\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J9\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PlaceHolder", "", "", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$Image;", "component1", "", "component2", "component3", "images", "text", JsonUtils.KEY_BGM, "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PlaceHolder;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "getText", "Ljava/lang/String;", "getBgm", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PlaceHolder, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PlaceHolder {

    @Nullable
    private final String bgm;

    @Nullable
    private final List<Image> images;

    @Nullable
    private final List<String> text;

    public PlaceHolder(@Nullable List<Image> list, @Nullable List<String> list2, @Nullable String str) {
        this.images = list;
        this.text = list2;
        this.bgm = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaceHolder copy$default(PlaceHolder placeHolder, List list, List list2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = placeHolder.images;
        }
        if ((i3 & 2) != 0) {
            list2 = placeHolder.text;
        }
        if ((i3 & 4) != 0) {
            str = placeHolder.bgm;
        }
        return placeHolder.copy(list, list2, str);
    }

    @Nullable
    public final List<Image> component1() {
        return this.images;
    }

    @Nullable
    public final List<String> component2() {
        return this.text;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBgm() {
        return this.bgm;
    }

    @NotNull
    public final PlaceHolder copy(@Nullable List<Image> images, @Nullable List<String> text, @Nullable String bgm) {
        return new PlaceHolder(images, text, bgm);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceHolder)) {
            return false;
        }
        PlaceHolder placeHolder = (PlaceHolder) other;
        if (Intrinsics.areEqual(this.images, placeHolder.images) && Intrinsics.areEqual(this.text, placeHolder.text) && Intrinsics.areEqual(this.bgm, placeHolder.bgm)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getBgm() {
        return this.bgm;
    }

    @Nullable
    public final List<Image> getImages() {
        return this.images;
    }

    @Nullable
    public final List<String> getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        List<Image> list = this.images;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = hashCode * 31;
        List<String> list2 = this.text;
        if (list2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str = this.bgm;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "PlaceHolder(images=" + this.images + ", text=" + this.text + ", bgm=" + this.bgm + ")";
    }
}
