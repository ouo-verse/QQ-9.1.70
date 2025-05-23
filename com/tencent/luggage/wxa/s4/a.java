package com.tencent.luggage.wxa.s4;

import com.tencent.luggage.wxa.ei.n;
import com.tencent.mm.libwxaudio.WxAudioNative;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f140067a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6703a implements WxAudioNative.NativeCallBackInterface {

        /* renamed from: a, reason: collision with root package name */
        public WxAudioNative.NativeCallBackInterface f140068a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.s4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6704a implements n.a {
            public C6704a() {
            }

            @Override // com.tencent.luggage.wxa.ei.n.a
            public final void onDestroy() {
                C6703a.this.f140068a = null;
            }
        }

        public C6703a(WxAudioNative.NativeCallBackInterface nativeCallBackInterface, n lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.f140068a = nativeCallBackInterface;
            lifecycleOwner.b(new C6704a());
        }

        @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface
        public String getFilePath(String str) {
            String str2;
            WxAudioNative.NativeCallBackInterface nativeCallBackInterface = this.f140068a;
            if (nativeCallBackInterface != null) {
                str2 = nativeCallBackInterface.getFilePath(str);
            } else {
                str2 = null;
            }
            if (str2 == null) {
                if (str == null) {
                    return "";
                }
                return str;
            }
            return str2;
        }

        @Override // com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface
        public void onCallBack(long j3, String str) {
            WxAudioNative.NativeCallBackInterface nativeCallBackInterface = this.f140068a;
            if (nativeCallBackInterface != null) {
                nativeCallBackInterface.onCallBack(j3, str);
            }
        }
    }

    public static final WxAudioNative.NativeCallBackInterface a(WxAudioNative.NativeCallBackInterface nativeCallBackInterface, n lifecycleOwner) {
        Intrinsics.checkNotNullParameter(nativeCallBackInterface, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        return new C6703a(nativeCallBackInterface, lifecycleOwner);
    }
}
