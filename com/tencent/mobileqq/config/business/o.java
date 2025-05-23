package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"", "", "a", "emotionpanel_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o {
    @Nullable
    public static final List<Integer> a() {
        String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("fav_face_lottie_emj", "");
        if (QLog.isColorLevel()) {
            QLog.d("FavLottieEmoticonConfig", 1, "[getLottieEmoticonDataList] configStr=" + loadConfigAsString);
        }
        if (!TextUtils.isEmpty(loadConfigAsString)) {
            try {
                JSONArray optJSONArray = new JSONObject(loadConfigAsString).optJSONArray("lottieEmoticon");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = optJSONArray.optJSONObject(i3).optString("QSid");
                        Intrinsics.checkNotNullExpressionValue(optString, "lottieEmojiObj.optString(\"QSid\")");
                        arrayList.add(Integer.valueOf(Integer.parseInt(optString)));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("FavLottieEmoticonConfig", 1, "[getLottieEmoticonDataList] resultList=" + arrayList);
                    }
                    return arrayList;
                }
                return null;
            } catch (Throwable th5) {
                QLog.e("FavLottieEmoticonConfig", 1, "[getLottieEmoticonDataList] error! ", th5);
                return null;
            }
        }
        return null;
    }
}
