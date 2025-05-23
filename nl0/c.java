package nl0;

import android.content.Intent;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface c {
    HashSet<String> getFilterCmds();

    void onCmdRsp(Intent intent, String str, long j3, JSONObject jSONObject);
}
