package com.tencent.shadow.core.runtime;

import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes25.dex */
public interface UriParseDelegate {
    Uri parse(String str);

    Uri parseCall(String str, Bundle bundle);
}
