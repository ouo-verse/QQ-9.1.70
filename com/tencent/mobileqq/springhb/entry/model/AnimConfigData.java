package com.tencent.mobileqq.springhb.entry.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\tH\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/model/AnimConfigData;", "Ljava/io/Serializable;", "()V", "mAnimConfigList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/springhb/entry/model/AnimConfig;", "Lkotlin/collections/ArrayList;", "getAnimConfig", "animKey", "", "parseJson", "", "jsonObject", "Lorg/json/JSONObject;", "toString", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class AnimConfigData implements Serializable {
    static IPatchRedirector $redirector_;

    @Nullable
    private ArrayList<AnimConfig> mAnimConfigList;

    public AnimConfigData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final AnimConfig getAnimConfig(@Nullable String animKey) {
        boolean z16;
        ArrayList<AnimConfig> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AnimConfig) iPatchRedirector.redirect((short) 3, (Object) this, (Object) animKey);
        }
        if (animKey != null && animKey.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (arrayList = this.mAnimConfigList) != null) {
            for (AnimConfig animConfig : arrayList) {
                if (TextUtils.equals(animKey, animConfig.getAnimKey())) {
                    return animConfig;
                }
            }
        }
        return null;
    }

    public final void parseJson(@Nullable JSONObject jsonObject) {
        JSONArray optJSONArray;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonObject);
            return;
        }
        if (jsonObject == null || (optJSONArray = jsonObject.optJSONArray("AnimList")) == null) {
            return;
        }
        ArrayList<AnimConfig> arrayList = new ArrayList<>(optJSONArray.length());
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String animKey = optJSONObject.optString("AnimKey");
                if (animKey != null && animKey.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    float optDouble = (float) optJSONObject.optDouble("CenterX", 0.0d);
                    float optDouble2 = (float) optJSONObject.optDouble("CenterY", 0.0d);
                    float optDouble3 = (float) optJSONObject.optDouble("WidthRatio", 0.0d);
                    float optDouble4 = (float) optJSONObject.optDouble("AspectRatio", 1.0d);
                    long optLong = optJSONObject.optLong("AnimDuration");
                    Intrinsics.checkNotNullExpressionValue(animKey, "animKey");
                    arrayList.add(new AnimConfig(animKey, optDouble, optDouble2, optDouble3, optDouble4, optLong));
                }
            }
        }
        this.mAnimConfigList = arrayList;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "AnimConfigData(mAnimConfigList=" + this.mAnimConfigList + ")";
    }
}
