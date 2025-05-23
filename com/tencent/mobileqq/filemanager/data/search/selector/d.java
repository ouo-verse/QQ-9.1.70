package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ap;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends a {
    private List<FileInfo> J;
    private CharSequence K;
    private CharSequence L;

    public d(String str, int i3) {
        super(str, i3);
        this.J = new ArrayList();
    }

    private String Q(FileInfo fileInfo) {
        return ap.a(fileInfo.e()) + "  " + q.g(fileInfo.l());
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public boolean G() {
        FileInfo fileInfo = this.J.get(0);
        if (fileInfo == null) {
            return false;
        }
        return ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).isSelected(fileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public List<y> H(QQAppInterface qQAppInterface, Context context) {
        ArrayList arrayList = new ArrayList();
        for (FileInfo fileInfo : this.J) {
            d dVar = new d(this.H, this.G);
            dVar.P(this.I);
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(fileInfo);
            dVar.R(arrayList2);
            arrayList.add(dVar);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public String I() {
        FileInfo fileInfo = this.J.get(0);
        if (fileInfo != null) {
            return fileInfo.j();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public String J() {
        FileInfo fileInfo = this.J.get(0);
        if (fileInfo != null) {
            int fileType = FileManagerUtil.getFileType(fileInfo.k());
            if (fileType == 0 || fileType == 2 || fileType == 5) {
                return fileInfo.k();
            }
            return "";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public int K() {
        FileInfo fileInfo = this.J.get(0);
        if (fileInfo != null) {
            return FileManagerUtil.getFileType(fileInfo.k());
        }
        return 11;
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    public int L() {
        return this.J.size();
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    protected void M(View view) {
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        FileSelectorSearchGroupFragment.rh(this);
        Intent intent = new Intent();
        intent.putExtra("qfile_search_param_ex_params", this.I);
        PublicFragmentActivity.startForResult(qBaseActivity, intent, FileSelectorSearchGroupFragment.class, 9999);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    protected void N(View view) {
        FileInfo fileInfo = this.J.get(0);
        QBaseActivity qBaseActivity = (QBaseActivity) view.getContext();
        FileManagerEntity newEntityByLocalFileInfo = FileManagerUtil.newEntityByLocalFileInfo(fileInfo);
        int i3 = newEntityByLocalFileInfo.nFileType;
        if (i3 != 0 && i3 != 2) {
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(qBaseActivity, new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) qBaseActivity.getAppRuntime(), newEntityByLocalFileInfo), new com.tencent.mobileqq.filemanager.openbrowser.c().d(8));
        } else {
            dc1.d dVar = new dc1.d(qBaseActivity, new dc1.b((QQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, newEntityByLocalFileInfo, 10000));
            dVar.m(8);
            dVar.d();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.selector.a
    protected void O(View view) {
        FileInfo fileInfo = this.J.get(0);
        if (((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).isSelected(fileInfo)) {
            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).removeSelected(fileInfo);
        } else {
            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).addSelected(fileInfo);
            ReportController.o(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 2, 0, "0", "0", "", "");
        }
        if (!q.f(fileInfo.k())) {
            com.tencent.mobileqq.filemanager.util.d.f(FileManagerUtil.cutLongName(fileInfo.j()) + HardCodeUtil.qqStr(R.string.q9l));
            ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).removeSelected(fileInfo);
        }
    }

    public void R(List<FileInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.J.addAll(list);
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        if (this.K == null) {
            if (this.J.size() == 1) {
                this.J.get(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(o());
                this.K = spannableStringBuilder;
            } else {
                this.K = o();
            }
        }
        return this.K;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        CharSequence charSequence = this.L;
        if (charSequence != null) {
            return charSequence;
        }
        int size = this.J.size();
        if (size > 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(size + HardCodeUtil.qqStr(R.string.mib) + "\"");
            String str = this.H;
            spannableStringBuilder.append(SearchUtils.C(str, str));
            spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) HardCodeUtil.qqStr(R.string.w0c));
            this.L = spannableStringBuilder;
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(SearchUtils.C(Q(this.J.get(0)), this.H));
        if (this.L == null) {
            this.L = spannableStringBuilder2;
        }
        return this.L;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return SearchUtils.C(this.J.get(0).j().toLowerCase(), this.H);
    }
}
