package fa1;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements b {
    private void a(Intent intent, ColorNote colorNote) {
        byte[] reserve;
        String stringExtra = intent.getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.matches("^https?://fm\\.qzone\\.qq\\.com/.*") && (reserve = colorNote.getReserve()) != null && reserve.length > 0) {
            intent.putExtra("url", new String(reserve));
        }
    }

    @Override // fa1.b
    public int getType() {
        return R.style.Animation;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        Intent i06;
        if (colorNote != null && colorNote.getServiceType() == 16973824 && (i06 = QQPlayerService.i0()) != null) {
            a(i06, colorNote);
            i06.addFlags(268435456);
            i06.addFlags(536870912);
            i06.addFlags(67108864);
            context.startActivity(i06);
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
