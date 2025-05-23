package com.tencent.tav.decoder.extractor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FfmpegExtractorCreator implements IExtractorCreator {
    public static final String TAG = "FfmpegExtractorCreator";

    @Override // com.tencent.tav.decoder.extractor.IExtractorCreator
    public IExtractor createExtractor() {
        return new FfmpegExtractor();
    }
}
