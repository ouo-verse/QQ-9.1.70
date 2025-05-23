package com.tencent.tav.extractor;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExtractorDelegateFactory {
    private static IExtractorDelegateCreator extractorDelegateCreator = new IExtractorDelegateCreator() { // from class: com.tencent.tav.extractor.ExtractorDelegateFactory.1
        @Override // com.tencent.tav.extractor.ExtractorDelegateFactory.IExtractorDelegateCreator
        public IExtractorDelegate createExtractorDelegate() {
            return new ApiExtractorDelegate();
        }
    };

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IExtractorDelegateCreator {
        IExtractorDelegate createExtractorDelegate();
    }

    public static IExtractorDelegate createDelegate() {
        return extractorDelegateCreator.createExtractorDelegate();
    }

    public static void setExtractorDelegateCreator(@NonNull IExtractorDelegateCreator iExtractorDelegateCreator) {
        extractorDelegateCreator = iExtractorDelegateCreator;
    }
}
