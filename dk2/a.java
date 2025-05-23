package dk2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.view.RoundProgressBar;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends ReportDialog {
    private final RoundProgressBar C;
    private final TextView D;
    private final TextView E;
    private int F;

    public a(@NonNull Context context, int i3) {
        super(context, R.style.f173523f9);
        this.F = i3;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.h1w);
        this.C = (RoundProgressBar) findViewById(R.id.f165958dx0);
        this.D = (TextView) findViewById(R.id.f167033k60);
        this.E = (TextView) findViewById(R.id.f28490j3);
    }

    private void N() {
        VideoReport.addToDetectionWhitelist(getOwnerActivity());
        VideoReport.setPageId(this, "pg_video_process_window");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("type_aio_pg", Integer.valueOf(this.F));
        VideoReport.setPageParams(this, new PageParams(hashMap));
    }

    public void O(View.OnClickListener onClickListener) {
        this.D.setOnClickListener(onClickListener);
    }

    public void P(@StringRes int i3) {
        this.E.setText(i3);
    }

    public void Q(int i3) {
        this.C.setProgress(i3);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N();
    }
}
