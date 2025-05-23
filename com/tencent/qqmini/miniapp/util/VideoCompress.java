package com.tencent.qqmini.miniapp.util;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VideoCompress {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Listener {
        void onFailure(String str);

        void onFinish(boolean z16);

        void onProgress(String str, float f16);

        void onStart();

        void onSuccess(String str);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Option {
        public int crf;
        public int scale;
        public TargetEncoding targetEncoding;
        public int targetFrameRate;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum TargetEncoding {
        x264
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class X264EncodingOption {
        String preset;
        String profile;
    }
}
