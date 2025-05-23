package nl0;

import android.content.Intent;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface h {
    HashSet<String> getFilterCmds();

    void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj);
}
