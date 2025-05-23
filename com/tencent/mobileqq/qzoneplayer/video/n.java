package com.tencent.mobileqq.qzoneplayer.video;

import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    public static final Integer f280015b = 1;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Integer> f280016a = new HashMap<>();

    public void a(String str) {
        if (!this.f280016a.containsKey(str)) {
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
            if (feedVideoExternalFunc != null) {
                feedVideoExternalFunc.showToast(str);
            } else {
                PlayerUtils.log(5, "SmartToast", "SmartToast not show externalFunc is null " + str);
            }
            this.f280016a.put(str, 1);
            return;
        }
        Integer num = this.f280016a.get(str);
        int intValue = num.intValue();
        Integer num2 = f280015b;
        if (intValue < num2.intValue()) {
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc2 = FeedVideoEnv.externalFunc;
            if (feedVideoExternalFunc2 != null) {
                feedVideoExternalFunc2.showToast(str);
            } else {
                PlayerUtils.log(5, "SmartToast", "SmartToast not show externalFunc is null " + str);
            }
            this.f280016a.put(str, Integer.valueOf(num.intValue() + 1));
            return;
        }
        PlayerUtils.log(5, "SmartToast", "SmartToast not show count=" + num + ",countmax=" + num2);
    }
}
