package com.tencent.biz.troop.file;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.openbrowser.c;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    public String C;
    public long D;
    public long E;
    private String G;

    /* renamed from: d, reason: collision with root package name */
    Activity f96846d;

    /* renamed from: e, reason: collision with root package name */
    List<ZipFilePresenter.f> f96847e;

    /* renamed from: f, reason: collision with root package name */
    public String f96848f;

    /* renamed from: h, reason: collision with root package name */
    public String f96849h;

    /* renamed from: i, reason: collision with root package name */
    public String f96850i;

    /* renamed from: m, reason: collision with root package name */
    public String f96851m;
    private boolean F = false;
    private short H = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            int i16;
            EventCollector.getInstance().onViewClickedBefore(view);
            C0983b c0983b = (C0983b) view.getTag();
            if (c0983b.f96857e.f208516a) {
                Intent intent = new Intent(b.this.f96846d, (Class<?>) TroopFileZipPreviewActivity.class);
                intent.putExtra("str_download_dns", b.this.f96848f);
                intent.putExtra("int32_server_port", b.this.f96849h);
                intent.putExtra("string_download_url", b.this.f96850i);
                intent.putExtra("str_cookie_val", b.this.f96851m);
                intent.putExtra("filepath", b.this.C + c0983b.f96857e.f208518c);
                intent.putExtra("filename", "" + c0983b.f96857e.f208518c);
                intent.putExtra("nSessionId", b.this.E);
                intent.putExtra("isHttps", b.this.F);
                if (!TextUtils.isEmpty(b.this.G)) {
                    intent.putExtra("httpsDomain", b.this.G);
                }
                intent.putExtra("httpsPort", b.this.H);
                intent.putExtra("troop_uin", b.this.D);
                b.this.f96846d.startActivityForResult(intent, 10099);
            } else {
                ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                forwardFileInfo.E(c0983b.f96857e.f208519d);
                forwardFileInfo.y(c0983b.f96857e.f208518c);
                forwardFileInfo.z(c0983b.f96857e.f208517b);
                forwardFileInfo.Z("");
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                if (b.this.D == 0) {
                    FileManagerEntity M = qQAppInterface.getFileManagerDataCenter().M(c0983b.f96857e.f208519d);
                    FileManagerEntity m3 = qQAppInterface.getFileManagerDataCenter().m(M.zipInnerPath);
                    if (m3 == null) {
                        m3 = qQAppInterface.getFileManagerRSCenter().d((String) M.mContext, M.zipInnerPath);
                    }
                    if (m3 != null) {
                        c0983b.f96857e.f208519d = m3.nSessionId;
                        m3.isZipInnerFile = true;
                    }
                    forwardFileInfo.E(c0983b.f96857e.f208519d);
                    if (forwardFileInfo.g() == 0) {
                        d.f(HardCodeUtil.qqStr(R.string.vo5));
                    } else if (m3 != null && (i16 = m3.nFileType) != 0 && i16 != 2) {
                        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(b.this.f96846d, new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, m3), new c().d(7));
                    } else {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        for (ZipFilePresenter.f fVar : b.this.f96847e) {
                            if (FileManagerUtil.getFileType(fVar.f208518c) == 0 && fVar.f208517b != 0) {
                                FileManagerEntity M2 = qQAppInterface.getFileManagerDataCenter().M(fVar.f208519d);
                                FileManagerEntity m16 = qQAppInterface.getFileManagerDataCenter().m(M2.zipInnerPath);
                                if (m16 == null) {
                                    m16 = qQAppInterface.getFileManagerRSCenter().d((String) M2.mContext, M2.zipInnerPath);
                                }
                                if (m16 != null) {
                                    m16.mContext = M2.mContext;
                                    fVar.f208519d = m16.nSessionId;
                                }
                                arrayList.add(Long.valueOf(fVar.f208519d));
                            }
                        }
                        forwardFileInfo.F(arrayList);
                        forwardFileInfo.w(1);
                        forwardFileInfo.N(10001);
                        Intent intent2 = new Intent(b.this.f96846d, (Class<?>) FileBrowserActivity.class);
                        intent2.putExtra("fileinfo", forwardFileInfo);
                        intent2.putExtra("last_time", 0);
                        intent2.putExtra("is_in_zip", true);
                        b.this.f96846d.startActivity(intent2);
                    }
                } else {
                    ArrayList<Long> arrayList2 = new ArrayList<>();
                    for (ZipFilePresenter.f fVar2 : b.this.f96847e) {
                        if (FileManagerUtil.getFileType(fVar2.f208518c) == 0) {
                            arrayList2.add(Long.valueOf(fVar2.f208519d));
                        }
                    }
                    forwardFileInfo.F(arrayList2);
                    FileManagerEntity D = qQAppInterface.getFileManagerDataCenter().D(c0983b.f96857e.f208519d);
                    if (D != null && (i3 = D.nFileType) != 0 && i3 != 2) {
                        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(b.this.f96846d, new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, D, 2), new c().d(7));
                    } else {
                        forwardFileInfo.w(4);
                        forwardFileInfo.N(10000);
                        Intent intent3 = new Intent(b.this.f96846d, (Class<?>) TroopFileDetailBrowserActivity.class);
                        intent3.putExtra("fileinfo", forwardFileInfo);
                        intent3.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
                        intent3.putExtra("not_forward", true);
                        intent3.putExtra("last_time", 0);
                        intent3.putExtra("is_in_zip", true);
                        b.this.f96846d.startActivity(intent3);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.troop.file.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0983b {

        /* renamed from: a, reason: collision with root package name */
        public AsyncImageView f96853a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f96854b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f96855c;

        /* renamed from: d, reason: collision with root package name */
        public View f96856d;

        /* renamed from: e, reason: collision with root package name */
        public ZipFilePresenter.f f96857e;
    }

    public b(List<ZipFilePresenter.f> list, Activity activity) {
        this.f96847e = list;
        this.f96846d = activity;
    }

    public void d(List<ZipFilePresenter.f> list) {
        this.f96847e = list;
    }

    public void e(boolean z16, String str, short s16) {
        this.F = z16;
        this.G = str;
        this.H = s16;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f96847e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f96846d).inflate(R.layout.amw, (ViewGroup) null);
            C0983b c0983b = new C0983b();
            c0983b.f96853a = (AsyncImageView) view.findViewById(R.id.c_u);
            c0983b.f96854b = (TextView) view.findViewById(R.id.c_x);
            c0983b.f96855c = (TextView) view.findViewById(R.id.f165204ca0);
            c0983b.f96856d = view.findViewById(R.id.i_l);
            view.setTag(c0983b);
            view.setOnClickListener(new a());
        }
        C0983b c0983b2 = (C0983b) view.getTag();
        ZipFilePresenter.f fVar = this.f96847e.get(i3);
        if (fVar.f208516a) {
            c0983b2.f96855c.setText(HardCodeUtil.qqStr(R.string.vo6));
            c0983b2.f96854b.setText(FileManagerUtil.cutLongName(fVar.f208518c));
            c0983b2.f96853a.setImageResource(R.drawable.e9e);
            c0983b2.f96856d.setVisibility(0);
        } else {
            c0983b2.f96855c.setText(q.g(fVar.f208517b));
            c0983b2.f96854b.setText(FileManagerUtil.cutLongName(fVar.f208518c));
            FileManagerUtil.setFileIcon(c0983b2.f96853a, fVar.f208518c);
            c0983b2.f96856d.setVisibility(8);
            if (FileManagerUtil.getFileType(fVar.f208518c) == 0) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                FileManagerEntity M = qQAppInterface.getFileManagerDataCenter().M(fVar.f208519d);
                if (M != null) {
                    M.isZipInnerFile = true;
                    FileManagerUtil.setZipImageFileIcon(c0983b2.f96853a, M);
                    qQAppInterface.getFileManagerEngine().q(M);
                } else {
                    FileManagerUtil.setFileIcon(c0983b2.f96853a, fVar.f208518c);
                }
            }
        }
        c0983b2.f96857e = fVar;
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
