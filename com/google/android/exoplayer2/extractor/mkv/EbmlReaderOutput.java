package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
interface EbmlReaderOutput {
    void binaryElement(int i3, int i16, ExtractorInput extractorInput) throws IOException, InterruptedException;

    void endMasterElement(int i3) throws ParserException;

    void floatElement(int i3, double d16) throws ParserException;

    int getElementType(int i3);

    void integerElement(int i3, long j3) throws ParserException;

    boolean isLevel1Element(int i3);

    void startMasterElement(int i3, long j3, long j16) throws ParserException;

    void stringElement(int i3, String str) throws ParserException;
}
