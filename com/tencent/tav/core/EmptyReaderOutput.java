package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EmptyReaderOutput extends AssetReaderOutput {
    @Override // com.tencent.tav.core.AssetReaderOutput
    @NonNull
    public CMSampleBuffer nextSampleBuffer() {
        return new CMSampleBuffer(CMSampleState.fromError(-1L));
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void markConfigurationAsFinal() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void preDecode() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void release() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void stopPreDecode() {
    }

    @Override // com.tencent.tav.core.AssetReaderOutput
    public void resetForReadingTimeRanges(List<CMTimeRange> list) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.tav.core.AssetReaderOutput
    public void start(@Nullable IContextCreate iContextCreate, AssetReader assetReader) {
    }
}
