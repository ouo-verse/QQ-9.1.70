package com.tencent.biz.qqcircle.comment.recpic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\tB%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ab;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "subCategory", "", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "textFeatures", "c", "[F", "()[F", "thresholds", "<init>", "(Ljava/lang/String;Ljava/util/List;[F)V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.ab, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSFeedCategoryConfig {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subCategory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<float[]> textFeatures;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final float[] thresholds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0014\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ab$a;", "", "Lorg/json/JSONObject;", "Lcom/tencent/biz/qqcircle/comment/recpic/ab;", "d", "Lorg/json/JSONArray;", "jsonArray", "", "", "a", "b", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.comment.recpic.ab$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<float[]> a(JSONArray jsonArray) {
            ArrayList arrayList = new ArrayList();
            if (jsonArray != null) {
                int length = jsonArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(QFSFeedCategoryConfig.INSTANCE.b(jsonArray.optJSONArray(i3)));
                }
            }
            return arrayList;
        }

        private final float[] b(JSONArray jsonArray) {
            int i3;
            if (jsonArray != null) {
                i3 = jsonArray.length();
            } else {
                i3 = 0;
            }
            float[] fArr = new float[i3];
            if (jsonArray != null) {
                int length = jsonArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    fArr[i16] = (float) jsonArray.optDouble(i16);
                }
            }
            return fArr;
        }

        private final QFSFeedCategoryConfig d(JSONObject jSONObject) {
            String optString = jSONObject.optString("sub_category");
            float[] b16 = b(jSONObject.optJSONArray("thresholds"));
            List<float[]> a16 = a(jSONObject.optJSONArray("text_features"));
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"sub_category\")");
            return new QFSFeedCategoryConfig(optString, a16, b16);
        }

        @JvmStatic
        @NotNull
        public final List<QFSFeedCategoryConfig> c(@NotNull JSONArray jsonArray) {
            Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jsonObj, "jsonObj");
                arrayList.add(d(jsonObj));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public QFSFeedCategoryConfig(@NotNull String subCategory, @NotNull List<float[]> textFeatures, @NotNull float[] thresholds) {
        Intrinsics.checkNotNullParameter(subCategory, "subCategory");
        Intrinsics.checkNotNullParameter(textFeatures, "textFeatures");
        Intrinsics.checkNotNullParameter(thresholds, "thresholds");
        this.subCategory = subCategory;
        this.textFeatures = textFeatures;
        this.thresholds = thresholds;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getSubCategory() {
        return this.subCategory;
    }

    @NotNull
    public final List<float[]> b() {
        return this.textFeatures;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final float[] getThresholds() {
        return this.thresholds;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSFeedCategoryConfig)) {
            return false;
        }
        QFSFeedCategoryConfig qFSFeedCategoryConfig = (QFSFeedCategoryConfig) other;
        if (Intrinsics.areEqual(this.subCategory, qFSFeedCategoryConfig.subCategory) && Intrinsics.areEqual(this.textFeatures, qFSFeedCategoryConfig.textFeatures) && Intrinsics.areEqual(this.thresholds, qFSFeedCategoryConfig.thresholds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.subCategory.hashCode() * 31) + this.textFeatures.hashCode()) * 31) + Arrays.hashCode(this.thresholds);
    }

    @NotNull
    public String toString() {
        return "QFSFeedCategoryConfig(subCategory=" + this.subCategory + ", textFeatures=" + this.textFeatures + ", thresholds=" + Arrays.toString(this.thresholds) + ")";
    }
}
