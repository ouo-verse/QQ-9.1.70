package fc1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.filemanager.widget.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends e {

    /* renamed from: g, reason: collision with root package name */
    private TextView f398261g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f398262h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f398263i;

    public a(QQAppInterface qQAppInterface, Context context, QFileSendBottomView qFileSendBottomView) {
        super(qQAppInterface, context, qFileSendBottomView);
        this.f398263i = new ViewOnClickListenerC10299a();
        j();
    }

    private void j() {
        this.f398261g = (TextView) this.f209538c.b(R.id.imy);
        this.f398262h = (TextView) this.f209538c.b(R.id.fa_);
        this.f398261g.setOnClickListener(this.f398263i);
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void f() {
        String str;
        boolean z16;
        String str2 = this.f209536a.getString(R.string.b5n) + this.f209536a.getString(R.string.b_3) + ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount() + this.f209536a.getString(R.string.b_4);
        long selectedFileSize = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedFileSize();
        if (selectedFileSize > 0) {
            str = this.f209536a.getString(R.string.f170943b71) + q.g(selectedFileSize);
        } else {
            str = "";
        }
        this.f398261g.setText(str2);
        TextView textView = this.f398261g;
        if (((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        textView.setEnabled(z16);
        this.f398262h.setText(str);
    }

    /* compiled from: P */
    /* renamed from: fc1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewOnClickListenerC10299a implements View.OnClickListener {
        ViewOnClickListenerC10299a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (((e) a.this).f209540e) {
                if (FileManagerUtil.is2GOr3G() && ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedLocalFileSize() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
                    FMDialogUtil.a(BaseActivity.sTopActivity, R.string.b_v, R.string.f170958ba0, new C10300a());
                } else {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    arrayList.addAll(((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra("sFilesSelected", arrayList);
                    a.this.c(intent);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: fc1.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C10300a implements FMDialogUtil.c {
            C10300a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.addAll(((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("sFilesSelected", arrayList);
                a.this.c(intent);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}
