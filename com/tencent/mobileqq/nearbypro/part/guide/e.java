package com.tencent.mobileqq.nearbypro.part.guide;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\rj\b\u0012\u0004\u0012\u00020\u000b`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/e;", "Lcom/tencent/freesia/IConfigData;", "", "d", "", "content", "e", "", "b", "c", "", "Lcom/tencent/mobileqq/nearbypro/part/guide/a;", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mGuideItemList", UserInfo.SEX_FEMALE, "mGuideImageWidthPD", "f", "mGuideImageHeightDP", "<init>", "()V", tl.h.F, "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<GuideConfigItem> mGuideItemList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mGuideImageWidthPD = 333.5f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mGuideImageHeightDP = 333.0f;

    @NotNull
    public final List<GuideConfigItem> a() {
        return this.mGuideItemList;
    }

    /* renamed from: b, reason: from getter */
    public final float getMGuideImageHeightDP() {
        return this.mGuideImageHeightDP;
    }

    /* renamed from: c, reason: from getter */
    public final float getMGuideImageWidthPD() {
        return this.mGuideImageWidthPD;
    }

    public final void d() {
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            return;
        }
        String string = baseApplication.getString(R.string.f170282km);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ro_guide_default_title_1)");
        String string2 = baseApplication.getString(R.string.f170262kk);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_guide_default_content_1)");
        String string3 = baseApplication.getString(R.string.f170292kn);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ro_guide_default_title_2)");
        String string4 = baseApplication.getString(R.string.f170272kl);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026_guide_default_content_2)");
        this.mGuideImageWidthPD = 333.5f;
        this.mGuideImageHeightDP = 333.0f;
        ArrayList<GuideConfigItem> arrayList = this.mGuideItemList;
        arrayList.clear();
        arrayList.add(new GuideConfigItem(string, string2, "https://image.superqqshow.qq.com/qq/nearby/nearby_pro_guide_image_first_0906.png"));
        arrayList.add(new GuideConfigItem(string3, string4, "https://image.superqqshow.qq.com/qq/nearby/nearby_pro_guide_image_second_0904.png"));
    }

    public final void e(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.mGuideImageWidthPD = (float) jSONObject.optDouble("guide_image_width_dp", 333.5d);
            this.mGuideImageHeightDP = (float) jSONObject.optDouble("guide_image_height_dp", 333.0d);
            this.mGuideItemList.clear();
            JSONArray optJSONArray = jSONObject.optJSONArray("guide_content");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                if (jSONObject2 != null) {
                    String title = jSONObject2.optString("guide_title", "");
                    String desc = jSONObject2.optString("guide_desc", "");
                    String url = jSONObject2.optString("guide_image_url", "");
                    ArrayList<GuideConfigItem> arrayList = this.mGuideItemList;
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(desc, "desc");
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    arrayList.add(new GuideConfigItem(title, desc, url));
                }
            }
        } catch (JSONException e16) {
            d();
            com.tencent.mobileqq.nearbypro.base.j.c().d("NearbyProGuideConfig", "parse error! exception = " + e16.getMessage());
        }
    }
}
