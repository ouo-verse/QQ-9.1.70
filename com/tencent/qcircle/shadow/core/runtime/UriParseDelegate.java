package com.tencent.qcircle.shadow.core.runtime;

import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes22.dex */
public interface UriParseDelegate {
    Uri parse(String str);

    Uri parseCall(String str, Bundle bundle);
}
