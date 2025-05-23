package fc1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.filemanager.widget.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends e {

    /* renamed from: g, reason: collision with root package name */
    private int f398266g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f398267h;

    /* renamed from: i, reason: collision with root package name */
    private String f398268i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f398269j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f398270k;

    /* renamed from: l, reason: collision with root package name */
    private View.OnClickListener f398271l;

    public b(QQAppInterface qQAppInterface, Context context, QFileSendBottomView qFileSendBottomView) {
        super(qQAppInterface, context, qFileSendBottomView);
        this.f398271l = new a();
        l();
    }

    private void l() {
        this.f398269j = (TextView) this.f209538c.b(R.id.imy);
        this.f398270k = (TextView) this.f209538c.b(R.id.fa_);
        this.f398269j.setOnClickListener(this.f398271l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Bundle bundle = this.f209539d;
        if (bundle != null && bundle.containsKey("qfile_search_param_exparams_qlink_state")) {
            String str = this.f398268i;
            Set<FileInfo> localFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles();
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FileInfo> it = localFiles.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().k());
            }
            int i3 = this.f209539d.getInt("qfile_search_param_exparams_qlink_state");
            Intent intent = new Intent();
            if (222 == i3) {
                intent.putExtra("string_filepaths", arrayList);
            } else {
                if (333 != i3 && 666 != i3 && 3333 != i3 && 6666 != i3) {
                    boolean z16 = true;
                    if (444 != i3 && 555 != i3) {
                        if (777 != i3 && 888 != i3) {
                            this.f209537b.getQQProxyForQlink().H(str, arrayList);
                            intent.putExtra("_UIN_", str);
                            intent.putExtra("_SEND_QLINK_FILE_", true);
                        } else {
                            Bundle bundle2 = new Bundle();
                            bundle2.putStringArrayList("string_filepaths", arrayList);
                            this.f209537b.getQQProxyForQlink();
                            QQProxyForQlink.P(this.f209536a, 16, bundle2);
                        }
                    } else {
                        if (444 != i3) {
                            z16 = false;
                        }
                        intent.putExtra("_INIT_SEND_IOS_", z16);
                        intent.putExtra("string_filepaths", arrayList);
                    }
                } else {
                    intent.putExtra("string_filepaths", arrayList);
                }
                b(i3, intent);
                return;
            }
            i3 = -1;
            b(i3, intent);
            return;
        }
        c(null);
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.f209540e) {
            this.f398268i = this.f209539d.getString("qfile_search_param_ex_params_target_uin");
            this.f398266g = this.f209539d.getInt("qfile_search_param_exparams_qlink_state");
            this.f398267h = this.f209539d.getBoolean("qfile_search_param_exparams_qlink_ap_created");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void f() {
        boolean z16;
        this.f398270k.setText(R.string.f4i);
        this.f398269j.setText(HardCodeUtil.qqStr(R.string.ket));
        TextView textView = this.f398269j;
        if (((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        textView.setEnabled(z16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (((e) b.this).f209540e) {
                ReportController.o(null, "dc00898", "", "", "0X800AA92", "0X800AA92", 4, 0, "" + ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount(), "0", "", "");
                if (1 != b.this.f398266g || b.this.f398267h) {
                    b.this.m();
                } else {
                    FMDialogUtil.a(((e) b.this).f209536a, R.string.f171471f53, R.string.f171470f52, new C10301a());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: fc1.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C10301a implements FMDialogUtil.c {
            C10301a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                b.this.m();
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}
