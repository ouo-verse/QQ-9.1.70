package com.tencent.opentelemetry.api.baggage;

import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface BaggageEntry {
    BaggageEntryMetadata getMetadata();

    String getValue();
}
