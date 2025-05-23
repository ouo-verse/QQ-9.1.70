package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.activity.NotificationActivity;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class CNAMERecord extends SingleCompressedNameBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CNAMERecord() {
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public CNAMERecord(Name name, int i3, long j3, Name name2) {
        super(name, 5, i3, j3, name2, NotificationActivity.KEY_ALIAS);
    }
}
