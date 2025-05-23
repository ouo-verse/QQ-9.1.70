package cn.wh.auth.server;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import cn.wh.auth.server.ResultRequestService;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

/* compiled from: P */
/* loaded from: classes.dex */
public class a extends ReportFragment {

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<ResultRequestService.a> f31130d = new SparseArray<>();

    public void e(Intent intent, ResultRequestService.a aVar) {
        this.f31130d.put(120, aVar);
        startActivityForResult(intent, 111);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        ResultRequestService.a aVar = this.f31130d.get(120);
        this.f31130d.remove(i3);
        if (aVar != null) {
            aVar.onActivityResult(i3, i16, intent);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
