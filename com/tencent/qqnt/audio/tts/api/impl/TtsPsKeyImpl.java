package com.tencent.qqnt.audio.tts.api.impl;

import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.qqnt.audio.tts.api.ITtsPsKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/audio/tts/api/impl/TtsPsKeyImpl;", "Lcom/tencent/qqnt/audio/tts/api/ITtsPsKey;", "", "getPsKeySync", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TtsPsKeyImpl implements ITtsPsKey {
    public static final String TAG = "TtsPsKey";
    public static final String TTS_DOMAIN = "textts.qq.com";

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/audio/tts/api/impl/TtsPsKeyImpl$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f352569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f352570b;

        b(CountDownLatch countDownLatch, ArrayList<String> arrayList) {
            this.f352569a = countDownLatch;
            this.f352570b = arrayList;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f352569a.countDown();
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str = domainToKeyMap.get(TtsPsKeyImpl.TTS_DOMAIN);
            if (str != null) {
                this.f352570b.add(str);
            }
            this.f352569a.countDown();
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsPsKey
    public String getPsKeySync() {
        Object firstOrNull;
        ArrayList arrayList = new ArrayList();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ((IPskeyManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{TTS_DOMAIN}, new b(countDownLatch, arrayList));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        return (String) firstOrNull;
    }
}
